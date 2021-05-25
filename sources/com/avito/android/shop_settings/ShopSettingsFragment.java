package com.avito.android.shop_settings;

import a2.a.a.t2.c;
import a2.a.a.t2.h;
import a2.a.a.t2.l;
import a2.a.a.t2.m;
import a2.g.r.g;
import android.annotation.SuppressLint;
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
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.ShopSettingsConfirmation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.shop_settings.ShopSettingsSelectData;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings.di.AddressItemClick;
import com.avito.android.shop_settings.di.DaggerShopSettingsFragmentComponent;
import com.avito.android.shop_settings.di.SaveButtonClick;
import com.avito.android.shop_settings.di.SelectItemClick;
import com.avito.android.shop_settings.di.ShopSettingsFragmentComponent;
import com.avito.android.shop_settings.di.ShopSettingsFragmentDependencies;
import com.avito.android.shop_settings_select.ShopSettingsSelectResult;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Bundles;
import com.avito.android.util.Contexts;
import com.avito.android.util.Kundle;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
import t6.y.k;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001nB\u0007¢\u0006\u0004\bm\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R.\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X.¢\u0006\u0018\n\u0004\b#\u0010$\u0012\u0004\b)\u0010\u0014\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R.\u00103\u001a\b\u0012\u0004\u0012\u0002020!8\u0006@\u0006X.¢\u0006\u0018\n\u0004\b3\u0010$\u0012\u0004\b6\u0010\u0014\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R.\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100!8\u0006@\u0006X.¢\u0006\u0018\n\u0004\bA\u0010$\u0012\u0004\bD\u0010\u0014\u001a\u0004\bB\u0010&\"\u0004\bC\u0010(R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bQ\u00108R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onBackPressed", "()Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItem;", "selectItemClickListener", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getSelectItemClickListener", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "setSelectItemClickListener", "(Lcom/jakewharton/rxrelay2/PublishRelay;)V", "getSelectItemClickListener$annotations", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getRecyclerAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setRecyclerAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/shop_settings/blueprints/address/ShopSettingsAddressItem;", "addressItemClickListener", "getAddressItemClickListener", "setAddressItemClickListener", "getAddressItemClickListener$annotations", "c", "Landroid/view/ViewGroup;", "contentView", "Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "viewModel", "Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "getViewModel", "()Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "setViewModel", "(Lcom/avito/android/shop_settings/ShopSettingsViewModel;)V", "saveButtonClickListener", "getSaveButtonClickListener", "setSaveButtonClickListener", "getSaveButtonClickListener$annotations", "Lio/reactivex/disposables/CompositeDisposable;", "i", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "toolbarTitleView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "h", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "d", "fragmentRoot", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/lib/design/button/Button;", g.a, "Lcom/avito/android/lib/design/button/Button;", "saveButton", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "", "j", "Ljava/lang/String;", "selectedAddressItemId", "<init>", "Companion", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsFragment extends BaseFragment implements OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public PublishRelay<ShopSettingsAddressItem> addressItemClickListener;
    public ViewGroup c;
    public ViewGroup d;
    public RecyclerView e;
    public TextView f;
    public Button g;
    public ProgressOverlay h;
    public final CompositeDisposable i = new CompositeDisposable();
    public String j;
    @Inject
    public RecyclerView.Adapter<BaseViewHolder> recyclerAdapter;
    @Inject
    public PublishRelay<Unit> saveButtonClickListener;
    @Inject
    public PublishRelay<ShopSettingsSelectItem> selectItemClickListener;
    @Inject
    public ShopSettingsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsFragment$Companion;", "", "Lcom/avito/android/ui/fragments/BaseFragment;", "newInstance", "()Lcom/avito/android/ui/fragments/BaseFragment;", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BaseFragment newInstance() {
            return new ShopSettingsFragment();
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((ShopSettingsFragment) this.b).getSaveButtonClickListener().accept(Unit.INSTANCE);
            } else if (i == 1) {
                ((ShopSettingsFragment) this.b).onBackPressed();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopSettingsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ShopSettingsFragment shopSettingsFragment) {
            super(0);
            this.a = shopSettingsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final void access$enableBackground(ShopSettingsFragment shopSettingsFragment) {
        ViewGroup viewGroup = shopSettingsFragment.d;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentRoot");
        }
        Context requireContext = shopSettingsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        viewGroup.setBackgroundColor(Contexts.getColorByAttr(requireContext, R.attr.white));
    }

    public static final /* synthetic */ ViewGroup access$getContentView$p(ShopSettingsFragment shopSettingsFragment) {
        ViewGroup viewGroup = shopSettingsFragment.c;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        return viewGroup;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(ShopSettingsFragment shopSettingsFragment) {
        ProgressOverlay progressOverlay = shopSettingsFragment.h;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(ShopSettingsFragment shopSettingsFragment) {
        RecyclerView recyclerView = shopSettingsFragment.e;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ Button access$getSaveButton$p(ShopSettingsFragment shopSettingsFragment) {
        Button button = shopSettingsFragment.g;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        return button;
    }

    public static final /* synthetic */ TextView access$getToolbarTitleView$p(ShopSettingsFragment shopSettingsFragment) {
        TextView textView = shopSettingsFragment.f;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarTitleView");
        }
        return textView;
    }

    public static final void access$hideSaveButton(ShopSettingsFragment shopSettingsFragment) {
        ViewGroup viewGroup = shopSettingsFragment.c;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        Button button = shopSettingsFragment.g;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        transitionDsl.addTarget(button);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        Button button2 = shopSettingsFragment.g;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        Views.conceal(button2);
    }

    public static final void access$openLocationPicker(ShopSettingsFragment shopSettingsFragment, ShopSettingsAddressItem shopSettingsAddressItem) {
        Objects.requireNonNull(shopSettingsFragment);
        shopSettingsFragment.j = shopSettingsAddressItem.getStringId();
        String latitude = shopSettingsAddressItem.getLatitude();
        AddressParameter.Value value = null;
        Double doubleOrNull = latitude != null ? k.toDoubleOrNull(latitude) : null;
        String longitude = shopSettingsAddressItem.getLongitude();
        Double doubleOrNull2 = longitude != null ? k.toDoubleOrNull(longitude) : null;
        if (!(doubleOrNull == null || doubleOrNull2 == null)) {
            value = new AddressParameter.Value(doubleOrNull.doubleValue(), doubleOrNull2.doubleValue(), shopSettingsAddressItem.getCurrentText(), null, 8, null);
        }
        ActivityIntentFactory activityIntentFactory2 = shopSettingsFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        shopSettingsFragment.startActivityForResult(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(activityIntentFactory2, value, null, null, null, null, null, null, null, 254, null), 666);
    }

    public static final void access$openSelect(ShopSettingsFragment shopSettingsFragment, ShopSettingsSelectItem shopSettingsSelectItem) {
        ActivityIntentFactory activityIntentFactory2 = shopSettingsFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        String stringId = shopSettingsSelectItem.getStringId();
        String selectContext = shopSettingsSelectItem.getSelectContext();
        List<String> parentValues = shopSettingsSelectItem.getParentValues();
        String value = shopSettingsSelectItem.getValue();
        List listOf = value != null ? d.listOf(value) : null;
        if (listOf == null) {
            listOf = CollectionsKt__CollectionsKt.emptyList();
        }
        shopSettingsFragment.startActivityForResult(activityIntentFactory2.shopSettingsSelectActivityIntent(new ShopSettingsSelectData(stringId, selectContext, CollectionsKt___CollectionsKt.plus((Collection) parentValues, (Iterable) listOf), CollectionsKt__CollectionsKt.emptyList(), null)), 42);
    }

    public static final void access$showSaveButton(ShopSettingsFragment shopSettingsFragment) {
        ViewGroup viewGroup = shopSettingsFragment.c;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        Button button = shopSettingsFragment.g;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        transitionDsl.addTarget(button);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        Button button2 = shopSettingsFragment.g;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        Views.show(button2);
    }

    @AddressItemClick
    public static /* synthetic */ void getAddressItemClickListener$annotations() {
    }

    @SaveButtonClick
    public static /* synthetic */ void getSaveButtonClickListener$annotations() {
    }

    @SelectItemClick
    public static /* synthetic */ void getSelectItemClickListener$annotations() {
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
    public final PublishRelay<ShopSettingsAddressItem> getAddressItemClickListener() {
        PublishRelay<ShopSettingsAddressItem> publishRelay = this.addressItemClickListener;
        if (publishRelay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemClickListener");
        }
        return publishRelay;
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
    public final PublishRelay<Unit> getSaveButtonClickListener() {
        PublishRelay<Unit> publishRelay = this.saveButtonClickListener;
        if (publishRelay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonClickListener");
        }
        return publishRelay;
    }

    @NotNull
    public final PublishRelay<ShopSettingsSelectItem> getSelectItemClickListener() {
        PublishRelay<ShopSettingsSelectItem> publishRelay = this.selectItemClickListener;
        if (publishRelay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectItemClickListener");
        }
        return publishRelay;
    }

    @NotNull
    public final ShopSettingsViewModel getViewModel() {
        ShopSettingsViewModel shopSettingsViewModel = this.viewModel;
        if (shopSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return shopSettingsViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        ShopSettingsSelectResult shopSettingsSelectResult;
        AddressParameter.Value value;
        String str;
        if (i2 != 42) {
            if (i2 == 666) {
                if (!(i3 != -1 || intent == null || (value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT)) == null || (str = this.j) == null)) {
                    ShopSettingsViewModel shopSettingsViewModel = this.viewModel;
                    if (shopSettingsViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    shopSettingsViewModel.handleLocationPickerResult(str, value);
                }
                this.j = null;
            } else if (i2 != 4815) {
                super.onActivityResult(i2, i3, intent);
            } else if (i3 == -1) {
                ShopSettingsViewModel shopSettingsViewModel2 = this.viewModel;
                if (shopSettingsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                shopSettingsViewModel2.loadContent();
            } else {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        } else if (i3 == -1 && intent != null && (shopSettingsSelectResult = (ShopSettingsSelectResult) intent.getParcelableExtra("result")) != null) {
            ShopSettingsViewModel shopSettingsViewModel3 = this.viewModel;
            if (shopSettingsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            shopSettingsViewModel3.handleSelectResult(shopSettingsSelectResult);
        }
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

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(com.avito.android.service_subscription.R.layout.shop_settings_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.i.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ShopSettingsViewModel shopSettingsViewModel = this.viewModel;
        if (shopSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundles.putKundle(bundle, "view_model_state", shopSettingsViewModel.saveState());
        bundle.putString("location_picker_state", this.j);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(com.avito.android.service_subscription.R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.c = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(com.avito.android.service_subscription.R.id.shop_settings_fragment_root);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.s…p_settings_fragment_root)");
        this.d = (ViewGroup) findViewById2;
        int i2 = com.avito.android.service_subscription.R.id.shop_settings_list;
        View findViewById3 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.shop_settings_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.e = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter<BaseViewHolder> adapter = this.recyclerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(adapter);
        View findViewById4 = view.findViewById(com.avito.android.service_subscription.R.id.toolbar_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar_title)");
        this.f = (TextView) findViewById4;
        View findViewById5 = view.findViewById(com.avito.android.service_subscription.R.id.shop_settings_floating_save_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.s…ngs_floating_save_button)");
        Button button = (Button) findViewById5;
        this.g = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        button.setOnClickListener(new a(0, this));
        ViewGroup viewGroup = this.c;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i2, null, false, 0, 28, null);
        this.h = progressOverlay;
        progressOverlay.setOnRefreshListener(new b(this));
        ((Toolbar) Views.findById(view, com.avito.android.service_subscription.R.id.toolbar)).setNavigationOnClickListener(new a(1, this));
        ShopSettingsViewModel shopSettingsViewModel = this.viewModel;
        if (shopSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new c(this));
        ShopSettingsViewModel shopSettingsViewModel2 = this.viewModel;
        if (shopSettingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsViewModel2.getListChanges().observe(getViewLifecycleOwner(), new a2.a.a.t2.d(this));
        ShopSettingsViewModel shopSettingsViewModel3 = this.viewModel;
        if (shopSettingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsViewModel3.getTitleChanges().observe(getViewLifecycleOwner(), new v(0, this));
        ShopSettingsViewModel shopSettingsViewModel4 = this.viewModel;
        if (shopSettingsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<String> messageChanges = shopSettingsViewModel4.getMessageChanges();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        messageChanges.observe(viewLifecycleOwner, new v(1, this));
        ShopSettingsViewModel shopSettingsViewModel5 = this.viewModel;
        if (shopSettingsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<ShopSettingsConfirmation> confirmationChanges = shopSettingsViewModel5.getConfirmationChanges();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        confirmationChanges.observe(viewLifecycleOwner2, new a2.a.a.t2.g(this));
        ShopSettingsViewModel shopSettingsViewModel6 = this.viewModel;
        if (shopSettingsViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Integer> scrollPositionChanges = shopSettingsViewModel6.getScrollPositionChanges();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        scrollPositionChanges.observe(viewLifecycleOwner3, new h(this));
        ShopSettingsViewModel shopSettingsViewModel7 = this.viewModel;
        if (shopSettingsViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        shopSettingsViewModel7.getSaveButtonDataChanges().observe(getViewLifecycleOwner(), new l(this));
        ShopSettingsViewModel shopSettingsViewModel8 = this.viewModel;
        if (shopSettingsViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Unit> goToLoginChanges = shopSettingsViewModel8.getGoToLoginChanges();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        goToLoginChanges.observe(viewLifecycleOwner4, new m(this));
        CompositeDisposable compositeDisposable = this.i;
        PublishRelay<Unit> publishRelay = this.saveButtonClickListener;
        if (publishRelay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButtonClickListener");
        }
        ShopSettingsViewModel shopSettingsViewModel9 = this.viewModel;
        if (shopSettingsViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Disposable subscribe = publishRelay.subscribe(shopSettingsViewModel9.getSaveButtonClickRelay());
        Intrinsics.checkNotNullExpressionValue(subscribe, "saveButtonClickListener\n…del.saveButtonClickRelay)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.i;
        PublishRelay<ShopSettingsSelectItem> publishRelay2 = this.selectItemClickListener;
        if (publishRelay2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectItemClickListener");
        }
        Disposable subscribe2 = publishRelay2.subscribe(new a2.a.a.t2.a(this), w0.b);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "selectItemClickListener\n…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.i;
        PublishRelay<ShopSettingsAddressItem> publishRelay3 = this.addressItemClickListener;
        if (publishRelay3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressItemClickListener");
        }
        Disposable subscribe3 = publishRelay3.subscribe(new a2.a.a.t2.b(this), w0.c);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "addressItemClickListener…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setAddressItemClickListener(@NotNull PublishRelay<ShopSettingsAddressItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "<set-?>");
        this.addressItemClickListener = publishRelay;
    }

    public final void setRecyclerAdapter(@NotNull RecyclerView.Adapter<BaseViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.recyclerAdapter = adapter;
    }

    public final void setSaveButtonClickListener(@NotNull PublishRelay<Unit> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "<set-?>");
        this.saveButtonClickListener = publishRelay;
    }

    public final void setSelectItemClickListener(@NotNull PublishRelay<ShopSettingsSelectItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "<set-?>");
        this.selectItemClickListener = publishRelay;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Kundle kundle;
        if (bundle == null || (kundle = Bundles.getKundle(bundle, "view_model_state")) == null) {
            kundle = Kundle.Companion.getEMPTY();
        }
        this.j = bundle != null ? bundle.getString("location_picker_state") : null;
        ShopSettingsFragmentComponent.Builder dependencies = DaggerShopSettingsFragmentComponent.builder().dependencies((ShopSettingsFragmentDependencies) ComponentDependenciesKt.getDependencies(ShopSettingsFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependencies.resources(resources).fragment(this).savedState(kundle).build().inject(this);
        return true;
    }

    public final void setViewModel(@NotNull ShopSettingsViewModel shopSettingsViewModel) {
        Intrinsics.checkNotNullParameter(shopSettingsViewModel, "<set-?>");
        this.viewModel = shopSettingsViewModel;
    }
}
