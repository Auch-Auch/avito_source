package a2.a.a.o1.d.a0.f;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<Boolean> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        StringBuilder sb = new StringBuilder();
        sb.append("Attachment cache is ");
        Intrinsics.checkNotNullExpressionValue(bool2, "isDeleted");
        sb.append(bool2.booleanValue() ? "successfully cleared" : "NOT cleared");
        Logs.debug$default("FileUploadInitializerImpl", sb.toString(), null, 4, null);
    }
}
