import java.util.ArrayList;
import java.util.List;

public class Lista {
    private ArrayList<Telegrama> lista = new ArrayList<Telegrama>();
    static int confirmacao = 0;

    public int adicionar(Telegrama telegrama, int id) {
        telegrama.setIdentificador(id);
        if (lista.add(telegrama)) {
            return telegrama.getIdentificador();
        }
        return -1;

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

    public List<Telegrama> encontrarOcorrencia(String texto) {
        List<Telegrama> Ocorrencias = new ArrayList<>();
        for (Telegrama telegrama : lista) {
            if (telegrama.getMensagem().toLowerCase().contains(texto)) { // verifica se a mensagem contem um determinado texto
                Ocorrencias.add(telegrama);

            }
        }
        return Ocorrencias;
    }

    public int listaTamanho() {
        return lista.size();
    }
}
