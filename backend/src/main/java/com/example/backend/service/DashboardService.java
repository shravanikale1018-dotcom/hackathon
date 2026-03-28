package com.example.backend.service;

import com.example.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final TaskRepository taskRepository;

    public DashboardService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Map<String, Long> getDashboardData() {

        Map<String, Long> data = new HashMap<>();

        long totalTasks =
                taskRepository.count();

        long completedTasks =
                taskRepository.findByStatus("Completed").size();

        long pendingTasks =
                taskRepository.findByStatus("Pending").size();

        data.put("totalTasks", totalTasks);
        data.put("completedTasks", completedTasks);
        data.put("pendingTasks", pendingTasks);

        return data;
    }
}