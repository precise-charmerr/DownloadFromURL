import java.io.*;
import java.net.URL;
public class Main{
    public static void URLDnldFile(URL urlink, String fileName) throws IOException{
        try (InputStream inp = urlink.openStream();
             BufferedInputStream bis = new BufferedInputStream(inp);
             FileOutputStream fops = new FileOutputStream(fileName)){

            byte[] d = new byte[1024];
            int i;
            while ((i = bis.read(d, 0, 1024)) != -1){
                fops.write(d, 0, i);
            }
        }
        System.out.print("Download complete!!");
    }
    public static void main(String[] args) throws Exception{
//        System.out.println("Call this method when you want your application to have this.")
        String link = "https://main.icmr.nic.in/sites/default/files/reports/Mental_Health.pdf";
        File out = new File("java.pdf");
        URL url = new URL(link);
        URLDnldFile(url, String.valueOf(out));
    }
}