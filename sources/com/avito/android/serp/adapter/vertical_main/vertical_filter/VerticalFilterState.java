package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Landroid/os/Parcelable;", "getDialogState", "()Landroid/os/Parcelable;", "dialogState", "", "c", "Ljava/lang/String;", "getXHash", "()Ljava/lang/String;", "xHash", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "getData", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "data", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;Landroid/os/Parcelable;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterState implements Parcelable {
    public static final Parcelable.Creator<VerticalFilterState> CREATOR = new Creator();
    @NotNull
    public final VerticalFilterData a;
    @Nullable
    public final Parcelable b;
    @Nullable
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerticalFilterState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerticalFilterState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VerticalFilterState(VerticalFilterData.CREATOR.createFromParcel(parcel), parcel.readParcelable(VerticalFilterState.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerticalFilterState[] newArray(int i) {
            return new VerticalFilterState[i];
        }
    }

    public VerticalFilterState(@NotNull VerticalFilterData verticalFilterData, @Nullable Parcelable parcelable, @Nullable String str) {
        Intrinsics.checkNotNullParameter(verticalFilterData, "data");
        this.a = verticalFilterData;
        this.b = parcelable;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final VerticalFilterData getData() {
        return this.a;
    }

    @Nullable
    public final Parcelable getDialogState() {
        return this.b;
    }

    @Nullable
    public final String getXHash() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.a.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
    }
}
