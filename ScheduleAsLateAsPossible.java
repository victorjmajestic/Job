public class ScheduleAsLateAsPossible implements ScheduleMetric {
  
  /**
   * A method that schedules a job.
   * First, check if the job can be completed after the start time and before the deadline.
   * Then, it checks if the job overlaps with any other job in the schedule.
   * @param schedule the schedule.
   * @param job the job.
   * @return true if all qualifications are met and the job is added successfully, false if it does not.
   */
  public boolean scheduleJob(Schedule schedule, Job job) {
    ScheduleSlot newjob = new ScheduleSlot(job, job.getEarliestStart());
    if ((job.getDuration() + newjob.getStartTime()) > job.getEarliestStart() && (job.getDuration() + newjob.getStartTime())
          < job.getDeadline()) {
      DLNode<ScheduleSlot> iterator = schedule.getBack();
    /* Cycles through each node backward until the first node is reached. */
      while (iterator != null) {
        if (job.getDuration() + newjob.getStartTime() == iterator.getElement().getJob().getEarliestStart() +
            iterator.getElement().getJob().getDuration()) {
          return false;
        }
        iterator = iterator.getPrevious();
      }
      schedule.addToBack(newjob);
      return true;
    }
    return false;
  }
}