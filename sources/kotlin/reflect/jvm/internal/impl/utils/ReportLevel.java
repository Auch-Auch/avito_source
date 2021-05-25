package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public enum ReportLevel {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;

    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    ReportLevel(String str) {
        this.a = str;
    }

    @NotNull
    public final String getDescription() {
        return this.a;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
