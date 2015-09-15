package dataManipulation;

import Classes.Area;
import Classes.Artigo;
import Classes.Autor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Pittigliani
 */
public class saveBin {
    //entrada String por virgulas(ex: "João,Maria")
    //Busca os artigos em comum de 2 ou mais autores
    public ArrayList<Artigo> artigosNautores(String nomeAutores) {
        String[] autores = nomeAutores.split(",");
        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
        ArrayList<Autor> auts = new ArrayList<Autor>();

        try {
            Deserializador d = new Deserializador();
            for (int i = 0; i < autores.length; i++) {
                Autor aux = d.achaAutor("autores.bin", autores[i]);
                if (aux == null) {
                    return null;//auts.set(i, aux);
                }
                auts.add(aux);
            }
            ArrayList<Integer> idsValidos = new ArrayList<Integer>();
            ArrayList<Integer> aux = new ArrayList<Integer>();
            for (int i = 0; i < auts.size() - 1; i++) {
                idsValidos = auts.get(i).getArtigoTotal();
                aux = auts.get(i + 1).getArtigoTotal();
                idsValidos.retainAll(aux);
            }
            auts.clear();
            auts = null;
            aux.clear();
            aux = null;
            listaArtigos = d.artigosValidos(idsValidos, "artigos.bin");
            d = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Falha ao deserializar! - "
                    + ex.toString());
        }
        return listaArtigos;//ARRUMAR
    }

    public ArrayList<Artigo> artigosAutor(String nomeAutor) {
        //busca 1: todos os artigos de um autor
        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
        try {
            Deserializador d = new Deserializador();

            Autor autor = d.achaAutor("autores.bin", nomeAutor);
            if (autor != null) {
                listaArtigos = d.artigosValidos(autor.getArtigoTotal(), "artigos.bin");
            } else {
                return null;
            }

            autor = null;
            d = null;
        } catch (Exception ex) {
            System.err.println("Falha ao deserializarYTYT! - "
                    + ex.toString());
        }
        Comparador cmp = new Comparador();
        Collections.sort(listaArtigos, cmp);
        /* for (int aux = 0; aux < listaArtigos.size(); aux++) {
         System.out.println(listaArtigos.get(aux).getTitulo());
         }*/
        cmp = null;
        return listaArtigos;
    }
    //funcao para a busca de artigos contendo a String palavra
    public ArrayList<Artigo> artigosBusca3(String palavra){
        //Artigos com a palavra no titulo
        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
        try{
            Deserializador d = new Deserializador();
            listaArtigos = d.artigosBusca3(palavra, "artigos.bin");
            
        }catch (Exception ex) {
            System.err.println("Falha ao deserializarOI! - "
                    + ex.toString());
        }
        Comparador cmp = new Comparador();
        Collections.sort(listaArtigos, cmp);
        //for (int aux = 0; aux < listaArtigos.size(); aux++) {
        //    System.out.println(listaArtigos.get(aux).getTitulo());
        //}
        cmp = null;
        return listaArtigos;
    }
//
    public ArrayList<Autor> busca4(String info) throws Exception{
        //funcionando
        Area area = new Area();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        
        Deserializador d = new Deserializador();
        try{
            area = d.achaArea("areas.bin", info, area);
            if (area==null)
                return null;
        }catch(Exception e){
            System.err.println("achaArea erro - "+e.toString());
        }
        //temos a area com os ids dos artigos.
        try{
            autores = d.busca4("autores.bin", area.getIdArtigosArray());
        }catch(Exception e){
            System.err.println("achaArea erro - "+e.toString());
        }
        
        ComparadorDecrescente cmp = new ComparadorDecrescente();
        Collections.sort(autores, cmp);
        
        return autores;
    }
    
    
    public ArrayList<Artigo> artigosBusca5(String a) {
        //listagem de todos os artigos de um autor em determinado ano;
        String[] b = a.split(",");
        String nomeAutor = b[0];
        String ano = b[1];
        ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();

        try {
            Deserializador d = new Deserializador();

            Autor autor = d.achaAutor("autores.bin", nomeAutor);
            try {
                // Deserializador d = new Deserializador();
                listaArtigos = d.artigosValidos(autor.getArtigoTotal(), "artigos.bin");
                autor = null;
            } catch (Exception ex) {
                System.err.println("Falha ao deserializarOPA2! - "
                        + ex.toString());
            }
            d = null;
        } catch (Exception ex) {
            System.err.println("Falha ao deserializarOPA! - "
                    + ex.toString());
        }

        //temos a lista de artigos validos do autor mas nao do ano
        Deserializador d = new Deserializador();
        listaArtigos = d.artigosValidosAno(listaArtigos, ano);
        Comparador cmp = new Comparador();
        Collections.sort(listaArtigos, cmp);
        // for (int aux = 0; aux < listaArtigos.size(); aux++) {
        //     System.out.println(listaArtigos.get(aux).getTitulo());
        // }
        cmp = null;
        return listaArtigos;
    }

    /*
     Funcao para Atualizar a lista de autores.
     params:
     listaAutor: contem todos os autores ja adicionados.
     autoresArtigo: ArrayList de Strings contendo os autores do ultimo artigo lido.
     idArtigo: id do artigo lido, para inserir na lista dos artigos escritos pelo autor.
     */
    private ArrayList<Autor> atualizaAutor(ArrayList<Autor> listaAutor, ArrayList<String> autoresArtigo, int idArtigo) {
        //inserir artigo na lista do autor
        boolean isNew = true; //booleano auxilar para inserir um novo autor. Por padrao eh true.
        
        /*
        if (listaAutor.isEmpty()) {
            Autor nodo = new Autor(autoresArtigo.get(0));
            nodo.setArtigo(idArtigo);
            listaAutor.add(nodo);
            nodo = null;
        }
        */
        //O primeiro laco percorre a lista de Strings e o segundo a lista de autores
        for (int j = 0; j < autoresArtigo.size(); j++) {
            for (int i = 0; i < listaAutor.size(); i++) {
                //Se o autor ja existe na lista, adiciona o id do artigo ao seu respectivo autor
                if (autoresArtigo.get(j).equals(listaAutor.get(i).getAutor())) {
                    listaAutor.get(i).setArtigo(idArtigo);
                    isNew = false; // deixa o flag negativo de que o autor nao eh novo
                    break;// como o autor foi encontrado sai do loop interno

                }
            }
            //se o autor nao esta na lista, adiciona-o na lista
            if (isNew) {
                Autor nodo2 = new Autor(autoresArtigo.get(j));
                nodo2.setArtigo(idArtigo);
                listaAutor.add(nodo2);
                nodo2 = null;
            }
            isNew = true; //deixa a flag como true
        }

        return listaAutor;
    }
    
    /*
    private Area buscaAutores(ArrayList<String> autoresArtigo, ArrayList<Autor> listaAutor, Area nodo) {
        for (int j = 0; j < autoresArtigo.size(); j++) {
            for (int i = 0; i < listaAutor.size(); i++) {
                if (autoresArtigo.get(j).equals(listaAutor.get(i).getAutor()) && !nodo.containsAutor(i)) {
                    nodo.setIdAutor(i);
                }
            }
        }

        return nodo;
    }
    */

    // funcao com mesmo objetivo que atualizaAutor, porem para o arquivo de areas
    private ArrayList<Area> atualizaAreas(ArrayList<Area> listaAreas, String nomeArea, int idArtigo) {
        //se a lista estiver vazia, insere o nodo
        Area nodo = new Area();
        //nodo = buscaAutores(autoresArtigo, listaAutor, nodo);
        nodo.setNome(nomeArea);
        nodo.setIdArtigos(idArtigo);
        if (listaAreas.isEmpty()) {
           listaAreas.add(nodo);
           nodo=null;
           return listaAreas;
        }
        //busca para verificar se ja existe area definida
        for (int j = 0; j < listaAreas.size(); j++) {
            //Se o autor ja existe na lista, adiciona o id do artigo ao seu respectivo autor
            if (listaAreas.get(j).getNome().equals(nomeArea)) {
                
                listaAreas.get(j).setIdArtigos(idArtigo);
                //listaAreas.set(j, nodo);
                return listaAreas;
            }
        }
        //insere nova area
        listaAreas.add(nodo);
        return listaAreas;
    }

    public int leCSV(String fileInput) {
        Scanner entrada = new Scanner(System.in);
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        Serializador s = new Serializador();
        int id = 0;
        ArrayList<Artigo> artigos = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Area> areas = new ArrayList<>();
        try {

            br = new BufferedReader(new FileReader(fileInput));
            line = br.readLine();// le a primeira linha para ignorar o campo inicial
            //faz o while procurando pelo nome
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] linha = line.split(cvsSplitBy);
                //linha[22] é o nome do autor
                //adiciona tudo 
                /**
                 * adiciona no arquivo serial o artigo do autor; arquivo
                 * binario; insere a instancia de artigo public Artigo(int id,
                 * String ano, String titulo, String area
                 */
                Artigo art = new Artigo(id, linha[0], linha[3], linha[18]);
                //temos a instancia deste artigo
                art.setAutor(linha, linha.length);
                artigos.add(art);//adicionou ao array                
                autores = atualizaAutor(autores, art.getAutor(), id);
                areas = atualizaAreas(areas, linha[18],id);
                id++;
            }
            try {
              /*  for(int i=0;i<areas.size();i++)
                    System.out.println(areas.get(i).getNome()+"Autores:"+areas.get(i).);
                */
                      //coloca a instancia art no arquivo binario
                s.serializarAutor("autores.bin", autores);
                s.serializarArtigo("artigos.bin", artigos);
                s.serializarArea("areas.bin", areas);
            } catch (Exception ex) {
                System.err.println("Falha ao serializar! - " + ex.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }

}
