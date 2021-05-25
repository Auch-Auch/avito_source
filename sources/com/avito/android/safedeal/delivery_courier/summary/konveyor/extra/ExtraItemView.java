package com.avito.android.safedeal.delivery_courier.summary.konveyor.extra;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "extraInfoTitle", "", "extraInfo", "setExtraInfo", "(Ljava/lang/String;Ljava/util/List;)V", "showDialog", "()V", "Lkotlin/Function1;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDialogStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface ExtraItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ExtraItemView extraItemView) {
            ItemView.DefaultImpls.onUnbind(extraItemView);
        }
    }

    void setDialogStateChangeListener(@Nullable Function1<? super DialogState, Unit> function1);

    void setExtraInfo(@NotNull String str, @NotNull List<String> list);

    void setTitle(@NotNull String str);

    void showDialog();
}
