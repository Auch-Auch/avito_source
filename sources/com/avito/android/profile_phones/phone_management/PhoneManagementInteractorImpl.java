package com.avito.android.profile_phones.phone_management;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractorImpl;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "", "currentPhone", "targetPhone", "Lio/reactivex/Completable;", "replacePhone", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "id", "src", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "login", "code", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", AuthSource.BOOKING_ORDER, "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneManagementInteractorImpl implements PhoneManagementInteractor, CodeConfirmationInteractor {
    public final ProfileApi a;
    public final CodeConfirmationInteractor b;
    public final SchedulersFactory c;

    @Inject
    public PhoneManagementInteractorImpl(@NotNull ProfileApi profileApi, @NotNull CodeConfirmationInteractor codeConfirmationInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = profileApi;
        this.b = codeConfirmationInteractor;
        this.c = schedulersFactory;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementInteractor
    @NotNull
    public Completable replacePhone(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "currentPhone");
        Intrinsics.checkNotNullParameter(str2, "targetPhone");
        Observable subscribeOn = InteropKt.toV2(this.a.replacePhoneOld(str, str2)).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.replacePhoneOld(curr…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.replacePhoneOld(curr…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.b.requestCode(str, str2);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        return this.b.sendCode(str, str2, str3);
    }
}
