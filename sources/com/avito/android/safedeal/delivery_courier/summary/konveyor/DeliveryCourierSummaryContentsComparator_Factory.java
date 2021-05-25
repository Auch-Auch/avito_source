package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import dagger.internal.Factory;
public final class DeliveryCourierSummaryContentsComparator_Factory implements Factory<DeliveryCourierSummaryContentsComparator> {

    public static final class a {
        public static final DeliveryCourierSummaryContentsComparator_Factory a = new DeliveryCourierSummaryContentsComparator_Factory();
    }

    public static DeliveryCourierSummaryContentsComparator_Factory create() {
        return a.a;
    }

    public static DeliveryCourierSummaryContentsComparator newInstance() {
        return new DeliveryCourierSummaryContentsComparator();
    }

    @Override // javax.inject.Provider
    public DeliveryCourierSummaryContentsComparator get() {
        return newInstance();
    }
}
