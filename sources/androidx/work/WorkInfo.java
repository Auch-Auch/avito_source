package androidx.work;

import a2.b.a.a.a;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
public final class WorkInfo {
    @NonNull
    public UUID a;
    @NonNull
    public State b;
    @NonNull
    public Data c;
    @NonNull
    public Set<String> d;
    @NonNull
    public Data e;
    public int f;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list, @NonNull Data data2, int i) {
        this.a = uuid;
        this.b = state;
        this.c = data;
        this.d = new HashSet(list);
        this.e = data2;
        this.f = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f == workInfo.f && this.a.equals(workInfo.a) && this.b == workInfo.b && this.c.equals(workInfo.c) && this.d.equals(workInfo.d)) {
            return this.e.equals(workInfo.e);
        }
        return false;
    }

    @NonNull
    public UUID getId() {
        return this.a;
    }

    @NonNull
    public Data getOutputData() {
        return this.c;
    }

    @NonNull
    public Data getProgress() {
        return this.e;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.f;
    }

    @NonNull
    public State getState() {
        return this.b;
    }

    @NonNull
    public Set<String> getTags() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.d.hashCode();
        return ((this.e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.f;
    }

    public String toString() {
        StringBuilder L = a.L("WorkInfo{mId='");
        L.append(this.a);
        L.append('\'');
        L.append(", mState=");
        L.append(this.b);
        L.append(", mOutputData=");
        L.append(this.c);
        L.append(", mTags=");
        L.append(this.d);
        L.append(", mProgress=");
        L.append(this.e);
        L.append('}');
        return L.toString();
    }
}
