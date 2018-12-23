/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbcn;

import controller.Handler;
import controller.Handler2;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author alu2017454
 */
public class ArbolesBcn {

    //handler used for three first and part of fourth option of activity
    static Handler reader;
  
    
    public static void main(String[] args) {
        
        startHandler();
         int option;
        do{
            showMenu();
            option = inputMethods.askInt("Select an option:");
            
            switch(option){
                case 1:
                    showStructure();
                    break;
                case 2:
                    totalTrees();
                    break;
                case 3:
                    treesAllData();
                    break;
                case 4:
                    parametricOptions();
                    break;
                case 0:
                    System.out.println("Leaving application");
                    break;
                default:
                    System.out.println("Option not allowed");
                      
            }
        }while(option != 0);
    }
    
    public static void startHandler(){
        try {
            //creation of object SAXParser to read into XML document
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            reader = new Handler();
            parser.parse(new File("datos.xml"), reader);
          } catch (ParserConfigurationException | SAXException ex) {
                 System.out.println("Error: " + ex.getMessage());

          } catch (IOException ex) {
            Logger.getLogger(ArbolesBcn.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    /**
     * Shows the tabulated structure of the xml file.
     */
    public static void showStructure() {
        List<String> structure = reader.getStructure();
        System.out.println("Structure of XML:");
        for(String index: structure) {
            System.out.println(index);
        }
    }
    
    /**
     * Returns the total number of trees in the xml file.
     */
    public static void totalTrees(){
        System.out.println(reader.getTotalTrees());
    }
    /**
     * Returns data from the trees with non void values
     */
    public static void treesAllData() {
       List<String> trees = reader.getCompletTrees();
       int totalTrees = 0;
       for(String index: trees) {
           System.out.println(index);
           totalTrees++;
       }
        System.out.println(totalTrees + " with all data.");
    }
    
    /**
     * Method for option four. Search trees by parameter
     */
    public static void parametricOptions() {
        //First we ask the user to select param Option and param Value. 
        String option = getParamOpt();
        List<String> results = reader.getParamData(option);
        String value = getParamValues(results);
        //After that, the handler is instanced with those two values
        Handler2 reader2 = new Handler2(option, value);
        
        try {
           //creation of object SAXParser to read into XML document
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new File("datos.xml"), reader2);
           
          } catch (ParserConfigurationException | SAXException ex) {
                 System.out.println("Error: " + ex.getMessage());

          } catch (IOException ex) {
            Logger.getLogger(ArbolesBcn.class.getName()).log(Level.SEVERE, null, ex);
          }
        //After the successful parse of the xml file, we get all the trees accomplishing the requirements.
        List<String> trees = reader2.getResults();
        for(String index: trees){
            System.out.println(index);
        }
        System.out.println("Found " + trees.size() + " trees with value " + value + " in attribute "+
                option);
        
        
    }
    /**
     * Method for selection of parameter from tree
     * @param results
     * @return 
     */
    public static String getParamValues(List results) {
        int option;
        do{
            System.out.println("\n*** Parametrical values ***");
            for(int i=0, j=1; i < results.size(); i++, j++){
              System.out.println(j + ". " + results.get(i));
            }
            option = inputMethods.askInt("Select option to show trees with that value");
        }while(option < 1 || option > results.size());
         System.out.println("You selected " + results.get(option-1));
         String selected = results.get(option-1).toString();
         return selected; 
     }
    
    /**
     * Method for selection of parametrical type
     * @return String
     */
     public static String getParamOpt(){
        String[] options = {"tipusElement","alcada","categoriaArbrat","tipAigua", "tipReg",
                         "tipSuperf","tipSuport","cobertaEscocell","midaEscocell","voraEscocell"};
        int option;
        do{
            System.out.println("\n*** Parametrical attributes ***");
            for(int i=0, j=1; i < options.length; i++, j++){
              System.out.println(j + ". " + options[i]);
            }
            option = inputMethods.askInt("Select option");
        }while(option < 1 || option > options.length);
         System.out.println("You selected " + options[option-1]);
        return options[option-1]; 
    }
    
    
    
    public static void showMenu(){
        
        System.out.println("\n*** SAX. Arboles Barcelona ***");
        System.out.println("1. Show file XML structure ");
        System.out.println("2. Number of registered trees");
        System.out.println("3. Show only trees with ALL data registered");
        System.out.println("4. Show parametric options for trees and select one of them");
        System.out.println("0. Exit");
    }
    
    
}
