package com.avito.android.delivery.summary.konveyor.header;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/header/HeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", ProductAction.ACTION_ADD, "addTopMargin", "(Z)V", "visible", "setVisibilityChangeButton", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnChangeClickListener", "(Lkotlin/jvm/functions/Function0;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface HeaderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HeaderItemView headerItemView) {
            ItemView.DefaultImpls.onUnbind(headerItemView);
        }
    }

    void addTopMargin(boolean z);

    void setOnChangeClickListener(@NotNull Function0<Unit> function0);

    void setText(@NotNull CharSequence charSequence);

    void setVisibilityChangeButton(boolean z);
}
