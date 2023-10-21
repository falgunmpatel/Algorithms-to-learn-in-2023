def bead_sort(a, length):
	# Find the maximum element
	maximum = a[0]
	for i in range(1, length):
		if a[i] > maximum:
			maximum = a[i]

	# allocating memory
	beads = [[0 for i in range(maximum)] for j in range(length)]

	# mark the beads
	for i in range(length):
		for j in range(a[i]):
			beads[i][j] = 1

	# move down the beads
	for j in range(maximum):
		sum = 0
		for i in range(length):
			sum += beads[i][j]
			beads[i][j] = 0
		for i in range(length-1, length-sum-1, -1):
			beads[i][j] = 1

	# to get sorted array
	result = [0] * length
	for i in range(length):
		sum = 0
		for j in range(maximum):
			sum += beads[i][j]
		result[i] = sum
	return result


print("The sorted array is : ", end="")
result = bead_sort([3, 1, 4, 1, 5], 5)
for i in range(0, len(result)):
print(result[i], end=" ")