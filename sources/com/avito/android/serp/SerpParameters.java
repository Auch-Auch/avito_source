package com.avito.android.serp;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/serp/SerpParameters;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "context", "copy", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;)Lcom/avito/android/serp/SerpParameters;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContext", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "()Lcom/avito/android/remote/model/SearchParams;", "<init>", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;)V", "CREATOR", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpParameters implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @NotNull
    public final SearchParams a;
    @Nullable
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/SerpParameters$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/SerpParameters;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/serp/SerpParameters;", "", "size", "", "newArray", "(I)[Lcom/avito/android/serp/SerpParameters;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<SerpParameters> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SerpParameters createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SerpParameters((SearchParams) a.z1(SearchParams.class, parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SerpParameters[] newArray(int i) {
            return new SerpParameters[i];
        }
    }

    public SerpParameters(@NotNull SearchParams searchParams, @Nullable String str) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        this.a = searchParams;
        this.b = str;
    }

    @NotNull
    public final SerpParameters copy(@NotNull SearchParams searchParams, @Nullable String str) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return new SerpParameters(searchParams, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getContext() {
        return this.b;
    }

    @NotNull
    public final SearchParams getSearchParams() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
    }
}
