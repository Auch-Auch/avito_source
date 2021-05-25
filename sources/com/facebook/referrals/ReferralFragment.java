package com.facebook.referrals;

import a2.g.u.a;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.CustomTabMainActivity;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.Utility;
import java.util.Objects;
public class ReferralFragment extends Fragment {
    public static final String TAG = "ReferralFragment";
    public a a;

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        a aVar = this.a;
        Objects.requireNonNull(aVar);
        boolean z = true;
        if (i == 1) {
            if (!(intent == null || (stringExtra = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL)) == null || !stringExtra.startsWith(CustomTabUtils.getValidRedirectURI(a.b())))) {
                Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(stringExtra).getQuery());
                if (aVar.c != null) {
                    z = aVar.c.equals(parseUrlQueryString.getString("state"));
                    aVar.c = null;
                }
                if (z) {
                    intent.putExtras(parseUrlQueryString);
                } else {
                    i2 = 0;
                    intent.putExtra("error_message", "The referral response was missing a valid challenge string.");
                }
            }
            aVar.a(i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r8 = this;
            super.onResume()
            a2.g.u.a r0 = r8.a
            androidx.fragment.app.Fragment r1 = r0.a
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0096
            androidx.fragment.app.Fragment r1 = r0.a
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            java.lang.String r4 = "android.permission.INTERNET"
            int r1 = r1.checkCallingOrSelfPermission(r4)
            if (r1 != 0) goto L_0x0096
            java.lang.String r1 = r0.b
            if (r1 != 0) goto L_0x0027
            java.lang.String r1 = com.facebook.internal.CustomTabUtils.getChromePackage()
            r0.b = r1
        L_0x0027:
            java.lang.String r1 = r0.b
            if (r1 == 0) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 != 0) goto L_0x0031
            goto L_0x0096
        L_0x0031:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r4 = 20
            java.lang.String r4 = com.facebook.internal.Utility.generateRandomString(r4)
            r0.c = r4
            java.lang.String r4 = a2.g.u.a.b()
            java.lang.String r4 = com.facebook.internal.CustomTabUtils.getValidRedirectURI(r4)
            java.lang.String r5 = "redirect_uri"
            r1.putString(r5, r4)
            java.lang.String r4 = com.facebook.FacebookSdk.getApplicationId()
            java.lang.String r5 = "app_id"
            r1.putString(r5, r4)
            java.lang.String r4 = r0.c
            java.lang.String r5 = "state"
            r1.putString(r5, r4)
            boolean r4 = com.facebook.FacebookSdk.hasCustomTabsPrefetching
            java.lang.String r5 = "share_referral"
            if (r4 == 0) goto L_0x0068
            android.net.Uri r4 = com.facebook.internal.CustomTab.getURIForAction(r5, r1)
            com.facebook.login.CustomTabPrefetchHelper.mayLaunchUrl(r4)
        L_0x0068:
            android.content.Intent r4 = new android.content.Intent
            androidx.fragment.app.Fragment r6 = r0.a
            androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
            java.lang.Class<com.facebook.CustomTabMainActivity> r7 = com.facebook.CustomTabMainActivity.class
            r4.<init>(r6, r7)
            java.lang.String r6 = com.facebook.CustomTabMainActivity.EXTRA_ACTION
            r4.putExtra(r6, r5)
            java.lang.String r5 = com.facebook.CustomTabMainActivity.EXTRA_PARAMS
            r4.putExtra(r5, r1)
            java.lang.String r1 = com.facebook.CustomTabMainActivity.EXTRA_CHROME_PACKAGE
            java.lang.String r5 = r0.b
            if (r5 != 0) goto L_0x008b
            java.lang.String r5 = com.facebook.internal.CustomTabUtils.getChromePackage()
            r0.b = r5
        L_0x008b:
            java.lang.String r5 = r0.b
            r4.putExtra(r1, r5)
            androidx.fragment.app.Fragment r1 = r0.a
            r1.startActivityForResult(r4, r2)
            goto L_0x0097
        L_0x0096:
            r2 = 0
        L_0x0097:
            if (r2 != 0) goto L_0x00a8
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "error_message"
            java.lang.String r4 = "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed"
            r1.putExtra(r2, r4)
            r0.a(r3, r1)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.referrals.ReferralFragment.onResume():void");
    }
}
