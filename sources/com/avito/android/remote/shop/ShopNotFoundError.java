package com.avito.android.remote.shop;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/shop/ShopNotFoundError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopNotFoundError implements ErrorWithMessage {
    @NotNull
    public final String a;

    public ShopNotFoundError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.a = str;
    }

    @Override // com.avito.android.remote.error.ErrorWithMessage
    @NotNull
    public String getMessage() {
        return this.a;
    }
}
