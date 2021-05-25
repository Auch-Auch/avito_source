package com.avito.android.advert.item;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.core.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/avito/android/advert/item/AdvertDetailsViewImpl$scrollStateChanges$1$listener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsViewImpl$scrollStateChanges$1$listener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ ObservableEmitter a;

    public AdvertDetailsViewImpl$scrollStateChanges$1$listener$1(ObservableEmitter observableEmitter) {
        this.a = observableEmitter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.a.onNext(Integer.valueOf(i));
    }
}
