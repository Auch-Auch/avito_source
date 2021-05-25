package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lorg/kodein/di/bindings/RefMaker;", "", "T", "Lkotlin/Function0;", "creator", "Lorg/kodein/di/bindings/Reference;", "make", "(Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/bindings/Reference;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface RefMaker {
    @NotNull
    <T> Reference<T> make(@NotNull Function0<? extends T> function0);
}
