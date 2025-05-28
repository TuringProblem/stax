package logger;

public class Logger {
  private String name;
  private String message;
  private Level level;
  private String timestamp;

  private Logger(Builder builder) {
    this.name = builder.name;
    this.message = builder.message;
    this.level = builder.level;
    this.timestamp = builder.timestamp;

  }

  public static class Builder {
    private String name;
    private String message;
    private Level level;
    private String timestamp;

    public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public Builder level(Level level) {
      this.level = level;
      return this;
    }

    public Builder timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Logger build() {
      return new Logger(this);
    }

    @Override
    public String toString() {
      return String.format("==={DEBUG LOGGER}=== \nLog:{name='%s', message='%s', level=%s, timestamp='%s'}",
          name, message, level, timestamp);
    }
  }

  public String getName() {
    return name;
  }

  public void changeMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public Level getLevel() {
    return level;
  }

  public String getTimestamp() {
    return timestamp;
  }

}
