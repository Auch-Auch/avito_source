package ru.sravni.android.bankproduct.domain.util;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.dashboard.entity.RestoreStorageIntentInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/domain/util/IStartBundleRepository;", "", "", "removeStorageInfo", "()V", "Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "getRestoreStorageIntentInfoDomain", "()Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "restoreStorageIntentInfoDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IStartBundleRepository {
    @Nullable
    RestoreStorageIntentInfoDomain getRestoreStorageIntentInfoDomain();

    void removeStorageInfo();
}
