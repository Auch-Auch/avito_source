package com.avito.android.publish.slots.infomation.item;

import dagger.internal.Factory;
public final class DisclaimerItemPresenter_Factory implements Factory<DisclaimerItemPresenter> {

    public static final class a {
        public static final DisclaimerItemPresenter_Factory a = new DisclaimerItemPresenter_Factory();
    }

    public static DisclaimerItemPresenter_Factory create() {
        return a.a;
    }

    public static DisclaimerItemPresenter newInstance() {
        return new DisclaimerItemPresenter();
    }

    @Override // javax.inject.Provider
    public DisclaimerItemPresenter get() {
        return newInstance();
    }
}
