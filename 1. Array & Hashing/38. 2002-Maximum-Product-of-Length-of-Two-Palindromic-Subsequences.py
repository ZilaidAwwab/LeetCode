class Solution:
    def maxProduct(self, s: str) -> int:
        N, palindrome = len(s), {}  # bitmask : length

        for mask in range(1, 1 << N):  # 1 << N == 2 ** N
            subsequence = ""
            for i in range(N):
                if mask & (1 << i):
                    subsequence += s[i]
            if subsequence == subsequence[::-1]:
                palindrome[mask] = len(subsequence)

        res = 0
        for m1 in palindrome:
            for m2 in palindrome:
                if m1 & m2 == 0:
                    res = max(res, palindrome[m1] * palindrome[m2])
        return res
