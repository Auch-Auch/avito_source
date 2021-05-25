package bolts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
public final class AppLinks {
    public static Bundle getAppLinkData(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle getAppLinkExtras(Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
    }

    public static Uri getTargetUrl(Intent intent) {
        String string;
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null || (string = appLinkData.getString("target_url")) == null) {
            return intent.getData();
        }
        return Uri.parse(string);
    }

    public static Uri getTargetUrlFromInboundIntent(Context context, Intent intent) {
        String string;
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null || (string = appLinkData.getString("target_url")) == null) {
            return null;
        }
        MeasurementEvent.b(context, MeasurementEvent.APP_LINK_NAVIGATE_IN_EVENT_NAME, intent, null);
        return Uri.parse(string);
    }
}
