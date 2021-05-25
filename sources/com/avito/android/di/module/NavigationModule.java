package com.avito.android.di.module;

import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.navigation.NavigationTabProviderImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/NavigationModule;", "", "Lcom/avito/android/navigation/NavigationTabProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/navigation/NavigationTabProvider;", "bindNavigationTabProvider", "(Lcom/avito/android/navigation/NavigationTabProviderImpl;)Lcom/avito/android/navigation/NavigationTabProvider;", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface NavigationModule {
    @Binds
    @NotNull
    NavigationTabProvider bindNavigationTabProvider(@NotNull NavigationTabProviderImpl navigationTabProviderImpl);
}
