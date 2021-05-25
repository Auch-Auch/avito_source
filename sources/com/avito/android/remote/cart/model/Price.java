package com.avito.android.remote.cart.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/cart/model/Price;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "amount", "getAmount", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class Price {
    @SerializedName("price")
    @Nullable
    private final AttributedText amount;
    @SerializedName("title")
    @NotNull
    private final AttributedText title;

    public Price(@NotNull AttributedText attributedText, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        this.title = attributedText;
        this.amount = attributedText2;
    }

    @Nullable
    public final AttributedText getAmount() {
        return this.amount;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.title;
    }
}
