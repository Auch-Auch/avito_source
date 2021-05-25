package a2.a.a.i.j;

import com.avito.android.analytics.inhouse_transport.UploadResult;
import com.avito.android.analytics.statsd.StatsdSenderImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<UploadResult> {
    public final /* synthetic */ StatsdSenderImpl.a a;
    public final /* synthetic */ List b;

    public b(StatsdSenderImpl.a aVar, List list) {
        this.a = aVar;
        this.b = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(UploadResult uploadResult) {
        UploadResult uploadResult2 = uploadResult;
        StatsdSenderImpl statsdSenderImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(uploadResult2, "it");
        List list = this.b;
        Intrinsics.checkNotNullExpressionValue(list, "events");
        StatsdSenderImpl.access$handleRecoverableError(statsdSenderImpl, uploadResult2, list);
    }
}
