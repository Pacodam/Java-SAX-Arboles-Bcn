/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Este handler se utilizará para los puntos 1, 2 y 3 de la actividad, y parte del 4.
 * @author alu2017454
 */
public class Handler extends DefaultHandler {

    
   
    //attributes used for option 1
    private List<String> structure; // general structure of all document
    private List<Integer> level; //used to store level of childhoold of every element (root = 0, first child = 1, childs of first child = 2, etc)
    private String openingElement;
    private int numberChilds = 0;
    
    //attributes used for option 2
     private int totalTrees = 0;
     
    //attributes used for option 3 
    private List<String> trees; //only trees with text in all elements 
    private String attribute;
    private String text;
    private Tree tree;
    private int added; //must be 23 to add a new tree
    
    /*In option 4, we present to the user the options of parametrical attributes. In this handler we save all parametrical data into a hashmap, and 
    in option 4 we access the different options via getParamData(). We make this way in order to practice hashmaps (making an extra handler
    would be, we know, more polite and clean)*/
    private HashMap<String, List<String>> hm;
    private List<String> tipusElement;
    private List<String> alcada;
    private List<String> categoriaArbrat ;
    private List<String> tipAigua;
    private List<String> tipReg;
    private List<String> tipSuperf;
    private List<String> tipSuport;
    private List<String> cobertaEscocell;
    private List<String> midaEscocell;
    private List<String> voraEscocell; 
    
    
    public Handler() {
        structure = new ArrayList<>();
        level = new ArrayList<>();
        trees = new ArrayList<>();   
        attribute = "";
    }
    
    /**
     * Given a param option, returns all the possible values that the param can addopt
     * @param param String
     * @return List String
     */
    public List<String> getParamData(String param){
        return hm.get(param);
    }

    /**
     * Returns tabulated structure
     * @return List String
     */
    public List<String> getStructure() {
       /*We got structure list and levels list. This getter creates a new tabulated
        list using both. */
       List<String> tabStructure = new ArrayList<>();
       StringBuilder space;
       for(int i = 0; i < structure.size(); i++){
           space = new StringBuilder();
           for(int j = 0; j < level.get(i); j++){
               space.append("    ");
           }
           tabStructure.add(space.toString() + structure.get(i));
       }
       return tabStructure;
       
    } 
    
    /**
     * Returns total number of trees
     * @return String
     */
    public String getTotalTrees(){
        return "There are " + totalTrees + " trees!";
    }
    
    
    /**
     * Returns trees with all data
     * @return List String
    */
    public List<String> getCompletTrees() {
        return trees;
       
    }
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
   
        text = new String(ch, start, length);
        String text2 = text.trim();  //we must apply trim to be able to know if text has null content
        if(!"".equals(text2)){
            switch(attribute) {
                case "codi":
                    tree.setCodi(text);
                    break;
                case "posicioX_ETRS89":
                    tree.setPosicioX(Double.parseDouble(text));
                    break;
                case "posicioY_ETRS89":
                    tree.setPosicioY(Double.parseDouble(text));
                    break;
                case "latitud_WGS84":
                    tree.setLatitud(Double.parseDouble(text));
                    break;
                case "longitud_WGS84":
                    tree.setLongitud(Double.parseDouble(text));
                    break;
                case "tipusElement":
                    tree.setTipusElement(text);
                     if(!tipusElement.contains(text)){
                       tipusElement.add(text);
                     }
                    break;
                case "espaiVerd":
                    tree.setEspaiVerd(text);
                    break;
                case "adreca":
                    tree.setAdreca(text);
                    break;
                case "alcada":
                    tree.setAlcada(text);
                     if(!alcada.contains(text)){
                       alcada.add(text);
                    }
                    break;
                case "catEspecieId":
                    tree.setCatEspecieId(Integer.parseInt(text));
                    break;
                case "nomCientific":
                    tree.setNomCientific(text);
                    break;
                case "nomEsp":
                    tree.setNomEsp(text);
                    break;
                case "nomCat":
                    tree.setNomCat(text);
                    break;
                case "categoriaArbrat":
                    tree.setCategoriaArbrat(text);
                     if(!categoriaArbrat.contains(text)){
                       categoriaArbrat.add(text);
                    }
                    break;
                case "ampladaVorera":
                    tree.setAmpladaVorera(Double.parseDouble(text));
                    break;
                case "plantacioDT":
                    tree.setPlantacioDT(text);
                    break;
                case "tipAigua":
                    tree.setTipAigua(text);
                     if(!tipAigua.contains(text)){
                       tipAigua.add(text);
                     }
                    break;
                case "tipReg":
                    tree.setTipReg(text);
                     if(!tipReg.contains(text)){
                       tipReg.add(text);
                    }
                    break;
                case "tipSuperf":
                    tree.setTipSuperf(text);
                     if(!tipSuperf.contains(text)){
                       tipSuperf.add(text);
                    }
                    break;
                case "tipSuport":
                    tree.setTipSuport(text);
                     if(!tipSuport.contains(text)){
                        tipSuport.add(text);
                     }
                    break;
                case "cobertaEscocell":
                    tree.setCobertaEscocell(text);
                     if(!cobertaEscocell.contains(text)){
                       cobertaEscocell.add(text);
                     }
                    break;
                case "midaEscocell":
                    tree.setMidaEscocell(text);
                     if(!midaEscocell.contains(text)){
                        midaEscocell.add(text);
                     }
                    break;
                case "voraEscocell":
                    tree.setVoraEscocell(text);
                     if(!voraEscocell.contains(text)){
                       voraEscocell.add(text);
                    }
                    break;
           }
            added++;  //if added targets 23 means that the tree gots all text nodes
        }
        attribute = "";
    }
    
    
     @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //we only add one element to structure arraylist if that element wasn't previously added */
        openingElement = qName;
        if(!structure.contains(qName)){
            structure.add(qName);
            level.add(0);  //levels when added first time worths 0
        } 
        //when this conditional is produced, added returns to 0, means that a new tree start
        if(structure.size() > 1 && qName.equals(structure.get(1))){
            added = 0;
           
        }
        //we only get attributes from inside 'arbres' elements.
        if(structure.indexOf(qName) > 1){
            attribute = qName;
        }
    }
    
    
    @Override
    public void endElement(String string, String string1, String qName) throws SAXException {
      /*In order to present a tabulated structure, we verify if between actual element
        and previous element with same name there is or not different elements (childs actually). If
        there is different elements between, then we add space to childs. We use an Integer arraylist
        to save the level of the childs, and later, in getStructure getter, we process the tabulations based
        on these level values*/
      /*Unfortunely, we wasn't able to make this process work for xml with different structure than actual one. 
      The algorithm should be revised to accomplish an universal xml estructure getter*/
           if(qName.equals(structure.get(0))){
               for(int i = 1; i < structure.size(); i++){
                 level.set(i, level.get(i) + 1);
               }
           }
           else if(openingElement.equals(qName)){
               numberChilds++;
           }
           else if(!openingElement.equals(qName)){   //significa que han terminado los hijos y cierra el padre
               
               int pos1 = structure.indexOf(qName) + 1;  //tomamos posicion del padre que cierra
              
               for(int i = pos1; i < pos1 + numberChilds; i++){  //pos1 posicion primer hijo, 
                 level.set(i, level.get(pos1 - 1) + 1);
                   
               }
               numberChilds = 0;
           } 
        //At this point, we add a new tree to total trees. Its added if qName equals structure.get(1), "arbre")
        if(qName.equals(structure.get(1))){
            totalTrees++;
            if(added == 23){ //We add only if added equals 23
              trees.add(tree.toString());
            }
        }
       
    }

    @Override
    public void endDocument() throws SAXException {
        //we use HashMap to store name of tag type and the related arraylist with its values
        hm = new HashMap<>();
        hm.put("tipusElement",tipusElement);
        hm.put("alcada",alcada);
        hm.put("categoriaArbrat",categoriaArbrat);
        hm.put("tipAigua",tipAigua);
        hm.put("tipReg",tipReg);
        hm.put("tipSuperf",tipSuperf);
        hm.put("tipSuport",tipSuport);
        hm.put("cobertaEscocell",cobertaEscocell);
        hm.put("midaEscocell",midaEscocell);
        hm.put("voraEscocell",voraEscocell);
        
    }

    @Override
    public void startDocument() throws SAXException {
         //we use the arraylists to store kind of parametric values
         tree = new Tree();
         tipusElement = new ArrayList<>();
         alcada= new ArrayList<>();
         categoriaArbrat = new ArrayList<>();
         tipAigua= new ArrayList<>();
         tipReg= new ArrayList<>();
         tipSuperf= new ArrayList<>();
         tipSuport= new ArrayList<>();
         cobertaEscocell= new ArrayList<>();
         midaEscocell= new ArrayList<>();
         voraEscocell = new ArrayList<>();
          
         
    }
    
    
    
}
