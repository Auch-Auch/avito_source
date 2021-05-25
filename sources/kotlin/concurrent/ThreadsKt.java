package kotlin.concurrent;

import com.google.firebase.messaging.Constants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", Tracker.Events.CREATIVE_START, "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", "", "name", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lkotlin/Function0;", "", "block", "Ljava/lang/Thread;", "thread", "(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)Ljava/lang/Thread;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "ThreadsKt")
public final class ThreadsKt {
    @NotNull
    public static final Thread thread(boolean z, boolean z2, @Nullable ClassLoader classLoader, @Nullable String str, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ThreadsKt$thread$thread$1 threadsKt$thread$thread$1 = new Thread(function0) { // from class: kotlin.concurrent.ThreadsKt$thread$thread$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                this.a.invoke();
            }
        };
        if (z2) {
            threadsKt$thread$thread$1.setDaemon(true);
        }
        if (i > 0) {
            threadsKt$thread$thread$1.setPriority(i);
        }
        if (str != null) {
            threadsKt$thread$thread$1.setName(str);
        }
        if (classLoader != null) {
            threadsKt$thread$thread$1.setContextClassLoader(classLoader);
        }
        if (z) {
            threadsKt$thread$thread$1.start();
        }
        return threadsKt$thread$thread$1;
    }

    public static /* synthetic */ Thread thread$default(boolean z, boolean z2, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        return thread((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : classLoader, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? -1 : i, function0);
    }
}
