package com.avito.android.notifications_settings.toggle;

import com.avito.android.component.switch_list_element.SwitchListElement;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsTogglePresenterImpl;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsTogglePresenter;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleView;", "view", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleView;Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleItem;I)V", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "typeConsumer", "<init>", "(Lcom/jakewharton/rxrelay2/Relay;)V", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsTogglePresenterImpl implements NotificationsSettingsTogglePresenter {
    public final Relay<NotificationsSettingsToggleItem> a;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ NotificationsSettingsTogglePresenterImpl a;
        public final /* synthetic */ NotificationsSettingsToggleItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NotificationsSettingsTogglePresenterImpl notificationsSettingsTogglePresenterImpl, NotificationsSettingsToggleItem notificationsSettingsToggleItem) {
            super(1);
            this.a = notificationsSettingsTogglePresenterImpl;
            this.b = notificationsSettingsToggleItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            bool.booleanValue();
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NotificationsSettingsTogglePresenterImpl(@NotNull Relay<NotificationsSettingsToggleItem> relay) {
        Intrinsics.checkNotNullParameter(relay, "typeConsumer");
        this.a = relay;
    }

    public void bindView(@NotNull NotificationsSettingsToggleView notificationsSettingsToggleView, @NotNull NotificationsSettingsToggleItem notificationsSettingsToggleItem, int i) {
        Intrinsics.checkNotNullParameter(notificationsSettingsToggleView, "view");
        Intrinsics.checkNotNullParameter(notificationsSettingsToggleItem, "item");
        notificationsSettingsToggleView.setTitle(notificationsSettingsToggleItem.getText());
        SwitchListElement.DefaultImpls.setChecked$default(notificationsSettingsToggleView, notificationsSettingsToggleItem.isChecked(), false, 2, null);
        notificationsSettingsToggleView.setCheckedChangeListener(new a(this, notificationsSettingsToggleItem));
    }
}
