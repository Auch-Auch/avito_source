package com.avito.android.analytics.bivrost;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorageImpl;", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "", "value", "getStatisticsTooltipVisible", "()Z", "setStatisticsTooltipVisible", "(Z)V", "statisticsTooltipVisible", "getStatisticsBannerVisible", "setStatisticsBannerVisible", "statisticsBannerVisible", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class BivrostTutorialSessionStorageImpl implements BivrostTutorialSessionStorage {
    public final Preferences a;

    public BivrostTutorialSessionStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage
    public boolean getStatisticsBannerVisible() {
        return this.a.getBoolean("banner_visibility", true);
    }

    @Override // com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage
    public boolean getStatisticsTooltipVisible() {
        return this.a.getBoolean("tooltip_visibility", true);
    }

    @Override // com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage
    public void setStatisticsBannerVisible(boolean z) {
        this.a.getSharedPreferences().edit().putBoolean("banner_visibility", z).apply();
    }

    @Override // com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage
    public void setStatisticsTooltipVisible(boolean z) {
        this.a.getSharedPreferences().edit().putBoolean("tooltip_visibility", z).apply();
    }
}
