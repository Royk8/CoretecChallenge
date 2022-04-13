package coretecchallenge;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Roy K. Maestre
 */
public class CoretecChallenge {

    /**
     * Create a K-long arrayList with random generated strings with length between 4 and 26 characters 
     * Characters are always different from each other.
     * @param K: length of the arrayList returned
     * @return ArrayList with k names.
     */
    public ArrayList<String> generateNames(int K){
        Random rnd = new Random();
        String[] abc = "abcdefghijklmnopqrstuvwxyz".split("");
        ArrayList<String> generated = new ArrayList();       
        
        for(int i = 0; i < K; i++){
            int L = rnd.ints(1,4,26).findFirst().getAsInt();
            String name = "";
            for(int j = 0; j < L; j++){
                int r = rnd.ints(1,0,26).findFirst().getAsInt();
                String newLetter = abc[r];
                if(!name.contains(newLetter)){
                    name += newLetter;
                }else{
                    j--;
                }
            }
            if(!generated.contains(name)){
                generated.add(name);
            }else{
                i--;
            }            
        }        
        return generated;
    }
    
    /**
     * Create a K-long arrayList with random generated strings with length of L characters
     * Characters are always different from each other.
     * @param K: length of the arrayList returned
     * @param L: length of the arrayList strings generated
     * @return ArrayList with k string with lenght L.
     */
    public ArrayList<String> generateNames(int K, int L){
        ArrayList<String> generated = new ArrayList();   
        if(L > 26){
            System.out.println("There isn't enough letters to generate names this long. "
                    + "Please choose an L smaller than 27");
            return generated;
        }        
        Random rnd = new Random();
        String[] abc = "abcdefghijklmnopqrstuvwxyz".split("");     
        
        for(int i = 0; i < K; i++){
            String name = "";
            for(int j = 0; j < L; j++){
                int r = rnd.ints(1,0,26).findFirst().getAsInt();
                String newLetter = abc[r];
                if(!name.contains(newLetter)){
                    name += newLetter;
                }else{
                    j--;
                }
            }
            if(!generated.contains(name)){
                generated.add(name);
            }else{
                i--;
            }            
        }        
        return generated;
    }

    public static void main(String[] args) {
        CoretecChallenge challenge = new CoretecChallenge();
        ArrayList<String> names = challenge.generateNames(10,50);
        for(String name: names){
            System.out.println(name);
        }
    }
    
    //35 Minutes
    // + more time commenting.
    
}
