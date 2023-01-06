import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ListaComStream {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Erik");
        nomes.add("Edney");
        nomes.add("Abner");
        nomes.add("Daniel");

        LocalTime now = LocalTime.now();

        var inicioStream1 = System.currentTimeMillis();

        return nomes.forEach(nome -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(nome);
            var terminoStream1 = System.currentTimeMillis();

            System.out.println(terminoStream1 - inicioStream1);
        };
    }
}

