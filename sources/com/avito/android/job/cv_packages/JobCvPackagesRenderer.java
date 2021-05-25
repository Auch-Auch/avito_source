package com.avito.android.job.cv_packages;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.job.cv_packages.Action;
import com.avito.android.job.cv_packages.State;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.util.AdapterPresentersKt;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.CollapsingTitleAppBarLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010$\u001a\u00020#\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/avito/android/job/cv_packages/JobCvPackagesRenderer;", "Lru/avito/component/toolbar/AppbarClickListener;", "Lcom/avito/android/job/cv_packages/State;", "state", "", "render", "(Lcom/avito/android/job/cv_packages/State;)V", "onHomeClicked", "()V", "onActionClicked", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "f", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", AuthSource.SEND_ABUSE, "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "appBar", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "e", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/job/cv_packages/Action;", "d", "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class JobCvPackagesRenderer implements AppbarClickListener {
    public final CollapsingTitleAppBarLayout a;
    public final RecyclerView b;
    public final ProgressOverlay c;
    public final Consumer<Action> d;
    public final SimpleRecyclerAdapter e;
    public final AdapterPresenter f;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JobCvPackagesRenderer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JobCvPackagesRenderer jobCvPackagesRenderer) {
            super(0);
            this.a = jobCvPackagesRenderer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.d.accept(Action.Refresh.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public JobCvPackagesRenderer(@NotNull View view, @NotNull Consumer<Action> consumer, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.d = consumer;
        this.e = simpleRecyclerAdapter;
        this.f = adapterPresenter;
        View findViewById = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type ru.avito.component.toolbar.CollapsingTitleAppBarLayout");
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = (CollapsingTitleAppBarLayout) findViewById;
        collapsingTitleAppBarLayout.setClickListener(this);
        Unit unit = Unit.INSTANCE;
        this.a = collapsingTitleAppBarLayout;
        int i = R.id.recycler_view;
        View findViewById2 = view.findViewById(i);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.addItemDecoration(new a2.a.a.j1.a.a());
        this.b = recyclerView;
        View findViewById3 = view.findViewById(R.id.progress_root);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.progress_root)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById3, i, null, false, 0, 28, null);
        progressOverlay.setOnRefreshListener(new a(this));
        this.c = progressOverlay;
    }

    @Override // ru.avito.component.toolbar.AppbarClickListener
    public void onActionClicked() {
    }

    @Override // ru.avito.component.toolbar.AppbarClickListener
    public void onHomeClicked() {
        this.d.accept(Action.Exit.INSTANCE);
    }

    public final void render(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(state, State.Loading.INSTANCE)) {
            this.c.showLoading();
        } else if (state instanceof State.Content) {
            State.Content content = (State.Content) state;
            this.c.showContent();
            this.a.setExpanded(true);
            this.a.setTitle(content.getTitle());
            this.a.setSubTitle(content.getSubtitle());
            this.b.setAdapter(this.e);
            AdapterPresentersKt.updateItems(this.f, content.getPackages());
            this.e.notifyDataSetChanged();
        } else if (Intrinsics.areEqual(state, State.Error.INSTANCE)) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
