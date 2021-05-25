package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.y.m;
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    @NotNull
    public final KotlinClassFinder a;
    @NotNull
    public final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, b<A, C>> b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AnnotatedCallableKind.values();
            int[] iArr = new int[4];
            iArr[2] = 1;
            iArr[3] = 2;
            iArr[1] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public enum a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    public static final class b<A, C> {
        @NotNull
        public final Map<MemberSignature, List<A>> a;
        @NotNull
        public final Map<MemberSignature, C> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends java.util.List<? extends A>> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends C> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Map<MemberSignature, ? extends List<? extends A>> map, @NotNull Map<MemberSignature, ? extends C> map2) {
            Intrinsics.checkNotNullParameter(map, "memberAnnotations");
            Intrinsics.checkNotNullParameter(map2, "propertyConstants");
            this.a = map;
            this.b = map2;
        }
    }

    public static final class c extends Lambda implements Function1<KotlinJvmBinaryClass, b<? extends A, ? extends C>> {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
            super(1);
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
            KotlinJvmBinaryClass kotlinJvmBinaryClass2 = kotlinJvmBinaryClass;
            Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass2, "kotlinClass");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationsAndInitializers(this.a, kotlinJvmBinaryClass2);
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(@NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.a = kotlinClassFinder;
        this.b = storageManager.createMemoizedFunction(new c(this));
    }

    public static final KotlinJvmBinaryClass.AnnotationArgumentVisitor access$loadAnnotationIfNotSpecial(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ClassId classId, SourceElement sourceElement, List list) {
        Objects.requireNonNull(abstractBinaryClassAnnotationAndConstantLoader);
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(classId)) {
            return null;
        }
        return abstractBinaryClassAnnotationAndConstantLoader.loadAnnotation(classId, sourceElement, list);
    }

    public static final b access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Objects.requireNonNull(abstractBinaryClassAnnotationAndConstantLoader);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(abstractBinaryClassAnnotationAndConstantLoader, hashMap, hashMap2), abstractBinaryClassAnnotationAndConstantLoader.getCachedFileContent(kotlinJvmBinaryClass));
        return new b(hashMap, hashMap2);
    }

    public static /* synthetic */ List b(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.a(protoContainer, memberSignature, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z3);
    }

    public static /* synthetic */ MemberSignature d(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.c(messageLite, nameResolver, typeTable, annotatedCallableKind, (i & 16) != 0 ? false : z);
    }

    public static /* synthetic */ MemberSignature f(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.e(property, nameResolver, typeTable, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
    }

    public final List<A> a(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3) {
        KotlinJvmBinaryClass g = g(protoContainer, z, z2, bool, z3);
        if (g == null) {
            g = protoContainer instanceof ProtoContainer.Class ? i((ProtoContainer.Class) protoContainer) : null;
        }
        if (g == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<A> list = this.b.invoke(g).a.get(memberSignature);
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    public final MemberSignature c(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        if (messageLite instanceof ProtoBuf.Constructor) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        } else if (messageLite instanceof ProtoBuf.Function) {
            MemberSignature.Companion companion2 = MemberSignature.Companion;
            JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        } else if (!(messageLite instanceof ProtoBuf.Property)) {
            return null;
        } else {
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) messageLite, generatedExtension);
            if (jvmPropertySignature == null) {
                return null;
            }
            int ordinal = annotatedCallableKind.ordinal();
            if (ordinal == 1) {
                return e((ProtoBuf.Property) messageLite, nameResolver, typeTable, true, true, z);
            }
            if (ordinal != 2) {
                if (ordinal != 3 || !jvmPropertySignature.hasSetter()) {
                    return null;
                }
                MemberSignature.Companion companion3 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                Intrinsics.checkNotNullExpressionValue(setter, "signature.setter");
                return companion3.fromMethod(nameResolver, setter);
            } else if (!jvmPropertySignature.hasGetter()) {
                return null;
            } else {
                MemberSignature.Companion companion4 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                Intrinsics.checkNotNullExpressionValue(getter, "signature.getter");
                return companion4.fromMethod(nameResolver, getter);
            }
        }
    }

    public final MemberSignature e(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3) {
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            JvmMemberSignature.Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(property, nameResolver, typeTable, z3);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
        } else if (!z2 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        } else {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
            Intrinsics.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
            return companion.fromMethod(nameResolver, syntheticMethod);
        }
    }

    public final KotlinJvmBinaryClass g(ProtoContainer protoContainer, boolean z, boolean z2, Boolean bool, boolean z3) {
        ProtoContainer.Class outerClass;
        if (z) {
            if (bool != null) {
                if (protoContainer instanceof ProtoContainer.Class) {
                    ProtoContainer.Class r8 = (ProtoContainer.Class) protoContainer;
                    if (r8.getKind() == ProtoBuf.Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder = this.a;
                        ClassId createNestedClassId = r8.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, createNestedClassId);
                    }
                }
                if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.Package)) {
                    SourceElement source = protoContainer.getSource();
                    JvmPackagePartSource jvmPackagePartSource = source instanceof JvmPackagePartSource ? (JvmPackagePartSource) source : null;
                    JvmClassName facadeClassName = jvmPackagePartSource == null ? null : jvmPackagePartSource.getFacadeClassName();
                    if (facadeClassName != null) {
                        KotlinClassFinder kotlinClassFinder2 = this.a;
                        String internalName = facadeClassName.getInternalName();
                        Intrinsics.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                        ClassId classId = ClassId.topLevel(new FqName(m.replace$default(internalName, '/', (char) FormatterType.defaultDecimalSeparator, false, 4, (Object) null)));
                        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder2, classId);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
        }
        if (z2 && (protoContainer instanceof ProtoContainer.Class)) {
            ProtoContainer.Class r82 = (ProtoContainer.Class) protoContainer;
            if (r82.getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = r82.getOuterClass()) != null && (outerClass.getKind() == ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS || (z3 && (outerClass.getKind() == ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return i(outerClass);
            }
        }
        if (!(protoContainer instanceof ProtoContainer.Package) || !(protoContainer.getSource() instanceof JvmPackagePartSource)) {
            return null;
        }
        SourceElement source2 = protoContainer.getSource();
        Objects.requireNonNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
        return knownJvmBinaryClass == null ? KotlinClassFinderKt.findKotlinClass(this.a, jvmPackagePartSource2.getClassId()) : knownJvmBinaryClass;
    }

    @Nullable
    public byte[] getCachedFileContent(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        return null;
    }

    public final List<A> h(ProtoContainer protoContainer, ProtoBuf.Property property, a aVar) {
        Boolean bool = Flags.IS_CONST.get(property.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean booleanValue = bool.booleanValue();
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(property);
        if (aVar == a.PROPERTY) {
            MemberSignature f = f(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            if (f == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return b(this, protoContainer, f, true, false, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature f2 = f(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (f2 == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z = false;
        boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) f2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null);
        if (aVar == a.DELEGATE_FIELD) {
            z = true;
        }
        if (contains$default != z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return a(protoContainer, f2, true, true, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion);
    }

    public final KotlinJvmBinaryClass i(ProtoContainer.Class r3) {
        SourceElement source = r3.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.getBinaryClass();
    }

    @Nullable
    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement, @NotNull List<A> list);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadCallableAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, MessageBody.Location.KIND);
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return h(protoContainer, (ProtoBuf.Property) messageLite, a.PROPERTY);
        }
        MemberSignature d = d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (d == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return b(this, protoContainer, d, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadClassAnnotations(@NotNull ProtoContainer.Class r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        KotlinJvmBinaryClass i = i(r4);
        if (i != null) {
            ArrayList arrayList = new ArrayList(1);
            i.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor(this, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1
                public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
                public final /* synthetic */ ArrayList<A> b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                @Nullable
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
                    Intrinsics.checkNotNullParameter(classId, "classId");
                    Intrinsics.checkNotNullParameter(sourceElement, "source");
                    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.a, classId, sourceElement, this.b);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                }
            }, getCachedFileContent(i));
            return arrayList;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Class for loading annotations is not found: ", r4.debugFqName()).toString());
    }

    @Nullable
    public abstract C loadConstant(@NotNull String str, @NotNull Object obj);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadEnumEntryAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.EnumEntry enumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(enumEntry, "proto");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String string = protoContainer.getNameResolver().getString(enumEntry.getName());
        ClassMapperLite classMapperLite = ClassMapperLite.INSTANCE;
        String asString = ((ProtoContainer.Class) protoContainer).getClassId().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "container as ProtoContainer.Class).classId.asString()");
        return b(this, protoContainer, companion.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(asString)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadExtensionReceiverParameterAnnotations(@NotNull ProtoContainer protoContainer, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, MessageBody.Location.KIND);
        MemberSignature d = d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (d != null) {
            return b(this, protoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(d, 0), false, false, null, false, 60, null);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadPropertyBackingFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        return h(protoContainer, property, a.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property, @NotNull KotlinType kotlinType) {
        MemberSignature c2;
        C c3;
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        Boolean bool = Flags.IS_CONST.get(property.getFlags());
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.INSTANCE;
        KotlinJvmBinaryClass g = g(protoContainer, true, true, bool, JvmProtoBufUtil.isMovedFromInterfaceCompanion(property));
        if (g == null) {
            g = protoContainer instanceof ProtoContainer.Class ? i((ProtoContainer.Class) protoContainer) : null;
        }
        if (g == null || (c2 = c(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), AnnotatedCallableKind.PROPERTY, g.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()))) == null || (c3 = this.b.invoke(g).b.get(c2)) == null) {
            return null;
        }
        UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
        return UnsignedTypes.isUnsignedType(kotlinType) ? transformToUnsignedConstant(c3) : c3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadPropertyDelegateFieldAnnotations(@NotNull ProtoContainer protoContainer, @NotNull ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        return h(protoContainer, property, a.DELEGATE_FIELD);
    }

    @NotNull
    public abstract A loadTypeAnnotation(@NotNull ProtoBuf.Annotation annotation, @NotNull NameResolver nameResolver);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadTypeAnnotations(@NotNull ProtoBuf.Type type, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = type.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            Intrinsics.checkNotNullExpressionValue(annotation, "it");
            arrayList.add(loadTypeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(typeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = typeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            Intrinsics.checkNotNullExpressionValue(annotation, "it");
            arrayList.add(loadTypeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r11.isInner() != false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r11) != false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r11) != false) goto L_0x005d;
     */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<A> loadValueParameterAnnotations(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r12, int r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter r14) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "callableProto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r10.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r4 = r10.getTypeTable()
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r2 = r11
            r5 = r12
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature r12 = d(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 == 0) goto L_0x0082
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function
            r0 = 1
            if (r14 == 0) goto L_0x0037
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r11
            boolean r11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver(r11)
            if (r11 == 0) goto L_0x005c
            goto L_0x005d
        L_0x0037:
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property
            if (r14 == 0) goto L_0x0044
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r11
            boolean r11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver(r11)
            if (r11 == 0) goto L_0x005c
            goto L_0x005d
        L_0x0044:
            boolean r14 = r11 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor
            if (r14 == 0) goto L_0x0072
            r11 = r10
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer$Class r11 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) r11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r14 = r11.getKind()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$Kind r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ENUM_CLASS
            if (r14 != r1) goto L_0x0055
            r0 = 2
            goto L_0x005d
        L_0x0055:
            boolean r11 = r11.isInner()
            if (r11 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            int r13 = r13 + r0
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature$Companion r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature r2 = r11.fromMethodSignatureAndParameterIndex(r12, r13)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 60
            r8 = 0
            r0 = r9
            r1 = r10
            java.util.List r10 = b(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            return r10
        L_0x0072:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.Class r11 = r11.getClass()
            java.lang.String r12 = "Unsupported message: "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r11)
            r10.<init>(r11)
            throw r10
        L_0x0082:
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadValueParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind, int, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter):java.util.List");
    }

    @Nullable
    public abstract C transformToUnsignedConstant(@NotNull C c2);
}
