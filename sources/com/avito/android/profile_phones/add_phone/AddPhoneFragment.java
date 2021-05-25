package com.avito.android.profile_phones.add_phone;

import a2.a.a.c2.a.a;
import a2.a.a.c2.a.b;
import a2.a.a.c2.a.c;
import a2.a.a.c2.a.d;
import a2.a.a.c2.a.e;
import a2.a.a.c2.a.f;
import a2.a.a.c2.a.g;
import a2.a.a.c2.a.h;
import a2.a.a.c2.a.i;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies;
import com.avito.android.profile_phones.add_phone.di.AddPhoneModule;
import com.avito.android.profile_phones.add_phone.di.DaggerAddPhoneComponent;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragmentKt;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithIconAction;
import ru.avito.component.toolbar.AppbarClickListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0001_B\u0007¢\u0006\u0004\b^\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X.¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010C\u001a\u00020<8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006`"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/lib/design/input/Input;", "n", "Lcom/avito/android/lib/design/input/Input;", "phoneInput", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", "j", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel;", "o", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel;", "viewModel", "Lcom/avito/android/util/KeyboardSubscription;", VKApiConst.Q, "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "p", "Landroid/view/View;", "anchorView", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "r", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelFactory;", "viewModelFactory", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelFactory;)V", "Lcom/avito/android/lib/design/button/Button;", "l", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "k", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "appBarLayout", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "componentContainer", "<init>", "Companion", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class AddPhoneFragment extends TabBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public Disposable j;
    public AppBarLayoutWithIconAction k;
    public Button l;
    public ComponentContainer m;
    public Input n;
    public AddPhoneViewModel o;
    public View p;
    public KeyboardSubscription q;
    @NotNull
    public NavigationState r = new NavigationState(false);
    @Inject
    public AddPhoneViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneFragment$Companion;", "", "Lcom/avito/android/profile_phones/add_phone/AddPhoneFragment;", "newInstance", "()Lcom/avito/android/profile_phones/add_phone/AddPhoneFragment;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AddPhoneFragment newInstance() {
            return new AddPhoneFragment();
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LandlinePhoneVerificationViewModel.ResultStatus.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public static final /* synthetic */ View access$getAnchorView$p(AddPhoneFragment addPhoneFragment) {
        View view = addPhoneFragment.p;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
        }
        return view;
    }

    public static final /* synthetic */ AppBarLayoutWithIconAction access$getAppBarLayout$p(AddPhoneFragment addPhoneFragment) {
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = addPhoneFragment.k;
        if (appBarLayoutWithIconAction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayoutWithIconAction;
    }

    public static final /* synthetic */ Button access$getButton$p(AddPhoneFragment addPhoneFragment) {
        Button button = addPhoneFragment.l;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        return button;
    }

    public static final /* synthetic */ ComponentContainer access$getComponentContainer$p(AddPhoneFragment addPhoneFragment) {
        ComponentContainer componentContainer = addPhoneFragment.m;
        if (componentContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentContainer");
        }
        return componentContainer;
    }

    public static final /* synthetic */ Input access$getPhoneInput$p(AddPhoneFragment addPhoneFragment) {
        Input input = addPhoneFragment.n;
        if (input == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneInput");
        }
        return input;
    }

    public static final /* synthetic */ AddPhoneViewModel access$getViewModel$p(AddPhoneFragment addPhoneFragment) {
        AddPhoneViewModel addPhoneViewModel = addPhoneFragment.o;
        if (addPhoneViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return addPhoneViewModel;
    }

    public static final void access$openDeepLinkIntent(AddPhoneFragment addPhoneFragment, DeepLink deepLink) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = addPhoneFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            addPhoneFragment.startForResult(intent, 20);
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
        return this.r;
    }

    @NotNull
    public final AddPhoneViewModelFactory getViewModelFactory() {
        AddPhoneViewModelFactory addPhoneViewModelFactory = this.viewModelFactory;
        if (addPhoneViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return addPhoneViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str;
        String str2;
        int ordinal;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 10 || i == 20) {
                if (intent == null || (str = intent.getStringExtra(AddPhoneFragmentKt.EXTRA_PHONE)) == null) {
                    str = "";
                }
                LandlinePhoneVerificationViewModel.ResultStatus resultStatus = null;
                Serializable serializableExtra = intent != null ? intent.getSerializableExtra(LandlinePhoneVerificationFragmentKt.EXTRA_RESULT_STATUS) : null;
                if (serializableExtra instanceof LandlinePhoneVerificationViewModel.ResultStatus) {
                    resultStatus = serializableExtra;
                }
                LandlinePhoneVerificationViewModel.ResultStatus resultStatus2 = resultStatus;
                if (resultStatus2 == null || (ordinal = resultStatus2.ordinal()) == 0) {
                    str2 = getString(R.string.phone_added_success, str);
                } else if (ordinal == 1) {
                    str2 = getString(R.string.phone_added_cancel, str);
                } else if (ordinal == 2) {
                    str2 = getString(R.string.f5onfirm_phone_manual, str);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Intrinsics.checkNotNullExpressionValue(str2, "when (status) {\n        … phone)\n                }");
                Intent intent2 = new Intent();
                intent2.putExtra("result_message", str2);
                Unit unit = Unit.INSTANCE;
                setResult(-1, intent2);
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.add_phone, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyboardSubscription keyboardSubscription = this.q;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        Input input = this.n;
        if (input == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneInput");
        }
        input.clearInputFocus();
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AddPhoneViewModelFactory addPhoneViewModelFactory = this.viewModelFactory;
        if (addPhoneViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, addPhoneViewModelFactory).get(AddPhoneViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …iewModelImpl::class.java)");
        this.o = (AddPhoneViewModel) viewModel;
        View findViewById = view.findViewById(R.id.add_phone_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.l = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.anchor_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.p = findViewById2;
        View findViewById3 = view.findViewById(R.id.phone_input_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.m = (ComponentContainer) findViewById3;
        View findViewById4 = view.findViewById(R.id.phone_input);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById4;
        this.n = input;
        KeyboardSubscription keyboardSubscription = null;
        Input.setFormatterType$default(input, FormatterType.Companion.getMOBILE_PHONE(), false, 2, null);
        Input input2 = this.n;
        if (input2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneInput");
        }
        input2.showKeyboard();
        Button button = this.l;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        Observable<Unit> clicks = RxView.clicks(button);
        Input input3 = this.n;
        if (input3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneInput");
        }
        this.j = Observable.merge(clicks, InputExtensionsKt.actionsCallbacks(input3, 6).map(c.a)).map(new d(this)).filter(e.a).subscribe(new f(this), g.a);
        View findViewById5 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type ru.avito.component.toolbar.AppBarLayoutWithIconAction");
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = (AppBarLayoutWithIconAction) findViewById5;
        this.k = appBarLayoutWithIconAction;
        appBarLayoutWithIconAction.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction2 = this.k;
        if (appBarLayoutWithIconAction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction2.setClickListener(new AppbarClickListener() { // from class: com.avito.android.profile_phones.add_phone.AddPhoneFragment$initView$6
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                AddPhoneFragment.access$getViewModel$p(AddPhoneFragment.this).onCloseClicked();
            }
        });
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getConfiguration().orientation;
        if (i == 1) {
            AppBarLayoutWithIconAction appBarLayoutWithIconAction3 = this.k;
            if (appBarLayoutWithIconAction3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayoutWithIconAction3.postDelayed(new i(this), 200);
        } else if (i == 2) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                keyboardSubscription = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) activity, false, (Function1) new h(this), 1, (Object) null);
            }
            this.q = keyboardSubscription;
        }
        AddPhoneViewModel addPhoneViewModel = this.o;
        if (addPhoneViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        addPhoneViewModel.navigation().observe(getViewLifecycleOwner(), new a(this));
        AddPhoneViewModel addPhoneViewModel2 = this.o;
        if (addPhoneViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        addPhoneViewModel2.screenState().observe(getViewLifecycleOwner(), new b(this));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
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
        this.r = navigationState;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DaggerAddPhoneComponent.builder().addPhoneModule(new AddPhoneModule(resources)).addPhoneDependencies((AddPhoneDependencies) ComponentDependenciesKt.getDependencies(AddPhoneDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull AddPhoneViewModelFactory addPhoneViewModelFactory) {
        Intrinsics.checkNotNullParameter(addPhoneViewModelFactory, "<set-?>");
        this.viewModelFactory = addPhoneViewModelFactory;
    }
}
