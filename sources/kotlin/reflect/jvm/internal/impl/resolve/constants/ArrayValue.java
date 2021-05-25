package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {
    @NotNull
    public final Function1<ModuleDescriptor, KotlinType> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayValue(@NotNull List<? extends ConstantValue<?>> list, @NotNull Function1<? super ModuleDescriptor, ? extends KotlinType> function1) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "value");
        Intrinsics.checkNotNullParameter(function1, "computeType");
        this.b = function1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        KotlinType invoke = this.b.invoke(moduleDescriptor);
        if (!KotlinBuiltIns.isArray(invoke) && !KotlinBuiltIns.isPrimitiveArray(invoke)) {
            KotlinBuiltIns.isUnsignedArrayType(invoke);
        }
        return invoke;
    }
}
