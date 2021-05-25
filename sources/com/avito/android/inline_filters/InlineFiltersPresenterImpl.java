package com.avito.android.inline_filters;

import a2.a.a.g1.c;
import a2.a.a.g1.d;
import a2.g.r.g;
import android.os.Parcelable;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.search.SearchBar;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.inline_filters.analytics.InlineFilterClickEvent;
import com.avito.android.inline_filters.di.InlineFiltersState;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpener;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.Header;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.InlineFiltersKt;
import com.avito.android.remote.model.search.Result;
import com.avito.android.remote.model.search.WidgetType;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import com.avito.android.util.rx3.Disposables;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFilterNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010p\u001a\u00020m\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010Y\u001a\u00020V\u0012\n\b\u0001\u0010v\u001a\u0004\u0018\u00010&¢\u0006\u0004\bw\u0010xJ=\u0010\u0006\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\t\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J=\u0010\u000b\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\n0\n \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\n0\n\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\"\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010\u0016J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J3\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0012H\u0002¢\u0006\u0004\b2\u0010\u0016RD\u00105\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010DR*\u0010K\u001a\u0016\u0012\u0004\u0012\u00020F\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0G\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\RD\u0010_\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u00104RD\u0010\u000b\u001a0\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\n0\n \u0004*\u0017\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\n0\n\u0018\u00010\u0002¢\u0006\u0002\b\u00050\u0002¢\u0006\u0002\b\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u00104R\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020a0G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR.\u0010/\u001a\u0004\u0018\u00010\u000f2\b\u0010q\u001a\u0004\u0018\u00010\u000f8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b-\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u00101¨\u0006y"}, d2 = {"Lcom/avito/android/inline_filters/InlineFiltersPresenterImpl;", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "inlineFilterSelected", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "", "inlineFiltersLoaded", "", "errors", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/InlineFilters;", "loadInlineFiltersObservable", "(Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/rxjava3/core/Observable;", "", "loadInlineFilters", "(Lcom/avito/android/remote/model/SearchParams;)V", "showInlineFilters", "()V", "Lru/avito/component/shortcut_navigation_bar/adapter/InlineFilterNavigationItem;", "item", UrlParams.SIMPLE_MAP, "openInlineFilter", "(Lru/avito/component/shortcut_navigation_bar/adapter/InlineFilterNavigationItem;Lcom/avito/android/remote/model/SearchParams;Z)V", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "shortcutNavigationBar", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "inlineFilterDialogOpener", "Lcom/avito/android/component/search/SearchBar;", "searchBar", "attachViews", "(Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;Lcom/avito/android/component/search/SearchBar;)V", "detachViews", "invalidate", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/remote/model/search/Filter;", "filter", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "selectedValue", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/InlineFilterValue;Lcom/avito/android/remote/model/SearchParams;Z)V", "inlineFilters", "d", "(Lcom/avito/android/remote/model/search/InlineFilters;)V", "c", "h", "Lcom/jakewharton/rxrelay3/PublishRelay;", "inlineFilterSelectConsumer", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "p", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "shortcutNavigationConverter", "Lcom/avito/android/serp/InlineFiltersInteractor;", "o", "Lcom/avito/android/serp/InlineFiltersInteractor;", "inlineFiltersInteractor", "Lcom/avito/android/analytics/Analytics;", "s", "Lcom/avito/android/analytics/Analytics;", "analytics", "f", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "", "", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "l", "Ljava/util/Map;", "convertedItems", "Z", "isLoading", "Landroid/os/Parcelable;", "n", "Landroid/os/Parcelable;", "viewState", "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", VKApiConst.Q, "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", "inlineFiltersDialogItemConverter", "Lcom/avito/android/serp/analytics/SerpTracker;", "t", "Lcom/avito/android/serp/analytics/SerpTracker;", "tracker", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", g.a, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "i", "inlineFiltersLoadedConsumer", "j", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "items", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/SearchParams;", "openedFilterParams", "e", "Lcom/avito/android/component/search/SearchBar;", "k", "Lcom/avito/android/remote/model/search/Filter;", "openedFilter", "Lcom/avito/android/util/SchedulersFactory3;", "r", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "value", "Lcom/avito/android/remote/model/search/InlineFilters;", "getInlineFilters", "()Lcom/avito/android/remote/model/search/InlineFilters;", "setInlineFilters", "state", "<init>", "(Lcom/avito/android/serp/InlineFiltersInteractor;Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/analytics/SerpTracker;Lcom/avito/android/util/Kundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersPresenterImpl implements InlineFiltersPresenter {
    @Nullable
    public InlineFilters a;
    public List<? extends ShortcutNavigationItem> b = CollectionsKt__CollectionsKt.emptyList();
    public boolean c;
    public ShortcutNavigationBar d;
    public SearchBar e;
    public InlineFilterDialogOpener f;
    public final CompositeDisposable g = new CompositeDisposable();
    public final PublishRelay<DeepLink> h = PublishRelay.create();
    public final PublishRelay<Boolean> i = PublishRelay.create();
    public final PublishRelay<Throwable> j = PublishRelay.create();
    public Filter k;
    public Map<String, List<InlineFiltersDialogItem>> l = new HashMap();
    public SearchParams m;
    public Parcelable n;
    public final InlineFiltersInteractor o;
    public final ShortcutNavigationItemConverter p;
    public final InlineFiltersDialogItemConverter q;
    public final SchedulersFactory3 r;
    public final Analytics s;
    public final SerpTracker t;

    public static final class a<T> implements Consumer<InlineFilters> {
        public final /* synthetic */ InlineFiltersPresenterImpl a;

        public a(InlineFiltersPresenterImpl inlineFiltersPresenterImpl) {
            this.a = inlineFiltersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(InlineFilters inlineFilters) {
            InlineFilters inlineFilters2 = inlineFilters;
            this.a.c = false;
            this.a.setInlineFilters(inlineFilters2);
            this.a.showInlineFilters();
            PublishRelay publishRelay = this.a.h;
            Result result = inlineFilters2.getResult();
            publishRelay.accept(result != null ? result.getUri() : null);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ InlineFiltersPresenterImpl a;

        public b(InlineFiltersPresenterImpl inlineFiltersPresenterImpl) {
            this.a = inlineFiltersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error(th2);
            this.a.j.accept(th2);
        }
    }

    @Inject
    public InlineFiltersPresenterImpl(@NotNull InlineFiltersInteractor inlineFiltersInteractor, @NotNull ShortcutNavigationItemConverter shortcutNavigationItemConverter, @NotNull InlineFiltersDialogItemConverter inlineFiltersDialogItemConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull SerpTracker serpTracker, @InlineFiltersState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(inlineFiltersInteractor, "inlineFiltersInteractor");
        Intrinsics.checkNotNullParameter(shortcutNavigationItemConverter, "shortcutNavigationConverter");
        Intrinsics.checkNotNullParameter(inlineFiltersDialogItemConverter, "inlineFiltersDialogItemConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(serpTracker, "tracker");
        this.o = inlineFiltersInteractor;
        this.p = shortcutNavigationItemConverter;
        this.q = inlineFiltersDialogItemConverter;
        this.r = schedulersFactory3;
        this.s = analytics;
        this.t = serpTracker;
        Parcelable parcelable = null;
        State state = kundle != null ? (State) kundle.getParcelable("InlineFiltersState") : null;
        setInlineFilters(state != null ? state.getInlineFilters() : null);
        this.k = state != null ? state.getOpenedFilter() : null;
        this.m = state != null ? state.getSearchParams() : null;
        this.n = state != null ? state.getViewState() : parcelable;
    }

    public static void b(InlineFiltersPresenterImpl inlineFiltersPresenterImpl, Filter filter, SearchParams searchParams, Parcelable parcelable, boolean z, int i2) {
        List<InlineFiltersDialogItem> list;
        if ((i2 & 4) != 0) {
            parcelable = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        Map<String, List<InlineFiltersDialogItem>> map = inlineFiltersPresenterImpl.l;
        if (map == null || (list = map.get(filter.getId())) == null) {
            list = inlineFiltersPresenterImpl.q.convertItems(filter);
        }
        InlineFilterDialogOpener inlineFilterDialogOpener = inlineFiltersPresenterImpl.f;
        if (inlineFilterDialogOpener != null) {
            InlineFilterDialogOpener.DefaultImpls.show$default(inlineFilterDialogOpener, filter, list, parcelable, new c(inlineFiltersPresenterImpl, filter, searchParams, z), new d(inlineFiltersPresenterImpl), null, 32, null);
        }
    }

    public final void a(Filter filter, InlineFilterValue inlineFilterValue, SearchParams searchParams, boolean z) {
        this.c = true;
        this.g.clear();
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.o.applyInlineFilters(filter, inlineFilterValue, searchParams, z).observeOn(this.r.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "inlineFiltersInteractor\n…accept(it)\n            })");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void attachViews(@NotNull ShortcutNavigationBar shortcutNavigationBar, @NotNull InlineFilterDialogOpener inlineFilterDialogOpener, @NotNull SearchBar searchBar) {
        Intrinsics.checkNotNullParameter(shortcutNavigationBar, "shortcutNavigationBar");
        Intrinsics.checkNotNullParameter(inlineFilterDialogOpener, "inlineFilterDialogOpener");
        Intrinsics.checkNotNullParameter(searchBar, "searchBar");
        this.d = shortcutNavigationBar;
        this.e = searchBar;
        this.f = inlineFilterDialogOpener;
        c();
        InlineFilters inlineFilters = getInlineFilters();
        if (inlineFilters != null) {
            d(inlineFilters);
        }
        Filter filter = this.k;
        if (filter != null) {
            b(this, filter, this.m, this.n, false, 8);
        }
    }

    public final void c() {
        Result result;
        Header header;
        Integer selectedFiltersCount;
        InlineFilters inlineFilters = getInlineFilters();
        if (inlineFilters != null && (result = inlineFilters.getResult()) != null && (header = result.getHeader()) != null && (selectedFiltersCount = header.getSelectedFiltersCount()) != null) {
            int intValue = selectedFiltersCount.intValue();
            SearchBar searchBar = this.e;
            if (searchBar != null) {
                searchBar.showSelectedFiltersCount(intValue);
            }
        }
    }

    public final void d(InlineFilters inlineFilters) {
        Header header;
        Header header2;
        Header header3;
        this.b = this.p.convert(inlineFilters);
        this.t.startShortcutsPrepare();
        Result result = inlineFilters.getResult();
        Integer num = null;
        String title = (result == null || (header3 = result.getHeader()) == null) ? null : header3.getTitle();
        Result result2 = inlineFilters.getResult();
        DeepLink resetAction = (result2 == null || (header2 = result2.getHeader()) == null) ? null : header2.getResetAction();
        Result result3 = inlineFilters.getResult();
        if (!(result3 == null || (header = result3.getHeader()) == null)) {
            num = header.getItemsCount();
        }
        List<? extends ShortcutNavigationItem> list = this.b;
        c();
        this.t.trackShortcutsPrepare();
        ShortcutNavigationBar shortcutNavigationBar = this.d;
        if (shortcutNavigationBar != null) {
            shortcutNavigationBar.setShortcutNavigationBarItems(title, resetAction, num, list);
        }
        this.t.trackShortcutsDraw();
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void detachViews() {
        this.d = null;
        this.e = null;
        InlineFilterDialogOpener inlineFilterDialogOpener = this.f;
        if (inlineFilterDialogOpener != null) {
            inlineFilterDialogOpener.dismiss();
        }
        this.f = null;
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    @Nullable
    public InlineFilters getInlineFilters() {
        return this.a;
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void invalidate() {
        setInlineFilters(null);
        this.k = null;
        this.m = null;
        this.n = null;
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void loadInlineFilters(@Nullable SearchParams searchParams) {
        SearchParams searchParams2;
        Map emptyMap = r.emptyMap();
        this.c = true;
        CompositeDisposable compositeDisposable = this.g;
        InlineFiltersInteractor inlineFiltersInteractor = this.o;
        if (searchParams != null) {
            searchParams2 = searchParams;
        } else {
            searchParams2 = new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        }
        Disposable subscribe = InlineFiltersInteractor.DefaultImpls.loadInlineFilters$default(inlineFiltersInteractor, searchParams2, emptyMap, false, 4, null).observeOn(this.r.mainThread()).subscribe(new a2.a.a.g1.a(this), new a2.a.a.g1.b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "inlineFiltersInteractor.…accept(it)\n            })");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    @NotNull
    public Observable<InlineFilters> loadInlineFiltersObservable(@Nullable SearchParams searchParams) {
        SearchParams searchParams2;
        InlineFiltersInteractor inlineFiltersInteractor = this.o;
        if (searchParams != null) {
            searchParams2 = searchParams;
        } else {
            searchParams2 = new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        }
        return a2.b.a.a.a.b2(this.r, InlineFiltersInteractor.DefaultImpls.loadInlineFilters$default(inlineFiltersInteractor, searchParams2, r.emptyMap(), false, 4, null), "inlineFiltersInteractor.…(schedulers.mainThread())");
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        InlineFilters inlineFilters = getInlineFilters();
        Filter filter = this.k;
        SearchParams searchParams = this.m;
        InlineFilterDialogOpener inlineFilterDialogOpener = this.f;
        kundle.putParcelable("InlineFiltersState", new State(inlineFilters, filter, searchParams, inlineFilterDialogOpener != null ? inlineFilterDialogOpener.onSaveState() : null));
        return kundle;
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void openInlineFilter(@NotNull InlineFilterNavigationItem inlineFilterNavigationItem, @NotNull SearchParams searchParams, boolean z) {
        Filter filter;
        Filter.InnerOptions.Options firstOption;
        Result result;
        Header header;
        Result result2;
        Header header2;
        Result result3;
        Header header3;
        Intrinsics.checkNotNullParameter(inlineFilterNavigationItem, "item");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        if (this.k == null && (filter = inlineFilterNavigationItem.getFilter()) != null) {
            String categoryId = searchParams.getCategoryId();
            String id = filter.getId();
            String title = filter.getTitle();
            if (!(categoryId == null || id == null || title == null)) {
                this.s.track(new InlineFilterClickEvent(categoryId, id, title));
            }
            Filter.Widget widget = filter.getWidget();
            String str = null;
            if ((widget != null ? widget.getType() : null) != WidgetType.Checkbox) {
                this.k = filter;
                this.m = searchParams;
                b(this, filter, searchParams, null, z, 4);
            } else if (!this.c) {
                for (T t2 : this.b) {
                    if (t2 instanceof InlineFilterNavigationItem) {
                        T t3 = t2;
                        Filter filter2 = t3.getFilter();
                        if (Intrinsics.areEqual(filter2 != null ? filter2.getId() : null, filter.getId())) {
                            t3.toggleStateIfPossible();
                        }
                    }
                }
                InlineFilters inlineFilters = getInlineFilters();
                String title2 = (inlineFilters == null || (result3 = inlineFilters.getResult()) == null || (header3 = result3.getHeader()) == null) ? null : header3.getTitle();
                InlineFilters inlineFilters2 = getInlineFilters();
                DeepLink resetAction = (inlineFilters2 == null || (result2 = inlineFilters2.getResult()) == null || (header2 = result2.getHeader()) == null) ? null : header2.getResetAction();
                InlineFilters inlineFilters3 = getInlineFilters();
                Integer itemsCount = (inlineFilters3 == null || (result = inlineFilters3.getResult()) == null || (header = result.getHeader()) == null) ? null : header.getItemsCount();
                List<? extends ShortcutNavigationItem> list = this.b;
                c();
                this.t.trackShortcutsPrepare();
                ShortcutNavigationBar shortcutNavigationBar = this.d;
                if (shortcutNavigationBar != null) {
                    shortcutNavigationBar.setShortcutNavigationBarItems(title2, resetAction, itemsCount, list);
                }
                this.t.trackShortcutsDraw();
                if (filter.getValue() == null && (firstOption = InlineFiltersKt.firstOption(filter)) != null) {
                    str = firstOption.getId();
                }
                a(filter, new InlineFilterValue.InlineFilterSelectValue(str), searchParams, z);
            }
        }
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void setInlineFilters(@Nullable InlineFilters inlineFilters) {
        Result result;
        List<Filter> filters;
        Map<String, List<InlineFiltersDialogItem>> map;
        this.a = inlineFilters;
        InlineFilters inlineFilters2 = getInlineFilters();
        if (!(inlineFilters2 == null || (result = inlineFilters2.getResult()) == null || (filters = result.getFilters()) == null)) {
            for (T t2 : filters) {
                String id = t2.getId();
                if (!(id == null || (map = this.l) == null)) {
                    map.put(id, this.q.convertItems(t2));
                }
            }
        }
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public void showInlineFilters() {
        InlineFilters inlineFilters = getInlineFilters();
        if (inlineFilters != null) {
            d(inlineFilters);
        }
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public PublishRelay<Throwable> errors() {
        return this.j;
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public PublishRelay<DeepLink> inlineFilterSelected() {
        return this.h;
    }

    @Override // com.avito.android.inline_filters.InlineFiltersPresenter
    public PublishRelay<Boolean> inlineFiltersLoaded() {
        return this.i;
    }
}
