package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "", AuthSource.SEND_ABUSE, "Z", "FAST_SERVICE_LOADER_ENABLED", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class MainDispatcherLoader {
    public static final MainDispatcherLoader INSTANCE = new MainDispatcherLoader();
    public static final boolean a = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
    @JvmField
    @NotNull
    public static final MainCoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    static {
        MainDispatcherFactory mainDispatcherFactory;
        MainCoroutineDispatcher tryCreateDispatcher;
        List list = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            mainDispatcherFactory = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            mainDispatcherFactory = next;
        }
        MainDispatcherFactory mainDispatcherFactory2 = mainDispatcherFactory;
        if (mainDispatcherFactory2 == null || (tryCreateDispatcher = MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory2, list)) == null) {
            MainDispatchersKt.throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        } else {
            dispatcher = tryCreateDispatcher;
        }
    }
}
