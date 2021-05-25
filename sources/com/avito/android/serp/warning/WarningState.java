package com.avito.android.serp.warning;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/warning/WarningState;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "SHOW", "HIDE", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public enum WarningState {
    SHOW("show"),
    HIDE("hide");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/warning/WarningState$Companion;", "", "", "value", "Lcom/avito/android/serp/warning/WarningState;", "getWarningStateByValue", "(Ljava/lang/String;)Lcom/avito/android/serp/warning/WarningState;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function0<WarningState> {
            public static final a a = new a();

            public a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public WarningState invoke() {
                return WarningState.HIDE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final WarningState getWarningStateByValue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            WarningState[] values = WarningState.values();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                WarningState warningState = values[i];
                if (Intrinsics.areEqual(warningState.getValue(), str)) {
                    arrayList.add(warningState);
                }
            }
            return (WarningState) OptionKt.getOrElse(OptionKt.firstOption((List) arrayList), a.a);
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    WarningState(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
