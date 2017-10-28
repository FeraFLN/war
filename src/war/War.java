/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import com.ferafln.war.core.Continente;
import com.ferafln.war.core.Jogo;
import com.ferafln.war.core.Territorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fernandoneto
 */
public class War {

    private static List<Territorio> territorios;
    private static List<Continente> continentes;
    private static Properties propTerritorio;
    private static Properties propContinente;
    private static String path = "C:" + File.separatorChar + "Users" + File.separatorChar + "fernandoneto" + File.separatorChar + 
            "Documents" + File.separatorChar + "NetBeansProjects" + File.separatorChar + "War" + File.separatorChar + 
            "properties" + File.separatorChar;
    private static String arqNomeTerritorio = "nomesPaises.properties";
    private static String arqNomeContinente = "nomesContinente.properties";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carregar();
        Jogo j = new Jogo(null, territorios, territorios, continentes);
    }
    private static void carregar(){
         try {
            propTerritorio = new Properties();
            propContinente = new Properties();
            propTerritorio.load(new InputStreamReader(new FileInputStream(new File(path+arqNomeTerritorio)),"UTF-8"));
            propContinente.load(new InputStreamReader(new FileInputStream(new File(path+arqNomeContinente)),"UTF-8"));
            lerTerritorios();
//            for (Territorio t : territorios) {
//                System.out.println("Territorio "+t.getNome());
//                for (Territorio t1 : t.getTerritoriosVizinhos()) {
//                    System.out.println("--"+t1.getNome());
//                }
//            }
            lerContinentes();
//            for (Continente c : continentes) {
//                System.out.println("Continente "+c.getNome());
//                for (Territorio t1 : c.getTerritorioCont()) {
//                    System.out.println("--"+t1.getNome());
//                }
//            }
        } catch (IOException ex) {
            Logger.getLogger(War.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void lerTerritorios() throws IOException {
        territorios = new ArrayList<Territorio>();
//        Pattern p = Pattern.compile("\\{([^)]+)\\}");
        Pattern p = Pattern.compile("(\\{)([^\\}]*)(\\})");
        for (Object key : propTerritorio.keySet()) {
            Matcher m = p.matcher(propTerritorio.getProperty((String)key));
            m.find();
            int id = Integer.parseInt((String)key);
            String nome =((String)propTerritorio.get(key)).split(",")[0];
            territorios.add(new Territorio(id, nome, null, getVizinho(m.group(2))));
        }
    }
    private static List<Territorio> getVizinho(String ids){
        List<Territorio> t = new ArrayList<Territorio>();
        for (String key : ids.split(",")) {
             t.add(new Territorio(Integer.parseInt(key), ((String)propTerritorio.get(key)).split(",")[0], null, null));
        }
        return t;
    }
    
    private static void lerContinentes(){
        continentes = new ArrayList<Continente>();
//        Pattern p = Pattern.compile("\\{([^)]+)\\}");
        Pattern p = Pattern.compile("(\\{)([^\\}]*)(\\})");
        for (Object key : propContinente.keySet()) {
            Matcher m = p.matcher(propContinente.getProperty((String)key));
            m.find();
            int id = Integer.parseInt((String)key);
            String nome =((String)propContinente.get(key)).split(",")[0];
            String qtde =((String)propContinente.get(key)).split(",")[1];
            continentes.add(new Continente(id, nome, Integer.parseInt(qtde), getVizinho(m.group(2))));
        }
    }
}
