package com.avito.android.delivery.profile_settings;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettings;
import com.avito.android.remote.model.delivery.DeliveryProfileSettingsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverterImpl;", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;", "Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse;", CommonKt.EXTRA_RESPONSE, "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings;", "convertToDeliveryProfileSettings", "(Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse;)Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettingsResponseConverterImpl implements DeliveryProfileSettingsResponseConverter {
    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsResponseConverter
    @NotNull
    public DeliveryProfileSettings convertToDeliveryProfileSettings(@NotNull DeliveryProfileSettingsResponse deliveryProfileSettingsResponse) {
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsResponse, CommonKt.EXTRA_RESPONSE);
        DeliveryProfileSettingsResponse.Body body = deliveryProfileSettingsResponse.getBody();
        DeliveryProfileSettings.Body body2 = new DeliveryProfileSettings.Body(body.getImage(), body.getAttributedText());
        DeliveryProfileSettingsResponse.EnableField enableField = deliveryProfileSettingsResponse.getEnableField();
        return new DeliveryProfileSettings(body2, new DeliveryProfileSettings.Switch(enableField.getTitle(), enableField.getValue()), deliveryProfileSettingsResponse.getEnableField().getDisclaimer());
    }
}
