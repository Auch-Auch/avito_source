package com.avito.android.advert_stats;

import a2.a.a.h.b;
import a2.a.a.h.h;
import a2.a.a.h.i;
import a2.a.a.h.j;
import a2.a.a.h.k;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_stats.di.AdvertStatisticComponent;
import com.avito.android.advert_stats.di.AdvertStatsDependencies;
import com.avito.android.advert_stats.di.AdvertStatsModule;
import com.avito.android.advert_stats.di.AdvertStatsModuleKt;
import com.avito.android.advert_stats.di.DaggerAdvertStatisticComponent;
import com.avito.android.advert_stats.item.PlotItemPresenter;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerPresenter;
import com.avito.android.advert_stats.item.hint.HintItemPresenter;
import com.avito.android.advert_stats.recycler.LastItemDecoration;
import com.avito.android.advert_stats.recycler.StatisticsDecoration;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.deprecated_design.R;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.architecture_components.Event;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b{\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ)\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0016\u0010\tR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bU\u0010VR \u0010\\\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030Y0X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bi\u0010jR\"\u0010m\u001a\u00020l8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006|"}, d2 = {"Lcom/avito/android/advert_stats/AdvertStatsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert_stats/ExternalLinkRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openLink", "(Landroid/net/Uri;)V", "onDestroy", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "advertStatsTracker", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "getAdvertStatsTracker", "()Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "setAdvertStatsTracker", "(Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;)V", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;", "statisticsItemPresenter", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;", "getStatisticsItemPresenter", "()Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;", "setStatisticsItemPresenter", "(Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/lib/design/button/Button;", "p", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lio/reactivex/disposables/Disposable;", VKApiConst.Q, "Lio/reactivex/disposables/Disposable;", "buttonDisposable", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "viewModel", "Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "getViewModel", "()Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "setViewModel", "(Lcom/avito/android/advert_stats/AdvertStatsViewModel;)V", "Landroidx/appcompat/widget/Toolbar;", "k", "Landroidx/appcompat/widget/Toolbar;", "advertsToolbar", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "n", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/lifecycle/Observer;", "Lcom/avito/android/util/architecture_components/Event;", "s", "Landroidx/lifecycle/Observer;", "routingEventsObserver", "Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;", "hintItemPresenter", "Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;", "getHintItemPresenter", "()Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;", "setHintItemPresenter", "(Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/advert_stats/recycler/LastItemDecoration;", "r", "Lcom/avito/android/advert_stats/recycler/LastItemDecoration;", "lastItemDecoration", "Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "plotPresenter", "Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "getPlotPresenter", "()Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "setPlotPresenter", "(Lcom/avito/android/advert_stats/item/PlotItemPresenter;)V", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "toolbarTitle", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "o", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "<init>", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatsActivity extends BaseActivity implements ExternalLinkRouter {
    @Inject
    @Named(AdvertStatsModuleKt.STATS_ADAPTER_PRESENTER)
    public AdapterPresenter adapterPresenter;
    @Inject
    public AdvertStatsTracker advertStatsTracker;
    @Inject
    public Analytics analytics;
    @Inject
    public HintItemPresenter hintItemPresenter;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    @Named(AdvertStatsModuleKt.STATS_ITEM_BINDER)
    public ItemBinder itemBinder;
    public Toolbar k;
    public TextView l;
    public ProgressOverlay m;
    public RecyclerView n;
    public RecyclerView.LayoutManager o;
    public Button p;
    @Inject
    public PlotItemPresenter plotPresenter;
    public Disposable q;
    public LastItemDecoration r;
    public final Observer<Event<?>> s = new a(this);
    @Inject
    public NewStatisticsBannerPresenter statisticsItemPresenter;
    @Inject
    public AdvertStatsViewModel viewModel;

    public static final class a<T> implements Observer<Event<?>> {
        public final /* synthetic */ AdvertStatsActivity a;

        public a(AdvertStatsActivity advertStatsActivity) {
            this.a = advertStatsActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Event<?> event) {
            Object contentIfNotHandled;
            Event<?> event2 = event;
            if (event2 != null && (contentIfNotHandled = event2.getContentIfNotHandled()) != null) {
                if (contentIfNotHandled instanceof IntentDataHolder) {
                    IntentDataHolder intentDataHolder = (IntentDataHolder) contentIfNotHandled;
                    if (intentDataHolder.getShouldFinish()) {
                        this.a.finish();
                    }
                    this.a.startActivity(intentDataHolder.getIntent());
                } else if (contentIfNotHandled instanceof IntentForResultDataHolder) {
                    IntentForResultDataHolder intentForResultDataHolder = (IntentForResultDataHolder) contentIfNotHandled;
                    this.a.startActivityForResult(intentForResultDataHolder.getIntent(), intentForResultDataHolder.getRequestCode());
                }
            }
        }
    }

    public AdvertStatsActivity() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.q = empty;
    }

    public static final /* synthetic */ Button access$getButton$p(AdvertStatsActivity advertStatsActivity) {
        Button button = advertStatsActivity.p;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        return button;
    }

    public static final /* synthetic */ LastItemDecoration access$getLastItemDecoration$p(AdvertStatsActivity advertStatsActivity) {
        LastItemDecoration lastItemDecoration = advertStatsActivity.r;
        if (lastItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastItemDecoration");
        }
        return lastItemDecoration;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(AdvertStatsActivity advertStatsActivity) {
        ProgressOverlay progressOverlay = advertStatsActivity.m;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(AdvertStatsActivity advertStatsActivity) {
        RecyclerView recyclerView = advertStatsActivity.n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ TextView access$getToolbarTitle$p(AdvertStatsActivity advertStatsActivity) {
        TextView textView = advertStatsActivity.l;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarTitle");
        }
        return textView;
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
    public final AdvertStatsTracker getAdvertStatsTracker() {
        AdvertStatsTracker advertStatsTracker2 = this.advertStatsTracker;
        if (advertStatsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertStatsTracker");
        }
        return advertStatsTracker2;
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
    public final HintItemPresenter getHintItemPresenter() {
        HintItemPresenter hintItemPresenter2 = this.hintItemPresenter;
        if (hintItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintItemPresenter");
        }
        return hintItemPresenter2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final PlotItemPresenter getPlotPresenter() {
        PlotItemPresenter plotItemPresenter = this.plotPresenter;
        if (plotItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plotPresenter");
        }
        return plotItemPresenter;
    }

    @NotNull
    public final NewStatisticsBannerPresenter getStatisticsItemPresenter() {
        NewStatisticsBannerPresenter newStatisticsBannerPresenter = this.statisticsItemPresenter;
        if (newStatisticsBannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticsItemPresenter");
        }
        return newStatisticsBannerPresenter;
    }

    @NotNull
    public final AdvertStatsViewModel getViewModel() {
        AdvertStatsViewModel advertStatsViewModel = this.viewModel;
        if (advertStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return advertStatsViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        AdvertStatsViewModel advertStatsViewModel = this.viewModel;
        if (advertStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel.handleResult(i, i2);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Timer B1 = a2.b.a.a.a.B1();
        String stringExtra = getIntent().getStringExtra("item_id");
        AdvertStatisticComponent.Builder dependencies = DaggerAdvertStatisticComponent.builder().dependencies((AdvertStatsDependencies) ComponentDependenciesKt.getDependencies(AdvertStatsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Intrinsics.checkNotNullExpressionValue(stringExtra, "itemId");
        dependencies.module(new AdvertStatsModule(this, this, stringExtra)).build().inject(this);
        AdvertStatsTracker advertStatsTracker2 = this.advertStatsTracker;
        if (advertStatsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertStatsTracker");
        }
        advertStatsTracker2.trackDiInject(B1.elapsed());
        AdvertStatsTracker advertStatsTracker3 = this.advertStatsTracker;
        if (advertStatsTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertStatsTracker");
        }
        advertStatsTracker3.startInit();
        setContentView(R.layout.advert_stats_activity);
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(deprecated_R.id.toolbar)");
        this.k = (Toolbar) findViewById;
        View findViewById2 = findViewById(R.id.toolbar_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.toolbar_title)");
        this.l = (TextView) findViewById2;
        int i = R.id.recycler_view;
        View findViewById3 = findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.recycler_view)");
        this.n = (RecyclerView) findViewById3;
        this.o = new LinearLayoutManager(this, 1, false);
        RecyclerView recyclerView = this.n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.LayoutManager layoutManager = this.o;
        if (layoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView recyclerView2 = this.n;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView recyclerView3 = this.n;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        Resources resources = recyclerView3.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "recyclerView.resources");
        recyclerView2.addItemDecoration(new StatisticsDecoration(resources));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.bottom_margin);
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        this.r = new LastItemDecoration(dimensionPixelSize, resources2);
        RecyclerView recyclerView4 = this.n;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        LastItemDecoration lastItemDecoration = this.r;
        if (lastItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastItemDecoration");
        }
        recyclerView4.addItemDecoration(lastItemDecoration);
        View findViewById4 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.content_container)");
        ViewGroup viewGroup = (ViewGroup) findViewById4;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics2, false, 0, 24, null);
        this.m = progressOverlay;
        progressOverlay.setOnRefreshListener(new j(this));
        Toolbar toolbar = this.k;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsToolbar");
        }
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        Toolbar toolbar2 = this.k;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsToolbar");
        }
        toolbar2.setNavigationOnClickListener(new k(this));
        View findViewById5 = findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.button)");
        this.p = (Button) findViewById5;
        AdvertStatsViewModel advertStatsViewModel = this.viewModel;
        if (advertStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel.getProgressChanges().observe(this, new a2.a.a.h.a(this));
        AdvertStatsViewModel advertStatsViewModel2 = this.viewModel;
        if (advertStatsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel2.getDataChanges().observe(this, new b(this));
        AdvertStatsViewModel advertStatsViewModel3 = this.viewModel;
        if (advertStatsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel3.getButtonActionChanges().observe(this, new h(this));
        AdvertStatsViewModel advertStatsViewModel4 = this.viewModel;
        if (advertStatsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel4.getTitleVisibilityChanges().observe(this, new i(this));
        AdvertStatsViewModel advertStatsViewModel5 = this.viewModel;
        if (advertStatsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PlotItemPresenter plotItemPresenter = this.plotPresenter;
        if (plotItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plotPresenter");
        }
        advertStatsViewModel5.subscribeToBarSelection(plotItemPresenter.getBarSelectedObservable());
        AdvertStatsViewModel advertStatsViewModel6 = this.viewModel;
        if (advertStatsViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PlotItemPresenter plotItemPresenter2 = this.plotPresenter;
        if (plotItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plotPresenter");
        }
        advertStatsViewModel6.subscribeToWeekSelection(plotItemPresenter2.getWeekSelectedObservable());
        AdvertStatsViewModel advertStatsViewModel7 = this.viewModel;
        if (advertStatsViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PlotItemPresenter plotItemPresenter3 = this.plotPresenter;
        if (plotItemPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plotPresenter");
        }
        advertStatsViewModel7.subscribeToWeekScrolling(plotItemPresenter3.getPlotScrollObservable());
        AdvertStatsViewModel advertStatsViewModel8 = this.viewModel;
        if (advertStatsViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        HintItemPresenter hintItemPresenter2 = this.hintItemPresenter;
        if (hintItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintItemPresenter");
        }
        advertStatsViewModel8.subscribeToItemClicks(hintItemPresenter2);
        AdvertStatsViewModel advertStatsViewModel9 = this.viewModel;
        if (advertStatsViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        NewStatisticsBannerPresenter newStatisticsBannerPresenter = this.statisticsItemPresenter;
        if (newStatisticsBannerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticsItemPresenter");
        }
        advertStatsViewModel9.subscribeStatisticsBannerClicks(newStatisticsBannerPresenter.getCloseBannerClicks());
        AdvertStatsTracker advertStatsTracker4 = this.advertStatsTracker;
        if (advertStatsTracker4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertStatsTracker");
        }
        advertStatsTracker4.trackInit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.dispose();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AdvertStatsViewModel advertStatsViewModel = this.viewModel;
        if (advertStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel.getRoutingEvents().observe(this, this.s);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AdvertStatsViewModel advertStatsViewModel = this.viewModel;
        if (advertStatsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        advertStatsViewModel.getRoutingEvents().removeObserver(this.s);
        super.onStop();
    }

    @Override // com.avito.android.advert_stats.ExternalLinkRouter
    public void openLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(implicitIntentFactory2.uriIntent(uri)));
        } catch (Exception unused) {
            ToastsKt.showToast$default(this, com.avito.android.ui_components.R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        }
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAdvertStatsTracker(@NotNull AdvertStatsTracker advertStatsTracker2) {
        Intrinsics.checkNotNullParameter(advertStatsTracker2, "<set-?>");
        this.advertStatsTracker = advertStatsTracker2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setHintItemPresenter(@NotNull HintItemPresenter hintItemPresenter2) {
        Intrinsics.checkNotNullParameter(hintItemPresenter2, "<set-?>");
        this.hintItemPresenter = hintItemPresenter2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPlotPresenter(@NotNull PlotItemPresenter plotItemPresenter) {
        Intrinsics.checkNotNullParameter(plotItemPresenter, "<set-?>");
        this.plotPresenter = plotItemPresenter;
    }

    public final void setStatisticsItemPresenter(@NotNull NewStatisticsBannerPresenter newStatisticsBannerPresenter) {
        Intrinsics.checkNotNullParameter(newStatisticsBannerPresenter, "<set-?>");
        this.statisticsItemPresenter = newStatisticsBannerPresenter;
    }

    public final void setViewModel(@NotNull AdvertStatsViewModel advertStatsViewModel) {
        Intrinsics.checkNotNullParameter(advertStatsViewModel, "<set-?>");
        this.viewModel = advertStatsViewModel;
    }
}
