package com.sumsub.sns.core.data.listener;

import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fR%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent;", "", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getPayload", "()Ljava/util/Map;", "payload", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "eventType", "SNSEventStepCompleted", "SNSEventStepInitiated", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepInitiated;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepCompleted;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSEvent {
    @NotNull
    public final String a;
    @NotNull
    public final Map<String, Object> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepCompleted;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "", "idDocSetType", "", "isCancelled", "<init>", "(Ljava/lang/String;Z)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SNSEventStepCompleted extends SNSEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SNSEventStepCompleted(@NotNull String str, boolean z) {
            super("StepCompleted", r.mapOf(TuplesKt.to("idDocSetType", str), TuplesKt.to("isCancelled", Boolean.valueOf(z))), null);
            Intrinsics.checkNotNullParameter(str, "idDocSetType");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepInitiated;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "", "idDocSetType", "<init>", "(Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SNSEventStepInitiated extends SNSEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SNSEventStepInitiated(@NotNull String str) {
            super("StepInitiated", q.mapOf(TuplesKt.to("idDocSetType", str)), null);
            Intrinsics.checkNotNullParameter(str, "idDocSetType");
        }
    }

    public SNSEvent(String str, Map map, j jVar) {
        this.a = str;
        this.b = map;
    }

    @NotNull
    public final String getEventType() {
        return this.a;
    }

    @NotNull
    public final Map<String, Object> getPayload() {
        return this.b;
    }
}
