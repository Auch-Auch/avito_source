package hu.akarnokd.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import r6.a.b.n.a;
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
        Objects.requireNonNull(subject, "subject is null");
        return new a(subject);
    }
}
