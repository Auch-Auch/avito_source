package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "e", "invoke", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$safeCtor$1(Function1 function1) {
        super(1);
        this.a = function1;
    }

    @Nullable
    public final Throwable invoke(@NotNull Throwable th) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m242constructorimpl((Throwable) this.a.invoke(th));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m242constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m247isFailureimpl(obj)) {
            obj = null;
        }
        return (Throwable) obj;
    }
}
