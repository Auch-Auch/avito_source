package com.avito.android.fees.refactor.item;

import com.avito.android.util.Constants;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u000eJ'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH&¢\u0006\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/avito/android/fees/refactor/item/PackageItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", ErrorBundle.DETAIL_ENTRY, "", "setCountDetails", "(Ljava/lang/String;)V", "days", "setDaysLeft", Constants.LOCATION_NAME, "setLocation", "title", "showCategory", "hideCategory", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showDetails", "(Lkotlin/jvm/functions/Function0;)V", "hideDetails", "", "max", "progress", "drawableId", "showProgress", "(III)V", "setOnClickListener", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface PackageItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PackageItemView packageItemView) {
            ItemView.DefaultImpls.onUnbind(packageItemView);
        }
    }

    void hideCategory();

    void hideDetails();

    void setCountDetails(@NotNull String str);

    void setDaysLeft(@NotNull String str);

    void setLocation(@NotNull String str);

    void setOnClickListener(@NotNull Function0<Unit> function0);

    void showCategory(@NotNull String str);

    void showDetails(@NotNull Function0<Unit> function0);

    void showProgress(int i, int i2, int i3);
}
