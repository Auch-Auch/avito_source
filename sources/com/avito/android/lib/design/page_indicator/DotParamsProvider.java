package com.avito.android.lib.design.page_indicator;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b#\u0010$J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/DotParamsProvider;", "", "", "dotCount", "pagesCount", "", "updateParams", "(II)V", "dotIndex", "selectedPage", "direction", "", "isSmall", "(III)Z", "isSelected", "isAnimationRequired", "(II)Z", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "getState", "()Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "range", "restore", "(Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;)V", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$PagesRange;", "pagesRange", AuthSource.SEND_ABUSE, "(Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$PagesRange;II)Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$PagesRange;", AuthSource.BOOKING_ORDER, "I", "c", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$PagesRange;", "visiblePagesRange", "<set-?>", "getDotCount", "()I", "<init>", "()V", "PagesRange", "State", "components_release"}, k = 1, mv = {1, 4, 2})
public final class DotParamsProvider {
    public int a;
    public int b;
    public PagesRange c = new PagesRange(0, this.b - 1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0006R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$PagesRange;", "", "", "value", "", "changeBounds", "(I)V", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "I", "getEndInclusive", "()I", "setEndInclusive", "endInclusive", AuthSource.SEND_ABUSE, "getStart", "setStart", Tracker.Events.CREATIVE_START, "<init>", "(II)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class PagesRange {
        public int a;
        public int b;

        public PagesRange(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final void changeBounds(int i) {
            this.a += i;
            this.b += i;
        }

        public final int getEndInclusive() {
            return this.b;
        }

        public final int getStart() {
            return this.a;
        }

        public final void setEndInclusive(int i) {
            this.b = i;
        }

        public final void setStart(int i) {
            this.a = i;
        }

        @NotNull
        public String toString() {
            return this.a + ".." + this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0017\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.SEND_ABUSE, "I", "getStart", Tracker.Events.CREATIVE_START, "c", "getPagesCount", "pagesCount", AuthSource.BOOKING_ORDER, "getEndInclusive", "endInclusive", "d", "getDotCount", "dotCount", "<init>", "(IIII)V", "(Landroid/os/Parcel;)V", "CREATOR", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class State implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "", "size", "", "newArray", "(I)[Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<State> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public State[] newArray(int i) {
                return new State[i];
            }
        }

        public State(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int getDotCount() {
            return this.d;
        }

        public final int getEndInclusive() {
            return this.b;
        }

        public final int getPagesCount() {
            return this.c;
        }

        public final int getStart() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public State(@NotNull Parcel parcel) {
            this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    public static /* synthetic */ boolean isSelected$default(DotParamsProvider dotParamsProvider, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -1;
        }
        return dotParamsProvider.isSelected(i, i2, i3);
    }

    public static /* synthetic */ boolean isSmall$default(DotParamsProvider dotParamsProvider, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -1;
        }
        return dotParamsProvider.isSmall(i, i2, i3);
    }

    public final PagesRange a(PagesRange pagesRange, int i, int i2) {
        int i3 = i - 1;
        int max = Math.max(pagesRange.getStart() - (i3 - pagesRange.getEndInclusive()), 0);
        int i4 = (max + i2) - 1;
        if (i4 > i3) {
            max = (i3 - i2) + 1;
        } else {
            i3 = i4;
        }
        return new PagesRange(max, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        if ((r5 == r4.a - 1) != false) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x000e
            int r2 = r4.a
            int r2 = r2 - r1
            if (r5 != r2) goto L_0x000b
            r2 = 1
            goto L_0x000c
        L_0x000b:
            r2 = 0
        L_0x000c:
            if (r2 == 0) goto L_0x004b
        L_0x000e:
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r2 = r4.c
            int r2 = r2.getStart()
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r3 = r4.c
            int r3 = r3.getEndInclusive()
            if (r2 <= r5) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            if (r3 < r5) goto L_0x0020
            return
        L_0x0020:
            if (r5 != 0) goto L_0x002f
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r2 = r4.c
            r2.setStart(r0)
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r2 = r4.c
            int r3 = r4.b
            int r3 = r3 - r1
            r2.setEndInclusive(r3)
        L_0x002f:
            int r2 = r4.a
            int r3 = r2 + -1
            if (r5 != r3) goto L_0x0036
            r0 = 1
        L_0x0036:
            if (r0 == 0) goto L_0x004b
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r0 = r4.c
            int r2 = r2 - r1
            r0.setEndInclusive(r2)
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r0 = r4.c
            int r2 = r0.getEndInclusive()
            int r3 = r4.b
            int r2 = r2 - r3
            int r2 = r2 + r1
            r0.setStart(r2)
        L_0x004b:
            if (r6 != r1) goto L_0x0055
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r0 = r4.c
            int r0 = r0.getStart()
            int r0 = r0 + r1
            goto L_0x005b
        L_0x0055:
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r0 = r4.c
            int r0 = r0.getStart()
        L_0x005b:
            r2 = -1
            if (r6 != r2) goto L_0x0066
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r2 = r4.c
            int r2 = r2.getEndInclusive()
            int r2 = r2 - r1
            goto L_0x006c
        L_0x0066:
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r1 = r4.c
            int r2 = r1.getEndInclusive()
        L_0x006c:
            if (r0 > r5) goto L_0x0070
            if (r2 >= r5) goto L_0x0076
        L_0x0070:
            com.avito.android.lib.design.page_indicator.DotParamsProvider$PagesRange r5 = r4.c
            int r6 = -r6
            r5.changeBounds(r6)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.page_indicator.DotParamsProvider.b(int, int):void");
    }

    public final int getDotCount() {
        return this.b;
    }

    @NotNull
    public final State getState() {
        return new State(this.c.getStart(), this.c.getEndInclusive(), this.a, this.b);
    }

    public final boolean isAnimationRequired(int i, int i2) {
        int start = this.c.getStart();
        b(i, i2);
        return this.c.getStart() != start;
    }

    public final boolean isSelected(int i, int i2, int i3) {
        if (i2 == this.a - 1) {
            if (i == this.b - 1) {
                return true;
            }
            return false;
        } else if (i2 != 0) {
            b(i2, i3);
            if (i2 - this.c.getStart() == i) {
                return true;
            }
            return false;
        } else if (i == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean isSmall(int i, int i2, int i3) {
        int i4;
        if (i < 0 || i >= (i4 = this.a)) {
            return true;
        }
        if (i4 <= this.b) {
            return false;
        }
        b(i2, i3);
        if (i == 0) {
            if (this.c.getStart() > 0) {
                return true;
            }
            return false;
        } else if (i != this.b - 1 || this.c.getEndInclusive() >= this.a - 1) {
            return false;
        } else {
            return true;
        }
    }

    public final void restore(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "range");
        PagesRange pagesRange = new PagesRange(state.getStart(), state.getEndInclusive());
        boolean z = true;
        boolean z2 = this.b > 0 && this.a > 0;
        if (state.getDotCount() == this.b && state.getPagesCount() == this.a) {
            z = false;
        }
        if (!z2 || !z) {
            this.c = pagesRange;
            this.b = state.getDotCount();
            this.a = state.getPagesCount();
            return;
        }
        this.c = a(pagesRange, this.a, this.b);
    }

    public final void updateParams(int i, int i2) {
        if ((i2 - 1) - this.c.getEndInclusive() <= 0 || this.b != i) {
            this.c = a(this.c, i2, i);
        }
        this.a = i2;
        this.b = i;
    }
}
