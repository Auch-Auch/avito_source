package com.avito.android.rating.publish.deal_stage.adapter.stage;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class StageItemBlueprint_Factory implements Factory<StageItemBlueprint> {
    public final Provider<StageItemPresenter> a;

    public StageItemBlueprint_Factory(Provider<StageItemPresenter> provider) {
        this.a = provider;
    }

    public static StageItemBlueprint_Factory create(Provider<StageItemPresenter> provider) {
        return new StageItemBlueprint_Factory(provider);
    }

    public static StageItemBlueprint newInstance(StageItemPresenter stageItemPresenter) {
        return new StageItemBlueprint(stageItemPresenter);
    }

    @Override // javax.inject.Provider
    public StageItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
