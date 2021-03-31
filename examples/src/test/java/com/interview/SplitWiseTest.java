package com.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class SplitWiseTest {

    @Test
    void splitWiseTest() {
        Solution solution = new Solution();
        List<SplitWise> input = new ArrayList<>();
        input.add(new SplitWise("a", "b", 10));
        input.add(new SplitWise("b", "c", 20));
        input.add(new SplitWise("c", "a", 10));
        input.add(new SplitWise("d", "b", 10));

        log.info("Answer = {}",solution.splitWise(input));
    }

    public class Solution {
        public int splitWise(List<SplitWise> input) {
            Map<String, Integer> transactions = new HashMap<>();

            // First pass populate this map
            input.forEach(s -> {
                transactions.put(s.from, 0);
                transactions.put(s.to, 0);
            });

            // Second pass, record double entry
            input.forEach(s -> {
                transactions.put(s.from, transactions.get(s.from) + s.oweAmount);
                transactions.put(s.to, transactions.get(s.to) - s.oweAmount);
            });

            // count non-zero entries
            int nonZero = 0;
            for(int oweAmount : transactions.values()) {
                if (oweAmount != 0) {
                    nonZero ++;
                }
            }

            return nonZero - 1;

        }

    }

    @Data
    @AllArgsConstructor
    public class SplitWise {
        private String from;
        private String to;
        private int oweAmount;
    }

}
