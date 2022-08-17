import java.util.*;
import java.util.ArrayList;
import java.io.*;


public class trabalho {
    public static void main(String[] args) {
             File arquivo = new File("C:\\trabalho.txt");
            Scanner in = new Scanner(System.in);
            ArrayList<String> linhas = new ArrayList<>();
            ArrayList<String[]> principal = new ArrayList<>();
            ArrayList<String> uniao = new ArrayList<>();
            ArrayList<String> inter = new ArrayList<>();
            ArrayList<String> diferenca = new ArrayList<>();
            ArrayList<String> cartesiano = new ArrayList<>();

            

            try{
                in = new Scanner(arquivo);
                while(in.hasNextLine()){
                    String linhaArquivo = new String();
                    linhaArquivo = in.nextLine();
                    linhas.add(linhaArquivo.toString().replace(" ", ""));
                    
                }
            } catch(Exception error) {

            }
            
            for(int i = 0; i < linhas.size();i++) {
                principal.add(linhas.get(i).split(","));
            }
            
            for(int i = 0; i < linhas.size(); i++){
                String a = principal.get(i)[0];
                if( a.equals("U") || a.equals("I") || a.equals("D")|| a.equals("C")){
                    
                
                    if(principal.get(i)[0].equals("U")){
                        for(int j= 0; j < principal.get(i+1).length; j++) {
                            uniao.add(principal.get(i+1)[j]);
                        }
                        for(int y = 0; y < principal.get(i+2).length; y++){
                            uniao.add(principal.get(i+2)[y]);
                        }
                        for(int m = 0; m < principal.get(i+1).length; m++) {
                            for(int l = 0; l < principal.get(i+2).length; l++) {
                                if(principal.get(i+1)[m].equals(principal.get(i+2)[l])) {
                                    uniao.remove(principal.get(i+1)[m]);
                                }
                            }
                        }
                        
                        System.out.println("União: conjunto 1 - {" + linhas.get(i+1) + "} conjunto 2 - {" + linhas.get(i+2) + "} Resultado: " + uniao);
                        uniao.clear();
                    }
                    else if(principal.get(i)[0].equals("I")){
                        for(int m = 0; m < principal.get(i+1).length; m++) {
                            for(int n = 0; n < principal.get(i+2).length; n++) {
                                if(principal.get(i+1)[m].equals(principal.get(i+2)[n])) {
                                    inter.add(principal.get(i+1)[m]);
                                    
                                }
                                
                            }
                        }
                        System.out.println("Intersecção: conjunto 1 - {" + linhas.get(i+1) + "} conjunto 2 - {" + linhas.get(i+2) + "} Resultado: " + inter);
                        inter.clear();
                    } 
                    else if(principal.get(i)[0].equals("D")){
                        for(int j= 0; j < principal.get(i+1).length; j++) {
                            diferenca.add(principal.get(i+1)[j]);
                        }
                        for(int y = 0; y < principal.get(i+2).length; y++){
                        	diferenca.add(principal.get(i+2)[y]);
                        }
                        for(int q = 0; q < principal.get(i+1).length; q++) {
                            for(int e = 0; e < principal.get(i+2).length; e++) {
                                if(principal.get(i+1)[q] != (principal.get(i+2)[e])) {
                                    diferenca.remove(principal.get(i+2)[e]);
                                }
    
                            }
                        }
                        System.out.println("Diferença: conjunto 1 - {" + linhas.get(i+1) + "} conjunto 2 - {" + linhas.get(i+2) + "} Resultado: " + diferenca);
                        diferenca.clear();
                    }
                    else if(principal.get(i)[0].equals("C")){
                        for(int o = 0; o < principal.get(i+1).length; o++) {
                            for(int p = 0; p < principal.get(i+2).length; p++) {
            
                                cartesiano.add("(" + principal.get(i+1)[o] +"."+ principal.get(i+2)[p] + ")");
            
                            }
                        }
                        System.out.println("Cartesiano: conjunto 1 - {" + linhas.get(i+1) + "} conjunto 2 - {" + linhas.get(i+2) + "} Resultado: " + cartesiano);
                        cartesiano.clear();
                    }
                }
            }
        }
    }