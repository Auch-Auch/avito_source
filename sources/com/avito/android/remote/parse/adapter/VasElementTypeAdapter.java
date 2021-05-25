package com.avito.android.remote.parse.adapter;

import androidx.core.app.NotificationCompat;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.vas.list.Advertisement;
import com.avito.android.remote.model.vas.list.Discount;
import com.avito.android.remote.model.vas.list.FreeElement;
import com.avito.android.remote.model.vas.list.Header;
import com.avito.android.remote.model.vas.list.Message;
import com.avito.android.remote.model.vas.list.Offer;
import com.avito.android.remote.model.vas.list.Package;
import com.avito.android.remote.model.vas.list.PromoCode;
import com.avito.android.remote.model.vas.list.Section;
import com.avito.android.remote.model.vas.list.Service;
import com.avito.android.remote.model.vas.list.VasElement;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/VasElementTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class VasElementTypeAdapter extends RuntimeTypeAdapter<VasElement> {
    @NotNull
    public final Map<String, Class<? extends VasElement>> a = r.mapOf(TuplesKt.to(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT, Advertisement.class), TuplesKt.to(FirebaseAnalytics.Param.DISCOUNT, Discount.class), TuplesKt.to(TariffPackageInfoConverterKt.HEADER_STRING_ID, Header.class), TuplesKt.to("section", Section.class), TuplesKt.to("package", Package.class), TuplesKt.to(NotificationCompat.CATEGORY_SERVICE, Service.class), TuplesKt.to(BaseAnalyticKt.ANALYTIC_MODULE_OFFER, Offer.class), TuplesKt.to("free", FreeElement.class), TuplesKt.to("message", Message.class), TuplesKt.to("promocode", PromoCode.class));

    public VasElementTypeAdapter() {
        super(null, null, null, 7, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<? extends VasElement>> getMapping() {
        return this.a;
    }
}
