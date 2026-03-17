import java.util.*;

public class FlashSaleInventory {
    private HashMap<String, Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String id, int count) {
        stock.put(id, count);
        waiting.put(id, new LinkedList<>());
    }

    public synchronized String purchaseItem(String id, int userId) {
        int s = stock.getOrDefault(id, 0);
        if (s > 0) {
            stock.put(id, s - 1);
            return "Success";
        } else {
            Queue<Integer> q = waiting.get(id);
            q.add(userId);
            return "Waiting position " + q.size();
        }
    }

    public int checkStock(String id) {
        return stock.getOrDefault(id, 0);
    }
}