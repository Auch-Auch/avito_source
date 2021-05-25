package com.avito.android.in_app_calls;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.push.CallPushHandler;
import com.avito.android.push.Push;
import com.avito.android.push.PushToken;
import com.avito.android.remote.auth.AuthSource;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/in_app_calls/CallPushHandlerImpl;", "Lcom/avito/android/push/CallPushHandler;", "Lcom/avito/android/push/PushToken;", "pushToken", "", "updatePushToken", "(Lcom/avito/android/push/PushToken;)V", "Lcom/avito/android/push/Push;", "push", "", "handlePush", "(Lcom/avito/android/push/Push;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "handlePushDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "Ldagger/Lazy;", "Lcom/avito/android/in_app_calls/CallManager;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "callManager", "<init>", "(Ldagger/Lazy;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallPushHandlerImpl implements CallPushHandler {
    public final Lazy<CallManager> a;

    public CallPushHandlerImpl(@NotNull Lazy<CallManager> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "callManager");
        this.a = lazy;
    }

    @Override // com.avito.android.push.CallPushHandler
    public boolean handlePush(@NotNull Push push) {
        Intrinsics.checkNotNullParameter(push, "push");
        return this.a.get().startFromPush(push);
    }

    @Override // com.avito.android.push.CallPushHandler
    public boolean handlePushDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        return false;
    }

    @Override // com.avito.android.push.CallPushHandler
    public void updatePushToken(@NotNull PushToken pushToken) {
        Intrinsics.checkNotNullParameter(pushToken, "pushToken");
        this.a.get().updatePushToken(pushToken);
    }
}
