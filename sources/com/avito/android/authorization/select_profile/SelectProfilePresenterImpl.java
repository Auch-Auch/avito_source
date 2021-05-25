package com.avito.android.authorization.select_profile;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.ProfileListLoadingEvent;
import com.avito.android.authorization.select_profile.SelectProfilePresenter;
import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001FBI\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010:\u001a\u000207\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010+\u001a\u00020(\u0012\b\u0010C\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bD\u0010EJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010&R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfilePresenterImpl;", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "Lcom/avito/android/authorization/select_profile/SelectProfileView;", "view", "", "attachView", "(Lcom/avito/android/authorization/select_profile/SelectProfileView;)V", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "shouldLogOnSuccess", AuthSource.SEND_ABUSE, "(Z)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "l", "Lcom/jakewharton/rxrelay3/PublishRelay;", "itemClicks", "", "f", "Ljava/lang/String;", "errorMessage", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;", "Lcom/avito/android/authorization/select_profile/SelectProfileInteractor;", "h", "Lcom/avito/android/authorization/select_profile/SelectProfileInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/analytics/Analytics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "disposables", "", "e", "Ljava/util/List;", "items", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenterImpl$ErrorType;", g.a, "Lcom/avito/android/authorization/select_profile/SelectProfilePresenterImpl$ErrorType;", "errorType", "Lcom/avito/android/authorization/select_profile/SelectProfileView;", "Lcom/avito/android/util/ErrorFormatter;", "k", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "i", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "state", "<init>", "(Lcom/avito/android/authorization/select_profile/SelectProfileInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/ErrorFormatter;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "ErrorType", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectProfilePresenterImpl implements SelectProfilePresenter {
    public SelectProfileView a;
    public SelectProfilePresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends SelectProfileField> e;
    public String f;
    public ErrorType g;
    public final SelectProfileInteractor h;
    public final AdapterPresenter i;
    public final SchedulersFactory3 j;
    public final ErrorFormatter k;
    public final PublishRelay<SelectProfileField> l;
    public final Analytics m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfilePresenterImpl$ErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON_ERROR", "NETWORK_ERROR", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public enum ErrorType {
        COMMON_ERROR,
        NETWORK_ERROR
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ErrorType.values();
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
                SelectProfilePresenter.Router router = ((SelectProfilePresenterImpl) this.b).b;
                if (router != null) {
                    router.leaveScreen();
                }
            } else if (i == 1) {
                ((SelectProfilePresenterImpl) this.b).a(false);
            } else if (i == 2) {
                ((SelectProfilePresenterImpl) this.b).a(true);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<SelectProfileField> {
        public final /* synthetic */ SelectProfilePresenterImpl a;

        public b(SelectProfilePresenterImpl selectProfilePresenterImpl) {
            this.a = selectProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SelectProfileField selectProfileField) {
            SelectProfilePresenter.Router router;
            SelectProfileField selectProfileField2 = selectProfileField;
            if (selectProfileField2 instanceof SelectProfileField.CreateProfile) {
                SelectProfilePresenter.Router router2 = this.a.b;
                if (router2 != null) {
                    router2.openCompleteRegistration();
                }
            } else if (selectProfileField2 instanceof SelectProfileField.Profile) {
                SelectProfileField.Profile profile = (SelectProfileField.Profile) selectProfileField2;
                String login = profile.getProfile().getLogin();
                List<ProfileSocial> social = profile.getProfile().getSocial();
                if (login != null) {
                    SelectProfilePresenter.Router router3 = this.a.b;
                    if (router3 != null) {
                        router3.openLogin(login);
                    }
                } else if (social != null && (router = this.a.b) != null) {
                    router.openSelectSocial(social);
                }
            }
        }
    }

    public static final class c<T> implements Consumer<List<? extends SelectProfileField>> {
        public final /* synthetic */ SelectProfilePresenterImpl a;
        public final /* synthetic */ boolean b;

        public c(SelectProfilePresenterImpl selectProfilePresenterImpl, boolean z) {
            this.a = selectProfilePresenterImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends SelectProfileField> list) {
            List<? extends SelectProfileField> list2 = list;
            SelectProfilePresenterImpl selectProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            SelectProfilePresenterImpl.access$handleSuccess(selectProfilePresenterImpl, list2, this.b);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ SelectProfilePresenterImpl a;

        public d(SelectProfilePresenterImpl selectProfilePresenterImpl) {
            this.a = selectProfilePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            SelectProfilePresenterImpl selectProfilePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            SelectProfilePresenterImpl.access$handleError(selectProfilePresenterImpl, th2);
        }
    }

    @Inject
    public SelectProfilePresenterImpl(@NotNull SelectProfileInteractor selectProfileInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorFormatter errorFormatter, @NotNull PublishRelay<SelectProfileField> publishRelay, @NotNull Analytics analytics, @Nullable Kundle kundle) {
        String string;
        Intrinsics.checkNotNullParameter(selectProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClicks");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = selectProfileInteractor;
        this.i = adapterPresenter;
        this.j = schedulersFactory3;
        this.k = errorFormatter;
        this.l = publishRelay;
        this.m = analytics;
        ErrorType errorType = null;
        this.e = kundle != null ? kundle.getParcelableList("items") : null;
        this.f = kundle != null ? kundle.getString("errorMessage") : null;
        if (!(kundle == null || (string = kundle.getString("error_type")) == null)) {
            errorType = ErrorType.valueOf(string);
        }
        this.g = errorType;
    }

    public static final void access$handleError(SelectProfilePresenterImpl selectProfilePresenterImpl, Throwable th) {
        Objects.requireNonNull(selectProfilePresenterImpl);
        if (Throwables.isNetworkProblem(th) || Throwables.isCertificatePinningError(th)) {
            String format = selectProfilePresenterImpl.k.format(th);
            selectProfilePresenterImpl.f = format;
            selectProfilePresenterImpl.g = ErrorType.NETWORK_ERROR;
            SelectProfileView selectProfileView = selectProfilePresenterImpl.a;
            if (selectProfileView != null) {
                selectProfileView.showNetworkError(format);
                return;
            }
            return;
        }
        selectProfilePresenterImpl.f = null;
        selectProfilePresenterImpl.g = ErrorType.COMMON_ERROR;
        SelectProfileView selectProfileView2 = selectProfilePresenterImpl.a;
        if (selectProfileView2 != null) {
            selectProfileView2.showError();
        }
        selectProfilePresenterImpl.m.track(new ProfileListLoadingEvent(true));
    }

    public static final void access$handleSuccess(SelectProfilePresenterImpl selectProfilePresenterImpl, List list, boolean z) {
        selectProfilePresenterImpl.f = null;
        selectProfilePresenterImpl.g = null;
        selectProfilePresenterImpl.e = list;
        AdapterPresentersKt.updateItems(selectProfilePresenterImpl.i, list);
        SelectProfileView selectProfileView = selectProfilePresenterImpl.a;
        if (selectProfileView != null) {
            selectProfileView.notifyItemsChanged();
        }
        SelectProfileView selectProfileView2 = selectProfilePresenterImpl.a;
        if (selectProfileView2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!(((SelectProfileField) obj) instanceof SelectProfileField.Text)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(list.indexOf((SelectProfileField) it.next())));
            }
            selectProfileView2.setDividers(arrayList2);
        }
        SelectProfileView selectProfileView3 = selectProfilePresenterImpl.a;
        if (selectProfileView3 != null) {
            selectProfileView3.showContent();
        }
        if (z) {
            selectProfilePresenterImpl.m.track(new ProfileListLoadingEvent(false));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r1 != null) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r4) {
        /*
            r3 = this;
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.c
            java.util.List<? extends com.avito.android.authorization.select_profile.adapter.SelectProfileField> r1 = r3.e
            if (r1 == 0) goto L_0x0012
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.just(r1)
            java.lang.String r2 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0012
            goto L_0x0030
        L_0x0012:
            com.avito.android.authorization.select_profile.SelectProfileInteractor r1 = r3.h
            io.reactivex.rxjava3.core.Observable r1 = r1.loadItems()
            com.avito.android.util.SchedulersFactory3 r2 = r3.j
            io.reactivex.rxjava3.core.Scheduler r2 = r2.mainThread()
            io.reactivex.rxjava3.core.Observable r1 = r1.observeOn(r2)
            a2.a.a.b.i.a r2 = new a2.a.a.b.i.a
            r2.<init>(r3)
            io.reactivex.rxjava3.core.Observable r1 = r1.doOnSubscribe(r2)
            java.lang.String r2 = "interactor.loadItems()\n … { view?.showProgress() }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0030:
            com.avito.android.authorization.select_profile.SelectProfilePresenterImpl$c r2 = new com.avito.android.authorization.select_profile.SelectProfilePresenterImpl$c
            r2.<init>(r3, r4)
            com.avito.android.authorization.select_profile.SelectProfilePresenterImpl$d r4 = new com.avito.android.authorization.select_profile.SelectProfilePresenterImpl$d
            r4.<init>(r3)
            io.reactivex.rxjava3.disposables.Disposable r4 = r1.subscribe(r2, r4)
            java.lang.String r1 = "getItems()\n            .…s) }) { handleError(it) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.select_profile.SelectProfilePresenterImpl.a(boolean):void");
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter
    public void attachRouter(@NotNull SelectProfilePresenter.Router router) {
        SelectProfileView selectProfileView;
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        ErrorType errorType = this.g;
        if (errorType == null) {
            a(false);
            return;
        }
        int ordinal = errorType.ordinal();
        if (ordinal == 0) {
            SelectProfileView selectProfileView2 = this.a;
            if (selectProfileView2 != null) {
                selectProfileView2.showError();
            }
        } else if (ordinal == 1 && (selectProfileView = this.a) != null) {
            String str = this.f;
            if (str == null) {
                str = "";
            }
            selectProfileView.showNetworkError(str);
        }
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter
    public void attachView(@NotNull SelectProfileView selectProfileView) {
        Intrinsics.checkNotNullParameter(selectProfileView, "view");
        this.a = selectProfileView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.l.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks.subscribe { i…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = selectProfileView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…?.leaveScreen()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = selectProfileView.networkErrorRetryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.networkErrorRetryCl…    loadItems()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = selectProfileView.errorRetryClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.errorRetryClicks().…Success = true)\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle putString = new Kundle().putParcelableList("items", this.e).putString("errorMessage", this.f);
        ErrorType errorType = this.g;
        return putString.putString("error_type", errorType != null ? errorType.name() : null);
    }
}
