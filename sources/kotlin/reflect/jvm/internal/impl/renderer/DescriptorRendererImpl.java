package kotlin.reflect.jvm.internal.impl.renderer;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.category_parameters.MultiselectParameterKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnresolvedType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
import t6.y.m;
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    @NotNull
    public final DescriptorRendererOptionsImpl a;
    @NotNull
    public final Lazy b = t6.c.lazy(new b(this));

    public final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        public final /* synthetic */ DescriptorRendererImpl a;

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3};

            static {
                PropertyAccessorRenderingPolicy.values();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl descriptorRendererImpl) {
            Intrinsics.checkNotNullParameter(descriptorRendererImpl, "this$0");
            this.a = descriptorRendererImpl;
        }

        public final void a(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int ordinal = this.a.getPropertyAccessorRenderingPolicy().ordinal();
            if (ordinal == 0) {
                DescriptorRendererImpl.access$renderAccessorModifiers(this.a, propertyAccessorDescriptor, sb);
                sb.append(Intrinsics.stringPlus(str, " for "));
                DescriptorRendererImpl descriptorRendererImpl = this.a;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                DescriptorRendererImpl.access$renderProperty(descriptorRendererImpl, correspondingProperty, sb);
            } else if (ordinal == 1) {
                Intrinsics.checkNotNullParameter(propertyAccessorDescriptor, "descriptor");
                Intrinsics.checkNotNullParameter(sb, "builder");
                DescriptorRendererImpl.access$renderFunction(this.a, propertyAccessorDescriptor, sb);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderClass(this.a, classDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.a, constructorDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderFunction(this.a, functionDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(moduleDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            this.a.t(moduleDescriptor, sb2, true);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.a, packageFragmentDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.a, packageViewDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderProperty(this.a, propertyDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            a(propertyGetterDescriptor, sb2, "getter");
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            a(propertySetterDescriptor, sb2, "setter");
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            sb2.append(receiverParameterDescriptor.getName());
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.a, typeAliasDescriptor, sb2);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            this.a.C(typeParameterDescriptor, sb2, true);
            return Unit.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public Unit visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            StringBuilder sb2 = sb;
            Intrinsics.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            this.a.G(valueParameterDescriptor, true, sb2, true);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2};
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = {1, 2, 3};

        static {
            RenderingFormat.values();
            RenderingFormat renderingFormat = RenderingFormat.PLAIN;
            RenderingFormat renderingFormat2 = RenderingFormat.HTML;
            ParameterNameRenderingPolicy.values();
        }
    }

    public static final class a extends Lambda implements Function1<TypeProjection, CharSequence> {
        public final /* synthetic */ DescriptorRendererImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DescriptorRendererImpl descriptorRendererImpl) {
            super(1);
            this.a = descriptorRendererImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(TypeProjection typeProjection) {
            TypeProjection typeProjection2 = typeProjection;
            Intrinsics.checkNotNullParameter(typeProjection2, "it");
            if (typeProjection2.isStarProjection()) {
                return "*";
            }
            DescriptorRendererImpl descriptorRendererImpl = this.a;
            KotlinType type = typeProjection2.getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            String renderType = descriptorRendererImpl.renderType(type);
            if (typeProjection2.getProjectionKind() == Variance.INVARIANT) {
                return renderType;
            }
            return typeProjection2.getProjectionKind() + ' ' + renderType;
        }
    }

    public static final class b extends Lambda implements Function0<DescriptorRendererImpl> {
        public final /* synthetic */ DescriptorRendererImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DescriptorRendererImpl descriptorRendererImpl) {
            super(0);
            this.a = descriptorRendererImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public DescriptorRendererImpl invoke() {
            return (DescriptorRendererImpl) this.a.withOptions(t6.w.f.a.m.f.a.a);
        }
    }

    public static final class c extends Lambda implements Function1<ConstantValue<?>, CharSequence> {
        public final /* synthetic */ DescriptorRendererImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DescriptorRendererImpl descriptorRendererImpl) {
            super(1);
            this.a = descriptorRendererImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(ConstantValue<?> constantValue) {
            ConstantValue<?> constantValue2 = constantValue;
            Intrinsics.checkNotNullParameter(constantValue2, "it");
            return this.a.k(constantValue2);
        }
    }

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics.checkNotNullParameter(descriptorRendererOptionsImpl, "options");
        this.a = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.isLocked();
    }

    public static final void access$renderAccessorModifiers(DescriptorRendererImpl descriptorRendererImpl, PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        descriptorRendererImpl.p(propertyAccessorDescriptor, sb);
    }

    public static final void access$renderClass(DescriptorRendererImpl descriptorRendererImpl, ClassDescriptor classDescriptor, StringBuilder sb) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Objects.requireNonNull(descriptorRendererImpl);
        boolean z = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!descriptorRendererImpl.getStartFromName()) {
            descriptorRendererImpl.h(sb, classDescriptor, null);
            if (!z) {
                DescriptorVisibility visibility = classDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "klass.visibility");
                descriptorRendererImpl.I(visibility, sb);
            }
            if (!(classDescriptor.getKind() == ClassKind.INTERFACE && classDescriptor.getModality() == Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "klass.modality");
                descriptorRendererImpl.q(modality, sb, descriptorRendererImpl.e(classDescriptor));
            }
            descriptorRendererImpl.p(classDescriptor, sb);
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData(), "data");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), MultiselectParameterKt.DISPLAY_TYPE_INLINE);
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), "value");
            descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
            sb.append(descriptorRendererImpl.n(DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
        }
        if (!DescriptorUtils.isCompanionObject(classDescriptor)) {
            if (!descriptorRendererImpl.getStartFromName()) {
                descriptorRendererImpl.B(sb);
            }
            descriptorRendererImpl.t(classDescriptor, sb, true);
        } else {
            if (descriptorRendererImpl.getRenderCompanionObjectName()) {
                if (descriptorRendererImpl.getStartFromName()) {
                    sb.append("companion object");
                }
                descriptorRendererImpl.B(sb);
                DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                if (containingDeclaration != null) {
                    sb.append("of ");
                    Name name = containingDeclaration.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "containingDeclaration.name");
                    sb.append(descriptorRendererImpl.renderName(name, false));
                }
            }
            if (descriptorRendererImpl.getVerbose() || !Intrinsics.areEqual(classDescriptor.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
                if (!descriptorRendererImpl.getStartFromName()) {
                    descriptorRendererImpl.B(sb);
                }
                Name name2 = classDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
                sb.append(descriptorRendererImpl.renderName(name2, true));
            }
        }
        if (!z) {
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
            descriptorRendererImpl.E(declaredTypeParameters, sb, false);
            descriptorRendererImpl.j(classDescriptor, sb);
            if (!classDescriptor.getKind().isSingleton() && descriptorRendererImpl.getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
                sb.append(" ");
                descriptorRendererImpl.h(sb, unsubstitutedPrimaryConstructor, null);
                DescriptorVisibility visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
                descriptorRendererImpl.I(visibility2, sb);
                sb.append(descriptorRendererImpl.n("constructor"));
                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
                descriptorRendererImpl.H(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
            }
            if (!descriptorRendererImpl.getWithoutSuperTypes() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
                Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
                Intrinsics.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
                if (!supertypes.isEmpty() && (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next()))) {
                    descriptorRendererImpl.B(sb);
                    sb.append(": ");
                    CollectionsKt___CollectionsKt.joinTo$default(supertypes, sb, ", ", null, null, 0, null, new t6.w.f.a.m.f.c(descriptorRendererImpl), 60, null);
                }
            }
            descriptorRendererImpl.J(declaredTypeParameters, sb);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$renderConstructor(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl r18, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r19, java.lang.StringBuilder r20) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.access$renderConstructor(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl, kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.StringBuilder):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$renderFunction(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl r7, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r8, java.lang.StringBuilder r9) {
        /*
        // Method dump skipped, instructions count: 342
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.access$renderFunction(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
    }

    public static final void access$renderPackageFragment(DescriptorRendererImpl descriptorRendererImpl, PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        Objects.requireNonNull(descriptorRendererImpl);
        descriptorRendererImpl.x(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (descriptorRendererImpl.getDebugMode()) {
            sb.append(" in ");
            descriptorRendererImpl.t(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    public static final void access$renderPackageView(DescriptorRendererImpl descriptorRendererImpl, PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        Objects.requireNonNull(descriptorRendererImpl);
        descriptorRendererImpl.x(packageViewDescriptor.getFqName(), "package", sb);
        if (descriptorRendererImpl.getDebugMode()) {
            sb.append(" in context of ");
            descriptorRendererImpl.t(packageViewDescriptor.getModule(), sb, false);
        }
    }

    public static final void access$renderProperty(DescriptorRendererImpl descriptorRendererImpl, PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!descriptorRendererImpl.getStartFromName()) {
            if (!descriptorRendererImpl.getStartFromDeclarationKeyword()) {
                if (descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
                    descriptorRendererImpl.h(sb, propertyDescriptor, null);
                    FieldDescriptor backingField = propertyDescriptor.getBackingField();
                    if (backingField != null) {
                        descriptorRendererImpl.h(sb, backingField, AnnotationUseSiteTarget.FIELD);
                    }
                    FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
                    if (delegateField != null) {
                        descriptorRendererImpl.h(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
                    }
                    if (descriptorRendererImpl.getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
                        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                        if (getter != null) {
                            descriptorRendererImpl.h(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                        }
                        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                        if (setter != null) {
                            descriptorRendererImpl.h(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                            List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                            Intrinsics.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
                            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                            descriptorRendererImpl.h(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                        }
                    }
                }
                DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "property.visibility");
                descriptorRendererImpl.I(visibility, sb);
                descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), "const");
                descriptorRendererImpl.p(propertyDescriptor, sb);
                descriptorRendererImpl.r(propertyDescriptor, sb);
                descriptorRendererImpl.w(propertyDescriptor, sb);
                descriptorRendererImpl.s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit(), "lateinit");
                descriptorRendererImpl.o(propertyDescriptor, sb);
            }
            descriptorRendererImpl.F(propertyDescriptor, sb, false);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            descriptorRendererImpl.E(typeParameters, sb, true);
            descriptorRendererImpl.z(propertyDescriptor, sb);
        }
        descriptorRendererImpl.t(propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "property.type");
        sb.append(descriptorRendererImpl.renderType(type));
        descriptorRendererImpl.A(propertyDescriptor, sb);
        descriptorRendererImpl.m(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        descriptorRendererImpl.J(typeParameters2, sb);
    }

    public static final void access$renderTypeAlias(DescriptorRendererImpl descriptorRendererImpl, TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        descriptorRendererImpl.h(sb, typeAliasDescriptor, null);
        DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        descriptorRendererImpl.I(visibility, sb);
        descriptorRendererImpl.p(typeAliasDescriptor, sb);
        sb.append(descriptorRendererImpl.n("typealias"));
        sb.append(" ");
        descriptorRendererImpl.t(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        descriptorRendererImpl.E(declaredTypeParameters, sb, false);
        descriptorRendererImpl.j(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(descriptorRendererImpl.renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    public static /* synthetic */ void i(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i) {
        int i2 = i & 2;
        descriptorRendererImpl.h(sb, annotated, null);
    }

    public final void A(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    public final void B(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public final void C(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(f());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        s(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        s(sb, label.length() > 0, label);
        h(sb, typeParameterDescriptor, null);
        t(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(next)) {
                sb.append(" : ");
                Intrinsics.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z) {
            for (KotlinType kotlinType : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(kotlinType)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "upperBound");
                    sb.append(renderType(kotlinType));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(d());
        }
    }

    public final void D(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            C((TypeParameterDescriptor) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    public final void E(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(f());
            D(sb, list);
            sb.append(d());
            if (z) {
                sb.append(" ");
            }
        }
    }

    public final void F(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(n(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e1, code lost:
        if ((getDebugMode() ? r9.declaresDefaultValue() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r9)) != false) goto L_0x00e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9, boolean r10, java.lang.StringBuilder r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.G(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r8 == false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r7, boolean r8, java.lang.StringBuilder r9) {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy r0 = r6.getParameterNameRenderingPolicy()
            int r0 = r0.ordinal()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001c
            if (r0 == r1) goto L_0x0018
            r8 = 2
            if (r0 != r8) goto L_0x0012
            goto L_0x001b
        L_0x0012:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0018:
            if (r8 != 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            int r8 = r7.size()
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r0 = r6.getValueParametersHandler()
            r0.appendBeforeValueParameters(r8, r9)
            java.util.Iterator r7 = r7.iterator()
            r0 = 0
        L_0x002c:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x004d
            int r3 = r0 + 1
            java.lang.Object r4 = r7.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r5 = r6.getValueParametersHandler()
            r5.appendBeforeValueParameter(r4, r0, r8, r9)
            r6.G(r4, r1, r9, r2)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r5 = r6.getValueParametersHandler()
            r5.appendAfterValueParameter(r4, r0, r8, r9)
            r0 = r3
            goto L_0x002c
        L_0x004d:
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r7 = r6.getValueParametersHandler()
            r7.appendAfterValueParameters(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.H(java.util.Collection, boolean, java.lang.StringBuilder):void");
    }

    public final boolean I(DescriptorVisibility descriptorVisibility, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(n(descriptorVisibility.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    public final void J(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (!getWithoutTypeParameters()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                for (KotlinType kotlinType : CollectionsKt___CollectionsKt.drop(upperBounds, 1)) {
                    StringBuilder sb2 = new StringBuilder();
                    Name name = typeParameterDescriptor.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "typeParameter.name");
                    sb2.append(renderName(name, false));
                    sb2.append(" : ");
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
                    sb2.append(renderType(kotlinType));
                    arrayList.add(sb2.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(" ");
                sb.append(n("where"));
                sb.append(" ");
                CollectionsKt___CollectionsKt.joinTo$default(arrayList, sb, ", ", null, null, 0, null, null, 124, null);
            }
        }
    }

    public final String K(String str, String str2, String str3, String str4, String str5) {
        if (m.startsWith$default(str, str2, false, 2, null) && m.startsWith$default(str3, str4, false, 2, null)) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String substring2 = str3.substring(length2);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            String stringPlus = Intrinsics.stringPlus(str5, substring);
            if (Intrinsics.areEqual(substring, substring2)) {
                return stringPlus;
            }
            if (b(substring, substring2)) {
                return Intrinsics.stringPlus(stringPlus, "!");
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean L(kotlin.reflect.jvm.internal.impl.types.KotlinType r4) {
        /*
            r3 = this;
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isBuiltinFunctionalType(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0032
            java.util.List r4 = r4.getArguments()
            boolean r0 = r4 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0018
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0018
        L_0x0016:
            r4 = 1
            goto L_0x002f
        L_0x0018:
            java.util.Iterator r4 = r4.iterator()
        L_0x001c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            boolean r0 = r0.isStarProjection()
            if (r0 == 0) goto L_0x001c
            r4 = 0
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            r1 = 1
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.L(kotlin.reflect.jvm.internal.impl.types.KotlinType):boolean");
    }

    public final void a(StringBuilder sb, List<? extends TypeProjection> list) {
        CollectionsKt___CollectionsKt.joinTo$default(list, sb, ", ", null, null, 0, null, new a(this), 60, null);
    }

    public final boolean b(String str, String str2) {
        if (!Intrinsics.areEqual(str, m.replace$default(str2, "?", "", false, 4, (Object) null)) && (!m.endsWith$default(str2, "?", false, 2, null) || !Intrinsics.areEqual(Intrinsics.stringPlus(str, "?"), str2))) {
            if (!Intrinsics.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    public final String c(String str) {
        return getTextFormat().escape(str);
    }

    public final String d() {
        return getTextFormat().escape(">");
    }

    public final Modality e(MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (classDescriptor.getKind() != ClassKind.INTERFACE || Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.PRIVATE)) {
            return Modality.FINAL;
        }
        Modality modality = callableMemberDescriptor.getModality();
        Modality modality2 = Modality.ABSTRACT;
        if (modality == modality2) {
            return modality2;
        }
        return Modality.OPEN;
    }

    public final String f() {
        return getTextFormat().escape("<");
    }

    public final void g(StringBuilder sb, AbbreviatedType abbreviatedType) {
        RenderingFormat textFormat = getTextFormat();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (textFormat == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        v(sb, abbreviatedType.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.a.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.a.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.a.getAnnotationArgumentsRenderingPolicy();
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.a.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.a.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.a.getClassWithPrimaryConstructor();
    }

    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.a.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.a.getDebugMode();
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.a.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.a.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.a.getEnhancedTypes();
    }

    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return this.a.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.a.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.a.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.a.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.a.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.a.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.a.getInformativeErrorType();
    }

    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return this.a.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.a.getNormalizedVisibilities();
    }

    @NotNull
    public final DescriptorRendererOptionsImpl getOptions() {
        return this.a;
    }

    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.a.getOverrideRenderingPolicy();
    }

    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.a.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.a.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.a.getPresentableUnresolvedTypes();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.a.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.a.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.a.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.a.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.a.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.a.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.a.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.a.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.a.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.a.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.a.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.a.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.a.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.a.getStartFromName();
    }

    @NotNull
    public RenderingFormat getTextFormat() {
        return this.a.getTextFormat();
    }

    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.a.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.a.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.a.getUnitReturnType();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.a.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.a.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.a.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.a.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.a.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.a.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.a.getWithoutTypeParameters();
    }

    public final void h(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<FqName> excludedTypeAnnotationClasses = annotated instanceof KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!CollectionsKt___CollectionsKt.contains(excludedTypeAnnotationClasses, annotationDescriptor.getFqName()) && !Intrinsics.areEqual(annotationDescriptor.getFqName(), StandardNames.FqNames.parameterName)) {
                    if (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue()) {
                        sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                        if (getEachAnnotationOnNewLine()) {
                            sb.append('\n');
                            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                        } else {
                            sb.append(" ");
                        }
                    }
                }
            }
        }
    }

    public final void j(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            D(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    public final String k(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            return CollectionsKt___CollectionsKt.joinToString$default((Iterable) ((ArrayValue) constantValue).getValue(), ", ", "{", "}", 0, null, new c(this), 24, null);
        }
        if (constantValue instanceof AnnotationValue) {
            return StringsKt__StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor) ((AnnotationValue) constantValue).getValue(), null, 2, null), (CharSequence) "@");
        }
        if (!(constantValue instanceof KClassValue)) {
            return constantValue.toString();
        }
        KClassValue.Value value = (KClassValue.Value) ((KClassValue) constantValue).getValue();
        if (value instanceof KClassValue.Value.LocalClass) {
            return ((KClassValue.Value.LocalClass) value).getType() + "::class";
        } else if (value instanceof KClassValue.Value.NormalClass) {
            KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
            String asString = normalClass.getClassId().asSingleFqName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "classValue.classId.asSingleFqName().asString()");
            int arrayDimensions = normalClass.getArrayDimensions();
            for (int i = 0; i < arrayDimensions; i++) {
                asString = a2.b.a.a.a.d3("kotlin.Array<", asString, Typography.greater);
            }
            return Intrinsics.stringPlus(asString, "::class");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void l(StringBuilder sb, KotlinType kotlinType) {
        h(sb, kotlinType, null);
        if (KotlinTypeKt.isError(kotlinType)) {
            if ((kotlinType instanceof UnresolvedType) && getPresentableUnresolvedTypes()) {
                sb.append(((UnresolvedType) kotlinType).getPresentableName());
            } else if (!(kotlinType instanceof ErrorType) || getInformativeErrorType()) {
                sb.append(kotlinType.getConstructor().toString());
            } else {
                sb.append(((ErrorType) kotlinType).getPresentableName());
            }
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            TypeConstructor constructor = kotlinType.getConstructor();
            PossiblyInnerType buildPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
            if (buildPossiblyInnerType == null) {
                sb.append(renderTypeConstructor(constructor));
                sb.append(renderTypeArguments(kotlinType.getArguments()));
            } else {
                y(sb, buildPossiblyInnerType);
            }
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append("?");
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            sb.append("!!");
        }
    }

    public final void m(VariableDescriptor variableDescriptor, StringBuilder sb) {
        ConstantValue<?> compileTimeInitializer;
        if (getIncludePropertyConstant() && (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) != null) {
            sb.append(" = ");
            sb.append(c(k(compileTimeInitializer)));
        }
    }

    public final String n(String str) {
        int ordinal = getTextFormat().ordinal();
        if (ordinal == 0) {
            return str;
        }
        if (ordinal == 1) {
            return getBoldOnlyForNamesInHtml() ? str : a2.b.a.a.a.e3("<b>", str, "</b>");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void o(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            String name = callableMemberDescriptor.getKind().name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    public final void p(MemberDescriptor memberDescriptor, StringBuilder sb) {
        s(sb, memberDescriptor.isExternal(), "external");
        boolean z = false;
        s(sb, getModifiers().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) && memberDescriptor.isActual()) {
            z = true;
        }
        s(sb, z, "actual");
    }

    public final void q(Modality modality, StringBuilder sb, Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            boolean contains = getModifiers().contains(DescriptorRendererModifier.MODALITY);
            String name = modality.name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            s(sb, contains, lowerCase);
        }
    }

    public final void r(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.getModality() != Modality.OPEN || !(!callableMemberDescriptor.getOverriddenDescriptors().isEmpty())) {
            Modality modality = callableMemberDescriptor.getModality();
            Intrinsics.checkNotNullExpressionValue(modality, "callable.modality");
            q(modality, sb, e(callableMemberDescriptor));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String render(@NotNull DeclarationDescriptor declarationDescriptor) {
        String name;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(this), sb);
        if (getWithDefinedIn() && !(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor)) {
            if (declarationDescriptor instanceof ModuleDescriptor) {
                sb.append(" is a module");
            } else {
                DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
                if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor)) {
                    sb.append(" ");
                    sb.append(renderMessage("defined in"));
                    sb.append(" ");
                    FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
                    Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
                    sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
                    if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                        sb.append(" ");
                        sb.append(renderMessage("in file"));
                        sb.append(" ");
                        sb.append(name);
                    }
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderAnnotation(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(Intrinsics.stringPlus(annotationUseSiteTarget.getRenderName(), ":"));
        }
        KotlinType type = annotationDescriptor.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
            List list = null;
            ClassDescriptor annotationClass = getRenderDefaultAnnotationArguments() ? DescriptorUtilsKt.getAnnotationClass(annotationDescriptor) : null;
            List<ValueParameterDescriptor> valueParameters = (annotationClass == null || (unsubstitutedPrimaryConstructor = annotationClass.getUnsubstitutedPrimaryConstructor()) == null) ? null : unsubstitutedPrimaryConstructor.getValueParameters();
            if (valueParameters != null) {
                ArrayList arrayList = new ArrayList();
                for (T t : valueParameters) {
                    if (t.declaresDefaultValue()) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ValueParameterDescriptor) it.next()).getName());
                }
                list = arrayList2;
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : list) {
                Name name = (Name) obj;
                Intrinsics.checkNotNullExpressionValue(name, "it");
                if (!allValueArguments.containsKey(name)) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(Intrinsics.stringPlus(((Name) it2.next()).asString(), " = ..."));
            }
            Set<Map.Entry<Name, ConstantValue<?>>> entrySet = allValueArguments.entrySet();
            ArrayList arrayList5 = new ArrayList(e.collectionSizeOrDefault(entrySet, 10));
            for (T t2 : entrySet) {
                Name name2 = (Name) t2.getKey();
                ConstantValue<?> constantValue = (ConstantValue) t2.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(name2.asString());
                sb2.append(" = ");
                sb2.append(!list.contains(name2) ? k(constantValue) : "...");
                arrayList5.add(sb2.toString());
            }
            List sorted = CollectionsKt___CollectionsKt.sorted(CollectionsKt___CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5));
            if (getIncludeEmptyAnnotationArguments() || (!sorted.isEmpty())) {
                CollectionsKt___CollectionsKt.joinTo$default(sorted, sb, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(type) || (type.getConstructor().mo425getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            sb.append(" /* annotation class not found */");
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public String renderClassifierName(@NotNull ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "klass");
        if (ErrorUtils.isError(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderFlexibleType(@NotNull String str, @NotNull String str2, @NotNull KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(str, "lowerRendered");
        Intrinsics.checkNotNullParameter(str2, "upperRendered");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (!b(str, str2)) {
            ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
            ClassDescriptor collection = kotlinBuiltIns.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection, "builtIns.collection");
            String substringBefore$default = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
            String stringPlus = Intrinsics.stringPlus(substringBefore$default, "Mutable");
            String K = K(str, stringPlus, str2, substringBefore$default, substringBefore$default + "(Mutable)");
            if (K != null) {
                return K;
            }
            String K2 = K(str, Intrinsics.stringPlus(substringBefore$default, "MutableMap.MutableEntry"), str2, Intrinsics.stringPlus(substringBefore$default, "Map.Entry"), Intrinsics.stringPlus(substringBefore$default, "(Mutable)Map.(Mutable)Entry"));
            if (K2 != null) {
                return K2;
            }
            ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
            ClassDescriptor array = kotlinBuiltIns.getArray();
            Intrinsics.checkNotNullExpressionValue(array, "builtIns.array");
            String substringBefore$default2 = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
            String K3 = K(str, Intrinsics.stringPlus(substringBefore$default2, getTextFormat().escape("Array<")), str2, Intrinsics.stringPlus(substringBefore$default2, getTextFormat().escape("Array<out ")), Intrinsics.stringPlus(substringBefore$default2, getTextFormat().escape("Array<(out) ")));
            if (K3 != null) {
                return K3;
            }
            return '(' + str + ".." + str2 + ')';
        } else if (!m.startsWith$default(str2, "(", false, 2, null)) {
            return Intrinsics.stringPlus(str, "!");
        } else {
            return '(' + str + ")!";
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderFqName(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "fqName.pathSegments()");
        return c(RenderingUtilsKt.renderFqName(pathSegments));
    }

    @NotNull
    public String renderMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        int ordinal = getTextFormat().ordinal();
        if (ordinal == 0) {
            return str;
        }
        if (ordinal == 1) {
            return a2.b.a.a.a.e3("<i>", str, "</i>");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderName(@NotNull Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        String c2 = c(RenderingUtilsKt.render(name));
        return (!getBoldOnlyForNamesInHtml() || getTextFormat() != RenderingFormat.HTML || !z) ? c2 : a2.b.a.a.a.e3("<b>", c2, "</b>");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        StringBuilder sb = new StringBuilder();
        u(sb, getTypeNormalizer().invoke(kotlinType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public String renderTypeArguments(@NotNull List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        a(sb, list);
        sb.append(d());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public String renderTypeConstructor(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor();
        boolean z = true;
        if (!(declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor)) {
            z = declarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            return typeConstructor.toString();
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderTypeProjection(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        a(sb, d.listOf(typeProjection));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void s(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(n(str));
            sb.append(" ");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.a.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.a.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.a.setDebugMode(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.a.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.a.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.a.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.a.setReceiverAfterName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.a.setRenderCompanionObjectName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.a.setStartFromName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.a.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.a.setVerbose(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.a.setWithDefinedIn(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.a.setWithoutSuperTypes(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.a.setWithoutTypeParameters(z);
    }

    public final void t(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        Name name = declarationDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z));
    }

    public final void u(StringBuilder sb, KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        AbbreviatedType abbreviatedType = unwrap instanceof AbbreviatedType ? (AbbreviatedType) unwrap : null;
        if (abbreviatedType == null) {
            v(sb, kotlinType);
        } else if (getRenderTypeExpansions()) {
            v(sb, abbreviatedType.getExpandedType());
        } else {
            v(sb, abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                g(sb, abbreviatedType);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(java.lang.StringBuilder r12, kotlin.reflect.jvm.internal.impl.types.KotlinType r13) {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.v(java.lang.StringBuilder, kotlin.reflect.jvm.internal.impl.types.KotlinType):void");
    }

    public final void w(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            s(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    public final void x(FqName fqName, String str, StringBuilder sb) {
        sb.append(n(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            sb.append(" ");
            sb.append(renderFqName);
        }
    }

    public final void y(StringBuilder sb, PossiblyInnerType possiblyInnerType) {
        StringBuilder sb2;
        PossiblyInnerType outerType = possiblyInnerType.getOuterType();
        if (outerType == null) {
            sb2 = null;
        } else {
            y(sb, outerType);
            sb.append(FormatterType.defaultDecimalSeparator);
            Name name = possiblyInnerType.getClassifierDescriptor().getName();
            Intrinsics.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    public final void z(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            h(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            String renderType = renderType(type);
            if (L(type) && !TypeUtils.isNullableType(type)) {
                renderType = '(' + renderType + ')';
            }
            sb.append(renderType);
            sb.append(".");
        }
    }
}
