package com.avito.android.advert.item.questionnaire;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class QuestionnaireStorageImpl_Factory implements Factory<QuestionnaireStorageImpl> {
    public final Provider<Preferences> a;

    public QuestionnaireStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static QuestionnaireStorageImpl_Factory create(Provider<Preferences> provider) {
        return new QuestionnaireStorageImpl_Factory(provider);
    }

    public static QuestionnaireStorageImpl newInstance(Preferences preferences) {
        return new QuestionnaireStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public QuestionnaireStorageImpl get() {
        return newInstance(this.a.get());
    }
}
