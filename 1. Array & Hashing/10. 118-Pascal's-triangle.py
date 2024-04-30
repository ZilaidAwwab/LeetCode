class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]

        for i in range(numRows - 1):
            # Here we are creating a temporary array
            temp = [0] + res[-1] + [0]

            # This is now the next row that we actually want to build
            row = []

            # Here len(res[-1]) is equal to the lenght of previous row, and as we wanted the next row to be greater by 1 in size to the previous so we added + 1 with it
            for j in range(len(res[-1]) + 1):
                row.append(temp[j] + temp[j + 1])
            res.append(row)
        return res
