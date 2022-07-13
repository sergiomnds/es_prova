import java.util.ArrayList;

public class Lista {
    private ArrayList<Telegrama> lista = new ArrayList<Telegrama>();
    private int contador = 1;

    public boolean adicionar(Telegrama telegrama) {
        telegrama.gerarIdentificador(contador);
        contador++;
        return lista.add(telegrama);
    }

    public boolean remover(int identificador) {
        for (Telegrama telegrama : lista) {
            if (telegrama.getIdentificador() == identificador) {
                lista.remove(telegrama);
                return true;
            }
        }
        return false;
    }

    public Telegrama consultarTelegrama(int identificador) {
        for (Telegrama telegrama : lista) {
            if (telegrama.getIdentificador() == identificador) {
                return telegrama;
            }
        }
        return null;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
