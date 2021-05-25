package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "", "<init>", "()V", "AbnormalTermination", "SuccessTermination", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult$SuccessTermination;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult$AbnormalTermination;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSCompletionResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSCompletionResult$AbnormalTermination;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "copy", "(Ljava/lang/Exception;)Lcom/sumsub/sns/core/data/model/SNSCompletionResult$AbnormalTermination;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Exception;", "getException", "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class AbnormalTermination extends SNSCompletionResult {
        @Nullable
        public final Exception a;

        public AbnormalTermination() {
            this(null, 1, null);
        }

        public AbnormalTermination(@Nullable Exception exc) {
            super(null);
            this.a = exc;
        }

        public static /* synthetic */ AbnormalTermination copy$default(AbnormalTermination abnormalTermination, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = abnormalTermination.a;
            }
            return abnormalTermination.copy(exc);
        }

        @Nullable
        public final Exception component1() {
            return this.a;
        }

        @NotNull
        public final AbnormalTermination copy(@Nullable Exception exc) {
            return new AbnormalTermination(exc);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof AbnormalTermination) && Intrinsics.areEqual(this.a, ((AbnormalTermination) obj).a);
            }
            return true;
        }

        @Nullable
        public final Exception getException() {
            return this.a;
        }

        public int hashCode() {
            Exception exc = this.a;
            if (exc != null) {
                return exc.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AbnormalTermination(exception=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AbnormalTermination(Exception exc, int i, j jVar) {
            this((i & 1) != 0 ? null : exc);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSCompletionResult$SuccessTermination;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SuccessTermination extends SNSCompletionResult {
        @NotNull
        public static final SuccessTermination INSTANCE = new SuccessTermination();

        public SuccessTermination() {
            super(null);
        }
    }

    public SNSCompletionResult() {
    }

    public SNSCompletionResult(j jVar) {
    }
}
