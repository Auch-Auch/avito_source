package com.avito.android.blueprints.chips;

import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.lib.design.chips.SelectStrategy;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJG\u0010\u0016\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0014H&¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/blueprints/chips/ChipsSelectItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "error", "setError", "setNormalState", "()V", "", "Lcom/avito/android/lib/design/chips/Chipable;", ResidentialComplexModuleKt.VALUES, "selectedValues", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "", "maxSelected", "setMaxSelected", "(Ljava/lang/Integer;)V", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "strategy", "setSelectStrategy", "(Lcom/avito/android/lib/design/chips/SelectStrategy;)V", "keepSelected", "setKeepSelected", "(Z)V", "Lcom/avito/android/lib/design/chips/Chips$DisplayType;", "type", "setDisplayType", "(Lcom/avito/android/lib/design/chips/Chips$DisplayType;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface ChipsSelectItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ChipsSelectItemView chipsSelectItemView) {
            ItemView.DefaultImpls.onUnbind(chipsSelectItemView);
        }
    }

    void setDisplayType(@NotNull Chips.DisplayType displayType);

    void setError(@NotNull String str);

    void setKeepSelected(boolean z);

    void setMaxSelected(@Nullable Integer num);

    void setNormalState();

    void setSelectStrategy(@NotNull SelectStrategy selectStrategy);

    void setSubtitle(@Nullable AttributedText attributedText);

    void setTitle(@NotNull String str);

    void setValues(@NotNull List<? extends Chipable> list, @Nullable List<? extends Chipable> list2, @NotNull Function2<? super Chipable, ? super Boolean, Unit> function2);
}
