package com.avito.android.publish.select;

import a2.a.a.e2.c0.b;
import a2.a.a.e2.c0.c;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.publish.PublishActivity;
import com.avito.android.publish.PublishActivityKt;
import com.avito.android.publish.PublishAppbarView;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.select.SelectFragment;
import com.avito.android.publish.select.di.DaggerSelectComponent;
import com.avito.android.publish.select.di.SelectModule;
import com.avito.android.publish.view.publish_button.PublishButton;
import com.avito.android.publish.view.publish_button.PublishButtonImpl;
import com.avito.android.recycler.layout_manager.UnpredictiveLinearLayoutManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bI\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R&\u0010(\u001a\u0006\u0012\u0002\b\u00030'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R5\u00108\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000306¢\u0006\u0002\b7058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/avito/android/publish/select/SelectFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "onActivityCreated", "onDestroyView", "()V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/publish/select/SelectViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/select/SelectViewModel;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/publish/select/SelectViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/select/SelectViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/select/SelectViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/select/SelectViewModelFactory;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "e", "Lcom/avito/android/publish/view/publish_button/PublishButton;", "publishButton", "Lcom/avito/android/publish/PublishAppbarView;", "c", "Lcom/avito/android/publish/PublishAppbarView;", "appbarView", "d", "Landroid/view/View;", "footer", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SelectFragment extends Fragment implements OnBackPressedListener {
    public SelectViewModel a;
    @Inject
    public RecyclerView.Adapter<?> adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    public RecyclerView b;
    public PublishAppbarView c;
    public View d;
    public PublishButton e;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public SelectViewModelFactory viewModelFactory;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ SelectFragment a;
        public final /* synthetic */ int b;

        public a(SelectFragment selectFragment, int i) {
            this.a = selectFragment;
            this.b = i;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            RecyclerView access$getRecycler$p = SelectFragment.access$getRecycler$p(this.a);
            int i9 = this.b;
            Intrinsics.checkNotNullExpressionValue(view, "footer");
            Views.changePadding$default(access$getRecycler$p, 0, 0, 0, view.getHeight() + i9, 7, null);
        }
    }

    public static final /* synthetic */ PublishAppbarView access$getAppbarView$p(SelectFragment selectFragment) {
        PublishAppbarView publishAppbarView = selectFragment.c;
        if (publishAppbarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appbarView");
        }
        return publishAppbarView;
    }

    public static final /* synthetic */ PublishButton access$getPublishButton$p(SelectFragment selectFragment) {
        PublishButton publishButton = selectFragment.e;
        if (publishButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishButton");
        }
        return publishButton;
    }

    public static final /* synthetic */ RecyclerView access$getRecycler$p(SelectFragment selectFragment) {
        RecyclerView recyclerView = selectFragment.b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        return recyclerView;
    }

    public static final void access$leavePublish(SelectFragment selectFragment) {
        FragmentActivity requireActivity = selectFragment.requireActivity();
        Objects.requireNonNull(requireActivity, "null cannot be cast to non-null type com.avito.android.publish.PublishActivity");
        ((PublishActivity) requireActivity).leavePublish();
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
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final SelectViewModelFactory getViewModelFactory() {
        SelectViewModelFactory selectViewModelFactory = this.viewModelFactory;
        if (selectViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return selectViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = ViewModelProviders.of(requireActivity, (ViewModelProvider.Factory) null).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        this.c = new PublishAppbarView(requireView, publishViewModel.getShouldSaveDraft());
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt(PublishActivityKt.KEY_STEP_INDEX);
            CategoryPublishStep step = publishViewModel.getStep(Integer.valueOf(i));
            if (step != null) {
                PublishAppbarView publishAppbarView = this.c;
                if (publishAppbarView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appbarView");
                }
                publishAppbarView.setTitle(step.getTitle());
                PublishAppbarView publishAppbarView2 = this.c;
                if (publishAppbarView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appbarView");
                }
                String shortTitle = step.getShortTitle();
                if (shortTitle == null) {
                    shortTitle = step.getTitle();
                }
                publishAppbarView2.setShortTitle(shortTitle);
                PublishAppbarView publishAppbarView3 = this.c;
                if (publishAppbarView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appbarView");
                }
                publishAppbarView3.setSubtitle(step.getSubtitle());
            }
            SelectViewModel selectViewModel = this.a;
            if (selectViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
            if (set == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
            }
            selectViewModel.initScreen(i, publishViewModel, set);
            SelectViewModel selectViewModel2 = this.a;
            if (selectViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            PublishAppbarView publishAppbarView4 = this.c;
            if (publishAppbarView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appbarView");
            }
            publishAppbarView4.setActionsListener(new Function0<Unit>(this) { // from class: a2.a.a.e2.c0.d
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    SelectFragment.access$leavePublish((SelectFragment) this.receiver);
                    return Unit.INSTANCE;
                }
            }, new d6(0, selectViewModel2));
            PublishButton publishButton = this.e;
            if (publishButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishButton");
            }
            publishButton.setClickListener(new d6(1, selectViewModel2));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        SelectViewModel selectViewModel = this.a;
        if (selectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        selectViewModel.onLeaveClicked();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerSelectComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).selectModule(new SelectModule()).build().inject(this);
        SelectViewModelFactory selectViewModelFactory = this.viewModelFactory;
        if (selectViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, selectViewModelFactory).get(SelectViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (SelectViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.select_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectViewModel selectViewModel = this.a;
        if (selectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        selectViewModel.onDestroyView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.e = new PublishButtonImpl(view);
        View findViewById = view.findViewById(R.id.footer);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.footer)");
        this.d = findViewById;
        PublishButton publishButton = this.e;
        if (publishButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishButton");
        }
        String string = getString(com.avito.android.ui_components.R.string.continue_string);
        Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.continue_string)");
        publishButton.setText(string);
        View findViewById2 = view.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        recyclerView.setLayoutManager(new UnpredictiveLinearLayoutManager(context));
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(500);
        }
        RecyclerView recyclerView3 = this.b;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView3.setAdapter(adapter2);
        SelectViewModel selectViewModel = this.a;
        if (selectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        selectViewModel.getItems().observe(getViewLifecycleOwner(), new b(this));
        selectViewModel.getMainActionState().observe(getViewLifecycleOwner(), new c(this));
        SelectViewModel selectViewModel2 = this.a;
        if (selectViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        selectViewModel2.routingActions().observe(getViewLifecycleOwner(), new a2.a.a.e2.c0.a(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.publish_card_padding_vertical);
        View view2 = this.d;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footer");
        }
        view2.addOnLayoutChangeListener(new a(this, dimensionPixelSize));
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setViewModelFactory(@NotNull SelectViewModelFactory selectViewModelFactory) {
        Intrinsics.checkNotNullParameter(selectViewModelFactory, "<set-?>");
        this.viewModelFactory = selectViewModelFactory;
    }
}
