package services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Comparator */

public class Program {

    public static int compareProducts(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 400.00));

        // Classe anônima, não precisa mais declarar a classe

        /*
        Comparator<Product> comp = new Comparator<services.Product>() {
            @Override
            public int compare(services.Product p1, services.Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        }
        */

        // Arrow function

        /*
        Comparator<Product> comp = (p1, p2) -> {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        }
        */

        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        list.sort(comp);
        //ou
        list.sort(Program::compareProducts);

        /*
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        */

        /* Predicate */
        list.removeIf(new ProductPredicate());

        Predicate<Product> pred = p -> p.getPrice() >= 100.0;
        list.removeIf(pred);

        list.removeIf(p -> p.getPrice() >= 100.0);


        /* Consumer */
        list.forEach(new PriceUpdate());
        list.forEach(Product::staticPriceUpdate);
        list.forEach(Product::nonStaticPriceUpdate);

        double factor = 1.1;
        Consumer<Product> cons = p -> {
            p.setPrice(p.getPrice() * factor);
        }
        list.forEach(cons);

        list.forEach(p -> p.setPrice(p.getPrice() * factor));


        /* Function */
        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());

        List<String> names1 = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

        List<String> names2 = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

        Function<Product, String> func = p -> p.getName().toUpperCase();
        List<String> names3 = list.stream().map(func).collect(Collectors.toList());

        List<String> names4 = list.stream().map( p -> p.getName().toUpperCase()).collect(Collectors.toList());


        /* Predicate Object */
        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        /*
        for (Product p : list) {
            System.out.println(p);
        }*/

        list.forEach(System.out::println);


        /* Stream */
        List<Integer> list = Array.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));


        /* Pipelines */
        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);

        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));

    }
}

public class Product {
    // todas as funções...

    /*Diferença entre static e non static*/
    public static boolean staticProductPredicate(Product p) {
        return p.getPrice() >= 100.0;
    }

    public booelan nonStaticProductPredicate() {
        return price >= 100.0;
    }

    public static void staticPriceUpdate(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    public void nonStaticPriceUpdate() {
        setPrice(getPrice() * 1.1);
    }

    public static String staticUpperCaseName(Product p) {
        return p.getName().toUpperCase();
    }

    public String nonStaticUpperCaseName() {
        name().toUpperCase();
    }
}


/* Interface funcional */

public class MyComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }
}

// Predicate

public class ProductPredicate implements Predicate<T> {

    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }

    public double filteredSum(List<Product> list, Predicate<Product> criteria) {
        double sum 0.0;
        for (Product p : list) {
            if (criteria.test(p)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

}

// Consumer

public class PriceUpdate implements Consumer<Product> {

    @Override
    public void accept(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }
}

// Function
public class UpperCaseName implements Function<Product, String> {

    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}