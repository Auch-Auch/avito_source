package com.avito.android.str_calendar.seller.edit.konveyor.chips;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.lib.design.chips.SelectStrategy;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "selectConsumer", AuthSource.BOOKING_ORDER, "unselectConsumer", "<init>", "(Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class ChipsSelectItemPresenter implements ItemPresenter<ChipsSelectItemView, ParameterElement.Select.Flat> {
    public final Consumer<ParameterElement.Select> a;
    public final Consumer<ParameterElement.Select> b;

    public static final class a extends Lambda implements Function2<SelectableItem, Boolean, Unit> {
        public final /* synthetic */ ChipsSelectItemPresenter a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChipsSelectItemPresenter chipsSelectItemPresenter, ParameterElement.Select.Flat flat) {
            super(2);
            this.a = chipsSelectItemPresenter;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(SelectableItem selectableItem, Boolean bool) {
            SelectableItem selectableItem2 = selectableItem;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(selectableItem2, "value");
            if (booleanValue) {
                this.b.setSelectedValue(selectableItem2);
                Consumer consumer = this.a.a;
                if (consumer != null) {
                    consumer.accept(this.b);
                }
            } else {
                Consumer consumer2 = this.a.b;
                if (consumer2 != null) {
                    consumer2.accept(this.b);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public ChipsSelectItemPresenter() {
        this(null, null, 3, null);
    }

    public ChipsSelectItemPresenter(@Nullable Consumer<ParameterElement.Select> consumer, @Nullable Consumer<ParameterElement.Select> consumer2) {
        this.a = consumer;
        this.b = consumer2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChipsSelectItemPresenter(Consumer consumer, Consumer consumer2, int i, j jVar) {
        this((i & 1) != 0 ? null : consumer, (i & 2) != 0 ? null : consumer2);
    }

    public void bindView(@NotNull ChipsSelectItemView chipsSelectItemView, @NotNull ParameterElement.Select.Flat flat, int i) {
        Intrinsics.checkNotNullParameter(chipsSelectItemView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        chipsSelectItemView.setTitle(flat.getTitle());
        String bubbleError = flat.getBubbleError();
        if (bubbleError == null) {
            bubbleError = "";
        }
        chipsSelectItemView.setError(bubbleError);
        chipsSelectItemView.setValues(flat.getValues(), flat.getSelectedValue(), new a(this, flat));
        chipsSelectItemView.setSelectStrategy(SelectStrategy.SINGLE);
        chipsSelectItemView.setKeepSelected(true);
    }
}
