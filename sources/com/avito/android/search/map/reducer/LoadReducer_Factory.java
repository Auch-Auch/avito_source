package com.avito.android.search.map.reducer;

import com.avito.android.search.map.view.SerpListResourcesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
public final class LoadReducer_Factory implements Factory<LoadReducer> {
    public final Provider<SerpListResourcesProvider> a;
    public final Provider<ShortcutNavigationItemConverter> b;

    public LoadReducer_Factory(Provider<SerpListResourcesProvider> provider, Provider<ShortcutNavigationItemConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LoadReducer_Factory create(Provider<SerpListResourcesProvider> provider, Provider<ShortcutNavigationItemConverter> provider2) {
        return new LoadReducer_Factory(provider, provider2);
    }

    public static LoadReducer newInstance(SerpListResourcesProvider serpListResourcesProvider, ShortcutNavigationItemConverter shortcutNavigationItemConverter) {
        return new LoadReducer(serpListResourcesProvider, shortcutNavigationItemConverter);
    }

    @Override // javax.inject.Provider
    public LoadReducer get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
