import java.util.*;
public class Nibhendra {
    // public static String period(String name,int time){
    //     ArrayList<String> sub = new ArrayList<>();


    // }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> t = new HashMap<>();
        t.put("AM","Charu Gupta");
        t.put("PC","Charu Gupta");
        t.put("AP","Arvind Sharma");
        t.put("EVS","Liza Sharma");

        System.out.println("Welcome to our software");
        System.out.print("Please enter Teacher's name: ");
        String name = sc.nextLine();
        System.out.print("Please enter Teacher's subject: ");
        String sub = sc.nextLine();


        ArrayList<ArrayList<String>> info = new ArrayList<>();
        ArrayList<String> EVS = new ArrayList<>();
        ArrayList<String> AP = new ArrayList<>();

        EVS.add("Liza Sharma");
        EVS.add("CSE-A");
        EVS.add("IT-B");
        EVS.add("Lab");
        EVS.add("Cabin");

        AP.add("Arvind Sharma");
        AP.add("LAb");
        AP.add("CSE-B");
        AP.add("IT-C");
        AP.add("Cabin");

        info.add(EVS);
        info.add(AP);
        
        if(t.containsKey(sub)){
            System.out.println("Please look at the following time table:");
            System.out.println("Please enter the number corresponding to the time");
            System.out.println("9:30- 10:20 -> 1");
            System.out.println("10:20 -> 11:10 -> 2");
            System.out.println("11:10 - 12:00 -> 3");
            System.out.println("12:00 - 12:50 -> 4");
            System.out.println("enter time:");
            int time = sc.nextInt();


            for(int i = 0; i<info.size();i++){
                ArrayList<String> element = info.get(i);
                if(element.get(0) == t.get(sub)){
                    System.out.println(element.get(0)+" is in "+element.get(time));
                }
            }
            

        }else{

        }
    
        


        
        
        
    }


}
