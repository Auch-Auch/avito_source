package com.avito.android.bottom_navigation.ui.fragment.factory;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "getShowNavigation", "()Z", "showNavigation", "<init>", "(Z)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class NavigationState implements Parcelable {
    public static final Parcelable.Creator<NavigationState> CREATOR = new Creator();
    public final boolean a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NavigationState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NavigationState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new NavigationState(parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NavigationState[] newArray(int i) {
            return new NavigationState[i];
        }
    }

    public NavigationState() {
        this(false, 1, null);
    }

    public NavigationState(boolean z) {
        this.a = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getShowNavigation() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigationState(boolean z, int i, j jVar) {
        this((i & 1) != 0 ? true : z);
    }
}
