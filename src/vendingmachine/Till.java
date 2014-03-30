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
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        float amount = 0f;
        float change;
        Collection<Coin> changeCoins;

        for (Coin coin : coins) {
            amount += coin.getValue();
        }

        if (amount < price) {
            throw new TillException("Not enough credit");
        }

        change = round(amount - price);
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
     * @param amount to break
     * @return coins
     */
    public Collection<Coin> breakIntoCoins(float amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive value");
        }

        Collection<Coin> coins = new ArrayList<>();
        List<Coin> coinTypes = Arrays.asList(Coin.values());

        // values in Coin enum are sorted according to the ordinal position
        Collections.sort(coinTypes);
        Collections.reverse(coinTypes);

        float diff;
        while (amount > 0) {
            for (Coin coin : coinTypes) {
                diff = round(amount - coin.getValue());
                if (diff >= 0) {
                    coins.add(coin);
                    amount = diff;
                    break;
                }
            }
        }

        return coins;
    }

    /**
     * For some reason Math.round has no decimal points
     */
    private float round(float number) {
        return Math.round(number * 100.0f) / 100.0f;
    }

}
