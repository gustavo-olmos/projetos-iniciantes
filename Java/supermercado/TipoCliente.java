package vendinha;

public enum TipoCliente {
    PF (1),
    PJ (0.95),
    VIP (0.85);

    private final double desconto;

    TipoCliente (double desconto){
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
    public static double calcularDesconto(TipoCliente tipoCliente, double valorTotal){
        return (tipoCliente.getDesconto() * valorTotal);
    }
}
