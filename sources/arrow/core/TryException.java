package arrow.core;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\t\nR\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Larrow/core/TryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "PredicateException", "UnsupportedOperationException", "Larrow/core/TryException$PredicateException;", "Larrow/core/TryException$UnsupportedOperationException;", "arrow-core"}, k = 1, mv = {1, 4, 0})
public abstract class TryException extends Exception {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Larrow/core/TryException$PredicateException;", "Larrow/core/TryException;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Larrow/core/TryException$PredicateException;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class PredicateException extends TryException {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PredicateException(@NotNull String str) {
            super(str, null);
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.b = str;
        }

        @NotNull
        public static /* bridge */ /* synthetic */ PredicateException copy$default(PredicateException predicateException, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = predicateException.getMessage();
            }
            return predicateException.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final PredicateException copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            return new PredicateException(str);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof PredicateException) && Intrinsics.areEqual(getMessage(), ((PredicateException) obj).getMessage());
            }
            return true;
        }

        @Override // arrow.core.TryException, java.lang.Throwable
        @NotNull
        public String getMessage() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message = getMessage();
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Throwable, java.lang.Object
        public String toString() {
            StringBuilder L = a.L("PredicateException(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Larrow/core/TryException$UnsupportedOperationException;", "Larrow/core/TryException;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Larrow/core/TryException$UnsupportedOperationException;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class UnsupportedOperationException extends TryException {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnsupportedOperationException(@NotNull String str) {
            super(str, null);
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.b = str;
        }

        @NotNull
        public static /* bridge */ /* synthetic */ UnsupportedOperationException copy$default(UnsupportedOperationException unsupportedOperationException, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unsupportedOperationException.getMessage();
            }
            return unsupportedOperationException.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final UnsupportedOperationException copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            return new UnsupportedOperationException(str);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof UnsupportedOperationException) && Intrinsics.areEqual(getMessage(), ((UnsupportedOperationException) obj).getMessage());
            }
            return true;
        }

        @Override // arrow.core.TryException, java.lang.Throwable
        @NotNull
        public String getMessage() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message = getMessage();
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Throwable, java.lang.Object
        public String toString() {
            StringBuilder L = a.L("UnsupportedOperationException(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }
    }

    public TryException(@NotNull String str, j jVar) {
        super(str);
        this.a = str;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.a;
    }
}
