class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;

        // Finding the upper bound without the need of sorting
        int maxSpeed = 0;
        for (int pile: piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        // Run Binary Search. 
        // Here, we dont do <= because we'll have to consider the maxSpeed for next operation as well
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (isHoursWithInRange(piles, h, mid)) {
                maxSpeed = mid;
                // which means, if hours is within range, then we still got some more time to reach 'h'.
                // So, we can slow down
            } else {
                // if estimated hours is high than 'h', we'll have to increase speed.
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    private boolean isHoursWithInRange(int[] piles, int h, int mid) {
        int hour = 0;
        for (int pile: piles) {
            // We need to get ceil value because of the condition::
            // you may finish eating the pile but you can not eat from another pile in the same hour. 
            hour += (int) Math.ceil((double) pile / mid);
        }

        // hour is valid only if <= given h value
        return hour <= h;
    }


}
