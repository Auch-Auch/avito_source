package ru.sravni.android.bankproduct.mock.webclient;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.network.profile.response.AccountResponse;
import ru.sravni.android.bankproduct.network.profile.response.v2.AccountV2Response;
import ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDetailedInfoResponse;
import ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDocumentInfoResponse;
import ru.sravni.android.bankproduct.repository.profile.IProfileWebClient;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileUpdateElementRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDetailedInfoRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDocumentInfoRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileV2Repo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/ProfileWebClientStub;", "Lru/sravni/android/bankproduct/repository/profile/IProfileWebClient;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileRepo;", "getAccountInfo", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "profileUpdateElementRepo", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateFieldAccount;", "updateField", "(Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo;", "getAccountBrief", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo;", "getAccountDetailInfo", "", "documentEndpoint", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo;", "getAccountDocument", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Lru/sravni/android/bankproduct/mock/webclient/ProfileWebClientStubInfo;", "c", "Lru/sravni/android/bankproduct/mock/webclient/ProfileWebClientStubInfo;", "profileWebClientStubInfo", "", AuthSource.SEND_ABUSE, "J", "delay", "<init>", "(JLandroid/content/Context;Lru/sravni/android/bankproduct/mock/webclient/ProfileWebClientStubInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileWebClientStub implements IProfileWebClient {
    public final long a;
    public final Context b;
    public final ProfileWebClientStubInfo c;

    public static final class a<T, R> implements Function<T, R> {
        public final /* synthetic */ AccountV2Response a;

        public a(AccountV2Response accountV2Response) {
            this.a = accountV2Response;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.getItem().toProfileRepo();
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public final /* synthetic */ ProfileDetailedInfoResponse a;

        public b(ProfileDetailedInfoResponse profileDetailedInfoResponse) {
            this.a = profileDetailedInfoResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.getItem().toProfileDetailedInfoRepo();
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public final /* synthetic */ ProfileDocumentInfoResponse a;

        public c(ProfileDocumentInfoResponse profileDocumentInfoResponse) {
            this.a = profileDocumentInfoResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.getItem().toProfileDocumentInfoRepo();
        }
    }

    public static final class d<T, R> implements Function<T, R> {
        public final /* synthetic */ AccountResponse a;

        public d(AccountResponse accountResponse) {
            this.a = accountResponse;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a.toProfileRepo();
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return new UpdateFieldAccount();
        }
    }

    public ProfileWebClientStub(long j, @NotNull Context context, @NotNull ProfileWebClientStubInfo profileWebClientStubInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(profileWebClientStubInfo, "profileWebClientStubInfo");
        this.a = j;
        this.b = context;
        this.c = profileWebClientStubInfo;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileV2Repo> getAccountBrief() {
        Observable<ProfileV2Repo> map = Observable.just(Unit.INSTANCE).delay(this.a, TimeUnit.SECONDS).map(new a((AccountV2Response) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.b, this.c.getAccount()), AccountV2Response.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…se.item.toProfileRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileDetailedInfoRepo> getAccountDetailInfo() {
        Observable<ProfileDetailedInfoRepo> map = Observable.just(Unit.INSTANCE).delay(this.a, TimeUnit.SECONDS).map(new b((ProfileDetailedInfoResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.b, this.c.getAccountDetail()), ProfileDetailedInfoResponse.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…ofileDetailedInfoRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileDocumentInfoRepo> getAccountDocument(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "documentEndpoint");
        Context context = this.b;
        Observable<ProfileDocumentInfoRepo> map = Observable.just(Unit.INSTANCE).delay(this.a, TimeUnit.SECONDS).map(new c((ProfileDocumentInfoResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(context, this.c.getDocumentPrefix() + str + this.c.getDocumentPostfix()), ProfileDocumentInfoResponse.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…ofileDocumentInfoRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<ProfileRepo> getAccountInfo() {
        Observable<ProfileRepo> map = Observable.just(Unit.INSTANCE).delay(this.a, TimeUnit.SECONDS).map(new d((AccountResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.b, this.c.getLegacyAccountPath()), AccountResponse.class)));
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de…fileRes.toProfileRepo() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.repository.profile.IProfileWebClient
    @NotNull
    public Observable<UpdateFieldAccount> updateField(@NotNull ProfileUpdateElementRepo profileUpdateElementRepo) {
        Intrinsics.checkParameterIsNotNull(profileUpdateElementRepo, "profileUpdateElementRepo");
        Observable<UpdateFieldAccount> map = Observable.just(Unit.INSTANCE).delay(this.a, TimeUnit.SECONDS).map(e.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "Observable.just(Unit).de… { UpdateFieldAccount() }");
        return map;
    }
}
