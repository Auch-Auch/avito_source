package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class DescriptorSubstitutor {
    public static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 4 ? 3 : 2)];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> list, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(0);
            throw null;
        } else if (typeSubstitution == null) {
            a(1);
            throw null;
        } else if (declarationDescriptor == null) {
            a(2);
            throw null;
        } else if (list2 != null) {
            TypeSubstitutor substituteTypeParameters = substituteTypeParameters(list, typeSubstitution, declarationDescriptor, list2, null);
            if (substituteTypeParameters != null) {
                return substituteTypeParameters;
            }
            throw new AssertionError("Substitution failed");
        } else {
            a(3);
            throw null;
        }
    }

    @Nullable
    public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> list, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2, @Nullable boolean[] zArr) {
        if (list == null) {
            a(5);
            throw null;
        } else if (typeSubstitution == null) {
            a(6);
            throw null;
        } else if (declarationDescriptor == null) {
            a(7);
            throw null;
        } else if (list2 != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int i = 0;
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                TypeParameterDescriptorImpl createForFurtherModification = TypeParameterDescriptorImpl.createForFurtherModification(declarationDescriptor, typeParameterDescriptor.getAnnotations(), typeParameterDescriptor.isReified(), typeParameterDescriptor.getVariance(), typeParameterDescriptor.getName(), i, SourceElement.NO_SOURCE, typeParameterDescriptor.getStorageManager());
                hashMap.put(typeParameterDescriptor.getTypeConstructor(), new TypeProjectionImpl(createForFurtherModification.getDefaultType()));
                hashMap2.put(typeParameterDescriptor, createForFurtherModification);
                list2.add(createForFurtherModification);
                i++;
            }
            TypeSubstitutor createChainedSubstitutor = TypeSubstitutor.createChainedSubstitutor(typeSubstitution, TypeConstructorSubstitution.createByConstructorsMap(hashMap));
            for (TypeParameterDescriptor typeParameterDescriptor2 : list) {
                TypeParameterDescriptorImpl typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) hashMap2.get(typeParameterDescriptor2);
                for (KotlinType kotlinType : typeParameterDescriptor2.getUpperBounds()) {
                    KotlinType substitute = createChainedSubstitutor.substitute(kotlinType, Variance.IN_VARIANCE);
                    if (substitute == null) {
                        return null;
                    }
                    if (!(substitute == kotlinType || zArr == null)) {
                        zArr[0] = true;
                    }
                    typeParameterDescriptorImpl.addUpperBound(substitute);
                }
                typeParameterDescriptorImpl.setInitialized();
            }
            return createChainedSubstitutor;
        } else {
            a(8);
            throw null;
        }
    }
}
