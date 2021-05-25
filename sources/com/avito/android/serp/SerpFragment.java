package com.avito.android.serp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.AuthIntentFactoryKt;
import com.avito.android.Features;
import com.avito.android.FiltersIntentFactory;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.SerpScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.UpNavigationHandler;
import com.avito.android.bottom_navigation.ui.OnAddButtonStateChangeListener;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiverKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerSerpComponent;
import com.avito.android.di.component.SerpComponent;
import com.avito.android.di.component.SerpDependencies;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.filter.FilterCommons;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.rec.ScreenSource;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerState;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterState;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.dfp_mobile_ads.DfpMobileAdsWrapper;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.serp.warning.WarningStateProviderState;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Bundles;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Intents;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedDestroyable;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004ï\u0002ð\u0002B\b¢\u0006\u0005\bî\u0002\u0010\u0015J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010%\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\"H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b-\u00101Jc\u0010<\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u001a2\u0006\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010\u001a2\b\u00106\u001a\u0004\u0018\u00010\u001a2\b\u00108\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020(H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0007H\u0016¢\u0006\u0004\bE\u0010\u0015J\u000f\u0010F\u001a\u00020\u0007H\u0016¢\u0006\u0004\bF\u0010\u0015J\u000f\u0010G\u001a\u00020(H\u0016¢\u0006\u0004\bG\u0010HJ)\u0010M\u001a\u00020\u00072\u0006\u0010I\u001a\u0002092\u0006\u0010J\u001a\u0002092\b\u0010L\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0004\bM\u0010NJ1\u0010P\u001a\u00020\u00072\u0006\u0010B\u001a\u00020A2\b\u00103\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u00020/2\u0006\u0010O\u001a\u00020(H\u0016¢\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0005H\u0016¢\u0006\u0004\bS\u0010\tJ\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010\u0015J\u0017\u0010V\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u001aH\u0016¢\u0006\u0004\bV\u0010@J\u0019\u0010W\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\bW\u0010\tR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0006@\u0006X.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010­\u0001\u001a\u00030¬\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b­\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R*\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R*\u0010»\u0001\u001a\u00030º\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R*\u0010Â\u0001\u001a\u00030Á\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R*\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R*\u0010Ð\u0001\u001a\u00030Ï\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R*\u0010×\u0001\u001a\u00030Ö\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001R*\u0010Þ\u0001\u001a\u00030Ý\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R*\u0010å\u0001\u001a\u00030ä\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bå\u0001\u0010æ\u0001\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R*\u0010ì\u0001\u001a\u00030ë\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bì\u0001\u0010í\u0001\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R*\u0010ó\u0001\u001a\u00030ò\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bó\u0001\u0010ô\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001\"\u0006\b÷\u0001\u0010ø\u0001R*\u0010ú\u0001\u001a\u00030ù\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bú\u0001\u0010û\u0001\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R5\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00028B@BX\u0002¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010 \u0002\u001a\u0006\b¡\u0002\u0010¢\u0002\"\u0006\b£\u0002\u0010¤\u0002R*\u0010¦\u0002\u001a\u00030¥\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0002\u0010§\u0002\u001a\u0006\b¨\u0002\u0010©\u0002\"\u0006\bª\u0002\u0010«\u0002R*\u0010­\u0002\u001a\u00030¬\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b­\u0002\u0010®\u0002\u001a\u0006\b¯\u0002\u0010°\u0002\"\u0006\b±\u0002\u0010²\u0002R*\u0010´\u0002\u001a\u00030³\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b´\u0002\u0010µ\u0002\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R*\u0010»\u0002\u001a\u00030º\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b»\u0002\u0010¼\u0002\u001a\u0006\b½\u0002\u0010¾\u0002\"\u0006\b¿\u0002\u0010À\u0002R*\u0010Â\u0002\u001a\u00030Á\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÂ\u0002\u0010Ã\u0002\u001a\u0006\bÄ\u0002\u0010Å\u0002\"\u0006\bÆ\u0002\u0010Ç\u0002R*\u0010É\u0002\u001a\u00030È\u00028\u0000@\u0000X.¢\u0006\u0018\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002\"\u0006\bÍ\u0002\u0010Î\u0002R*\u0010Ð\u0002\u001a\u00030Ï\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÐ\u0002\u0010Ñ\u0002\u001a\u0006\bÒ\u0002\u0010Ó\u0002\"\u0006\bÔ\u0002\u0010Õ\u0002R*\u0010Ö\u0002\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÖ\u0002\u0010\u0001\u001a\u0006\b×\u0002\u0010\u0001\"\u0006\bØ\u0002\u0010\u0001R*\u0010Ú\u0002\u001a\u00030Ù\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÚ\u0002\u0010Û\u0002\u001a\u0006\bÜ\u0002\u0010Ý\u0002\"\u0006\bÞ\u0002\u0010ß\u0002R*\u0010á\u0002\u001a\u00030à\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\bá\u0002\u0010â\u0002\u001a\u0006\bã\u0002\u0010ä\u0002\"\u0006\bå\u0002\u0010æ\u0002R*\u0010è\u0002\u001a\u00030ç\u00028\u0000@\u0000X.¢\u0006\u0018\n\u0006\bè\u0002\u0010é\u0002\u001a\u0006\bê\u0002\u0010ë\u0002\"\u0006\bì\u0002\u0010í\u0002¨\u0006ñ\u0002"}, d2 = {"Lcom/avito/android/serp/SerpFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/serp/SerpRouter;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/ui/ActivityInteractor;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onStart", "onStop", "onResume", "onPause", "", "src", "Landroid/os/Parcelable;", "authPendingData", "showAuth", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", "Lkotlin/Function0;", "successHandler", "failureHandler", "followPhoneLink", "(Lcom/avito/android/deep_linking/links/PhoneLink;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "phoneLink", "", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "galleryPosition", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/Integer;Z)V", "channelId", "openMessenger", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "showClarifyScreen", "(Lcom/avito/android/remote/model/SearchParams;)V", "closeSearch", "leaveScreen", "onBackPressed", "()Z", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "showJobNearbyBanner", "openSerpWithBackstack", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "outState", "onSaveInstanceState", "showNotificationSettingsScreen", "adUnitId", "openDebugMenu", "onViewStateRestored", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "floatingViewsPresenter", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "getFloatingViewsPresenter", "()Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "setFloatingViewsPresenter", "(Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;)V", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "setGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "serpSkeletonTestGroup", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "getSerpSkeletonTestGroup", "()Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "setSerpSkeletonTestGroup", "(Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/serp/SerpInteractor;", "interactor", "Lcom/avito/android/serp/SerpInteractor;", "getInteractor", "()Lcom/avito/android/serp/SerpInteractor;", "setInteractor", "(Lcom/avito/android/serp/SerpInteractor;)V", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "supplier", "Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "getSupplier", "()Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "setSupplier", "(Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "networkInfoBroadcastReceiver", "Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "getNetworkInfoBroadcastReceiver", "()Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "setNetworkInfoBroadcastReceiver", "(Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;)V", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "closedItemPresenter", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "getClosedItemPresenter", "()Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "setClosedItemPresenter", "(Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;)V", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "advertXlStateProvider", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "getAdvertXlStateProvider", "()Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;", "setAdvertXlStateProvider", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlStateProvider;)V", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "getNotificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "setNotificationManagerProvider", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "Lcom/avito/android/serp/analytics/SerpTracker;", "tracker", "Lcom/avito/android/serp/analytics/SerpTracker;", "getTracker", "()Lcom/avito/android/serp/analytics/SerpTracker;", "setTracker", "(Lcom/avito/android/serp/analytics/SerpTracker;)V", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchPresenter", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "getSavedSearchPresenter", "()Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "setSavedSearchPresenter", "(Lcom/avito/android/saved_searches/SavedSearchesPresenter;)V", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "setSpanSizeLookup", "(Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "setFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenter;)V", "Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "mobileAdsWrapper", "Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "getMobileAdsWrapper", "()Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "setMobileAdsWrapper", "(Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "inlineFiltersPresenter", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "getInlineFiltersPresenter", "()Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "setInlineFiltersPresenter", "(Lcom/avito/android/inline_filters/InlineFiltersPresenter;)V", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "inlineFilterDialogFactory", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "getInlineFilterDialogFactory", "()Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "setInlineFilterDialogFactory", "(Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;)V", "Lcom/avito/android/serp/SerpPresenter;", "presenter", "Lcom/avito/android/serp/SerpPresenter;", "getPresenter", "()Lcom/avito/android/serp/SerpPresenter;", "setPresenter", "(Lcom/avito/android/serp/SerpPresenter;)V", "Lcom/avito/android/serp/SerpResourcesProvider;", "resourcesProvider", "Lcom/avito/android/serp/SerpResourcesProvider;", "getResourcesProvider", "()Lcom/avito/android/serp/SerpResourcesProvider;", "setResourcesProvider", "(Lcom/avito/android/serp/SerpResourcesProvider;)V", "Lcom/avito/android/serp/SerpView;", "<set-?>", "j", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedDestroyable;", "getSerpView", "()Lcom/avito/android/serp/SerpView;", "setSerpView", "(Lcom/avito/android/serp/SerpView;)V", "serpView", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "setBuildInfo", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "verticalFilterPresenter", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "getVerticalFilterPresenter", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "setVerticalFilterPresenter", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;)V", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "getOnboardingHandler", "()Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "setOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)V", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "setItemVisibilityTracker", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "witcherItemPresenter", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "getWitcherItemPresenter", "()Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "setWitcherItemPresenter", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;)V", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "richSnippetStateProvider", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "getRichSnippetStateProvider", "()Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "setRichSnippetStateProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$serp_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$serp_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Lcom/avito/android/serp/warning/WarningStateProvider;", "warningStateProvider", "Lcom/avito/android/serp/warning/WarningStateProvider;", "getWarningStateProvider", "()Lcom/avito/android/serp/warning/WarningStateProvider;", "setWarningStateProvider", "(Lcom/avito/android/serp/warning/WarningStateProvider;)V", "serpInteractor", "getSerpInteractor", "setSerpInteractor", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "getAsyncPhonePresenter", "()Lcom/avito/android/async_phone/AsyncPhonePresenter;", "setAsyncPhonePresenter", "(Lcom/avito/android/async_phone/AsyncPhonePresenter;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartFabQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartFabQuantityHandler$serp_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartFabQuantityHandler$serp_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "<init>", "Factory", "StoreFragment", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpFragment extends TabBaseFragment implements SerpRouter, OnBackPressedListener, ActivityInteractor {
    public static final /* synthetic */ KProperty[] k = {a2.b.a.a.a.u0(SerpFragment.class, "serpView", "getSerpView()Lcom/avito/android/serp/SerpView;", 0)};
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public AdvertXlStateProvider advertXlStateProvider;
    @Inject
    public Analytics analytics;
    @Inject
    public SerpAnalyticsInteractor analyticsInteractor;
    @Inject
    public AsyncPhonePresenter asyncPhonePresenter;
    @Inject
    public BuildInfo buildInfo;
    @Inject
    public CartQuantityChangesHandler cartFabQuantityHandler;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public ClosedItemPresenter closedItemPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    @Inject
    public FavoriteAdvertsPresenter favoriteAdvertsPresenter;
    @Inject
    public Features features;
    @Inject
    public PersistableFloatingViewsPresenter floatingViewsPresenter;
    @Inject
    public SpannedGridPositionProvider gridPositionProvider;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public InlineFilterDialogFactory inlineFilterDialogFactory;
    @Inject
    public InlineFiltersPresenter inlineFiltersPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public SerpInteractor interactor;
    @Inject
    public ItemVisibilityTracker itemVisibilityTracker;
    public final AutoClearedDestroyable j = new AutoClearedDestroyable();
    @Inject
    public DfpMobileAdsWrapper mobileAdsWrapper;
    @Inject
    public NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver;
    @Inject
    public NotificationManagerProvider notificationManagerProvider;
    @Inject
    public SerpOnboardingHandler onboardingHandler;
    @Inject
    public SerpPresenter presenter;
    @Inject
    public SerpResourcesProvider resourcesProvider;
    @Inject
    @RichStateProvider
    public RichSnippetStateProvider richSnippetStateProvider;
    @Inject
    public SavedSearchesPresenter savedSearchPresenter;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public SerpInteractor serpInteractor;
    @Inject
    public SerpSkeletonTestGroup serpSkeletonTestGroup;
    @Inject
    public GridLayoutManager.SpanSizeLookup spanSizeLookup;
    @Inject
    public FpsStateSupplier supplier;
    @Inject
    public SerpTracker tracker;
    @Inject
    public VerticalFilterPresenter verticalFilterPresenter;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;
    @Inject
    public WarningStateProvider warningStateProvider;
    @Inject
    public WitcherItemPresenter witcherItemPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/SerpFragment$Factory;", "", "Lcom/avito/android/serp/SerpArguments;", "arguments", "", "showJobNearbyBanner", "Lcom/avito/android/serp/SerpFragment;", "createFragment", "(Lcom/avito/android/serp/SerpArguments;Z)Lcom/avito/android/serp/SerpFragment;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public static /* synthetic */ SerpFragment createFragment$default(Factory factory, SerpArguments serpArguments, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return factory.createFragment(serpArguments, z);
        }

        @NotNull
        public final SerpFragment createFragment(@NotNull SerpArguments serpArguments, boolean z) {
            Intrinsics.checkNotNullParameter(serpArguments, "arguments");
            SerpFragment serpFragment = new SerpFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arguments", serpArguments);
            bundle.putBoolean("KEY_SHOW_JOB_NEARBY_BANNER", z);
            serpFragment.setArguments(bundle);
            return serpFragment;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/SerpFragment$StoreFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/serp/SerpPresenterState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/SerpPresenterState;", "getState$serp_release", "()Lcom/avito/android/serp/SerpPresenterState;", "setState$serp_release", "(Lcom/avito/android/serp/SerpPresenterState;)V", "state", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class StoreFragment extends Fragment {
        @Nullable
        public SerpPresenterState a;

        @Nullable
        public final SerpPresenterState getState$serp_release() {
            return this.a;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public final void setState$serp_release(@Nullable SerpPresenterState serpPresenterState) {
            this.a = serpPresenterState;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SerpFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SerpFragment serpFragment) {
            super(0);
            this.a = serpFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getPresenter().onRefresh();
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.serp.SerpRouter
    public void closeSearch() {
        FragmentActivity activity = getActivity();
        if (activity instanceof UpNavigationHandler) {
            ((UpNavigationHandler) activity).handleUpNavigation();
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallRouter
    public boolean dialPhone(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(phoneLink);
        if (intent == null) {
            return false;
        }
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // com.avito.android.serp.SerpRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            Intents.putCalledFromExtra(intent, "search");
            IntentsKt.replaceTargetTabIfRequired(intent, currentTab());
            IntentsKt.replaceCalledFromIfRequired(intent, "search");
            startActivity(intent);
        }
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallRouter
    public void followPhoneLink(@NotNull PhoneLink phoneLink, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(phoneLink, "link");
        Intrinsics.checkNotNullParameter(function0, "successHandler");
        Intrinsics.checkNotNullParameter(function02, "failureHandler");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(phoneLink);
        if (intent != null) {
            try {
                startActivity(com.avito.android.util.IntentsKt.makeSafeForExternalApps(intent));
                function0.invoke();
            } catch (Exception unused) {
                function02.invoke();
            }
        }
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
    public final AdvertXlStateProvider getAdvertXlStateProvider() {
        AdvertXlStateProvider advertXlStateProvider2 = this.advertXlStateProvider;
        if (advertXlStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertXlStateProvider");
        }
        return advertXlStateProvider2;
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
    public final SerpAnalyticsInteractor getAnalyticsInteractor() {
        SerpAnalyticsInteractor serpAnalyticsInteractor = this.analyticsInteractor;
        if (serpAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return serpAnalyticsInteractor;
    }

    @NotNull
    public final AsyncPhonePresenter getAsyncPhonePresenter() {
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        return asyncPhonePresenter2;
    }

    @NotNull
    public final BuildInfo getBuildInfo() {
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        return buildInfo2;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartFabQuantityHandler$serp_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartFabQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabQuantityHandler");
        }
        return cartQuantityChangesHandler;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel$serp_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final ClosedItemPresenter getClosedItemPresenter() {
        ClosedItemPresenter closedItemPresenter2 = this.closedItemPresenter;
        if (closedItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedItemPresenter");
        }
        return closedItemPresenter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getDestroyableViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        return destroyableViewHolderBuilder2;
    }

    @NotNull
    public final FavoriteAdvertsPresenter getFavoriteAdvertsPresenter() {
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        return favoriteAdvertsPresenter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final PersistableFloatingViewsPresenter getFloatingViewsPresenter() {
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        return persistableFloatingViewsPresenter;
    }

    @NotNull
    public final SpannedGridPositionProvider getGridPositionProvider() {
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        return spannedGridPositionProvider;
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
    public final InlineFilterDialogFactory getInlineFilterDialogFactory() {
        InlineFilterDialogFactory inlineFilterDialogFactory2 = this.inlineFilterDialogFactory;
        if (inlineFilterDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFilterDialogFactory");
        }
        return inlineFilterDialogFactory2;
    }

    @NotNull
    public final InlineFiltersPresenter getInlineFiltersPresenter() {
        InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
        if (inlineFiltersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
        }
        return inlineFiltersPresenter2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final SerpInteractor getInteractor() {
        SerpInteractor serpInteractor2 = this.interactor;
        if (serpInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return serpInteractor2;
    }

    @NotNull
    public final ItemVisibilityTracker getItemVisibilityTracker() {
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        return itemVisibilityTracker2;
    }

    @NotNull
    public final DfpMobileAdsWrapper getMobileAdsWrapper() {
        DfpMobileAdsWrapper dfpMobileAdsWrapper = this.mobileAdsWrapper;
        if (dfpMobileAdsWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileAdsWrapper");
        }
        return dfpMobileAdsWrapper;
    }

    @NotNull
    public final NetworkInfoBroadcastReceiver getNetworkInfoBroadcastReceiver() {
        NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2 = this.networkInfoBroadcastReceiver;
        if (networkInfoBroadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkInfoBroadcastReceiver");
        }
        return networkInfoBroadcastReceiver2;
    }

    @NotNull
    public final NotificationManagerProvider getNotificationManagerProvider() {
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        return notificationManagerProvider2;
    }

    @NotNull
    public final SerpOnboardingHandler getOnboardingHandler() {
        SerpOnboardingHandler serpOnboardingHandler = this.onboardingHandler;
        if (serpOnboardingHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onboardingHandler");
        }
        return serpOnboardingHandler;
    }

    @NotNull
    public final SerpPresenter getPresenter() {
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return serpPresenter;
    }

    @NotNull
    public final SerpResourcesProvider getResourcesProvider() {
        SerpResourcesProvider serpResourcesProvider = this.resourcesProvider;
        if (serpResourcesProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourcesProvider");
        }
        return serpResourcesProvider;
    }

    @NotNull
    public final RichSnippetStateProvider getRichSnippetStateProvider() {
        RichSnippetStateProvider richSnippetStateProvider2 = this.richSnippetStateProvider;
        if (richSnippetStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
        }
        return richSnippetStateProvider2;
    }

    @NotNull
    public final SavedSearchesPresenter getSavedSearchPresenter() {
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        return savedSearchesPresenter;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @NotNull
    public final SerpInteractor getSerpInteractor() {
        SerpInteractor serpInteractor2 = this.serpInteractor;
        if (serpInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpInteractor");
        }
        return serpInteractor2;
    }

    @NotNull
    public final SerpSkeletonTestGroup getSerpSkeletonTestGroup() {
        SerpSkeletonTestGroup serpSkeletonTestGroup2 = this.serpSkeletonTestGroup;
        if (serpSkeletonTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpSkeletonTestGroup");
        }
        return serpSkeletonTestGroup2;
    }

    @NotNull
    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        return spanSizeLookup2;
    }

    @NotNull
    public final FpsStateSupplier getSupplier() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        return fpsStateSupplier;
    }

    @NotNull
    public final SerpTracker getTracker() {
        SerpTracker serpTracker = this.tracker;
        if (serpTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return serpTracker;
    }

    @NotNull
    public final VerticalFilterPresenter getVerticalFilterPresenter() {
        VerticalFilterPresenter verticalFilterPresenter2 = this.verticalFilterPresenter;
        if (verticalFilterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verticalFilterPresenter");
        }
        return verticalFilterPresenter2;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @NotNull
    public final WarningStateProvider getWarningStateProvider() {
        WarningStateProvider warningStateProvider2 = this.warningStateProvider;
        if (warningStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningStateProvider");
        }
        return warningStateProvider2;
    }

    @NotNull
    public final WitcherItemPresenter getWitcherItemPresenter() {
        WitcherItemPresenter witcherItemPresenter2 = this.witcherItemPresenter;
        if (witcherItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("witcherItemPresenter");
        }
        return witcherItemPresenter2;
    }

    @Override // com.avito.android.serp.SerpRouter
    public void leaveScreen() {
        FragmentManager fragmentManager = getFragmentManager();
        if ((fragmentManager != null ? fragmentManager.getBackStackEntryCount() : 0) >= 1) {
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features2.getFiltersWithoutActivity().invoke().booleanValue()) {
                finish();
                return;
            }
            FragmentManager fragmentManager2 = getFragmentManager();
            if (fragmentManager2 != null) {
                fragmentManager2.popBackStackImmediate();
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof UpNavigationHandler) {
            ((UpNavigationHandler) activity).handleUpNavigation();
        } else if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = i2 == -1;
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter.attachRouter(this);
        if (i == 0) {
            SerpPresenter serpPresenter2 = this.presenter;
            if (serpPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            serpPresenter2.onUserAuthorized(z, AuthIntentFactoryKt.getSuccessAuthResultData(intent));
        } else if (i != 1) {
            if (i != 3) {
                super.onActivityResult(i, i2, intent);
            } else if (z) {
                SerpInteractor serpInteractor2 = this.serpInteractor;
                if (serpInteractor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serpInteractor");
                }
                serpInteractor2.restoreState(intent != null ? (Kundle) intent.getParcelableExtra("interactor_state") : null);
            }
        } else if (z && intent != null) {
            DeepLink result = new FilterCommons().getResult(intent);
            SerpPresenter serpPresenter3 = this.presenter;
            if (serpPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            serpPresenter3.onSearchClarified(result);
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter.onBackPressed();
        return false;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        SearchParams searchParams;
        SerpParameters serpParameters;
        Kundle kundle;
        super.onCreate(bundle);
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("serp_store_fragment");
        if (storeFragment == null) {
            getChildFragmentManager().beginTransaction().add(new StoreFragment(), "serp_store_fragment").commit();
        }
        Bundle arguments = getArguments();
        SerpArguments serpArguments = arguments != null ? (SerpArguments) arguments.getParcelable("arguments") : null;
        if (serpArguments != null) {
            SerpArguments serpArguments2 = (bundle == null || (kundle = Bundles.getKundle(bundle, "state")) == null) ? null : (SerpArguments) kundle.getParcelable("state_value");
            if (serpArguments2 != null) {
                serpArguments = serpArguments2;
            }
            Bundle arguments2 = getArguments();
            boolean z = arguments2 != null ? arguments2.getBoolean("KEY_SHOW_JOB_NEARBY_BANNER") : false;
            SerpPresenterState state$serp_release = storeFragment != null ? storeFragment.getState$serp_release() : null;
            Kundle kundle2 = bundle != null ? (Kundle) bundle.getParcelable("interactor_state") : null;
            Bundle bundle2 = bundle != null ? bundle.getBundle("floating_views_presenter_state") : null;
            Kundle kundle3 = bundle != null ? (Kundle) bundle.getParcelable("advert_xl_state") : null;
            Kundle kundle4 = bundle != null ? (Kundle) bundle.getParcelable("advert_rich_state") : null;
            WarningStateProviderState warningStateProviderState = bundle != null ? (WarningStateProviderState) bundle.getParcelable("warning_state_provider_state") : null;
            Kundle kundle5 = bundle != null ? (Kundle) bundle.getParcelable("inline_filters_state") : null;
            Kundle kundle6 = bundle != null ? (Kundle) bundle.getParcelable("state_witcher") : null;
            Bundle bundle3 = bundle != null ? bundle.getBundle("key_item_visibility_tracker_state") : null;
            Kundle kundle7 = bundle != null ? (Kundle) bundle.getParcelable("saved_search_state") : null;
            VerticalFilterState verticalFilterState = bundle != null ? (VerticalFilterState) bundle.getParcelable("vertical_filter_state") : null;
            SerpOnboardingHandlerState serpOnboardingHandlerState = bundle != null ? (SerpOnboardingHandlerState) bundle.getParcelable("serp_onboarding_handler_state") : null;
            Timer B1 = a2.b.a.a.a.B1();
            SerpComponent.Builder screen = DaggerSerpComponent.builder().locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).serpDependencies((SerpDependencies) ComponentDependenciesKt.getDependencies(SerpDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screen(SerpScreen.INSTANCE);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            SerpComponent.Builder withWitcherSavedState = screen.resources(resources).serpArguments(serpArguments).withRichGalleryState(kundle4).withRichSnippetRecycledViewPool(new RecyclerView.RecycledViewPool()).presenterState(state$serp_release).interactorState(kundle2).floatingViewsPresenterState(bundle2).warningStates(warningStateProviderState).withWitcherSavedState(kundle6);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            SerpComponent.Builder showJobNearbyBanner = withWitcherSavedState.fragmentManager(parentFragmentManager).withIsFirstStart(false).withAdvertXlState(kundle3).showJobNearbyBanner(z);
            PublishRelay create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            SerpComponent.Builder snippetClick = showJobNearbyBanner.snippetClick(create);
            PublishRelay create2 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
            SerpComponent.Builder snippetClose = snippetClick.snippetClose(create2);
            PublishRelay create3 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
            SerpComponent.Builder bannerPageSource = snippetClose.snippetVisibility(create3).bannerPageSource(BannerPageSource.SERP);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SerpComponent.Builder withItemVisibilityTrackerState = bannerPageSource.withActivity(requireActivity).withFragment(this).withActivityInteractor(this).withInlineFiltersState(kundle5).withSavedSearchState(kundle7).withItemVisibilityTrackerState(bundle3);
            if (state$serp_release == null || (serpParameters = state$serp_release.getSerpParameters()) == null || (searchParams = serpParameters.getSearchParams()) == null) {
                searchParams = serpArguments.getSearchParams();
            }
            withItemVisibilityTrackerState.withSearchParams(searchParams).withSearchArea(null).withMapSerpState(null).withInteractorState(null).withBubblePresenterState(null).withVerticalFilterState(verticalFilterState).withSerpOnboardingHandlerState(serpOnboardingHandlerState).build().inject(this);
            SerpTracker serpTracker = this.tracker;
            if (serpTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            serpTracker.trackDiInject(B1.elapsed());
            if (state$serp_release == null && bundle != null) {
                SerpAnalyticsInteractor serpAnalyticsInteractor = this.analyticsInteractor;
                if (serpAnalyticsInteractor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
                }
                serpAnalyticsInteractor.sendNotRestoreState();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("arguments was not passed to " + this).toString());
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        SerpTracker serpTracker = this.tracker;
        if (serpTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        serpTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.serp_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(layoutId, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        destroyableViewHolderBuilder2.destroy();
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter.detachView();
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        persistableFloatingViewsPresenter.detachAll();
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.detachViews();
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.detachView();
        ClosedItemPresenter closedItemPresenter2 = this.closedItemPresenter;
        if (closedItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedItemPresenter");
        }
        closedItemPresenter2.detachView();
        InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
        if (inlineFiltersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
        }
        inlineFiltersPresenter2.detachViews();
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        asyncPhonePresenter2.detachView();
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        savedSearchesPresenter.detachView();
        SerpTracker serpTracker = this.tracker;
        if (serpTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        serpTracker.destroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onPause();
        SerpTracker serpTracker = this.tracker;
        if (serpTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        serpTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        fpsStateSupplier.onResume();
        SerpTracker serpTracker = this.tracker;
        if (serpTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        serpTracker.attach();
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter.subscribeToLocationChanges();
        super.onResume();
        SerpPresenter serpPresenter2 = this.presenter;
        if (serpPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter2.onResume();
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        savedSearchesPresenter.setPushEnabled(notificationManagerProvider2.getAreNotificationsEnabled());
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        cartFabViewModel2.loadCartSize();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        SerpArguments serpArguments;
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SerpInteractor serpInteractor2 = this.interactor;
        if (serpInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("interactor_state", serpInteractor2.onSaveState());
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        bundle.putBundle("floating_views_presenter_state", persistableFloatingViewsPresenter.onSaveState());
        InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
        if (inlineFiltersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
        }
        bundle.putParcelable("inline_filters_state", inlineFiltersPresenter2.onSaveState());
        AdvertXlStateProvider advertXlStateProvider2 = this.advertXlStateProvider;
        if (advertXlStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertXlStateProvider");
        }
        bundle.putParcelable("advert_xl_state", advertXlStateProvider2.onSaveState());
        RichSnippetStateProvider richSnippetStateProvider2 = this.richSnippetStateProvider;
        if (richSnippetStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richSnippetStateProvider");
        }
        bundle.putParcelable("advert_rich_state", richSnippetStateProvider2.onSaveState());
        WarningStateProvider warningStateProvider2 = this.warningStateProvider;
        if (warningStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningStateProvider");
        }
        bundle.putParcelable("warning_state_provider_state", warningStateProvider2.onSaveState());
        WitcherItemPresenter witcherItemPresenter2 = this.witcherItemPresenter;
        if (witcherItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("witcherItemPresenter");
        }
        bundle.putParcelable("state_witcher", witcherItemPresenter2.onSaveState());
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getViewVisibilityTrackingInSerp().invoke().booleanValue()) {
            ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
            if (itemVisibilityTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
            }
            bundle.putBundle("key_item_visibility_tracker_state", itemVisibilityTracker2.onSaveState());
        }
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        bundle.putParcelable("saved_search_state", savedSearchesPresenter.onSaveState());
        VerticalFilterPresenter verticalFilterPresenter2 = this.verticalFilterPresenter;
        if (verticalFilterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verticalFilterPresenter");
        }
        bundle.putParcelable("vertical_filter_state", verticalFilterPresenter2.onSaveState());
        SerpOnboardingHandler serpOnboardingHandler = this.onboardingHandler;
        if (serpOnboardingHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onboardingHandler");
        }
        bundle.putParcelable("serp_onboarding_handler_state", serpOnboardingHandler.onSaveState());
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        SerpPresenterState onSaveState = serpPresenter.onSaveState();
        String subscriptionId = onSaveState.getSubscriptionId();
        SerpParameters serpParameters = onSaveState.getSerpParameters();
        SearchParams searchParams = serpParameters != null ? serpParameters.getSearchParams() : null;
        SerpParameters serpParameters2 = onSaveState.getSerpParameters();
        String context = serpParameters2 != null ? serpParameters2.getContext() : null;
        SerpAnalyticsInteractor serpAnalyticsInteractor = this.analyticsInteractor;
        if (serpAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        TreeClickStreamParent parent = serpAnalyticsInteractor.getParent();
        Bundle arguments = getArguments();
        Bundles.putKundle(bundle, "state", new Kundle().putParcelable("state_value", new SerpArguments(subscriptionId, searchParams, context, parent, (arguments == null || (serpArguments = (SerpArguments) arguments.getParcelable("arguments")) == null) ? null : serpArguments.getFromPage(), false, 32, null)));
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("serp_store_fragment");
        if (storeFragment != null) {
            SerpPresenter serpPresenter2 = this.presenter;
            if (serpPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            storeFragment.setState$serp_release(serpPresenter2.onSaveState());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FragmentActivity requireActivity = requireActivity();
        NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2 = this.networkInfoBroadcastReceiver;
        if (networkInfoBroadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkInfoBroadcastReceiver");
        }
        requireActivity.registerReceiver(networkInfoBroadcastReceiver2, NetworkInfoBroadcastReceiverKt.createNetworkInfoBroadcastReceiverIntentFilter());
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter.detachRouter();
        SerpPresenter serpPresenter2 = this.presenter;
        if (serpPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter2.onStop();
        FragmentActivity requireActivity = requireActivity();
        NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2 = this.networkInfoBroadcastReceiver;
        if (networkInfoBroadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkInfoBroadcastReceiver");
        }
        requireActivity.unregisterReceiver(networkInfoBroadcastReceiver2);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        CartFabView cartFabView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getCartFloatingActionButton().invoke().booleanValue()) {
            View inflate = ((ViewStub) view.findViewById(R.id.cart_fab_stub)).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
            CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
            if (cartFabViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
            }
            CartQuantityChangesHandler cartQuantityChangesHandler = this.cartFabQuantityHandler;
            if (cartQuantityChangesHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartFabQuantityHandler");
            }
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            cartFabView = new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory2);
        } else {
            cartFabView = null;
        }
        SerpPresenter serpPresenter = this.presenter;
        if (serpPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SpannedGridPositionProvider spannedGridPositionProvider = this.gridPositionProvider;
        if (spannedGridPositionProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridPositionProvider");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup2 = this.spanSizeLookup;
        if (spanSizeLookup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanSizeLookup");
        }
        SerpInteractor serpInteractor2 = this.serpInteractor;
        if (serpInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpInteractor");
        }
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        SerpResourcesProvider serpResourcesProvider = this.resourcesProvider;
        if (serpResourcesProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourcesProvider");
        }
        InlineFilterDialogFactory inlineFilterDialogFactory2 = this.inlineFilterDialogFactory;
        if (inlineFilterDialogFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFilterDialogFactory");
        }
        a aVar = new a(this);
        ItemVisibilityTracker itemVisibilityTracker2 = this.itemVisibilityTracker;
        if (itemVisibilityTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemVisibilityTracker");
        }
        Features features3 = this.features;
        if (features3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        FpsStateSupplier fpsStateSupplier = this.supplier;
        if (fpsStateSupplier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplier");
        }
        SerpSkeletonTestGroup serpSkeletonTestGroup2 = this.serpSkeletonTestGroup;
        if (serpSkeletonTestGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serpSkeletonTestGroup");
        }
        boolean isTest = serpSkeletonTestGroup2.isTest();
        SerpOnboardingHandler serpOnboardingHandler = this.onboardingHandler;
        if (serpOnboardingHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onboardingHandler");
        }
        SerpViewImpl serpViewImpl = new SerpViewImpl(view, serpPresenter, destroyableViewHolderBuilder2, adapterPresenter2, spannedGridPositionProvider, analytics2, buildInfo2, schedulersFactory3, spanSizeLookup2, persistableFloatingViewsPresenter, serpInteractor2, serpResourcesProvider, aVar, inlineFilterDialogFactory2, itemVisibilityTracker2, features3, fpsStateSupplier, isTest, serpOnboardingHandler, cartFabView);
        this.j.setValue((Fragment) this, k[0], (KProperty<?>) serpViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter2 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter2.attachView(serpViewImpl);
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.attachView(serpViewImpl);
        ClosedItemPresenter closedItemPresenter2 = this.closedItemPresenter;
        if (closedItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedItemPresenter");
        }
        closedItemPresenter2.attachView(serpViewImpl);
        FavoriteAdvertsPresenter favoriteAdvertsPresenter3 = this.favoriteAdvertsPresenter;
        if (favoriteAdvertsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteAdvertsPresenter");
        }
        favoriteAdvertsPresenter3.attachErrorMessageView(serpViewImpl);
        SerpPresenter serpPresenter2 = this.presenter;
        if (serpPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        serpPresenter2.attachView(serpViewImpl, serpViewImpl.getRetryView());
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter2 = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        persistableFloatingViewsPresenter2.attachSubscriber(serpViewImpl);
        PersistableFloatingViewsPresenter persistableFloatingViewsPresenter3 = this.floatingViewsPresenter;
        if (persistableFloatingViewsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        SerpPresenter serpPresenter3 = this.presenter;
        if (serpPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        persistableFloatingViewsPresenter3.attachAppendingListener(serpPresenter3);
        InlineFiltersPresenter inlineFiltersPresenter2 = this.inlineFiltersPresenter;
        if (inlineFiltersPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inlineFiltersPresenter");
        }
        inlineFiltersPresenter2.attachViews(serpViewImpl, serpViewImpl, serpViewImpl.getSearchBar());
        AsyncPhonePresenter asyncPhonePresenter2 = this.asyncPhonePresenter;
        if (asyncPhonePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("asyncPhonePresenter");
        }
        asyncPhonePresenter2.attachView(serpViewImpl);
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        savedSearchesPresenter.attachView(serpViewImpl, notificationManagerProvider2.getAreNotificationsEnabled());
        VerticalFilterPresenter verticalFilterPresenter2 = this.verticalFilterPresenter;
        if (verticalFilterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verticalFilterPresenter");
        }
        verticalFilterPresenter2.attachDialogOpener(serpViewImpl);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getWindow().setBackgroundDrawable(null);
        SerpTracker serpTracker = this.tracker;
        if (serpTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        serpTracker.trackInit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        NavigationTab currentTab = currentTab();
        if (currentTab != null) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof OnAddButtonStateChangeListener)) {
                activity = null;
            }
            OnAddButtonStateChangeListener onAddButtonStateChangeListener = (OnAddButtonStateChangeListener) activity;
            if (onAddButtonStateChangeListener != null) {
                onAddButtonStateChangeListener.onAddButtonStateChange(currentTab, AddButtonState.SMALL);
            }
        }
    }

    @Override // com.avito.android.serp.SerpRouter
    public void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.advertDetailsIntent(str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), num, currentTab(), ScreenSource.SERP.INSTANCE));
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebugRouter
    public void openDebugMenu(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        DfpMobileAdsWrapper dfpMobileAdsWrapper = this.mobileAdsWrapper;
        if (dfpMobileAdsWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileAdsWrapper");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        dfpMobileAdsWrapper.openDfpDebugMenu(requireContext, str);
    }

    @Override // com.avito.android.serp.SerpRouter
    public void openMessenger(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(MessengerIntentFactory.DefaultImpls.channelIntent$default(activityIntentFactory, str, null, null, null, false, 30, null));
    }

    @Override // com.avito.android.serp.SerpRouter
    public void openSerpWithBackstack(@NotNull SearchParams searchParams, @Nullable String str, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, new Factory().createFragment(new SerpArguments(null, searchParams, str, treeClickStreamParent, null, false, 49, null), z)).commitAllowingStateLoss();
        getParentFragmentManager().executePendingTransactions();
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAdvertXlStateProvider(@NotNull AdvertXlStateProvider advertXlStateProvider2) {
        Intrinsics.checkNotNullParameter(advertXlStateProvider2, "<set-?>");
        this.advertXlStateProvider = advertXlStateProvider2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsInteractor(@NotNull SerpAnalyticsInteractor serpAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(serpAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = serpAnalyticsInteractor;
    }

    public final void setAsyncPhonePresenter(@NotNull AsyncPhonePresenter asyncPhonePresenter2) {
        Intrinsics.checkNotNullParameter(asyncPhonePresenter2, "<set-?>");
        this.asyncPhonePresenter = asyncPhonePresenter2;
    }

    public final void setBuildInfo(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "<set-?>");
        this.buildInfo = buildInfo2;
    }

    public final void setCartFabQuantityHandler$serp_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartFabQuantityHandler = cartQuantityChangesHandler;
    }

    public final void setCartFabViewModel$serp_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setClosedItemPresenter(@NotNull ClosedItemPresenter closedItemPresenter2) {
        Intrinsics.checkNotNullParameter(closedItemPresenter2, "<set-?>");
        this.closedItemPresenter = closedItemPresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDestroyableViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder2) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder2, "<set-?>");
        this.destroyableViewHolderBuilder = destroyableViewHolderBuilder2;
    }

    public final void setFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter2, "<set-?>");
        this.favoriteAdvertsPresenter = favoriteAdvertsPresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setFloatingViewsPresenter(@NotNull PersistableFloatingViewsPresenter persistableFloatingViewsPresenter) {
        Intrinsics.checkNotNullParameter(persistableFloatingViewsPresenter, "<set-?>");
        this.floatingViewsPresenter = persistableFloatingViewsPresenter;
    }

    public final void setGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "<set-?>");
        this.gridPositionProvider = spannedGridPositionProvider;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setInlineFilterDialogFactory(@NotNull InlineFilterDialogFactory inlineFilterDialogFactory2) {
        Intrinsics.checkNotNullParameter(inlineFilterDialogFactory2, "<set-?>");
        this.inlineFilterDialogFactory = inlineFilterDialogFactory2;
    }

    public final void setInlineFiltersPresenter(@NotNull InlineFiltersPresenter inlineFiltersPresenter2) {
        Intrinsics.checkNotNullParameter(inlineFiltersPresenter2, "<set-?>");
        this.inlineFiltersPresenter = inlineFiltersPresenter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull SerpInteractor serpInteractor2) {
        Intrinsics.checkNotNullParameter(serpInteractor2, "<set-?>");
        this.interactor = serpInteractor2;
    }

    public final void setItemVisibilityTracker(@NotNull ItemVisibilityTracker itemVisibilityTracker2) {
        Intrinsics.checkNotNullParameter(itemVisibilityTracker2, "<set-?>");
        this.itemVisibilityTracker = itemVisibilityTracker2;
    }

    public final void setMobileAdsWrapper(@NotNull DfpMobileAdsWrapper dfpMobileAdsWrapper) {
        Intrinsics.checkNotNullParameter(dfpMobileAdsWrapper, "<set-?>");
        this.mobileAdsWrapper = dfpMobileAdsWrapper;
    }

    public final void setNetworkInfoBroadcastReceiver(@NotNull NetworkInfoBroadcastReceiver networkInfoBroadcastReceiver2) {
        Intrinsics.checkNotNullParameter(networkInfoBroadcastReceiver2, "<set-?>");
        this.networkInfoBroadcastReceiver = networkInfoBroadcastReceiver2;
    }

    public final void setNotificationManagerProvider(@NotNull NotificationManagerProvider notificationManagerProvider2) {
        Intrinsics.checkNotNullParameter(notificationManagerProvider2, "<set-?>");
        this.notificationManagerProvider = notificationManagerProvider2;
    }

    public final void setOnboardingHandler(@NotNull SerpOnboardingHandler serpOnboardingHandler) {
        Intrinsics.checkNotNullParameter(serpOnboardingHandler, "<set-?>");
        this.onboardingHandler = serpOnboardingHandler;
    }

    public final void setPresenter(@NotNull SerpPresenter serpPresenter) {
        Intrinsics.checkNotNullParameter(serpPresenter, "<set-?>");
        this.presenter = serpPresenter;
    }

    public final void setResourcesProvider(@NotNull SerpResourcesProvider serpResourcesProvider) {
        Intrinsics.checkNotNullParameter(serpResourcesProvider, "<set-?>");
        this.resourcesProvider = serpResourcesProvider;
    }

    public final void setRichSnippetStateProvider(@NotNull RichSnippetStateProvider richSnippetStateProvider2) {
        Intrinsics.checkNotNullParameter(richSnippetStateProvider2, "<set-?>");
        this.richSnippetStateProvider = richSnippetStateProvider2;
    }

    public final void setSavedSearchPresenter(@NotNull SavedSearchesPresenter savedSearchesPresenter) {
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "<set-?>");
        this.savedSearchPresenter = savedSearchesPresenter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    public final void setSerpInteractor(@NotNull SerpInteractor serpInteractor2) {
        Intrinsics.checkNotNullParameter(serpInteractor2, "<set-?>");
        this.serpInteractor = serpInteractor2;
    }

    public final void setSerpSkeletonTestGroup(@NotNull SerpSkeletonTestGroup serpSkeletonTestGroup2) {
        Intrinsics.checkNotNullParameter(serpSkeletonTestGroup2, "<set-?>");
        this.serpSkeletonTestGroup = serpSkeletonTestGroup2;
    }

    public final void setSpanSizeLookup(@NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup2) {
        Intrinsics.checkNotNullParameter(spanSizeLookup2, "<set-?>");
        this.spanSizeLookup = spanSizeLookup2;
    }

    public final void setSupplier(@NotNull FpsStateSupplier fpsStateSupplier) {
        Intrinsics.checkNotNullParameter(fpsStateSupplier, "<set-?>");
        this.supplier = fpsStateSupplier;
    }

    public final void setTracker(@NotNull SerpTracker serpTracker) {
        Intrinsics.checkNotNullParameter(serpTracker, "<set-?>");
        this.tracker = serpTracker;
    }

    public final void setVerticalFilterPresenter(@NotNull VerticalFilterPresenter verticalFilterPresenter2) {
        Intrinsics.checkNotNullParameter(verticalFilterPresenter2, "<set-?>");
        this.verticalFilterPresenter = verticalFilterPresenter2;
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }

    public final void setWarningStateProvider(@NotNull WarningStateProvider warningStateProvider2) {
        Intrinsics.checkNotNullParameter(warningStateProvider2, "<set-?>");
        this.warningStateProvider = warningStateProvider2;
    }

    public final void setWitcherItemPresenter(@NotNull WitcherItemPresenter witcherItemPresenter2) {
        Intrinsics.checkNotNullParameter(witcherItemPresenter2, "<set-?>");
        this.witcherItemPresenter = witcherItemPresenter2;
    }

    @Override // com.avito.android.serp.SerpRouter
    public void showAuth(@NotNull String str, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(str, "src");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, str, parcelable, 1, null), 0);
    }

    @Override // com.avito.android.serp.SerpRouter
    public void showClarifyScreen(@NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent searchIntent$default = FiltersIntentFactory.DefaultImpls.searchIntent$default(activityIntentFactory, searchParams, searchParams.getArea(), null, false, null, currentTab(), false, 92, null);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getFiltersWithoutActivity().invoke().booleanValue() || (getActivity() instanceof SerpActivity)) {
            startActivityForResult(searchIntent$default, 1);
        } else {
            startForResult(searchIntent$default, 1);
        }
    }

    @Override // com.avito.android.serp.SerpRouter
    public void showNotificationSettingsScreen() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.serp.SerpRouter
    public void followDeepLink(@NotNull DeepLink deepLink, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            Intents.putTreeAnalyticsParent(intent, treeClickStreamParent);
            IntentsKt.replaceTargetTabIfRequired(intent, currentTab());
            startActivity(intent);
        }
    }
}
