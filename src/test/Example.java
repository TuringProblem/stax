import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        // converting @see nums -> into a List using Streams
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Collections.shuffle(numList);
        System.out.println(numList);

        for (int n : nums) {
            System.out.printf("%d", n);

        }

    }
}
