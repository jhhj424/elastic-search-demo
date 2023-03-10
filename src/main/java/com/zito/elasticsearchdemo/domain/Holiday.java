package com.zito.elasticsearchdemo.domain;

public enum Holiday {
    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);

    private final int value;

    Holiday(int value) {
        this.value = value;
    }
}
