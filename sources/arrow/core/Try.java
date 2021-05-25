package arrow.core;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.core.Either;
import arrow.core.TryException;
import arrow.higherkind;
import arrow.legacy.Disjunction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 <*\u0006\b\u0000\u0010\u0001 \u00012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0004:\u0003<=>B\t\b\u0002¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JO\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000724\u0010\t\u001a0\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b`\u0004¢\u0006\u0004\b\n\u0010\u000bJH\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00072*\b\u0004\u0010\f\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00040\bH\b¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00072\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\b¢\u0006\u0004\b\u000f\u0010\u000eJ6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00028\u0000`\u0011H\b¢\u0006\u0004\b\u0013\u0010\u000eJ\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0000¢\u0006\u0004\b\u0015\u0010\u0016J>\u0010\u0019\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00010\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H&¢\u0006\u0004\b\u001d\u0010\u001cJ#\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0\bH\u0007¢\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0\bH\u0007¢\u0006\u0004\b!\u0010\u000eJ+\u0010#\u001a\u00020\u00102\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00028\u0000`\u0011¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00028\u0000H'¢\u0006\u0004\b%\u0010\u0006J)\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0\bH\u0007¢\u0006\u0004\b'\u0010\u000eJ)\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001e0\bH\u0007¢\u0006\u0004\b(\u0010\u000eJ\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000,¢\u0006\u0004\b-\u0010.J\u001b\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000/H\u0007¢\u0006\u0004\b0\u00101J5\u00104\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00072\u0006\u00102\u001a\u00028\u00012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103¢\u0006\u0004\b4\u00105JM\u00108\u001a\b\u0012\u0004\u0012\u00028\u000106\"\u0004\b\u0001\u0010\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u0001062$\u0010\f\u001a \u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000106\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010603¢\u0006\u0004\b8\u00109\u0001\u0002?@¨\u0006A"}, d2 = {"Larrow/core/Try;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/Kind;", "Larrow/core/ForTry;", "Larrow/core/TryOf;", "invoke", "()Ljava/lang/Object;", "B", "Lkotlin/Function1;", "ff", "ap", "(Larrow/Kind;)Larrow/core/Try;", "f", "flatMap", "(Lkotlin/jvm/functions/Function1;)Larrow/core/Try;", "map", "", "Larrow/core/Predicate;", "p", "filter", "", PaymentStateKt.PAYMENT_STATE_FAILED, "()Larrow/core/Try;", "fa", "fb", "fold", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isFailure", "()Z", "isSuccess", "", "foreach", "(Lkotlin/jvm/functions/Function1;)V", "onEach", "predicate", "exists", "(Lkotlin/jvm/functions/Function1;)Z", "get", SDKConstants.PARAM_A2U_BODY, "onSuccess", "onFailure", "Larrow/core/Option;", "toOption", "()Larrow/core/Option;", "Larrow/core/Either;", "toEither", "()Larrow/core/Either;", "Larrow/legacy/Disjunction;", "toDisjunction", "()Larrow/legacy/Disjunction;", AuthSource.BOOKING_ORDER, "Lkotlin/Function2;", "foldLeft", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Larrow/core/Eval;", "lb", "foldRight", "(Larrow/core/Eval;Lkotlin/jvm/functions/Function2;)Larrow/core/Eval;", "<init>", "()V", "Companion", "Failure", "Success", "Larrow/core/Try$Failure;", "Larrow/core/Try$Success;", "arrow-core"}, k = 1, mv = {1, 4, 0})
public abstract class Try<A> implements Kind<ForTry, A> {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006Jl\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00072\u0006\u0010\u0003\u001a\u00028\u00012@\u0010\r\u001a<\u0012\u0004\u0012\u00028\u0001\u00122\u00120\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b`\f0\bH\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\n¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Larrow/core/Try$Companion;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AuthSource.SEND_ABUSE, "Larrow/core/Try;", "just", "(Ljava/lang/Object;)Larrow/core/Try;", "B", "Lkotlin/Function1;", "Larrow/Kind;", "Larrow/core/ForTry;", "Larrow/core/Either;", "Larrow/core/TryOf;", "f", "tailRecM", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Larrow/core/Try;", "Lkotlin/Function0;", "invoke", "(Lkotlin/jvm/functions/Function0;)Larrow/core/Try;", "", "e", "raise", "(Ljava/lang/Throwable;)Larrow/core/Try;", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <A> Try<A> invoke(@NotNull Function0<? extends A> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "f");
            try {
                return new Success(function0.invoke());
            } catch (Throwable th) {
                return new Failure(th);
            }
        }

        @NotNull
        public final <A> Try<A> just(A a) {
            return new Success(a);
        }

        @NotNull
        public final <A> Try<A> raise(@NotNull Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "e");
            return new Failure(th);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:? */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: ? super A */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
        @NotNull
        public final <A, B> Try<B> tailRecM(A a, @NotNull Function1<? super A, ? extends Kind<ForTry, ? extends Either<? extends A, ? extends B>>> function1) {
            while (true) {
                Intrinsics.checkParameterIsNotNull(function1, "f");
                Kind kind = (Kind) function1.invoke((Object) a);
                if (kind != null) {
                    Try r2 = (Try) kind;
                    if (r2 instanceof Failure) {
                        return new Failure(((Failure) r2).getException());
                    }
                    if (r2 instanceof Success) {
                        Either either = (Either) ((Success) r2).getValue();
                        if (either instanceof Either.Left) {
                            a = (Object) ((Either.Left) either).getA();
                        } else if (either instanceof Either.Right) {
                            return new Success(((Either.Right) either).getB());
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
                }
            }
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Larrow/core/Try$Failure;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Try;", "", "isFailure", "()Z", "isSuccess", "get", "()Ljava/lang/Object;", "", "component1", "()Ljava/lang/Throwable;", OkListener.KEY_EXCEPTION, "copy", "(Ljava/lang/Throwable;)Larrow/core/Try$Failure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getException", "<init>", "(Ljava/lang/Throwable;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Failure<A> extends Try<A> {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkParameterIsNotNull(th, OkListener.KEY_EXCEPTION);
            this.a = th;
        }

        @NotNull
        public static /* bridge */ /* synthetic */ Failure copy$default(Failure failure, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = failure.a;
            }
            return failure.copy(th);
        }

        @NotNull
        public final Throwable component1() {
            return this.a;
        }

        @NotNull
        public final Failure<A> copy(@NotNull Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, OkListener.KEY_EXCEPTION);
            return new Failure<>(th);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Failure) && Intrinsics.areEqual(this.a, ((Failure) obj).a);
            }
            return true;
        }

        @Override // arrow.core.Try
        public A get() {
            throw this.a;
        }

        @NotNull
        public final Throwable getException() {
            return this.a;
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Try
        public boolean isFailure() {
            return true;
        }

        @Override // arrow.core.Try
        public boolean isSuccess() {
            return false;
        }

        public String toString() {
            StringBuilder L = a.L("Failure(exception=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\n\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Larrow/core/Try$Success;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Larrow/core/Try;", "", "isFailure", "()Z", "isSuccess", "get", "()Ljava/lang/Object;", "component1", "value", "copy", "(Ljava/lang/Object;)Larrow/core/Try$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Success<A> extends Try<A> {
        public final A a;

        public Success(A a3) {
            super(null);
            this.a = a3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: arrow.core.Try$Success */
        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static /* bridge */ /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.a;
            }
            return success.copy(obj);
        }

        public final A component1() {
            return this.a;
        }

        @NotNull
        public final Success<A> copy(A a3) {
            return new Success<>(a3);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Success) && Intrinsics.areEqual(this.a, ((Success) obj).a);
            }
            return true;
        }

        @Override // arrow.core.Try
        public A get() {
            return this.a;
        }

        public final A getValue() {
            return this.a;
        }

        public int hashCode() {
            A a3 = this.a;
            if (a3 != null) {
                return a3.hashCode();
            }
            return 0;
        }

        @Override // arrow.core.Try
        public boolean isFailure() {
            return false;
        }

        @Override // arrow.core.Try
        public boolean isSuccess() {
            return true;
        }

        public String toString() {
            return a.r(a.L("Success(value="), this.a, ")");
        }
    }

    public Try() {
    }

    @NotNull
    public final <B> Try<B> ap(@NotNull Kind<ForTry, ? extends Function1<? super A, ? extends B>> kind) {
        Try<B> r3;
        Intrinsics.checkParameterIsNotNull(kind, "ff");
        Try r32 = (Try) kind;
        if (r32 instanceof Failure) {
            r3 = Companion.raise(((Failure) r32).getException());
        } else if (r32 instanceof Success) {
            Function1 function1 = (Function1) ((Success) r32).getValue();
            if (this instanceof Failure) {
                r3 = new Failure(((Failure) this).getException());
            } else if (this instanceof Success) {
                r3 = new Success(function1.invoke(((Success) this).getValue()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (r3 != null) {
            return r3;
        }
        throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
    }

    public final boolean exists(@NotNull Function1<? super A, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (this instanceof Failure) {
            ((Failure) this).getException();
            return false;
        } else if (this instanceof Success) {
            return function1.invoke((Object) ((Success) this).getValue()).booleanValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Try<Throwable> failed() {
        if (this instanceof Failure) {
            return new Success(((Failure) this).getException());
        }
        if (this instanceof Success) {
            ((Success) this).getValue();
            return new Failure(new TryException.UnsupportedOperationException("Success"));
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Try<A> filter(@NotNull Function1<? super A, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "p");
        if (this instanceof Failure) {
            return new Failure(((Failure) this).getException());
        }
        if (this instanceof Success) {
            Object obj = (Object) ((Success) this).getValue();
            return function1.invoke(obj).booleanValue() ? new Success<>(obj) : new Failure<>(new TryException.PredicateException(a.b3("Predicate does not hold for ", obj)));
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final <B> Try<B> flatMap(@NotNull Function1<? super A, ? extends Kind<ForTry, ? extends B>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Failure) {
            return Companion.raise(((Failure) this).getException());
        } else if (this instanceof Success) {
            Kind kind = (Kind) function1.invoke((Object) ((Success) this).getValue());
            if (kind != null) {
                return (Try) kind;
            }
            throw new TypeCastException("null cannot be cast to non-null type arrow.core.Try<A>");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final <B> B fold(@NotNull Function1<? super Throwable, ? extends B> function1, @NotNull Function1<? super A, ? extends B> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "fa");
        Intrinsics.checkParameterIsNotNull(function12, "fb");
        if (this instanceof Failure) {
            return (B) function1.invoke(((Failure) this).getException());
        }
        if (this instanceof Success) {
            return (B) function12.invoke((Object) ((Success) this).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <B> B foldLeft(B b, @NotNull Function2<? super B, ? super A, ? extends B> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (this instanceof Failure) {
            ((Failure) this).getException();
            return b;
        } else if (this instanceof Success) {
            return (B) function2.invoke(b, (Object) ((Success) this).getValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Eval<? extends B> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <B> Eval<B> foldRight(@NotNull Eval<? extends B> eval, @NotNull Function2<? super A, ? super Eval<? extends B>, ? extends Eval<? extends B>> function2) {
        Intrinsics.checkParameterIsNotNull(eval, "lb");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        if (this instanceof Failure) {
            ((Failure) this).getException();
            return eval;
        } else if (this instanceof Success) {
            return (Eval) function2.invoke((Object) ((Success) this).getValue(), eval);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "fold({ Unit }, f)", imports = {}))
    public final void foreach(@NotNull Function1<? super A, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (isSuccess()) {
            function1.invoke(get());
        }
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "getOrElse { ifEmpty }", imports = {}))
    public abstract A get();

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "getOrElse { ifEmpty }", imports = {}))
    public final A invoke() {
        return get();
    }

    public abstract boolean isFailure();

    public abstract boolean isSuccess();

    @NotNull
    public final <B> Try<B> map(@NotNull Function1<? super A, ? extends B> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Failure) {
            return new Failure(((Failure) this).getException());
        }
        if (this instanceof Success) {
            return new Success(function1.invoke((Object) ((Success) this).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "map { f(it); it }", imports = {}))
    @NotNull
    public final Try<A> onEach(@NotNull Function1<? super A, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (this instanceof Failure) {
            return new Failure(((Failure) this).getException());
        }
        if (this instanceof Success) {
            Object obj = (Object) ((Success) this).getValue();
            function1.invoke(obj);
            return new Success(obj);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "fold ({ Try { body(it); it }}, { Try.just(it) })", imports = {}))
    @NotNull
    public final Try<A> onFailure(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, SDKConstants.PARAM_A2U_BODY);
        if (!(this instanceof Success)) {
            if (this instanceof Failure) {
                function1.invoke(((Failure) this).getException());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return this;
    }

    @Deprecated(message = UtilsKt.DeprecatedUnsafeAccess, replaceWith = @ReplaceWith(expression = "map { body(it); it }", imports = {}))
    @NotNull
    public final Try<A> onSuccess(@NotNull Function1<? super A, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, SDKConstants.PARAM_A2U_BODY);
        foreach(function1);
        return this;
    }

    @Deprecated(message = "arrow.data.Either is already right biased. This function will be removed in future releases", replaceWith = @ReplaceWith(expression = "toEither()", imports = {}))
    @NotNull
    public final Disjunction<Throwable, A> toDisjunction() {
        return toEither().toDisjunction();
    }

    @NotNull
    public final Either<Throwable, A> toEither() {
        if (this instanceof Failure) {
            return EitherKt.Left(((Failure) this).getException());
        }
        if (this instanceof Success) {
            return EitherKt.Right(((Success) this).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Option<A> toOption() {
        if (this instanceof Failure) {
            ((Failure) this).getException();
            return None.INSTANCE;
        } else if (this instanceof Success) {
            return new Some(((Success) this).getValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public Try(j jVar) {
    }
}
