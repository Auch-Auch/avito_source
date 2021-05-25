package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
public final class IntersectionTypeKt {
    @NotNull
    public static final UnwrappedType intersectTypes(@NotNull List<? extends UnwrappedType> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        } else if (size == 1) {
            return (UnwrappedType) CollectionsKt___CollectionsKt.single((List<? extends Object>) list);
        } else {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            boolean z = false;
            boolean z2 = false;
            for (T t2 : list) {
                z = z || KotlinTypeKt.isError(t2);
                if (t2 instanceof SimpleType) {
                    t = t2;
                } else if (!(t2 instanceof FlexibleType)) {
                    throw new NoWhenBranchMatchedException();
                } else if (DynamicTypesKt.isDynamic(t2)) {
                    return t2;
                } else {
                    t = t2.getLowerBound();
                    z2 = true;
                }
                arrayList.add(t);
            }
            if (z) {
                SimpleType createErrorType = ErrorUtils.createErrorType(Intrinsics.stringPlus("Intersection of error types: ", list));
                Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Intersection of error types: $types\")");
                return createErrorType;
            } else if (!z2) {
                return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(FlexibleTypesKt.upperIfFlexible(it.next()));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                return KotlinTypeFactory.flexibleType(typeIntersector.intersectTypes$descriptors(arrayList), typeIntersector.intersectTypes$descriptors(arrayList2));
            }
        }
    }
}
