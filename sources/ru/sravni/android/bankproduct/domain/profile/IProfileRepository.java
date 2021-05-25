package ru.sravni.android.bankproduct.domain.profile;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateAccountElementDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileV2Domain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H&¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/IProfileRepository;", "", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "getAccountInfo", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;", "updateAccountElementDomain", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateFieldAccount;", "updateFieldAccount", "(Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain;", "getAccountBrief", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "getAccountDetailInfo", "", "documentID", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "getAccountDocument", "(Ljava/lang/String;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProfileRepository {
    @NotNull
    Observable<ProfileV2Domain> getAccountBrief();

    @NotNull
    Observable<ProfileDetailedInfoDomain> getAccountDetailInfo();

    @NotNull
    Observable<ProfileDocumentInfoDomain> getAccountDocument(@NotNull String str);

    @NotNull
    Observable<ProfileDomain> getAccountInfo();

    @NotNull
    Observable<UpdateFieldAccount> updateFieldAccount(@NotNull UpdateAccountElementDomain updateAccountElementDomain);
}
