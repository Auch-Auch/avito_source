package com.avito.http;

import a2.b.a.a.a;
import com.avito.android.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Lcom/avito/android/Result;", "Lokhttp3/HttpUrl;", "toHttpUrlResult", "(Ljava/lang/String;)Lcom/avito/android/Result;", "okhttp"}, k = 2, mv = {1, 4, 2})
public final class HttpUrlKt {
    @NotNull
    public static final Result<HttpUrl> toHttpUrlResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toHttpUrlResult");
        try {
            return new Result.Success(HttpUrl.Companion.get(str));
        } catch (IllegalArgumentException e) {
            return new Result.Failure(new IllegalArgumentException(a.c3("Failed to parse httpUrl: ", str), e));
        }
    }
}
