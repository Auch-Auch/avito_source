package com.avito.android.verification.verifications_list;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.verification.R;
import com.avito.android.verification.di.DaggerVerificationsListComponent;
import com.avito.android.verification.di.VerificationsListComponent;
import com.avito.android.verification.di.VerificationsListDependencies;
import com.avito.android.verification.verifications_list.list.VerificationOptionItem;
import com.avito.android.verification.verifications_list.list.VerificationsListItemPresenter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0002BCB\u0007¢\u0006\u0004\bA\u0010\u0010J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R5\u0010\u0017\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015¢\u0006\u0002\b\u00160\u00148\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0000@\u0000X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresentersSet", "Ljava/util/Set;", "getItemPresentersSet$verification_release", "()Ljava/util/Set;", "setItemPresentersSet$verification_release", "(Ljava/util/Set;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter$verification_release", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter$verification_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/verification/verifications_list/VerificationsListView;", "c", "Lcom/avito/android/verification/verifications_list/VerificationsListView;", "verificationsListView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter$verification_release", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter$verification_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$verification_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$verification_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;", "viewModel", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;", "getViewModel$verification_release", "()Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;", "setViewModel$verification_release", "(Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;)V", "<init>", "Companion", "VerificationsListRouter", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationsListFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public VerificationsListView c;
    public final CompositeDisposable d = new CompositeDisposable();
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresentersSet;
    @Inject
    public VerificationsListViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListFragment$Companion;", "", "Lcom/avito/android/verification/verifications_list/VerificationsListFragment;", "newInstance", "()Lcom/avito/android/verification/verifications_list/VerificationsListFragment;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VerificationsListFragment newInstance() {
            return new VerificationsListFragment();
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListFragment$VerificationsListRouter;", "", "", "type", "", "navigateToVerificationStatus", "(Ljava/lang/String;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public interface VerificationsListRouter {
        void navigateToVerificationStatus(@NotNull String str);
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((VerificationsListFragment) this.b).requireActivity().onBackPressed();
            } else if (i == 1) {
                ((VerificationsListFragment) this.b).getViewModel$verification_release().loadVerificationsList();
            } else if (i == 2) {
                ((VerificationsListFragment) this.b).getViewModel$verification_release().refreshVerificationsList();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<VerificationOptionItem> {
        public final /* synthetic */ VerificationsListFragment a;

        public b(VerificationsListFragment verificationsListFragment) {
            this.a = verificationsListFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(VerificationOptionItem verificationOptionItem) {
            VerificationOptionItem verificationOptionItem2 = verificationOptionItem;
            VerificationsListViewModel viewModel$verification_release = this.a.getViewModel$verification_release();
            Intrinsics.checkNotNullExpressionValue(verificationOptionItem2, "it");
            viewModel$verification_release.onVerificationOptionClicked(verificationOptionItem2);
        }
    }

    public static final /* synthetic */ VerificationsListView access$getVerificationsListView$p(VerificationsListFragment verificationsListFragment) {
        VerificationsListView verificationsListView = verificationsListFragment.c;
        if (verificationsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verificationsListView");
        }
        return verificationsListView;
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter$verification_release() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter$verification_release() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics$verification_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresentersSet$verification_release() {
        Set<ItemPresenter<?, ?>> set = this.itemPresentersSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresentersSet");
        }
        return set;
    }

    @NotNull
    public final VerificationsListViewModel getViewModel$verification_release() {
        VerificationsListViewModel verificationsListViewModel = this.viewModel;
        if (verificationsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return verificationsListViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.verifications_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…s_list, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.d.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        VerificationsListViewModel verificationsListViewModel = this.viewModel;
        if (verificationsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        verificationsListViewModel.onViewCreated();
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        VerificationsListViewImpl verificationsListViewImpl = new VerificationsListViewImpl(view, analytics2, simpleRecyclerAdapter, adapterPresenter2);
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = verificationsListViewImpl.getBackClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "backClicks.subscribe { r…ivity().onBackPressed() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = verificationsListViewImpl.getRetryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "retryClicks.subscribe { …loadVerificationsList() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = verificationsListViewImpl.getRefreshes().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "refreshes.subscribe { vi…reshVerificationsList() }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        this.c = verificationsListViewImpl;
        Set<ItemPresenter<?, ?>> set = this.itemPresentersSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresentersSet");
        }
        for (T t : set) {
            if (t instanceof VerificationsListItemPresenter) {
                CompositeDisposable compositeDisposable4 = this.d;
                Disposable subscribe4 = t.getClicks().subscribe(new b(this));
                Intrinsics.checkNotNullExpressionValue(subscribe4, "it.clicks.subscribe { \n …ed(it) \n                }");
                DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            }
        }
        VerificationsListViewModel verificationsListViewModel2 = this.viewModel;
        if (verificationsListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        verificationsListViewModel2.getScreenState().observe(getViewLifecycleOwner(), new a2.a.a.r3.b.a(this));
        verificationsListViewModel2.getRouterAction().observe(getViewLifecycleOwner(), new a2.a.a.r3.b.b(this));
    }

    public final void setAdapter$verification_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAdapterPresenter$verification_release(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$verification_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setItemPresentersSet$verification_release(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresentersSet = set;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        VerificationsListComponent.Factory factory = DaggerVerificationsListComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(this, resources, (VerificationsListDependencies) ComponentDependenciesKt.getDependencies(VerificationsListDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }

    public final void setViewModel$verification_release(@NotNull VerificationsListViewModel verificationsListViewModel) {
        Intrinsics.checkNotNullParameter(verificationsListViewModel, "<set-?>");
        this.viewModel = verificationsListViewModel;
    }
}
