package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface RoadEventFailedError extends Error {

    public enum Code {
        UNKNOWN,
        BANNED,
        TOO_FAR,
        TOO_OFTEN,
        LEGAL_REASONS
    }

    @NonNull
    Code getCode();

    @NonNull
    String getDescription();
}
