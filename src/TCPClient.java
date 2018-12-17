import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String argv[]) {
        try {
            Student student = null;
            int ocena;
            Scanner scanner = new Scanner(System.in);
            String sentence;
            String modifiedSentence;
            //BufferedReader inFromUser = new BufferedReader;
            Socket clientSocket = new Socket("localhost", 6790);
            //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Połączło się");
            System.out.println("Podaj Numer Indeksu Studenta");
            sentence = scanner.nextLine();
            System.out.println(sentence);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(sentence+"\n");


            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
            student = (Student) inputStream.readObject();

            System.out.println(student.toString());
            System.out.println("Jeśli chcesz dopisać ocenę wpisz T");

            sentence = scanner.nextLine();
            if (sentence.equals("T")) {
                System.out.println("Podaj ocenę");
                ocena = scanner.nextInt();
                student.dodajOcene(ocena);
            }
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(student);

            clientSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
