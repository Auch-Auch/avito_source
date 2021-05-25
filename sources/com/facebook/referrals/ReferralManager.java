package com.facebook.referrals;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
public class ReferralManager {
    public static volatile ReferralManager b;
    public ReferralLogger a;

    public class a implements CallbackManagerImpl.Callback {
        public final /* synthetic */ FacebookCallback a;

        public a(FacebookCallback facebookCallback) {
            this.a = facebookCallback;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onActivityResult(int r7, android.content.Intent r8) {
            /*
                r6 = this;
                com.facebook.referrals.ReferralManager r0 = com.facebook.referrals.ReferralManager.this
                com.facebook.FacebookCallback r1 = r6.a
                java.util.Objects.requireNonNull(r0)
                java.lang.String r2 = "error_message"
                java.lang.String r3 = "fb_referral_codes"
                r4 = -1
                r5 = 0
                if (r7 != r4) goto L_0x0039
                if (r8 == 0) goto L_0x0039
                android.os.Bundle r4 = r8.getExtras()     // Catch:{ JSONException -> 0x0066 }
                if (r4 == 0) goto L_0x0039
                android.os.Bundle r4 = r8.getExtras()     // Catch:{ JSONException -> 0x0066 }
                boolean r4 = r4.containsKey(r3)     // Catch:{ JSONException -> 0x0066 }
                if (r4 == 0) goto L_0x0039
                android.os.Bundle r7 = r8.getExtras()     // Catch:{ JSONException -> 0x0066 }
                java.lang.String r7 = r7.getString(r3)     // Catch:{ JSONException -> 0x0066 }
                org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0066 }
                r8.<init>(r7)     // Catch:{ JSONException -> 0x0066 }
                java.util.List r7 = com.facebook.internal.Utility.convertJSONArrayToList(r8)     // Catch:{ JSONException -> 0x0066 }
                com.facebook.referrals.ReferralResult r8 = new com.facebook.referrals.ReferralResult     // Catch:{ JSONException -> 0x0066 }
                r8.<init>(r7)     // Catch:{ JSONException -> 0x0066 }
                r7 = r5
                goto L_0x006f
            L_0x0039:
                if (r7 != 0) goto L_0x005e
                if (r8 == 0) goto L_0x005b
                android.os.Bundle r7 = r8.getExtras()     // Catch:{ JSONException -> 0x0066 }
                if (r7 == 0) goto L_0x005b
                android.os.Bundle r7 = r8.getExtras()     // Catch:{ JSONException -> 0x0066 }
                boolean r7 = r7.containsKey(r2)     // Catch:{ JSONException -> 0x0066 }
                if (r7 == 0) goto L_0x005b
                android.os.Bundle r7 = r8.getExtras()     // Catch:{ JSONException -> 0x0066 }
                java.lang.String r7 = r7.getString(r2)     // Catch:{ JSONException -> 0x0066 }
                com.facebook.FacebookException r8 = new com.facebook.FacebookException     // Catch:{ JSONException -> 0x0066 }
                r8.<init>(r7)     // Catch:{ JSONException -> 0x0066 }
                goto L_0x006d
            L_0x005b:
                r7 = r5
                r8 = r7
                goto L_0x006f
            L_0x005e:
                com.facebook.FacebookException r8 = new com.facebook.FacebookException     // Catch:{ JSONException -> 0x0066 }
                java.lang.String r7 = "Unexpected call to ReferralManager.onActivityResult"
                r8.<init>(r7)     // Catch:{ JSONException -> 0x0066 }
                goto L_0x006d
            L_0x0066:
                com.facebook.FacebookException r8 = new com.facebook.FacebookException
                java.lang.String r7 = "Unable to parse referral codes from response"
                r8.<init>(r7)
            L_0x006d:
                r7 = r8
                r8 = r5
            L_0x006f:
                com.facebook.referrals.ReferralLogger r0 = r0.a(r5)
                if (r0 == 0) goto L_0x0084
                if (r8 == 0) goto L_0x007b
                r0.logSuccess()
                goto L_0x0084
            L_0x007b:
                if (r7 == 0) goto L_0x0081
                r0.logError(r7)
                goto L_0x0084
            L_0x0081:
                r0.logCancel()
            L_0x0084:
                if (r8 == 0) goto L_0x008a
                r1.onSuccess(r8)
                goto L_0x0093
            L_0x008a:
                if (r7 == 0) goto L_0x0090
                r1.onError(r7)
                goto L_0x0093
            L_0x0090:
                r1.onCancel()
            L_0x0093:
                r7 = 1
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.referrals.ReferralManager.a.onActivityResult(int, android.content.Intent):boolean");
        }
    }

    public static class b implements a2.g.u.b {
        public final Activity a;

        public b(Activity activity) {
            Validate.notNull(activity, "activity");
            this.a = activity;
        }

        @Override // a2.g.u.b
        public Activity a() {
            return this.a;
        }

        @Override // a2.g.u.b
        public void startActivityForResult(Intent intent, int i) {
            this.a.startActivityForResult(intent, i);
        }
    }

    public static class c implements a2.g.u.b {
        public final FragmentWrapper a;

        public c(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.a = fragmentWrapper;
        }

        @Override // a2.g.u.b
        public Activity a() {
            return this.a.getActivity();
        }

        @Override // a2.g.u.b
        public void startActivityForResult(Intent intent, int i) {
            this.a.startActivityForResult(intent, i);
        }
    }

    public ReferralManager() {
        Validate.sdkInitialized();
    }

    public static ReferralManager getInstance() {
        if (b == null) {
            synchronized (ReferralManager.class) {
                if (b == null) {
                    b = new ReferralManager();
                }
            }
        }
        return b;
    }

    public final ReferralLogger a(Context context) {
        if (context == null) {
            context = FacebookSdk.getApplicationContext();
        }
        if (context == null) {
            return null;
        }
        if (this.a == null) {
            this.a = new ReferralLogger(context, FacebookSdk.getApplicationId());
        }
        return this.a;
    }

    public final void b(a2.g.u.b bVar) {
        ReferralLogger a3 = a(bVar.a());
        if (a3 != null) {
            a3.logStartReferral();
        }
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(ReferralFragment.TAG);
        boolean z = false;
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null) {
            try {
                bVar.startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode());
                z = true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        if (!z) {
            FacebookException facebookException = new FacebookException("Failed to open Referral dialog: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            if (a3 != null) {
                a3.logError(facebookException);
            }
            throw facebookException;
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<ReferralResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode(), new a(facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public void startReferral(Activity activity) {
        b(new b(activity));
    }

    public void startReferral(Fragment fragment) {
        b(new c(new FragmentWrapper(fragment)));
    }

    public void startReferral(android.app.Fragment fragment) {
        b(new c(new FragmentWrapper(fragment)));
    }

    public void startReferral(FragmentWrapper fragmentWrapper) {
        b(new c(fragmentWrapper));
    }
}
