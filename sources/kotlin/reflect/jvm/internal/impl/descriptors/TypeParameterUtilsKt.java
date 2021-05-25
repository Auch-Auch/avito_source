package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
public final class TypeParameterUtilsKt {

    public static final class a extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
            Intrinsics.checkNotNullParameter(declarationDescriptor2, "it");
            return Boolean.valueOf(declarationDescriptor2 instanceof CallableDescriptor);
        }
    }

    public static final class b extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
            Intrinsics.checkNotNullParameter(declarationDescriptor2, "it");
            return Boolean.valueOf(!(declarationDescriptor2 instanceof ConstructorDescriptor));
        }
    }

    public static final class c extends Lambda implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Sequence<? extends TypeParameterDescriptor> invoke(DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
            Intrinsics.checkNotNullParameter(declarationDescriptor2, "it");
            List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) declarationDescriptor2).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "it as CallableDescriptor).typeParameters");
            return CollectionsKt___CollectionsKt.asSequence(typeParameters);
        }
    }

    public static final PossiblyInnerType a(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = null;
        if (classifierDescriptorWithTypeParameters == null || ErrorUtils.isError(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
        if (!classifierDescriptorWithTypeParameters.isInner()) {
            if (size != kotlinType.getArguments().size()) {
                DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters);
            }
            return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i, kotlinType.getArguments().size()), null);
        }
        List<TypeProjection> subList = kotlinType.getArguments().subList(i, size);
        DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
        if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
            classifierDescriptorWithTypeParameters2 = (ClassifierDescriptorWithTypeParameters) containingDeclaration;
        }
        return new PossiblyInnerType(classifierDescriptorWithTypeParameters, subList, a(kotlinType, classifierDescriptorWithTypeParameters2, size));
    }

    @Nullable
    public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
        return a(kotlinType, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null, 0);
    }

    @NotNull
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!(classifierDescriptorWithTypeParameters.isInner() || (classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor))) {
            return declaredTypeParameters;
        }
        List list2 = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.flatMap(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.takeWhile(DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters), a.a), b.a), c.a));
        Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                declarationDescriptor = null;
                break;
            }
            declarationDescriptor = it.next();
            if (declarationDescriptor instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (!(classDescriptor == null || (typeConstructor = classDescriptor.getTypeConstructor()) == null)) {
            list = typeConstructor.getParameters();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!list2.isEmpty() || !list.isEmpty()) {
            List<TypeParameterDescriptor> plus = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) list);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(plus, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : plus) {
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "it");
                arrayList.add(new t6.w.f.a.m.b.a(typeParameterDescriptor, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
            }
            return CollectionsKt___CollectionsKt.plus((Collection) declaredTypeParameters, (Iterable) arrayList);
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
        return declaredTypeParameters2;
    }
}
