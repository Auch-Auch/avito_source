package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.w.f.a.m.j.j.a;
public final class UtilsKt {
    public static final String a(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        b(Intrinsics.stringPlus("type: ", typeConstructor), sb);
        b(Intrinsics.stringPlus("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        b(Intrinsics.stringPlus("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            b(Intrinsics.stringPlus("fqName: ", DescriptorRenderer.FQ_NAMES_IN_TYPES.render(declarationDescriptor)), sb);
            b(Intrinsics.stringPlus("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final StringBuilder b(String str, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(sb, "$this_anonymous");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    @Nullable
    public static final KotlinType findCorrespondingSupertype(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics.checkNotNullParameter(kotlinType2, "supertype");
        Intrinsics.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new a(kotlinType, null));
        TypeConstructor constructor = kotlinType2.getConstructor();
        while (!arrayDeque.isEmpty()) {
            a aVar = (a) arrayDeque.poll();
            KotlinType kotlinType3 = aVar.a;
            TypeConstructor constructor2 = kotlinType3.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean isMarkedNullable = kotlinType3.isMarkedNullable();
                for (a aVar2 = aVar.b; aVar2 != null; aVar2 = aVar2.b) {
                    KotlinType kotlinType4 = aVar2.a;
                    List<TypeProjection> arguments = kotlinType4.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().getProjectionKind() != Variance.INVARIANT) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        KotlinType safeSubstitute = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(kotlinType4), false, 1, null).buildSubstitutor().safeSubstitute(kotlinType3, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        kotlinType3 = CapturedTypeApproximationKt.approximateCapturedTypes(safeSubstitute).getUpper();
                    } else {
                        kotlinType3 = TypeConstructorSubstitution.Companion.create(kotlinType4).buildSubstitutor().safeSubstitute(kotlinType3, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(kotlinType3, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    isMarkedNullable = isMarkedNullable || kotlinType4.isMarkedNullable();
                }
                TypeConstructor constructor3 = kotlinType3.getConstructor();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor)) {
                    return TypeUtils.makeNullableAsSpecified(kotlinType3, isMarkedNullable);
                }
                StringBuilder L = a2.b.a.a.a.L("Type constructors should be equals!\nsubstitutedSuperType: ");
                L.append(a(constructor3));
                L.append(", \n\nsupertype: ");
                L.append(a(constructor));
                L.append(" \n");
                L.append(typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor));
                throw new AssertionError(L.toString());
            }
            for (KotlinType kotlinType5 : constructor2.getSupertypes()) {
                Intrinsics.checkNotNullExpressionValue(kotlinType5, "immediateSupertype");
                arrayDeque.add(new a(kotlinType5, aVar));
            }
        }
        return null;
    }
}
