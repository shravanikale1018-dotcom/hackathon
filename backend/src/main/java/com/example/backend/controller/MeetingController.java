package com.example.backend.controller;

import com.example.backend.model.Meeting;
import com.example.backend.service.MeetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
@CrossOrigin
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping
    public Meeting createMeeting(
            @RequestBody Meeting meeting) {

        return meetingService.createMeeting(meeting);
    }

    @GetMapping
    public List<Meeting> getAllMeetings() {
        return meetingService.getAllMeetings();
    }
}