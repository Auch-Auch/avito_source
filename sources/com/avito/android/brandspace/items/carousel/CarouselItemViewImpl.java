package com.avito.android.brandspace.items.carousel;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.FixedWidthLinearLayoutManager;
import com.avito.android.lib.design.page_indicator.PageIndicator;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.ui.snap_helper.PagingSnapHelper;
import com.avito.android.ui_components.R;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.ListRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BE\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0007\u0012\b\b\u0002\u0010;\u001a\u00020\u000f\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b=\u0010>J5\u0010\r\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u00102¨\u0006?"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/carousel/CarouselItemView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "", VKApiConst.POSITION, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Ljava/util/List;IILcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;)V", "", "animated", "setCurrentPosition", "(IZ)V", "destroy", "()V", "onUnbind", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "scheduleScrollToNextPage", "(Lcom/avito/android/util/SchedulersFactory3;)V", "t", "x", "Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", "Lio/reactivex/rxjava3/disposables/Disposable;", "y", "Lio/reactivex/rxjava3/disposables/Disposable;", "autoScrollTimer", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "u", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "listAdapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/SnapHelper;", "w", "Landroidx/recyclerview/widget/SnapHelper;", "snapHelper", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "pageIndicator", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "view", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderProvider", "columnOffset", "hasSnapHelper", "itemFixedWidth", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Landroid/view/View;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;IZLjava/lang/Integer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public class CarouselItemViewImpl extends BaseViewHolder implements CarouselItemView, DestroyableViewHolder {
    public final RecyclerView s;
    public PageIndicator t;
    public ListRecyclerAdapter u;
    public final LinearLayoutManager v;
    public SnapHelper w;
    public CarouselItemView.Listener x;
    public Disposable y;

    public static final class a<T> implements Consumer<Long> {
        public final /* synthetic */ CarouselItemViewImpl a;

        public a(CarouselItemViewImpl carouselItemViewImpl) {
            this.a = carouselItemViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Long l) {
            int findFirstVisibleItemPosition = this.a.v.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition < this.a.v.getItemCount()) {
                this.a.setCurrentPosition(findFirstVisibleItemPosition + 1, true);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselItemViewImpl(AdapterPresenter adapterPresenter, View view, ViewHolderBuilder viewHolderBuilder, int i, boolean z, Integer num, int i2, j jVar) {
        this(adapterPresenter, view, viewHolderBuilder, (i2 & 8) != 0 ? view.getResources().getDimensionPixelOffset(R.dimen.rds_column_offset) : i, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? null : num);
    }

    public static final void access$onCurrentPositionChanged(CarouselItemViewImpl carouselItemViewImpl, boolean z) {
        CarouselItemView.Listener listener = carouselItemViewImpl.x;
        if (listener != null) {
            listener.onCurrentPositionChanged(carouselItemViewImpl.v.findFirstVisibleItemPosition(), z);
        }
    }

    @Override // com.avito.android.brandspace.items.carousel.CarouselItemView
    public void bind(@NotNull List<? extends BrandspaceItem> list, int i, int i2, @NotNull CarouselItemView.Listener listener) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x = listener;
        this.u.submitList(list);
        this.s.setAdapter(this.u);
        this.s.clearOnScrollListeners();
        this.s.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.brandspace.items.carousel.CarouselItemViewImpl$addScrollListener$1
            public boolean a;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i3 == 1) {
                    this.a = true;
                }
                if (i3 == 0) {
                    CarouselItemViewImpl.access$onCurrentPositionChanged(CarouselItemViewImpl.this, true ^ this.a);
                    this.a = false;
                }
            }
        });
        SnapHelper snapHelper = this.w;
        if (snapHelper != null) {
            snapHelper.attachToRecyclerView(this.s);
        }
        PageIndicator pageIndicator = this.t;
        if (pageIndicator != null) {
            pageIndicator.attachToRecyclerView(this.s);
        }
        CarouselItemView.DefaultImpls.setCurrentPosition$default(this, i, false, 2, null);
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        t();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        t();
    }

    @Override // com.avito.android.brandspace.items.carousel.CarouselItemView
    public void scheduleScrollToNextPage(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Disposable disposable = this.y;
        if (disposable != null) {
            disposable.dispose();
        }
        this.y = null;
        this.y = Single.timer(7000, TimeUnit.MILLISECONDS, schedulersFactory3.computation()).observeOn(schedulersFactory3.mainThread()).subscribe(new a(this));
    }

    @Override // com.avito.android.brandspace.items.carousel.CarouselItemView
    public void setCurrentPosition(int i, boolean z) {
        if (z) {
            this.s.smoothScrollToPosition(i);
        } else {
            this.v.scrollToPosition(i);
        }
    }

    public final void t() {
        this.x = null;
        SnapHelper snapHelper = this.w;
        if (snapHelper != null) {
            snapHelper.attachToRecyclerView(null);
        }
        this.s.setOnFlingListener(null);
        this.s.clearOnScrollListeners();
        Disposable disposable = this.y;
        if (disposable != null) {
            disposable.dispose();
        }
        this.y = null;
        this.s.setAdapter(null);
        this.u.submitList(null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselItemViewImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull View view, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, int i, boolean z, @Nullable Integer num) {
        super(view);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderProvider");
        View findViewById = view.findViewById(com.avito.android.brandspace.R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.s = recyclerView;
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        this.t = (PageIndicator) view2.findViewById(com.avito.android.brandspace.R.id.page_indicator);
        recyclerView.setScrollingTouchSlop(0);
        FixedWidthLinearLayoutManager fixedWidthLinearLayoutManager = new FixedWidthLinearLayoutManager(view.getContext(), 0, false, num, false, 16, null);
        this.v = fixedWidthLinearLayoutManager;
        recyclerView.setLayoutManager(fixedWidthLinearLayoutManager);
        this.u = new ListRecyclerAdapter(adapterPresenter, viewHolderBuilder, null, 4, null);
        if (z) {
            this.w = new PagingSnapHelper(recyclerView.getPaddingLeft());
        }
        if (i != 0) {
            recyclerView.addItemDecoration(new CarouselDecoration(i, z));
        }
    }
}
