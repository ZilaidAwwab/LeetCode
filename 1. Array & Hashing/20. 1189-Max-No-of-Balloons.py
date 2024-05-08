class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        count = Counter(text)
        balloon = Counter("balloon")

        result = len(text)

        for n in balloon:
            result = min(result, count[n] // balloon[n])
        return result


# Using raw Python (more efficient)
class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        balloon_freq = {"b": 0, "a": 0, "l": 0, "o": 0, "n": 0}

        for char in text:
            if char in balloon_freq:
                balloon_freq[char] += 1

        balloon_freq["l"] //= 2
        balloon_freq["o"] //= 2

        return min(balloon_freq.values())
