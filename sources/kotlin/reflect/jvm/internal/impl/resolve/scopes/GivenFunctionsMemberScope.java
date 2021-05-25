package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    public static final /* synthetic */ KProperty<Object>[] c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    @NotNull
    public final ClassDescriptor a;
    @NotNull
    public final NotNullLazyValue b;

    public static final class a extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
        public final /* synthetic */ GivenFunctionsMemberScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GivenFunctionsMemberScope givenFunctionsMemberScope) {
            super(0);
            this.a = givenFunctionsMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends DeclarationDescriptor> invoke() {
            List<FunctionDescriptor> computeDeclaredFunctions = this.a.computeDeclaredFunctions();
            return CollectionsKt___CollectionsKt.plus((Collection) computeDeclaredFunctions, (Iterable) GivenFunctionsMemberScope.access$createFakeOverrides(this.a, computeDeclaredFunctions));
        }
    }

    public GivenFunctionsMemberScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(classDescriptor, "containingClass");
        this.a = classDescriptor;
        this.b = storageManager.createLazyValue(new a(this));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0124 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List access$createFakeOverrides(kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope r10, java.util.List r11) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope.access$createFakeOverrides(kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope, java.util.List):java.util.List");
    }

    public final List<DeclarationDescriptor> a() {
        return (List) StorageKt.getValue(this.b, this, c[0]);
    }

    @NotNull
    public abstract List<FunctionDescriptor> computeDeclaredFunctions();

    @NotNull
    public final ClassDescriptor getContainingClass() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask())) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        List<DeclarationDescriptor> a3 = a();
        SmartList smartList = new SmartList();
        for (T t : a3) {
            if ((t instanceof SimpleFunctionDescriptor) && Intrinsics.areEqual(t.getName(), name)) {
                smartList.add(t);
            }
        }
        return smartList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        List<DeclarationDescriptor> a3 = a();
        SmartList smartList = new SmartList();
        for (T t : a3) {
            if ((t instanceof PropertyDescriptor) && Intrinsics.areEqual(t.getName(), name)) {
                smartList.add(t);
            }
        }
        return smartList;
    }
}
