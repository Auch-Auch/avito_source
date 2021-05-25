package org.kodein.di;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Reference;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lorg/kodein/di/softReference;", "Lorg/kodein/di/bindings/RefMaker;", "", "T", "Lkotlin/Function0;", "creator", "Lorg/kodein/di/bindings/Reference;", "make", "(Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/bindings/Reference;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class softReference implements RefMaker {
    public static final softReference INSTANCE = new softReference();

    public static final class a extends Lambda implements Function0<T> {
        public final /* synthetic */ SoftReference a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SoftReference softReference) {
            super(0);
            this.a = softReference;
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final T invoke() {
            return (T) this.a.get();
        }
    }

    @Override // org.kodein.di.bindings.RefMaker
    @NotNull
    public <T> Reference<T> make(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "creator");
        Object invoke = function0.invoke();
        return new Reference<>(invoke, new a(new SoftReference(invoke)));
    }
}
