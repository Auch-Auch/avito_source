package com.avito.android.serp.diff_calculator;

import com.avito.android.serp.diff_calculator.DiffCalculator;
import dagger.internal.Factory;
public final class DiffCalculator_Impl_Factory implements Factory<DiffCalculator.Impl> {

    public static final class a {
        public static final DiffCalculator_Impl_Factory a = new DiffCalculator_Impl_Factory();
    }

    public static DiffCalculator_Impl_Factory create() {
        return a.a;
    }

    public static DiffCalculator.Impl newInstance() {
        return new DiffCalculator.Impl();
    }

    @Override // javax.inject.Provider
    public DiffCalculator.Impl get() {
        return newInstance();
    }
}
