package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\u0013R\u001c\u0010\u0019\u001a\u00020\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b\"\u0010\u0013¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/Metro;", "Lcom/avito/android/remote/model/Sublocation;", "", "describeContents", "()I", "Landroid/os/Parcel;", VKApiConst.OUT, "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "component1", "component2", "Lcom/avito/android/remote/model/Coordinates;", "component3", "()Lcom/avito/android/remote/model/Coordinates;", "id", "name", "coordinates", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)Lcom/avito/android/remote/model/Metro;", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "Ljava/lang/String;", "getName", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Metro implements Sublocation {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Metro> CREATOR = Parcels.creator(Metro$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(ParameterId.COORDS)
    @Nullable
    private final Coordinates coordinates;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("name")
    @NotNull
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Metro$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Metro;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public Metro(@NotNull String str, @NotNull String str2, @Nullable Coordinates coordinates2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.id = str;
        this.name = str2;
        this.coordinates = coordinates2;
    }

    public static /* synthetic */ Metro copy$default(Metro metro, String str, String str2, Coordinates coordinates2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metro.getId();
        }
        if ((i & 2) != 0) {
            str2 = metro.getName();
        }
        if ((i & 4) != 0) {
            coordinates2 = metro.coordinates;
        }
        return metro.copy(str, str2, coordinates2);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return getName();
    }

    @Nullable
    public final Coordinates component3() {
        return this.coordinates;
    }

    @NotNull
    public final Metro copy(@NotNull String str, @NotNull String str2, @Nullable Coordinates coordinates2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new Metro(str, str2, coordinates2);
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
        if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, Metro.class)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.Metro");
        return !(Intrinsics.areEqual(getId(), ((Metro) obj).getId()) ^ true);
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Metro(id='");
        L.append(getId());
        L.append("', name='");
        L.append(getName());
        L.append("', coordinates=");
        L.append(this.coordinates);
        L.append(')');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
        parcel.writeString(getId());
        parcel.writeString(getName());
        parcel.writeParcelable(this.coordinates, i);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }
}
