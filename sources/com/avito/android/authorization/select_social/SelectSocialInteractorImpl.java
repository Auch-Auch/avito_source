package com.avito.android.authorization.select_social;

import com.avito.android.account.AccountInteractor;
import com.avito.android.account.Credentials;
import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialInteractorImpl;", "Lcom/avito/android/authorization/select_social/SelectSocialInteractor;", "Lio/reactivex/Observable;", "", "Lcom/avito/android/authorization/select_social/adapter/SelectSocialField;", "loadItems", "()Lio/reactivex/Observable;", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "suggestKey", "Lcom/avito/android/remote/model/SocialAuthResult;", "login", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "user", "loginWithApple", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/account/AccountInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "Lcom/avito/android/remote/model/registration/ProfileSocial;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "socialList", "Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "c", "Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "resourceProvider", "<init>", "(Ljava/util/List;Lcom/avito/android/account/AccountInteractor;Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectSocialInteractorImpl implements SelectSocialInteractor {
    public final List<ProfileSocial> a;
    public final AccountInteractor b;
    public final SelectSocialResourceProvider c;

    @Inject
    public SelectSocialInteractorImpl(@NotNull List<ProfileSocial> list, @NotNull AccountInteractor accountInteractor, @NotNull SelectSocialResourceProvider selectSocialResourceProvider) {
        Intrinsics.checkNotNullParameter(list, "socialList");
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        Intrinsics.checkNotNullParameter(selectSocialResourceProvider, "resourceProvider");
        this.a = list;
        this.b = accountInteractor;
        this.c = selectSocialResourceProvider;
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialInteractor
    @NotNull
    public Observable<List<SelectSocialField>> loadItems() {
        List<ProfileSocial> list = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new SelectSocialField.Social((long) i, t));
            i = i2;
        }
        Observable<List<SelectSocialField>> just = Observable.just(CollectionsKt___CollectionsKt.plus((Collection) d.listOf(new SelectSocialField.Text(Long.MAX_VALUE, this.c.selectSocialMessage())), (Iterable) arrayList));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(textFields + socialFields)");
        return just;
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialInteractor
    @NotNull
    public Observable<SocialAuthResult> login(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "socialType");
        Intrinsics.checkNotNullParameter(str2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Observable<SocialAuthResult> observable = InteropKt.toV2(this.b.login(new Credentials.SignInServiceCredentials.SocialCredentials(str2, str3, str), null, str4)).flatMap(SelectSocialInteractorImpl$login$$inlined$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable;
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialInteractor
    @NotNull
    public Observable<SocialAuthResult> loginWithApple(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Observable<SocialAuthResult> observable = InteropKt.toV2(this.b.login(new Credentials.SignInServiceCredentials.AppleCredentials(str, str2, "apple"), null, str3)).flatMap(SelectSocialInteractorImpl$loginWithApple$$inlined$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable;
    }
}
