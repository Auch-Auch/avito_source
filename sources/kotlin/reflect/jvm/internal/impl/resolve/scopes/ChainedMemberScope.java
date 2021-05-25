package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.Shared;
import t6.n.h;
import t6.n.y;
import t6.r.a.j;
public final class ChainedMemberScope implements MemberScope {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final MemberScope[] b;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final MemberScope create(@NotNull String str, @NotNull Iterable<? extends MemberScope> iterable) {
            Intrinsics.checkNotNullParameter(str, "debugName");
            Intrinsics.checkNotNullParameter(iterable, Shared.PARAM_SCOPES);
            SmartList smartList = new SmartList();
            for (MemberScope memberScope : iterable) {
                if (memberScope != MemberScope.Empty.INSTANCE) {
                    if (memberScope instanceof ChainedMemberScope) {
                        h.addAll(smartList, ((ChainedMemberScope) memberScope).b);
                    } else {
                        smartList.add(memberScope);
                    }
                }
            }
            return createOrSingle$descriptors(str, smartList);
        }

        @NotNull
        public final MemberScope createOrSingle$descriptors(@NotNull String str, @NotNull List<? extends MemberScope> list) {
            Intrinsics.checkNotNullParameter(str, "debugName");
            Intrinsics.checkNotNullParameter(list, Shared.PARAM_SCOPES);
            int size = list.size();
            if (size == 0) {
                return MemberScope.Empty.INSTANCE;
            }
            if (size == 1) {
                return (MemberScope) list.get(0);
            }
            Object[] array = list.toArray(new MemberScope[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new ChainedMemberScope(str, (MemberScope[]) array, null);
        }

        public Companion(j jVar) {
        }
    }

    public ChainedMemberScope(String str, MemberScope[] memberScopeArr, j jVar) {
        this.a = str;
        this.b = memberScopeArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt___ArraysKt.asIterable(this.b));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, lookupLocation);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(descriptorKindFilter, function1);
        }
        Collection<DeclarationDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedDescriptors(descriptorKindFilter, function1));
        }
        if (collection == null) {
            return y.emptySet();
        }
        return collection;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name, lookupLocation);
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, lookupLocation));
        }
        if (collection == null) {
            return y.emptySet();
        }
        return collection;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name, lookupLocation);
        }
        Collection<PropertyDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, lookupLocation));
        }
        if (collection == null) {
            return y.emptySet();
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            h.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            h.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        for (MemberScope memberScope : this.b) {
            memberScope.recordLookup(name, lookupLocation);
        }
    }

    @NotNull
    public String toString() {
        return this.a;
    }
}
