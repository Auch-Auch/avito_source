package com.avito.android.profile.sessions.list;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile.R;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BD\u0012\u0006\u0010~\u001a\u00020{\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010z\u001a\u00020w\u0012\u0007\u0010\u0001\u001a\u00020\u0002\u0012\u0006\u0010r\u001a\u00020\u0003\u0012\u0006\u0010]\u001a\u00020\u0004\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\rJY\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\rJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0006H\u0001¢\u0006\u0004\b'\u0010\rJ\u0010\u0010(\u001a\u00020$H\u0001¢\u0006\u0004\b(\u0010&J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005H\u0001¢\u0006\u0004\b)\u0010\bJ\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0001¢\u0006\u0004\b*\u0010\bJ.\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00132\b\b\u0001\u0010,\u001a\u00020\u00132\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000100H\u0001¢\u0006\u0004\b2\u00103J\u001a\u00105\u001a\u00020\u00062\b\b\u0001\u00104\u001a\u00020\u0013H\u0001¢\u0006\u0004\b5\u00106J\u001a\u00108\u001a\u00020\u00062\b\b\u0001\u00107\u001a\u00020\u0013H\u0001¢\u0006\u0004\b8\u00106J\u001a\u0010:\u001a\u00020\u00062\b\b\u0001\u00109\u001a\u00020\u0013H\u0001¢\u0006\u0004\b:\u00106J&\u0010=\u001a\u00020\u00062\b\b\u0001\u0010;\u001a\u00020\u00132\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b=\u0010>J\u0018\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020$H\u0001¢\u0006\u0004\b@\u0010AJ\u0018\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0001¢\u0006\u0004\bD\u0010EJ\u001a\u0010D\u001a\u00020\u00062\b\b\u0001\u0010F\u001a\u00020\u0013H\u0001¢\u0006\u0004\bD\u00106J\u0018\u0010G\u001a\u00020\u00062\u0006\u0010?\u001a\u00020$H\u0001¢\u0006\u0004\bG\u0010AJ\u001e\u0010K\u001a\u00020\u00062\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0HH\u0001¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\u0006H\u0001¢\u0006\u0004\bM\u0010\rJ\u0010\u0010N\u001a\u00020\u0006H\u0001¢\u0006\u0004\bN\u0010\rJ\u0010\u0010O\u001a\u00020$H\u0001¢\u0006\u0004\bO\u0010&J\u0018\u0010Q\u001a\u00020\u00062\u0006\u0010P\u001a\u00020$H\u0001¢\u0006\u0004\bQ\u0010AJ\u001e\u0010S\u001a\u00020\u00062\f\u0010J\u001a\b\u0012\u0004\u0012\u00020R0HH\u0001¢\u0006\u0004\bS\u0010LJ\u0010\u0010T\u001a\u00020\u0006H\u0001¢\u0006\u0004\bT\u0010\rJ\u0018\u0010V\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0011H\u0001¢\u0006\u0004\bV\u0010#R\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010dR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bs\u0010\bR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bu\u0010\bR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200\u00058\u0016@\u0016X\u0005¢\u0006\u0007\u001a\u0005\b\u0001\u0010\bR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListViewImpl;", "Lcom/avito/android/profile/sessions/list/SessionsListView;", "Lru/avito/component/appbar/AppBar;", "Lcom/avito/android/profile/sessions/list/SessionsMenuView;", "Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationView;", "Lio/reactivex/rxjava3/core/Observable;", "", "refreshClicks", "()Lio/reactivex/rxjava3/core/Observable;", "errorRetryClicks", "networkErrorRetryClicks", "getNavigationCallbacks", "onDataChanged", "()V", "showProgress", "hideProgress", "stopRefreshing", "", "text", "", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "showError", "message", "showNetworkError", "(Ljava/lang/String;)V", "", "canShowSnackbar", "()Z", "hideActionsMenu", "isVisible", "menuCallbacks", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "closeMenu", "isShowing", "isInProgress", "showLogoutInProgress", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", "showMenu", "closeConfirmationMenu", "description", "showConfirmationMenu", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "h", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "l", "Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationView;", "logoutMenu", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "d", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Landroid/view/View;", "f", "Landroid/view/View;", "errorContainer", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "e", "retryButton", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "k", "Lcom/avito/android/profile/sessions/list/SessionsMenuView;", "menuView", "getChangePasswordClicks", "changePasswordClicks", "getDismissEvents", "dismissEvents", "Lcom/avito/konveyor/ItemBinder;", "i", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroid/view/ViewGroup;", g.a, "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/deep_linking/links/DeepLink;", "getActionClicks", "actionClicks", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "j", "Lru/avito/component/appbar/AppBar;", "appBar", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lru/avito/component/appbar/AppBar;Lcom/avito/android/profile/sessions/list/SessionsMenuView;Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationView;Lcom/avito/android/analytics/Analytics;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsListViewImpl implements SessionsListView, AppBar, SessionsMenuView, SessionLogoutConfirmationView {
    public final Context a;
    public final RecyclerView b;
    public final ProgressOverlay c;
    public final SwipeRefreshLayout d;
    public final View e;
    public final View f;
    public final ViewGroup g;
    public final AdapterPresenter h;
    public final ItemBinder i;
    public final AppBar j;
    public final SessionsMenuView k;
    public final SessionLogoutConfirmationView l;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ SessionsListViewImpl a;

        /* renamed from: com.avito.android.profile.sessions.list.SessionsListViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0149a implements SwipeRefreshLayout.OnRefreshListener {
            public final /* synthetic */ ObservableEmitter a;

            public C0149a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public static final class b implements Cancellable {
            public final /* synthetic */ a a;

            public b(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.d.setOnRefreshListener(null);
            }
        }

        public a(SessionsListViewImpl sessionsListViewImpl) {
            this.a = sessionsListViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            this.a.d.setOnRefreshListener(new C0149a(observableEmitter));
            observableEmitter.setCancellable(new b(this));
        }
    }

    public SessionsListViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull AppBar appBar, @NotNull SessionsMenuView sessionsMenuView, @NotNull SessionLogoutConfirmationView sessionLogoutConfirmationView, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(sessionsMenuView, "menuView");
        Intrinsics.checkNotNullParameter(sessionLogoutConfirmationView, "logoutMenu");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.g = viewGroup;
        this.h = adapterPresenter;
        this.i = itemBinder;
        this.j = appBar;
        this.k = sessionsMenuView;
        this.l = sessionLogoutConfirmationView;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        View findViewById = viewGroup.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, R.id.content, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        View findViewById2 = viewGroup.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById2;
        this.d = swipeRefreshLayout;
        View findViewById3 = viewGroup.findViewById(R.id.button_retry);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.error_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById4;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(null);
        AppBar.DefaultImpls.setNavigationIcon$default(appBar, com.avito.android.ui_components.R.drawable.ic_back_24_black, null, 2, null);
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context2);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context3 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.white));
        progressOverlay.setToolbarPadding();
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return true;
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    public void closeConfirmationMenu() {
        this.l.closeConfirmationMenu();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public void closeMenu() {
        this.k.closeMenu();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    @NotNull
    public Observable<Unit> errorRetryClicks() {
        return RxView.clicks(this.e);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    @NotNull
    public Observable<DeepLink> getActionClicks() {
        return this.k.getActionClicks();
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    @NotNull
    public Observable<Unit> getChangePasswordClicks() {
        return this.l.getChangePasswordClicks();
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    @NotNull
    public Observable<Unit> getDismissEvents() {
        return this.l.getDismissEvents();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    @NotNull
    public Observable<Unit> getNavigationCallbacks() {
        return this.j.navigationCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.j.hideActionsMenu();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    public void hideProgress() {
        this.c.showContent();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public boolean isShowing() {
        return this.k.isShowing();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.j.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.j.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.j.navigationCallbacks();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    @NotNull
    public Observable<Unit> networkErrorRetryClicks() {
        return InteropKt.toV3(this.c.refreshes());
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    public void onDataChanged() {
        if (this.b.getAdapter() == null) {
            this.b.setAdapter(new SimpleRecyclerAdapter(this.h, this.i));
            return;
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    @NotNull
    public Observable<Unit> refreshClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…eshListener(null) }\n    }");
        return create;
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i2, @DrawableRes int i3, @AttrRes @Nullable Integer num) {
        this.j.setActionMenuItemIcon(i2, i3, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.j.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i2) {
        this.j.setMenu(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.j.setMenuTintColor(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.j.setMenuTintColorAttr(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.j.setNavigationIcon(i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.j.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i2) {
        this.j.setTitle(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.j.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.j.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.j.showActionsMenu(list);
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    public void showConfirmationMenu(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.l.showConfirmationMenu(str);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    public void showError() {
        this.c.showContent();
        Views.show(this.f);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public void showLogoutInProgress(boolean z) {
        this.k.showLogoutInProgress(z);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsMenuView
    public void showMenu(@NotNull List<SessionItem.Action> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.k.showMenu(list);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    public void showNetworkError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.c.showLoadingProblem(str);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    public void showProgress() {
        Views.hide(this.f);
        this.c.showLoading();
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        SnackbarExtensionsKt.showSnackbar(this.g, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.j.showToolbar();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListView
    public void stopRefreshing() {
        this.d.setRefreshing(false);
    }
}
