package org.funktionale.option;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 ,*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003,-.B\t\b\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\tJ0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\b¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0001\u0010\u0010\"\u0004\b\u0002\u0010\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012H\b¢\u0006\u0004\b\u000e\u0010\u0013J8\u0010\u0017\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\b¢\u0006\u0004\b\u0017\u0010\u0018J6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\fH\b¢\u0006\u0004\b\u0019\u0010\u000fJ4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00028\u0000`\u001aH\b¢\u0006\u0004\b\u001c\u0010\u000fJ4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00028\u0000`\u001aH\b¢\u0006\u0004\b\u001d\u0010\u000fJ.\u0010\u001e\u001a\u00020\u00032\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00028\u0000`\u001aH\b¢\u0006\u0004\b\u001e\u0010\u001fJ$\u0010!\u001a\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020 0\fH\b¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b$\u0010%J*\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0004¢\u0006\u0004\b(\u0010)\u0001\u0002/0¨\u00061"}, d2 = {"Lorg/funktionale/option/Option;", "T", "", "", "isEmpty", "()Z", "nonEmpty", "isDefined", "get", "()Ljava/lang/Object;", "orNull", "R", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Lorg/funktionale/option/Option;", "P1", "p1", "Lkotlin/Function2;", "(Lorg/funktionale/option/Option;Lkotlin/jvm/functions/Function2;)Lorg/funktionale/option/Option;", "Lkotlin/Function0;", "ifEmpty", "some", "fold", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "flatMap", "Lorg/funktionale/utils/Predicate;", "predicate", "filter", "filterNot", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "", "forEach", "(Lkotlin/jvm/functions/Function1;)V", "", "toList", "()Ljava/util/List;", "X", "value", "and", "(Lorg/funktionale/option/Option;)Lorg/funktionale/option/Option;", "<init>", "()V", "Companion", "None", "Some", "Lorg/funktionale/option/Option$None;", "Lorg/funktionale/option/Option$Some;", "funktionale-option"}, k = 1, mv = {1, 4, 0})
public abstract class Option<T> {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lorg/funktionale/option/Option$Companion;", "", "T", "Lorg/funktionale/option/Option;", "empty", "()Lorg/funktionale/option/Option;", "<init>", "()V", "funktionale-option"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <T> Option<T> empty() {
            return None.INSTANCE;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lorg/funktionale/option/Option$None;", "Lorg/funktionale/option/Option;", "", "get", "()Ljava/lang/Void;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<init>", "()V", "funktionale-option"}, k = 1, mv = {1, 4, 0})
    public static final class None extends Option {
        public static final None INSTANCE = new None();

        public None() {
            super(null);
        }

        public boolean equals(@Nullable Object obj) {
            return obj instanceof None;
        }

        public int hashCode() {
            return Integer.MAX_VALUE;
        }

        @Override // org.funktionale.option.Option
        public boolean isEmpty() {
            return true;
        }

        @Override // org.funktionale.option.Option
        @NotNull
        public Void get() {
            throw new NoSuchElementException("None.get");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00028\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lorg/funktionale/option/Option$Some;", "T", "Lorg/funktionale/option/Option;", "get", "()Ljava/lang/Object;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getT", "t", "<init>", "(Ljava/lang/Object;)V", "funktionale-option"}, k = 1, mv = {1, 4, 0})
    public static final class Some<T> extends Option<T> {
        public final T a;

        public Some(T t) {
            super(null);
            this.a = t;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Some) {
                return Intrinsics.areEqual(this.a, ((Some) obj).get());
            }
            return false;
        }

        @Override // org.funktionale.option.Option
        public T get() {
            return this.a;
        }

        public final T getT() {
            return this.a;
        }

        public int hashCode() {
            T t = this.a;
            if (t == null) {
                return 17;
            }
            return 17 + t.hashCode();
        }

        @Override // org.funktionale.option.Option
        public boolean isEmpty() {
            return false;
        }

        @NotNull
        public String toString() {
            return a.q(a.L("Some<"), this.a, Typography.greater);
        }
    }

    public Option() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.funktionale.option.Option<? extends X> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <X> Option<X> and(@NotNull Option<? extends X> option) {
        Intrinsics.checkParameterIsNotNull(option, "value");
        return isEmpty() ? None.INSTANCE : option;
    }

    public final boolean exists(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return nonEmpty() && function1.invoke(get()).booleanValue();
    }

    @NotNull
    public final Option<T> filter(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return (!nonEmpty() || !function1.invoke(get()).booleanValue()) ? None.INSTANCE : this;
    }

    @NotNull
    public final Option<T> filterNot(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return (!nonEmpty() || function1.invoke(get()).booleanValue()) ? None.INSTANCE : this;
    }

    @NotNull
    public final <R> Option<R> flatMap(@NotNull Function1<? super T, ? extends Option<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (isEmpty()) {
            return None.INSTANCE;
        }
        return (Option) function1.invoke(get());
    }

    public final <R> R fold(@NotNull Function0<? extends R> function0, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "ifEmpty");
        Intrinsics.checkParameterIsNotNull(function1, "some");
        return isEmpty() ? (R) function0.invoke() : (R) function1.invoke(get());
    }

    public final void forEach(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (nonEmpty()) {
            function1.invoke(get());
        }
    }

    public abstract T get();

    public final boolean isDefined() {
        return !isEmpty();
    }

    public abstract boolean isEmpty();

    @NotNull
    public final <R> Option<R> map(@NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (isEmpty()) {
            return None.INSTANCE;
        }
        return new Some(function1.invoke(get()));
    }

    public final boolean nonEmpty() {
        return isDefined();
    }

    @Nullable
    public final T orNull() {
        if (isEmpty()) {
            return null;
        }
        return get();
    }

    @NotNull
    public final List<T> toList() {
        if (isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return d.listOf(get());
    }

    public Option(j jVar) {
    }

    @NotNull
    public final <P1, R> Option<R> map(@NotNull Option<? extends P1> option, @NotNull Function2<? super T, ? super P1, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(option, "p1");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (isEmpty()) {
            return None.INSTANCE;
        }
        if (option.isEmpty()) {
            return None.INSTANCE;
        }
        return new Some(function2.invoke(get(), (Object) option.get()));
    }
}
