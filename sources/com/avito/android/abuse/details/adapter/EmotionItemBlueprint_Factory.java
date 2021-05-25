package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmotionItemBlueprint_Factory implements Factory<EmotionItemBlueprint> {
    public final Provider<EmotionItemPresenter> a;

    public EmotionItemBlueprint_Factory(Provider<EmotionItemPresenter> provider) {
        this.a = provider;
    }

    public static EmotionItemBlueprint_Factory create(Provider<EmotionItemPresenter> provider) {
        return new EmotionItemBlueprint_Factory(provider);
    }

    public static EmotionItemBlueprint newInstance(EmotionItemPresenter emotionItemPresenter) {
        return new EmotionItemBlueprint(emotionItemPresenter);
    }

    @Override // javax.inject.Provider
    public EmotionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
