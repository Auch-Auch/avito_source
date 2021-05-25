package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
public abstract class DescriptorRenderer {
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    @NotNull
    public static final Companion Companion;
    @JvmField
    @NotNull
    public static final DescriptorRenderer DEBUG_TEXT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer HTML;
    @JvmField
    @NotNull
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3, 6, 5, 4};

            static {
                ClassKind.values();
            }
        }

        public Companion() {
        }

        @NotNull
        public final String getClassifierKindPrefix(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                int ordinal = classDescriptor.getKind().ordinal();
                if (ordinal == 0) {
                    return "class";
                }
                if (ordinal == 1) {
                    return "interface";
                }
                if (ordinal == 2) {
                    return "enum class";
                }
                if (ordinal == 3) {
                    return "enum entry";
                }
                if (ordinal == 4) {
                    return "annotation class";
                }
                if (ordinal == 5) {
                    return "object";
                }
                throw new NoWhenBranchMatchedException();
            }
            throw new AssertionError(Intrinsics.stringPlus("Unexpected classifier: ", classifierDescriptorWithTypeParameters));
        }

        @NotNull
        public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }

        public Companion(t6.r.a.j jVar) {
        }
    }

    public interface ValueParametersHandler {

        public static final class DEFAULT implements ValueParametersHandler {
            @NotNull
            public static final DEFAULT INSTANCE = new DEFAULT();

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb) {
                Intrinsics.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics.checkNotNullParameter(sb, "builder");
                if (i != i2 - 1) {
                    sb.append(", ");
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i, @NotNull StringBuilder sb) {
                Intrinsics.checkNotNullParameter(sb, "builder");
                sb.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb) {
                Intrinsics.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics.checkNotNullParameter(sb, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i, @NotNull StringBuilder sb) {
                Intrinsics.checkNotNullParameter(sb, "builder");
                sb.append("(");
            }
        }

        void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb);

        void appendAfterValueParameters(int i, @NotNull StringBuilder sb);

        void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb);

        void appendBeforeValueParameters(int i, @NotNull StringBuilder sb);
    }

    public static final class a extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setWithDefinedIn(false);
            descriptorRendererOptions2.setModifiers(y.emptySet());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setWithDefinedIn(false);
            descriptorRendererOptions2.setModifiers(y.emptySet());
            descriptorRendererOptions2.setWithoutSuperTypes(true);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setWithDefinedIn(false);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setModifiers(y.emptySet());
            descriptorRendererOptions2.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
            descriptorRendererOptions2.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setDebugMode(true);
            descriptorRendererOptions2.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
            descriptorRendererOptions2.setModifiers(DescriptorRendererModifier.ALL);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final g a = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setModifiers(DescriptorRendererModifier.ALL);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final h a = new h();

        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setTextFormat(RenderingFormat.HTML);
            descriptorRendererOptions2.setModifiers(DescriptorRendererModifier.ALL);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final i a = new i();

        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setWithDefinedIn(false);
            descriptorRendererOptions2.setModifiers(y.emptySet());
            descriptorRendererOptions2.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
            descriptorRendererOptions2.setWithoutTypeParameters(true);
            descriptorRendererOptions2.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
            descriptorRendererOptions2.setReceiverAfterName(true);
            descriptorRendererOptions2.setRenderCompanionObjectName(true);
            descriptorRendererOptions2.setWithoutSuperTypes(true);
            descriptorRendererOptions2.setStartFromName(true);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final j a = new j();

        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
            DescriptorRendererOptions descriptorRendererOptions2 = descriptorRendererOptions;
            Intrinsics.checkNotNullParameter(descriptorRendererOptions2, "<this>");
            descriptorRendererOptions2.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
            descriptorRendererOptions2.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
            return Unit.INSTANCE;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        COMPACT_WITH_MODIFIERS = companion.withOptions(c.a);
        COMPACT = companion.withOptions(a.a);
        COMPACT_WITHOUT_SUPERTYPES = companion.withOptions(b.a);
        COMPACT_WITH_SHORT_TYPES = companion.withOptions(d.a);
        ONLY_NAMES_WITH_SHORT_TYPES = companion.withOptions(i.a);
        FQ_NAMES_IN_TYPES = companion.withOptions(f.a);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = companion.withOptions(g.a);
        SHORT_NAMES_IN_TYPES = companion.withOptions(j.a);
        DEBUG_TEXT = companion.withOptions(e.a);
        HTML = companion.withOptions(h.a);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    @NotNull
    public abstract String render(@NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract String renderAnnotation(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget);

    @NotNull
    public abstract String renderFlexibleType(@NotNull String str, @NotNull String str2, @NotNull KotlinBuiltIns kotlinBuiltIns);

    @NotNull
    public abstract String renderFqName(@NotNull FqNameUnsafe fqNameUnsafe);

    @NotNull
    public abstract String renderName(@NotNull Name name, boolean z);

    @NotNull
    public abstract String renderType(@NotNull KotlinType kotlinType);

    @NotNull
    public abstract String renderTypeProjection(@NotNull TypeProjection typeProjection);

    @NotNull
    public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "changeOptions");
        DescriptorRendererOptionsImpl copy = ((DescriptorRendererImpl) this).getOptions().copy();
        function1.invoke(copy);
        copy.lock();
        return new DescriptorRendererImpl(copy);
    }
}
