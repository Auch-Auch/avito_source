package com.avito.android.rating.details;

import dagger.internal.Factory;
public final class ReviewReplyResultConverterImpl_Factory implements Factory<ReviewReplyResultConverterImpl> {

    public static final class a {
        public static final ReviewReplyResultConverterImpl_Factory a = new ReviewReplyResultConverterImpl_Factory();
    }

    public static ReviewReplyResultConverterImpl_Factory create() {
        return a.a;
    }

    public static ReviewReplyResultConverterImpl newInstance() {
        return new ReviewReplyResultConverterImpl();
    }

    @Override // javax.inject.Provider
    public ReviewReplyResultConverterImpl get() {
        return newInstance();
    }
}
