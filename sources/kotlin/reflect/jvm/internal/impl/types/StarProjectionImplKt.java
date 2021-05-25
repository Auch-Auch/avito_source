package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
public final class StarProjectionImplKt {
    @NotNull
    public static final KotlinType starProjectionType(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) typeParameterDescriptor.getContainingDeclaration()).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTypeConstructor());
        }
        TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution(arrayList) { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt$starProjectionType$1
            public final /* synthetic */ List<TypeConstructor> a;

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeConstructor> */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.a = r1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            @Nullable
            public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
                Intrinsics.checkNotNullParameter(typeConstructor, "key");
                if (!this.a.contains(typeConstructor)) {
                    return null;
                }
                ClassifierDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return TypeUtils.makeStarProjection((TypeParameterDescriptor) declarationDescriptor);
            }
        });
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
        KotlinType substitute = create.substitute((KotlinType) CollectionsKt___CollectionsKt.first((List<? extends Object>) upperBounds), Variance.OUT_VARIANCE);
        if (substitute != null) {
            return substitute;
        }
        SimpleType defaultBound = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getDefaultBound();
        Intrinsics.checkNotNullExpressionValue(defaultBound, "builtIns.defaultBound");
        return defaultBound;
    }
}
