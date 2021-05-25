package a2.g.s;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
public final class o extends PlatformServiceClient {
    public final String j;
    public final String k;
    public final long l;

    public o(Context context, String str, String str2, String str3, long j2) {
        super(context, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20170411, str);
        this.j = str2;
        this.k = str3;
        this.l = j2;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    public void populateRequestBundle(Bundle bundle) {
        bundle.putString(NativeProtocol.EXTRA_LOGGER_REF, this.j);
        bundle.putString(NativeProtocol.EXTRA_GRAPH_API_VERSION, this.k);
        bundle.putLong(NativeProtocol.EXTRA_TOAST_DURATION_MS, this.l);
    }
}
