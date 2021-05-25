package kotlin.reflect.jvm.internal.impl.resolve.constants;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    @NotNull
    public final ClassId b;
    @NotNull
    public final Name c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumValue(@NotNull ClassId classId, @NotNull Name name) {
        super(TuplesKt.to(classId, name));
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name, "enumEntryName");
        this.b = classId;
        this.c = name;
    }

    @NotNull
    public final Name getEnumEntryName() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, this.b);
        SimpleType simpleType = null;
        if (findClassAcrossModuleDependencies != null) {
            if (!DescriptorUtils.isEnumClass(findClassAcrossModuleDependencies)) {
                findClassAcrossModuleDependencies = null;
            }
            if (findClassAcrossModuleDependencies != null) {
                simpleType = findClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (simpleType != null) {
            return simpleType;
        }
        StringBuilder L = a.L("Containing class for error-class based enum entry ");
        L.append(this.b);
        L.append(FormatterType.defaultDecimalSeparator);
        L.append(this.c);
        SimpleType createErrorType = ErrorUtils.createErrorType(L.toString());
        Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return createErrorType;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: kotlin.reflect.jvm.internal.impl.name.Name : 0x0007: INVOKE  (r1v1 kotlin.reflect.jvm.internal.impl.name.Name) = 
      (wrap: kotlin.reflect.jvm.internal.impl.name.ClassId : 0x0005: IGET  (r1v0 kotlin.reflect.jvm.internal.impl.name.ClassId) = (r2v0 'this' kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue A[IMMUTABLE_TYPE, THIS]) kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue.b kotlin.reflect.jvm.internal.impl.name.ClassId)
     type: VIRTUAL call: kotlin.reflect.jvm.internal.impl.name.ClassId.getShortClassName():kotlin.reflect.jvm.internal.impl.name.Name), (wrap: char : ?: SGET   com.avito.android.lib.design.input.FormatterType.defaultDecimalSeparator char), (wrap: kotlin.reflect.jvm.internal.impl.name.Name : 0x0013: IGET  (r1v3 kotlin.reflect.jvm.internal.impl.name.Name) = (r2v0 'this' kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue A[IMMUTABLE_TYPE, THIS]) kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue.c kotlin.reflect.jvm.internal.impl.name.Name)] */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.getShortClassName());
        sb.append(FormatterType.defaultDecimalSeparator);
        sb.append(this.c);
        return sb.toString();
    }
}
