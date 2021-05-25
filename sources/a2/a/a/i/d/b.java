package a2.a.a.i.d;

import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.analytics.clickstream.ClickStreamSenderImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<ClickStreamSender.UploadResult> {
    public final /* synthetic */ ClickStreamSenderImpl.a a;
    public final /* synthetic */ List b;

    public b(ClickStreamSenderImpl.a aVar, List list) {
        this.a = aVar;
        this.b = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ClickStreamSender.UploadResult uploadResult) {
        ClickStreamSender.UploadResult uploadResult2 = uploadResult;
        ClickStreamSenderImpl clickStreamSenderImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(uploadResult2, "it");
        List list = this.b;
        Intrinsics.checkNotNullExpressionValue(list, "events");
        ClickStreamSenderImpl.access$handleUploadResult(clickStreamSenderImpl, uploadResult2, list);
    }
}
