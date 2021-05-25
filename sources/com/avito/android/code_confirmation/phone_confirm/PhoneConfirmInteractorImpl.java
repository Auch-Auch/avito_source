package com.avito.android.code_confirmation.phone_confirm;

import com.avito.android.code_confirmation.phone_confirm.ConfirmedCodeData;
import com.avito.android.code_confirmation.phone_confirm.PhoneCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.registration.ConfirmCodeResult;
import com.avito.android.remote.model.registration.RequestCodeResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001f\u0010 J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractorImpl;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "", "login", "src", "", "retry", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "code", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorThrowableConverter", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "d", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "resourcesProvider", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmInteractorImpl implements PhoneConfirmInteractor {
    public final ProfileApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;
    public final PhoneConfirmResourceProvider d;

    public static final class a<T, R> implements Function<Throwable, SingleSource<? extends TypedResult<RequestCodeResult>>> {
        public final /* synthetic */ PhoneConfirmInteractorImpl a;

        public a(PhoneConfirmInteractorImpl phoneConfirmInteractorImpl) {
            this.a = phoneConfirmInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends TypedResult<RequestCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Singles.toSingle((Throwable) new TypedResultException(this.a.c.convert(th2)));
        }
    }

    public static final class b<T, R> implements Function<RequestCodeResult, PhoneCodeInfo> {
        public final /* synthetic */ PhoneConfirmInteractorImpl a;

        public b(PhoneConfirmInteractorImpl phoneConfirmInteractorImpl) {
            this.a = phoneConfirmInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public PhoneCodeInfo apply(RequestCodeResult requestCodeResult) {
            RequestCodeResult requestCodeResult2 = requestCodeResult;
            if (requestCodeResult2 instanceof RequestCodeResult.Ok) {
                RequestCodeResult.Ok ok = (RequestCodeResult.Ok) requestCodeResult2;
                return new PhoneCodeInfo.Ok(ok.getNextTryTime() - ok.getLastTryTime(), 5);
            } else if (requestCodeResult2 instanceof RequestCodeResult.Failure) {
                return new PhoneCodeInfo.Error(((RequestCodeResult.Failure) requestCodeResult2).getMessage());
            } else {
                if (requestCodeResult2 instanceof RequestCodeResult.IncorrectData) {
                    String str = (String) CollectionsKt___CollectionsKt.firstOrNull(((RequestCodeResult.IncorrectData) requestCodeResult2).getMessages().values());
                    if (str == null) {
                        str = this.a.d.getPhoneAlreadyAddedError();
                    }
                    return new PhoneCodeInfo.Error(str);
                } else if (requestCodeResult2 instanceof RequestCodeResult.Confirmed) {
                    return new PhoneCodeInfo.Error(this.a.d.getPhoneAlreadyAddedError());
                } else {
                    if (requestCodeResult2 instanceof RequestCodeResult.VerifyByCall) {
                        return new PhoneCodeInfo.LandlinePhone(((RequestCodeResult.VerifyByCall) requestCodeResult2).getDeeplink());
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    public static final class c<T, R> implements Function<Throwable, SingleSource<? extends TypedResult<ConfirmCodeResult>>> {
        public final /* synthetic */ PhoneConfirmInteractorImpl a;

        public c(PhoneConfirmInteractorImpl phoneConfirmInteractorImpl) {
            this.a = phoneConfirmInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends TypedResult<ConfirmCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Singles.toSingle((Throwable) new TypedResultException(this.a.c.convert(th2)));
        }
    }

    public static final class d<T, R> implements Function<ConfirmCodeResult, ConfirmedCodeData> {
        public final /* synthetic */ PhoneConfirmInteractorImpl a;
        public final /* synthetic */ String b;

        public d(PhoneConfirmInteractorImpl phoneConfirmInteractorImpl, String str) {
            this.a = phoneConfirmInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ConfirmedCodeData apply(ConfirmCodeResult confirmCodeResult) {
            ConfirmCodeResult confirmCodeResult2 = confirmCodeResult;
            if (confirmCodeResult2 instanceof ConfirmCodeResult.Ok) {
                ConfirmCodeResult.Ok ok = (ConfirmCodeResult.Ok) confirmCodeResult2;
                return new ConfirmedCodeData.Ok(this.b, ok.getHash(), ok.isPhoneUsed());
            } else if (confirmCodeResult2 instanceof ConfirmCodeResult.Failure) {
                return new ConfirmedCodeData.Error(((ConfirmCodeResult.Failure) confirmCodeResult2).getMessage());
            } else {
                if (confirmCodeResult2 instanceof ConfirmCodeResult.IncorrectData) {
                    String str = (String) CollectionsKt___CollectionsKt.firstOrNull(((ConfirmCodeResult.IncorrectData) confirmCodeResult2).getMessages().values());
                    if (str == null) {
                        str = this.a.d.getCodeConfirmError();
                    }
                    return new ConfirmedCodeData.Error(str);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Inject
    public PhoneConfirmInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull PhoneConfirmResourceProvider phoneConfirmResourceProvider) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorThrowableConverter");
        Intrinsics.checkNotNullParameter(phoneConfirmResourceProvider, "resourcesProvider");
        this.a = profileApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
        this.d = phoneConfirmResourceProvider;
    }

    @Override // com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor
    @NotNull
    public Single<PhoneCodeInfo> requestCode(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "src");
        Single<TypedResult<RequestCodeResult>> onErrorResumeNext = this.a.requestCodeV2(str, z, str2).subscribeOn(this.b.io()).onErrorResumeNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.requestCodeV2(login,….toSingle()\n            }");
        Single<R> flatMap = onErrorResumeNext.flatMap(PhoneConfirmInteractorImpl$requestCode$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single<R> map = flatMap.map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.requestCodeV2(login,…          }\n            }");
        return map;
    }

    @Override // com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor
    @NotNull
    public Single<ConfirmedCodeData> sendCode(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "login", str2, "code", str3, "src");
        Single<TypedResult<ConfirmCodeResult>> onErrorResumeNext = this.a.confirmCodeSingle(str, str2, str3).subscribeOn(this.b.io()).onErrorResumeNext(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.confirmCodeSingle(lo….toSingle()\n            }");
        Single<R> flatMap = onErrorResumeNext.flatMap(PhoneConfirmInteractorImpl$sendCode$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single<R> map = flatMap.map(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(map, "api.confirmCodeSingle(lo…          }\n            }");
        return map;
    }
}
