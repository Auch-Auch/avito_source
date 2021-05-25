package ru.sravni.android.bankproduct.network.profile.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileUpdateElementRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "Lru/sravni/android/bankproduct/network/profile/request/UpdateAccountElementRequest;", "toUpdateAccountElementRequest", "(Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;)Lru/sravni/android/bankproduct/network/profile/request/UpdateAccountElementRequest;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class UpdateAccountElementRequestKt {
    @NotNull
    public static final UpdateAccountElementRequest toUpdateAccountElementRequest(@NotNull ProfileUpdateElementRepo profileUpdateElementRepo) {
        Intrinsics.checkParameterIsNotNull(profileUpdateElementRepo, "$this$toUpdateAccountElementRequest");
        return new UpdateAccountElementRequest(profileUpdateElementRepo.getNewValue(), profileUpdateElementRepo.getOldValue(), profileUpdateElementRepo.getPath());
    }
}
