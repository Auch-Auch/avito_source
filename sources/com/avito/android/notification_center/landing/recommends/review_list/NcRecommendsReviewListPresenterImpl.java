package com.avito.android.notification_center.landing.recommends.review_list;

import a2.g.r.g;
import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItem;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedback;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u00102\u001a\u00020/\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\b\u00103\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010,R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListPresenter;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListView;)V", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedback;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedback;)V", "d", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListRouter;", "e", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListView;", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractor;", "f", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractor;", "interactor", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/jakewharton/rxrelay2/Relay;", "", "i", "Lcom/jakewharton/rxrelay2/Relay;", "itemClicks", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/remote/model/notification_center/NcRecommendsFeedback;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "h", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "kundle", "<init>", "(Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewListPresenterImpl implements NcRecommendsReviewListPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public NcRecommendsFeedback b;
    public Disposable c;
    public NcRecommendsReviewListRouter d;
    public NcRecommendsReviewListView e;
    public final NcRecommendsReviewListInteractor f;
    public final SchedulersFactory g;
    public final AdapterPresenter h;
    public final Relay<Integer> i;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Unit unit) {
            int i = this.a;
            if (i == 0) {
                NcRecommendsReviewListPresenterImpl.access$disposeRequest((NcRecommendsReviewListPresenterImpl) this.b);
                return Unit.INSTANCE;
            } else if (i == 1) {
                NcRecommendsReviewListRouter ncRecommendsReviewListRouter = ((NcRecommendsReviewListPresenterImpl) this.b).d;
                if (ncRecommendsReviewListRouter != null) {
                    ncRecommendsReviewListRouter.closeScreen();
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((NcRecommendsReviewListPresenterImpl) this.b).b();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ NcRecommendsReviewListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl) {
            super(1);
            this.a = ncRecommendsReviewListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            Integer num2 = num;
            NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            NcRecommendsReviewListPresenterImpl.access$itemClicked(ncRecommendsReviewListPresenterImpl, num2.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<LoadingState<? super NcRecommendsFeedback>, Unit> {
        public final /* synthetic */ NcRecommendsReviewListPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl) {
            super(1);
            this.a = ncRecommendsReviewListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super NcRecommendsFeedback> loadingState) {
            NcRecommendsReviewListView ncRecommendsReviewListView;
            LoadingState<? super NcRecommendsFeedback> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                NcRecommendsReviewListView ncRecommendsReviewListView2 = this.a.e;
                if (ncRecommendsReviewListView2 != null) {
                    ncRecommendsReviewListView2.showProgress();
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.c = null;
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.b = (NcRecommendsFeedback) loaded.getData();
                this.a.a((NcRecommendsFeedback) loaded.getData());
                NcRecommendsReviewListView ncRecommendsReviewListView3 = this.a.e;
                if (ncRecommendsReviewListView3 != null) {
                    ncRecommendsReviewListView3.showContent();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.c = null;
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if ((error instanceof ErrorResult) && (ncRecommendsReviewListView = this.a.e) != null) {
                    ncRecommendsReviewListView.showError(((ErrorResult) error).getMessage());
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NcRecommendsReviewListPresenterImpl(@NotNull NcRecommendsReviewListInteractor ncRecommendsReviewListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull Relay<Integer> relay, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(relay, "itemClicks");
        this.f = ncRecommendsReviewListInteractor;
        this.g = schedulersFactory;
        this.h = adapterPresenter;
        this.i = relay;
        this.b = kundle != null ? (NcRecommendsFeedback) kundle.getParcelable("key_data") : null;
    }

    public static final void access$disposeRequest(NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl) {
        Disposable disposable = ncRecommendsReviewListPresenterImpl.c;
        if (disposable != null) {
            disposable.dispose();
        }
        ncRecommendsReviewListPresenterImpl.c = null;
    }

    public static final void access$itemClicked(NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl, int i2) {
        NcRecommendsFeedback ncRecommendsFeedback = ncRecommendsReviewListPresenterImpl.b;
        if (ncRecommendsFeedback != null && i2 >= 1) {
            List<NcRecommendsFeedback.Reason> reasons = ncRecommendsFeedback.getReasons();
            if (i2 <= reasons.size() + 1) {
                if (i2 == reasons.size() + 1) {
                    NcRecommendsReviewListRouter ncRecommendsReviewListRouter = ncRecommendsReviewListPresenterImpl.d;
                    if (ncRecommendsReviewListRouter != null) {
                        ncRecommendsReviewListRouter.showReview(ncRecommendsFeedback.getTitle());
                        return;
                    }
                    return;
                }
                String id = reasons.get(i2 - 1).getId();
                Disposable disposable = ncRecommendsReviewListPresenterImpl.c;
                if (disposable != null) {
                    disposable.dispose();
                }
                ncRecommendsReviewListPresenterImpl.c = Observables.subscribeOnNext(a2.b.a.a.a.T1(ncRecommendsReviewListPresenterImpl.g, ncRecommendsReviewListPresenterImpl.f.send(id), "interactor.send(reasonId…lersFactory.mainThread())"), new a2.a.a.p1.a.b.b.a(ncRecommendsReviewListPresenterImpl));
            }
        }
    }

    public final void a(NcRecommendsFeedback ncRecommendsFeedback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NcRecommendsReviewListTitle("title_0", ncRecommendsFeedback.getTitle()));
        Iterator<T> it = ncRecommendsFeedback.getReasons().iterator();
        while (it.hasNext()) {
            arrayList.add(new NcRecommendsReviewListItem("reason_0", it.next().getTitle()));
        }
        arrayList.add(new NcRecommendsReviewListItem("review_0", "Оставить отзыв"));
        this.h.onDataSourceChanged(new ListDataSource(arrayList));
        NcRecommendsReviewListView ncRecommendsReviewListView = this.e;
        if (ncRecommendsReviewListView != null) {
            ncRecommendsReviewListView.notifyDataChanged();
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter
    public void attachRouter(@NotNull NcRecommendsReviewListRouter ncRecommendsReviewListRouter) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewListRouter, "router");
        this.d = ncRecommendsReviewListRouter;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter
    public void attachView(@NotNull NcRecommendsReviewListView ncRecommendsReviewListView) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewListView, "view");
        this.e = ncRecommendsReviewListView;
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.g, ncRecommendsReviewListView.getCancelDialogCallback(), "view.getCancelDialogCall…lersFactory.mainThread())"), new a(0, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.g, ncRecommendsReviewListView.getBackButtonClicks(), "view.getBackButtonClicks…lersFactory.mainThread())"), new a(1, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.g, ncRecommendsReviewListView.getRetryButtonClicks(), "view.getRetryButtonClick…lersFactory.mainThread())"), new a(2, this)));
        CompositeDisposable compositeDisposable = this.a;
        Observable<Integer> observeOn = this.i.observeOn(this.g.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "itemClicks.observeOn(sch…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(observeOn, new b(this)));
        NcRecommendsFeedback ncRecommendsFeedback = this.b;
        if (ncRecommendsFeedback == null) {
            b();
        } else {
            a(ncRecommendsFeedback);
        }
    }

    public final void b() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = Observables.subscribeOnNext(a2.b.a.a.a.T1(this.g, this.f.load(), "interactor.load()\n      …lersFactory.mainThread())"), new c(this));
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter
    public void detachView() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        this.a.clear();
        this.e = null;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelable("key_data", this.b);
    }
}
