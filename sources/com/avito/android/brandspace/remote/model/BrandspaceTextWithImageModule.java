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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\rJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010)R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\rR\u001c\u0010\u0015\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010\nR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u0012R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b0\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\b4\u0010\u0004R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b5\u0010\r¨\u00068"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;", "component3", "()Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "Lcom/avito/android/remote/model/Action;", "component7", "()Lcom/avito/android/remote/model/Action;", "version", "image", "imagePlacement", "title", "description", "additionalDescription", "action", "copy", "(ILcom/avito/android/remote/model/Image;Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;", "getImagePlacement", "Lcom/avito/android/remote/model/Action;", "getAction", "getDescription", "Lcom/avito/android/remote/model/Image;", "getImage", "I", "getVersion", "getAdditionalDescription", "<init>", "(ILcom/avito/android/remote/model/Image;Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceTextWithImageModule implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceTextWithImageModule> CREATOR = new Creator();
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
    @Nullable
    private final Image image;
    @SerializedName("imagePlacement")
    @NotNull
    private final BrandspaceTextWithImageImagePlacement imagePlacement;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceTextWithImageModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceTextWithImageModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceTextWithImageModule(parcel.readInt(), (Image) parcel.readParcelable(BrandspaceTextWithImageModule.class.getClassLoader()), (BrandspaceTextWithImageImagePlacement) Enum.valueOf(BrandspaceTextWithImageImagePlacement.class, parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(BrandspaceTextWithImageModule.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceTextWithImageModule[] newArray(int i) {
            return new BrandspaceTextWithImageModule[i];
        }
    }

    public BrandspaceTextWithImageModule(int i, @Nullable Image image2, @NotNull BrandspaceTextWithImageImagePlacement brandspaceTextWithImageImagePlacement, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(brandspaceTextWithImageImagePlacement, "imagePlacement");
        this.version = i;
        this.image = image2;
        this.imagePlacement = brandspaceTextWithImageImagePlacement;
        this.title = str;
        this.description = str2;
        this.additionalDescription = str3;
        this.action = action2;
    }

    public static /* synthetic */ BrandspaceTextWithImageModule copy$default(BrandspaceTextWithImageModule brandspaceTextWithImageModule, int i, Image image2, BrandspaceTextWithImageImagePlacement brandspaceTextWithImageImagePlacement, String str, String str2, String str3, Action action2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = brandspaceTextWithImageModule.version;
        }
        if ((i2 & 2) != 0) {
            image2 = brandspaceTextWithImageModule.image;
        }
        if ((i2 & 4) != 0) {
            brandspaceTextWithImageImagePlacement = brandspaceTextWithImageModule.imagePlacement;
        }
        if ((i2 & 8) != 0) {
            str = brandspaceTextWithImageModule.title;
        }
        if ((i2 & 16) != 0) {
            str2 = brandspaceTextWithImageModule.description;
        }
        if ((i2 & 32) != 0) {
            str3 = brandspaceTextWithImageModule.additionalDescription;
        }
        if ((i2 & 64) != 0) {
            action2 = brandspaceTextWithImageModule.action;
        }
        return brandspaceTextWithImageModule.copy(i, image2, brandspaceTextWithImageImagePlacement, str, str2, str3, action2);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final Image component2() {
        return this.image;
    }

    @NotNull
    public final BrandspaceTextWithImageImagePlacement component3() {
        return this.imagePlacement;
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

    @NotNull
    public final BrandspaceTextWithImageModule copy(int i, @Nullable Image image2, @NotNull BrandspaceTextWithImageImagePlacement brandspaceTextWithImageImagePlacement, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(brandspaceTextWithImageImagePlacement, "imagePlacement");
        return new BrandspaceTextWithImageModule(i, image2, brandspaceTextWithImageImagePlacement, str, str2, str3, action2);
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
        if (!(obj instanceof BrandspaceTextWithImageModule)) {
            return false;
        }
        BrandspaceTextWithImageModule brandspaceTextWithImageModule = (BrandspaceTextWithImageModule) obj;
        return this.version == brandspaceTextWithImageModule.version && Intrinsics.areEqual(this.image, brandspaceTextWithImageModule.image) && Intrinsics.areEqual(this.imagePlacement, brandspaceTextWithImageModule.imagePlacement) && Intrinsics.areEqual(this.title, brandspaceTextWithImageModule.title) && Intrinsics.areEqual(this.description, brandspaceTextWithImageModule.description) && Intrinsics.areEqual(this.additionalDescription, brandspaceTextWithImageModule.additionalDescription) && Intrinsics.areEqual(this.action, brandspaceTextWithImageModule.action);
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

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final BrandspaceTextWithImageImagePlacement getImagePlacement() {
        return this.imagePlacement;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        Image image2 = this.image;
        int i2 = 0;
        int hashCode = (i + (image2 != null ? image2.hashCode() : 0)) * 31;
        BrandspaceTextWithImageImagePlacement brandspaceTextWithImageImagePlacement = this.imagePlacement;
        int hashCode2 = (hashCode + (brandspaceTextWithImageImagePlacement != null ? brandspaceTextWithImageImagePlacement.hashCode() : 0)) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.additionalDescription;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Action action2 = this.action;
        if (action2 != null) {
            i2 = action2.hashCode();
        }
        return hashCode5 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceTextWithImageModule(version=");
        L.append(this.version);
        L.append(", image=");
        L.append(this.image);
        L.append(", imagePlacement=");
        L.append(this.imagePlacement);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", additionalDescription=");
        L.append(this.additionalDescription);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.imagePlacement.name());
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.additionalDescription);
        parcel.writeParcelable(this.action, i);
    }
}
