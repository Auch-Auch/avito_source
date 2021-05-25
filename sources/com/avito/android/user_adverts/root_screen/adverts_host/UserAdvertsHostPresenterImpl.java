package com.avito.android.user_adverts.root_screen.adverts_host;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.deep_linking.links.DetailsSheetLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertShortcut;
import com.avito.android.remote.model.UserAdvertsShortcuts;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_adverts.helpers.UserAdvertsHelpersKt;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel;
import com.avito.android.user_adverts.tracker.UserAdvertsTracker;
import com.avito.android.user_adverts_common.safety.SafetyInfoProvider;
import com.avito.android.user_adverts_common.safety.UserAdvertConstants;
import com.avito.android.user_adverts_common.safety.events.FraudWindowModalShowEvent;
import com.avito.android.util.Bundles;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B{\b\u0007\u0012\u0006\u0010v\u001a\u00020s\u0012\u0006\u0010r\u001a\u00020o\u0012\f\u0010|\u001a\b\u0012\u0004\u0012\u00020y0x\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010]\u001a\u00020Z\u0012\u0006\u0010k\u001a\u00020h\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0018\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u0010Y\u001a\u00020V¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J!\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J5\u0010-\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010,\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b-\u0010.J-\u0010/\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010,\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u0010\u0004J'\u00105\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020)H\u0016¢\u0006\u0004\b5\u00106J'\u00107\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020)H\u0016¢\u0006\u0004\b7\u00106J\u0017\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020\"H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001bH\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001bH\u0016¢\u0006\u0004\b=\u0010<J\u000f\u0010>\u001a\u00020\u0002H\u0016¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010?\u001a\u00020\u0002H\u0016¢\u0006\u0004\b?\u0010\u0004J\u000f\u0010@\u001a\u00020\u0002H\u0016¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010A\u001a\u00020\u0002H\u0016¢\u0006\u0004\bA\u0010\u0004J\u000f\u0010B\u001a\u00020\u0002H\u0016¢\u0006\u0004\bB\u0010\u0004J\u0017\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u001bH\u0016¢\u0006\u0004\bD\u0010<J\u000f\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\u0002H\u0016¢\u0006\u0004\bF\u0010\u0004J\u0017\u0010H\u001a\u00020\u00022\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0002H\u0016¢\u0006\u0004\bJ\u0010\u0004J\u000f\u0010K\u001a\u00020\u0002H\u0016¢\u0006\u0004\bK\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR$\u0010U\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001b8\u0002@BX\u000e¢\u0006\f\n\u0004\b\b\u0010S\"\u0004\bT\u0010<R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010cR\u0016\u0010G\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010cR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010cR\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020y0x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u0018\u0010\u0001\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010cR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0003\u0010\u0001R\u0018\u0010\u0001\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010cR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenterImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "", AuthSource.SEND_ABUSE, "()V", "", "Lcom/avito/android/remote/model/AdvertShortcut;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, AuthSource.BOOKING_ORDER, "(Ljava/util/List;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "view", "attachView", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;", "viewModel", "setHeaderViewModel", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;)V", "detachView", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;)V", "detachRouter", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "", "getActiveTabShortcut", "()Ljava/lang/String;", "onRetryClicked", "onAddAdvertClicked", "onAuthenticationCancelled", "onNewAdvertCreated", "", "resultCode", "Landroid/content/Intent;", "data", "onAdvertDetailsResult", "(ILandroid/content/Intent;)V", "statusMessage", "", "updateContents", "soaUpdateText", "soaAdvertId", "onAdvertStatusChanged", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "onAdvertStatusBroadcast", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onShowAppRater", "shortcut", "animate", "animateToolbar", "onShowFloatingViews", "(Ljava/lang/String;ZZ)V", "onHideFloatingViews", "activeTab", "onActiveTabChanged", "(I)V", "requestTabChange", "(Ljava/lang/String;)V", "openTabWithShortcut", "refreshActiveTab", "onRefreshSoaStatistics", "onRefreshTabs", "onInvalidateActiveTab", "onLoginClick", "categoryId", "loadSafetyInfo", "onPageLoadingError", "onStateInvalidated", "userCanBeLogout", "setUserCanBeLogout", "(Z)V", "onAddNewAdvertTabClicked", "onResume", "e", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "Lcom/avito/android/app_rater/AppRaterInteractor;", "s", "Lcom/avito/android/app_rater/AppRaterInteractor;", "appRaterInteractor", "value", "Ljava/lang/String;", "c", "activeShortcut", "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", "w", "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", "safetyProvider", "Lcom/avito/android/server_time/TimeSource;", "t", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/account/AccountStateProvider;", VKApiConst.VERSION, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "k", "Z", "isAuthorized", "j", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;", "headerViewModel", "Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;", "u", "Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;", "tracker", AuthSource.OPEN_CHANNEL_LIST, "invalidateContent", "l", "Lcom/avito/android/util/SchedulersFactory;", "o", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "n", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "interactor", "invalidateTabs", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabItem;", "p", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "routerSubscriptions", "d", "areFloatingViewsShown", "f", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;", a2.g.r.g.a, "subscriptions", "Ljava/util/List;", "i", "isPageLoadingError", "Lcom/avito/android/analytics/Analytics;", "r", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", VKApiConst.Q, "Lcom/avito/android/Features;", "features", "state", "defaultShortcut", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/app_rater/AppRaterInteractor;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/user_adverts/tracker/UserAdvertsTracker;Landroid/os/Bundle;Ljava/lang/String;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsHostPresenterImpl implements UserAdvertsHostPresenter {
    public List<AdvertShortcut> a;
    public String b;
    public boolean c;
    public boolean d;
    public UserAdvertsHostView e;
    public UserAdvertsHostPresenter.Router f;
    public final CompositeDisposable g;
    public final CompositeDisposable h;
    public boolean i;
    public ProfileHeaderViewModel j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final UserAdvertsInteractor n;
    public final SchedulersFactory o;
    public final TabsDataProvider<TabItem> p;
    public final Features q;
    public final Analytics r;
    public final AppRaterInteractor s;
    public final TimeSource t;
    public final UserAdvertsTracker u;
    public final AccountStateProvider v;
    public final SafetyInfoProvider w;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;

        public a(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl) {
            this.a = userAdvertsHostPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            if (!Intrinsics.areEqual(Boolean.valueOf(this.a.k), bool2)) {
                UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                userAdvertsHostPresenterImpl.k = bool2.booleanValue();
                this.a.a();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on observe authorization", th);
        }
    }

    public static final class c<T> implements Consumer<UserAdvertsShortcuts> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;

        public c(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl) {
            this.a = userAdvertsHostPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(UserAdvertsShortcuts userAdvertsShortcuts) {
            this.a.u.trackShortcutsLoading();
            this.a.u.startShortcutsDraw();
            this.a.b(userAdvertsShortcuts.getList());
            this.a.u.trackShortcutsDraw();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;

        public d(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl) {
            this.a = userAdvertsHostPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.u.trackShortcutsLoadingError();
            this.a.u.startShortcutsDraw();
            UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            UserAdvertsHostPresenterImpl.access$onShortcutsLoadingError(userAdvertsHostPresenterImpl, th2);
            this.a.u.trackShortcutsDrawingError();
        }
    }

    public static final class e<T> implements Consumer<DetailsSheetLinkBody> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;
        public final /* synthetic */ String b;

        public e(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl, String str) {
            this.a = userAdvertsHostPresenterImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DetailsSheetLinkBody detailsSheetLinkBody) {
            DetailsSheetLinkBody detailsSheetLinkBody2 = detailsSheetLinkBody;
            UserAdvertsHostView userAdvertsHostView = this.a.e;
            if (userAdvertsHostView != null) {
                Intrinsics.checkNotNullExpressionValue(detailsSheetLinkBody2, "it");
                userAdvertsHostView.showSafetyInfoBanner(new DetailsSheetLink(detailsSheetLinkBody2));
            }
            this.a.r.track(new FraudWindowModalShowEvent(this.b));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to load security message", th);
        }
    }

    public static final class g<T> implements Consumer<UserAdvertsShortcuts> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;

        public g(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl) {
            this.a = userAdvertsHostPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.List */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(UserAdvertsShortcuts userAdvertsShortcuts) {
            AdvertShortcut[] advertShortcutArr;
            UserAdvertsShortcuts userAdvertsShortcuts2 = userAdvertsShortcuts;
            List list = this.a.a;
            if (list != 0) {
                Object[] array = list.toArray(new AdvertShortcut[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                advertShortcutArr = (AdvertShortcut[]) array;
            } else {
                advertShortcutArr = new AdvertShortcut[0];
            }
            Object[] array2 = userAdvertsShortcuts2.getList().toArray(new AdvertShortcut[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            if (!Arrays.equals((AdvertShortcut[]) array2, advertShortcutArr)) {
                this.a.c = true;
                this.a.b(userAdvertsShortcuts2.getList());
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;

        public h(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl) {
            this.a = userAdvertsHostPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            UserAdvertsHostPresenterImpl.access$onShortcutsLoadingError(userAdvertsHostPresenterImpl, th2);
        }
    }

    public static final class i<T> implements Consumer<Boolean> {
        public final /* synthetic */ UserAdvertsHostPresenterImpl a;

        public i(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl) {
            this.a = userAdvertsHostPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            UserAdvertsHostView userAdvertsHostView;
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "shouldShowAppRater");
            if (bool2.booleanValue() && (userAdvertsHostView = this.a.e) != null) {
                userAdvertsHostView.showAppRater();
            }
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public static final j a = new j();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to get info should be app rater be shown", th);
        }
    }

    @Inject
    public UserAdvertsHostPresenterImpl(@NotNull UserAdvertsInteractor userAdvertsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TabsDataProvider<TabItem> tabsDataProvider, @NotNull Features features, @NotNull Analytics analytics, @NotNull AppRaterInteractor appRaterInteractor, @NotNull TimeSource timeSource, @NotNull UserAdvertsTracker userAdvertsTracker, @Nullable Bundle bundle, @Nullable String str, @NotNull AccountStateProvider accountStateProvider, @NotNull SafetyInfoProvider safetyInfoProvider) {
        String string;
        Intrinsics.checkNotNullParameter(userAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(appRaterInteractor, "appRaterInteractor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(userAdvertsTracker, "tracker");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(safetyInfoProvider, "safetyProvider");
        this.n = userAdvertsInteractor;
        this.o = schedulersFactory;
        this.p = tabsDataProvider;
        this.q = features;
        this.r = analytics;
        this.s = appRaterInteractor;
        this.t = timeSource;
        this.u = userAdvertsTracker;
        this.v = accountStateProvider;
        this.w = safetyInfoProvider;
        this.a = bundle != null ? bundle.getParcelableArrayList("key_user_adverts_shortcuts") : null;
        if (!(bundle == null || (string = bundle.getString(UserAdvertsHostPresenterKt.KEY_ACTIVE_SHORTCUT)) == null)) {
            str = string;
        }
        this.b = str == null ? "" : str;
        boolean z = false;
        this.c = bundle != null ? bundle.getBoolean("key_invalidate_tabs") : false;
        this.g = new CompositeDisposable();
        this.h = new CompositeDisposable();
        this.k = accountStateProvider.isAuthorized();
        this.m = bundle != null ? bundle.getBoolean("key_should_reload_on_resume") : z;
    }

    public static final void access$onShortcutsLoadingError(UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl, Throwable th) {
        Objects.requireNonNull(userAdvertsHostPresenterImpl);
        if (!(th instanceof UnauthorizedException)) {
            UserAdvertsHostView userAdvertsHostView = userAdvertsHostPresenterImpl.e;
            if (userAdvertsHostView != null) {
                userAdvertsHostView.showError();
            }
            UserAdvertsHostView userAdvertsHostView2 = userAdvertsHostPresenterImpl.e;
            if (userAdvertsHostView2 != null) {
                userAdvertsHostView2.showFloatingViews(true);
            }
        } else if (userAdvertsHostPresenterImpl.l) {
            UserAdvertsHostView userAdvertsHostView3 = userAdvertsHostPresenterImpl.e;
            if (userAdvertsHostView3 != null) {
                userAdvertsHostView3.showLogout();
            }
        } else {
            UserAdvertsHostPresenter.Router router = userAdvertsHostPresenterImpl.f;
            if (router != null) {
                router.showLoginScreen();
            }
        }
    }

    public final void a() {
        this.m = false;
        this.u.startShortcutsLoading();
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            userAdvertsHostView.showProgress();
        }
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.n.loadShortcuts().observeOn(this.o.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadShortcuts…rror()\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void attachRouter(@NotNull UserAdvertsHostPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.f = router;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void attachView(@Nullable UserAdvertsHostView userAdvertsHostView) {
        this.e = userAdvertsHostView;
        List<AdvertShortcut> list = this.a;
        if (list == null || this.m) {
            a();
        } else {
            b(list);
        }
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = InteropKt.toV2(this.v.authorized()).observeOn(this.o.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.aut…tion\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void b(List<AdvertShortcut> list) {
        T t2;
        String str;
        this.a = list;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(t2.getShortcut(), this.b)) {
                break;
            }
        }
        if (t2 != null) {
            str = this.b;
        } else {
            str = list.isEmpty() ^ true ? ((AdvertShortcut) CollectionsKt___CollectionsKt.first((List<? extends Object>) list)).getShortcut() : "";
        }
        c(str);
        String str2 = this.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t3 : list) {
            arrayList.add(new TabItem(t3.getTitle(), t3.getShortcut(), t3.getCount()));
        }
        ListDataSource listDataSource = new ListDataSource(arrayList);
        this.p.onDataSourceChanged(listDataSource);
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            if (this.c) {
                this.c = false;
                this.i = false;
                userAdvertsHostView.onTabsInvalidated();
            }
            userAdvertsHostView.onTabsChanged();
            if (!list.isEmpty()) {
                Iterator it2 = listDataSource.iterator();
                int i2 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    Object next = it2.next();
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((TabItem) next).getShortcut(), str2)) {
                        break;
                    }
                    i2++;
                }
                if (i2 == -1) {
                    i2 = 0;
                }
                userAdvertsHostView.setActiveTab(i2);
                userAdvertsHostView.showContent();
                if (this.i) {
                    this.i = false;
                    userAdvertsHostView.onRefreshTab(i2);
                }
            } else {
                userAdvertsHostView.showEmpty();
            }
            UserAdvertsHostPresenter.DefaultImpls.onShowFloatingViews$default(this, str2, false, false, 4, null);
        }
    }

    public final void c(String str) {
        if (!Intrinsics.areEqual(this.b, str)) {
            this.b = str;
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void detachRouter() {
        this.h.clear();
        this.f = null;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void detachView() {
        this.g.clear();
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            userAdvertsHostView.removeListeners();
        }
        this.e = null;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    @NotNull
    public String getActiveTabShortcut() {
        return this.b;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void loadSafetyInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        if (this.q.getAntiFraudSheetAfterActivation().invoke().booleanValue()) {
            String currentUserId = this.v.getCurrentUserId();
            if (currentUserId == null) {
                currentUserId = "";
            }
            CompositeDisposable compositeDisposable = this.g;
            Disposable subscribe = InteropKt.toV2(this.w.loadSafetyInfo(str, currentUserId)).delay(600, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new e(this, currentUserId), f.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "safetyProvider\n         …sage\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView.Presenter
    public void onActiveTabChanged(int i2) {
        c(this.p.getItem(i2).getShortcut());
        UserAdvertsHostPresenter.DefaultImpls.onShowFloatingViews$default(this, this.b, true, false, 4, null);
        ProfileHeaderViewModel profileHeaderViewModel = this.j;
        if (profileHeaderViewModel != null) {
            profileHeaderViewModel.updateSoaIfNecessary();
        }
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            userAdvertsHostView.showPublishButtonIfNeeded();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView.Presenter
    public void onAddAdvertClicked() {
        this.m = true;
        this.c = true;
        UserAdvertsHostPresenter.Router router = this.f;
        if (router != null) {
            router.showAddAdvert();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onAddNewAdvertTabClicked() {
        this.m = true;
        this.c = true;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onAdvertDetailsResult(int i2, @Nullable Intent intent) {
        AdvertActionTransferData advertActionTransferData;
        String categoryId;
        String str = null;
        if (intent == null || (advertActionTransferData = (AdvertActionTransferData) intent.getParcelableExtra(UserAdvertConstants.KEY_ADVERT_ACTION)) == null) {
            advertActionTransferData = intent != null ? UserAdvertsHelpersKt.getAdvertActionTransferData(intent) : null;
        }
        switch (i2) {
            case 6:
                String stringExtra = intent != null ? intent.getStringExtra(UserAdvertConstants.KEY_SOA_UPDATE_MESSAGE) : null;
                boolean z = false;
                if (intent != null) {
                    z = intent.getBooleanExtra(UserAdvertConstants.KEY_SHOULD_SHOW_APPRATER, false);
                }
                if (z) {
                    onShowAppRater();
                }
                String message = advertActionTransferData != null ? advertActionTransferData.getMessage() : null;
                if (advertActionTransferData != null) {
                    str = advertActionTransferData.getSoaAdvertId();
                }
                UserAdvertsHostPresenter.DefaultImpls.onAdvertStatusChanged$default(this, message, false, stringExtra, str, 2, null);
                return;
            case 7:
                if (!(advertActionTransferData == null || (categoryId = advertActionTransferData.getCategoryId()) == null)) {
                    loadSafetyInfo(categoryId);
                }
                if (advertActionTransferData != null) {
                    str = advertActionTransferData.getMessage();
                }
                UserAdvertsHostPresenter.DefaultImpls.onAdvertStatusChanged$default(this, str, false, null, null, 14, null);
                return;
            case 8:
            case 9:
            case 10:
                if (advertActionTransferData != null) {
                    str = advertActionTransferData.getMessage();
                }
                UserAdvertsHostPresenter.DefaultImpls.onAdvertStatusChanged$default(this, str, false, null, null, 14, null);
                return;
            default:
                return;
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onAdvertStatusBroadcast(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        UserAdvertsHostView userAdvertsHostView;
        ProfileHeaderViewModel profileHeaderViewModel = this.j;
        if (profileHeaderViewModel != null) {
            profileHeaderViewModel.setSoaUpdateParams(true, str2, str3);
        }
        onRefreshSoaStatistics();
        if (str != null && (userAdvertsHostView = this.e) != null) {
            userAdvertsHostView.showSnackBar(str);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onAdvertStatusChanged(@Nullable String str, boolean z, @Nullable String str2, @Nullable String str3) {
        UserAdvertsHostView userAdvertsHostView;
        ProfileHeaderViewModel profileHeaderViewModel = this.j;
        if (profileHeaderViewModel != null) {
            profileHeaderViewModel.setSoaUpdateParams(true, str2, str3);
        }
        if (z) {
            onStateInvalidated();
        }
        if (str != null && (userAdvertsHostView = this.e) != null) {
            userAdvertsHostView.showSnackBar(str);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onAuthenticationCancelled() {
        UserAdvertsHostPresenter.Router router = this.f;
        if (router != null) {
            router.onAuthentificationFailed();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onHideFloatingViews(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        if (Intrinsics.areEqual(str, this.b) && this.d && z2) {
            this.d = false;
            UserAdvertsHostView userAdvertsHostView = this.e;
            if (userAdvertsHostView != null) {
                userAdvertsHostView.hideFloatingViews(z);
            }
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onInvalidateActiveTab() {
        ProfileHeaderViewModel profileHeaderViewModel = this.j;
        if (profileHeaderViewModel != null) {
            profileHeaderViewModel.checkShowSearchIfRequired();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView.Presenter
    public void onLoginClick() {
        UserAdvertsHostPresenter.Router router = this.f;
        if (router != null) {
            router.showLoginScreen();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onNewAdvertCreated() {
        this.c = true;
        a();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onPageLoadingError() {
        this.i = true;
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            userAdvertsHostView.showError();
        }
        UserAdvertsHostView userAdvertsHostView2 = this.e;
        if (userAdvertsHostView2 != null) {
            userAdvertsHostView2.showFloatingViews(true);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onRefreshSoaStatistics() {
        ProfileHeaderViewModel profileHeaderViewModel = this.j;
        if (profileHeaderViewModel != null) {
            profileHeaderViewModel.onUpdateNotifications();
        }
        ProfileHeaderViewModel profileHeaderViewModel2 = this.j;
        if (profileHeaderViewModel2 != null) {
            profileHeaderViewModel2.updateSoaImmediately();
        }
        ProfileHeaderViewModel profileHeaderViewModel3 = this.j;
        if (profileHeaderViewModel3 != null) {
            profileHeaderViewModel3.updateOrdersInfo();
        }
        ProfileHeaderViewModel profileHeaderViewModel4 = this.j;
        if (profileHeaderViewModel4 != null) {
            profileHeaderViewModel4.loadBootstrapConfig();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onRefreshTabs() {
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.n.loadShortcuts().observeOn(this.o.mainThread()).subscribe(new g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadShortcuts…rtcutsLoadingError(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onResume() {
        if (this.m) {
            a();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView.Presenter
    public void onRetryClicked() {
        ProfileHeaderViewModel profileHeaderViewModel = this.j;
        if (profileHeaderViewModel != null) {
            profileHeaderViewModel.checkShowSearchIfRequired();
        }
        a();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        Bundles.putParcelableList(bundle, "key_user_adverts_shortcuts", this.a);
        bundle.putString(UserAdvertsHostPresenterKt.KEY_ACTIVE_SHORTCUT, this.b);
        bundle.putBoolean("key_invalidate_tabs", this.c);
        bundle.putBoolean("key_should_reload_on_resume", this.m);
        return bundle;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onShowAppRater() {
        if (this.q.getShowAppRater().invoke().booleanValue()) {
            CompositeDisposable compositeDisposable = this.g;
            Disposable subscribe = this.s.shouldShowAppRaterOnSoa(this.t.now()).subscribeOn(this.o.io()).observeOn(this.o.mainThread()).subscribe(new i(this), j.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "appRaterInteractor\n     …\", it)\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onShowFloatingViews(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        if (Intrinsics.areEqual(str, this.b) && !this.d && z2) {
            this.d = true;
            UserAdvertsHostView userAdvertsHostView = this.e;
            if (userAdvertsHostView != null) {
                userAdvertsHostView.showFloatingViews(z);
            }
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void onStateInvalidated() {
        this.c = true;
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            userAdvertsHostView.showFloatingViews(false);
        }
        a();
        onRefreshSoaStatistics();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void openTabWithShortcut(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        int access$findTabByShortcut = UserAdvertsHostPresenterKt.access$findTabByShortcut(this.p, str);
        if (access$findTabByShortcut >= 0) {
            if (!Intrinsics.areEqual(this.b, str)) {
                this.b = str;
            }
            UserAdvertsHostView userAdvertsHostView = this.e;
            if (userAdvertsHostView != null) {
                userAdvertsHostView.setActiveTab(access$findTabByShortcut);
            }
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void refreshActiveTab() {
        UserAdvertsHostView userAdvertsHostView = this.e;
        if (userAdvertsHostView != null) {
            userAdvertsHostView.refreshActiveTab();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void requestTabChange(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        if (!Intrinsics.areEqual(this.b, str)) {
            this.b = str;
        }
        onStateInvalidated();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void setHeaderViewModel(@NotNull ProfileHeaderViewModel profileHeaderViewModel) {
        Intrinsics.checkNotNullParameter(profileHeaderViewModel, "viewModel");
        this.j = profileHeaderViewModel;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter
    public void setUserCanBeLogout(boolean z) {
        this.l = z;
    }
}
