package com.avito.android.delivery.map.point_info.konveyor.attribute;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItem;", "Lcom/avito/conveyor_item/Item;", "", "c", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class AttributeItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    public AttributeItem(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "stringId", str2, "title", str3, "description");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @NotNull
    public final String getDescription() {
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
