class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        valuesMap = {}

        for i, n in enumerate(nums):
            diff = target - n
            if diff in valuesMap:
                return [valuesMap[diff], i]
            valuesMap[n] = i
