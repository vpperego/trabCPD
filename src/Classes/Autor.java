package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pittigliani
 */
public class Autor implements Serializable {

    private static final long serialVersionUID = -8788577721993601053L;
    private String Autor;
    private ArrayList<Integer> Artigo = new ArrayList<Integer>();

    public Autor(String Autor) {
        this.Autor = Autor;
    }

    public String getAutor() {
        return this.Autor;
    }

    public ArrayList<Integer> getArtigoTotal() {
        return this.Artigo;
    }

    public int getArtigo(int index) {
        return Artigo.get(index);
    }

    public Integer totalArtigo() {
        return Artigo.size();
    }

    public void setArtigo(int novoArtigo) {
        Artigo.add(novoArtigo);
    }

    public void setArtigoTotal(ArrayList<Integer> array) {
        this.Artigo = array;
    }

    public void clearArtigo() {
        Artigo.clear();
    }

}
