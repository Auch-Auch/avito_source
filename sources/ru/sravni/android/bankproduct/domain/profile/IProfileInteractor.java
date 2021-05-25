package ru.sravni.android.bankproduct.domain.profile;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateAccountElementDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileV2Domain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\n¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/IProfileInteractor;", "", "", "documentID", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "loadDocument", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain;", "getProfile", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "getProfileDetailInfo", "", "logout", "()V", "refreshProfileData", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;", "updateAccountElementDomain", "Lru/sravni/android/bankproduct/domain/profile/entity/UpdateFieldAccount;", "updateFieldAccount", "(Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "getProfileDataChannel", "profileDataChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProfileInteractor {
    @NotNull
    Observable<ProfileV2Domain> getProfile();

    @NotNull
    Observable<DataContainer<ProfileDomain>> getProfileDataChannel();

    @NotNull
    Observable<ProfileDetailedInfoDomain> getProfileDetailInfo();

    @NotNull
    Observable<ProfileDocumentInfoDomain> loadDocument(@NotNull String str);

    void logout();

    void refreshProfileData();

    @NotNull
    Observable<UpdateFieldAccount> updateFieldAccount(@NotNull UpdateAccountElementDomain updateAccountElementDomain);
}
