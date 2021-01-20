
public class Transportation{
    private String Method_Name;
    private int  Emission_Value;
 
    public Transportation(String Method_Name,int Emission_Value){
        this.Method_Name=Method_Name;
        this.Emission_Value=Emission_Value;
    }
 
 
    public String getMethod_Name(){
        return Method_Name;
    }
    public void setMethod_Name(String Method_Name){
        this.Method_Name=Method_Name;
    }
    public int getEmission_Value (){
        return Emission_Value;
    }
    public void setEmission_Value(int Emission_Value){
        this.Emission_Value=Emission_Value;
    }
    public String toString(){
        return "Transportation Method : "+getMethod_Name()+" "+getEmission_Value()+"\n";
    }
    
    public double getCo2Emmission(double distance,String unitofdistance,String output){
        double result=0.00;
        if(unitofdistance.equals("km") && output.equals("kg")){
            result=distance*(Emission_Value/1000.0);
        }
        else if(unitofdistance.equals("km") && output.equals("g")){
            result=distance*Emission_Value;
        }
        else if(unitofdistance.equals("m") && output.equals("kg"))
        {
            result=(distance/1000.0)*(Emission_Value/1000.0);
        }
        else if(unitofdistance.equals("m") && output.equals("g")){
            result=(distance/1000.0)*(Emission_Value);
        }
        else{
            System.out.println("Invalid Command ");
            System.exit(0);
        }
        return result;

    }
    
 }