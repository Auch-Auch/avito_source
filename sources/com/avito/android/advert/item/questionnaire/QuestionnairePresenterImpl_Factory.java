package com.avito.android.advert.item.questionnaire;

import android.os.Bundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class QuestionnairePresenterImpl_Factory implements Factory<QuestionnairePresenterImpl> {
    public final Provider<Bundle> a;
    public final Provider<QuestionnaireStorage> b;

    public QuestionnairePresenterImpl_Factory(Provider<Bundle> provider, Provider<QuestionnaireStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static QuestionnairePresenterImpl_Factory create(Provider<Bundle> provider, Provider<QuestionnaireStorage> provider2) {
        return new QuestionnairePresenterImpl_Factory(provider, provider2);
    }

    public static QuestionnairePresenterImpl newInstance(Bundle bundle, QuestionnaireStorage questionnaireStorage) {
        return new QuestionnairePresenterImpl(bundle, questionnaireStorage);
    }

    @Override // javax.inject.Provider
    public QuestionnairePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
