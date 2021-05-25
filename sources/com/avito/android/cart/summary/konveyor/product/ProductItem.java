package com.avito.android.cart.summary.konveyor.product;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.model.Store;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\\\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010'R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010,\u001a\u0004\b3\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0007¨\u00069"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "component3", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "()Lcom/avito/android/remote/model/text/AttributedText;", "component5", "Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "component6", "()Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "component7", "stringId", "image", "title", "price", "itemsLeft", "stepper", "pricePerPiece", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/cart/model/Store$Item$Stepper;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "getStepper", "setStepper", "(Lcom/avito/android/remote/cart/model/Store$Item$Stepper;)V", "e", "Lcom/avito/android/remote/model/text/AttributedText;", "getItemsLeft", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", g.a, "getPricePerPiece", "d", "getPrice", "c", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/cart/model/Store$Item$Stepper;Lcom/avito/android/remote/model/text/AttributedText;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class ProductItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final Image b;
    @NotNull
    public final String c;
    @NotNull
    public final AttributedText d;
    @Nullable
    public final AttributedText e;
    @NotNull
    public Store.Item.Stepper f;
    @Nullable
    public final AttributedText g;

    public ProductItem(@NotNull String str, @Nullable Image image, @NotNull String str2, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @NotNull Store.Item.Stepper stepper, @Nullable AttributedText attributedText3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText, "price");
        Intrinsics.checkNotNullParameter(stepper, "stepper");
        this.a = str;
        this.b = image;
        this.c = str2;
        this.d = attributedText;
        this.e = attributedText2;
        this.f = stepper;
        this.g = attributedText3;
    }

    public static /* synthetic */ ProductItem copy$default(ProductItem productItem, String str, Image image, String str2, AttributedText attributedText, AttributedText attributedText2, Store.Item.Stepper stepper, AttributedText attributedText3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productItem.getStringId();
        }
        if ((i & 2) != 0) {
            image = productItem.b;
        }
        if ((i & 4) != 0) {
            str2 = productItem.c;
        }
        if ((i & 8) != 0) {
            attributedText = productItem.d;
        }
        if ((i & 16) != 0) {
            attributedText2 = productItem.e;
        }
        if ((i & 32) != 0) {
            stepper = productItem.f;
        }
        if ((i & 64) != 0) {
            attributedText3 = productItem.g;
        }
        return productItem.copy(str, image, str2, attributedText, attributedText2, stepper, attributedText3);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final Image component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final AttributedText component4() {
        return this.d;
    }

    @Nullable
    public final AttributedText component5() {
        return this.e;
    }

    @NotNull
    public final Store.Item.Stepper component6() {
        return this.f;
    }

    @Nullable
    public final AttributedText component7() {
        return this.g;
    }

    @NotNull
    public final ProductItem copy(@NotNull String str, @Nullable Image image, @NotNull String str2, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @NotNull Store.Item.Stepper stepper, @Nullable AttributedText attributedText3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText, "price");
        Intrinsics.checkNotNullParameter(stepper, "stepper");
        return new ProductItem(str, image, str2, attributedText, attributedText2, stepper, attributedText3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductItem)) {
            return false;
        }
        ProductItem productItem = (ProductItem) obj;
        return Intrinsics.areEqual(getStringId(), productItem.getStringId()) && Intrinsics.areEqual(this.b, productItem.b) && Intrinsics.areEqual(this.c, productItem.c) && Intrinsics.areEqual(this.d, productItem.d) && Intrinsics.areEqual(this.e, productItem.e) && Intrinsics.areEqual(this.f, productItem.f) && Intrinsics.areEqual(this.g, productItem.g);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getImage() {
        return this.b;
    }

    @Nullable
    public final AttributedText getItemsLeft() {
        return this.e;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.d;
    }

    @Nullable
    public final AttributedText getPricePerPiece() {
        return this.g;
    }

    @NotNull
    public final Store.Item.Stepper getStepper() {
        return this.f;
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

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        Image image = this.b;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        AttributedText attributedText = this.d;
        int hashCode4 = (hashCode3 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.e;
        int hashCode5 = (hashCode4 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        Store.Item.Stepper stepper = this.f;
        int hashCode6 = (hashCode5 + (stepper != null ? stepper.hashCode() : 0)) * 31;
        AttributedText attributedText3 = this.g;
        if (attributedText3 != null) {
            i = attributedText3.hashCode();
        }
        return hashCode6 + i;
    }

    public final void setStepper(@NotNull Store.Item.Stepper stepper) {
        Intrinsics.checkNotNullParameter(stepper, "<set-?>");
        this.f = stepper;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProductItem(stringId=");
        L.append(getStringId());
        L.append(", image=");
        L.append(this.b);
        L.append(", title=");
        L.append(this.c);
        L.append(", price=");
        L.append(this.d);
        L.append(", itemsLeft=");
        L.append(this.e);
        L.append(", stepper=");
        L.append(this.f);
        L.append(", pricePerPiece=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }
}
