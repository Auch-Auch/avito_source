package com.avito.android.payment.items;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/items/TextItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "text", "DisclaimerTextItem", "InfoTextItem", "Lcom/avito/android/payment/items/TextItem$InfoTextItem;", "Lcom/avito/android/payment/items/TextItem$DisclaimerTextItem;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class TextItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/items/TextItem$DisclaimerTextItem;", "Lcom/avito/android/payment/items/TextItem;", "", "stringId", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class DisclaimerTextItem extends TextItem {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DisclaimerTextItem(@NotNull String str, @NotNull CharSequence charSequence) {
            super(str, charSequence, null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(charSequence, "text");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/items/TextItem$InfoTextItem;", "Lcom/avito/android/payment/items/TextItem;", "", "stringId", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class InfoTextItem extends TextItem {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InfoTextItem(@NotNull String str, @NotNull CharSequence charSequence) {
            super(str, charSequence, null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(charSequence, "text");
        }
    }

    public TextItem(String str, CharSequence charSequence, j jVar) {
        this.a = str;
        this.b = charSequence;
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
    public final CharSequence getText() {
        return this.b;
    }
}
