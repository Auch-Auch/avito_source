package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
@Nullsafe(Nullsafe.Mode.STRICT)
public class AndroidPredicates {

    public static class a implements Predicate<T> {
        @Override // com.facebook.common.internal.Predicate
        public boolean apply(T t) {
            return true;
        }
    }

    public static class b implements Predicate<T> {
        @Override // com.facebook.common.internal.Predicate
        public boolean apply(T t) {
            return false;
        }
    }

    public static <T> Predicate<T> False() {
        return new b();
    }

    public static <T> Predicate<T> True() {
        return new a();
    }
}
