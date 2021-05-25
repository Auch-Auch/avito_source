package com.avito.android.lib.design.picker;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r¸\u0006\u0000"}, d2 = {"com/avito/android/lib/design/picker/Wheel$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Wheel$$special$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ Wheel a;

    public static final class a implements Runnable {
        public final /* synthetic */ Wheel$$special$$inlined$apply$lambda$1 a;

        public a(Wheel$$special$$inlined$apply$lambda$1 wheel$$special$$inlined$apply$lambda$1) {
            this.a = wheel$$special$$inlined$apply$lambda$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Wheel.access$checkMiddlePositionOnly(this.a.a);
            this.a.a.a(false);
        }
    }

    public Wheel$$special$$inlined$apply$lambda$1(Wheel wheel, Context context) {
        this.a = wheel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Function0<Unit> onScrollStarted;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (this.a.l == 0 && i == 1 && (onScrollStarted = this.a.getOnScrollStarted()) != null) {
            onScrollStarted.invoke();
        }
        this.a.l = i;
        if (i == 0 && !(this.a.p)) {
            recyclerView.post(new a(this));
        }
        if (i == 1) {
            this.a.o = null;
            this.a.setCenterView((View) null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        this.a.d();
    }
}
