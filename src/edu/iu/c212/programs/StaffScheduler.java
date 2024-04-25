package edu.iu.c212.programs;

import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class StaffScheduler {

    public static void main(String[] args) {
        new StaffScheduler().scheduleStaff();
    }

    public void scheduleStaff() {
        try {
            List<Staff> staffList = FileUtils.readStaffFromFile();
            Map<String, String> shifts = FileUtils.readShiftSchedulesFromFile();
            Map<String, List<String>> schedule = createSchedule(staffList, shifts);

            FileUtils.writeStoreScheduleToFile(parseSchedule(schedule));
        } catch (IOException e) {
            System.err.println("Error in scheduling staff: " + e.getMessage());
        }
    }

    private Map<String, List<String>> createSchedule(List<Staff> staff, Map<String, String> shifts) {
        Map<String, List<String>> schedule = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : shifts.entrySet()) {
            String day = entry.getKey();
            List<String> availableStaffNames = new ArrayList<>();
            for (Staff s : staff) {
                if (s.getAvailability().contains(day)) {
                    availableStaffNames.add(formatStaffName(s.getName()));
                }
            }
            Collections.sort(availableStaffNames);
            schedule.put(day, availableStaffNames);
        }
        return schedule;
    }

    private String formatStaffName(String fullName) {
        String lastNameInitial = fullName.substring(fullName.lastIndexOf(' ') + 1, fullName.lastIndexOf(' ') + 2);
        return fullName.substring(0, fullName.lastIndexOf(' ')) + " " + lastNameInitial;
    }

    private List<String> parseSchedule(Map<String, List<String>> s) {
        List<String> schedule = new ArrayList<String>();

        for(Map.Entry<String, List<String>> entry : s.entrySet())
        {
            String temp;
            temp = entry.toString().replace("=", "");
            schedule.add(temp);
        }
        return schedule;
    }
}
