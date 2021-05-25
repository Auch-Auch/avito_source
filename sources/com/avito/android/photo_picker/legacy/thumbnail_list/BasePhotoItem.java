package com.avito.android.photo_picker.legacy.thumbnail_list;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "c", "Z", "isLoading", "()Z", AuthSource.BOOKING_ORDER, "getSelected", "setSelected", "(Z)V", "selected", "<init>", "(Ljava/lang/String;ZZ)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public abstract class BasePhotoItem implements Item {
    @NotNull
    public final String a;
    public boolean b;
    public final boolean c;

    public BasePhotoItem(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final boolean getSelected() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public final boolean isLoading() {
        return this.c;
    }

    public final void setSelected(boolean z) {
        this.b = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasePhotoItem(String str, boolean z, boolean z2, int i, j jVar) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }
}
