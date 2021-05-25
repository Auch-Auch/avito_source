package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.n.z;
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    @NotNull
    public final ProtoBuf.Class d;
    @NotNull
    public final BinaryVersion e;
    @NotNull
    public final SourceElement f;
    @NotNull
    public final ClassId g;
    @NotNull
    public final Modality h;
    @NotNull
    public final DescriptorVisibility i;
    @NotNull
    public final ClassKind j;
    @NotNull
    public final DeserializationContext k;
    @NotNull
    public final MemberScopeImpl l;
    @NotNull
    public final a m;
    @NotNull
    public final ScopesHolderForClass<DeserializedClassMemberScope> n;
    @Nullable
    public final b o;
    @NotNull
    public final DeclarationDescriptor p;
    @NotNull
    public final NullableLazyValue<ClassConstructorDescriptor> q;
    @NotNull
    public final NotNullLazyValue<Collection<ClassConstructorDescriptor>> r;
    @NotNull
    public final NullableLazyValue<ClassDescriptor> s;
    @NotNull
    public final NotNullLazyValue<Collection<ClassDescriptor>> t;
    @NotNull
    public final ProtoContainer.Class u;
    @NotNull
    public final Annotations v;

    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        @NotNull
        public final KotlinTypeRefiner f;
        @NotNull
        public final NotNullLazyValue<Collection<DeclarationDescriptor>> g;
        @NotNull
        public final NotNullLazyValue<Collection<KotlinType>> h;
        public final /* synthetic */ DeserializedClassDescriptor i;

        public static final class a extends Lambda implements Function0<List<? extends Name>> {
            public final /* synthetic */ List<Name> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(List<Name> list) {
                super(0);
                this.a = list;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Name> invoke() {
                return this.a;
            }
        }

        public static final class b extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
            public final /* synthetic */ DeserializedClassMemberScope a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(DeserializedClassMemberScope deserializedClassMemberScope) {
                super(0);
                this.a = deserializedClassMemberScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Collection<? extends DeclarationDescriptor> invoke() {
                return this.a.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        public static final class c extends Lambda implements Function0<Collection<? extends KotlinType>> {
            public final /* synthetic */ DeserializedClassMemberScope a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(DeserializedClassMemberScope deserializedClassMemberScope) {
                super(0);
                this.a = deserializedClassMemberScope;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Collection<? extends KotlinType> invoke() {
                DeserializedClassMemberScope deserializedClassMemberScope = this.a;
                return deserializedClassMemberScope.f.refineSupertypes(deserializedClassMemberScope.i);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DeserializedClassMemberScope(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9) {
            /*
                r7 = this;
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r7.i = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "classProto.functionList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "classProto.propertyList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "classProto.typeAliasList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "classProto.nestedClassNameList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.getNameResolver()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = t6.n.e.collectionSizeOrDefault(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L_0x005c:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x0074
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.Name r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r8, r6)
                r1.add(r6)
                goto L_0x005c
            L_0x0074:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$a r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$a
                r6.<init>(r1)
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.getC()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$b r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$b
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.g = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.getC()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$c r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$c
                r9.<init>(r7)
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.h = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):void");
        }

        public final <D extends CallableMemberDescriptor> void a(Name name, Collection<? extends D> collection, List<D> list) {
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name, collection, new ArrayList(list), this.i, new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(list));
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super Name, Boolean> function1) {
            List list;
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            b bVar = this.i.o;
            if (bVar == null) {
                list = null;
            } else {
                Set<Name> keySet = bVar.a.keySet();
                ArrayList arrayList = new ArrayList();
                for (T t : keySet) {
                    Intrinsics.checkNotNullParameter(t, "name");
                    ClassDescriptor invoke = bVar.b.invoke(t);
                    if (invoke != null) {
                        arrayList.add(invoke);
                    }
                }
                list = arrayList;
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            collection.addAll(list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredFunctions(@NotNull Name name, @NotNull List<SimpleFunctionDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (KotlinType kotlinType : (Collection) this.h.invoke()) {
                arrayList.addAll(kotlinType.getMemberScope().getContributedFunctions(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name, this.i));
            a(name, arrayList, list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredProperties(@NotNull Name name, @NotNull List<PropertyDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (KotlinType kotlinType : (Collection) this.h.invoke()) {
                arrayList.addAll(kotlinType.getMemberScope().getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            a(name, arrayList, list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public ClassId createClassId(@NotNull Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            ClassId createNestedClassId = this.i.g.createNestedClassId(name);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId.createNestedClassId(name)");
            return createNestedClassId;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            b bVar = this.i.o;
            if (bVar != null) {
                Intrinsics.checkNotNullParameter(name, "name");
                ClassDescriptor invoke = bVar.b.invoke(name);
                if (invoke != null) {
                    return invoke;
                }
            }
            return super.getContributedClassifier(name, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            return (Collection) this.g.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            return super.getContributedFunctions(name, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            return super.getContributedVariables(name, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @Nullable
        public Set<Name> getNonDeclaredClassifierNames() {
            List<KotlinType> supertypes = this.i.m.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                Set<Name> classifierNames = it.next().getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    return null;
                }
                t6.n.h.addAll(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Set<Name> getNonDeclaredFunctionNames() {
            List<KotlinType> supertypes = this.i.m.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                t6.n.h.addAll(linkedHashSet, it.next().getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.i));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Set<Name> getNonDeclaredVariableNames() {
            List<KotlinType> supertypes = this.i.m.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                t6.n.h.addAll(linkedHashSet, it.next().getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public boolean isDeclaredFunctionAvailable(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.i, simpleFunctionDescriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, this.i, name);
        }
    }

    public final class a extends AbstractClassTypeConstructor {
        @NotNull
        public final NotNullLazyValue<List<TypeParameterDescriptor>> c;
        public final /* synthetic */ DeserializedClassDescriptor d;

        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$a$a  reason: collision with other inner class name */
        public static final class C0511a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
            public final /* synthetic */ DeserializedClassDescriptor a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0511a(DeserializedClassDescriptor deserializedClassDescriptor) {
                super(0);
                this.a = deserializedClassDescriptor;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends TypeParameterDescriptor> invoke() {
                return TypeParameterUtilsKt.computeConstructorTypeParameters(this.a);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(deserializedClassDescriptor.getC().getStorageManager());
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.d = deserializedClassDescriptor;
            this.c = deserializedClassDescriptor.getC().getStorageManager().createLazyValue(new C0511a(deserializedClassDescriptor));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<KotlinType> computeSupertypes() {
            FqName asSingleFqName;
            List<ProtoBuf.Type> supertypes = ProtoTypeTableUtilKt.supertypes(this.d.getClassProto(), this.d.getC().getTypeTable());
            DeserializedClassDescriptor deserializedClassDescriptor = this.d;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(supertypes, 10));
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(deserializedClassDescriptor.getC().getTypeDeserializer().type(it.next()));
            }
            List plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) this.d.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.d));
            ArrayList<NotFoundClasses.MockClassDescriptor> arrayList2 = new ArrayList();
            Iterator it2 = plus.iterator();
            while (true) {
                NotFoundClasses.MockClassDescriptor mockClassDescriptor = null;
                if (!it2.hasNext()) {
                    break;
                }
                ClassifierDescriptor declarationDescriptor = ((KotlinType) it2.next()).getConstructor().mo425getDeclarationDescriptor();
                if (declarationDescriptor instanceof NotFoundClasses.MockClassDescriptor) {
                    mockClassDescriptor = (NotFoundClasses.MockClassDescriptor) declarationDescriptor;
                }
                if (mockClassDescriptor != null) {
                    arrayList2.add(mockClassDescriptor);
                }
            }
            if (!arrayList2.isEmpty()) {
                ErrorReporter errorReporter = this.d.getC().getComponents().getErrorReporter();
                DeserializedClassDescriptor deserializedClassDescriptor2 = this.d;
                ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
                for (NotFoundClasses.MockClassDescriptor mockClassDescriptor2 : arrayList2) {
                    ClassId classId = DescriptorUtilsKt.getClassId(mockClassDescriptor2);
                    String asString = (classId == null || (asSingleFqName = classId.asSingleFqName()) == null) ? null : asSingleFqName.asString();
                    if (asString == null) {
                        asString = mockClassDescriptor2.getName().asString();
                    }
                    arrayList3.add(asString);
                }
                errorReporter.reportIncompleteHierarchy(deserializedClassDescriptor2, arrayList3);
            }
            return CollectionsKt___CollectionsKt.toList(plus);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public ClassDescriptor mo425getDeclarationDescriptor() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.c.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @NotNull
        public String toString() {
            String name = this.d.getName().toString();
            Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
            return name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor  reason: collision with other method in class */
        public ClassifierDescriptor mo425getDeclarationDescriptor() {
            return this.d;
        }
    }

    public final class b {
        @NotNull
        public final Map<Name, ProtoBuf.EnumEntry> a;
        @NotNull
        public final MemoizedFunctionToNullable<Name, ClassDescriptor> b;
        @NotNull
        public final NotNullLazyValue<Set<Name>> c;
        public final /* synthetic */ DeserializedClassDescriptor d;

        public static final class a extends Lambda implements Function1<Name, ClassDescriptor> {
            public final /* synthetic */ b a;
            public final /* synthetic */ DeserializedClassDescriptor b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, DeserializedClassDescriptor deserializedClassDescriptor) {
                super(1);
                this.a = bVar;
                this.b = deserializedClassDescriptor;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public ClassDescriptor invoke(Name name) {
                Name name2 = name;
                Intrinsics.checkNotNullParameter(name2, "name");
                ProtoBuf.EnumEntry enumEntry = this.a.a.get(name2);
                if (enumEntry == null) {
                    return null;
                }
                DeserializedClassDescriptor deserializedClassDescriptor = this.b;
                return EnumEntrySyntheticClassDescriptor.create(deserializedClassDescriptor.getC().getStorageManager(), deserializedClassDescriptor, name2, this.a.c, new DeserializedAnnotations(deserializedClassDescriptor.getC().getStorageManager(), new t6.w.f.a.m.h.a.b.a(deserializedClassDescriptor, enumEntry)), SourceElement.NO_SOURCE);
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$b$b  reason: collision with other inner class name */
        public static final class C0512b extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ b a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0512b(b bVar) {
                super(0);
                this.a = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Set<? extends Name> invoke() {
                b bVar = this.a;
                Objects.requireNonNull(bVar);
                HashSet hashSet = new HashSet();
                for (KotlinType kotlinType : bVar.d.getTypeConstructor().getSupertypes()) {
                    for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(kotlinType.getMemberScope(), null, null, 3, null)) {
                        if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                            hashSet.add(declarationDescriptor.getName());
                        }
                    }
                }
                List<ProtoBuf.Function> functionList = bVar.d.getClassProto().getFunctionList();
                Intrinsics.checkNotNullExpressionValue(functionList, "classProto.functionList");
                DeserializedClassDescriptor deserializedClassDescriptor = bVar.d;
                Iterator<T> it = functionList.iterator();
                while (it.hasNext()) {
                    hashSet.add(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), it.next().getName()));
                }
                List<ProtoBuf.Property> propertyList = bVar.d.getClassProto().getPropertyList();
                Intrinsics.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
                DeserializedClassDescriptor deserializedClassDescriptor2 = bVar.d;
                Iterator<T> it2 = propertyList.iterator();
                while (it2.hasNext()) {
                    hashSet.add(NameResolverUtilKt.getName(deserializedClassDescriptor2.getC().getNameResolver(), it2.next().getName()));
                }
                return z.plus((Set) hashSet, (Iterable) hashSet);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.d = deserializedClassDescriptor;
            List<ProtoBuf.EnumEntry> enumEntryList = deserializedClassDescriptor.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(enumEntryList, "classProto.enumEntryList");
            LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(enumEntryList, 10)), 16));
            for (T t : enumEntryList) {
                linkedHashMap.put(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), t.getName()), t);
            }
            this.a = linkedHashMap;
            this.b = this.d.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new a(this, this.d));
            this.c = this.d.getC().getStorageManager().createLazyValue(new C0512b(this));
        }
    }

    public static final class c extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ DeserializedClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(0);
            this.a = deserializedClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends AnnotationDescriptor> invoke() {
            return CollectionsKt___CollectionsKt.toList(this.a.getC().getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(this.a.getThisAsProtoContainer$deserialization()));
        }
    }

    public static final class d extends Lambda implements Function0<ClassDescriptor> {
        public final /* synthetic */ DeserializedClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(0);
            this.a = deserializedClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ClassDescriptor invoke() {
            return DeserializedClassDescriptor.access$computeCompanionObjectDescriptor(this.a);
        }
    }

    public static final class e extends Lambda implements Function0<Collection<? extends ClassConstructorDescriptor>> {
        public final /* synthetic */ DeserializedClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(0);
            this.a = deserializedClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<? extends ClassConstructorDescriptor> invoke() {
            return DeserializedClassDescriptor.access$computeConstructors(this.a);
        }
    }

    public static final class g extends Lambda implements Function0<ClassConstructorDescriptor> {
        public final /* synthetic */ DeserializedClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(0);
            this.a = deserializedClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ClassConstructorDescriptor invoke() {
            return DeserializedClassDescriptor.access$computePrimaryConstructor(this.a);
        }
    }

    public static final class h extends Lambda implements Function0<Collection<? extends ClassDescriptor>> {
        public final /* synthetic */ DeserializedClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(0);
            this.a = deserializedClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<? extends ClassDescriptor> invoke() {
            return DeserializedClassDescriptor.access$computeSubclassesForSealedClass(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(@NotNull DeserializationContext deserializationContext, @NotNull ProtoBuf.Class r10, @NotNull NameResolver nameResolver, @NotNull BinaryVersion binaryVersion, @NotNull SourceElement sourceElement) {
        super(deserializationContext.getStorageManager(), NameResolverUtilKt.getClassId(nameResolver, r10.getFqName()).getShortClassName());
        Annotations annotations;
        Intrinsics.checkNotNullParameter(deserializationContext, "outerContext");
        Intrinsics.checkNotNullParameter(r10, "classProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.d = r10;
        this.e = binaryVersion;
        this.f = sourceElement;
        this.g = NameResolverUtilKt.getClassId(nameResolver, r10.getFqName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        this.h = protoEnumFlags.modality(Flags.MODALITY.get(r10.getFlags()));
        this.i = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(r10.getFlags()));
        ClassKind classKind = protoEnumFlags.classKind(Flags.CLASS_KIND.get(r10.getFlags()));
        this.j = classKind;
        List<ProtoBuf.TypeParameter> typeParameterList = r10.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = r10.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = r10.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
        DeserializationContext childContext = deserializationContext.childContext(this, typeParameterList, nameResolver, typeTable2, companion.create(versionRequirementTable), binaryVersion);
        this.k = childContext;
        ClassKind classKind2 = ClassKind.ENUM_CLASS;
        this.l = classKind == classKind2 ? new StaticScopeForKotlinEnum(childContext.getStorageManager(), this) : MemberScope.Empty.INSTANCE;
        this.m = new a(this);
        this.n = ScopesHolderForClass.Companion.create(this, childContext.getStorageManager(), childContext.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new Function1<KotlinTypeRefiner, DeserializedClassMemberScope>(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.f
            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            @NotNull
            public final String getName() {
                return "<init>";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(DeserializedClassMemberScope.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final String getSignature() {
                return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public DeserializedClassMemberScope invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "p0");
                return new DeserializedClassMemberScope((DeserializedClassDescriptor) this.receiver, kotlinTypeRefiner2);
            }
        });
        ProtoContainer.Class r1 = null;
        this.o = classKind == classKind2 ? new b(this) : null;
        DeclarationDescriptor containingDeclaration = deserializationContext.getContainingDeclaration();
        this.p = containingDeclaration;
        this.q = childContext.getStorageManager().createNullableLazyValue(new g(this));
        this.r = childContext.getStorageManager().createLazyValue(new e(this));
        this.s = childContext.getStorageManager().createNullableLazyValue(new d(this));
        this.t = childContext.getStorageManager().createLazyValue(new h(this));
        NameResolver nameResolver2 = childContext.getNameResolver();
        TypeTable typeTable3 = childContext.getTypeTable();
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration : null;
        this.u = new ProtoContainer.Class(r10, nameResolver2, typeTable3, sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.u : r1);
        if (!Flags.HAS_ANNOTATIONS.get(r10.getFlags()).booleanValue()) {
            annotations = Annotations.Companion.getEMPTY();
        } else {
            annotations = new NonEmptyDeserializedAnnotations(childContext.getStorageManager(), new c(this));
        }
        this.v = annotations;
    }

    public static final ClassDescriptor access$computeCompanionObjectDescriptor(DeserializedClassDescriptor deserializedClassDescriptor) {
        if (!deserializedClassDescriptor.d.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = deserializedClassDescriptor.b().getContributedClassifier(NameResolverUtilKt.getName(deserializedClassDescriptor.k.getNameResolver(), deserializedClassDescriptor.d.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    public static final Collection access$computeConstructors(DeserializedClassDescriptor deserializedClassDescriptor) {
        List<ProtoBuf.Constructor> constructorList = deserializedClassDescriptor.d.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        ArrayList arrayList = new ArrayList();
        for (T t2 : constructorList) {
            Boolean bool = Flags.IS_SECONDARY.get(t2.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) it.next();
            MemberDeserializer memberDeserializer = deserializedClassDescriptor.getC().getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(constructor, "it");
            arrayList2.add(memberDeserializer.loadConstructor(constructor, false));
        }
        return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) CollectionsKt__CollectionsKt.listOfNotNull(deserializedClassDescriptor.getUnsubstitutedPrimaryConstructor())), (Iterable) deserializedClassDescriptor.k.getComponents().getAdditionalClassPartsProvider().getConstructors(deserializedClassDescriptor));
    }

    public static final ClassConstructorDescriptor access$computePrimaryConstructor(DeserializedClassDescriptor deserializedClassDescriptor) {
        T t2;
        if (deserializedClassDescriptor.j.isSingleton()) {
            ClassConstructorDescriptorImpl createPrimaryConstructorForObject = DescriptorFactory.createPrimaryConstructorForObject(deserializedClassDescriptor, SourceElement.NO_SOURCE);
            createPrimaryConstructorForObject.setReturnType(deserializedClassDescriptor.getDefaultType());
            return createPrimaryConstructorForObject;
        }
        List<ProtoBuf.Constructor> constructorList = deserializedClassDescriptor.d.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (!Flags.IS_SECONDARY.get(t2.getFlags()).booleanValue()) {
                break;
            }
        }
        T t3 = t2;
        if (t3 == null) {
            return null;
        }
        return deserializedClassDescriptor.getC().getMemberDeserializer().loadConstructor(t3, true);
    }

    public static final Collection access$computeSubclassesForSealedClass(DeserializedClassDescriptor deserializedClassDescriptor) {
        if (deserializedClassDescriptor.h != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> sealedSubclassFqNameList = deserializedClassDescriptor.d.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(deserializedClassDescriptor, false);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : sealedSubclassFqNameList) {
            DeserializationComponents components = deserializedClassDescriptor.getC().getComponents();
            NameResolver nameResolver = deserializedClassDescriptor.getC().getNameResolver();
            Intrinsics.checkNotNullExpressionValue(t2, FirebaseAnalytics.Param.INDEX);
            ClassDescriptor deserializeClass = components.deserializeClass(NameResolverUtilKt.getClassId(nameResolver, t2.intValue()));
            if (deserializeClass != null) {
                arrayList.add(deserializeClass);
            }
        }
        return arrayList;
    }

    public final DeserializedClassMemberScope b() {
        return this.n.getScope(this.k.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.v;
    }

    @NotNull
    public final DeserializationContext getC() {
        return this.k;
    }

    @NotNull
    public final ProtoBuf.Class getClassProto() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.s.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.r.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.k.getTypeDeserializer().getOwnTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return this.j;
    }

    @NotNull
    public final BinaryVersion getMetadataVersion() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.t.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        return this.f;
    }

    @NotNull
    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.n.getScope(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.q.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        return this.i;
    }

    public final boolean hasNestedClass$deserialization(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return b().getClassNames$deserialization().contains(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return Flags.CLASS_KIND.get(this.d.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        Boolean bool = Flags.IS_DATA.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        Boolean bool = Flags.IS_EXPECT_CLASS.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_CLASS.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        Boolean bool = Flags.IS_FUN_INTERFACE.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_FUN_INTERFACE.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        Boolean bool = Flags.IS_INLINE_CLASS.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.e.isAtMost(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean bool = Flags.IS_INNER.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        Boolean bool = Flags.IS_INLINE_CLASS.get(this.d.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.e.isAtLeast(1, 4, 2);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("deserialized ");
        L.append(isExpect() ? "expect " : "");
        L.append("class ");
        L.append(getName());
        return L.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScopeImpl getStaticScope() {
        return this.l;
    }
}
