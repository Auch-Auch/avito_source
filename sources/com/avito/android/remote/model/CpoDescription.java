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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\nR\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b$\u0010\nR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010\u0007¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/CpoDescription;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/CpoLogo;", "component1", "()Lcom/avito/android/remote/model/CpoLogo;", "Lcom/avito/android/remote/model/CpoIcon;", "component2", "()Lcom/avito/android/remote/model/CpoIcon;", "", "component3", "()Ljava/lang/String;", "component4", "logo", "icon", "title", "content", "copy", "(Lcom/avito/android/remote/model/CpoLogo;Lcom/avito/android/remote/model/CpoIcon;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/CpoDescription;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getContent", "Lcom/avito/android/remote/model/CpoLogo;", "getLogo", "Lcom/avito/android/remote/model/CpoIcon;", "getIcon", "<init>", "(Lcom/avito/android/remote/model/CpoLogo;Lcom/avito/android/remote/model/CpoIcon;Ljava/lang/String;Ljava/lang/String;)V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class CpoDescription implements Parcelable {
    public static final Parcelable.Creator<CpoDescription> CREATOR = new Creator();
    @SerializedName("content")
    @NotNull
    private final String content;
    @SerializedName("icon")
    @Nullable
    private final CpoIcon icon;
    @SerializedName("logo")
    @NotNull
    private final CpoLogo logo;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CpoDescription> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpoDescription createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CpoDescription(CpoLogo.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? CpoIcon.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpoDescription[] newArray(int i) {
            return new CpoDescription[i];
        }
    }

    public CpoDescription(@NotNull CpoLogo cpoLogo, @Nullable CpoIcon cpoIcon, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(cpoLogo, "logo");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.logo = cpoLogo;
        this.icon = cpoIcon;
        this.title = str;
        this.content = str2;
    }

    public static /* synthetic */ CpoDescription copy$default(CpoDescription cpoDescription, CpoLogo cpoLogo, CpoIcon cpoIcon, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            cpoLogo = cpoDescription.logo;
        }
        if ((i & 2) != 0) {
            cpoIcon = cpoDescription.icon;
        }
        if ((i & 4) != 0) {
            str = cpoDescription.title;
        }
        if ((i & 8) != 0) {
            str2 = cpoDescription.content;
        }
        return cpoDescription.copy(cpoLogo, cpoIcon, str, str2);
    }

    @NotNull
    public final CpoLogo component1() {
        return this.logo;
    }

    @Nullable
    public final CpoIcon component2() {
        return this.icon;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final String component4() {
        return this.content;
    }

    @NotNull
    public final CpoDescription copy(@NotNull CpoLogo cpoLogo, @Nullable CpoIcon cpoIcon, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(cpoLogo, "logo");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        return new CpoDescription(cpoLogo, cpoIcon, str, str2);
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
        if (!(obj instanceof CpoDescription)) {
            return false;
        }
        CpoDescription cpoDescription = (CpoDescription) obj;
        return Intrinsics.areEqual(this.logo, cpoDescription.logo) && Intrinsics.areEqual(this.icon, cpoDescription.icon) && Intrinsics.areEqual(this.title, cpoDescription.title) && Intrinsics.areEqual(this.content, cpoDescription.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final CpoIcon getIcon() {
        return this.icon;
    }

    @NotNull
    public final CpoLogo getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        CpoLogo cpoLogo = this.logo;
        int i = 0;
        int hashCode = (cpoLogo != null ? cpoLogo.hashCode() : 0) * 31;
        CpoIcon cpoIcon = this.icon;
        int hashCode2 = (hashCode + (cpoIcon != null ? cpoIcon.hashCode() : 0)) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.content;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CpoDescription(logo=");
        L.append(this.logo);
        L.append(", icon=");
        L.append(this.icon);
        L.append(", title=");
        L.append(this.title);
        L.append(", content=");
        return a.t(L, this.content, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.logo.writeToParcel(parcel, 0);
        CpoIcon cpoIcon = this.icon;
        if (cpoIcon != null) {
            parcel.writeInt(1);
            cpoIcon.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.title);
        parcel.writeString(this.content);
    }
}
