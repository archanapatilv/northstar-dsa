package org.northstar.dsa;

public class JumpGameII {
    public static int jump(int[] nums) {
        int result = 0;
        //have window initialised for (kind of) BFS, right is meant to have the farthest position we
        // can jump
        int  left = 0, right = 0, n = nums.length;
        while (right < n -1) { //Did we reach destination?
            int farthest = 0;
            //include the right value as well
            for(; left < right + 1; left++) {
                farthest = Math.max(farthest, left + nums[left]);
            }
            left = right + 1;
            right = farthest;
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(jump( new int[]{2, 3, 1, 1, 4}));
    }
}
