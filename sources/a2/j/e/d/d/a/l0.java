package a2.j.e.d.d.a;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import org.json.JSONException;
import org.json.JSONObject;
public class l0 extends JSONObject {
    public final /* synthetic */ UserMetadata a;

    public l0(UserMetadata userMetadata) throws JSONException {
        this.a = userMetadata;
        put(ChannelContext.Item.USER_ID, userMetadata.getUserId());
    }
}
