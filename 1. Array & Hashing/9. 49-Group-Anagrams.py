class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)

        for s in strs:
            count = [0] * 26

            for n in s:
                count[ord(n) - ord("a")] += 1

            result[tuple(count)].append(s)

        return result.values()
