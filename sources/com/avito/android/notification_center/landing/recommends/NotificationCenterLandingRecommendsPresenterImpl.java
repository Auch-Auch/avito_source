package com.avito.android.notification_center.landing.recommends;

import a2.g.r.g;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationCenterLandingRecommendsAdvertClickEvent;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.notification_center.landing.recommends.di.ItemAdvertRelay;
import com.avito.android.notification_center.landing.recommends.di.ItemReviewRelay;
import com.avito.android.notification_center.landing.recommends.di.ItemTitleRelay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010;\u001a\u000208\u0012\u000e\b\u0001\u0010G\u001a\b\u0012\u0004\u0012\u00020,0\"\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\u000e\b\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\"\u0012\u000e\b\u0001\u0010=\u001a\b\u0012\u0004\u0012\u00020,0\"\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u00107\u001a\u000204\u0012\b\u0010P\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bQ\u0010RJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010%R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u00100R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010%R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010%R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u00100R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsView;)V", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "n", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", VKApiConst.Q, "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverter;", "h", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverter;", "converter", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/serp/adapter/FavorableItem;", "k", "Lcom/jakewharton/rxrelay2/Relay;", "itemAdvertFavoriteClicks", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "d", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;", "", "l", "itemReviewRelay", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "converterDisposable", "e", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsView;", "Lcom/avito/android/util/SchedulersFactory;", "r", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractor;", "i", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractor;", "interactor", AuthSource.OPEN_CHANNEL_LIST, "itemTitleClicks", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "p", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "", g.a, "Ljava/lang/String;", "id", "j", "itemAdvertClicks", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "requestDisposable", "f", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverter;Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsInteractor;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsPresenterImpl implements NotificationCenterLandingRecommendsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public Disposable b;
    public Disposable c;
    public NotificationCenterLandingRecommendsRouter d;
    public NotificationCenterLandingRecommendsView e;
    public NotificationCenterLandingRecommends f;
    public final String g;
    public final NotificationCenterLandingRecommendsConverter h;
    public final NotificationCenterLandingRecommendsInteractor i;
    public final Relay<Integer> j;
    public final Relay<FavorableItem> k;
    public final Relay<Integer> l;
    public final Relay<Integer> m;
    public final AdapterPresenter n;
    public final Analytics o;
    public final FavoriteAdvertsPresenter p;
    public final ViewedAdvertsPresenter q;
    public final SchedulersFactory r;

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
                NotificationCenterLandingRecommendsRouter notificationCenterLandingRecommendsRouter = ((NotificationCenterLandingRecommendsPresenterImpl) this.b).d;
                if (notificationCenterLandingRecommendsRouter != null) {
                    notificationCenterLandingRecommendsRouter.closeScreen();
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((NotificationCenterLandingRecommendsPresenterImpl) this.b).b();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int i = this.a;
            if (i == 0) {
                Integer num2 = num;
                Intrinsics.checkNotNullExpressionValue(num2, "it");
                NotificationCenterLandingRecommendsPresenterImpl.access$elementClicked((NotificationCenterLandingRecommendsPresenterImpl) this.b, num2.intValue());
                return Unit.INSTANCE;
            } else if (i == 1) {
                Integer num3 = num;
                NotificationCenterLandingRecommendsRouter notificationCenterLandingRecommendsRouter = ((NotificationCenterLandingRecommendsPresenterImpl) this.b).d;
                if (notificationCenterLandingRecommendsRouter != null) {
                    Intrinsics.checkNotNullExpressionValue(num3, "it");
                    notificationCenterLandingRecommendsRouter.openReviewListScreen(num3.intValue());
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                Integer num4 = num;
                Intrinsics.checkNotNullExpressionValue(num4, "it");
                NotificationCenterLandingRecommendsPresenterImpl.access$elementClicked((NotificationCenterLandingRecommendsPresenterImpl) this.b, num4.intValue());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<FavorableItem, Unit> {
        public final /* synthetic */ NotificationCenterLandingRecommendsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl) {
            super(1);
            this.a = notificationCenterLandingRecommendsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(FavorableItem favorableItem) {
            FavorableItem favorableItem2 = favorableItem;
            FavoriteAdvertsPresenter favoriteAdvertsPresenter = this.a.p;
            Intrinsics.checkNotNullExpressionValue(favorableItem2, "it");
            favoriteAdvertsPresenter.onFavoriteButtonClicked(favorableItem2);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<List<? extends Item>, Unit> {
        public final /* synthetic */ NotificationCenterLandingRecommendsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl) {
            super(1);
            this.a = notificationCenterLandingRecommendsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl = this.a;
            NotificationCenterLandingRecommendsPresenterImpl.access$removeDisposable(notificationCenterLandingRecommendsPresenterImpl, notificationCenterLandingRecommendsPresenterImpl.b);
            this.a.b = null;
            NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl2 = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            NotificationCenterLandingRecommendsPresenterImpl.access$bindData(notificationCenterLandingRecommendsPresenterImpl2, list2);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<LoadingState<? super NotificationCenterLandingRecommends>, Unit> {
        public final /* synthetic */ NotificationCenterLandingRecommendsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl) {
            super(1);
            this.a = notificationCenterLandingRecommendsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super NotificationCenterLandingRecommends> loadingState) {
            LoadingState<? super NotificationCenterLandingRecommends> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                NotificationCenterLandingRecommendsView notificationCenterLandingRecommendsView = this.a.e;
                if (notificationCenterLandingRecommendsView != null) {
                    notificationCenterLandingRecommendsView.showProgress();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                NotificationCenterLandingRecommendsPresenterImpl.access$removeRequestDisposable(this.a);
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorResult) {
                    NotificationCenterLandingRecommendsView notificationCenterLandingRecommendsView2 = this.a.e;
                    if (notificationCenterLandingRecommendsView2 != null) {
                        notificationCenterLandingRecommendsView2.showLoadingError(((ErrorResult) error).getMessage());
                    }
                } else {
                    NotificationCenterLandingRecommendsView notificationCenterLandingRecommendsView3 = this.a.e;
                    if (notificationCenterLandingRecommendsView3 != null) {
                        notificationCenterLandingRecommendsView3.showLoadingError();
                    }
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                NotificationCenterLandingRecommendsPresenterImpl.access$removeRequestDisposable(this.a);
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.f = (NotificationCenterLandingRecommends) loaded.getData();
                this.a.a((NotificationCenterLandingRecommends) loaded.getData());
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NotificationCenterLandingRecommendsPresenterImpl(@NotNull String str, @NotNull NotificationCenterLandingRecommendsConverter notificationCenterLandingRecommendsConverter, @NotNull NotificationCenterLandingRecommendsInteractor notificationCenterLandingRecommendsInteractor, @ItemAdvertRelay @NotNull Relay<Integer> relay, @NotNull Relay<FavorableItem> relay2, @ItemReviewRelay @NotNull Relay<Integer> relay3, @ItemTitleRelay @NotNull Relay<Integer> relay4, @NotNull AdapterPresenter adapterPresenter, @NotNull Analytics analytics, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsConverter, "converter");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(relay, "itemAdvertClicks");
        Intrinsics.checkNotNullParameter(relay2, "itemAdvertFavoriteClicks");
        Intrinsics.checkNotNullParameter(relay3, "itemReviewRelay");
        Intrinsics.checkNotNullParameter(relay4, "itemTitleClicks");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.g = str;
        this.h = notificationCenterLandingRecommendsConverter;
        this.i = notificationCenterLandingRecommendsInteractor;
        this.j = relay;
        this.k = relay2;
        this.l = relay3;
        this.m = relay4;
        this.n = adapterPresenter;
        this.o = analytics;
        this.p = favoriteAdvertsPresenter;
        this.q = viewedAdvertsPresenter;
        this.r = schedulersFactory;
        this.f = kundle != null ? (NotificationCenterLandingRecommends) kundle.getParcelable("key_data") : null;
    }

    public static final void access$bindData(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl, List list) {
        NotificationCenterLandingRecommendsView notificationCenterLandingRecommendsView = notificationCenterLandingRecommendsPresenterImpl.e;
        if (notificationCenterLandingRecommendsView != null) {
            ListDataSource listDataSource = new ListDataSource(list);
            notificationCenterLandingRecommendsPresenterImpl.n.onDataSourceChanged(listDataSource);
            notificationCenterLandingRecommendsPresenterImpl.p.onDataSourceChanged(listDataSource);
            notificationCenterLandingRecommendsPresenterImpl.q.onDataSourceChanged(listDataSource);
            notificationCenterLandingRecommendsView.notifyDataChanged();
            notificationCenterLandingRecommendsView.showContent();
        }
    }

    public static final void access$elementClicked(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl, int i2) {
        NotificationCenterLandingRecommendsRouter notificationCenterLandingRecommendsRouter;
        NotificationCenterLandingRecommends notificationCenterLandingRecommends = notificationCenterLandingRecommendsPresenterImpl.f;
        if (notificationCenterLandingRecommends != null) {
            List<NotificationCenterLandingRecommends.Element> elements = notificationCenterLandingRecommends.getElements();
            if (i2 >= 1 && i2 <= elements.size()) {
                NotificationCenterLandingRecommends.Element element = elements.get(i2 - 1);
                if (element instanceof NotificationCenterLandingRecommends.Element.Advert) {
                    Map<String, String> analyticParams = notificationCenterLandingRecommends.getAnalyticParams();
                    if (analyticParams != null) {
                        notificationCenterLandingRecommendsPresenterImpl.o.track(new NotificationCenterLandingRecommendsAdvertClickEvent(((NotificationCenterLandingRecommends.Element.Advert) element).getId(), analyticParams));
                    }
                    NotificationCenterLandingRecommendsRouter notificationCenterLandingRecommendsRouter2 = notificationCenterLandingRecommendsPresenterImpl.d;
                    if (notificationCenterLandingRecommendsRouter2 != null) {
                        notificationCenterLandingRecommendsRouter2.openDeepLink(((NotificationCenterLandingRecommends.Element.Advert) element).getDeepLink());
                    }
                } else if ((element instanceof NotificationCenterLandingRecommends.Element.Title) && (notificationCenterLandingRecommendsRouter = notificationCenterLandingRecommendsPresenterImpl.d) != null) {
                    notificationCenterLandingRecommendsRouter.openDeepLink(((NotificationCenterLandingRecommends.Element.Title) element).getAction().getDeepLink());
                }
            }
        }
    }

    public static final void access$removeDisposable(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl, Disposable disposable) {
        Objects.requireNonNull(notificationCenterLandingRecommendsPresenterImpl);
        if (disposable != null) {
            notificationCenterLandingRecommendsPresenterImpl.a.remove(disposable);
        }
    }

    public static final void access$removeRequestDisposable(NotificationCenterLandingRecommendsPresenterImpl notificationCenterLandingRecommendsPresenterImpl) {
        Disposable disposable = notificationCenterLandingRecommendsPresenterImpl.c;
        if (disposable != null) {
            notificationCenterLandingRecommendsPresenterImpl.a.remove(disposable);
        }
        notificationCenterLandingRecommendsPresenterImpl.c = null;
    }

    public final void a(NotificationCenterLandingRecommends notificationCenterLandingRecommends) {
        Disposable subscribeOnNext = Observables.subscribeOnNext(a2.b.a.a.a.T1(this.r, this.h.convert(notificationCenterLandingRecommends).subscribeOn(this.r.io()), "converter.convert(data)\n…lersFactory.mainThread())"), new d(this));
        this.b = subscribeOnNext;
        DisposableKt.plusAssign(this.a, subscribeOnNext);
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter
    public void attachRouter(@NotNull NotificationCenterLandingRecommendsRouter notificationCenterLandingRecommendsRouter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsRouter, "router");
        this.d = notificationCenterLandingRecommendsRouter;
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter
    public void attachView(@NotNull NotificationCenterLandingRecommendsView notificationCenterLandingRecommendsView) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsView, "view");
        this.e = notificationCenterLandingRecommendsView;
        this.p.attachView(notificationCenterLandingRecommendsView);
        this.p.attachErrorMessageView(notificationCenterLandingRecommendsView);
        CompositeDisposable compositeDisposable = this.a;
        Observable<Integer> observeOn = this.j.observeOn(this.r.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "itemAdvertClicks.observe…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(observeOn, new b(0, this)));
        CompositeDisposable compositeDisposable2 = this.a;
        Observable<FavorableItem> observeOn2 = this.k.observeOn(this.r.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn2, "itemAdvertFavoriteClicks…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable2, Observables.subscribeOnNext(observeOn2, new c(this)));
        CompositeDisposable compositeDisposable3 = this.a;
        Observable<Integer> observeOn3 = this.l.observeOn(this.r.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn3, "itemReviewRelay.observeO…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable3, Observables.subscribeOnNext(observeOn3, new b(1, this)));
        CompositeDisposable compositeDisposable4 = this.a;
        Observable<Integer> observeOn4 = this.m.observeOn(this.r.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn4, "itemTitleClicks.observeO…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable4, Observables.subscribeOnNext(observeOn4, new b(2, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.r, notificationCenterLandingRecommendsView.getBackButtonClicks(), "view.getBackButtonClicks…lersFactory.mainThread())"), new a(0, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.r, notificationCenterLandingRecommendsView.getRetryButtonClicks(), "view.getRetryButtonClick…lersFactory.mainThread())"), new a(1, this)));
        NotificationCenterLandingRecommends notificationCenterLandingRecommends = this.f;
        if (notificationCenterLandingRecommends == null) {
            b();
            return;
        }
        notificationCenterLandingRecommendsView.showProgress();
        a(notificationCenterLandingRecommends);
    }

    public final void b() {
        Disposable subscribeOnNext = Observables.subscribeOnNext(a2.b.a.a.a.T1(this.r, this.i.getNotificationCenterLandingRecommends(this.g), "interactor.getNotificati…lersFactory.mainThread())"), new e(this));
        this.c = subscribeOnNext;
        DisposableKt.plusAssign(this.a, subscribeOnNext);
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter
    public void detachView() {
        this.p.detachViews();
        this.a.clear();
        this.b = null;
        this.c = null;
        this.e = null;
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putParcelable("key_data", this.f);
    }
}
