package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.r.a.j;
import t6.v.e;
public final class KotlinClassHeader {
    @NotNull
    public final Kind a;
    @NotNull
    public final JvmMetadataVersion b;
    @Nullable
    public final String[] c;
    @Nullable
    public final String[] d;
    @Nullable
    public final String[] e;
    @Nullable
    public final String f;
    public final int g;

    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final Map<Integer, Kind> b;
        public final int a;

        public static final class Companion {
            public Companion() {
            }

            @JvmStatic
            @NotNull
            public final Kind getById(int i) {
                Kind kind = (Kind) Kind.b.get(Integer.valueOf(i));
                return kind == null ? Kind.UNKNOWN : kind;
            }

            public Companion(j jVar) {
            }
        }

        /* access modifiers changed from: public */
        static {
            Kind[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(6), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            b = linkedHashMap;
        }

        /* access modifiers changed from: public */
        Kind(int i) {
            this.a = i;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i) {
            return Companion.getById(i);
        }

        public final int getId() {
            return this.a;
        }
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull JvmMetadataVersion jvmMetadataVersion, @NotNull JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(kind, MessageBody.Location.KIND);
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(jvmBytecodeBinaryVersion, "bytecodeVersion");
        this.a = kind;
        this.b = jvmMetadataVersion;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    public final boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    @Nullable
    public final String[] getData() {
        return this.c;
    }

    @Nullable
    public final String[] getIncompatibleData() {
        return this.d;
    }

    @NotNull
    public final Kind getKind() {
        return this.a;
    }

    @NotNull
    public final JvmMetadataVersion getMetadataVersion() {
        return this.b;
    }

    @Nullable
    public final String getMultifileClassName() {
        String str = this.f;
        if (getKind() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @NotNull
    public final List<String> getMultifilePartNames() {
        String[] strArr = this.c;
        List<String> list = null;
        if (!(getKind() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        if (strArr != null) {
            list = ArraysKt___ArraysJvmKt.asList(strArr);
        }
        return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
    }

    @Nullable
    public final String[] getStrings() {
        return this.e;
    }

    public final boolean isPreRelease() {
        return a(this.g, 2);
    }

    public final boolean isUnstableFirBinary() {
        return a(this.g, 64) && !a(this.g, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return a(this.g, 16) && !a(this.g, 32);
    }

    @NotNull
    public String toString() {
        return this.a + " version=" + this.b;
    }
}
