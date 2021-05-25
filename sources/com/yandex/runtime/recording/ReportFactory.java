package com.yandex.runtime.recording;

import androidx.annotation.NonNull;
public interface ReportFactory {
    @NonNull
    ReportData createReportData(@NonNull byte[] bArr);
}
