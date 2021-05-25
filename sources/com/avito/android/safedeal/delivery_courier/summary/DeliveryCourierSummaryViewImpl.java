package com.avito.android.safedeal.delivery_courier.summary;

import a2.a.a.i2.a.b.e;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryView;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;)V", "Landroid/widget/FrameLayout;", AuthSource.SEND_ABUSE, "Landroid/widget/FrameLayout;", "contentHolder", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "adapter", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryViewImpl implements DeliveryCourierSummaryView {
    public final FrameLayout a;
    public ProgressOverlay b;
    public final RecyclerView c;
    public final View d;
    public final LifecycleOwner e;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Unit unit) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                } else if (unit != null) {
                    ((DeliveryCourierSummaryViewImpl) this.b).b.showLoading();
                }
            } else if (unit != null) {
                ((DeliveryCourierSummaryViewImpl) this.b).b.showContent();
            }
        }
    }

    public static final class b<T> implements Observer<Runnable> {
        public final /* synthetic */ DeliveryCourierSummaryViewImpl a;

        public b(DeliveryCourierSummaryViewImpl deliveryCourierSummaryViewImpl) {
            this.a = deliveryCourierSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Runnable runnable) {
            Runnable runnable2 = runnable;
            if (runnable2 != null) {
                LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.b, null, 1, null);
                this.a.b.setOnRefreshListener(new e(runnable2));
            }
        }
    }

    public static final class c<T> implements Observer<String> {
        public final /* synthetic */ DeliveryCourierSummaryViewImpl a;

        public c(DeliveryCourierSummaryViewImpl deliveryCourierSummaryViewImpl) {
            this.a = deliveryCourierSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(String str) {
            String str2 = str;
            if (str2 != null) {
                Views.showSnackBar$default(this.a.d, str2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
        }
    }

    public static final class d<T> implements Observer<Integer> {
        public final /* synthetic */ DeliveryCourierSummaryViewImpl a;

        public d(DeliveryCourierSummaryViewImpl deliveryCourierSummaryViewImpl) {
            this.a = deliveryCourierSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            Integer num2 = num;
            if (num2 != null) {
                this.a.c.scrollToPosition(num2.intValue());
            }
        }
    }

    public DeliveryCourierSummaryViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull LifecycleOwner lifecycleOwner, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.d = view;
        this.e = lifecycleOwner;
        View findViewById = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.a = frameLayout;
        this.b = new ProgressOverlay(frameLayout, 0, analytics, false, 0, 26, null);
        View findViewById2 = view.findViewById(R.id.summary_list);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewImpl.1
            public final /* synthetic */ DeliveryCourierSummaryViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (recyclerView2.canScrollVertically(-1)) {
                    FrameLayout frameLayout2 = this.a.a;
                    frameLayout2.setForeground(frameLayout2.getContext().getDrawable(com.avito.android.deprecated_design.R.drawable.shadow_toolbar));
                    return;
                }
                this.a.a.setForeground(null);
            }
        });
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryView
    public void bindTo(@NotNull DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModel, "viewModel");
        deliveryCourierSummaryViewModel.getShowContentChanges().observe(this.e, new a(0, this));
        deliveryCourierSummaryViewModel.getProgressChanges().observe(this.e, new a(1, this));
        deliveryCourierSummaryViewModel.getErrorChanges().observe(this.e, new b(this));
        deliveryCourierSummaryViewModel.getSnackBarChanges().observe(this.e, new c(this));
        deliveryCourierSummaryViewModel.getErrorPositionChanges().observe(this.e, new d(this));
    }
}
