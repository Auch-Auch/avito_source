package hu.akarnokd.rxjava3.util;

import io.reactivex.rxjava3.functions.BooleanSupplier;
public enum AlwaysTrueBooleanSupplier implements BooleanSupplier {
    INSTANCE;

    @Override // io.reactivex.rxjava3.functions.BooleanSupplier
    public boolean getAsBoolean() throws Exception {
        return true;
    }
}
