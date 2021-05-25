package com.avito.android.konveyor_adapter_module;

import a2.b.a.a.a;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.ElementsIntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000e\u001a\u00020\u00022\u0019\u0010\u000b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t¢\u0006\u0002\b\n0\bH\u0001¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0011¢\u0006\u0002\b\n0\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\bH\u0001¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/konveyor_adapter_module/AdapterModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$konveyor_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$konveyor_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "binder", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "provideViewHolderBuilder$konveyor_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "provideViewHolderBuilder", "provideItemBlueprints$konveyor_release", "()Ljava/util/Set;", "provideItemBlueprints", "<init>", "()V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AdapterModule {
    @NotNull
    public static final AdapterModule INSTANCE = new AdapterModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AdapterPresenter provideAdapterPresenter$konveyor_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ItemBinder provideItemBinder$konveyor_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @JvmStatic
    @Reusable
    @ElementsIntoSet
    @NotNull
    public static final Set<ItemBlueprint<?, ?>> provideItemBlueprints$konveyor_release() {
        return y.emptySet();
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ViewHolderBuilder<BaseViewHolder> provideViewHolderBuilder$konveyor_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "binder");
        return itemBinder;
    }
}
