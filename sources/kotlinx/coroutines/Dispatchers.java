package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00128F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", AuthSource.BOOKING_ORDER, "Lkotlinx/coroutines/CoroutineDispatcher;", "getUnconfined", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getUnconfined$annotations", "()V", "Unconfined", AuthSource.SEND_ABUSE, "getDefault", "getDefault$annotations", "Default", "c", "getIO", "getIO$annotations", "IO", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();
    @NotNull
    public static final CoroutineDispatcher a = CoroutineContextKt.createDefaultDispatcher();
    @NotNull
    public static final CoroutineDispatcher b = Unconfined.INSTANCE;
    @NotNull
    public static final CoroutineDispatcher c = DefaultScheduler.INSTANCE.getIO();

    @NotNull
    public static final CoroutineDispatcher getDefault() {
        return a;
    }

    @JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    @NotNull
    public static final CoroutineDispatcher getIO() {
        return c;
    }

    @JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    @NotNull
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    @NotNull
    public static final CoroutineDispatcher getUnconfined() {
        return b;
    }

    @JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }
}
