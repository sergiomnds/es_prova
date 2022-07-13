import java.util.HashMap;

public class Mapa {
    private HashMap<UF, Lista> mapa = new HashMap<UF, Lista>();

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
