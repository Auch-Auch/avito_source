package com.avito.android.cart.summary.konveyor.text;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/text/TextItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "stringId", "text", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/cart/summary/konveyor/text/TextItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class TextItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final AttributedText b;

    public TextItem(@NotNull String str, @NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "text");
        this.a = str;
        this.b = attributedText;
    }

    public static /* synthetic */ TextItem copy$default(TextItem textItem, String str, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textItem.getStringId();
        }
        if ((i & 2) != 0) {
            attributedText = textItem.b;
        }
        return textItem.copy(str, attributedText);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final AttributedText component2() {
        return this.b;
    }

    @NotNull
    public final TextItem copy(@NotNull String str, @NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "text");
        return new TextItem(str, attributedText);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextItem)) {
            return false;
        }
        TextItem textItem = (TextItem) obj;
        return Intrinsics.areEqual(getStringId(), textItem.getStringId()) && Intrinsics.areEqual(this.b, textItem.b);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final AttributedText getText() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        AttributedText attributedText = this.b;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextItem(stringId=");
        L.append(getStringId());
        L.append(", text=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
