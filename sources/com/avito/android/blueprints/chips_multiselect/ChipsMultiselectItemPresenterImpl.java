package com.avito.android.blueprints.chips_multiselect;

import com.avito.android.blueprints.SelectedInfo;
import com.avito.android.blueprints.chips.ChipableValue;
import com.avito.android.blueprints.chips.ChipsSelectItemView;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.ItemWithState;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.lib.design.chips.SelectStrategy;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR:\u0010\u0010\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemPresenterImpl;", "Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemPresenter;", "Lcom/avito/android/blueprints/chips/ChipsSelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/chips/ChipsSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/blueprints/SelectedInfo;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemSelectedRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getItemSelectedObservable", "()Lio/reactivex/Observable;", "itemSelectedObservable", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ChipsMultiselectItemPresenterImpl implements ChipsMultiselectItemPresenter {
    public final PublishRelay<SelectedInfo> a;
    @NotNull
    public final Observable<SelectedInfo> b;

    public static final class a extends Lambda implements Function2<Chipable, Boolean, Unit> {
        public final /* synthetic */ ChipsMultiselectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Multiselect b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChipsMultiselectItemPresenterImpl chipsMultiselectItemPresenterImpl, ParameterElement.Multiselect multiselect) {
            super(2);
            this.a = chipsMultiselectItemPresenterImpl;
            this.b = multiselect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Chipable chipable, Boolean bool) {
            T t;
            Chipable chipable2 = chipable;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(chipable2, "chipable");
            Iterator<T> it = this.b.getValues().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getStringId(), ((ChipableValue) chipable2).getStringId())) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                t2.setSelected(booleanValue);
                this.a.a.accept(new SelectedInfo(this.b.getStringId(), t2));
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ChipsMultiselectItemPresenterImpl() {
        PublishRelay<SelectedInfo> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "itemSelectedRelay");
        this.b = create;
    }

    @Override // com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter
    @NotNull
    public Observable<SelectedInfo> getItemSelectedObservable() {
        return this.b;
    }

    public void bindView(@NotNull ChipsSelectItemView chipsSelectItemView, @NotNull ParameterElement.Multiselect multiselect, int i) {
        Intrinsics.checkNotNullParameter(chipsSelectItemView, "view");
        Intrinsics.checkNotNullParameter(multiselect, "item");
        chipsSelectItemView.setDisplayType(Chips.DisplayType.MULTIPLE_LINES);
        chipsSelectItemView.setTitle(multiselect.getHideTitle() ? "" : multiselect.getTitle());
        chipsSelectItemView.setSubtitle(multiselect.getSubtitle());
        ItemWithState.State state = multiselect.getState();
        if (state instanceof ItemWithState.State.Error) {
            chipsSelectItemView.setError(((ItemWithState.State.Error) state).getMessage().toString());
        } else {
            chipsSelectItemView.setNormalState();
        }
        if (multiselect.getDisplayType() instanceof ParameterElement.DisplayType.Chips) {
            chipsSelectItemView.setKeepSelected(((ParameterElement.DisplayType.Chips) multiselect.getDisplayType()).getKeepSelectedChip());
        } else {
            chipsSelectItemView.setKeepSelected(true);
        }
        chipsSelectItemView.setSelectStrategy(SelectStrategy.MULTIPLE);
        chipsSelectItemView.setMaxSelected(multiselect.getMaxSelected());
        chipsSelectItemView.setValues(ChipsMultiselectItemPresenterKt.access$chipableValues(multiselect), ChipsMultiselectItemPresenterKt.access$selectedValues(multiselect), new a(this, multiselect));
    }
}
