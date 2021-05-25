package com.avito.android.profile.sessions.list;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SessionMenuOpenEvent;
import com.avito.android.analytics.event.SessionsNotMeButtonClick;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PasswordChangeLink;
import com.avito.android.deep_linking.links.SessionDeleteLink;
import com.avito.android.deep_linking.links.SessionsSocialLogoutLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.avito.android.profile.sessions.adapter.error.SessionsErrorItem;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItem;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.profile.sessions.list.SessionsListInteractor;
import com.avito.android.profile.sessions.list.SessionsListPresenter;
import com.avito.android.profile.sessions.list.di.SessionsListSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.SessionContract;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001nBe\b\u0007\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00020f0e\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u00106\u001a\u000203\u0012\b\u0010H\u001a\u0004\u0018\u00010$\u0012\u0006\u0010T\u001a\u00020Q\u0012\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bl\u0010mJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u00107R\u0016\u0010:\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010UR\u0016\u0010W\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010OR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010ZR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020f0e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010D¨\u0006o"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListPresenterImpl;", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter;", "", "d", "()V", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", SessionContract.SESSION, "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "(Lcom/avito/android/profile/sessions/adapter/session/SessionItem;)Lcom/avito/android/deep_linking/links/DeepLink;", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/profile/sessions/adapter/session/SessionItem;)Ljava/lang/String;", "", "Lcom/avito/android/profile/sessions/adapter/SessionsListItem;", "e", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/deep_linking/links/SessionDeleteLink;", "deeplink", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/deep_linking/links/SessionDeleteLink;)Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", "Lcom/avito/android/profile/sessions/list/SessionsListView;", "view", "attachView", "(Lcom/avito/android/profile/sessions/list/SessionsListView;)V", "detachView", "", "resultCode", "onAuthResult", "(I)V", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/sessions/list/SessionsListPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isRefreshing", "load", "(Z)V", "Lcom/avito/android/error_helper/ErrorHelper;", "o", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory3;", "r", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/profile/sessions/list/SessionsListView;", "k", "I", "timeZoneOffsetMin", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "n", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/profile/sessions/list/SessionsListPresenterImpl$ErrorType;", "h", "Lcom/avito/android/profile/sessions/list/SessionsListPresenterImpl$ErrorType;", "errorType", "u", "Ljava/lang/String;", "source", "s", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/profile/sessions/list/SessionsListResourceProvider;", VKApiConst.Q, "Lcom/avito/android/profile/sessions/list/SessionsListResourceProvider;", "resourcesProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "deleteDisposables", "Lcom/avito/android/analytics/Analytics;", "t", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ljava/util/List;", "items", "viewDisposables", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter$Router;", "j", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", "lastDeletedSession", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadingDisposable", "Lcom/avito/android/profile/sessions/list/SessionsListInteractor;", "l", "Lcom/avito/android/profile/sessions/list/SessionsListInteractor;", "interactor", "i", "selectedSession", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/profile/sessions/adapter/action/SessionsItemAction;", "p", "Lio/reactivex/rxjava3/core/Observable;", "itemEvents", a2.g.r.g.a, "errorMessage", "<init>", "(Lcom/avito/android/profile/sessions/list/SessionsListInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/profile/sessions/list/SessionsListResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;)V", "ErrorType", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsListPresenterImpl implements SessionsListPresenter {
    public SessionsListView a;
    public SessionsListPresenter.Router b;
    public List<? extends SessionsListItem> c;
    public final CompositeDisposable d;
    public Disposable e;
    public CompositeDisposable f;
    public String g;
    public ErrorType h;
    public SessionItem i;
    public SessionItem j;
    public final int k;
    public final SessionsListInteractor l;
    public final AdapterPresenter m;
    public final CompositeSnackbarPresenter n;
    public final ErrorHelper o;
    public final Observable<SessionsItemAction> p;
    public final SessionsListResourceProvider q;
    public final SchedulersFactory3 r;
    public final Kundle s;
    public final Analytics t;
    public final String u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListPresenterImpl$ErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON_ERROR", "NETWORK_ERROR", "profile_release"}, k = 1, mv = {1, 4, 2})
    public enum ErrorType {
        COMMON_ERROR,
        NETWORK_ERROR
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ErrorType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((SessionsListPresenterImpl) this.b).load(true);
            } else if (i == 1) {
                SessionsListPresenter.DefaultImpls.load$default((SessionsListPresenterImpl) this.b, false, 1, null);
            } else if (i == 2) {
                SessionsListPresenter.DefaultImpls.load$default((SessionsListPresenterImpl) this.b, false, 1, null);
            } else if (i == 3) {
                SessionsListPresenter.Router router = ((SessionsListPresenterImpl) this.b).b;
                if (router != null) {
                    router.closeScreen();
                }
            } else if (i == 4) {
                ((SessionsListPresenterImpl) this.b).j = null;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<SessionsItemAction> {
        public final /* synthetic */ SessionsListPresenterImpl a;
        public final /* synthetic */ SessionsListView b;

        public b(SessionsListPresenterImpl sessionsListPresenterImpl, SessionsListView sessionsListView) {
            this.a = sessionsListPresenterImpl;
            this.b = sessionsListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SessionsItemAction sessionsItemAction) {
            SessionsItemAction sessionsItemAction2 = sessionsItemAction;
            if (sessionsItemAction2 instanceof SessionsItemAction.LoadingNextAction) {
                SessionsListPresenterImpl.access$loadNextPage(this.a, ((SessionsItemAction.LoadingNextAction) sessionsItemAction2).getFromTimestamp());
                return;
            }
            List<SessionItem.Action> list = null;
            if (sessionsItemAction2 instanceof SessionsItemAction.RetryOnErrorAction) {
                SessionsListPresenterImpl sessionsListPresenterImpl = this.a;
                List list2 = sessionsListPresenterImpl.c;
                if (list2 != null) {
                    list = this.a.e(list2);
                }
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                sessionsListPresenterImpl.c = CollectionsKt___CollectionsKt.plus((Collection<? extends SessionsLoadingItem>) list, new SessionsLoadingItem(((SessionsItemAction.RetryOnErrorAction) sessionsItemAction2).getFromTimestamp()));
                this.a.d();
            } else if (sessionsItemAction2 instanceof SessionsItemAction.MoreButtonClickAction) {
                this.a.t.track(new SessionMenuOpenEvent());
                this.a.i = ((SessionsItemAction.MoreButtonClickAction) sessionsItemAction2).getItem();
                SessionItem sessionItem = this.a.i;
                if (sessionItem != null) {
                    list = sessionItem.getActions();
                }
                if (!(list == null || list.isEmpty())) {
                    this.b.showMenu(list);
                }
            }
        }
    }

    public static final class c<T> implements Consumer<DeepLink> {
        public final /* synthetic */ SessionsListPresenterImpl a;

        public c(SessionsListPresenterImpl sessionsListPresenterImpl) {
            this.a = sessionsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            SessionsListPresenterImpl sessionsListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            SessionsListPresenterImpl.access$processDeeplink(sessionsListPresenterImpl, deepLink2);
        }
    }

    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ SessionsListPresenterImpl a;
        public final /* synthetic */ SessionsListView b;

        public d(SessionsListPresenterImpl sessionsListPresenterImpl, SessionsListView sessionsListView) {
            this.a = sessionsListPresenterImpl;
            this.b = sessionsListView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            DeepLink c;
            this.b.closeConfirmationMenu();
            SessionItem sessionItem = this.a.j;
            if (sessionItem != null && (c = this.a.c(sessionItem)) != null) {
                SessionsListPresenterImpl sessionsListPresenterImpl = this.a;
                SessionsListPresenterImpl.access$processDeeplink(sessionsListPresenterImpl, SessionsListPresenterImpl.access$substituteSource(sessionsListPresenterImpl, c));
            }
        }
    }

    public static final class e<T> implements Consumer<Notification<LoadingState<? super List<? extends SessionsListItem>>>> {
        public final /* synthetic */ SessionsListPresenterImpl a;

        public e(SessionsListPresenterImpl sessionsListPresenterImpl) {
            this.a = sessionsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Notification<LoadingState<? super List<? extends SessionsListItem>>> notification) {
            SessionsListView sessionsListView = this.a.a;
            if (sessionsListView != null) {
                sessionsListView.stopRefreshing();
            }
        }
    }

    public static final class f<T> implements Consumer<LoadingState<? super List<? extends SessionsListItem>>> {
        public final /* synthetic */ SessionsListPresenterImpl a;

        public f(SessionsListPresenterImpl sessionsListPresenterImpl) {
            this.a = sessionsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super List<? extends SessionsListItem>> loadingState) {
            LoadingState<? super List<? extends SessionsListItem>> loadingState2 = loadingState;
            SessionsListPresenterImpl sessionsListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "items");
            SessionsListPresenterImpl.access$onLoaded(sessionsListPresenterImpl, loadingState2);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public SessionsListPresenterImpl(@NotNull SessionsListInteractor sessionsListInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull ErrorHelper errorHelper, @NotNull Observable<SessionsItemAction> observable, @NotNull SessionsListResourceProvider sessionsListResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable Kundle kundle, @NotNull Analytics analytics, @SessionsListSource @Nullable String str) {
        String string;
        Intrinsics.checkNotNullParameter(sessionsListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(observable, "itemEvents");
        Intrinsics.checkNotNullParameter(sessionsListResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.l = sessionsListInteractor;
        this.m = adapterPresenter;
        this.n = compositeSnackbarPresenter;
        this.o = errorHelper;
        this.p = observable;
        this.q = sessionsListResourceProvider;
        this.r = schedulersFactory3;
        this.s = kundle;
        this.t = analytics;
        this.u = str;
        SessionItem sessionItem = null;
        this.c = kundle != null ? kundle.getParcelableList("items") : null;
        this.d = new CompositeDisposable();
        this.f = new CompositeDisposable();
        this.g = kundle != null ? kundle.getString("error_message") : null;
        this.h = (kundle == null || (string = kundle.getString("error_type")) == null) ? null : ErrorType.valueOf(string);
        this.j = kundle != null ? (SessionItem) kundle.getParcelable("last_deleted") : sessionItem;
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getDefault()");
        this.k = (timeZone.getRawOffset() / 60) / 1000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$handleDeleteSessionResult(com.avito.android.profile.sessions.list.SessionsListPresenterImpl r17, com.avito.android.util.LoadingState r18, com.avito.android.deep_linking.links.SessionDeleteLink r19, com.avito.android.profile.sessions.adapter.session.SessionItem r20) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.sessions.list.SessionsListPresenterImpl.access$handleDeleteSessionResult(com.avito.android.profile.sessions.list.SessionsListPresenterImpl, com.avito.android.util.LoadingState, com.avito.android.deep_linking.links.SessionDeleteLink, com.avito.android.profile.sessions.adapter.session.SessionItem):void");
    }

    public static final void access$loadNextPage(SessionsListPresenterImpl sessionsListPresenterImpl, long j2) {
        Disposable disposable = sessionsListPresenterImpl.e;
        if (disposable != null) {
            disposable.dispose();
        }
        sessionsListPresenterImpl.e = sessionsListPresenterImpl.l.loadSessions(Long.valueOf(j2), Integer.valueOf(sessionsListPresenterImpl.k), sessionsListPresenterImpl.u).observeOn(sessionsListPresenterImpl.r.mainThread()).subscribe(new a2.a.a.b2.h1.a.e(sessionsListPresenterImpl, j2), a2.a.a.b2.h1.a.f.a);
    }

    public static final void access$onLoaded(SessionsListPresenterImpl sessionsListPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(sessionsListPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            sessionsListPresenterImpl.c = (List) ((LoadingState.Loaded) loadingState).getData();
            sessionsListPresenterImpl.h = null;
            sessionsListPresenterImpl.g = null;
        } else if (loadingState instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState).getError();
            sessionsListPresenterImpl.c = null;
            if (error instanceof ErrorWithMessage.NetworkError) {
                String message = ((ErrorWithMessage.NetworkError) error).getMessage();
                sessionsListPresenterImpl.g = message;
                sessionsListPresenterImpl.h = ErrorType.NETWORK_ERROR;
                if (message != null) {
                    CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(sessionsListPresenterImpl.n, message, 0, null, 0, null, 0, null, null, 254, null);
                }
            } else if (error instanceof TypedError.UnauthorizedError) {
                sessionsListPresenterImpl.g = null;
                sessionsListPresenterImpl.h = null;
                SessionsListPresenter.Router router = sessionsListPresenterImpl.b;
                if (router != null) {
                    router.openAuthScreen();
                }
            } else {
                sessionsListPresenterImpl.g = null;
                sessionsListPresenterImpl.h = ErrorType.COMMON_ERROR;
                CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(sessionsListPresenterImpl.n, sessionsListPresenterImpl.q.getCommonErrorMessageText(), 0, null, 0, null, 0, null, null, 254, null);
            }
        }
        sessionsListPresenterImpl.d();
    }

    public static final void access$onNextPageLoaded(SessionsListPresenterImpl sessionsListPresenterImpl, LoadingState loadingState, long j2) {
        Objects.requireNonNull(sessionsListPresenterImpl);
        List<SessionsListItem> list = null;
        if (loadingState instanceof LoadingState.Loaded) {
            List<? extends SessionsListItem> list2 = sessionsListPresenterImpl.c;
            if (list2 != null) {
                list = sessionsListPresenterImpl.e(list2);
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            sessionsListPresenterImpl.c = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) ((LoadingState.Loaded) loadingState).getData());
        } else if (loadingState instanceof LoadingState.Error) {
            String recycle = sessionsListPresenterImpl.o.recycle(((LoadingState.Error) loadingState).getError());
            List<? extends SessionsListItem> list3 = sessionsListPresenterImpl.c;
            if (list3 != null) {
                list = sessionsListPresenterImpl.e(list3);
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            sessionsListPresenterImpl.c = CollectionsKt___CollectionsKt.plus((Collection<? extends SessionsErrorItem>) list, new SessionsErrorItem(recycle, j2));
            CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(sessionsListPresenterImpl.n, recycle, 0, null, 0, null, 0, null, null, 254, null);
        }
        sessionsListPresenterImpl.d();
    }

    public static final void access$processDeeplink(SessionsListPresenterImpl sessionsListPresenterImpl, DeepLink deepLink) {
        Objects.requireNonNull(sessionsListPresenterImpl);
        if (deepLink instanceof SessionDeleteLink) {
            SessionDeleteLink sessionDeleteLink = (SessionDeleteLink) deepLink;
            SessionItem sessionItem = sessionsListPresenterImpl.i;
            CompositeDisposable compositeDisposable = sessionsListPresenterImpl.f;
            Disposable subscribe = sessionsListPresenterImpl.l.deleteSession(sessionDeleteLink.getDeviceId(), sessionDeleteLink.getSessionIdHash(), sessionDeleteLink.getLoginType()).doOnSubscribe(new a2.a.a.b2.h1.a.b(sessionsListPresenterImpl, sessionDeleteLink)).observeOn(sessionsListPresenterImpl.r.mainThread()).subscribe(new a2.a.a.b2.h1.a.c(sessionsListPresenterImpl, sessionDeleteLink, sessionItem), a2.a.a.b2.h1.a.d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.deleteSession… session = session) }) {}");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } else if (deepLink instanceof PasswordChangeLink) {
            sessionsListPresenterImpl.t.track(new SessionsNotMeButtonClick());
            SessionsListPresenter.Router router = sessionsListPresenterImpl.b;
            if (router != null) {
                PasswordChangeLink passwordChangeLink = (PasswordChangeLink) deepLink;
                router.openChangePasswordScreen(true, passwordChangeLink.getSource(), passwordChangeLink.getLogin(), passwordChangeLink.getLoginType(), passwordChangeLink.getSessionIdHash(), passwordChangeLink.getDeviceId(), passwordChangeLink.getUserId());
            }
        } else if (deepLink instanceof SessionsSocialLogoutLink) {
            sessionsListPresenterImpl.t.track(new SessionsNotMeButtonClick());
            SessionsListPresenter.Router router2 = sessionsListPresenterImpl.b;
            if (router2 != null) {
                SessionsSocialLogoutLink sessionsSocialLogoutLink = (SessionsSocialLogoutLink) deepLink;
                router2.openSocialLogoutScreen(sessionsSocialLogoutLink.getSource(), sessionsSocialLogoutLink.getUserId(), sessionsSocialLogoutLink.getLoginType(), sessionsSocialLogoutLink.getSessionIdHash(), sessionsSocialLogoutLink.getDeviceId());
            }
        }
    }

    public static final DeepLink access$substituteSource(SessionsListPresenterImpl sessionsListPresenterImpl, DeepLink deepLink) {
        Objects.requireNonNull(sessionsListPresenterImpl);
        if (deepLink instanceof SessionsSocialLogoutLink) {
            return SessionsSocialLogoutLink.copy$default((SessionsSocialLogoutLink) deepLink, "ses", null, null, null, null, 30, null);
        }
        return deepLink instanceof PasswordChangeLink ? PasswordChangeLink.copy$default((PasswordChangeLink) deepLink, null, null, null, null, "ses", null, 47, null) : deepLink;
    }

    public final String a(SessionItem sessionItem) {
        return sessionItem.getTitle() + '\n' + sessionItem.getSubtitle();
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    public void attachRouter(@NotNull SessionsListPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    public void attachView(@NotNull SessionsListView sessionsListView) {
        Intrinsics.checkNotNullParameter(sessionsListView, "view");
        this.a = sessionsListView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.p.subscribe(new b(this, sessionsListView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemEvents.subscribe { a…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = sessionsListView.refreshClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.refreshClicks().sub…ad(isRefreshing = true) }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = sessionsListView.errorRetryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.errorRetryClicks().subscribe { load() }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = sessionsListView.networkErrorRetryClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.networkErrorRetryCl…ks().subscribe { load() }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.d;
        Disposable subscribe5 = sessionsListView.getNavigationCallbacks().subscribe(new a(3, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.getNavigationCallba…{ router?.closeScreen() }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.d;
        Disposable subscribe6 = sessionsListView.getActionClicks().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "view.actionClicks.subscr…e { processDeeplink(it) }");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.d;
        Disposable subscribe7 = sessionsListView.getDismissEvents().subscribe(new a(4, this));
        Intrinsics.checkNotNullExpressionValue(subscribe7, "view.dismissEvents.subsc…stDeletedSession = null }");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        CompositeDisposable compositeDisposable8 = this.d;
        Disposable subscribe8 = sessionsListView.getChangePasswordClicks().subscribe(new d(this, sessionsListView));
        Intrinsics.checkNotNullExpressionValue(subscribe8, "view.changePasswordClick…teSource()) } }\n        }");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        if (this.s == null) {
            SessionsListPresenter.DefaultImpls.load$default(this, false, 1, null);
        } else {
            d();
        }
        SessionItem sessionItem = this.j;
        if (sessionItem != null) {
            sessionsListView.showConfirmationMenu(a(sessionItem));
        }
    }

    public final SessionItem.Action b(SessionDeleteLink sessionDeleteLink) {
        T t2;
        List<SessionItem.Action> actions;
        boolean z;
        T t3;
        List<? extends SessionsListItem> list = this.c;
        T t4 = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it.next();
                if (SessionsListPresenterKt.access$isCorrespondsTo(t3, sessionDeleteLink)) {
                    break;
                }
            }
            t2 = t3;
        } else {
            t2 = null;
        }
        SessionItem sessionItem = (SessionItem) t2;
        if (sessionItem == null || (actions = sessionItem.getActions()) == null) {
            return null;
        }
        Iterator<T> it2 = actions.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (next.getType() == SessionItem.Action.Type.LOGOUT) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t4 = next;
                break;
            }
        }
        return t4;
    }

    public final DeepLink c(SessionItem sessionItem) {
        T t2;
        boolean z;
        List<SessionItem.Action> actions = sessionItem.getActions();
        if (actions == null) {
            return null;
        }
        Iterator<T> it = actions.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            if ((t3.getDeeplink() instanceof SessionsSocialLogoutLink) || (t3.getDeeplink() instanceof PasswordChangeLink)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t4 = t2;
        if (t4 != null) {
            return t4.getDeeplink();
        }
        return null;
    }

    public final void d() {
        SessionsListView sessionsListView;
        SessionsListView sessionsListView2 = this.a;
        if (sessionsListView2 != null) {
            sessionsListView2.hideProgress();
        }
        ErrorType errorType = this.h;
        if (errorType != null) {
            int ordinal = errorType.ordinal();
            if (ordinal == 0) {
                SessionsListView sessionsListView3 = this.a;
                if (sessionsListView3 != null) {
                    sessionsListView3.showError();
                }
            } else if (ordinal == 1 && (sessionsListView = this.a) != null) {
                String str = this.g;
                if (str == null) {
                    str = "";
                }
                sessionsListView.showNetworkError(str);
            }
        }
        AdapterPresenter adapterPresenter = this.m;
        List<? extends SessionsListItem> list = this.c;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        AdapterPresentersKt.updateItems(adapterPresenter, list);
        SessionsListView sessionsListView4 = this.a;
        if (sessionsListView4 != null) {
            sessionsListView4.onDataChanged();
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    public void detachView() {
        this.d.clear();
        this.f.clear();
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
        this.i = null;
        this.a = null;
    }

    public final List<SessionsListItem> e(List<? extends SessionsListItem> list) {
        ArrayList arrayList = new ArrayList();
        for (T t2 : list) {
            T t3 = t2;
            if (!((t3 instanceof SessionsLoadingItem) || (t3 instanceof SessionsErrorItem))) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    public void load(boolean z) {
        SessionsListView sessionsListView;
        SessionsListView sessionsListView2 = this.a;
        if (sessionsListView2 != null) {
            sessionsListView2.closeMenu();
        }
        if (!z && (sessionsListView = this.a) != null) {
            sessionsListView.showProgress();
        }
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = SessionsListInteractor.DefaultImpls.loadSessions$default(this.l, null, Integer.valueOf(this.k), this.u, 1, null).observeOn(this.r.mainThread()).doOnEach(new e(this)).subscribe(new f(this), g.a);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    public void onAuthResult(int i2) {
        if (i2 == -1) {
            SessionsListPresenter.DefaultImpls.load$default(this, false, 1, null);
            return;
        }
        SessionsListPresenter.Router router = this.b;
        if (router != null) {
            router.closeScreen();
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle putString = new Kundle().putParcelableList("items", this.c).putParcelable("last_deleted", this.j).putString("error_message", this.g);
        ErrorType errorType = this.h;
        return putString.putString("error_type", errorType != null ? errorType.name() : null);
    }
}
