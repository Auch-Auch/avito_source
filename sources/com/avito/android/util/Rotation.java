package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\b\u0001\u0005\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/util/Rotation;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", AuthSource.SEND_ABUSE, "I", "getDegree", "degree", "Rotation_0", "Rotation_180", "Rotation_270", "Rotation_90", "Rotation_unknown", "Lcom/avito/android/util/Rotation$Rotation_0;", "Lcom/avito/android/util/Rotation$Rotation_90;", "Lcom/avito/android/util/Rotation$Rotation_180;", "Lcom/avito/android/util/Rotation$Rotation_270;", "Lcom/avito/android/util/Rotation$Rotation_unknown;", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public abstract class Rotation {
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/Rotation$Rotation_0;", "Lcom/avito/android/util/Rotation;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rotation_0 extends Rotation {
        public Rotation_0() {
            super(0, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/Rotation$Rotation_180;", "Lcom/avito/android/util/Rotation;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rotation_180 extends Rotation {
        public Rotation_180() {
            super(180, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/Rotation$Rotation_270;", "Lcom/avito/android/util/Rotation;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rotation_270 extends Rotation {
        public Rotation_270() {
            super(270, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/Rotation$Rotation_90;", "Lcom/avito/android/util/Rotation;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rotation_90 extends Rotation {
        public Rotation_90() {
            super(90, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/Rotation$Rotation_unknown;", "Lcom/avito/android/util/Rotation;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rotation_unknown extends Rotation {
        public Rotation_unknown() {
            super(-1, null);
        }
    }

    public Rotation(int i, j jVar) {
        this.a = i;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.util.Rotation");
        return this.a == ((Rotation) obj).a;
    }

    public final int getDegree() {
        return this.a;
    }

    public int hashCode() {
        return this.a;
    }
}
