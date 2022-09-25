/**
 * Victor Majestic
 * This class represents a job.
 */

import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class Job implements Comparable<Job> {
  
  /** A reference to the ID number for the job. */
  private int id;
  
  /** A reference to the earliest start time of the job. */
  private int earliestStart;
  
  /** A reference to the deadline of the job. */
  private int deadline;
  
  /** A reference to the duration of the job. */
  private int duration;
  
  /** A reference to the profit of the job */
  private int profit;
  
  /** Create a job with unspecified values. */
  public Job() {
  }
  
  /**
   * Create a job with specified values.
   * @param id the ID of the job.
   * @param earliestStart the earliest start time of the job.
   * @param deadline the deadline of the job.
   * @param duration the duration of the job.
   * @param profit the profit of the job.
   */
  public Job(int id, int earliestStart, int deadline, int duration, int profit) {
    this.id = id;
    this.earliestStart = earliestStart;
    this.deadline = deadline;
    this.duration = duration;
    this.profit = profit;
  }
  
  /**
   * Return the ID number of the job.
   * @return the ID number of the job.
   */
  public int getID() {
    return id;
  }
  
  /**
   * Return the earliest start time of the job.
   * @return the earliest start time of the job.
   */
  public int getEarliestStart() {
    return earliestStart;
  }
  
  /** 
   * Return the deadline of the job.
   * @return the deadline of the job.
   */
  public int getDeadline() {
    return deadline;
  }
  
  /**
   * Return the duration of the job.
   * @return the duration of the job.
   */
  public int getDuration() {
    return duration;
  }
  
  /**
   * Return the profit of the job.
   * @return the profit of the job.
   */
  public int getProfit() {
    return profit;
  }
  
  /**
   * The comparable of the job.
   * @param j the job that is being compared.
   * @return 1 if the current job ID is greater than that of the parameter ID.
   * @return 0 if the current job ID is equal to that of the parameter ID.
   * @return -1 if the current job ID is less than that of the parameter ID.
   */
  public int compareTo(Job j) {
    if (this.getID() > (j.getID()))
      return 1;
    else if (this.getID() == (j.getID()))
      return 0;
    else
      return -1;
  }
  
  /**
   * Returns the start comparator.
   * @return the comparator by earliest start time of the job.
   */
  public Comparator<Job> getStartComparator() {
    return compareByEarliestStart();
  }
  
  /**
   * Returns the profit comparator.
   * @return the comparator by profit of the job.
   */
  public Comparator<Job> getProfitComparator() {
    return compareByProfit();
  }
  
  /**
   * A comparator that organizes jobs by earliest start.
   * @param job 1 a job being compared.
   * @param job 2 the other job being compared.
   * @return the differences in start time of the two jobs.
   */
  public static Comparator<Job> compareByEarliestStart() {
    return new Comparator<Job>() {
      public int compare(Job job1, Job job2) {
        return job1.getEarliestStart() - job2.getEarliestStart();
      }
    };
  }
  
  /**
   * A comparator that organizes jobs by profit.
   * @param job 1 a job being compared.
   * @param job 2 the other job being compared.
   * @return the differences in profit of the two jobs.
   */
  public static Comparator<Job> compareByProfit() {
    return new Comparator<Job>() {
      public int compare(Job job1, Job job2) {
        return job1.getProfit() - job2.getProfit();
      }
    };
  }
}