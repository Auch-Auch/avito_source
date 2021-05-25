package com.avito.android.user_adverts_common.safety;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;", "", "", "component1", "()J", "lastShowTimestamp", "copy", "(J)Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "J", "getLastShowTimestamp", "<init>", "(J)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AfterPublishWarningSession {
    public final long a;

    public AfterPublishWarningSession(long j) {
        this.a = j;
    }

    public static /* synthetic */ AfterPublishWarningSession copy$default(AfterPublishWarningSession afterPublishWarningSession, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = afterPublishWarningSession.a;
        }
        return afterPublishWarningSession.copy(j);
    }

    public final long component1() {
        return this.a;
    }

    @NotNull
    public final AfterPublishWarningSession copy(long j) {
        return new AfterPublishWarningSession(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AfterPublishWarningSession) && this.a == ((AfterPublishWarningSession) obj).a;
        }
        return true;
    }

    public final long getLastShowTimestamp() {
        return this.a;
    }

    public int hashCode() {
        return c.a(this.a);
    }

    @NotNull
    public String toString() {
        return a.l(a.L("AfterPublishWarningSession(lastShowTimestamp="), this.a, ")");
    }
}
