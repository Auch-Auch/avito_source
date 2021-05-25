package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.avito.android.payment.SberbankOnlineKt;
import com.google.common.util.concurrent.ListenableFuture;
public interface Operation {
    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final State.IN_PROGRESS IN_PROGRESS = new State.IN_PROGRESS(null);
    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final State.SUCCESS SUCCESS = new State.SUCCESS(null);

    public static abstract class State {

        public static final class FAILURE extends State {
            public final Throwable a;

            public FAILURE(@NonNull Throwable th) {
                this.a = th;
            }

            @NonNull
            public Throwable getThrowable() {
                return this.a;
            }

            @NonNull
            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        public static final class IN_PROGRESS extends State {
            public IN_PROGRESS() {
            }

            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }

            public IN_PROGRESS(a aVar) {
            }
        }

        public static final class SUCCESS extends State {
            public SUCCESS() {
            }

            @NonNull
            public String toString() {
                return SberbankOnlineKt.RESULT_SUCCESS;
            }

            public SUCCESS(a aVar) {
            }
        }
    }

    @NonNull
    ListenableFuture<State.SUCCESS> getResult();

    @NonNull
    LiveData<State> getState();
}
