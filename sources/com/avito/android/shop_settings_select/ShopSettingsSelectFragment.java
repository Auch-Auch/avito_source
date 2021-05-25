package com.avito.android.shop_settings_select;

import a2.a.a.u2.c;
import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.shop_settings.ShopSettingsSelectData;
import com.avito.android.service_subscription.R;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItem;
import com.avito.android.shop_settings_select.di.CheckedIds;
import com.avito.android.shop_settings_select.di.DaggerShopSettingsSelectFragmentComponent;
import com.avito.android.shop_settings_select.di.SelectContext;
import com.avito.android.shop_settings_select.di.ShopSettingsSelectFragmentComponent;
import com.avito.android.shop_settings_select.di.ShopSettingsSelectFragmentDependencies;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u0007¢\u0006\u0004\bg\u0010UJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR5\u0010 \u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e¢\u0006\u0002\b\u001f0\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R(\u00108\u001a\b\u0012\u0004\u0012\u000207068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR(\u0010O\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0018\n\u0004\bO\u0010F\u0012\u0004\bT\u0010U\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b^\u0010_R.\u0010a\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006@\u0006X.¢\u0006\u0018\n\u0004\ba\u0010)\u0012\u0004\bf\u0010U\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006i"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onBackPressed", "()Z", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "", "", "d", "Ljava/util/List;", "selectedParentIds", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRouter;", "i", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRouter;", "router", "e", "Landroid/view/ViewGroup;", "contentView", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "toolbarTitleView", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getRecyclerAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setRecyclerAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "c", "Ljava/lang/String;", "inputId", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "selectContext", "getSelectContext", "()Ljava/lang/String;", "setSelectContext", "(Ljava/lang/String;)V", "getSelectContext$annotations", "()V", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "viewModel", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "getViewModel", "()Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "setViewModel", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "h", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "checkedIds", "getCheckedIds", "()Ljava/util/List;", "setCheckedIds", "(Ljava/util/List;)V", "getCheckedIds$annotations", "<init>", "Companion", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectFragment extends BaseFragment implements OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    public String c;
    @Inject
    public List<String> checkedIds;
    public List<String> d;
    public ViewGroup e;
    public RecyclerView f;
    public TextView g;
    public ProgressOverlay h;
    public ShopSettingsSelectRouter i;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public RecyclerView.Adapter<BaseViewHolder> recyclerAdapter;
    @Inject
    public String selectContext;
    @Inject
    public ShopSettingsSelectViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectFragment$Companion;", "", "Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;", "data", "Lcom/avito/android/ui/fragments/BaseFragment;", "newInstance", "(Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;)Lcom/avito/android/ui/fragments/BaseFragment;", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BaseFragment newInstance(@Nullable ShopSettingsSelectData shopSettingsSelectData) {
            ShopSettingsSelectFragment shopSettingsSelectFragment = new ShopSettingsSelectFragment();
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("data", shopSettingsSelectData);
            Unit unit = Unit.INSTANCE;
            shopSettingsSelectFragment.setArguments(bundle);
            return shopSettingsSelectFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopSettingsSelectFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopSettingsSelectFragment shopSettingsSelectFragment) {
            super(0);
            this.a = shopSettingsSelectFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ShopSettingsSelectFragment a;

        public b(ShopSettingsSelectFragment shopSettingsSelectFragment) {
            this.a = shopSettingsSelectFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onBackPressed();
        }
    }

    public static final void access$chooseSelect(ShopSettingsSelectFragment shopSettingsSelectFragment, ShopSettingsSelectionItem shopSettingsSelectionItem) {
        FragmentActivity activity = shopSettingsSelectFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            String str = shopSettingsSelectFragment.c;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputId");
            }
            String stringId = shopSettingsSelectionItem.getStringId();
            String title = shopSettingsSelectionItem.getTitle();
            List<String> list = shopSettingsSelectFragment.d;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedParentIds");
            }
            intent.putExtra("result", new ShopSettingsSelectResult(str, stringId, title, list));
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = shopSettingsSelectFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        ProgressOverlay progressOverlay = shopSettingsSelectFragment.h;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ TextView access$getToolbarTitleView$p(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        TextView textView = shopSettingsSelectFragment.g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarTitleView");
        }
        return textView;
    }

    public static final void access$openSelect(ShopSettingsSelectFragment shopSettingsSelectFragment, ShopSettingsSelectionItem shopSettingsSelectionItem) {
        ShopSettingsSelectRouter shopSettingsSelectRouter = shopSettingsSelectFragment.i;
        if (shopSettingsSelectRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        String str = shopSettingsSelectFragment.c;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputId");
        }
        String str2 = shopSettingsSelectFragment.selectContext;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectContext");
        }
        List<String> list = shopSettingsSelectFragment.checkedIds;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkedIds");
        }
        List<String> list2 = shopSettingsSelectFragment.d;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedParentIds");
        }
        shopSettingsSelectRouter.openSelect(new ShopSettingsSelectData(str, str2, list, CollectionsKt___CollectionsKt.plus((Collection<? extends String>) list2, shopSettingsSelectionItem.getStringId()), shopSettingsSelectionItem.getStringId()));
    }

    @CheckedIds
    public static /* synthetic */ void getCheckedIds$annotations() {
    }

    @SelectContext
    public static /* synthetic */ void getSelectContext$annotations() {
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
    }

    @NotNull
    public final List<String> getCheckedIds() {
        List<String> list = this.checkedIds;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkedIds");
        }
        return list;
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
    public final RecyclerView.Adapter<BaseViewHolder> getRecyclerAdapter() {
        RecyclerView.Adapter<BaseViewHolder> adapter = this.recyclerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return adapter;
    }

    @NotNull
    public final String getSelectContext() {
        String str = this.selectContext;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectContext");
        }
        return str;
    }

    @NotNull
    public final ShopSettingsSelectViewModel getViewModel() {
        ShopSettingsSelectViewModel shopSettingsSelectViewModel = this.viewModel;
        if (shopSettingsSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return shopSettingsSelectViewModel;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.onBackPressed();
        return true;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ShopSettingsSelectViewModel shopSettingsSelectViewModel = this.viewModel;
        if (shopSettingsSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        shopSettingsSelectViewModel.observeItemClicks(set);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.shop_settings_select_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ShopSettingsSelectViewModel shopSettingsSelectViewModel = this.viewModel;
        if (shopSettingsSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundles.putKundle(bundle, "view_model_state", shopSettingsSelectViewModel.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.e = (ViewGroup) findViewById;
        int i2 = R.id.shop_settings_select_list;
        View findViewById2 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.shop_settings_select_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.f = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter<BaseViewHolder> adapter = this.recyclerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(adapter);
        View findViewById3 = view.findViewById(R.id.toolbar_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.toolbar_title)");
        this.g = (TextView) findViewById3;
        ViewGroup viewGroup = this.e;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i2, null, false, 0, 28, null);
        this.h = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(this));
        ((Toolbar) Views.findById(view, R.id.toolbar)).setNavigationOnClickListener(new b(this));
        ShopSettingsSelectViewModel shopSettingsSelectViewModel = this.viewModel;
        if (shopSettingsSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsSelectViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.u2.a(this));
        ShopSettingsSelectViewModel shopSettingsSelectViewModel2 = this.viewModel;
        if (shopSettingsSelectViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsSelectViewModel2.getListChanges().observe(getViewLifecycleOwner(), new a2.a.a.u2.b(this));
        ShopSettingsSelectViewModel shopSettingsSelectViewModel3 = this.viewModel;
        if (shopSettingsSelectViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsSelectViewModel3.getTitleChanges().observe(getViewLifecycleOwner(), new c(this));
        ShopSettingsSelectViewModel shopSettingsSelectViewModel4 = this.viewModel;
        if (shopSettingsSelectViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<ShopSettingsSelectionItem> openSelectEvent = shopSettingsSelectViewModel4.getOpenSelectEvent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        openSelectEvent.observe(viewLifecycleOwner, new i3(0, this));
        ShopSettingsSelectViewModel shopSettingsSelectViewModel5 = this.viewModel;
        if (shopSettingsSelectViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<ShopSettingsSelectionItem> chooseSelectEvent = shopSettingsSelectViewModel5.getChooseSelectEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        chooseSelectEvent.observe(viewLifecycleOwner2, new i3(1, this));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setCheckedIds(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.checkedIds = list;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter(@NotNull RecyclerView.Adapter<BaseViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.recyclerAdapter = adapter;
    }

    public final void setSelectContext(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectContext = str;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Kundle kundle;
        ShopSettingsSelectData shopSettingsSelectData;
        if (bundle == null || (kundle = Bundles.getKundle(bundle, "view_model_state")) == null) {
            kundle = Kundle.Companion.getEMPTY();
        }
        Context context = getContext();
        if (!(context instanceof ShopSettingsSelectRouter)) {
            context = null;
        }
        ShopSettingsSelectRouter shopSettingsSelectRouter = (ShopSettingsSelectRouter) context;
        if (shopSettingsSelectRouter != null) {
            this.i = shopSettingsSelectRouter;
            Bundle arguments = getArguments();
            if (arguments == null || (shopSettingsSelectData = (ShopSettingsSelectData) arguments.getParcelable("data")) == null) {
                throw new IllegalStateException("Data must not be null");
            }
            Intrinsics.checkNotNullExpressionValue(shopSettingsSelectData, "arguments?.getParcelable…(\"Data must not be null\")");
            this.c = shopSettingsSelectData.getInputId();
            this.d = shopSettingsSelectData.getSelectedParentIds();
            ShopSettingsSelectFragmentComponent.Factory factory = DaggerShopSettingsSelectFragmentComponent.factory();
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            factory.create(resources, this, kundle, shopSettingsSelectData.getSelectContext(), shopSettingsSelectData.getCheckedIds(), shopSettingsSelectData.getSelectedId(), (ShopSettingsSelectFragmentDependencies) ComponentDependenciesKt.getDependencies(ShopSettingsSelectFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
            return true;
        }
        throw new IllegalStateException("Context must conform to ShopSettingsSelectRouter");
    }

    public final void setViewModel(@NotNull ShopSettingsSelectViewModel shopSettingsSelectViewModel) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectViewModel, "<set-?>");
        this.viewModel = shopSettingsSelectViewModel;
    }
}
