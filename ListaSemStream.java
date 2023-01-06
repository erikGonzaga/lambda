import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ListaSemStream {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Erik");
        nomes.add("Edney");
        nomes.add("Abner");
        nomes.add("Daniel");

        LocalTime now = LocalTime.now();

        var inicioStream1 = System.currentTimeMillis();

        for (int i = 0 ; i < nomes.size(); i++){
            var nome = nomes.remove(i).toUpperCase();
            nomes.add(i, nome);
            System.out.println(nome);
            var terminoStream1 = System.currentTimeMillis();

            System.out.println(terminoStream1 - inicioStream1);
        }
    }
}
