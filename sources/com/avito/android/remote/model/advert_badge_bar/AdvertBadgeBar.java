package com.avito.android.remote.model.advert_badge_bar;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBarParams;", "view", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBarParams;", "getView", "()Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBarParams;", "", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadge;", "badges", "Ljava/util/List;", "getBadges", "()Ljava/util/List;", "<init>", "(Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBarParams;Ljava/util/List;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeBar implements Parcelable {
    public static final Parcelable.Creator<AdvertBadgeBar> CREATOR = new Creator();
    @SerializedName("badges")
    @Nullable
    private final List<AdvertBadge> badges;
    @SerializedName("view")
    @Nullable
    private final AdvertBadgeBarParams view;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertBadgeBar> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeBar createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList arrayList = null;
            AdvertBadgeBarParams createFromParcel = parcel.readInt() != 0 ? AdvertBadgeBarParams.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add(AdvertBadge.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                arrayList = arrayList2;
            }
            return new AdvertBadgeBar(createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeBar[] newArray(int i) {
            return new AdvertBadgeBar[i];
        }
    }

    public AdvertBadgeBar(@Nullable AdvertBadgeBarParams advertBadgeBarParams, @Nullable List<AdvertBadge> list) {
        this.view = advertBadgeBarParams;
        this.badges = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<AdvertBadge> getBadges() {
        return this.badges;
    }

    @Nullable
    public final AdvertBadgeBarParams getView() {
        return this.view;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        AdvertBadgeBarParams advertBadgeBarParams = this.view;
        if (advertBadgeBarParams != null) {
            parcel.writeInt(1);
            advertBadgeBarParams.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<AdvertBadge> list = this.badges;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((AdvertBadge) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
