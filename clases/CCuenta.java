/**
 * Clase que representa el funcionamiento de una cuenta corriente simple.
 * 
 * @author Ministerio de Educación y Adonay Ramírez Valido
 * @version 1.0
 * @since 0.5
 */
public class CCuenta {

    /**
     * Nombre del titular de la cuenta
     */
    private String nombre;
    
    /**
     * Número de la cuenta, separando los campos por guines altos (-)
     */
    private String cuenta;
    
    /**
     * Cantidad de saldo disponible en la cuenta
     */
    private double saldo;
    
    /**
     * Número porcentaje del tipo de interés de la cuenta.
     */
    private double tipoInteres;
   
    /**
     * Constructor vacío por defecto
     */
    public CCuenta() {
    }

    /**
     * Constructor dónde inicializaremos todos los atributos de una cuenta
     * 
     * @param nom Nombre del titular de la cuenta a crear
     * @param cue Número de cuenta de la cuenta a crear
     * @param sal Cantidad inicial de saldo de la cuenta a crear
     * @param tipo Número porcentaje de interés de la cuenta a crear
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInteres = tipo;
    }
    
    /**
     * Obtiene el nombre del titular de la cuenta
     * 
    @return Nombre del titular de la cuenta
    */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del titular de la cuenta
     * 
    @param nombre El nombre por el que se cambiará el existente
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de cuenta de la cuenta
     * 
    @return Número de cuenta de la cuenta
    */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Cambia el número de cuenta de la cuenta
     * 
    @param cuenta Número de cuenta que reemplazará al existente
    */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Cambia el saldo de la cuenta
     * 
    @param saldo Cantidad de saldo que reemplazará al existente
    */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     *Obtiene el número porcentaje de interés de la cuenta
     * 
    @return Número porcentaje de interés de la cuenta
    */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Cambia el número porcentaje de interés de la cuenta
     * 
    @param tipoInteres El nuevo número porcentaje de interés
    */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    /**
     * Obtiene la cantidad actual de saldo en la cuenta
     * 
     * @return Cantidad de saldo actual en la cuenta
     */
    public double estado() {
        return saldo;
    }

    /**
     * Añadimos dinero al saldo de la cuenta
     * 
     * @param cantidad Cantidad de dinero a añadir al saldo
     * @throws Exception Si la cantidad es negativa
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        setSaldo(saldo + cantidad);
    }

    /**
     * Retira dinero del saldo de la cuenta
     * 
     * @param cantidad Cantidad a retirar del saldo
     * @throws Exception Si la cantidad es negativa, o si no hay saldo suficiente
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (estado() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        setSaldo(saldo - cantidad);
    }
    
    /**
     * Realiza unas operaciones básicas para ver que todo funciona bien
     * 
     * @param cuenta1 La cuenta que será objeto de las pruebas
     * @param cantidad Cantidad a ingresar y retirar de la cuenta objetivo
     * 
     * @see ingresar
     * @see retirar
     */
    public static void operativa_cuenta(CCuenta cuenta1, double cantidad) {
        double saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es" + saldoActual);
        try {
            cuenta1.retirar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
}
