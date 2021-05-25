package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u6.a.m;
import u6.a.o;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u001c\u0010\t\u001a\u00020\u00048\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u001c\u0010\u000e\u001a\u00020\n8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\b\"\u001c\u0010\u0011\u001a\u00020\n8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u0012\u0004\b\u0010\u0010\b\"\u001c\u0010\u0014\u001a\u00020\u00048\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u0012\u0004\b\u0013\u0010\b\"\u001c\u0010\u0015\u001a\u00020\u00048\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u0012\u0004\b\u0016\u0010\b\"\u001c\u0010\u0019\u001a\u00020\u00048\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u0012\u0004\b\u0018\u0010\b\"\u001c\u0010\u001c\u001a\u00020\u00048\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u0012\u0004\b\u001b\u0010\b¨\u0006\u001d"}, d2 = {"", "boxIncomplete", "(Ljava/lang/Object;)Ljava/lang/Object;", "unboxState", "Lkotlinx/coroutines/internal/Symbol;", "d", "Lkotlinx/coroutines/internal/Symbol;", "getSEALED$annotations", "()V", "SEALED", "Lu6/a/m;", "e", "Lu6/a/m;", "getEMPTY_NEW$annotations", "EMPTY_NEW", "f", "getEMPTY_ACTIVE$annotations", "EMPTY_ACTIVE", AuthSource.SEND_ABUSE, "getCOMPLETING_ALREADY$annotations", "COMPLETING_ALREADY", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", AuthSource.BOOKING_ORDER, "getCOMPLETING_RETRY$annotations", "COMPLETING_RETRY", "c", "getTOO_LATE_TO_CANCEL$annotations", "TOO_LATE_TO_CANCEL", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class JobSupportKt {
    @JvmField
    @NotNull
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
    public static final Symbol a = new Symbol("COMPLETING_ALREADY");
    public static final Symbol b = new Symbol("COMPLETING_RETRY");
    public static final Symbol c = new Symbol("TOO_LATE_TO_CANCEL");
    public static final Symbol d = new Symbol("SEALED");
    public static final m e = new m(false);
    public static final m f = new m(true);

    @Nullable
    public static final Object boxIncomplete(@Nullable Object obj) {
        return obj instanceof Incomplete ? new o((Incomplete) obj) : obj;
    }

    public static /* synthetic */ void getCOMPLETING_WAITING_CHILDREN$annotations() {
    }

    @Nullable
    public static final Object unboxState(@Nullable Object obj) {
        Incomplete incomplete;
        o oVar = (o) (!(obj instanceof o) ? null : obj);
        return (oVar == null || (incomplete = oVar.a) == null) ? obj : incomplete;
    }
}
