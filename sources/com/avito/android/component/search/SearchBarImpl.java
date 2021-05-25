package com.avito.android.component.search;

import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.avito.android.component.search.list.BubblesItemBlueprint;
import com.avito.android.component.search.list.BubblesItemPresenter;
import com.avito.android.component.search.list.GapItemBlueprint;
import com.avito.android.component.search.list.GapItemPresenter;
import com.avito.android.component.search.list.TextSearchItemBlueprint;
import com.avito.android.component.search.list.TextSearchItemPresenter;
import com.avito.android.component.search.list.TitleItemBlueprint;
import com.avito.android.component.search.list.TitleItemPresenter;
import com.avito.android.design.widget.lifecycle_view.AttachListener;
import com.avito.android.design.widget.lifecycle_view.LifecycleView;
import com.avito.android.design.widget.lifecycle_view.StateListener;
import com.avito.android.design.widget.search_view.SubscriptionButtonState;
import com.avito.android.design.widget.search_view.ToolbarSearchView;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.BubblesSuggestItem;
import com.avito.android.remote.model.search.suggest.GapSuggestItem;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestDeeplink;
import com.avito.android.remote.model.search.suggest.SuggestItem;
import com.avito.android.remote.model.search.suggest.SuggestNewQuery;
import com.avito.android.remote.model.search.suggest.TextSuggestItem;
import com.avito.android.remote.model.search.suggest.TitleSuggestItem;
import com.avito.android.ui_components.R;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.share.internal.ShareConstants;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010l\u001a\u00020i\u0012\u0006\u0010s\u001a\u00020p\u0012\b\b\u0002\u0010e\u001a\u00020b¢\u0006\u0004\b~\u0010J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0007J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0007J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0007J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u000bJ\u0011\u0010(\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\u000bJ\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\"H\u0016¢\u0006\u0004\b1\u0010%J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\"H\u0016¢\u0006\u0004\b3\u0010%J\u0019\u00105\u001a\u00020\u00052\b\b\u0001\u00104\u001a\u00020\"H\u0016¢\u0006\u0004\b5\u0010%J\u0019\u00107\u001a\u00020\u00052\b\b\u0001\u00106\u001a\u00020\"H\u0016¢\u0006\u0004\b7\u0010%J\u001f\u0010:\u001a\u00020\u00052\u0006\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020,H\u0016¢\u0006\u0004\b:\u0010;J/\u0010?\u001a\u00020\u00052\u0006\u00108\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020,H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010B\u001a\u00020\u00052\u0006\u00108\u001a\u00020\"2\u0006\u0010A\u001a\u00020\"H\u0016¢\u0006\u0004\bB\u0010CJ\u0015\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0016¢\u0006\u0004\bD\u0010\u001fJ\u0015\u0010E\u001a\b\u0012\u0004\u0012\u00020\"0\u001dH\u0016¢\u0006\u0004\bE\u0010\u001fJ\u0015\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016¢\u0006\u0004\bF\u0010\u001fJ\u0015\u0010G\u001a\b\u0012\u0004\u0012\u00020,0\u001dH\u0016¢\u0006\u0004\bG\u0010\u001fJ\u0017\u0010H\u001a\u00020\u00052\u0006\u00109\u001a\u00020,H\u0016¢\u0006\u0004\bH\u0010/J\u000f\u0010I\u001a\u00020,H\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0005H\u0016¢\u0006\u0004\bK\u0010\u0007J/\u0010O\u001a\u00020\u00052\b\b\u0001\u0010L\u001a\u00020\"2\b\b\u0001\u0010M\u001a\u00020\"2\n\b\u0001\u0010N\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0005H\u0016¢\u0006\u0004\bQ\u0010\u0007J\u000f\u0010R\u001a\u00020\u0005H\u0016¢\u0006\u0004\bR\u0010\u0007J\u0017\u0010U\u001a\u00020\u00052\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010aR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010nR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010aR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\"\u0010y\u001a\u00020t8\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010u\u0012\u0004\bx\u0010\u0007\u001a\u0004\bv\u0010wR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006\u0001"}, d2 = {"Lcom/avito/android/component/search/SearchBarImpl;", "Lcom/avito/android/component/search/SearchBar;", "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", "Lcom/avito/android/design/widget/lifecycle_view/StateListener;", "Lcom/avito/android/component/search/SuggestItemListener;", "", AuthSource.BOOKING_ORDER, "()V", "", "query", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, "d", "(Ljava/util/List;)V", "c", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "actions", "onItemClicked", "Lcom/avito/android/util/Kundle;", "state", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onAttach", "onDetach", "Lio/reactivex/rxjava3/core/Observable;", "searchSuggestsCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "close", "showActionProgress", "", "count", "showSelectedFiltersCount", "(I)V", "text", "setQuery", "getQuery", "()Ljava/lang/String;", "hint", "setHint", "", "enabled", "setSearchEnabled", "(Z)V", "drawableRes", "setNavigationIcon", "menuId", "setMenu", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "itemId", "visible", "setMenuItemVisible", "(IZ)V", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "(II)V", "navigationCallbacks", "menuCallbacks", "submitCallbacks", "openCallbacks", "setVisible", "isVisible", "()Z", "setInvisibleSearch", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "hideNavigationIcon", "showSavedSearchesTooltipIfNeeded", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "h", "Ljava/lang/String;", "savedQuery", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", a2.g.r.g.a, "suggestionActionDisposables", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/component/search/SuggestInteractor;", "l", "Lcom/avito/android/component/search/SuggestInteractor;", "interactor", "i", "Ljava/util/List;", "suggests", "Landroid/view/View;", "j", "Landroid/view/View;", "rootView", "Lcom/avito/android/design/widget/search_view/ToolbarSearchView;", "Lcom/avito/android/design/widget/search_view/ToolbarSearchView;", "view", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter$annotations", "adapterPresenter", "Lio/reactivex/rxjava3/disposables/Disposable;", "f", "Lio/reactivex/rxjava3/disposables/Disposable;", "suggestionDisposable", "<init>", "(Landroid/view/View;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/component/search/SuggestInteractor;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SearchBarImpl implements SearchBar, AttachListener, StateListener, SuggestItemListener {
    public final ToolbarSearchView a;
    @NotNull
    public final AdapterPresenter b;
    public final PublishRelay<SuggestAction> c;
    public final PublishRelay<String> d;
    public final CompositeDisposable e;
    public Disposable f;
    public CompositeDisposable g;
    public String h;
    public List<? extends SuggestItem> i;
    public final View j;
    public final SchedulersFactory3 k;
    public final SuggestInteractor l;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<List<? extends SuggestItem>> {
        public final /* synthetic */ SearchBarImpl a;

        public b(SearchBarImpl searchBarImpl) {
            this.a = searchBarImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends SuggestItem> list) {
            List<? extends SuggestItem> list2 = list;
            SearchBarImpl searchBarImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            searchBarImpl.d(list2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ SearchBarImpl a;

        public c(SearchBarImpl searchBarImpl) {
            this.a = searchBarImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            SearchBarImpl.access$onFailedToLoadSuggest(this.a);
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SearchBarImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SearchBarImpl searchBarImpl) {
            super(0);
            this.a = searchBarImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.setQuery("");
            SearchBarImpl.access$onResetSearch(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer<String> {
        public final /* synthetic */ SearchBarImpl a;

        public e(SearchBarImpl searchBarImpl) {
            this.a = searchBarImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            SearchBarImpl searchBarImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            SearchBarImpl.access$onQueryChanged(searchBarImpl, str2);
        }
    }

    public static final class f<T> implements Consumer<Boolean> {
        public final /* synthetic */ SearchBarImpl a;

        public f(SearchBarImpl searchBarImpl) {
            this.a = searchBarImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            SearchBarImpl searchBarImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            SearchBarImpl.access$reloadSuggestsIfNeeded(searchBarImpl, bool2.booleanValue());
        }
    }

    public static final class g<T> implements Consumer<String> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            LastClick.Updater.update();
        }
    }

    public SearchBarImpl(@NotNull View view, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SuggestInteractor suggestInteractor) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(suggestInteractor, "interactor");
        this.j = view;
        this.k = schedulersFactory3;
        this.l = suggestInteractor;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.search_view.ToolbarSearchView");
        ToolbarSearchView toolbarSearchView = (ToolbarSearchView) view;
        this.a = toolbarSearchView;
        PublishRelay<SuggestAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
        PublishRelay<String> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.d = create2;
        this.e = new CompositeDisposable();
        this.g = new CompositeDisposable();
        this.i = CollectionsKt__CollectionsKt.emptyList();
        View findViewById = view.findViewById(R.id.toolbar_lifecycle);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.design.widget.lifecycle_view.LifecycleView");
        LifecycleView lifecycleView = (LifecycleView) findViewById;
        lifecycleView.setAttachListener(this);
        lifecycleView.setStateListener(this);
        TextSearchItemBlueprint textSearchItemBlueprint = new TextSearchItemBlueprint(new TextSearchItemPresenter(this));
        GapItemBlueprint gapItemBlueprint = new GapItemBlueprint(new GapItemPresenter());
        TitleItemBlueprint titleItemBlueprint = new TitleItemBlueprint(new TitleItemPresenter());
        ItemBinder build = new ItemBinder.Builder().registerItem(textSearchItemBlueprint).registerItem(gapItemBlueprint).registerItem(titleItemBlueprint).registerItem(new BubblesItemBlueprint(new BubblesItemPresenter(this))).build();
        SimpleAdapterPresenter simpleAdapterPresenter = new SimpleAdapterPresenter(build, build);
        this.b = simpleAdapterPresenter;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(simpleAdapterPresenter, build);
        simpleRecyclerAdapter.setHasStableIds(true);
        toolbarSearchView.setAdapter(simpleRecyclerAdapter);
        if (ViewCompat.isAttachedToWindow(lifecycleView)) {
            c();
        }
    }

    public static final void access$onFailedToLoadSuggest(SearchBarImpl searchBarImpl) {
        Objects.requireNonNull(searchBarImpl);
        searchBarImpl.d(CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$onQueryChanged(com.avito.android.component.search.SearchBarImpl r3, java.lang.String r4) {
        /*
            java.lang.String r0 = r3.h
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            if (r0 != 0) goto L_0x001f
            int r0 = r4.length()
            if (r0 != 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 == 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 != 0) goto L_0x0049
            int r0 = r4.length()
            if (r0 != 0) goto L_0x002a
            r0 = 1
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r3.h
            if (r0 == 0) goto L_0x003a
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r0 = 0
            goto L_0x003b
        L_0x003a:
            r0 = 1
        L_0x003b:
            if (r0 != 0) goto L_0x0047
        L_0x003d:
            java.lang.String r0 = r3.h
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0047
            r1 = 1
        L_0x0047:
            if (r1 == 0) goto L_0x004e
        L_0x0049:
            r3.h = r4
            r3.a(r4)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.component.search.SearchBarImpl.access$onQueryChanged(com.avito.android.component.search.SearchBarImpl, java.lang.String):void");
    }

    public static final void access$onResetSearch(SearchBarImpl searchBarImpl) {
        Disposable disposable = searchBarImpl.f;
        if (disposable != null) {
            disposable.dispose();
        }
        searchBarImpl.b();
        searchBarImpl.e.clear();
        searchBarImpl.c();
        searchBarImpl.h = null;
    }

    public static final void access$reloadSuggestsIfNeeded(SearchBarImpl searchBarImpl, boolean z) {
        Objects.requireNonNull(searchBarImpl);
        if (z) {
            searchBarImpl.d(CollectionsKt__CollectionsKt.emptyList());
            String str = searchBarImpl.h;
            if (str == null) {
                str = "";
            }
            searchBarImpl.a(str);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getAdapterPresenter$annotations() {
    }

    public final void a(String str) {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = this.l.loadSuggestions(str).observeOn(this.k.mainThread()).subscribe(new b(this), new c(this));
    }

    public final void b() {
        this.i = CollectionsKt__CollectionsKt.emptyList();
        a2.b.a.a.a.s1(CollectionsKt__CollectionsKt.emptyList(), this.b);
        this.a.notifyDataSetChanged();
    }

    public final void c() {
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.a.textChangeCallbacks().observeOn(this.k.mainThread()).subscribe(new e(this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.textChangeCallbacks…t) }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.e;
        Disposable subscribe2 = this.a.openCallbacks().subscribe(new f(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view\n            .openCa…t) }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.e;
        Disposable subscribe3 = this.a.submitCallbacks().observeOn(this.k.mainThread()).doOnNext(g.a).subscribe(this.d);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.submitCallbacks()\n …ubscribe(submitCallbacks)");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void close() {
        this.a.close();
    }

    public final void d(List<? extends SuggestItem> list) {
        Object obj;
        this.i = list;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            String valueOf = String.valueOf(i2);
            if (t2 instanceof TextSuggestItem) {
                obj = new TextSearchItem(valueOf, t2);
            } else if (t2 instanceof BubblesSuggestItem) {
                obj = new BubblesSearchItem(valueOf, t2);
            } else if (t2 instanceof GapSuggestItem) {
                obj = new GapSearchItem(valueOf, t2);
            } else if (t2 instanceof TitleSuggestItem) {
                obj = new TitleSearchItem(valueOf, t2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
            i2 = i3;
        }
        this.b.onDataSourceChanged(new ListDataSource(arrayList));
        this.a.notifyDataSetChanged();
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.b;
    }

    @Override // com.avito.android.component.search.SearchBar
    @Nullable
    public String getQuery() {
        return this.a.getQuery();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void hideNavigationIcon() {
        this.a.hideNavigationIcon();
    }

    @Override // com.avito.android.component.search.SearchBar
    public boolean isVisible() {
        return this.j.getVisibility() == 0;
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.a.menuCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.a.navigationCallbacks();
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onAttach() {
        c();
        if (!this.i.isEmpty()) {
            d(this.i);
        } else {
            b();
        }
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onDetach() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e.clear();
        this.g.clear();
    }

    @Override // com.avito.android.component.search.SuggestItemListener
    public void onItemClicked(@NotNull List<? extends SuggestAction> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        for (T t : list) {
            this.c.accept(t);
            if (t instanceof SuggestNewQuery) {
                this.a.updateActiveQuery(t.getQuery());
            } else if (t instanceof SuggestDeeplink) {
                this.a.showActionProgress();
                this.a.closeDelayed(new d(this));
            }
        }
    }

    @Override // com.avito.android.design.widget.lifecycle_view.StateListener
    public void onRestoreState(@Nullable Kundle kundle) {
        if (kundle != null) {
            this.h = kundle.getString("saved_query");
            List<? extends SuggestItem> parcelableList = kundle.getParcelableList("suggests");
            if (parcelableList == null) {
                parcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            this.i = parcelableList;
            d(parcelableList);
        }
    }

    @Override // com.avito.android.design.widget.lifecycle_view.StateListener
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("saved_query", this.h).putParcelableList("suggests", this.i);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Boolean> openCallbacks() {
        return this.a.openCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemIcon(int i2, int i3, boolean z, boolean z2) {
        this.a.replaceMenuItemIcon(i2, i3, z, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemTitle(int i2, int i3) {
        this.a.replaceMenuItemTitle(i2, i3);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<SuggestAction> searchSuggestsCallbacks() {
        return this.c;
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.a.setHint(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setInvisibleSearch() {
        this.a.removeHint();
        setSearchEnabled(false);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenu(int i2) {
        this.a.setMenu(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuItemVisible(int i2, boolean z) {
        this.a.setMenuItemVisible(i2, z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.a.setMenuTintColor(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.a.setMenuTintColorAttr(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setNavigationIcon(int i2) {
        this.a.setNavigationIcon(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a.setQuery(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setSearchEnabled(boolean z) {
        this.a.setSearchEnabled(z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setVisible(boolean z) {
        Views.setVisible(this.j, z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showActionProgress() {
        this.a.showActionProgress();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSavedSearchesTooltipIfNeeded() {
        String string = this.j.getContext().getString(R.string.saved_searches_tooltip_text);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri…ed_searches_tooltip_text)");
        this.a.showTooltipToMenuItem(R.id.menu_subscription, string);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSelectedFiltersCount(int i2) {
        this.a.showSelectedFiltersCount(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showTapTarget(@IdRes int i2, @StringRes int i3, @StringRes @Nullable Integer num) {
        this.a.showTapTarget(i2, i3, num);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<String> submitCallbacks() {
        return this.d;
    }

    @Override // com.avito.android.component.search.SearchBar
    public void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState) {
        Intrinsics.checkNotNullParameter(subscriptionButtonState, "subscriptionButtonState");
        this.a.toggleSubscriptionButton(subscriptionButtonState);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchBarImpl(View view, SchedulersFactory3 schedulersFactory3, SuggestInteractor suggestInteractor, int i2, j jVar) {
        this(view, schedulersFactory3, (i2 & 4) != 0 ? new EmptySuggestInteractor() : suggestInteractor);
    }
}
