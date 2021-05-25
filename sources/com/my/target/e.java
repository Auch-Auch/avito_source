package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import com.my.target.common.CustomParams;
import com.my.target.common.MyTargetConfig;
import com.my.target.common.MyTargetManager;
import com.my.target.common.MyTargetPrivacy;
import com.my.target.common.MyTargetVersion;
import com.vk.sdk.api.VKApiConst;
import java.util.HashMap;
import java.util.Map;
public abstract class e {

    public static class a extends e {
        @Override // com.my.target.e
        @NonNull
        public bp a(@NonNull a aVar, @NonNull Context context) {
            int cachePolicy = aVar.getCachePolicy();
            boolean z = false;
            il.Q(cachePolicy == 0 || cachePolicy == 1);
            if (cachePolicy == 0 || cachePolicy == 2) {
                z = true;
            }
            il.R(z);
            Map<String, String> c = c(aVar, context);
            StringBuilder L = a2.b.a.a.a.L("https://ad.mail.ru/mobile/");
            L.append(aVar.getSlotId());
            L.append("/?");
            L.append(in.a(c));
            return bp.p(L.toString());
        }

        public int b(@NonNull a aVar, @NonNull Context context) {
            return il.bp();
        }

        @NonNull
        public Map<String, String> c(@NonNull a aVar, @NonNull Context context) {
            String str;
            HashMap hashMap = new HashMap();
            hashMap.put("formats", aVar.getFormat());
            hashMap.put("adman_ver", MyTargetVersion.VERSION);
            hashMap.put("sdk_ver_int", MyTargetVersion.VERSION_INT);
            MyTargetPrivacy currentPrivacy = MyTargetPrivacy.currentPrivacy();
            Boolean bool = currentPrivacy.userConsent;
            String str2 = "0";
            if (bool != null) {
                hashMap.put("user_consent", bool.booleanValue() ? "1" : str2);
            }
            Boolean bool2 = currentPrivacy.ccpaUserConsent;
            if (bool2 != null) {
                hashMap.put("ccpa_user_consent", bool2.booleanValue() ? "1" : str2);
            }
            Boolean bool3 = currentPrivacy.iabUserConsent;
            if (bool3 != null) {
                if (bool3.booleanValue()) {
                    str2 = "1";
                }
                hashMap.put("iab_user_consent", str2);
            }
            if (currentPrivacy.userAgeRestricted) {
                hashMap.put("user_age_restricted", "1");
            }
            if (aVar.getCachePolicy() == 0 || aVar.getCachePolicy() == 2) {
                hashMap.put("preloadvideo", "1");
            }
            int bannersCount = aVar.getBannersCount();
            if (bannersCount > 0) {
                hashMap.put("count", Integer.toString(bannersCount));
            }
            String bidId = aVar.getBidId();
            if (bidId != null) {
                hashMap.put("bid_id", bidId);
            }
            CustomParams customParams = aVar.getCustomParams();
            if (currentPrivacy.isConsent()) {
                customParams.putDataTo(hashMap);
            }
            fc dP = fc.dP();
            dP.C(currentPrivacy.isConsent());
            MyTargetConfig sdkConfig = MyTargetManager.getSdkConfig();
            try {
                fa dQ = dP.dQ();
                dQ.A(sdkConfig.isTrackingEnvironmentEnabled);
                dQ.B(sdkConfig.isTrackingLocationEnabled);
                dP.collectData(context);
            } catch (Throwable th) {
                ae.a("Error collecting data: " + th);
            }
            dP.putDataTo(hashMap);
            String lang = customParams.getLang();
            if (lang != null) {
                hashMap.put(VKApiConst.LANG, lang);
            }
            int b = b(aVar, context);
            if (b >= 0) {
                hashMap.put("sdk_flags", String.valueOf(b));
            }
            String[] strArr = sdkConfig.testDevices;
            String str3 = (String) hashMap.get("instance_id");
            if (str3 == null) {
                return hashMap;
            }
            if (strArr == null || !hw.a(strArr, str3)) {
                str = "Device instanceId is " + str3 + ". Use this value in adInstance.withTestDevices() to enable test mode on this device.";
            } else {
                hashMap.put("test_mode", "1");
                str = "Test mode is enabled on current device";
            }
            ae.a(str);
            return hashMap;
        }
    }

    @NonNull
    public static e e() {
        return new a();
    }

    @NonNull
    public abstract bp a(@NonNull a aVar, @NonNull Context context);
}
