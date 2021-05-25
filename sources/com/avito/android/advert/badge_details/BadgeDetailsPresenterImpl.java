package com.avito.android.advert.badge_details;

import a2.g.r.g;
import com.avito.android.advert.badge_details.BadgeDetailsPresenter;
import com.avito.android.advert.badge_details.di.BadgeId;
import com.avito.android.advert.badge_details.di.ObjectEntity;
import com.avito.android.advert.badge_details.di.ObjectId;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_badge_bar.BadgeDetailsResponse;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\b\b\u0001\u0010.\u001a\u00020+\u0012\b\b\u0001\u0010\"\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010:\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006="}, d2 = {"Lcom/avito/android/advert/badge_details/BadgeDetailsPresenterImpl;", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter;", "Lcom/avito/android/advert/badge_details/BadgeDetailsView;", "view", "", "attachView", "(Lcom/avito/android/advert/badge_details/BadgeDetailsView;)V", "detachView", "()V", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse;", "badgeDetails", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse;)V", "c", "Lcom/avito/android/advert/badge_details/BadgeDetailsView;", "", "h", "Ljava/lang/String;", "objectEntity", "d", "Lcom/avito/android/advert/badge_details/BadgeDetailsPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", g.a, "objectId", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "", "f", "I", "badgeId", "e", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse;", "Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProvider;", "k", "Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProvider;", "resourceProvider", "disposables", "Lcom/avito/android/advert/badge_details/BadgeDetailsInteractor;", "j", "Lcom/avito/android/advert/badge_details/BadgeDetailsInteractor;", "badgeDetailsInteractor", "state", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert/badge_details/BadgeDetailsInteractor;Lcom/avito/android/advert/badge_details/BadgeDetailsResourceProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeDetailsPresenterImpl implements BadgeDetailsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public BadgeDetailsView c;
    public BadgeDetailsPresenter.Router d;
    public BadgeDetailsResponse e;
    public final int f;
    public final String g;
    public final String h;
    public final Analytics i;
    public final BadgeDetailsInteractor j;
    public final BadgeDetailsResourceProvider k;
    public final SchedulersFactory3 l;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            DeepLink uri;
            BadgeDetailsPresenter.Router router;
            int i = this.a;
            if (i == 0) {
                ((BadgeDetailsPresenterImpl) this.b).i.track(new BadgeDetailsButtonClickEvent(((BadgeDetailsPresenterImpl) this.b).g, ((BadgeDetailsPresenterImpl) this.b).f));
                BadgeDetailsResponse.Action action = ((BadgeDetailsResponse) this.c).getAction();
                if (!(action == null || (uri = action.getUri()) == null || (router = ((BadgeDetailsPresenterImpl) this.b).d) == null)) {
                    router.followDeeplink(uri);
                }
                BadgeDetailsPresenter.Router router2 = ((BadgeDetailsPresenterImpl) this.b).d;
                if (router2 != null) {
                    router2.close();
                }
            } else if (i == 1) {
                BadgeDetailsPresenter.Router router3 = ((BadgeDetailsPresenterImpl) this.b).d;
                if (router3 != null) {
                    router3.close();
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        public b(int i) {
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

    @Inject
    public BadgeDetailsPresenterImpl(@BadgeId int i2, @ObjectId @NotNull String str, @ObjectEntity @NotNull String str2, @Nullable Kundle kundle, @NotNull Analytics analytics, @NotNull BadgeDetailsInteractor badgeDetailsInteractor, @NotNull BadgeDetailsResourceProvider badgeDetailsResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "objectId");
        Intrinsics.checkNotNullParameter(str2, "objectEntity");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(badgeDetailsInteractor, "badgeDetailsInteractor");
        Intrinsics.checkNotNullParameter(badgeDetailsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.f = i2;
        this.g = str;
        this.h = str2;
        this.i = analytics;
        this.j = badgeDetailsInteractor;
        this.k = badgeDetailsResourceProvider;
        this.l = schedulersFactory3;
        this.e = kundle != null ? (BadgeDetailsResponse) kundle.getParcelable("badgeDetails") : null;
    }

    public static final void access$handleLoadingState(BadgeDetailsPresenterImpl badgeDetailsPresenterImpl, LoadingState loadingState) {
        BadgeDetailsPresenter.Router router;
        Objects.requireNonNull(badgeDetailsPresenterImpl);
        if (loadingState instanceof LoadingState.Loading) {
            BadgeDetailsView badgeDetailsView = badgeDetailsPresenterImpl.c;
            if (badgeDetailsView != null) {
                badgeDetailsView.showLoading();
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            badgeDetailsPresenterImpl.e = (BadgeDetailsResponse) loaded.getData();
            badgeDetailsPresenterImpl.a((BadgeDetailsResponse) loaded.getData());
        } else if ((loadingState instanceof LoadingState.Error) && (router = badgeDetailsPresenterImpl.d) != null) {
            router.closeWithError(badgeDetailsPresenterImpl.k.getErrorText());
        }
    }

    public final void a(BadgeDetailsResponse badgeDetailsResponse) {
        BadgeDetailsView badgeDetailsView = this.c;
        if (badgeDetailsView != null) {
            String title = badgeDetailsResponse.getTitle();
            String str = "";
            if (title == null) {
                title = str;
            }
            badgeDetailsView.setTitle(title);
            String content = badgeDetailsResponse.getContent();
            if (content != null) {
                str = content;
            }
            badgeDetailsView.setDescription(str);
            BadgeDetailsResponse.Action action = badgeDetailsResponse.getAction();
            badgeDetailsView.setButtonText(action != null ? action.getTitle() : null);
            badgeDetailsView.showContent();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = badgeDetailsView.getButtonClicks().observeOn(this.l.mainThread()).subscribe(new a(0, this, badgeDetailsResponse), b.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "buttonClicks\n           …or(it)\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.b;
            Disposable subscribe2 = badgeDetailsView.getDialogDismisses().observeOn(this.l.mainThread()).subscribe(new a(1, this, badgeDetailsResponse), b.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "dialogDismisses\n        …r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter
    public void attachRouter(@NotNull BadgeDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.d = router;
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter
    public void attachView(@NotNull BadgeDetailsView badgeDetailsView) {
        Intrinsics.checkNotNullParameter(badgeDetailsView, "view");
        this.c = badgeDetailsView;
        BadgeDetailsResponse badgeDetailsResponse = this.e;
        if (badgeDetailsResponse != null) {
            a(badgeDetailsResponse);
            return;
        }
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.j.getBadgeDetails(this.g, this.h, this.f).subscribeOn(this.l.io()).observeOn(this.l.mainThread()).startWithItem(LoadingState.Loading.INSTANCE).subscribe(new a2.a.a.f.u.a(this), new a2.a.a.f.u.b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "badgeDetailsInteractor.g…rrorText) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter
    public void detachView() {
        this.c = null;
        this.a.clear();
        this.b.clear();
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("badgeDetails", this.e);
    }
}
