package com.avito.android.notifications_settings.toggle;

import android.text.method.MovementMethod;
import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.component.switch_list_element.SwitchListElement;
import com.avito.android.component.switch_list_element.SwitchListElementImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\nJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0014\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001e\u0010\u0018J&\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0001¢\u0006\u0004\b%\u0010\u0018J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001fH\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0004H\u0001¢\u0006\u0004\b)\u0010\u0006¨\u0006."}, d2 = {"Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleView;", "Lcom/avito/android/component/switch_list_element/SwitchListElement;", "", "onUnbind", "()V", "hideToggle", "", "isChecked", "()Z", "isSaveEnabled", "withAnimation", "setChecked", "(ZZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled", "setEnabled", "(Z)V", "", "resId", "setIcon", "(I)V", "enabled", "setSaveEnabled", "", MessengerShareContentUtility.SUBTITLE, "Landroid/text/method/MovementMethod;", "movementMethod", "setSubtitle", "(Ljava/lang/CharSequence;Landroid/text/method/MovementMethod;)V", "setSwitchEnabled", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "showToggle", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsToggleViewImpl extends BaseViewHolder implements NotificationsSettingsToggleView, SwitchListElement {
    public final /* synthetic */ SwitchListElementImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationsSettingsToggleViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new SwitchListElementImpl(view);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void hideToggle() {
        this.s.hideToggle();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isChecked() {
        return this.s.isChecked();
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public boolean isSaveEnabled() {
        return this.s.isSaveEnabled();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        setCheckedChangeListener(null);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setChecked(boolean z, boolean z2) {
        this.s.setChecked(z, z2);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setCheckedChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.s.setCheckedChangeListener(function1);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setClickListener(function0);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setIcon(@DrawableRes int i) {
        this.s.setIcon(i);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSaveEnabled(boolean z) {
        this.s.setSaveEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSubtitle(@Nullable CharSequence charSequence, @Nullable MovementMethod movementMethod) {
        this.s.setSubtitle(charSequence, movementMethod);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setSwitchEnabled(boolean z) {
        this.s.setSwitchEnabled(z);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.s.setTitle(charSequence);
    }

    @Override // com.avito.android.component.switch_list_element.SwitchListElement
    public void showToggle() {
        this.s.showToggle();
    }
}
