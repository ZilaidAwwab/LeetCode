class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = {}

        for i in nums:
            if i in count:
                count[i] += 1
            else:
                count[i] = 1
        return max(count, key=count.get)


# Same appraoch as above but less efficient
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = {}

        res, maxCount = 0, 0
        for n in nums:
            count[n] = 1 + count.get(n, 0)
            res = n if count[n] > maxCount else res
            maxCount = max(count[n], maxCount)
        return res


# The edge case appraoch required in the question (without using the hashmap)
# Boyer-Moore Approach
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        res, count = 0, 0

        for n in nums:
            if count == 0:
                res = n
            count += 1 if n == res else -1
        return res
