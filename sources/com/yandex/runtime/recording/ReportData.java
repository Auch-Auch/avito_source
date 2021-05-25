package com.yandex.runtime.recording;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
public interface ReportData {
    @NonNull
    byte[] data();

    long getEndTime();

    @Nullable
    String getIssueId();

    long getStartTime();

    @NonNull
    List<Long> problemMarks();

    void setIssueId(@Nullable String str);
}
