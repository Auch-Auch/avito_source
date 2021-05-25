package com.avito.android.in_app_calls.service;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.CallManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "", "Lcom/avito/android/calls_shared/AppCallInfo;", "info", "", "isUiBound", "wasConnected", "", "showCallNotification", "(Lcom/avito/android/calls_shared/AppCallInfo;ZZ)V", "showCallActivity", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "Lcom/avito/android/in_app_calls/CallManager$MissedCallData;", "missedCall", "showMissedCallNotification", "(Lcom/avito/android/in_app_calls/CallManager$MissedCallData;)V", "stopForeground", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallNotificationsDelegate {
    void showCallActivity(@NotNull AppCallInfo appCallInfo);

    void showCallNotification(@NotNull AppCallInfo appCallInfo, boolean z, boolean z2);

    void showMissedCallNotification(@NotNull CallManager.MissedCallData missedCallData);

    void stopForeground();
}
