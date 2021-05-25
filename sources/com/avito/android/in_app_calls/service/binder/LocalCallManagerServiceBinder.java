package com.avito.android.in_app_calls.service.binder;

import android.os.Binder;
import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\n\u0010\u0005J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0013\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/avito/android/in_app_calls/service/binder/LocalCallManagerServiceBinder;", "Landroid/os/Binder;", "Lcom/avito/android/in_app_calls/service/binder/CallManagerServiceApi;", "", "answer", "()V", "", "reason", "cancel", "(Ljava/lang/String;)V", "decline", "", "getMissingPermissions", "()Ljava/util/List;", "hangup", "Lcom/avito/android/in_app_calls/service/binder/CallStateListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCallStateListener", "(Lcom/avito/android/in_app_calls/service/binder/CallStateListener;)V", "toggleMic", "Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;", "serviceDelegate", "<init>", "(Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class LocalCallManagerServiceBinder extends Binder implements CallManagerServiceApi {
    public final /* synthetic */ CallManagerServiceDelegate a;

    @Inject
    public LocalCallManagerServiceBinder(@NotNull CallManagerServiceDelegate callManagerServiceDelegate) {
        Intrinsics.checkNotNullParameter(callManagerServiceDelegate, "serviceDelegate");
        this.a = callManagerServiceDelegate;
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void answer() {
        this.a.answer();
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void cancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        this.a.cancel(str);
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void decline() {
        this.a.decline();
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    @NotNull
    public List<String> getMissingPermissions() {
        return this.a.getMissingPermissions();
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void hangup() {
        this.a.hangup();
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void setCallStateListener(@Nullable CallStateListener callStateListener) {
        this.a.setCallStateListener(callStateListener);
    }

    @Override // com.avito.android.in_app_calls.service.binder.CallManagerServiceApi
    public void toggleMic() {
        this.a.toggleMic();
    }
}
