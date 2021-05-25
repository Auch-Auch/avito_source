package kotlin.reflect.jvm.internal.impl.load.kotlin;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
public final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    @NotNull
    public static final JvmTypeFactoryImpl a = new JvmTypeFactoryImpl();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3, 4, 5, 6, 7, 8};

        static {
            PrimitiveType.values();
            PrimitiveType primitiveType = PrimitiveType.BOOLEAN;
            PrimitiveType primitiveType2 = PrimitiveType.CHAR;
            PrimitiveType primitiveType3 = PrimitiveType.BYTE;
            PrimitiveType primitiveType4 = PrimitiveType.SHORT;
            PrimitiveType primitiveType5 = PrimitiveType.INT;
            PrimitiveType primitiveType6 = PrimitiveType.FLOAT;
            PrimitiveType primitiveType7 = PrimitiveType.LONG;
            PrimitiveType primitiveType8 = PrimitiveType.DOUBLE;
        }
    }

    @NotNull
    /* renamed from: a */
    public JvmType createFromString(@NotNull String str) {
        JvmPrimitiveType jvmPrimitiveType;
        JvmType object;
        Intrinsics.checkNotNullParameter(str, "representation");
        str.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int i = 0;
        while (true) {
            if (i >= 8) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new JvmType.Primitive(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new JvmType.Primitive(null);
        }
        if (charAt == '[') {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            object = new JvmType.Array(createFromString(substring));
        } else {
            if (charAt == 'L') {
                StringsKt__StringsKt.endsWith$default((CharSequence) str, ';', false, 2, (Object) null);
            }
            String substring2 = str.substring(1, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            object = new JvmType.Object(substring2);
        }
        return object;
    }

    @NotNull
    /* renamed from: b */
    public JvmType.Object createObjectType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        return new JvmType.Object(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType boxType(JvmType jvmType) {
        JvmType jvmType2 = jvmType;
        Intrinsics.checkNotNullParameter(jvmType2, "possiblyPrimitiveType");
        if (!(jvmType2 instanceof JvmType.Primitive)) {
            return jvmType2;
        }
        JvmType.Primitive primitive = (JvmType.Primitive) jvmType2;
        if (primitive.getJvmPrimitiveType() == null) {
            return jvmType2;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType(internalName);
    }

    @NotNull
    /* renamed from: c */
    public String toString(@NotNull JvmType jvmType) {
        String desc;
        Intrinsics.checkNotNullParameter(jvmType, "type");
        if (jvmType instanceof JvmType.Array) {
            return Intrinsics.stringPlus("[", toString(((JvmType.Array) jvmType).getElementType()));
        }
        if (jvmType instanceof JvmType.Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((JvmType.Primitive) jvmType).getJvmPrimitiveType();
            if (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) {
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            }
            return desc;
        } else if (jvmType instanceof JvmType.Object) {
            StringBuilder I = a.I(Matrix.MATRIX_TYPE_RANDOM_LT);
            I.append(((JvmType.Object) jvmType).getInternalName());
            I.append(';');
            return I.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (primitiveType.ordinal()) {
            case 0:
                return JvmType.Companion.getBOOLEAN$descriptors_jvm();
            case 1:
                return JvmType.Companion.getCHAR$descriptors_jvm();
            case 2:
                return JvmType.Companion.getBYTE$descriptors_jvm();
            case 3:
                return JvmType.Companion.getSHORT$descriptors_jvm();
            case 4:
                return JvmType.Companion.getINT$descriptors_jvm();
            case 5:
                return JvmType.Companion.getFLOAT$descriptors_jvm();
            case 6:
                return JvmType.Companion.getLONG$descriptors_jvm();
            case 7:
                return JvmType.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public JvmType getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }
}
