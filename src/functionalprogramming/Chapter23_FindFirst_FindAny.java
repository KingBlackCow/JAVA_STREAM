package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter23_FindFirst_FindAny {
    public static void main(String[] args) {
        Optional<Integer> nums = Stream.of(3, -4, 2, 7, 9)
                .filter(x -> x<0)
                .findAny();
        System.out.println(nums.get());
        Optional<Integer> first = Stream.of(3, -4, 2, 7, 9)
                .filter(x -> x > 0)
                .findFirst();
        System.out.println(first.get());

    }
}
