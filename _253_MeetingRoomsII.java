//Time  : nlogn whre n is number of Meetings
//space : o(n)
//Approach : sort intervals based on start time an dstore elemet end time in heap, if new start time is greater than pq peek end time then add poll and add
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b) ->  a[0] - b[0]);

        Queue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals){

            int start = interval[0];
            int end = interval[1];

            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }

            pq.add(end);

        }

        return pq.size();
    }
}
