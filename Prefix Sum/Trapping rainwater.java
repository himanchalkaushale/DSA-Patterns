public int trap(int[] height) {
    if (height == null || height.length == 0) return 0;
    
    int n = height.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    int water = 0;
    
    // Calculate left maximum for each position
    leftMax[0] = height[0];
    /*
    DRY RUN - LEFT MAX:
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    
    i=0: leftMax[0] = height[0] = 0
    i=1: leftMax[1] = max(leftMax[0], height[1]) = max(0,1) = 1
    i=2: leftMax[2] = max(1,0) = 1
    i=3: leftMax[3] = max(1,2) = 2
    i=4: leftMax[4] = max(2,1) = 2
    i=5: leftMax[5] = max(2,0) = 2
    i=6: leftMax[6] = max(2,1) = 2
    i=7: leftMax[7] = max(2,3) = 3
    i=8: leftMax[8] = max(3,2) = 3
    i=9: leftMax[9] = max(3,1) = 3
    i=10: leftMax[10] = max(3,2) = 3
    i=11: leftMax[11] = max(3,1) = 3
    
    Final leftMax = [0,1,1,2,2,2,2,3,3,3,3,3]
    */
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i-1], height[i]);
    }
    
    // Calculate right maximum for each position
    rightMax[n-1] = height[n-1];
    /*
    DRY RUN - RIGHT MAX:
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    
    i=11: rightMax[11] = height[11] = 1
    i=10: rightMax[10] = max(rightMax[11], height[10]) = max(1,2) = 2
    i=9: rightMax[9] = max(2,1) = 2
    i=8: rightMax[8] = max(2,2) = 2
    i=7: rightMax[7] = max(2,3) = 3
    i=6: rightMax[6] = max(3,1) = 3
    i=5: rightMax[5] = max(3,0) = 3
    i=4: rightMax[4] = max(3,1) = 3
    i=3: rightMax[3] = max(3,2) = 3
    i=2: rightMax[2] = max(3,0) = 3
    i=1: rightMax[1] = max(3,1) = 3
    i=0: rightMax[0] = max(3,0) = 3
    
    Final rightMax = [3,3,3,3,3,3,3,3,2,2,2,1]
    */
    for (int i = n-2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i+1], height[i]);
    }
    
    // Calculate trapped water at each position
    /*
    DRY RUN - WATER CALCULATION:
    leftMax = [0,1,1,2,2,2,2,3,3,3,3,3]
    rightMax = [3,3,3,3,3,3,3,3,2,2,2,1]
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    
    i=0: water += min(0,3)-0 = 0
    i=1: water += min(1,3)-1 = 0
    i=2: water += min(1,3)-0 = 1
    i=3: water += min(2,3)-2 = 0
    i=4: water += min(2,3)-1 = 1
    i=5: water += min(2,3)-0 = 2
    i=6: water += min(2,3)-1 = 1
    i=7: water += min(3,3)-3 = 0
    i=8: water += min(3,2)-2 = 0
    i=9: water += min(3,2)-1 = 1
    i=10: water += min(3,2)-2 = 0
    i=11: water += min(3,1)-1 = 0
    
    Total water = 0+0+1+0+1+2+1+0+0+1+0+0 = 6
    */
    for (int i = 0; i < n; i++) {
        water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    
    return water; // Returns 6 for the example input
}
