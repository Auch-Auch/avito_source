package com.avito.android.design;

import com.avito.android.remote.auth.AuthSource;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/design/State;", "", "", AuthSource.SEND_ABUSE, "I", "getId", "()I", "id", "<init>", "(Ljava/lang/String;II)V", "Companion", "PLACEHOLDER", "ERROR", "LOADED", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public enum State {
    PLACEHOLDER(0),
    ERROR(1),
    LOADED(2);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/design/State$Companion;", "", "", "id", "Lcom/avito/android/design/State;", "byId", "(I)Lcom/avito/android/design/State;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final State byId(int i) {
            State[] values = State.values();
            for (int i2 = 0; i2 < 3; i2++) {
                State state = values[i2];
                if (state.getId() == i) {
                    return state;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    State(int i) {
        this.a = i;
    }

    public final int getId() {
        return this.a;
    }
}
