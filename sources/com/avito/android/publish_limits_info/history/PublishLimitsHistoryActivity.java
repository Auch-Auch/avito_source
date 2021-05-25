package com.avito.android.publish_limits_info.history;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.avito.android.app.di.HasActivityComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.R;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModel;
import com.avito.android.publish_limits_info.history.di.DaggerPublishLimitsHistoryComponent;
import com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryComponent;
import com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies;
import com.avito.android.publish_limits_info.history.tab.ExtraInfoClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.CollapsingTitleAppBarLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/app/di/HasActivityComponent;", "Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent;", "Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "shortcut", "onExtraLinkClicked", "(Ljava/lang/String;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "getActivityComponent", "()Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent;", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "l", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "appBar", "Landroid/view/View;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/View;", "loadingSkeleton", "n", "Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryComponent;", "limitsHistoryComponent", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;", "historyViewModel", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;", "getHistoryViewModel", "()Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;", "setHistoryViewModel", "(Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;)V", "Lcom/avito/android/publish_limits_info/history/PublishAdvertsHistoryHostView;", "k", "Lcom/avito/android/publish_limits_info/history/PublishAdvertsHistoryHostView;", "advertsHostView", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "limitsEventTracker", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "getLimitsEventTracker", "()Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "setLimitsEventTracker", "(Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;)V", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "loadingProgress", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "getLoadingProgress", "()Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "setLoadingProgress", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlay;)V", "<init>", "()V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsHistoryActivity extends BaseActivity implements HasActivityComponent<PublishLimitsHistoryComponent>, ExtraInfoClickListener {
    @Inject
    public PublishLimitsHistoryViewModel historyViewModel;
    public PublishAdvertsHistoryHostView k;
    public CollapsingTitleAppBarLayout l;
    @Inject
    public PublishLimitsEventTracker limitsEventTracker;
    @Inject
    public LoadingProgressOverlay loadingProgress;
    public View m;
    public PublishLimitsHistoryComponent n;

    public static final class a<T> implements Observer<LoadingState<? super PublishLimitsHistoryViewModel.State>> {
        public final /* synthetic */ PublishLimitsHistoryActivity a;

        public a(PublishLimitsHistoryActivity publishLimitsHistoryActivity) {
            this.a = publishLimitsHistoryActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(LoadingState<? super PublishLimitsHistoryViewModel.State> loadingState) {
            String str;
            LoadingState<? super PublishLimitsHistoryViewModel.State> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                PublishLimitsHistoryActivity.access$setupUI(this.a, (PublishLimitsHistoryViewModel.State) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Error) {
                PublishLimitsHistoryActivity.access$showProgress(this.a, false);
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (!(error instanceof ErrorWithMessage)) {
                    error = null;
                }
                ErrorWithMessage errorWithMessage = (ErrorWithMessage) error;
                if (errorWithMessage == null || (str = errorWithMessage.getMessage()) == null) {
                    str = "";
                }
                PublishLimitsHistoryActivity.access$showError(this.a, str);
            } else if (Intrinsics.areEqual(loadingState2, LoadingState.Loading.INSTANCE)) {
                PublishLimitsHistoryActivity.access$hideError(this.a);
                PublishLimitsHistoryActivity.access$showProgress(this.a, true);
            }
        }
    }

    public static final void access$hideError(PublishLimitsHistoryActivity publishLimitsHistoryActivity) {
        LoadingProgressOverlay loadingProgressOverlay = publishLimitsHistoryActivity.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay.showContent();
    }

    public static final void access$setupUI(PublishLimitsHistoryActivity publishLimitsHistoryActivity, PublishLimitsHistoryViewModel.State state) {
        View view = publishLimitsHistoryActivity.m;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingSkeleton");
        }
        Views.setVisible(view, false);
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = publishLimitsHistoryActivity.l;
        if (collapsingTitleAppBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBar");
        }
        collapsingTitleAppBarLayout.setTitle(state.getTitle());
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout2 = publishLimitsHistoryActivity.l;
        if (collapsingTitleAppBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBar");
        }
        collapsingTitleAppBarLayout2.setShortTitle(state.getTitle());
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout3 = publishLimitsHistoryActivity.l;
        if (collapsingTitleAppBarLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBar");
        }
        collapsingTitleAppBarLayout3.setSubTitle(state.getDescription());
        PublishAdvertsHistoryHostView publishAdvertsHistoryHostView = publishLimitsHistoryActivity.k;
        if (publishAdvertsHistoryHostView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsHostView");
        }
        publishAdvertsHistoryHostView.updateTabs(state.getTabs());
    }

    public static final void access$showError(PublishLimitsHistoryActivity publishLimitsHistoryActivity, String str) {
        LoadingProgressOverlay loadingProgressOverlay = publishLimitsHistoryActivity.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay.showFullScreenLoadingProblem(str);
    }

    public static final void access$showProgress(PublishLimitsHistoryActivity publishLimitsHistoryActivity, boolean z) {
        View view = publishLimitsHistoryActivity.m;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingSkeleton");
        }
        Views.setVisible(view, z);
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.publish_limits_history;
    }

    @NotNull
    public final PublishLimitsHistoryViewModel getHistoryViewModel() {
        PublishLimitsHistoryViewModel publishLimitsHistoryViewModel = this.historyViewModel;
        if (publishLimitsHistoryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
        }
        return publishLimitsHistoryViewModel;
    }

    @NotNull
    public final PublishLimitsEventTracker getLimitsEventTracker() {
        PublishLimitsEventTracker publishLimitsEventTracker = this.limitsEventTracker;
        if (publishLimitsEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("limitsEventTracker");
        }
        return publishLimitsEventTracker;
    }

    @NotNull
    public final LoadingProgressOverlay getLoadingProgress() {
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        return loadingProgressOverlay;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.k = new PublishAdvertsHistoryHostView(containerView, supportFragmentManager);
        View findViewById = findViewById(R.id.publish_limits_skeleton_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.publish_limits_skeleton_root)");
        this.m = findViewById;
        View findViewById2 = findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.app_bar)");
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = (CollapsingTitleAppBarLayout) findViewById2;
        this.l = collapsingTitleAppBarLayout;
        if (collapsingTitleAppBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBar");
        }
        collapsingTitleAppBarLayout.setClickListener(new AppbarClickListener() { // from class: com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity$setupAppBar$1
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                PublishLimitsHistoryActivity.this.finish();
            }
        });
        LoadingProgressOverlay loadingProgressOverlay = this.loadingProgress;
        if (loadingProgressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        View containerView2 = getContainerView();
        Objects.requireNonNull(containerView2, "null cannot be cast to non-null type android.view.ViewGroup");
        loadingProgressOverlay.setup((ViewGroup) containerView2, R.id.root_container);
        LoadingProgressOverlay loadingProgressOverlay2 = this.loadingProgress;
        if (loadingProgressOverlay2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        }
        loadingProgressOverlay2.setOnRefreshListener(new a2.a.a.f2.a.a(this));
        PublishLimitsHistoryViewModel publishLimitsHistoryViewModel = this.historyViewModel;
        if (publishLimitsHistoryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
        }
        publishLimitsHistoryViewModel.getState().observe(this, new a(this));
    }

    @Override // com.avito.android.publish_limits_info.history.tab.ExtraInfoClickListener
    public void onExtraLinkClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        PublishLimitsEventTracker publishLimitsEventTracker = this.limitsEventTracker;
        if (publishLimitsEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("limitsEventTracker");
        }
        PublishLimitsHistoryViewModel publishLimitsHistoryViewModel = this.historyViewModel;
        if (publishLimitsHistoryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
        }
        publishLimitsEventTracker.trackHistoryHelpClicked(publishLimitsHistoryViewModel.getItemId(), str);
    }

    public final void setHistoryViewModel(@NotNull PublishLimitsHistoryViewModel publishLimitsHistoryViewModel) {
        Intrinsics.checkNotNullParameter(publishLimitsHistoryViewModel, "<set-?>");
        this.historyViewModel = publishLimitsHistoryViewModel;
    }

    public final void setLimitsEventTracker(@NotNull PublishLimitsEventTracker publishLimitsEventTracker) {
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "<set-?>");
        this.limitsEventTracker = publishLimitsEventTracker;
    }

    public final void setLoadingProgress(@NotNull LoadingProgressOverlay loadingProgressOverlay) {
        Intrinsics.checkNotNullParameter(loadingProgressOverlay, "<set-?>");
        this.loadingProgress = loadingProgressOverlay;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("history_id");
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtra(EXTRA_ITEM_ID)");
        ItemId itemId = (ItemId) parcelableExtra;
        PublishLimitsHistoryComponent create = DaggerPublishLimitsHistoryComponent.factory().create(this, itemId, this, (PublishLimitsHistoryDependencies) ComponentDependenciesKt.getDependencies(PublishLimitsHistoryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        this.n = create;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException("limitsHistoryComponent");
        }
        create.inject(this);
        PublishLimitsEventTracker publishLimitsEventTracker = this.limitsEventTracker;
        if (publishLimitsEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("limitsEventTracker");
        }
        publishLimitsEventTracker.trackLimitsHistoryOpen(itemId);
        return true;
    }

    @Override // com.avito.android.app.di.HasActivityComponent
    @NotNull
    public PublishLimitsHistoryComponent getActivityComponent() {
        PublishLimitsHistoryComponent publishLimitsHistoryComponent = this.n;
        if (publishLimitsHistoryComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("limitsHistoryComponent");
        }
        return publishLimitsHistoryComponent;
    }
}
