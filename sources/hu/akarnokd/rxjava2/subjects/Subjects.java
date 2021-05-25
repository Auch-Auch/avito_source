package hu.akarnokd.rxjava2.subjects;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.Subject;
import r6.a.a.l.a;
public final class Subjects {
    public Subjects() {
        throw new IllegalStateException("No instances!");
    }

    @CheckReturnValue
    @NonNull
    public static <T> Subject<T> refCount(Subject<T> subject) {
        if (subject instanceof a) {
            return subject;
        }
        return new a((Subject) ObjectHelper.requireNonNull(subject, "subject is null"));
    }
}
