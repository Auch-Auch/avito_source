package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
public final class WorkQuery {
    public final List<String> a;
    public final List<String> b;
    public final List<WorkInfo.State> c;

    public static final class Builder {
        public List<String> a = new ArrayList();
        public List<String> b = new ArrayList();
        public List<WorkInfo.State> c = new ArrayList();

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromStates(@NonNull List<WorkInfo.State> list) {
            Builder builder = new Builder();
            builder.addStates(list);
            return builder;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromTags(@NonNull List<String> list) {
            Builder builder = new Builder();
            builder.addTags(list);
            return builder;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromUniqueWorkNames(@NonNull List<String> list) {
            Builder builder = new Builder();
            builder.addUniqueWorkNames(list);
            return builder;
        }

        @NonNull
        public Builder addStates(@NonNull List<WorkInfo.State> list) {
            this.c.addAll(list);
            return this;
        }

        @NonNull
        public Builder addTags(@NonNull List<String> list) {
            this.b.addAll(list);
            return this;
        }

        @NonNull
        public Builder addUniqueWorkNames(@NonNull List<String> list) {
            this.a.addAll(list);
            return this;
        }

        @NonNull
        public WorkQuery build() {
            if (!this.a.isEmpty() || !this.b.isEmpty() || !this.c.isEmpty()) {
                return new WorkQuery(this);
            }
            throw new IllegalArgumentException("Must specify uniqueNames, tags or states when building a WorkQuery");
        }
    }

    public WorkQuery(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    @NonNull
    public List<WorkInfo.State> getStates() {
        return this.c;
    }

    @NonNull
    public List<String> getTags() {
        return this.b;
    }

    @NonNull
    public List<String> getUniqueWorkNames() {
        return this.a;
    }
}
