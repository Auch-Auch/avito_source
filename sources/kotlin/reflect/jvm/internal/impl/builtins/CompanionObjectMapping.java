package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
public final class CompanionObjectMapping {
    @NotNull
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
    @NotNull
    public static final Set<ClassId> a;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        StandardNames standardNames = StandardNames.INSTANCE;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(StandardNames.getPrimitiveFqName(it.next()));
        }
        FqName safe = StandardNames.FqNames.string.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "string.toSafe()");
        List plus = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) arrayList, safe);
        FqName safe2 = StandardNames.FqNames._boolean.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        List plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) plus, safe2);
        FqName safe3 = StandardNames.FqNames._enum.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        List<FqName> plus3 = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) plus2, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : plus3) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        a = linkedHashSet;
    }

    @NotNull
    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return a;
    }

    @NotNull
    public final Set<ClassId> getClassIds() {
        return a;
    }
}
