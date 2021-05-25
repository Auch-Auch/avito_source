package com.avito.android.favorite_sellers;

import com.avito.android.remote.model.FavoriteSellersResult;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/favorite_sellers/TabOpenAnalyticsStub;", "Lcom/avito/android/favorite_sellers/TabOpenAnalytics;", "Lcom/avito/android/util/Kundle;", "state", "", "initWithState", "(Lcom/avito/android/util/Kundle;)V", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "visibleToUser", "onVisibilityChanged", "(Z)V", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "result", "setResult", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)V", "reset", "()V", "<init>", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class TabOpenAnalyticsStub implements TabOpenAnalytics {
    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void initWithState(@Nullable Kundle kundle) {
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    @NotNull
    public Kundle onSaveState() {
        return Kundle.Companion.getEMPTY();
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void onVisibilityChanged(boolean z) {
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void reset() {
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void setResult(@Nullable FavoriteSellersResult favoriteSellersResult) {
    }
}
