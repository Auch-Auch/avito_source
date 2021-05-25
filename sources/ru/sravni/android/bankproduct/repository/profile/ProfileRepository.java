package ru.sravni.android.bankproduct.repository.profile;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.profile.IProfileRepository;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateAccountElementDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileV2Domain;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileUpdateElementRepoKt;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDetailedInfoRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDocumentInfoRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileV2Repo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/ProfileRepository;", "Lru/sravni/android/bankproduct/domain/profile/IProfileRepository;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "getAccountInfo", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;", "updateAccountElementDomain", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateFieldAccount;", "updateFieldAccount", "(Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain;", "getAccountBrief", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "getAccountDetailInfo", "", "documentID", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "getAccountDocument", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/profile/IProfileWebClient;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/profile/IProfileWebClient;", "profileWebClient", "<init>", "(Lru/sravni/android/bankproduct/repository/profile/IProfileWebClient;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileRepository implements IProfileRepository {
    public final IProfileWebClient a;

    public static final class a<T, R> implements Function<T, R> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ProfileV2Repo profileV2Repo = (ProfileV2Repo) obj;
            Intrinsics.checkParameterIsNotNull(profileV2Repo, "it");
            return profileV2Repo.toProfileDomain();
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ProfileDetailedInfoRepo profileDetailedInfoRepo = (ProfileDetailedInfoRepo) obj;
            Intrinsics.checkParameterIsNotNull(profileDetailedInfoRepo, "it");
            return profileDetailedInfoRepo.toProfileDetailedInfoDomain();
        }
    }

    public static final class c<T, R> implements Function<T, R> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ProfileDocumentInfoRepo profileDocumentInfoRepo = (ProfileDocumentInfoRepo) obj;
            Intrinsics.checkParameterIsNotNull(profileDocumentInfoRepo, "it");
            return profileDocumentInfoRepo.toProfileDocumentInfoDomain();
        }
    }

    public static final class d<T, R> implements Function<T, R> {
        public static final d a = new d();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ProfileRepo profileRepo = (ProfileRepo) obj;
            Intrinsics.checkParameterIsNotNull(profileRepo, "it");
            return profileRepo.toDomain();
        }
    }

    public ProfileRepository(@NotNull IProfileWebClient iProfileWebClient) {
        Intrinsics.checkParameterIsNotNull(iProfileWebClient, "profileWebClient");
        this.a = iProfileWebClient;
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileRepository
    @NotNull
    public Observable<ProfileV2Domain> getAccountBrief() {
        Observable<R> map = this.a.getAccountBrief().map(a.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "profileWebClient.getAcco… { it.toProfileDomain() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileRepository
    @NotNull
    public Observable<ProfileDetailedInfoDomain> getAccountDetailInfo() {
        Observable<R> map = this.a.getAccountDetailInfo().map(b.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "profileWebClient.getAcco…ileDetailedInfoDomain() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileRepository
    @NotNull
    public Observable<ProfileDocumentInfoDomain> getAccountDocument(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "documentID");
        Observable<R> map = this.a.getAccountDocument(str).map(c.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "profileWebClient.getAcco…ileDocumentInfoDomain() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileRepository
    @NotNull
    public Observable<ProfileDomain> getAccountInfo() {
        Observable<R> map = this.a.getAccountInfo().map(d.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "profileWebClient.getAcco…o().map { it.toDomain() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.domain.profile.IProfileRepository
    @NotNull
    public Observable<UpdateFieldAccount> updateFieldAccount(@NotNull UpdateAccountElementDomain updateAccountElementDomain) {
        Intrinsics.checkParameterIsNotNull(updateAccountElementDomain, "updateAccountElementDomain");
        return this.a.updateField(ProfileUpdateElementRepoKt.toProfileUpdateElementRepo(updateAccountElementDomain));
    }
}
