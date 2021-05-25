package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
public final class MemberDeserializer {
    @NotNull
    public final DeserializationContext a;
    @NotNull
    public final AnnotationDeserializer b;

    public static final class b extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ MemberDeserializer a;
        public final /* synthetic */ MessageLite b;
        public final /* synthetic */ AnnotatedCallableKind c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
            super(0);
            this.a = memberDeserializer;
            this.b = messageLite;
            this.c = annotatedCallableKind;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends AnnotationDescriptor> invoke() {
            List<? extends AnnotationDescriptor> list;
            MemberDeserializer memberDeserializer = this.a;
            ProtoContainer a3 = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
            if (a3 == null) {
                list = null;
            } else {
                list = CollectionsKt___CollectionsKt.toList(this.a.a.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(a3, this.b, this.c));
            }
            return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
        }
    }

    public static final class c extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ MemberDeserializer a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ProtoBuf.Property c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MemberDeserializer memberDeserializer, boolean z, ProtoBuf.Property property) {
            super(0);
            this.a = memberDeserializer;
            this.b = z;
            this.c = property;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends AnnotationDescriptor> invoke() {
            List<? extends AnnotationDescriptor> list;
            MemberDeserializer memberDeserializer = this.a;
            ProtoContainer a3 = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
            if (a3 == null) {
                list = null;
            } else {
                boolean z = this.b;
                MemberDeserializer memberDeserializer2 = this.a;
                ProtoBuf.Property property = this.c;
                if (z) {
                    list = CollectionsKt___CollectionsKt.toList(memberDeserializer2.a.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(a3, property));
                } else {
                    list = CollectionsKt___CollectionsKt.toList(memberDeserializer2.a.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(a3, property));
                }
            }
            return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
        }
    }

    public static final class d extends Lambda implements Function0<ConstantValue<?>> {
        public final /* synthetic */ MemberDeserializer a;
        public final /* synthetic */ ProtoBuf.Property b;
        public final /* synthetic */ DeserializedPropertyDescriptor c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MemberDeserializer memberDeserializer, ProtoBuf.Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
            super(0);
            this.a = memberDeserializer;
            this.b = property;
            this.c = deserializedPropertyDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ConstantValue<?> invoke() {
            MemberDeserializer memberDeserializer = this.a;
            ProtoContainer a3 = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
            Intrinsics.checkNotNull(a3);
            AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = this.a.a.getComponents().getAnnotationAndConstantLoader();
            ProtoBuf.Property property = this.b;
            KotlinType returnType = this.c.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "property.returnType");
            return annotationAndConstantLoader.loadPropertyConstant(a3, property, returnType);
        }
    }

    public static final class e extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ MemberDeserializer a;
        public final /* synthetic */ ProtoContainer b;
        public final /* synthetic */ MessageLite c;
        public final /* synthetic */ AnnotatedCallableKind d;
        public final /* synthetic */ int e;
        public final /* synthetic */ ProtoBuf.ValueParameter f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf.ValueParameter valueParameter) {
            super(0);
            this.a = memberDeserializer;
            this.b = protoContainer;
            this.c = messageLite;
            this.d = annotatedCallableKind;
            this.e = i;
            this.f = valueParameter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends AnnotationDescriptor> invoke() {
            return CollectionsKt___CollectionsKt.toList(this.a.a.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.b, this.c, this.d, this.e, this.f));
        }
    }

    public MemberDeserializer(@NotNull DeserializationContext deserializationContext) {
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        this.a = deserializationContext;
        this.b = new AnnotationDeserializer(deserializationContext.getComponents().getModuleDescriptor(), deserializationContext.getComponents().getNotFoundClasses());
    }

    public final ProtoContainer a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.a.getNameResolver(), this.a.getTypeTable(), this.a.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    public final DeserializedMemberDescriptor.CoroutinesCompatibilityMode b(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (!i(deserializedMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        Iterator<T> it = typeDeserializer.getOwnTypeParameters().iterator();
        while (it.hasNext()) {
            it.next().getUpperBounds();
        }
        if (typeDeserializer.getExperimentalSuspendFunctionTypeEncountered()) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00b4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.CoroutinesCompatibilityMode c(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor r4, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r5, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r6, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r7, kotlin.reflect.jvm.internal.impl.types.KotlinType r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 332
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.c(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, java.util.Collection, java.util.Collection, kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean):kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor$CoroutinesCompatibilityMode");
    }

    public final boolean d(KotlinType kotlinType) {
        return TypeUtilsKt.contains(kotlinType, a.a);
    }

    public final Annotations e(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.a.getStorageManager(), new b(this, messageLite, annotatedCallableKind));
    }

    public final ReceiverParameterDescriptor f() {
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    public final Annotations g(ProtoBuf.Property property, boolean z) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.a.getStorageManager(), new c(this, z, property));
    }

    public final List<ValueParameterDescriptor> h(List<ProtoBuf.ValueParameter> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        NonEmptyDeserializedAnnotations nonEmptyDeserializedAnnotations;
        CallableDescriptor callableDescriptor = (CallableDescriptor) this.a.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "callableDescriptor.containingDeclaration");
        ProtoContainer a3 = a(containingDeclaration);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            int flags = t2.hasFlags() ? t2.getFlags() : 0;
            if (a3 == null || !a2.b.a.a.a.w1(Flags.HAS_ANNOTATIONS, flags, "HAS_ANNOTATIONS.get(flags)")) {
                nonEmptyDeserializedAnnotations = Annotations.Companion.getEMPTY();
            } else {
                nonEmptyDeserializedAnnotations = new NonEmptyDeserializedAnnotations(this.a.getStorageManager(), new e(this, a3, messageLite, annotatedCallableKind, i, t2));
            }
            Name name = NameResolverUtilKt.getName(this.a.getNameResolver(), t2.getName());
            KotlinType type = this.a.getTypeDeserializer().type(ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter) t2, this.a.getTypeTable()));
            boolean w1 = a2.b.a.a.a.w1(Flags.DECLARES_DEFAULT_VALUE, flags, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean w12 = a2.b.a.a.a.w1(Flags.IS_CROSSINLINE, flags, "IS_CROSSINLINE.get(flags)");
            boolean w13 = a2.b.a.a.a.w1(Flags.IS_NOINLINE, flags, "IS_NOINLINE.get(flags)");
            ProtoBuf.Type varargElementType = ProtoTypeTableUtilKt.varargElementType(t2, this.a.getTypeTable());
            KotlinType type2 = varargElementType == null ? null : this.a.getTypeDeserializer().type(varargElementType);
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, nonEmptyDeserializedAnnotations, name, type, w1, w12, w13, type2, sourceElement));
            arrayList = arrayList;
            i = i2;
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final boolean i(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (!this.a.getComponents().getConfiguration().getReleaseCoroutines()) {
            return false;
        }
        List<VersionRequirement> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
        if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
            Iterator<T> it = versionRequirements.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!Intrinsics.areEqual(next.getVersion(), new VersionRequirement.Version(1, 3, 0, 4, null)) || next.getKind() != ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ClassConstructorDescriptor loadConstructor(@NotNull ProtoBuf.Constructor constructor, boolean z) {
        DeserializationContext deserializationContext;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        TypeDeserializer typeDeserializer;
        Intrinsics.checkNotNullParameter(constructor, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.a.getContainingDeclaration();
        int flags = constructor.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, e(constructor, flags, annotatedCallableKind), z, CallableMemberDescriptor.Kind.DECLARATION, constructor, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource(), null, 1024, null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.a, deserializedClassConstructorDescriptor2, CollectionsKt__CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        deserializedClassConstructorDescriptor2.initialize(memberDeserializer.h(valueParameterList, constructor, annotatedCallableKind), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(constructor.getFlags())));
        deserializedClassConstructorDescriptor2.setReturnType(classDescriptor.getDefaultType());
        boolean z2 = true;
        deserializedClassConstructorDescriptor2.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(constructor.getFlags()).booleanValue());
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        Boolean bool = null;
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration : null;
        if (deserializedClassDescriptor == null) {
            deserializationContext = null;
        } else {
            deserializationContext = deserializedClassDescriptor.getC();
        }
        if (!(deserializationContext == null || (typeDeserializer = deserializationContext.getTypeDeserializer()) == null)) {
            bool = Boolean.valueOf(typeDeserializer.getExperimentalSuspendFunctionTypeEncountered());
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) || !i(deserializedClassConstructorDescriptor2)) {
            z2 = false;
        }
        if (z2) {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
        } else {
            Collection<? extends ValueParameterDescriptor> valueParameters = deserializedClassConstructorDescriptor2.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Collection<? extends TypeParameterDescriptor> typeParameters = deserializedClassConstructorDescriptor2.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
            coroutinesCompatibilityMode = c(deserializedClassConstructorDescriptor2, null, valueParameters, typeParameters, deserializedClassConstructorDescriptor2.getReturnType(), false);
        }
        deserializedClassConstructorDescriptor.setCoroutinesExperimentalCompatibilityMode$deserialization(coroutinesCompatibilityMode);
        return deserializedClassConstructorDescriptor;
    }

    @NotNull
    public final SimpleFunctionDescriptor loadFunction(@NotNull ProtoBuf.Function function) {
        int i;
        Annotations annotations;
        VersionRequirementTable versionRequirementTable;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType type;
        Intrinsics.checkNotNullParameter(function, "proto");
        if (function.hasFlags()) {
            i = function.getFlags();
        } else {
            int oldFlags = function.getOldFlags();
            i = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations e2 = e(function, i, annotatedCallableKind);
        if (ProtoTypeTableUtilKt.hasReceiver(function)) {
            annotations = new DeserializedAnnotations(this.a.getStorageManager(), new t6.w.f.a.m.h.a.a(this, function, annotatedCallableKind));
        } else {
            annotations = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.a.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.a.getNameResolver(), function.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.a.getVersionRequirementTable();
        }
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        Name name = NameResolverUtilKt.getName(this.a.getNameResolver(), function.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(containingDeclaration, null, e2, name, ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, Flags.MEMBER_KIND.get(i)), function, this.a.getNameResolver(), this.a.getTypeTable(), versionRequirementTable, this.a.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.a;
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(function, this.a.getTypeTable());
        if (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, annotations);
        }
        ReceiverParameterDescriptor f = f();
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> h = memberDeserializer.h(valueParameterList, function, annotatedCallableKind);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(function, this.a.getTypeTable()));
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(i));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(i));
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> emptyMap = r.emptyMap();
        Flags.BooleanFlagField booleanFlagField = Flags.IS_SUSPEND;
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, f, ownTypeParameters, h, type2, modality, descriptorVisibility, emptyMap, c(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor, h, ownTypeParameters, type2, a2.b.a.a.a.w1(booleanFlagField, i, "IS_SUSPEND.get(flags)")));
        Boolean bool = Flags.IS_OPERATOR.get(i);
        Intrinsics.checkNotNullExpressionValue(bool, "IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor.setOperator(bool.booleanValue());
        Boolean bool2 = Flags.IS_INFIX.get(i);
        Intrinsics.checkNotNullExpressionValue(bool2, "IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags.IS_EXTERNAL_FUNCTION.get(i);
        Intrinsics.checkNotNullExpressionValue(bool3, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags.IS_INLINE.get(i);
        Intrinsics.checkNotNullExpressionValue(bool4, "IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor.setInline(bool4.booleanValue());
        Boolean bool5 = Flags.IS_TAILREC.get(i);
        Intrinsics.checkNotNullExpressionValue(bool5, "IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool5.booleanValue());
        Boolean bool6 = booleanFlagField.get(i);
        Intrinsics.checkNotNullExpressionValue(bool6, "IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags.IS_EXPECT_FUNCTION.get(i);
        Intrinsics.checkNotNullExpressionValue(bool7, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExpect(bool7.booleanValue());
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(i).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.a.getComponents().getContractDeserializer().deserializeContractFromFunction(function, deserializedSimpleFunctionDescriptor, this.a.getTypeTable(), childContext$default.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    @NotNull
    public final PropertyDescriptor loadProperty(@NotNull ProtoBuf.Property property) {
        int i;
        ProtoBuf.Property property2;
        Annotations annotations;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ProtoEnumFlags protoEnumFlags;
        Flags.FlagField<ProtoBuf.Visibility> flagField;
        DeserializationContext deserializationContext;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        ProtoBuf.Property property3;
        Flags.FlagField<ProtoBuf.Modality> flagField2;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor2;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        MemberDeserializer memberDeserializer;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2;
        KotlinType type;
        Intrinsics.checkNotNullParameter(property, "proto");
        if (property.hasFlags()) {
            i = property.getFlags();
        } else {
            int oldFlags = property.getOldFlags();
            i = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        DeclarationDescriptor containingDeclaration = this.a.getContainingDeclaration();
        Annotations e2 = e(property, i, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.INSTANCE;
        Flags.FlagField<ProtoBuf.Modality> flagField3 = Flags.MODALITY;
        Modality modality = protoEnumFlags2.modality(flagField3.get(i));
        Flags.FlagField<ProtoBuf.Visibility> flagField4 = Flags.VISIBILITY;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = new DeserializedPropertyDescriptor(containingDeclaration, null, e2, modality, ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, flagField4.get(i)), a2.b.a.a.a.w1(Flags.IS_VAR, i, "IS_VAR.get(flags)"), NameResolverUtilKt.getName(this.a.getNameResolver(), property.getName()), ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags2, Flags.MEMBER_KIND.get(i)), a2.b.a.a.a.w1(Flags.IS_LATEINIT, i, "IS_LATEINIT.get(flags)"), a2.b.a.a.a.w1(Flags.IS_CONST, i, "IS_CONST.get(flags)"), a2.b.a.a.a.w1(Flags.IS_EXTERNAL_PROPERTY, i, "IS_EXTERNAL_PROPERTY.get(flags)"), a2.b.a.a.a.w1(Flags.IS_DELEGATED, i, "IS_DELEGATED.get(flags)"), a2.b.a.a.a.w1(Flags.IS_EXPECT_PROPERTY, i, "IS_EXPECT_PROPERTY.get(flags)"), property, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource());
        DeserializationContext deserializationContext2 = this.a;
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext2, deserializedPropertyDescriptor3, typeParameterList, null, null, null, null, 60, null);
        boolean w1 = a2.b.a.a.a.w1(Flags.HAS_GETTER, i, "HAS_GETTER.get(flags)");
        if (!w1 || !ProtoTypeTableUtilKt.hasReceiver(property)) {
            property2 = property;
            annotations = Annotations.Companion.getEMPTY();
        } else {
            property2 = property;
            annotations = new DeserializedAnnotations(this.a.getStorageManager(), new t6.w.f.a.m.h.a.a(this, property2, AnnotatedCallableKind.PROPERTY_GETTER));
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property2, this.a.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor f = f();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property2, this.a.getTypeTable());
        if (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) {
            receiverParameterDescriptor = null;
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
        } else {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, annotations);
        }
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, f, receiverParameterDescriptor);
        int accessorFlags = Flags.getAccessorFlags(a2.b.a.a.a.w1(Flags.HAS_ANNOTATIONS, i, "HAS_ANNOTATIONS.get(flags)"), flagField4.get(i), flagField3.get(i), false, false, false);
        if (w1) {
            int getterFlags = property.hasGetterFlags() ? property.getGetterFlags() : accessorFlags;
            boolean w12 = a2.b.a.a.a.w1(Flags.IS_NOT_DEFAULT, getterFlags, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean w13 = a2.b.a.a.a.w1(Flags.IS_EXTERNAL_ACCESSOR, getterFlags, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean w14 = a2.b.a.a.a.w1(Flags.IS_INLINE_ACCESSOR, getterFlags, "IS_INLINE_ACCESSOR.get(getterFlags)");
            Annotations e3 = e(property2, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (w12) {
                protoEnumFlags = protoEnumFlags2;
                flagField2 = flagField3;
                deserializationContext = childContext$default;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                flagField = flagField4;
                property3 = property2;
                propertyGetterDescriptorImpl2 = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, e3, protoEnumFlags2.modality(flagField3.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, flagField4.get(getterFlags)), !w12, w13, w14, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                deserializationContext = childContext$default;
                flagField = flagField4;
                flagField2 = flagField3;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property3 = property2;
                protoEnumFlags = protoEnumFlags2;
                propertyGetterDescriptorImpl2 = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor2, e3);
                Intrinsics.checkNotNullExpressionValue(propertyGetterDescriptorImpl2, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            propertyGetterDescriptorImpl2.initialize(deserializedPropertyDescriptor2.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl2;
        } else {
            deserializationContext = childContext$default;
            flagField = flagField4;
            flagField2 = flagField3;
            deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
            property3 = property2;
            protoEnumFlags = protoEnumFlags2;
            propertyGetterDescriptorImpl = null;
        }
        if (a2.b.a.a.a.w1(Flags.HAS_SETTER, i, "HAS_SETTER.get(flags)")) {
            if (property.hasSetterFlags()) {
                accessorFlags = property.getSetterFlags();
            }
            boolean w15 = a2.b.a.a.a.w1(Flags.IS_NOT_DEFAULT, accessorFlags, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean w16 = a2.b.a.a.a.w1(Flags.IS_EXTERNAL_ACCESSOR, accessorFlags, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean w17 = a2.b.a.a.a.w1(Flags.IS_INLINE_ACCESSOR, accessorFlags, "IS_INLINE_ACCESSOR.get(setterFlags)");
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations e4 = e(property3, accessorFlags, annotatedCallableKind);
            if (w15) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor2, e4, protoEnumFlags.modality(flagField2.get(accessorFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, flagField.get(accessorFlags)), !w15, w16, w17, deserializedPropertyDescriptor2.getKind(), null, SourceElement.NO_SOURCE);
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) DeserializationContext.childContext$default(deserializationContext, propertySetterDescriptorImpl2, CollectionsKt__CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().h(t6.n.d.listOf(property.getSetterValueParameter()), property3, annotatedCallableKind)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                PropertySetterDescriptorImpl createDefaultSetter = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor2, e4, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNullExpressionValue(createDefaultSetter, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
                propertySetterDescriptorImpl = createDefaultSetter;
            }
        } else {
            propertySetterDescriptorImpl = null;
        }
        if (a2.b.a.a.a.w1(Flags.HAS_CONSTANT, i, "HAS_CONSTANT.get(flags)")) {
            memberDeserializer = this;
            deserializedPropertyDescriptor2.setCompileTimeInitializer(memberDeserializer.a.getStorageManager().createNullableLazyValue(new d(memberDeserializer, property3, deserializedPropertyDescriptor2)));
        } else {
            memberDeserializer = this;
        }
        deserializedPropertyDescriptor2.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, new FieldDescriptorImpl(memberDeserializer.g(property3, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(memberDeserializer.g(property3, true), deserializedPropertyDescriptor2), memberDeserializer.b(deserializedPropertyDescriptor2, deserializationContext.getTypeDeserializer()));
        return deserializedPropertyDescriptor2;
    }

    @NotNull
    public final TypeAliasDescriptor loadTypeAlias(@NotNull ProtoBuf.TypeAlias typeAlias) {
        Intrinsics.checkNotNullParameter(typeAlias, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(annotationList, 10));
        for (T t : annotationList) {
            AnnotationDeserializer annotationDeserializer = this.b;
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(annotationDeserializer.deserializeAnnotation(t, this.a.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.a.getStorageManager(), this.a.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.a.getNameResolver(), typeAlias.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(typeAlias.getFlags())), typeAlias, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource());
        DeserializationContext deserializationContext = this.a;
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(typeAlias, this.a.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(typeAlias, this.a.getTypeTable()), false), b(deserializedTypeAliasDescriptor, childContext$default.getTypeDeserializer()));
        return deserializedTypeAliasDescriptor;
    }
}
