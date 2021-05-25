package com.avito.android.bundles.vas_union.di;

import com.avito.android.bundles.di.VasBundlesListModule;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemBlueprint;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemPresenter;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemPresenterImpl;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemBlueprint;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemPresenter;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/bundles/vas_union/di/VasUnionListModule;", "", "<init>", "()V", "Declarations", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, VasBundlesListModule.Declarations.class})
public final class VasUnionListModule {
    @NotNull
    public static final VasUnionListModule INSTANCE = new VasUnionListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00102\u0006\u0010\b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/bundles/vas_union/di/VasUnionListModule$Declarations;", "", "Lcom/avito/android/bundles/vas_union/item/union_title/VasUnionTitleItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindTitleBlueprint", "(Lcom/avito/android/bundles/vas_union/item/union_title/VasUnionTitleItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/vas_union/item/union_title/VasUnionTitleItemPresenterImpl;", "presenter", "Lcom/avito/android/bundles/vas_union/item/union_title/VasUnionTitleItemPresenter;", "bindTitlePresenter", "(Lcom/avito/android/bundles/vas_union/item/union_title/VasUnionTitleItemPresenterImpl;)Lcom/avito/android/bundles/vas_union/item/union_title/VasUnionTitleItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemBlueprint;", "bindTabsBlueprint", "(Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTabsPresenter", "(Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemPresenterImpl;", "bindTabsPresenter", "(Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemPresenterImpl;)Lcom/avito/android/bundles/vas_union/item/tabs/TabsItemPresenter;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindTabsBlueprint(@NotNull TabsItemBlueprint tabsItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        TabsItemPresenter bindTabsPresenter(@NotNull TabsItemPresenterImpl tabsItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindTitleBlueprint(@NotNull VasUnionTitleItemBlueprint vasUnionTitleItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        VasUnionTitleItemPresenter bindTitlePresenter(@NotNull VasUnionTitleItemPresenterImpl vasUnionTitleItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTabsPresenter(@NotNull TabsItemPresenter tabsItemPresenter);
    }
}
