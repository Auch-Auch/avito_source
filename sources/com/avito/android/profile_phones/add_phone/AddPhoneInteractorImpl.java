package com.avito.android.profile_phones.add_phone;

import com.avito.android.code_confirmation.phone_confirm.ConfirmedCodeData;
import com.avito.android.code_confirmation.phone_confirm.PhoneCodeInfo;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractorImpl;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmResourceProvider;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.PhoneValidationResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractorImpl;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractor;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "", "phone", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/PhoneValidationResult;", "validatePhone", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "login", "src", "", "retry", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "code", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorThrowableConverter", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class AddPhoneInteractorImpl implements AddPhoneInteractor, PhoneConfirmInteractor {
    public final ProfileApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;
    public final /* synthetic */ PhoneConfirmInteractorImpl d;

    public static final class a<T, R> implements Function<Throwable, SingleSource<? extends TypedResult<PhoneValidationResult>>> {
        public final /* synthetic */ AddPhoneInteractorImpl a;

        public a(AddPhoneInteractorImpl addPhoneInteractorImpl) {
            this.a = addPhoneInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends TypedResult<PhoneValidationResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Singles.toSingle((Throwable) new TypedResultException(this.a.c.convert(th2)));
        }
    }

    @Inject
    public AddPhoneInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull PhoneConfirmResourceProvider phoneConfirmResourceProvider) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorThrowableConverter");
        Intrinsics.checkNotNullParameter(phoneConfirmResourceProvider, "resourcesProvider");
        this.d = new PhoneConfirmInteractorImpl(profileApi, schedulersFactory3, typedErrorThrowableConverter, phoneConfirmResourceProvider);
        this.a = profileApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor
    @NotNull
    public Single<PhoneCodeInfo> requestCode(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "src");
        return this.d.requestCode(str, str2, z);
    }

    @Override // com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor
    @NotNull
    public Single<ConfirmedCodeData> sendCode(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "login", str2, "code", str3, "src");
        return this.d.sendCode(str, str2, str3);
    }

    @Override // com.avito.android.profile_phones.validation.PhoneValidationInteractor
    @NotNull
    public Single<PhoneValidationResult> validatePhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Single<TypedResult<PhoneValidationResult>> onErrorResumeNext = this.a.validatePhone(str).subscribeOn(this.b.io()).onErrorResumeNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.validatePhone(phone)….toSingle()\n            }");
        Single<R> flatMap = onErrorResumeNext.flatMap(AddPhoneInteractorImpl$validatePhone$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return flatMap;
    }
}
