import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Vendingmachine {

        public static void main(String[] args) {

            Double balenceAmount = 100.00;
          // Item name as Key and Price as value
            Map<String, Double> itemsMap = vendingMachineItemsAndPricingInfo();
            List<String> transactionList = new ArrayList<>();
            System.out.println("Welcome to vending Machine!!!\n Here are list of available items and Prices in rupees .. ");
            System.out.println(" Initial Balence in vending Machine : " + balenceAmount);
            System.out.println(" ITEM NAME : ITEM PRICE ");
            System.out.println(" ======================== ");
         // Iterating map to show the available items
            Set<Entry<String, Double>> entrySet = itemsMap.entrySet();
            for (Entry<String, Double> entry : entrySet) {
                System.out.println(entry.getKey() + " : " + entry.getValue());

            }

            System.out.println("Please select Item ");
            transactionList.add("Please select Item ");
            Scanner sc = new Scanner(System.in);
            String itemName = sc.next();
            balenceAmount = vendingMachineProcessor(balenceAmount, itemsMap, transactionList, sc, itemName);
            System.out.println("Final Balence amount in Wending Machine : " + balenceAmount);
            sc.close();

        }

        private static Map<String, Double> vendingMachineItemsAndPricingInfo() {
            Map<String, Double> itemsMap = new HashMap<>();
            itemsMap.put("Coke", 20.0);
            itemsMap.put("Lays", 10.0);
            itemsMap.put("Sprite", 20.0);
            itemsMap.put("Marinda", 15.0);
            return itemsMap;
        }

        private static Double vendingMachineProcessor(Double balenceAmount, Map<String, Double> itemsMap,
                                                      List<String> transactionList, Scanner sc, String itemName) {
            do {
                Calendar calendar = Calendar.getInstance();
                double balenceToReturn;
                if (itemsMap.containsKey(itemName.trim())) {
                    Double itemPrice = itemsMap.get(itemName.trim());
                    System.out.println("Item Price : " + itemPrice);
                    transactionList.add("Item Price : " + itemPrice);
                    System.out.println("Please deposit the amount");
                    transactionList.add("Please deposit the amount");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > itemPrice) {
                        balenceToReturn = depositAmount - itemPrice;
                        balenceAmount = balenceAmount + itemPrice;
                        System.out.println("Please collect the Balence Amount " + balenceToReturn);
                        transactionList.add("Please collect the Balence Amount " + balenceToReturn);
                    }
                    transactionList.add("Transaction Time : " + calendar.getTime());
                    System.out.println(
                            "Do you want to buy another item ?\n YES - Enter item Name or Enter 1 for exit\n 2 - Previous transactions details ");
                    itemName = sc.next();
                } else if ("2".equals(itemName)) {
                    printPreviousTransactions(transactionList);
                    System.out.println(
                            "Do you want to buy another item ?\n YES - Enter Name of item.\nEnter 1 for exit\n Enter 2 for previous transactions details ");
                    itemName = sc.next();
                } else {
                    System.out.println("Please Enter only available items");
                }
            } while (!"1".equals(itemName));
            return balenceAmount;
        }

        public static void printPreviousTransactions(List<String> transactionList) {
            for (String eachDetail : transactionList) {
                System.out.println(eachDetail);
            }

        }

    }



