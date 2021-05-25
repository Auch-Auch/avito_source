package kotlin.reflect.jvm.internal.impl.name;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.preferences.db_preferences.Types;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class ClassId {
    public final FqName a;
    public final FqName b;
    public final boolean c;

    public ClassId(@NotNull FqName fqName, @NotNull FqName fqName2, boolean z) {
        if (fqName == null) {
            a(1);
            throw null;
        } else if (fqName2 != null) {
            this.a = fqName;
            this.b = fqName2;
            this.c = z;
        } else {
            a(2);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = Types.STRING;
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static ClassId fromString(@NotNull String str) {
        if (str != null) {
            return fromString(str, false);
        }
        a(11);
        throw null;
    }

    @NotNull
    public static ClassId topLevel(@NotNull FqName fqName) {
        if (fqName != null) {
            return new ClassId(fqName.parent(), fqName.shortName());
        }
        a(0);
        throw null;
    }

    @NotNull
    public FqName asSingleFqName() {
        if (this.a.isRoot()) {
            FqName fqName = this.b;
            if (fqName != null) {
                return fqName;
            }
            a(9);
            throw null;
        }
        return new FqName(this.a.asString() + "." + this.b.asString());
    }

    @NotNull
    public String asString() {
        if (this.a.isRoot()) {
            String asString = this.b.asString();
            if (asString != null) {
                return asString;
            }
            a(13);
            throw null;
        }
        String str = this.a.asString().replace(FormatterType.defaultDecimalSeparator, '/') + "/" + this.b.asString();
        if (str != null) {
            return str;
        }
        a(14);
        throw null;
    }

    @NotNull
    public ClassId createNestedClassId(@NotNull Name name) {
        if (name != null) {
            return new ClassId(getPackageFqName(), this.b.child(name), this.c);
        }
        a(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (!this.a.equals(classId.a) || !this.b.equals(classId.b) || this.c != classId.c) {
            return false;
        }
        return true;
    }

    @Nullable
    public ClassId getOuterClassId() {
        FqName parent = this.b.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.c);
    }

    @NotNull
    public FqName getPackageFqName() {
        FqName fqName = this.a;
        if (fqName != null) {
            return fqName;
        }
        a(5);
        throw null;
    }

    @NotNull
    public FqName getRelativeClassName() {
        FqName fqName = this.b;
        if (fqName != null) {
            return fqName;
        }
        a(6);
        throw null;
    }

    @NotNull
    public Name getShortClassName() {
        Name shortName = this.b.shortName();
        if (shortName != null) {
            return shortName;
        }
        a(7);
        throw null;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        return Boolean.valueOf(this.c).hashCode() + ((hashCode + (this.a.hashCode() * 31)) * 31);
    }

    public boolean isLocal() {
        return this.c;
    }

    public boolean isNestedClass() {
        return !this.b.parent().isRoot();
    }

    public String toString() {
        if (!this.a.isRoot()) {
            return asString();
        }
        StringBuilder L = a.L("/");
        L.append(asString());
        return L.toString();
    }

    @NotNull
    public static ClassId fromString(@NotNull String str, boolean z) {
        if (str != null) {
            return new ClassId(new FqName(StringsKt__StringsKt.substringBeforeLast(str, '/', "").replace('/', FormatterType.defaultDecimalSeparator)), new FqName(StringsKt__StringsKt.substringAfterLast(str, '/', str)), z);
        }
        a(12);
        throw null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClassId(@NotNull FqName fqName, @NotNull Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            a(3);
            throw null;
        } else if (name != null) {
        } else {
            a(4);
            throw null;
        }
    }
}
