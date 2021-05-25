package com.avito.android.tariff.edit_info.item.button;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/button/ButtonItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;", "c", "Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;", "getEditAction", "()Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;", "editAction", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final EditButtonAction c;

    public ButtonItem(@NotNull String str, @NotNull String str2, @NotNull EditButtonAction editButtonAction) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(editButtonAction, "editAction");
        this.a = str;
        this.b = str2;
        this.c = editButtonAction;
    }

    @NotNull
    public final EditButtonAction getEditAction() {
        return this.c;
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
    public final String getTitle() {
        return this.b;
    }
}
