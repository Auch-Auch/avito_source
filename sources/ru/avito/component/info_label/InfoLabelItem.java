package ru.avito.component.info_label;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/avito/component/info_label/InfoLabelItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lru/avito/component/info_label/InfoLevel;", "c", "Lru/avito/component/info_label/InfoLevel;", "getInfoLevel", "()Lru/avito/component/info_label/InfoLevel;", "infoLevel", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "text", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lru/avito/component/info_label/InfoLevel;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InfoLabelItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;
    @NotNull
    public final InfoLevel c;

    public InfoLabelItem(@NotNull String str, @NotNull CharSequence charSequence, @NotNull InfoLevel infoLevel) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(infoLevel, "infoLevel");
        this.a = str;
        this.b = charSequence;
        this.c = infoLevel;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final InfoLevel getInfoLevel() {
        return this.c;
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
