package com.avito.android.search.map.reducer;

import com.avito.android.saved_searches.SavedSearchesPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpReducer_Factory implements Factory<SerpReducer> {
    public final Provider<SavedSearchesPresenter> a;

    public SerpReducer_Factory(Provider<SavedSearchesPresenter> provider) {
        this.a = provider;
    }

    public static SerpReducer_Factory create(Provider<SavedSearchesPresenter> provider) {
        return new SerpReducer_Factory(provider);
    }

    public static SerpReducer newInstance(SavedSearchesPresenter savedSearchesPresenter) {
        return new SerpReducer(savedSearchesPresenter);
    }

    @Override // javax.inject.Provider
    public SerpReducer get() {
        return newInstance(this.a.get());
    }
}
