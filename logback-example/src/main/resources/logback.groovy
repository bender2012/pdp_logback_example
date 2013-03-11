import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.status.OnConsoleStatusListener

import static ch.qos.logback.classic.Level.INFO

// always a good idea to add an on console status listener
statusListener(OnConsoleStatusListener)

def appenderList = ["ROLLING"]
def APP_DIR = "."
def consoleAppender = true;


if (consoleAppender) {
  appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
      pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
  }
   appenderList.add("CONSOLE")
}

appender("ROLLING", RollingFileAppender) {
  encoder(PatternLayoutEncoder) {
    Pattern = "%d %level %thread %mdc %logger - %m%n"
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    FileNamePattern = "${APP_DIR}/log/translator-%d{yyyy-MM}.zip"
  }
}

root(INFO, appenderList)
