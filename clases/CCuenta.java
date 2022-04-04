
public class CCuenta {

    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    public CCuenta() {
    }

    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInteres = tipo;
    }
    
    /**
    @return the nombre
    */
    public String getNombre() {
        return nombre;
    }

    /**
    @param nombre the nombre to set
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    @return the cuenta
    */
    public String getCuenta() {
        return cuenta;
    }

    /**
    @param cuenta the cuenta to set
    */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
    @param saldo the saldo to set
    */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
    @return the tipoInteres
    */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
    @param tipoInteres the tipoInteres to set
    */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double estado() {
        return saldo;
    }

    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        setSaldo(saldo + cantidad);
    }

    public void retirar(double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (estado() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        setSaldo(saldo - cantidad);
    }
    
    public static void operativa_cuenta(CCuenta cuenta1, double cantidad) {
        saldoActual = cuenta1.estado();
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
