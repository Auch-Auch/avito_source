package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\n¨\u0006("}, d2 = {"Lnet/gotev/uploadservice/data/NameValue;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "validateAsHeader", "()Lnet/gotev/uploadservice/data/NameValue;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toPersistableData", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "", "component1", "()Ljava/lang/String;", "component2", "name", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/data/NameValue;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", AuthSource.BOOKING_ORDER, "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class NameValue implements Parcelable, Persistable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lnet/gotev/uploadservice/data/NameValue$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/NameValue;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "data", "createFromPersistableData", "(Lnet/gotev/uploadservice/persistence/PersistableData;)Lnet/gotev/uploadservice/data/NameValue;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion implements Persistable.Creator<NameValue> {
        public Companion() {
        }

        public Companion(j jVar) {
        }

        @Override // net.gotev.uploadservice.persistence.Persistable.Creator
        @NotNull
        public NameValue createFromPersistableData(@NotNull PersistableData persistableData) {
            Intrinsics.checkNotNullParameter(persistableData, "data");
            return new NameValue(persistableData.getString("name"), persistableData.getString("value"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new NameValue(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new NameValue[i];
        }
    }

    public NameValue(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ NameValue copy$default(NameValue nameValue, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nameValue.a;
        }
        if ((i & 2) != 0) {
            str2 = nameValue.b;
        }
        return nameValue.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final NameValue copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new NameValue(str, str2);
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
        if (!(obj instanceof NameValue)) {
            return false;
        }
        NameValue nameValue = (NameValue) obj;
        return Intrinsics.areEqual(this.a, nameValue.a) && Intrinsics.areEqual(this.b, nameValue.b);
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @NotNull
    public final String getValue() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // net.gotev.uploadservice.persistence.Persistable
    @NotNull
    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        persistableData.putString("name", this.a);
        persistableData.putString("value", this.b);
        return persistableData;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("NameValue(name=");
        L.append(this.a);
        L.append(", value=");
        return a.t(L, this.b, ")");
    }

    @NotNull
    public final NameValue validateAsHeader() {
        if (StringExtensionsKt.isASCII(this.a) && StringExtensionsKt.isASCII(this.b)) {
            return this;
        }
        StringBuilder L = a.L("Header ");
        L.append(this.a);
        L.append(" and its value ");
        throw new IllegalArgumentException(a.t(L, this.b, " must be ASCII only! Read http://stackoverflow.com/a/4410331").toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
