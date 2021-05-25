package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\tR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b'\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b(\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\f¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/AdvertHistoryInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "", "component5", "()Ljava/lang/Boolean;", "title", "price", "hint", "image", "autoPublish", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/AdvertHistoryInfo;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/String;", "getHint", "getPrice", "getTitle", "Ljava/lang/Boolean;", "getAutoPublish", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertHistoryInfo implements Parcelable {
    public static final Parcelable.Creator<AdvertHistoryInfo> CREATOR = new Creator();
    @SerializedName("autopublish")
    @Nullable
    private final Boolean autoPublish;
    @SerializedName("occupation_hint")
    @NotNull
    private final String hint;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("price")
    @NotNull
    private final String price;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertHistoryInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertHistoryInfo createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Image image = (Image) parcel.readParcelable(AdvertHistoryInfo.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new AdvertHistoryInfo(readString, readString2, readString3, image, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertHistoryInfo[] newArray(int i) {
            return new AdvertHistoryInfo[i];
        }
    }

    public AdvertHistoryInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Image image2, @Nullable Boolean bool) {
        a.Z0(str, "title", str2, "price", str3, "hint");
        this.title = str;
        this.price = str2;
        this.hint = str3;
        this.image = image2;
        this.autoPublish = bool;
    }

    public static /* synthetic */ AdvertHistoryInfo copy$default(AdvertHistoryInfo advertHistoryInfo, String str, String str2, String str3, Image image2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advertHistoryInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = advertHistoryInfo.price;
        }
        if ((i & 4) != 0) {
            str3 = advertHistoryInfo.hint;
        }
        if ((i & 8) != 0) {
            image2 = advertHistoryInfo.image;
        }
        if ((i & 16) != 0) {
            bool = advertHistoryInfo.autoPublish;
        }
        return advertHistoryInfo.copy(str, str2, str3, image2, bool);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.price;
    }

    @NotNull
    public final String component3() {
        return this.hint;
    }

    @Nullable
    public final Image component4() {
        return this.image;
    }

    @Nullable
    public final Boolean component5() {
        return this.autoPublish;
    }

    @NotNull
    public final AdvertHistoryInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Image image2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "price");
        Intrinsics.checkNotNullParameter(str3, "hint");
        return new AdvertHistoryInfo(str, str2, str3, image2, bool);
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
        if (!(obj instanceof AdvertHistoryInfo)) {
            return false;
        }
        AdvertHistoryInfo advertHistoryInfo = (AdvertHistoryInfo) obj;
        return Intrinsics.areEqual(this.title, advertHistoryInfo.title) && Intrinsics.areEqual(this.price, advertHistoryInfo.price) && Intrinsics.areEqual(this.hint, advertHistoryInfo.hint) && Intrinsics.areEqual(this.image, advertHistoryInfo.image) && Intrinsics.areEqual(this.autoPublish, advertHistoryInfo.autoPublish);
    }

    @Nullable
    public final Boolean getAutoPublish() {
        return this.autoPublish;
    }

    @NotNull
    public final String getHint() {
        return this.hint;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
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
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.price;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.hint;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode4 = (hashCode3 + (image2 != null ? image2.hashCode() : 0)) * 31;
        Boolean bool = this.autoPublish;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertHistoryInfo(title=");
        L.append(this.title);
        L.append(", price=");
        L.append(this.price);
        L.append(", hint=");
        L.append(this.hint);
        L.append(", image=");
        L.append(this.image);
        L.append(", autoPublish=");
        return a.o(L, this.autoPublish, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.price);
        parcel.writeString(this.hint);
        parcel.writeParcelable(this.image, i);
        Boolean bool = this.autoPublish;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertHistoryInfo(String str, String str2, String str3, Image image2, Boolean bool, int i, j jVar) {
        this(str, str2, str3, (i & 8) != 0 ? null : image2, (i & 16) != 0 ? null : bool);
    }
}
