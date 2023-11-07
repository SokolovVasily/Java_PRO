package org.example.hw11_PriorityUrgentTask;

import java.util.LinkedList;
import java.util.List;

public class TaskManager<T extends Task> {
    private final List< T > taskList = new LinkedList<>();
    public void addTask(T task) {
        taskList.add(task);
        System.out.println("Task add in List");
    }
    public void calculateTotalPayment(){
        double n = 0;
        for (T task : taskList){
            n = n + task.calculatePayment();
        }
        System.out.println("TotalPayment / Полная стоимость : " + n);
    }
}

