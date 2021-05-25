package com.avito.android.feedback_adverts;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.feedback_adverts.FeedbackAdvertsView;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.adapter.RecyclerViewAppendingAdapter;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsViewImpl;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView;", "", "title", "", "setToolbarTitle", "(Ljava/lang/String;)V", "showNetworkProblem", "()V", "showProgress", "hideProgress", "message", "showMessage", "setToolbarBackIcon", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "showData", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "h", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderFactory", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView$Callback;", "f", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView$Callback;", "viewCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/ViewGroup;", "containerView", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/feedback_adverts/FeedbackAdvertsView$Callback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/analytics/Analytics;)V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsViewImpl implements FeedbackAdvertsView {
    public final Context a;
    public final ProgressOverlay b;
    public final Toolbar c;
    public final RecyclerView d;
    public final LinearLayoutManager e;
    public final FeedbackAdvertsView.Callback f;
    public final AdapterPresenter g;
    public final ViewHolderBuilder<BaseViewHolder> h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FeedbackAdvertsViewImpl a;

        public a(FeedbackAdvertsViewImpl feedbackAdvertsViewImpl) {
            this.a = feedbackAdvertsViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.f.onBackButtonPressed();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FeedbackAdvertsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FeedbackAdvertsViewImpl feedbackAdvertsViewImpl) {
            super(0);
            this.a = feedbackAdvertsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.f.onRefresh();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackAdvertsViewImpl(@NotNull ViewGroup viewGroup, @NotNull FeedbackAdvertsView.Callback callback, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        Intrinsics.checkNotNullParameter(callback, "viewCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = callback;
        this.g = adapterPresenter;
        this.h = viewHolderBuilder;
        Context context = viewGroup.getContext();
        this.a = context;
        int i = R.id.recycler;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.c = toolbar;
        View findViewById2 = viewGroup.findViewById(i);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.d = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.e = linearLayoutManager;
        toolbar.setNavigationOnClickListener(new a(this));
        progressOverlay.setOnRefreshListener(new b(this));
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void hideProgress() {
        this.b.showContent();
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void setToolbarBackIcon() {
        Toolbars.setBackIcon$default(this.c, 0, 1, null);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void setToolbarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c.setTitle(str);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void showData(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        if (this.d.getAdapter() == null) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.g, this.h);
            simpleRecyclerAdapter.setHasStableIds(true);
            this.d.setAdapter(new RecyclerViewAppendingAdapter(simpleRecyclerAdapter, appendingListener, false, 0, 12, null));
            return;
        }
        RecyclerView.Adapter adapter = this.d.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void showNetworkProblem() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.b, null, 1, null);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView
    public void showProgress() {
        this.b.showLoading();
    }
}
