import java.util.ArrayList;

// A Purse holds a collection of Coins
public class Purse {
    private ArrayList<Coin> coins;

    public Purse() {
        coins = new ArrayList();
    }

    public void add(Coin aCoin) {
        coins.add(aCoin);
    }

    public double getTotal() {
        double sum = 0;
        for(Coin coin : coins) sum += coin.getValue();
        return sum;
    }

    public int count(Coin aCoin) {
        int count = 0;
        for(Coin coin : coins) {
            if(coin.equals(aCoin)) count++;
        }
        return count;
    }

    public String findSmallest() {
        Coin smallestCoin = coins.get(0);
        for(Coin coin : coins) {
            if(coin.getValue() < smallestCoin.getValue()) smallestCoin = coin;
        }
        return smallestCoin.getName();
    }
}
