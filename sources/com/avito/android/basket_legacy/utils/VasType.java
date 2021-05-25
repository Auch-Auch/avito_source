package com.avito.android.basket_legacy.utils;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/basket_legacy/utils/VasType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "PERFORMANCE", "VISUAL", "basket_release"}, k = 1, mv = {1, 4, 2})
public enum VasType {
    PERFORMANCE,
    VISUAL;
    
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/basket_legacy/utils/VasType$Companion;", "", "", "value", "Lcom/avito/android/basket_legacy/utils/VasType;", "fromString", "(Ljava/lang/String;)Lcom/avito/android/basket_legacy/utils/VasType;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VasType fromString(@NotNull String str) {
            VasType vasType;
            Intrinsics.checkNotNullParameter(str, "value");
            VasType[] values = VasType.values();
            int i = 0;
            while (true) {
                if (i >= 2) {
                    vasType = null;
                    break;
                }
                vasType = values[i];
                String name = vasType.name();
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                String lowerCase2 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    break;
                }
                i++;
            }
            return vasType != null ? vasType : VasType.PERFORMANCE;
        }

        public Companion(j jVar) {
        }
    }
}
