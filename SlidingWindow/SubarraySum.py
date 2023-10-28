def subarray_sum(arr, target_sum):
    window_sum = 0
    left, right = 0, 0

    while right < len(arr):
        window_sum += arr[right]

        while window_sum > target_sum:
            window_sum -= arr[left]
            left += 1

        if window_sum == target_sum:
            return arr[left:right + 1]

        right += 1

    return None  # If no subarray is found with the target_sum

arr = [1, 2, 3, 4, 5]
target_sum = 9
result = subarray_sum(arr, target_sum)
print(result)  # Output: [2, 3, 4]
