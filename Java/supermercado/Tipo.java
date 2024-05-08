package vendinha;

public enum Tipo {
    ALIMENTO (1.2),
    BEBIDA(2.3),
    HIGIENE(1.5);


    private final double markup;
    Tipo(double markup){

        this.markup = markup;
    }

    public double getMarkup() {
        return markup;
    }

    public static double calcularVenda(Tipo tipo, double custo){
        return tipo.getMarkup() * custo;
    }
}
