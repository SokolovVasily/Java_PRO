package org.example.hw11_PriorityUrgentTask;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("HW1", new Date(), 1, 500);
        UrgentTask urgentTask = new UrgentTask("HW2", 300);
        PriorityTask priorityTask = new PriorityTask("HW3", new Date(), 2, 400, 2);

        TaskManager<Task> taskManager = new TaskManager<>();
        taskManager.addTask(task);
        taskManager.calculateTotalPayment();
        taskManager.addTask(urgentTask);
        taskManager.addTask(priorityTask);
        taskManager.calculateTotalPayment();
    }

}
