package a2.g.v.l;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.share.internal.ShareConstants;
@Deprecated
public final class l extends PlatformServiceClient {
    public String j;

    public l(Context context, String str, String str2) {
        super(context, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20141001, str);
        this.j = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    public void populateRequestBundle(Bundle bundle) {
        bundle.putString(ShareConstants.EXTRA_OBJECT_ID, this.j);
    }
}
