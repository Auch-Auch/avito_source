package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class TypeMappingMode {
    @JvmField
    @NotNull
    public static final TypeMappingMode CLASS_DECLARATION;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT;
    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT_UAST;
    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT;
    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;
    @JvmField
    @NotNull
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, null, false, null, null, false, 1021, null);
    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE;
    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    @JvmField
    @NotNull
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    @Nullable
    public final TypeMappingMode f;
    public final boolean g;
    @Nullable
    public final TypeMappingMode h;
    @Nullable
    public final TypeMappingMode i;
    public final boolean j;

    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Variance.values();
            int[] iArr = new int[3];
            iArr[1] = 1;
            iArr[0] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        TypeMappingMode typeMappingMode = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, 1023, null);
        GENERIC_ARGUMENT = typeMappingMode;
        TypeMappingMode typeMappingMode2 = new TypeMappingMode(false, false, false, false, false, null, false, null, null, true, 511, null);
        GENERIC_ARGUMENT_UAST = typeMappingMode2;
        DEFAULT = new TypeMappingMode(false, false, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        DEFAULT_UAST = new TypeMappingMode(false, false, false, false, false, typeMappingMode2, false, null, null, true, 476, null);
        CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, false, 983, null);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, false, 919, null);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, typeMappingMode, false, null, null, false, 984, null);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable TypeMappingMode typeMappingMode, boolean z7, @Nullable TypeMappingMode typeMappingMode2, @Nullable TypeMappingMode typeMappingMode3, boolean z8) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = typeMappingMode;
        this.g = z7;
        this.h = typeMappingMode2;
        this.i = typeMappingMode3;
        this.j = z8;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.g;
    }

    public final boolean getMapTypeAliases() {
        return this.j;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.b;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.a;
    }

    public final boolean isForAnnotationParameter() {
        return this.c;
    }

    @NotNull
    public final TypeMappingMode toGenericArgumentMode(@NotNull Variance variance, boolean z) {
        Intrinsics.checkNotNullParameter(variance, "effectiveVariance");
        if (!z || !this.c) {
            int ordinal = variance.ordinal();
            if (ordinal == 0) {
                TypeMappingMode typeMappingMode = this.i;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else if (ordinal != 1) {
                TypeMappingMode typeMappingMode2 = this.f;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.h;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    @NotNull
    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.a, true, this.c, this.d, this.e, this.f, this.g, this.h, this.i, false, 512, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TypeMappingMode(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r17, boolean r18, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r19, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r20, boolean r21, int r22, t6.r.a.j r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r1 = 1
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = 0
            goto L_0x0020
        L_0x001f:
            r6 = r15
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0026
            r7 = 0
            goto L_0x0028
        L_0x0026:
            r7 = r16
        L_0x0028:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002e
            r8 = 0
            goto L_0x0030
        L_0x002e:
            r8 = r17
        L_0x0030:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r2 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r8
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r8
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r5 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r9
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode.<init>(boolean, boolean, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, boolean, int, t6.r.a.j):void");
    }
}
