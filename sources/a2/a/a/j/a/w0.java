package a2.a.a.j.a;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class w0<T> implements Consumer<Throwable> {
    public static final w0 a = new w0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("ScheduleMetricSendTask", "startup time", th);
    }
}
