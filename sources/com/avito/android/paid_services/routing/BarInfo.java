package com.avito.android.paid_services.routing;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u001f\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010-\u001a\u0004\u0018\u00010%\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010*\u001a\u00020%¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0019\u0010$\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010*\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)¨\u00060"}, d2 = {"Lcom/avito/android/paid_services/routing/BarInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/Float;", "getStartProgress", "()Ljava/lang/Float;", "startProgress", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "c", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "getDescriptionStatus", "()Lcom/avito/android/paid_services/routing/TariffCountStatus;", "descriptionStatus", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", AuthSource.SEND_ABUSE, "getTitle", "title", "f", "F", "getProgress", "()F", "progress", "Lcom/avito/android/paid_services/routing/ProgressState;", g.a, "Lcom/avito/android/paid_services/routing/ProgressState;", "getProgressState", "()Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", "e", "getStartProgressState", "startProgressState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/paid_services/routing/TariffCountStatus;Ljava/lang/Float;Lcom/avito/android/paid_services/routing/ProgressState;FLcom/avito/android/paid_services/routing/ProgressState;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class BarInfo implements Parcelable {
    public static final Parcelable.Creator<BarInfo> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @NotNull
    public final TariffCountStatus c;
    @Nullable
    public final Float d;
    @Nullable
    public final ProgressState e;
    public final float f;
    @NotNull
    public final ProgressState g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BarInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BarInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BarInfo(parcel.readString(), parcel.readString(), (TariffCountStatus) Enum.valueOf(TariffCountStatus.class, parcel.readString()), parcel.readInt() != 0 ? Float.valueOf(parcel.readFloat()) : null, parcel.readInt() != 0 ? (ProgressState) Enum.valueOf(ProgressState.class, parcel.readString()) : null, parcel.readFloat(), (ProgressState) Enum.valueOf(ProgressState.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BarInfo[] newArray(int i) {
            return new BarInfo[i];
        }
    }

    public BarInfo(@NotNull String str, @Nullable String str2, @NotNull TariffCountStatus tariffCountStatus, @Nullable Float f2, @Nullable ProgressState progressState, float f3, @NotNull ProgressState progressState2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(tariffCountStatus, "descriptionStatus");
        Intrinsics.checkNotNullParameter(progressState2, "progressState");
        this.a = str;
        this.b = str2;
        this.c = tariffCountStatus;
        this.d = f2;
        this.e = progressState;
        this.f = f3;
        this.g = progressState2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getDescription() {
        return this.b;
    }

    @NotNull
    public final TariffCountStatus getDescriptionStatus() {
        return this.c;
    }

    public final float getProgress() {
        return this.f;
    }

    @NotNull
    public final ProgressState getProgressState() {
        return this.g;
    }

    @Nullable
    public final Float getStartProgress() {
        return this.d;
    }

    @Nullable
    public final ProgressState getStartProgressState() {
        return this.e;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c.name());
        Float f2 = this.d;
        if (f2 != null) {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        } else {
            parcel.writeInt(0);
        }
        ProgressState progressState = this.e;
        if (progressState != null) {
            parcel.writeInt(1);
            parcel.writeString(progressState.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeFloat(this.f);
        parcel.writeString(this.g.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarInfo(String str, String str2, TariffCountStatus tariffCountStatus, Float f2, ProgressState progressState, float f3, ProgressState progressState2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? TariffCountStatus.NORMAL : tariffCountStatus, f2, progressState, f3, progressState2);
    }
}
