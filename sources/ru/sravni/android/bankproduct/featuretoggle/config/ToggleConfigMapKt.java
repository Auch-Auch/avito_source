package ru.sravni.android.bankproduct.featuretoggle.config;

import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\"%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getFeatureToggleConfigMap", "()Ljava/util/Map;", "featureToggleConfigMap", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ToggleConfigMapKt {
    @NotNull
    public static final Map<String, Boolean> a;

    static {
        Boolean bool = Boolean.FALSE;
        a = r.mapOf(TuplesKt.to(FeaturesToToggle.creditDeposit, Boolean.TRUE), TuplesKt.to(FeaturesToToggle.navigationToDetailedDocument, bool), TuplesKt.to(FeaturesToToggle.newProfile, bool));
    }

    @NotNull
    public static final Map<String, Boolean> getFeatureToggleConfigMap() {
        return a;
    }
}
