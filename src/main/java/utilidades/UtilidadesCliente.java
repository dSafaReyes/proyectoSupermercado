package utilidades;

import modelos.Cliente;

import java.util.Arrays;

public class UtilidadesCliente {

    public static boolean esDniValido(Cliente cliente) {
        String dni = cliente.getDni();
        String dniNums = dni.substring(0, dni.length() - 1);
        String dniLetter = dni.substring(dni.length() - 1);
        boolean isLenRigth = dni.length() == 9;
        boolean isLastCharLetter = Character.isLetter(dniLetter.charAt(0));
        boolean AreNums = Arrays.stream(dniNums.split("")).allMatch(letter -> Character.isDigit(letter.charAt(0)));
        return isLenRigth && AreNums && isLastCharLetter;
    }

}
