package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001f\u001a\u00020\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/FeeMethod;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/HighDemandIcon;", "priceIcon", "Lcom/avito/android/remote/model/HighDemandIcon;", "getPriceIcon", "()Lcom/avito/android/remote/model/HighDemandIcon;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "getTitle", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "", "isHighDemand", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "price", "getPrice", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;Lcom/avito/android/remote/model/HighDemandIcon;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethod {
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("icon")
    @Nullable
    private final Image icon;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("isHighDemand")
    @Nullable
    private final Boolean isHighDemand;
    @SerializedName("price")
    @Nullable
    private final AttributedText price;
    @SerializedName("priceIcon")
    @Nullable
    private final HighDemandIcon priceIcon;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    public FeeMethod(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable Image image, @NotNull DeepLink deepLink, @Nullable Boolean bool, @Nullable HighDemandIcon highDemandIcon) {
        a.W0(str, "id", str2, "title", deepLink, ShareConstants.MEDIA_URI);
        this.id = str;
        this.title = str2;
        this.description = attributedText;
        this.price = attributedText2;
        this.icon = image;
        this.uri = deepLink;
        this.isHighDemand = bool;
        this.priceIcon = highDemandIcon;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AttributedText getPrice() {
        return this.price;
    }

    @Nullable
    public final HighDemandIcon getPriceIcon() {
        return this.priceIcon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }

    @Nullable
    public final Boolean isHighDemand() {
        return this.isHighDemand;
    }
}
