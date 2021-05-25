package com.avito.android.delivery.profile_settings;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView;", "", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;)V", "Listener", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryProfileSettingsView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView$Listener;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "", "value", "", "onSwitchToggleChanges", "(Z)V", "onCloseClicked", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener extends OnDeepLinkClickListener {
        void onCloseClicked();

        void onSwitchToggleChanges(boolean z);
    }

    void bindTo(@NotNull DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel);
}
