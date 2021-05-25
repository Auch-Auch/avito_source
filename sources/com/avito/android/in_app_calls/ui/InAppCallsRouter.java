package com.avito.android.in_app_calls.ui;

import com.avito.android.in_app_calls.data.CallActivityRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "", "openCallScreen", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "", "callId", "", "declinedCalls", "openDeclineReasonScreen", "(Ljava/lang/String;I)V", "openCancelReasonScreen", "(Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface InAppCallsRouter {
    void openCallScreen(@NotNull CallActivityRequest callActivityRequest);

    void openCancelReasonScreen(@NotNull String str);

    void openDeclineReasonScreen(@NotNull String str, int i);
}
