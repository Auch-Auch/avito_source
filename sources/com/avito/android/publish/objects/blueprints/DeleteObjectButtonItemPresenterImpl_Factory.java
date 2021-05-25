package com.avito.android.publish.objects.blueprints;

import dagger.internal.Factory;
public final class DeleteObjectButtonItemPresenterImpl_Factory implements Factory<DeleteObjectButtonItemPresenterImpl> {

    public static final class a {
        public static final DeleteObjectButtonItemPresenterImpl_Factory a = new DeleteObjectButtonItemPresenterImpl_Factory();
    }

    public static DeleteObjectButtonItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static DeleteObjectButtonItemPresenterImpl newInstance() {
        return new DeleteObjectButtonItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DeleteObjectButtonItemPresenterImpl get() {
        return newInstance();
    }
}
