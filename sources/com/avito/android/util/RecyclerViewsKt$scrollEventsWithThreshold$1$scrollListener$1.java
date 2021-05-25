package com.avito.android.util;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"com/avito/android/util/RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", AuthSource.BOOKING_ORDER, "I", "getDeltaX", "()I", "setDeltaX", "(I)V", "deltaX", "c", "getDeltaY", "setDeltaY", "deltaY", "", AuthSource.SEND_ABUSE, "Z", "getMeasuring", "()Z", "setMeasuring", "(Z)V", "measuring", "android_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1 extends RecyclerView.OnScrollListener {
    public boolean a;
    public int b;
    public int c;
    public final /* synthetic */ RecyclerViewsKt$scrollEventsWithThreshold$1 d;
    public final /* synthetic */ ObservableEmitter e;

    public RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1(RecyclerViewsKt$scrollEventsWithThreshold$1 recyclerViewsKt$scrollEventsWithThreshold$1, ObservableEmitter observableEmitter) {
        this.d = recyclerViewsKt$scrollEventsWithThreshold$1;
        this.e = observableEmitter;
    }

    public final int getDeltaX() {
        return this.b;
    }

    public final int getDeltaY() {
        return this.c;
    }

    public final boolean getMeasuring() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i == 0) {
            this.b = 0;
            this.c = 0;
            this.a = false;
        } else if (i == 1) {
            this.b = 0;
            this.c = 0;
            this.a = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.a) {
            if (c.getSign(this.b) * c.getSign(i) < 0) {
                this.b = i;
            } else {
                this.b += i;
            }
            if (c.getSign(this.c) * c.getSign(i2) < 0) {
                this.c = i2;
            } else {
                this.c += i2;
            }
            boolean z = true;
            boolean z2 = Math.abs(this.b) >= this.d.b;
            if (Math.abs(this.c) < this.d.b) {
                z = false;
            }
            if (z2 || z) {
                this.e.onNext(new ScrollEventWithThreshold(this.b, this.c));
                if (z2) {
                    this.b = 0;
                } else {
                    this.c = 0;
                }
            }
        }
    }

    public final void setDeltaX(int i) {
        this.b = i;
    }

    public final void setDeltaY(int i) {
        this.c = i;
    }

    public final void setMeasuring(boolean z) {
        this.a = z;
    }
}
