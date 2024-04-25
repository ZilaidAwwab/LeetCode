class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:

        rightMax = -1

        # These 3 arguments corresponds to the starting point of iteration, increment, and stoping point

        # Here if the array size is 5, it will start from 4, then increment -1 down (3, 2, 1, 0), then stops before -1 (i-e: 0)
        for i in range(len(arr) - 1, -1, -1):

            # The max function compares 2 values here, although it can compare 2 lists, tuples etc as well
            newMax = max(rightMax, arr[i])
            arr[i] = rightMax
            rightMax = newMax
        return arr
