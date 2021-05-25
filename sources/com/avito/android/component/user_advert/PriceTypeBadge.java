package com.avito.android.component.user_advert;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.badge.Badge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/avito/android/component/user_advert/PriceTypeBadge;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/badge/Badge;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "c", "Lcom/avito/android/remote/model/UniversalColor;", "getUniversalBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "universalBackgroundColor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getUniversalTitleColor", "universalTitleColor", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PriceTypeBadge implements Parcelable, Badge {
    public static final Parcelable.Creator<PriceTypeBadge> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final UniversalColor b;
    @Nullable
    public final UniversalColor c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PriceTypeBadge> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceTypeBadge createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PriceTypeBadge(parcel.readString(), (UniversalColor) parcel.readParcelable(PriceTypeBadge.class.getClassLoader()), (UniversalColor) parcel.readParcelable(PriceTypeBadge.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceTypeBadge[] newArray(int i) {
            return new PriceTypeBadge[i];
        }
    }

    public PriceTypeBadge(@NotNull String str, @NotNull UniversalColor universalColor, @Nullable UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(universalColor, "universalTitleColor");
        this.a = str;
        this.b = universalColor;
        this.c = universalColor2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @NotNull
    public String getTitle() {
        return this.a;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @Nullable
    public UniversalColor getUniversalBackgroundColor() {
        return this.c;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @NotNull
    public UniversalColor getUniversalTitleColor() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }
}
