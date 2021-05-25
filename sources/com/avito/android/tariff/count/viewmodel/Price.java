package com.avito.android.tariff.count.viewmodel;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/Price;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTotalPrice", "()Ljava/lang/String;", "totalPrice", AuthSource.BOOKING_ORDER, "getOldPrice", "oldPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class Price {
    @NotNull
    public final String a;
    @Nullable
    public final String b;

    public Price(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "totalPrice");
        this.a = str;
        this.b = str2;
    }

    @Nullable
    public final String getOldPrice() {
        return this.b;
    }

    @NotNull
    public final String getTotalPrice() {
        return this.a;
    }
}
