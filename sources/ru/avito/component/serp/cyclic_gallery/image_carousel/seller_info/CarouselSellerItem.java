package ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\b\u0010*\u001a\u0004\u0018\u00010%\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010-\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b.\u0010/R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u000f\u001a\u0004\b,\u0010\u0011¨\u00060"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/Image;", "h", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "logo", "", "i", "Z", "isShop", "()Z", "", "d", "Ljava/lang/String;", "getReviewCount", "()Ljava/lang/String;", "reviewCount", AuthSource.SEND_ABUSE, "getStringId", "stringId", "e", "getExternalVerification", "externalVerification", AuthSource.BOOKING_ORDER, "getSellerName", "sellerName", "f", "getInternalVerification", "internalVerification", "Lcom/avito/android/deep_linking/links/DeepLink;", "j", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "c", "Ljava/lang/Float;", "getRating", "()Ljava/lang/Float;", "rating", g.a, "getSellerTypeName", "sellerTypeName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLcom/avito/android/deep_linking/links/DeepLink;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselSellerItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final Float c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final Image h;
    public final boolean i;
    @Nullable
    public final DeepLink j;

    public CarouselSellerItem(@NotNull String str, @NotNull String str2, @Nullable Float f2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Image image, boolean z, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "sellerName");
        this.a = str;
        this.b = str2;
        this.c = f2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = image;
        this.i = z;
        this.j = deepLink;
    }

    @Nullable
    public final DeepLink getDeeplink() {
        return this.j;
    }

    @Nullable
    public final String getExternalVerification() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getInternalVerification() {
        return this.f;
    }

    @Nullable
    public final Image getLogo() {
        return this.h;
    }

    @Nullable
    public final Float getRating() {
        return this.c;
    }

    @Nullable
    public final String getReviewCount() {
        return this.d;
    }

    @NotNull
    public final String getSellerName() {
        return this.b;
    }

    @Nullable
    public final String getSellerTypeName() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public final boolean isShop() {
        return this.i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselSellerItem(String str, String str2, Float f2, String str3, String str4, String str5, String str6, Image image, boolean z, DeepLink deepLink, int i2, j jVar) {
        this(str, str2, f2, str3, str4, str5, str6, image, z, (i2 & 512) != 0 ? null : deepLink);
    }
}
