class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res, cur, num_letters = [], [], 0

        def justify(cur, num_letters, maxWidth):
            if not cur:
                return []
            if len(cur) == 1:
                return [cur[0] + " " * (maxWidth - len(cur[0]))]

            extra_spaces = maxWidth - num_letters
            spaces = [" "] * (len(cur) - 1)
            remaining_spaces = extra_spaces % (len(cur) - 1)
            equal_spaces = extra_spaces // (len(cur) - 1)
            for i, space in enumerate(spaces):
                spaces[i] = " " * (equal_spaces + (1 if i < remaining_spaces else 0))
            return [
                "".join(word + space for space, word in zip(spaces, cur[:-1])) + cur[-1]
            ]

        for w in words:
            if num_letters + len(w) + len(cur) > maxWidth:
                res.extend(justify(cur, num_letters, maxWidth))
                cur, num_letters = [], 0
            cur.append(w)
            num_letters += len(w)

        if cur:
            last_line = " ".join(cur) + " " * (maxWidth - num_letters - len(cur) + 1)
            res.append(last_line)

        return res
