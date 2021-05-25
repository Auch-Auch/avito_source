package com.avito.android.abuse.details;

import com.avito.android.abuse.details.AbuseDetailsPresenter;
import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Be\b\u0007\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010:\u001a\u000207\u0012\u000e\b\u0001\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\"\u0012\u000e\b\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\"\u0012\u000e\b\u0001\u0010E\u001a\b\u0012\u0004\u0012\u00020C0\"\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u0002*\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010;R\u0016\u0010<\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010>\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u00100R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020C0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010$¨\u0006I"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsPresenterImpl;", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "", "d", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/abuse/details/AbuseDetailsView;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/abuse/details/AbuseDetailsView;)V", "c", "", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "e", "(Ljava/util/List;)Ljava/util/List;", "view", "attachView", "detachView", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "onSendingAccepted", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/core/Observable;", "l", "Lio/reactivex/rxjava3/core/Observable;", "focusChangedStream", "h", "Ljava/util/List;", "fields", "k", "fieldChangedStream", "Lcom/avito/android/abuse/details/AbuseDetailsInteractor;", "i", "Lcom/avito/android/abuse/details/AbuseDetailsInteractor;", "interactor", "", "Z", "isSendingAccepted", "Lcom/avito/android/util/ErrorFormatter;", "n", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/abuse/details/AbuseDetailsView;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;", "viewDisposables", "f", "isSent", "", a2.g.r.g.a, "Ljava/lang/String;", "gettingError", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.OPEN_CHANNEL_LIST, "fieldClickStream", "state", "<init>", "(Lcom/avito/android/abuse/details/AbuseDetailsInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseDetailsPresenterImpl implements AbuseDetailsPresenter {
    public AbuseDetailsPresenter.Router a;
    public AbuseDetailsView b;
    public final CompositeDisposable c;
    public final CompositeDisposable d;
    public boolean e;
    public boolean f;
    public String g;
    public List<? extends AbuseField> h;
    public final AbuseDetailsInteractor i;
    public final AdapterPresenter j;
    public final Observable<AbuseField> k;
    public final Observable<AbuseField> l;
    public final Observable<DeepLink> m;
    public final ErrorFormatter n;
    public final SchedulersFactory3 o;

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
                ((AbuseDetailsPresenterImpl) this.b).a();
            } else if (i == 1) {
                ((AbuseDetailsPresenterImpl) this.b).onBackPressed();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<AbuseField> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public b(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AbuseField abuseField) {
            AbuseDetailsPresenterImpl.access$hideError(this.a, abuseField.getId());
        }
    }

    public static final class c<T> implements Consumer<AbuseField> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;
        public final /* synthetic */ AbuseDetailsView b;

        public c(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl, AbuseDetailsView abuseDetailsView) {
            this.a = abuseDetailsPresenterImpl;
            this.b = abuseDetailsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AbuseField abuseField) {
            AbuseField abuseField2 = abuseField;
            List list = this.a.h;
            if (list != null) {
                this.b.scrollToPosition(list.indexOf(abuseField2));
            }
        }
    }

    public static final class d<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public d(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            AbuseDetailsPresenter.Router router = this.a.a;
            if (router != null) {
                router.closeWithResult(deepLink2);
            }
        }
    }

    public static final class e<T> implements Consumer<Disposable> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public e(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            AbuseDetailsView abuseDetailsView = this.a.b;
            if (abuseDetailsView != null) {
                AbuseDetailsPresenterImpl.access$showProgress(this.a, abuseDetailsView);
            }
        }
    }

    public static final class f<T> implements Consumer<Boolean> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public f(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue() || this.a.e) {
                AbuseDetailsPresenterImpl.access$sendAbuse(this.a);
            } else {
                AbuseDetailsPresenterImpl.access$verifyAbuse(this.a);
            }
        }
    }

    public static final class g<T> implements Consumer<Disposable> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public g(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            AbuseDetailsView abuseDetailsView = this.a.b;
            if (abuseDetailsView != null) {
                AbuseDetailsPresenterImpl.access$showProgress(this.a, abuseDetailsView);
            }
        }
    }

    public static final class h<T> implements Consumer<List<? extends AbuseField>> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public h(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends AbuseField> list) {
            List<? extends AbuseField> list2 = list;
            AbuseDetailsPresenterImpl abuseDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            AbuseDetailsPresenterImpl.access$showFields(abuseDetailsPresenterImpl, list2);
            this.a.g = null;
            AbuseDetailsView abuseDetailsView = this.a.b;
            if (abuseDetailsView != null) {
                this.a.b(abuseDetailsView);
            }
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ AbuseDetailsPresenterImpl a;

        public i(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
            this.a = abuseDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AbuseDetailsPresenterImpl abuseDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            abuseDetailsPresenterImpl.g = AbuseDetailsPresenterImpl.access$format(abuseDetailsPresenterImpl, th2);
            AbuseDetailsView abuseDetailsView = this.a.b;
            if (abuseDetailsView != null) {
                this.a.b(abuseDetailsView);
            }
        }
    }

    public static final class j extends Lambda implements Function1<AbuseField, Boolean> {
        public static final j a = new j();

        public j() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(AbuseField abuseField) {
            AbuseField abuseField2 = abuseField;
            Intrinsics.checkNotNullParameter(abuseField2, "it");
            return Boolean.valueOf(abuseField2 instanceof AbuseField.ErrorLabel);
        }
    }

    @Inject
    public AbuseDetailsPresenterImpl(@NotNull AbuseDetailsInteractor abuseDetailsInteractor, @NotNull AdapterPresenter adapterPresenter, @Named("changed") @NotNull Observable<AbuseField> observable, @Named("focused") @NotNull Observable<AbuseField> observable2, @Named("clicked") @NotNull Observable<DeepLink> observable3, @NotNull ErrorFormatter errorFormatter, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable Kundle kundle) {
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(abuseDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(observable, "fieldChangedStream");
        Intrinsics.checkNotNullParameter(observable2, "focusChangedStream");
        Intrinsics.checkNotNullParameter(observable3, "fieldClickStream");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.i = abuseDetailsInteractor;
        this.j = adapterPresenter;
        this.k = observable;
        this.l = observable2;
        this.m = observable3;
        this.n = errorFormatter;
        this.o = schedulersFactory3;
        this.c = new CompositeDisposable();
        this.d = new CompositeDisposable();
        boolean z = false;
        this.e = (kundle == null || (bool2 = kundle.getBoolean("sendingAccepted")) == null) ? false : bool2.booleanValue();
        if (!(kundle == null || (bool = kundle.getBoolean("sent")) == null)) {
            z = bool.booleanValue();
        }
        this.f = z;
        List<? extends AbuseField> list = null;
        this.g = kundle != null ? kundle.getString("gettingError") : null;
        this.h = kundle != null ? kundle.getParcelableList("fields") : list;
    }

    public static final String access$format(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl, Throwable th) {
        return abuseDetailsPresenterImpl.n.format(th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r4 != null) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$handleSendingError(com.avito.android.abuse.details.AbuseDetailsPresenterImpl r13, java.lang.Throwable r14) {
        /*
            java.util.Objects.requireNonNull(r13)
            boolean r0 = r14 instanceof com.avito.android.abuse.details.IncorrectDataException
            if (r0 == 0) goto L_0x00d0
            com.avito.android.abuse.details.AbuseDetailsView r0 = r13.b
            if (r0 == 0) goto L_0x00e3
            com.avito.android.abuse.details.IncorrectDataException r14 = (com.avito.android.abuse.details.IncorrectDataException) r14
            java.util.Map r14 = r14.getErrors()
            r0.showContent()
            java.util.List<? extends com.avito.android.abuse.details.adapter.AbuseField> r1 = r13.h
            r2 = -1
            r3 = 0
            if (r1 == 0) goto L_0x0081
            java.util.List r1 = r13.e(r1)
            if (r1 == 0) goto L_0x0081
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r1)
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x002c:
            boolean r5 = r14.hasNext()
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r14.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            java.util.Iterator r8 = r1.iterator()
            r9 = 0
        L_0x004d:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x006a
            java.lang.Object r10 = r8.next()
            com.avito.android.abuse.details.adapter.AbuseField r10 = (com.avito.android.abuse.details.adapter.AbuseField) r10
            long r10 = r10.getId()
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x0063
            r10 = 1
            goto L_0x0064
        L_0x0063:
            r10 = 0
        L_0x0064:
            if (r10 == 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            int r9 = r9 + 1
            goto L_0x004d
        L_0x006a:
            r9 = -1
        L_0x006b:
            if (r9 < 0) goto L_0x002c
            com.avito.android.abuse.details.adapter.AbuseField$ErrorLabel r8 = new com.avito.android.abuse.details.adapter.AbuseField$ErrorLabel
            com.avito.android.abuse.details.adapter.AbuseField$ErrorLabel$Companion r10 = com.avito.android.abuse.details.adapter.AbuseField.ErrorLabel.Companion
            long r6 = r10.errorId(r6)
            r8.<init>(r6, r5)
            int r9 = r9 + 1
            r4.add(r9, r8)
            goto L_0x002c
        L_0x007e:
            if (r4 == 0) goto L_0x0081
            goto L_0x0085
        L_0x0081:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0085:
            r13.h = r4
            com.avito.konveyor.adapter.AdapterPresenter r14 = r13.j
            a2.b.a.a.a.s1(r4, r14)
            com.avito.android.abuse.details.AbuseDetailsView r14 = r13.b
            if (r14 == 0) goto L_0x0093
            r14.notifyItemsChanged()
        L_0x0093:
            r13.c()
            r0.showSendButton()
            java.util.Iterator r14 = r4.iterator()
            r0 = 0
        L_0x009e:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x00b2
            java.lang.Object r1 = r14.next()
            com.avito.android.abuse.details.adapter.AbuseField r1 = (com.avito.android.abuse.details.adapter.AbuseField) r1
            boolean r1 = r1 instanceof com.avito.android.abuse.details.adapter.AbuseField.ErrorLabel
            if (r1 == 0) goto L_0x00af
            goto L_0x00b3
        L_0x00af:
            int r0 = r0 + 1
            goto L_0x009e
        L_0x00b2:
            r0 = -1
        L_0x00b3:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r0)
            int r0 = r14.intValue()
            if (r0 <= r2) goto L_0x00be
            r3 = 1
        L_0x00be:
            if (r3 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r14 = 0
        L_0x00c2:
            if (r14 == 0) goto L_0x00e3
            int r14 = r14.intValue()
            com.avito.android.abuse.details.AbuseDetailsView r13 = r13.b
            if (r13 == 0) goto L_0x00e3
            r13.scrollToPosition(r14)
            goto L_0x00e3
        L_0x00d0:
            com.avito.android.abuse.details.AbuseDetailsView r0 = r13.b
            if (r0 == 0) goto L_0x00e3
            com.avito.android.util.ErrorFormatter r13 = r13.n
            java.lang.String r13 = r13.format(r14)
            r0.showContent()
            r0.showSnackbar(r13)
            r0.showSendButton()
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.abuse.details.AbuseDetailsPresenterImpl.access$handleSendingError(com.avito.android.abuse.details.AbuseDetailsPresenterImpl, java.lang.Throwable):void");
    }

    public static final void access$hideError(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl, long j2) {
        List<? extends AbuseField> list = abuseDetailsPresenterImpl.h;
        if (list != null) {
            Iterator<? extends AbuseField> it = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((AbuseField) it.next()).getId() == AbuseField.ErrorLabel.Companion.errorId(j2)) {
                    break;
                }
                i2++;
            }
            if (i2 >= 0) {
                List<? extends AbuseField> minus = CollectionsKt___CollectionsKt.minus(list, list.get(i2));
                abuseDetailsPresenterImpl.h = minus;
                a2.b.a.a.a.s1(minus, abuseDetailsPresenterImpl.j);
                AbuseDetailsView abuseDetailsView = abuseDetailsPresenterImpl.b;
                if (abuseDetailsView != null) {
                    abuseDetailsView.notifyItemRemoved(i2);
                }
                abuseDetailsPresenterImpl.c();
            }
        }
    }

    public static final void access$sendAbuse(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        List<? extends AbuseField> list = abuseDetailsPresenterImpl.h;
        if (list != null) {
            CompositeDisposable compositeDisposable = abuseDetailsPresenterImpl.d;
            Disposable subscribe = abuseDetailsPresenterImpl.i.sendAbuse(abuseDetailsPresenterImpl.e(list)).observeOn(abuseDetailsPresenterImpl.o.mainThread()).doOnSubscribe(new a2.a.a.d.a.a(abuseDetailsPresenterImpl)).subscribe(new a2.a.a.d.a.b(abuseDetailsPresenterImpl), new a2.a.a.d.a.c(abuseDetailsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.sendAbuse(sen…handleSendingError(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final void access$showFields(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl, List list) {
        abuseDetailsPresenterImpl.h = list;
        a2.b.a.a.a.s1(list, abuseDetailsPresenterImpl.j);
        AbuseDetailsView abuseDetailsView = abuseDetailsPresenterImpl.b;
        if (abuseDetailsView != null) {
            abuseDetailsView.notifyItemsChanged();
        }
        abuseDetailsPresenterImpl.c();
    }

    public static final void access$showProgress(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl, AbuseDetailsView abuseDetailsView) {
        Objects.requireNonNull(abuseDetailsPresenterImpl);
        abuseDetailsView.showLoading();
        abuseDetailsView.hideSendButton();
        abuseDetailsView.hideKeyboard();
    }

    public static final void access$verifyAbuse(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        List<? extends AbuseField> list = abuseDetailsPresenterImpl.h;
        if (list != null) {
            CompositeDisposable compositeDisposable = abuseDetailsPresenterImpl.d;
            Disposable subscribe = abuseDetailsPresenterImpl.i.verifyAbuse(abuseDetailsPresenterImpl.e(list)).observeOn(abuseDetailsPresenterImpl.o.mainThread()).doOnSubscribe(new a2.a.a.d.a.e(abuseDetailsPresenterImpl)).subscribe(new a2.a.a.d.a.f(abuseDetailsPresenterImpl), new a2.a.a.d.a.g(abuseDetailsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.verifyAbuse(s…Error(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void a() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = InteropKt.toV3(this.i.isAuthorized()).observeOn(this.o.mainThread()).doOnSubscribe(new e(this)).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.isAuthorized(…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    public void attachRouter(@NotNull AbuseDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
        if (!(this.g != null)) {
            d();
            return;
        }
        AbuseDetailsView abuseDetailsView = this.b;
        if (abuseDetailsView != null) {
            b(abuseDetailsView);
        }
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    public void attachView(@NotNull AbuseDetailsView abuseDetailsView) {
        Intrinsics.checkNotNullParameter(abuseDetailsView, "view");
        this.b = abuseDetailsView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = abuseDetailsView.sendClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.sendClicks().subscribe { trySendAbuse() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = abuseDetailsView.navigationClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…cribe { onBackPressed() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Disposable subscribe3 = this.k.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "fieldChangedStream.subsc… -> hideError(field.id) }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.c;
        Disposable subscribe4 = this.l.subscribe(new c(this, abuseDetailsView));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "focusChangedStream.subsc…oPosition(it) }\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.c;
        Disposable subscribe5 = this.m.subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "fieldClickStream.subscri…oseWithResult(deepLink) }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
    }

    public final void b(AbuseDetailsView abuseDetailsView) {
        AbuseDetailsView abuseDetailsView2;
        String str = this.g;
        if (str == null) {
            boolean z = this.f;
            if (z) {
                AbuseDetailsView abuseDetailsView3 = this.b;
                if (abuseDetailsView3 != null) {
                    abuseDetailsView3.showContent();
                    abuseDetailsView3.showCloseNavigation();
                    abuseDetailsView3.hideSendButton();
                }
            } else if (!z && (abuseDetailsView2 = this.b) != null) {
                abuseDetailsView2.showContent();
                abuseDetailsView2.showBackNavigation();
                abuseDetailsView2.showSendButton();
            }
        } else if (str != null) {
            abuseDetailsView.showError(str, new a2.a.a.d.a.d(this));
            abuseDetailsView.hideSendButton();
        }
    }

    public final void c() {
        AbuseDetailsView abuseDetailsView;
        List<? extends AbuseField> list = this.h;
        if (!(list == null || (abuseDetailsView = this.b) == null)) {
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            int i2 = 0;
            for (T t : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if ((CollectionsKt___CollectionsKt.getOrNull(list, i3) instanceof AbuseField.ErrorLabel) || (CollectionsKt___CollectionsKt.getOrNull(list, i3) instanceof AbuseField.Button) || i2 == CollectionsKt__CollectionsKt.getLastIndex(list)) {
                    i2 = -1;
                }
                arrayList.add(Integer.valueOf(i2));
                i2 = i3;
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((Number) obj).intValue() > -1) {
                    arrayList2.add(obj);
                }
            }
            abuseDetailsView.setDividers(arrayList2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r1 != null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r4 = this;
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r4.d
            java.util.List<? extends com.avito.android.abuse.details.adapter.AbuseField> r1 = r4.h
            if (r1 == 0) goto L_0x0012
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.just(r1)
            java.lang.String r2 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            com.avito.android.abuse.details.AbuseDetailsInteractor r1 = r4.i
            io.reactivex.rxjava3.core.Observable r1 = r1.getFields()
            com.avito.android.util.SchedulersFactory3 r2 = r4.o
            io.reactivex.rxjava3.core.Scheduler r2 = r2.mainThread()
            io.reactivex.rxjava3.core.Observable r1 = r1.observeOn(r2)
        L_0x0022:
            com.avito.android.abuse.details.AbuseDetailsPresenterImpl$g r2 = new com.avito.android.abuse.details.AbuseDetailsPresenterImpl$g
            r2.<init>(r4)
            io.reactivex.rxjava3.core.Observable r1 = r1.doOnSubscribe(r2)
            com.avito.android.abuse.details.AbuseDetailsPresenterImpl$h r2 = new com.avito.android.abuse.details.AbuseDetailsPresenterImpl$h
            r2.<init>(r4)
            com.avito.android.abuse.details.AbuseDetailsPresenterImpl$i r3 = new com.avito.android.abuse.details.AbuseDetailsPresenterImpl$i
            r3.<init>(r4)
            io.reactivex.rxjava3.disposables.Disposable r1 = r1.subscribe(r2, r3)
            java.lang.String r2 = "(fields?.toSingletonObse…?.update()\n            })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.abuse.details.AbuseDetailsPresenterImpl.d():void");
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    public void detachRouter() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    public void detachView() {
        this.c.clear();
        this.b = null;
    }

    public final List<AbuseField> e(List<? extends AbuseField> list) {
        List<AbuseField> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        t6.n.h.removeAll((List) mutableList, (Function1) j.a);
        return mutableList;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    public void onBackPressed() {
        if (this.f) {
            AbuseDetailsPresenter.Router router = this.a;
            if (router != null) {
                AbuseDetailsPresenter.Router.DefaultImpls.closeWithResult$default(router, null, 1, null);
                return;
            }
            return;
        }
        AbuseDetailsPresenter.Router router2 = this.a;
        if (router2 != null) {
            router2.close();
        }
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("gettingError", this.g).putBoolean("sendingAccepted", Boolean.valueOf(this.e)).putBoolean("sent", Boolean.valueOf(this.f)).putParcelableList("fields", this.h);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter
    public void onSendingAccepted() {
        this.e = true;
        a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbuseDetailsPresenterImpl(AbuseDetailsInteractor abuseDetailsInteractor, AdapterPresenter adapterPresenter, Observable observable, Observable observable2, Observable observable3, ErrorFormatter errorFormatter, SchedulersFactory3 schedulersFactory3, Kundle kundle, int i2, t6.r.a.j jVar) {
        this(abuseDetailsInteractor, adapterPresenter, observable, observable2, observable3, errorFormatter, schedulersFactory3, (i2 & 128) != 0 ? null : kundle);
    }
}
