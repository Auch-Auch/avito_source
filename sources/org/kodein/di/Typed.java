package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import x6.d.a.k;
import x6.d.a.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \n*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\nR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lorg/kodein/di/Typed;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lorg/kodein/di/TypeToken;", "getType", "()Lorg/kodein/di/TypeToken;", "type", "getValue", "()Ljava/lang/Object;", "value", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface Typed<A> {
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/Typed$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lorg/kodein/di/TypeToken;", "type", "value", "Lorg/kodein/di/Typed;", "invoke", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/Typed;", "Lkotlin/Function0;", "func", "(Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/Typed;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final <A> Typed<A> invoke(@NotNull TypeToken<A> typeToken, A a3) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            return new l(a3, typeToken);
        }

        @NotNull
        public final <A> Typed<A> invoke(@NotNull TypeToken<A> typeToken, @NotNull Function0<? extends A> function0) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            Intrinsics.checkParameterIsNotNull(function0, "func");
            return new k(function0, typeToken);
        }
    }

    @NotNull
    TypeToken<A> getType();

    A getValue();
}
