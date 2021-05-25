package com.avito.android.remote.parse.adapter;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/NotificationCenterUnifiedFieldDeserializer;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterUnifiedFieldDeserializer extends RuntimeTypeAdapter<NotificationCenterLandingField> {
    @NotNull
    public final Map<String, Class<? extends NotificationCenterLandingField>> a = r.mapOf(TuplesKt.to(PhonePageSourceKt.PHONE_SOURCE_BUTTON, NotificationCenterLandingField.Button.class), TuplesKt.to("description", NotificationCenterLandingField.Description.class), TuplesKt.to("divider", NotificationCenterLandingField.Divider.class), TuplesKt.to("image", NotificationCenterLandingField.Image.class), TuplesKt.to("item", NotificationCenterLandingField.Item.class), TuplesKt.to("pairButton", NotificationCenterLandingField.PairButton.class), TuplesKt.to("space", NotificationCenterLandingField.Space.class), TuplesKt.to(MessengerShareContentUtility.SUBTITLE, NotificationCenterLandingField.Subtitle.class), TuplesKt.to("title", NotificationCenterLandingField.Title.class));

    public NotificationCenterUnifiedFieldDeserializer() {
        super(null, null, null, 7, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<? extends NotificationCenterLandingField>> getMapping() {
        return this.a;
    }
}
