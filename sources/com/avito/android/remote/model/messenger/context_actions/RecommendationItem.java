package com.avito.android.remote.model.messenger.context_actions;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.stats.CodePackage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B5\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JF\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\tR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b(\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/RecommendationItem;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "component5", "id", "title", "price", "image", "location", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/context_actions/RecommendationItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getLocation", "getId", "Lcom/avito/android/remote/model/Image;", "getImage", "getPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendationItem implements Parcelable {
    public static final Parcelable.Creator<RecommendationItem> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String ID = "id";
    @NotNull
    public static final String IMAGE = "imageBySizes";
    @NotNull
    public static final String LOCATION = "locationWithMetro";
    @NotNull
    public static final String PRICE = "priceString";
    @NotNull
    public static final String TITLE = "title";
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("imageBySizes")
    @Nullable
    private final Image image;
    @SerializedName("locationWithMetro")
    @Nullable
    private final String location;
    @SerializedName("priceString")
    @NotNull
    private final String price;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/RecommendationItem$Companion;", "", "", "ID", "Ljava/lang/String;", ShareConstants.IMAGE_URL, CodePackage.LOCATION, "PRICE", ShareConstants.TITLE, "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RecommendationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RecommendationItem(parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(RecommendationItem.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendationItem[] newArray(int i) {
            return new RecommendationItem[i];
        }
    }

    public RecommendationItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Image image2, @Nullable String str4) {
        a.Z0(str, "id", str2, "title", str3, "price");
        this.id = str;
        this.title = str2;
        this.price = str3;
        this.image = image2;
        this.location = str4;
    }

    public static /* synthetic */ RecommendationItem copy$default(RecommendationItem recommendationItem, String str, String str2, String str3, Image image2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recommendationItem.id;
        }
        if ((i & 2) != 0) {
            str2 = recommendationItem.title;
        }
        if ((i & 4) != 0) {
            str3 = recommendationItem.price;
        }
        if ((i & 8) != 0) {
            image2 = recommendationItem.image;
        }
        if ((i & 16) != 0) {
            str4 = recommendationItem.location;
        }
        return recommendationItem.copy(str, str2, str3, image2, str4);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.price;
    }

    @Nullable
    public final Image component4() {
        return this.image;
    }

    @Nullable
    public final String component5() {
        return this.location;
    }

    @NotNull
    public final RecommendationItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Image image2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "price");
        return new RecommendationItem(str, str2, str3, image2, str4);
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
        if (!(obj instanceof RecommendationItem)) {
            return false;
        }
        RecommendationItem recommendationItem = (RecommendationItem) obj;
        return Intrinsics.areEqual(this.id, recommendationItem.id) && Intrinsics.areEqual(this.title, recommendationItem.title) && Intrinsics.areEqual(this.price, recommendationItem.price) && Intrinsics.areEqual(this.image, recommendationItem.image) && Intrinsics.areEqual(this.location, recommendationItem.location);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.price;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode4 = (hashCode3 + (image2 != null ? image2.hashCode() : 0)) * 31;
        String str4 = this.location;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RecommendationItem(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", price=");
        L.append(this.price);
        L.append(", image=");
        L.append(this.image);
        L.append(", location=");
        return a.t(L, this.location, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.price);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.location);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendationItem(String str, String str2, String str3, Image image2, String str4, int i, j jVar) {
        this(str, str2, str3, image2, (i & 16) != 0 ? null : str4);
    }
}
