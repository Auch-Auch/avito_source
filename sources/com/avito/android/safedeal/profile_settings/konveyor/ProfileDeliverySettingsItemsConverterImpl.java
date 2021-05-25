package com.avito.android.safedeal.profile_settings.konveyor;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverterImpl;", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings;", "settings", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings;)Ljava/util/List;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileDeliverySettingsItemsConverterImpl implements ProfileDeliverySettingsItemsConverter {
    public final Context a;
    public final AttributedTextFormatter b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ProfileDeliverySettings.Service.Content.Icon.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            ProfileDeliverySettings.Service.Type.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            iArr2[0] = 2;
        }
    }

    @Inject
    public ProfileDeliverySettingsItemsConverterImpl(@NotNull Context context, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = context;
        this.b = attributedTextFormatter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0112  */
    @Override // com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.conveyor_item.Item> convert(@org.jetbrains.annotations.NotNull com.avito.android.safedeal.remote.model.ProfileDeliverySettings r21) {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverterImpl.convert(com.avito.android.safedeal.remote.model.ProfileDeliverySettings):java.util.List");
    }
}
