package ru.sravni.android.bankproduct.repository.featuretoggle;

import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterRepository;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/repository/featuretoggle/FeatureToggleRouterRepository;", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterRepository;", "", "featureName", "", "featureIsEnabled", "(Ljava/lang/String;)Z", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "featuresMap", "", "initValues", "<init>", "(Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FeatureToggleRouterRepository implements IFeatureToggleRouterRepository {
    public final Map<String, Boolean> a;

    public FeatureToggleRouterRepository(@NotNull Map<String, Boolean> map) {
        Intrinsics.checkParameterIsNotNull(map, "initValues");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        linkedHashMap.putAll(map);
    }

    @Override // ru.sravni.android.bankproduct.featuretoggle.IFeatureToggleRouter
    public boolean featureIsEnabled(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "featureName");
        return Intrinsics.areEqual(this.a.get(str), Boolean.TRUE);
    }
}
