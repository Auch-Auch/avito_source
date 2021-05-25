package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000bR\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/CheckoutService;", "Lcom/avito/android/remote/model/CheckoutElement;", "", "cancellable", "Ljava/lang/Boolean;", "getCancellable", "()Ljava/lang/Boolean;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/text/AttributedText;", "oldPrice", "Lcom/avito/android/remote/model/text/AttributedText;", "getOldPrice", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "priceValue", "Ljava/lang/Integer;", "getPriceValue", "()Ljava/lang/Integer;", "title", "getTitle", "price", "getPrice", "Lcom/avito/android/remote/model/Prolongation;", AnalyticFieldsName.prolongation, "Lcom/avito/android/remote/model/Prolongation;", "getProlongation", "()Lcom/avito/android/remote/model/Prolongation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Prolongation;Ljava/lang/Integer;)V", "checkout_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutService implements CheckoutElement {
    @SerializedName("cancellable")
    @Nullable
    private final Boolean cancellable;
    @SerializedName("icon")
    @NotNull
    private final Image icon;
    @SerializedName("slug")
    @NotNull
    private final String id;
    @SerializedName("oldPrice")
    @Nullable
    private final AttributedText oldPrice;
    @SerializedName("price")
    @Nullable
    private final String price;
    @SerializedName("priceValue")
    @Nullable
    private final Integer priceValue;
    @SerializedName(AnalyticFieldsName.prolongation)
    @Nullable
    private final Prolongation prolongation;
    @SerializedName("title")
    @NotNull
    private final String title;

    public CheckoutService(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, @NotNull Image image, @Nullable Boolean bool, @Nullable Prolongation prolongation2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(image, "icon");
        this.id = str;
        this.title = str2;
        this.price = str3;
        this.oldPrice = attributedText;
        this.icon = image;
        this.cancellable = bool;
        this.prolongation = prolongation2;
        this.priceValue = num;
    }

    @Nullable
    public final Boolean getCancellable() {
        return this.cancellable;
    }

    @NotNull
    public final Image getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AttributedText getOldPrice() {
        return this.oldPrice;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final Integer getPriceValue() {
        return this.priceValue;
    }

    @Nullable
    public final Prolongation getProlongation() {
        return this.prolongation;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
