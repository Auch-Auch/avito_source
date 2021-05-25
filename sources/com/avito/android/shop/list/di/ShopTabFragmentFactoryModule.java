package com.avito.android.shop.list.di;

import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.list.ShopListFragment;
import com.avito.android.shop.list.ShopListFragmentData;
import com.avito.android.ui.fragments.TabBaseFragment;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/shop/list/di/ShopTabFragmentFactoryModule;", "", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsTabTestGroup", "", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "provideDataTabFragmentFactories", "(Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)Ljava/util/Set;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ShopTabFragmentFactoryModule {
    @NotNull
    public static final ShopTabFragmentFactoryModule INSTANCE = new ShopTabFragmentFactoryModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> provideDataTabFragmentFactories(@NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "userAdvertsTabTestGroup");
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return x.setOf(new DataTabFragmentFactory(userAdvertsTabTestGroup) { // from class: com.avito.android.shop.list.di.ShopTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = ShopListFragmentData.class;
            public final /* synthetic */ UserAdvertsTabTestGroup b;

            {
                this.b = r1;
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                NavigationTabSetItem navigationTabSetItem;
                Intrinsics.checkNotNullParameter(data, "data");
                ShopListFragmentData shopListFragmentData = (ShopListFragmentData) data;
                ShopListFragment.Factory factory = new ShopListFragment.Factory();
                ShopsSearchParameters params = shopListFragmentData.getParams();
                String locationName = shopListFragmentData.getLocationName();
                if (this.b.isTest()) {
                    navigationTabSetItem = shopListFragmentData.getTabInProfileTest();
                } else {
                    navigationTabSetItem = shopListFragmentData.getTabInControl();
                }
                return factory.createFragment(params, locationName, navigationTabSetItem);
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        });
    }
}
