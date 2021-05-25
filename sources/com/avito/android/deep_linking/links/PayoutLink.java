package com.avito.android.deep_linking.links;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/deep_linking/links/PayoutLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "c", "Ljava/lang/String;", "getPurchaseId", "()Ljava/lang/String;", "purchaseId", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class PayoutLink extends DeepLink {
    @NotNull
    public final String c;

    public PayoutLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "purchaseId");
        this.c = str;
    }

    @NotNull
    public final String getPurchaseId() {
        return this.c;
    }
}
