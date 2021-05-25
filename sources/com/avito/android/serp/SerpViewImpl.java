package com.avito.android.serp;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhoneView;
import com.avito.android.async_phone.AsyncPhoneViewImpl;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.component.search.SearchBar;
import com.avito.android.component.search.SearchBarImpl;
import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.design.widget.search_view.SubscriptionButtonState;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.floating_views.ScrollHandler;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpener;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpenerImpl;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lastclick.LastClick;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchViewImpl;
import com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandlerImpl;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingTooltipEventsProducer;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetItemDecorator;
import com.avito.android.serp.adapter.skeleton.ScrollGridLayoutManager;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterItemDecorator;
import com.avito.android.serp.adapter.witcher.WitcherItemDecorator;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.adapter.GridLayoutAppendingAdapter;
import com.avito.android.ui.adapter.GridLayoutNoLoaderAppendingHandler;
import com.avito.android.ui.view.retry.RetryView;
import com.avito.android.ui.view.retry.RetryViewBuilder;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Snackbars;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BÞ\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010æ\u0001\u0012\b\u0010ª\u0001\u001a\u00030§\u0001\u0012\b\u0010à\u0001\u001a\u00030Ý\u0001\u0012\b\u0010º\u0001\u001a\u00030·\u0001\u0012\b\u0010Ú\u0001\u001a\u00030×\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0'\u0012\b\u0010\u0002\u001a\u00030ÿ\u0001\u0012\b\u0010î\u0001\u001a\u00030ë\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010®\u0001\u001a\u00030«\u0001\u0012\u0007\u0010½\u0001\u001a\u00020\u0007\u0012\b\u0010Ñ\u0001\u001a\u00030Î\u0001\u0012\n\u0010£\u0001\u001a\u0005\u0018\u00010 \u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u000bJ\u0017\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u000bJ3\u0010*\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0'H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010\u0013J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010\u0013J\u000f\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010\u0013J\u000f\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u0010\u0013J\u000f\u00101\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u0010\u0013J-\u00105\u001a\u00020\t2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0'H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001fH\u0016¢\u0006\u0004\b8\u0010\"J\u000f\u00109\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010\u0013J\u000f\u0010:\u001a\u00020\tH\u0016¢\u0006\u0004\b:\u0010\u0013J\u000f\u0010;\u001a\u00020\tH\u0016¢\u0006\u0004\b;\u0010\u0013J\u000f\u0010<\u001a\u00020\tH\u0016¢\u0006\u0004\b<\u0010\u0013J\u000f\u0010=\u001a\u00020\tH\u0016¢\u0006\u0004\b=\u0010\u0013J\u0017\u0010>\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b>\u0010?J'\u0010B\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0016¢\u0006\u0004\bB\u0010CJ'\u0010D\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0016¢\u0006\u0004\bD\u0010CJ'\u0010G\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010CJ\u0017\u0010I\u001a\u00020\t2\u0006\u0010H\u001a\u00020\fH\u0016¢\u0006\u0004\bI\u0010\u000fJ\u0017\u0010J\u001a\u00020\t2\u0006\u0010H\u001a\u00020\fH\u0016¢\u0006\u0004\bJ\u0010\u000fJ\u0017\u0010K\u001a\u00020\t2\u0006\u0010H\u001a\u00020\fH\u0016¢\u0006\u0004\bK\u0010\u000fJ\u0017\u0010L\u001a\u00020\t2\u0006\u0010A\u001a\u00020\fH\u0016¢\u0006\u0004\bL\u0010\u000fJ\u0017\u0010M\u001a\u00020\t2\u0006\u00102\u001a\u00020\u001fH\u0016¢\u0006\u0004\bM\u0010\"J\u000f\u0010N\u001a\u00020\tH\u0016¢\u0006\u0004\bN\u0010\u0013J\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010\u000bJ\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0QH\u0001¢\u0006\u0004\bR\u0010SJ \u0010U\u001a\u00020\t2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0001¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020\tH\u0001¢\u0006\u0004\bW\u0010\u0013J\u0010\u0010X\u001a\u00020\tH\u0001¢\u0006\u0004\bX\u0010\u0013J\u001a\u0010Z\u001a\u00020\t2\b\b\u0001\u0010Y\u001a\u00020\fH\u0001¢\u0006\u0004\bZ\u0010\u000fJ\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0QH\u0001¢\u0006\u0004\b\\\u0010SJ\u0010\u0010]\u001a\u00020\tH\u0001¢\u0006\u0004\b]\u0010\u0013J(\u0010c\u001a\u00020\t2\b\u0010_\u001a\u0004\u0018\u00010^2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`H\u0001¢\u0006\u0004\bc\u0010dJ<\u0010h\u001a\u00020\t2\b\u0010e\u001a\u0004\u0018\u00010\u001f2\b\u0010f\u001a\u0004\u0018\u00010[2\b\u0010g\u001a\u0004\u0018\u00010\f2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`H\u0001¢\u0006\u0004\bh\u0010iJ(\u0010l\u001a\u00020\t2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020j0`2\b\b\u0002\u0010k\u001a\u00020\u0007H\u0001¢\u0006\u0004\bl\u0010mJ\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020a0QH\u0001¢\u0006\u0004\bn\u0010SJ\u0010\u0010o\u001a\u00020\tH\u0001¢\u0006\u0004\bo\u0010\u0013J\u0010\u0010p\u001a\u00020\tH\u0001¢\u0006\u0004\bp\u0010\u0013J\u0012\u0010r\u001a\u0004\u0018\u00010qH\u0001¢\u0006\u0004\br\u0010sJs\u0010T\u001a\u00020\t2\u0006\u0010u\u001a\u00020t2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020v0`2\b\u0010x\u001a\u0004\u0018\u00010q2!\u0010~\u001a\u001d\u0012\u0013\u0012\u00110z¢\u0006\f\b{\u0012\b\b|\u0012\u0004\b\b(}\u0012\u0004\u0012\u00020\t0y2\f\u0010\u001a\b\u0012\u0004\u0012\u00020\t0'2\u000f\b\u0002\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0'H\u0001¢\u0006\u0005\bT\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0005\b\u0001\u0010\u0013J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0QH\u0001¢\u0006\u0005\b\u0001\u0010SJ\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0QH\u0001¢\u0006\u0005\b\u0001\u0010SJ\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0QH\u0001¢\u0006\u0005\b\u0001\u0010SJ\u0012\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0005\b\u0001\u0010\u0013J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0QH\u0001¢\u0006\u0005\b\u0001\u0010SJ\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\f0QH\u0001¢\u0006\u0005\b\u0001\u0010SJ\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0QH\u0001¢\u0006\u0005\b\u0001\u0010SJ1\u0010T\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0001\u001a\u00020\u0007H\u0001¢\u0006\u0005\bT\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0005\b\u0001\u0010\u0013J\u001a\u0010\u0001\u001a\u00020\t2\u0006\u00102\u001a\u00020\u001fH\u0001¢\u0006\u0005\b\u0001\u0010\"J\u0012\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0005\b\u0001\u0010\u0013J\u0012\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0005\b\u0001\u0010\u0013J\u0012\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0005\b\u0001\u0010\u0013J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020[0QH\u0001¢\u0006\u0005\b\u0001\u0010SR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u00107\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010¦\u0001\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001a\u0010ª\u0001\u001a\u00030§\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010®\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010­\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010º\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010½\u0001\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010¾\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\n\u0010\u0001R\u001a\u0010Â\u0001\u001a\u00030¿\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001a\u0010Æ\u0001\u001a\u00030Ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0019\u0010É\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010È\u0001R#\u0010Í\u0001\u001a\r Ë\u0001*\u0005\u0018\u00010Ê\u00010Ê\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0012\u0010Ì\u0001R\u001a\u0010Ñ\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R!\u0010Ö\u0001\u001a\u00030Ò\u00018\u0016@\u0016X\u0004¢\u0006\u000f\n\u0005\b\u0017\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u001a\u0010Ú\u0001\u001a\u00030×\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010Ü\u0001\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010¥\u0001R\u001a\u0010à\u0001\u001a\u00030Ý\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u001c\u0010ä\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0019\u0010å\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010\u0001R!\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010æ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001a\u0010î\u0001\u001a\u00030ë\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001f\u0010ô\u0001\u001a\u00030ï\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010ø\u0001\u001a\u00030õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001a\u0010ü\u0001\u001a\u00030ù\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u0019\u0010þ\u0001\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bý\u0001\u0010¥\u0001R\u001a\u0010\u0002\u001a\u00030ÿ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0'8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010¥\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/serp/SerpViewImpl;", "Lcom/avito/android/serp/SerpView;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "Lcom/avito/android/async_phone/AsyncPhoneView;", "Lcom/avito/android/saved_searches/SavedSearchView;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingTooltipEventsProducer;", "", "withShortcuts", "", "e", "(Z)V", "", "paddingTop", "c", "(I)V", "refreshOffset", "d", AuthSource.BOOKING_ORDER, "()V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/ui/adapter/AppendingListener;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "resetScrollingToTop", "showProgress", "", "error", "showError", "(Ljava/lang/String;)V", "animate", "showFloatingViews", "hideFloatingViews", "phoneNumber", "Lkotlin/Function0;", "okHandler", "cancelHandler", "showCallDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Z", "setSubscriptionSwitchedOn", "setSubscriptionSwitchedOff", "setSubscriptionSwitchedLoading", "showNewSearchEmptyView", "showSavedSearchEmptyView", "hideEmptyView", "message", "action", "actionListener", "showMessageWithAction", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "hint", "setSearchHint", "setSearchHintSearch", "showDefaultNavigationIcon", "destroy", "hideShortcutsWithShift", "showShortcutsWithShift", "onDataChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "startPosition", "count", "onDataRangeChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;II)V", "onDataAppended", "positionStart", "itemCount", "onRemoveItemRange", VKApiConst.POSITION, "onRemoveItem", "onItemChanged", "notifyItemAtPositionChanged", "setColumnsCount", "showToastMessage", "enableScroll", "visible", "setCartFabVisible", "Lio/reactivex/rxjava3/core/Observable;", "allCategoriesClicks", "()Lio/reactivex/rxjava3/core/Observable;", "show", "animateShortcutBar", "(ZZ)V", "hideShortcutBar", "hideSkeleton", "color", "overrideVisibleBackground", "Lcom/avito/android/deep_linking/links/DeepLink;", "resetActionClicks", "resetShortcutBarPosition", "Lcom/avito/android/remote/model/Shortcuts$Header;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "items", "setShortcutItems", "(Lcom/avito/android/remote/model/Shortcuts$Header;Ljava/util/List;)V", "headerTitle", "resetAction", "searchResultCount", "setShortcutNavigationBarItems", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;Ljava/util/List;)V", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "withText", "setSkeleton", "(Ljava/util/List;Z)V", "shortcutClicks", "showShortcutBar", "dismiss", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/search/Filter;", "filter", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "filterSetListener", "filterCloseListener", "closeButtonListener", "(Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dismissPhoneLoadError", "showPhoneLoadError", "applyAction", "closeAction", "closeDialog", "deleteAction", "frequencyChangedAction", "openSettingsAction", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "selectedId", "pushEnabled", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;Ljava/lang/Integer;Z)V", "showErrorMessage", "showMessage", "showSubscriptionEditedMessage", "showSubscriptionMessage", "showUnsubscriptionMessage", "tooltipDetailsLinkClicks", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "Lcom/avito/android/serp/SerpViewPresenter;", "u", "Lcom/avito/android/serp/SerpViewPresenter;", "presenter", "Lcom/avito/android/cart_fab/CartFabView;", "H", "Lcom/avito/android/cart_fab/CartFabView;", "cartFabView", "o", "I", "pullRefreshOffsetEnd", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "w", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", ExifInterface.LONGITUDE_EAST, "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "p", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "k", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "scrollListener", "Lcom/avito/android/analytics/Analytics;", "y", "Lcom/avito/android/analytics/Analytics;", "analytics", "F", "Z", "isSkeleton", "shortcutsContainer", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "overlayContainer", "Lcom/avito/android/serp/adapter/skeleton/ScrollGridLayoutManager;", "i", "Lcom/avito/android/serp/adapter/skeleton/ScrollGridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "G", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/component/search/SearchBar;", "Lcom/avito/android/component/search/SearchBar;", "getSearchBar", "()Lcom/avito/android/component/search/SearchBar;", "searchBar", "Lcom/avito/android/util/BuildInfo;", "z", "Lcom/avito/android/util/BuildInfo;", "buildInfo", AuthSource.OPEN_CHANNEL_LIST, "serpTopPadding", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "x", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Landroidx/appcompat/app/AlertDialog;", VKApiConst.Q, "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "emptyView", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", VKApiConst.VERSION, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "C", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/ui/view/retry/RetryView;", "r", "Lcom/avito/android/ui/view/retry/RetryView;", "getRetryView", "()Lcom/avito/android/ui/view/retry/RetryView;", "retryView", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "j", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "itemsScrollListener", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "s", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "n", "pullRefreshOffsetStart", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "B", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "inlineFilterDialogFactory", "Lcom/avito/android/progress_overlay/ProgressOverlay;", g.a, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/Features;", "D", "Lcom/avito/android/Features;", "features", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/jvm/functions/Function0;", "onRefreshListener", "l", "emptyShortcutsPadding", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/floating_views/ScrollHandler$Listener;", "scrollHandlerListener", "Lcom/avito/android/component/search/SuggestInteractor;", "suggestInteractor", "Lcom/avito/android/serp/SerpResourcesProvider;", "resourcesProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/serp/SerpViewPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/util/SchedulersFactory3;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/floating_views/ScrollHandler$Listener;Lcom/avito/android/component/search/SuggestInteractor;Lcom/avito/android/serp/SerpResourcesProvider;Lkotlin/jvm/functions/Function0;Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/Features;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;ZLcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;Lcom/avito/android/cart_fab/CartFabView;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpViewImpl implements SerpView, ShortcutNavigationBar, InlineFilterDialogOpener, AsyncPhoneView, SavedSearchView, SerpOnboardingTooltipEventsProducer {
    public final Function0<Unit> A;
    public final InlineFilterDialogFactory B;
    public final ItemVisibilityTracker C;
    public final Features D;
    public final RecyclerView.OnScrollListener E;
    public final boolean F;
    public final SerpOnboardingHandler G;
    public final CartFabView H;
    public final /* synthetic */ ShortcutNavigationBarImpl I;
    public final /* synthetic */ InlineFilterDialogOpenerImpl J;
    public final /* synthetic */ AsyncPhoneViewImpl K;
    public final /* synthetic */ SavedSearchViewImpl L;
    @NotNull
    public final SearchBar a;
    public final Resources b;
    public final View c;
    public final RecyclerView d;
    public final View e;
    public final ViewGroup f;
    public final ProgressOverlay g;
    public final TextView h;
    public final ScrollGridLayoutManager i;
    public final SnippetScrollDepthRecyclerViewScrollHandlerImpl j;
    public final RecyclerViewScrollHandler k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final SwipeRefreshLayout p;
    public AlertDialog q;
    @NotNull
    public final RetryView r;
    public final CompositeDisposable s;
    public final View t;
    public final SerpViewPresenter u;
    public final ViewHolderBuilder<BaseViewHolder> v;
    public final AdapterPresenter w;
    public final SpannedGridPositionProvider x;
    public final Analytics y;
    public final BuildInfo z;

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ SerpViewImpl a;

        public a(SerpViewImpl serpViewImpl) {
            this.a = serpViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.A.invoke();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SerpViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SerpViewImpl serpViewImpl) {
            super(0);
            this.a = serpViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.u.retryLoading();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ SerpViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SerpViewImpl serpViewImpl) {
            super(1);
            this.a = serpViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            SerpViewImpl.access$onMenu(this.a, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            this.a.invoke();
        }
    }

    public static final class e implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Function0 a;

        public e(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.invoke();
        }
    }

    public static final class f extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ SerpViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SerpViewImpl serpViewImpl) {
            super(1);
            this.a = serpViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            this.a.u.onUpPressed();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r32v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public SerpViewImpl(@NotNull View view, @NotNull SerpViewPresenter serpViewPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull AdapterPresenter adapterPresenter, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull ScrollHandler.Listener listener, @NotNull SuggestInteractor suggestInteractor, @NotNull SerpResourcesProvider serpResourcesProvider, @NotNull Function0<Unit> function0, @NotNull InlineFilterDialogFactory inlineFilterDialogFactory, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull Features features, @NotNull RecyclerView.OnScrollListener onScrollListener, boolean z2, @NotNull SerpOnboardingHandler serpOnboardingHandler, @Nullable CartFabView cartFabView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(serpViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(listener, "scrollHandlerListener");
        Intrinsics.checkNotNullParameter(suggestInteractor, "suggestInteractor");
        Intrinsics.checkNotNullParameter(serpResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(function0, "onRefreshListener");
        Intrinsics.checkNotNullParameter(inlineFilterDialogFactory, "inlineFilterDialogFactory");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(onScrollListener, "fpsListener");
        Intrinsics.checkNotNullParameter(serpOnboardingHandler, "onboardingHandler");
        int i2 = R.id.shortcuts_container;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.I = new ShortcutNavigationBarImpl(findViewById, null, null, features.getLoadFontsFromAssets().invoke().booleanValue(), 6, null);
        this.J = new InlineFilterDialogOpenerImpl(inlineFilterDialogFactory);
        this.K = new AsyncPhoneViewImpl(view);
        this.L = new SavedSearchViewImpl(view);
        this.t = view;
        this.u = serpViewPresenter;
        this.v = viewHolderBuilder;
        this.w = adapterPresenter;
        this.x = spannedGridPositionProvider;
        this.y = analytics;
        this.z = buildInfo;
        this.A = function0;
        this.B = inlineFilterDialogFactory;
        this.C = itemVisibilityTracker;
        this.D = features;
        this.E = onScrollListener;
        this.F = z2;
        this.G = serpOnboardingHandler;
        this.H = cartFabView;
        View findViewById2 = view.findViewById(R.id.toolbar_search);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.a = new SearchBarImpl(findViewById2, schedulersFactory3, suggestInteractor);
        Resources resources = view.getResources();
        this.b = resources;
        View findViewById3 = view.findViewById(16908292);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(android.R.id.empty)");
        this.c = findViewById3;
        int i3 = R.id.recycler_view;
        View findViewById4 = view.findViewById(i3);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.d = recyclerView;
        View findViewById5 = view.findViewById(i2);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById5;
        int i4 = R.id.progress_overlay_container;
        View findViewById6 = view.findViewById(i4);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f = (ViewGroup) findViewById6;
        View findViewById7 = view.findViewById(R.id.hint);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById7;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ScrollGridLayoutManager scrollGridLayoutManager = new ScrollGridLayoutManager(context, serpResourcesProvider.getColumnsCount());
        this.i = scrollGridLayoutManager;
        SnippetScrollDepthRecyclerViewScrollHandlerImpl snippetScrollDepthRecyclerViewScrollHandlerImpl = new SnippetScrollDepthRecyclerViewScrollHandlerImpl(serpViewPresenter, scrollGridLayoutManager);
        this.j = snippetScrollDepthRecyclerViewScrollHandlerImpl;
        RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(listener, scrollGridLayoutManager);
        this.k = recyclerViewScrollHandler;
        SerpDisplayType serpDisplayType = SerpDisplayType.Grid;
        this.l = resources.getDimensionPixelSize(R.dimen.toolbar_search_view_height);
        this.m = resources.getDimensionPixelSize(R.dimen.serp_top_padding);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.pull_refresh_offset_start);
        this.n = dimensionPixelSize;
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.pull_refresh_offset_end);
        this.o = dimensionPixelSize2;
        View findViewById8 = view.findViewById(R.id.pull_refresh_layout);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById8;
        this.p = swipeRefreshLayout;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.s = compositeDisposable;
        recyclerView.addOnScrollListener(onScrollListener);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        int colorCompat = Contexts.getColorCompat(context2, com.avito.android.lib.design.avito.R.color.expected_background);
        View findViewById9 = view.findViewById(i4);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById9, i3, analytics, false, colorCompat, 8, null);
        this.g = progressOverlay;
        this.r = new RetryViewBuilder(new b(this)).withOverlay(progressOverlay).withSwipeRefresh(swipeRefreshLayout).build();
        progressOverlay.setToolbarPadding();
        recyclerView.setLayoutManager(scrollGridLayoutManager);
        if (features.getSnippetScrollDepthListener().invoke().booleanValue()) {
            recyclerView.addOnScrollListener(snippetScrollDepthRecyclerViewScrollHandlerImpl);
        }
        recyclerView.addOnScrollListener(recyclerViewScrollHandler);
        recyclerView.setItemAnimator(null);
        Context context3 = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "recycler.context");
        recyclerView.addItemDecoration(new RichSnippetItemDecorator(context3, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        recyclerView.addItemDecoration(new WitcherItemDecorator(resources));
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        recyclerView.addItemDecoration(new VerticalFilterItemDecorator(resources));
        if (features.getCartFloatingActionButton().invoke().booleanValue()) {
            Views.changePadding$default(recyclerView, 0, 0, 0, resources.getDimensionPixelSize(com.avito.android.cart_fab.R.dimen.cart_bottom_space_for_list), 7, null);
            recyclerView.setClipToPadding(false);
        }
        serpOnboardingHandler.bindSerpRecyclerView(recyclerView);
        scrollGridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        swipeRefreshLayout.setProgressViewOffset(true, dimensionPixelSize, dimensionPixelSize2);
        Context context4 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context4);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context5 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setOnRefreshListener(new a(this));
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(getSearchBar().menuCallbacks(), new c(this)));
        recyclerView.getContext().obtainStyledAttributes(new TypedValue().data, new int[]{androidx.appcompat.R.attr.actionBarSize}).recycle();
        setDisplayType(serpDisplayType);
        getSearchBar().setMenu(R.menu.item_list_custom_clarify);
        SearchBar.DefaultImpls.replaceMenuItemIcon$default(getSearchBar(), R.id.menu_subscription, R.drawable.ic_save_search_24, false, false, 8, null);
    }

    public static final void access$onMenu(SerpViewImpl serpViewImpl, int i2) {
        Objects.requireNonNull(serpViewImpl);
        if (i2 == R.id.menu_subscription) {
            serpViewImpl.u.onSearchSubscriptionToggled();
        } else if (i2 == R.id.menu_clarify) {
            serpViewImpl.u.onClarifyClicked();
        }
    }

    public final RecyclerView.Adapter<?> a(AppendingListener appendingListener) {
        if (this.d.getAdapter() != null) {
            return this.d.getAdapter();
        }
        SafeRecyclerAdapter safeRecyclerAdapter = new SafeRecyclerAdapter(this.w, this.v, this.z, this.y);
        GridLayoutNoLoaderAppendingHandler gridLayoutNoLoaderAppendingHandler = new GridLayoutNoLoaderAppendingHandler(this.x, true);
        gridLayoutNoLoaderAppendingHandler.setAppendingListener(appendingListener);
        GridLayoutAppendingAdapter gridLayoutAppendingAdapter = new GridLayoutAppendingAdapter(safeRecyclerAdapter, gridLayoutNoLoaderAppendingHandler);
        gridLayoutAppendingAdapter.setHasStableIds(true);
        this.d.setAdapter(gridLayoutAppendingAdapter);
        if (this.D.getViewVisibilityTrackingInSerp().invoke().booleanValue()) {
            ItemVisibilityTracker.DefaultImpls.subscribe$default(this.C, this.d, null, 2, null);
        }
        return null;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<Unit> allCategoriesClicks() {
        return this.I.allCategoriesClicks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void animateShortcutBar(boolean z2, boolean z3) {
        this.I.animateShortcutBar(z2, z3);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> applyAction() {
        PublishRelay<Unit> applyAction = this.L.applyAction();
        Intrinsics.checkNotNullExpressionValue(applyAction, "applyAction(...)");
        return applyAction;
    }

    public final void b() {
        this.i.getSpanSizeLookup().invalidateSpanIndexCache();
    }

    public final void c(int i2) {
        if (i2 != this.d.getPaddingTop()) {
            Integer valueOf = this.d.getPaddingTop() < i2 ? Integer.valueOf(this.d.computeVerticalScrollOffset()) : null;
            Views.changePadding$default(this.d, 0, i2, 0, 0, 13, null);
            if (valueOf != null && valueOf.intValue() == 0) {
                RecyclerView.Adapter adapter = this.d.getAdapter();
                if ((adapter != null ? adapter.getItemCount() : 0) > 0) {
                    this.d.scrollToPosition(0);
                }
            }
        }
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> closeAction() {
        PublishRelay<Unit> closeAction = this.L.closeAction();
        Intrinsics.checkNotNullExpressionValue(closeAction, "closeAction(...)");
        return closeAction;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void closeDialog() {
        this.L.closeDialog();
    }

    public final void d(int i2) {
        int progressViewStartOffset = this.p.getProgressViewStartOffset();
        int i3 = this.n;
        if (progressViewStartOffset != i3 + i2) {
            this.p.setProgressViewOffset(true, i3 + i2, this.o + i2);
        }
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> deleteAction() {
        PublishRelay<Unit> deleteAction = this.L.deleteAction();
        Intrinsics.checkNotNullExpressionValue(deleteAction, "deleteAction(...)");
        return deleteAction;
    }

    @Override // com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable
    public void destroy() {
        AlertDialog alertDialog = this.q;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.D.getSnippetScrollDepthListener().invoke().booleanValue()) {
            this.d.removeOnScrollListener(this.j);
        }
        this.d.removeOnScrollListener(this.k);
        this.d.removeOnScrollListener(this.E);
        this.G.unbind();
        this.s.clear();
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    public void dismiss() {
        this.J.dismiss();
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    public void dismissPhoneLoadError() {
        this.K.dismissPhoneLoadError();
    }

    public final void e(boolean z2) {
        if (this.D.getViewVisibilityTrackingInSerp().invoke().booleanValue()) {
            ItemVisibilityTracker.DefaultImpls.updateViewportInset$default(this.C, 0, Math.max((!Views.isVisible(this.e) || !z2) ? 0 : this.e.getMeasuredHeight(), this.l), 0, 0, 13, null);
        }
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void enableScroll() {
        this.i.setScrollEnabled(true);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Integer> frequencyChangedAction() {
        PublishRelay<Integer> frequencyChangedAction = this.L.frequencyChangedAction();
        Intrinsics.checkNotNullExpressionValue(frequencyChangedAction, "frequencyChangedAction(...)");
        return frequencyChangedAction;
    }

    @NotNull
    public final RetryView getRetryView() {
        return this.r;
    }

    @Override // com.avito.android.serp.SerpPresenterView
    @NotNull
    public SearchBar getSearchBar() {
        return this.a;
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void hideEmptyView() {
        Views.show(this.d);
        Views.hide(this.c);
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void hideFloatingViews(boolean z2) {
        animateShortcutBar(false, z2);
        e(false);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideShortcutBar() {
        this.I.hideShortcutBar();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void hideShortcutsWithShift() {
        hideShortcutBar();
        c(this.l);
        d(0);
        e(false);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideSkeleton() {
        this.I.hideSkeleton();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.d.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void onDataAppended(@NotNull AppendingListener appendingListener, int i2, int i3) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        RecyclerView.Adapter<?> a3 = a(appendingListener);
        if (a3 != null) {
            a3.notifyItemRangeInserted(i2, i3);
        }
        b();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void onDataChanged(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        RecyclerView.Adapter<?> a3 = a(appendingListener);
        if (a3 != null) {
            a3.notifyDataSetChanged();
        }
        b();
        if (this.D.getSnippetScrollDepthListener().invoke().booleanValue()) {
            this.j.onInitialDataSourceSet();
        }
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void onDataRangeChanged(@NotNull AppendingListener appendingListener, int i2, int i3) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        RecyclerView.Adapter<?> a3 = a(appendingListener);
        if (a3 != null) {
            a3.notifyItemRangeChanged(i2, i3);
        }
        b();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void onItemChanged(int i2) {
        notifyItemAtPositionChanged(i2);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void onRemoveItem(int i2) {
        RecyclerView.Adapter adapter = this.d.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRemoved(i2);
        }
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void onRemoveItemRange(@NotNull AppendingListener appendingListener, int i2, int i3) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        RecyclerView.Adapter<?> a3 = a(appendingListener);
        if (a3 != null) {
            a3.notifyItemRangeRemoved(i2, i3);
        }
        b();
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    @Nullable
    public Parcelable onSaveState() {
        return this.J.onSaveState();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> openSettingsAction() {
        PublishRelay<Unit> openSettingsAction = this.L.openSettingsAction();
        Intrinsics.checkNotNullExpressionValue(openSettingsAction, "openSettingsAction(...)");
        return openSettingsAction;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void overrideVisibleBackground(@ColorInt int i2) {
        this.I.overrideVisibleBackground(i2);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<DeepLink> resetActionClicks() {
        return this.I.resetActionClicks();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void resetScrollingToTop() {
        this.d.scrollToPosition(0);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void resetShortcutBarPosition() {
        this.I.resetShortcutBarPosition();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setCartFabVisible(boolean z2) {
        CartFabView cartFabView = this.H;
        if (cartFabView != null) {
            cartFabView.setVisible(z2);
        }
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setColumnsCount(int i2) {
        this.i.setSpanCount(i2);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        int i2;
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        if (serpDisplayType.isInformative()) {
            i2 = com.avito.android.lib.design.R.attr.white;
        } else {
            i2 = com.avito.android.lib.design.R.attr.oldBackground;
        }
        Context context = this.t.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int colorByAttr = Contexts.getColorByAttr(context, i2);
        this.f.setBackgroundColor(colorByAttr);
        overrideVisibleBackground(colorByAttr);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setSearchHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        getSearchBar().setHint(str);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setSearchHintSearch() {
        String string = this.t.getResources().getString(R.string.search);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString(ui_R.string.search)");
        setSearchHint(string);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutItems(@Nullable Shortcuts.Header header, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.I.setShortcutItems(header, list);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutNavigationBarItems(@Nullable String str, @Nullable DeepLink deepLink, @Nullable Integer num, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.I.setShortcutNavigationBarItems(str, deepLink, num, list);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setSkeleton(@NotNull List<SkeletonItem> list, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.I.setSkeleton(list, z2);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setSubscriptionSwitchedLoading() {
        getSearchBar().toggleSubscriptionButton(SubscriptionButtonState.LOADING_STATE);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setSubscriptionSwitchedOff() {
        getSearchBar().toggleSubscriptionButton(SubscriptionButtonState.NOT_SUBSCRIBED_STATE);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void setSubscriptionSwitchedOn() {
        getSearchBar().toggleSubscriptionButton(SubscriptionButtonState.SUBSCRIBED_STATE);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<ShortcutNavigationItem> shortcutClicks() {
        return this.I.shortcutClicks();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void show(@NotNull SearchPushSubscription searchPushSubscription, @Nullable Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(searchPushSubscription, "subscriptionParams");
        this.L.show(searchPushSubscription, num, z2);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    public void show(@NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "filterSetListener");
        Intrinsics.checkNotNullParameter(function0, "filterCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        this.J.show(filter, list, parcelable, function1, function0, function02);
    }

    @Override // com.avito.android.serp.adapter.advert_xl.PhoneCallView
    public boolean showCallDialog(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        Intrinsics.checkNotNullParameter(function0, "okHandler");
        Intrinsics.checkNotNullParameter(function02, "cancelHandler");
        if (DialogUtils.isShowing(this.q)) {
            return false;
        }
        AlertDialog create = new AlertDialog.Builder(this.t.getContext()).setTitle(R.string.phone).setMessage(str).setPositiveButton(R.string.call, new d(function0)).setOnCancelListener(new e(function02)).create();
        this.q = create;
        Intrinsics.checkNotNull(create);
        create.show();
        return true;
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showDefaultNavigationIcon() {
        getSearchBar().setNavigationIcon(R.drawable.ic_back_24_blue);
        DisposableKt.plusAssign(this.s, Observables.subscribeOnNext(getSearchBar().navigationCallbacks(), new f(this)));
    }

    @Override // com.avito.android.serp.SerpPresenterView, com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.t, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showErrorMessage() {
        this.L.showErrorMessage();
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void showFloatingViews(boolean z2) {
        animateShortcutBar(true, z2);
        e(true);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.L.showMessage(str);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showMessageWithAction(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intrinsics.checkNotNullParameter(function0, "actionListener");
        Snackbars.getTextView(Snackbars.initButton(Views.showSnackBar$default(this.t, str, 0, str2, 0, function0, (Function0) null, 0, 104, (Object) null))).setMaxLines(3);
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showNewSearchEmptyView() {
        Views.hide(this.d);
        Views.show(this.c);
        this.h.setText(R.string.serp_not_found_hint_new_search);
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    @NotNull
    public Observable<Unit> showPhoneLoadError() {
        return this.K.showPhoneLoadError();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showProgress() {
        if (this.F) {
            this.i.setScrollEnabled(false);
            this.g.showContent();
            return;
        }
        this.g.showLoading();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showSavedSearchEmptyView() {
        Views.hide(this.d);
        Views.show(this.c);
        this.h.setText(R.string.serp_not_found_hint_saved_search);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void showShortcutBar() {
        this.I.showShortcutBar();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showShortcutsWithShift() {
        int i2;
        showShortcutBar();
        Integer valueOf = Integer.valueOf(this.t.getWidth());
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        } else {
            Context context = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            i2 = Contexts.getRealDisplayWidth(context);
        }
        this.e.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.e.getMeasuredHeight();
        c(this.e.getMeasuredHeight());
        d(measuredHeight - this.m);
        e(true);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showSubscriptionEditedMessage() {
        this.L.showSubscriptionEditedMessage();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showSubscriptionMessage() {
        this.L.showSubscriptionMessage();
    }

    @Override // com.avito.android.serp.SerpPresenterView
    public void showToastMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.t.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showUnsubscriptionMessage() {
        this.L.showUnsubscriptionMessage();
    }

    @Override // com.avito.android.serp.adapter.onboarding.SerpOnboardingTooltipEventsProducer
    @NotNull
    public Observable<DeepLink> tooltipDetailsLinkClicks() {
        return this.G.tooltipDetailsLinkClicks();
    }
}
