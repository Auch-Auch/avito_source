package ru.sravni.android.bankproduct.domain.featuretoggle;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/domain/featuretoggle/FeatureToggleRouterDomain;", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "", "featureName", "", "featureIsEnabled", "(Ljava/lang/String;)Z", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterRepository;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterRepository;", "featureToggleRouterRepository", "<init>", "(Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterRepository;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FeatureToggleRouterDomain implements IFeatureToggleRouterDomain {
    public final IFeatureToggleRouterRepository a;

    public FeatureToggleRouterDomain(@NotNull IFeatureToggleRouterRepository iFeatureToggleRouterRepository) {
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterRepository, "featureToggleRouterRepository");
        this.a = iFeatureToggleRouterRepository;
    }

    @Override // ru.sravni.android.bankproduct.featuretoggle.IFeatureToggleRouter
    public boolean featureIsEnabled(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "featureName");
        return this.a.featureIsEnabled(str);
    }
}
