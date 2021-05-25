package com.adjust.sdk.criteo;

import android.net.Uri;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class AdjustCriteo {
    private static int MAX_VIEW_LISTING_PRODUCTS = 3;
    private static String checkInDateInternal;
    private static String checkOutDateInternal;
    private static String customerIdInternal;
    private static String hashEmailInternal;
    private static ILogger logger = AdjustFactory.getLogger();
    private static String partnerIdInternal;
    private static String userSegmentInternal;

    private static String createCriteoVBFromProducts(List<CriteoProduct> list) {
        if (list == null) {
            logger.warn("Criteo Event product list is empty. It will sent as empty.", new Object[0]);
            list = new ArrayList<>();
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int size = list.size();
        int i = 0;
        while (i < size) {
            CriteoProduct criteoProduct = list.get(i);
            stringBuffer.append(String.format(Locale.US, "{\"i\":\"%s\",\"pr\":%f,\"q\":%d}", criteoProduct.productID, Float.valueOf(criteoProduct.price), Integer.valueOf(criteoProduct.quantity)));
            i++;
            if (i == size) {
                break;
            }
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        try {
            return URLEncoder.encode(stringBuffer.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("error converting criteo products (%s)", e.getMessage());
            return null;
        }
    }

    private static String createCriteoVLFromProducts(List<String> list) {
        if (list == null) {
            logger.warn("Criteo View Listing product ids list is null. It will sent as empty.", new Object[0]);
            list = new ArrayList<>();
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int size = list.size();
        if (size > MAX_VIEW_LISTING_PRODUCTS) {
            logger.warn("Criteo View Listing should only have at most 3 product ids. The rest will be discarded.", new Object[0]);
        }
        int i = 0;
        while (i < size) {
            stringBuffer.append(String.format(Locale.US, "\"%s\"", list.get(i)));
            i++;
            if (i == size || i >= MAX_VIEW_LISTING_PRODUCTS) {
                break;
            }
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        try {
            return URLEncoder.encode(stringBuffer.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("error converting criteo product ids (%s)", e.getMessage());
            return null;
        }
    }

    public static void injectAchievementUnlockedIntoEvent(AdjustEvent adjustEvent, String str) {
        adjustEvent.addPartnerParameter("ui_achievmnt", str);
        injectOptionalParams(adjustEvent);
    }

    public static void injectCartIntoEvent(AdjustEvent adjustEvent, List<CriteoProduct> list) {
        adjustEvent.addPartnerParameter("criteo_p", createCriteoVBFromProducts(list));
        injectOptionalParams(adjustEvent);
    }

    public static void injectCustomEvent2IntoEvent(AdjustEvent adjustEvent, String str, long j) {
        adjustEvent.addPartnerParameter("ui_data2", str);
        adjustEvent.addPartnerParameter("ui_data3", String.valueOf(j));
        injectOptionalParams(adjustEvent);
    }

    public static void injectCustomEventIntoEvent(AdjustEvent adjustEvent, String str) {
        adjustEvent.addPartnerParameter("ui_data", str);
        injectOptionalParams(adjustEvent);
    }

    private static void injectCustomerId(AdjustEvent adjustEvent) {
        String str = customerIdInternal;
        if (str != null && !str.isEmpty()) {
            adjustEvent.addPartnerParameter("customer_id", customerIdInternal);
        }
    }

    public static void injectCustomerIdIntoCriteoEvents(String str) {
        customerIdInternal = str;
    }

    public static void injectDeeplinkIntoEvent(AdjustEvent adjustEvent, Uri uri) {
        if (uri != null) {
            adjustEvent.addPartnerParameter("criteo_deeplink", uri.toString());
            injectOptionalParams(adjustEvent);
        }
    }

    private static void injectHashEmail(AdjustEvent adjustEvent) {
        String str = hashEmailInternal;
        if (str != null && !str.isEmpty()) {
            adjustEvent.addPartnerParameter("criteo_email_hash", hashEmailInternal);
        }
    }

    public static void injectHashedEmailIntoCriteoEvents(String str) {
        hashEmailInternal = str;
    }

    private static void injectOptionalParams(AdjustEvent adjustEvent) {
        injectHashEmail(adjustEvent);
        injectSearchDates(adjustEvent);
        injectPartnerId(adjustEvent);
        injectUserSegment(adjustEvent);
        injectCustomerId(adjustEvent);
    }

    private static void injectPartnerId(AdjustEvent adjustEvent) {
        String str = partnerIdInternal;
        if (str != null && !str.isEmpty()) {
            adjustEvent.addPartnerParameter("criteo_partner_id", partnerIdInternal);
        }
    }

    public static void injectPartnerIdIntoCriteoEvents(String str) {
        partnerIdInternal = str;
    }

    private static void injectSearchDates(AdjustEvent adjustEvent) {
        String str;
        String str2 = checkInDateInternal;
        if (str2 != null && !str2.isEmpty() && (str = checkOutDateInternal) != null && !str.isEmpty()) {
            adjustEvent.addPartnerParameter("din", checkInDateInternal);
            adjustEvent.addPartnerParameter("dout", checkOutDateInternal);
        }
    }

    public static void injectTransactionConfirmedIntoEvent(AdjustEvent adjustEvent, List<CriteoProduct> list, String str, String str2) {
        String createCriteoVBFromProducts = createCriteoVBFromProducts(list);
        adjustEvent.addPartnerParameter(FirebaseAnalytics.Param.TRANSACTION_ID, str);
        adjustEvent.addPartnerParameter("criteo_p", createCriteoVBFromProducts);
        adjustEvent.addPartnerParameter("new_customer", str2);
        injectOptionalParams(adjustEvent);
    }

    public static void injectUserLevelIntoEvent(AdjustEvent adjustEvent, long j) {
        adjustEvent.addPartnerParameter("ui_level", String.valueOf(j));
        injectOptionalParams(adjustEvent);
    }

    private static void injectUserSegment(AdjustEvent adjustEvent) {
        String str = userSegmentInternal;
        if (str != null && !str.isEmpty()) {
            adjustEvent.addPartnerParameter("user_segment", userSegmentInternal);
        }
    }

    public static void injectUserSegmentIntoCriteoEvents(String str) {
        userSegmentInternal = str;
    }

    public static void injectUserStatusIntoEvent(AdjustEvent adjustEvent, String str) {
        adjustEvent.addPartnerParameter("ui_status", str);
        injectOptionalParams(adjustEvent);
    }

    public static void injectViewListingIntoEvent(AdjustEvent adjustEvent, List<String> list) {
        adjustEvent.addPartnerParameter("criteo_p", createCriteoVLFromProducts(list));
        injectOptionalParams(adjustEvent);
    }

    public static void injectViewProductIntoEvent(AdjustEvent adjustEvent, String str) {
        adjustEvent.addPartnerParameter("criteo_p", str);
        injectOptionalParams(adjustEvent);
    }

    public static void injectViewSearchDatesIntoCriteoEvents(String str, String str2) {
        checkInDateInternal = str;
        checkOutDateInternal = str2;
    }
}
