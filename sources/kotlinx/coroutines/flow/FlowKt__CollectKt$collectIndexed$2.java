package kotlinx.coroutines.flow;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", AuthSource.SEND_ABUSE, "I", FirebaseAnalytics.Param.INDEX, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class FlowKt__CollectKt$collectIndexed$2 implements FlowCollector<T> {
    public int a;
    public final /* synthetic */ Function3 b;

    public FlowKt__CollectKt$collectIndexed$2(Function3 function3) {
        this.b = function3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Function3 function3 = this.b;
        int i = this.a;
        this.a = i + 1;
        if (i >= 0) {
            Object invoke = function3.invoke(Boxing.boxInt(i), t, continuation);
            return invoke == a.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    @Nullable
    public Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
            public /* synthetic */ Object a;
            public int b;
            public final /* synthetic */ FlowKt__CollectKt$collectIndexed$2 c;

            {
                this.c = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.a = obj2;
                this.b |= Integer.MIN_VALUE;
                return this.c.emit(null, this);
            }
        };
        InlineMarker.mark(5);
        Function3 function3 = this.b;
        int i = this.a;
        this.a = i + 1;
        if (i >= 0) {
            return function3.invoke(Integer.valueOf(i), obj, continuation);
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
