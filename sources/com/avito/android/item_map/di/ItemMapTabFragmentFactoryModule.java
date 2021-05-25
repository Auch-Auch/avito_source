package com.avito.android.item_map.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.item_map.ItemMapFragment;
import com.avito.android.item_map.ItemMapFragmentData;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/item_map/di/ItemMapTabFragmentFactoryModule;", "", "", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "provideDataTabFragmentFactories", "()Ljava/util/Set;", "<init>", "()V", "item-map_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ItemMapTabFragmentFactoryModule {
    @NotNull
    public static final ItemMapTabFragmentFactoryModule INSTANCE = new ItemMapTabFragmentFactoryModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return x.setOf(new DataTabFragmentFactory() { // from class: com.avito.android.item_map.di.ItemMapTabFragmentFactoryModule$provideDataTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = ItemMapFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return ItemMapFragment.Companion.newInstance(((ItemMapFragmentData) data).getArguments());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        });
    }
}
