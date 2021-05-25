package com.avito.android.rating.publish;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.ChainedDeepLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneAddLink;
import com.avito.android.deep_linking.links.RefreshLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.tracker.RatingPublishTracker;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.publish.AddRatingResult;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.remote.model.publish.RatingPublishResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010j\u001a\u00020g\u0012\b\u0010t\u001a\u0004\u0018\u00010.¢\u0006\u0004\bu\u0010vJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J3\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u0010\u0004J'\u00107\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0010H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0002H\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010:\u001a\u00020\u0002H\u0016¢\u0006\u0004\b:\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010AR\u0018\u0010D\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010RR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010UR\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010aR\u0016\u0010b\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010AR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010kR\u0016\u0010m\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010ER\u0016\u0010o\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010ER\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006w"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishPresenterImpl;", "Lcom/avito/android/rating/publish/RatingPublishPresenter;", "", a2.g.r.g.a, "()V", "Lkotlin/Function0;", "show", "c", "(Lkotlin/jvm/functions/Function0;)V", "d", "Lcom/avito/android/rating/publish/RatingPublishStep;", "ratingPublishStep", "", "rawStep", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "", "isLastStep", "e", "(Lcom/avito/android/rating/publish/RatingPublishStep;Ljava/lang/String;Lcom/avito/android/ratings/RatingPublishData;Z)Lcom/avito/android/ratings/RatingPublishData;", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "newRatingData", "f", "(Lcom/avito/android/rating/publish/RatingPublishStep;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/ratings/RatingPublishData;)V", "", "error", AuthSource.BOOKING_ORDER, "(Ljava/lang/Throwable;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.SEND_ABUSE, "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "stepId", "h", "(Ljava/lang/String;)Z", "Lcom/avito/android/rating/publish/RatingPublishView;", "view", "attachView", "(Lcom/avito/android/rating/publish/RatingPublishView;)V", "Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/ratings/RatingPublishConfig;", Navigation.CONFIG, "handleConfig", "(Lcom/avito/android/ratings/RatingPublishConfig;)V", "onPopScreen", "isCompleted", "onStepDataProvided", "(Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Z)V", "onBackPressed", "onActionSuccess", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "Lcom/avito/android/rating/publish/RatingPublishInteractor;", "p", "Lcom/avito/android/rating/publish/RatingPublishInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/ratings/RatingPublishConfig;", "ratingConfig", "Z", "firstScreenOpened", "Landroid/os/Handler;", "n", "Landroid/os/Handler;", "handler", "j", "Lcom/avito/android/deep_linking/links/DeepLink;", "nextDeepLink", "Lcom/avito/android/util/RandomKeyProvider;", "r", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;", "Ljava/lang/Runnable;", "l", "Ljava/lang/Runnable;", "showLoadingRunnable", "Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", VKApiConst.Q, "Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "tracker", AuthSource.OPEN_CHANNEL_LIST, "hideLoadingRunnable", "Lcom/avito/android/util/SchedulersFactory3;", "s", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/publish/RatingPublishView;", "viewDisposables", "Lcom/avito/android/error_helper/ErrorHelper;", "t", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;", "u", "Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;", "stepHolder", "Lcom/avito/android/ratings/RatingPublishData;", "i", "processAfterActionSuccess", "k", "wasAnyDataLoaded", "", "o", "J", "loadingShowTime", "state", "<init>", "(Lcom/avito/android/rating/publish/RatingPublishInteractor;Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishPresenterImpl implements RatingPublishPresenter {
    public RatingPublishView a;
    public RatingPublishPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public RatingPublishData e;
    public RatingPublishViewData f;
    public RatingPublishConfig g;
    public boolean h;
    public boolean i;
    public DeepLink j;
    public boolean k;
    public final Runnable l;
    public final Runnable m;
    public final Handler n;
    public long o;
    public final RatingPublishInteractor p;
    public final RatingPublishTracker q;
    public final RandomKeyProvider r;
    public final SchedulersFactory3 s;
    public final ErrorHelper t;
    public final RatingPublishPresenter.StepHolder u;

    /* compiled from: java-style lambda group */
    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 0) {
                RatingPublishView ratingPublishView = ((RatingPublishPresenterImpl) this.b).a;
                if (ratingPublishView != null) {
                    ratingPublishView.hideProgress();
                }
                ((RatingPublishPresenterImpl) this.b).o = 0;
            } else if (i == 1) {
                RatingPublishView ratingPublishView2 = ((RatingPublishPresenterImpl) this.b).a;
                if (ratingPublishView2 != null) {
                    ratingPublishView2.showProgress();
                }
                ((RatingPublishPresenterImpl) this.b).o = System.currentTimeMillis();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Disposable disposable) {
            int i = this.a;
            if (i == 0) {
                RatingPublishPresenterImpl.access$showProgress((RatingPublishPresenterImpl) this.b);
            } else if (i == 1) {
                RatingPublishPresenterImpl.access$showProgress((RatingPublishPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RatingPublishPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RatingPublishPresenterImpl ratingPublishPresenterImpl) {
            super(0);
            this.a = ratingPublishPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RatingPublishPresenter.Router router;
            if (!this.a.k && (router = this.a.b) != null) {
                router.onExit();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ RatingPublishPresenterImpl a;
        public final /* synthetic */ Function0 b;

        public d(RatingPublishPresenterImpl ratingPublishPresenterImpl, Function0 function0) {
            this.a = ratingPublishPresenterImpl;
            this.b = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m.run();
            this.b.invoke();
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class f<T> implements Consumer<AddRatingResult> {
        public final /* synthetic */ RatingPublishPresenterImpl a;
        public final /* synthetic */ RatingPublishData b;

        public f(RatingPublishPresenterImpl ratingPublishPresenterImpl, RatingPublishData ratingPublishData) {
            this.a = ratingPublishPresenterImpl;
            this.b = ratingPublishData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddRatingResult addRatingResult) {
            this.a.c(new a2.a.a.g2.b.f(this, addRatingResult));
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ RatingPublishPresenterImpl a;

        public g(RatingPublishPresenterImpl ratingPublishPresenterImpl) {
            this.a = ratingPublishPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.c(new a2.a.a.g2.b.g(this, th));
        }
    }

    public static final class h<T> implements Consumer<RatingPublishResult> {
        public final /* synthetic */ RatingPublishPresenterImpl a;

        public h(RatingPublishPresenterImpl ratingPublishPresenterImpl) {
            this.a = ratingPublishPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(RatingPublishResult ratingPublishResult) {
            this.a.k = true;
            this.a.c(new a2.a.a.g2.b.h(this, ratingPublishResult));
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ RatingPublishPresenterImpl a;

        public i(RatingPublishPresenterImpl ratingPublishPresenterImpl) {
            this.a = ratingPublishPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.c(new a2.a.a.g2.b.i(this, th));
        }
    }

    @Inject
    public RatingPublishPresenterImpl(@NotNull RatingPublishInteractor ratingPublishInteractor, @NotNull RatingPublishTracker ratingPublishTracker, @NotNull RandomKeyProvider randomKeyProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper, @NotNull RatingPublishPresenter.StepHolder stepHolder, @Nullable Kundle kundle) {
        Parcelable parcelable;
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(ratingPublishInteractor, "interactor");
        Intrinsics.checkNotNullParameter(ratingPublishTracker, "tracker");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(stepHolder, "stepHolder");
        this.p = ratingPublishInteractor;
        this.q = ratingPublishTracker;
        this.r = randomKeyProvider;
        this.s = schedulersFactory3;
        this.t = errorHelper;
        this.u = stepHolder;
        DeepLink deepLink = null;
        this.e = kundle != null ? (RatingPublishData) kundle.getParcelable("rating_data") : null;
        this.f = kundle != null ? (RatingPublishViewData) kundle.getParcelable("rating_view_data") : null;
        this.g = kundle != null ? (RatingPublishConfig) kundle.getParcelable("rating_config") : null;
        this.h = (kundle == null || (bool2 = kundle.getBoolean("first_screen_opened")) == null) ? false : bool2.booleanValue();
        this.i = (kundle == null || (bool = kundle.getBoolean("process_after_action_success")) == null) ? false : bool.booleanValue();
        this.j = kundle != null ? (DeepLink) kundle.getParcelable("key_next_deeplink") : deepLink;
        this.k = (kundle == null || (parcelable = kundle.getParcelable("key_was_data_loaded")) == null) ? false : ((Boolean) parcelable).booleanValue();
        this.l = new a(1, this);
        this.m = new a(0, this);
        this.n = new Handler(Looper.getMainLooper());
    }

    public static final void access$handleStep(RatingPublishPresenterImpl ratingPublishPresenterImpl, RatingPublishResult ratingPublishResult) {
        RatingPublishViewData ratingPublishViewData;
        RatingPublishPresenter.Router router;
        Objects.requireNonNull(ratingPublishPresenterImpl);
        RatingPublishStep parseRatingPublishStep = RatingPublishStepKt.parseRatingPublishStep(ratingPublishResult.getNextStep());
        RatingPublishStepType parseRatingPublishStepType = RatingPublishStepTypeKt.parseRatingPublishStepType(ratingPublishResult.getNextStepType());
        RatingPublishData ratingPublishData = ratingPublishPresenterImpl.e;
        if (ratingPublishData != null && (ratingPublishViewData = ratingPublishPresenterImpl.f) != null) {
            Boolean isFinal = ratingPublishResult.isFinal();
            boolean booleanValue = isFinal != null ? isFinal.booleanValue() : false;
            String nextStep = ratingPublishResult.getNextStep();
            if (nextStep != null) {
                RatingPublishData e2 = ratingPublishPresenterImpl.e(parseRatingPublishStep, nextStep, ratingPublishData, booleanValue);
                ratingPublishPresenterImpl.f(parseRatingPublishStep, ratingPublishViewData, e2);
                if (parseRatingPublishStepType != null) {
                    NextStagePayload payload = ratingPublishResult.getPayload();
                    if (payload != null) {
                        if (parseRatingPublishStepType == RatingPublishStepType.RADIO_SELECT) {
                            NextStagePayload payload2 = ratingPublishResult.getPayload();
                            if ((payload2 != null ? payload2.getOptions() : null) == null) {
                                ratingPublishPresenterImpl.b(new IllegalStateException("expected options for step type: " + parseRatingPublishStepType));
                                return;
                            }
                        }
                        try {
                            RatingPublishPresenter.Router router2 = ratingPublishPresenterImpl.b;
                            if (router2 != null) {
                                router2.openScreen(nextStep, parseRatingPublishStepType, payload, e2, ratingPublishViewData);
                            }
                        } catch (Exception e3) {
                            ratingPublishPresenterImpl.b(e3);
                        }
                    } else {
                        ratingPublishPresenterImpl.b(new IllegalStateException("expected payload for step with type: " + parseRatingPublishStepType));
                    }
                } else if (parseRatingPublishStep != null && (router = ratingPublishPresenterImpl.b) != null) {
                    router.openScreen(parseRatingPublishStep, e2, ratingPublishViewData);
                }
            }
        }
    }

    public static final void access$showProgress(RatingPublishPresenterImpl ratingPublishPresenterImpl) {
        ratingPublishPresenterImpl.n.removeCallbacks(ratingPublishPresenterImpl.m);
        ratingPublishPresenterImpl.n.removeCallbacks(ratingPublishPresenterImpl.l);
        RatingPublishData ratingPublishData = ratingPublishPresenterImpl.e;
        if (ratingPublishPresenterImpl.h(ratingPublishData != null ? ratingPublishData.getStepId() : null)) {
            ratingPublishPresenterImpl.u.proxyLoadingState(true);
        } else {
            ratingPublishPresenterImpl.n.postDelayed(ratingPublishPresenterImpl.l, 300);
        }
    }

    public final void a(DeepLink deepLink) {
        if (deepLink instanceof ChainedDeepLink) {
            this.j = ((ChainedDeepLink) deepLink).getThen();
        }
        if (deepLink instanceof PhoneAddLink) {
            RatingPublishPresenter.Router router = this.b;
            if (router != null) {
                router.followDeepLink(deepLink, 0);
            }
        } else if (deepLink instanceof RefreshLink) {
            g();
        } else {
            RatingPublishPresenter.Router router2 = this.b;
            if (router2 != null) {
                router2.followDeepLink(deepLink);
            }
        }
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void attachRouter(@NotNull RatingPublishPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        if (!this.h) {
            g();
            this.h = true;
        }
        if (this.i) {
            this.i = false;
            DeepLink deepLink = this.j;
            if (deepLink != null) {
                a(deepLink);
                this.j = null;
                return;
            }
            g();
        }
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void attachView(@NotNull RatingPublishView ratingPublishView) {
        Intrinsics.checkNotNullParameter(ratingPublishView, "view");
        this.a = ratingPublishView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Throwable r12) {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.publish.RatingPublishPresenterImpl.b(java.lang.Throwable):void");
    }

    public final void c(Function0<Unit> function0) {
        this.n.removeCallbacks(this.m);
        this.n.removeCallbacks(this.l);
        RatingPublishData ratingPublishData = this.e;
        if (h(ratingPublishData != null ? ratingPublishData.getStepId() : null)) {
            this.u.proxyLoadingState(false);
            function0.invoke();
        } else if (this.o > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.o;
            if (currentTimeMillis < 1100) {
                this.n.postDelayed(new d(this, function0), 1100 - currentTimeMillis);
                return;
            }
            RatingPublishView ratingPublishView = this.a;
            if (ratingPublishView != null) {
                ratingPublishView.hideProgress();
            }
            this.o = 0;
            function0.invoke();
        } else {
            RatingPublishView ratingPublishView2 = this.a;
            if (ratingPublishView2 != null) {
                ratingPublishView2.hideProgress();
            }
            function0.invoke();
        }
    }

    public final void d() {
        this.n.removeCallbacks(this.m);
        this.n.removeCallbacks(this.l);
        this.o = 0;
        c(e.a);
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void detachRouter() {
        this.c.clear();
        d();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    public final RatingPublishData e(RatingPublishStep ratingPublishStep, String str, RatingPublishData ratingPublishData, boolean z) {
        String stepId;
        return RatingPublishData.copy$default(ratingPublishData, ratingPublishData.getUserKey(), ratingPublishData.getItemId(), ratingPublishData.getStageId(), ratingPublishData.getScore(), ratingPublishData.getComment(), ratingPublishData.getContextId(), ratingPublishData.getFilesOperationId(), ratingPublishData.getImagesOperationId(), ratingPublishData.getBuyerInfo(), (ratingPublishStep == null || (stepId = ratingPublishStep.getStepId()) == null) ? str : stepId, z, null, ratingPublishData.getDynamicParams(), 2048, null);
    }

    public final void f(RatingPublishStep ratingPublishStep, RatingPublishViewData ratingPublishViewData, RatingPublishData ratingPublishData) {
        if (RatingPublishStep.IMAGES == ratingPublishStep) {
            if (ratingPublishViewData.getImagesOperationId() == null) {
                ratingPublishViewData.setImagesOperationId(this.r.generateKey());
            }
            ratingPublishData.setImagesOperationId(ratingPublishViewData.getImagesOperationId());
        } else if (RatingPublishStep.REG_VEHICLE == ratingPublishStep || RatingPublishStep.DEAL_PROOF == ratingPublishStep) {
            if (ratingPublishViewData.getFilesOperationId() == null) {
                ratingPublishViewData.setFilesOperationId(this.r.generateKey());
            }
            ratingPublishData.setFilesOperationId(ratingPublishViewData.getFilesOperationId());
        }
    }

    public final void g() {
        RatingPublishData ratingPublishData = this.e;
        if (ratingPublishData == null) {
            return;
        }
        if (ratingPublishData.isLastStep()) {
            this.q.startSendRatingLoading();
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.p.sendRating(ratingPublishData).observeOn(this.s.mainThread()).doOnSubscribe(new b(0, this)).subscribe(new f(this, ratingPublishData), new g(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.sendRating(ra…     }\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        this.q.startNextStepLoading();
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = this.p.sendRatingForm(ratingPublishData).observeOn(this.s.mainThread()).doOnSubscribe(new b(1, this)).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.sendRatingFor…     }\n                })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public final boolean h(String str) {
        return str != null && (Intrinsics.areEqual(str, RatingPublishStep.ITEMS.getStepId()) ^ true);
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void handleConfig(@NotNull RatingPublishConfig ratingPublishConfig) {
        Intrinsics.checkNotNullParameter(ratingPublishConfig, Navigation.CONFIG);
        this.g = ratingPublishConfig;
        this.e = new RatingPublishData(ratingPublishConfig.getUserKey(), ratingPublishConfig.getItemId(), null, ratingPublishConfig.getScore(), null, ratingPublishConfig.getContext(), null, null, null, null, false, null, null, 8148, null);
        this.f = new RatingPublishViewData(ratingPublishConfig.getItemId(), null, ratingPublishConfig.getScore(), null, null, null, null, null, 250, null);
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void onActionSuccess() {
        this.i = true;
    }

    @Override // com.avito.android.rating.publish.StepListener
    public void onBackPressed() {
        RatingPublishPresenter.Router router = this.b;
        if (router != null) {
            router.onBackPressed();
        }
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    public void onPopScreen() {
        this.c.clear();
        d();
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("rating_data", this.e).putParcelable("rating_view_data", this.f).putParcelable("rating_config", this.g).putBoolean("first_screen_opened", Boolean.valueOf(this.h)).putBoolean("process_after_action_success", Boolean.valueOf(this.i)).putParcelable("key_next_deeplink", this.j).putBoolean("key_was_data_loaded", Boolean.valueOf(this.k));
    }

    @Override // com.avito.android.rating.publish.StepListener
    public void onStepDataProvided(@NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, boolean z) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        this.e = ratingPublishData;
        this.f = ratingPublishViewData;
        if (z) {
            g();
        }
    }
}
