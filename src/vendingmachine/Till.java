package vendingmachine;

import java.util.*;

class Till {

    /**
     * Charge given price accepting coins
     *
     * @param coins
     * @param price
     * @return change in coins
     * @throws TillException if not enough coins given
     */
    public Collection<Coin> charge(Collection<Coin> coins, float price) throws TillException {
        if (price < 1) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        float amount = 0f;
        float change = 0f;
        Collection<Coin> changeCoins;

        for (Coin coin : coins) {
            amount += coin.getValue();
        }

        if (amount < price) {
            throw new TillException("Not enough amount given");
        }

        change = amount - price;
        if (change > 0) {
            changeCoins = breakIntoCoins(change);
        } else {
            changeCoins = new ArrayList<>();
        }


        return changeCoins;
    }

    /**
     * Break given amount into coins
     *
     * @param amount
     * @return coins
     */
    public Collection<Coin> breakIntoCoins(float amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive value");
        }

        Collection<Coin> coins = new ArrayList<>();
        List<Coin> coinTypes = Arrays.asList(Coin.values());

        Collections.sort(coinTypes);
        Collections.reverse(coinTypes);

        while (amount > 0) {
            for (Coin coin : coinTypes) {
                if (0 == amount % coin.getValue()) {
                    coins.add(coin);
                    amount = -coin.getValue();
                    break;
                }
            }
        }

        return coins;
    }

}
