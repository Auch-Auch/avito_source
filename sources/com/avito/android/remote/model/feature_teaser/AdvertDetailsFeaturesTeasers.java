package com.avito.android.remote.model.feature_teaser;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/feature_teaser/SafeShow;", "safeShow", "Lcom/avito/android/remote/model/feature_teaser/SafeShow;", "getSafeShow", "()Lcom/avito/android/remote/model/feature_teaser/SafeShow;", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;", "findOfficeOffer", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;", "getFindOfficeOffer", "()Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;", "Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;", "checkedByAvito", "Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;", "getCheckedByAvito", "()Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;", "<init>", "(Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;Lcom/avito/android/remote/model/feature_teaser/SafeShow;Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeaturesTeasers implements Parcelable {
    public static final Parcelable.Creator<AdvertDetailsFeaturesTeasers> CREATOR = new Creator();
    @SerializedName("realtyVerified")
    @Nullable
    private final CheckedByAvito checkedByAvito;
    @SerializedName("findOfficeOffer")
    @Nullable
    private final CreReportTeaser findOfficeOffer;
    @SerializedName("contactlessView")
    @Nullable
    private final SafeShow safeShow;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsFeaturesTeasers> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsFeaturesTeasers createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            SafeShow safeShow = null;
            CheckedByAvito createFromParcel = parcel.readInt() != 0 ? CheckedByAvito.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                safeShow = SafeShow.CREATOR.createFromParcel(parcel);
            }
            return new AdvertDetailsFeaturesTeasers(createFromParcel, safeShow, (CreReportTeaser) parcel.readParcelable(AdvertDetailsFeaturesTeasers.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsFeaturesTeasers[] newArray(int i) {
            return new AdvertDetailsFeaturesTeasers[i];
        }
    }

    public AdvertDetailsFeaturesTeasers() {
        this(null, null, null, 7, null);
    }

    public AdvertDetailsFeaturesTeasers(@Nullable CheckedByAvito checkedByAvito2, @Nullable SafeShow safeShow2, @Nullable CreReportTeaser creReportTeaser) {
        this.checkedByAvito = checkedByAvito2;
        this.safeShow = safeShow2;
        this.findOfficeOffer = creReportTeaser;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final CheckedByAvito getCheckedByAvito() {
        return this.checkedByAvito;
    }

    @Nullable
    public final CreReportTeaser getFindOfficeOffer() {
        return this.findOfficeOffer;
    }

    @Nullable
    public final SafeShow getSafeShow() {
        return this.safeShow;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CheckedByAvito checkedByAvito2 = this.checkedByAvito;
        if (checkedByAvito2 != null) {
            parcel.writeInt(1);
            checkedByAvito2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        SafeShow safeShow2 = this.safeShow;
        if (safeShow2 != null) {
            parcel.writeInt(1);
            safeShow2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.findOfficeOffer, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsFeaturesTeasers(CheckedByAvito checkedByAvito2, SafeShow safeShow2, CreReportTeaser creReportTeaser, int i, j jVar) {
        this((i & 1) != 0 ? null : checkedByAvito2, (i & 2) != 0 ? null : safeShow2, (i & 4) != 0 ? null : creReportTeaser);
    }
}
