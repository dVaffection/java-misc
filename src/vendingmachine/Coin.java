package vendingmachine;

public enum Coin implements Comparable<Coin> {

    PENNY(0.01f),
    NICKEL(0.05f),
    DIME(0.10f),
    QUARTER(0.20f),
    HALF(0.50f),
    LOONIE(1),
    TOONIE(2);

    private float value;

    Coin(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }



}
