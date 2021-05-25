package com.avito.android.profile_phones.landline_verification;

import a2.a.a.c2.c.a;
import a2.a.a.c2.c.b;
import a2.a.a.c2.c.c;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewAnimator;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationViewModel;
import com.avito.android.profile_phones.landline_verification.di.DaggerLandlinePhoneVerificationComponent;
import com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies;
import com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.text.AttributedTextFormatter;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.CollapsingTitleAppBarLayout;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\bX\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u0010)R\u0016\u00106\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u0010)R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010\u0018R\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010U\u001a\u00020N8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\bV\u0010\u0018¨\u0006Z"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "Lcom/avito/android/lib/design/button/Button;", "n", "Lcom/avito/android/lib/design/button/Button;", "callOrderButton", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "j", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "appBarLayout", "o", "cancelButton", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "description", "Landroid/widget/ViewAnimator;", "r", "Landroid/widget/ViewAnimator;", "actionContainer", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel;", "s", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel;", "viewModel", "k", MessengerShareContentUtility.SUBTITLE, AuthSource.OPEN_CHANNEL_LIST, "callOrderError", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;", "viewModelFactory", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;", "getViewModelFactory", "()Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;", "setViewModelFactory", "(Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;)V", "p", "acceptButton", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "t", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", VKApiConst.Q, "okButton", "<init>", "Companion", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationFragment extends TabBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public CollapsingTitleAppBarLayout j;
    public TextView k;
    public TextView l;
    public TextView m;
    public Button n;
    public Button o;
    public Button p;
    public Button q;
    public ViewAnimator r;
    public LandlinePhoneVerificationViewModel s;
    @NotNull
    public NavigationState t = new NavigationState(false);
    @Inject
    public LandlinePhoneVerificationVMFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationFragment$Companion;", "", "", "callId", "", "title", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "description", "phone", "", "isManual", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationFragment;", "newInstance", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationFragment;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LandlinePhoneVerificationFragment newInstance(int i, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(attributedText, "description");
            Intrinsics.checkNotNullParameter(str3, "phone");
            LandlinePhoneVerificationFragment landlinePhoneVerificationFragment = new LandlinePhoneVerificationFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg_call_id", i);
            bundle.putString("arg_title", str);
            bundle.putString("arg_subtitle", str2);
            bundle.putParcelable("arg_description", attributedText);
            bundle.putString("arg_phone", str3);
            bundle.putBoolean("arg_is_manual", z);
            Unit unit = Unit.INSTANCE;
            landlinePhoneVerificationFragment.setArguments(bundle);
            return landlinePhoneVerificationFragment;
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

    public static final /* synthetic */ ViewAnimator access$getActionContainer$p(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        ViewAnimator viewAnimator = landlinePhoneVerificationFragment.r;
        if (viewAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionContainer");
        }
        return viewAnimator;
    }

    public static final /* synthetic */ CollapsingTitleAppBarLayout access$getAppBarLayout$p(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = landlinePhoneVerificationFragment.j;
        if (collapsingTitleAppBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return collapsingTitleAppBarLayout;
    }

    public static final /* synthetic */ TextView access$getCallOrderError$p(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        TextView textView = landlinePhoneVerificationFragment.m;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callOrderError");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getDescription$p(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        TextView textView = landlinePhoneVerificationFragment.l;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getSubtitle$p(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        TextView textView = landlinePhoneVerificationFragment.k;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MessengerShareContentUtility.SUBTITLE);
        }
        return textView;
    }

    public static final /* synthetic */ LandlinePhoneVerificationViewModel access$getViewModel$p(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel = landlinePhoneVerificationFragment.s;
        if (landlinePhoneVerificationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return landlinePhoneVerificationViewModel;
    }

    public static final void access$setLoadingState(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment, boolean z) {
        Button button = landlinePhoneVerificationFragment.n;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callOrderButton");
        }
        boolean z2 = !z;
        button.setEnabled(z2);
        Button button2 = landlinePhoneVerificationFragment.n;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callOrderButton");
        }
        button2.setLoading(z);
        Button button3 = landlinePhoneVerificationFragment.p;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("acceptButton");
        }
        button3.setEnabled(z2);
        Button button4 = landlinePhoneVerificationFragment.p;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("acceptButton");
        }
        button4.setLoading(z);
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
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.t;
    }

    @NotNull
    public final LandlinePhoneVerificationVMFactory getViewModelFactory() {
        LandlinePhoneVerificationVMFactory landlinePhoneVerificationVMFactory = this.viewModelFactory;
        if (landlinePhoneVerificationVMFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return landlinePhoneVerificationVMFactory;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.landline_phone_verification, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel = this.s;
        if (landlinePhoneVerificationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        landlinePhoneVerificationViewModel.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel = this.s;
        if (landlinePhoneVerificationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        landlinePhoneVerificationViewModel.onStop();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LandlinePhoneVerificationVMFactory landlinePhoneVerificationVMFactory = this.viewModelFactory;
        if (landlinePhoneVerificationVMFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, landlinePhoneVerificationVMFactory).get(LandlinePhoneVerificationViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ionViewModel::class.java)");
        this.s = (LandlinePhoneVerificationViewModel) viewModel;
        View findViewById = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.bot_error);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.m = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.state_call_ordered);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.action_and_state_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ViewAnimator");
        this.r = (ViewAnimator) findViewById4;
        View findViewById5 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById5;
        this.l = textView2;
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        View findViewById6 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type ru.avito.component.toolbar.CollapsingTitleAppBarLayout");
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = (CollapsingTitleAppBarLayout) findViewById6;
        this.j = collapsingTitleAppBarLayout;
        collapsingTitleAppBarLayout.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout2 = this.j;
        if (collapsingTitleAppBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        collapsingTitleAppBarLayout2.setClickListener(new AppbarClickListener() { // from class: com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment$initView$1
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                LandlinePhoneVerificationFragment.access$getViewModel$p(LandlinePhoneVerificationFragment.this).onBackClicked();
            }
        });
        View findViewById7 = view.findViewById(R.id.cancel_button);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById7;
        this.o = button;
        button.setOnClickListener(new o2(0, this));
        View findViewById8 = view.findViewById(R.id.accept_button);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button2 = (Button) findViewById8;
        this.p = button2;
        button2.setOnClickListener(new o2(1, this));
        View findViewById9 = view.findViewById(R.id.ok_button);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button3 = (Button) findViewById9;
        this.q = button3;
        button3.setOnClickListener(new o2(2, this));
        View findViewById10 = view.findViewById(R.id.state_call_order);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button4 = (Button) findViewById10;
        this.n = button4;
        button4.setOnClickListener(new o2(3, this));
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel = this.s;
        if (landlinePhoneVerificationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        landlinePhoneVerificationViewModel.navigation().observe(getViewLifecycleOwner(), new a(this));
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel2 = this.s;
        if (landlinePhoneVerificationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        landlinePhoneVerificationViewModel2.screenState().observe(getViewLifecycleOwner(), new b(this));
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel3 = this.s;
        if (landlinePhoneVerificationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        landlinePhoneVerificationViewModel3.events().observe(getViewLifecycleOwner(), new c(this));
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel4 = this.s;
        if (landlinePhoneVerificationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        int i = requireArguments.getInt("arg_call_id");
        String string = requireArguments.getString("arg_title", "");
        Intrinsics.checkNotNullExpressionValue(string, "args.getString(ARG_TITLE, \"\")");
        String string2 = requireArguments.getString("arg_subtitle", "");
        Intrinsics.checkNotNullExpressionValue(string2, "args.getString(ARG_SUBTITLE, \"\")");
        AttributedText attributedText = (AttributedText) requireArguments.getParcelable("arg_description");
        if (attributedText == null) {
            attributedText = new AttributedText("", CollectionsKt__CollectionsKt.emptyList());
        }
        String string3 = requireArguments.getString("arg_phone", "");
        Intrinsics.checkNotNullExpressionValue(string3, "args.getString(ARG_PHONE, \"\")");
        landlinePhoneVerificationViewModel4.initData(i, string, string2, attributedText, string3, requireArguments.getBoolean("arg_is_manual", false));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.t = navigationState;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        DaggerLandlinePhoneVerificationComponent.builder().landlinePhoneVerificationModule(new LandlinePhoneVerificationModule()).landlinePhoneVerificationDependencies((LandlinePhoneVerificationDependencies) ComponentDependenciesKt.getDependencies(LandlinePhoneVerificationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull LandlinePhoneVerificationVMFactory landlinePhoneVerificationVMFactory) {
        Intrinsics.checkNotNullParameter(landlinePhoneVerificationVMFactory, "<set-?>");
        this.viewModelFactory = landlinePhoneVerificationVMFactory;
    }
}
