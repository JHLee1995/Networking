
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class a {
    public static void main(String[] args) throws IOException {
    	 ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = br.readLine();
            if (s.indexOf("time.html") != -1) {
                getHtml(socket);
            } else if(s.indexOf("servertime")){
                getValue(socket);
            }else {
            	get404(socket);
            }
        }
    }

    public static void getHtml(Socket socket) throws IOException {
        File file = new File("time.html");
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = new FileInputStream(file);
        in.read(filecontent);
        in.close();
        String f = new String(filecontent);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("HTTP/1.1 200 OK\n");
        bw.write("Content-Type: text/html\n\n");
        bw.write(f);
        bw.close();
    }

    public static void getValue(Socket socket) throws IOException {
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //JSON ba;
        String t2 = "" + System.currentTimeMillis();
        String t3 = "" + System.currentTimeMillis();
        bw1.write("HTTP/1.1 200 OK\n");
        bw1.write("Content-Type: application/json\n\n");
        char j = 34;
        String json = "" + '{' + j + "t2" + j + ':' + t2 + ',' + j + "t3" + j + ':' + t3 + '}';
        bw1.write(json);
        bw1.close();
        socket.close();
    }
    public static void get404(Socket socket) throws IOException {
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw1.write("HTTP/1.1 404 Not Found\n");
        bw1.write("Content-Type: text/html\\n\\n");
        String json ="404 not found";
        bw1.write(json);
        bw1.close();
        socket.close();
    }
}
