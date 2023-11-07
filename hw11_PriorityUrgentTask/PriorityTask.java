package org.example.hw11_PriorityUrgentTask;

import java.util.Date;

public class PriorityTask extends Task {
    private final int requiredPriority;

    public PriorityTask(String title, Date deadline, int priority, double reward, int requiredPriority) {
        super(title, deadline, priority, reward);
        this.requiredPriority = requiredPriority;
    }
    @Override
    public double calculatePayment(){
       if (requiredPriority == getPriority()){
        return super.calculatePayment();
       }
      return 0;
    }
}
