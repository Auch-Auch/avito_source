package com.avito.android.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 B\u0019\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010!J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001c\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\r¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/SimpleLocation;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Entity;", "", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/CaseText;", "names", "Lcom/avito/android/remote/model/CaseText;", "getNames", "()Lcom/avito/android/remote/model/CaseText;", "getName", "name", "id", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleLocation implements Parcelable, Entity<String> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SimpleLocation> CREATOR = Parcels.creator(SimpleLocation$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("names")
    @NotNull
    private final CaseText names;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SimpleLocation$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SimpleLocation;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SimpleLocation(@NotNull String str, @NotNull CaseText caseText) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(caseText, "names");
        this.id = str;
        this.names = caseText;
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
        if (obj != null && (obj instanceof Location)) {
            return Intrinsics.areEqual(((Location) obj).getId(), getId());
        }
        return false;
    }

    @Override // com.avito.android.remote.model.Entity
    @Nullable
    public String getName() {
        return this.names.getName();
    }

    @NotNull
    public final CaseText getNames() {
        return this.names;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode() + 31;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Location[");
        L.append(getId());
        L.append(", ");
        L.append(getName());
        L.append(']');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getId());
        parcel.writeParcelable(this.names, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleLocation(@NotNull String str, @NotNull String str2) {
        this(str, new CaseText());
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.names.setName(1, str2);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }
}
