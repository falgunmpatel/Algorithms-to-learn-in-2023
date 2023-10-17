# Brute-Force Approach
def max_subarray_sum_bruteforce(nums):
    max_sum = float('-inf')
    n = len(nums)

    for i in range(n):
        for j in range(i, n):
            total = sum(nums[i:j+1])
            max_sum = max(max_sum, total)

    return max_sum

# Improved Brute-Force Approach
def max_subarray_sum_improved_bruteforce(nums):
    max_sum = float('-inf')
    n = len(nums)

    for i in range(n):
        total = 0
        for j in range(i, n):
            total += nums[j]
            max_sum = max(max_sum, total)

    return max_sum

# Divide and Conquer Approach
def max_subarray_sum_divide_conquer(nums):
    def max_crossing_sum(nums, left, mid, right):
        left_sum = float('-inf')
        total = 0
        for i in range(mid, left - 1, -1):
            total += nums[i]
            left_sum = max(left_sum, total)

        right_sum = float('-inf')
        total = 0
        for i in range(mid + 1, right + 1):
            total += nums[i]
            right_sum = max(right_sum, total)

        return left_sum + right_sum

    def max_subarray_sum_helper(nums, left, right):
        if left == right:
            return nums[left]

        mid = (left + right) // 2

        left_sum = max_subarray_sum_helper(nums, left, mid)
        right_sum = max_subarray_sum_helper(nums, mid + 1, right)
        crossing_sum = max_crossing_sum(nums, left, mid, right)

        return max(left_sum, right_sum, crossing_sum)

    return max_subarray_sum_helper(nums, 0, len(nums) - 1)

# Kadane's Algorithm
def max_subarray_sum_kadane(nums):
    max_so_far = float('-inf')
    max_ending_here = 0

    for num in nums:
        max_ending_here = max(num, max_ending_here + num)
        max_so_far = max(max_so_far, max_ending_here)

    return max_so_far

if __name__ == "__main__":
    arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    print("Brute-Force Approach:", max_subarray_sum_bruteforce(arr))
    print("Improved Brute-Force Approach:", max_subarray_sum_improved_bruteforce(arr))
    print("Divide and Conquer Approach:", max_subarray_sum_divide_conquer(arr))
    print("Kadane's Algorithm:", max_subarray_sum_kadane(arr))
