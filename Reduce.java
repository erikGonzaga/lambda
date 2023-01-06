import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Reduce {

    public static void main(String[] args) {
        String frase = "Concatenacao com reduce";
        String[] split = frase.split(" ");
        List<String> listString = Arrays.asList(split);

    // FUNCOES DE ACUMULACAO.

        // Reduce > Soma - (1 + 2 + 3 + 4 + 5 + 6)
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> soma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        // Reduce > Multiplicação
        Optional<Integer> multiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplicacao.get());

        // Reduce > Concatenação
        Optional<String> concatenacao = listString.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concatenacao.get());

        // Reduce > Math.min
        OptionalDouble reduce = DoubleStream.of(1.5, 2.7, 5.3)
                .reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println(reduce);

        // Função Associativa

        // Reduce - Subtração (Não indicado por nao ser Parelelo,
        // ou seja, não obteremos o mesmo resultado. Como no exemplo).

        /*  Associativa:    1 - 2 - 3 - 4 - 5 - 6   = -19
            Paralela:       (1-2) - (3-4) - (5-6)   = -3      */

        Optional<Integer> subtracao = list.stream()
                .reduce((n1,n2) -> n1 - n2);
        System.out.println(subtracao);

        //////////////////////////////////////////////////////////////

    // VALOR DE IDENTIDADE
        // * Valor que se somado ou multiplicado
        // por outro o resultado será ele mesmo;
        // Ex.: 1+0 = 1 ou 9+0 = 0 ou 1*5 = 5 ou 20*1 = 20

        // Reduce > Soma
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);
        Integer soma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma2);

        // Reduce > Multiplicação
        Integer multiplicacao2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplicacao2);

        // Reduce > Concatenação
        String concatenacao2 = listString.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concatenacao2);

        // Reduce > Math.min
        double reduce2 = DoubleStream.of(1.5, 2.7, 5.3)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(reduce);

    // FUNCAO DE COMBINACAO

        // Reduce - Soma
        Integer soma3 = list.stream()
                .reduce(0,(n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma3);

        // Reduce - map + combiner

        Optional<String> reduce3 = list.stream()
                .map(n1 -> n1.toString())
                .reduce((n1, n2) -> n1.concat(n2));
        System.out.println(reduce3);

        // Map + Combiner (de Forma mais performatica)

        String reduce4 = list.stream()
                .reduce("",(n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2));
        System.out.println(reduce4);
    }
}










