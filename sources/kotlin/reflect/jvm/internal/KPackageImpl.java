package kotlin.reflect.jvm.internal;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u00014B\u001f\u0012\n\u0010,\u001a\u0006\u0012\u0002\b\u00030\u001f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b2\u00103J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u001f8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R,\u0010(\u001a\u0018\u0012\u0014\u0012\u0012 %*\b\u0018\u00010$R\u00020\u00000$R\u00020\u00000#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010,\u001a\u0006\u0012\u0002\b\u00030\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010!R\u0016\u00100\u001a\u00020-8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", FirebaseAnalytics.Param.INDEX, "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/KCallable;", "getMembers", "members", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$a;", "kotlin.jvm.PlatformType", "c", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "data", "d", "Ljava/lang/Class;", "getJClass", "jClass", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "usageModuleName", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", AuthSource.SEND_ABUSE, "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KPackageImpl extends KDeclarationContainerImpl {
    public final ReflectProperties.LazyVal<a> c;
    @NotNull
    public final Class<?> d;

    public final class a extends KDeclarationContainerImpl.Data {
        public static final /* synthetic */ KProperty[] j = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        public final ReflectProperties.LazySoftVal d = ReflectProperties.lazySoft(new C0506a(this));
        @NotNull
        public final ReflectProperties.LazySoftVal e = ReflectProperties.lazySoft(new e(this));
        @Nullable
        public final ReflectProperties.LazyVal f = ReflectProperties.lazy(new d(this));
        @Nullable
        public final ReflectProperties.LazyVal g = ReflectProperties.lazy(new c(this));
        @NotNull
        public final ReflectProperties.LazySoftVal h = ReflectProperties.lazySoft(new b(this));

        /* renamed from: kotlin.reflect.jvm.internal.KPackageImpl$a$a  reason: collision with other inner class name */
        public static final class C0506a extends Lambda implements Function0<ReflectKotlinClass> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0506a(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public ReflectKotlinClass invoke() {
                return ReflectKotlinClass.Factory.create(KPackageImpl.this.getJClass());
            }
        }

        public static final class b extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Collection<? extends KCallableImpl<?>> invoke() {
                a aVar = this.a;
                return KPackageImpl.this.getMembers((MemberScope) aVar.e.getValue(aVar, a.j[1]), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
            }
        }

        public static final class c extends Lambda implements Function0<Triple<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion>> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Triple<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion> invoke() {
                KotlinClassHeader classHeader;
                ReflectKotlinClass a3 = a.a(this.a);
                if (a3 == null || (classHeader = a3.getClassHeader()) == null) {
                    return null;
                }
                String[] data = classHeader.getData();
                String[] strings = classHeader.getStrings();
                if (data == null || strings == null) {
                    return null;
                }
                Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
                return new Triple<>(readPackageDataFrom.component1(), readPackageDataFrom.component2(), classHeader.getMetadataVersion());
            }
        }

        public static final class d extends Lambda implements Function0<Class<?>> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Class<?> invoke() {
                KotlinClassHeader classHeader;
                ReflectKotlinClass a3 = a.a(this.a);
                String multifileClassName = (a3 == null || (classHeader = a3.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
                if (multifileClassName == null) {
                    return null;
                }
                if (multifileClassName.length() > 0) {
                    return KPackageImpl.this.getJClass().getClassLoader().loadClass(m.replace$default(multifileClassName, '/', (char) FormatterType.defaultDecimalSeparator, false, 4, (Object) null));
                }
                return null;
            }
        }

        public static final class e extends Lambda implements Function0<MemberScope> {
            public final /* synthetic */ a a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(a aVar) {
                super(0);
                this.a = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public MemberScope invoke() {
                ReflectKotlinClass a3 = a.a(this.a);
                if (a3 != null) {
                    return this.a.getModuleData().getPackagePartScopeCache().getPackagePartScope(a3);
                }
                return MemberScope.Empty.INSTANCE;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            super();
        }

        public static final ReflectKotlinClass a(a aVar) {
            return (ReflectKotlinClass) aVar.d.getValue(aVar, j[0]);
        }
    }

    public static final class b extends Lambda implements Function0<a> {
        public final /* synthetic */ KPackageImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KPackageImpl kPackageImpl) {
            super(0);
            this.a = kPackageImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public a invoke() {
            return new a();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KPackageImpl(Class cls, String str, int i, j jVar) {
        this(cls, (i & 2) != 0 ? null : str);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KPackageImpl) && Intrinsics.areEqual(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return h().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public PropertyDescriptor getLocalProperty(int i) {
        a invoke = this.c.invoke();
        Triple triple = (Triple) invoke.g.getValue(invoke, a.j[3]);
        if (triple == null) {
            return null;
        }
        JvmNameResolver jvmNameResolver = (JvmNameResolver) triple.component1();
        ProtoBuf.Package r2 = (ProtoBuf.Package) triple.component2();
        JvmMetadataVersion jvmMetadataVersion = (JvmMetadataVersion) triple.component3();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.packageLocalVariable;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "JvmProtoBuf.packageLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(r2, generatedExtension, i);
        if (property == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        ProtoBuf.TypeTable typeTable = r2.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "packageProto.typeTable");
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(jClass, property, jvmNameResolver, new TypeTable(typeTable), jvmMetadataVersion, c.a);
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        a invoke = this.c.invoke();
        return (Collection) invoke.h.getValue(invoke, a.j[4]);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Class<?> getMethodOwner() {
        a invoke = this.c.invoke();
        Class<?> cls = (Class) invoke.f.getValue(invoke, a.j[2]);
        return cls != null ? cls : getJClass();
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> */
    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return h().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION);
    }

    public final MemberScope h() {
        a invoke = this.c.invoke();
        return (MemberScope) invoke.e.getValue(invoke, a.j[1]);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("file class ");
        L.append(ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName());
        return L.toString();
    }

    public KPackageImpl(@NotNull Class<?> cls, @Nullable String str) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.d = cls;
        ReflectProperties.LazyVal<a> lazy = ReflectProperties.lazy(new b(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Data() }");
        this.c = lazy;
    }
}
