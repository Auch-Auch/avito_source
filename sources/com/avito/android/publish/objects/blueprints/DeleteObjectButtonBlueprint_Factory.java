package com.avito.android.publish.objects.blueprints;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeleteObjectButtonBlueprint_Factory implements Factory<DeleteObjectButtonBlueprint> {
    public final Provider<DeleteObjectButtonItemPresenter> a;

    public DeleteObjectButtonBlueprint_Factory(Provider<DeleteObjectButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static DeleteObjectButtonBlueprint_Factory create(Provider<DeleteObjectButtonItemPresenter> provider) {
        return new DeleteObjectButtonBlueprint_Factory(provider);
    }

    public static DeleteObjectButtonBlueprint newInstance(DeleteObjectButtonItemPresenter deleteObjectButtonItemPresenter) {
        return new DeleteObjectButtonBlueprint(deleteObjectButtonItemPresenter);
    }

    @Override // javax.inject.Provider
    public DeleteObjectButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
