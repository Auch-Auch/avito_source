package hu.akarnokd.rxjava2.functions;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.HashSet;
public final class FunctionTagging {
    public static volatile boolean a;

    public static final class FunctionTaggingException extends RuntimeException {
        private static final long serialVersionUID = -8382312975142579020L;

        public FunctionTaggingException(String str) {
            super(str);
        }

        public Throwable appendLast(Throwable th) {
            HashSet hashSet = new HashSet();
            Throwable th2 = th;
            while (th2.getCause() != null) {
                if (hashSet.add(th2)) {
                    th2 = th2.getCause();
                } else {
                    RxJavaPlugins.onError(new CompositeException(th, this));
                    return th;
                }
            }
            try {
                th2.initCause(this);
            } catch (Throwable unused) {
                RxJavaPlugins.onError(new CompositeException(th, this));
            }
            return th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a<T1, T2, R> implements BiFunction<T1, T2, R> {
        public final BiFunction<T1, T2, R> a;
        public final String b;

        public a(BiFunction<T1, T2, R> biFunction, String str) {
            this.a = biFunction;
            this.b = str;
        }

        @Override // io.reactivex.functions.BiFunction
        public R apply(T1 t1, T2 t2) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 != null) {
                try {
                    R apply = this.a.apply(t1, t2);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L2 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L2.append(this.b);
                    throw new NullPointerException(L2.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L3 = a2.b.a.a.a.L("t2 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            }
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T1, T2, T3, R> {
        public final Function3<T1, T2, T3, R> a;
        public final String b;

        public b(Function3<T1, T2, T3, R> function3, String str) {
            this.a = function3;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function3
        public R apply(T1 t1, T2 t2, T3 t3) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L3 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L3.append(this.b);
                    throw new NullPointerException(L3.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L4 = a2.b.a.a.a.L("t3 is null, tag = ");
                L4.append(this.b);
                throw new NullPointerException(L4.toString());
            }
        }
    }

    public static final class c<T1, T2, T3, T4, R> implements Function4<T1, T2, T3, T4, R> {
        public final Function4<T1, T2, T3, T4, R> a;
        public final String b;

        public c(Function4<T1, T2, T3, T4, R> function4, String str) {
            this.a = function4;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function4
        public R apply(T1 t1, T2 t2, T3 t3, T4 t4) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 == null) {
                StringBuilder L3 = a2.b.a.a.a.L("t3 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            } else if (t4 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3, t4);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L4 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L4.append(this.b);
                    throw new NullPointerException(L4.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L5 = a2.b.a.a.a.L("t4 is null, tag = ");
                L5.append(this.b);
                throw new NullPointerException(L5.toString());
            }
        }
    }

    public static final class d<T1, T2, T3, T4, T5, R> implements Function5<T1, T2, T3, T4, T5, R> {
        public final Function5<T1, T2, T3, T4, T5, R> a;
        public final String b;

        public d(Function5<T1, T2, T3, T4, T5, R> function5, String str) {
            this.a = function5;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function5
        public R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 == null) {
                StringBuilder L3 = a2.b.a.a.a.L("t3 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            } else if (t4 == null) {
                StringBuilder L4 = a2.b.a.a.a.L("t4 is null, tag = ");
                L4.append(this.b);
                throw new NullPointerException(L4.toString());
            } else if (t5 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3, t4, t5);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L5 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L5.append(this.b);
                    throw new NullPointerException(L5.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L6 = a2.b.a.a.a.L("t5 is null, tag = ");
                L6.append(this.b);
                throw new NullPointerException(L6.toString());
            }
        }
    }

    public static final class e<T1, T2, T3, T4, T5, T6, R> implements Function6<T1, T2, T3, T4, T5, T6, R> {
        public final Function6<T1, T2, T3, T4, T5, T6, R> a;
        public final String b;

        public e(Function6<T1, T2, T3, T4, T5, T6, R> function6, String str) {
            this.a = function6;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function6
        public R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 == null) {
                StringBuilder L3 = a2.b.a.a.a.L("t3 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            } else if (t4 == null) {
                StringBuilder L4 = a2.b.a.a.a.L("t4 is null, tag = ");
                L4.append(this.b);
                throw new NullPointerException(L4.toString());
            } else if (t5 == null) {
                StringBuilder L5 = a2.b.a.a.a.L("t5 is null, tag = ");
                L5.append(this.b);
                throw new NullPointerException(L5.toString());
            } else if (t62 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3, t4, t5, t62);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L6 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L6.append(this.b);
                    throw new NullPointerException(L6.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L7 = a2.b.a.a.a.L("t6 is null, tag = ");
                L7.append(this.b);
                throw new NullPointerException(L7.toString());
            }
        }
    }

    public static final class f<T1, T2, T3, T4, T5, T6, T7, R> implements Function7<T1, T2, T3, T4, T5, T6, T7, R> {
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> a;
        public final String b;

        public f(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7, String str) {
            this.a = function7;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function7
        public R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 == null) {
                StringBuilder L3 = a2.b.a.a.a.L("t3 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            } else if (t4 == null) {
                StringBuilder L4 = a2.b.a.a.a.L("t4 is null, tag = ");
                L4.append(this.b);
                throw new NullPointerException(L4.toString());
            } else if (t5 == null) {
                StringBuilder L5 = a2.b.a.a.a.L("t5 is null, tag = ");
                L5.append(this.b);
                throw new NullPointerException(L5.toString());
            } else if (t62 == null) {
                StringBuilder L6 = a2.b.a.a.a.L("t6 is null, tag = ");
                L6.append(this.b);
                throw new NullPointerException(L6.toString());
            } else if (t7 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3, t4, t5, t62, t7);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L7 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L7.append(this.b);
                    throw new NullPointerException(L7.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L8 = a2.b.a.a.a.L("t7 is null, tag = ");
                L8.append(this.b);
                throw new NullPointerException(L8.toString());
            }
        }
    }

    public static final class g<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> a;
        public final String b;

        public g(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8, String str) {
            this.a = function8;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function8
        public R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 == null) {
                StringBuilder L3 = a2.b.a.a.a.L("t3 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            } else if (t4 == null) {
                StringBuilder L4 = a2.b.a.a.a.L("t4 is null, tag = ");
                L4.append(this.b);
                throw new NullPointerException(L4.toString());
            } else if (t5 == null) {
                StringBuilder L5 = a2.b.a.a.a.L("t5 is null, tag = ");
                L5.append(this.b);
                throw new NullPointerException(L5.toString());
            } else if (t62 == null) {
                StringBuilder L6 = a2.b.a.a.a.L("t6 is null, tag = ");
                L6.append(this.b);
                throw new NullPointerException(L6.toString());
            } else if (t7 == null) {
                StringBuilder L7 = a2.b.a.a.a.L("t7 is null, tag = ");
                L7.append(this.b);
                throw new NullPointerException(L7.toString());
            } else if (t8 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3, t4, t5, t62, t7, t8);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L8 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L8.append(this.b);
                    throw new NullPointerException(L8.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L9 = a2.b.a.a.a.L("t8 is null, tag = ");
                L9.append(this.b);
                throw new NullPointerException(L9.toString());
            }
        }
    }

    public static final class h<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;
        public final String b;

        public h(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9, String str) {
            this.a = function9;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function9
        public R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8, T9 t9) throws Exception {
            if (t1 == null) {
                StringBuilder L = a2.b.a.a.a.L("t1 is null, tag = ");
                L.append(this.b);
                throw new NullPointerException(L.toString());
            } else if (t2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("t2 is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            } else if (t3 == null) {
                StringBuilder L3 = a2.b.a.a.a.L("t3 is null, tag = ");
                L3.append(this.b);
                throw new NullPointerException(L3.toString());
            } else if (t4 == null) {
                StringBuilder L4 = a2.b.a.a.a.L("t4 is null, tag = ");
                L4.append(this.b);
                throw new NullPointerException(L4.toString());
            } else if (t5 == null) {
                StringBuilder L5 = a2.b.a.a.a.L("t5 is null, tag = ");
                L5.append(this.b);
                throw new NullPointerException(L5.toString());
            } else if (t62 == null) {
                StringBuilder L6 = a2.b.a.a.a.L("t6 is null, tag = ");
                L6.append(this.b);
                throw new NullPointerException(L6.toString());
            } else if (t7 == null) {
                StringBuilder L7 = a2.b.a.a.a.L("t7 is null, tag = ");
                L7.append(this.b);
                throw new NullPointerException(L7.toString());
            } else if (t8 == null) {
                StringBuilder L8 = a2.b.a.a.a.L("t8 is null, tag = ");
                L8.append(this.b);
                throw new NullPointerException(L8.toString());
            } else if (t9 != null) {
                try {
                    R apply = this.a.apply(t1, t2, t3, t4, t5, t62, t7, t8, t9);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L9 = a2.b.a.a.a.L("The BiFunction returned null, tag = ");
                    L9.append(this.b);
                    throw new NullPointerException(L9.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L10 = a2.b.a.a.a.L("t9 is null, tag = ");
                L10.append(this.b);
                throw new NullPointerException(L10.toString());
            }
        }
    }

    public static final class i<T, R> implements Function<T, R> {
        public final Function<T, R> a;
        public final String b;

        public i(Function<T, R> function, String str) {
            this.a = function;
            this.b = str;
        }

        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            if (t != null) {
                try {
                    R apply = this.a.apply(t);
                    if (apply != null) {
                        return apply;
                    }
                    StringBuilder L = a2.b.a.a.a.L("The Function returned null, tag = ");
                    L.append(this.b);
                    throw new NullPointerException(L.toString());
                } catch (Throwable th) {
                    throw FunctionTagging.a(new FunctionTaggingException(this.b).appendLast(th));
                }
            } else {
                StringBuilder L2 = a2.b.a.a.a.L("t is null, tag = ");
                L2.append(this.b);
                throw new NullPointerException(L2.toString());
            }
        }
    }

    public FunctionTagging() {
        throw new IllegalStateException("No instances!");
    }

    public static <E extends Throwable> Exception a(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static void disable() {
        a = false;
    }

    public static void enable() {
        a = true;
    }

    public static boolean isEnabled() {
        return a;
    }

    public static <T1, T2, R> BiFunction<T1, T2, R> tagBiFunction(BiFunction<T1, T2, R> biFunction, String str) {
        if (!a) {
            return biFunction;
        }
        ObjectHelper.requireNonNull(biFunction, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new a(biFunction, str);
    }

    public static <T, R> Function<T, R> tagFunction(Function<T, R> function, String str) {
        if (!a) {
            return function;
        }
        ObjectHelper.requireNonNull(function, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new i(function, str);
    }

    public static <T1, T2, T3, R> Function3<T1, T2, T3, R> tagFunction3(Function3<T1, T2, T3, R> function3, String str) {
        if (!a) {
            return function3;
        }
        ObjectHelper.requireNonNull(function3, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new b(function3, str);
    }

    public static <T1, T2, T3, T4, R> Function4<T1, T2, T3, T4, R> tagFunction4(Function4<T1, T2, T3, T4, R> function4, String str) {
        if (!a) {
            return function4;
        }
        ObjectHelper.requireNonNull(function4, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new c(function4, str);
    }

    public static <T1, T2, T3, T4, T5, R> Function5<T1, T2, T3, T4, T5, R> tagFunction5(Function5<T1, T2, T3, T4, T5, R> function5, String str) {
        if (!a) {
            return function5;
        }
        ObjectHelper.requireNonNull(function5, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new d(function5, str);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function6<T1, T2, T3, T4, T5, T6, R> tagFunction6(Function6<T1, T2, T3, T4, T5, T6, R> function6, String str) {
        if (!a) {
            return function6;
        }
        ObjectHelper.requireNonNull(function6, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new e(function6, str);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function7<T1, T2, T3, T4, T5, T6, T7, R> tagFunction7(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7, String str) {
        if (!a) {
            return function7;
        }
        ObjectHelper.requireNonNull(function7, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new f(function7, str);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> tagFunction8(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8, String str) {
        if (!a) {
            return function8;
        }
        ObjectHelper.requireNonNull(function8, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new g(function8, str);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> tagFunction9(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9, String str) {
        if (!a) {
            return function9;
        }
        ObjectHelper.requireNonNull(function9, "func is null");
        ObjectHelper.requireNonNull(str, "tag is null");
        return new h(function9, str);
    }
}
