package com.avito.android.notifications_settings;

import com.avito.android.notifications_settings.info.NotificationsSettingsInfoItem;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomItem;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopItem;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceItem;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleItem;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleItem;
import com.avito.android.remote.model.notifications_settings.NotificationsSettings;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/notifications_settings/NotificationsSettingsConverterImpl;", "Lcom/avito/android/notifications_settings/NotificationsSettingsConverter;", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;", "data", "", "areNotificationsEnabled", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;Z)Ljava/util/List;", "<init>", "()V", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsConverterImpl implements NotificationsSettingsConverter {
    @Override // com.avito.android.notifications_settings.NotificationsSettingsConverter
    @NotNull
    public List<Item> convert(@NotNull NotificationsSettings notificationsSettings, boolean z) {
        Intrinsics.checkNotNullParameter(notificationsSettings, "data");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : notificationsSettings.getSections()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (i == 0) {
                arrayList.add(new NotificationsSettingsSpaceItem(""));
            } else {
                arrayList.add(new NotificationsSettingsShadowTopItem(""));
            }
            arrayList.add(new NotificationsSettingsTitleItem("", t2.getTitle(), t2.getSubtitle()));
            for (T t3 : t2.getChannels()) {
                if (t3 instanceof NotificationsSettings.Section.Channel.Push) {
                    arrayList.add(new NotificationsSettingsToggleItem("", t2.getType(), t3.getType(), t3.getTitle(), z && t3.getValue()));
                } else {
                    arrayList.add(new NotificationsSettingsToggleItem("", t2.getType(), t3.getType(), t3.getTitle(), t3.getValue()));
                }
            }
            arrayList.add(new NotificationsSettingsShadowBottomItem(""));
            i = i2;
        }
        arrayList.add(new NotificationsSettingsInfoItem("", notificationsSettings.getInfo()));
        return arrayList;
    }
}
