package com.avito.android.player.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.PlayerScreen;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.player.R;
import com.avito.android.player.di.DaggerPlayerFragmentComponent;
import com.avito.android.player.di.PlayerFragmentComponent;
import com.avito.android.player.di.PlayerFragmentDependencies;
import com.avito.android.player.presenter.PlayerPresenter;
import com.avito.android.player.presenter.tracker.PlayerTracker;
import com.avito.android.player.router.PlayerArguments;
import com.avito.android.player.router.PlayerRouter;
import com.avito.android.player.router.PlayerRouterImpl;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Views;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001dB\u0007¢\u0006\u0004\bc\u0010\u001bJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u001bJ\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u001bJ\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\u001bJ\u0017\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u001bR\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010:\u001a\u0002038\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/avito/android/player/view/PlayerFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/player/view/PlayerView;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "onBackPressed", "()Z", "onStart", "()V", "onStop", "onResume", "onPause", "onDestroyView", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", ScreenPublicConstsKt.CONTENT_TYPE_PLAYER, "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "releasePlayer", "hideSystemUI", "showLoading", "", "message", "showError", "(Ljava/lang/String;)V", "showContent", "Lcom/avito/android/player/presenter/PlayerPresenter;", "presenter", "Lcom/avito/android/player/presenter/PlayerPresenter;", "getPresenter", "()Lcom/avito/android/player/presenter/PlayerPresenter;", "setPresenter", "(Lcom/avito/android/player/presenter/PlayerPresenter;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "o", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/player/router/PlayerRouter;", "j", "Lcom/avito/android/player/router/PlayerRouter;", "router", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/ViewGroup;", "loadingView", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "closeView", "Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "tracker", "Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "getTracker", "()Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "setTracker", "(Lcom/avito/android/player/presenter/tracker/PlayerTracker;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/google/android/exoplayer2/ui/PlayerView;", "l", "Lcom/google/android/exoplayer2/ui/PlayerView;", "playerView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "n", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "<init>", "Companion", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerFragment extends TabBaseFragment implements OnBackPressedListener, PlayerView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "PlayerFragment";
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public PlayerRouter j;
    public ImageView k;
    public PlayerView l;
    public ViewGroup m;
    public ProgressOverlay n;
    @NotNull
    public NavigationState o = new NavigationState(false);
    @Inject
    public PlayerPresenter presenter;
    @Inject
    public PlayerTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/player/view/PlayerFragment$Companion;", "", "Lcom/avito/android/player/router/PlayerArguments;", "arguments", "Lcom/avito/android/player/view/PlayerFragment;", "newInstance", "(Lcom/avito/android/player/router/PlayerArguments;)Lcom/avito/android/player/view/PlayerFragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "player_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ PlayerArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(PlayerArguments playerArguments) {
                super(1);
                this.a = playerArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("player_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final PlayerFragment newInstance(@NotNull PlayerArguments playerArguments) {
            Intrinsics.checkNotNullParameter(playerArguments, "arguments");
            return (PlayerFragment) FragmentsKt.arguments$default(new PlayerFragment(), 0, new a(playerArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PlayerPresenter a;

        public a(PlayerPresenter playerPresenter) {
            this.a = playerPresenter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onClosePressed();
        }
    }

    public static final class b implements PlayerControlView.VisibilityListener {
        public final /* synthetic */ WeakReference a;

        public b(WeakReference weakReference) {
            this.a = weakReference;
        }

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener
        public final void onVisibilityChange(int i) {
            PlayerFragment playerFragment = (PlayerFragment) this.a.get();
            if (playerFragment != null) {
                PlayerFragment.access$setNavigationVisible(playerFragment, i == 0);
            }
        }
    }

    public static final void access$setNavigationVisible(PlayerFragment playerFragment, boolean z) {
        ImageView imageView = playerFragment.k;
        if (imageView != null) {
            Views.setVisible(imageView, z);
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

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.o;
    }

    @NotNull
    public final PlayerPresenter getPresenter() {
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return playerPresenter;
    }

    @NotNull
    public final PlayerTracker getTracker() {
        PlayerTracker playerTracker = this.tracker;
        if (playerTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return playerTracker;
    }

    @Override // com.avito.android.player.view.PlayerView
    public void hideSystemUI() {
        PlayerView playerView = this.l;
        if (playerView != null) {
            playerView.setSystemUiVisibility(4871);
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        this.j = new PlayerRouterImpl(this, activityIntentFactory2);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PlayerTracker playerTracker = this.tracker;
        if (playerTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        playerTracker.startInit();
        return layoutInflater.inflate(R.layout.player_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        playerPresenter.onViewDestroyed();
        PlayerTracker playerTracker = this.tracker;
        if (playerTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        playerTracker.destroy();
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        this.k = null;
        this.l = null;
        this.m = null;
        ProgressOverlay progressOverlay = this.n;
        if (progressOverlay != null) {
            progressOverlay.setOnRefreshListener((OnRefreshListener) null);
        }
        this.n = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        playerPresenter.onViewPaused();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        playerPresenter.onViewResumed();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = new Bundle();
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle2.putBundle("presenter", playerPresenter.onSaveState());
        saveInRetainStorage(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PlayerRouter playerRouter = this.j;
        if (playerRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        playerPresenter.onViewStarted(playerRouter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        PlayerPresenter playerPresenter = this.presenter;
        if (playerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        playerPresenter.onViewStopped();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle retainStorage = retainStorage();
        if (retainStorage != null) {
            PlayerPresenter playerPresenter = this.presenter;
            if (playerPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            playerPresenter.onRestoreState(retainStorage.getBundle("presenter"));
        }
        this.l = (PlayerView) view.findViewById(R.id.player_view);
        this.k = (ImageView) view.findViewById(R.id.close_button);
        PlayerPresenter playerPresenter2 = this.presenter;
        if (playerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        playerPresenter2.onViewCreated(this);
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) view).findViewById(R.id.loading_container);
        this.m = viewGroup;
        PlayerPresenter playerPresenter3 = this.presenter;
        if (playerPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intrinsics.checkNotNullExpressionValue(viewGroup, "loadingView");
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, 0, analytics2, false, 0, 10, null);
        progressOverlay.setOnRefreshListener(new a2.a.a.a2.b.b(playerPresenter3));
        this.n = progressOverlay;
        PlayerPresenter playerPresenter4 = this.presenter;
        if (playerPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(new a(playerPresenter4));
        }
        PlayerTracker playerTracker = this.tracker;
        if (playerTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        playerTracker.trackInit();
    }

    @Override // com.avito.android.player.view.PlayerView
    public void releasePlayer() {
        PlayerView playerView = this.l;
        if (playerView != null) {
            playerView.setControllerVisibilityListener(null);
            playerView.setPlayer(null);
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.o = navigationState;
    }

    @Override // com.avito.android.player.view.PlayerView
    public void setPlayer(@NotNull SimpleExoPlayer simpleExoPlayer) {
        Intrinsics.checkNotNullParameter(simpleExoPlayer, ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
        PlayerView playerView = this.l;
        if (playerView != null) {
            playerView.setPlayer(simpleExoPlayer);
        }
        PlayerView playerView2 = this.l;
        if (playerView2 != null) {
            playerView2.setControlDispatcher(new a2.a.a.a2.b.a(new DefaultControlDispatcher()) { // from class: com.avito.android.player.view.PlayerFragment$createControlDispatcher$1
                @Override // a2.a.a.a2.b.a, com.google.android.exoplayer2.ControlDispatcher
                public boolean dispatchFastForward(@NotNull Player player) {
                    Intrinsics.checkNotNullParameter(player, ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
                    PlayerFragment.this.getPresenter().onPlayerFastForwardPressed();
                    return super.dispatchFastForward(player);
                }

                @Override // a2.a.a.a2.b.a, com.google.android.exoplayer2.ControlDispatcher
                public boolean dispatchRewind(@NotNull Player player) {
                    Intrinsics.checkNotNullParameter(player, ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
                    PlayerFragment.this.getPresenter().onPlayerRewindPressed();
                    return super.dispatchRewind(player);
                }

                @Override // a2.a.a.a2.b.a, com.google.android.exoplayer2.ControlDispatcher
                public boolean dispatchSetPlayWhenReady(@NotNull Player player, boolean z) {
                    Intrinsics.checkNotNullParameter(player, ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
                    if (!shouldShowPauseButton(player) || player.getPlaybackState() == 2) {
                        PlayerFragment.this.getPresenter().onPlayerPlayPressed();
                    } else {
                        PlayerFragment.this.getPresenter().onPlayerPausePressed();
                    }
                    return super.dispatchSetPlayWhenReady(player, z);
                }
            });
        }
        WeakReference weakReference = new WeakReference(this);
        PlayerView playerView3 = this.l;
        if (playerView3 != null) {
            playerView3.setControllerVisibilityListener(new b(weakReference));
        }
    }

    public final void setPresenter(@NotNull PlayerPresenter playerPresenter) {
        Intrinsics.checkNotNullParameter(playerPresenter, "<set-?>");
        this.presenter = playerPresenter;
    }

    public final void setTracker(@NotNull PlayerTracker playerTracker) {
        Intrinsics.checkNotNullParameter(playerTracker, "<set-?>");
        this.tracker = playerTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        retainStorage();
        Bundle arguments = getArguments();
        PlayerArguments playerArguments = null;
        PlayerArguments playerArguments2 = arguments != null ? (PlayerArguments) arguments.getParcelable("player_arguments") : null;
        if (playerArguments2 instanceof PlayerArguments) {
            playerArguments = playerArguments2;
        }
        if (playerArguments != null) {
            Timer B1 = a2.b.a.a.a.B1();
            PlayerFragmentComponent.Builder withScreenSource = DaggerPlayerFragmentComponent.builder().withPlayerDependencies((PlayerFragmentDependencies) ComponentDependenciesKt.getDependencies(PlayerFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withScreenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withMediaUrl(playerArguments.getUrl()).withMediaSlug(playerArguments.getSlug()).withMediaBlockType(playerArguments.getBlockType()).withScreenSource(playerArguments.getScreenSource());
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            PlayerFragmentComponent.Builder withScreen = withScreenSource.withResources(resources).withScreen(PlayerScreen.INSTANCE);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            withScreen.withViewContext(requireContext).build().inject(this);
            PlayerTracker playerTracker = this.tracker;
            if (playerTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            playerTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException("PlayerArguments must be specified");
    }

    @Override // com.avito.android.player.view.PlayerView
    public void showContent() {
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
        ProgressOverlay progressOverlay = this.n;
        if (progressOverlay != null) {
            progressOverlay.showContent();
        }
        PlayerView playerView = this.l;
        if (playerView != null) {
            playerView.setControllerHideOnTouch(true);
        }
    }

    @Override // com.avito.android.player.view.PlayerView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.player_error_bg));
            int color = ContextCompat.getColor(requireContext(), R.color.player_text_color);
            View findViewById = viewGroup.findViewById(com.avito.android.ui_components.R.id.error_image);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            TextView textView = (TextView) viewGroup.findViewById(com.avito.android.ui_components.R.id.error_text);
            if (textView != null) {
                textView.setTextColor(color);
            }
        }
        ProgressOverlay progressOverlay = this.n;
        if (progressOverlay != null) {
            progressOverlay.showLoadingProblem(str);
        }
        PlayerView playerView = this.l;
        if (playerView != null) {
            playerView.showController();
            playerView.setControllerHideOnTouch(false);
        }
    }

    @Override // com.avito.android.player.view.PlayerView
    public void showLoading() {
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
        ProgressOverlay progressOverlay = this.n;
        if (progressOverlay != null) {
            progressOverlay.showLoading();
        }
        PlayerView playerView = this.l;
        if (playerView != null) {
            playerView.showController();
            playerView.setControllerHideOnTouch(true);
        }
    }
}
