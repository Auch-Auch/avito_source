package com.avito.android.bundles.vas_union.item.performance.vas;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "setPrice", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "oldPrice", "setOldPrice", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface PerformanceVasItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PerformanceVasItemView performanceVasItemView) {
            ItemView.DefaultImpls.onUnbind(performanceVasItemView);
        }
    }

    void setClickListener(@NotNull Function0<Unit> function0);

    void setOldPrice(@Nullable AttributedText attributedText);

    void setPicture(@NotNull Picture picture);

    void setPrice(@Nullable AttributedText attributedText);

    void setTitle(@NotNull String str);
}
