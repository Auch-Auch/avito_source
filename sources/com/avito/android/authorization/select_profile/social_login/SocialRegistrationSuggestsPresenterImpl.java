package com.avito.android.authorization.select_profile.social_login;

import a2.a.a.b.i.b.c;
import a2.a.a.b.i.b.d;
import a2.g.r.g;
import com.avito.android.account.AccountInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.SocialRegistrationUserChoiceEvent;
import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter;
import com.avito.android.authorization.select_profile.social_login.di.ScreenTitle;
import com.avito.android.authorization.select_profile.social_login.di.SocialType;
import com.avito.android.authorization.select_profile.social_login.di.SuggestKey;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bs\b\u0007\u0012\b\b\u0001\u00107\u001a\u000204\u0012\b\b\u0001\u00109\u001a\u000204\u0012\b\b\u0001\u0010?\u001a\u000204\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010=\u001a\u00020:¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u00106¨\u0006B"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenterImpl;", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter;", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsView;", "view", "", "attachView", "(Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsView;)V", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;)V", "detachView", "()V", "detachRouter", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountInteractor;", g.a, "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "Lcom/avito/android/error_helper/ErrorHelper;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "i", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsView;", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "h", "Ljava/util/List;", "profiles", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "itemClicks", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsResourceProvider;", "l", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "", "d", "Ljava/lang/String;", "title", "e", "suggestKey", "Lcom/avito/android/analytics/Analytics;", "n", "Lcom/avito/android/analytics/Analytics;", "analytics", "f", "socialType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/account/AccountInteractor;Ljava/util/List;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsResourceProvider;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/Analytics;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SocialRegistrationSuggestsPresenterImpl implements SocialRegistrationSuggestsPresenter {
    public SocialRegistrationSuggestsView a;
    public SocialRegistrationSuggestsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final String d;
    public final String e;
    public final String f;
    public final AccountInteractor g;
    public final List<RegisteredProfile> h;
    public final AdapterPresenter i;
    public final PublishRelay<SelectProfileField> j;
    public final SchedulersFactory3 k;
    public final SocialRegistrationSuggestsResourceProvider l;
    public final ErrorHelper m;
    public final Analytics n;

    public static final class a<T> implements Consumer<SelectProfileField> {
        public final /* synthetic */ SocialRegistrationSuggestsPresenterImpl a;

        public a(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl) {
            this.a = socialRegistrationSuggestsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SelectProfileField selectProfileField) {
            SelectProfileField selectProfileField2 = selectProfileField;
            SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(selectProfileField2, "it");
            SocialRegistrationSuggestsPresenterImpl.access$handleItemClick(socialRegistrationSuggestsPresenterImpl, selectProfileField2);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ SocialRegistrationSuggestsPresenterImpl a;

        public b(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl) {
            this.a = socialRegistrationSuggestsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            SocialRegistrationSuggestsPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    @Inject
    public SocialRegistrationSuggestsPresenterImpl(@ScreenTitle @NotNull String str, @SuggestKey @NotNull String str2, @SocialType @NotNull String str3, @NotNull AccountInteractor accountInteractor, @NotNull List<RegisteredProfile> list, @NotNull AdapterPresenter adapterPresenter, @NotNull PublishRelay<SelectProfileField> publishRelay, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SocialRegistrationSuggestsResourceProvider socialRegistrationSuggestsResourceProvider, @NotNull ErrorHelper errorHelper, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "suggestKey");
        Intrinsics.checkNotNullParameter(str3, "socialType");
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        Intrinsics.checkNotNullParameter(list, "profiles");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClicks");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(socialRegistrationSuggestsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = accountInteractor;
        this.h = list;
        this.i = adapterPresenter;
        this.j = publishRelay;
        this.k = schedulersFactory3;
        this.l = socialRegistrationSuggestsResourceProvider;
        this.m = errorHelper;
        this.n = analytics;
    }

    public static final void access$handleItemClick(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl, SelectProfileField selectProfileField) {
        SocialRegistrationSuggestsPresenter.Router router;
        Unit unit;
        Objects.requireNonNull(socialRegistrationSuggestsPresenterImpl);
        if (selectProfileField instanceof SelectProfileField.Profile) {
            SelectProfileField.Profile profile = (SelectProfileField.Profile) selectProfileField;
            socialRegistrationSuggestsPresenterImpl.n.track(new SocialRegistrationUserChoiceEvent(false));
            List<ProfileSocial> social = profile.getProfile().getSocial();
            if (social != null) {
                SocialRegistrationSuggestsPresenter.Router router2 = socialRegistrationSuggestsPresenterImpl.b;
                if (router2 != null) {
                    router2.openSelectSocial(social, socialRegistrationSuggestsPresenterImpl.e);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            String login = profile.getProfile().getLogin();
            if (login != null && (router = socialRegistrationSuggestsPresenterImpl.b) != null) {
                router.openLogin(login, socialRegistrationSuggestsPresenterImpl.e);
            }
        } else if (selectProfileField instanceof SelectProfileField.CreateProfile) {
            socialRegistrationSuggestsPresenterImpl.n.track(new SocialRegistrationUserChoiceEvent(true));
            CompositeDisposable compositeDisposable = socialRegistrationSuggestsPresenterImpl.c;
            Disposable subscribe = socialRegistrationSuggestsPresenterImpl.g.createProfile(socialRegistrationSuggestsPresenterImpl.e, socialRegistrationSuggestsPresenterImpl.f).observeOn(socialRegistrationSuggestsPresenterImpl.k.mainThread()).doOnSubscribe(new a2.a.a.b.i.b.a(socialRegistrationSuggestsPresenterImpl)).doAfterTerminate(new a2.a.a.b.i.b.b(socialRegistrationSuggestsPresenterImpl)).subscribe(new c(socialRegistrationSuggestsPresenterImpl), new d(socialRegistrationSuggestsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "accountInteractor.create…rHelper.recycle(error)) }");
            Disposables.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final void access$handleState(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl, LoadingState loadingState) {
        SocialRegistrationSuggestsView socialRegistrationSuggestsView;
        Objects.requireNonNull(socialRegistrationSuggestsPresenterImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            SocialRegistrationSuggestsPresenter.Router router = socialRegistrationSuggestsPresenterImpl.b;
            if (router != null) {
                router.onProfileCreated();
            }
        } else if ((loadingState instanceof LoadingState.Error) && (socialRegistrationSuggestsView = socialRegistrationSuggestsPresenterImpl.a) != null) {
            socialRegistrationSuggestsView.showError(socialRegistrationSuggestsPresenterImpl.m.recycle(((LoadingState.Error) loadingState).getError()));
        }
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter
    public void attachRouter(@NotNull SocialRegistrationSuggestsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter
    public void attachView(@NotNull SocialRegistrationSuggestsView socialRegistrationSuggestsView) {
        Intrinsics.checkNotNullParameter(socialRegistrationSuggestsView, "view");
        this.a = socialRegistrationSuggestsView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.j.subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks.subscribe { handleItemClick(it) }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = socialRegistrationSuggestsView.getNavigationClicks().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks.su…{ router?.leaveScreen() }");
        Disposables.plusAssign(compositeDisposable2, subscribe2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SelectProfileField.Text(0, this.l.getSelectProfileMessage()));
        int i2 = 0;
        for (T t : this.h) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new SelectProfileField.Profile((long) i3, t));
            i2 = i3;
        }
        arrayList.add(new SelectProfileField.CreateProfile((long) (this.h.size() + 2), this.l.getCreateProfileMessage()));
        AdapterPresentersKt.updateItems(this.i, arrayList);
        SocialRegistrationSuggestsView socialRegistrationSuggestsView2 = this.a;
        if (socialRegistrationSuggestsView2 != null) {
            socialRegistrationSuggestsView2.onDataChanged();
        }
        SocialRegistrationSuggestsView socialRegistrationSuggestsView3 = this.a;
        if (socialRegistrationSuggestsView3 != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(((SelectProfileField) next) instanceof SelectProfileField.Text)) {
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(arrayList.indexOf((SelectProfileField) it2.next())));
            }
            socialRegistrationSuggestsView3.setDividers(arrayList3);
        }
        socialRegistrationSuggestsView.showScreenTitle(this.d);
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter
    public void detachView() {
        this.c.clear();
        this.a = null;
    }
}
