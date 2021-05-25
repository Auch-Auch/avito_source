package com.avito.android.advert_core.feature_teasers.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "getIcon", "()Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "icon", "<init>", "(Ljava/lang/String;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserOption implements Parcelable {
    public static final Parcelable.Creator<AdvertDetailsFeatureTeaserOption> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final AdvertDetailsFeatureTeaserItem.Icon b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsFeatureTeaserOption> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsFeatureTeaserOption createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsFeatureTeaserOption(parcel.readString(), parcel.readInt() != 0 ? (AdvertDetailsFeatureTeaserItem.Icon) Enum.valueOf(AdvertDetailsFeatureTeaserItem.Icon.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsFeatureTeaserOption[] newArray(int i) {
            return new AdvertDetailsFeatureTeaserOption[i];
        }
    }

    public AdvertDetailsFeatureTeaserOption(@NotNull String str, @Nullable AdvertDetailsFeatureTeaserItem.Icon icon) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
        this.b = icon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserItem.Icon getIcon() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        AdvertDetailsFeatureTeaserItem.Icon icon = this.b;
        if (icon != null) {
            parcel.writeInt(1);
            parcel.writeString(icon.name());
            return;
        }
        parcel.writeInt(0);
    }
}
