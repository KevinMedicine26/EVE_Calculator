import java.util.HashMap;
import java.util.Map;

public class Ore {
    private String name;
    private Map<Product, Double> yields; // 每种产物及其对应的数量

    public Ore(String name) {
        this.name = name;
        this.yields = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addProductYield(Product product, double quantity) {
        yields.put(product, quantity);
    }

    public double calculateValue(Map<String, Double> marketPrices) {
        double value = 0.0;
        for (Map.Entry<Product, Double> entry : yields.entrySet()) {
            double productPrice = marketPrices.getOrDefault(entry.getKey().getName(), 0.0);
            value += entry.getValue() * productPrice; // 产物数量 * 市场价格
        }
        return value;
    }

    // 为了在EVE_Miner_Calculator类中遍历yields，我们需要一个方法来获取它
    public Map<Product, Double> getYields() {
        return yields;
    }
}
