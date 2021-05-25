package com.avito.android.bundles.ui.recycler.item.bundle;

import a2.g.r.g;
import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.BundleDiscount;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010#\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u00102\u001a\u0004\u0018\u00010-\u0012\u0006\u0010)\u001a\u00020\b\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010&\u001a\u00020\u001b\u0012\b\u0010,\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b3\u00104R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\u0019\u0010&\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u0019\u0010)\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b(\u0010\fR\u001b\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001fR\u001b\u00102\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/deep_linking/links/DeepLink;", "j", "Lcom/avito/android/deep_linking/links/DeepLink;", "getButtonDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "buttonDeeplink", "", "i", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "buttonText", "Lcom/avito/android/remote/model/UniversalImage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/UniversalImage;", "getImage", "()Lcom/avito/android/remote/model/UniversalImage;", "image", "", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItem;", "e", "Ljava/util/List;", "getBenefits", "()Ljava/util/List;", "benefits", "Lcom/avito/android/remote/model/text/AttributedText;", "h", "Lcom/avito/android/remote/model/text/AttributedText;", "getPriceHint", "()Lcom/avito/android/remote/model/text/AttributedText;", "priceHint", AuthSource.SEND_ABUSE, "getStringId", "stringId", "f", "getPrice", "price", "d", "getTitle", "title", g.a, "getOldPrice", "oldPrice", "Lcom/avito/android/remote/model/BundleDiscount;", "c", "Lcom/avito/android/remote/model/BundleDiscount;", "getDiscount", "()Lcom/avito/android/remote/model/BundleDiscount;", FirebaseAnalytics.Param.DISCOUNT, "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalImage;Lcom/avito/android/remote/model/BundleDiscount;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundleItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final UniversalImage b;
    @Nullable
    public final BundleDiscount c;
    @NotNull
    public final String d;
    @NotNull
    public final List<BundleBenefitItem> e;
    @NotNull
    public final AttributedText f;
    @Nullable
    public final AttributedText g;
    @Nullable
    public final AttributedText h;
    @NotNull
    public final String i;
    @NotNull
    public final DeepLink j;

    public VasBundleItem(@NotNull String str, @Nullable UniversalImage universalImage, @Nullable BundleDiscount bundleDiscount, @NotNull String str2, @NotNull List<BundleBenefitItem> list, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable AttributedText attributedText3, @NotNull String str3, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "benefits");
        Intrinsics.checkNotNullParameter(attributedText, "price");
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(deepLink, "buttonDeeplink");
        this.a = str;
        this.b = universalImage;
        this.c = bundleDiscount;
        this.d = str2;
        this.e = list;
        this.f = attributedText;
        this.g = attributedText2;
        this.h = attributedText3;
        this.i = str3;
        this.j = deepLink;
    }

    @NotNull
    public final List<BundleBenefitItem> getBenefits() {
        return this.e;
    }

    @NotNull
    public final DeepLink getButtonDeeplink() {
        return this.j;
    }

    @NotNull
    public final String getButtonText() {
        return this.i;
    }

    @Nullable
    public final BundleDiscount getDiscount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final UniversalImage getImage() {
        return this.b;
    }

    @Nullable
    public final AttributedText getOldPrice() {
        return this.g;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.f;
    }

    @Nullable
    public final AttributedText getPriceHint() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.d;
    }
}
