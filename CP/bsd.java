import java.io.*;
import java.util.*;
import static java.lang.System.out;

class bsd {
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int e = 0; e < t; e++){
            out.println("test case : " + e);
            int n = Integer.parseInt(br.readLine()); 
            int k = 0;

            if(n < 3){
                k = 0;
            }else{
            	   StringTokenizer st = new StringTokenizer(br.readLine());
                   long a = 0;
                   long a1 = Long.parseLong(st.nextToken());
                   //out.println(a1);
                   int  i = 0;

            	
                  for(i = 1; i < n; i++){
                   a = Long.parseLong(st.nextToken());
                   //out.println(a);
                   if(a1 < a){
                       a1 = a;
                   }else if(a1 == a){
                       a1 = a;
                       if(st.hasMoreTokens()){
                            a = Long.parseLong(st.nextToken());
                            //out.println(a+ "....");
                               i++;
                               if(a1 > a){
                                   k++;
                               }
                               a1 = a;
                       }
                   }else{
                       a1 = a;
                       k++;
                   }
                }
            }
          
            out.println(k);
        }
    }
}
