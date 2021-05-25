package com.yandex.runtime.recording.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.recording.ReportData;
import java.util.List;
public class ReportDataBinding implements ReportData {
    private final NativeObject nativeObject;

    public ReportDataBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.recording.ReportData
    @NonNull
    public native byte[] data();

    @Override // com.yandex.runtime.recording.ReportData
    public native long getEndTime();

    @Override // com.yandex.runtime.recording.ReportData
    @Nullable
    public native String getIssueId();

    @Override // com.yandex.runtime.recording.ReportData
    public native long getStartTime();

    @Override // com.yandex.runtime.recording.ReportData
    @NonNull
    public native List<Long> problemMarks();

    @Override // com.yandex.runtime.recording.ReportData
    public native void setIssueId(@Nullable String str);
}
