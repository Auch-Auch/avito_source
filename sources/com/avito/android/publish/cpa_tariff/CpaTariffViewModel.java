package com.avito.android.publish.cpa_tariff;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.cpa_tariff.data.CpaTariffRepository;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CpaContactInfoResponse;
import com.avito.android.remote.model.CpaPhone;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.Flowables;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002/0B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b-\u0010.J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010&¨\u00061"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents;", "screenEvents", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction;", "routingActions", "Lcom/avito/android/publish/cpa_tariff/CpaTariffView;", "cpaTariffView", "", "init", "(Lcom/avito/android/publish/cpa_tariff/CpaTariffView;)V", "onCleared", "()V", "Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;", "h", "Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;", "repository", "", "Lcom/avito/android/remote/model/CpaPhone;", "d", "Ljava/util/List;", "userPhones", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "e", "Z", "initialDataLoaded", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "j", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "tracker", "f", "events", "<init>", "(Lcom/avito/android/publish/cpa_tariff/data/CpaTariffRepository;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "RoutingAction", "ScreenEvents", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public List<CpaPhone> d = CollectionsKt__CollectionsKt.emptyList();
    public boolean e;
    public final SingleLiveEvent<ScreenEvents> f = new SingleLiveEvent<>();
    public final SingleLiveEvent<RoutingAction> g = new SingleLiveEvent<>();
    public final CpaTariffRepository h;
    public final SchedulersFactory3 i;
    public final PublishEventTracker j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction;", "", "<init>", "()V", "Back", "BackWithToast", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction$Back;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction$BackWithToast;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction$Back;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Back extends RoutingAction {
            @NotNull
            public static final Back INSTANCE = new Back();

            public Back() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction$BackWithToast;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class BackWithToast extends RoutingAction {
            @NotNull
            public static final BackWithToast INSTANCE = new BackWithToast();

            public BackWithToast() {
                super(null);
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents;", "", "<init>", "()V", "ContactInfoLoaded", "CreateTariffRequestError", "NameInputError", "PhoneInputError", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$NameInputError;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$PhoneInputError;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$CreateTariffRequestError;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$ContactInfoLoaded;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenEvents {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$ContactInfoLoaded;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", AuthSource.SEND_ABUSE, "getName", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ContactInfoLoaded extends ScreenEvents {
            @NotNull
            public final String a;
            @Nullable
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ContactInfoLoaded(@NotNull String str, @Nullable String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "name");
                this.a = str;
                this.b = str2;
            }

            @NotNull
            public final String getName() {
                return this.a;
            }

            @Nullable
            public final String getPhone() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$CreateTariffRequestError;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class CreateTariffRequestError extends ScreenEvents {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CreateTariffRequestError(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$NameInputError;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class NameInputError extends ScreenEvents {
            @NotNull
            public static final NameInputError INSTANCE = new NameInputError();

            public NameInputError() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents$PhoneInputError;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel$ScreenEvents;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhoneInputError extends ScreenEvents {
            @NotNull
            public static final PhoneInputError INSTANCE = new PhoneInputError();

            public PhoneInputError() {
                super(null);
            }
        }

        public ScreenEvents() {
        }

        public ScreenEvents(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ CpaTariffViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CpaTariffViewModel cpaTariffViewModel) {
            super(1);
            this.a = cpaTariffViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            this.a.g.setValue(RoutingAction.Back.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Pair<? extends String, ? extends String>, Unit> {
        public final /* synthetic */ CpaTariffViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CpaTariffViewModel cpaTariffViewModel) {
            super(1);
            this.a = cpaTariffViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Pair<? extends String, ? extends String> pair) {
            Pair<? extends String, ? extends String> pair2 = pair;
            CpaTariffViewModel.access$submit(this.a, (String) pair2.getFirst(), (String) pair2.getSecond());
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<TypedResult<CpaContactInfoResponse>> {
        public final /* synthetic */ CpaTariffViewModel a;

        public c(CpaTariffViewModel cpaTariffViewModel) {
            this.a = cpaTariffViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<CpaContactInfoResponse> typedResult) {
            TypedResult<CpaContactInfoResponse> typedResult2 = typedResult;
            String str = null;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.e = true;
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                List<CpaPhone> phones = ((CpaContactInfoResponse) ofResult.getResult()).getPhones();
                if (phones != null) {
                    this.a.d = phones;
                    for (CpaPhone cpaPhone : phones) {
                        if (cpaPhone.isConfirmed()) {
                            str = CpaTariffViewModelKt.access$getPhoneWithoutPrefix(cpaPhone);
                        }
                    }
                }
                this.a.f.setValue(new ScreenEvents.ContactInfoLoaded(((CpaContactInfoResponse) ofResult.getResult()).getName(), str));
            } else if (typedResult2 instanceof TypedResult.OfError) {
                Logs.error$default("Can't load contact info for CPA tariff screen", null, 2, null);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Can't load contact info for CPA tariff screen", th);
        }
    }

    public CpaTariffViewModel(@NotNull CpaTariffRepository cpaTariffRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(cpaTariffRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishEventTracker, "tracker");
        this.h = cpaTariffRepository;
        this.i = schedulersFactory3;
        this.j = publishEventTracker;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if ((r5.length() > 0) != false) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$submit(com.avito.android.publish.cpa_tariff.CpaTariffViewModel r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.util.Objects.requireNonNull(r3)
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0014
            int r2 = r4.length()
            if (r2 <= 0) goto L_0x000f
            r2 = 1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            if (r2 == 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 != 0) goto L_0x001f
            com.avito.android.util.architecture_components.SingleLiveEvent<com.avito.android.publish.cpa_tariff.CpaTariffViewModel$ScreenEvents> r3 = r3.f
            com.avito.android.publish.cpa_tariff.CpaTariffViewModel$ScreenEvents$NameInputError r4 = com.avito.android.publish.cpa_tariff.CpaTariffViewModel.ScreenEvents.NameInputError.INSTANCE
            r3.setValue(r4)
            goto L_0x0076
        L_0x001f:
            if (r5 == 0) goto L_0x002d
            int r2 = r5.length()
            if (r2 <= 0) goto L_0x0029
            r2 = 1
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r2 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            if (r0 != 0) goto L_0x0038
            com.avito.android.util.architecture_components.SingleLiveEvent<com.avito.android.publish.cpa_tariff.CpaTariffViewModel$ScreenEvents> r3 = r3.f
            com.avito.android.publish.cpa_tariff.CpaTariffViewModel$ScreenEvents$PhoneInputError r4 = com.avito.android.publish.cpa_tariff.CpaTariffViewModel.ScreenEvents.PhoneInputError.INSTANCE
            r3.setValue(r4)
            goto L_0x0076
        L_0x0038:
            com.avito.android.publish.analytics.PublishEventTracker r0 = r3.j
            r0.trackCpaRequestSend()
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r5 = r0
        L_0x0043:
            if (r4 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r4 = r0
        L_0x0047:
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.c
            com.avito.android.publish.cpa_tariff.data.CpaTariffRepository r1 = r3.h
            io.reactivex.rxjava3.core.Observable r4 = r1.requestCpaTariff(r5, r4)
            com.avito.android.util.SchedulersFactory3 r5 = r3.i
            io.reactivex.rxjava3.core.Scheduler r5 = r5.io()
            io.reactivex.rxjava3.core.Observable r4 = r4.subscribeOn(r5)
            com.avito.android.util.SchedulersFactory3 r5 = r3.i
            io.reactivex.rxjava3.core.Scheduler r5 = r5.mainThread()
            io.reactivex.rxjava3.core.Observable r4 = r4.observeOn(r5)
            a2.a.a.e2.p.a r5 = new a2.a.a.e2.p.a
            r5.<init>(r3)
            a2.a.a.e2.p.b r3 = a2.a.a.e2.p.b.a
            io.reactivex.rxjava3.disposables.Disposable r3 = r4.subscribe(r5, r3)
            java.lang.String r4 = "repository.requestCpaTar…\", it)\n                })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r3)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.cpa_tariff.CpaTariffViewModel.access$submit(com.avito.android.publish.cpa_tariff.CpaTariffViewModel, java.lang.String, java.lang.String):void");
    }

    public final void init(@NotNull CpaTariffView cpaTariffView) {
        Intrinsics.checkNotNullParameter(cpaTariffView, "cpaTariffView");
        CompositeDisposable compositeDisposable = this.c;
        Observable<Unit> upButtonClicks = cpaTariffView.upButtonClicks();
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.DROP;
        DisposableKt.plusAssign(compositeDisposable, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.i, upButtonClicks.toFlowable(backpressureStrategy), "cpaTariffView.upButtonCl…(schedulers.mainThread())"), new a(this)));
        DisposableKt.plusAssign(this.c, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.i, cpaTariffView.submitButtonClicks().toFlowable(backpressureStrategy), "cpaTariffView.submitButt…(schedulers.mainThread())"), new b(this)));
        if (!this.e) {
            CompositeDisposable compositeDisposable2 = this.c;
            Disposable subscribe = this.h.getContactInfo().subscribeOn(this.i.io()).observeOn(this.i.mainThread()).subscribe(new c(this), d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getContactInf…t)\n                    })");
            DisposableKt.plusAssign(compositeDisposable2, subscribe);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
        super.onCleared();
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.g;
    }

    @NotNull
    public final LiveData<ScreenEvents> screenEvents() {
        return this.f;
    }
}
