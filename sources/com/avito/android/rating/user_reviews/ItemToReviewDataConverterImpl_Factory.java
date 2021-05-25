package com.avito.android.rating.user_reviews;

import dagger.internal.Factory;
public final class ItemToReviewDataConverterImpl_Factory implements Factory<ItemToReviewDataConverterImpl> {

    public static final class a {
        public static final ItemToReviewDataConverterImpl_Factory a = new ItemToReviewDataConverterImpl_Factory();
    }

    public static ItemToReviewDataConverterImpl_Factory create() {
        return a.a;
    }

    public static ItemToReviewDataConverterImpl newInstance() {
        return new ItemToReviewDataConverterImpl();
    }

    @Override // javax.inject.Provider
    public ItemToReviewDataConverterImpl get() {
        return newInstance();
    }
}
