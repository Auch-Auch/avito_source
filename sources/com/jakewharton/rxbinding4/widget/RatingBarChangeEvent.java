package com.jakewharton.rxbinding4.widget;

import a2.b.a.a.a;
import android.widget.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/jakewharton/rxbinding4/widget/RatingBarChangeEvent;", "", "Landroid/widget/RatingBar;", "component1", "()Landroid/widget/RatingBar;", "", "component2", "()F", "", "component3", "()Z", "view", "rating", "fromUser", "copy", "(Landroid/widget/RatingBar;FZ)Lcom/jakewharton/rxbinding4/widget/RatingBarChangeEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Z", "getFromUser", AuthSource.SEND_ABUSE, "Landroid/widget/RatingBar;", "getView", AuthSource.BOOKING_ORDER, "F", "getRating", "<init>", "(Landroid/widget/RatingBar;FZ)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class RatingBarChangeEvent {
    @NotNull
    public final RatingBar a;
    public final float b;
    public final boolean c;

    public RatingBarChangeEvent(@NotNull RatingBar ratingBar, float f, boolean z) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "view");
        this.a = ratingBar;
        this.b = f;
        this.c = z;
    }

    public static /* synthetic */ RatingBarChangeEvent copy$default(RatingBarChangeEvent ratingBarChangeEvent, RatingBar ratingBar, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            ratingBar = ratingBarChangeEvent.a;
        }
        if ((i & 2) != 0) {
            f = ratingBarChangeEvent.b;
        }
        if ((i & 4) != 0) {
            z = ratingBarChangeEvent.c;
        }
        return ratingBarChangeEvent.copy(ratingBar, f, z);
    }

    @NotNull
    public final RatingBar component1() {
        return this.a;
    }

    public final float component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final RatingBarChangeEvent copy(@NotNull RatingBar ratingBar, float f, boolean z) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "view");
        return new RatingBarChangeEvent(ratingBar, f, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingBarChangeEvent)) {
            return false;
        }
        RatingBarChangeEvent ratingBarChangeEvent = (RatingBarChangeEvent) obj;
        return Intrinsics.areEqual(this.a, ratingBarChangeEvent.a) && Float.compare(this.b, ratingBarChangeEvent.b) == 0 && this.c == ratingBarChangeEvent.c;
    }

    public final boolean getFromUser() {
        return this.c;
    }

    public final float getRating() {
        return this.b;
    }

    @NotNull
    public final RatingBar getView() {
        return this.a;
    }

    public int hashCode() {
        RatingBar ratingBar = this.a;
        int i1 = a.i1(this.b, (ratingBar != null ? ratingBar.hashCode() : 0) * 31, 31);
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return i1 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RatingBarChangeEvent(view=");
        L.append(this.a);
        L.append(", rating=");
        L.append(this.b);
        L.append(", fromUser=");
        return a.B(L, this.c, ")");
    }
}
