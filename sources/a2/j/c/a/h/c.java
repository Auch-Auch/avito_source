package a2.j.c.a.h;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import com.google.androidbrowserhelper.trusted.ChromeLegacyUtils;
import java.util.HashMap;
import java.util.Map;
public class c {
    public Map<String, b> a = new HashMap();

    public static class b {
        public final boolean a;
        public final boolean b;

        public b(boolean z, boolean z2, a aVar) {
            this.a = z;
            this.b = z2;
        }
    }

    public static int a(Context context, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder) {
        Integer num;
        Bundle extras = trustedWebActivityIntentBuilder.buildCustomTabsIntent().intent.getExtras();
        if (extras == null) {
            num = null;
        } else {
            num = (Integer) extras.get(CustomTabsIntent.EXTRA_COLOR_SCHEME);
        }
        if (num != null && num.intValue() != 0) {
            return num.intValue();
        }
        return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 2 : 1;
    }

    public final b b(Context context, String str) {
        IntentFilter intentFilter;
        IntentFilter intentFilter2;
        b bVar = this.a.get(str);
        if (bVar != null) {
            return bVar;
        }
        boolean z = true;
        if (ChromeLegacyUtils.supportsNavbarAndColorCustomization(context.getPackageManager(), str)) {
            b bVar2 = new b(true, true, null);
            this.a.put(str, bVar2);
            return bVar2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent().setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(str), 64);
        boolean z2 = (resolveService == null || (intentFilter2 = resolveService.filter) == null || !intentFilter2.hasCategory(CustomTabsService.CATEGORY_NAVBAR_COLOR_CUSTOMIZATION)) ? false : true;
        if (resolveService == null || (intentFilter = resolveService.filter) == null || !intentFilter.hasCategory(CustomTabsService.CATEGORY_COLOR_SCHEME_CUSTOMIZATION)) {
            z = false;
        }
        b bVar3 = new b(z2, z, null);
        this.a.put(str, bVar3);
        return bVar3;
    }
}
