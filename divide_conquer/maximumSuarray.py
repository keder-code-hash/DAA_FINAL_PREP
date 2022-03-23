import sys
def max_crossing_subarray(A,low,mid,high):
    left_sum=-sys.maxsize
    sum=0
    for i in range(mid,low-1,-1):
        sum=sum+A[i]
        if sum>left_sum:
            left_sum=sum
            left_index=i
    sum=0
    right_sum=-sys.maxsize
    for j in range(mid+1,high+1):
        sum=sum+A[j]
        if sum>right_sum:
            right_sum=sum
            right_index=j
    return left_index,right_index,left_sum+right_sum
def max_subarray(A,low,high):
    if high<=low:
        return low,high,A[low]
    else:
        mid=int((low+high)/2)
        left_low,left_high,left_sum=max_subarray(A,low,mid)
        right_low,right_high,right_sum=max_subarray(A,mid+1,high)
        cross_low,cross_high,cross_sum=max_crossing_subarray(A,low,mid,high)
        if left_sum>=right_sum and left_sum>=cross_sum:
            return left_low,left_high,left_sum
        elif left_sum<=right_sum and cross_sum<=right_sum:
            return right_low,right_high,right_sum
        else:
            return cross_low,cross_high,cross_sum
print(max_subarray([13,-3,-2,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7],0,15))