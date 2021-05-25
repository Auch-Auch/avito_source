package com.avito.android.stories.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class StoriesItemBlueprint_Factory implements Factory<StoriesItemBlueprint> {
    public final Provider<StoriesItemPresenter> a;

    public StoriesItemBlueprint_Factory(Provider<StoriesItemPresenter> provider) {
        this.a = provider;
    }

    public static StoriesItemBlueprint_Factory create(Provider<StoriesItemPresenter> provider) {
        return new StoriesItemBlueprint_Factory(provider);
    }

    public static StoriesItemBlueprint newInstance(StoriesItemPresenter storiesItemPresenter) {
        return new StoriesItemBlueprint(storiesItemPresenter);
    }

    @Override // javax.inject.Provider
    public StoriesItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
