package com.avito.android.profile_phones.phone_action;

import a2.a.a.c2.d.b;
import a2.a.a.c2.d.c;
import a2.a.a.c2.d.e;
import a2.a.a.c2.d.f;
import a2.a.a.c2.d.g;
import a2.b.a.a.a;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.phone_action.di.DaggerPhoneActionComponent;
import com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies;
import com.avito.android.profile_phones.phone_action.di.PhoneActionModule;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModelFactory;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModelImpl;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectListener;
import com.avito.android.select.bottom_sheet.SelectBottomSheetFragmentKt;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import java.util.ArrayList;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0007¢\u0006\u0004\bJ\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00180\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001d8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/PhoneActionFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/select/SelectListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "requestId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedItems", "sectionTitle", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "p", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;", "viewModelFactory", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;)V", "k", "Landroid/view/View;", "anchorView", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "componentContainer", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "j", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "appBarLayout", "Lcom/avito/android/lib/design/input/Input;", "n", "Lcom/avito/android/lib/design/input/Input;", "phoneInput", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel;", "o", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel;", "viewModel", "Lcom/avito/android/lib/design/button/Button;", "l", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Companion", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionFragment extends TabBaseFragment implements SelectListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    public AppBarLayoutWithIconAction j;
    public View k;
    public Button l;
    public ComponentContainer m;
    public Input n;
    public PhoneActionViewModel o;
    @NotNull
    public NavigationState p = new NavigationState(false);
    @Inject
    public PhoneActionViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/PhoneActionFragment$Companion;", "", "", "phone", "", "advertsNumber", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "actionCode", "", "Lcom/avito/android/profile_phones/phone_action/PhoneParcelableEntity;", "phonesForReplacement", "Lcom/avito/android/profile_phones/phone_action/PhoneActionFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;Ljava/util/List;)Lcom/avito/android/profile_phones/phone_action/PhoneActionFragment;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PhoneActionFragment newInstance(@NotNull String str, @Nullable Integer num, @NotNull PhoneActionCode phoneActionCode, @Nullable List<PhoneParcelableEntity> list) {
            Intrinsics.checkNotNullParameter(str, "phone");
            Intrinsics.checkNotNullParameter(phoneActionCode, "actionCode");
            PhoneActionFragment phoneActionFragment = new PhoneActionFragment();
            Bundle y1 = a.y1("phone", str);
            if (num != null) {
                y1.putInt("adverts_number", num.intValue());
            }
            y1.putParcelable("phone_action", phoneActionCode);
            Bundles.putParcelableList(y1, "phones_for_replacement", list);
            phoneActionFragment.setArguments(y1);
            return phoneActionFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final /* synthetic */ View access$getAnchorView$p(PhoneActionFragment phoneActionFragment) {
        View view = phoneActionFragment.k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
        }
        return view;
    }

    public static final /* synthetic */ AppBarLayoutWithIconAction access$getAppBarLayout$p(PhoneActionFragment phoneActionFragment) {
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = phoneActionFragment.j;
        if (appBarLayoutWithIconAction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayoutWithIconAction;
    }

    public static final /* synthetic */ Button access$getButton$p(PhoneActionFragment phoneActionFragment) {
        Button button = phoneActionFragment.l;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        return button;
    }

    public static final /* synthetic */ ComponentContainer access$getComponentContainer$p(PhoneActionFragment phoneActionFragment) {
        ComponentContainer componentContainer = phoneActionFragment.m;
        if (componentContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentContainer");
        }
        return componentContainer;
    }

    public static final /* synthetic */ Input access$getPhoneInput$p(PhoneActionFragment phoneActionFragment) {
        Input input = phoneActionFragment.n;
        if (input == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneInput");
        }
        return input;
    }

    public static final /* synthetic */ PhoneActionViewModel access$getViewModel$p(PhoneActionFragment phoneActionFragment) {
        PhoneActionViewModel phoneActionViewModel = phoneActionFragment.o;
        if (phoneActionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return phoneActionViewModel;
    }

    public static final void access$showBottomSheetSelect(PhoneActionFragment phoneActionFragment, Arguments arguments) {
        Objects.requireNonNull(phoneActionFragment);
        SelectBottomSheetFragmentKt.createSelectSheetDialogFragment(phoneActionFragment, arguments).show(phoneActionFragment.getParentFragmentManager(), "select_fragment");
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.p;
    }

    @NotNull
    public final PhoneActionViewModelFactory getViewModelFactory() {
        PhoneActionViewModelFactory phoneActionViewModelFactory = this.viewModelFactory;
        if (phoneActionViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return phoneActionViewModelFactory;
    }

    @Override // com.avito.android.select.SelectListener
    public void onCancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        SelectListener.DefaultImpls.onCancel(this, str);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.phone_action_details, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Input input = this.n;
        if (input == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneInput");
        }
        input.clearInputFocus();
        super.onDestroyView();
    }

    @Override // com.avito.android.select.SelectListener
    public void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedItems");
        PhoneActionViewModel phoneActionViewModel = this.o;
        if (phoneActionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneActionViewModel.onSelected(list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        PhoneActionViewModelFactory phoneActionViewModelFactory = this.viewModelFactory;
        if (phoneActionViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, phoneActionViewModelFactory).get(PhoneActionViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …iewModelImpl::class.java)");
        this.o = (PhoneActionViewModel) viewModel;
        View findViewById = view.findViewById(R.id.action_confirm_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.l = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.anchor_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById2;
        View findViewById3 = view.findViewById(R.id.phone_input_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.m = (ComponentContainer) findViewById3;
        View findViewById4 = view.findViewById(R.id.phone_input);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById4;
        this.n = input;
        Input.setFormatterType$default(input, FormatterType.Companion.getMOBILE_PHONE(), false, 2, null);
        Button button = this.l;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        button.setOnClickListener(new g(this));
        View findViewById5 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type ru.avito.component.toolbar.AppBarLayoutWithIconAction");
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = (AppBarLayoutWithIconAction) findViewById5;
        this.j = appBarLayoutWithIconAction;
        appBarLayoutWithIconAction.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction2 = this.j;
        if (appBarLayoutWithIconAction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction2.setClickListener(new AppbarClickListener() { // from class: com.avito.android.profile_phones.phone_action.PhoneActionFragment$initView$2
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                PhoneActionFragment.access$getViewModel$p(PhoneActionFragment.this).onCloseButtonClick();
            }
        });
        PhoneActionViewModel phoneActionViewModel = this.o;
        if (phoneActionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneActionViewModel.navigation().observe(getViewLifecycleOwner(), new a2.a.a.c2.d.a(this));
        PhoneActionViewModel phoneActionViewModel2 = this.o;
        if (phoneActionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneActionViewModel2.screenState().observe(getViewLifecycleOwner(), new b(this));
        PhoneActionViewModel phoneActionViewModel3 = this.o;
        if (phoneActionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneActionViewModel3.errors().observe(getViewLifecycleOwner(), new c(this));
        PhoneActionViewModel phoneActionViewModel4 = this.o;
        if (phoneActionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneActionViewModel4.phoneInputState().observe(getViewLifecycleOwner(), new e(this));
        PhoneActionViewModel phoneActionViewModel5 = this.o;
        if (phoneActionViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneActionViewModel5.phonesListState().observe(getViewLifecycleOwner(), new f(this));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.p = navigationState;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Parcelable parcelable = requireArguments.getParcelable("phone_action");
        Intrinsics.checkNotNull(parcelable);
        String string = requireArguments.getString("phone");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "args.getString(KEY_PHONE)!!");
        int i = requireArguments.getInt("adverts_number", 0);
        ArrayList parcelableArrayList = requireArguments.getParcelableArrayList("phones_for_replacement");
        Intrinsics.checkNotNull(parcelableArrayList);
        Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "args.getParcelableArrayL…PHONES_FOR_REPLACEMENT)!!");
        DaggerPhoneActionComponent.builder().phoneActionModule(new PhoneActionModule(resources, (PhoneActionCode) parcelable, string, i, parcelableArrayList)).dependencies((PhoneActionDependencies) ComponentDependenciesKt.getDependencies(PhoneActionDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull PhoneActionViewModelFactory phoneActionViewModelFactory) {
        Intrinsics.checkNotNullParameter(phoneActionViewModelFactory, "<set-?>");
        this.viewModelFactory = phoneActionViewModelFactory;
    }
}
