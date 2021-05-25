package com.avito.android.tariff.landing.item.icon;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/tariff/landing/item/icon/IconItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/image_loader/Picture;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/image_loader/Picture;", "getIcon", "()Lcom/avito/android/image_loader/Picture;", "icon", "c", "getTitle", "title", "<init>", "(Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class IconItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final Picture b;
    @NotNull
    public final String c;

    public IconItem(@NotNull String str, @NotNull Picture picture, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(picture, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = picture;
        this.c = str2;
    }

    @NotNull
    public final Picture getIcon() {
        return this.b;
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
        return this.c;
    }
}
