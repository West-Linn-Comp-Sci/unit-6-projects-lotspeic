// A Coin represents a real world coin such as a "quarter" which
// has a value of 0.25, a "half dollar" which has value of 0.50, etc.
// A class invariant holds that 0.00 < all coin values <= 1.00
public class Coin {

    private double myValue;
    private String myName;

    public Coin(double value, String name) {
        myValue = value;
        myName = name;
    }

    public double getValue() {
        return myValue;
    }

    public String getName() {
        return myName;
    }

    public boolean equals(Coin aCoin) {
        return aCoin.getName().equals(myName) && aCoin.getValue() == myValue;
    }
}
