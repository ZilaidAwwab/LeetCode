class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        codeSet = set()

        for i in range(len(s) - k + 1):
            codeSet.add(s[i : i + k])

        return len(codeSet) == 2**k


# Same complexity, different approach
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        return len(set(s[i : i + k] for i in range(len(s) - k + 1))) == 2**k
