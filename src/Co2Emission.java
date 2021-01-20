import java.util.*;
import java.io.*;
public class Co2Emission{
    public static List<Transportation> transp=new ArrayList<>();
    public static Map<String,String> parameters=new HashMap<>();


    public static void initialize(){
      
        transp.add(new Transportation("small-diesel-car",142));
        transp.add(new Transportation("small-petrol-car",154));
        transp.add(new Transportation("small-plugin-hybrid-car",73));
        transp.add(new Transportation("small-electric-car",50));

        transp.add(new Transportation("medium-diesel-car",171));
        transp.add(new Transportation("medium-petrol-car",192));
        transp.add(new Transportation("medium-plugin-hybrid-car",110));
        transp.add(new Transportation("medium-electric-car",58));

        transp.add(new Transportation("large-diesel-car",209));
        transp.add(new Transportation("large-petrol-car",282));
        transp.add(new Transportation("large-plugin-hybrid-car",126));
        transp.add(new Transportation("large-electric-car",73));

        transp.add(new Transportation("bus",27));

        transp.add(new Transportation("train",6));
    }
    public static void Map_parameters(){
        parameters.put("transportation-method","");
        parameters.put("distance","");
        parameters.put("unit-of-distance","km");//default value is km
        parameters.put("output","");//default value is ""
        return;
    } 

    public static void parse_parameters() {    
        Map_parameters();   
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("$ ./co2-calculator ");
        try{
        String tokens=br.readLine().trim();
        //Termination Condition 
        if(tokens.equalsIgnoreCase("q")||tokens.equalsIgnoreCase("quit")){
            System.exit(0);
        }
        if(tokens.length()==0){
            return;
        }

        String []token=tokens.split("--");
        for(int i=1;i<token.length;i++){
            token[i]=token[i].replaceAll("=", " ");
            String[] pair=token[i].split("\\s+");
            String key=pair[0].trim();
            String value=pair[1].trim();
            if(parameters.containsKey(key)){
                parameters.put(key, value);
            }
            else{
                System.out.println("Invalid Command");
                return ;
            }
        }
    }catch(Exception e){
        //System.out.println("Invalid Command" +e); 
        System.out.println("Invalid Command"); 
        return ;
    }
     if(parameters.get("output").length()==0){
         String outputin= parameters.get("unit-of-distance").equals("km") ?"kg":"g";
         //System.out.println(outputin);
         parameters.put("output", outputin);
     }
       //check if output parameter has correct value
     if(!parameters.get("output").equals("g") && !parameters.get("output").equals("kg")){
         System.out.println("Invalid Command:Invalid output parameter");
         return;
     }
       //check if unit-of-distance has correct value
     if(!parameters.get("unit-of-distance").equals("m") && !parameters.get("unit-of-distance").equals("km")){
        System.out.println("Invalid Command:Invalid unit-of-distance parameter");
        return;
    }
    //check if the distance has valid value
    if(parameters.get("distance").length()>0){ 
    try{
        Double.parseDouble(parameters.get("distance"));
    }
    catch(NumberFormatException ne){
        System.out.println("Invalid Command: Non-Number value passed for distance");
        return;
    }
   }
    

     //System.out.println(parameters);
     int flag=0;
     if(parameters.get("transportation-method").length()>1 && parameters.get("distance").length()>1 && parameters.get("unit-of-distance").length()>=1){
         for(Transportation t:transp){
             if(t.getMethod_Name().equals(parameters.get("transportation-method"))){
                 flag=1;
                 double answer=0.00;
                 answer=t.getCo2Emmission(Double.parseDouble(parameters.get("distance")),parameters.get("unit-of-distance"),parameters.get("output"));
                 String formattedAnswer=(answer==(long)answer)?String.format("%d",(long)answer):String.format("%.1f", answer);
                 System.out.println("Your trip caused "+formattedAnswer+""+parameters.get("output")+" of CO2-equivalent.");;
                 return;
             }
         }
         if(flag==0){
             System.out.println("Invalid Command: transportation-method not exist");
             return;
         }
     }
     else{
         System.out.println("Invalid Command");
         return;
     }

    }
    public static void main(String[] args) {
        System.out.println("Co2Emission Calculator");
        initialize();
        Map_parameters();
        while(true){
        parse_parameters();
        }
        
    }
}
