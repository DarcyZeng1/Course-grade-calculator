
public class ValidInput{

    public boolean checkValidility(String input){
        boolean valid = true;
        try{
            Double.valueOf(input);
        }catch(Exception e){
            System.out.println("Incorrect Input format. Enter the weight of grade in number. Ex: 70");
            valid = false;
        }
        return valid;
    }
}
