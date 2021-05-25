package kotlin.reflect.jvm.internal.impl.name;

import com.vk.sdk.api.model.VKApiUserFull;
import java.util.List;
import org.jetbrains.annotations.NotNull;
public final class FqName {
    public static final FqName ROOT = new FqName("");
    @NotNull
    public final FqNameUnsafe a;
    public transient FqName b;

    public FqName(@NotNull String str) {
        if (str != null) {
            this.a = new FqNameUnsafe(str, this);
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = VKApiUserFull.RelativeType.CHILD;
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static FqName topLevel(@NotNull Name name) {
        if (name != null) {
            return new FqName(FqNameUnsafe.topLevel(name));
        }
        a(13);
        throw null;
    }

    @NotNull
    public String asString() {
        String asString = this.a.asString();
        if (asString != null) {
            return asString;
        }
        a(4);
        throw null;
    }

    @NotNull
    public FqName child(@NotNull Name name) {
        if (name != null) {
            return new FqName(this.a.child(name), this);
        }
        a(8);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqName) && this.a.equals(((FqName) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isRoot() {
        return this.a.isRoot();
    }

    @NotNull
    public FqName parent() {
        FqName fqName = this.b;
        if (fqName != null) {
            if (fqName != null) {
                return fqName;
            }
            a(6);
            throw null;
        } else if (!isRoot()) {
            FqName fqName2 = new FqName(this.a.parent());
            this.b = fqName2;
            if (fqName2 != null) {
                return fqName2;
            }
            a(7);
            throw null;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public List<Name> pathSegments() {
        List<Name> pathSegments = this.a.pathSegments();
        if (pathSegments != null) {
            return pathSegments;
        }
        a(11);
        throw null;
    }

    @NotNull
    public Name shortName() {
        Name shortName = this.a.shortName();
        if (shortName != null) {
            return shortName;
        }
        a(9);
        throw null;
    }

    @NotNull
    public Name shortNameOrSpecial() {
        Name shortNameOrSpecial = this.a.shortNameOrSpecial();
        if (shortNameOrSpecial != null) {
            return shortNameOrSpecial;
        }
        a(10);
        throw null;
    }

    public boolean startsWith(@NotNull Name name) {
        if (name != null) {
            return this.a.startsWith(name);
        }
        a(12);
        throw null;
    }

    public String toString() {
        return this.a.toString();
    }

    @NotNull
    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe fqNameUnsafe = this.a;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        a(5);
        throw null;
    }

    public FqName(@NotNull FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe != null) {
            this.a = fqNameUnsafe;
        } else {
            a(2);
            throw null;
        }
    }

    public FqName(@NotNull FqNameUnsafe fqNameUnsafe, FqName fqName) {
        if (fqNameUnsafe != null) {
            this.a = fqNameUnsafe;
            this.b = fqName;
            return;
        }
        a(3);
        throw null;
    }
}
