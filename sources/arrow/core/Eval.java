package arrow.core;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import arrow.core.Eval;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u0016*\u0006\b\u0000\u0010\u0001 \u00012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004:\u0007\u0017\u0016\u0018\u0019\u001a\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\f\u0010\rJO\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\t24\u0010\u000e\u001a0\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n`\u0004¢\u0006\u0004\b\u000f\u0010\u0010JE\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\t2(\u0010\u000b\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00040\nH\u0007¢\u0006\u0004\b\u0011\u0010\rJC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\t2(\u0010\u000b\u001a$\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0006\u0001\u0006\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Larrow/core/Eval;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "Larrow/core/ForEval;", "Larrow/core/EvalOf;", "value", "()Ljava/lang/Object;", "memoize", "()Larrow/core/Eval;", "B", "Lkotlin/Function1;", "f", "map", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Eval;", "ff", "ap", "(Larrow/Kind;)Larrow/core/Eval;", "flatMap", "coflatMap", "extract", "<init>", "()V", "Companion", "Always", "Defer", "FlatMap", "Later", "Memoize", "Now", "Larrow/core/Eval$Now;", "Larrow/core/Eval$Later;", "Larrow/core/Eval$Always;", "Larrow/core/Eval$Defer;", "Larrow/core/Eval$FlatMap;", "Larrow/core/Eval$Memoize;", "arrow-core"}, k = 1, mv = {1, 4, 0})
public abstract class Eval<A> implements Kind<ForEval, A> {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Eval<Unit> a = new Now(Unit.INSTANCE);
    @NotNull
    public static final Eval<Boolean> b = new Now(Boolean.TRUE);
    @NotNull
    public static final Eval<Boolean> c = new Now(Boolean.FALSE);
    @NotNull
    public static final Eval<Integer> d = new Now(0);
    @NotNull
    public static final Eval<Integer> e = new Now(1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016¨\u0006\u0019"}, d2 = {"Larrow/core/Eval$Always;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Eval;", "value", "()Ljava/lang/Object;", "memoize", "()Larrow/core/Eval;", "Lkotlin/Function0;", "f", "copy", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Eval$Always;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Always<A> extends Eval<A> {
        public final Function0<A> f;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends A> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Always(@NotNull Function0<? extends A> function0) {
            super(null);
            Intrinsics.checkParameterIsNotNull(function0, "f");
            this.f = function0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Eval$Always */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Always copy$default(Always always, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = always.f;
            }
            return always.copy(function0);
        }

        @NotNull
        public final Always<A> copy(@NotNull Function0<? extends A> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "f");
            return new Always<>(function0);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Always) && Intrinsics.areEqual(this.f, ((Always) obj).f);
            }
            return true;
        }

        public int hashCode() {
            Function0<A> function0 = this.f;
            if (function0 != null) {
                return function0.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Eval
        @NotNull
        public Eval<A> memoize() {
            return new Later(this.f);
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Always(f=");
            L.append(this.f);
            L.append(")");
            return L.toString();
        }

        @Override // arrow.core.Eval
        public A value() {
            return this.f.invoke();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101Ji\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00012@\u0010\n\u001a<\u0012\u0004\u0012\u00028\u0001\u00122\u00120\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u0006j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b`\t0\u0005¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014\"\u0004\b\u0001\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\"\u0004\b\u0001\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0001\u0010\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 R\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020!0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%R\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010%R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020&0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%¨\u00062"}, d2 = {"Larrow/core/Eval$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", AuthSource.SEND_ABUSE, "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForEval;", "Larrow/core/Either;", "Larrow/core/EvalOf;", "f", "Larrow/core/Eval;", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Eval;", "just", "(Ljava/lang/Object;)Larrow/core/Eval;", "Larrow/core/Eval$Now;", "now", "(Ljava/lang/Object;)Larrow/core/Eval$Now;", "Lkotlin/Function0;", "Larrow/core/Eval$Later;", "later", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Eval$Later;", "Larrow/core/Eval$Always;", "always", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Eval$Always;", "defer", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Eval;", "", "t", "", "raise", "(Ljava/lang/Throwable;)Larrow/core/Eval;", "", "True", "Larrow/core/Eval;", "getTrue", "()Larrow/core/Eval;", "", "One", "getOne", "False", "getFalse", "", "Unit", "getUnit", "Zero", "getZero", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        public static final class a extends Lambda implements Function0 {
            public final /* synthetic */ Throwable a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Throwable th) {
                super(0);
                this.a = th;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                throw this.a;
            }
        }

        public static final class b extends Lambda implements Function1<Either<? extends A, ? extends B>, Eval<? extends B>> {
            public final /* synthetic */ Function1 a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Function1 function1) {
                super(1);
                this.a = function1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: arrow.core.Eval$Companion */
            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: arrow.core.Eval$Companion */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Either either = (Either) obj;
                Intrinsics.checkParameterIsNotNull(either, "eval");
                if (either instanceof Either.Left) {
                    return Eval.Companion.tailRecM(((Either.Left) either).getA(), this.a);
                }
                if (either instanceof Either.Right) {
                    return Eval.Companion.just(((Either.Right) either).getB());
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        public Companion() {
        }

        @NotNull
        public static final Eval access$collapse(Companion companion, @NotNull Eval eval) {
            Objects.requireNonNull(companion);
            while (eval instanceof Defer) {
                eval = ((Defer) eval).getThunk().invoke();
            }
            return eval instanceof FlatMap ? new Eval$Companion$collapse$1(eval) : eval;
        }

        @NotNull
        public static final Eval access$collapse1(Companion companion, @NotNull Eval eval) {
            Objects.requireNonNull(companion);
            return access$collapse(companion, eval);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: arrow.core.Eval */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Object access$evaluate(Companion companion, @NotNull Eval eval) {
            Objects.requireNonNull(companion);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = eval;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = (T) new ArrayList();
            n6.a.b bVar = new n6.a.b(companion);
            while (true) {
                T t = objectRef.element;
                if (t instanceof FlatMap) {
                    if (t != null) {
                        T t2 = t;
                        Eval start = t2.start();
                        if (start instanceof FlatMap) {
                            n6.a.c cVar = new n6.a.c(start);
                            q4 q4Var = new q4(0, t2, objectRef, objectRef2, bVar);
                            objectRef.element = (T) ((FlatMap) start).start();
                            objectRef2.element.add(0, q4Var);
                            objectRef2.element.add(0, cVar);
                        } else if (start instanceof Memoize) {
                            Memoize memoize = (Memoize) start;
                            Option<A> result = memoize.getResult();
                            if (result instanceof None) {
                                objectRef.element = (T) memoize.getEval();
                                objectRef2.element.add(0, new n6.a.a(start, t2, objectRef, objectRef2, bVar));
                                T t3 = objectRef2.element;
                                if (start != null) {
                                    t3.add(0, bVar.invoke((Memoize) start));
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval.Memoize<kotlin.Any?>");
                                }
                            } else if (result instanceof Some) {
                                objectRef.element = (T) new Now(((Some) result).getT());
                                objectRef2.element.add(0, new q4(1, t2, objectRef, objectRef2, bVar));
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            objectRef.element = (T) t2.run(start.value());
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval.FlatMap<A>");
                    }
                } else if (t instanceof Memoize) {
                    if (t != null) {
                        T t4 = t;
                        T t5 = (T) t4.getEval();
                        Option<A> result2 = t4.getResult();
                        if (result2 instanceof None) {
                            objectRef.element = t5;
                            objectRef2.element.add(0, bVar.invoke(t4));
                        } else if (result2 instanceof Some) {
                            Object t7 = ((Some) result2).getT();
                            if (!objectRef2.element.isEmpty()) {
                                objectRef.element = (T) ((Eval) ((Function1) objectRef2.element.get(0)).invoke(t7));
                                objectRef2.element.remove(0);
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval.Memoize<A>");
                    }
                } else if (!(!objectRef2.element.isEmpty())) {
                    return objectRef.element.value();
                } else {
                    objectRef.element = (T) ((Eval) ((Function1) objectRef2.element.get(0)).invoke(objectRef.element.value()));
                    objectRef2.element.remove(0);
                }
            }
        }

        @NotNull
        public final <A> Always<A> always(@NotNull Function0<? extends A> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "f");
            return new Always<>(function0);
        }

        @NotNull
        public final <A> Eval<A> defer(@NotNull Function0<? extends Eval<? extends A>> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "f");
            return new Defer(function0);
        }

        @NotNull
        public final Eval<Boolean> getFalse() {
            return Eval.c;
        }

        @NotNull
        public final Eval<Integer> getOne() {
            return Eval.e;
        }

        @NotNull
        public final Eval<Boolean> getTrue() {
            return Eval.b;
        }

        @NotNull
        public final Eval<Unit> getUnit() {
            return Eval.a;
        }

        @NotNull
        public final Eval<Integer> getZero() {
            return Eval.d;
        }

        @NotNull
        public final <A> Eval<A> just(A a3) {
            return now(a3);
        }

        @NotNull
        public final <A> Later<A> later(@NotNull Function0<? extends A> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "f");
            return new Later<>(function0);
        }

        @NotNull
        public final <A> Now<A> now(A a3) {
            return new Now<>(a3);
        }

        @NotNull
        public final Eval raise(@NotNull Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "t");
            return defer(new a(th));
        }

        @NotNull
        public final <A, B> Eval<B> tailRecM(A a3, @NotNull Function1<? super A, ? extends Kind<ForEval, ? extends Either<? extends A, ? extends B>>> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "f");
            Kind kind = (Kind) function1.invoke(a3);
            if (kind != null) {
                return ((Eval) kind).flatMap(new b(function1));
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval<A>");
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Larrow/core/Eval$Defer;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Eval;", "memoize", "()Larrow/core/Eval;", "value", "()Ljava/lang/Object;", "Lkotlin/Function0;", "component1", "()Lkotlin/jvm/functions/Function0;", "thunk", "copy", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Eval$Defer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Lkotlin/jvm/functions/Function0;", "getThunk", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Defer<A> extends Eval<A> {
        @NotNull
        public final Function0<Eval<A>> f;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends arrow.core.Eval<? extends A>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Defer(@NotNull Function0<? extends Eval<? extends A>> function0) {
            super(null);
            Intrinsics.checkParameterIsNotNull(function0, "thunk");
            this.f = function0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Eval$Defer */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Defer copy$default(Defer defer, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = defer.f;
            }
            return defer.copy(function0);
        }

        @NotNull
        public final Function0<Eval<A>> component1() {
            return this.f;
        }

        @NotNull
        public final Defer<A> copy(@NotNull Function0<? extends Eval<? extends A>> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "thunk");
            return new Defer<>(function0);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Defer) && Intrinsics.areEqual(this.f, ((Defer) obj).f);
            }
            return true;
        }

        @NotNull
        public final Function0<Eval<A>> getThunk() {
            return this.f;
        }

        public int hashCode() {
            Function0<Eval<A>> function0 = this.f;
            if (function0 != null) {
                return function0.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Eval
        @NotNull
        public Eval<A> memoize() {
            return new Memoize(this);
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Defer(thunk=");
            L.append(this.f);
            L.append(")");
            return L.toString();
        }

        @Override // arrow.core.Eval
        public A value() {
            return (A) Companion.access$collapse(Eval.Companion, this).value();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0002\u0010\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0002\u0010\u00032\u0006\u0010\u0006\u001a\u00028\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Larrow/core/Eval$FlatMap;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Eval;", ExifInterface.LATITUDE_SOUTH, Tracker.Events.CREATIVE_START, "()Larrow/core/Eval;", "s", "run", "(Ljava/lang/Object;)Larrow/core/Eval;", "memoize", "value", "()Ljava/lang/Object;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static abstract class FlatMap<A> extends Eval<A> {
        public FlatMap() {
            super(null);
        }

        @Override // arrow.core.Eval
        @NotNull
        public Eval<A> memoize() {
            return new Memoize(this);
        }

        @NotNull
        public abstract <S> Eval<A> run(S s);

        @NotNull
        public abstract <S> Eval<S> start();

        @Override // arrow.core.Eval
        public A value() {
            return (A) Companion.access$evaluate(Eval.Companion, this);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u00028\u00018F@\u0006X\u0002¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Larrow/core/Eval$Later;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Eval;", "value", "()Ljava/lang/Object;", "memoize", "()Larrow/core/Eval;", "Lkotlin/Function0;", "f", "copy", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Eval$Later;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Lazy;", "getValue", g.a, "Lkotlin/jvm/functions/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Later<A> extends Eval<A> {
        public static final /* synthetic */ KProperty[] h = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Later.class), "value", "getValue()Ljava/lang/Object;"))};
        public final Lazy f;
        public final Function0<A> g;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends A> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Later(@NotNull Function0<? extends A> function0) {
            super(null);
            Intrinsics.checkParameterIsNotNull(function0, "f");
            this.g = function0;
            this.f = t6.c.lazy(function0);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Eval$Later */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Later copy$default(Later later, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = later.g;
            }
            return later.copy(function0);
        }

        @NotNull
        public final Later<A> copy(@NotNull Function0<? extends A> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "f");
            return new Later<>(function0);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Later) && Intrinsics.areEqual(this.g, ((Later) obj).g);
            }
            return true;
        }

        public final A getValue() {
            Lazy lazy = this.f;
            KProperty kProperty = h[0];
            return (A) lazy.getValue();
        }

        public int hashCode() {
            Function0<A> function0 = this.g;
            if (function0 != null) {
                return function0.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Eval
        @NotNull
        public Eval<A> memoize() {
            return this;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Later(f=");
            L.append(this.g);
            L.append(")");
            return L.toString();
        }

        @Override // arrow.core.Eval
        public A value() {
            return getValue();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\bR(\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Larrow/core/Eval$Memoize;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Eval;", "memoize", "()Larrow/core/Eval$Memoize;", "value", "()Ljava/lang/Object;", "component1", "()Larrow/core/Eval;", "eval", "copy", "(Larrow/core/Eval;)Larrow/core/Eval$Memoize;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", g.a, "Larrow/core/Eval;", "getEval", "Larrow/core/Option;", "f", "Larrow/core/Option;", "getResult", "()Larrow/core/Option;", "setResult", "(Larrow/core/Option;)V", "result", "<init>", "(Larrow/core/Eval;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Memoize<A> extends Eval<A> {
        @NotNull
        public Option<? extends A> f = None.INSTANCE;
        @NotNull
        public final Eval<A> g;

        public static final class a extends Lambda implements Function0<A> {
            public final /* synthetic */ Memoize a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Memoize memoize) {
                super(0);
                this.a = memoize;
            }

            @Override // kotlin.jvm.functions.Function0
            public final A invoke() {
                A a3 = (A) Companion.access$evaluate(Eval.Companion, this.a.getEval());
                this.a.setResult(new Some(a3));
                return a3;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Eval<? extends A> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Memoize(@NotNull Eval<? extends A> eval) {
            super(null);
            Intrinsics.checkParameterIsNotNull(eval, "eval");
            this.g = eval;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Eval$Memoize */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Memoize copy$default(Memoize memoize, Eval eval, int i, Object obj) {
            if ((i & 1) != 0) {
                eval = memoize.g;
            }
            return memoize.copy(eval);
        }

        @NotNull
        public final Eval<A> component1() {
            return this.g;
        }

        @NotNull
        public final Memoize<A> copy(@NotNull Eval<? extends A> eval) {
            Intrinsics.checkParameterIsNotNull(eval, "eval");
            return new Memoize<>(eval);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Memoize) && Intrinsics.areEqual(this.g, ((Memoize) obj).g);
            }
            return true;
        }

        @NotNull
        public final Eval<A> getEval() {
            return this.g;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: arrow.core.Option<? extends A>, arrow.core.Option<A> */
        @NotNull
        public final Option<A> getResult() {
            return (Option<? extends A>) this.f;
        }

        public int hashCode() {
            Eval<A> eval = this.g;
            if (eval != null) {
                return eval.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Eval
        @NotNull
        public Memoize<A> memoize() {
            return this;
        }

        public final void setResult(@NotNull Option<? extends A> option) {
            Intrinsics.checkParameterIsNotNull(option, "<set-?>");
            this.f = option;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Memoize(eval=");
            L.append(this.g);
            L.append(")");
            return L.toString();
        }

        @Override // arrow.core.Eval
        public A value() {
            return (A) OptionKt.getOrElse(this.f, new a(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Larrow/core/Eval$Now;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Eval;", "value", "()Ljava/lang/Object;", "memoize", "()Larrow/core/Eval;", "component1", "copy", "(Ljava/lang/Object;)Larrow/core/Eval$Now;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Now<A> extends Eval<A> {
        public final A f;

        public Now(A a) {
            super(null);
            this.f = a;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Eval$Now */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Now copy$default(Now now, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = now.f;
            }
            return now.copy(obj);
        }

        public final A component1() {
            return this.f;
        }

        @NotNull
        public final Now<A> copy(A a) {
            return new Now<>(a);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Now) && Intrinsics.areEqual(this.f, ((Now) obj).f);
            }
            return true;
        }

        public final A getValue() {
            return this.f;
        }

        public int hashCode() {
            A a = this.f;
            if (a != null) {
                return a.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Eval
        @NotNull
        public Eval<A> memoize() {
            return this;
        }

        public String toString() {
            return a2.b.a.a.a.r(a2.b.a.a.a.L("Now(value="), this.f, ")");
        }

        @Override // arrow.core.Eval
        public A value() {
            return this.f;
        }
    }

    public static final class a extends Lambda implements Function1<Function1<? super A, ? extends B>, Eval<? extends B>> {
        public final /* synthetic */ Eval a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Eval eval) {
            super(1);
            this.a = eval;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Function1 function1 = (Function1) obj;
            Intrinsics.checkParameterIsNotNull(function1, "f");
            return this.a.map(function1);
        }
    }

    public static final class b extends Lambda implements Function0<B> {
        public final /* synthetic */ Eval a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Eval eval, Function1 function1) {
            super(0);
            this.a = eval;
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public final B invoke() {
            return (B) this.b.invoke(this.a);
        }
    }

    public static final class c extends Lambda implements Function1<A, Now<? extends B>> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return new Now(this.a.invoke(obj));
        }
    }

    public Eval() {
    }

    @NotNull
    public final <B> Eval<B> ap(@NotNull Kind<ForEval, ? extends Function1<? super A, ? extends B>> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "ff");
        Eval<B> flatMap = ((Eval) kind).flatMap(new a(this));
        if (flatMap != null) {
            return flatMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval<A>");
    }

    @NotNull
    public final <B> Eval<B> coflatMap(@NotNull Function1<? super Kind<ForEval, ? extends A>, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return new Later(new b(this, function1));
    }

    public final A extract() {
        return value();
    }

    @NotNull
    public final <B> Eval<B> flatMap(@NotNull Function1<? super A, ? extends Kind<ForEval, ? extends B>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof FlatMap) {
            return new Eval$flatMap$1(this, function1);
        }
        if (this instanceof Defer) {
            return new FlatMap<B>(this, function1) { // from class: arrow.core.Eval$flatMap$2
                public final /* synthetic */ Eval f;
                public final /* synthetic */ Function1 g;

                {
                    this.f = r1;
                    this.g = r2;
                }

                @Override // arrow.core.Eval.FlatMap
                @NotNull
                public <S> Eval<B> run(S s) {
                    Kind kind = (Kind) this.g.invoke(s);
                    if (kind != null) {
                        return (Eval) kind;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval<A>");
                }

                @Override // arrow.core.Eval.FlatMap
                @NotNull
                public <S> Eval<S> start() {
                    Object invoke = ((Eval.Defer) this.f).getThunk().invoke();
                    if (invoke != null) {
                        return (Eval) invoke;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval<S>");
                }
            };
        }
        return new FlatMap<B>(this, function1) { // from class: arrow.core.Eval$flatMap$3
            public final /* synthetic */ Eval f;
            public final /* synthetic */ Function1 g;

            {
                this.f = r1;
                this.g = r2;
            }

            @Override // arrow.core.Eval.FlatMap
            @NotNull
            public <S> Eval<B> run(S s) {
                Kind kind = (Kind) this.g.invoke(s);
                if (kind != null) {
                    return (Eval) kind;
                }
                throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval<A>");
            }

            @Override // arrow.core.Eval.FlatMap
            @NotNull
            public <S> Eval<S> start() {
                Eval<S> eval = this.f;
                if (eval != null) {
                    return eval;
                }
                throw new TypeCastException("null cannot be cast to non-null type arrow.core.Eval<S>");
            }
        };
    }

    @NotNull
    public final <B> Eval<B> map(@NotNull Function1<? super A, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return flatMap(new c(function1));
    }

    @NotNull
    public abstract Eval<A> memoize();

    public abstract A value();

    public Eval(j jVar) {
    }
}
