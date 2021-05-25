package com.avito.android.public_profile.ui;

import a2.a.a.d2.c.j;
import com.avito.android.FavoriteSeller;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscribeSellerButtonEvent;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.event.favorite.UnsubscribeSellerButtonEvent;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.di.PublicProfileFragmentModule;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.Maybies;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B}\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u00104\u001a\u000201\u0012\u0010\u0010I\u001a\f\u0012\u0006\b\u0001\u0012\u00020F\u0018\u00010E\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010m\u001a\u00020j\u0012\n\b\u0001\u0010w\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010s\u001a\u00020p\u0012\u0006\u0010y\u001a\u00020x¢\u0006\u0004\bz\u0010{J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0019J!\u0010&\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0019J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010\u0019J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u0019J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR \u0010I\u001a\f\u0012\u0006\b\u0001\u0012\u00020F\u0018\u00010E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010]R\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010hR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006|"}, d2 = {"Lcom/avito/android/public_profile/ui/SubscriptionsPresenterImpl;", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "Lcom/avito/android/public_profile/ui/OnBackPressedListener;", "", "needSubscribe", "fromUser", "", AuthSource.SEND_ABUSE, "(ZZ)V", "", "userKey", "contextId", "setUserData", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;", "view", "attachContainerView", "(Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;)V", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "attachButtonsView", "(Lcom/avito/android/public_profile/ui/SubscribeButtonsView;)V", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "attachCounterView", "(Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;)V", "detachView", "()V", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onStartProfileLoading", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "info", "force", "updateSellersSubscription", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Z)V", "onBackPressed", "()Z", "refreshNotificationMenuItem", "onAuthCompleted", "onAuthCanceled", "onSubscribeLinkFollow", "(Z)V", "subscriptionStatusChanged", "(Ljava/lang/String;)Z", "Lcom/avito/android/error_helper/ErrorHelper;", "p", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", AuthSource.BOOKING_ORDER, "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "buttonsView", "d", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "j", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "n", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "resourceProvider", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "o", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "interactor", "Ldagger/Lazy;", "Lcom/avito/android/public_profile/ui/SubscriptionStateListener;", VKApiConst.Q, "Ldagger/Lazy;", "stateListener", "Lcom/avito/android/util/SchedulersFactory3;", "r", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "k", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/FavoriteSellersRepository;", "l", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;", "containerView", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "t", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "subscriptionSource", "i", "Ljava/lang/String;", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", a2.g.r.g.a, "Ljava/lang/Boolean;", "targetSubscribe", "h", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscribeDisposables", "Lcom/avito/android/analytics/Analytics;", "s", "Lcom/avito/android/analytics/Analytics;", "analytics", "e", "disposables", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "u", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "c", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "counterView", "state", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;Lcom/avito/android/public_profile/ui/SubscribeInteractor;Lcom/avito/android/error_helper/ErrorHelper;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionsPresenterImpl implements SubscriptionsPresenter, OnBackPressedListener {
    public SubscriptionsContainerView a;
    public SubscribeButtonsView b;
    public SubscriptionsCounterView c;
    public SubscriptionsPresenter.Router d;
    public final CompositeDisposable e = new CompositeDisposable();
    public final CompositeDisposable f = new CompositeDisposable();
    public Boolean g;
    public String h;
    public String i;
    public SubscribeInfo j;
    public final NotificationManagerProvider k;
    public final FavoriteSellersRepository l;
    public final AccountStateProvider m;
    public final SubscriptionsResourceProvider n;
    public final SubscribeInteractor o;
    public final ErrorHelper p;
    public final Lazy<? extends SubscriptionStateListener> q;
    public final SchedulersFactory3 r;
    public final Analytics s;
    public final SubscriptionSource t;
    public final CompositeSnackbarPresenter u;

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
            Boolean isSubscribed;
            int i = this.a;
            if (i == 0) {
                SubscribeInfo subscribeInfo = ((SubscriptionsPresenterImpl) this.b).j;
                if (subscribeInfo != null && (isSubscribed = subscribeInfo.isSubscribed()) != null) {
                    if (isSubscribed.booleanValue()) {
                        SubscriptionsPresenterImpl.access$onSettingsClicked((SubscriptionsPresenterImpl) this.b);
                    } else {
                        SubscriptionsPresenterImpl.access$onSubscribeClicked((SubscriptionsPresenterImpl) this.b, true);
                    }
                }
            } else if (i == 1) {
                SubscribeInfo subscribeInfo2 = ((SubscriptionsPresenterImpl) this.b).j;
                if (subscribeInfo2 != null) {
                    SubscriptionsPresenterImpl.access$onNotificationsClicked((SubscriptionsPresenterImpl) this.b, subscribeInfo2);
                }
            } else if (i != 2) {
                throw null;
            } else if (((SubscriptionsPresenterImpl) this.b).j != null) {
                SubscriptionsPresenterImpl.access$onSubscribeClicked((SubscriptionsPresenterImpl) this.b, false);
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b implements Action {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            int i = this.a;
            if (i == 0) {
                SubscribeButtonsView subscribeButtonsView = ((SubscriptionsPresenterImpl) this.b).b;
                if (subscribeButtonsView != null) {
                    subscribeButtonsView.setSubscribeLoading(false);
                }
            } else if (i == 1) {
                ((SubscriptionsPresenterImpl) this.b).g = null;
                SubscribeButtonsView subscribeButtonsView2 = ((SubscriptionsPresenterImpl) this.b).b;
                if (subscribeButtonsView2 != null) {
                    subscribeButtonsView2.setSubscribeLoading(false);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Predicate<Boolean> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return bool2.booleanValue();
        }
    }

    public static final class d<T, R> implements Function<Boolean, MaybeSource<? extends SubscribeInfo>> {
        public final /* synthetic */ SubscriptionsPresenterImpl a;
        public final /* synthetic */ boolean b;

        public d(SubscriptionsPresenterImpl subscriptionsPresenterImpl, boolean z) {
            this.a = subscriptionsPresenterImpl;
            this.b = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends SubscribeInfo> apply(Boolean bool) {
            SubscriptionsPresenterImpl subscriptionsPresenterImpl = this.a;
            return SubscriptionsPresenterImpl.access$changeSubscribe(subscriptionsPresenterImpl, subscriptionsPresenterImpl.o, this.b).toMaybe();
        }
    }

    public static final class e<T> implements Consumer<Disposable> {
        public final /* synthetic */ SubscriptionsPresenterImpl a;

        public e(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
            this.a = subscriptionsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            SubscribeButtonsView subscribeButtonsView = this.a.b;
            if (subscribeButtonsView != null) {
                subscribeButtonsView.setSubscribeLoading(true);
            }
        }
    }

    public static final class f<T, R> implements Function<SubscribeInfo, MaybeSource<? extends SubscribeInfo>> {
        public final /* synthetic */ SubscriptionsPresenterImpl a;

        public f(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
            this.a = subscriptionsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends SubscribeInfo> apply(SubscribeInfo subscribeInfo) {
            SubscribeInfo subscribeInfo2 = subscribeInfo;
            return this.a.l.updateSeller(this.a.h, subscribeInfo2.isSubscribed(), subscribeInfo2.isNotificationsActivated()).andThen(Maybies.toMaybe(subscribeInfo2)).observeOn(this.a.r.mainThread());
        }
    }

    public static final class g<T> implements Consumer<SubscribeInfo> {
        public final /* synthetic */ SubscriptionsPresenterImpl a;

        public g(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
            this.a = subscriptionsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscribeInfo subscribeInfo) {
            SubscribeInfo subscribeInfo2 = subscribeInfo;
            SubscriptionsPresenter.DefaultImpls.updateSellersSubscription$default(this.a, subscribeInfo2, false, 2, null);
            SubscriptionsPresenterImpl subscriptionsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(subscribeInfo2, "subscribeInfo");
            SubscriptionsPresenterImpl.access$showSubscriptionMessageIfNeeded(subscriptionsPresenterImpl, subscribeInfo2);
            SubscribeButtonsView subscribeButtonsView = this.a.b;
            if (subscribeButtonsView != null) {
                subscribeButtonsView.closeSubscriptionSettings();
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ SubscriptionsPresenterImpl a;

        public h(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
            this.a = subscriptionsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Objects.requireNonNull(th2, "null cannot be cast to non-null type com.avito.android.util.TypedResultException");
            TypedError errorResult = ((TypedResultException) th2).getErrorResult();
            if (errorResult instanceof ErrorResult.ErrorDialog) {
                SubscriptionsPresenterImpl.access$handleErrorDialog(this.a, (ErrorResult.ErrorDialog) errorResult);
                return;
            }
            SubscriptionsContainerView subscriptionsContainerView = this.a.a;
            if (subscriptionsContainerView != null) {
                subscriptionsContainerView.showContent();
            }
            CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.a.u, this.a.p.recycle(th2), 0, null, 0, null, 0, null, null, 254, null);
        }
    }

    public static final class i implements Action {
        public final /* synthetic */ SubscriptionsPresenterImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public i(SubscriptionsPresenterImpl subscriptionsPresenterImpl, boolean z, boolean z2) {
            this.a = subscriptionsPresenterImpl;
            this.b = z;
            this.c = z2;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscriptionsPresenter.Router router;
            SubscriptionsContainerView subscriptionsContainerView = this.a.a;
            if (subscriptionsContainerView != null) {
                subscriptionsContainerView.showContent();
            }
            if (this.b) {
                if (this.a.g == null && (router = this.a.d) != null) {
                    router.openAuthScreen();
                    Unit unit = Unit.INSTANCE;
                }
                this.a.g = Boolean.valueOf(this.c);
            }
        }
    }

    public SubscriptionsPresenterImpl(@NotNull NotificationManagerProvider notificationManagerProvider, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull AccountStateProvider accountStateProvider, @NotNull SubscriptionsResourceProvider subscriptionsResourceProvider, @NotNull SubscribeInteractor subscribeInteractor, @NotNull ErrorHelper errorHelper, @Nullable Lazy<? extends SubscriptionStateListener> lazy, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @PublicProfileFragmentModule.SubscriptionsState @Nullable Kundle kundle, @NotNull SubscriptionSource subscriptionSource, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features) {
        String str;
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(subscriptionsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(subscribeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(subscriptionSource, "subscriptionSource");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.k = notificationManagerProvider;
        this.l = favoriteSellersRepository;
        this.m = accountStateProvider;
        this.n = subscriptionsResourceProvider;
        this.o = subscribeInteractor;
        this.p = errorHelper;
        this.q = lazy;
        this.r = schedulersFactory3;
        this.s = analytics;
        this.t = subscriptionSource;
        this.u = compositeSnackbarPresenter;
        SubscribeInfo subscribeInfo = null;
        this.g = kundle != null ? kundle.getBoolean("target_subscribe") : null;
        this.h = (kundle == null || (str = kundle.getString("user_key")) == null) ? "" : str;
        this.i = kundle != null ? kundle.getString("context_id") : null;
        this.j = kundle != null ? (SubscribeInfo) kundle.getParcelable("subscribe_info") : subscribeInfo;
    }

    public static final Single access$changeSubscribe(SubscriptionsPresenterImpl subscriptionsPresenterImpl, SubscribeInteractor subscribeInteractor, boolean z) {
        if (z) {
            return subscribeInteractor.subscribe(subscriptionsPresenterImpl.h);
        }
        return subscribeInteractor.unsubscribe(subscriptionsPresenterImpl.h);
    }

    public static final void access$handleErrorDialog(SubscriptionsPresenterImpl subscriptionsPresenterImpl, ErrorResult.ErrorDialog errorDialog) {
        SubscriptionsContainerView subscriptionsContainerView = subscriptionsPresenterImpl.a;
        if (subscriptionsContainerView != null) {
            subscriptionsContainerView.showContent();
        }
        SubscriptionsContainerView subscriptionsContainerView2 = subscriptionsPresenterImpl.a;
        if (subscriptionsContainerView2 != null) {
            subscriptionsContainerView2.showErrorDialog(errorDialog, new j(subscriptionsPresenterImpl, errorDialog));
        }
    }

    public static final void access$onNotificationsClicked(SubscriptionsPresenterImpl subscriptionsPresenterImpl, SubscribeInfo subscribeInfo) {
        SubscribeButtonsView subscribeButtonsView = subscriptionsPresenterImpl.b;
        if (subscribeButtonsView != null) {
            subscriptionsPresenterImpl.f.clear();
            if (!subscriptionsPresenterImpl.k.getAreNotificationsEnabled()) {
                CompositeDisposable compositeDisposable = subscriptionsPresenterImpl.e;
                Disposable subscribe = subscribeButtonsView.showEnableNotificationDialog().subscribe(new a2.a.a.d2.c.e(subscriptionsPresenterImpl));
                Intrinsics.checkNotNullExpressionValue(subscribe, "buttonsView.showEnableNo…NotificationsSettings() }");
                Disposables.plusAssign(compositeDisposable, subscribe);
                return;
            }
            CompositeDisposable compositeDisposable2 = subscriptionsPresenterImpl.f;
            SubscribeInteractor subscribeInteractor = subscriptionsPresenterImpl.o;
            boolean z = !Intrinsics.areEqual(subscribeInfo.isNotificationsActivated(), Boolean.TRUE);
            Single singleDefault = subscribeInteractor.changeNotifications(subscriptionsPresenterImpl.h, z).toSingleDefault(Boolean.valueOf(z));
            Intrinsics.checkNotNullExpressionValue(singleDefault, "changeNotifications(user…ngleDefault(needActivate)");
            Disposable subscribe2 = singleDefault.observeOn(subscriptionsPresenterImpl.r.mainThread()).doOnSubscribe(new a2.a.a.d2.c.f(subscribeButtonsView)).doOnDispose(new c2(0, subscribeButtonsView)).doOnTerminate(new c2(1, subscribeButtonsView)).flatMap(new a2.a.a.d2.c.g(subscriptionsPresenterImpl, subscribeInfo)).subscribe(new a2.a.a.d2.c.h(subscriptionsPresenterImpl), new a2.a.a.d2.c.i(subscriptionsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.changeNotific…le(error))\n            })");
            Disposables.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    public static final void access$onSettingsClicked(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
        SubscribeButtonsView subscribeButtonsView = subscriptionsPresenterImpl.b;
        if (subscribeButtonsView != null) {
            subscribeButtonsView.openSubscriptionSettings();
        }
    }

    public static final void access$onSubscribeClicked(SubscriptionsPresenterImpl subscriptionsPresenterImpl, boolean z) {
        if (z) {
            subscriptionsPresenterImpl.s.track(new SubscribeSellerButtonEvent(subscriptionsPresenterImpl.h, subscriptionsPresenterImpl.t));
        } else {
            subscriptionsPresenterImpl.s.track(new UnsubscribeSellerButtonEvent(subscriptionsPresenterImpl.h, subscriptionsPresenterImpl.t));
        }
        subscriptionsPresenterImpl.a(z, true);
    }

    public static final void access$showSubscriptionMessageIfNeeded(SubscriptionsPresenterImpl subscriptionsPresenterImpl, SubscribeInfo subscribeInfo) {
        Objects.requireNonNull(subscriptionsPresenterImpl);
        Boolean isSubscribed = subscribeInfo.isSubscribed();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isSubscribed, bool) && Intrinsics.areEqual(subscribeInfo.isNotificationsActivated(), bool) && subscriptionsPresenterImpl.k.getAreNotificationsEnabled()) {
            CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(subscriptionsPresenterImpl.u, subscriptionsPresenterImpl.n.notificationsEnabled(), 0, null, 0, null, 0, null, null, 254, null);
        }
    }

    public final void a(boolean z, boolean z2) {
        this.f.clear();
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = this.m.currentAuthorized().filter(c.a).flatMap(new d(this, z)).observeOn(this.r.mainThread()).doOnSubscribe(new e(this)).doOnDispose(new b(0, this)).doOnTerminate(new b(1, this)).flatMap(new f(this)).subscribe(new g(this), new h(this), new i(this, z2, z));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.cur…         }\n            })");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void attachButtonsView(@NotNull SubscribeButtonsView subscribeButtonsView) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(subscribeButtonsView, "view");
        this.b = subscribeButtonsView;
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = subscribeButtonsView.getSubscribeButtonClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.subscribeButtonClic…          }\n            }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.e;
        Disposable subscribe2 = subscribeButtonsView.notificationClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.notificationClicks(…ificationsClicked(it) } }");
        Disposables.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.e;
        Disposable subscribe3 = subscribeButtonsView.unsubscribeClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.unsubscribeClicks()…eedSubscribe = false) } }");
        Disposables.plusAssign(compositeDisposable3, subscribe3);
        if (this.d != null && (bool = this.g) != null) {
            a(bool.booleanValue(), false);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void attachContainerView(@NotNull SubscriptionsContainerView subscriptionsContainerView) {
        Intrinsics.checkNotNullParameter(subscriptionsContainerView, "view");
        this.a = subscriptionsContainerView;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void attachCounterView(@NotNull SubscriptionsCounterView subscriptionsCounterView) {
        Intrinsics.checkNotNullParameter(subscriptionsCounterView, "view");
        this.c = subscriptionsCounterView;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void attachRouter(@Nullable SubscriptionsPresenter.Router router) {
        this.d = router;
        if (router != null) {
            router.addOnBackPressedListener(this);
        }
        refreshNotificationMenuItem();
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void detachRouter() {
        this.f.clear();
        SubscriptionsPresenter.Router router = this.d;
        if (router != null) {
            router.removeOnBackPressedListener(this);
        }
        this.d = null;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void detachView() {
        this.e.clear();
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void onAuthCanceled() {
        this.g = null;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void onAuthCompleted() {
        Boolean bool;
        if (this.d != null && (bool = this.g) != null) {
            a(bool.booleanValue(), false);
        }
    }

    @Override // com.avito.android.public_profile.ui.OnBackPressedListener
    public boolean onBackPressed() {
        SubscribeButtonsView subscribeButtonsView = this.b;
        if (subscribeButtonsView != null) {
            return subscribeButtonsView.closeSubscriptionSettings();
        }
        return false;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("target_subscribe", this.g).putString("user_key", this.h).putString("context_id", this.i).putParcelable("subscribe_info", this.j);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void onStartProfileLoading() {
        SubscribeButtonsView subscribeButtonsView = this.b;
        if (subscribeButtonsView != null) {
            subscribeButtonsView.setSubscribeLoading(true);
        }
        SubscribeButtonsView subscribeButtonsView2 = this.b;
        if (subscribeButtonsView2 != null) {
            subscribeButtonsView2.setNotificationLoading(true);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void onSubscribeLinkFollow(boolean z) {
        a(z, false);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void refreshNotificationMenuItem() {
        Boolean isNotificationsActivated;
        if (!this.k.getAreNotificationsEnabled()) {
            SubscribeButtonsView subscribeButtonsView = this.b;
            if (subscribeButtonsView != null) {
                subscribeButtonsView.setNotificationActivated(false);
                return;
            }
            return;
        }
        SubscribeInfo subscribeInfo = this.j;
        if (subscribeInfo != null && (isNotificationsActivated = subscribeInfo.isNotificationsActivated()) != null) {
            boolean booleanValue = isNotificationsActivated.booleanValue();
            SubscribeButtonsView subscribeButtonsView2 = this.b;
            if (subscribeButtonsView2 != null) {
                subscribeButtonsView2.setNotificationActivated(booleanValue);
            }
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void setUserData(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.h = str;
        this.i = str2;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public boolean subscriptionStatusChanged(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        FavoriteSeller favoriteSeller = this.l.getSellersAsMap().get(str);
        if (favoriteSeller == null) {
            return false;
        }
        Boolean valueOf = Boolean.valueOf(favoriteSeller.isSubscribed());
        SubscribeInfo subscribeInfo = this.j;
        return !Intrinsics.areEqual(valueOf, subscribeInfo != null ? subscribeInfo.isSubscribed() : null);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter
    public void updateSellersSubscription(@Nullable SubscribeInfo subscribeInfo, boolean z) {
        SubscriptionStateListener subscriptionStateListener;
        Boolean isNotificationsActivated;
        Boolean isNotificationsActivated2;
        if (z) {
            this.j = subscribeInfo;
        } else {
            if (this.j == null) {
                this.j = subscribeInfo;
            }
            FavoriteSeller favoriteSeller = this.l.getSellersAsMap().get(this.h);
            if (!(favoriteSeller == null || (isNotificationsActivated2 = favoriteSeller.isNotificationsActivated()) == null)) {
                boolean booleanValue = isNotificationsActivated2.booleanValue();
                SubscribeInfo subscribeInfo2 = this.j;
                if (subscribeInfo2 != null) {
                    subscribeInfo2.setNotificationsActivated(Boolean.valueOf(booleanValue));
                }
            }
        }
        SubscribeInfo subscribeInfo3 = this.j;
        ProfileCounter profileCounter = null;
        Boolean isSubscribed = subscribeInfo3 != null ? subscribeInfo3.isSubscribed() : null;
        SubscribeButtonsView subscribeButtonsView = this.b;
        if (subscribeButtonsView != null) {
            if (isSubscribed != null) {
                if (isSubscribed.booleanValue()) {
                    subscribeButtonsView.showSubscribeButton(this.n.notificationSettings());
                } else {
                    subscribeButtonsView.showSubscribeButton(this.n.subscribe());
                }
                subscribeButtonsView.setSubscribeLoading(false);
            } else {
                subscribeButtonsView.hideSubscribeButton();
            }
        }
        SubscriptionsCounterView subscriptionsCounterView = this.c;
        if (subscriptionsCounterView != null) {
            SubscribeInfo subscribeInfo4 = this.j;
            subscriptionsCounterView.bindSubscribersCounter(subscribeInfo4 != null ? subscribeInfo4.getSubscribers() : null);
            SubscribeInfo subscribeInfo5 = this.j;
            if (subscribeInfo5 != null) {
                profileCounter = subscribeInfo5.getSubscriptions();
            }
            subscriptionsCounterView.bindSubscriptionsCounter(profileCounter);
        }
        SubscribeInfo subscribeInfo6 = this.j;
        boolean booleanValue2 = (subscribeInfo6 == null || (isNotificationsActivated = subscribeInfo6.isNotificationsActivated()) == null) ? false : isNotificationsActivated.booleanValue();
        SubscribeButtonsView subscribeButtonsView2 = this.b;
        if (subscribeButtonsView2 != null) {
            subscribeButtonsView2.setNotificationActivated(booleanValue2 && this.k.getAreNotificationsEnabled());
            subscribeButtonsView2.setNotificationLoading(false);
        }
        Lazy<? extends SubscriptionStateListener> lazy = this.q;
        if (lazy != null && (subscriptionStateListener = (SubscriptionStateListener) lazy.get()) != null) {
            subscriptionStateListener.onSubscribeInfoChanged(this.j);
        }
    }
}
