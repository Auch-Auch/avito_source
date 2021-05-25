package kotlin.reflect.jvm.internal;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u0006:\u0001iB\u0015\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\bg\u0010hJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\"\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R \u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R \u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u001c\u00105\u001a\b\u0012\u0004\u0012\u000202018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R;\u0010=\u001a$\u0012 \u0012\u001e 8*\u000e\u0018\u000107R\b\u0012\u0004\u0012\u00028\u00000\u000007R\b\u0012\u0004\u0012\u00028\u00000\u0000068\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020>018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b?\u00104R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020A018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u00104R\u0016\u0010D\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u001fR\u0018\u0010H\u001a\u0004\u0018\u00010E8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u001fR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020J0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010*R\u0018\u0010O\u001a\u0004\u0018\u00018\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u001fR\u0016\u0010Q\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u001fR\u0016\u0010R\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u001fR\u0016\u0010S\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u001fR\u0018\u0010U\u001a\u0004\u0018\u00010\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u001dR$\u0010W\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bV\u00104R\u0016\u0010X\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u001fR\u0016\u0010\\\u001a\u00020Y8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020a8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\be\u0010c¨\u0006j"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "", "T", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", FirebaseAnalytics.Param.INDEX, "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "value", "", "isInstance", "(Ljava/lang/Object;)Z", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isFun", "()Z", "getQualifiedName", "qualifiedName", "Ljava/lang/Class;", "d", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "jClass", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "getNestedClasses", "nestedClasses", "Lkotlin/reflect/KCallable;", "getMembers", "members", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "c", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "data", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes", "isData", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "isAbstract", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "constructorDescriptors", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "isCompanion", DecodeProducer.EXTRA_IS_FINAL, "isOpen", "isInner", "getSimpleName", "simpleName", "getSealedSubclasses", "sealedSubclasses", "isSealed", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "<init>", "(Ljava/lang/Class;)V", "Data", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    @NotNull
    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> c;
    @NotNull
    public final Class<T> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001b\n\u0002\b\u0015\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\bM\u0010NR'\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR'\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR/\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u00038F@\u0006X\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\bR#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u00198F@\u0006X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001e8F@\u0006X\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010!R+\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000#0\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010\u0017R'\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038B@\u0002X\u0002¢\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\bR'\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038B@\u0002X\u0002¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\bR#\u00100\u001a\b\u0012\u0004\u0012\u00020-0\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\u0017R%\u00106\u001a\u0004\u0018\u00018\u00008F@\u0006X\u0002¢\u0006\u0012\n\u0004\b1\u00102\u0012\u0004\b5\u0010\u0011\u001a\u0004\b3\u00104R'\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038F@\u0006X\u0002¢\u0006\f\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\bR#\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\u0017R\u001f\u0010@\u001a\u0004\u0018\u00010\u00198F@\u0006X\u0002¢\u0006\f\n\u0004\b>\u0010\u0006\u001a\u0004\b?\u0010\u001cR'\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038F@\u0006X\u0002¢\u0006\f\n\u0004\bA\u0010\u0006\u001a\u0004\bB\u0010\bR'\u0010F\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038F@\u0006X\u0002¢\u0006\f\n\u0004\bD\u0010\u0006\u001a\u0004\bE\u0010\bR'\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\u00038F@\u0006X\u0002¢\u0006\f\n\u0004\bG\u0010\u0006\u001a\u0004\bH\u0010\bR'\u0010L\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038F@\u0006X\u0002¢\u0006\f\n\u0004\bJ\u0010\u0006\u001a\u0004\bK\u0010\b¨\u0006O"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "s", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getAllStaticMembers", "()Ljava/util/Collection;", "allStaticMembers", "o", "getDeclaredStaticMembers", "declaredStaticMembers", "Lkotlin/reflect/KFunction;", "h", "getConstructors", "getConstructors$annotations", "()V", "constructors", "", "Lkotlin/reflect/KType;", "l", "getSupertypes", "()Ljava/util/List;", "supertypes", "", a2.g.r.g.a, "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "d", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "Lkotlin/reflect/KClass;", AuthSource.OPEN_CHANNEL_LIST, "getSealedSubclasses", "sealedSubclasses", "p", "getInheritedNonStaticMembers", "inheritedNonStaticMembers", VKApiConst.Q, "getInheritedStaticMembers", "inheritedStaticMembers", "Lkotlin/reflect/KTypeParameter;", "k", "getTypeParameters", "typeParameters", "j", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getObjectInstance", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "r", "getAllNonStaticMembers", "allNonStaticMembers", "", "e", "getAnnotations", "annotations", "f", "getSimpleName", "simpleName", "n", "getDeclaredNonStaticMembers", "declaredNonStaticMembers", "t", "getDeclaredMembers", "declaredMembers", "i", "getNestedClasses", "nestedClasses", "u", "getAllMembers", "allMembers", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public final class Data extends KDeclarationContainerImpl.Data {
        public static final /* synthetic */ KProperty[] w = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        @NotNull
        public final ReflectProperties.LazySoftVal d = ReflectProperties.lazySoft(new f(this));
        @NotNull
        public final ReflectProperties.LazySoftVal e = ReflectProperties.lazySoft(new d(this));
        @Nullable
        public final ReflectProperties.LazySoftVal f = ReflectProperties.lazySoft(new c(1, this));
        @Nullable
        public final ReflectProperties.LazySoftVal g = ReflectProperties.lazySoft(new c(0, this));
        @NotNull
        public final ReflectProperties.LazySoftVal h = ReflectProperties.lazySoft(new e(this));
        @NotNull
        public final ReflectProperties.LazySoftVal i = ReflectProperties.lazySoft(new g(this));
        @Nullable
        public final ReflectProperties.LazyVal j = ReflectProperties.lazy(new h(this));
        @NotNull
        public final ReflectProperties.LazySoftVal k = ReflectProperties.lazySoft(new k(this));
        @NotNull
        public final ReflectProperties.LazySoftVal l = ReflectProperties.lazySoft(new j(this));
        @NotNull
        public final ReflectProperties.LazySoftVal m = ReflectProperties.lazySoft(new i(this));
        @NotNull
        public final ReflectProperties.LazySoftVal n = ReflectProperties.lazySoft(new a(0, this));
        public final ReflectProperties.LazySoftVal o = ReflectProperties.lazySoft(new a(1, this));
        public final ReflectProperties.LazySoftVal p = ReflectProperties.lazySoft(new a(2, this));
        public final ReflectProperties.LazySoftVal q = ReflectProperties.lazySoft(new a(3, this));
        @NotNull
        public final ReflectProperties.LazySoftVal r = ReflectProperties.lazySoft(new b(1, this));
        @NotNull
        public final ReflectProperties.LazySoftVal s = ReflectProperties.lazySoft(new b(2, this));
        @NotNull
        public final ReflectProperties.LazySoftVal t = ReflectProperties.lazySoft(new b(3, this));
        @NotNull
        public final ReflectProperties.LazySoftVal u = ReflectProperties.lazySoft(new b(0, this));

        /* compiled from: kotlin-style lambda group */
        public static final class a extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(int i, Object obj) {
                super(0);
                this.a = i;
                this.b = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KCallableImpl<?>> invoke() {
                int i = this.a;
                if (i == 0) {
                    KClassImpl kClassImpl = KClassImpl.this;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                } else if (i == 1) {
                    KClassImpl kClassImpl2 = KClassImpl.this;
                    return kClassImpl2.getMembers(kClassImpl2.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                } else if (i == 2) {
                    KClassImpl kClassImpl3 = KClassImpl.this;
                    return kClassImpl3.getMembers(kClassImpl3.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                } else if (i == 3) {
                    KClassImpl kClassImpl4 = KClassImpl.this;
                    return kClassImpl4.getMembers(kClassImpl4.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                } else {
                    throw null;
                }
            }
        }

        /* compiled from: kotlin-style lambda group */
        public static final class b extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(int i, Object obj) {
                super(0);
                this.a = i;
                this.b = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                int i = this.a;
                if (i == 0) {
                    return CollectionsKt___CollectionsKt.plus((Collection) ((Data) this.b).getAllNonStaticMembers(), (Iterable) ((Data) this.b).getAllStaticMembers());
                }
                if (i == 1) {
                    return CollectionsKt___CollectionsKt.plus((Collection) ((Data) this.b).getDeclaredNonStaticMembers(), (Iterable) Data.access$getInheritedNonStaticMembers$p((Data) this.b));
                }
                if (i == 2) {
                    return CollectionsKt___CollectionsKt.plus(Data.access$getDeclaredStaticMembers$p((Data) this.b), (Iterable) Data.access$getInheritedStaticMembers$p((Data) this.b));
                }
                if (i == 3) {
                    return CollectionsKt___CollectionsKt.plus((Collection) ((Data) this.b).getDeclaredNonStaticMembers(), (Iterable) Data.access$getDeclaredStaticMembers$p((Data) this.b));
                }
                throw null;
            }
        }

        /* compiled from: kotlin-style lambda group */
        public static final class c extends Lambda implements Function0<String> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(int i, Object obj) {
                super(0);
                this.a = i;
                this.b = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                int i = this.a;
                if (i != 0) {
                    if (i != 1) {
                        throw null;
                    } else if (KClassImpl.this.getJClass().isAnonymousClass()) {
                        return null;
                    } else {
                        ClassId access$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                        if (access$getClassId$p.isLocal()) {
                            Data data = (Data) this.b;
                            return Data.access$calculateLocalClassName(data, KClassImpl.this.getJClass());
                        }
                        String asString = access$getClassId$p.getShortClassName().asString();
                        Intrinsics.checkNotNullExpressionValue(asString, "classId.shortClassName.asString()");
                        return asString;
                    }
                } else if (KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                } else {
                    ClassId access$getClassId$p2 = KClassImpl.access$getClassId$p(KClassImpl.this);
                    if (access$getClassId$p2.isLocal()) {
                        return null;
                    }
                    return access$getClassId$p2.asSingleFqName().asString();
                }
            }
        }

        public static final class d extends Lambda implements Function0<List<? extends Annotation>> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(Data data) {
                super(0);
                this.a = data;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Annotation> invoke() {
                return UtilKt.computeAnnotations(this.a.getDescriptor());
            }
        }

        public static final class e extends Lambda implements Function0<List<? extends KFunction<? extends T>>> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(Data data) {
                super(0);
                this.a = data;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Collection<ConstructorDescriptor> constructorDescriptors = KClassImpl.this.getConstructorDescriptors();
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(constructorDescriptors, 10));
                Iterator<T> it = constructorDescriptors.iterator();
                while (it.hasNext()) {
                    arrayList.add(new KFunctionImpl(KClassImpl.this, it.next()));
                }
                return arrayList;
            }
        }

        public static final class f extends Lambda implements Function0<ClassDescriptor> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(Data data) {
                super(0);
                this.a = data;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public ClassDescriptor invoke() {
                ClassDescriptor classDescriptor;
                ClassId access$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                RuntimeModuleData moduleData = KClassImpl.this.getData().invoke().getModuleData();
                if (access$getClassId$p.isLocal()) {
                    classDescriptor = moduleData.getDeserialization().deserializeClass(access$getClassId$p);
                } else {
                    classDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData.getModule(), access$getClassId$p);
                }
                if (classDescriptor != null) {
                    return classDescriptor;
                }
                KClassImpl.access$reportUnresolvedClass(KClassImpl.this);
                throw null;
            }
        }

        public static final class g extends Lambda implements Function0<List<? extends KClassImpl<? extends Object>>> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(Data data) {
                super(0);
                this.a = data;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends KClassImpl<? extends Object>> invoke() {
                Collection contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(this.a.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                ArrayList arrayList = new ArrayList();
                for (T t : contributedDescriptors$default) {
                    if (!DescriptorUtils.isEnumEntry(t)) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) it.next();
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
                    KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                    if (kClassImpl != null) {
                        arrayList2.add(kClassImpl);
                    }
                }
                return arrayList2;
            }
        }

        public static final class h extends Lambda implements Function0<T> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(Data data) {
                super(0);
                this.a = data;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final T invoke() {
                Field field;
                ClassDescriptor descriptor = this.a.getDescriptor();
                if (descriptor.getKind() != ClassKind.OBJECT) {
                    return null;
                }
                if (!descriptor.isCompanionObject() || CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, descriptor)) {
                    field = KClassImpl.this.getJClass().getDeclaredField("INSTANCE");
                } else {
                    field = KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString());
                }
                T t = (T) field.get(null);
                Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                return t;
            }
        }

        public static final class i extends Lambda implements Function0<List<? extends KClassImpl<? extends T>>> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public i(Data data) {
                super(0);
                this.a = data;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Collection<ClassDescriptor> sealedSubclasses = this.a.getDescriptor().getSealedSubclasses();
                Intrinsics.checkNotNullExpressionValue(sealedSubclasses, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (T t : sealedSubclasses) {
                    Objects.requireNonNull(t, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = UtilKt.toJavaClass(t);
                    KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                    if (kClassImpl != null) {
                        arrayList.add(kClassImpl);
                    }
                }
                return arrayList;
            }
        }

        public static final class j extends Lambda implements Function0<List<? extends KTypeImpl>> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public j(Data data) {
                super(0);
                this.a = data;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends KTypeImpl> invoke() {
                boolean z;
                TypeConstructor typeConstructor = this.a.getDescriptor().getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
                Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
                Intrinsics.checkNotNullExpressionValue(supertypes, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(supertypes.size());
                for (T t : supertypes) {
                    Intrinsics.checkNotNullExpressionValue(t, "kotlinType");
                    arrayList.add(new KTypeImpl(t, new t6.w.f.a.c(t, this)));
                }
                if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.a.getDescriptor())) {
                    boolean z2 = true;
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ClassDescriptor classDescriptorForType = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType());
                            Intrinsics.checkNotNullExpressionValue(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                            ClassKind kind = classDescriptorForType.getKind();
                            Intrinsics.checkNotNullExpressionValue(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                            if (kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (!z) {
                                z2 = false;
                                break;
                            }
                        }
                    }
                    if (z2) {
                        SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this.a.getDescriptor()).getAnyType();
                        Intrinsics.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                        arrayList.add(new KTypeImpl(anyType, t6.w.f.a.d.a));
                    }
                }
                return CollectionsKt.compact(arrayList);
            }
        }

        public static final class k extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public k(Data data) {
                super(0);
                this.a = data;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends KTypeParameterImpl> invoke() {
                List<TypeParameterDescriptor> declaredTypeParameters = this.a.getDescriptor().getDeclaredTypeParameters();
                Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(declaredTypeParameters, 10));
                for (T t : declaredTypeParameters) {
                    KClassImpl kClassImpl = KClassImpl.this;
                    Intrinsics.checkNotNullExpressionValue(t, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kClassImpl, t));
                }
                return arrayList;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public Data() {
            super();
        }

        public static final String access$calculateLocalClassName(Data data, Class cls) {
            Objects.requireNonNull(data);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                return StringsKt__StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                return StringsKt__StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNullExpressionValue(simpleName, "name");
            return StringsKt__StringsKt.substringAfter$default(simpleName, (char) Typography.dollar, (String) null, 2, (Object) null);
        }

        public static final Collection access$getDeclaredStaticMembers$p(Data data) {
            return (Collection) data.o.getValue(data, w[11]);
        }

        public static final Collection access$getInheritedNonStaticMembers$p(Data data) {
            return (Collection) data.p.getValue(data, w[12]);
        }

        public static final Collection access$getInheritedStaticMembers$p(Data data) {
            return (Collection) data.q.getValue(data, w[13]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllMembers() {
            return (Collection) this.u.getValue(this, w[17]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection) this.r.getValue(this, w[14]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection) this.s.getValue(this, w[15]);
        }

        @NotNull
        public final List<Annotation> getAnnotations() {
            return (List) this.e.getValue(this, w[1]);
        }

        @NotNull
        public final Collection<KFunction<T>> getConstructors() {
            return (Collection) this.h.getValue(this, w[4]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            return (Collection) this.t.getValue(this, w[16]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.n.getValue(this, w[10]);
        }

        @NotNull
        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor) this.d.getValue(this, w[0]);
        }

        @NotNull
        public final Collection<KClass<?>> getNestedClasses() {
            return (Collection) this.i.getValue(this, w[5]);
        }

        @Nullable
        public final T getObjectInstance() {
            return (T) this.j.getValue(this, w[6]);
        }

        @Nullable
        public final String getQualifiedName() {
            return (String) this.g.getValue(this, w[3]);
        }

        @NotNull
        public final List<KClass<? extends T>> getSealedSubclasses() {
            return (List) this.m.getValue(this, w[9]);
        }

        @Nullable
        public final String getSimpleName() {
            return (String) this.f.getValue(this, w[2]);
        }

        @NotNull
        public final List<KType> getSupertypes() {
            return (List) this.l.getValue(this, w[8]);
        }

        @NotNull
        public final List<KTypeParameter> getTypeParameters() {
            return (List) this.k.getValue(this, w[7]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            KotlinClassHeader.Kind.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            KotlinClassHeader.Kind kind = KotlinClassHeader.Kind.FILE_FACADE;
            iArr[2] = 1;
            KotlinClassHeader.Kind kind2 = KotlinClassHeader.Kind.MULTIFILE_CLASS;
            iArr[4] = 2;
            KotlinClassHeader.Kind kind3 = KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
            iArr[5] = 3;
            KotlinClassHeader.Kind kind4 = KotlinClassHeader.Kind.SYNTHETIC_CLASS;
            iArr[3] = 4;
            KotlinClassHeader.Kind kind5 = KotlinClassHeader.Kind.UNKNOWN;
            iArr[0] = 5;
            KotlinClassHeader.Kind kind6 = KotlinClassHeader.Kind.CLASS;
            iArr[1] = 6;
        }
    }

    public static final class a extends Lambda implements Function0<KClassImpl<T>.Data> {
        public final /* synthetic */ KClassImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KClassImpl kClassImpl) {
            super(0);
            this.a = kClassImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public KClassImpl<T>.Data invoke() {
            return new Data();
        }
    }

    public KClassImpl(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.d = cls;
        ReflectProperties.LazyVal<KClassImpl<T>.Data> lazy = ReflectProperties.lazy(new a(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Data() }");
        this.c = lazy;
    }

    public static final ClassId access$getClassId$p(KClassImpl kClassImpl) {
        Objects.requireNonNull(kClassImpl);
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(kClassImpl.getJClass());
    }

    public static final Void access$reportUnresolvedClass(KClassImpl kClassImpl) {
        KotlinClassHeader classHeader;
        Objects.requireNonNull(kClassImpl);
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(kClassImpl.getJClass());
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind != null) {
            int ordinal = kind.ordinal();
            if (ordinal == 0) {
                StringBuilder L = a2.b.a.a.a.L("Unknown class: ");
                L.append(kClassImpl.getJClass());
                L.append(" (kind = ");
                L.append(kind);
                L.append(')');
                throw new KotlinReflectionInternalError(L.toString());
            } else if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        StringBuilder Q = a2.b.a.a.a.Q("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ", "library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                        Q.append(kClassImpl.getJClass());
                        throw new UnsupportedOperationException(Q.toString());
                    } else if (!(ordinal == 4 || ordinal == 5)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                StringBuilder Q2 = a2.b.a.a.a.Q("Packages and file facades are not yet supported in Kotlin reflection. ", "Meanwhile please use Java reflection to inspect this class: ");
                Q2.append(kClassImpl.getJClass());
                throw new UnsupportedOperationException(Q2.toString());
            }
        }
        StringBuilder L2 = a2.b.a.a.a.L("Unresolved class: ");
        L2.append(kClassImpl.getJClass());
        throw new KotlinReflectionInternalError(L2.toString());
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.c.invoke().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "descriptor.constructors");
        return constructors;
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<T>> getConstructors() {
        return this.c.invoke().getConstructors();
    }

    @NotNull
    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt___CollectionsKt.plus((Collection) memberScope$kotlin_reflection.getContributedFunctions(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, noLookupLocation));
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<T> getJClass() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public PropertyDescriptor getLocalProperty(int i) {
        Class<?> declaringClass;
        if (!Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") || (declaringClass = getJClass().getDeclaringClass()) == null || !declaringClass.isInterface()) {
            ClassDescriptor descriptor = getDescriptor();
            if (!(descriptor instanceof DeserializedClassDescriptor)) {
                descriptor = null;
            }
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            ProtoBuf.Class classProto = deserializedClassDescriptor.getClassProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.classLocalVariable;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "JvmProtoBuf.classLocalVariable");
            ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(classProto, generatedExtension, i);
            if (property != null) {
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), b.a);
            }
            return null;
        }
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(declaringClass);
        Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        return ((KClassImpl) kotlinClass).getLocalProperty(i);
    }

    @NotNull
    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.c.invoke().getAllMembers();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        return this.c.invoke().getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public T getObjectInstance() {
        return (T) this.c.invoke().getObjectInstance();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt___CollectionsKt.plus((Collection) memberScope$kotlin_reflection.getContributedVariables(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, noLookupLocation));
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return this.c.invoke().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.c.invoke().getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return this.c.invoke().getSimpleName();
    }

    @NotNull
    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        return this.c.invoke().getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        return this.c.invoke().getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(@Nullable Object obj) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return TypeIntrinsics.isFunctionOfArity(obj, functionClassArity.intValue());
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(obj);
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        return getDescriptor().getModality() == Modality.SEALED;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder L = a2.b.a.a.a.L("class ");
        ClassId mapJvmClassToKotlinClassId = RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
        FqName packageFqName = mapJvmClassToKotlinClassId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String asString = mapJvmClassToKotlinClassId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.relativeClassName.asString()");
        L.append(str + m.replace$default(asString, (char) FormatterType.defaultDecimalSeparator, (char) Typography.dollar, false, 4, (Object) null));
        return L.toString();
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    @NotNull
    public ClassDescriptor getDescriptor() {
        return this.c.invoke().getDescriptor();
    }
}
