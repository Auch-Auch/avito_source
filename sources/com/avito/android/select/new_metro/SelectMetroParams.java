package com.avito.android.select.new_metro;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\"\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "getMetroWithLines", "()Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "metroWithLines", "d", "Ljava/lang/Integer;", "getCategoryId", "()Ljava/lang/Integer;", "categoryId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "e", "Ljava/util/List;", "getSelectedValues", "()Ljava/util/List;", "selectedValues", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "requestId", "c", "I", "getLocationId", "locationId", "<init>", "(Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroParams implements Parcelable {
    public static final Parcelable.Creator<SelectMetroParams> CREATOR = new Creator();
    @Nullable
    public final MetroResponseBody a;
    @NotNull
    public final String b;
    public final int c;
    @Nullable
    public final Integer d;
    @NotNull
    public final List<ParcelableEntity<String>> e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SelectMetroParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectMetroParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            MetroResponseBody metroResponseBody = (MetroResponseBody) parcel.readParcelable(SelectMetroParams.class.getClassLoader());
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((ParcelableEntity) parcel.readParcelable(SelectMetroParams.class.getClassLoader()));
                readInt2--;
            }
            return new SelectMetroParams(metroResponseBody, readString, readInt, valueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectMetroParams[] newArray(int i) {
            return new SelectMetroParams[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectMetroParams(@Nullable MetroResponseBody metroResponseBody, @NotNull String str, int i, @Nullable Integer num, @NotNull List<? extends ParcelableEntity<String>> list) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedValues");
        this.a = metroResponseBody;
        this.b = str;
        this.c = i;
        this.d = num;
        this.e = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getCategoryId() {
        return this.d;
    }

    public final int getLocationId() {
        return this.c;
    }

    @Nullable
    public final MetroResponseBody getMetroWithLines() {
        return this.a;
    }

    @NotNull
    public final String getRequestId() {
        return this.b;
    }

    @NotNull
    public final List<ParcelableEntity<String>> getSelectedValues() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        Integer num = this.d;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        Iterator n0 = a.n0(this.e, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ParcelableEntity) n0.next(), i);
        }
    }
}
