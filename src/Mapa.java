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

    public String getMaiorLista() {
        int maior = 0;
        UF uf = null;
        for (UF uf1 : mapa.keySet()) {
            if (mapa.get(uf1).quantidadeTelegramas() > maior) {
                maior = mapa.get(uf1).quantidadeTelegramas();
                uf = uf1;
            }
        }
        return uf.getDescricao();
    }

    public String getMenorLista() {
        int menor = Integer.MAX_VALUE;
        UF uf = null;
        for (UF uf1 : mapa.keySet()) {
            if (mapa.get(uf1).quantidadeTelegramas() < menor) {
                menor = mapa.get(uf1).quantidadeTelegramas();
                uf = uf1;
            }
        }
        return uf.getDescricao();
    }

    public int quantidadeTelegramas(UF uf) {
        return mapa.get(uf).quantidadeTelegramas();
    }

    public int quantidadeTelegramasNoMapa() {
        int contador = 0;
        for (Lista lista : mapa.values()) {
            contador += lista.quantidadeTelegramas();
        }
        return contador;
    }
}
