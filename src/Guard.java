class Guard<T> {
  private T value;
  private boolean alreadyMatched = false;

  static final boolean OtherwiseGuard = true;

  public Guard() {
    this.value = null;
    this.alreadyMatched = false;
  }

  public static <T> Guard<T> initializeGuard() {
    return new Guard<T>();
  }

  public T getValue() {
    if(!alreadyMatched) {
      throw new RuntimeException();
    }
    return value;
  }

  interface GuardResult<T> {
    public T evaluateGuardResult();
  }

  public Guard<T> guard(final boolean expression, final GuardResult<T> result) {
    if(!alreadyMatched && expression) {
      this.value = result.evaluateGuardResult();
      this.alreadyMatched = true;
    }
    return this;
  }
}