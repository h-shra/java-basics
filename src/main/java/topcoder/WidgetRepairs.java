package topcoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class WidgetRepairs {
    //{ 10, 0, 0, 4, 20 }
    //8
    //Returns: 6

    public int days(int[] workload, int capacity) {
        if (capacity == 0) {
            return 0;
        }
        //if workload is all 0, return 0

        Integer cap = capacity;
        List<Integer> workloadList = IntStream.of(workload).boxed().collect(Collectors.toList());
        Integer rollOverWidgets = 0;
        int idleDays = 0;
        for (Integer dayWorkload : workloadList) {
            dayWorkload = dayWorkload + rollOverWidgets;
            if (dayWorkload == 0) {
                idleDays++;
            }
            if (dayWorkload > cap) {
                rollOverWidgets = dayWorkload - cap;
            } else {
                rollOverWidgets = 0;
            }
        }
        int extraDays = 0;
        if (rollOverWidgets > 0) { //12
            extraDays = (int) Math.ceil(rollOverWidgets.doubleValue() / cap.doubleValue());
        }

        return workloadList.size() - idleDays + extraDays;
    }

}
