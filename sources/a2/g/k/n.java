package a2.g.k;

import com.facebook.internal.InstallReferrerUtil;
public final class n implements InstallReferrerUtil.Callback {
    @Override // com.facebook.internal.InstallReferrerUtil.Callback
    public void onReceiveReferrerUrl(String str) {
        o.m(str);
    }
}
