package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/PositionedCommercialCascade;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/SerpElement;", "banners", "Ljava/util/List;", "getBanners", "()Ljava/util/List;", "", VKApiConst.POSITION, "Ljava/lang/String;", "getPosition", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PositionedCommercialCascade implements Parcelable {
    public static final Parcelable.Creator<PositionedCommercialCascade> CREATOR = new Creator();
    @SerializedName("banners")
    @NotNull
    private final List<SerpElement> banners;
    @SerializedName(VKApiConst.POSITION)
    @NotNull
    private final String position;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PositionedCommercialCascade> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PositionedCommercialCascade createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SerpElement) parcel.readParcelable(PositionedCommercialCascade.class.getClassLoader()));
                readInt--;
            }
            return new PositionedCommercialCascade(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PositionedCommercialCascade[] newArray(int i) {
            return new PositionedCommercialCascade[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public PositionedCommercialCascade(@NotNull String str, @NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(str, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(list, "banners");
        this.position = str;
        this.banners = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<SerpElement> getBanners() {
        return this.banners;
    }

    @NotNull
    public final String getPosition() {
        return this.position;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.position);
        Iterator n0 = a.n0(this.banners, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((SerpElement) n0.next(), i);
        }
    }
}
