package com.avito.android.delivery.summary.konveyor.header;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/header/HeaderItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "d", "Z", "getEditable", "()Z", "editable", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "text", "c", "getAddTopMargin", "addTopMargin", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;ZZ)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;
    public final boolean c;
    public final boolean d;

    public HeaderItem(@NotNull String str, @NotNull CharSequence charSequence, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.a = str;
        this.b = charSequence;
        this.c = z;
        this.d = z2;
    }

    public final boolean getAddTopMargin() {
        return this.c;
    }

    public final boolean getEditable() {
        return this.d;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderItem(String str, CharSequence charSequence, boolean z, boolean z2, int i, j jVar) {
        this(str, charSequence, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }
}
