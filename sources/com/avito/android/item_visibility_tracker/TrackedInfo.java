package com.avito.android.item_visibility_tracker;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\b\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\bF\u0010GB\u0011\b\u0016\u0012\u0006\u0010;\u001a\u00020\u0006¢\u0006\u0004\bF\u00109J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ4\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R4\u0010,\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#8\u0006@FX\u000e¢\u0006\u0018\n\u0004\b%\u0010&\u0012\u0004\b+\u0010\u0004\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u00101R\u0013\u00103\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b2\u0010\u000bR*\u0010;\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b4\u00105\u0012\u0004\b:\u0010\u0004\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0013\u0010<\u001a\u00020\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b<\u0010=R\"\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010.\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u00101R\u0013\u0010B\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010\u000bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\b¨\u0006H"}, d2 = {"Lcom/avito/android/item_visibility_tracker/TrackedInfo;", "Landroid/os/Parcelable;", "", "setAsTracked", "()V", "Ljava/lang/Class;", "Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "component1", "()Ljava/lang/Class;", "", "component2", "()J", "component3", "filterClass", "trackedTime", "startTrackingTime", "copy", "(Ljava/lang/Class;JJ)Lcom/avito/android/item_visibility_tracker/TrackedInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Runnable;", "value", AuthSource.BOOKING_ORDER, "Ljava/lang/Runnable;", "getTimerRunnable", "()Ljava/lang/Runnable;", "setTimerRunnable", "(Ljava/lang/Runnable;)V", "getTimerRunnable$annotations", "timerRunnable", "e", "J", "getStartTrackingTime", "setStartTrackingTime", "(J)V", "getTimerDuration", "timerDuration", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "getFilter", "()Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "setFilter", "(Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;)V", "getFilter$annotations", "filter", "isTracked", "()Z", "d", "getTrackedTime", "setTrackedTime", "getDuration", "duration", "c", "Ljava/lang/Class;", "getFilterClass", "<init>", "(Ljava/lang/Class;JJ)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class TrackedInfo implements Parcelable {
    public static final Parcelable.Creator<TrackedInfo> CREATOR = new Creator();
    @Nullable
    public ItemVisibilityFilter a;
    @Nullable
    public Runnable b;
    @NotNull
    public final Class<ItemVisibilityFilter> c;
    public long d;
    public long e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TrackedInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TrackedInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TrackedInfo((Class) parcel.readSerializable(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TrackedInfo[] newArray(int i) {
            return new TrackedInfo[i];
        }
    }

    public TrackedInfo(@NotNull Class<ItemVisibilityFilter> cls, long j, long j2) {
        Intrinsics.checkNotNullParameter(cls, "filterClass");
        this.c = cls;
        this.d = j;
        this.e = j2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.item_visibility_tracker.TrackedInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrackedInfo copy$default(TrackedInfo trackedInfo, Class cls, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = trackedInfo.c;
        }
        if ((i & 2) != 0) {
            j = trackedInfo.d;
        }
        if ((i & 4) != 0) {
            j2 = trackedInfo.e;
        }
        return trackedInfo.copy(cls, j, j2);
    }

    public static /* synthetic */ void getFilter$annotations() {
    }

    public static /* synthetic */ void getTimerRunnable$annotations() {
    }

    @NotNull
    public final Class<ItemVisibilityFilter> component1() {
        return this.c;
    }

    public final long component2() {
        return this.d;
    }

    public final long component3() {
        return this.e;
    }

    @NotNull
    public final TrackedInfo copy(@NotNull Class<ItemVisibilityFilter> cls, long j, long j2) {
        Intrinsics.checkNotNullParameter(cls, "filterClass");
        return new TrackedInfo(cls, j, j2);
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
        if (!(obj instanceof TrackedInfo)) {
            return false;
        }
        TrackedInfo trackedInfo = (TrackedInfo) obj;
        return Intrinsics.areEqual(this.c, trackedInfo.c) && this.d == trackedInfo.d && this.e == trackedInfo.e;
    }

    public final long getDuration() {
        ItemVisibilityFilter itemVisibilityFilter = this.a;
        if (itemVisibilityFilter != null) {
            return itemVisibilityFilter.getDuration();
        }
        return 0;
    }

    @Nullable
    public final ItemVisibilityFilter getFilter() {
        return this.a;
    }

    @NotNull
    public final Class<ItemVisibilityFilter> getFilterClass() {
        return this.c;
    }

    public final long getStartTrackingTime() {
        return this.e;
    }

    public final long getTimerDuration() {
        return Math.max(0L, getDuration() - this.d);
    }

    @Nullable
    public final Runnable getTimerRunnable() {
        return this.b;
    }

    public final long getTrackedTime() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Class<ItemVisibilityFilter> cls = this.c;
        return ((((cls != null ? cls.hashCode() : 0) * 31) + c.a(this.d)) * 31) + c.a(this.e);
    }

    public final boolean isTracked() {
        return this.d >= getDuration();
    }

    public final void setAsTracked() {
        this.d = getDuration();
    }

    public final void setFilter(@Nullable ItemVisibilityFilter itemVisibilityFilter) {
        this.a = itemVisibilityFilter;
    }

    public final void setStartTrackingTime(long j) {
        this.e = j;
    }

    public final void setTimerRunnable(@Nullable Runnable runnable) {
        this.b = runnable;
        if (runnable != null) {
            this.e = SystemClock.elapsedRealtime();
        } else if (this.e != 0) {
            this.d = (SystemClock.elapsedRealtime() - this.e) + this.d;
        }
    }

    public final void setTrackedTime(long j) {
        this.d = j;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TrackedInfo(filterClass=");
        L.append(this.c);
        L.append(", trackedTime=");
        L.append(this.d);
        L.append(", startTrackingTime=");
        return a.l(L, this.e, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackedInfo(Class cls, long j, long j2, int i, j jVar) {
        this(cls, (i & 2) != 0 ? 0 : j, (i & 4) != 0 ? 0 : j2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrackedInfo(@NotNull ItemVisibilityFilter itemVisibilityFilter) {
        this(itemVisibilityFilter.getClass(), 0, 0, 6, null);
        Intrinsics.checkNotNullParameter(itemVisibilityFilter, "filter");
        this.a = itemVisibilityFilter;
    }
}
