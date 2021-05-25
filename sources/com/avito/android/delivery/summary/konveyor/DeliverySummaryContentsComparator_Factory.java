package com.avito.android.delivery.summary.konveyor;

import dagger.internal.Factory;
public final class DeliverySummaryContentsComparator_Factory implements Factory<DeliverySummaryContentsComparator> {

    public static final class a {
        public static final DeliverySummaryContentsComparator_Factory a = new DeliverySummaryContentsComparator_Factory();
    }

    public static DeliverySummaryContentsComparator_Factory create() {
        return a.a;
    }

    public static DeliverySummaryContentsComparator newInstance() {
        return new DeliverySummaryContentsComparator();
    }

    @Override // javax.inject.Provider
    public DeliverySummaryContentsComparator get() {
        return newInstance();
    }
}
