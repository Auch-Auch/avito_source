package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.w.f.a.m.c.a.d.h;
public final class SignatureEnhancement {
    @NotNull
    public final AnnotationTypeQualifierResolver a;
    @NotNull
    public final JavaTypeEnhancementState b;
    @NotNull
    public final JavaTypeEnhancement c;

    public static class a {
        @NotNull
        public final KotlinType a;
        public final boolean b;
        public final boolean c;

        public a(@NotNull KotlinType kotlinType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.a = kotlinType;
            this.b = z;
            this.c = z2;
        }
    }

    public static final class c extends a {
        public final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull KotlinType kotlinType, boolean z, boolean z2, boolean z3) {
            super(kotlinType, z2, z3);
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.d = z;
        }
    }

    public static final class d extends Lambda implements Function1<UnwrappedType, Boolean> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(UnwrappedType unwrappedType) {
            UnwrappedType unwrappedType2 = unwrappedType;
            Intrinsics.checkNotNullParameter(unwrappedType2, "it");
            return Boolean.valueOf(unwrappedType2 instanceof RawType);
        }
    }

    public SignatureEnhancement(@NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @NotNull JavaTypeEnhancementState javaTypeEnhancementState, @NotNull JavaTypeEnhancement javaTypeEnhancement) {
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(javaTypeEnhancement, "typeEnhancement");
        this.a = annotationTypeQualifierResolver;
        this.b = javaTypeEnhancementState;
        this.c = javaTypeEnhancement;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00df, code lost:
        if (r8.equals("NEVER") == false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
        if (r8.equals("MAYBE") == false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ec, code lost:
        r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE, r7);
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r6, boolean r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 378
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus");
    }

    public final b b(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        KotlinType kotlinType = (KotlinType) function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (T t : overriddenDescriptors) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add((KotlinType) function1.invoke(t));
        }
        return new b(annotated, kotlinType, arrayList, z, ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, ((KotlinType) function1.invoke(callableMemberDescriptor)).getAnnotations()), annotationQualifierApplicabilityType, false, 64);
    }

    public final b c(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        return b(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : copyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0257, code lost:
        if (r5 == false) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0287 A[LOOP:4: B:143:0x0281->B:145:0x0287, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e1  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> java.util.Collection<D> enhanceSignatures(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r20, @org.jetbrains.annotations.NotNull java.util.Collection<? extends D> r21) {
        /*
        // Method dump skipped, instructions count: 680
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignatures(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, java.util.Collection):java.util.Collection");
    }

    @NotNull
    public final KotlinType enhanceSuperType(@NotNull KotlinType kotlinType, @NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        return new b(null, kotlinType, CollectionsKt__CollectionsKt.emptyList(), false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_USE, false, 64).b(null).a;
    }

    @NotNull
    public final List<KotlinType> enhanceTypeParameterBounds(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull List<? extends KotlinType> list, @NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(list, "bounds");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            if (!TypeUtilsKt.contains(t, d.a)) {
                t = (T) new b(this, typeParameterDescriptor, t, CollectionsKt__CollectionsKt.emptyList(), false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true).b(null).a;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @Nullable
    public final NullabilityQualifierWithMigrationStatus extractNullability(@NotNull AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        NullabilityQualifierWithMigrationStatus a3;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus a4 = a(annotationDescriptor, z, z2);
        if (a4 != null) {
            return a4;
        }
        AnnotationDescriptor resolveTypeQualifierAnnotation = this.a.resolveTypeQualifierAnnotation(annotationDescriptor);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = this.a.resolveJsr305AnnotationState(annotationDescriptor);
        if (!resolveJsr305AnnotationState.isIgnore() && (a3 = a(resolveTypeQualifierAnnotation, z, z2)) != null) {
            return NullabilityQualifierWithMigrationStatus.copy$default(a3, null, resolveJsr305AnnotationState.isWarning(), 1, null);
        }
        return null;
    }

    public final class b {
        @Nullable
        public final Annotated a;
        @NotNull
        public final KotlinType b;
        @NotNull
        public final Collection<KotlinType> c;
        public final boolean d;
        @NotNull
        public final LazyJavaResolverContext e;
        @NotNull
        public final AnnotationQualifierApplicabilityType f;
        public final boolean g;

        public static final class a extends Lambda implements Function1<UnwrappedType, Boolean> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(UnwrappedType unwrappedType) {
                ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().mo425getDeclarationDescriptor();
                if (declarationDescriptor == null) {
                    return Boolean.FALSE;
                }
                Name name = declarationDescriptor.getName();
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                return Boolean.valueOf(Intrinsics.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(declarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$b$b  reason: collision with other inner class name */
        public static final class C0510b extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
            public final /* synthetic */ TypeEnhancementInfo a;
            public final /* synthetic */ Function1<Integer, JavaTypeQualifiers> b;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0510b(TypeEnhancementInfo typeEnhancementInfo, Function1<? super Integer, JavaTypeQualifiers> function1) {
                super(1);
                this.a = typeEnhancementInfo;
                this.b = function1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public JavaTypeQualifiers invoke(Integer num) {
                int intValue = num.intValue();
                JavaTypeQualifiers javaTypeQualifiers = this.a.getMap().get(Integer.valueOf(intValue));
                return javaTypeQualifiers == null ? this.b.invoke(Integer.valueOf(intValue)) : javaTypeQualifiers;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@Nullable SignatureEnhancement signatureEnhancement, @NotNull Annotated annotated, @NotNull KotlinType kotlinType, Collection<? extends KotlinType> collection, @NotNull boolean z, @NotNull LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2) {
            Intrinsics.checkNotNullParameter(signatureEnhancement, "this$0");
            Intrinsics.checkNotNullParameter(kotlinType, "fromOverride");
            Intrinsics.checkNotNullParameter(collection, "fromOverridden");
            Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "containerContext");
            Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "containerApplicabilityType");
            SignatureEnhancement.this = signatureEnhancement;
            this.a = annotated;
            this.b = kotlinType;
            this.c = collection;
            this.d = z;
            this.e = lazyJavaResolverContext;
            this.f = annotationQualifierApplicabilityType;
            this.g = z2;
        }

        public static final <T> T d(List<FqName> list, Annotations annotations, T t) {
            boolean z;
            boolean z2 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (annotations.findAnnotation(it.next()) != null) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z2) {
                return t;
            }
            return null;
        }

        public static final void e(b bVar, ArrayList<h> arrayList, KotlinType kotlinType, LazyJavaResolverContext lazyJavaResolverContext, TypeParameterDescriptor typeParameterDescriptor) {
            JavaDefaultQualifiers javaDefaultQualifiers;
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, kotlinType.getAnnotations());
            JavaTypeQualifiersByElementType defaultTypeQualifiers = copyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            if (defaultTypeQualifiers == null) {
                javaDefaultQualifiers = null;
            } else {
                if (bVar.g) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                javaDefaultQualifiers = defaultTypeQualifiers.get(annotationQualifierApplicabilityType);
            }
            arrayList.add(new h(kotlinType, javaDefaultQualifiers, typeParameterDescriptor, false));
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
            for (Pair pair : CollectionsKt___CollectionsKt.zip(arguments, parameters)) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) pair.component2();
                if (typeProjection.isStarProjection()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "arg.type");
                    arrayList.add(new h(type, javaDefaultQualifiers, typeParameterDescriptor2, true));
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "arg.type");
                    e(bVar, arrayList, type2, copyWithNewDefaultTypeQualifiers, typeParameterDescriptor2);
                }
            }
        }

        public final NullabilityQualifier a(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z;
            boolean z2;
            if (!(typeParameterDescriptor instanceof LazyJavaTypeParameterDescriptor)) {
                return null;
            }
            LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor) typeParameterDescriptor;
            List<KotlinType> upperBounds = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
            boolean z3 = false;
            if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                Iterator<T> it = upperBounds.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!KotlinTypeKt.isError(it.next())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return null;
            }
            List<KotlinType> upperBounds2 = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "upperBounds");
            if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                Iterator<T> it2 = upperBounds2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!SignatureEnhancementKt.access$isNullabilityFlexible(it2.next())) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return null;
            }
            List<KotlinType> upperBounds3 = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds3, "upperBounds");
            if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                Iterator<T> it3 = upperBounds3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    if (!KotlinTypeKt.isNullable(next)) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                return NullabilityQualifier.NOT_NULL;
            }
            return NullabilityQualifier.NULLABLE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function1, t6.w.f.a.m.c.a.d.d] */
        /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r5v11, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
        /* JADX WARN: Type inference failed for: r1v12, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers] */
        /* JADX WARN: Type inference failed for: r6v19, types: [kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier] */
        /* JADX WARN: Type inference failed for: r6v21 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0218, code lost:
            if ((r14.getAffectsTypeParameterBasedTypes() || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r13)) != false) goto L_0x021c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x02fc, code lost:
            if (r7.getQualifier() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L_0x0318;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0313, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r7, java.lang.Boolean.TRUE) != false) goto L_0x0318;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x03b2, code lost:
            if (((r8 != null) && r11 && r6 == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE) == false) goto L_0x03b6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0228  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x022b  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x022e  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0230  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0236  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x0247  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x0286  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x029e  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x02f2  */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x02f6  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x02ff  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x031d  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x031f  */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x0339 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:174:0x0347  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x034c  */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x0357  */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x0359  */
        /* JADX WARNING: Removed duplicated region for block: B:186:0x0372  */
        /* JADX WARNING: Removed duplicated region for block: B:187:0x0374  */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0377  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:190:0x0379  */
        /* JADX WARNING: Removed duplicated region for block: B:193:0x0385 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x0391  */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x03c4  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:221:0x03cf  */
        /* JADX WARNING: Removed duplicated region for block: B:225:0x03d8  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:238:0x0400 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:241:0x040e  */
        /* JADX WARNING: Removed duplicated region for block: B:242:0x0410  */
        /* JADX WARNING: Removed duplicated region for block: B:247:0x0437  */
        /* JADX WARNING: Removed duplicated region for block: B:248:0x0439  */
        /* JADX WARNING: Removed duplicated region for block: B:251:0x0451  */
        /* JADX WARNING: Removed duplicated region for block: B:254:0x0458  */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x045a  */
        /* JADX WARNING: Removed duplicated region for block: B:257:0x0462  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:285:0x0293 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:289:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01f2  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0203  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0208  */
        /* JADX WARNING: Unknown variable types count: 2 */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.a b(@org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r27) {
            /*
            // Method dump skipped, instructions count: 1131
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.b.b(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$a");
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers c(kotlin.reflect.jvm.internal.impl.types.KotlinType r12) {
            /*
                r11 = this;
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(r12)
                if (r0 == 0) goto L_0x0018
                kotlin.reflect.jvm.internal.impl.types.FlexibleType r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.asFlexibleType(r12)
                kotlin.Pair r1 = new kotlin.Pair
                kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r0.getLowerBound()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.getUpperBound()
                r1.<init>(r2, r0)
                goto L_0x001d
            L_0x0018:
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r12, r12)
            L_0x001d:
                java.lang.Object r0 = r1.component1()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                java.lang.Object r1 = r1.component2()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
                boolean r3 = r0.isMarkedNullable()
                r4 = 0
                if (r3 == 0) goto L_0x0038
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L_0x0036:
                r5 = r3
                goto L_0x0042
            L_0x0038:
                boolean r3 = r1.isMarkedNullable()
                if (r3 != 0) goto L_0x0041
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L_0x0036
            L_0x0041:
                r5 = r4
            L_0x0042:
                boolean r0 = r2.isReadOnly(r0)
                if (r0 == 0) goto L_0x004b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L_0x0055
            L_0x004b:
                boolean r0 = r2.isMutable(r1)
                if (r0 == 0) goto L_0x0054
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L_0x0055
            L_0x0054:
                r0 = r4
            L_0x0055:
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = r12.unwrap()
                boolean r6 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.b.c(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(Annotated annotated, KotlinType kotlinType, Collection collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i) {
            this(SignatureEnhancement.this, annotated, kotlinType, collection, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, (i & 64) != 0 ? false : z2);
        }
    }
}
