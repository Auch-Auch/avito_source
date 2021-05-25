package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u001c\u0010\u0005\u001a\u00020\u00008\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"", AuthSource.SEND_ABUSE, "Z", "getANDROID_DETECTED", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class FastServiceLoaderKt {
    public static final boolean a;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m242constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m242constructorimpl(ResultKt.createFailure(th));
        }
        a = Result.m248isSuccessimpl(obj);
    }

    public static final boolean getANDROID_DETECTED() {
        return true;
    }
}
