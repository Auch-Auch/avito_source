package kotlin.reflect.jvm.internal.impl.resolve.constants;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class StringValue extends ConstantValue<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringValue(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public String toString() {
        return a.s(a.I(Typography.quote), (String) getValue(), Typography.quote);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        SimpleType stringType = moduleDescriptor.getBuiltIns().getStringType();
        Intrinsics.checkNotNullExpressionValue(stringType, "module.builtIns.stringType");
        return stringType;
    }
}
