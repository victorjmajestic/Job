/**
 * Victor Majestic
 * An interface that represents a schedule metric.
 */

public interface ScheduleMetric {
  
  /**
   * A method stub that schedules a job.
   * @param s the schedule.
   * @param j the job.
   */
  public boolean scheduleJob(Schedule s, Job j);

}