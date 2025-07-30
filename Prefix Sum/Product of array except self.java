public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] answer = new int[n];
    
    // Left products (prefix products)
    left[0] = 1;
    for (int i = 1; i < n; i++) {
        left[i] = left[i-1] * nums[i-1];
    }
    /*
    DRY RUN - LEFT PRODUCTS:
    nums = [1, 2, 4, 6]
    
    Initialize: left[0] = 1
    
    i=1: left[1] = left[0] * nums[0] = 1 * 1 = 1
    i=2: left[2] = left[1] * nums[1] = 1 * 2 = 2
    i=3: left[3] = left[2] * nums[2] = 2 * 4 = 8
    
    After left pass: left = [1, 1, 2, 8]
    */
    
    // Right products (suffix products)
    right[n-1] = 1;
    for (int i = n-2; i >= 0; i--) {
        right[i] = right[i+1] * nums[i+1];
    }
    /*
    DRY RUN - RIGHT PRODUCTS:
    nums = [1, 2, 4, 6]
    
    Initialize: right[3] = 1
    
    i=2: right[2] = right[3] * nums[3] = 1 * 6 = 6
    i=1: right[1] = right[2] * nums[2] = 6 * 4 = 24
    i=0: right[0] = right[1] * nums[1] = 24 * 2 = 48
    
    After right pass: right = [48, 24, 6, 1]
    */
    
    // Combine left and right products
    for (int i = 0; i < n; i++) {
        answer[i] = left[i] * right[i];
    }
    /*
    DRY RUN - COMBINING:
    left = [1, 1, 2, 8]
    right = [48, 24, 6, 1]
    
    i=0: answer[0] = 1 * 48 = 48
    i=1: answer[1] = 1 * 24 = 24
    i=2: answer[2] = 2 * 6 = 12
    i=3: answer[3] = 8 * 1 = 8
    
    Final answer: [48, 24, 12, 8]
    */
    
    return answer;
}
