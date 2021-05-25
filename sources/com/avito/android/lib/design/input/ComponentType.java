package com.avito.android.lib.design.input;

import com.avito.android.remote.auth.AuthSource;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/lib/design/input/ComponentType;", "", "", AuthSource.SEND_ABUSE, "I", "getId", "()I", "id", "<init>", "(Ljava/lang/String;II)V", "Companion", "INPUT", "SELECT", "components_release"}, k = 1, mv = {1, 4, 2})
public enum ComponentType {
    INPUT(0),
    SELECT(-1);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/input/ComponentType$Companion;", "", "", "id", "Lcom/avito/android/lib/design/input/ComponentType;", "byId", "(I)Lcom/avito/android/lib/design/input/ComponentType;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ComponentType byId(int i) {
            ComponentType[] values = ComponentType.values();
            for (int i2 = 0; i2 < 2; i2++) {
                ComponentType componentType = values[i2];
                if (componentType.getId() == i) {
                    return componentType;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    ComponentType(int i) {
        this.a = i;
    }

    public final int getId() {
        return this.a;
    }
}
