class Solution:
    def partitionString(self, s: str) -> int:
        curSet = set()
        res = 0

        for c in s:
            if c in curSet:
                res += 1
                curSet = set()
            curSet.add(c)
        return res
