package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.search.map.Area;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/AreaSearchParams;", "Lcom/avito/android/remote/model/SearchParam;", "Lcom/avito/android/remote/model/search/map/Area;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "value", "Lcom/avito/android/remote/model/search/map/Area;", "getValue", "()Lcom/avito/android/remote/model/search/map/Area;", "<init>", "(Lcom/avito/android/remote/model/search/map/Area;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AreaSearchParams extends SearchParam<Area> {
    public static final Parcelable.Creator<AreaSearchParams> CREATOR = new Creator();
    @NotNull
    private final Area value;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AreaSearchParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AreaSearchParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AreaSearchParams((Area) parcel.readParcelable(AreaSearchParams.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AreaSearchParams[] newArray(int i) {
            return new AreaSearchParams[i];
        }
    }

    public AreaSearchParams(@NotNull Area area) {
        Intrinsics.checkNotNullParameter(area, "value");
        this.value = area;
    }

    @Override // com.avito.android.remote.model.SearchParam
    @NotNull
    public Area getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.value, i);
    }
}
