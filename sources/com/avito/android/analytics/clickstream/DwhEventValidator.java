package com.avito.android.analytics.clickstream;

import a2.b.a.a.a;
import com.avito.android.analytics.clickstream.event.HasSensitiveData;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.preferences.Preference;
import com.vk.sdk.VKAccessToken;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/clickstream/DwhEventValidator;", "Lcom/avito/android/analytics/clickstream/EventValidator;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "event", "", "validateOrFail", "(Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;)V", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "sensitiveParameters", "Lkotlin/text/Regex;", AuthSource.SEND_ABUSE, "Lkotlin/text/Regex;", "wordDelimiter", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class DwhEventValidator extends EventValidator {
    public final Regex a = new Regex("[^a-zA-Z0-9]+");
    public final List<String> b = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"access", "bank", PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD, "cardholder", "cred", "cvc", "cvv", "debit", "e-mail", "email", "fingerprint", "fp", "mail", "pass", Preference.PASSWORD, "payment", "pwd", VKAccessToken.SECRET, "thru", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "valid"});

    @Override // com.avito.android.analytics.clickstream.EventValidator
    public void validateOrFail(@NotNull ClickStreamEvent clickStreamEvent) {
        T t;
        Intrinsics.checkNotNullParameter(clickStreamEvent, "event");
        String str = null;
        if (!(clickStreamEvent instanceof HasSensitiveData)) {
            Iterator<Map.Entry<String, Object>> it = clickStreamEvent.getParams().entrySet().iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String key = it.next().getKey();
                Iterator<T> it2 = this.a.split(key, 0).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        T next = it2.next();
                        Iterator<T> it3 = this.b.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it3.next();
                            if (m.equals(next, t, true)) {
                                break;
                            }
                        }
                        T t2 = t;
                        if (t2 != null) {
                            str = a.f("Parameter ", key, " looks suspicious because of ", t2, ". Check event https://cf.avito.ru/x/KRfKBQ and mark with HasSensitiveData");
                            break loop0;
                        }
                    }
                }
            }
        }
        if (str != null) {
            throwValidationError(clickStreamEvent, str);
        }
    }
}
