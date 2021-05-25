package com.avito.android.basket_legacy.item;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010*\u001a\u00020\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010-\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b.\u0010/R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u0019\u0010'\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\u0019\u0010*\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\u0019\u0010-\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000b¨\u00060"}, d2 = {"Lcom/avito/android/basket_legacy/item/BasketItem;", "Lcom/avito/conveyor_item/Item;", "", g.a, "Z", "isCancelable", "()Z", "Lcom/avito/android/remote/model/text/AttributedText;", "e", "Lcom/avito/android/remote/model/text/AttributedText;", "getOldPrice", "()Lcom/avito/android/remote/model/text/AttributedText;", "oldPrice", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "i", "getServiceId", "serviceId", "", "j", "J", "getPriceValue", "()J", "priceValue", "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "icon", "c", "getSubTitle", "subTitle", "h", "getSectionId", "sectionId", AuthSource.BOOKING_ORDER, "getTitle", "title", "d", "getPrice", "price", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;ZLjava/lang/String;Ljava/lang/String;J)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final AttributedText c;
    @NotNull
    public final AttributedText d;
    @Nullable
    public final AttributedText e;
    @Nullable
    public final Image f;
    public final boolean g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    public final long j;

    public BasketItem(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @NotNull AttributedText attributedText2, @Nullable AttributedText attributedText3, @Nullable Image image, boolean z, @NotNull String str3, @NotNull String str4, long j2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText2, "price");
        Intrinsics.checkNotNullParameter(str3, "sectionId");
        Intrinsics.checkNotNullParameter(str4, "serviceId");
        this.a = str;
        this.b = str2;
        this.c = attributedText;
        this.d = attributedText2;
        this.e = attributedText3;
        this.f = image;
        this.g = z;
        this.h = str3;
        this.i = str4;
        this.j = j2;
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
        return this.j;
    }

    @NotNull
    public final String getSectionId() {
        return this.h;
    }

    @NotNull
    public final String getServiceId() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final AttributedText getSubTitle() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public final boolean isCancelable() {
        return this.g;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasketItem(String str, String str2, AttributedText attributedText, AttributedText attributedText2, AttributedText attributedText3, Image image, boolean z, String str3, String str4, long j2, int i2, j jVar) {
        this(str, str2, (i2 & 4) != 0 ? null : attributedText, attributedText2, (i2 & 16) != 0 ? null : attributedText3, image, z, str3, str4, j2);
    }
}
