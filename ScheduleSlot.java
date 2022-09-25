/**
 * Victor Majestic
 * A class that represents a schedule slot.
 */

public class ScheduleSlot {
  
  /** The job used to fill the slot in the schedule. */
  private Job job;
 
  /** The start time of the schedule slot. */
  private int startTime;
 
  /**
   * Create a schedule slot.
   * @param job adds the job.
   * @param startTime sets the start time of the schedule slot.
   */
  public ScheduleSlot(Job job, int startTime) {
    this.job = job;
    this.startTime = startTime;
  }
 
  /**
   * Returns the job in the schedule slot.
   * @return the job in the schedule slot.
   */
  public Job getJob() {
    return job;
  }
 
  /**
   * Returns the start time of the schedule slot.
   * @return the start time of the schedule slot.
   */
  public int getStartTime() {
    return startTime;
  }
 
  /**
   * Changes the start time of the schedule slot.
   * @param the new time of the schedule slot start.
   */
  public void setStartTime(int time) {
    startTime = time;
  }
}