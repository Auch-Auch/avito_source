package com.avito.android.calls.quality;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssueListener;", "", "", "callUuid", "Lcom/avito/android/calls/quality/CallQualityIssue;", "issue", "", FirebaseAnalytics.Param.LEVEL, "", "onQualityIssue", "(Ljava/lang/String;Lcom/avito/android/calls/quality/CallQualityIssue;I)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallQualityIssueListener {
    void onQualityIssue(@NotNull String str, @NotNull CallQualityIssue callQualityIssue, int i);
}
