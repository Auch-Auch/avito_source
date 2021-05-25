package com.avito.android.search.map.di;

import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SearchMapModule_ProvidePinAdvertsBottomSheetBehaviourProviderFactory implements Factory<BottomSheetBehaviourEventsProvider> {

    public static final class a {
        public static final SearchMapModule_ProvidePinAdvertsBottomSheetBehaviourProviderFactory a = new SearchMapModule_ProvidePinAdvertsBottomSheetBehaviourProviderFactory();
    }

    public static SearchMapModule_ProvidePinAdvertsBottomSheetBehaviourProviderFactory create() {
        return a.a;
    }

    public static BottomSheetBehaviourEventsProvider providePinAdvertsBottomSheetBehaviourProvider() {
        return (BottomSheetBehaviourEventsProvider) Preconditions.checkNotNullFromProvides(SearchMapModule.providePinAdvertsBottomSheetBehaviourProvider());
    }

    @Override // javax.inject.Provider
    public BottomSheetBehaviourEventsProvider get() {
        return providePinAdvertsBottomSheetBehaviourProvider();
    }
}
