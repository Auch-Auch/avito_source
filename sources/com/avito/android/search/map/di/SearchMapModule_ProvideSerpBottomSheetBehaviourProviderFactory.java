package com.avito.android.search.map.di;

import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SearchMapModule_ProvideSerpBottomSheetBehaviourProviderFactory implements Factory<BottomSheetBehaviourEventsProvider> {

    public static final class a {
        public static final SearchMapModule_ProvideSerpBottomSheetBehaviourProviderFactory a = new SearchMapModule_ProvideSerpBottomSheetBehaviourProviderFactory();
    }

    public static SearchMapModule_ProvideSerpBottomSheetBehaviourProviderFactory create() {
        return a.a;
    }

    public static BottomSheetBehaviourEventsProvider provideSerpBottomSheetBehaviourProvider() {
        return (BottomSheetBehaviourEventsProvider) Preconditions.checkNotNullFromProvides(SearchMapModule.provideSerpBottomSheetBehaviourProvider());
    }

    @Override // javax.inject.Provider
    public BottomSheetBehaviourEventsProvider get() {
        return provideSerpBottomSheetBehaviourProvider();
    }
}
