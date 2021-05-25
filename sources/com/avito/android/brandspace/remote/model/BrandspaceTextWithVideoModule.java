package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJj\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004J \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010+R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\rR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b.\u0010\rR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b/\u0010\rR\u001c\u0010\u0016\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b1\u0010\nR\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u00106\u001a\u0004\b7\u0010\u0004R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b8\u0010\r¨\u0006;"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;", "component3", "()Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "Lcom/avito/android/remote/model/Action;", "component7", "()Lcom/avito/android/remote/model/Action;", "component8", "version", "image", "videoPlacement", "title", "description", "additionalDescription", "action", "videoUrl", "copy", "(ILcom/avito/android/remote/model/Image;Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getDescription", "getAdditionalDescription", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;", "getVideoPlacement", "Lcom/avito/android/remote/model/Image;", "getImage", "Lcom/avito/android/remote/model/Action;", "getAction", "I", "getVersion", "getVideoUrl", "<init>", "(ILcom/avito/android/remote/model/Image;Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceTextWithVideoModule implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceTextWithVideoModule> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("additionalDescription")
    @Nullable
    private final String additionalDescription;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("version")
    private final int version;
    @SerializedName("videoPlacement")
    @NotNull
    private final BrandspaceTextWithVideoImagePlacement videoPlacement;
    @SerializedName("videoUrl")
    @Nullable
    private final String videoUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceTextWithVideoModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceTextWithVideoModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceTextWithVideoModule(parcel.readInt(), (Image) parcel.readParcelable(BrandspaceTextWithVideoModule.class.getClassLoader()), (BrandspaceTextWithVideoImagePlacement) Enum.valueOf(BrandspaceTextWithVideoImagePlacement.class, parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(BrandspaceTextWithVideoModule.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceTextWithVideoModule[] newArray(int i) {
            return new BrandspaceTextWithVideoModule[i];
        }
    }

    public BrandspaceTextWithVideoModule(int i, @NotNull Image image2, @NotNull BrandspaceTextWithVideoImagePlacement brandspaceTextWithVideoImagePlacement, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(brandspaceTextWithVideoImagePlacement, "videoPlacement");
        this.version = i;
        this.image = image2;
        this.videoPlacement = brandspaceTextWithVideoImagePlacement;
        this.title = str;
        this.description = str2;
        this.additionalDescription = str3;
        this.action = action2;
        this.videoUrl = str4;
    }

    public static /* synthetic */ BrandspaceTextWithVideoModule copy$default(BrandspaceTextWithVideoModule brandspaceTextWithVideoModule, int i, Image image2, BrandspaceTextWithVideoImagePlacement brandspaceTextWithVideoImagePlacement, String str, String str2, String str3, Action action2, String str4, int i2, Object obj) {
        return brandspaceTextWithVideoModule.copy((i2 & 1) != 0 ? brandspaceTextWithVideoModule.version : i, (i2 & 2) != 0 ? brandspaceTextWithVideoModule.image : image2, (i2 & 4) != 0 ? brandspaceTextWithVideoModule.videoPlacement : brandspaceTextWithVideoImagePlacement, (i2 & 8) != 0 ? brandspaceTextWithVideoModule.title : str, (i2 & 16) != 0 ? brandspaceTextWithVideoModule.description : str2, (i2 & 32) != 0 ? brandspaceTextWithVideoModule.additionalDescription : str3, (i2 & 64) != 0 ? brandspaceTextWithVideoModule.action : action2, (i2 & 128) != 0 ? brandspaceTextWithVideoModule.videoUrl : str4);
    }

    public final int component1() {
        return this.version;
    }

    @NotNull
    public final Image component2() {
        return this.image;
    }

    @NotNull
    public final BrandspaceTextWithVideoImagePlacement component3() {
        return this.videoPlacement;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    @Nullable
    public final String component5() {
        return this.description;
    }

    @Nullable
    public final String component6() {
        return this.additionalDescription;
    }

    @Nullable
    public final Action component7() {
        return this.action;
    }

    @Nullable
    public final String component8() {
        return this.videoUrl;
    }

    @NotNull
    public final BrandspaceTextWithVideoModule copy(int i, @NotNull Image image2, @NotNull BrandspaceTextWithVideoImagePlacement brandspaceTextWithVideoImagePlacement, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(brandspaceTextWithVideoImagePlacement, "videoPlacement");
        return new BrandspaceTextWithVideoModule(i, image2, brandspaceTextWithVideoImagePlacement, str, str2, str3, action2, str4);
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
        if (!(obj instanceof BrandspaceTextWithVideoModule)) {
            return false;
        }
        BrandspaceTextWithVideoModule brandspaceTextWithVideoModule = (BrandspaceTextWithVideoModule) obj;
        return this.version == brandspaceTextWithVideoModule.version && Intrinsics.areEqual(this.image, brandspaceTextWithVideoModule.image) && Intrinsics.areEqual(this.videoPlacement, brandspaceTextWithVideoModule.videoPlacement) && Intrinsics.areEqual(this.title, brandspaceTextWithVideoModule.title) && Intrinsics.areEqual(this.description, brandspaceTextWithVideoModule.description) && Intrinsics.areEqual(this.additionalDescription, brandspaceTextWithVideoModule.additionalDescription) && Intrinsics.areEqual(this.action, brandspaceTextWithVideoModule.action) && Intrinsics.areEqual(this.videoUrl, brandspaceTextWithVideoModule.videoUrl);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getAdditionalDescription() {
        return this.additionalDescription;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final BrandspaceTextWithVideoImagePlacement getVideoPlacement() {
        return this.videoPlacement;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        Image image2 = this.image;
        int i2 = 0;
        int hashCode = (i + (image2 != null ? image2.hashCode() : 0)) * 31;
        BrandspaceTextWithVideoImagePlacement brandspaceTextWithVideoImagePlacement = this.videoPlacement;
        int hashCode2 = (hashCode + (brandspaceTextWithVideoImagePlacement != null ? brandspaceTextWithVideoImagePlacement.hashCode() : 0)) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.additionalDescription;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Action action2 = this.action;
        int hashCode6 = (hashCode5 + (action2 != null ? action2.hashCode() : 0)) * 31;
        String str4 = this.videoUrl;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode6 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceTextWithVideoModule(version=");
        L.append(this.version);
        L.append(", image=");
        L.append(this.image);
        L.append(", videoPlacement=");
        L.append(this.videoPlacement);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", additionalDescription=");
        L.append(this.additionalDescription);
        L.append(", action=");
        L.append(this.action);
        L.append(", videoUrl=");
        return a.t(L, this.videoUrl, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.videoPlacement.name());
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.additionalDescription);
        parcel.writeParcelable(this.action, i);
        parcel.writeString(this.videoUrl);
    }
}
