package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class ClassicBuiltinSpecialProperties {
    @NotNull
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ ClassicBuiltinSpecialProperties a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties) {
            super(1);
            this.a = classicBuiltinSpecialProperties;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
            Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "it");
            return Boolean.valueOf(this.a.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor2));
        }
    }

    @Nullable
    public final String getBuiltinSpecialPropertyGetterName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Name name;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, new a(this), 1, null);
        if (firstOverridden$default == null || (name = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(firstOverridden$default))) == null) {
            return null;
        }
        return name.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.INSTANCE;
        if (!builtinSpecialProperties.getSPECIAL_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return false;
        }
        if (CollectionsKt___CollectionsKt.contains(builtinSpecialProperties.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull(callableMemberDescriptor)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
        if (overriddenDescriptors.isEmpty()) {
            return false;
        }
        for (T t : overriddenDescriptors) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            if (hasBuiltinSpecialPropertyFqName(t)) {
                return true;
            }
        }
        return false;
    }
}
