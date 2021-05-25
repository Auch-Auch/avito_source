package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CommentItemBlueprint_Factory implements Factory<CommentItemBlueprint> {
    public final Provider<CommentItemPresenter> a;

    public CommentItemBlueprint_Factory(Provider<CommentItemPresenter> provider) {
        this.a = provider;
    }

    public static CommentItemBlueprint_Factory create(Provider<CommentItemPresenter> provider) {
        return new CommentItemBlueprint_Factory(provider);
    }

    public static CommentItemBlueprint newInstance(CommentItemPresenter commentItemPresenter) {
        return new CommentItemBlueprint(commentItemPresenter);
    }

    @Override // javax.inject.Provider
    public CommentItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
