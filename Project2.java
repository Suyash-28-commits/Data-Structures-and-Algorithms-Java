import java.util.*;
public class Project2 {
    static class TeacherInfo{
        static HashMap<String,String> map = new HashMap<>();
        static ArrayList<ArrayList<String>> period = new ArrayList<>();
        static class Teacher{
            String name;
            String subject;
    
            Teacher(String name,String subject){
                this.name = name;
                this.subject = subject;
            }
        }

        //add infortmation of teacher
        public static void addInfo(String name,String subject,ArrayList<String>sub){
            Teacher teacher = new Teacher(name,subject);
            map.put(teacher.subject,teacher.name);
            period.add(sub);    
        }

        public static void printInfo(String name,String subject){
            for(String key : map.keySet()){
                if(key == subject && map.get(key) == subject){
                    
                }
            }

        }

    }
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to our software: ");
            System.out.println("Our software provides the following information:");
            System.out.println("1. Add Teacher's information");
            System.out.println("2. Enter to see Teacher's information");
            System.out.println("3. Enter to see the current class of teacher: ");
            System.out.print("enter your choice(1-3)");
            int choice = sc.nextInt();

            switch(choice){
                case 1: System.out.print("Enter Teacher's Name:");
                String name = sc.nextLine();
                System.out.println("Enter teacher's subject: ");
                String subject = sc.nextLine();

                TeacherInfo t = new TeacherInfo();
                
            }



        }


    }
    
}
