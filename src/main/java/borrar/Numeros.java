package borrar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Numeros {

    public static void main(String[] args) {

        // Declaramos e instanciamos una lista:
        List<Integer> numeros = new ArrayList<>();

        // Añadimos elementos a una lista:
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        // Sumar +1 a cada número:
        List<Integer> numerosMas1 = new ArrayList<>();
        // Recorremos la lista original:
        for (Integer num:numeros) {
            // En cada iteración obtenemos un número, a ese le sumamos 1
            // y lo guardamos en una variable newNum:
            Integer newNum = num + 1;
            // esta nueva variable la añadimos a la nueva lista
            numerosMas1.add(newNum);
        }

        // Filtrar números pares:
        List<Integer> numerosPares = new ArrayList<>();
        // Recorremos la lista original:
        for (Integer num:numeros) {
            // Establecemos condición de filtro:
            if (num%2 == 0) {
                // Si pasa el filtro se añade a la nueva lista
                numerosPares.add(num);
            }
            // Si no es par no se añade a la nueva lista
        }

        System.out.println("Lista números original: " + numeros);
        System.out.println("Lista números +1: " + numerosMas1);
        System.out.println("Lista números pares: " + numerosPares);

        // EJERCICIOS
        // Filtrar números impares
        // Sumar +1 a cada uno
        // Filtrar los que son iguales a 1
        // Multiplicar x2 cada uno
        // Filtrar el ó los números más altos
        // Elevar al cuadrado cada uno




//        {
//            lolo: 15,
//            lola: 25
//        }
//        Map<String, Integer> json = new HashMap<>();
//        json.put("lolo", 15);
//        json.put("lola", 25);
//        System.out.println(json);

    }

}
