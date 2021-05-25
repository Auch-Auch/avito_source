package com.yandex.runtime.recording.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.recording.ReportData;
import com.yandex.runtime.recording.ReportFactory;
public class ReportFactoryBinding implements ReportFactory {
    private final NativeObject nativeObject;

    public ReportFactoryBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.recording.ReportFactory
    @NonNull
    public native ReportData createReportData(@NonNull byte[] bArr);
}
