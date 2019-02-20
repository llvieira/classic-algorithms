import java.util.ArrayList;
import java.util.PriorityQueue;

/**
* Get maximum amount of meetings which fit a specific time.
* 
* We have two options to solve this problem:
* 1 - sort the input array  O(nlogn)
* 2 - use a min heap instead of a sorted array O(n + klogn)
*/
public class MeetingOptimizer {

    public ArrayList<Meeting> optimizeMeetings(ArrayList<Meeting> meetings, int hrs) {
        PriorityQueue<Meeting> queue = new PriorityQueue<>();

        for (Meeting m : meetings) {
            queue.add(m);
        }

        ArrayList<Meeting> result = new ArrayList<>();
        int totalHrs = 0;

        while (totalHrs + queue.peek().hrs <= hrs) {
            Meeting meeting = queue.poll();
            totalHrs += meeting.hrs;
            result.add(meeting);
        }

        return result;
    }

    public static void main(String[] args) {
        MeetingOptimizer mo = new MeetingOptimizer();

        ArrayList<Meeting> arr = new ArrayList<>();
        arr.add(new Meeting(5));
        arr.add(new Meeting(3));
        arr.add(new Meeting(2));
        ArrayList<Meeting> result = mo.optimizeMeetings(arr, 8);

       for (Meeting m : result) {
           System.out.println(m.hrs);
       }
    }
}

class Meeting implements Comparable<Meeting> {
    public int hrs;

    public Meeting(int hrs) {
        this.hrs = hrs;
    }

    @Override
    public int compareTo(Meeting meeting) {
        if (this.hrs > meeting.hrs) {
            return 1;
        } else if (this.hrs < meeting.hrs) {
            return -1;
        }

        return 0;
    }    
}
