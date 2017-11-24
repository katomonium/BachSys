package br.ufla.dcc.ppoo.model;

public class Musica {

    private final String nome;
    private final String autor;
    private final String album;
    private final int ano;
    private final String genero;
    private final Usuario usuario;
    private final String[] tags;
    
    /**
     * 
     * @param nome
     * @param autor
     * @param album
     * @param ano
     * @param genero
     * @param usuario
     * @param tags 
     */
    public Musica(String nome, String autor, String album, int ano,
            String genero, Usuario usuario, String[] tags) {
        
        if(tags == null || tags.length < 2) {
            System.out.println("Excecao: nao ha tags");
        }
        
        this.nome = nome;
        this.autor = autor;
        this.album = album;
        this.ano = ano;
        this.genero = genero;
        this.usuario = usuario;
        this.tags = tags;
    }
    
    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String[] getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Musica{" + "nome=" + nome + ", autor=" + autor + ", album="
                + album + ", ano=" + ano + ", genero=" + genero + ", usuario="
                + usuario + ", tags=" + tags + '}';
    }

}
