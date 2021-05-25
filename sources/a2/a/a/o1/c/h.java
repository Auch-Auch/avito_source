package a2.a.a.o1.c;

import com.avito.android.messenger.connection.AvitoMessengerSessionRefresher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public final class h extends Lambda implements Function1<Request, Response> {
    public final /* synthetic */ AvitoMessengerSessionRefresher.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(AvitoMessengerSessionRefresher.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Response invoke(Request request) {
        Request request2 = request;
        Intrinsics.checkNotNullParameter(request2, "request");
        return ((OkHttpClient) this.a.a.b.get()).newCall(request2).execute();
    }
}
