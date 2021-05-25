package hu.akarnokd.rxjava3.util;

import io.reactivex.rxjava3.functions.BiFunction;
public enum BiFunctionSecondIdentity implements BiFunction<Object, Object, Object> {
    INSTANCE;

    public static <T, U> BiFunction<T, U, U> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public Object apply(Object obj, Object obj2) throws Exception {
        return obj2;
    }
}
