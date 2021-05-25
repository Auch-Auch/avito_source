package com.avito.android.calls;

import com.avito.android.calls.auth.PushTokenRegistration;
import com.avito.android.code_confirmation.Source;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/calls/CredentialsStorage;", "", "", ChannelContext.Item.USER_ID, "", "setUserId", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "name", "setUsername", "Lcom/avito/android/calls/Credentials;", "getCredentials", "()Lcom/avito/android/calls/Credentials;", "Lcom/avito/android/calls/auth/PushTokenRegistration;", "getPushTokenRegistration", "()Lcom/avito/android/calls/auth/PushTokenRegistration;", Source.REGISTRATION, "savePushTokenRegistration", "(Lcom/avito/android/calls/auth/PushTokenRegistration;)V", "", "isNotified", "saveBackendNotified", "(Z)V", SDKConstants.PARAM_ACCESS_TOKEN, "", "accessTokenExpiresIn", "refreshToken", "refreshTokenExpiresIn", "saveTokens", "(Ljava/lang/String;JLjava/lang/String;J)V", "clearAccessToken", "()V", "clearTokens", "clearAll", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface CredentialsStorage {
    void clearAccessToken();

    void clearAll();

    void clearTokens();

    @NotNull
    Credentials getCredentials();

    @NotNull
    PushTokenRegistration getPushTokenRegistration();

    @Nullable
    String getUsername();

    void saveBackendNotified(boolean z);

    void savePushTokenRegistration(@NotNull PushTokenRegistration pushTokenRegistration);

    void saveTokens(@NotNull String str, long j, @NotNull String str2, long j2);

    void setUserId(@NotNull String str);

    void setUsername(@NotNull String str);
}
