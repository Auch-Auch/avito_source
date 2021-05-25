package com.avito.android.konveyor_adapter_module;

import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory implements Factory<Set<ItemBlueprint<?, ?>>> {

    public static final class a {
        public static final AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory a = new AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory();
    }

    public static AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory create() {
        return a.a;
    }

    public static Set<ItemBlueprint<?, ?>> provideItemBlueprints$konveyor_release() {
        return (Set) Preconditions.checkNotNullFromProvides(AdapterModule.provideItemBlueprints$konveyor_release());
    }

    @Override // javax.inject.Provider
    public Set<ItemBlueprint<?, ?>> get() {
        return provideItemBlueprints$konveyor_release();
    }
}
