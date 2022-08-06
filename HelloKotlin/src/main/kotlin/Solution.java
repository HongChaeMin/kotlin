import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int solution(int[] s) {
        int p = 0;
        for (int i = 0; i < s.length; i++) {
            int check = 75 / s.length * 100;
            if (check == 25) {
                p = i;
                break;
            }
        }
        if (p == 0) return -1;

        List<Integer> list = new ArrayList<>();
        for (int i = p; i < s.length; i++) {
            list.add(s[i]);
        }
        return list.isEmpty() ? -1 : list.get(0);
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
