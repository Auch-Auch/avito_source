package com.avito.android.social_management;

import a2.a.a.y2.h;
import a2.a.a.y2.i;
import a2.a.a.y2.j;
import a2.a.a.y2.k;
import a2.a.a.y2.l;
import a2.a.a.y2.m;
import a2.a.a.y2.n;
import a2.a.a.y2.o;
import a2.a.a.y2.p;
import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.SocialButtonClickedEvent;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social_management.SocialManagementPresenter;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.avito.android.social_management.events.EsiaLinkClick;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010V\u001a\u00020S\u0012\u0011\u0010\u001e\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u0019\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020F0'\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010&\u001a\u00020#\u0012\b\u0010`\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\ba\u0010bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004R!\u0010\u001e\u001a\r\u0012\t\u0012\u00070\u001a¢\u0006\u0002\b\u001b0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020F0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010*R\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020I0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u001dR\u0016\u0010M\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010@R\u0018\u0010P\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001e\u0010R\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010\u001dR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010WR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006c"}, d2 = {"Lcom/avito/android/social_management/SocialManagementPresenterImpl;", "Lcom/avito/android/social_management/SocialManagementPresenter;", "", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/social_management/SocialManagementView;", "view", "attachView", "(Lcom/avito/android/social_management/SocialManagementView;)V", "Lcom/avito/android/social_management/SocialManagementPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/social_management/SocialManagementPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "type", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "onSocialLoginResult", "(Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginError", "onBackPressed", "", "Lcom/avito/android/social/SignInManager;", "Lkotlin/jvm/JvmSuppressWildcards;", "k", "Ljava/util/List;", "socialManagers", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "l", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/social/SocialTypeToStringMapper;", "t", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/social_management/adapter/SocialItem;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemClicks", "Lcom/avito/android/dialog/DialogPresenter;", "p", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/analytics/Analytics;", "r", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.BOOKING_ORDER, "Lcom/avito/android/social_management/SocialManagementPresenter$Router;", "Lcom/avito/android/error_helper/ErrorHelper;", "o", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "", g.a, "Z", "changed", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "", "i", "I", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", "n", "notificationActions", "Lcom/avito/android/remote/model/social/SocialNetwork;", "h", "socialItems", "d", "viewDisposables", "f", "Ljava/lang/String;", "errorMessage", "e", "items", "Lcom/avito/android/social_management/SocialManagementInteractor;", "j", "Lcom/avito/android/social_management/SocialManagementInteractor;", "interactor", "Lcom/avito/android/social_management/SocialManagementView;", "Lcom/avito/android/social_management/SocialManagementResourceProvider;", VKApiConst.Q, "Lcom/avito/android/social_management/SocialManagementResourceProvider;", "resourceProvider", "Lcom/avito/android/util/SchedulersFactory;", "s", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "state", "<init>", "(Lcom/avito/android/social_management/SocialManagementInteractor;Ljava/util/List;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/social_management/SocialManagementResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/social/SocialTypeToStringMapper;Lcom/avito/android/util/Kundle;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialManagementPresenterImpl implements SocialManagementPresenter {
    public SocialManagementView a;
    public SocialManagementPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends SocialItem> e;
    public String f;
    public boolean g;
    public final List<SocialNetwork> h;
    public int i;
    public final SocialManagementInteractor j;
    public final List<SignInManager> k;
    public final DataAwareAdapterPresenter l;
    public final PublishRelay<SocialItem> m;
    public final PublishRelay<SocialNotificationAction> n;
    public final ErrorHelper o;
    public final DialogPresenter p;
    public final SocialManagementResourceProvider q;
    public final Analytics r;
    public final SchedulersFactory s;
    public final SocialTypeToStringMapper t;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((SocialManagementPresenterImpl) this.b).onBackPressed();
            } else if (i == 1) {
                ((SocialManagementPresenterImpl) this.b).a();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<SocialItem> {
        public final /* synthetic */ SocialManagementPresenterImpl a;

        public b(SocialManagementPresenterImpl socialManagementPresenterImpl) {
            this.a = socialManagementPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SocialItem socialItem) {
            SocialItem socialItem2 = socialItem;
            if (socialItem2 instanceof SocialItem.Connected) {
                CompositeDisposable compositeDisposable = this.a.d;
                Disposable subscribe = this.a.p.showDialog(null, this.a.q.removeSocialDialogMessage(), this.a.q.removeButtonText(), this.a.q.cancelButtonText(), true).subscribe(new a2.a.a.y2.f(this, socialItem2));
                Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…twork(item.social.type) }");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (socialItem2 instanceof SocialItem.Available) {
                SocialItem.Available available = (SocialItem.Available) socialItem2;
                this.a.r.track(new SocialButtonClickedEvent("profile", available.getSocial().getType()));
                SocialManagementPresenter.Router router = this.a.b;
                if (router != null) {
                    router.loginSocial(available.getSocial().getType());
                }
            }
        }
    }

    public static final class c<T> implements Consumer<SocialNotificationAction> {
        public final /* synthetic */ SocialManagementPresenterImpl a;

        public c(SocialManagementPresenterImpl socialManagementPresenterImpl) {
            this.a = socialManagementPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SocialNotificationAction socialNotificationAction) {
            SocialNotificationAction socialNotificationAction2 = socialNotificationAction;
            if (socialNotificationAction2 instanceof SocialNotificationAction.CrossClick) {
                SocialManagementPresenterImpl.access$removeNotification(this.a, ((SocialNotificationAction.CrossClick) socialNotificationAction2).getNotification());
            } else if (socialNotificationAction2 instanceof SocialNotificationAction.DeepLinkClick) {
                SocialNotificationAction.DeepLinkClick deepLinkClick = (SocialNotificationAction.DeepLinkClick) socialNotificationAction2;
                if (Intrinsics.areEqual(deepLinkClick.getNotification().getProvider(), "esia")) {
                    this.a.r.track(new EsiaLinkClick());
                }
                SocialManagementPresenter.Router router = this.a.b;
                if (router != null) {
                    router.followDeepLink(deepLinkClick.getDeepLink());
                }
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class e<T> implements Consumer<List<? extends SocialItem>> {
        public final /* synthetic */ SocialManagementPresenterImpl a;

        public e(SocialManagementPresenterImpl socialManagementPresenterImpl) {
            this.a = socialManagementPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends SocialItem> list) {
            List<? extends SocialItem> list2 = list;
            this.a.f = null;
            this.a.e = list2;
            DataAwareAdapterPresenter dataAwareAdapterPresenter = this.a.l;
            Intrinsics.checkNotNullExpressionValue(list2, "items");
            AdapterPresentersKt.updateItems(dataAwareAdapterPresenter, list2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ SocialManagementPresenterImpl a;

        public f(SocialManagementPresenterImpl socialManagementPresenterImpl) {
            this.a = socialManagementPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ErrorHelper errorHelper = this.a.o;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            String recycle = errorHelper.recycle(th2);
            SocialManagementView socialManagementView = this.a.a;
            if (socialManagementView != null) {
                socialManagementView.showError(recycle);
            }
            this.a.f = recycle;
        }
    }

    @Inject
    public SocialManagementPresenterImpl(@NotNull SocialManagementInteractor socialManagementInteractor, @NotNull List<SignInManager> list, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull PublishRelay<SocialItem> publishRelay, @NotNull PublishRelay<SocialNotificationAction> publishRelay2, @NotNull ErrorHelper errorHelper, @NotNull DialogPresenter dialogPresenter, @NotNull SocialManagementResourceProvider socialManagementResourceProvider, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull SocialTypeToStringMapper socialTypeToStringMapper, @Nullable Kundle kundle) {
        Object obj;
        Boolean bool;
        Intrinsics.checkNotNullParameter(socialManagementInteractor, "interactor");
        Intrinsics.checkNotNullParameter(list, "socialManagers");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClicks");
        Intrinsics.checkNotNullParameter(publishRelay2, "notificationActions");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(socialManagementResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper, "socialTypeToStringMapper");
        this.j = socialManagementInteractor;
        this.k = list;
        this.l = dataAwareAdapterPresenter;
        this.m = publishRelay;
        this.n = publishRelay2;
        this.o = errorHelper;
        this.p = dialogPresenter;
        this.q = socialManagementResourceProvider;
        this.r = analytics;
        this.s = schedulersFactory;
        this.t = socialTypeToStringMapper;
        String str = null;
        this.e = kundle != null ? kundle.getParcelableList("items") : null;
        this.f = kundle != null ? kundle.getString("error") : str;
        this.g = (kundle == null || (bool = kundle.getBoolean("changed")) == null) ? false : bool.booleanValue();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SocialManagementResourceProvider socialManagementResourceProvider2 = this.q;
            String mapToString = this.t.mapToString(it.next().getType());
            int hashCode = mapToString.hashCode();
            if (hashCode != 3260) {
                if (hashCode != 3305) {
                    if (hashCode != 3548) {
                        if (hashCode != 3765) {
                            if (hashCode != 3122758) {
                                if (hashCode == 93029210 && mapToString.equals("apple")) {
                                    obj = new SocialNetwork.Apple(socialManagementResourceProvider2.appleTitle());
                                }
                                throw new IllegalStateException("Unknown social manager");
                            } else if (mapToString.equals("esia")) {
                                obj = new SocialNetwork.Esia(socialManagementResourceProvider2.getEsiaTitle());
                            } else {
                                throw new IllegalStateException("Unknown social manager");
                            }
                        } else if (mapToString.equals("vk")) {
                            obj = new SocialNetwork.Vkontakte(socialManagementResourceProvider2.vkontakteTitle());
                        } else {
                            throw new IllegalStateException("Unknown social manager");
                        }
                    } else if (mapToString.equals("ok")) {
                        obj = new SocialNetwork.Odnoklassniki(socialManagementResourceProvider2.odnoklassnikiTitle());
                    } else {
                        throw new IllegalStateException("Unknown social manager");
                    }
                } else if (mapToString.equals("gp")) {
                    obj = new SocialNetwork.Google(socialManagementResourceProvider2.googleTitle());
                } else {
                    throw new IllegalStateException("Unknown social manager");
                }
            } else if (mapToString.equals("fb")) {
                obj = new SocialNetwork.Facebook(socialManagementResourceProvider2.facebookTitle());
            } else {
                throw new IllegalStateException("Unknown social manager");
            }
            arrayList.add(obj);
        }
        this.h = arrayList;
    }

    public static final void access$handleError(SocialManagementPresenterImpl socialManagementPresenterImpl, Throwable th) {
        TypedError handle = socialManagementPresenterImpl.o.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            CompositeDisposable compositeDisposable = socialManagementPresenterImpl.d;
            Disposable subscribe = socialManagementPresenterImpl.p.showDialog(((ErrorResult.ErrorDialog) handle).getUserDialog()).subscribe(new j(socialManagementPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…ter?.followDeepLink(it) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        SocialManagementView socialManagementView = socialManagementPresenterImpl.a;
        if (socialManagementView != null) {
            socialManagementView.showMessage(socialManagementPresenterImpl.o.recycle(handle));
        }
    }

    public static final void access$onSocialNetworkAdded(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        socialManagementPresenterImpl.e = null;
        socialManagementPresenterImpl.a();
    }

    public static final void access$onSocialNetworkRemoved(SocialManagementPresenterImpl socialManagementPresenterImpl, String str) {
        T t2;
        boolean z;
        SocialType mapToSocialType = socialManagementPresenterImpl.t.mapToSocialType(str);
        Iterator<T> it = socialManagementPresenterImpl.k.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2.getType() == mapToSocialType) {
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
        T t3 = t2;
        if (t3 != null) {
            t3.logout();
            socialManagementPresenterImpl.e = null;
            socialManagementPresenterImpl.a();
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.e3("SocialNetwork type: ", str, " is not supported"));
    }

    public static final void access$removeNotification(SocialManagementPresenterImpl socialManagementPresenterImpl, SocialItem.Notification notification) {
        CompositeDisposable compositeDisposable = socialManagementPresenterImpl.c;
        Disposable subscribe = socialManagementPresenterImpl.j.removeNotification(notification.getStringId()).observeOn(socialManagementPresenterImpl.s.mainThread()).subscribe(new k(socialManagementPresenterImpl, notification), l.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.removeNotific…   }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$removeSocialNetwork(SocialManagementPresenterImpl socialManagementPresenterImpl, String str) {
        socialManagementPresenterImpl.g = true;
        CompositeDisposable compositeDisposable = socialManagementPresenterImpl.c;
        Disposable subscribe = socialManagementPresenterImpl.j.removeSocialNetwork(str).observeOn(socialManagementPresenterImpl.s.mainThread()).doOnSubscribe(new m(socialManagementPresenterImpl)).doAfterTerminate(new n(socialManagementPresenterImpl)).subscribe(new o(socialManagementPresenterImpl, str), new p(socialManagementPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.removeSocialN…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void a() {
        Single<R> single;
        CompositeDisposable compositeDisposable = this.c;
        List<? extends SocialItem> list = this.e;
        if (list == null || (single = Singles.toSingle(list)) == null) {
            single = this.j.loadSocialNetworks().firstOrError().observeOn(this.s.mainThread()).doOnSubscribe(new a2.a.a.y2.g(this)).doOnTerminate(new h(this)).map(new i(this));
            Intrinsics.checkNotNullExpressionValue(single, "interactor.loadSocialNet…          }\n            }");
        }
        Disposable subscribe = single.subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "getItems()\n            .…rorMessage\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void attachRouter(@NotNull SocialManagementPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void attachView(@NotNull SocialManagementView socialManagementView) {
        Intrinsics.checkNotNullParameter(socialManagementView, "view");
        this.a = socialManagementView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.m.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks.subscribe { i…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = this.n.subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "notificationActions.subs…   }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = socialManagementView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.navigationClicks().…cribe { onBackPressed() }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = socialManagementView.retryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.retryClicks().subscribe { loadItems() }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        String str = this.f;
        if (str != null) {
            socialManagementView.showError(str);
        } else {
            a();
        }
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void onBackPressed() {
        SocialManagementPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen(this.g);
        }
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("items", this.e).putString("error", this.f).putBoolean("changed", Boolean.valueOf(this.g));
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void onSocialLoginError() {
        SocialManagementView socialManagementView = this.a;
        if (socialManagementView != null) {
            socialManagementView.showMessage(this.q.socialLoginError());
        }
    }

    @Override // com.avito.android.social_management.SocialManagementPresenter
    public void onSocialLoginResult(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        this.g = true;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.j.addSocialNetwork(str, str2).observeOn(this.s.mainThread()).doOnSubscribe(new a2.a.a.y2.b(this)).doAfterTerminate(new a2.a.a.y2.c(this)).subscribe(new a2.a.a.y2.d(this), new a2.a.a.y2.e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.addSocialNetw…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
