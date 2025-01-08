package utez.edu.mx.RIS.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class Validaciones {
    private final static Logger logger = LoggerFactory.getLogger(Validaciones.class);

    /**
     * Esta función valida que la longitud de los datos no EXCEDAN la cantidad de caracteres permitidos en la base de datos, retorna una excepción si no cumple con las condiciones.
     * Parámetro 1: El nombre del dato que quieres validar.
     * Parámetro 2: El valor del dato que quieres validar.
     * Parámetro 3: La longitud máxima permitida para el dato (los espacios también cuentan).
     * */
    public static ResponseEntity<Object> validarMayorLongitud(String nombre_dato, String valor, int longitud) {
        if (valor.length()>longitud){
            logger.warn("El campo '{}' excede el número de caracteres ({})", nombre_dato, longitud);
            return new ResponseEntity<>(new Message("El campo '" + nombre_dato + "' excede el número de caracteres (" + longitud + ")", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    /**
     * Esta función valida que la longitud del dato no sea DIFERENTE a la longitud de caracteres permitidos en la base de datos, retorna una excepción si no cumple con las condiciones.
     * Parámetro 1: El nombre del dato que quieres validar.
     * Parámetro 2: El valor del dato que quieres validar.
     * Parámetro 3: La longitud permitida para el dato (debe ser exactamente la misma longitud del dato).
     * */
    public static ResponseEntity<Object> validarDiferenteLongitud(String nombre_dato, String valor, int longitud_igual) {
        if (valor.length()!= longitud_igual){
            logger.warn("El campo '{}' debe contener ({}) dígitos", nombre_dato, longitud_igual);
            return new ResponseEntity<>(new Message("El campo '"+ nombre_dato +"' debe contener (" + longitud_igual + ") dígitos", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    /**
     * Esta función valida que la longitud del dato sea entre un RANGO que le indiques permitidos en la base de datos, retorna una excepción si no cumple con las condiciones.
     * Parámetro 1: El nombre del dato que quieres validar.
     * Parámetro 2: El valor del dato que quieres validar.
     * Parámetro 3: La longitud MÍNIMA permitida para el dato.
     * Parámetro 4: La longitud MÁXIMA permitida para el dato.
     * */
    public static ResponseEntity<Object> validarRangoLongitud(String nombre_dato, String valor, int minimo, int maximo) {
        if (valor.length()> maximo || valor.length()< minimo){
            logger.warn("El campo '{}' está fuera del rango del número de caracteres", nombre_dato);
            return new ResponseEntity<>(new Message("El campo '"+ nombre_dato +"' está fuera del rango del número de caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    /**
     * Esta función es una excepción que es retornada por si hay un dato esperado que sea nulo.
     * */
    public static ResponseEntity<Object> excepcionDatosNulos() {
        logger.error("Verifica tu petición, algún dato enviado es nulo");
        return new ResponseEntity<>(new Message("Verifica tu petición, algún dato enviado es nulo", TypesResponse.ERROR), HttpStatus.BAD_REQUEST);
    }

    /**
     * Esta función es una excepción que es retornada por si hay un dato esperado que sea invalido.
     * */
    public static ResponseEntity<Object> excepcionDatoInvalido(String nombre_dato) {
        logger.warn("{} no es valido", nombre_dato);
        return new ResponseEntity<>(new Message(nombre_dato+" no es valido", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
    }

    /**
     * Esta función es una excepción que es retornada por si hay un dato único que ya este registrado en la base de datos.
     * */
    public static ResponseEntity<Object> excepcionDatoYaRegistrado(String nombre_dato) {
        logger.warn("{} ya está registrado", nombre_dato);
        return new ResponseEntity<>(new Message(nombre_dato+" ya está registrado", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
    }

    /**
     * Esta función es una excepción que es retornada por si hay un objeto esperado que sea nulo o inexistente.
     * Parámetro 1: El nombre de la clase al que pertence el objeto (para una mejor depuración)
     * */
    public static ResponseEntity<Object> excepcionObjetoInexistente(String nombre) {
        logger.warn("No se encontró {}", nombre);
        return new ResponseEntity<>(new Message("No se encontró " +nombre, TypesResponse.WARNING), HttpStatus.NOT_FOUND);
    }

    /**
     * Esta función valida que un conjunto de datos NO sean nulos (Solo aplica para Strings), retorna false si NO hay datos nulos.
     * Parámetro 1: El conjunto de datos que quieres validar que no sean nulos (ArrayList<String>).
     * */
    public static boolean sonNulos(ArrayList<String> datos){
        if (datos == null || datos.isEmpty()) {
            return true;
        }
        for (String dato : datos) {
            if (dato == null || dato.replace(" ", "").isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esta función valida que un String sea numerico de tipo Long, Retorna una excepción si no es una String numerica.
     * Parámetro 1: El nombre del campo que quieres validar.
     * Parámetro 2: El valor del campo que quieres validar.
     * */
    public static ResponseEntity<Object> esNumerico(String nombre_dato, String valor) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException e) {
            logger.warn("El campo '{}' no es un número", nombre_dato);
            return new ResponseEntity<>(new Message("El campo " + nombre_dato + " no es un número", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    /**
     * Esta función valida que un número de tipo Long sea mayor a 0, retorna true si es menor o igual a 0.
     * Parámetro 1: El número que quieres validar.
     * */
    public static boolean esIgualOMenorACero(Long id){
        return id <= 0;
    }
}
