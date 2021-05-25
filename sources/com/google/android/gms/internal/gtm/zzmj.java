package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@VisibleForTesting
public final class zzmj extends zzhb {
    private static final String ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final List<String> zzamg = Arrays.asList(ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, "checkout_option", "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, "purchase", "refund");
    private static final Pattern zzamh = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzami = Pattern.compile("metric(\\d+)");
    private static final Set<String> zzasb = CollectionUtils.setOf("", "0", "false");
    private static final Map<String, String> zzasc = CollectionUtils.mapOf("transactionId", "&ti", "transactionAffiliation", "&ta", "transactionTax", "&tt", "transactionShipping", "&ts", "transactionTotal", "&tr", "transactionCurrency", "&cu");
    private static final Map<String, String> zzasd = CollectionUtils.mapOf("name", "&in", "sku", "&ic", "category", "&iv", "price", "&ip", FirebaseAnalytics.Param.QUANTITY, "&iq", FirebaseAnalytics.Param.CURRENCY, "&cu");
    private final zzfj zzapc;
    private final zzgu zzase;
    private Map<String, Object> zzasf;

    public zzmj(Context context, zzfj zzfj) {
        this(new zzgu(context), zzfj);
    }

    private static Map<String, String> zzh(zzoa<?> zzoa) {
        Preconditions.checkNotNull(zzoa);
        Preconditions.checkArgument(zzoa instanceof zzok);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object zzj = zzoo.zzj(zzoo.zzk(zzoa));
        Preconditions.checkState(zzj instanceof Map);
        for (Map.Entry entry : ((Map) zzj).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static Map<String, String> zzi(zzoa<?> zzoa) {
        Map<String, String> zzh = zzh(zzoa);
        String str = zzh.get("&aip");
        if (str != null && zzasb.contains(str.toLowerCase())) {
            zzh.remove("&aip");
        }
        return zzh;
    }

    private static Product zzj(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get(VerticalFilterCloseDialogEventKt.BRAND_DIALOG);
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get(FirebaseAnalytics.Param.COUPON);
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get(VKApiConst.POSITION);
        if (obj7 != null) {
            product.setPosition(zzn(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.setPrice(zzm(obj8).doubleValue());
        }
        Object obj9 = map.get(FirebaseAnalytics.Param.QUANTITY);
        if (obj9 != null) {
            product.setQuantity(zzn(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = zzamh.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(str);
                    zzev.zzac(valueOf.length() != 0 ? "illegal number in custom dimension value: ".concat(valueOf) : new String("illegal number in custom dimension value: "));
                }
            } else {
                Matcher matcher2 = zzami.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzn(map.get(str)).intValue());
                    } catch (NumberFormatException unused2) {
                        String valueOf2 = String.valueOf(str);
                        zzev.zzac(valueOf2.length() != 0 ? "illegal number in custom metric value: ".concat(valueOf2) : new String("illegal number in custom metric value: "));
                    }
                }
            }
        }
        return product;
    }

    private static Double zzm(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf) : new String("Cannot convert the object to Double: "));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf2) : new String("Cannot convert the object to Double: "));
        }
    }

    private static Integer zzn(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf) : new String("Cannot convert the object to Integer: "));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf2) : new String("Cannot convert the object to Integer: "));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A[Catch:{ all -> 0x0477 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4 A[Catch:{ all -> 0x0477 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    @Override // com.google.android.gms.internal.gtm.zzhb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.gtm.zzoa<?> zza(com.google.android.gms.internal.gtm.zzfl r19, com.google.android.gms.internal.gtm.zzoa<?>... r20) {
        /*
        // Method dump skipped, instructions count: 1148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzmj.zza(com.google.android.gms.internal.gtm.zzfl, com.google.android.gms.internal.gtm.zzoa[]):com.google.android.gms.internal.gtm.zzoa");
    }

    @VisibleForTesting
    private zzmj(zzgu zzgu, zzfj zzfj) {
        this.zzapc = zzfj;
        this.zzase = zzgu;
    }
}
