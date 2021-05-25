package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final MemberScope a;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final MemberScope create(@NotNull String str, @NotNull Collection<? extends KotlinType> collection) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(collection, "types");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getMemberScope());
            }
            SmartList<MemberScope> listOfNonEmptyScopes = ScopeUtilsKt.listOfNonEmptyScopes(arrayList);
            MemberScope createOrSingle$descriptors = ChainedMemberScope.Companion.createOrSingle$descriptors(str, listOfNonEmptyScopes);
            if (listOfNonEmptyScopes.size() <= 1) {
                return createOrSingle$descriptors;
            }
            return new TypeIntersectionScope(str, createOrSingle$descriptors, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<CallableDescriptor, CallableDescriptor> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CallableDescriptor invoke(CallableDescriptor callableDescriptor) {
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            Intrinsics.checkNotNullParameter(callableDescriptor2, "<this>");
            return callableDescriptor2;
        }
    }

    public static final class b extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = simpleFunctionDescriptor;
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor2, "<this>");
            return simpleFunctionDescriptor2;
        }
    }

    public static final class c extends Lambda implements Function1<PropertyDescriptor, CallableDescriptor> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CallableDescriptor invoke(PropertyDescriptor propertyDescriptor) {
            PropertyDescriptor propertyDescriptor2 = propertyDescriptor;
            Intrinsics.checkNotNullParameter(propertyDescriptor2, "<this>");
            return propertyDescriptor2;
        }
    }

    public TypeIntersectionScope(String str, MemberScope memberScope, j jVar) {
        this.a = memberScope;
    }

    @JvmStatic
    @NotNull
    public static final MemberScope create(@NotNull String str, @NotNull Collection<? extends KotlinType> collection) {
        return Companion.create(str, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(descriptorKindFilter, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : contributedDescriptors) {
            if (t instanceof CallableDescriptor) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return CollectionsKt___CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup((List) pair.component1(), a.a), (Iterable) ((List) pair.component2()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, lookupLocation), b.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, lookupLocation), c.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    @NotNull
    public MemberScope getWorkerScope() {
        return this.a;
    }
}
