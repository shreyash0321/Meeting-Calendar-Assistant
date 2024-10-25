package com.itvedant.Meetingcalander;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meetings")
public class Controller {

    private final MeetingService meetingService;

    public Controller(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("/book")
    public String bookMeeting(@RequestBody Meeting meeting) {
        meetingService.bookMeeting(meeting);
        return "Meeting booked successfully!";
    }

    @GetMapping("/available-slots")
    public List<LocalDateTime> findAvailableSlots(@RequestParam String participant1,@RequestParam String participant2,@RequestParam int duration) {
        return meetingService.findAvailableSlots(participant1, participant2, duration);
    }

    @GetMapping("/conflicts")
    public List<Meeting> checkConflicts(@RequestParam String participant) {
        return meetingService.findConflictingMeetings(participant);
    }
}