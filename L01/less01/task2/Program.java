package org.dav.less01.task2;

import java.util.Scanner;

/*
Техническое задание на разработку информационной системы UMarket.

Вам доверено спроектировать и реализовать классы предметной области,
которые позволяют в дальнейшем вести разработку ИС со след.функционалом:

1. Осуществлять учет продовольственных товаров, которыми торгует UMarket
2. Предоставлять покупателям возможность фильтрации продовольственных товароы по след.видам:
- Снеки
- Полуфабрикаты
- Продукты для приготовления
- Все продавольственные товары
3. Формировать онлайн корзину из продовольственных товаров
4. Осуществлять балансировку онлайн корзины с целью получения такого
    набора продуктов питания, который включает все основные питательные элементы

    Особенности бизнес-логики сервисов UMarket.

    Можуль онлайн покупок должен осуществлять контроль за попадающими в покупательскую
    корзину продуктами, а именно:
    - в онлайн конзину можно добавить только продовольственные товары
    - в зависимости от желания покупателя в онлайн корзине могут находиться как все
    присутствующие  в UMarket продовольственные товары, так и исключиельно товары той
    категории, которую выбрал покупатель посредством настроек фильтрации (фильтрация
    по видам продовольственных товаров)

    Необходимо предусмотреть типобезопасность онлайн корзины, т.к. в момент "автоматической
    балансировки" она должна пополняться продовольственными товарами из списка товаров
    UMarket. Необходимо учесть, что в случае формирования онлайн корзины конкретного
    вида продовольственных товаров, дополнять корзину необходимо товарами именно из
    выбранной покупателем категории продовольственных товаров.

    С целью упрощения алгоритма балансировки онлайн корзины, будем считать, что каждый
    продовольственный продукт содержит всего лишь один питательный элемент (boolean):
    белки / жиры / углеводы. Следовательно, есть вероятность, что все выбранные товары
    будут представителями одного и того же питательного элемента (например, уллеводными).
    В свою очередь, балансировка делает так, чтобы в корзине бали представлены
    все питательные элементы.
 */
public class Program {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UMarket market = new UMarket();
        System.out.println("Welcome to the market U-Market!!!");

        while (true){
            System.out.println("===========================================");
            System.out.println("0 - End of app work");
            System.out.println("1 - Show full list of products");
            System.out.println("2 - Create an online shopping cart from snacks");
            System.out.println("3 - Create an online shopping cart from semi-finished products");
            System.out.println("4 - Create an online shopping cart from products for cooking");
            System.out.println("5 - Create an online shopping cart from from any food products");
            System.out.println("Select menu item: ");

            if (scanner.hasNextInt()){
                int no = scanner.nextInt();
                scanner.nextLine();
                switch (no){
                    case 0 -> {
                        System.out.println("End of app work");
                        return;
                    }
                    case 1 -> {
                        System.out.println("List of products: ");
                        market.printThings(Thing.class);
                    }
                    case 2 -> createCart(Snack.class, market);
                    case 3 -> createCart(SemiFinishedFood.class, market);
                    case 4 -> createCart(HealtyFood.class, market);
                    case 5 -> createCart(Food.class, market);
                    default -> System.out.println("Menu item does not exist.\nPlease try entering again");
                }
            } else {
                System.out.println("Incorrect menu item.\nPlease try entering again");
                scanner.nextLine();
            }
        }


    }

    /**
     * Create online cart from food products
     * @param market Market and list of products
     * @param <T> type of products
     */
    static <T extends Food> void createCart(Class<T> clazz, UMarket market){
        Cart<T> cart = new Cart<>(clazz, market);
        while (true){
            System.out.println("List of available products");
            System.out.println("[0] End of formation the cart and balancing");
            market.printThings(clazz);
            System.out.println("Put number of product for added: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                if (no == 0){
                    cart.cartBalancing();
                    System.out.println("Your cart contains products:");
                    cart.printFoodStaffs();
                    return;
                } else {
                    T thing = market.getThingByIndex(clazz, no);
                    if (thing == null) {
                        System.out.println("Incorrect menu item.\nPlease try entering again");
                        continue;
                    }
                    cart.getFoodStuffs().add(thing);
                    System.out.println("Product successfully added in the cart");
                    System.out.println("Your cart contains products:");
                    cart.printFoodStaffs();
                }
            }
            else System.out.println("Incorrect menu item.\nPlease try entering again");
            scanner.nextLine();
        }
    }
}
