package com.avito.android.in_app_calls.analytics;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTrackerImpl;", "Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;", "Lcom/avito/android/push/Push;", "push", "", "trackNewPush", "(Lcom/avito/android/push/Push;)Ljava/lang/String;", "pushId", "", "connected", "", "trackPushHandlingFailed", "(Ljava/lang/String;Z)V", "Lcom/avito/android/util/RandomKeyProvider;", "c", "Lcom/avito/android/util/RandomKeyProvider;", "randomKeyProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "appContext", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "d", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "context", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;Landroid/content/Context;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallPushHandlingTrackerImpl implements CallPushHandlingTracker {
    public final Context a;
    public final Analytics b;
    public final RandomKeyProvider c;
    public final CallEventTracker d;

    @Inject
    public CallPushHandlingTrackerImpl(@NotNull Analytics analytics, @NotNull RandomKeyProvider randomKeyProvider, @NotNull CallEventTracker callEventTracker, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "randomKeyProvider");
        Intrinsics.checkNotNullParameter(callEventTracker, "callEventTracker");
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = analytics;
        this.c = randomKeyProvider;
        this.d = callEventTracker;
        this.a = context.getApplicationContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5  */
    @Override // com.avito.android.in_app_calls.analytics.CallPushHandlingTracker
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String trackNewPush(@org.jetbrains.annotations.NotNull com.avito.android.push.Push r14) {
        /*
            r13 = this;
            java.lang.String r0 = "push"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.avito.android.util.RandomKeyProvider r0 = r13.c
            java.lang.String r0 = r0.generateKey()
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x002a }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x002a }
            java.util.Map r2 = r14.getData()     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0020
            java.lang.String r3 = "voximplant"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            java.lang.String r2 = "{}"
        L_0x0022:
            r1.<init>(r2)     // Catch:{ all -> 0x002a }
            java.lang.Object r1 = kotlin.Result.m242constructorimpl(r1)     // Catch:{ all -> 0x002a }
            goto L_0x0035
        L_0x002a:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m242constructorimpl(r1)
        L_0x0035:
            boolean r2 = kotlin.Result.m248isSuccessimpl(r1)
            if (r2 == 0) goto L_0x005c
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0055 }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x0055 }
            kotlin.Pair r2 = new kotlin.Pair     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = "callid"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = "userid"
            java.lang.String r1 = r1.getString(r4)     // Catch:{ all -> 0x0055 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0055 }
            java.lang.Object r1 = kotlin.Result.m242constructorimpl(r2)     // Catch:{ all -> 0x0055 }
            goto L_0x0060
        L_0x0055:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
        L_0x005c:
            java.lang.Object r1 = kotlin.Result.m242constructorimpl(r1)
        L_0x0060:
            r2 = 0
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r2)
            boolean r3 = kotlin.Result.m247isFailureimpl(r1)
            if (r3 == 0) goto L_0x006c
            r1 = r2
        L_0x006c:
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r2 = r1.component1()
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r1 = r1.component2()
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            com.avito.android.calls_shared.tracker.events.CallEventTracker r11 = r13.d
            com.avito.android.calls_shared.tracker.events.CallEvent$PushReceived r12 = new com.avito.android.calls_shared.tracker.events.CallEvent$PushReceived
            int r3 = r14.getTtl()
            int r1 = r14.getOriginalPriority()
            java.lang.String r2 = "unknown"
            java.lang.String r4 = "normal"
            r5 = 2
            java.lang.String r6 = "high"
            r7 = 1
            if (r1 == r7) goto L_0x0098
            if (r1 == r5) goto L_0x0096
            r8 = r2
            goto L_0x0099
        L_0x0096:
            r8 = r4
            goto L_0x0099
        L_0x0098:
            r8 = r6
        L_0x0099:
            int r1 = r14.getDeliveredPriority()
            if (r1 == r7) goto L_0x00a5
            if (r1 == r5) goto L_0x00a3
            r5 = r2
            goto L_0x00a6
        L_0x00a3:
            r5 = r4
            goto L_0x00a6
        L_0x00a5:
            r5 = r6
        L_0x00a6:
            long r6 = r14.getSentTimestamp()
            android.content.Context r14 = r13.a
            java.lang.String r1 = "appContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r1)
            boolean r14 = com.avito.android.in_app_calls.util.NotificationsKt.areIncomingCallNotificationsAllowed(r14)
            r1 = r12
            r2 = r0
            r4 = r8
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r8, r9, r10)
            r11.track(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.in_app_calls.analytics.CallPushHandlingTrackerImpl.trackNewPush(com.avito.android.push.Push):java.lang.String");
    }

    @Override // com.avito.android.in_app_calls.analytics.CallPushHandlingTracker
    public void trackPushHandlingFailed(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "pushId");
        this.b.track(new CallPushHandlingFailedEvent(str, z));
    }
}
