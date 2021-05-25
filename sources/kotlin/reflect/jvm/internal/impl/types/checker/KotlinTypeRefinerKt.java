package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
public final class KotlinTypeRefinerKt {
    @NotNull
    public static final ModuleCapability<Ref<KotlinTypeRefiner>> a = new ModuleCapability<>("KotlinTypeRefiner");

    @NotNull
    public static final ModuleCapability<Ref<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return a;
    }

    @NotNull
    public static final List<KotlinType> refineTypes(@NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull Iterable<? extends KotlinType> iterable) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "types");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(iterable, 10));
        for (KotlinType kotlinType : iterable) {
            arrayList.add(kotlinTypeRefiner.refineType(kotlinType));
        }
        return arrayList;
    }
}
