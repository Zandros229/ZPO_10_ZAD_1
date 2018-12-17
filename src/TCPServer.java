import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {

    public static void main(String argv[]) {
        try {
            int index = 0;
            List<Student> list = new ArrayList<Student>();
            List<Integer> oceny = new ArrayList<Integer>();
            oceny.add(3);
            oceny.add(4);
            oceny.add(5);
            list.add(new Student("Adam", "Sylla", "123456", oceny));
            list.add(new Student("Jan", "Kowalski", "111111", oceny));
            list.add(new Student("Ernest ", "Figura", "222222", oceny));
            String temp;
            Student student = null;

            ServerSocket welcomeSocket = new ServerSocket(6790);
            while (true) {

                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Połączyło się");
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                temp=inFromClient.readLine();
                System.out.println(temp);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).numerIndeksu.equals(temp)) {
                        student = list.get(i);
                        index = i;
                        System.out.println("Znalazło obiekt");
                    }
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
                objectOutputStream.writeObject(student);
                ObjectInputStream inputStream = new ObjectInputStream(connectionSocket.getInputStream());
                list.set(index, (Student) inputStream.readObject());
                System.out.println("Zmieniło Obiekt");
                System.out.println(list.get(index).toString());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
