package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfig;", "", "Lokhttp3/HttpUrl;", "component1", "()Lokhttp3/HttpUrl;", "", "component2", "()Ljava/lang/String;", "component3", "fileUploadEndpoint", "origin", "sessionId", "copy", "(Lokhttp3/HttpUrl;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getOrigin", "c", "getSessionId", AuthSource.SEND_ABUSE, "Lokhttp3/HttpUrl;", "getFileUploadEndpoint", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerFileUploadConfig {
    @NotNull
    public final HttpUrl a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    public MessengerFileUploadConfig(@NotNull HttpUrl httpUrl, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(httpUrl, "fileUploadEndpoint");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        this.a = httpUrl;
        this.b = str;
        this.c = str2;
    }

    public static /* synthetic */ MessengerFileUploadConfig copy$default(MessengerFileUploadConfig messengerFileUploadConfig, HttpUrl httpUrl, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            httpUrl = messengerFileUploadConfig.a;
        }
        if ((i & 2) != 0) {
            str = messengerFileUploadConfig.b;
        }
        if ((i & 4) != 0) {
            str2 = messengerFileUploadConfig.c;
        }
        return messengerFileUploadConfig.copy(httpUrl, str, str2);
    }

    @NotNull
    public final HttpUrl component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final MessengerFileUploadConfig copy(@NotNull HttpUrl httpUrl, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(httpUrl, "fileUploadEndpoint");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        return new MessengerFileUploadConfig(httpUrl, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessengerFileUploadConfig)) {
            return false;
        }
        MessengerFileUploadConfig messengerFileUploadConfig = (MessengerFileUploadConfig) obj;
        return Intrinsics.areEqual(this.a, messengerFileUploadConfig.a) && Intrinsics.areEqual(this.b, messengerFileUploadConfig.b) && Intrinsics.areEqual(this.c, messengerFileUploadConfig.c);
    }

    @NotNull
    public final HttpUrl getFileUploadEndpoint() {
        return this.a;
    }

    @NotNull
    public final String getOrigin() {
        return this.b;
    }

    @NotNull
    public final String getSessionId() {
        return this.c;
    }

    public int hashCode() {
        HttpUrl httpUrl = this.a;
        int i = 0;
        int hashCode = (httpUrl != null ? httpUrl.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessengerFileUploadConfig(fileUploadEndpoint=");
        L.append(this.a);
        L.append(", origin=");
        L.append(this.b);
        L.append(", sessionId=");
        return a.t(L, this.c, ")");
    }
}
