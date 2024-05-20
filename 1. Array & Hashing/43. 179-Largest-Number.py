class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        # with enumerate we get the value as well as the index
        for i, n in enumerate(nums):
            nums[i] = str(n)

        def compare(n1, n2):
            if n1 + n2 > n2 + n1:
                return -1
            else:
                return 1

        # Here we are sorting based on some confitions, that are passed on in the second argument. cmp_to_key is a built-in function

        nums = sorted(nums, key=cmp_to_key(compare))

        # "" is a delimiter, and here we are joining the strings of nums to this delimiter (we can also add every nums item individually to a list as well)
        return str(int("".join(nums)))
