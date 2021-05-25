package com.avito.android.publish.wizard;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.publish.PublishAppbarView;
import com.avito.android.publish.R;
import com.avito.android.publish.wizard.WizardView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ToastsKt;
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
import ru.avito.component.toolbar.AppBarLayoutWithTextAction;
import ru.avito.component.toolbar.OnboardingData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0019\u00105\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006B"}, d2 = {"Lcom/avito/android/publish/wizard/WizardViewImpl;", "Lcom/avito/android/publish/wizard/WizardView;", "", "showProgress", "()V", "showRetry", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "", "backIcon", "setUpIcon", "(I)V", "title", "setAppBarTitle", "dataChanged", "showParameters", "Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "showActionOnboarding", "(Lru/avito/component/toolbar/OnboardingData;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "h", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderFactory", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/publish/wizard/WizardView$Presenter;", "f", "Lcom/avito/android/publish/wizard/WizardView$Presenter;", "getPresenter", "()Lcom/avito/android/publish/wizard/WizardView$Presenter;", "presenter", "Lcom/avito/android/publish/PublishAppbarView;", "d", "Lcom/avito/android/publish/PublishAppbarView;", "appBar", "Landroid/view/ViewGroup;", "root", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "saveEnabled", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/publish/wizard/WizardView$Presenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/analytics/Analytics;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardViewImpl implements WizardView {
    public final Context a;
    public final RecyclerView b;
    public final ProgressOverlay c;
    public final PublishAppbarView d;
    public final LinearLayoutManager e;
    @NotNull
    public final WizardView.Presenter f;
    public final AdapterPresenter g;
    public final ViewHolderBuilder<BaseViewHolder> h;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((WizardViewImpl) this.b).getPresenter().onRetryClick();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((WizardViewImpl) this.b).getPresenter().onCloseClick();
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((WizardViewImpl) this.b).getPresenter().onBackPressed();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public WizardViewImpl(@NotNull ViewGroup viewGroup, @NotNull WizardView.Presenter presenter, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull Analytics analytics, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = presenter;
        this.g = adapterPresenter;
        this.h = viewHolderBuilder;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        this.a = context;
        int i = R.id.recycler_view;
        View findViewById = viewGroup.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        PublishAppbarView publishAppbarView = new PublishAppbarView(viewGroup, z);
        this.d = publishAppbarView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.e = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(500);
        }
        progressOverlay.setOnRefreshListener(new a(0, this));
        publishAppbarView.setActionsListener(new a(1, this), new a(2, this));
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void dataChanged() {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        this.d.setExpanded(true, true);
    }

    @NotNull
    public final WizardView.Presenter getPresenter() {
        return this.f;
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void setAppBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.d.setTitle(str);
        this.d.setShortTitle(str);
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void setUpIcon(int i) {
        this.d.setHomeIcon(i);
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void showActionOnboarding(@NotNull OnboardingData onboardingData) {
        Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
        PublishAppbarView publishAppbarView = this.d;
        if (!(publishAppbarView instanceof AppBarLayoutWithTextAction)) {
            publishAppbarView = null;
        }
        AppBarLayoutWithTextAction appBarLayoutWithTextAction = (AppBarLayoutWithTextAction) publishAppbarView;
        if (appBarLayoutWithTextAction != null) {
            appBarLayoutWithTextAction.showActionOnboarding(onboardingData);
        }
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void showContent() {
        this.c.showContent();
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ToastsKt.showToast$default(this.a, str, 0, 2, (Object) null);
        showRetry();
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void showParameters() {
        if (this.b.getAdapter() == null) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.g, this.h);
            simpleRecyclerAdapter.setHasStableIds(true);
            this.b.setAdapter(simpleRecyclerAdapter);
            return;
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void showProgress() {
        this.c.showLoading();
    }

    @Override // com.avito.android.publish.wizard.WizardView
    public void showRetry() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
    }
}
