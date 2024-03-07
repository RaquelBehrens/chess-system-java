package services;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class GenericClass<T> {

    private List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty!")
        }
        return list.get(0);
    }
}


/*
 * Como usar:
 *
 * GenericClass<Integer> gc = new GenericClass<>();
 *
 * ...outras funções
 *
 *
 * */

/* Delimited Gerenerics */

public class DelimitedGenerics {

    public static <T extends Comparable<? super T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("List can not be empty");
        }
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

}


public class Product implements Comparable<Product> {

    private Double price;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(services.Product product) {
        return price.compareTo(other.getPrice());
    }
}


/*
 * Como usar:
 *
 * Product x = DelimitedGenerics.max(list)
 *
 * */


/* Tipos Curinga */

/* List <Object> não é supertipo de qualquer tipo de lista.
* List<?> é supertipo de qualquer tipo de lista:
*
* List<?> myObjs = new ArrayList<Object>();
* List<Integer> myNumbers = new ArrayList<Integer)();
* myObjs = myNumbers;
*
* */

/* Com tipos curinga podemos fazer métodos que recebem um genérico de "qualquer tipo".
* Mas não é possível adicionar dados a uma coleção de tipo curinga!
* */

public class CuringaType {

    public static void main(String[] args) {
        List<Integer> myInts = Array.asList(5, 2, 10);
        printList(myInts);
    }

    public static void printList(List<?> list) {
        // list.add(3) --> Não funciona
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}


/* Curingas delimitados */

public class DelimitedCuringa {

    public static void main(String[] args) {
        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(myCircles));
    }

    public static double totalArea(List<? extends Shape> list) {
        // list.add(new Rectangle(3.0, 4.0)); --> Não funciona
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}

public class DelimitedCuringa2 {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);

        List<? extends Number> list = intList;

        Number x = list.get(0);

        // list.add(20); --> Erro!
    }

    public static void main2(String[] args) {
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");

        List<? extends Number> myNums = myObjs;

        myNums.add(10);
        myNums.add(3.14);

        // Number x = myNums.get(0); --> Erro!
    }
}


/* HashCode e Equals */

public class HashCodeAndEquals {

    public static void main(String[] args) {

        String a = "Maria";
        String b = "Alex";

        System.out.println(a.equals(b)); // Resultado: false, usa hashCode para comparação dos valores dos objetos, mas é possível comparar literais com ==

        System.out.println(a.hashCode()); // função que produz um número inteiro
        System.out.println(b.hashCode());

        // hashCode possui um número de bits limitados, pode acontecer colisões (raramente)

        // Dá pra gerar hashcodes de objetos, e refazer a função de hashcode nesses objetos para alterar os parâmetros de comparação!
    }
}


/* Set */

public class Sets {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        //HashSet não garante a ordem dos objetos adicionados

        //Set<String> set = new TreeSet<>();
        //TreeSet garante a ordem dos objetos adicionados

        //Set<String> set = new LinkedSet<>();
        //LinkedSet garante a ordem dos objetos adicionados

        /* HashSet (mais rápido, O(1) nas operações, não ordenado)
        * LinkedHashSet (velocidade intermediária, e elementos ficam em ordem que são adicionados)
        * TreeSet (mais lento -> O(log(n) em árvore rubro-negra) e ordenado pelo CompareTo do objeto */

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        set.remove("Tablet");
        set.remove(x -> x.length() >= 3);

        System.out.println(set.contains("Notebook"));

        for (String p : set) {
            System.out.println(p);
        }

        /* Operations */

        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        // Union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);

        // Intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        
        // Difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);


        /* Como as coleções Set testam igualdade:
        *
        * Se hashCode e equals estiverem implementados. Primeiro hasCode. Se der igual, usa equals pra confirmar.
        *
        * String, Integer, Double, etc. já possuem equals e hashCode.
        *
        * Se hashCode e equals não estiverem implementados: compara as referências (ponteiros) dos objetos.
        *
        *  */
    }
}

/* Set */

public class Maps {

    public static void main(String[] args) {

        /* Map<K,V>
        *
        * É uma coleção de pares cahve/valor
        * -> Não admite repetições do objeto chave;
        * -> Os elementos são indexados pelo objeto chave (não possuem posição)
        * -> Acesso, inserção e remoção de elementos são rápidos
        *
        * Uso comum: cookies, local storage, qualquer modelo chave-valor
        *
        * Principais implementações:
        * -> HashMap - mais rápido (operações O(1) em tabela hash) e não ordenado;
        * -> TreeMap - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)
        * -> LinkedHashMap - velocidade intermediária e elementos na ordem em que são adicionados
        *
        * Métodos:
        * -> put(key, value)
        * -> remove(key)
        * -> contains(key)
        * -> get(key)
        * ---- a comparação é baseado em equals e hashCode, e, caso não existirem, comparação de ponteiros é usada
        *
        * -> clear()
        * -> size()
        *
        * -> keySet() - retorna um Set<K>
        * -> values() - retorna um Collection<V>
        */

        Map<String, String> cookies = new TreeMap<>();
        //ordena pelo nome da key

        cookies.put("username". "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "123456789");

        cookies.remove("email");

        cookies.put("phone", "987654321"); // Sobrescreve o valor antigo, pq não aceita repetições

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email")); // Quando o elemento não existe, retorna null
        System.out.println("Size: " + cookies.size());

        System.out.println("ALL COOKIES:");
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}