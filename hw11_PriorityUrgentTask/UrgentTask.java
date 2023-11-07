package org.example.hw11_PriorityUrgentTask;

import java.util.Date;

public class UrgentTask extends Task{
    public UrgentTask(String title,  double reward) {
        super(title, new Date(), 1, reward);
    }


}
