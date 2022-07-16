import java.util.ArrayList;
import java.util.List;

public class Lista {
    private ArrayList<Telegrama> lista = new ArrayList<Telegrama>();
    private int contador = 1;
    static int confirmacao = 0;

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

    public List<Telegrama> encontrarOcorrencia(String texto) {   
        List<Telegrama> Ocorrencias = new ArrayList<>();
        for (Telegrama telegrama : lista) {
            String[] mensagem = telegrama.getMensagem().split(" ");         
            for (int i = 0; i < mensagem.length; i++) {
                if (mensagem[i].equals(texto)) {
                        Ocorrencias.add(telegrama);
                    }
                }
            }
            return Ocorrencias;
        }
           
    public int getContador() {
        return contador;
    }
    
    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public int listaTamanho(){
        return lista.size();
    }

}
