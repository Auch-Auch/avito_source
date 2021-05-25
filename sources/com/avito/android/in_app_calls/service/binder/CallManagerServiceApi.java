package com.avito.android.in_app_calls.service.binder;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", "", "", "answer", "()V", "decline", "hangup", "", "reason", "cancel", "(Ljava/lang/String;)V", "toggleMic", "Lcom/avito/android/in_app_calls/service/binder/CallStateListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCallStateListener", "(Lcom/avito/android/in_app_calls/service/binder/CallStateListener;)V", "", "getMissingPermissions", "()Ljava/util/List;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallManagerServiceApi {
    void answer();

    void cancel(@NotNull String str);

    void decline();

    @NotNull
    List<String> getMissingPermissions();

    void hangup();

    void setCallStateListener(@Nullable CallStateListener callStateListener);

    void toggleMic();
}
