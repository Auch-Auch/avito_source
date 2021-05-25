package com.avito.android.player.presenter.analytics;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0006H&¢\u0006\u0004\b\u0013\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;", "", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "saveState", "()Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "state", "", "restoreState", "(Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;)V", "trackClose", "()V", "trackRewind", "trackFastForward", "trackPause", "trackResume", "trackMediaStartIfNeeded", "trackMediaFirstQuartileIfNeeded", "trackMediaMidpointIfNeeded", "trackMediaThirdQuartileIfNeeded", "trackMediaCompleteIfNeeded", "State", "player_release"}, k = 1, mv = {1, 4, 2})
public interface PlayerAnalyticsInteractor {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0015J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\n\u0010\u0004\"\u0004\b#\u0010$R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b&\u0010$R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b\t\u0010\u0004\"\u0004\b(\u0010$R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010\"\u001a\u0004\b\f\u0010\u0004\"\u0004\b*\u0010$R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b\r\u0010\u0004\"\u0004\b,\u0010$¨\u0006/"}, d2 = {"Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "Landroid/os/Parcelable;", "", "component1", "()Z", "component2", "component3", "component4", "component5", "isMediaStartTracked", "isMediaFirstQuartileTracked", "isMediaMidpointTracked", "isMediaThirdQuartileTracked", "isMediaCompleteTracked", "copy", "(ZZZZZ)Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Z", "setMediaFirstQuartileTracked", "(Z)V", "c", "setMediaMidpointTracked", AuthSource.SEND_ABUSE, "setMediaStartTracked", "d", "setMediaThirdQuartileTracked", "e", "setMediaCompleteTracked", "<init>", "(ZZZZZ)V", "player_release"}, k = 1, mv = {1, 4, 2})
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new State(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State() {
            this(false, false, false, false, false, 31, null);
        }

        public State(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = z4;
            this.e = z5;
        }

        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.a;
            }
            if ((i & 2) != 0) {
                z2 = state.b;
            }
            if ((i & 4) != 0) {
                z3 = state.c;
            }
            if ((i & 8) != 0) {
                z4 = state.d;
            }
            if ((i & 16) != 0) {
                z5 = state.e;
            }
            return state.copy(z, z2, z3, z4, z5);
        }

        public final boolean component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        @NotNull
        public final State copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            return new State(z, z2, z3, z4, z5);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.a == state.a && this.b == state.b && this.c == state.c && this.d == state.d && this.e == state.e;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean z = this.a;
            int i = 1;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 * 31;
            boolean z2 = this.b;
            if (z2) {
                z2 = true;
            }
            int i6 = z2 ? 1 : 0;
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = (i5 + i6) * 31;
            boolean z3 = this.c;
            if (z3) {
                z3 = true;
            }
            int i10 = z3 ? 1 : 0;
            int i11 = z3 ? 1 : 0;
            int i12 = z3 ? 1 : 0;
            int i13 = (i9 + i10) * 31;
            boolean z4 = this.d;
            if (z4) {
                z4 = true;
            }
            int i14 = z4 ? 1 : 0;
            int i15 = z4 ? 1 : 0;
            int i16 = z4 ? 1 : 0;
            int i17 = (i13 + i14) * 31;
            boolean z5 = this.e;
            if (!z5) {
                i = z5 ? 1 : 0;
            }
            return i17 + i;
        }

        public final boolean isMediaCompleteTracked() {
            return this.e;
        }

        public final boolean isMediaFirstQuartileTracked() {
            return this.b;
        }

        public final boolean isMediaMidpointTracked() {
            return this.c;
        }

        public final boolean isMediaStartTracked() {
            return this.a;
        }

        public final boolean isMediaThirdQuartileTracked() {
            return this.d;
        }

        public final void setMediaCompleteTracked(boolean z) {
            this.e = z;
        }

        public final void setMediaFirstQuartileTracked(boolean z) {
            this.b = z;
        }

        public final void setMediaMidpointTracked(boolean z) {
            this.c = z;
        }

        public final void setMediaStartTracked(boolean z) {
            this.a = z;
        }

        public final void setMediaThirdQuartileTracked(boolean z) {
            this.d = z;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(isMediaStartTracked=");
            L.append(this.a);
            L.append(", isMediaFirstQuartileTracked=");
            L.append(this.b);
            L.append(", isMediaMidpointTracked=");
            L.append(this.c);
            L.append(", isMediaThirdQuartileTracked=");
            L.append(this.d);
            L.append(", isMediaCompleteTracked=");
            return a.B(L, this.e, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.a ? 1 : 0);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, j jVar) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5);
        }
    }

    void restoreState(@NotNull State state);

    @NotNull
    State saveState();

    void trackClose();

    void trackFastForward();

    void trackMediaCompleteIfNeeded();

    void trackMediaFirstQuartileIfNeeded();

    void trackMediaMidpointIfNeeded();

    void trackMediaStartIfNeeded();

    void trackMediaThirdQuartileIfNeeded();

    void trackPause();

    void trackResume();

    void trackRewind();
}
