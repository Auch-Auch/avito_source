package com.avito.android.in_app_calls.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls.quality.CallQualityIssue;
import com.avito.android.calls.quality.CallQualityIssueListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/CallQualityIssueTracker;", "Lcom/avito/android/calls/quality/CallQualityIssueListener;", "", "callUuid", "Lcom/avito/android/calls/quality/CallQualityIssue;", "issue", "", FirebaseAnalytics.Param.LEVEL, "", "onQualityIssue", "(Ljava/lang/String;Lcom/avito/android/calls/quality/CallQualityIssue;I)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallQualityIssueTracker implements CallQualityIssueListener {
    public final Analytics a;

    @Inject
    public CallQualityIssueTracker(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.calls.quality.CallQualityIssueListener
    public void onQualityIssue(@NotNull String str, @NotNull CallQualityIssue callQualityIssue, int i) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "callUuid");
        Intrinsics.checkNotNullParameter(callQualityIssue, "issue");
        Analytics analytics = this.a;
        if (Intrinsics.areEqual(callQualityIssue, CallQualityIssue.CodecMismatch.INSTANCE)) {
            str2 = "codecMismatch";
        } else if (Intrinsics.areEqual(callQualityIssue, CallQualityIssue.PacketLoss.INSTANCE)) {
            str2 = "packetLoss";
        } else if (Intrinsics.areEqual(callQualityIssue, CallQualityIssue.IceDisconnected.INSTANCE)) {
            str2 = "iceDisconnected";
        } else if (Intrinsics.areEqual(callQualityIssue, CallQualityIssue.NoAudioSignal.INSTANCE)) {
            str2 = "noAudio";
        } else if (Intrinsics.areEqual(callQualityIssue, CallQualityIssue.HighMediaLatency.INSTANCE)) {
            str2 = "highMediaLatency";
        } else if (Intrinsics.areEqual(callQualityIssue, CallQualityIssue.LowBandwidth.INSTANCE)) {
            str2 = "lowBandwidth";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        analytics.track(new InAppCallQualityIssueEvent(str, str2, i));
    }
}
