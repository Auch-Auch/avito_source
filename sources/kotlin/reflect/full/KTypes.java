package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/reflect/KType;", "", "nullable", "withNullability", "(Lkotlin/reflect/KType;Z)Lkotlin/reflect/KType;", "other", "isSubtypeOf", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)Z", "isSupertypeOf", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "KTypes")
public final class KTypes {
    @SinceKotlin(version = "1.1")
    public static final boolean isSubtypeOf(@NotNull KType kType, @NotNull KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "$this$isSubtypeOf");
        Intrinsics.checkNotNullParameter(kType2, "other");
        return TypeUtilsKt.isSubtypeOf(((KTypeImpl) kType).getType(), ((KTypeImpl) kType2).getType());
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSupertypeOf(@NotNull KType kType, @NotNull KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "$this$isSupertypeOf");
        Intrinsics.checkNotNullParameter(kType2, "other");
        return isSubtypeOf(kType2, kType);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final KType withNullability(@NotNull KType kType, boolean z) {
        Intrinsics.checkNotNullParameter(kType, "$this$withNullability");
        return ((KTypeImpl) kType).makeNullableAsSpecified$kotlin_reflection(z);
    }
}
