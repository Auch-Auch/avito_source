package com.avito.android.profile;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileTab;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.remote.model.user_profile.PhonesList;
import com.avito.android.remote.model.user_profile.UserProfileResult;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/profile/UserProfileInteractorImpl;", "Lcom/avito/android/profile/UserProfileInteractor;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "loadProfileInfo", "()Lio/reactivex/Observable;", "", "phone", "Lio/reactivex/Completable;", "deletePhone", "(Ljava/lang/String;)Lio/reactivex/Completable;", "setPhoneForAllAdverts", "Lio/reactivex/Single;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "getPhones", "()Lio/reactivex/Single;", "id", "src", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "login", "code", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "c", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileInteractorImpl implements UserProfileInteractor, CodeConfirmationInteractor {
    public final ProfileApi a;
    public final SchedulersFactory b;
    public final CodeConfirmationInteractor c;

    public static final class a<T, R> implements Function<PhonesList, List<? extends Phone>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends Phone> apply(PhonesList phonesList) {
            PhonesList phonesList2 = phonesList;
            Intrinsics.checkNotNullParameter(phonesList2, "it");
            return phonesList2.getPhones();
        }
    }

    public UserProfileInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CodeConfirmationInteractor codeConfirmationInteractor) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        this.a = profileApi;
        this.b = schedulersFactory;
        this.c = codeConfirmationInteractor;
    }

    @Override // com.avito.android.profile.UserProfileInteractor
    @NotNull
    public Completable deletePhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Observable subscribeOn = InteropKt.toV2(this.a.deletePhone(str)).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.deletePhone(phone).t…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.deletePhone(phone).t…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.profile.UserProfileInteractor
    @NotNull
    public Single<List<Phone>> getPhones() {
        Single subscribeOn = InteropKt.toV2(this.a.getProfilePhones()).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getProfilePhones().t…scribeOn(schedulers.io())");
        Single<List<Phone>> map = TypedSingleKt.toTyped(subscribeOn).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getProfilePhones().t…       .map { it.phones }");
        return map;
    }

    @Override // com.avito.android.profile.UserProfileInteractor
    @NotNull
    public Observable<UserProfileResult> loadProfileInfo() {
        Observable subscribeOn = InteropKt.toV2(this.a.getProfileInfoV6()).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getProfileInfoV6().t…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.c.requestCode(str, str2);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        return this.c.sendCode(str, str2, str3);
    }

    @Override // com.avito.android.profile.UserProfileInteractor
    @NotNull
    public Completable setPhoneForAllAdverts(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Observable subscribeOn = InteropKt.toV2(this.a.applyPhoneToItems(str, ProfileTab.ALL)).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.applyPhoneToItems(ph…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.applyPhoneToItems(ph…        .ignoreElements()");
        return ignoreElements;
    }
}
