package com.avito.android.rating.publish.deal_stage.adapter.stage;

import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class StageItemPresenterImpl_Factory implements Factory<StageItemPresenterImpl> {
    public final Provider<Consumer<DealStageItem>> a;

    public StageItemPresenterImpl_Factory(Provider<Consumer<DealStageItem>> provider) {
        this.a = provider;
    }

    public static StageItemPresenterImpl_Factory create(Provider<Consumer<DealStageItem>> provider) {
        return new StageItemPresenterImpl_Factory(provider);
    }

    public static StageItemPresenterImpl newInstance(Consumer<DealStageItem> consumer) {
        return new StageItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public StageItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
