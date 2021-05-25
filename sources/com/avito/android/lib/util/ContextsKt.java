package com.avito.android.lib.util;

import androidx.annotation.AttrRes;
import com.avito.android.lib.design.R;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "name", "", "getButtonStyleByAttrName", "(Ljava/lang/String;)I", "Landroid/content/Context;", "getTextStyleByAttrName", "(Landroid/content/Context;Ljava/lang/String;)I", "components_release"}, k = 2, mv = {1, 4, 2})
public final class ContextsKt {
    @AttrRes
    public static final int getButtonStyleByAttrName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        switch (str.hashCode()) {
            case -2034205441:
                if (str.equals("warningLarge")) {
                    return R.attr.buttonWarningLarge;
                }
                break;
            case -2027399477:
                if (str.equals("warningSmall")) {
                    return R.attr.buttonWarningSmall;
                }
                break;
            case -1705053985:
                if (str.equals("accentMedium")) {
                    return R.attr.buttonAccentMedium;
                }
                break;
            case -1481532391:
                if (str.equals("outlineLarge")) {
                    return R.attr.buttonOutlineLarge;
                }
                break;
            case -1474726427:
                if (str.equals("outlineSmall")) {
                    return R.attr.buttonOutlineSmall;
                }
                break;
            case -1423461174:
                if (str.equals("accent")) {
                    return R.attr.buttonAccentLarge;
                }
                break;
            case -1204892614:
                if (str.equals("appInstall")) {
                    return R.attr.buttonAppInstall;
                }
                break;
            case -1188486617:
                if (str.equals("secondaryLarge")) {
                    return R.attr.buttonSecondaryLarge;
                }
                break;
            case -1181680653:
                if (str.equals("secondarySmall")) {
                    return R.attr.buttonSecondarySmall;
                }
                break;
            case -1164409711:
                if (str.equals("accentLarge")) {
                    return R.attr.buttonAccentLarge;
                }
                break;
            case -1157603747:
                if (str.equals("accentSmall")) {
                    return R.attr.buttonAccentSmall;
                }
                break;
            case -1132319143:
                if (str.equals("primaryLarge")) {
                    return R.attr.buttonPrimaryLarge;
                }
                break;
            case -1125513179:
                if (str.equals("primarySmall")) {
                    return R.attr.buttonPrimarySmall;
                }
                break;
            case -1022965475:
                if (str.equals("linkIncreasedMedium")) {
                    return R.attr.buttonLinkIncreasedMedium;
                }
                break;
            case -946869682:
                if (str.equals("safedealMedium")) {
                    return R.attr.buttonSafedealMedium;
                }
                break;
            case -817598092:
                if (str.equals("secondary")) {
                    return R.attr.buttonSecondaryLarge;
                }
                break;
            case -710246377:
                if (str.equals("primaryMedium")) {
                    return R.attr.buttonPrimaryMedium;
                }
                break;
            case -668355206:
                if (str.equals("defaultLarge")) {
                    return R.attr.buttonDefaultLarge;
                }
                break;
            case -661549242:
                if (str.equals("defaultSmall")) {
                    return R.attr.buttonDefaultSmall;
                }
                break;
            case -538635560:
                if (str.equals("dangerLarge")) {
                    return R.attr.buttonDangerLarge;
                }
                break;
            case -531829596:
                if (str.equals("dangerSmall")) {
                    return R.attr.buttonDangerSmall;
                }
                break;
            case 514075512:
                if (str.equals("dangerMedium")) {
                    return R.attr.buttonDangerMedium;
                }
                break;
            case 787733782:
                if (str.equals("defaultMedium")) {
                    return R.attr.buttonDefaultMedium;
                }
                break;
            case 1349044823:
                if (str.equals("outlineMedium")) {
                    return R.attr.buttonOutlineMedium;
                }
                break;
            case 1396049457:
                if (str.equals("warningMedium")) {
                    return R.attr.buttonWarningMedium;
                }
                break;
            case 1843529225:
                if (str.equals("secondaryMedium")) {
                    return R.attr.buttonSecondaryMedium;
                }
                break;
            case 1905634451:
                if (str.equals("linkIncreasedLarge")) {
                    return R.attr.buttonLinkIncreasedLarge;
                }
                break;
            case 1908089154:
                if (str.equals("safedealLarge")) {
                    return R.attr.buttonSafedealLarge;
                }
                break;
            case 1912440415:
                if (str.equals("linkIncreasedSmall")) {
                    return R.attr.buttonLinkIncreasedSmall;
                }
                break;
            case 1914895118:
                if (str.equals("safedealSmall")) {
                    return R.attr.buttonSafedealSmall;
                }
                break;
        }
        Logs.debug$default("Button style is not supported - " + str, null, 2, null);
        return R.attr.buttonDefaultMedium;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r3.equals("bodyLarge") != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r3.equals("headingXLarge") != false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (r3.equals("title") != false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        r3 = com.avito.android.lib.design.R.attr.textTitle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (r3.equals(com.facebook.gamingservices.cloudgaming.internal.SDKConstants.PARAM_A2U_BODY) != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        r3 = com.avito.android.lib.design.R.attr.textBody;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009b, code lost:
        if (r3.equals("titleSmall") != false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009d, code lost:
        r3 = com.avito.android.lib.design.R.attr.textTitleSmall;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (r3.equals("subheading") != false) goto L_0x0071;
     */
    @androidx.annotation.StyleRes
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getTextStyleByAttrName(@org.jetbrains.annotations.NotNull android.content.Context r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            java.lang.String r0 = "$this$getTextStyleByAttrName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 != 0) goto L_0x000b
            int r3 = com.avito.android.lib.design.R.attr.textBody
            goto L_0x00b8
        L_0x000b:
            int r0 = r3.hashCode()
            switch(r0) {
                case -1784661617: goto L_0x0095;
                case 3029410: goto L_0x008a;
                case 30621082: goto L_0x007f;
                case 103890628: goto L_0x0074;
                case 110371416: goto L_0x0069;
                case 463779397: goto L_0x0060;
                case 795311618: goto L_0x0055;
                case 1227640477: goto L_0x004a;
                case 1234912953: goto L_0x0041;
                case 1241718917: goto L_0x0035;
                case 1667087961: goto L_0x0029;
                case 1673893925: goto L_0x001d;
                case 1944008642: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x00a0
        L_0x0014:
            java.lang.String r0 = "subheading"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            goto L_0x0071
        L_0x001d:
            java.lang.String r0 = "headingSmall"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textHeadingSmall
            goto L_0x00b8
        L_0x0029:
            java.lang.String r0 = "headingLarge"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textHeadingLarge
            goto L_0x00b8
        L_0x0035:
            java.lang.String r0 = "bodySmall"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textBodySmall
            goto L_0x00b8
        L_0x0041:
            java.lang.String r0 = "bodyLarge"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            goto L_0x0092
        L_0x004a:
            java.lang.String r0 = "bodyDense"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textBodyDense
            goto L_0x00b8
        L_0x0055:
            java.lang.String r0 = "heading"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textHeading
            goto L_0x00b8
        L_0x0060:
            java.lang.String r0 = "headingXLarge"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            goto L_0x009d
        L_0x0069:
            java.lang.String r0 = "title"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
        L_0x0071:
            int r3 = com.avito.android.lib.design.R.attr.textTitle
            goto L_0x00b8
        L_0x0074:
            java.lang.String r0 = "micro"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textMicro
            goto L_0x00b8
        L_0x007f:
            java.lang.String r0 = "bodySmallDense"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
            int r3 = com.avito.android.lib.design.R.attr.textBodySmallDense
            goto L_0x00b8
        L_0x008a:
            java.lang.String r0 = "body"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
        L_0x0092:
            int r3 = com.avito.android.lib.design.R.attr.textBody
            goto L_0x00b8
        L_0x0095:
            java.lang.String r0 = "titleSmall"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00a0
        L_0x009d:
            int r3 = com.avito.android.lib.design.R.attr.textTitleSmall
            goto L_0x00b8
        L_0x00a0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Text style is not supported - "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r0 = 2
            r1 = 0
            com.avito.android.util.Logs.debug$default(r3, r1, r0, r1)
            int r3 = com.avito.android.lib.design.R.attr.textBody
        L_0x00b8:
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.res.Resources$Theme r2 = r2.getTheme()
            r1 = 1
            r2.resolveAttribute(r3, r0, r1)
            int r2 = r0.data
            return r2
            switch-data {-1784661617->0x0095, 3029410->0x008a, 30621082->0x007f, 103890628->0x0074, 110371416->0x0069, 463779397->0x0060, 795311618->0x0055, 1227640477->0x004a, 1234912953->0x0041, 1241718917->0x0035, 1667087961->0x0029, 1673893925->0x001d, 1944008642->0x0014, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.util.ContextsKt.getTextStyleByAttrName(android.content.Context, java.lang.String):int");
    }
}
