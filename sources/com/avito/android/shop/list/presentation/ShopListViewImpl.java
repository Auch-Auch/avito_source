package com.avito.android.shop.list.presentation;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.search.SearchBar;
import com.avito.android.component.search.SearchBarImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.search_view.SubscriptionButtonState;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.floating_views.ScrollHandler;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.adapter.GridLayoutAppendingAdapter;
import com.avito.android.ui.adapter.GridLayoutAppendingHandler;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Constants;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
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
import ru.avito.component.floating_button.PrimaryFloatingButtonImpl;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0001\u0012\b\u0010¦\u0001\u001a\u00030£\u0001\u0012\b\u0010Î\u0001\u001a\u00030Ë\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010Â\u0001\u001a\u00030¿\u0001\u0012\b\u0010Ò\u0001\u001a\u00030Ï\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¾\u0001\u001a\u00030»\u0001\u0012\b\u0010¸\u0001\u001a\u00030µ\u0001\u0012\b\u0010Ô\u0001\u001a\u00030Ó\u0001\u0012\b\u0010Ö\u0001\u001a\u00030Õ\u0001\u0012\b\u0010Ø\u0001\u001a\u00030×\u0001\u0012\u0007\u0010Ù\u0001\u001a\u00020\u0015¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010\u0018J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0006J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b&\u0010\u0018J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b*\u0010)J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b,\u0010)J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'H\u0016¢\u0006\u0004\b.\u0010)J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0006J\u0010\u00101\u001a\u00020\u0004H\u0001¢\u0006\u0004\b1\u0010\u0006J\u0012\u00102\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0004H\u0001¢\u0006\u0004\b4\u0010\u0006J\u0010\u00105\u001a\u00020\u0015H\u0001¢\u0006\u0004\b5\u00106J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020-0'H\u0001¢\u0006\u0004\b7\u0010)J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0001¢\u0006\u0004\b8\u0010)J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00150'H\u0001¢\u0006\u0004\b9\u0010)J8\u0010>\u001a\u00020\u00042\b\b\u0001\u0010:\u001a\u00020-2\b\b\u0001\u0010;\u001a\u00020-2\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010=\u001a\u00020\u0015H\u0001¢\u0006\u0004\b>\u0010?J$\u0010A\u001a\u00020\u00042\b\b\u0001\u0010:\u001a\u00020-2\b\b\u0001\u0010@\u001a\u00020-H\u0001¢\u0006\u0004\bA\u0010BJ\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020C0'H\u0001¢\u0006\u0004\bD\u0010)J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\tH\u0001¢\u0006\u0004\bF\u0010\fJ\u0010\u0010G\u001a\u00020\u0004H\u0001¢\u0006\u0004\bG\u0010\u0006J\u001a\u0010I\u001a\u00020\u00042\b\b\u0001\u0010H\u001a\u00020-H\u0001¢\u0006\u0004\bI\u0010JJ\"\u0010L\u001a\u00020\u00042\b\b\u0001\u0010:\u001a\u00020-2\u0006\u0010K\u001a\u00020\u0015H\u0001¢\u0006\u0004\bL\u0010MJ\u001a\u0010O\u001a\u00020\u00042\b\b\u0001\u0010N\u001a\u00020-H\u0001¢\u0006\u0004\bO\u0010JJ\u001a\u0010Q\u001a\u00020\u00042\b\b\u0001\u0010P\u001a\u00020-H\u0001¢\u0006\u0004\bQ\u0010JJ\u001a\u0010S\u001a\u00020\u00042\b\b\u0001\u0010R\u001a\u00020-H\u0001¢\u0006\u0004\bS\u0010JJ\u0018\u0010T\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0001¢\u0006\u0004\bT\u0010\fJ\u0018\u0010V\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0015H\u0001¢\u0006\u0004\bV\u0010\u0018J\u0018\u0010W\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0015H\u0001¢\u0006\u0004\bW\u0010\u0018J\u0010\u0010X\u001a\u00020\u0004H\u0001¢\u0006\u0004\bX\u0010\u0006J\u0010\u0010Y\u001a\u00020\u0004H\u0001¢\u0006\u0004\bY\u0010\u0006J\u0018\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020-H\u0001¢\u0006\u0004\b[\u0010JJ0\u0010_\u001a\u00020\u00042\b\b\u0001\u0010\\\u001a\u00020-2\b\b\u0001\u0010]\u001a\u00020-2\n\b\u0001\u0010^\u001a\u0004\u0018\u00010-H\u0001¢\u0006\u0004\b_\u0010`J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020\t0'H\u0001¢\u0006\u0004\ba\u0010)J\u0018\u0010d\u001a\u00020\u00042\u0006\u0010c\u001a\u00020bH\u0001¢\u0006\u0004\bd\u0010eJ\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0001¢\u0006\u0004\bf\u0010)J \u0010h\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0001¢\u0006\u0004\bh\u0010iJ\u0010\u0010j\u001a\u00020\u0004H\u0001¢\u0006\u0004\bj\u0010\u0006J\u0010\u0010k\u001a\u00020\u0004H\u0001¢\u0006\u0004\bk\u0010\u0006J\u001a\u0010m\u001a\u00020\u00042\b\b\u0001\u0010l\u001a\u00020-H\u0001¢\u0006\u0004\bm\u0010JJ\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020n0'H\u0001¢\u0006\u0004\bo\u0010)J\u0010\u0010p\u001a\u00020\u0004H\u0001¢\u0006\u0004\bp\u0010\u0006J(\u0010v\u001a\u00020\u00042\b\u0010r\u001a\u0004\u0018\u00010q2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020t0sH\u0001¢\u0006\u0004\bv\u0010wJ<\u0010{\u001a\u00020\u00042\b\u0010x\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010n2\b\u0010z\u001a\u0004\u0018\u00010-2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020t0sH\u0001¢\u0006\u0004\b{\u0010|J)\u0010\u001a\u00020\u00042\f\u0010u\u001a\b\u0012\u0004\u0012\u00020}0s2\b\b\u0002\u0010~\u001a\u00020\u0015H\u0001¢\u0006\u0005\b\u0010\u0001J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020t0'H\u0001¢\u0006\u0005\b\u0001\u0010)J\u0012\u0010\u0001\u001a\u00020\u0004H\u0001¢\u0006\u0005\b\u0001\u0010\u0006R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\r \u0001*\u0005\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010 \u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010\u0001R\u001a\u0010¦\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R \u0010¨\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010\u0001R \u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b©\u0001\u0010\u0001R\u0019\u0010¬\u0001\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010\u0001R\u001a\u0010°\u0001\u001a\u00030­\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010´\u0001\u001a\u00030±\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001a\u0010¸\u0001\u001a\u00030µ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010º\u0001\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010\u0001R\u001a\u0010¾\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010Â\u0001\u001a\u00030¿\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001a\u0010Æ\u0001\u001a\u00030Ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001a\u0010Î\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001a\u0010Ò\u0001\u001a\u00030Ï\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001¨\u0006Ü\u0001"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListViewImpl;", "Lcom/avito/android/shop/list/presentation/ShopListView;", "Lcom/avito/android/component/search/SearchBar;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "", "showRetryOverlay", "()V", "showLoading", "hideLoading", "", "error", "showError", "(Ljava/lang/String;)V", "showEmptyView", "hideEmptyView", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "onDataChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "stopPullRefresh", "dispose", "", "isEnabled", "setPullRefreshEnabled", "(Z)V", "showActionButton", "hideActionButton", "text", "setActionText", "animate", "showFloatingViews", "hideFloatingViews", Constants.LOCATION_NAME, "showSearchHintWithLocation", "showSearchHintNoLocation", "hideShortcutsWithShift", "showShortcutsWithShift", "smooth", "scrollToTop", "Lio/reactivex/rxjava3/core/Observable;", "searchClarifyEvents", "()Lio/reactivex/rxjava3/core/Observable;", "reloadEvents", "pullRefreshEvents", "actionClickEvents", "", "firstVisibleEvents", "addBottomSpace", "removeBottomSpace", "close", "getQuery", "()Ljava/lang/String;", "hideNavigationIcon", "isVisible", "()Z", "menuCallbacks", "navigationCallbacks", "openCallbacks", "itemId", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "(II)V", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "searchSuggestsCallbacks", "hint", "setHint", "setInvisibleSearch", "menuId", "setMenu", "(I)V", "visible", "setMenuItemVisible", "(IZ)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "setNavigationIcon", "setQuery", "enabled", "setSearchEnabled", "setVisible", "showActionProgress", "showSavedSearchesTooltipIfNeeded", "count", "showSelectedFiltersCount", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "submitCallbacks", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "allCategoriesClicks", "show", "animateShortcutBar", "(ZZ)V", "hideShortcutBar", "hideSkeleton", "color", "overrideVisibleBackground", "Lcom/avito/android/deep_linking/links/DeepLink;", "resetActionClicks", "resetShortcutBarPosition", "Lcom/avito/android/remote/model/Shortcuts$Header;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "items", "setShortcutItems", "(Lcom/avito/android/remote/model/Shortcuts$Header;Ljava/util/List;)V", "headerTitle", "resetAction", "searchResultCount", "setShortcutNavigationBarItems", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;Ljava/util/List;)V", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "withText", "setSkeleton", "(Ljava/util/List;Z)V", "shortcutClicks", "showShortcutBar", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "h", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Lcom/jakewharton/rxrelay3/PublishRelay;", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "reloadRelay", "n", "firstVisibleItemRelay", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "r", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "u", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", AuthSource.BOOKING_ORDER, "I", "topPadding", "Landroid/view/View;", "kotlin.jvm.PlatformType", g.a, "Landroid/view/View;", "emptyView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "k", "pullRefreshRelay", "Landroid/view/ViewGroup;", "p", "Landroid/view/ViewGroup;", "view", "l", "searchClarifyRelay", AuthSource.OPEN_CHANNEL_LIST, "actionClickRelay", "c", "bottomPadding", "Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl;", "d", "Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl;", "toolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "w", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", AuthSource.SEND_ABUSE, "emptyShortcutsPadding", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/analytics/Analytics;", "s", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lru/avito/component/floating_button/PrimaryFloatingButtonImpl;", "i", "Lru/avito/component/floating_button/PrimaryFloatingButtonImpl;", "actionButton", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "o", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", VKApiConst.Q, "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "t", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/floating_views/ScrollHandler$Listener;", "scrollHandlerListener", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "shopListDataChangeListener", "shortcutNavBarloadFontsFromAssets", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/floating_views/ScrollHandler$Listener;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;Z)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListViewImpl implements ShopListView, SearchBar, ShortcutNavigationBar {
    public final int a;
    public final int b;
    public final int c;
    public final ToolbarSearchViewImpl d;
    public final RecyclerView e;
    public final ProgressOverlay f;
    public final View g;
    public final SwipeRefreshLayout h;
    public final PrimaryFloatingButtonImpl i;
    public final PublishRelay<Unit> j;
    public final PublishRelay<Unit> k;
    public final PublishRelay<Unit> l;
    public final PublishRelay<Unit> m;
    public final PublishRelay<Integer> n;
    public final CompositeDisposable o;
    public final ViewGroup p;
    public final DestroyableViewHolderBuilder q;
    public final AdapterPresenter r;
    public final Analytics s;
    public final BuildInfo t;
    public final SpannedGridPositionProvider u;
    public final GridLayoutManager.SpanSizeLookup v;
    public final SerpSpanProvider w;
    public final /* synthetic */ SearchBarImpl x;
    public final /* synthetic */ ShortcutNavigationBarImpl y;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                PublishRelay publishRelay = ((ShopListViewImpl) this.b).j;
                Unit unit = Unit.INSTANCE;
                publishRelay.accept(unit);
                return unit;
            } else if (i == 1) {
                PublishRelay publishRelay2 = ((ShopListViewImpl) this.b).m;
                Unit unit2 = Unit.INSTANCE;
                publishRelay2.accept(unit2);
                return unit2;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ SwipeRefreshLayout a;
        public final /* synthetic */ ShopListViewImpl b;

        public b(SwipeRefreshLayout swipeRefreshLayout, ShopListViewImpl shopListViewImpl) {
            this.a = swipeRefreshLayout;
            this.b = shopListViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.setRefreshing(true);
            this.b.k.accept(Unit.INSTANCE);
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ ShopListViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ShopListViewImpl shopListViewImpl) {
            super(1);
            this.a = shopListViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            ShopListViewImpl.access$onMenu(this.a, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public ShopListViewImpl(@NotNull ViewGroup viewGroup, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull AdapterPresenter adapterPresenter, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull SerpSpanProvider serpSpanProvider, @NotNull ScrollHandler.Listener listener, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ShopListDataChangeListener shopListDataChangeListener, boolean z) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(listener, "scrollHandlerListener");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(shopListDataChangeListener, "shopListDataChangeListener");
        int i2 = R.id.toolbar_search;
        View findViewById = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.x = new SearchBarImpl(findViewById, schedulersFactory3, null, 4, null);
        View findViewById2 = viewGroup.findViewById(R.id.shortcuts_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.y = new ShortcutNavigationBarImpl(findViewById2, null, null, z, 6, null);
        this.p = viewGroup;
        this.q = destroyableViewHolderBuilder;
        this.r = adapterPresenter;
        this.s = analytics;
        this.t = buildInfo;
        this.u = spannedGridPositionProvider;
        this.v = spanSizeLookup;
        this.w = serpSpanProvider;
        this.a = viewGroup.getResources().getDimensionPixelSize(R.dimen.toolbar_search_view_height);
        this.b = viewGroup.getResources().getDimensionPixelSize(com.avito.android.shop.R.dimen.shop_list_padding_top);
        this.c = viewGroup.getResources().getDimensionPixelSize(com.avito.android.shop.R.dimen.new_item_button_bottom_space);
        View findViewById3 = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.design.widget.search_view.ToolbarSearchViewImpl");
        ToolbarSearchViewImpl toolbarSearchViewImpl = (ToolbarSearchViewImpl) findViewById3;
        this.d = toolbarSearchViewImpl;
        int i3 = com.avito.android.shop.R.id.recycler_view;
        View findViewById4 = viewGroup.findViewById(i3);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.e = recyclerView;
        this.g = viewGroup.findViewById(16908292);
        View findViewById5 = viewGroup.findViewById(com.avito.android.shop.R.id.pull_refresh_layout);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById5;
        this.h = swipeRefreshLayout;
        View findViewById6 = viewGroup.findViewById(com.avito.android.shop.R.id.new_shop_view);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        PrimaryFloatingButtonImpl primaryFloatingButtonImpl = new PrimaryFloatingButtonImpl(findViewById6);
        this.i = primaryFloatingButtonImpl;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.k = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.l = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.m = create4;
        PublishRelay<Integer> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.n = create5;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.o = compositeDisposable;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int colorCompat = Contexts.getColorCompat(context, com.avito.android.lib.design.avito.R.color.expected_background);
        View findViewById7 = viewGroup.findViewById(com.avito.android.shop.R.id.progress_overlay_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById7, i3, analytics, false, colorCompat, 8, null);
        this.f = progressOverlay;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(viewGroup.getContext(), viewGroup.getResources().getInteger(R.integer.shop_list_columns));
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerViewScrollHandler(new ScrollHandler.Listener(this) { // from class: com.avito.android.shop.list.presentation.ShopListViewImpl.1
            public final /* synthetic */ ShopListViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.floating_views.ScrollHandler.Listener
            public void onVisibleItemChanged(int i4, int i5, int i6, int i7) {
                this.a.n.accept(Integer.valueOf(i4));
            }
        }, gridLayoutManager));
        recyclerView.addOnScrollListener(new RecyclerViewScrollHandler(listener, gridLayoutManager));
        progressOverlay.setOnRefreshListener(new a(0, this));
        toolbarSearchViewImpl.setNavigationIcon(R.drawable.ic_back_24_blue);
        toolbarSearchViewImpl.setMenu(com.avito.android.shop.R.menu.shop_list);
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context2);
        swipeRefreshLayout.setProgressViewOffset(true, (int) swipeRefreshLayout.getResources().getDimension(R.dimen.pull_refresh_offset_start), (int) swipeRefreshLayout.getResources().getDimension(R.dimen.pull_refresh_offset_end));
        Context context3 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        swipeRefreshLayout.setOnRefreshListener(new b(swipeRefreshLayout, this));
        primaryFloatingButtonImpl.setClickListener(new a(1, this));
        Drawable drawable2 = primaryFloatingButtonImpl.getView().getContext().getDrawable(R.drawable.ic_add_24);
        if (drawable2 != null) {
            Context context4 = primaryFloatingButtonImpl.getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "actionButton.view.context");
            drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.constantWhite));
        } else {
            drawable = null;
        }
        if (drawable != null) {
            primaryFloatingButtonImpl.setImageDrawable(drawable);
        }
        Disposables.plusAssign(compositeDisposable, Observables.subscribeOnNext(menuCallbacks(), new c(this)));
        shopListDataChangeListener.attachAdapterPresenter(adapterPresenter);
        shopListDataChangeListener.attachPositionsProvider(spannedGridPositionProvider);
        shopListDataChangeListener.attachSpanProvider(serpSpanProvider);
    }

    public static final void access$onMenu(ShopListViewImpl shopListViewImpl, int i2) {
        Objects.requireNonNull(shopListViewImpl);
        if (i2 == com.avito.android.shop.R.id.menu_clarify) {
            shopListViewImpl.l.accept(Unit.INSTANCE);
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    @NotNull
    public Observable<Unit> actionClickEvents() {
        return this.m;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void addBottomSpace() {
        Views.changePadding$default(this.e, 0, 0, 0, this.c, 7, null);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<Unit> allCategoriesClicks() {
        return this.y.allCategoriesClicks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void animateShortcutBar(boolean z, boolean z2) {
        this.y.animateShortcutBar(z, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void close() {
        this.x.close();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void dispose() {
        this.e.clearOnScrollListeners();
        this.o.clear();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    @NotNull
    public Observable<Integer> firstVisibleEvents() {
        return this.n;
    }

    @Override // com.avito.android.component.search.SearchBar
    @Nullable
    public String getQuery() {
        return this.x.getQuery();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void hideActionButton() {
        this.i.moveOut(false);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void hideEmptyView() {
        Views.hide(this.g);
        Views.show(this.e);
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void hideFloatingViews(boolean z) {
        animateShortcutBar(false, z);
        this.i.moveOut(z);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void hideLoading() {
        this.f.showContent();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void hideNavigationIcon() {
        this.x.hideNavigationIcon();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideShortcutBar() {
        this.y.hideShortcutBar();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void hideShortcutsWithShift() {
        hideShortcutBar();
        Views.changePadding$default(this.e, 0, this.a, 0, 0, 13, null);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideSkeleton() {
        this.y.hideSkeleton();
    }

    @Override // com.avito.android.component.search.SearchBar
    public boolean isVisible() {
        return this.x.isVisible();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.x.menuCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.x.navigationCallbacks();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void onDataChanged(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        if (this.e.getAdapter() == null) {
            GridLayoutAppendingAdapter gridLayoutAppendingAdapter = new GridLayoutAppendingAdapter(new SafeRecyclerAdapter(this.r, this.q, this.t, this.s), new GridLayoutAppendingHandler(appendingListener, this.u));
            gridLayoutAppendingAdapter.setHasStableIds(true);
            this.e.setAdapter(gridLayoutAppendingAdapter);
            return;
        }
        RecyclerView.Adapter adapter = this.e.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Boolean> openCallbacks() {
        return this.x.openCallbacks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void overrideVisibleBackground(@ColorInt int i2) {
        this.y.overrideVisibleBackground(i2);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    @NotNull
    public Observable<Unit> pullRefreshEvents() {
        return this.k;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    @NotNull
    public Observable<Unit> reloadEvents() {
        return this.j;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void removeBottomSpace() {
        Views.changePadding$default(this.e, 0, 0, 0, 0, 7, null);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemIcon(@IdRes int i2, @DrawableRes int i3, boolean z, boolean z2) {
        this.x.replaceMenuItemIcon(i2, i3, z, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemTitle(@IdRes int i2, @StringRes int i3) {
        this.x.replaceMenuItemTitle(i2, i3);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<DeepLink> resetActionClicks() {
        return this.y.resetActionClicks();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void resetShortcutBarPosition() {
        this.y.resetShortcutBarPosition();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void scrollToTop(boolean z) {
        if (z) {
            this.e.smoothScrollToPosition(0);
        } else {
            this.e.scrollToPosition(0);
        }
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    @NotNull
    public Observable<Unit> searchClarifyEvents() {
        return this.l;
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<SuggestAction> searchSuggestsCallbacks() {
        return this.x.searchSuggestsCallbacks();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void setActionText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.i.setText(str);
        this.i.setVisible(true);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.x.setHint(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setInvisibleSearch() {
        this.x.setInvisibleSearch();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenu(@MenuRes int i2) {
        this.x.setMenu(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuItemVisible(@IdRes int i2, boolean z) {
        this.x.setMenuItemVisible(i2, z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.x.setMenuTintColor(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.x.setMenuTintColorAttr(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setNavigationIcon(@DrawableRes int i2) {
        this.x.setNavigationIcon(i2);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void setPullRefreshEnabled(boolean z) {
        this.h.setEnabled(z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.x.setQuery(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setSearchEnabled(boolean z) {
        this.x.setSearchEnabled(z);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutItems(@Nullable Shortcuts.Header header, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.y.setShortcutItems(header, list);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutNavigationBarItems(@Nullable String str, @Nullable DeepLink deepLink, @Nullable Integer num, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.y.setShortcutNavigationBarItems(str, deepLink, num, list);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setSkeleton(@NotNull List<SkeletonItem> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.y.setSkeleton(list, z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setVisible(boolean z) {
        this.x.setVisible(z);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<ShortcutNavigationItem> shortcutClicks() {
        return this.y.shortcutClicks();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showActionButton() {
        this.i.moveIn(false);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showActionProgress() {
        this.x.showActionProgress();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showEmptyView() {
        Views.show(this.g);
        Views.hide(this.e);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.p, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void showFloatingViews(boolean z) {
        animateShortcutBar(true, z);
        this.i.moveIn(z);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showLoading() {
        this.f.showLoading();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showRetryOverlay() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSavedSearchesTooltipIfNeeded() {
        this.x.showSavedSearchesTooltipIfNeeded();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showSearchHintNoLocation() {
        String string = this.p.getResources().getString(com.avito.android.shop.R.string.shops_search);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString(R.string.shops_search)");
        this.d.setHint(string);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showSearchHintWithLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.LOCATION_NAME);
        String string = this.p.getResources().getString(com.avito.android.shop.R.string.shops_search_in, str);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…_search_in, locationName)");
        this.d.setHint(string);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSelectedFiltersCount(int i2) {
        this.x.showSelectedFiltersCount(i2);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void showShortcutBar() {
        this.y.showShortcutBar();
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void showShortcutsWithShift() {
        showShortcutBar();
        Views.changePadding$default(this.e, 0, this.b, 0, 0, 13, null);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showTapTarget(@IdRes int i2, @StringRes int i3, @StringRes @Nullable Integer num) {
        this.x.showTapTarget(i2, i3, num);
    }

    @Override // com.avito.android.shop.list.presentation.ShopListView
    public void stopPullRefresh() {
        this.h.setRefreshing(false);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<String> submitCallbacks() {
        return this.x.submitCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState) {
        Intrinsics.checkNotNullParameter(subscriptionButtonState, "subscriptionButtonState");
        this.x.toggleSubscriptionButton(subscriptionButtonState);
    }
}
