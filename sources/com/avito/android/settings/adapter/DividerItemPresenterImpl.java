package com.avito.android.settings.adapter;

import com.avito.android.settings.adapter.SettingsItem;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/settings/adapter/DividerItemPresenterImpl;", "Lcom/avito/android/settings/adapter/DividerItemPresenter;", "Lcom/avito/android/settings/adapter/DividerItemView;", "view", "Lcom/avito/android/settings/adapter/SettingsItem$Divider;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/settings/adapter/DividerItemView;Lcom/avito/android/settings/adapter/SettingsItem$Divider;I)V", "<init>", "()V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class DividerItemPresenterImpl implements DividerItemPresenter {
    public void bindView(@NotNull DividerItemView dividerItemView, @NotNull SettingsItem.Divider divider, int i) {
        Intrinsics.checkNotNullParameter(dividerItemView, "view");
        Intrinsics.checkNotNullParameter(divider, "item");
    }
}
