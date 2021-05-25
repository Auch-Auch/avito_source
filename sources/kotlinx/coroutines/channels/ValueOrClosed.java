package kotlinx.coroutines.channels;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\r\b@\u0018\u0000 !*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\"!B\u0016\b\u0000\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0012\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00168F@\u0006¢\u0006\f\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001b\u0010\u000fR\u0013\u0010\u001f\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlinx/coroutines/channels/ValueOrClosed;", "T", "", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "getValueOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValueOrNull$annotations", "()V", "valueOrNull", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "holder", "", "getCloseCause-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getCloseCause$annotations", "closeCause", "getValue-impl", "getValue$annotations", "value", "isClosed-impl", "isClosed", "constructor-impl", "Companion", "Closed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class ValueOrClosed<T> {
    public static final Companion Companion = new Companion(null);
    public final Object a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/ValueOrClosed$Closed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "cause", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class Closed {
        @JvmField
        @Nullable
        public final Throwable cause;

        public Closed(@Nullable Throwable th) {
            this.cause = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Closed(");
            L.append(this.cause);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/ValueOrClosed$Companion;", "", ExifInterface.LONGITUDE_EAST, "value", "Lkotlinx/coroutines/channels/ValueOrClosed;", "value-ZYPwvRU$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "cause", "closed-ZYPwvRU$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "closed", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        /* renamed from: closed-ZYPwvRU$kotlinx_coroutines_core  reason: not valid java name */
        public final <E> Object m512closedZYPwvRU$kotlinx_coroutines_core(@Nullable Throwable th) {
            return ValueOrClosed.m502constructorimpl(new Closed(th));
        }

        @NotNull
        /* renamed from: value-ZYPwvRU$kotlinx_coroutines_core  reason: not valid java name */
        public final <E> Object m513valueZYPwvRU$kotlinx_coroutines_core(E e) {
            return ValueOrClosed.m502constructorimpl(e);
        }

        public Companion(j jVar) {
        }
    }

    public /* synthetic */ ValueOrClosed(@Nullable Object obj) {
        this.a = obj;
    }

    @NotNull
    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ValueOrClosed m501boximpl(@Nullable Object obj) {
        return new ValueOrClosed(obj);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m502constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m503equalsimpl(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof ValueOrClosed) && Intrinsics.areEqual(obj, ((ValueOrClosed) obj2).m511unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m504equalsimpl0(@Nullable Object obj, @Nullable Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getCloseCause$annotations() {
    }

    @Nullable
    /* renamed from: getCloseCause-impl  reason: not valid java name */
    public static final Throwable m505getCloseCauseimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).cause;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getValue-impl  reason: not valid java name */
    public static final T m506getValueimpl(Object obj) {
        if (!(obj instanceof Closed)) {
            return obj;
        }
        throw new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE.toString());
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* renamed from: getValueOrNull-impl  reason: not valid java name */
    public static final T m507getValueOrNullimpl(Object obj) {
        if (obj instanceof Closed) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m508hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m509isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m510toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m503equalsimpl(this.a, obj);
    }

    public int hashCode() {
        return m508hashCodeimpl(this.a);
    }

    @NotNull
    public String toString() {
        return m510toStringimpl(this.a);
    }

    @Nullable
    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m511unboximpl() {
        return this.a;
    }
}
