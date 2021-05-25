package kotlin.reflect.jvm.internal.impl.name;

import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
public final class FqNameUnsafe {
    public static final Name e = Name.special("<root>");
    public static final Pattern f = Pattern.compile("\\.");
    public static final Function1<String, Name> g = new a();
    @NotNull
    public final String a;
    public transient FqName b;
    public transient FqNameUnsafe c;
    public transient Name d;

    public static class a implements Function1<String, Name> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Name invoke(String str) {
            return Name.guessByFirstCharacter(str);
        }
    }

    public FqNameUnsafe(@NotNull String str, @NotNull FqName fqName) {
        if (str != null) {
            this.a = str;
            this.b = fqName;
            return;
        }
        a(0);
        throw null;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = VKApiUserFull.RelativeType.CHILD;
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static FqNameUnsafe topLevel(@NotNull Name name) {
        if (name != null) {
            return new FqNameUnsafe(name.asString(), FqName.ROOT.toUnsafe(), name);
        }
        a(16);
        throw null;
    }

    @NotNull
    public String asString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        a(4);
        throw null;
    }

    public final void b() {
        int lastIndexOf = this.a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.d = Name.guessByFirstCharacter(this.a.substring(lastIndexOf + 1));
            this.c = new FqNameUnsafe(this.a.substring(0, lastIndexOf));
            return;
        }
        this.d = Name.guessByFirstCharacter(this.a);
        this.c = FqName.ROOT.toUnsafe();
    }

    @NotNull
    public FqNameUnsafe child(@NotNull Name name) {
        String str;
        if (name != null) {
            if (isRoot()) {
                str = name.asString();
            } else {
                str = this.a + "." + name.asString();
            }
            return new FqNameUnsafe(str, this, name);
        }
        a(9);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && this.a.equals(((FqNameUnsafe) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isRoot() {
        return this.a.isEmpty();
    }

    public boolean isSafe() {
        return this.b != null || asString().indexOf(60) < 0;
    }

    @NotNull
    public FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.c;
        if (fqNameUnsafe != null) {
            if (fqNameUnsafe != null) {
                return fqNameUnsafe;
            }
            a(7);
            throw null;
        } else if (!isRoot()) {
            b();
            FqNameUnsafe fqNameUnsafe2 = this.c;
            if (fqNameUnsafe2 != null) {
                return fqNameUnsafe2;
            }
            a(8);
            throw null;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public List<Name> pathSegments() {
        List<Name> emptyList = isRoot() ? Collections.emptyList() : ArraysKt___ArraysKt.map(f.split(this.a), g);
        if (emptyList != null) {
            return emptyList;
        }
        a(14);
        throw null;
    }

    @NotNull
    public Name shortName() {
        Name name = this.d;
        if (name != null) {
            if (name != null) {
                return name;
            }
            a(10);
            throw null;
        } else if (!isRoot()) {
            b();
            Name name2 = this.d;
            if (name2 != null) {
                return name2;
            }
            a(11);
            throw null;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public Name shortNameOrSpecial() {
        if (isRoot()) {
            Name name = e;
            if (name != null) {
                return name;
            }
            a(12);
            throw null;
        }
        Name shortName = shortName();
        if (shortName != null) {
            return shortName;
        }
        a(13);
        throw null;
    }

    public boolean startsWith(@NotNull Name name) {
        if (name == null) {
            a(15);
            throw null;
        } else if (isRoot()) {
            return false;
        } else {
            int indexOf = this.a.indexOf(46);
            String str = this.a;
            String asString = name.asString();
            if (indexOf == -1) {
                indexOf = this.a.length();
            }
            return str.regionMatches(0, asString, 0, indexOf);
        }
    }

    @NotNull
    public FqName toSafe() {
        FqName fqName = this.b;
        if (fqName == null) {
            FqName fqName2 = new FqName(this);
            this.b = fqName2;
            if (fqName2 != null) {
                return fqName2;
            }
            a(6);
            throw null;
        } else if (fqName != null) {
            return fqName;
        } else {
            a(5);
            throw null;
        }
    }

    @NotNull
    public String toString() {
        String asString = isRoot() ? e.asString() : this.a;
        if (asString != null) {
            return asString;
        }
        a(17);
        throw null;
    }

    public FqNameUnsafe(@NotNull String str) {
        if (str != null) {
            this.a = str;
        } else {
            a(2);
            throw null;
        }
    }

    public FqNameUnsafe(@NotNull String str, FqNameUnsafe fqNameUnsafe, Name name) {
        if (str != null) {
            this.a = str;
            this.c = fqNameUnsafe;
            this.d = name;
            return;
        }
        a(3);
        throw null;
    }
}
