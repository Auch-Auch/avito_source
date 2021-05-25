package com.avito.android.inline_filters.dialog.select.adapter;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010'\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010*\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b+\u0010,R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010'\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R\u0019\u0010*\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010¨\u0006-"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "Lcom/avito/conveyor_item/Item;", "", "h", "Z", "isMultiselect", "()Z", "f", "getChecked", "setChecked", "(Z)V", "checked", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "c", "getSecondaryText", "secondaryText", "e", "isHeading", "j", "getShouldExposeImageGroup", "shouldExposeImageGroup", "Lcom/avito/android/remote/model/Image;", "k", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", g.a, "isIntValue", "i", "getWithImages", "withImages", AuthSource.SEND_ABUSE, "getStringId", "stringId", "d", "getFilterId", "filterId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZLcom/avito/android/remote/model/Image;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersDialogItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final String d;
    public final boolean e;
    public boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    @Nullable
    public final Image k;

    public InlineFiltersDialogItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, @Nullable Image image) {
        a.Z0(str, "stringId", str2, "text", str4, "filterId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z7;
        this.k = image;
    }

    public final boolean getChecked() {
        return this.f;
    }

    @NotNull
    public final String getFilterId() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getImage() {
        return this.k;
    }

    @Nullable
    public final String getSecondaryText() {
        return this.c;
    }

    public final boolean getShouldExposeImageGroup() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    public final boolean getWithImages() {
        return this.i;
    }

    public final boolean isHeading() {
        return this.e;
    }

    public final boolean isIntValue() {
        return this.g;
    }

    public final boolean isMultiselect() {
        return this.h;
    }

    public final void setChecked(boolean z) {
        this.f = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InlineFiltersDialogItem(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, Image image, int i2, j jVar) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, str4, z, z2, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? false : z4, (i2 & 256) != 0 ? false : z5, (i2 & 512) != 0 ? false : z7, (i2 & 1024) != 0 ? null : image);
    }
}
