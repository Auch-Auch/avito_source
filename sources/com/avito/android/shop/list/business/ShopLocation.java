package com.avito.android.shop.list.business;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/shop/list/business/ShopLocation;", "", "", "nameCase", "", "getName", "(I)Ljava/lang/String;", "Lcom/avito/android/remote/model/CaseText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/CaseText;", "getNames", "()Lcom/avito/android/remote/model/CaseText;", "names", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopLocation {
    @NotNull
    public final String a;
    @NotNull
    public final CaseText b;

    public ShopLocation(@NotNull String str, @NotNull CaseText caseText) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(caseText, "names");
        this.a = str;
        this.b = caseText;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @Nullable
    public final String getName(int i) {
        return this.b.getName(i);
    }

    @NotNull
    public final CaseText getNames() {
        return this.b;
    }
}
