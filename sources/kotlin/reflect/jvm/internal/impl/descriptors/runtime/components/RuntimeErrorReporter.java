package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import a2.b.a.a.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;
public final class RuntimeErrorReporter implements ErrorReporter {
    @NotNull
    public static final RuntimeErrorReporter INSTANCE = new RuntimeErrorReporter();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        throw new IllegalStateException(Intrinsics.stringPlus("Cannot infer visibility for ", callableMemberDescriptor));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(@NotNull ClassDescriptor classDescriptor, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "unresolvedSuperClasses");
        StringBuilder L = a.L("Incomplete hierarchy for class ");
        L.append(classDescriptor.getName());
        L.append(", unresolved classes ");
        L.append(list);
        throw new IllegalStateException(L.toString());
    }
}
