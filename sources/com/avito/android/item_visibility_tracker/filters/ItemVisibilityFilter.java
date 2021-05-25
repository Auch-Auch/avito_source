package com.avito.android.item_visibility_tracker.filters;

import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0016\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "item", "", "canStartTracking", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;)Z", "", "track", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;)V", AuthSource.SEND_ABUSE, "Z", "getKeepTrackedTimeOnDisappear", "()Z", "keepTrackedTimeOnDisappear", "", "d", "J", "getDuration", "()J", "duration", AuthSource.BOOKING_ORDER, "isSingleTrack", "", "c", "F", "getMinVisibilityPercentage", "()F", "minVisibilityPercentage", "<init>", "(ZZFJ)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ItemVisibilityFilter {
    public final boolean a;
    public final boolean b;
    public final float c;
    public final long d;

    public ItemVisibilityFilter(boolean z, boolean z2, float f, long j) {
        this.a = z;
        this.b = z2;
        this.c = f;
        this.d = j;
    }

    public abstract boolean canStartTracking(@NotNull ItemVisibilityTracker.Item item);

    public final long getDuration() {
        return this.d;
    }

    public final boolean getKeepTrackedTimeOnDisappear() {
        return this.a;
    }

    public final float getMinVisibilityPercentage() {
        return this.c;
    }

    public final boolean isSingleTrack() {
        return this.b;
    }

    public abstract void track(@NotNull ItemVisibilityTracker.Item item);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemVisibilityFilter(boolean z, boolean z2, float f, long j, int i, j jVar) {
        this(z, z2, (i & 4) != 0 ? 0.5f : f, (i & 8) != 0 ? 2000 : j);
    }
}
