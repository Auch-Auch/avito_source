package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010#\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b'\u0010(R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR\u001e\u0010%\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/VasBundle;", "", "", "Lcom/avito/android/remote/model/BundleBenefit;", "benefits", "Ljava/util/List;", "getBenefits", "()Ljava/util/List;", "Lcom/avito/android/remote/model/BundleDiscount;", FirebaseAnalytics.Param.DISCOUNT, "Lcom/avito/android/remote/model/BundleDiscount;", "getDiscount", "()Lcom/avito/android/remote/model/BundleDiscount;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/remote/model/text/AttributedText;", "priceHint", "Lcom/avito/android/remote/model/text/AttributedText;", "getPriceHint", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "price", "getPrice", "Lcom/avito/android/remote/model/UniversalImage;", "image", "Lcom/avito/android/remote/model/UniversalImage;", "getImage", "()Lcom/avito/android/remote/model/UniversalImage;", "id", "getId", "oldPrice", "getOldPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/BundleDiscount;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/UniversalImage;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundle {
    @SerializedName("action")
    @NotNull
    private final Action action;
    @SerializedName("benefits")
    @NotNull
    private final List<BundleBenefit> benefits;
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    @Nullable
    private final BundleDiscount discount;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("image")
    @Nullable
    private final UniversalImage image;
    @SerializedName("oldPrice")
    @Nullable
    private final AttributedText oldPrice;
    @SerializedName("price")
    @NotNull
    private final AttributedText price;
    @SerializedName("priceHint")
    @Nullable
    private final AttributedText priceHint;
    @SerializedName("title")
    @NotNull
    private final String title;

    public VasBundle(@NotNull String str, @NotNull String str2, @Nullable BundleDiscount bundleDiscount, @NotNull List<BundleBenefit> list, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable AttributedText attributedText3, @NotNull Action action2, @Nullable UniversalImage universalImage) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "benefits");
        Intrinsics.checkNotNullParameter(attributedText, "price");
        Intrinsics.checkNotNullParameter(action2, "action");
        this.id = str;
        this.title = str2;
        this.discount = bundleDiscount;
        this.benefits = list;
        this.price = attributedText;
        this.oldPrice = attributedText2;
        this.priceHint = attributedText3;
        this.action = action2;
        this.image = universalImage;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final List<BundleBenefit> getBenefits() {
        return this.benefits;
    }

    @Nullable
    public final BundleDiscount getDiscount() {
        return this.discount;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final UniversalImage getImage() {
        return this.image;
    }

    @Nullable
    public final AttributedText getOldPrice() {
        return this.oldPrice;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.price;
    }

    @Nullable
    public final AttributedText getPriceHint() {
        return this.priceHint;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
