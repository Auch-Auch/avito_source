package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
public final class UtilsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4) != false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue lexicalCastFrom(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.KotlinType r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.mo425getDeclarationDescriptor()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            r2 = 0
            if (r1 == 0) goto L_0x0048
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS
            if (r1 != r3) goto L_0x0048
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r4 = r0.getUnsubstitutedInnerClassesScope()
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r5)
            java.lang.String r0 = "identifier(value)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r0 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BACKEND
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getContributedClassifier(r5, r0)
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L_0x0047
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r4.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r5 != r0) goto L_0x0047
            kotlin.reflect.jvm.internal.impl.load.java.EnumEntry r2 = new kotlin.reflect.jvm.internal.impl.load.java.EnumEntry
            r2.<init>(r4)
        L_0x0047:
            return r2
        L_0x0048:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNotNullable(r4)
            kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix r0 = kotlin.reflect.jvm.internal.impl.utils.NumbersKt.extractRadix(r5)
            java.lang.String r1 = r0.component1()
            int r0 = r0.component2()
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBoolean(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r3 == 0) goto L_0x0067
            boolean r4 = java.lang.Boolean.parseBoolean(r5)     // Catch:{ IllegalArgumentException -> 0x00bb }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x0067:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isChar(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r3 == 0) goto L_0x0072
            java.lang.Character r5 = kotlin.text.StringsKt___StringsKt.singleOrNull(r5)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x0072:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isByte(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r3 == 0) goto L_0x007d
            java.lang.Byte r5 = t6.y.l.toByteOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x007d:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isShort(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r3 == 0) goto L_0x0088
            java.lang.Short r5 = t6.y.l.toShortOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x0088:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isInt(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r3 == 0) goto L_0x0093
            java.lang.Integer r5 = t6.y.l.toIntOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x0093:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isLong(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r3 == 0) goto L_0x009e
            java.lang.Long r5 = t6.y.l.toLongOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x009e:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isFloat(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r0 == 0) goto L_0x00a9
            java.lang.Float r5 = t6.y.k.toFloatOrNull(r5)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x00a9:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDouble(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r0 == 0) goto L_0x00b4
            java.lang.Double r5 = t6.y.k.toDoubleOrNull(r5)     // Catch:{ IllegalArgumentException -> 0x00bb }
            goto L_0x00bc
        L_0x00b4:
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            if (r4 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r5 = r2
        L_0x00bc:
            if (r5 == 0) goto L_0x00c3
            kotlin.reflect.jvm.internal.impl.load.java.Constant r2 = new kotlin.reflect.jvm.internal.impl.load.java.Constant
            r2.<init>(r5)
        L_0x00c3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.lexicalCastFrom(kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.String):kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue");
    }

    @NotNull
    public static final DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility);
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }
}
