package ru.sravni.android.bankproduct.repository.profile.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateAccountElementDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "toProfileUpdateElementRepo", "(Lru/sravni/android/bankproduct/domain/profile/entity/UpdateAccountElementDomain;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ProfileUpdateElementRepoKt {
    @NotNull
    public static final ProfileUpdateElementRepo toProfileUpdateElementRepo(@NotNull UpdateAccountElementDomain updateAccountElementDomain) {
        Intrinsics.checkParameterIsNotNull(updateAccountElementDomain, "$this$toProfileUpdateElementRepo");
        return new ProfileUpdateElementRepo(updateAccountElementDomain.getNewValue(), updateAccountElementDomain.getOldValue(), updateAccountElementDomain.getPath());
    }
}
