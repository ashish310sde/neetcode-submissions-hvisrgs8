class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Creating map for storing frequency of each number in nums
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for(int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for(int i = freq.length - 1; i > 0; i--) {
            for(int n : freq[i]) {
                res[idx++] = n;

                if(idx == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
