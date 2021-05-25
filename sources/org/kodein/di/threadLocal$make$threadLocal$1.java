package org.kodein.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"org/kodein/di/threadLocal$make$threadLocal$1", "Ljava/lang/ThreadLocal;", "initialValue", "()Ljava/lang/Object;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class threadLocal$make$threadLocal$1 extends ThreadLocal<T> {
    public final /* synthetic */ Function0 a;

    public threadLocal$make$threadLocal$1(Function0 function0) {
        this.a = function0;
    }

    @Override // java.lang.ThreadLocal
    @NotNull
    public T initialValue() {
        return (T) this.a.invoke();
    }
}
