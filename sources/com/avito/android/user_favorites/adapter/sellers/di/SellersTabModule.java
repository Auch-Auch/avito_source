package com.avito.android.user_favorites.adapter.sellers.di;

import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.di.PerActivity;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.user_favorites.adapter.sellers.SellersTabBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/user_favorites/adapter/sellers/di/SellersTabModule;", "", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "provideTabBlueprint", "()Lcom/avito/android/design/widget/tab/TabBlueprint;", "<init>", "()V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SellersTabModule {
    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final TabBlueprint<? extends FavoritesTab> provideTabBlueprint() {
        return new SellersTabBlueprint();
    }
}
