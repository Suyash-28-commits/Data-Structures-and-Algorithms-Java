import java.util.*;
public class DehliMetro {
    static class MetroNetwork{
        static class Edge{
            String src;
            String dest;

            public Edge(String s,String d){
                this.src = s;
                this.dest = d;
            }
        }

        static class Path{
            //long and short bothh are keywords in java
            String s; //short path
            String l; //long path

            public Path(String s,String l){
                this.s = s;
                this.l = l;
            }
        }
        
        //Graph using Edge List
        static LinkedList<Edge>graph = new LinkedList<>();
        public static void createNetwork(){
            //Red Line
            graph.add(new Edge("Shaheed Sthal","Hindon River")); //Shaheed Sthal
            graph.add(new Edge("Hindon River","Arthala")); //Hindon River
            graph.add(new Edge("Hindon River","Shaheed Sthal"));

            graph.add(new Edge("Arthala","Mohan Nagar")); //Arthala
            graph.add(new Edge("Arthala","Hindon River"));

            graph.add(new Edge("Mohan Nagar","Shyam Park"));//Mohan Nagar
            graph.add(new Edge("Mohan Nagar","Arthala"));

            graph.add(new Edge("Shyam Park","Major Mohit Sharma Rajendra Nagar")); //Shyam Park
            graph.add(new Edge("Shyam Park","Mohan Nagar"));

            graph.add(new Edge("Major Mohit Sharma Rajendra Nagar","Raj Bagh"));//Major Mohit Sharma Rajendra Nagar
            graph.add(new Edge("Major Mohit Sharma Rajendra Nagar","Shya, Park"));

            graph.add(new Edge("Raj Bagh","Shaheed Nagar")); //Raj Bagh
            graph.add(new Edge("Raj Bagh","Major Mohit Sharma Rajendra Nagar"));

            graph.add(new Edge("Shaheed Nagar","Dilshad Garden"));//Shaheed Nagar
            graph.add(new Edge("Shaheed Nagar","Raj Bagh"));

            graph.add(new Edge("Dilshad Garden","Jhilmil")); //Dilshad Garden
            graph.add(new Edge("Dilshad Garden","Shaheed Nagar"));

            graph.add(new Edge("Jhilmil","Mansarovar Park"));//Jhilmil
            graph.add(new Edge("Jhilmil","Dilshad Garden"));

            graph.add(new Edge("Mansarovar Park","Shahdra"));//Mansarovar Park
            graph.add(new Edge("Mansarovar Park","Jhilmil"));

            graph.add(new Edge("Shahdra","Welcome"));//Shahdra
            graph.add(new Edge("Shahdra","Mansarovar Park"));

            graph.add(new Edge("Welcome","Shahdra"));//Welcome
            graph.add(new Edge("Welcome","Jafrabad"));
            graph.add(new Edge("Welcome","East Azad Nagar"));
            graph.add(new Edge("Welcome","Seelampur"));
            
            graph.add(new Edge("Seelampur","Welcome"));//Seelmapur
            graph.add(new Edge("Seelampur","Shastri Park"));

            graph.add(new Edge("Shastri Park","Seelampur"));//Shastri Park
            graph.add(new Edge("Shastri Park","Kashmere Gate"));

            graph.add(new Edge("Kashmere Gate","Shastri Park"));//Kashmere Gate
            graph.add(new Edge("Kashmere Gate","Tis Hazari"));
            graph.add(new Edge("Kashmere Gate","Civil Lines"));
            graph.add(new Edge("Kashmere Gate","Chandini Chowk"));
            graph.add(new Edge("Kashmere Gate","Lal Quila"));

            graph.add(new Edge("Tis Hazari","Pulbangash")); //Tis Hazari
            graph.add(new Edge("Tis Hazari","Kashmere Gate"));

            graph.add(new Edge("Pulbangash","Tis Hazari")); //Pulbangash
            graph.add(new Edge("Pulbangash","Pratap Nagar"));

            graph.add(new Edge("Paratap Nagar","Shastri Nagar"));//Pratap Nagar
            graph.add(new Edge("Paratap Nagar","Pulbangash"));

            graph.add(new Edge("Shastri Nagar","Inderlok"));//Shastri Nagar
            graph.add(new Edge("Shastri Nagar","Pratap Nagar"));

            graph.add(new Edge("Inderlok","Shastri Nagar"));//Inderlok
            graph.add(new Edge("Inderlok","Kanhaiya Nagar"));
            graph.add(new Edge("Inderlok","Ashok Park Main"));

            graph.add(new Edge("Kanhaiya Nagar","Inderlok"));//Kanhaiya Nagar
            graph.add(new Edge("Kanhaiya Nagar","Keshav Puram"));

            graph.add(new Edge("Keshav Puram","Kanhaiya Nagar")); //Keshav Puram
            graph.add(new Edge("Keshav Puram","Netaji Subhash Place"));

            graph.add(new Edge("Netaji Subhash Place","Keshav Puram"));//Netaji Subhash Place
            graph.add(new Edge("Netaji Subhash Place","Kohat Enclave"));
            graph.add(new Edge("Netaji Subhash Place","Shakurpur"));
            graph.add(new Edge("Netaji Subhash Place","Shalimar Bagh"));

            graph.add(new Edge("Kohat Enclave","Netaji Subhash Place"));//Kohat Enclave
            graph.add(new Edge("Kohat Enclave","Pitampura"));

            graph.add(new Edge("Pitampura","Rohini East"));//Pitampura
            graph.add(new Edge("Pitampura","Kohat Enclave"));

            graph.add(new Edge("Rohini East","Pitampura"));//Rohini East
            graph.add(new Edge("Rohini East","Rohini West"));

            graph.add(new Edge("Rohini West","Rithala")); //Rohini West
            graph.add(new Edge("Rohini West","Rithala"));

            graph.add(new Edge("Rithala","Rohini West")); //Rithala

            //Blue Line
            graph.add(new Edge("Vaishali","Kaushambi")); //Vaishali

            graph.add(new Edge("Kaushambi","Vaishali"));//Kaushambi
            graph.add(new Edge("Kaushambi","Anand Vihar"));

            graph.add(new Edge("Anand Vihar","Kaushambi")); //Anand Vihar
            graph.add(new Edge("Anand Vihar","Karkardooma"));
            graph.add(new Edge("Anand Vihar","IP Extension"));

            graph.add(new Edge("Karkardooma","Anand Vihar"));//Karkardooma
            graph.add(new Edge("Karkardooma","Preet Vihar"));
            graph.add(new Edge("Karkardooma","Karkardooma Court"));

            graph.add(new Edge("Preet Vihar","Karkardooma"));//Preet Vihar
            graph.add(new Edge("Preet Vihar","Nirman Vihar"));

            graph.add(new Edge("Nirman Vihar","Laxmi Nagar")); //Nirman Vihar
            graph.add(new Edge("Nirman Vihar","Preet Vihar"));

            graph.add(new Edge("Laxmi Nagar","Yamuna Bank")); //Laxmi Nagar
            graph.add(new Edge("Laxmi Nagar","Nirman Vihar"));

            graph.add(new Edge("Yamuna Bank","Laxmi Nagar")); //Yamuna Bank
            graph.add(new Edge("Laxmi Nagar","Akshardham"));
            graph.add(new Edge("Laxmi Nagar","Indraprastha"));

            graph.add(new Edge("Akshardham","Yamuna Bank")); //Akshardham
            graph.add(new Edge("Akshardham","Mayur Vihar 1"));

            graph.add(new Edge("Mayur Vihar 1","Askshardham")); //Mayur Vihar - 1
            graph.add(new Edge("Mayur Vihar 1","Mayur Vihar Pocket 1"));
            graph.add(new Edge("Mayur Vihar 1","Ashram"));
            graph.add(new Edge("Mayur Vihar 1","Mayur Vihar Extension"));

            graph.add(new Edge("Mayur Vihar Extension","Mayur Vihar 1"));//Mayur Vihar Extension
            graph.add(new Edge("Mayur Vihar Extension","New Ashok Nagar"));

            graph.add(new Edge("New Ashok Nagar","Mayur Vihar Extension"));//New Ashok Nagar
            graph.add(new Edge("New Ashok Nagar","Noida Sector 15"));

            graph.add(new Edge("Noida Sector 15","Noida Sector 16"));//Noida Sector 15
            graph.add(new Edge("Noida Sector 15","Ashok Nagar"));

            graph.add(new Edge("Noida Sector 16","Noida Sector 15"));//Noida Sector 16
            graph.add(new Edge("Noida Sector 16","Noida Sector 18"));

            graph.add(new Edge("Noida Sector 18","Botanical Garden"));//Noida Sector 18
            graph.add(new Edge("Noida Sector 18","Noida Sector 16"));

            graph.add(new Edge("Botanical Garden","Noida Secor 18")); //Botanical Garden
            graph.add(new Edge("Botanical Garden","Okhla Bird Sanctury"));
            graph.add(new Edge("Botanical Garden","Golf Course"));

            graph.add(new Edge("Golf Course","Botanical Garden"));//Golf Course
            graph.add(new Edge("Golf Course","Sector-34 Noida"));

            graph.add(new Edge("Sector-34 Noida","Golf Course")); //Sector-34 Noida
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));
            graph.add(new Edge("F","B"));

        







        }

        public static HashMap<String,Integer> allPaths = new HashMap<>();

        public static void printAllPaths(String curr,HashMap<String,Boolean>vis,String path,String tar){
            if(curr == tar){//Base Case
                //->when current vertex upon traversing becomes equal to target vertex
                //shows that targer vertex has reached
                //print all the paths
                allPaths.put(path,path.length());
                return;
            }
    
            for(int i = 0; i<graph.size();i++){
                Edge e = graph.get(i);
                if(e.src == curr){
                    if(!vis.get(e.dest)){//if current nod's neighbour's are not visited
                      vis.put(e.src,true); //make current vertex visited
                      
                      //function call to traverse further
                      printAllPaths(e.dest, vis, path+"->"+e.dest, tar);
                    }      
                }     
            }
            //Backtracking ->>> steps
            //make current vertex visited earlier to not visited
            //all vertex can be visited more than once
            vis.put(curr,false);
        }

        public static Path showPath(HashMap<String,Integer>map,String shortPath,String longPath){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(Map.Entry<String,Integer> e: map.entrySet()){
                if(e.getValue()> max){
                    max = e.getValue();
                }else{
                    min = e.getValue();
                }
            }

            for(Map.Entry<String,Integer> m: map.entrySet()){
                if(m.getValue() == min){
                    shortPath = m.getKey();
                }
                if(m.getValue() == max){
                    longPath = m.getKey();
                }
            }

            Path path = new Path(shortPath, longPath);
            return path;
        }

        

        public static void main(String[]args){
            HashMap<String,Boolean> vis = new HashMap<>();
            createNetwork();
            vis.put("A",false);
            vis.put("B",false);
            vis.put("C",false);
            vis.put("D",false);
            vis.put("E",false);
            vis.put("F",false);

            printAllPaths("F", vis,"F","E");
            System.out.println();
            System.out.println("Short path");
            System.out.println(showPath(allPaths,"","").s);
            System.out.println("Long Path:");
            System.out.println(showPath(allPaths,"","").l);
        }
        



        




        

    }
    
}
