import Command.CommandManager;
import shop.Product;
import shop.ShoppingCart;
import shop.ShoppingCartItem;
import strategies.*;

public class main {

    public static void main(String[] args) {
        CommandManager manager = new CommandManager();
        ShoppingCart shoppingCart = new ShoppingCart(manager);

        ShoppingCartItem item1 = new ShoppingCartItem(new Product("shoes"), 50, 1, manager);
        ShoppingCartItem item2 = new ShoppingCartItem(new Product("shirt"), 100, 3, manager);
        ShoppingCartItem item3 = new ShoppingCartItem(new Product("pullover"), 150, 1, manager);
        ShoppingCartItem item4 = new ShoppingCartItem(new Product("underwear"), 30, 1, manager);
        ShoppingCartItem item5 = new ShoppingCartItem(new Product("socks"), 20, 1, manager);


        shoppingCart.addCartItem(item1);
        shoppingCart.addCartItem(item2);
        shoppingCart.addCartItem(item3);
        shoppingCart.addCartItem(item4);
        shoppingCart.addCartItem(item5);


        shoppingCart.addDiscount(new BuyMoreGetOneForFree());
        shoppingCart.addDiscount(new BuyThreeGetOneForFree());
        shoppingCart.addDiscount(new BuyMoreGetTenPercent());


        System.out.println(shoppingCart.receipt());

        shoppingCart.removeCartItem(item1);
        System.out.println("\n\n remove/undo/redo demonstration");
        System.out.println("\nnumber of items after item removed = " + shoppingCart.getItems().size());
        shoppingCart.undo();
        System.out.println("number of items after undo = " + shoppingCart.getItems().size());
        shoppingCart.redo();
        System.out.println("number of items after redo = " + shoppingCart.getItems().size());

    }
}