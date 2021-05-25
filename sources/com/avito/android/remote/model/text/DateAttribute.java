package com.avito.android.remote.model.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\tR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/text/DateAttribute;", "Lcom/avito/android/remote/model/text/Attribute;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Long;", "name", "title", "format", "timestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/avito/android/remote/model/text/DateAttribute;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/lang/Long;", "getTimestamp", "getFormat", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DateAttribute extends Attribute {
    public static final Parcelable.Creator<DateAttribute> CREATOR = new Creator();
    @Nullable
    private final String format;
    @NotNull
    private final String name;
    @Nullable
    private final Long timestamp;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DateAttribute> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateAttribute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DateAttribute(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateAttribute[] newArray(int i) {
            return new DateAttribute[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DateAttribute(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.name = str;
        this.title = str2;
        this.format = str3;
        this.timestamp = l;
    }

    public static /* synthetic */ DateAttribute copy$default(DateAttribute dateAttribute, String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateAttribute.getName();
        }
        if ((i & 2) != 0) {
            str2 = dateAttribute.getTitle();
        }
        if ((i & 4) != 0) {
            str3 = dateAttribute.format;
        }
        if ((i & 8) != 0) {
            l = dateAttribute.timestamp;
        }
        return dateAttribute.copy(str, str2, str3, l);
    }

    @NotNull
    public final String component1() {
        return getName();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @Nullable
    public final String component3() {
        return this.format;
    }

    @Nullable
    public final Long component4() {
        return this.timestamp;
    }

    @NotNull
    public final DateAttribute copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new DateAttribute(str, str2, str3, l);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateAttribute)) {
            return false;
        }
        DateAttribute dateAttribute = (DateAttribute) obj;
        return Intrinsics.areEqual(getName(), dateAttribute.getName()) && Intrinsics.areEqual(getTitle(), dateAttribute.getTitle()) && Intrinsics.areEqual(this.format, dateAttribute.format) && Intrinsics.areEqual(this.timestamp, dateAttribute.timestamp);
    }

    @Nullable
    public final String getFormat() {
        return this.format;
    }

    @Override // com.avito.android.remote.model.text.Attribute
    @NotNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.avito.android.remote.model.text.Attribute
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String name2 = getName();
        int i = 0;
        int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        String str = this.format;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.timestamp;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DateAttribute(name=");
        L.append(getName());
        L.append(", title=");
        L.append(getTitle());
        L.append(", format=");
        L.append(this.format);
        L.append(", timestamp=");
        L.append(this.timestamp);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.format);
        Long l = this.timestamp;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
    }
}
