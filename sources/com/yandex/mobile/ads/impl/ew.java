package com.yandex.mobile.ads.impl;

import com.avito.android.remote.model.Navigation;
import java.util.Locale;
public final class ew {
    public static final String a = a("onCollapse", Navigation.CONFIG, "AdPerformActionsJSI");
    public static final String b = a("onExpand", Navigation.CONFIG, "AdPerformActionsJSI");
    public static final String c;
    public static final String d;

    static {
        Locale locale = Locale.US;
        d = String.format(locale, "<script type='text/javascript'> \nfunction wrapJsFunction_%1$s() { \n  window['%1$s'] = function() { \n      return %2$s.%1$s(); \n  } \n} \n \nwrapJsFunction_%1$s('%1$s'); \n</script> \n", "getBannerInfo", "AdPerformActionsJSI");
        c = String.format(locale, "<script type='text/javascript'> \nfunction wrapJsFunction_%1$s() { \n  window['%1$s'] = function(%3$s) { \n      return %4$s.%1$s(%2$s, %3$s); \n  } \n} \n \nwrapJsFunction_%1$s('%1$s'); \n</script> \n", "onAdRender", "document.querySelector('#rtb').offsetHeight", "testTag", "AdPerformActionsJSI");
    }

    private static String a(String str, String str2, String str3) {
        return String.format(Locale.US, "<script type='text/javascript'> \nfunction wrapJsFunction_%1$s() { \n  window['%1$s'] = function(%2$s) { \n      %3$s.%1$s(JSON.stringify(%2$s)); \n  } \n} \n \nwrapJsFunction_%1$s('%1$s'); \n</script> \n", str, str2, str3).replace("JSON.stringify()", "");
    }

    public static String a(int i) {
        return "<body style='width:" + i + "px;'>";
    }

    public static String a(int i, int i2) {
        return "\n<style>ytag.container { width:" + i + "px; height:" + i2 + "px; }</style>\n";
    }
}
