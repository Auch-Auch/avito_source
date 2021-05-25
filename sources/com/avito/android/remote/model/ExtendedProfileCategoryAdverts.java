package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileCategoryAdverts;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ExtendedProfileAdvertsNextPage;", "nextPage", "Lcom/avito/android/remote/model/ExtendedProfileAdvertsNextPage;", "getNextPage", "()Lcom/avito/android/remote/model/ExtendedProfileAdvertsNextPage;", "", "Lcom/avito/android/remote/model/SerpElement;", "adverts", "Ljava/util/List;", "getAdverts", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/ExtendedProfileAdvertsNextPage;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileCategoryAdverts implements Parcelable {
    public static final Parcelable.Creator<ExtendedProfileCategoryAdverts> CREATOR = new Creator();
    @SerializedName("list")
    @Nullable
    private final List<SerpElement> adverts;
    @SerializedName("nextPage")
    @Nullable
    private final ExtendedProfileAdvertsNextPage nextPage;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedProfileCategoryAdverts> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileCategoryAdverts createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            ExtendedProfileAdvertsNextPage extendedProfileAdvertsNextPage = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((SerpElement) parcel.readParcelable(ExtendedProfileCategoryAdverts.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                extendedProfileAdvertsNextPage = ExtendedProfileAdvertsNextPage.CREATOR.createFromParcel(parcel);
            }
            return new ExtendedProfileCategoryAdverts(arrayList, extendedProfileAdvertsNextPage);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileCategoryAdverts[] newArray(int i) {
            return new ExtendedProfileCategoryAdverts[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtendedProfileCategoryAdverts(@Nullable List<? extends SerpElement> list, @Nullable ExtendedProfileAdvertsNextPage extendedProfileAdvertsNextPage) {
        this.adverts = list;
        this.nextPage = extendedProfileAdvertsNextPage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<SerpElement> getAdverts() {
        return this.adverts;
    }

    @Nullable
    public final ExtendedProfileAdvertsNextPage getNextPage() {
        return this.nextPage;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<SerpElement> list = this.adverts;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((SerpElement) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        ExtendedProfileAdvertsNextPage extendedProfileAdvertsNextPage = this.nextPage;
        if (extendedProfileAdvertsNextPage != null) {
            parcel.writeInt(1);
            extendedProfileAdvertsNextPage.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
