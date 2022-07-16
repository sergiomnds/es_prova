import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
    private Map<UF, Lista> mapa = new HashMap<UF, Lista>();

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

    public Map<UF, Integer> encontrarOcorrencia(String texto){
        Map<UF, Integer> mapa1 = new HashMap<UF, Integer>();
        for (Entry<UF, Lista> pair : mapa.entrySet()){
          List<Telegrama> telegrama = pair.getValue().encontrarOcorrencia(texto);
            if(telegrama != null && telegrama.size() != 0){
                mapa1.put(pair.getKey(), telegrama.size());
             
            }
        }
        return mapa1;
    }

    public boolean adicionar(UF uf, Telegrama telegrama) throws IllegalArgumentException {
        if (uf == null) {
            throw new IllegalArgumentException("UF não pode ser nulo");
        }
        return mapa.get(uf).adicionar(telegrama);
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
}
