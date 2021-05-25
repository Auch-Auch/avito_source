package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            super(cls);
            this.c.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'androidx.work.WorkRequest' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        public OneTimeWorkRequest a() {
            if (!this.a || Build.VERSION.SDK_INT < 23 || !this.c.constraints.requiresDeviceIdle()) {
                WorkSpec workSpec = this.c;
                if (!workSpec.runInForeground || Build.VERSION.SDK_INT < 23 || !workSpec.constraints.requiresDeviceIdle()) {
                    return new OneTimeWorkRequest(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'androidx.work.WorkRequest$Builder' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        public Builder b() {
            return this;
        }

        @NonNull
        public Builder setInputMerger(@NonNull Class<? extends InputMerger> cls) {
            this.c.inputMergerClassName = cls.getName();
            return this;
        }
    }

    public OneTimeWorkRequest(Builder builder) {
        super(builder.b, builder.c, builder.d);
    }

    @NonNull
    public static OneTimeWorkRequest from(@NonNull Class<? extends ListenableWorker> cls) {
        return (OneTimeWorkRequest) new Builder(cls).build();
    }

    @NonNull
    public static List<OneTimeWorkRequest> from(@NonNull List<Class<? extends ListenableWorker>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<? extends ListenableWorker> cls : list) {
            arrayList.add(new Builder(cls).build());
        }
        return arrayList;
    }
}
