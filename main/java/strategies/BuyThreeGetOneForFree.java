package strategies;

import shop.ShoppingCartItem;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BuyThreeGetOneForFree implements Discount {

    @Override
    public BigDecimal discount(ArrayList<ShoppingCartItem> cartItems) {
        var sum = BigDecimal.ZERO;
        int quantity = 0;
        BigDecimal cheapestItem = cartItems.get(0).itemCost();

        for (var item: cartItems) {
            System.out.println(item.product());
            for (int i = 0; i < item.quantity(); i++) {
                quantity++;
                // sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
                sum = item.itemCost().add(sum);

                if (item.itemCost().intValue() < cheapestItem.intValue()) {
                    cheapestItem = item.itemCost();
                }
            }
        }
        if (quantity > 2) {
            sum = sum.subtract(cheapestItem);
        }
        System.out.println(cheapestItem);
        return sum;
    }
}