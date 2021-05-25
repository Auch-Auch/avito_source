package ru.sravni.android.bankproduct.featuretoggle.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/featuretoggle/config/FeaturesToToggle;", "", "", "newProfile", "Ljava/lang/String;", "creditDeposit", "navigationToDetailedDocument", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FeaturesToToggle {
    public static final FeaturesToToggle INSTANCE = new FeaturesToToggle();
    @NotNull
    public static final String creditDeposit = "APPS-2175-CreditDeposit";
    @NotNull
    public static final String navigationToDetailedDocument = "APPS-2127-ProfileV2.NavigationToDetailedDocument";
    @NotNull
    public static final String newProfile = "APPS-2170-ProfileV2.NewProfile";
}
