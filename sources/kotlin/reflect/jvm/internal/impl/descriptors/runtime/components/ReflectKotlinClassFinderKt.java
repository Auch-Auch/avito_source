package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.avito.android.lib.design.input.FormatterType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.Typography;
import t6.y.m;
public final class ReflectKotlinClassFinderKt {
    public static final String access$toRuntimeFqName(ClassId classId) {
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "relativeClassName.asString()");
        String replace$default = m.replace$default(asString, (char) FormatterType.defaultDecimalSeparator, (char) Typography.dollar, false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return replace$default;
        }
        return classId.getPackageFqName() + FormatterType.defaultDecimalSeparator + replace$default;
    }
}
