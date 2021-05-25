package com.avito.android.safedeal.delivery_courier;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "BOTTOM_SHEET", "MODAL", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public enum ScreenStyle {
    BOTTOM_SHEET("bottomSheet"),
    MODAL("modal");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/ScreenStyle$Companion;", "", "", "str", "Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "fromString", "(Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final ScreenStyle fromString(@Nullable String str) {
            ScreenStyle screenStyle = ScreenStyle.BOTTOM_SHEET;
            return Intrinsics.areEqual(str, screenStyle.getValue()) ? screenStyle : ScreenStyle.MODAL;
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    ScreenStyle(String str) {
        this.a = str;
    }

    @JvmStatic
    @NotNull
    public static final ScreenStyle fromString(@Nullable String str) {
        return Companion.fromString(str);
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
