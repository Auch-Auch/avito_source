package com.avito.android.delivery.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RdsOrderCancellationReasonsModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final RdsOrderCancellationReasonsModule_ProvidesScreenContentTypeFactory a = new RdsOrderCancellationReasonsModule_ProvidesScreenContentTypeFactory();
    }

    public static RdsOrderCancellationReasonsModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(RdsOrderCancellationReasonsModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
