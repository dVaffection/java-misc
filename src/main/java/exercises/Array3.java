package exercises;

import java.util.ArrayList;

public class Array3 {

    /**
     * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one
     * side is equal to the sum of the numbers on the other side.
     */
    public boolean canBalance(int[] nums) {
        // 1. define middle index
        // 2. split and canBalanceCmp sum
        // 3. go to either side and try 2 again

        int middle = (int) Math.floor(nums.length);

        for (int i = middle; i < nums.length; i++) {
            boolean is = canBalanceCmp(nums, i);
            if (is) {
                return true;
            }
        }

        for (int i = 0; i < middle; i++) {
            boolean is = canBalanceCmp(nums, i);
            if (is) {
                return true;
            }
        }

        return false;
    }

    private boolean canBalanceCmp(int[] nums, int index) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < index; i++) {
            leftSum += nums[i];
        }

        for (int i = index; i < nums.length; i++) {
            rightSum += nums[i];
        }

        return leftSum == rightSum;
    }

    /**
     * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner
     * appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact
     * that both arrays are already in sorted order.
     */
    public boolean linearIn(int[] outer, int[] inner) {
        int counter = 0;

        for (int o = 0, i = 0; o < outer.length; o++) {
            if (i == inner.length) {
                break;
            }

            if (outer[o] < inner[i]) {
                continue;
            }

            if (outer[o] == inner[i]) {
                counter++;
                i++;
            }
        }

        return counter == inner.length;
    }

    /**
     * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array,
     * the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is
     * length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
     */
    public int maxMirror(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        ArrayList<ArrayList<Integer>> container = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentSection = new ArrayList<Integer>();

        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] == prev + 1) || (nums[i] == prev - 1)) {
                // if it the very first apply
                if (currentSection.size() == 0) {
                    currentSection.add(prev);
                }
                currentSection.add(nums[i]);

            } else if (currentSection.size() > 0) {
                // when we don't find a contiguous number, start new section
                // and current section goes to the container
                container.add((ArrayList<Integer>) currentSection.clone());
                currentSection.clear();
            }

            prev = nums[i];
        }

        if (currentSection.size() > 0) {
            container.add(currentSection);
        }


        // now let's find out the largest section
        int largestSectionIndex = 0;
        int largestSectionSize = 0;
        for (int i = 0; i < container.size(); i++) {
            if (container.get(i).size() > largestSectionSize) {
                largestSectionSize = container.get(i).size();
                largestSectionIndex = i;
            }
        }

        if (container.size() == 0) {
            return 0;
        } else {
            return container.get(largestSectionIndex).size();
        }
    }


}
