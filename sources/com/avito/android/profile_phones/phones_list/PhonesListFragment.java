package com.avito.android.profile_phones.phones_list;

import a2.a.a.c2.f.a;
import a2.a.a.c2.f.b;
import a2.a.a.c2.f.c;
import a2.a.a.c2.f.d;
import a2.a.a.c2.f.e;
import a2.a.a.c2.f.f;
import a2.a.a.c2.f.h;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.phones_list.PhonesListViewModel;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionResultHandler;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogArguments;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragmentKt;
import com.avito.android.profile_phones.phones_list.di.DaggerPhonesListComponent;
import com.avito.android.profile_phones.phones_list.di.PhonesListDependencies;
import com.avito.android.profile_phones.phones_list.di.PhonesListModule;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithIconAction;
import ru.avito.component.toolbar.AppbarClickListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001vB\u0007¢\u0006\u0004\bu\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!R\"\u0010)\u001a\u00020\"8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010FR&\u0010I\u001a\u0006\u0012\u0002\b\u00030H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010T\u001a\u00020S8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR,\u0010h\u001a\f\u0012\u0004\u0012\u00020f0ej\u0002`g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006w"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionResultHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "phone", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "action", "handlePhoneAction", "(Ljava/lang/String;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "p", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "n", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "appBarLayout", "Lcom/avito/android/lib/design/dialog/Dialog;", "o", "Lcom/avito/android/lib/design/dialog/Dialog;", "dialog", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/lifecycle/ViewModelProvider$Factory;", "phonesListViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getPhonesListViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setPhonesListViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", "l", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel;", "k", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel;", "phonesListViewModel", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "j", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemClickObservable;", "phoneListItemClickObservable", "Lio/reactivex/rxjava3/core/Observable;", "getPhoneListItemClickObservable", "()Lio/reactivex/rxjava3/core/Observable;", "setPhoneListItemClickObservable", "(Lio/reactivex/rxjava3/core/Observable;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Companion", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesListFragment extends TabBaseFragment implements PhoneActionResultHandler {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public RecyclerView.Adapter<?> adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public ProgressOverlay j;
    public PhonesListViewModel k;
    public Disposable l;
    public RecyclerView m;
    public AppBarLayoutWithIconAction n;
    public Dialog o;
    @NotNull
    public NavigationState p = new NavigationState(false);
    @Inject
    public Observable<PhoneListItem> phoneListItemClickObservable;
    @Inject
    public ViewModelProvider.Factory phonesListViewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListFragment$Companion;", "", "Lcom/avito/android/profile_phones/phones_list/PhonesListFragment;", "newInstance", "()Lcom/avito/android/profile_phones/phones_list/PhonesListFragment;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PhonesListFragment newInstance() {
            return new PhonesListFragment();
        }

        public Companion(j jVar) {
        }
    }

    public static final /* synthetic */ AppBarLayoutWithIconAction access$getAppBarLayout$p(PhonesListFragment phonesListFragment) {
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = phonesListFragment.n;
        if (appBarLayoutWithIconAction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayoutWithIconAction;
    }

    public static final /* synthetic */ PhonesListViewModel access$getPhonesListViewModel$p(PhonesListFragment phonesListFragment) {
        PhonesListViewModel phonesListViewModel = phonesListFragment.k;
        if (phonesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
        }
        return phonesListViewModel;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(PhonesListFragment phonesListFragment) {
        ProgressOverlay progressOverlay = phonesListFragment.j;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecycler$p(PhonesListFragment phonesListFragment) {
        RecyclerView recyclerView = phonesListFragment.m;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        return recyclerView;
    }

    public static final void access$handleError(PhonesListFragment phonesListFragment, PhonesListViewModel.ErrorType errorType) {
        Objects.requireNonNull(phonesListFragment);
        if (errorType instanceof PhonesListViewModel.ErrorType.ListLoadingError) {
            ProgressOverlay progressOverlay = phonesListFragment.j;
            if (progressOverlay == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            String string = phonesListFragment.getString(R.string.phones_loading_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.phones_loading_error)");
            progressOverlay.showLoadingProblem(string);
        }
    }

    public static final void access$openActionsSheet(PhonesListFragment phonesListFragment, String str, List list) {
        Fragment findFragmentByTag = phonesListFragment.getParentFragmentManager().findFragmentByTag("actions_fragment_tag");
        if (findFragmentByTag == null || !findFragmentByTag.isAdded()) {
            PhoneActionsSheetDialogFragment createPhoneActionsSheetDialogFragment = PhoneActionsSheetDialogFragmentKt.createPhoneActionsSheetDialogFragment(new PhoneActionsSheetDialogArguments(list, str));
            createPhoneActionsSheetDialogFragment.setTargetFragment(phonesListFragment, 10);
            createPhoneActionsSheetDialogFragment.show(phonesListFragment.getParentFragmentManager(), "actions_fragment_tag");
        }
    }

    public static final void access$openAddPhoneScreen(PhonesListFragment phonesListFragment) {
        ActivityIntentFactory activityIntentFactory2 = phonesListFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        phonesListFragment.startForResult(activityIntentFactory2.addPhoneIntent(), 20);
    }

    public static final void access$openDeepLinkIntent(PhonesListFragment phonesListFragment, DeepLink deepLink) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = phonesListFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            phonesListFragment.startForResult(intent, 30);
        }
    }

    public static final void access$showVerificationStatusStub(PhonesListFragment phonesListFragment, String str) {
        Dialog dialog = phonesListFragment.o;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog.Companion companion = Dialog.Companion;
        Context requireContext = phonesListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Dialog create$default = Dialog.Companion.create$default(companion, requireContext, 0, 0, new h(phonesListFragment, str), 6, null);
        phonesListFragment.o = create$default;
        if (create$default != null) {
            create$default.show();
        }
    }

    public static final void access$showVerificationStub(PhonesListFragment phonesListFragment) {
        Dialog dialog = phonesListFragment.o;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog.Companion companion = Dialog.Companion;
        Context requireContext = phonesListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Dialog create$default = Dialog.Companion.create$default(companion, requireContext, 0, 0, new a2.a.a.c2.f.j(phonesListFragment), 6, null);
        phonesListFragment.o = create$default;
        if (create$default != null) {
            create$default.show();
        }
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.p;
    }

    @NotNull
    public final Observable<PhoneListItem> getPhoneListItemClickObservable() {
        Observable<PhoneListItem> observable = this.phoneListItemClickObservable;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneListItemClickObservable");
        }
        return observable;
    }

    @NotNull
    public final ViewModelProvider.Factory getPhonesListViewModelFactory() {
        ViewModelProvider.Factory factory = this.phonesListViewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModelFactory");
        }
        return factory;
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.PhoneActionResultHandler
    public void handlePhoneAction(@NotNull String str, @NotNull PhoneListItem.Action action) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(action, "action");
        PhonesListViewModel phonesListViewModel = this.k;
        if (phonesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
        }
        phonesListViewModel.handlePhoneAction(str, action);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String str = null;
            if (i == 20) {
                PhonesListViewModel phonesListViewModel = this.k;
                if (phonesListViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
                }
                if (intent != null) {
                    str = intent.getStringExtra("result_message");
                }
                phonesListViewModel.onPhoneActionSuccess(str);
            } else if (i == 30) {
                PhonesListViewModel phonesListViewModel2 = this.k;
                if (phonesListViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
                }
                if (intent != null) {
                    str = intent.getStringExtra("result_message");
                }
                phonesListViewModel2.onPhoneActionSuccess(str);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.phones_list_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog;
        Dialog dialog2 = this.o;
        if (!(dialog2 == null || !dialog2.isShowing() || (dialog = this.o) == null)) {
            dialog.dismiss();
        }
        this.o = null;
        Disposable disposable = this.l;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewModelProvider.Factory factory = this.phonesListViewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, factory).get(PhonesListViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …iewModelImpl::class.java)");
        this.k = (PhonesListViewModel) viewModel;
        View findViewById = view.findViewById(R.id.phones_list_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.phones_list_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.m = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RecyclerView recyclerView2 = this.m;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(adapter2);
        View findViewById2 = view.findViewById(R.id.progress_overlay_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, 0, null, false, 0, 30, null);
        this.j = progressOverlay;
        progressOverlay.setOnRefreshListener(new f(this));
        View findViewById3 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type ru.avito.component.toolbar.AppBarLayoutWithIconAction");
        this.n = (AppBarLayoutWithIconAction) findViewById3;
        String string = getString(R.string.phones_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.phones_title)");
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = this.n;
        if (appBarLayoutWithIconAction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction.setTitle(string);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction2 = this.n;
        if (appBarLayoutWithIconAction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction2.setShortTitle(string);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction3 = this.n;
        if (appBarLayoutWithIconAction3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction3.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction4 = this.n;
        if (appBarLayoutWithIconAction4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        AppBarLayoutWithIconAction.setActionIcon$default(appBarLayoutWithIconAction4, Integer.valueOf(R.drawable.icon_add_24), null, 2, null);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction5 = this.n;
        if (appBarLayoutWithIconAction5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction5.setClickListener(new AppbarClickListener() { // from class: com.avito.android.profile_phones.phones_list.PhonesListFragment$initView$2
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
                PhonesListFragment.access$getPhonesListViewModel$p(PhonesListFragment.this).onAppBarActionClick();
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                PhonesListFragment.this.finish();
            }
        });
        PhonesListViewModel phonesListViewModel = this.k;
        if (phonesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
        }
        phonesListViewModel.phoneItemsState().observe(getViewLifecycleOwner(), new a(this));
        PhonesListViewModel phonesListViewModel2 = this.k;
        if (phonesListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
        }
        SingleLiveEvent<PhonesListViewModel.RoutingAction> routingActions = phonesListViewModel2.routingActions();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        routingActions.observe(viewLifecycleOwner, new b(this));
        PhonesListViewModel phonesListViewModel3 = this.k;
        if (phonesListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phonesListViewModel");
        }
        SingleLiveEvent<String> snackbars = phonesListViewModel3.snackbars();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        snackbars.observe(viewLifecycleOwner2, new c(this));
        Observable<PhoneListItem> observable = this.phoneListItemClickObservable;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneListItemClickObservable");
        }
        this.l = observable.subscribe(new d(this), e.a);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
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

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.p = navigationState;
    }

    public final void setPhoneListItemClickObservable(@NotNull Observable<PhoneListItem> observable) {
        Intrinsics.checkNotNullParameter(observable, "<set-?>");
        this.phoneListItemClickObservable = observable;
    }

    public final void setPhonesListViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.phonesListViewModelFactory = factory;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DaggerPhonesListComponent.builder().phonesListModule(new PhonesListModule(resources)).phonesListDependencies((PhonesListDependencies) ComponentDependenciesKt.getDependencies(PhonesListDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return true;
    }
}
