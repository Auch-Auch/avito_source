package com.avito.android;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.composite_exception.CompositeException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003+,-B\t\b\u0002¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000H¦\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0004J\u001b\u0010\u000b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\r2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010\u000eH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013JH\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\r2'\u0010\n\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u000eH\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013JY\u0010\u0018\u001a\u00028\u0001\"\u0004\b\u0001\u0010\r2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010\u000e2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u001a\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u000e¢\u0006\u0004\b\u001c\u0010\u0013J!\u0010\u001f\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0\u000e¢\u0006\u0004\b\u001f\u0010 J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0\u000e¢\u0006\u0004\b\u0015\u0010\u0013J'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0\u000e¢\u0006\u0004\b\u0017\u0010\u0013JG\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\bø\u0001\u0000¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u001d¢\u0006\u0004\b(\u0010'\u0001\u0002./\u0002\u0007\n\u0005\b20\u0001¨\u00060"}, d2 = {"Lcom/avito/android/Result;", "T", "", "component1", "()Ljava/lang/Object;", "", "component2", "()Ljava/lang/Throwable;", "getOrThrow", "Lkotlin/Function0;", "func", "getOrElse", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "R", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "map", "(Lkotlin/jvm/functions/Function1;)Lcom/avito/android/Result;", "flatMap", "onSuccess", "throwable", "onFailure", "fold", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "recover", "f", "rescue", "", "predicate", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "", "other", "Lkotlin/Function2;", "combine", "(Lcom/avito/android/Result;Lkotlin/jvm/functions/Function2;)Lcom/avito/android/Result;", "isSuccess", "()Z", "isFailure", "<init>", "()V", "Companion", "Failure", "Success", "Lcom/avito/android/Result$Success;", "Lcom/avito/android/Result$Failure;", "result"}, k = 1, mv = {1, 4, 2})
public abstract class Result<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/Result$Companion;", "", "T", "Lkotlin/Function0;", "func", "Lcom/avito/android/Result;", "tryCatch", "(Lkotlin/jvm/functions/Function0;)Lcom/avito/android/Result;", "<init>", "()V", "result"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <T> Result<T> tryCatch(@NotNull Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(function0, "func");
            try {
                return new Success(function0.invoke());
            } catch (Throwable th) {
                return new Failure(th);
            }
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/Result$Failure;", "T", "Lcom/avito/android/Result;", "component1", "()Ljava/lang/Object;", "", "component2", "()Ljava/lang/Throwable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getThrowable", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "result"}, k = 1, mv = {1, 4, 2})
    public static final class Failure<T> extends Result<T> {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "throwable");
            this.a = th;
        }

        @Override // com.avito.android.Result
        @Nullable
        public T component1() {
            return null;
        }

        @Override // com.avito.android.Result
        @NotNull
        public Throwable component2() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Failure) {
                return Intrinsics.areEqual(this.a, ((Failure) obj).a);
            }
            return false;
        }

        @NotNull
        public final Throwable getThrowable() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Failure[");
            L.append(this.a.getMessage());
            L.append(']');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00028\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/Result$Success;", "T", "Lcom/avito/android/Result;", "component1", "()Ljava/lang/Object;", "", "component2", "()Ljava/lang/Throwable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "value", "<init>", "(Ljava/lang/Object;)V", "result"}, k = 1, mv = {1, 4, 2})
    public static final class Success<T> extends Result<T> {
        public final T a;

        public Success(T t) {
            super(null);
            this.a = t;
        }

        @Override // com.avito.android.Result
        @Nullable
        public T component1() {
            return this.a;
        }

        @Override // com.avito.android.Result
        @Nullable
        public Throwable component2() {
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Success) {
                return Intrinsics.areEqual((Object) this.a, (Object) ((Success) obj).a);
            }
            return false;
        }

        public final T getValue() {
            return this.a;
        }

        public int hashCode() {
            T t = this.a;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.q(a.L("Success["), this.a, ']');
        }
    }

    public Result() {
    }

    @NotNull
    public final <R> Result<R> combine(@NotNull Result<T> result, @NotNull Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(result, "other");
        Intrinsics.checkNotNullParameter(function2, "func");
        boolean z = this instanceof Success;
        if (z && (result instanceof Success)) {
            return new Success(function2.invoke((Object) ((Success) this).getValue(), (Object) ((Success) result).getValue()));
        }
        boolean z2 = this instanceof Failure;
        if (z2 && (result instanceof Success)) {
            return new Failure(((Failure) this).getThrowable());
        }
        if (z && (result instanceof Failure)) {
            return new Failure(((Failure) result).getThrowable());
        }
        if (!z2 || !(result instanceof Failure)) {
            throw new IllegalStateException("this shouldn't happen");
        }
        StringBuilder sb = new StringBuilder();
        Failure failure = (Failure) this;
        sb.append(failure.getThrowable().getMessage());
        sb.append('\n');
        Failure failure2 = (Failure) result;
        sb.append(failure2.getThrowable().getMessage());
        return new Failure(new CompositeException(sb.toString(), new Throwable[]{failure.getThrowable(), failure2.getThrowable()}));
    }

    @Nullable
    public abstract T component1();

    @Nullable
    public abstract Throwable component2();

    public final boolean exists(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (this instanceof Success) {
            try {
                return function1.invoke(getOrThrow()).booleanValue();
            } catch (Throwable unused) {
                return false;
            }
        } else if (this instanceof Failure) {
            return false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final <R> Result<R> flatMap(@NotNull Function1<? super T, ? extends Result<R>> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        if (this instanceof Success) {
            try {
                return (Result) function1.invoke(getOrThrow());
            } catch (Throwable th) {
                return new Failure(th);
            }
        } else if (this instanceof Failure) {
            return new Failure(((Failure) this).getThrowable());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final <R> R fold(@NotNull Function1<? super T, ? extends R> function1, @NotNull Function1<? super Throwable, ? extends R> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onFailure");
        if (this instanceof Success) {
            return (R) function1.invoke((Object) ((Success) this).getValue());
        }
        if (this instanceof Failure) {
            return (R) function12.invoke(((Failure) this).getThrowable());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final T getOrElse(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (this instanceof Failure) {
            return (T) function0.invoke();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final T getOrThrow() {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (this instanceof Failure) {
            throw ((Failure) this).getThrowable();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isFailure() {
        return this instanceof Failure;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    @NotNull
    public final <R> Result<R> map(@NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        if (this instanceof Success) {
            try {
                return new Success(function1.invoke((Object) ((Success) this).getValue()));
            } catch (Throwable th) {
                return new Failure(th);
            }
        } else if (this instanceof Failure) {
            return new Failure(((Failure) this).getThrowable());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Result<T> onFailure(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        if (!(this instanceof Success)) {
            if (this instanceof Failure) {
                function1.invoke(((Failure) this).getThrowable());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return this;
    }

    @NotNull
    public final Result<T> onSuccess(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        if (this instanceof Success) {
            function1.invoke((Object) ((Success) this).getValue());
        } else if (!(this instanceof Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        return this;
    }

    @NotNull
    public final Result<T> recover(@NotNull Function1<? super Throwable, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        if (this instanceof Success) {
            return this;
        }
        if (this instanceof Failure) {
            try {
                return new Success(function1.invoke(((Failure) this).getThrowable()));
            } catch (Throwable th) {
                return new Failure(th);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Result<T> rescue(@NotNull Function1<? super Throwable, ? extends Result<T>> function1) {
        Intrinsics.checkNotNullParameter(function1, "f");
        if (this instanceof Success) {
            return this;
        }
        if (this instanceof Failure) {
            try {
                return (Result) function1.invoke(((Failure) this).getThrowable());
            } catch (Throwable th) {
                return new Failure(th);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public Result(j jVar) {
    }
}
