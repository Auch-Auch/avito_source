package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.badge.Badge;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b#\u0010\u0005J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020$HÖ\u0001¢\u0006\u0004\b,\u0010&J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020$HÖ\u0001¢\u0006\u0004\b1\u00102R\u001c\u00108\u001a\u0002038V@\u0016X\u0004¢\u0006\f\u0012\u0004\b6\u00107\u001a\u0004\b4\u00105R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010\u0005R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u00109\u001a\u0004\b;\u0010\u0005R\u001e\u0010>\u001a\u0004\u0018\u0001038V@\u0016X\u0004¢\u0006\f\u0012\u0004\b=\u00107\u001a\u0004\b<\u00105R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b@\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\bA\u0010\u0005R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\bB\u0010\u0005R\u001c\u0010\u0017\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010?\u001a\u0004\bC\u0010\tR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010?\u001a\u0004\bD\u0010\tR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\bE\u0010\u0005R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010?\u001a\u0004\bF\u0010\tR\u001e\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\bG\u0010\u0005R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u00109\u001a\u0004\bH\u0010\u0005R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010I\u001a\u0004\bJ\u0010\u0012¨\u0006M"}, d2 = {"Lcom/avito/android/remote/model/PriceBadge;", "Lcom/avito/android/remote/model/badge/Badge;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Color;", "component3", "()Lcom/avito/android/remote/model/Color;", "component4", "component5", "component6", "component7", "component8", "component9", "Lcom/avito/android/remote/model/MarketPriceImageName;", "component10", "()Lcom/avito/android/remote/model/MarketPriceImageName;", "component11", "component12", "title", MessengerShareContentUtility.SUBTITLE, "titleColor", "titleColorDark", "titleColorName", "backgroundColor", "backgroundColorDark", "backgroundColorName", "url", "image", "marketPrice", "priceType", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/MarketPriceImageName;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/PriceBadge;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "getUniversalTitleColor", "()Lcom/avito/android/remote/model/UniversalColor;", "getUniversalTitleColor$annotations", "()V", "universalTitleColor", "Ljava/lang/String;", "getMarketPrice", "getTitle", "getUniversalBackgroundColor", "getUniversalBackgroundColor$annotations", "universalBackgroundColor", "Lcom/avito/android/remote/model/Color;", "getTitleColorDark", "getTitleColorName", "getSubtitle", "getTitleColor", "getBackgroundColorDark", "getUrl", "getBackgroundColor", "getPriceType", "getBackgroundColorName", "Lcom/avito/android/remote/model/MarketPriceImageName;", "getImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/MarketPriceImageName;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PriceBadge implements Badge, Parcelable {
    public static final Parcelable.Creator<PriceBadge> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @Nullable
    private final Color backgroundColor;
    @SerializedName("backgroundColorDark")
    @Nullable
    private final Color backgroundColorDark;
    @SerializedName("backgroundColorName")
    @Nullable
    private final String backgroundColorName;
    @SerializedName("image")
    @Nullable
    private final MarketPriceImageName image;
    @SerializedName("marketPrice")
    @Nullable
    private final String marketPrice;
    @SerializedName("priceType")
    @Nullable
    private final String priceType;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("titleColor")
    @NotNull
    private final Color titleColor;
    @SerializedName("titleColorDark")
    @Nullable
    private final Color titleColorDark;
    @SerializedName("titleColorName")
    @Nullable
    private final String titleColorName;
    @SerializedName("url")
    @Nullable
    private final String url;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PriceBadge> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceBadge createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Parcelable.Creator<Color> creator = Color.CREATOR;
            return new PriceBadge(readString, readString2, creator.createFromParcel(parcel), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (MarketPriceImageName) Enum.valueOf(MarketPriceImageName.class, parcel.readString()) : null, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceBadge[] newArray(int i) {
            return new PriceBadge[i];
        }
    }

    public PriceBadge(@NotNull String str, @Nullable String str2, @NotNull Color color, @Nullable Color color2, @Nullable String str3, @Nullable Color color3, @Nullable Color color4, @Nullable String str4, @Nullable String str5, @Nullable MarketPriceImageName marketPriceImageName, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(color, "titleColor");
        this.title = str;
        this.subtitle = str2;
        this.titleColor = color;
        this.titleColorDark = color2;
        this.titleColorName = str3;
        this.backgroundColor = color3;
        this.backgroundColorDark = color4;
        this.backgroundColorName = str4;
        this.url = str5;
        this.image = marketPriceImageName;
        this.marketPrice = str6;
        this.priceType = str7;
    }

    public static /* synthetic */ PriceBadge copy$default(PriceBadge priceBadge, String str, String str2, Color color, Color color2, String str3, Color color3, Color color4, String str4, String str5, MarketPriceImageName marketPriceImageName, String str6, String str7, int i, Object obj) {
        return priceBadge.copy((i & 1) != 0 ? priceBadge.getTitle() : str, (i & 2) != 0 ? priceBadge.subtitle : str2, (i & 4) != 0 ? priceBadge.titleColor : color, (i & 8) != 0 ? priceBadge.titleColorDark : color2, (i & 16) != 0 ? priceBadge.titleColorName : str3, (i & 32) != 0 ? priceBadge.backgroundColor : color3, (i & 64) != 0 ? priceBadge.backgroundColorDark : color4, (i & 128) != 0 ? priceBadge.backgroundColorName : str4, (i & 256) != 0 ? priceBadge.url : str5, (i & 512) != 0 ? priceBadge.image : marketPriceImageName, (i & 1024) != 0 ? priceBadge.marketPrice : str6, (i & 2048) != 0 ? priceBadge.priceType : str7);
    }

    public static /* synthetic */ void getUniversalBackgroundColor$annotations() {
    }

    public static /* synthetic */ void getUniversalTitleColor$annotations() {
    }

    @NotNull
    public final String component1() {
        return getTitle();
    }

    @Nullable
    public final MarketPriceImageName component10() {
        return this.image;
    }

    @Nullable
    public final String component11() {
        return this.marketPrice;
    }

    @Nullable
    public final String component12() {
        return this.priceType;
    }

    @Nullable
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final Color component3() {
        return this.titleColor;
    }

    @Nullable
    public final Color component4() {
        return this.titleColorDark;
    }

    @Nullable
    public final String component5() {
        return this.titleColorName;
    }

    @Nullable
    public final Color component6() {
        return this.backgroundColor;
    }

    @Nullable
    public final Color component7() {
        return this.backgroundColorDark;
    }

    @Nullable
    public final String component8() {
        return this.backgroundColorName;
    }

    @Nullable
    public final String component9() {
        return this.url;
    }

    @NotNull
    public final PriceBadge copy(@NotNull String str, @Nullable String str2, @NotNull Color color, @Nullable Color color2, @Nullable String str3, @Nullable Color color3, @Nullable Color color4, @Nullable String str4, @Nullable String str5, @Nullable MarketPriceImageName marketPriceImageName, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(color, "titleColor");
        return new PriceBadge(str, str2, color, color2, str3, color3, color4, str4, str5, marketPriceImageName, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PriceBadge)) {
            return false;
        }
        PriceBadge priceBadge = (PriceBadge) obj;
        return Intrinsics.areEqual(getTitle(), priceBadge.getTitle()) && Intrinsics.areEqual(this.subtitle, priceBadge.subtitle) && Intrinsics.areEqual(this.titleColor, priceBadge.titleColor) && Intrinsics.areEqual(this.titleColorDark, priceBadge.titleColorDark) && Intrinsics.areEqual(this.titleColorName, priceBadge.titleColorName) && Intrinsics.areEqual(this.backgroundColor, priceBadge.backgroundColor) && Intrinsics.areEqual(this.backgroundColorDark, priceBadge.backgroundColorDark) && Intrinsics.areEqual(this.backgroundColorName, priceBadge.backgroundColorName) && Intrinsics.areEqual(this.url, priceBadge.url) && Intrinsics.areEqual(this.image, priceBadge.image) && Intrinsics.areEqual(this.marketPrice, priceBadge.marketPrice) && Intrinsics.areEqual(this.priceType, priceBadge.priceType);
    }

    @Nullable
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Color getBackgroundColorDark() {
        return this.backgroundColorDark;
    }

    @Nullable
    public final String getBackgroundColorName() {
        return this.backgroundColorName;
    }

    @Nullable
    public final MarketPriceImageName getImage() {
        return this.image;
    }

    @Nullable
    public final String getMarketPrice() {
        return this.marketPrice;
    }

    @Nullable
    public final String getPriceType() {
        return this.priceType;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public final Color getTitleColor() {
        return this.titleColor;
    }

    @Nullable
    public final Color getTitleColorDark() {
        return this.titleColorDark;
    }

    @Nullable
    public final String getTitleColorName() {
        return this.titleColorName;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @Nullable
    public UniversalColor getUniversalBackgroundColor() {
        Color color = this.backgroundColor;
        if (color == null && this.backgroundColorName == null) {
            return null;
        }
        return UniversalColorKt.universalColorOf(this.backgroundColorName, color, this.backgroundColorDark);
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @NotNull
    public UniversalColor getUniversalTitleColor() {
        return UniversalColorKt.universalColorOf(this.titleColorName, this.titleColor, this.titleColorDark);
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String title2 = getTitle();
        int i = 0;
        int hashCode = (title2 != null ? title2.hashCode() : 0) * 31;
        String str = this.subtitle;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Color color = this.titleColor;
        int hashCode3 = (hashCode2 + (color != null ? color.hashCode() : 0)) * 31;
        Color color2 = this.titleColorDark;
        int hashCode4 = (hashCode3 + (color2 != null ? color2.hashCode() : 0)) * 31;
        String str2 = this.titleColorName;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Color color3 = this.backgroundColor;
        int hashCode6 = (hashCode5 + (color3 != null ? color3.hashCode() : 0)) * 31;
        Color color4 = this.backgroundColorDark;
        int hashCode7 = (hashCode6 + (color4 != null ? color4.hashCode() : 0)) * 31;
        String str3 = this.backgroundColorName;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        MarketPriceImageName marketPriceImageName = this.image;
        int hashCode10 = (hashCode9 + (marketPriceImageName != null ? marketPriceImageName.hashCode() : 0)) * 31;
        String str5 = this.marketPrice;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.priceType;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode11 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PriceBadge(title=");
        L.append(getTitle());
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", titleColor=");
        L.append(this.titleColor);
        L.append(", titleColorDark=");
        L.append(this.titleColorDark);
        L.append(", titleColorName=");
        L.append(this.titleColorName);
        L.append(", backgroundColor=");
        L.append(this.backgroundColor);
        L.append(", backgroundColorDark=");
        L.append(this.backgroundColorDark);
        L.append(", backgroundColorName=");
        L.append(this.backgroundColorName);
        L.append(", url=");
        L.append(this.url);
        L.append(", image=");
        L.append(this.image);
        L.append(", marketPrice=");
        L.append(this.marketPrice);
        L.append(", priceType=");
        return a.t(L, this.priceType, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        this.titleColor.writeToParcel(parcel, 0);
        Color color = this.titleColorDark;
        if (color != null) {
            parcel.writeInt(1);
            color.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.titleColorName);
        Color color2 = this.backgroundColor;
        if (color2 != null) {
            parcel.writeInt(1);
            color2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Color color3 = this.backgroundColorDark;
        if (color3 != null) {
            parcel.writeInt(1);
            color3.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.backgroundColorName);
        parcel.writeString(this.url);
        MarketPriceImageName marketPriceImageName = this.image;
        if (marketPriceImageName != null) {
            parcel.writeInt(1);
            parcel.writeString(marketPriceImageName.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.marketPrice);
        parcel.writeString(this.priceType);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceBadge(String str, String str2, Color color, Color color2, String str3, Color color3, Color color4, String str4, String str5, MarketPriceImageName marketPriceImageName, String str6, String str7, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, color, (i & 8) != 0 ? null : color2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : color3, (i & 64) != 0 ? null : color4, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : marketPriceImageName, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7);
    }
}
