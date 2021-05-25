package com.avito.android.blueprints.radiogroup;

import dagger.internal.Factory;
public final class RadioGroupSelectItemPresenterImpl_Factory implements Factory<RadioGroupSelectItemPresenterImpl> {

    public static final class a {
        public static final RadioGroupSelectItemPresenterImpl_Factory a = new RadioGroupSelectItemPresenterImpl_Factory();
    }

    public static RadioGroupSelectItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static RadioGroupSelectItemPresenterImpl newInstance() {
        return new RadioGroupSelectItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public RadioGroupSelectItemPresenterImpl get() {
        return newInstance();
    }
}
