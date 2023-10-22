package io.sim3;

public class Rotas {
    //private int id;
    //private double  depart;
    private String id;
    private String depart;
    Rotas(int i){

        /*for(int i=0;i<998;i++){
            depart = i + 0.00;
            id = i;
            //converter para  string 
        }*/
        //int j= (String)i;
        //i = 1 + 700;
        id = Integer.toString(i);
        depart = Integer.toString(i) + "0.0";
    }
    public void CriaRota(int i){
        //id = Integer.toString(i);
        //depart = Integer.toString(i) + "0.0";
    }
    public String getId(){
        return id;
    }
    public String getDepart(){
        return depart;
    }
    
}
