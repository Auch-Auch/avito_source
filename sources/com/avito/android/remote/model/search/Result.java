package com.avito.android.remote.model.search;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/search/Result;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/search/Filter;", "filters", "Ljava/util/List;", "getFilters", "()Ljava/util/List;", "Lcom/avito/android/remote/model/search/Header;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "Lcom/avito/android/remote/model/search/Header;", "getHeader", "()Lcom/avito/android/remote/model/search/Header;", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/remote/model/search/Header;Ljava/util/List;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Result implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new Creator();
    @SerializedName("filters")
    @Nullable
    private final List<Filter> filters;
    @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
    @Nullable
    private final Header header;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink uri;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Result> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Result createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList arrayList = null;
            Header createFromParcel = parcel.readInt() != 0 ? Header.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add(Filter.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                arrayList = arrayList2;
            }
            return new Result(createFromParcel, arrayList, (DeepLink) parcel.readParcelable(Result.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Result[] newArray(int i) {
            return new Result[i];
        }
    }

    public Result(@Nullable Header header2, @Nullable List<Filter> list, @Nullable DeepLink deepLink) {
        this.header = header2;
        this.filters = list;
        this.uri = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<Filter> getFilters() {
        return this.filters;
    }

    @Nullable
    public final Header getHeader() {
        return this.header;
    }

    @Nullable
    public final DeepLink getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Header header2 = this.header;
        if (header2 != null) {
            parcel.writeInt(1);
            header2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<Filter> list = this.filters;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Filter) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.uri, i);
    }
}
