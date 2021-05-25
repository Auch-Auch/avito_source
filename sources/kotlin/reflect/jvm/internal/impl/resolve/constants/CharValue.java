package kotlin.reflect.jvm.internal.impl.resolve.constants;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char c) {
        super(Character.valueOf(c));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0069: APUT  (r1v0 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r2v7 java.lang.String) */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = Integer.valueOf(((Character) getValue()).charValue());
        char charValue = ((Character) getValue()).charValue();
        if (charValue == '\b') {
            str = "\\b";
        } else if (charValue == '\t') {
            str = "\\t";
        } else if (charValue == '\n') {
            str = "\\n";
        } else if (charValue == '\f') {
            str = "\\f";
        } else if (charValue == '\r') {
            str = "\\r";
        } else {
            byte type = (byte) Character.getType(charValue);
            if (!(type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19)) {
                z = true;
            }
            str = z ? String.valueOf(charValue) : "?";
        }
        objArr[1] = str;
        return a.H(objArr, 2, "\\u%04X ('%s')", "java.lang.String.format(this, *args)");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        SimpleType charType = moduleDescriptor.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(charType, "module.builtIns.charType");
        return charType;
    }
}
