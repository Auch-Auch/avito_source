package com.avito.android.blueprints.range;

import a2.g.r.g;
import com.avito.android.blueprints.input.MultiStateInputItemView;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.RangeItem;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.RangeItemChangePayload;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u00102\u001a\u00020/\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b¢\u0006\u0004\b5\u00106J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\u00020\b*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR:\u0010\u001f\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R.\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00040&0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$Rj\u0010+\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0004 \u001d*\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0004\u0018\u00010&0& \u001d**\u0012$\u0012\"\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0004 \u001d*\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0004\u0018\u00010&0&\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010\u001e¨\u00067"}, d2 = {"Lcom/avito/android/blueprints/range/RangePresenterImpl;", "Lcom/avito/android/blueprints/range/RangePresenter;", "Lcom/avito/android/blueprints/range/RangeItemView;", "view", "Lcom/avito/android/items/RangeItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/range/RangeItemView;Lcom/avito/android/items/RangeItem;I)V", "", "", "payloads", "(Lcom/avito/android/blueprints/range/RangeItemView;Lcom/avito/android/items/RangeItem;ILjava/util/List;)V", "rangeItem", "Lcom/avito/android/items/InputItem;", "inputItem", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/items/RangeItem;Lcom/avito/android/items/InputItem;Lcom/avito/android/blueprints/input/MultiStateInputItemView;)V", "Lcom/avito/android/items/ItemWithState$State;", "state", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/blueprints/input/MultiStateInputItemView;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "viewSelectionStream", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "getViewSelectionObservable", "()Lio/reactivex/Observable;", "viewSelectionObservable", "Lkotlin/Pair;", "", "d", "getFocusChangesObservable", "focusChangesObservable", "focusChangesStream", "c", "getValueChangesObservable", "valueChangesObservable", "Lcom/avito/android/util/text/AttributedTextFormatter;", "f", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", g.a, "valueChangesStream", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/jakewharton/rxrelay2/PublishRelay;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class RangePresenterImpl implements RangePresenter {
    public final PublishRelay<Pair<Boolean, RangeItem>> a;
    public final PublishRelay<String> b;
    @NotNull
    public final Observable<RangeItem> c;
    @NotNull
    public final Observable<Pair<Boolean, RangeItem>> d;
    @NotNull
    public final Observable<String> e;
    public final AttributedTextFormatter f;
    public final PublishRelay<RangeItem> g;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(1);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "it");
                ((RangeItem) this.c).getFrom().setValue(str2);
                ((RangePresenterImpl) this.b).g.accept((RangeItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullParameter(str3, "it");
                ((RangeItem) this.c).getTo().setValue(str3);
                ((RangePresenterImpl) this.b).g.accept((RangeItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj, Object obj2) {
            super(1);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                ((RangePresenterImpl) this.b).a.accept(TuplesKt.to(Boolean.valueOf(bool.booleanValue()), (RangeItem) this.c));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((RangePresenterImpl) this.b).a.accept(TuplesKt.to(Boolean.valueOf(bool.booleanValue()), (RangeItem) this.c));
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RangePresenterImpl a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RangePresenterImpl rangePresenterImpl, InputItem inputItem, RangeItem rangeItem) {
            super(0);
            this.a = rangePresenterImpl;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.accept(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ RangePresenterImpl a;
        public final /* synthetic */ InputItem b;
        public final /* synthetic */ RangeItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RangePresenterImpl rangePresenterImpl, InputItem inputItem, RangeItem rangeItem) {
            super(1);
            this.a = rangePresenterImpl;
            this.b = inputItem;
            this.c = rangeItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.a.accept(TuplesKt.to(Boolean.valueOf(bool.booleanValue()), this.c));
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ RangePresenterImpl a;
        public final /* synthetic */ InputItem b;
        public final /* synthetic */ RangeItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(RangePresenterImpl rangePresenterImpl, InputItem inputItem, RangeItem rangeItem) {
            super(1);
            this.a = rangePresenterImpl;
            this.b = inputItem;
            this.c = rangeItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setValue(str2);
            this.a.g.accept(this.c);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public RangePresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull PublishRelay<RangeItem> publishRelay) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(publishRelay, "valueChangesStream");
        this.f = attributedTextFormatter;
        this.g = publishRelay;
        PublishRelay<Pair<Boolean, RangeItem>> create = PublishRelay.create();
        this.a = create;
        PublishRelay<String> create2 = PublishRelay.create();
        this.b = create2;
        this.c = publishRelay;
        Intrinsics.checkNotNullExpressionValue(create, "focusChangesStream");
        this.d = create;
        Intrinsics.checkNotNullExpressionValue(create2, "viewSelectionStream");
        this.e = create2;
    }

    public final void a(RangeItem rangeItem, InputItem inputItem, MultiStateInputItemView multiStateInputItemView) {
        String postfix;
        String prefix;
        multiStateInputItemView.setOnValueChangeListener(null);
        multiStateInputItemView.removeTextWatcher();
        multiStateInputItemView.setTitle(inputItem.getHideTitle() ? "" : inputItem.getTitle());
        multiStateInputItemView.setPlaceholder(inputItem.getPlaceholder());
        multiStateInputItemView.setPrefix(inputItem.getPrefix());
        multiStateInputItemView.setPostfix(inputItem.getPostfix());
        DisplayingOptions displayingOptions = inputItem.getDisplayingOptions();
        if (!(displayingOptions == null || (prefix = displayingOptions.getPrefix()) == null)) {
            multiStateInputItemView.setPrefix(prefix);
        }
        DisplayingOptions displayingOptions2 = inputItem.getDisplayingOptions();
        if (!(displayingOptions2 == null || (postfix = displayingOptions2.getPostfix()) == null)) {
            multiStateInputItemView.setPostfix(postfix);
        }
        multiStateInputItemView.setInputType(inputItem.getInputType());
        if (inputItem.getLines() > 1) {
            MultiStateInputItemView.DefaultImpls.setMultiLine$default(multiStateInputItemView, inputItem.getLines(), 0, 2, null);
        } else {
            multiStateInputItemView.setSingleLine();
        }
        multiStateInputItemView.setMaxLength(Intrinsics.areEqual(inputItem.getInputType(), FormatterType.Companion.getDECIMAL()) ? 12 : Integer.MAX_VALUE);
        multiStateInputItemView.setValue(inputItem.getValue());
        multiStateInputItemView.setOnViewTouchedListener(new c(this, inputItem, rangeItem));
        multiStateInputItemView.setFocusChangeListener(new d(this, inputItem, rangeItem));
        multiStateInputItemView.setOnValueChangeListener(new e(this, inputItem, rangeItem));
        b(multiStateInputItemView, inputItem.getState(), inputItem.getMotivation());
    }

    public final void b(MultiStateInputItemView multiStateInputItemView, ItemWithState.State state, AttributedText attributedText) {
        if (state instanceof ItemWithState.State.Error) {
            multiStateInputItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStateInputItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message == null) {
                message = attributedText != null ? this.f.format(attributedText) : null;
            }
            multiStateInputItemView.setNormalState(message);
        }
    }

    @Override // com.avito.android.blueprints.range.RangePresenter
    @NotNull
    public Observable<Pair<Boolean, RangeItem>> getFocusChangesObservable() {
        return this.d;
    }

    @Override // com.avito.android.blueprints.range.RangePresenter
    @NotNull
    public Observable<RangeItem> getValueChangesObservable() {
        return this.c;
    }

    @Override // com.avito.android.blueprints.range.RangePresenter
    @NotNull
    public Observable<String> getViewSelectionObservable() {
        return this.e;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(RangeItemView rangeItemView, RangeItem rangeItem, int i, List list) {
        bindView(rangeItemView, rangeItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull RangeItemView rangeItemView, @NotNull RangeItem rangeItem, int i) {
        Intrinsics.checkNotNullParameter(rangeItemView, "view");
        Intrinsics.checkNotNullParameter(rangeItem, "item");
        a(rangeItem, rangeItem.getFrom(), rangeItemView.getFromInputView());
        a(rangeItem, rangeItem.getTo(), rangeItemView.getToInputView());
    }

    public void bindView(@NotNull RangeItemView rangeItemView, @NotNull RangeItem rangeItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(rangeItemView, "view");
        Intrinsics.checkNotNullParameter(rangeItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof RangeItemChangePayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(rangeItemView, rangeItem, i);
            return;
        }
        ItemWithState.State state = t3.getState();
        if (state != null) {
            rangeItem.setState(state);
            b(rangeItemView.getFromInputView(), rangeItem.getFrom().getState(), rangeItem.getFrom().getMotivation());
            b(rangeItemView.getToInputView(), rangeItem.getTo().getState(), rangeItem.getTo().getMotivation());
        }
        rangeItemView.getFromInputView().setOnValueChangeListener(new a(0, this, rangeItem));
        rangeItemView.getToInputView().setOnValueChangeListener(new a(1, this, rangeItem));
        rangeItemView.getFromInputView().setFocusChangeListener(new b(0, this, rangeItem));
        rangeItemView.getToInputView().setFocusChangeListener(new b(1, this, rangeItem));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RangePresenterImpl(com.avito.android.util.text.AttributedTextFormatter r1, com.jakewharton.rxrelay2.PublishRelay r2, int r3, t6.r.a.j r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            com.jakewharton.rxrelay2.PublishRelay r2 = com.jakewharton.rxrelay2.PublishRelay.create()
            java.lang.String r3 = "PublishRelay.create<RangeItem>()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.blueprints.range.RangePresenterImpl.<init>(com.avito.android.util.text.AttributedTextFormatter, com.jakewharton.rxrelay2.PublishRelay, int, t6.r.a.j):void");
    }
}
