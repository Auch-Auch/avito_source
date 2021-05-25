package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
@Nullsafe(Nullsafe.Mode.STRICT)
public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = new c();
    public static final Supplier<Boolean> BOOLEAN_TRUE = new b();

    public static class a implements Supplier<T> {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // com.facebook.common.internal.Supplier
        public T get() {
            return (T) this.a;
        }
    }

    public static class b implements Supplier<Boolean> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public /* bridge */ /* synthetic */ Boolean get() {
            return Boolean.TRUE;
        }
    }

    public static class c implements Supplier<Boolean> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public /* bridge */ /* synthetic */ Boolean get() {
            return Boolean.FALSE;
        }
    }

    public static <T> Supplier<T> of(T t) {
        return new a(t);
    }
}
