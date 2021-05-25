package com.avito.android.remote.model.metro_lines;

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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/metro_lines/MetroLine;", "lines", "Ljava/util/List;", "getLines", "()Ljava/util/List;", "Lcom/avito/android/remote/model/metro_lines/MetroStation;", "stations", "getStations", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MetroResponseBody implements Parcelable {
    public static final Parcelable.Creator<MetroResponseBody> CREATOR = new Creator();
    @SerializedName("lines")
    @NotNull
    private final List<MetroLine> lines;
    @SerializedName("stations")
    @NotNull
    private final List<MetroStation> stations;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MetroResponseBody> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroResponseBody createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(MetroLine.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add(MetroStation.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new MetroResponseBody(arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroResponseBody[] newArray(int i) {
            return new MetroResponseBody[i];
        }
    }

    public MetroResponseBody(@NotNull List<MetroLine> list, @NotNull List<MetroStation> list2) {
        Intrinsics.checkNotNullParameter(list, "lines");
        Intrinsics.checkNotNullParameter(list2, "stations");
        this.lines = list;
        this.stations = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<MetroLine> getLines() {
        return this.lines;
    }

    @NotNull
    public final List<MetroStation> getStations() {
        return this.stations;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.lines, parcel);
        while (n0.hasNext()) {
            ((MetroLine) n0.next()).writeToParcel(parcel, 0);
        }
        Iterator n02 = a.n0(this.stations, parcel);
        while (n02.hasNext()) {
            ((MetroStation) n02.next()).writeToParcel(parcel, 0);
        }
    }
}
