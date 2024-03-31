package app.catsriding.aws.common.infra;

import app.catsriding.aws.common.service.ClockHolder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClockHolderImpl implements ClockHolder {

    private static final String CURRENT_MONTH_PATTERN = "yyyy-MM";
    private static final String CURRENT_DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public String stampCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(CURRENT_DATE_PATTERN));
    }

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
