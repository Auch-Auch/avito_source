package com.avito.android.advert_core.contactbar;

import a2.g.r.g;
import arrow.core.Option;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.call_methods.CallMethods;
import com.avito.android.advert_core.contactbar.PhoneActionData;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.async_phone_core.UtilsKt;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.calls_shared.analytics.mapping.CallTypesToEventParamMapperKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.InAppCallLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.CallContactsResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FailurePhoneResponse;
import com.avito.android.remote.model.PhoneResponse;
import com.avito.android.remote.model.SuccessPhoneResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BY\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u00103\u001a\u000200\u0012\u000e\b\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b4\u00105J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractorImpl;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "", "itemId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/advert_core/contactbar/PhoneActionData;", "getPhoneAction", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "categoryId", "Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "phoneLink", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "getCallMethods", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;Lcom/avito/android/deep_linking/links/PhoneLink$Call;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "f", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/Formatter;", "e", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/remote/AsyncPhoneApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/AsyncPhoneApi;", "phoneApi", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", g.a, "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "appCallUsageTracker", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "Lcom/avito/android/analytics/NetworkTypeProvider;", "c", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", "d", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "<init>", "(Lcom/avito/android/remote/AsyncPhoneApi;Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/calls_shared/CallUuidProvider;Lcom/avito/android/calls_shared/AppCallsUsageTracker;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertContactsInteractorImpl implements AdvertContactsInteractor {
    public final AsyncPhoneApi a;
    public final CallsApi b;
    public final NetworkTypeProvider c;
    public final AccountStateProvider d;
    public final Formatter<String> e;
    public final CallUuidProvider f;
    public final AppCallsUsageTracker g;
    public final Features h;
    public final SchedulersFactory3 i;

    public static final class a<T, R> implements Function<Boolean, ObservableSource<? extends TypedResult<CallContactsResult>>> {
        public final /* synthetic */ AdvertContactsInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AppCallScenario e;

        public a(AdvertContactsInteractorImpl advertContactsInteractorImpl, String str, String str2, String str3, AppCallScenario appCallScenario) {
            this.a = advertContactsInteractorImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = appCallScenario;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends TypedResult<CallContactsResult>> apply(Boolean bool) {
            Observable<TypedResult<CallContactsResult>> observable;
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (!bool2.booleanValue()) {
                return Observable.error(new UnauthorizedException());
            }
            if (this.a.h.getCallsCanCallv4().invoke().booleanValue()) {
                observable = this.a.b.getCallContacts(this.b, this.c, this.d, CallTypesToEventParamMapperKt.getEventValue(this.e));
            } else {
                observable = this.a.b.getCallContactsOld(this.b, this.c, this.d, CallTypesToEventParamMapperKt.getEventValue(this.e));
            }
            return observable.subscribeOn(this.a.i.io());
        }
    }

    public static final class b<T, R> implements Function<CallContactsResult, Option<? extends InAppCallLink>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends InAppCallLink> apply(CallContactsResult callContactsResult) {
            CallContactsResult callContactsResult2 = callContactsResult;
            String callTo = callContactsResult2.getCallTo();
            if (!callContactsResult2.getCallAvailable() || callTo == null) {
                return Option.Companion.empty();
            }
            return Option.Companion.just(new InAppCallLink(callTo, callContactsResult2.getCallerName()));
        }
    }

    public static final class c<T, R> implements Function<Throwable, Option<? extends InAppCallLink>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends InAppCallLink> apply(Throwable th) {
            return Option.Companion.empty();
        }
    }

    public static final class d<T, R> implements Function<PhoneActionData, DeepLink> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public DeepLink apply(PhoneActionData phoneActionData) {
            return phoneActionData.getDeepLink();
        }
    }

    public static final class e<T, R> implements Function<PhoneResponse, PhoneActionData> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public PhoneActionData apply(PhoneResponse phoneResponse) {
            PhoneResponse phoneResponse2 = phoneResponse;
            if (phoneResponse2 instanceof SuccessPhoneResponse) {
                return new PhoneActionData.Success(((SuccessPhoneResponse) phoneResponse2).getAction());
            }
            if (phoneResponse2 instanceof FailurePhoneResponse) {
                return new PhoneActionData.Failed(UtilsKt.toDialogDeepLink(((FailurePhoneResponse) phoneResponse2).getDialogInfo()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public AdvertContactsInteractorImpl(@NotNull AsyncPhoneApi asyncPhoneApi, @NotNull CallsApi callsApi, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull AccountStateProvider accountStateProvider, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull CallUuidProvider callUuidProvider, @NotNull AppCallsUsageTracker appCallsUsageTracker, @NotNull Features features, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(asyncPhoneApi, "phoneApi");
        Intrinsics.checkNotNullParameter(callsApi, "callsApi");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(callUuidProvider, "callUuidProvider");
        Intrinsics.checkNotNullParameter(appCallsUsageTracker, "appCallUsageTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = asyncPhoneApi;
        this.b = callsApi;
        this.c = networkTypeProvider;
        this.d = accountStateProvider;
        this.e = formatter;
        this.f = callUuidProvider;
        this.g = appCallsUsageTracker;
        this.h = features;
        this.i = schedulersFactory3;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsInteractor
    @NotNull
    public Single<CallMethods> getCallMethods(@NotNull String str, @NotNull String str2, @NotNull AppCallScenario appCallScenario, @Nullable PhoneLink.Call call) {
        Single<R> single;
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
        Observable<R> observeOn = this.d.currentAuthorized().flatMapObservable(new a(this, str, str2, this.c.networkType(), appCallScenario)).observeOn(this.i.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "accountStateProvider.cur…schedulers.computation())");
        Single first = TypedObservablesKt.toTyped(observeOn).map(b.a).timeout(3000, TimeUnit.MILLISECONDS, this.i.computation()).onErrorReturn(c.a).first(Option.Companion.empty());
        if (call != null) {
            single = Single.just(call);
        } else {
            single = getPhoneAction(str).map(d.a);
        }
        Intrinsics.checkNotNullExpressionValue(first, "appCallContactsRequest");
        Intrinsics.checkNotNullExpressionValue(single, "phoneRequest");
        Single<CallMethods> zipWith = first.zipWith(single, new BiFunction<Option<? extends InAppCallLink>, DeepLink, R>(this) { // from class: com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl$getCallMethods$$inlined$zipWith$1
            public final /* synthetic */ AdvertContactsInteractorImpl a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(Option<? extends InAppCallLink> option, DeepLink deepLink) {
                CallMethods.Phone phone;
                Intrinsics.checkExpressionValueIsNotNull(option, "t");
                Intrinsics.checkExpressionValueIsNotNull(deepLink, "u");
                DeepLink deepLink2 = deepLink;
                Option<? extends InAppCallLink> option2 = option;
                CallMethods.InApp inApp = null;
                if (deepLink2 != null) {
                    phone = new CallMethods.Phone(deepLink2, deepLink2 instanceof PhoneLink.Call ? this.a.e.format(((PhoneLink.Call) deepLink2).getPhone()) : null);
                } else {
                    phone = null;
                }
                InAppCallLink inAppCallLink = (InAppCallLink) option2.orNull();
                if (inAppCallLink != null) {
                    inApp = new CallMethods.InApp(this.a.f.nextCallUuid(), inAppCallLink.getRecipient(), inAppCallLink.getCaller(), !this.a.g.hasBeenUsed());
                }
                return (R) new CallMethods(phone, inApp);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsInteractor
    @NotNull
    public Single<PhoneActionData> getPhoneAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Observable observeOn = AsyncPhoneApi.DefaultImpls.getPhoneAction$default(this.a, str, null, 2, null).subscribeOn(this.i.io()).observeOn(this.i.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "phoneApi.getPhoneAction(…schedulers.computation())");
        Single<PhoneActionData> firstOrError = TypedObservablesKt.toTyped(observeOn).map(e.a).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "phoneApi.getPhoneAction(…          .firstOrError()");
        return firstOrError;
    }
}
