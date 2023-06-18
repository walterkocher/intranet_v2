package utils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class ValidarRut {
    public static String eliminarCaracteresRut(String rut){
        rut= rut.replace(".","");
        rut= rut.replace("-","");
        return rut;
    }
    public static String[] dividirRutDigitoVerificador(String rut){
        rut= eliminarCaracteresRut(rut);
        String[] rutDividido= new String[]{rut.substring(0,rut.length()-1),rut.substring(rut.length()-1)};
        System.out.println("rut "+rutDividido[0]+" guion "+rutDividido[1]);
        return rutDividido;
    }

    // segmenta el rut en un arreglo de caracteres
    public static char[] segmentarRut(String rut) {
        char[] rutInvertido = rut.toCharArray();
        rutInvertido = invertirRut(rutInvertido);
        //System.out.println(rutInvertido);
        return rutInvertido;
    }
    public static boolean validarRut(String rut){
        try {
            int rutInt = Integer.parseInt(rut);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static int convertirDigitoVerificador(String digito){
        int digitoVerificador;
        try {
            digitoVerificador = Integer.parseInt(digito);
            if (digitoVerificador == 0) {
                digitoVerificador= 11;
            }
        }
        catch (Exception e){
            if(digito.toUpperCase(Locale.ROOT).equals("K")){
                digitoVerificador=10;
            }
            else{
                digitoVerificador=-1;
            }
        }
        return digitoVerificador;
    }

    // invierte el rut
    public static char[] invertirRut(char[] rut) {
        char aux;
        for (int i = 0; i < rut.length / 2; i++) {
            aux = rut[i];
            rut[i] = rut[rut.length - 1 - i];
            rut[rut.length - 1 - i] = aux;
        }

        return rut;
    }

    // multiplica el rut invertido por la cadena 2,4,5,6,7
    public static int multiplicacionCadena(char[] rut) {
        int resultadoCadena = 0;
        int contador = 2;
        for (int i = 0; i < rut.length; i++) {
            resultadoCadena = resultadoCadena + Integer.parseInt(String.valueOf(rut[i])) * contador;
            if (contador >= 7) {
                contador = 2;
            } else {
                contador++;
            }
        }
        //System.out.println(resultadoCadena);
        return resultadoCadena;
    }
    public static int obtenerDigitoVerificador(int multiplicacionCadena){
        //  int divisionCadena= (int)(multiplicacionCadena / 11);
        // int digitoVerificador= 11- (multiplicacionCadena - (divisionCadena*11));
        //  return digitoVerificador;
        int digito= 11- (multiplicacionCadena % 11);
        return digito ;
    }

    //calcula el digito verificador desde el rut invertido
    public static int calcularDigito(String rut){
        char[] rutInvertido= segmentarRut(rut);
        int multiplicacionCadena= multiplicacionCadena(rutInvertido);
        return obtenerDigitoVerificador(multiplicacionCadena);
    }
    //calcula el digito verificador desde el rut invertido
    public static boolean validarDigito(String rut){
        if(rut.length()<2){
            return false;
        }
        String[] rutDigitoVerificador= dividirRutDigitoVerificador(rut);
        if(validarRut(rutDigitoVerificador[0])){
            int digitoVerificador= calcularDigito(rutDigitoVerificador[0]);
            return digitoVerificador==convertirDigitoVerificador(rutDigitoVerificador[1]);
        }
        else{
            return false;
        }

    }

}