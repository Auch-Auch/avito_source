package a2.q.a.d.a;

import com.sumsub.sns.presentation.screen.SNSAppViewModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onLoad$1", f = "SNSAppViewModel.kt", i = {1, 2, 2}, l = {105, 111, 117, 123}, m = "invokeSuspend", n = {"configResult", "configResult", "stringsResult"}, s = {"L$0", "L$0", "L$1"})
public final class b extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public Object b;
    public Object c;
    public int d;
    public final /* synthetic */ SNSAppViewModel e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SNSAppViewModel sNSAppViewModel, Continuation continuation) {
        super(1, continuation);
        this.e = sNSAppViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new b(this.e, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        return new b(this.e, continuation2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.q.a.d.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
