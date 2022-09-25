/**
 * Victor Majestic
 * A class that represents a compound job.
 */

import java.util.*; 
import java.lang.*; 
import java.io.*;

public class CompoundJob extends Job {
  
  /** An array of subjobs. */
  private Job[] subjoblist;
  
  /** The total profit of all subjobs. Default value is 0. */
  private int totalprofit = 0;
  
  /** The total earliest start of all subjobs. Default value is 0. */
  private int trueearlieststart = 0;
  
  /** The true deadline of all subjobs. Cannot exceed 24. */
  private int truedeadline = 24;
  
  /** The true duration of all subjubs. Initially at 0. */
  private int trueduration = 0;
  
  /**
   * A constructor that represents a compound job.
   * @param the profit of all subjobs.
   * @param jobsArray the defined array of all subjobs.
   */
  public CompoundJob(int profit, Job[] jobsArray) {
    this.subjoblist = jobsArray;
    this.totalprofit = profit;
    for (int i = 0; i < jobsArray.length; i = i + 1) {
      if (jobsArray[i].getEarliestStart() < trueearlieststart) {
        trueearlieststart = jobsArray[i].getEarliestStart();
      }
      if (jobsArray[i].getDeadline() > truedeadline) {
        truedeadline = jobsArray[i].getDeadline();
      }
      trueduration = trueduration + jobsArray[i].getDuration();
      profit = profit + jobsArray[i].getProfit();
    }
  }
  
  /**
   * Returns the current list of jobs.
   * @return the current list of jobs.
   */
  public Job[] getSubJobList() {
    return subjoblist;
  }
}