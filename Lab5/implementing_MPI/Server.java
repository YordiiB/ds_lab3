import java.io.*;
import java.net.*;
public class Server
{
PrintStream out=null;
BufferedReader in=null;
BufferedReader br=null;
String str="";
public Server()throws IOException
{
ServerSocket ss=new ServerSocket(7000);
System.out.println("Server Started");
Socket s = ss.accept();
out = new PrintStream(s.getOutputStream());
in = new BufferedReader(new InputStreamReader(s.getInputStream()));
br = new BufferedReader(new InputStreamReader(System.in));
String str;
while(s!=null)
{
System.out.println("Select the operation to be performed");
System.out.println("1. To send message without any response
MPI_send");
System.out.println("2. To send message with response
MPI_sendrecv");
System.out.println("3. To receive message MPI_recv");
System.out.println("4. To end the program");
str = br.readLine();
out.println(str);
if(str.equals("1"))
{
MPI_send();
}
else if(str.equals("2"))
{
MPI_sendrec();
}
else if(str.equals("3"))
{
MPI_recv();
}
else
break;
}
}
