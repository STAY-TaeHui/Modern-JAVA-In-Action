package ch05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TraderTransactionTest
{
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Trader> traders = List.of(raoul, mario, alan, brian);

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    @DisplayName("2011년에 일어난 모든 트랜잭션을 찾아 오름차순 정렬")
    @Test
    void practice1()
    {
        // given
        List<Transaction> collect = transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
        // when

        // then
        assertThat(collect).hasSize(2);
    }

    @DisplayName("거래자가 근무하는 모든 도시를 중복없이 나열")
    @Test
    void practice2()
    {
        // given

        // when
        List<String> tradersCity = traders.stream()
            .map(Trader::getCity)
            .distinct()
            .collect(Collectors.toList());

        // then
        assertThat(tradersCity).hasSize(2);
    }

    @DisplayName("Cambridge의 모든 거래자를 찾아 이름으로 정렬.")
    @Test
    void practice3()
    {
        // given

        // when
        List<Trader> collect = traders.stream()
            .filter(t -> "Cambridge".equals(t.getCity()))
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());

        // then
        assertThat(collect.get(0).getName()).isEqualTo("Alan");
    }
}
