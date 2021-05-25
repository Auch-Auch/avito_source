package com.avito.android.abuse.details.adapter;

import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CommentItemPresenterImpl_Factory implements Factory<CommentItemPresenterImpl> {
    public final Provider<PublishRelay<AbuseField>> a;

    public CommentItemPresenterImpl_Factory(Provider<PublishRelay<AbuseField>> provider) {
        this.a = provider;
    }

    public static CommentItemPresenterImpl_Factory create(Provider<PublishRelay<AbuseField>> provider) {
        return new CommentItemPresenterImpl_Factory(provider);
    }

    public static CommentItemPresenterImpl newInstance(PublishRelay<AbuseField> publishRelay) {
        return new CommentItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public CommentItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
