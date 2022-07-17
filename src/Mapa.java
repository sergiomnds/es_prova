import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
    private Map<UF, Lista> mapa = new HashMap<UF, Lista>();
    private int id_telegrama = 1;

    Mapa() {
        for (UF uf : UF.values()) {
            mapa.put(uf, new Lista());
        }
    }

    public Telegrama consultarTelegrama(int identificador) {
        for (Lista lista : mapa.values()) {
            Telegrama telegrama = lista.consultarTelegrama(identificador);
            if (telegrama != null) {
                return telegrama;
            }
        }
        return null;
    }

    public Map<UF, Integer> encontrarOcorrencia(String texto) {
        texto = texto.trim().toLowerCase();
        Map<UF, Integer> ocorrencias = new HashMap<UF, Integer>();
        for (Entry<UF, Lista> pair : mapa.entrySet()) {
            List<Telegrama> telegrama = pair.getValue().encontrarOcorrencia(texto);
            if (telegrama != null && telegrama.size() != 0) {
                ocorrencias.put(pair.getKey(), telegrama.size());
            }
        }
        return ocorrencias;
    }

    public int adicionar(UF uf, Telegrama telegrama) throws IllegalArgumentException {
        if (uf == null) {
            throw new IllegalArgumentException("UF não pode ser nulo");
        }

        id_telegrama++;
        return mapa.get(uf).adicionar(telegrama, id_telegrama);

    }

    public boolean remover(int identificador) throws IllegalArgumentException {
        for (Lista lista : mapa.values()) {
            if (lista.remover(identificador)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasUF(UF uf) {
        return mapa.containsKey(uf);
    }

    public String getMaiorLista() {

        int maior = 0;
        Map<UF, Integer> quantidades = new HashMap<UF, Integer>();
        for (Entry<UF, Lista> pair : mapa.entrySet()) {
            quantidades.put(pair.getKey(), pair.getValue().listaTamanho());
            if (pair.getValue().listaTamanho() > maior) {
                maior = pair.getValue().listaTamanho();
            }
        }
        String resposta = "\n";
        for (UF uf1 : quantidades.keySet()) {
            if (quantidades.get(uf1) == maior) {
                resposta += uf1.getDescricao() + " ("+maior+")\n";
            }
        }
    
        return resposta;
    }
    public String getMenorLista() {

        int menor = Integer.MAX_VALUE;
        Map<UF, Integer> quantidades = new HashMap<UF, Integer>();
        for (Entry<UF, Lista> pair : mapa.entrySet()) {
            quantidades.put(pair.getKey(), pair.getValue().listaTamanho());
            if (pair.getValue().listaTamanho() < menor && pair.getValue().listaTamanho() > 0) {
                menor = pair.getValue().listaTamanho();
            }
        }
        String resposta = "\n";
        for (UF uf1 : quantidades.keySet()) {
            if (quantidades.get(uf1) == menor) {
                resposta += uf1.getDescricao() + " ("+menor+")\n";
            }
        }
        return resposta;
    }
   

    public int quantidadeTelegramasNoMapa() {
        int contador = 0;
        for (Lista lista : mapa.values()) {
            contador += lista.listaTamanho();
        }
        return contador;
    }

    public int quantidadeTelegramas(UF uf) {
        return mapa.get(uf).listaTamanho();
    }
}
