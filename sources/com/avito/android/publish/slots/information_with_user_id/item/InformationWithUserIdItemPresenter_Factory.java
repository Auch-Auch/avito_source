package com.avito.android.publish.slots.information_with_user_id.item;

import dagger.internal.Factory;
public final class InformationWithUserIdItemPresenter_Factory implements Factory<InformationWithUserIdItemPresenter> {

    public static final class a {
        public static final InformationWithUserIdItemPresenter_Factory a = new InformationWithUserIdItemPresenter_Factory();
    }

    public static InformationWithUserIdItemPresenter_Factory create() {
        return a.a;
    }

    public static InformationWithUserIdItemPresenter newInstance() {
        return new InformationWithUserIdItemPresenter();
    }

    @Override // javax.inject.Provider
    public InformationWithUserIdItemPresenter get() {
        return newInstance();
    }
}
