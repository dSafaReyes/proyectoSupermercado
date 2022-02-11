package utilidades;

import modelos.Cliente;

import java.util.Arrays;

public class UtilidadesCliente {

    public boolean esDniValido(Cliente cliente) {
        String dni = cliente.getDni();
        String dniNums = dni.substring(0, dni.length() - 1);
        String dniLetter = dni.substring(dni.length() - 1);
        boolean isLetter = Character.isLetter(dniLetter.charAt(0));
        boolean allAreNums = Arrays.stream(dniNums.split("")).allMatch(letter -> Character.isDigit(letter.charAt(0)));
        return allAreNums && isLetter;
    }

}
