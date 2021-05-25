package hu.akarnokd.rxjava2.util;

import io.reactivex.functions.BooleanSupplier;
public enum AlwaysFalseBooleanSupplier implements BooleanSupplier {
    INSTANCE;

    @Override // io.reactivex.functions.BooleanSupplier
    public boolean getAsBoolean() throws Exception {
        return false;
    }
}
