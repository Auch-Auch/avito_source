package com.avito.android.delivery.map.start_ordering;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.util.preferences.GeoContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\u001ac\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0001\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a\"\u0016\u0010\u001c\u001a\u00020\u00108\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a\"\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u001a\"\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u001a\"\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001a\"\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u001a\"\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u001a\"\u0016\u0010$\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u001a\"\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u001a\"\u0016\u0010&\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u001a\"\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u001a¨\u0006("}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "searchContext", "", "isMarketplace", "isCart", "firstCartItemId", "cartItems", "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "Landroid/content/Intent;", "createDeliveryRdsStartOrderingIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "fiasGuid", "", "serviceIDs", "fromSummary", "createDeliveryRdsStartOrderingIntentWithPin", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lcom/avito/android/remote/model/ParametrizedEvent;)Landroid/content/Intent;", "EXTRA_PIN_SERVICE_IDS", "Ljava/lang/String;", "EXTRA_FIRST_CART_ITEM_ID", "DEFAULT_COORDINATE", "D", "EXTRA_CONTACT_EVENT", "EXTRA_PIN_LAT", "EXTRA_FROM_SUMMARY", "EXTRA_PIN_LNG", "EXTRA_PIN_FIAS_GUID", "EXTRA_MARKETPLACE_FLAG", "EXTRA_CART_ITEMS", "EXTRA_ADVERT_ID", "EXTRA_CART_FLAG", "EXTRA_SOURCE", "delivery_release"}, k = 2, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingActivityKt {
    public static final double DEFAULT_COORDINATE = 180.01d;
    @NotNull
    public static final String EXTRA_ADVERT_ID = "advert_id";
    @NotNull
    public static final String EXTRA_CART_FLAG = "is_cart";
    @NotNull
    public static final String EXTRA_CART_ITEMS = "extra_cart_items";
    @NotNull
    public static final String EXTRA_CONTACT_EVENT = "contact_event";
    @NotNull
    public static final String EXTRA_FIRST_CART_ITEM_ID = "first_cart_item_id";
    @NotNull
    public static final String EXTRA_FROM_SUMMARY = "from_summary";
    @NotNull
    public static final String EXTRA_MARKETPLACE_FLAG = "is_marketplace";
    @NotNull
    public static final String EXTRA_PIN_FIAS_GUID = "pin_fias_guid";
    @NotNull
    public static final String EXTRA_PIN_LAT = "pin_lat";
    @NotNull
    public static final String EXTRA_PIN_LNG = "pin_lng";
    @NotNull
    public static final String EXTRA_PIN_SERVICE_IDS = "pin_service_ids";
    @NotNull
    public static final String EXTRA_SOURCE = "source";

    @NotNull
    public static final Intent createDeliveryRdsStartOrderingIntent(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable ParametrizedEvent parametrizedEvent) {
        Intent X0 = a.X0(context, "context", context, DeliveryRdsStartOrderingActivity.class);
        if (str != null) {
            X0.putExtra("advert_id", str);
        }
        X0.putExtra("source", str2);
        X0.putExtra(EXTRA_MARKETPLACE_FLAG, z);
        X0.putExtra(EXTRA_CART_FLAG, z2);
        if (str3 != null) {
            X0.putExtra("search_context", str3);
        }
        X0.putExtra(EXTRA_FIRST_CART_ITEM_ID, str4);
        X0.putExtra(EXTRA_CART_ITEMS, str5);
        X0.putExtra(EXTRA_CONTACT_EVENT, parametrizedEvent);
        return X0;
    }

    @NotNull
    public static final Intent createDeliveryRdsStartOrderingIntentWithPin(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable Double d, @Nullable Double d2, @NotNull String str6, @NotNull List<String> list, @Nullable Boolean bool, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str6, "fiasGuid");
        Intrinsics.checkNotNullParameter(list, "serviceIDs");
        Intent createDeliveryRdsStartOrderingIntent = createDeliveryRdsStartOrderingIntent(context, str, str2, str3, z, z2, str4, str5, parametrizedEvent);
        createDeliveryRdsStartOrderingIntent.putExtra(EXTRA_PIN_LAT, d);
        createDeliveryRdsStartOrderingIntent.putExtra(EXTRA_PIN_LNG, d2);
        createDeliveryRdsStartOrderingIntent.putExtra(EXTRA_PIN_FIAS_GUID, str6);
        createDeliveryRdsStartOrderingIntent.putStringArrayListExtra(EXTRA_PIN_SERVICE_IDS, new ArrayList<>(list));
        createDeliveryRdsStartOrderingIntent.putExtra(EXTRA_FROM_SUMMARY, bool);
        return createDeliveryRdsStartOrderingIntent;
    }
}
