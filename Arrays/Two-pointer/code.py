def find_pair_with_sum(nums, target):
    left, right = 0, len(nums) - 1

    while left < right:
        current_sum = nums[left] + nums[right]

        if current_sum == target:
            # We found a pair with the target sum
            return [nums[left], nums[right]]
        elif current_sum < target:
            # If the current sum is less than the target, move the left pointer to the right
            left += 1
        else:
            # If the current sum is greater than the target, move the right pointer to the left
            right -= 1

    # If no such pair is found, return None or an appropriate result
    return None

# Example usage
nums = [1, 2, 4, 7, 11, 15]
target = 9

result = find_pair_with_sum(nums, target)

if result:
    print("Pair found:", result[0], ",", result[1])
else:
    print("No pair found with the given sum.")
