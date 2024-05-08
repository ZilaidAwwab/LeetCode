class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        if len(words) != len(pattern):
            return False

        charToWords = {}
        wordsToChar = {}

        for char, word in zip(pattern, words):
            if char in charToWords and charToWords[char] != word:
                return False
            if word in wordsToChar and wordsToChar[word] != char:
                return False
            charToWords[char] = word
            wordsToChar[word] = char
        return True
