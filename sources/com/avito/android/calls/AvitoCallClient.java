package com.avito.android.calls;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.preferences.Preference;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J#\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\b\b\u0002\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0018\u0010\u0019J9\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H&¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010'H&¢\u0006\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/avito/android/calls/AvitoCallClient;", "", "", ChannelContext.Item.USER_ID, "", "register", "(Ljava/lang/String;)V", "unregister", "()V", "name", "connectForOutgoingCall", "", "pushData", "connectForIncomingCall", "(Ljava/util/Map;)V", "disconnect", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "updatePushToken", "data", "", "shouldStartFromPush", "(Ljava/util/Map;)Z", "enableVideo", "", "getMissingPermissions", "(Z)Ljava/util/List;", "callUuid", "targetId", "isVideo", "earlyBeeps", "Lcom/avito/android/calls/CallExtras;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Lcom/avito/android/calls/OutgoingCall;", "makeCall", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/calls/CallExtras;)Lcom/avito/android/calls/OutgoingCall;", "Lcom/avito/android/calls/IncomingCallListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setIncomingCallListener", "(Lcom/avito/android/calls/IncomingCallListener;)V", "Lcom/avito/android/calls/ConnectionListener;", "setConnectionListener", "(Lcom/avito/android/calls/ConnectionListener;)V", "getUsername", "()Ljava/lang/String;", Preference.USERNAME, "calls_release"}, k = 1, mv = {1, 4, 2})
public interface AvitoCallClient {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.calls.AvitoCallClient */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void connectForIncomingCall$default(AvitoCallClient avitoCallClient, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = null;
                }
                avitoCallClient.connectForIncomingCall(map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connectForIncomingCall");
        }

        public static /* synthetic */ List getMissingPermissions$default(AvitoCallClient avitoCallClient, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return avitoCallClient.getMissingPermissions(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMissingPermissions");
        }
    }

    void connectForIncomingCall(@Nullable Map<String, String> map);

    void connectForOutgoingCall(@Nullable String str);

    void disconnect();

    @NotNull
    List<String> getMissingPermissions(boolean z);

    @Nullable
    String getUsername();

    @Nullable
    OutgoingCall makeCall(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @NotNull CallExtras callExtras);

    void register(@NotNull String str);

    void setConnectionListener(@Nullable ConnectionListener connectionListener);

    void setIncomingCallListener(@Nullable IncomingCallListener incomingCallListener);

    boolean shouldStartFromPush(@NotNull Map<String, String> map);

    void unregister();

    void updatePushToken(@NotNull String str);
}
