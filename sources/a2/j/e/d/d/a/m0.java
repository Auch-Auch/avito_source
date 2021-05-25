package a2.j.e.d.d.a;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import java.io.File;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
public class m0 {
    public static final Charset b = Charset.forName("UTF-8");
    public final File a;

    public m0(File file) {
        this.a = file;
    }

    public static UserMetadata c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        UserMetadata userMetadata = new UserMetadata();
        String str2 = null;
        if (!jSONObject.isNull(ChannelContext.Item.USER_ID)) {
            str2 = jSONObject.optString(ChannelContext.Item.USER_ID, null);
        }
        userMetadata.setUserId(str2);
        return userMetadata;
    }

    @NonNull
    public File a(String str) {
        return new File(this.a, a.e3(str, "keys", ".meta"));
    }

    @NonNull
    public File b(String str) {
        return new File(this.a, a.e3(str, "user", ".meta"));
    }
}
