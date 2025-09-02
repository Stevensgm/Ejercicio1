public class CuentaAhorros extends Cuenta {

    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    // Getter para el atributo 'activa'
    public boolean isActiva() {
        return activa;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta de ahorros está inactiva y no se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta de ahorros está inactiva y no se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual = comisionMensual + (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        if (saldo < 10000) {
            activa = false;
        }
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Estado de la cuenta: " + (activa ? "Activa" : "Inactiva"));
    }
}