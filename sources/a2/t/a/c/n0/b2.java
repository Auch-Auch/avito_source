package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.avito.android.util.preferences.Preference;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKApiCommunityFull;
import com.voximplant.sdk.internal.Logger;
public class b2 {
    @SerializedName("displayName")
    @Expose
    private String mDisplayName;
    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName(VKApiCommunityFull.PLACE)
    @Expose
    private Long mPlace;
    @SerializedName("sipURI")
    @Expose
    private String mSipUri;
    @SerializedName(Preference.USERNAME)
    @Expose
    private String mUserName;

    public String a() {
        return this.mDisplayName;
    }

    public String b() {
        return this.mId;
    }

    public int c() {
        Long l = this.mPlace;
        if (l != null) {
            return l.intValue();
        }
        return 0;
    }

    public String d() {
        return this.mSipUri;
    }

    public String e() {
        return this.mUserName;
    }

    public void f(String str) {
        this.mDisplayName = str;
    }

    public void g(String str) {
        this.mSipUri = str;
        if (str != null && str.startsWith("sip:")) {
            try {
                this.mUserName = str.substring(4, str.indexOf("@"));
                Logger.i("EndpointInfo: setEndpointInfo: user name: " + this.mUserName);
            } catch (IndexOutOfBoundsException unused) {
                Logger.e("EndpointInfo: setEndpointInfo: fail to get user name");
                this.mUserName = null;
            }
        }
    }

    public String toString() {
        StringBuilder L = a.L("[");
        L.append(this.mId);
        L.append(", ");
        L.append(this.mDisplayName);
        L.append(", ");
        return a.t(L, this.mSipUri, "]");
    }
}
