class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        nums1Set, nums2Set = set(nums1), set(nums2)
        res1, res2 = set(), set()

        for i in nums1:
            if i not in nums2:
                res1.add(i)

        for i in nums2:
            if i not in nums1:
                res2.add(i)

        return [list(res1), list(res2)]
