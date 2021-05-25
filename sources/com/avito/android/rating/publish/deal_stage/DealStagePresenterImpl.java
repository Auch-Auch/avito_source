package com.avito.android.rating.publish.deal_stage;

import a2.g.r.g;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.deal_stage.DealStagePresenter;
import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import com.avito.android.rating.publish.deal_stage.adapter.stage.StageItem;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010$\u001a\u00020!\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0(\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010N\u001a\u00020K\u0012\b\u0010S\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bT\u0010UJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\fR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010=R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010?R\u0016\u0010A\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010=R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006V"}, d2 = {"Lcom/avito/android/rating/publish/deal_stage/DealStagePresenterImpl;", "Lcom/avito/android/rating/publish/deal_stage/DealStagePresenter;", "Lcom/avito/android/rating/publish/deal_stage/DealStageView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/deal_stage/DealStageView;)V", "Lcom/avito/android/rating/publish/deal_stage/DealStagePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/deal_stage/DealStagePresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isLoading", "handleLoading", "(Z)V", "", "stageId", "checked", "c", "(Ljava/lang/Long;Z)V", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "", "Lcom/avito/android/rating/publish/deal_stage/adapter/DealStageItem;", "e", "Ljava/util/List;", "items", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "f", "Ljava/lang/Long;", "selectedStageId", "Lio/reactivex/rxjava3/core/Observable;", "k", "Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "Lcom/avito/android/rating/publish/StepListener;", "h", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/dialog/DialogPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "", g.a, "Ljava/lang/String;", "errorMessage", "Lcom/avito/android/rating/publish/deal_stage/DealStageInteractor;", "i", "Lcom/avito/android/rating/publish/deal_stage/DealStageInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/rating/publish/deal_stage/DealStagePresenter$Router;", "d", "viewDisposables", "Lcom/avito/android/rating/publish/deal_stage/DealStageView;", "Lcom/avito/android/error_helper/ErrorHelper;", "n", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/ratings/RatingPublishData;", "o", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "p", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "state", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/android/rating/publish/deal_stage/DealStageInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class DealStagePresenterImpl implements DealStagePresenter {
    public DealStageView a;
    public DealStagePresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends DealStageItem> e;
    public Long f;
    public String g;
    public final StepListener h;
    public final DealStageInteractor i;
    public final AdapterPresenter j;
    public final Observable<DealStageItem> k;
    public final SchedulersFactory3 l;
    public final DialogPresenter m;
    public final ErrorHelper n;
    public final RatingPublishData o;
    public final RatingPublishViewData p;

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
                DealStagePresenter.Router router = ((DealStagePresenterImpl) this.b).b;
                if (router != null) {
                    router.onBackPressed();
                }
            } else if (i == 1) {
                ((DealStagePresenterImpl) this.b).b();
            } else if (i == 2) {
                Long l = ((DealStagePresenterImpl) this.b).f;
                if (l != null) {
                    long longValue = l.longValue();
                    StepListener stepListener = ((DealStagePresenterImpl) this.b).h;
                    RatingPublishData ratingPublishData = ((DealStagePresenterImpl) this.b).o;
                    ratingPublishData.setStageId(Long.valueOf(longValue));
                    RatingPublishViewData ratingPublishViewData = ((DealStagePresenterImpl) this.b).p;
                    ratingPublishViewData.setStageId(Long.valueOf(longValue));
                    stepListener.onStepDataProvided(ratingPublishData, ratingPublishViewData, true);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<DealStageItem> {
        public final /* synthetic */ DealStagePresenterImpl a;

        public b(DealStagePresenterImpl dealStagePresenterImpl) {
            this.a = dealStagePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DealStageItem dealStageItem) {
            DealStageItem dealStageItem2 = dealStageItem;
            if (dealStageItem2 instanceof StageItem) {
                StageItem stageItem = (StageItem) dealStageItem2;
                DealStagePresenterImpl.access$onSelectionChanged(this.a, stageItem);
                StepListener stepListener = this.a.h;
                RatingPublishData ratingPublishData = this.a.o;
                ratingPublishData.setStageId(Long.valueOf(stageItem.getStage().getId()));
                RatingPublishViewData ratingPublishViewData = this.a.p;
                ratingPublishViewData.setStageId(Long.valueOf(stageItem.getStage().getId()));
                stepListener.onStepDataProvided(ratingPublishData, ratingPublishViewData, true);
            }
        }
    }

    public static final class c<T> implements Consumer<List<? extends DealStageItem>> {
        public final /* synthetic */ DealStagePresenterImpl a;

        public c(DealStagePresenterImpl dealStagePresenterImpl) {
            this.a = dealStagePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends DealStageItem> list) {
            List<? extends DealStageItem> list2 = list;
            DealStagePresenterImpl dealStagePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "items");
            DealStagePresenterImpl.access$onItemsLoaded(dealStagePresenterImpl, list2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ DealStagePresenterImpl a;

        public d(DealStagePresenterImpl dealStagePresenterImpl) {
            this.a = dealStagePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            DealStagePresenterImpl dealStagePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            DealStagePresenterImpl.access$handleError(dealStagePresenterImpl, th2);
        }
    }

    @Inject
    public DealStagePresenterImpl(@NotNull StepListener stepListener, @NotNull DealStageInteractor dealStageInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull Observable<DealStageItem> observable, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @Nullable Kundle kundle) {
        Long stageId;
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(dealStageInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(observable, "itemClicks");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        this.h = stepListener;
        this.i = dealStageInteractor;
        this.j = adapterPresenter;
        this.k = observable;
        this.l = schedulersFactory3;
        this.m = dialogPresenter;
        this.n = errorHelper;
        this.o = ratingPublishData;
        this.p = ratingPublishViewData;
        String str = null;
        this.e = kundle != null ? kundle.getParcelableList("items") : null;
        this.f = (kundle == null || (stageId = kundle.getLong("selected_stage_id")) == null) ? ratingPublishViewData.getStageId() : stageId;
        this.g = kundle != null ? kundle.getString("errorMessage") : str;
    }

    public static final void access$handleError(DealStagePresenterImpl dealStagePresenterImpl, Throwable th) {
        TypedError handle = dealStagePresenterImpl.n.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            CompositeDisposable compositeDisposable = dealStagePresenterImpl.d;
            Disposable subscribe = dealStagePresenterImpl.m.showDialog3(((ErrorResult.ErrorDialog) handle).getUserDialog()).subscribe(new a2.a.a.g2.b.k.c(dealStagePresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…ter?.followDeepLink(it) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        DealStageView dealStageView = dealStagePresenterImpl.a;
        if (dealStageView != null) {
            dealStageView.showError(dealStagePresenterImpl.n.recycle(handle));
        }
    }

    public static final void access$onItemsLoaded(DealStagePresenterImpl dealStagePresenterImpl, List list) {
        dealStagePresenterImpl.g = null;
        dealStagePresenterImpl.e = list;
        dealStagePresenterImpl.c(dealStagePresenterImpl.f, true);
        AdapterPresentersKt.updateItems(dealStagePresenterImpl.j, list);
        DealStageView dealStageView = dealStagePresenterImpl.a;
        if (dealStageView != null) {
            dealStageView.notifyItemsChanged();
        }
        dealStagePresenterImpl.a();
    }

    public static final void access$onSelectionChanged(DealStagePresenterImpl dealStagePresenterImpl, StageItem stageItem) {
        Objects.requireNonNull(dealStagePresenterImpl);
        stageItem.setChecked(true);
        dealStagePresenterImpl.c(dealStagePresenterImpl.f, false);
        dealStagePresenterImpl.f = Long.valueOf(stageItem.getStage().getId());
        dealStagePresenterImpl.a();
    }

    public final void a() {
        if (this.o.isLastStep()) {
            DealStageView dealStageView = this.a;
            if (dealStageView != null) {
                dealStageView.showSendButton();
            }
        } else {
            DealStageView dealStageView2 = this.a;
            if (dealStageView2 != null) {
                dealStageView2.showContinueButton();
            }
        }
        boolean z = this.f != null;
        DealStageView dealStageView3 = this.a;
        if (dealStageView3 != null) {
            dealStageView3.setButtonEnabled(z);
        }
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStagePresenter
    public void attachRouter(@NotNull DealStagePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        String str = this.g;
        if (str != null) {
            DealStageView dealStageView = this.a;
            if (dealStageView != null) {
                dealStageView.showError(str);
                return;
            }
            return;
        }
        b();
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStagePresenter
    public void attachView(@NotNull DealStageView dealStageView) {
        Intrinsics.checkNotNullParameter(dealStageView, "view");
        this.a = dealStageView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.k.debounce(250, TimeUnit.MILLISECONDS, this.l.computation()).observeOn(this.l.mainThread()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks\n            .…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = dealStageView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = dealStageView.retryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.retryClicks().subsc…    loadItems()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = dealStageView.continueClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.continueClicks().su…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r1 != null) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r4 = this;
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r4.c
            java.util.List<? extends com.avito.android.rating.publish.deal_stage.adapter.DealStageItem> r1 = r4.e
            if (r1 == 0) goto L_0x0012
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.just(r1)
            java.lang.String r2 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0012
            goto L_0x0039
        L_0x0012:
            com.avito.android.rating.publish.deal_stage.DealStageInteractor r1 = r4.i
            io.reactivex.rxjava3.core.Observable r1 = r1.loadItems()
            com.avito.android.util.SchedulersFactory3 r2 = r4.l
            io.reactivex.rxjava3.core.Scheduler r2 = r2.mainThread()
            io.reactivex.rxjava3.core.Observable r1 = r1.observeOn(r2)
            a2.a.a.g2.b.k.a r2 = new a2.a.a.g2.b.k.a
            r2.<init>(r4)
            io.reactivex.rxjava3.core.Observable r1 = r1.doOnSubscribe(r2)
            a2.a.a.g2.b.k.b r2 = new a2.a.a.g2.b.k.b
            r2.<init>(r4)
            io.reactivex.rxjava3.core.Observable r1 = r1.doOnTerminate(r2)
            java.lang.String r2 = "interactor.loadItems()\n … { view?.hideProgress() }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0039:
            com.avito.android.util.SchedulersFactory3 r2 = r4.l
            io.reactivex.rxjava3.core.Scheduler r2 = r2.mainThread()
            io.reactivex.rxjava3.core.Observable r1 = r1.observeOn(r2)
            com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl$c r2 = new com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl$c
            r2.<init>(r4)
            com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl$d r3 = new com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl$d
            r3.<init>(r4)
            io.reactivex.rxjava3.disposables.Disposable r1 = r1.subscribe(r2, r3)
            java.lang.String r2 = "getItems()\n            .…or(error) }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl.b():void");
    }

    public final void c(Long l2, boolean z) {
        boolean z2;
        List<? extends DealStageItem> list = this.e;
        if (list != null) {
            StageItem stageItem = null;
            if (l2 != null) {
                long longValue = l2.longValue();
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    T t = next;
                    if (!(t instanceof StageItem) || t.getStage().getId() != longValue) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        stageItem = next;
                        break;
                    }
                }
                stageItem = stageItem;
            }
            if (stageItem != null) {
                stageItem.setChecked(z);
                DealStageView dealStageView = this.a;
                if (dealStageView != null) {
                    dealStageView.notifyItemChanged(list.indexOf(stageItem));
                }
            }
        }
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStagePresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStagePresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStagePresenter
    public void handleLoading(boolean z) {
        DealStageView dealStageView = this.a;
        if (dealStageView != null) {
            dealStageView.showLoadingState(z);
        }
    }

    @Override // com.avito.android.rating.publish.deal_stage.DealStagePresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("items", this.e).putLong("selected_stage_id", this.f).putString("errorMessage", this.g);
    }
}
