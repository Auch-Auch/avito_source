package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0011\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010¨\u0006#"}, d2 = {"Lru/avito/messenger/api/entity/Avatar;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "Lru/avito/messenger/api/entity/Image;", "component2", "()Lru/avito/messenger/api/entity/Image;", "default", "image", "copy", "(Ljava/lang/String;Lru/avito/messenger/api/entity/Image;)Lru/avito/messenger/api/entity/Avatar;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDefault", "Lru/avito/messenger/api/entity/Image;", "getImage", "<init>", "(Ljava/lang/String;Lru/avito/messenger/api/entity/Image;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Avatar implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Avatar> CREATOR = Parcels.creator(Avatar$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("default")
    @NotNull

    /* renamed from: default  reason: not valid java name */
    private final String f12default;
    @SerializedName("images")
    @Nullable
    private final Image image;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/Avatar$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/Avatar;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Avatar(@NotNull String str, @Nullable Image image2) {
        Intrinsics.checkNotNullParameter(str, "default");
        this.f12default = str;
        this.image = image2;
    }

    public static /* synthetic */ Avatar copy$default(Avatar avatar, String str, Image image2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = avatar.f12default;
        }
        if ((i & 2) != 0) {
            image2 = avatar.image;
        }
        return avatar.copy(str, image2);
    }

    @NotNull
    public final String component1() {
        return this.f12default;
    }

    @Nullable
    public final Image component2() {
        return this.image;
    }

    @NotNull
    public final Avatar copy(@NotNull String str, @Nullable Image image2) {
        Intrinsics.checkNotNullParameter(str, "default");
        return new Avatar(str, image2);
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
        if (!(obj instanceof Avatar)) {
            return false;
        }
        Avatar avatar = (Avatar) obj;
        return Intrinsics.areEqual(this.f12default, avatar.f12default) && Intrinsics.areEqual(this.image, avatar.image);
    }

    @NotNull
    public final String getDefault() {
        return this.f12default;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.f12default;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Image image2 = this.image;
        if (image2 != null) {
            i = image2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Avatar(default=");
        L.append(this.f12default);
        L.append(", image=");
        L.append(this.image);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.f12default);
        parcel.writeParcelable(this.image, i);
    }
}
