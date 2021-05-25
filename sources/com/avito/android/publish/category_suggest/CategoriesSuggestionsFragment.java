package com.avito.android.publish.category_suggest;

import a2.a.a.e2.o.a;
import a2.a.a.e2.o.b;
import a2.a.a.e2.o.c;
import a2.a.a.e2.o.d;
import a2.a.a.e2.o.e;
import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.publish.PublishActivityKt;
import com.avito.android.publish.PublishAppbarView;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.category_suggest.di.CategoriesSuggestionsModule;
import com.avito.android.publish.category_suggest.di.DaggerCategoriesSuggestionsComponent;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.view.publish_button.PublishButton;
import com.avito.android.publish.view.publish_button.PublishButtonImpl;
import com.avito.android.publish.wizard.WizardFragmentKt;
import com.avito.android.publish.wizard.WizardRouter;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R&\u0010A\u001a\u0006\u0012\u0002\b\u00030@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0005\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR5\u0010f\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030d¢\u0006\u0002\be0c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010r\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}¨\u0006\u0001"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/publish/wizard/WizardRouter;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "", AuthSource.SEND_ABUSE, "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "", "onBackPressed", "()Z", "Lcom/avito/android/remote/model/WizardParameter;", "wizardParameter", "onParameterSelected", "(Lcom/avito/android/remote/model/WizardParameter;)V", "leaveWizard", "leavePublish", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lio/reactivex/disposables/CompositeDisposable;", "i", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModelFactory;)V", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "publishDraftDataHolder", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "getPublishDraftDataHolder", "()Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "setPublishDraftDataHolder", "(Lcom/avito/android/publish/drafts/PublishDraftDataHolder;)V", g.a, "Landroid/view/View;", "suggestsView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "getPublishEventTracker", "()Lcom/avito/android/publish/analytics/PublishEventTracker;", "setPublishEventTracker", "(Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/publish/PublishViewModel;", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "k", "I", "stepIndex", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel;", "viewModel", "h", "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsRouter;", "c", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsRouter;", "router", "Lcom/avito/android/publish/PublishAppbarView;", "f", "Lcom/avito/android/publish/PublishAppbarView;", "appbarView", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "j", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "publishButton", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesSuggestionsFragment extends Fragment implements WizardRouter, OnBackPressedListener {
    public PublishViewModel a;
    @Inject
    public RecyclerView.Adapter<?> adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public CategoriesSuggestionsViewModel b;
    public CategoriesSuggestionsRouter c;
    public ProgressOverlay d;
    public RecyclerView e;
    public PublishAppbarView f;
    public View g;
    public ViewGroup h;
    public final CompositeDisposable i = new CompositeDisposable();
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    public PublishButton j;
    public int k = -1;
    @Inject
    public PublishDraftDataHolder publishDraftDataHolder;
    @Inject
    public PublishEventTracker publishEventTracker;
    @Inject
    public CategoriesSuggestionsViewModelFactory viewModelFactory;

    public static final void access$addDividerItemDecoration(CategoriesSuggestionsFragment categoriesSuggestionsFragment, List list) {
        Context context = categoriesSuggestionsFragment.getContext();
        Drawable drawable = context != null ? context.getDrawable(R.drawable.recycler_view_divider) : null;
        int dimensionPixelSize = categoriesSuggestionsFragment.getResources().getDimensionPixelSize(R.dimen.container_horizontal_padding);
        VerticalListItemDecoration.Builder padding = new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelSize, dimensionPixelSize);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            padding.setDividerForItemAt(((Number) it.next()).intValue(), drawable);
        }
        RecyclerView recyclerView = categoriesSuggestionsFragment.e;
        if (recyclerView != null) {
            RecyclerViewsKt.clearItemDecorations(recyclerView);
        }
        RecyclerView recyclerView2 = categoriesSuggestionsFragment.e;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(padding.build());
        }
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        PublishViewModel publishViewModel = categoriesSuggestionsFragment.a;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final /* synthetic */ CategoriesSuggestionsRouter access$getRouter$p(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        CategoriesSuggestionsRouter categoriesSuggestionsRouter = categoriesSuggestionsFragment.c;
        if (categoriesSuggestionsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return categoriesSuggestionsRouter;
    }

    public static final /* synthetic */ CategoriesSuggestionsViewModel access$getViewModel$p(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = categoriesSuggestionsFragment.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return categoriesSuggestionsViewModel;
    }

    public static final void access$showWizardInnerFragment(CategoriesSuggestionsFragment categoriesSuggestionsFragment, Navigation navigation) {
        ViewGroup viewGroup = categoriesSuggestionsFragment.h;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        View view = categoriesSuggestionsFragment.g;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestsView");
        }
        viewGroup.removeView(view);
        FragmentTransaction beginTransaction = categoriesSuggestionsFragment.getChildFragmentManager().beginTransaction();
        int i2 = com.avito.android.publish.R.id.container;
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = categoriesSuggestionsFragment.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        beginTransaction.replace(i2, WizardFragmentKt.createWizardFragment$default(null, navigation, true, null, null, categoriesSuggestionsViewModel.getStepId(), 25, null)).addToBackStack(null).commit();
    }

    public final void a() {
        RecyclerView.ItemAnimator itemAnimator;
        View view = this.g;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestsView");
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.h;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        if (!Intrinsics.areEqual(parent, viewGroup)) {
            ViewGroup viewGroup2 = this.h;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            }
            View view2 = this.g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestsView");
            }
            viewGroup2.addView(view2);
            View view3 = this.g;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestsView");
            }
            RecyclerView recyclerView = (RecyclerView) view3.findViewById(com.avito.android.publish.R.id.suggest_recycler_view);
            this.e = recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            }
            RecyclerView recyclerView2 = this.e;
            if (!(recyclerView2 == null || (itemAnimator = recyclerView2.getItemAnimator()) == null)) {
                itemAnimator.setAddDuration(500);
            }
            RecyclerView recyclerView3 = this.e;
            if (recyclerView3 != null) {
                RecyclerView.Adapter<?> adapter2 = this.adapter;
                if (adapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                recyclerView3.setAdapter(adapter2);
            }
            ViewGroup viewGroup3 = this.h;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            }
            int i2 = com.avito.android.publish.R.id.recycler_view;
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            this.d = new ProgressOverlay(viewGroup3, i2, analytics2, false, 0, 24, null);
            View view4 = this.g;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestsView");
            }
            PublishViewModel publishViewModel = this.a;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            this.f = new PublishAppbarView(view4, publishViewModel.getShouldSaveDraft());
            PublishViewModel publishViewModel2 = this.a;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            CategoryPublishStep step = publishViewModel2.getStep(Integer.valueOf(this.k));
            if (step != null) {
                PublishAppbarView publishAppbarView = this.f;
                if (publishAppbarView != null) {
                    publishAppbarView.setTitle(step.getTitle());
                }
                PublishAppbarView publishAppbarView2 = this.f;
                if (publishAppbarView2 != null) {
                    String shortTitle = step.getShortTitle();
                    if (shortTitle == null) {
                        shortTitle = step.getTitle();
                    }
                    publishAppbarView2.setShortTitle(shortTitle);
                }
                PublishAppbarView publishAppbarView3 = this.f;
                if (publishAppbarView3 != null) {
                    publishAppbarView3.setSubtitle(step.getSubtitle());
                }
            }
            ViewGroup viewGroup4 = this.h;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            }
            PublishButtonImpl publishButtonImpl = new PublishButtonImpl(viewGroup4);
            this.j = publishButtonImpl;
            String string = getString(R.string.continue_string);
            Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.continue_string)");
            publishButtonImpl.setText(string);
            CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
            if (categoriesSuggestionsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            PublishAppbarView publishAppbarView4 = this.f;
            if (publishAppbarView4 != null) {
                publishAppbarView4.setActionsListener(new i5(0, categoriesSuggestionsViewModel), new i5(1, categoriesSuggestionsViewModel));
            }
            ProgressOverlay progressOverlay = this.d;
            if (progressOverlay != null) {
                progressOverlay.setOnRefreshListener(new i5(2, categoriesSuggestionsViewModel));
            }
            PublishButton publishButton = this.j;
            if (publishButton != null) {
                publishButton.setClickListener(new i5(3, categoriesSuggestionsViewModel));
            }
        }
    }

    @NotNull
    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final PublishDraftDataHolder getPublishDraftDataHolder() {
        PublishDraftDataHolder publishDraftDataHolder2 = this.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        return publishDraftDataHolder2;
    }

    @NotNull
    public final PublishEventTracker getPublishEventTracker() {
        PublishEventTracker publishEventTracker2 = this.publishEventTracker;
        if (publishEventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishEventTracker");
        }
        return publishEventTracker2;
    }

    @NotNull
    public final CategoriesSuggestionsViewModelFactory getViewModelFactory() {
        CategoriesSuggestionsViewModelFactory categoriesSuggestionsViewModelFactory = this.viewModelFactory;
        if (categoriesSuggestionsViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return categoriesSuggestionsViewModelFactory;
    }

    @Override // com.avito.android.publish.wizard.WizardRouter
    public void leavePublish() {
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel.onCloseClicked();
    }

    @Override // com.avito.android.publish.wizard.WizardRouter
    public void leaveWizard() {
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel.onLeaveWizardClicked();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.publish.category_suggest.CategoriesSuggestionsRouter");
        this.c = (CategoriesSuggestionsRouter) activity;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Fragment fragment = (Fragment) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        if (fragment instanceof OnBackPressedListener) {
            ((OnBackPressedListener) fragment).onBackPressed();
            return true;
        }
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel.onLeaveClicked();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.k = arguments != null ? arguments.getInt(PublishActivityKt.KEY_STEP_INDEX) : -1;
        DaggerCategoriesSuggestionsComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).categoriesSuggestionsModule(new CategoriesSuggestionsModule()).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(com.avito.android.publish.R.layout.categories_suggestions_container, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel.screenState().removeObservers(getViewLifecycleOwner());
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel2 = this.b;
        if (categoriesSuggestionsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel2.routingActions().removeObservers(getViewLifecycleOwner());
        this.i.clear();
        super.onDestroyView();
    }

    @Override // com.avito.android.publish.wizard.WizardRouter
    public void onParameterSelected(@NotNull WizardParameter wizardParameter) {
        Intrinsics.checkNotNullParameter(wizardParameter, "wizardParameter");
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        CategoriesSuggestionsViewModel.onCategorySelected$default(categoriesSuggestionsViewModel, wizardParameter, false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.h = (ViewGroup) view;
        View inflate = View.inflate(getContext(), com.avito.android.publish.R.layout.categories_suggestions, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "View.inflate(context, R.…gories_suggestions, null)");
        this.g = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (PublishViewModel) viewModel;
        CategoriesSuggestionsViewModelFactory categoriesSuggestionsViewModelFactory = this.viewModelFactory;
        if (categoriesSuggestionsViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.of(this, categoriesSuggestionsViewModelFactory).get(CategoriesSuggestionsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProviders.of(th…onsViewModel::class.java)");
        this.b = (CategoriesSuggestionsViewModel) viewModel2;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (childFragmentManager.getBackStackEntryCount() == 0) {
            a();
        }
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        for (T t : set) {
            if (t instanceof WizardItemPresenter) {
                CompositeDisposable compositeDisposable = this.i;
                Disposable subscribe = t.getItemClickObservable().subscribe(new d(this), e.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "itemClickStream\n        …eam\", it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel = this.b;
        if (categoriesSuggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel.screenState().observe(getViewLifecycleOwner(), new b(this));
        categoriesSuggestionsViewModel.mainActionState().observe(getViewLifecycleOwner(), new c(this));
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel2 = this.b;
        if (categoriesSuggestionsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        categoriesSuggestionsViewModel2.routingActions().observe(getViewLifecycleOwner(), new a(this));
        CategoriesSuggestionsViewModel categoriesSuggestionsViewModel3 = this.b;
        if (categoriesSuggestionsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        int i2 = this.k;
        PublishViewModel publishViewModel = this.a;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishDraftDataHolder publishDraftDataHolder2 = this.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        categoriesSuggestionsViewModel3.initScreen(i2, publishViewModel, publishDraftDataHolder2);
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setPublishDraftDataHolder(@NotNull PublishDraftDataHolder publishDraftDataHolder2) {
        Intrinsics.checkNotNullParameter(publishDraftDataHolder2, "<set-?>");
        this.publishDraftDataHolder = publishDraftDataHolder2;
    }

    public final void setPublishEventTracker(@NotNull PublishEventTracker publishEventTracker2) {
        Intrinsics.checkNotNullParameter(publishEventTracker2, "<set-?>");
        this.publishEventTracker = publishEventTracker2;
    }

    public final void setViewModelFactory(@NotNull CategoriesSuggestionsViewModelFactory categoriesSuggestionsViewModelFactory) {
        Intrinsics.checkNotNullParameter(categoriesSuggestionsViewModelFactory, "<set-?>");
        this.viewModelFactory = categoriesSuggestionsViewModelFactory;
    }
}
