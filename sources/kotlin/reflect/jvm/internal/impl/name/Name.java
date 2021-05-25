package kotlin.reflect.jvm.internal.impl.name;

import a2.b.a.a.a;
import org.jetbrains.annotations.NotNull;
public final class Name implements Comparable<Name> {
    @NotNull
    public final String a;
    public final boolean b;

    public Name(@NotNull String str, boolean z) {
        if (str != null) {
            this.a = str;
            this.b = z;
            return;
        }
        a(0);
        throw null;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 1 || i == 2) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static Name guessByFirstCharacter(@NotNull String str) {
        if (str == null) {
            a(6);
            throw null;
        } else if (str.startsWith("<")) {
            return special(str);
        } else {
            return identifier(str);
        }
    }

    @NotNull
    public static Name identifier(@NotNull String str) {
        if (str != null) {
            return new Name(str, false);
        }
        a(3);
        throw null;
    }

    public static boolean isValidIdentifier(@NotNull String str) {
        if (str == null) {
            a(4);
            throw null;
        } else if (str.isEmpty() || str.startsWith("<")) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == '.' || charAt == '/' || charAt == '\\') {
                    return false;
                }
            }
            return true;
        }
    }

    @NotNull
    public static Name special(@NotNull String str) {
        if (str == null) {
            a(5);
            throw null;
        } else if (str.startsWith("<")) {
            return new Name(str, true);
        } else {
            throw new IllegalArgumentException(a.c3("special name must start with '<': ", str));
        }
    }

    @NotNull
    public String asString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        a(1);
        throw null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.b == name.b && this.a.equals(name.a);
    }

    @NotNull
    public String getIdentifier() {
        if (!this.b) {
            String asString = asString();
            if (asString != null) {
                return asString;
            }
            a(2);
            throw null;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.b;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a;
    }

    public int compareTo(Name name) {
        return this.a.compareTo(name.a);
    }
}
