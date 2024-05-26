class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        i, res = 0, 0
        while i < len(nums):
            count = 0
            while i < len(nums) and nums[i] == 0:
                count += 1
                i += 1
                res += count

            i += 1

        return res


# Other Method
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        res, count = 0, 0
        for i in range(len(nums)):
            if nums[i] == 0:
                count += 1
            else:
                count = 0
            res += count

        return res
