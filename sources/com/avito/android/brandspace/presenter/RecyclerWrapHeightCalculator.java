package com.avito.android.brandspace.presenter;

import a2.a.a.w.c.y;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.util.Contexts;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/brandspace/presenter/RecyclerWrapHeightCalculator;", "", "Landroidx/recyclerview/widget/RecyclerView;", "source", "Lio/reactivex/rxjava3/core/Single;", "", "requestHeightByHighestItemAsync", "(Landroidx/recyclerview/widget/RecyclerView;)Lio/reactivex/rxjava3/core/Single;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerWrapHeightCalculator {

    public static final class a<V> implements Callable<Integer> {
        public final /* synthetic */ RecyclerWrapHeightCalculator a;
        public final /* synthetic */ RecyclerView b;

        public a(RecyclerWrapHeightCalculator recyclerWrapHeightCalculator, RecyclerView recyclerView) {
            this.a = recyclerWrapHeightCalculator;
            this.b = recyclerView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Integer call() {
            return Integer.valueOf(RecyclerWrapHeightCalculator.access$requestHeightByHighestItem(this.a, this.b));
        }
    }

    public static final int access$requestHeightByHighestItem(RecyclerWrapHeightCalculator recyclerWrapHeightCalculator, RecyclerView recyclerView) {
        int i;
        Objects.requireNonNull(recyclerWrapHeightCalculator);
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "source.context");
        y yVar = new y(context, recyclerView.getLayoutManager());
        RecyclerView recyclerView2 = new RecyclerView(recyclerView.getContext());
        recyclerView2.setLayoutManager(yVar);
        Integer valueOf = Integer.valueOf(recyclerView.getMeasuredWidth());
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        } else {
            Context context2 = recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "source.context");
            i = Contexts.getRealDisplayWidth(context2);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        recyclerView2.setAdapter(recyclerView.getAdapter());
        recyclerView2.setLayoutParams(recyclerView.getLayoutParams());
        recyclerView2.setRecycledViewPool(recyclerView.getRecycledViewPool());
        IntRange until = e.until(0, recyclerView.getItemDecorationCount());
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(recyclerView.getItemDecorationAt(((IntIterator) it).nextInt()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            recyclerView2.addItemDecoration((RecyclerView.ItemDecoration) it2.next());
        }
        recyclerView2.measure(makeMeasureSpec, makeMeasureSpec2);
        int i2 = yVar.J;
        if (i2 != Integer.MIN_VALUE) {
            return recyclerView.getPaddingBottom() + recyclerView.getPaddingTop() + i2;
        }
        throw new IllegalStateException("Illegal value. Something went wrong.");
    }

    @NotNull
    public final Single<Integer> requestHeightByHighestItemAsync(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "source");
        Single<Integer> observeOn = Single.fromCallable(new a(this, recyclerView)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "Single.fromCallable { re…dSchedulers.mainThread())");
        return observeOn;
    }
}
