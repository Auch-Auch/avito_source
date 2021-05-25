package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.avito.android.lib.design.input.FormatterType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
public class JvmClassName {
    public final String a;

    public JvmClassName(@NotNull String str) {
        if (str != null) {
            this.a = str;
        } else {
            a(5);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 3 || i == 6 || i == 7 || i == 8) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static JvmClassName byClassId(@NotNull ClassId classId) {
        if (classId != null) {
            FqName packageFqName = classId.getPackageFqName();
            String replace = classId.getRelativeClassName().asString().replace(FormatterType.defaultDecimalSeparator, Typography.dollar);
            if (packageFqName.isRoot()) {
                return new JvmClassName(replace);
            }
            return new JvmClassName(packageFqName.asString().replace(FormatterType.defaultDecimalSeparator, '/') + "/" + replace);
        }
        a(1);
        throw null;
    }

    @NotNull
    public static JvmClassName byFqNameWithoutInnerClasses(@NotNull FqName fqName) {
        if (fqName != null) {
            return new JvmClassName(fqName.asString().replace(FormatterType.defaultDecimalSeparator, '/'));
        }
        a(2);
        throw null;
    }

    @NotNull
    public static JvmClassName byInternalName(@NotNull String str) {
        if (str != null) {
            return new JvmClassName(str);
        }
        a(0);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((JvmClassName) obj).a);
    }

    @NotNull
    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.a.replace('/', FormatterType.defaultDecimalSeparator));
    }

    @NotNull
    public String getInternalName() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        a(8);
        throw null;
    }

    @NotNull
    public FqName getPackageFqName() {
        int lastIndexOf = this.a.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return new FqName(this.a.substring(0, lastIndexOf).replace('/', FormatterType.defaultDecimalSeparator));
        }
        FqName fqName = FqName.ROOT;
        if (fqName != null) {
            return fqName;
        }
        a(7);
        throw null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
