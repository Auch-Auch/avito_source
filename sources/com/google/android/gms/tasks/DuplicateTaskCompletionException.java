package com.google.android.gms.tasks;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.avito.android.analytics.screens.PublicConstantsKt;
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(Task<?> task) {
        String str;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = PublicConstantsKt.FAILURE;
        } else if (task.isSuccessful()) {
            String valueOf = String.valueOf(task.getResult());
            str = a.r2(valueOf.length() + 7, "result ", valueOf);
        } else {
            str = task.isCanceled() ? "cancellation" : "unknown issue";
        }
        String valueOf2 = String.valueOf(str);
        return new DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), exception);
    }
}
