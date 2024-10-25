package com.itvedant.Meetingcalander;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingJpa extends JpaRepository<Meeting, Long> {
    List<Meeting> findByParticipantsContaining(String participant);
}
