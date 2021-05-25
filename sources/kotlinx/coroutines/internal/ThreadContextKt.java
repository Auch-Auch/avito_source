package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u6.a.k0.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\",\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"(\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013\"(\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013\"4\u0010\u001c\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013¨\u0006\u001d"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "threadContextElements", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "countOrElement", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/Symbol;", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/internal/Symbol;", "ZERO", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "countAll", "Lu6/a/k0/d;", "e", "restoreState", "d", "updateState", "Lkotlinx/coroutines/ThreadContextElement;", "c", "findOne", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class ThreadContextKt {
    public static final Symbol a = new Symbol("ZERO");
    public static final Function2<Object, CoroutineContext.Element, Object> b = b.a;
    public static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> c = c.a;
    public static final Function2<d, CoroutineContext.Element, d> d = a.c;
    public static final Function2<d, CoroutineContext.Element, d> e = a.b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function2<d, CoroutineContext.Element, d> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final d invoke(d dVar, CoroutineContext.Element element) {
            int i = this.a;
            if (i == 0) {
                d dVar2 = dVar;
                CoroutineContext.Element element2 = element;
                if (element2 instanceof ThreadContextElement) {
                    CoroutineContext coroutineContext = dVar2.c;
                    Object[] objArr = dVar2.a;
                    int i2 = dVar2.b;
                    dVar2.b = i2 + 1;
                    ((ThreadContextElement) element2).restoreThreadContext(coroutineContext, objArr[i2]);
                }
                return dVar2;
            } else if (i == 1) {
                d dVar3 = dVar;
                CoroutineContext.Element element3 = element;
                if (element3 instanceof ThreadContextElement) {
                    Object updateThreadContext = ((ThreadContextElement) element3).updateThreadContext(dVar3.c);
                    Object[] objArr2 = dVar3.a;
                    int i3 = dVar3.b;
                    dVar3.b = i3 + 1;
                    objArr2[i3] = updateThreadContext;
                }
                return dVar3;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, CoroutineContext.Element element) {
            CoroutineContext.Element element2 = element;
            if (!(element2 instanceof ThreadContextElement)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? element2 : Integer.valueOf(intValue + 1);
        }
    }

    public static final class c extends Lambda implements Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> {
        public static final c a = new c();

        public c() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
            ThreadContextElement<?> threadContextElement2 = threadContextElement;
            CoroutineContext.Element element2 = element;
            if (threadContextElement2 != null) {
                return threadContextElement2;
            }
            if (!(element2 instanceof ThreadContextElement)) {
                element2 = null;
            }
            return (ThreadContextElement) element2;
        }
    }

    public static final void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj != a) {
            if (obj instanceof d) {
                ((d) obj).b = 0;
                coroutineContext.fold(obj, e);
                return;
            }
            Object fold = coroutineContext.fold(null, c);
            Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
        }
    }

    @NotNull
    public static final Object threadContextElements(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, b);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new d(coroutineContext, ((Number) obj).intValue()), d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
