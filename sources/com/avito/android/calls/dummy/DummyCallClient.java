package com.avito.android.calls.dummy;

import com.avito.android.calls.AvitoCallClient;
import com.avito.android.calls.CallExtras;
import com.avito.android.calls.ConnectionListener;
import com.avito.android.calls.IncomingCallListener;
import com.avito.android.calls.OutgoingCall;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.preferences.Preference;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J%\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J#\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020'2\u0006\u0010&\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/avito/android/calls/dummy/DummyCallClient;", "Lcom/avito/android/calls/AvitoCallClient;", "", ChannelContext.Item.USER_ID, "", "register", "(Ljava/lang/String;)V", "unregister", "()V", "name", "connectForOutgoingCall", "", "pushData", "connectForIncomingCall", "(Ljava/util/Map;)V", "disconnect", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "updatePushToken", "data", "", "shouldStartFromPush", "(Ljava/util/Map;)Z", "callUuid", "targetId", "isVideo", "earlyBeeps", "Lcom/avito/android/calls/CallExtras;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Lcom/avito/android/calls/OutgoingCall;", "makeCall", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/calls/CallExtras;)Lcom/avito/android/calls/OutgoingCall;", "Lcom/avito/android/calls/IncomingCallListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setIncomingCallListener", "(Lcom/avito/android/calls/IncomingCallListener;)V", "Lcom/avito/android/calls/ConnectionListener;", "setConnectionListener", "(Lcom/avito/android/calls/ConnectionListener;)V", "enableVideo", "", "getMissingPermissions", "(Z)Ljava/util/List;", Preference.USERNAME, "Ljava/lang/String;", "getUsername", "()Ljava/lang/String;", "<init>", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class DummyCallClient implements AvitoCallClient {
    @Override // com.avito.android.calls.AvitoCallClient
    public void connectForIncomingCall(@Nullable Map<String, String> map) {
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void connectForOutgoingCall(@Nullable String str) {
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void disconnect() {
    }

    @Override // com.avito.android.calls.AvitoCallClient
    @NotNull
    public List<String> getMissingPermissions(boolean z) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // com.avito.android.calls.AvitoCallClient
    @Nullable
    public String getUsername() {
        return null;
    }

    @Override // com.avito.android.calls.AvitoCallClient
    @Nullable
    public OutgoingCall makeCall(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @NotNull CallExtras callExtras) {
        Intrinsics.checkNotNullParameter(str, "callUuid");
        Intrinsics.checkNotNullParameter(str2, "targetId");
        Intrinsics.checkNotNullParameter(callExtras, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        return null;
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void register(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void setConnectionListener(@Nullable ConnectionListener connectionListener) {
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void setIncomingCallListener(@Nullable IncomingCallListener incomingCallListener) {
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public boolean shouldStartFromPush(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return false;
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void unregister() {
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void updatePushToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
    }
}
