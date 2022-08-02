package com.allog.dallog.common.fixtures;

import com.allog.dallog.domain.category.domain.Category;
import com.allog.dallog.domain.schedule.domain.Schedule;
import com.allog.dallog.domain.schedule.dto.request.ScheduleCreateRequest;
import java.time.LocalDateTime;

public class ScheduleFixtures {

    /* 시작일시, 종료일시 */
    public static final LocalDateTime 날짜_2022년_7월_1일_0시_0분 = LocalDateTime.of(2022, 7, 1, 0, 0);
    public static final LocalDateTime 날짜_2022년_7월_7일_16시_0분 = LocalDateTime.of(2022, 7, 7, 16, 0);
    public static final LocalDateTime 날짜_2022년_7월_9일_16시_0분 = LocalDateTime.of(2022, 7, 9, 16, 0);
    public static final LocalDateTime 날짜_2022년_7월_31일_0시_0분 = LocalDateTime.of(2022, 7, 31, 0, 0);
    public static final LocalDateTime 날짜_2022년_7월_15일_16시_0분 = LocalDateTime.of(2022, 7, 15, 16, 0);
    public static final LocalDateTime 날짜_2022년_7월_16일_16시_0분 = LocalDateTime.of(2022, 7, 16, 16, 0);
    public static final LocalDateTime 날짜_2022년_7월_16일_16시_1분 = LocalDateTime.of(2022, 7, 16, 16, 1);
    public static final LocalDateTime 날짜_2022년_8월_15일_14시_0분 = LocalDateTime.of(2022, 8, 15, 14, 0);
    public static final LocalDateTime 날짜_2022년_8월_15일_17시_0분 = LocalDateTime.of(2022, 8, 15, 17, 0);

    /* 알록달록 회의 */
    public static final String 알록달록_회의_제목 = "알록달록 회의";
    public static final LocalDateTime 알록달록_회의_시작일시 = LocalDateTime.of(2022, 7, 15, 16, 0);
    public static final LocalDateTime 알록달록_회의_종료일시 = LocalDateTime.of(2022, 7, 16, 16, 0);
    public static final String 알록달록_회의_메모 = "알록달록 회의가 있어요";
    public static final ScheduleCreateRequest 알록달록_회의_생성_요청 = new ScheduleCreateRequest(알록달록_회의_제목, 알록달록_회의_시작일시,
            알록달록_회의_종료일시, 알록달록_회의_메모);

    /* 알록달록 회식 */
    public static final String 알록달록_회식_제목 = "알록달록 회식";
    public static final LocalDateTime 알록달록_회식_시작일시 = LocalDateTime.of(2022, 7, 7, 16, 0);
    public static final LocalDateTime 알록달록_회식_종료일시 = LocalDateTime.of(2022, 7, 9, 16, 0);
    public static final String 알록달록_회식_메모 = "알록달록 회식이 있어요";
    public static final ScheduleCreateRequest 알록달록_회식_생성_요청 = new ScheduleCreateRequest(알록달록_회식_제목, 알록달록_회식_시작일시,
            알록달록_회식_종료일시, 알록달록_회식_메모);


    public static final String START_DATE_TIME_STRING = "2022-07-04T13:00";
    public static final String END_DATE_TIME_STRING = "2022-07-05T07:00";
    public static final int YEAR = 2022;
    public static final int MONTH = 7;

    public static Schedule 알록달록_회의(final Category category) {
        return new Schedule(알록달록_회의_제목, 알록달록_회의_시작일시, 알록달록_회의_종료일시, 알록달록_회의_메모, category);
    }

    public static Schedule 알록달록_회식(final Category category) {
        return new Schedule(알록달록_회식_제목, 알록달록_회식_시작일시, 알록달록_회식_종료일시, 알록달록_회식_메모, category);
    }
}
