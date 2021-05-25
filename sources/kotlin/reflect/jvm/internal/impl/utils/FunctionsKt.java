package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class FunctionsKt {
    @NotNull
    public static final Function1<Object, Boolean> a = b.a;
    @NotNull
    public static final Function3<Object, Object, Object, Unit> b = e.a;

    public static final class a extends Lambda implements Function1 {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return null;
        }
    }

    public static final class b extends Lambda implements Function1<Object, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    public static final class c extends Lambda implements Function1<Object, Unit> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<Object, Object, Unit> {
        public static final d a = new d();

        public d() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Object obj, Object obj2) {
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function3<Object, Object, Object, Unit> {
        public static final e a = new e();

        public e() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(Object obj, Object obj2, Object obj3) {
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Object, Object> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    }

    static {
        f fVar = f.a;
        a aVar = a.a;
        c cVar = c.a;
        d dVar = d.a;
    }

    @NotNull
    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) a;
    }

    @NotNull
    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return b;
    }
}
