/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import models.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author usuario
 */

/*this handler is used on second part of option 4. It receives two params when instanced and searches
for trees that accomplish those parameters.
*/

public class Handler2 extends DefaultHandler {

    private String paramOption;
    private String paramValue;
    private ArrayList<String> trees;
    private String attribute;
    private String text;
    private boolean treeGotParam;
    private Tree tree;
    
    /**
     * Constructor of Handler2 class. Receives the type of parametric attribute and
     * the content to search for
     * @param paramOption String
     * @param paramValue String
     */
    public Handler2(String paramOption, String paramValue) {
        this.paramOption = paramOption;
        this.paramValue = paramValue;
        trees = new ArrayList<>();  
    }
    
    /**
     * Returns arraylist with all trees with required values
     * @return ArrayList String
     */
    public ArrayList<String> getResults() {
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
                     if(addTree("tipusElement",text)){
                       treeGotParam = true;
                     }
                    break;
                case "espaiVerd":
                    tree.setEspaiVerd(text2);
                    break;
                case "adreca":
                    tree.setAdreca(text2);
                    break;
                case "alcada":
                    tree.setAlcada(text);
                    if(addTree("alcada",text)){
                       treeGotParam = true;
                     }
                    break;
                case "catEspecieId":
                    tree.setCatEspecieId(Integer.parseInt(text));
                    break;
                case "nomCientific":
                    tree.setNomCientific(text2);
                    break;
                case "nomEsp":
                    tree.setNomEsp(text);
                    break;
                case "nomCat":
                    tree.setNomCat(text);
                    break;
                case "categoriaArbrat":
                    tree.setCategoriaArbrat(text);
                    if(addTree("categoriaArbrat",text)){
                       treeGotParam = true;
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
                     if(addTree("tipAigua",text)){
                       treeGotParam = true;
                     }
                    break;
                case "tipReg":
                    tree.setTipReg(text);
                    if(addTree("tipReg",text)){
                       treeGotParam = true;
                     }
                    break;
                case "tipSuperf":
                    tree.setTipSuperf(text);
                    if(addTree("tipSuperf",text)){
                       treeGotParam = true;
                     }
                    break;
                case "tipSuport":
                    tree.setTipSuport(text);
                    if(addTree("tipSuport",text)){
                       treeGotParam = true;
                     }
                    break;
                case "cobertaEscocell":
                    tree.setCobertaEscocell(text);
                    if(addTree("cobertaEscocell",text)){
                       treeGotParam = true;
                     }
                    break;
                case "midaEscocell":
                    tree.setMidaEscocell(text);
                    if(addTree("midaEscocell",text)){
                       treeGotParam = true;
                     }
                    break;
                case "voraEscocell":
                    tree.setVoraEscocell(text);
                    if(addTree("voraEscocell",text)){
                       treeGotParam = true;
                     }
                    break;
           }
        }
        attribute = "";
    }
    
   
    /**
     * Method that verifies if the params are right and returns a boolean
     * @param option String
     * @param value String
     * @return boolean
     */
    boolean addTree(String option, String value){
        if(paramOption.equals(option) && paramValue.equals(value)){
            return true;
        }
        return false;
    }

    @Override
    public void endElement(String string, String string1, String qName) throws SAXException {
        //We add a new tree to total trees. Its added if qName equals "arbre" and includes the required param value)
        if(qName.equals("arbre")){
            if(treeGotParam){
              trees.add(tree.toString());
            }
        }
    }

    @Override
    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        attribute = qName;
        if(qName.equals("arbre")){
            treeGotParam = false;
        }
    }

    @Override
    public void endDocument() throws SAXException {
       
    }

    @Override
    public void startDocument() throws SAXException {
        tree = new Tree();
    }
    
    
}
