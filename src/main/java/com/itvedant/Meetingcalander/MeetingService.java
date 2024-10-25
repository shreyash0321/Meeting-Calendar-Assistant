package com.itvedant.Meetingcalander;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.stereotype.Service;


@Service
public class MeetingService {

    private final MeetingJpa meetingRepository;

    public MeetingService(MeetingJpa meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public void bookMeeting(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    public List<LocalDateTime> findAvailableSlots(String participant1, String participant2, int duration) {
        // Placeholder logic for finding available slots based on existing meetings
        return List.of(); // Returning an empty list as a placeholder
    }

    public List<Meeting> findConflictingMeetings(String participant) {
        return meetingRepository.findByParticipantsContaining(participant);
    }
}