package com.avito.android.profile.sessions.info;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SessionsShowExtraInfo;
import com.avito.android.analytics.event.SessionsSupportLinkClickEvent;
import com.avito.android.profile.sessions.info.SessionsInfoPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx3.Disposables;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoPresenterImpl;", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter;", "Lcom/avito/android/profile/sessions/info/SessionsInfoView;", "view", "", "attachView", "(Lcom/avito/android/profile/sessions/info/SessionsInfoView;)V", "detachView", "()V", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;)V", "detachRouter", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Mode;", "d", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Mode;", "mode", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile/sessions/info/SessionsInfoView;", "<init>", "(Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Mode;Lcom/avito/android/analytics/Analytics;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsInfoPresenterImpl implements SessionsInfoPresenter {
    public SessionsInfoView a;
    public SessionsInfoPresenter.Router b;
    public CompositeDisposable c = new CompositeDisposable();
    public final SessionsInfoPresenter.Mode d;
    public final Analytics e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SessionsInfoPresenter.Mode.values();
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
                SessionsInfoPresenter.Router router = ((SessionsInfoPresenterImpl) this.b).b;
                if (router != null) {
                    router.navigateToSessionsList();
                }
            } else if (i == 1) {
                SessionsInfoPresenterImpl.access$openLink((SessionsInfoPresenterImpl) this.b);
            } else if (i == 2) {
                SessionsInfoPresenter.Router router2 = ((SessionsInfoPresenterImpl) this.b).b;
                if (router2 != null) {
                    router2.navigateToSessionsList();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ SessionsInfoPresenterImpl a;
        public final /* synthetic */ SessionsInfoView b;

        public b(SessionsInfoPresenterImpl sessionsInfoPresenterImpl, SessionsInfoView sessionsInfoView) {
            this.a = sessionsInfoPresenterImpl;
            this.b = sessionsInfoView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.e.track(new SessionsShowExtraInfo());
            this.b.expandInfo();
        }
    }

    @Inject
    public SessionsInfoPresenterImpl(@NotNull SessionsInfoPresenter.Mode mode, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = mode;
        this.e = analytics;
    }

    public static final void access$openLink(SessionsInfoPresenterImpl sessionsInfoPresenterImpl) {
        sessionsInfoPresenterImpl.e.track(new SessionsSupportLinkClickEvent());
        SessionsInfoPresenter.Router router = sessionsInfoPresenterImpl.b;
        if (router != null) {
            router.openHelpCenter("request/119?eventData[articleId]=1399&eventData[contextId]=102");
        }
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoPresenter
    public void attachRouter(@NotNull SessionsInfoPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoPresenter
    public void attachView(@NotNull SessionsInfoView sessionsInfoView) {
        Intrinsics.checkNotNullParameter(sessionsInfoView, "view");
        this.a = sessionsInfoView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = sessionsInfoView.getButtonClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.buttonClicks.subscr…avigateToSessionsList() }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = sessionsInfoView.getHelpCenterLinkClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.helpCenterLinkClicks.subscribe { openLink() }");
        Disposables.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Disposable subscribe3 = sessionsInfoView.getNavigationClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.navigationClicks.su…avigateToSessionsList() }");
        Disposables.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.c;
        Disposable subscribe4 = sessionsInfoView.getExpandInfoClicks().subscribe(new b(this, sessionsInfoView));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.expandInfoClicks.su…ew.expandInfo()\n        }");
        Disposables.plusAssign(compositeDisposable4, subscribe4);
        int ordinal = this.d.ordinal();
        if (ordinal == 0) {
            sessionsInfoView.bindTextsForLogout();
        } else if (ordinal == 1) {
            sessionsInfoView.bindTextsForPasswordChange();
        }
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoPresenter
    public void detachView() {
        this.c.clear();
    }
}
