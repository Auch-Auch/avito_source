package com.avito.android.public_profile.ui;

import a2.g.r.g;
import android.view.View;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PublicRatingDetailsLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.analytics.event.ActiveTabSwitchEvent;
import com.avito.android.public_profile.analytics.event.ClosedTabSwitchEvent;
import com.avito.android.public_profile.analytics.event.ProfileShareEvent;
import com.avito.android.public_profile.analytics.event.PublicRatingDetailsOpenEvent;
import com.avito.android.public_profile.di.PublicProfileFragmentModule;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.public_profile.ui.PublicProfileInteractorImpl;
import com.avito.android.public_profile.ui.PublicProfilePresenter;
import com.avito.android.public_profile.ui.PublicProfileView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ProfileRatingAction;
import com.avito.android.remote.model.Sharing;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B²\u0001\b\u0007\u0012\b\b\u0001\u0010,\u001a\u00020\u001c\u0012\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\u001c\u0012\b\u00104\u001a\u0004\u0018\u000101\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010%\u001a\u00020\"\u0012\f\u0010o\u001a\b\u0012\u0004\u0012\u00020l0k\u0012\u0006\u0010}\u001a\u00020z\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010w\u001a\u00020t\u0012\n\b\u0001\u0010~\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010)\u001a\u00020&\u0012\b\u0010W\u001a\u0004\u0018\u00010T\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010O\u001a\u00020L\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000205\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040H¢\u0006\u0005\b\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\bR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010+R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR&\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010DR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010`R\u0016\u0010c\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020l0k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006\u0001"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfilePresenterImpl;", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "result", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;)V", AuthSource.BOOKING_ORDER, "()V", "Lcom/avito/android/public_profile/ui/PublicProfileView;", "view", "attachView", "(Lcom/avito/android/public_profile/ui/PublicProfileView;)V", "detachView", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackClicked", "onRetryClicked", "", "activeTab", "onActiveTabChanged", "(I)V", "", "message", "showMessage", "(Ljava/lang/String;)V", "onAuthCompleted", "reloadProfileAdverts", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "t", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "tracker", "k", "Ljava/lang/String;", "userKey", "Lcom/avito/android/public_profile/ui/PublicProfileInteractor;", "n", "Lcom/avito/android/public_profile/ui/PublicProfileInteractor;", "interactor", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "Lcom/jakewharton/rxrelay3/PublishRelay;", "y", "Lcom/jakewharton/rxrelay3/PublishRelay;", "profileAdvertsResultReceivedEvent", "", "h", "Ljava/lang/Boolean;", "startNotificationsState", "l", "contextId", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "w", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "", "Ljava/util/Map;", "analyticParams", "d", "Lcom/avito/android/public_profile/ui/PublicProfileView;", "Lio/reactivex/rxjava3/functions/Consumer;", "z", "Lio/reactivex/rxjava3/functions/Consumer;", "profileAdvertsReload", "Lcom/avito/android/Features;", "x", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "r", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "u", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", VKApiConst.VERSION, "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "I", "j", "Z", "wasErrorHandled", "i", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "profileAdvertsResult", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", g.a, "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "p", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Lcom/avito/android/remote/model/Sharing;", "c", "Lcom/avito/android/remote/model/Sharing;", "sharing", "Lcom/avito/android/public_profile/ui/PublicProfileResourceProvider;", "s", "Lcom/avito/android/public_profile/ui/PublicProfileResourceProvider;", "resourceProvider", "e", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;", "Lcom/avito/android/error_helper/ErrorHelper;", VKApiConst.Q, "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Lcom/avito/android/public_profile/ui/PublicProfileInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/public_profile/ui/PublicProfileResourceProvider;Lcom/avito/android/util/Kundle;Lcom/avito/android/public_profile/tracker/PublicProfileTracker;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/Features;Lcom/jakewharton/rxrelay3/PublishRelay;Lio/reactivex/rxjava3/functions/Consumer;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfilePresenterImpl implements PublicProfilePresenter {
    public int a;
    public Map<String, String> b;
    public Sharing c;
    public PublicProfileView d;
    public PublicProfilePresenter.Router e;
    public final CompositeDisposable f;
    public final TreeStateIdGenerator g;
    public Boolean h;
    public ProfileAdvertsResult i;
    public boolean j;
    public final String k;
    public final String l;
    public DefaultPublicUserProfile m;
    public final PublicProfileInteractor n;
    public final SchedulersFactory3 o;
    public final TabsDataProvider<BaseTabItem> p;
    public final ErrorHelper q;
    public final Analytics r;
    public final PublicProfileResourceProvider s;
    public final PublicProfileTracker t;
    public final TreeClickStreamParent u;
    public final SubscriptionsPresenter v;
    public final CompositeSnackbarPresenter w;
    public final Features x;
    public final PublishRelay<ProfileAdvertsResult> y;
    public final Consumer<Unit> z;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ PublicProfilePresenterImpl a;

        public a(PublicProfilePresenterImpl publicProfilePresenterImpl) {
            this.a = publicProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            PublicProfilePresenterImpl.access$onShareClicked(this.a);
        }
    }

    public static final class b<T> implements Predicate<ProfileAdvertsResult> {
        public final /* synthetic */ PublicProfilePresenterImpl a;

        public b(PublicProfilePresenterImpl publicProfilePresenterImpl) {
            this.a = publicProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(ProfileAdvertsResult profileAdvertsResult) {
            return !this.a.j;
        }
    }

    public static final class c<T> implements Consumer<ProfileAdvertsResult> {
        public final /* synthetic */ PublicProfilePresenterImpl a;

        public c(PublicProfilePresenterImpl publicProfilePresenterImpl) {
            this.a = publicProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ProfileAdvertsResult profileAdvertsResult) {
            ProfileAdvertsResult profileAdvertsResult2 = profileAdvertsResult;
            PublicProfilePresenterImpl publicProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(profileAdvertsResult2, "result");
            publicProfilePresenterImpl.a(profileAdvertsResult2);
        }
    }

    public static final class d<T> implements Consumer<View> {
        public final /* synthetic */ Action a;
        public final /* synthetic */ PublicProfilePresenterImpl b;
        public final /* synthetic */ PublicProfileView c;

        public d(Action action, PublicProfilePresenterImpl publicProfilePresenterImpl, PublicProfileView publicProfileView, UserDialog userDialog) {
            this.a = action;
            this.b = publicProfilePresenterImpl;
            this.c = publicProfileView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(View view) {
            PublicProfilePresenter.Router router = this.b.e;
            if (router != null) {
                PublicProfilePresenter.Router.DefaultImpls.followDeepLink$default(router, this.a.getDeepLink(), null, 2, null);
            }
        }
    }

    public static final class e<T> implements Consumer<DefaultPublicUserProfile> {
        public final /* synthetic */ PublicProfilePresenterImpl a;

        public e(PublicProfilePresenterImpl publicProfilePresenterImpl) {
            this.a = publicProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DefaultPublicUserProfile defaultPublicUserProfile) {
            DefaultPublicUserProfile defaultPublicUserProfile2 = defaultPublicUserProfile;
            this.a.t.trackProfileLoaded();
            PublicProfilePresenterImpl publicProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(defaultPublicUserProfile2, "it");
            PublicProfilePresenterImpl.access$onPublicProfileLoaded(publicProfilePresenterImpl, defaultPublicUserProfile2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ PublicProfilePresenterImpl a;

        public f(PublicProfilePresenterImpl publicProfilePresenterImpl) {
            this.a = publicProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.t.trackProfileLoadError();
            PublicProfilePresenterImpl publicProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            PublicProfilePresenterImpl.access$onError(publicProfilePresenterImpl, th2);
        }
    }

    @Inject
    public PublicProfilePresenterImpl(@PublicProfileFragmentModule.UserKey @NotNull String str, @PublicProfileFragmentModule.ContextId @Nullable String str2, @Nullable DefaultPublicUserProfile defaultPublicUserProfile, @NotNull PublicProfileInteractor publicProfileInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TabsDataProvider<BaseTabItem> tabsDataProvider, @NotNull ErrorHelper errorHelper, @NotNull Analytics analytics, @NotNull PublicProfileResourceProvider publicProfileResourceProvider, @PublicProfileFragmentModule.PresenterState @Nullable Kundle kundle, @NotNull PublicProfileTracker publicProfileTracker, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull SubscriptionsPresenter subscriptionsPresenter, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Features features, @NotNull PublishRelay<ProfileAdvertsResult> publishRelay, @NotNull Consumer<Unit> consumer) {
        DefaultPublicUserProfile defaultPublicUserProfile2;
        Integer num;
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(publicProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publicProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(publicProfileTracker, "tracker");
        Intrinsics.checkNotNullParameter(subscriptionsPresenter, "subscriptionsPresenter");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(publishRelay, "profileAdvertsResultReceivedEvent");
        Intrinsics.checkNotNullParameter(consumer, "profileAdvertsReload");
        this.k = str;
        this.l = str2;
        this.m = defaultPublicUserProfile;
        this.n = publicProfileInteractor;
        this.o = schedulersFactory3;
        this.p = tabsDataProvider;
        this.q = errorHelper;
        this.r = analytics;
        this.s = publicProfileResourceProvider;
        this.t = publicProfileTracker;
        this.u = treeClickStreamParent;
        this.v = subscriptionsPresenter;
        this.w = compositeSnackbarPresenter;
        this.x = features;
        this.y = publishRelay;
        this.z = consumer;
        this.a = (kundle == null || (num = kundle.getInt("key_active_tab")) == null) ? 0 : num.intValue();
        this.f = new CompositeDisposable();
        this.g = new TreeStateIdGenerator();
        ProfileAdvertsResult profileAdvertsResult = null;
        this.h = kundle != null ? kundle.getBoolean("start_notifications_state") : null;
        this.i = kundle != null ? (ProfileAdvertsResult) kundle.getParcelable("key_profile_advert_results") : profileAdvertsResult;
        if (kundle != null && (defaultPublicUserProfile2 = (DefaultPublicUserProfile) kundle.getParcelable("key_profile")) != null) {
            this.m = defaultPublicUserProfile2;
        }
    }

    public static final void access$onError(PublicProfilePresenterImpl publicProfilePresenterImpl, Throwable th) {
        publicProfilePresenterImpl.t.startProfilePreparing();
        publicProfilePresenterImpl.t.trackProfileErrorPreparing();
        publicProfilePresenterImpl.t.startProfileDraw();
        TypedError handle = publicProfilePresenterImpl.q.handle(th);
        if (handle instanceof PublicProfileInteractorImpl.UserBannedError) {
            PublicProfileView publicProfileView = publicProfilePresenterImpl.d;
            if (publicProfileView != null) {
                publicProfileView.showUserBanned(publicProfilePresenterImpl.q.recycle(th));
            }
        } else if (handle instanceof PublicProfileInteractorImpl.UserRemovedError) {
            PublicProfileView publicProfileView2 = publicProfilePresenterImpl.d;
            if (publicProfileView2 != null) {
                publicProfileView2.showUserRemoved(publicProfilePresenterImpl.q.recycle(th));
            }
        } else {
            PublicProfileView publicProfileView3 = publicProfilePresenterImpl.d;
            if (publicProfileView3 != null) {
                publicProfileView3.showError(publicProfilePresenterImpl.q.recycle(th));
            }
        }
        publicProfilePresenterImpl.t.trackProfileErrorDraw();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0200 A[LOOP:2: B:74:0x01fa->B:76:0x0200, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0257  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$onPublicProfileLoaded(com.avito.android.public_profile.ui.PublicProfilePresenterImpl r23, com.avito.android.public_profile.remote.model.DefaultPublicUserProfile r24) {
        /*
        // Method dump skipped, instructions count: 625
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.public_profile.ui.PublicProfilePresenterImpl.access$onPublicProfileLoaded(com.avito.android.public_profile.ui.PublicProfilePresenterImpl, com.avito.android.public_profile.remote.model.DefaultPublicUserProfile):void");
    }

    public static final void access$onRatingClicked(PublicProfilePresenterImpl publicProfilePresenterImpl, ProfileRatingAction profileRatingAction) {
        Map<String, String> map;
        String str;
        Objects.requireNonNull(publicProfilePresenterImpl);
        DeepLink deepLink = profileRatingAction.getDeepLink();
        if (!(!(deepLink instanceof PublicRatingDetailsLink) || (map = publicProfilePresenterImpl.b) == null || (str = map.get("rating")) == null)) {
            publicProfilePresenterImpl.r.track(new PublicRatingDetailsOpenEvent(str));
        }
        PublicProfilePresenter.Router router = publicProfilePresenterImpl.e;
        if (router != null) {
            PublicProfilePresenter.Router.DefaultImpls.followDeepLink$default(router, deepLink, null, 2, null);
        }
    }

    public static final void access$onShareClicked(PublicProfilePresenterImpl publicProfilePresenterImpl) {
        String str;
        Sharing sharing = publicProfilePresenterImpl.c;
        if (sharing != null) {
            PublicProfilePresenter.Router router = publicProfilePresenterImpl.e;
            if (router != null) {
                router.openShareDialog(sharing.getTitle(), sharing.getText());
            }
            Map<String, String> map = publicProfilePresenterImpl.b;
            if (map != null && (str = map.get("sharing")) != null) {
                publicProfilePresenterImpl.r.track(new ProfileShareEvent(str));
            }
        }
    }

    public final void a(ProfileAdvertsResult profileAdvertsResult) {
        Action action;
        this.i = profileAdvertsResult;
        PublicProfileView publicProfileView = this.d;
        if (publicProfileView != null) {
            Objects.requireNonNull(publicProfileView, "null cannot be cast to non-null type com.avito.android.public_profile.ui.PublicProfileView");
            UserDialog dialog = profileAdvertsResult.getDialog();
            if (dialog != null) {
                this.j = true;
                publicProfileView.hideAdverts();
                List<Action> actions = dialog.getActions();
                if (actions == null || (action = actions.get(0)) == null) {
                    PublicProfileView.DefaultImpls.showBlockedAdvertsAlertBanner$default(publicProfileView, dialog, null, null, 6, null);
                } else {
                    PublishRelay<View> create = PublishRelay.create();
                    Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
                    CompositeDisposable compositeDisposable = this.f;
                    Disposable subscribe = create.subscribe(new d(action, this, publicProfileView, dialog));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "relay.subscribe { router…epLink(action.deepLink) }");
                    Disposables.plusAssign(compositeDisposable, subscribe);
                    publicProfileView.showBlockedAdvertsAlertBanner(dialog, action.getTitle(), create);
                }
            } else {
                publicProfileView.showAdverts();
            }
            publicProfileView.showContent();
        }
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void attachRouter(@Nullable PublicProfilePresenter.Router router) {
        this.e = router;
        b();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void attachView(@NotNull PublicProfileView publicProfileView) {
        Intrinsics.checkNotNullParameter(publicProfileView, "view");
        this.d = publicProfileView;
        ProfileAdvertsResult profileAdvertsResult = this.i;
        if (profileAdvertsResult != null) {
            a(profileAdvertsResult);
        }
        publicProfileView.hideShareButton();
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = publicProfileView.shareButtonClicks().toFlowable(BackpressureStrategy.DROP).observeOn(this.o.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.shareButtonClicks()…reClicked()\n            }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.f;
        Disposable subscribe2 = this.y.filter(new b(this)).subscribeOn(this.o.mainThread()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "profileAdvertsResultRece…ult(result)\n            }");
        Disposables.plusAssign(compositeDisposable2, subscribe2);
    }

    public final void b() {
        CompositeDisposable compositeDisposable = this.f;
        DefaultPublicUserProfile defaultPublicUserProfile = this.m;
        Observable<DefaultPublicUserProfile> observable = null;
        if (defaultPublicUserProfile != null) {
            if (this.v.subscriptionStatusChanged(this.k)) {
                defaultPublicUserProfile = null;
            }
            if (defaultPublicUserProfile != null) {
                Observable just = Observable.just(defaultPublicUserProfile);
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                if (just != null) {
                    observable = just.doOnNext(new a2.a.a.d2.c.a(this));
                }
            }
        }
        if (observable == null) {
            this.t.restartSession();
            observable = this.n.loadPublicUserProfile(this.k, this.l).subscribeOn(this.o.io()).observeOn(this.o.mainThread()).doOnSubscribe(new a2.a.a.d2.c.b(this)).doOnNext(new a2.a.a.d2.c.c(this));
            Intrinsics.checkNotNullExpressionValue(observable, "interactor.loadPublicUse…          )\n            }");
        }
        Disposable subscribe = observable.subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "(getLocalProfile() ?: lo…          }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void detachView() {
        this.f.clear();
        this.d = null;
        this.t.stop();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void onActiveTabChanged(int i2) {
        int count = this.p.getCount();
        int i3 = this.a;
        if (count > i3) {
            String shortcut = this.p.getItem(i3).getShortcut();
            int hashCode = shortcut.hashCode();
            if (hashCode != -1422950650) {
                if (hashCode == -1357520532 && shortcut.equals("closed")) {
                    this.r.track(new ClosedTabSwitchEvent(this.k));
                }
            } else if (shortcut.equals("active")) {
                this.r.track(new ActiveTabSwitchEvent(this.k));
            }
        }
        this.a = i2;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void onAuthCompleted() {
        if (this.p.getCount() > 0) {
            reloadProfileAdverts();
        }
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void onBackClicked() {
        PublicProfilePresenter.Router router = this.e;
        if (router != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void onRetryClicked() {
        PublicProfileView publicProfileView = this.d;
        if (publicProfileView != null) {
            publicProfileView.hideAdverts();
        }
        PublicProfileView publicProfileView2 = this.d;
        if (publicProfileView2 != null) {
            publicProfileView2.hideBlockedAdvertsAlertBanner();
        }
        PublicProfileView publicProfileView3 = this.d;
        if (publicProfileView3 != null) {
            publicProfileView3.showProgress();
        }
        b();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("start_notifications_state", this.h).putInt("key_active_tab", Integer.valueOf(this.a)).putParcelable("key_profile", this.m).putParcelable("key_profile_advert_results", this.i);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void reloadProfileAdverts() {
        this.j = false;
        PublicProfileView publicProfileView = this.d;
        if (publicProfileView != null) {
            publicProfileView.hideAdverts();
        }
        PublicProfileView publicProfileView2 = this.d;
        if (publicProfileView2 != null) {
            publicProfileView2.hideBlockedAdvertsAlertBanner();
        }
        PublicProfileView publicProfileView3 = this.d;
        if (publicProfileView3 != null) {
            publicProfileView3.showProgress();
        }
        this.z.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.w, str, 0, null, 0, null, 0, null, null, 254, null);
    }
}
