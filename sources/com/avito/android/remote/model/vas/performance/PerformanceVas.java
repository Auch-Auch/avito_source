package com.avito.android.remote.model.vas.performance;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001d\u001a\u00020\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/vas/performance/PerformanceVas;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "getId", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "Lcom/avito/android/remote/model/text/AttributedText;", "getPrice", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "getTitle", "oldPrice", "getOldPrice", "", "priceValue", "J", "getPriceValue", "()J", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;JLcom/avito/android/deep_linking/links/DeepLink;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVas {
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("icon")
    @NotNull
    private final Image icon;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("oldPrice")
    @Nullable
    private final AttributedText oldPrice;
    @SerializedName("price")
    @NotNull
    private final AttributedText price;
    @SerializedName("priceValue")
    private final long priceValue;
    @SerializedName("title")
    @NotNull
    private final String title;

    public PerformanceVas(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @NotNull Image image, long j, @Nullable DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(attributedText, "price");
        Intrinsics.checkNotNullParameter(image, "icon");
        this.id = str;
        this.title = str2;
        this.name = str3;
        this.price = attributedText;
        this.oldPrice = attributedText2;
        this.icon = image;
        this.priceValue = j;
        this.deepLink = deepLink2;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @NotNull
    public final Image getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final AttributedText getOldPrice() {
        return this.oldPrice;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.price;
    }

    public final long getPriceValue() {
        return this.priceValue;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
