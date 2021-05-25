package com.avito.android.remote.model;

import androidx.annotation.DrawableRes;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u001b\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/HighDemandIconName;", "", "", "iconResId", "I", "getIconResId", "()I", "", "networkName", "Ljava/lang/String;", "getNetworkName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "Companion", "HIGH_DEMAND_20", "HIGH_DEMAND_24", "tariff_release"}, k = 1, mv = {1, 4, 2})
public enum HighDemandIconName {
    HIGH_DEMAND_20("TariffHighDemand20", R.drawable.ic_high_demand_20),
    HIGH_DEMAND_24("TariffHighDemand24", R.drawable.ic_high_demand_24);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int iconResId;
    @NotNull
    private final String networkName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/HighDemandIconName$Companion;", "", "", "networkName", "Lcom/avito/android/remote/model/HighDemandIconName;", "getByNetworkName", "(Ljava/lang/String;)Lcom/avito/android/remote/model/HighDemandIconName;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HighDemandIconName getByNetworkName(@NotNull String str) {
            HighDemandIconName highDemandIconName;
            Intrinsics.checkNotNullParameter(str, "networkName");
            HighDemandIconName[] values = HighDemandIconName.values();
            int i = 0;
            while (true) {
                if (i >= 2) {
                    highDemandIconName = null;
                    break;
                }
                highDemandIconName = values[i];
                if (Intrinsics.areEqual(highDemandIconName.getNetworkName(), str)) {
                    break;
                }
                i++;
            }
            return highDemandIconName != null ? highDemandIconName : HighDemandIconName.HIGH_DEMAND_24;
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    private HighDemandIconName(String str, @DrawableRes int i) {
        this.networkName = str;
        this.iconResId = i;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    @NotNull
    public final String getNetworkName() {
        return this.networkName;
    }
}
