package ru.avito.messenger.internal;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/internal/ImageUploadConfig;", "", "Lokhttp3/HttpUrl;", AuthSource.SEND_ABUSE, "Lokhttp3/HttpUrl;", "getEndpoint", "()Lokhttp3/HttpUrl;", "endpoint", "", "c", "J", "getUploadTimeoutMs", "()J", "uploadTimeoutMs", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getOrigin", "()Ljava/lang/String;", "origin", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadConfig {
    @NotNull
    public final HttpUrl a;
    @NotNull
    public final String b;
    public final long c;

    public ImageUploadConfig(@NotNull HttpUrl httpUrl, @NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(httpUrl, "endpoint");
        Intrinsics.checkNotNullParameter(str, "origin");
        this.a = httpUrl;
        this.b = str;
        this.c = j;
    }

    @NotNull
    public final HttpUrl getEndpoint() {
        return this.a;
    }

    @NotNull
    public final String getOrigin() {
        return this.b;
    }

    public final long getUploadTimeoutMs() {
        return this.c;
    }
}
