package com.avito.android.search.map.di;

import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class SearchMapModule_ProvideViewedItemsTabTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> {

    public static final class a {
        public static final SearchMapModule_ProvideViewedItemsTabTestGroupFactory a = new SearchMapModule_ProvideViewedItemsTabTestGroupFactory();
    }

    public static SearchMapModule_ProvideViewedItemsTabTestGroupFactory create() {
        return a.a;
    }

    @Nullable
    public static SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> provideViewedItemsTabTestGroup() {
        return SearchMapModule.provideViewedItemsTabTestGroup();
    }

    @Override // javax.inject.Provider
    @Nullable
    public SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> get() {
        return provideViewedItemsTabTestGroup();
    }
}
