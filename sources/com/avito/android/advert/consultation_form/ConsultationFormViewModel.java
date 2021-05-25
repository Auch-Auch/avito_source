package com.avito.android.advert.consultation_form;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.advert.consultation_form.data.ConsultationFormRepository;
import com.avito.android.advert.consultation_form.event.VerifiedByAvitoSubmitEvent;
import com.avito.android.advert_core.analytics.consultation_form.ConsultationFormSubmitSuccessEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.ConsultationRequestResult;
import com.avito.android.remote.model.ContactInfoResponse;
import com.avito.android.remote.model.FormCategory;
import com.avito.android.remote.model.FormInput;
import com.avito.android.remote.model.Phone;
import com.avito.android.remote.model.SuccessAction;
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
import java.util.Objects;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001EB?\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010)\u001a\u00020&\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010-¢\u0006\u0004\bC\u0010DJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u00101R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010$R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u0003088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010$R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010$¨\u0006F"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "routingActions", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/advert/consultation_form/ConsultationFormView;", "consultationFormView", "", "init", "(Lcom/avito/android/advert/consultation_form/ConsultationFormView;)V", "onCleared", "()V", "", "requestCode", "resultCode", "", "onResult", "(II)Z", "", "phone", "c", "(Ljava/lang/String;)Z", "name", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;", "l", "Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;", "repository", "", "Lcom/avito/android/remote/model/Phone;", "e", "Ljava/util/List;", "userPhones", a2.g.r.g.a, "Ljava/lang/String;", "savedPhone", "Lcom/avito/android/analytics/Analytics;", "n", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/remote/model/ConsultationFormData;", "o", "Lcom/avito/android/remote/model/ConsultationFormData;", "formData", "Lcom/avito/android/advert/consultation_form/ConsultationFormView;", "view", "f", "savedName", "h", "Z", "initialDataLoaded", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "i", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "k", "developmentId", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "j", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/remote/model/ConsultationFormData;)V", "RoutingAction", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormViewModel extends ViewModel {
    public ConsultationFormView c;
    public final CompositeDisposable d;
    public List<Phone> e;
    public String f;
    public String g;
    public boolean h;
    public final SingleLiveEvent<RoutingAction> i;
    public final String j;
    public final String k;
    public final ConsultationFormRepository l;
    public final SchedulersFactory3 m;
    public final Analytics n;
    public final ConsultationFormData o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "", "<init>", "()V", "Back", "BackWithAction", "BackWithToast", "OpenDeepLink", "ToPhoneVerification", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$Back;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$BackWithToast;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$ToPhoneVerification;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$BackWithAction;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$OpenDeepLink;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$Back;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class Back extends RoutingAction {
            @NotNull
            public static final Back INSTANCE = new Back();

            public Back() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$BackWithAction;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class BackWithAction extends RoutingAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BackWithAction(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "link");
                this.a = deepLink;
            }

            @NotNull
            public final DeepLink getLink() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$BackWithToast;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class BackWithToast extends RoutingAction {
            @Nullable
            public final String a;

            public BackWithToast() {
                this(null, 1, null);
            }

            public BackWithToast(@Nullable String str) {
                super(null);
                this.a = str;
            }

            @Nullable
            public final String getMessage() {
                return this.a;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ BackWithToast(String str, int i, j jVar) {
                this((i & 1) != 0 ? null : str);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$OpenDeepLink;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenDeepLink extends RoutingAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenDeepLink(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "link");
                this.a = deepLink;
            }

            @NotNull
            public final DeepLink getLink() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction$ToPhoneVerification;", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel$RoutingAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToPhoneVerification extends RoutingAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ToPhoneVerification(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                this.a = str;
            }

            @NotNull
            public final String getPhone() {
                return this.a;
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            FormCategory.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            FormCategory formCategory = FormCategory.FindOfficeOffer;
            iArr[1] = 1;
            FormCategory.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            FormCategory.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            FormCategory formCategory2 = FormCategory.VerifiedByAvito;
            iArr3[2] = 1;
            FormCategory formCategory3 = FormCategory.NewBuildings;
            iArr3[0] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error("Error in deepLinks subscription from ConsultationFormViewModel", th);
            } else if (i == 1) {
                Logs.error("Can't load contact info", th);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ ConsultationFormViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ConsultationFormViewModel consultationFormViewModel) {
            super(1);
            this.a = consultationFormViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            this.a.i.setValue(RoutingAction.Back.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Pair<? extends String, ? extends String>, Unit> {
        public final /* synthetic */ ConsultationFormViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ConsultationFormViewModel consultationFormViewModel) {
            super(1);
            this.a = consultationFormViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Pair<? extends String, ? extends String> pair) {
            Pair<? extends String, ? extends String> pair2 = pair;
            ConsultationFormViewModel.access$submit(this.a, (String) pair2.getFirst(), (String) pair2.getSecond());
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<DeepLink> {
        public final /* synthetic */ ConsultationFormViewModel a;

        public d(ConsultationFormViewModel consultationFormViewModel) {
            this.a = consultationFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            SingleLiveEvent singleLiveEvent = this.a.i;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            singleLiveEvent.setValue(new RoutingAction.OpenDeepLink(deepLink2));
        }
    }

    public static final class e<T> implements Consumer<TypedResult<ContactInfoResponse>> {
        public final /* synthetic */ ConsultationFormViewModel a;

        public e(ConsultationFormViewModel consultationFormViewModel) {
            this.a = consultationFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<ContactInfoResponse> typedResult) {
            TypedResult<ContactInfoResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.h = true;
                String str = null;
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                List<Phone> phones = ((ContactInfoResponse) ofResult.getResult()).getPhones();
                if (phones != null) {
                    this.a.e = phones;
                    for (Phone phone : phones) {
                        if (phone.isConfirmed()) {
                            str = ConsultationFormViewModelKt.access$getPhoneWithoutPrefix(phone);
                        }
                    }
                }
                ConsultationFormView consultationFormView = this.a.c;
                if (consultationFormView != null) {
                    consultationFormView.fillFieldsWithContactInfo(((ContactInfoResponse) ofResult.getResult()).getName(), str);
                    return;
                }
                return;
            }
            boolean z = typedResult2 instanceof TypedResult.OfError;
        }
    }

    public static final class f<T> implements Consumer<TypedResult<ConsultationRequestResult>> {
        public final /* synthetic */ ConsultationFormViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public f(ConsultationFormViewModel consultationFormViewModel, String str, String str2) {
            this.a = consultationFormViewModel;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<ConsultationRequestResult> typedResult) {
            ConsultationFormView consultationFormView;
            TypedResult<ConsultationRequestResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                ConsultationRequestResult consultationRequestResult = (ConsultationRequestResult) ofResult.getResult();
                if (consultationRequestResult instanceof ConsultationRequestResult.Ok) {
                    ConsultationFormViewModel.access$sendConsultationSubmitSuccess(this.a);
                    ConsultationFormViewModel.access$sendSuccessAction(this.a);
                } else if (consultationRequestResult instanceof ConsultationRequestResult.Failure) {
                    ConsultationFormView consultationFormView2 = this.a.c;
                    if (consultationFormView2 != null) {
                        Object result = ofResult.getResult();
                        Objects.requireNonNull(result, "null cannot be cast to non-null type com.avito.android.remote.model.ConsultationRequestResult.Failure");
                        consultationFormView2.handleRequestError(((ConsultationRequestResult.Failure) result).getMessage());
                    }
                } else if (consultationRequestResult instanceof ConsultationRequestResult.PhoneNeedVerification) {
                    this.a.f = this.b;
                    this.a.g = this.c;
                    this.a.i.setValue(new RoutingAction.ToPhoneVerification(this.c));
                }
            } else if ((typedResult2 instanceof TypedResult.OfError) && (consultationFormView = this.a.c) != null) {
                consultationFormView.handleRequestError(((TypedResult.OfError) typedResult2).getError().getMessage());
            }
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Can't request consultation", th);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsultationFormViewModel(String str, String str2, ConsultationFormRepository consultationFormRepository, SchedulersFactory3 schedulersFactory3, Analytics analytics, ConsultationFormData consultationFormData, int i2, j jVar) {
        this(str, str2, consultationFormRepository, schedulersFactory3, analytics, (i2 & 32) != 0 ? null : consultationFormData);
    }

    public static final void access$sendConsultationSubmitSuccess(ConsultationFormViewModel consultationFormViewModel) {
        int ordinal;
        ConsultationFormData consultationFormData = consultationFormViewModel.o;
        Event event = null;
        FormCategory category = consultationFormData != null ? consultationFormData.getCategory() : null;
        if (category == null || (ordinal = category.ordinal()) == 0) {
            event = new ConsultationFormSubmitSuccessEvent(consultationFormViewModel.j, consultationFormViewModel.k);
        } else if (ordinal == 2) {
            event = new VerifiedByAvitoSubmitEvent(0, 0, null, 7, null);
        }
        if (event != null) {
            consultationFormViewModel.n.track(event);
        }
    }

    public static final void access$sendSuccessAction(ConsultationFormViewModel consultationFormViewModel) {
        RoutingAction routingAction;
        ConsultationFormData consultationFormData = consultationFormViewModel.o;
        SuccessAction successAction = consultationFormData != null ? consultationFormData.getSuccessAction() : null;
        if (successAction instanceof SuccessAction.OpenDeepLink) {
            routingAction = new RoutingAction.BackWithAction(((SuccessAction.OpenDeepLink) successAction).getDeepLink());
        } else if (successAction instanceof SuccessAction.ShowToast) {
            routingAction = new RoutingAction.BackWithToast(((SuccessAction.ShowToast) successAction).getToastText());
        } else {
            routingAction = new RoutingAction.BackWithToast(null, 1, null);
        }
        consultationFormViewModel.i.setValue(routingAction);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        if ((r11.length() > 0) != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
        if (r0 == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00bb, code lost:
        if (r7 == null) goto L_0x00bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$submit(com.avito.android.advert.consultation_form.ConsultationFormViewModel r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.consultation_form.ConsultationFormViewModel.access$submit(com.avito.android.advert.consultation_form.ConsultationFormViewModel, java.lang.String, java.lang.String):void");
    }

    public final boolean c(String str) {
        ConsultationFormData consultationFormData = this.o;
        Boolean bool = null;
        FormCategory category = consultationFormData != null ? consultationFormData.getCategory() : null;
        if (category != null && category.ordinal() == 1) {
            FormInput phoneInput = this.o.getPhoneInput();
            if (phoneInput != null) {
                bool = phoneInput.isRequired();
            }
            if (!Intrinsics.areEqual(bool, Boolean.FALSE) && (str == null || str.length() != 10)) {
                return false;
            }
        } else if (str == null) {
            return false;
        } else {
            if (!(str.length() > 0)) {
                return false;
            }
        }
        return true;
    }

    public final void d(String str, String str2) {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.l.requestConsultation(str, str2, null, this.j, this.k).subscribeOn(this.m.io()).observeOn(this.m.mainThread()).subscribe(new f(this, str2, str), g.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.requestConsul…\", it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void init(@NotNull ConsultationFormView consultationFormView) {
        Intrinsics.checkNotNullParameter(consultationFormView, "consultationFormView");
        this.c = consultationFormView;
        ConsultationFormData consultationFormData = this.o;
        if (consultationFormData != null) {
            consultationFormView.initiateWithData(consultationFormData);
        }
        CompositeDisposable compositeDisposable = this.d;
        Observable<Unit> upButtonClicks = consultationFormView.upButtonClicks();
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.DROP;
        DisposableKt.plusAssign(compositeDisposable, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.m, upButtonClicks.toFlowable(backpressureStrategy), "consultationFormView.upB…(schedulers.mainThread())"), new b(this)));
        DisposableKt.plusAssign(this.d, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.m, consultationFormView.submitButtonClicks().toFlowable(backpressureStrategy), "consultationFormView.sub…(schedulers.mainThread())"), new c(this)));
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe = consultationFormView.deepLinkClicks().toFlowable(backpressureStrategy).observeOn(this.m.mainThread()).subscribe(new d(this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "consultationFormView.dee…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
        if (!this.h) {
            ConsultationFormData consultationFormData2 = this.o;
            if (!((consultationFormData2 != null ? consultationFormData2.getPhoneInput() : null) != null)) {
                CompositeDisposable compositeDisposable3 = this.d;
                Disposable subscribe2 = this.l.getContactInfo().subscribeOn(this.m.io()).observeOn(this.m.mainThread()).subscribe(new e(this), a.c);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "repository.getContactInf…t)\n                    })");
                DisposableKt.plusAssign(compositeDisposable3, subscribe2);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.dispose();
        this.c = null;
        super.onCleared();
    }

    public final boolean onResult(int i2, int i3) {
        if (i2 != 0) {
            return false;
        }
        if (i3 == -1) {
            d(this.g, this.f);
            return true;
        }
        ConsultationFormView consultationFormView = this.c;
        if (consultationFormView == null) {
            return true;
        }
        consultationFormView.stopLoading();
        return true;
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.i;
    }

    public ConsultationFormViewModel(@Nullable String str, @Nullable String str2, @NotNull ConsultationFormRepository consultationFormRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @Nullable ConsultationFormData consultationFormData) {
        Intrinsics.checkNotNullParameter(consultationFormRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.j = str;
        this.k = str2;
        this.l = consultationFormRepository;
        this.m = schedulersFactory3;
        this.n = analytics;
        this.o = consultationFormData;
        this.d = new CompositeDisposable();
        this.e = CollectionsKt__CollectionsKt.emptyList();
        this.f = "";
        this.g = "";
        this.i = new SingleLiveEvent<>();
    }
}
