package com.avito.android.user_stats.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.user_stats.UserStatsFragmentKt;
import com.avito.android.user_stats.navigation.UserStatsFragmentData;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabFragmentFactoryModule;", "", "", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "provideDataTabFragmentFactories", "()Ljava/util/Set;", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserStatsTabFragmentFactoryModule {
    @NotNull
    public static final UserStatsTabFragmentFactoryModule INSTANCE = new UserStatsTabFragmentFactoryModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return x.setOf(new DataTabFragmentFactory() { // from class: com.avito.android.user_stats.di.UserStatsTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = UserStatsFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                UserStatsFragmentData userStatsFragmentData = (UserStatsFragmentData) data;
                return UserStatsFragmentKt.createUserStatsFragment();
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        });
    }
}
