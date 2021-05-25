package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;
public final class ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2 extends AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform {
    public final /* synthetic */ ClassicTypeSystemContext a;
    public final /* synthetic */ TypeSubstitutor b;

    public ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor typeSubstitutor) {
        this.a = classicTypeSystemContext;
        this.b = typeSubstitutor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy
    @NotNull
    public SimpleTypeMarker transformType(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        ClassicTypeSystemContext classicTypeSystemContext = this.a;
        KotlinType safeSubstitute = this.b.safeSubstitute((KotlinType) classicTypeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker), Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
        SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(safeSubstitute);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }
}
