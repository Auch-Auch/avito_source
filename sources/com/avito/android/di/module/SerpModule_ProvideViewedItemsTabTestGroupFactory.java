package com.avito.android.di.module;

import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class SerpModule_ProvideViewedItemsTabTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> {

    public static final class a {
        public static final SerpModule_ProvideViewedItemsTabTestGroupFactory a = new SerpModule_ProvideViewedItemsTabTestGroupFactory();
    }

    public static SerpModule_ProvideViewedItemsTabTestGroupFactory create() {
        return a.a;
    }

    @Nullable
    public static SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> provideViewedItemsTabTestGroup() {
        return SerpModule.provideViewedItemsTabTestGroup();
    }

    @Override // javax.inject.Provider
    @Nullable
    public SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> get() {
        return provideViewedItemsTabTestGroup();
    }
}
