package ru.sravni.android.bankproduct.network.profile;

import a7.c.a.a.n.f.h;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.network.profile.request.UpdateAccountElementRequestKt;
import ru.sravni.android.bankproduct.network.profile.response.AccountResponse;
import ru.sravni.android.bankproduct.repository.profile.IProfileWebClient;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileUpdateElementRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDetailedInfoRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDocumentInfoRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileV2Repo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/network/profile/ProfileWebClient;", "Lru/sravni/android/bankproduct/repository/profile/IProfileWebClient;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileRepo;", "getAccountInfo", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "profileUpdateElementRepo", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateFieldAccount;", "updateField", "(Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo;", "getAccountBrief", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo;", "getAccountDetailInfo", "", "documentEndpoint", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo;", "getAccountDocument", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/network/profile/IProfileApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/profile/IProfileApi;", "profileApi", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "<init>", "(Lru/sravni/android/bankproduct/network/profile/IProfileApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileWebClient implements IProfileWebClient {
    public final IProfileApi a;
    public final IThrowableWrapper b;
    public final ITokenRefresher c;

    public static final class a extends Lambda implements Function1<TokenData, Observable<ProfileV2Repo>> {
        public final /* synthetic */ ProfileWebClient a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProfileWebClient profileWebClient) {
            super(1);
            this.a = profileWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ProfileV2Repo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return this.a.a.getAccountBrief(tokenData2.getAccess_token()).map(a7.c.a.a.n.f.a.a).onErrorResumeNext(new a7.c.a.a.n.f.b(this));
        }
    }

    public static final class b extends Lambda implements Function1<TokenData, Observable<ProfileDetailedInfoRepo>> {
        public final /* synthetic */ ProfileWebClient a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ProfileWebClient profileWebClient) {
            super(1);
            this.a = profileWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ProfileDetailedInfoRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return this.a.a.getAccountDetailInfo(tokenData2.getAccess_token()).map(a7.c.a.a.n.f.c.a).onErrorResumeNext(new a7.c.a.a.n.f.d(this));
        }
    }

    public static final class c extends Lambda implements Function1<TokenData, Observable<ProfileDocumentInfoRepo>> {
        public final /* synthetic */ ProfileWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ProfileWebClient profileWebClient, String str) {
            super(1);
            this.a = profileWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ProfileDocumentInfoRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return this.a.a.getAccountDocument(this.b, tokenData2.getAccess_token()).map(a7.c.a.a.n.f.e.a).onErrorResumeNext(new a7.c.a.a.n.f.f(this));
        }
    }

    public static final class d extends Lambda implements Function1<TokenData, Observable<AccountResponse>> {
        public final /* synthetic */ ProfileWebClient a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ProfileWebClient profileWebClient) {
            super(1);
            this.a = profileWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<AccountResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "it");
            return this.a.a.getAccountInfo(tokenData2.getAccess_token());
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            AccountResponse accountResponse = (AccountResponse) obj;
            Intrinsics.checkParameterIsNotNull(accountResponse, "it");
            return accountResponse.toProfileRepo();
        }
    }

    public static final class f<T, R> implements Function<Throwable, ObservableSource<? extends ProfileRepo>> {
        public final /* synthetic */ ProfileWebClient a;

        public f(ProfileWebClient profileWebClient) {
            this.a = profileWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ProfileRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return Observable.error(this.a.b.wrap(th2));
        }
    }

    public static final class g extends Lambda implements Function1<TokenData, Observable<UpdateFieldAccount>> {
        public final /* synthetic */ ProfileWebClient a;
        public final /* synthetic */ ProfileUpdateElementRepo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ProfileWebClient profileWebClient, ProfileUpdateElementRepo profileUpdateElementRepo) {
            super(1);
            this.a = profileWebClient;
            this.b = profileUpdateElementRepo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<UpdateFieldAccount> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "it");
            return this.a.a.updateField(tokenData2.getAccess_token(), UpdateAccountElementRequestKt.toUpdateAccountElementRequest(this.b)).map(a7.c.a.a.n.f.g.a).onErrorResumeNext(new h(this));
        }
    }

    public ProfileWebClient(@NotNull IProfileApi iProfileApi, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iProfileApi, "profileApi");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.a = iProfileApi;
        this.b = iThrowableWrapper;
        this.c = iTokenRefresher;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileV2Repo> getAccountBrief() {
        return this.c.wrapWithTokenRefresh(new a(this));
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileDetailedInfoRepo> getAccountDetailInfo() {
        return this.c.wrapWithTokenRefresh(new b(this));
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileDocumentInfoRepo> getAccountDocument(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "documentEndpoint");
        return this.c.wrapWithTokenRefresh(new c(this, str));
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileRepo> getAccountInfo() {
        Observable<ProfileRepo> onErrorResumeNext = this.c.wrapWithTokenRefresh(new d(this)).map(e.a).onErrorResumeNext(new f(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.wrapWithT…error(wrapper.wrap(it)) }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<UpdateFieldAccount> updateField(@NotNull ProfileUpdateElementRepo profileUpdateElementRepo) {
        Intrinsics.checkParameterIsNotNull(profileUpdateElementRepo, "profileUpdateElementRepo");
        return this.c.wrapWithTokenRefresh(new g(this, profileUpdateElementRepo));
    }
}
