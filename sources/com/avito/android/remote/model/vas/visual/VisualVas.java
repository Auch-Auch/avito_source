package com.avito.android.remote.model.vas.visual;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001b\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/vas/visual/VisualVas;", "", "", "priceValue", "J", "getPriceValue", "()J", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "id", "getId", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "price", "getPrice", "", "selected", "Z", "getSelected", "()Z", "oldPrice", "getOldPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;JZ)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class VisualVas {
    @SerializedName("description")
    @NotNull
    private final AttributedText description;
    @SerializedName("icon")
    @NotNull
    private final Image icon;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("oldPrice")
    @Nullable
    private final AttributedText oldPrice;
    @SerializedName("price")
    @NotNull
    private final AttributedText price;
    @SerializedName("priceValue")
    private final long priceValue;
    @SerializedName("selected")
    private final boolean selected;
    @SerializedName("title")
    @NotNull
    private final String title;

    public VisualVas(@NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull AttributedText attributedText2, @Nullable AttributedText attributedText3, @NotNull Image image, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText, "description");
        Intrinsics.checkNotNullParameter(attributedText2, "price");
        Intrinsics.checkNotNullParameter(image, "icon");
        this.id = str;
        this.title = str2;
        this.description = attributedText;
        this.price = attributedText2;
        this.oldPrice = attributedText3;
        this.icon = image;
        this.priceValue = j;
        this.selected = z;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.description;
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

    @NotNull
    public final AttributedText getPrice() {
        return this.price;
    }

    public final long getPriceValue() {
        return this.priceValue;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
