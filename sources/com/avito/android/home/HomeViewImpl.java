package com.avito.android.home;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.advert.actions.HiddenAdvertsViewKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.ui.OnAddButtonStateChangeListener;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.component.search.SearchBar;
import com.avito.android.component.search.SearchBarImpl;
import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.search_view.SubscriptionButtonState;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.floating_views.ScrollHandler;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ItemAction;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandlerImpl;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.skeleton.ScrollGridLayoutManager;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.adapter.GridLayoutAppendingAdapter;
import com.avito.android.ui.adapter.GridLayoutNoLoaderAppendingHandler;
import com.avito.android.ui.view.retry.RetryViewBuilder;
import com.avito.android.ui.view.retry.RetryViewDelegate;
import com.avito.android.ui_components.R;
import com.avito.android.util.Constants;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.Observables;
import com.avito.android.view.ActionsBottomSheet;
import com.avito.android.view.ActionsBottomSheetView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
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
import ru.avito.component.shortcut_navigation_bar.RubricatorType;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarKt;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0002B±\u0001\u0012\b\u0010Û\u0001\u001a\u00030Ø\u0001\u0012\b\u0010ç\u0001\u001a\u00030ä\u0001\u0012\u000f\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u0001\u0012\b\u0010¶\u0001\u001a\u00030³\u0001\u0012\b\u0010º\u0001\u001a\u00030·\u0001\u0012\b\u0010Ì\u0001\u001a\u00030É\u0001\u0012\b\u0010ó\u0001\u001a\u00030ò\u0001\u0012\b\u0010õ\u0001\u001a\u00030ô\u0001\u0012\b\u0010÷\u0001\u001a\u00030ö\u0001\u0012\b\u0010ù\u0001\u001a\u00030ø\u0001\u0012\b\u0010û\u0001\u001a\u00030ú\u0001\u0012\b\u0010ý\u0001\u001a\u00030ü\u0001\u0012\b\u0010¬\u0001\u001a\u00030©\u0001\u0012\u0007\u0010Á\u0001\u001a\u00020\u000f\u0012\b\u0010ÿ\u0001\u001a\u00030þ\u0001\u0012\n\u0010ß\u0001\u001a\u0005\u0018\u00010Ü\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\nJ\u001f\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0016¢\u0006\u0004\b-\u0010,J\u001f\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0016¢\u0006\u0004\b/\u0010,J\u0017\u00100\u001a\u00020\b2\u0006\u0010.\u001a\u00020#H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\b2\u0006\u0010.\u001a\u00020#H\u0016¢\u0006\u0004\b2\u00101J\u0017\u00103\u001a\u00020\b2\u0006\u0010.\u001a\u00020#H\u0016¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u0010\u000eJ\u000f\u00106\u001a\u00020\bH\u0016¢\u0006\u0004\b6\u0010\nJ\u000f\u00107\u001a\u00020\bH\u0016¢\u0006\u0004\b7\u0010\nJ\u000f\u00108\u001a\u00020\bH\u0016¢\u0006\u0004\b8\u0010\nJ\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\nJ\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010\nJ\u0017\u0010;\u001a\u00020\b2\u0006\u0010*\u001a\u00020#H\u0016¢\u0006\u0004\b;\u00101J\u0017\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u000fH\u0016¢\u0006\u0004\b=\u0010\u0012J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0>H\u0001¢\u0006\u0004\b?\u0010@J \u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\bH\u0001¢\u0006\u0004\bD\u0010\nJ\u0010\u0010E\u001a\u00020\bH\u0001¢\u0006\u0004\bE\u0010\nJ\u001a\u0010G\u001a\u00020\b2\b\b\u0001\u0010F\u001a\u00020#H\u0001¢\u0006\u0004\bG\u00101J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020H0>H\u0001¢\u0006\u0004\bI\u0010@J\u0010\u0010J\u001a\u00020\bH\u0001¢\u0006\u0004\bJ\u0010\nJ(\u0010P\u001a\u00020\b2\b\u0010L\u001a\u0004\u0018\u00010K2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0MH\u0001¢\u0006\u0004\bP\u0010QJ<\u0010U\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010H2\b\u0010T\u001a\u0004\u0018\u00010#2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0MH\u0001¢\u0006\u0004\bU\u0010VJ(\u0010Y\u001a\u00020\b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020W0M2\b\b\u0002\u0010X\u001a\u00020\u000fH\u0001¢\u0006\u0004\bY\u0010ZJ\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020N0>H\u0001¢\u0006\u0004\b[\u0010@J\u0010\u0010\\\u001a\u00020\bH\u0001¢\u0006\u0004\b\\\u0010\nJ\u0010\u0010]\u001a\u00020\bH\u0001¢\u0006\u0004\b]\u0010\nJ\u0012\u0010^\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\bH\u0001¢\u0006\u0004\b`\u0010\nJ\u0010\u0010a\u001a\u00020\u000fH\u0001¢\u0006\u0004\ba\u0010bJ\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020#0>H\u0001¢\u0006\u0004\bc\u0010@J\u0016\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0>H\u0001¢\u0006\u0004\bd\u0010@J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0>H\u0001¢\u0006\u0004\be\u0010@J8\u0010j\u001a\u00020\b2\b\b\u0001\u0010f\u001a\u00020#2\b\b\u0001\u0010g\u001a\u00020#2\b\b\u0002\u0010h\u001a\u00020\u000f2\b\b\u0002\u0010i\u001a\u00020\u000fH\u0001¢\u0006\u0004\bj\u0010kJ$\u0010m\u001a\u00020\b2\b\b\u0001\u0010f\u001a\u00020#2\b\b\u0001\u0010l\u001a\u00020#H\u0001¢\u0006\u0004\bm\u0010,J\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020n0>H\u0001¢\u0006\u0004\bo\u0010@J\u0018\u0010p\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0001¢\u0006\u0004\bp\u0010\u000eJ\u0010\u0010q\u001a\u00020\bH\u0001¢\u0006\u0004\bq\u0010\nJ\u001a\u0010s\u001a\u00020\b2\b\b\u0001\u0010r\u001a\u00020#H\u0001¢\u0006\u0004\bs\u00101J\"\u0010t\u001a\u00020\b2\b\b\u0001\u0010f\u001a\u00020#2\u0006\u0010<\u001a\u00020\u000fH\u0001¢\u0006\u0004\bt\u0010uJ\u001a\u0010w\u001a\u00020\b2\b\b\u0001\u0010v\u001a\u00020#H\u0001¢\u0006\u0004\bw\u00101J\u001a\u0010y\u001a\u00020\b2\b\b\u0001\u0010x\u001a\u00020#H\u0001¢\u0006\u0004\by\u00101J\u001a\u0010{\u001a\u00020\b2\b\b\u0001\u0010z\u001a\u00020#H\u0001¢\u0006\u0004\b{\u00101J\u0018\u0010}\u001a\u00020\b2\u0006\u0010|\u001a\u00020\u000bH\u0001¢\u0006\u0004\b}\u0010\u000eJ\u0018\u0010\u001a\u00020\b2\u0006\u0010~\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0010\u0012J\u001a\u0010\u0001\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u000fH\u0001¢\u0006\u0005\b\u0001\u0010\u0012J\u0012\u0010\u0001\u001a\u00020\bH\u0001¢\u0006\u0005\b\u0001\u0010\nJ\u0012\u0010\u0001\u001a\u00020\bH\u0001¢\u0006\u0005\b\u0001\u0010\nJ\u001a\u0010\u0001\u001a\u00020\b2\u0006\u0010*\u001a\u00020#H\u0001¢\u0006\u0005\b\u0001\u00101J6\u0010\u0001\u001a\u00020\b2\t\b\u0001\u0010\u0001\u001a\u00020#2\t\b\u0001\u0010\u0001\u001a\u00020#2\u000b\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010#H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0>H\u0001¢\u0006\u0005\b\u0001\u0010@J\u001d\u0010\u0001\u001a\u00020\b2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J]\u0010\u0001\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010M2\u0007\u0010\u0001\u001a\u00020\u000b2\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u0001\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020#H\u0001¢\u0006\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R\u0019\u0010¤\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010£\u0001R\u001a\u0010¨\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010¬\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R$\u0010²\u0001\u001a\u0005\u0018\u00010­\u00018\u0016@\u0016X\u000f¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010º\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001a\u0010¾\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u0019\u0010Á\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R!\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010È\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010«\u0001R\u001a\u0010Ì\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ó\u0001\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010×\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001a\u0010Û\u0001\u001a\u00030Ø\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001c\u0010ß\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001c\u0010á\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bà\u0001\u0010Ú\u0001R\u0019\u0010ã\u0001\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010Ò\u0001R\u001a\u0010ç\u0001\u001a\u00030ä\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ë\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001f\u0010ñ\u0001\u001a\u00030ì\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/home/HomeViewImpl;", "Lcom/avito/android/home/HomeView;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lcom/avito/android/component/search/SearchBar;", "Lcom/avito/android/view/ActionsBottomSheet;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", AuthSource.SEND_ABUSE, "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "showProgress", "()V", "", "error", "showError", "(Ljava/lang/String;)V", "", "animate", "showFloatingViews", "(Z)V", "hideFloatingViews", "title", "showEmptyView", "hideEmptyView", Constants.LOCATION_NAME, "setSearchHintSearchInLocation", "setSearchHintSearch", "hint", "setSearchHintFromApi", "initToolbar", "destroy", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "setAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "onDataChanged", "", "offset", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "dispatchChanges", "(ILandroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "startPosition", "count", "onDataRangeChanged", "(II)V", "onDataInserted", VKApiConst.POSITION, "onRemoveItem", "onItemHidden", "(I)V", "onItemChanged", "notifyItemAtPositionChanged", "message", "showMessage", "scrollToStart", "hideShortcutsBlock", "showShortcutsBlock", "updateAddButtonState", "enableScroll", "setColumnsCount", "visible", "setCartFabVisible", "Lio/reactivex/rxjava3/core/Observable;", "allCategoriesClicks", "()Lio/reactivex/rxjava3/core/Observable;", "show", "animateShortcutBar", "(ZZ)V", "hideShortcutBar", "hideSkeleton", "color", "overrideVisibleBackground", "Lcom/avito/android/deep_linking/links/DeepLink;", "resetActionClicks", "resetShortcutBarPosition", "Lcom/avito/android/remote/model/Shortcuts$Header;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "items", "setShortcutItems", "(Lcom/avito/android/remote/model/Shortcuts$Header;Ljava/util/List;)V", "headerTitle", "resetAction", "searchResultCount", "setShortcutNavigationBarItems", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;Ljava/util/List;)V", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "withText", "setSkeleton", "(Ljava/util/List;Z)V", "shortcutClicks", "showShortcutBar", "close", "getQuery", "()Ljava/lang/String;", "hideNavigationIcon", "isVisible", "()Z", "menuCallbacks", "navigationCallbacks", "openCallbacks", "itemId", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "searchSuggestsCallbacks", "setHint", "setInvisibleSearch", "menuId", "setMenu", "setMenuItemVisible", "(IZ)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "setNavigationIcon", "text", "setQuery", "enabled", "setSearchEnabled", "setVisible", "showActionProgress", "showSavedSearchesTooltipIfNeeded", "showSelectedFiltersCount", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "submitCallbacks", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "Lcom/avito/android/remote/model/ItemAction;", "actions", "id", "categoryId", "locationId", "feedId", "showBottomActionsMenu", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)V", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "l", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "e", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "itemsScrollListener", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/ui/adapter/GridLayoutNoLoaderAppendingHandler;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/GridLayoutNoLoaderAppendingHandler;", "adapterHandler", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "u", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "getActionsMenuPresenter", "()Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "setActionsMenuPresenter", "(Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;)V", "actionsMenuPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "r", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "s", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", VKApiConst.VERSION, "Z", "isSkeleton", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", VKApiConst.Q, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", g.a, "addButtonStateListener", "Lcom/avito/android/Features;", "t", "Lcom/avito/android/Features;", "features", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "emptyViewHint", "j", "I", "emptyShortcutsPadding", "Lcom/avito/android/serp/adapter/skeleton/ScrollGridLayoutManager;", "d", "Lcom/avito/android/serp/adapter/skeleton/ScrollGridLayoutManager;", "layoutManager", "Landroid/view/View;", "o", "Landroid/view/View;", "view", "Lcom/avito/android/cart_fab/CartFabView;", "w", "Lcom/avito/android/cart_fab/CartFabView;", "cartFabView", "h", "emptyView", "k", "serpTopPadding", "Lcom/avito/android/home/HomeViewPresenter;", "p", "Lcom/avito/android/home/HomeViewPresenter;", "presenter", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "f", "Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "scrollListener", "Lcom/avito/android/ui/view/retry/RetryViewDelegate;", "n", "Lcom/avito/android/ui/view/retry/RetryViewDelegate;", "getRetryView", "()Lcom/avito/android/ui/view/retry/RetryViewDelegate;", "retryView", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/floating_views/ScrollHandler$Listener;", "scrollHandlerListener", "Lcom/avito/android/component/search/SuggestInteractor;", "suggestInteractor", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "rubricatorTestGroup", "<init>", "(Landroid/view/View;Lcom/avito/android/home/HomeViewPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/util/SchedulersFactory3;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/floating_views/ScrollHandler$Listener;Lcom/avito/android/component/search/SuggestInteractor;Lcom/avito/android/analytics/Analytics;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;ZLcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;Lcom/avito/android/cart_fab/CartFabView;)V", "Companion", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeViewImpl implements HomeView, ShortcutNavigationBar, SearchBar, ActionsBottomSheet {
    public static final int A = ViewSizeKt.getDp(40);
    public static final int B = ViewSizeKt.getDp(142);
    public static final int C = ViewSizeKt.getDp(169);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int D = ViewSizeKt.getDp(215);
    public final RecyclerView a;
    public final GridLayoutNoLoaderAppendingHandler b;
    public final ProgressOverlay c;
    public final ScrollGridLayoutManager d;
    public final SnippetScrollDepthRecyclerViewScrollHandlerImpl e;
    public final RecyclerViewScrollHandler f;
    public final RecyclerView.OnScrollListener g;
    public View h;
    public TextView i;
    public final int j;
    public int k;
    public final SwipeRefreshLayout l;
    public final CompositeDisposable m;
    @NotNull
    public final RetryViewDelegate n;
    public final View o;
    public final HomeViewPresenter p;
    public final ViewHolderBuilder<BaseViewHolder> q;
    public final ResponsiveAdapterPresenter r;
    public final ItemVisibilityTracker s;
    public final Features t;
    public final RecyclerView.OnScrollListener u;
    public final boolean v;
    public final CartFabView w;
    public final /* synthetic */ ShortcutNavigationBarImpl x;
    public final /* synthetic */ SearchBarImpl y;
    public final /* synthetic */ ActionsBottomSheetView z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/home/HomeViewImpl$Companion;", "", "", "BIG_RUBRICATOR_HEIGHT", "I", "MEDIUM_RUBRICATOR_HEIGHT", "PULL_REFRESH_RANGE", "SMALL_RUBRICATOR_HEIGHT", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                HomeNewRubricatorTestGroup.values();
                int[] iArr = new int[6];
                $EnumSwitchMapping$0 = iArr;
                iArr[2] = 1;
                iArr[3] = 2;
                iArr[4] = 3;
                iArr[5] = 4;
            }
        }

        public Companion() {
        }

        public static final RubricatorType access$toViewType(Companion companion, HomeNewRubricatorTestGroup homeNewRubricatorTestGroup) {
            Objects.requireNonNull(companion);
            int ordinal = homeNewRubricatorTestGroup.ordinal();
            if (ordinal == 2) {
                return RubricatorType.BIG_ICON_ALL_CAT_BELOW;
            }
            if (ordinal == 3) {
                return RubricatorType.BIG_ICON_ALL_CAT_LAST;
            }
            if (ordinal == 4) {
                return RubricatorType.SMALL_ICON_ALL_CAT_FIRST;
            }
            if (ordinal != 5) {
                return null;
            }
            return RubricatorType.SMALL_ICON_ALL_CAT_LAST;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            HomeNewRubricatorTestGroup.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[4] = 1;
            iArr[5] = 2;
            iArr[3] = 3;
            iArr[2] = 4;
        }
    }

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ HomeViewImpl a;

        public a(HomeViewImpl homeViewImpl, HomeNewRubricatorTestGroup homeNewRubricatorTestGroup) {
            this.a = homeViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.p.onRefresh();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HomeViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HomeViewImpl homeViewImpl) {
            super(0);
            this.a = homeViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.p.retryLoading();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ HomeViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HomeViewImpl homeViewImpl) {
            super(1);
            this.a = homeViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            HomeViewImpl.access$onMenu(this.a, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r26v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeViewImpl(@NotNull View view, @NotNull HomeViewPresenter homeViewPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull Features features, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull ScrollHandler.Listener listener, @NotNull SuggestInteractor suggestInteractor, @NotNull Analytics analytics, @NotNull RecyclerView.OnScrollListener onScrollListener, boolean z2, @NotNull HomeNewRubricatorTestGroup homeNewRubricatorTestGroup, @Nullable CartFabView cartFabView) {
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(homeViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(listener, "scrollHandlerListener");
        Intrinsics.checkNotNullParameter(suggestInteractor, "suggestInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(onScrollListener, "fpsListener");
        Intrinsics.checkNotNullParameter(homeNewRubricatorTestGroup, "rubricatorTestGroup");
        View findViewById = view.findViewById(R.id.shortcuts_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.x = new ShortcutNavigationBarImpl(findViewById, ShortcutNavigationBarKt.JUST_ICON, Companion.access$toViewType(Companion, homeNewRubricatorTestGroup), features.getLoadFontsFromAssets().invoke().booleanValue());
        View findViewById2 = view.findViewById(R.id.toolbar_search);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.y = new SearchBarImpl(findViewById2, schedulersFactory3, suggestInteractor);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.z = new ActionsBottomSheetView(context);
        this.o = view;
        this.p = homeViewPresenter;
        this.q = viewHolderBuilder;
        this.r = responsiveAdapterPresenter;
        this.s = itemVisibilityTracker;
        this.t = features;
        this.u = onScrollListener;
        this.v = z2;
        this.w = cartFabView;
        int i6 = com.avito.android.serp.R.id.recycler_view;
        View findViewById3 = view.findViewById(i6);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.a = recyclerView;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        ScrollGridLayoutManager scrollGridLayoutManager = new ScrollGridLayoutManager(context2, view.getResources().getInteger(R.integer.serp_columns));
        this.d = scrollGridLayoutManager;
        SnippetScrollDepthRecyclerViewScrollHandlerImpl snippetScrollDepthRecyclerViewScrollHandlerImpl = new SnippetScrollDepthRecyclerViewScrollHandlerImpl(homeViewPresenter, scrollGridLayoutManager);
        this.e = snippetScrollDepthRecyclerViewScrollHandlerImpl;
        RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(listener, scrollGridLayoutManager);
        this.f = recyclerViewScrollHandler;
        HomeViewImpl$addButtonStateListener$1 homeViewImpl$addButtonStateListener$1 = new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.home.HomeViewImpl$addButtonStateListener$1
            public final /* synthetic */ HomeViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i7, int i8) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                this.a.updateAddButtonState();
            }
        };
        this.g = homeViewImpl$addButtonStateListener$1;
        this.j = a2.b.a.a.a.u1(view, "view.context").getDimensionPixelSize(R.dimen.toolbar_search_view_height);
        this.k = a2.b.a.a.a.u1(view, "view.context").getDimensionPixelSize(com.avito.android.serp.R.dimen.serp_top_padding);
        View findViewById4 = view.findViewById(com.avito.android.serp.R.id.pull_refresh_layout);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById4;
        this.l = swipeRefreshLayout;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        if (homeNewRubricatorTestGroup.isTest()) {
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            i2 = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.white);
        } else {
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "view.context");
            i2 = Contexts.getColorCompat(context4, com.avito.android.lib.design.avito.R.color.expected_background);
        }
        View findViewById5 = view.findViewById(com.avito.android.serp.R.id.progress_overlay_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById5, i6, analytics, false, i2, 8, null);
        this.c = progressOverlay;
        progressOverlay.setToolbarPadding();
        int ordinal = homeNewRubricatorTestGroup.ordinal();
        if (ordinal == 2) {
            i3 = D;
        } else if (ordinal == 3) {
            i3 = C;
        } else if (ordinal == 4 || ordinal == 5) {
            i3 = B;
        } else {
            i3 = this.k;
        }
        this.k = i3;
        this.n = new RetryViewBuilder(new b(this)).withOverlay(progressOverlay).withSwipeRefresh(swipeRefreshLayout).build();
        hideNavigationIcon();
        recyclerView.setLayoutManager(scrollGridLayoutManager);
        if (features.getSnippetScrollDepthListener().invoke().booleanValue()) {
            recyclerView.addOnScrollListener(snippetScrollDepthRecyclerViewScrollHandlerImpl);
        }
        recyclerView.addOnScrollListener(recyclerViewScrollHandler);
        recyclerView.addOnScrollListener(homeViewImpl$addButtonStateListener$1);
        recyclerView.addOnScrollListener(onScrollListener);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
        scrollGridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        Resources resources = recyclerView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "recyclerView.resources");
        recyclerView.addItemDecoration(new HomeItemDecorator(resources));
        this.b = new GridLayoutNoLoaderAppendingHandler(spannedGridPositionProvider, true);
        if (homeNewRubricatorTestGroup.isTest()) {
            i5 = this.k;
            i4 = A + i5;
        } else {
            i5 = (int) swipeRefreshLayout.getResources().getDimension(R.dimen.pull_refresh_offset_start);
            i4 = (int) swipeRefreshLayout.getResources().getDimension(R.dimen.pull_refresh_offset_end);
        }
        swipeRefreshLayout.setProgressViewOffset(true, i5, i4);
        Context context5 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context5);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        swipeRefreshLayout.setOnRefreshListener(new a(this, homeNewRubricatorTestGroup));
        Context context6 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context6, com.avito.android.lib.design.R.attr.white));
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(menuCallbacks(), new c(this)));
    }

    public static final void access$onMenu(HomeViewImpl homeViewImpl, int i2) {
        Objects.requireNonNull(homeViewImpl);
        if (i2 == R.id.menu_clarify) {
            homeViewImpl.p.onClarifyClicked();
        }
    }

    public final RecyclerView.Adapter<?> a() {
        if (this.a.getAdapter() != null) {
            return this.a.getAdapter();
        }
        GridLayoutAppendingAdapter gridLayoutAppendingAdapter = new GridLayoutAppendingAdapter(new ResponsiveRecyclerAdapter(this.r, this.q), this.b);
        gridLayoutAppendingAdapter.setHasStableIds(true);
        this.a.setAdapter(gridLayoutAppendingAdapter);
        if (!this.t.getViewVisibilityTracking().invoke().booleanValue()) {
            return null;
        }
        this.s.subscribe(this.a, new Rect(0, this.j, 0, 0));
        return null;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<Unit> allCategoriesClicks() {
        return this.x.allCategoriesClicks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void animateShortcutBar(boolean z2, boolean z3) {
        this.x.animateShortcutBar(z2, z3);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void close() {
        this.y.close();
    }

    @Override // com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable
    public void destroy() {
        this.a.removeOnScrollListener(this.f);
        this.a.removeOnScrollListener(this.g);
        this.a.removeOnScrollListener(this.u);
        if (this.t.getSnippetScrollDepthListener().invoke().booleanValue()) {
            this.a.removeOnScrollListener(this.e);
        }
        this.m.clear();
    }

    @Override // com.avito.android.home.HomePresenterView
    public void dispatchChanges(int i2, @NotNull DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(diffResult, "diff");
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            diffResult.dispatchUpdatesTo(new OffsetListUpdateCallback(a3, i2));
        }
    }

    @Override // com.avito.android.home.HomePresenterView
    public void enableScroll() {
        this.d.setScrollEnabled(true);
    }

    @Override // com.avito.android.view.ActionsBottomSheet
    @Nullable
    public AdvertItemActionsPresenter getActionsMenuPresenter() {
        return this.z.getActionsMenuPresenter();
    }

    @Override // com.avito.android.component.search.SearchBar
    @Nullable
    public String getQuery() {
        return this.y.getQuery();
    }

    @NotNull
    public final RetryViewDelegate getRetryView() {
        return this.n;
    }

    @Override // com.avito.android.home.HomeView
    public void hideEmptyView() {
        View view = this.h;
        if (view != null) {
            Views.hide(view);
        }
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void hideFloatingViews(boolean z2) {
        animateShortcutBar(false, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void hideNavigationIcon() {
        this.y.hideNavigationIcon();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideShortcutBar() {
        this.x.hideShortcutBar();
    }

    @Override // com.avito.android.home.HomeView
    public void hideShortcutsBlock() {
        hideShortcutBar();
        Views.changePadding$default(this.a, 0, this.j, 0, 0, 13, null);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideSkeleton() {
        this.x.hideSkeleton();
    }

    @Override // com.avito.android.home.HomePresenterView
    public void initToolbar() {
        setMenu(R.menu.home);
    }

    @Override // com.avito.android.component.search.SearchBar
    public boolean isVisible() {
        return this.y.isVisible();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.y.menuCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.y.navigationCallbacks();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            a3.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.home.HomePresenterView
    public void onDataChanged() {
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            a3.notifyDataSetChanged();
        }
        if (this.t.getSnippetScrollDepthListener().invoke().booleanValue()) {
            this.e.onInitialDataSourceSet();
        }
    }

    @Override // com.avito.android.home.HomePresenterView
    public void onDataInserted(int i2, int i3) {
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            a3.notifyItemRangeInserted(i2, i3);
        }
    }

    @Override // com.avito.android.home.HomePresenterView
    public void onDataRangeChanged(int i2, int i3) {
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            a3.notifyItemRangeChanged(i2, i3);
        }
    }

    @Override // com.avito.android.home.HomePresenterView
    public void onItemChanged(int i2) {
        notifyItemAtPositionChanged(i2);
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertsView
    public void onItemHidden(int i2) {
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            a3.notifyItemChanged(i2, HiddenAdvertsViewKt.HIDDEN_STUB_ANIMATION_PAYLOAD);
        }
    }

    @Override // com.avito.android.home.HomePresenterView
    public void onRemoveItem(int i2, int i3) {
        RecyclerView.Adapter<?> a3 = a();
        if (a3 != null) {
            a3.notifyItemRangeRemoved(i2, i3);
        }
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Boolean> openCallbacks() {
        return this.y.openCallbacks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void overrideVisibleBackground(@ColorInt int i2) {
        this.x.overrideVisibleBackground(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemIcon(@IdRes int i2, @DrawableRes int i3, boolean z2, boolean z3) {
        this.y.replaceMenuItemIcon(i2, i3, z2, z3);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemTitle(@IdRes int i2, @StringRes int i3) {
        this.y.replaceMenuItemTitle(i2, i3);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<DeepLink> resetActionClicks() {
        return this.x.resetActionClicks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void resetShortcutBarPosition() {
        this.x.resetShortcutBarPosition();
    }

    @Override // com.avito.android.home.HomePresenterView
    public void scrollToStart() {
        this.a.scrollToPosition(0);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<SuggestAction> searchSuggestsCallbacks() {
        return this.y.searchSuggestsCallbacks();
    }

    @Override // com.avito.android.view.ActionsBottomSheet
    public void setActionsMenuPresenter(@Nullable AdvertItemActionsPresenter advertItemActionsPresenter) {
        this.z.setActionsMenuPresenter(advertItemActionsPresenter);
    }

    @Override // com.avito.android.home.HomePresenterView
    public void setAppendingListener(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        this.b.setAppendingListener(appendingListener);
    }

    @Override // com.avito.android.home.HomeView
    public void setCartFabVisible(boolean z2) {
        CartFabView cartFabView = this.w;
        if (cartFabView != null) {
            cartFabView.setVisible(z2);
        }
    }

    @Override // com.avito.android.home.HomeView
    public void setColumnsCount(int i2) {
        this.d.setSpanCount(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.y.setHint(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setInvisibleSearch() {
        this.y.setInvisibleSearch();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenu(@MenuRes int i2) {
        this.y.setMenu(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuItemVisible(@IdRes int i2, boolean z2) {
        this.y.setMenuItemVisible(i2, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.y.setMenuTintColor(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.y.setMenuTintColorAttr(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setNavigationIcon(@DrawableRes int i2) {
        this.y.setNavigationIcon(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.y.setQuery(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setSearchEnabled(boolean z2) {
        this.y.setSearchEnabled(z2);
    }

    @Override // com.avito.android.home.HomePresenterView
    public void setSearchHintFromApi(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        setHint(str);
    }

    @Override // com.avito.android.home.HomePresenterView
    public void setSearchHintSearch() {
        String string = this.o.getResources().getString(R.string.search);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString(ui_R.string.search)");
        setHint(string);
    }

    @Override // com.avito.android.home.HomePresenterView
    public void setSearchHintSearchInLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.LOCATION_NAME);
        String string = this.o.getResources().getString(com.avito.android.serp_core.R.string.search_in, str);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString….search_in, locationName)");
        setHint(string);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutItems(@Nullable Shortcuts.Header header, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.x.setShortcutItems(header, list);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutNavigationBarItems(@Nullable String str, @Nullable DeepLink deepLink, @Nullable Integer num, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.x.setShortcutNavigationBarItems(str, deepLink, num, list);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setSkeleton(@NotNull List<SkeletonItem> list, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.x.setSkeleton(list, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setVisible(boolean z2) {
        this.y.setVisible(z2);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<ShortcutNavigationItem> shortcutClicks() {
        return this.x.shortcutClicks();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showActionProgress() {
        this.y.showActionProgress();
    }

    @Override // com.avito.android.view.ActionsBottomSheet
    public void showBottomActionsMenu(@Nullable String str, @NotNull List<? extends ItemAction> list, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i2) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str4, "feedId");
        this.z.showBottomActionsMenu(str, list, str2, str3, num, str4, i2);
    }

    @Override // com.avito.android.home.HomeView
    public void showEmptyView(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        hideShortcutsBlock();
        if (this.h == null) {
            View findViewById = this.o.findViewById(16908292);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            this.h = ((ViewStub) findViewById).inflate();
            View findViewById2 = this.o.findViewById(com.avito.android.serp.R.id.create_first_advert_hint);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.i = (TextView) findViewById2;
        }
        Views.show(this.h);
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.avito.android.home.HomePresenterView, com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.o, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void showFloatingViews(boolean z2) {
        animateShortcutBar(true, z2);
    }

    @Override // com.avito.android.home.HomeView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.o, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.home.HomePresenterView
    public void showProgress() {
        if (this.v) {
            this.d.setScrollEnabled(false);
            this.c.showContent();
            return;
        }
        this.c.showLoading();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSavedSearchesTooltipIfNeeded() {
        this.y.showSavedSearchesTooltipIfNeeded();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSelectedFiltersCount(int i2) {
        this.y.showSelectedFiltersCount(i2);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void showShortcutBar() {
        this.x.showShortcutBar();
    }

    @Override // com.avito.android.home.HomeView
    public void showShortcutsBlock() {
        showShortcutBar();
        Views.changePadding$default(this.a, 0, this.k, 0, 0, 13, null);
        int i2 = this.k;
        int computeVerticalScrollOffset = this.a.computeVerticalScrollOffset();
        if (1 <= computeVerticalScrollOffset && i2 > computeVerticalScrollOffset) {
            this.a.smoothScrollBy(0, -this.k);
        }
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showTapTarget(@IdRes int i2, @StringRes int i3, @StringRes @Nullable Integer num) {
        this.y.showTapTarget(i2, i3, num);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<String> submitCallbacks() {
        return this.y.submitCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState) {
        Intrinsics.checkNotNullParameter(subscriptionButtonState, "subscriptionButtonState");
        this.y.toggleSubscriptionButton(subscriptionButtonState);
    }

    @Override // com.avito.android.home.HomePresenterView
    public void updateAddButtonState() {
        AddButtonState addButtonState = this.a.computeVerticalScrollOffset() > 0 ? AddButtonState.SMALL : AddButtonState.BIG;
        Context context = this.o.getContext();
        if (!(context instanceof OnAddButtonStateChangeListener)) {
            context = null;
        }
        OnAddButtonStateChangeListener onAddButtonStateChangeListener = (OnAddButtonStateChangeListener) context;
        if (onAddButtonStateChangeListener != null) {
            onAddButtonStateChangeListener.onAddButtonStateChange(NavigationTab.SEARCH.INSTANCE, addButtonState);
        }
    }
}
