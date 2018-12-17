import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    String imie;
    String nazwisko;
    String numerIndeksu;
    List<Integer> oceny=new ArrayList<Integer>();

    public Student(String imie, String nazwisko, String numerIndeksu, List<Integer> oceny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerIndeksu = numerIndeksu;
        this.oceny = oceny;
    }
    public void dodajOcene(int ocena){
        this.oceny.add(ocena);
    }
    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numerIndeksu='" + numerIndeksu + '\'' +
                ", oceny=" + oceny.toString() +
                '}';
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public List<Integer> getOceny() {
        return oceny;
    }
}
