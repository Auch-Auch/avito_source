package com.avito.android.advert_core.analytics.sharing;

import com.avito.android.remote.model.SocialNetworkType;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertSharingEventTrackerKt {
    public static final int access$toSocialNetworkType(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -939287413) {
                if (hashCode != 3260) {
                    if (hashCode != 3305) {
                        if (hashCode != 3548) {
                            if (hashCode != 3765) {
                                if (hashCode != 2390487) {
                                    if (hashCode == 748307027 && str.equals(SocialNetworkType.TWITTER)) {
                                        return 4;
                                    }
                                } else if (str.equals(SocialNetworkType.MAIL_RU)) {
                                    return 1;
                                }
                            } else if (str.equals("vk")) {
                                return 2;
                            }
                        } else if (str.equals("ok")) {
                            return 5;
                        }
                    } else if (str.equals("gp")) {
                        return 6;
                    }
                } else if (str.equals("fb")) {
                    return 7;
                }
            } else if (str.equals(SocialNetworkType.LIVE_JOURNAL)) {
                return 3;
            }
        }
        return 0;
    }
}
