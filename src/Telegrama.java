public class Telegrama {
    private String destinatario;
    private String remetente;
    private String mensagem;
    // rua, bairro e numero, cidade e estado
    private String rua;
    private String bairro;
    private int numero;
    private String cidade;
    private String endereco;
    private UF uf;
    private int identificador;

    public Telegrama(String destinatario, String remetente, String mensagem, String endereco) {
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.mensagem = mensagem;
        this.endereco = endereco;
    }

    public void gerarEndereco() {
        String[] endereco = this.endereco.split(",");
        this.rua = "Rua " + endereco[0];
        this.numero = Integer.parseInt(endereco[1]);
        this.bairro = "Bairro " + endereco[2];
        this.cidade = "Cidade " + endereco[3];
        this.uf = UF.valueOf(endereco[4]);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void gerarIdentificador(int entradaTelegrama) {
        this.identificador = entradaTelegrama;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String toString() {
        return "Telegrama de Nº: " + this.identificador +
                "\nDestinatario: " + this.destinatario +
                "\nRemetente: " + this.remetente +
                "\nMensagem: " + this.mensagem +
                "\nEndereço: " + this.endereco;
    }
}
