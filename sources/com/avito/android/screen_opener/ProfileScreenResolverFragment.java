package com.avito.android.screen_opener;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.PublicProfileIntentFactory;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.public_profile.R;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.screen_opener.ProfileScreenResolverPresenter;
import com.avito.android.screen_opener.di.DaggerProfileScreenResolverFragmentComponent;
import com.avito.android.screen_opener.di.ProfileScreenResolverFragmentComponent;
import com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.FragmentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0007¢\u0006\u0004\bE\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J1\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010!\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010\u0014R\"\u0010+\u001a\u00020$8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onStart", "onStop", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "", "userKey", "contextId", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "openPublicProfileScreen", "(Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "openExtendedProfileScreen", "(Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "closeScreen", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "k", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/analytics/screens/Timer;", "j", "Lcom/avito/android/analytics/screens/Timer;", "timer", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "presenter", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "getPresenter", "()Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "setPresenter", "(Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;)V", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "performanceTracker", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "getPerformanceTracker", "()Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "setPerformanceTracker", "(Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Companion", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileScreenResolverFragment extends TabBaseFragment implements ProfileScreenResolverPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    public Timer j;
    @NotNull
    public NavigationState k = new NavigationState(false);
    @Inject
    public UnknownScreenTracker performanceTracker;
    @Inject
    public ProfileScreenResolverPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverFragment$Companion;", "", "Lcom/avito/android/screen_opener/ProfileScreenResolverArguments;", "arguments", "Lcom/avito/android/screen_opener/ProfileScreenResolverFragment;", "newInstance", "(Lcom/avito/android/screen_opener/ProfileScreenResolverArguments;)Lcom/avito/android/screen_opener/ProfileScreenResolverFragment;", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ ProfileScreenResolverArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ProfileScreenResolverArguments profileScreenResolverArguments) {
                super(1);
                this.a = profileScreenResolverArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final ProfileScreenResolverFragment newInstance(@NotNull ProfileScreenResolverArguments profileScreenResolverArguments) {
            Intrinsics.checkNotNullParameter(profileScreenResolverArguments, "arguments");
            return (ProfileScreenResolverFragment) FragmentsKt.arguments$default(new ProfileScreenResolverFragment(), 0, new a(profileScreenResolverArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter.Router
    public void closeScreen() {
        if (!(getActivity() instanceof ProfileScreenResolverActivity)) {
            finish();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
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

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.k;
    }

    @NotNull
    public final UnknownScreenTracker getPerformanceTracker() {
        UnknownScreenTracker unknownScreenTracker = this.performanceTracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        return unknownScreenTracker;
    }

    @NotNull
    public final ProfileScreenResolverPresenter getPresenter() {
        ProfileScreenResolverPresenter profileScreenResolverPresenter = this.presenter;
        if (profileScreenResolverPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return profileScreenResolverPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Timer timer = this.j;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
        }
        timer.restart();
        return layoutInflater.inflate(R.layout.profile_screen_resolver_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProfileScreenResolverPresenter profileScreenResolverPresenter = this.presenter;
        if (profileScreenResolverPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileScreenResolverPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ProfileScreenResolverPresenter profileScreenResolverPresenter = this.presenter;
        if (profileScreenResolverPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileScreenResolverPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ProfileScreenResolverPresenter profileScreenResolverPresenter = this.presenter;
        if (profileScreenResolverPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileScreenResolverPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ProfileScreenResolverPresenter profileScreenResolverPresenter = this.presenter;
        if (profileScreenResolverPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        profileScreenResolverPresenter.attachView(new ProfileScreenResolverViewImpl(view));
        UnknownScreenTracker unknownScreenTracker = this.performanceTracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        Timer timer = this.j;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
        }
        unknownScreenTracker.trackInit(timer.elapsed());
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter.Router
    public void openExtendedProfileScreen(@NotNull ExtendedPublicUserProfile extendedPublicUserProfile, @NotNull String str, @Nullable String str2, @NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(extendedPublicUserProfile, "profile");
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(screenTransfer, "screenTransfer");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(PublicProfileIntentFactory.DefaultImpls.createExtendedProfileIntent$default(activityIntentFactory2, str, extendedPublicUserProfile, str2, null, screenTransfer, 8, null));
        closeScreen();
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverPresenter.Router
    public void openPublicProfileScreen(@NotNull DefaultPublicUserProfile defaultPublicUserProfile, @NotNull String str, @Nullable String str2, @NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(defaultPublicUserProfile, "profile");
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(screenTransfer, "screenTransfer");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(PublicProfileIntentFactory.DefaultImpls.createPublicProfileIntent$default(activityIntentFactory2, str, defaultPublicUserProfile, str2, null, screenTransfer, 8, null));
        closeScreen();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.k = navigationState;
    }

    public final void setPerformanceTracker(@NotNull UnknownScreenTracker unknownScreenTracker) {
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "<set-?>");
        this.performanceTracker = unknownScreenTracker;
    }

    public final void setPresenter(@NotNull ProfileScreenResolverPresenter profileScreenResolverPresenter) {
        Intrinsics.checkNotNullParameter(profileScreenResolverPresenter, "<set-?>");
        this.presenter = profileScreenResolverPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        ProfileScreenResolverArguments profileScreenResolverArguments;
        Bundle arguments = getArguments();
        if (arguments == null || (profileScreenResolverArguments = (ProfileScreenResolverArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalStateException("Argument must be specified");
        }
        String userKey = profileScreenResolverArguments.getUserKey();
        String contextId = profileScreenResolverArguments.getContextId();
        this.j = a.B1();
        ProfileScreenResolverFragmentComponent.Builder factory = DaggerProfileScreenResolverFragmentComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(userKey, contextId, resources, (ProfileScreenResolverFragmentDependencies) ComponentDependenciesKt.getDependencies(ProfileScreenResolverFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        UnknownScreenTracker unknownScreenTracker = this.performanceTracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("performanceTracker");
        }
        Timer timer = this.j;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
        }
        unknownScreenTracker.trackDiInject(timer.elapsed());
        return true;
    }
}
