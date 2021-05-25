package com.avito.android.vas_performance.ui.items.visual;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001a¢\u0006\u0004\b+\u0010,R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0019\u0010'\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010*\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006¨\u0006-"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getPrice", "()Lcom/avito/android/remote/model/text/AttributedText;", "price", "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "icon", "e", "getOldPrice", "oldPrice", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "title", "", "h", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "selected", "", g.a, "J", "getPriceValue", "()J", "priceValue", "c", "getDescription", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;JZ)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VisualVasItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final AttributedText c;
    @NotNull
    public final AttributedText d;
    @Nullable
    public final AttributedText e;
    @Nullable
    public final Image f;
    public final long g;
    public boolean h;

    public VisualVasItem(@NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull AttributedText attributedText2, @Nullable AttributedText attributedText3, @Nullable Image image, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText, "description");
        Intrinsics.checkNotNullParameter(attributedText2, "price");
        this.a = str;
        this.b = str2;
        this.c = attributedText;
        this.d = attributedText2;
        this.e = attributedText3;
        this.f = image;
        this.g = j;
        this.h = z;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.c;
    }

    @Nullable
    public final Image getIcon() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final AttributedText getOldPrice() {
        return this.e;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.d;
    }

    public final long getPriceValue() {
        return this.g;
    }

    public final boolean getSelected() {
        return this.h;
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

    public final void setSelected(boolean z) {
        this.h = z;
    }
}
