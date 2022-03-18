package common;

import lombok.ToString;

@ToString(callSuper = true)
public abstract class Solution<T> {

  protected String title;
  protected String url;
  protected String notes;

  protected abstract void initializeSolution();

  public abstract T solve();
}