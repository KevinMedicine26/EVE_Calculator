import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EVE_Miner_Calculator {

    public static void main(String[] args) {
        // 创建产品实例
        Product heavyWater = new Product("重水");
        Product liquidOzone = new Product("液化臭氧");
        Product strontiumClathrate = new Product("锶包合物");

        // 创建“黑闪冰Dark Glitter”矿石实例
        Ore darkGlitter = new Ore("黑闪冰Dark Glitter");
        // 添加产物到“黑闪冰Dark Glitter”
        darkGlitter.addProductYield(heavyWater, 691.0);
        darkGlitter.addProductYield(liquidOzone, 1381.0);
        darkGlitter.addProductYield(strontiumClathrate, 69.0);

        // 创建“加里多斯冰Gelidus”矿石实例
        Ore gelidus = new Ore("加里多斯冰Gelidus");
        // 添加产物到“加里多斯冰Gelidus”
        gelidus.addProductYield(heavyWater, 345.0);
        gelidus.addProductYield(liquidOzone, 691.0);
        gelidus.addProductYield(strontiumClathrate, 104.0);

        // 用户输入部分
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> marketPrices = new HashMap<>();

        // 收集市场价格
        System.out.println("请输入重水的当前市场价格:");
        marketPrices.put(heavyWater.getName(), scanner.nextDouble());

        System.out.println("请输入液化臭氧的当前市场价格:");
        marketPrices.put(liquidOzone.getName(), scanner.nextDouble());

        System.out.println("请输入锶包合物的当前市场价格:");
        marketPrices.put(strontiumClathrate.getName(), scanner.nextDouble());

        // 计算矿石价值
        double darkGlitterValue = darkGlitter.calculateValue(marketPrices);
        double gelidusValue = gelidus.calculateValue(marketPrices);

        System.out.println("黑闪冰Dark Glitter的价值是: " + darkGlitterValue);
        System.out.println("加里多斯冰Gelidus的价值是: " + gelidusValue);

        scanner.close();
    }
}
