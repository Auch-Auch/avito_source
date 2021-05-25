package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.g;
import t6.n.q;
import t6.n.r;
import t6.n.z;
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    public static final /* synthetic */ KProperty<Object>[] e = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    @NotNull
    public final DeserializationContext a;
    @NotNull
    public final a b;
    @NotNull
    public final NotNullLazyValue c;
    @NotNull
    public final NullableLazyValue d;

    public final class OptimizedImplementation implements a {
        public static final /* synthetic */ KProperty<Object>[] j = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull
        public final Map<Name, byte[]> a;
        @NotNull
        public final Map<Name, byte[]> b;
        @NotNull
        public final Map<Name, byte[]> c;
        @NotNull
        public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> d;
        @NotNull
        public final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> e;
        @NotNull
        public final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> f;
        @NotNull
        public final NotNullLazyValue g;
        @NotNull
        public final NotNullLazyValue h;
        public final /* synthetic */ DeserializedMemberScope i;

        public static final class a extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ OptimizedImplementation a;
            public final /* synthetic */ DeserializedMemberScope b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.a = optimizedImplementation;
                this.b = deserializedMemberScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Set<? extends Name> invoke() {
                return z.plus((Set) this.a.a.keySet(), (Iterable) this.b.getNonDeclaredFunctionNames());
            }
        }

        public static final class b extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
            public final /* synthetic */ OptimizedImplementation a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(OptimizedImplementation optimizedImplementation) {
                super(1);
                this.a = optimizedImplementation;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                Name name2 = name;
                Intrinsics.checkNotNullParameter(name2, "it");
                OptimizedImplementation optimizedImplementation = this.a;
                Map<Name, byte[]> map = optimizedImplementation.a;
                Parser<ProtoBuf.Function> parser = ProtoBuf.Function.PARSER;
                Intrinsics.checkNotNullExpressionValue(parser, "PARSER");
                DeserializedMemberScope deserializedMemberScope = optimizedImplementation.i;
                byte[] bArr = map.get(name2);
                List<ProtoBuf.Function> list = bArr == null ? null : SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), optimizedImplementation.i)));
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (ProtoBuf.Function function : list) {
                    MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                    Intrinsics.checkNotNullExpressionValue(function, "it");
                    SimpleFunctionDescriptor loadFunction = memberDeserializer.loadFunction(function);
                    if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                        loadFunction = null;
                    }
                    if (loadFunction != null) {
                        arrayList.add(loadFunction);
                    }
                }
                deserializedMemberScope.computeNonDeclaredFunctions(name2, arrayList);
                return CollectionsKt.compact(arrayList);
            }
        }

        public static final class c extends Lambda implements Function1<Name, Collection<? extends PropertyDescriptor>> {
            public final /* synthetic */ OptimizedImplementation a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(OptimizedImplementation optimizedImplementation) {
                super(1);
                this.a = optimizedImplementation;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Collection<? extends PropertyDescriptor> invoke(Name name) {
                List<ProtoBuf.Property> list;
                Name name2 = name;
                Intrinsics.checkNotNullParameter(name2, "it");
                OptimizedImplementation optimizedImplementation = this.a;
                Map<Name, byte[]> map = optimizedImplementation.b;
                Parser<ProtoBuf.Property> parser = ProtoBuf.Property.PARSER;
                Intrinsics.checkNotNullExpressionValue(parser, "PARSER");
                DeserializedMemberScope deserializedMemberScope = optimizedImplementation.i;
                byte[] bArr = map.get(name2);
                if (bArr == null) {
                    list = null;
                } else {
                    list = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), optimizedImplementation.i)));
                }
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (ProtoBuf.Property property : list) {
                    MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                    Intrinsics.checkNotNullExpressionValue(property, "it");
                    PropertyDescriptor loadProperty = memberDeserializer.loadProperty(property);
                    if (loadProperty != null) {
                        arrayList.add(loadProperty);
                    }
                }
                deserializedMemberScope.computeNonDeclaredProperties(name2, arrayList);
                return CollectionsKt.compact(arrayList);
            }
        }

        public static final class d extends Lambda implements Function1<Name, TypeAliasDescriptor> {
            public final /* synthetic */ OptimizedImplementation a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(OptimizedImplementation optimizedImplementation) {
                super(1);
                this.a = optimizedImplementation;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public TypeAliasDescriptor invoke(Name name) {
                ProtoBuf.TypeAlias parseDelimitedFrom;
                Name name2 = name;
                Intrinsics.checkNotNullParameter(name2, "it");
                OptimizedImplementation optimizedImplementation = this.a;
                byte[] bArr = optimizedImplementation.c.get(name2);
                if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), optimizedImplementation.i.getC().getComponents().getExtensionRegistryLite())) == null) {
                    return null;
                }
                return optimizedImplementation.i.getC().getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
            }
        }

        public static final class e extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ OptimizedImplementation a;
            public final /* synthetic */ DeserializedMemberScope b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.a = optimizedImplementation;
                this.b = deserializedMemberScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Set<? extends Name> invoke() {
                return z.plus((Set) this.a.b.keySet(), (Iterable) this.b.getNonDeclaredVariableNames());
            }
        }

        public OptimizedImplementation(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf.Function> list, @NotNull List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
            Map<Name, byte[]> map;
            Intrinsics.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.i = deserializedMemberScope;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : list) {
                Name name = NameResolverUtilKt.getName(deserializedMemberScope.a.getNameResolver(), t.getName());
                Object obj = linkedHashMap.get(name);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(name, obj);
                }
                ((List) obj).add(t);
            }
            this.a = d(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (T t2 : list2) {
                Name name2 = NameResolverUtilKt.getName(deserializedMemberScope2.a.getNameResolver(), t2.getName());
                Object obj2 = linkedHashMap2.get(name2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(name2, obj2);
                }
                ((List) obj2).add(t2);
            }
            this.b = d(linkedHashMap2);
            if (this.i.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (T t3 : list3) {
                    Name name3 = NameResolverUtilKt.getName(deserializedMemberScope3.a.getNameResolver(), t3.getName());
                    Object obj3 = linkedHashMap3.get(name3);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap3.put(name3, obj3);
                    }
                    ((List) obj3).add(t3);
                }
                map = d(linkedHashMap3);
            } else {
                map = r.emptyMap();
            }
            this.c = map;
            this.d = this.i.getC().getStorageManager().createMemoizedFunction(new b(this));
            this.e = this.i.getC().getStorageManager().createMemoizedFunction(new c(this));
            this.f = this.i.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new d(this));
            this.g = this.i.getC().getStorageManager().createLazyValue(new a(this, this.i));
            this.h = this.i.getC().getStorageManager().createLazyValue(new e(this, this.i));
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        public void a(@NotNull Collection<DeclarationDescriptor> collection, @NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                Set<Name> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (Name name : variableNames) {
                    if (function1.invoke(name).booleanValue()) {
                        arrayList.addAll(getContributedVariables(name, lookupLocation));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator, "INSTANCE");
                g.sortWith(arrayList, nameAndTypeMemberComparator);
                collection.addAll(arrayList);
            }
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                Set<Name> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (Name name2 : functionNames) {
                    if (function1.invoke(name2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(name2, lookupLocation));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator2, "INSTANCE");
                g.sortWith(arrayList2, nameAndTypeMemberComparator2);
                collection.addAll(arrayList2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @Nullable
        public TypeAliasDescriptor b(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.f.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<Name> c() {
            return this.c.keySet();
        }

        public final Map<Name, byte[]> d(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(map.size()));
            for (T t : map.entrySet()) {
                Object key = t.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) t.getValue();
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
                for (AbstractMessageLite abstractMessageLite : iterable) {
                    abstractMessageLite.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.INSTANCE);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getFunctionNames().contains(name)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return this.d.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (!getVariableNames().contains(name)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return this.e.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.g, this, j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.h, this, j[1]);
        }
    }

    public interface a {
        void a(@NotNull Collection<DeclarationDescriptor> collection, @NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation);

        @Nullable
        TypeAliasDescriptor b(@NotNull Name name);

        @NotNull
        Set<Name> c();

        @NotNull
        Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation);

        @NotNull
        Set<Name> getFunctionNames();

        @NotNull
        Set<Name> getVariableNames();
    }

    public final class b implements a {
        public static final /* synthetic */ KProperty<Object>[] o = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull
        public final List<ProtoBuf.Function> a;
        @NotNull
        public final List<ProtoBuf.Property> b;
        @NotNull
        public final List<ProtoBuf.TypeAlias> c;
        @NotNull
        public final NotNullLazyValue d;
        @NotNull
        public final NotNullLazyValue e;
        @NotNull
        public final NotNullLazyValue f;
        @NotNull
        public final NotNullLazyValue g;
        @NotNull
        public final NotNullLazyValue h;
        @NotNull
        public final NotNullLazyValue i;
        @NotNull
        public final NotNullLazyValue j;
        @NotNull
        public final NotNullLazyValue k;
        @NotNull
        public final NotNullLazyValue l;
        @NotNull
        public final NotNullLazyValue m;
        public final /* synthetic */ DeserializedMemberScope n;

        public static final class a extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends SimpleFunctionDescriptor> invoke() {
                b bVar = this.a;
                List list = (List) StorageKt.getValue(bVar.d, bVar, b.o[0]);
                b bVar2 = this.a;
                Set<Name> nonDeclaredFunctionNames = bVar2.n.getNonDeclaredFunctionNames();
                ArrayList arrayList = new ArrayList();
                for (T t : nonDeclaredFunctionNames) {
                    DeserializedMemberScope deserializedMemberScope = bVar2.n;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : (List) StorageKt.getValue(bVar2.d, bVar2, b.o[0])) {
                        if (Intrinsics.areEqual(((DeclarationDescriptor) obj).getName(), t)) {
                            arrayList2.add(obj);
                        }
                    }
                    int size = arrayList2.size();
                    deserializedMemberScope.computeNonDeclaredFunctions(t, arrayList2);
                    t6.n.h.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
                }
                return CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$b$b  reason: collision with other inner class name */
        public static final class C0513b extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0513b(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends PropertyDescriptor> invoke() {
                b bVar = this.a;
                List list = (List) StorageKt.getValue(bVar.e, bVar, b.o[1]);
                b bVar2 = this.a;
                Set<Name> nonDeclaredVariableNames = bVar2.n.getNonDeclaredVariableNames();
                ArrayList arrayList = new ArrayList();
                for (T t : nonDeclaredVariableNames) {
                    DeserializedMemberScope deserializedMemberScope = bVar2.n;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : (List) StorageKt.getValue(bVar2.e, bVar2, b.o[1])) {
                        if (Intrinsics.areEqual(((DeclarationDescriptor) obj).getName(), t)) {
                            arrayList2.add(obj);
                        }
                    }
                    int size = arrayList2.size();
                    deserializedMemberScope.computeNonDeclaredProperties(t, arrayList2);
                    t6.n.h.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
                }
                return CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
            }
        }

        public static final class c extends Lambda implements Function0<List<? extends TypeAliasDescriptor>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends TypeAliasDescriptor> invoke() {
                b bVar = this.a;
                List<ProtoBuf.TypeAlias> list = bVar.c;
                DeserializedMemberScope deserializedMemberScope = bVar.n;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    TypeAliasDescriptor loadTypeAlias = deserializedMemberScope.a.getMemberDeserializer().loadTypeAlias(it.next());
                    if (loadTypeAlias != null) {
                        arrayList.add(loadTypeAlias);
                    }
                }
                return arrayList;
            }
        }

        public static final class d extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends SimpleFunctionDescriptor> invoke() {
                b bVar = this.a;
                List<ProtoBuf.Function> list = bVar.a;
                DeserializedMemberScope deserializedMemberScope = bVar.n;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    SimpleFunctionDescriptor loadFunction = deserializedMemberScope.a.getMemberDeserializer().loadFunction(it.next());
                    if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                        loadFunction = null;
                    }
                    if (loadFunction != null) {
                        arrayList.add(loadFunction);
                    }
                }
                return arrayList;
            }
        }

        public static final class e extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends PropertyDescriptor> invoke() {
                b bVar = this.a;
                List<ProtoBuf.Property> list = bVar.b;
                DeserializedMemberScope deserializedMemberScope = bVar.n;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    PropertyDescriptor loadProperty = deserializedMemberScope.a.getMemberDeserializer().loadProperty(it.next());
                    if (loadProperty != null) {
                        arrayList.add(loadProperty);
                    }
                }
                return arrayList;
            }
        }

        public static final class f extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ b a;
            public final /* synthetic */ DeserializedMemberScope b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(b bVar, DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.a = bVar;
                this.b = deserializedMemberScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Set<? extends Name> invoke() {
                b bVar = this.a;
                List<ProtoBuf.Function> list = bVar.a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.n;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.a.getNameResolver(), it.next().getName()));
                }
                return z.plus((Set) linkedHashSet, (Iterable) this.b.getNonDeclaredFunctionNames());
            }
        }

        public static final class g extends Lambda implements Function0<Map<Name, ? extends List<? extends SimpleFunctionDescriptor>>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Name, ? extends List<? extends SimpleFunctionDescriptor>> invoke() {
                b bVar = this.a;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : (List) StorageKt.getValue(bVar.g, bVar, b.o[3])) {
                    Name name = ((SimpleFunctionDescriptor) obj).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(name, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        public static final class h extends Lambda implements Function0<Map<Name, ? extends List<? extends PropertyDescriptor>>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Name, ? extends List<? extends PropertyDescriptor>> invoke() {
                b bVar = this.a;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : (List) StorageKt.getValue(bVar.h, bVar, b.o[4])) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(name, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        public static final class i extends Lambda implements Function0<Map<Name, ? extends TypeAliasDescriptor>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public i(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Map<Name, ? extends TypeAliasDescriptor> invoke() {
                b bVar = this.a;
                List list = (List) StorageKt.getValue(bVar.f, bVar, b.o[2]);
                LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(list, 10)), 16));
                for (Object obj : list) {
                    Name name = ((TypeAliasDescriptor) obj).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        public static final class j extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ b a;
            public final /* synthetic */ DeserializedMemberScope b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public j(b bVar, DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.a = bVar;
                this.b = deserializedMemberScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Set<? extends Name> invoke() {
                b bVar = this.a;
                List<ProtoBuf.Property> list = bVar.b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.n;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.a.getNameResolver(), it.next().getName()));
                }
                return z.plus((Set) linkedHashSet, (Iterable) this.b.getNonDeclaredVariableNames());
            }
        }

        public b(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf.Function> list, @NotNull List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
            Intrinsics.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.n = deserializedMemberScope;
            this.a = list;
            this.b = list2;
            this.c = !deserializedMemberScope.getC().getComponents().getConfiguration().getTypeAliasesAllowed() ? CollectionsKt__CollectionsKt.emptyList() : list3;
            this.d = deserializedMemberScope.getC().getStorageManager().createLazyValue(new d(this));
            this.e = deserializedMemberScope.getC().getStorageManager().createLazyValue(new e(this));
            this.f = deserializedMemberScope.getC().getStorageManager().createLazyValue(new c(this));
            this.g = deserializedMemberScope.getC().getStorageManager().createLazyValue(new a(this));
            this.h = deserializedMemberScope.getC().getStorageManager().createLazyValue(new C0513b(this));
            this.i = deserializedMemberScope.getC().getStorageManager().createLazyValue(new i(this));
            this.j = deserializedMemberScope.getC().getStorageManager().createLazyValue(new g(this));
            this.k = deserializedMemberScope.getC().getStorageManager().createLazyValue(new h(this));
            this.l = deserializedMemberScope.getC().getStorageManager().createLazyValue(new f(this, deserializedMemberScope));
            this.m = deserializedMemberScope.getC().getStorageManager().createLazyValue(new j(this, deserializedMemberScope));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        public void a(@NotNull Collection<DeclarationDescriptor> collection, @NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                for (Object obj : (List) StorageKt.getValue(this.h, this, o[4])) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                for (Object obj2 : (List) StorageKt.getValue(this.g, this, o[3])) {
                    Name name2 = ((SimpleFunctionDescriptor) obj2).getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @Nullable
        public TypeAliasDescriptor b(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (TypeAliasDescriptor) ((Map) StorageKt.getValue(this.i, this, o[5])).get(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<Name> c() {
            List<ProtoBuf.TypeAlias> list = this.c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.a.getNameResolver(), it.next().getName()));
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            NotNullLazyValue notNullLazyValue = this.l;
            KProperty<Object>[] kPropertyArr = o;
            if (!((Set) StorageKt.getValue(notNullLazyValue, this, kPropertyArr[8])).contains(name)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            Collection<SimpleFunctionDescriptor> collection = (Collection) ((Map) StorageKt.getValue(this.j, this, kPropertyArr[6])).get(name);
            return collection != null ? collection : CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            NotNullLazyValue notNullLazyValue = this.m;
            KProperty<Object>[] kPropertyArr = o;
            if (!((Set) StorageKt.getValue(notNullLazyValue, this, kPropertyArr[9])).contains(name)) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            Collection<PropertyDescriptor> collection = (Collection) ((Map) StorageKt.getValue(this.k, this, kPropertyArr[7])).get(name);
            return collection != null ? collection : CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.l, this, o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.m, this, o[9]);
        }
    }

    public static final class c extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ Function0<Collection<Name>> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function0<? extends Collection<Name>> function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends Name> invoke() {
            return CollectionsKt___CollectionsKt.toSet(this.a.invoke());
        }
    }

    public static final class d extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ DeserializedMemberScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(DeserializedMemberScope deserializedMemberScope) {
            super(0);
            this.a = deserializedMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends Name> invoke() {
            Set<Name> nonDeclaredClassifierNames = this.a.getNonDeclaredClassifierNames();
            if (nonDeclaredClassifierNames == null) {
                return null;
            }
            return z.plus(z.plus((Set) this.a.getClassNames$deserialization(), (Iterable) this.a.b.c()), (Iterable) nonDeclaredClassifierNames);
        }
    }

    public DeserializedMemberScope(@NotNull DeserializationContext deserializationContext, @NotNull List<ProtoBuf.Function> list, @NotNull List<ProtoBuf.Property> list2, @NotNull List<ProtoBuf.TypeAlias> list3, @NotNull Function0<? extends Collection<Name>> function0) {
        a aVar;
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        Intrinsics.checkNotNullParameter(list, "functionList");
        Intrinsics.checkNotNullParameter(list2, "propertyList");
        Intrinsics.checkNotNullParameter(list3, "typeAliasList");
        Intrinsics.checkNotNullParameter(function0, "classNames");
        this.a = deserializationContext;
        if (deserializationContext.getComponents().getConfiguration().getPreserveDeclarationsOrdering()) {
            aVar = new b(this, list, list2, list3);
        } else {
            aVar = new OptimizedImplementation(this, list, list2, list3);
        }
        this.b = aVar;
        this.c = deserializationContext.getStorageManager().createLazyValue(new c(function0));
        this.d = deserializationContext.getStorageManager().createNullableLazyValue(new d(this));
    }

    public abstract void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super Name, Boolean> function1);

    @NotNull
    public final Collection<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        DescriptorKindFilter.Companion companion = DescriptorKindFilter.Companion;
        if (descriptorKindFilter.acceptsKinds(companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, function1);
        }
        this.b.a(arrayList, descriptorKindFilter, function1, lookupLocation);
        if (descriptorKindFilter.acceptsKinds(companion.getCLASSIFIERS_MASK())) {
            for (Name name : getClassNames$deserialization()) {
                if (function1.invoke(name).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, this.a.getComponents().deserializeClass(createClassId(name)));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name name2 : this.b.c()) {
                if (function1.invoke(name2).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, this.b.b(name2));
                }
            }
        }
        return CollectionsKt.compact(arrayList);
    }

    public void computeNonDeclaredFunctions(@NotNull Name name, @NotNull List<SimpleFunctionDescriptor> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "functions");
    }

    public void computeNonDeclaredProperties(@NotNull Name name, @NotNull List<PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "descriptors");
    }

    @NotNull
    public abstract ClassId createClassId(@NotNull Name name);

    @NotNull
    public final DeserializationContext getC() {
        return this.a;
    }

    @NotNull
    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.c, this, e[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<Name> getClassifierNames() {
        return (Set) StorageKt.getValue(this.d, this, e[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (hasClass(name)) {
            return this.a.getComponents().deserializeClass(createClassId(name));
        }
        if (this.b.c().contains(name)) {
            return this.b.b(name);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return this.b.getContributedFunctions(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return this.b.getContributedVariables(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.b.getFunctionNames();
    }

    @Nullable
    public abstract Set<Name> getNonDeclaredClassifierNames();

    @NotNull
    public abstract Set<Name> getNonDeclaredFunctionNames();

    @NotNull
    public abstract Set<Name> getNonDeclaredVariableNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        return this.b.getVariableNames();
    }

    public boolean hasClass(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    public boolean isDeclaredFunctionAvailable(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
        return true;
    }
}
