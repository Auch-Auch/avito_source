package com.avito.android.shop_settings.blueprints.switcher;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000bJ%\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setMessage", "", "value", "setValue", "(Z)V", "isEnabled", "setEnabled", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsSwitcherItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShopSettingsSwitcherItemView shopSettingsSwitcherItemView) {
            ItemView.DefaultImpls.onUnbind(shopSettingsSwitcherItemView);
        }
    }

    void setEnabled(boolean z);

    void setMessage(@Nullable String str);

    void setTitle(@NotNull String str);

    void setValue(boolean z);

    void setValueChangeListener(@Nullable Function1<? super Boolean, Unit> function1);
}
