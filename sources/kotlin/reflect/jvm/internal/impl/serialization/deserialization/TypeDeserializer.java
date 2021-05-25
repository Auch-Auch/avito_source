package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
public final class TypeDeserializer {
    @NotNull
    public final DeserializationContext a;
    @Nullable
    public final TypeDeserializer b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    public boolean e;
    @NotNull
    public final Function1<Integer, ClassifierDescriptor> f;
    @NotNull
    public final Function1<Integer, ClassifierDescriptor> g;
    @NotNull
    public final Map<Integer, TypeParameterDescriptor> h;

    public static final class a extends Lambda implements Function1<Integer, ClassifierDescriptor> {
        public final /* synthetic */ TypeDeserializer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TypeDeserializer typeDeserializer) {
            super(1);
            this.a = typeDeserializer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ClassifierDescriptor invoke(Integer num) {
            return TypeDeserializer.access$computeClassifierDescriptor(this.a, num.intValue());
        }
    }

    public static final class b extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ TypeDeserializer a;
        public final /* synthetic */ ProtoBuf.Type b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
            super(0);
            this.a = typeDeserializer;
            this.b = type;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends AnnotationDescriptor> invoke() {
            return this.a.a.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.b, this.a.a.getNameResolver());
        }
    }

    public static final class c extends Lambda implements Function1<Integer, ClassifierDescriptor> {
        public final /* synthetic */ TypeDeserializer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(TypeDeserializer typeDeserializer) {
            super(1);
            this.a = typeDeserializer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ClassifierDescriptor invoke(Integer num) {
            return TypeDeserializer.access$computeTypeAliasDescriptor(this.a, num.intValue());
        }
    }

    public static final class e extends Lambda implements Function1<ProtoBuf.Type, ProtoBuf.Type> {
        public final /* synthetic */ TypeDeserializer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(TypeDeserializer typeDeserializer) {
            super(1);
            this.a = typeDeserializer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ProtoBuf.Type invoke(ProtoBuf.Type type) {
            ProtoBuf.Type type2 = type;
            Intrinsics.checkNotNullParameter(type2, "it");
            return ProtoTypeTableUtilKt.outerType(type2, this.a.a.getTypeTable());
        }
    }

    public static final class f extends Lambda implements Function1<ProtoBuf.Type, Integer> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(ProtoBuf.Type type) {
            ProtoBuf.Type type2 = type;
            Intrinsics.checkNotNullParameter(type2, "it");
            return Integer.valueOf(type2.getArgumentCount());
        }
    }

    public TypeDeserializer(@NotNull DeserializationContext deserializationContext, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf.TypeParameter> list, @NotNull String str, @NotNull String str2, boolean z) {
        Map<Integer, TypeParameterDescriptor> map;
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(str2, "containerPresentableName");
        this.a = deserializationContext;
        this.b = typeDeserializer;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new a(this));
        this.g = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new c(this));
        if (list.isEmpty()) {
            map = r.emptyMap();
        } else {
            map = new LinkedHashMap<>();
            int i = 0;
            for (ProtoBuf.TypeParameter typeParameter : list) {
                map.put(Integer.valueOf(typeParameter.getId()), new DeserializedTypeParameterDescriptor(this.a, typeParameter, i));
                i++;
            }
        }
        this.h = map;
    }

    public static final ClassifierDescriptor access$computeClassifierDescriptor(TypeDeserializer typeDeserializer, int i) {
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.a.getNameResolver(), i);
        if (classId.isLocal()) {
            return typeDeserializer.a.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(typeDeserializer.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer typeDeserializer, int i) {
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.a.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(typeDeserializer.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final List<ProtoBuf.Type.Argument> c(ProtoBuf.Type type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "argumentList");
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type, typeDeserializer.a.getTypeTable());
        List<ProtoBuf.Type.Argument> c2 = outerType == null ? null : c(outerType, typeDeserializer);
        if (c2 == null) {
            c2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt___CollectionsKt.plus((Collection) argumentList, (Iterable) c2);
    }

    public static final ClassDescriptor d(TypeDeserializer typeDeserializer, ProtoBuf.Type type, int i) {
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.a.getNameResolver(), i);
        List<Integer> mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(SequencesKt__SequencesKt.generateSequence(type, new e(typeDeserializer)), f.a));
        int count = SequencesKt___SequencesKt.count(SequencesKt__SequencesKt.generateSequence(classId, d.a));
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        return typeDeserializer.a.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.simpleType(type, z);
    }

    public final SimpleType a(int i) {
        if (NameResolverUtilKt.getClassId(this.a.getNameResolver(), i).isLocal()) {
            return this.a.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    public final SimpleType b(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<TypeProjection> dropLast = CollectionsKt___CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(dropLast, 10));
        for (TypeProjection typeProjection : dropLast) {
            arrayList.add(typeProjection.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    public final TypeConstructor e(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.h.get(Integer.valueOf(i));
        TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        TypeDeserializer typeDeserializer = this.b;
        if (typeDeserializer == null) {
            return null;
        }
        return typeDeserializer.e(i);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.e;
    }

    @NotNull
    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt___CollectionsKt.toList(this.h.values());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:132:0x01eb */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25, types: [kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 911
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type, boolean):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    @NotNull
    public String toString() {
        String str = this.c;
        TypeDeserializer typeDeserializer = this.b;
        return Intrinsics.stringPlus(str, typeDeserializer == null ? "" : Intrinsics.stringPlus(". Child of ", typeDeserializer.c));
    }

    @NotNull
    public final KotlinType type(@NotNull ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "proto");
        if (!type.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(type, true);
        }
        String string = this.a.getNameResolver().getString(type.getFlexibleTypeCapabilitiesId());
        SimpleType simpleType$default = simpleType$default(this, type, false, 2, null);
        ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(type, this.a.getTypeTable());
        Intrinsics.checkNotNull(flexibleUpperBound);
        return this.a.getComponents().getFlexibleTypeDeserializer().create(type, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i, j jVar) {
        this(deserializationContext, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z);
    }
}
