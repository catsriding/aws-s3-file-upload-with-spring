package app.catsriding.aws.common.service;

import java.time.LocalDateTime;

public interface ClockHolder {

    String stampCurrentDate();

    LocalDateTime now();
}
