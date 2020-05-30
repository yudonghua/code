import java.io.BufferedReader;  
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class Command {  
    public static void exeCmd(String commandStr) {  
        BufferedReader br = null;  
        try {  
            System.out.println("111111");
            Process p = Runtime.getRuntime().exec(commandStr);  
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n");  
            }  
            System.out.println(sb.toString());  
        } catch (Exception e) { 
            System.out.println("222222");
            e.printStackTrace();  
        }   
        finally  
        {  
            if (br != null)  
            {  
                try {  
                    br.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
  
    public static void main(String[] args) {
        String commandStr = null;
        try {
            commandStr = URLEncoder.encode("什么", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        Command.exeCmd(commandStr);

        System.out.println(commandStr);
    }  
} 