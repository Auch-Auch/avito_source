package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/DateSearchParam;", "Lcom/avito/android/remote/model/SearchParam;", "", "Landroid/os/Parcelable;", "component1", "()Ljava/lang/String;", "value", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/DateSearchParam;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getValue", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DateSearchParam extends SearchParam<String> implements Parcelable {
    public static final Parcelable.Creator<DateSearchParam> CREATOR = new Creator();
    @NotNull
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DateSearchParam> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateSearchParam createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DateSearchParam(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateSearchParam[] newArray(int i) {
            return new DateSearchParam[i];
        }
    }

    public DateSearchParam(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public static /* synthetic */ DateSearchParam copy$default(DateSearchParam dateSearchParam, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateSearchParam.getValue();
        }
        return dateSearchParam.copy(str);
    }

    @NotNull
    public final String component1() {
        return getValue();
    }

    @NotNull
    public final DateSearchParam copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new DateSearchParam(str);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof DateSearchParam) && Intrinsics.areEqual(getValue(), ((DateSearchParam) obj).getValue());
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String value2 = getValue();
        if (value2 != null) {
            return value2.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DateSearchParam(value=");
        L.append(getValue());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.value);
    }

    @Override // com.avito.android.remote.model.SearchParam
    @NotNull
    public String getValue() {
        return this.value;
    }
}
