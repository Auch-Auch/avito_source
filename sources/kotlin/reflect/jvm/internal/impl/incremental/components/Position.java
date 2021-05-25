package kotlin.reflect.jvm.internal.impl.incremental.components;

import a2.b.a.a.a;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class Position implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Position c = new Position(-1, -1);
    public final int a;
    public final int b;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Position getNO_POSITION() {
            return Position.c;
        }

        public Companion(j jVar) {
        }
    }

    public Position(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return this.a == position.a && this.b == position.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Position(line=");
        L.append(this.a);
        L.append(", column=");
        return a.i(L, this.b, ')');
    }
}
