package com.avito.android.blueprints.range.cre_range;

import com.avito.android.blueprints.range.RangeItemView;
import com.avito.android.blueprints.range.RangePresenterImpl;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemView;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.RangeItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b0\u00101J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000eJ3\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R.\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0(0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010&¨\u00062"}, d2 = {"Lcom/avito/android/blueprints/range/cre_range/CreRangePresenterImpl;", "Lcom/avito/android/blueprints/range/cre_range/CreRangePresenter;", "Lcom/avito/android/blueprints/range/RangeItemView;", "view", "Lcom/avito/android/items/RangeItem$CreRangeItem;", "item", "", VKApiConst.POSITION, "", "", "payloads", "", "bindView", "(Lcom/avito/android/blueprints/range/RangeItemView;Lcom/avito/android/items/RangeItem$CreRangeItem;ILjava/util/List;)V", "(Lcom/avito/android/blueprints/range/RangeItemView;Lcom/avito/android/items/RangeItem$CreRangeItem;I)V", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "Lcom/avito/android/items/CheckBoxItem;", "Lkotlin/Function1;", "", "callback", AuthSource.SEND_ABUSE, "(Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;Lcom/avito/android/items/CheckBoxItem;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/blueprints/range/RangePresenterImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/blueprints/range/RangePresenterImpl;", "rangePresenter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/items/RangeItem;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "valueChangesStream", "Lcom/avito/android/util/text/AttributedTextFormatter;", "f", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lio/reactivex/Observable;", "c", "Lio/reactivex/Observable;", "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "Lkotlin/Pair;", "d", "getFocusChangesObservable", "focusChangesObservable", "", "e", "getViewSelectionObservable", "viewSelectionObservable", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class CreRangePresenterImpl implements CreRangePresenter {
    public final PublishRelay<RangeItem> a;
    public final RangePresenterImpl b;
    @NotNull
    public final Observable<RangeItem> c;
    @NotNull
    public final Observable<Pair<Boolean, RangeItem>> d;
    @NotNull
    public final Observable<String> e;
    public final AttributedTextFormatter f;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CheckBoxItem a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CreRangePresenterImpl creRangePresenterImpl, CheckBoxItem checkBoxItem, Function1 function1) {
            super(1);
            this.a = checkBoxItem;
            this.b = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            this.a.setChecked(booleanValue);
            this.b.invoke(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CreRangePresenterImpl a;
        public final /* synthetic */ RangeItem.CreRangeItem b;
        public final /* synthetic */ RangeItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CreRangePresenterImpl creRangePresenterImpl, RangeItem.CreRangeItem creRangeItem, RangeItemView rangeItemView) {
            super(1);
            this.a = creRangePresenterImpl;
            this.b = creRangeItem;
            this.c = rangeItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            CreRangePresenterImpl.access$onSwitcherValueChanged(this.a, bool.booleanValue(), this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CreRangePresenterImpl a;
        public final /* synthetic */ RangeItem.CreRangeItem b;
        public final /* synthetic */ RangeItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CreRangePresenterImpl creRangePresenterImpl, RangeItem.CreRangeItem creRangeItem, RangeItemView rangeItemView) {
            super(1);
            this.a = creRangePresenterImpl;
            this.b = creRangeItem;
            this.c = rangeItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            CreRangePresenterImpl.access$onSwitcherValueChanged(this.a, bool.booleanValue(), this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CreRangePresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.f = attributedTextFormatter;
        PublishRelay<RangeItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        RangePresenterImpl rangePresenterImpl = new RangePresenterImpl(attributedTextFormatter, create);
        this.b = rangePresenterImpl;
        this.c = rangePresenterImpl.getValueChangesObservable();
        this.d = rangePresenterImpl.getFocusChangesObservable();
        this.e = rangePresenterImpl.getViewSelectionObservable();
    }

    public static final void access$onSwitcherValueChanged(CreRangePresenterImpl creRangePresenterImpl, boolean z, RangeItem.CreRangeItem creRangeItem, RangeItemView rangeItemView) {
        Objects.requireNonNull(creRangePresenterImpl);
        rangeItemView.showFromField(z);
        if (z) {
            rangeItemView.getFromInputView().setNormalState(null);
        }
        creRangePresenterImpl.a.accept(creRangeItem);
    }

    public final void a(MultiStateSwitcherItemView multiStateSwitcherItemView, CheckBoxItem checkBoxItem, Function1<? super Boolean, Unit> function1) {
        multiStateSwitcherItemView.setTitle(checkBoxItem.getText());
        AttributedText subTitle = checkBoxItem.getSubTitle();
        CharSequence charSequence = null;
        multiStateSwitcherItemView.setSubTitle(subTitle != null ? this.f.format(subTitle) : null);
        multiStateSwitcherItemView.setChecked(checkBoxItem.isChecked());
        ItemWithState.State state = checkBoxItem.getState();
        if (state instanceof ItemWithState.State.Error) {
            multiStateSwitcherItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStateSwitcherItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message != null) {
                charSequence = message;
            } else {
                AttributedText motivation = checkBoxItem.getMotivation();
                if (motivation != null) {
                    charSequence = this.f.format(motivation);
                }
            }
            multiStateSwitcherItemView.setNormalState(charSequence);
        }
        multiStateSwitcherItemView.setCheckListener(new a(this, checkBoxItem, function1));
    }

    @Override // com.avito.android.blueprints.range.cre_range.CreRangePresenter
    @NotNull
    public Observable<Pair<Boolean, RangeItem>> getFocusChangesObservable() {
        return this.d;
    }

    @Override // com.avito.android.blueprints.range.cre_range.CreRangePresenter
    @NotNull
    public Observable<RangeItem> getValueChangesObservable() {
        return this.c;
    }

    @Override // com.avito.android.blueprints.range.cre_range.CreRangePresenter
    @NotNull
    public Observable<String> getViewSelectionObservable() {
        return this.e;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(RangeItemView rangeItemView, RangeItem.CreRangeItem creRangeItem, int i, List list) {
        bindView(rangeItemView, creRangeItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull RangeItemView rangeItemView, @NotNull RangeItem.CreRangeItem creRangeItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(rangeItemView, "view");
        Intrinsics.checkNotNullParameter(creRangeItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.b.bindView(rangeItemView, (RangeItem) creRangeItem, i, list);
        a(rangeItemView.getSwitcherView(), creRangeItem.getFromEnabler(), new b(this, creRangeItem, rangeItemView));
        rangeItemView.showFromField(creRangeItem.getFromEnabler().isChecked());
    }

    public void bindView(@NotNull RangeItemView rangeItemView, @NotNull RangeItem.CreRangeItem creRangeItem, int i) {
        Intrinsics.checkNotNullParameter(rangeItemView, "view");
        Intrinsics.checkNotNullParameter(creRangeItem, "item");
        this.b.bindView(rangeItemView, (RangeItem) creRangeItem, i);
        a(rangeItemView.getSwitcherView(), creRangeItem.getFromEnabler(), new c(this, creRangeItem, rangeItemView));
        rangeItemView.showFromField(creRangeItem.getFromEnabler().isChecked());
    }
}
