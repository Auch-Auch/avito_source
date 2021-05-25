package com.avito.android.blueprints.publish;

import a2.g.r.g;
import android.text.TextWatcher;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithState;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.MaskInfo;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.MaskApplyingResult;
import com.avito.android.util.MasksFormatterImpl;
import com.avito.android.util.MasksFormatterTextWatcher;
import com.avito.android.util.MultiStateInputChangePayload;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.validation.ItemsKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0*\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b4\u00105J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0013\u001a\u00020\b*\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR:\u0010!\u001a&\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e \u001f*\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010$¨\u00066"}, d2 = {"Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemPresenterImpl;", "Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemPresenter;", "Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemView;", "view", "Lcom/avito/android/items/InputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemView;Lcom/avito/android/items/InputItem;I)V", "", "", "payloads", "(Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemView;Lcom/avito/android/items/InputItem;ILjava/util/List;)V", "Lcom/avito/android/items/ItemWithState$State;", "state", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", AuthSource.SEND_ABUSE, "(Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemView;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "e", "Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "fullMatchedMask", "Landroid/text/TextWatcher;", g.a, "Landroid/text/TextWatcher;", "vehicleRegNumberRegionTextWatcher", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/items/BasicInputItem;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "valueChangesStream", "", "d", "Ljava/lang/String;", "lastEnteredRegion", "Lcom/avito/android/util/text/AttributedTextFormatter;", "h", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lio/reactivex/Observable;", "f", "Lio/reactivex/Observable;", "requestFocusStream", AuthSource.BOOKING_ORDER, "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "c", "lastEnteredNumber", "<init>", "(Lio/reactivex/Observable;Landroid/text/TextWatcher;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class VehicleRegNumberInputItemPresenterImpl implements VehicleRegNumberInputItemPresenter {
    public final PublishRelay<BasicInputItem> a;
    @NotNull
    public final Observable<BasicInputItem> b;
    public String c = "";
    public String d = "";
    public MaskInfo e;
    public final Observable<String> f;
    public final TextWatcher g;
    public final AttributedTextFormatter h;

    public static final class a extends Lambda implements Function1<MaskApplyingResult, Unit> {
        public final /* synthetic */ VehicleRegNumberInputItemView a;
        public final /* synthetic */ VehicleRegNumberInputItemPresenterImpl b;
        public final /* synthetic */ InputItem c;
        public final /* synthetic */ VehicleRegNumberInputItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VehicleRegNumberInputItemView vehicleRegNumberInputItemView, VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl, InputItem inputItem, VehicleRegNumberInputItemView vehicleRegNumberInputItemView2) {
            super(1);
            this.a = vehicleRegNumberInputItemView;
            this.b = vehicleRegNumberInputItemPresenterImpl;
            this.c = inputItem;
            this.d = vehicleRegNumberInputItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MaskApplyingResult maskApplyingResult) {
            MaskApplyingResult maskApplyingResult2 = maskApplyingResult;
            if (maskApplyingResult2 == null || m.isBlank(maskApplyingResult2.getResultText())) {
                this.b.e = null;
                this.a.setIsEmpty(true);
            } else {
                this.a.setIsEmpty(false);
                Color backgroundColor = maskApplyingResult2.getMask().getBackgroundColor();
                if (maskApplyingResult2.getResultText().length() != maskApplyingResult2.getMask().getMask().length() || backgroundColor == null) {
                    this.b.e = null;
                } else {
                    this.b.e = maskApplyingResult2.getMask();
                    this.a.setBackgroundColor(backgroundColor);
                    this.a.showKeyboardForRegion();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ VehicleRegNumberInputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;
        public final /* synthetic */ VehicleRegNumberInputItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl, InputItem inputItem, VehicleRegNumberInputItemView vehicleRegNumberInputItemView) {
            super(1);
            this.a = vehicleRegNumberInputItemPresenterImpl;
            this.b = inputItem;
            this.c = vehicleRegNumberInputItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setValue(str2);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ InputItem a;
        public final /* synthetic */ VehicleRegNumberInputItemView b;

        public c(VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl, InputItem inputItem, VehicleRegNumberInputItemView vehicleRegNumberInputItemView) {
            this.a = inputItem;
            this.b = vehicleRegNumberInputItemView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            this.b.showKeyboardForNumber();
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Disposable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Disposable disposable) {
            super(0);
            this.a = disposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dispose();
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ VehicleRegNumberInputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl, InputItem inputItem) {
            super(1);
            this.a = vehicleRegNumberInputItemPresenterImpl;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setValue(str2);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public VehicleRegNumberInputItemPresenterImpl(@NotNull Observable<String> observable, @NotNull TextWatcher textWatcher, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(observable, "requestFocusStream");
        Intrinsics.checkNotNullParameter(textWatcher, "vehicleRegNumberRegionTextWatcher");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.f = observable;
        this.g = textWatcher;
        this.h = attributedTextFormatter;
        PublishRelay<BasicInputItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "valueChangesStream");
        this.b = create;
    }

    public static final String access$withoutSpaces(VehicleRegNumberInputItemPresenterImpl vehicleRegNumberInputItemPresenterImpl, String str) {
        Objects.requireNonNull(vehicleRegNumberInputItemPresenterImpl);
        return m.replace$default(str, " ", "", false, 4, (Object) null);
    }

    public final void a(VehicleRegNumberInputItemView vehicleRegNumberInputItemView, ItemWithState.State state, AttributedText attributedText) {
        Color backgroundColor;
        if (state instanceof ItemWithState.State.Error) {
            vehicleRegNumberInputItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
            vehicleRegNumberInputItemView.setBackgroundColor(R.color.expected_avito_constant_red_50);
        } else if (state instanceof ItemWithState.State.Warning) {
            vehicleRegNumberInputItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
            vehicleRegNumberInputItemView.setBackgroundColor(R.color.expected_avito_constant_orange_50);
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message == null) {
                message = attributedText != null ? this.h.format(vehicleRegNumberInputItemView.getContext(), attributedText) : null;
            }
            vehicleRegNumberInputItemView.setNormalState(message);
            MaskInfo maskInfo = this.e;
            if (maskInfo == null || (backgroundColor = maskInfo.getBackgroundColor()) == null) {
                vehicleRegNumberInputItemView.setBackgroundColor(R.color.avito_constant_white);
            } else {
                vehicleRegNumberInputItemView.setBackgroundColor(backgroundColor);
            }
        }
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter
    @NotNull
    public Observable<BasicInputItem> getValueChangesObservable() {
        return this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(VehicleRegNumberInputItemView vehicleRegNumberInputItemView, InputItem inputItem, int i, List list) {
        bindView(vehicleRegNumberInputItemView, inputItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull VehicleRegNumberInputItemView vehicleRegNumberInputItemView, @NotNull InputItem inputItem, int i) {
        List<MaskInfo> list;
        Boolean enabled;
        Intrinsics.checkNotNullParameter(vehicleRegNumberInputItemView, "view");
        Intrinsics.checkNotNullParameter(inputItem, "item");
        vehicleRegNumberInputItemView.removeNumberTextWatcher();
        vehicleRegNumberInputItemView.removeRegionTextWatcher();
        DisplayingOptions displayingOptions = inputItem.getDisplayingOptions();
        if (displayingOptions == null || (list = displayingOptions.getMasks()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z = true;
        MasksFormatterImpl masksFormatterImpl = new MasksFormatterImpl(list, true, new a(vehicleRegNumberInputItemView, this, inputItem, vehicleRegNumberInputItemView));
        vehicleRegNumberInputItemView.setNumberTextWatcher(new MasksFormatterTextWatcher(masksFormatterImpl));
        vehicleRegNumberInputItemView.setRegionTextWatcher(this.g);
        b bVar = new b(this, inputItem, vehicleRegNumberInputItemView);
        vehicleRegNumberInputItemView.setOnNumberChangedListener(new p4(0, this, bVar));
        vehicleRegNumberInputItemView.setOnRegionChangedListener(new p4(1, this, bVar));
        String value = inputItem.getValue();
        String str = "";
        if (value != null) {
            String filterUnconstrainedLetters = masksFormatterImpl.filterUnconstrainedLetters(value);
            if (m.startsWith(value, filterUnconstrainedLetters, true)) {
                vehicleRegNumberInputItemView.setRegion(m.replace(value, filterUnconstrainedLetters, str, true));
            } else {
                vehicleRegNumberInputItemView.setRegion(null);
            }
            vehicleRegNumberInputItemView.setNumber(filterUnconstrainedLetters);
        }
        if (!inputItem.getHideTitle()) {
            str = inputItem.getTitle();
        }
        vehicleRegNumberInputItemView.setTitle(str);
        vehicleRegNumberInputItemView.setOnUnbindListener(new d(ItemsKt.filterItemIdFromNotifications(this.f, inputItem.getStringId()).subscribe(new c(this, inputItem, vehicleRegNumberInputItemView))));
        a(vehicleRegNumberInputItemView, inputItem.getState(), inputItem.getMotivation());
        DisplayingOptions displayingOptions2 = inputItem.getDisplayingOptions();
        if (!(displayingOptions2 == null || (enabled = displayingOptions2.getEnabled()) == null)) {
            z = enabled.booleanValue();
        }
        vehicleRegNumberInputItemView.setEnabled(z);
    }

    public void bindView(@NotNull VehicleRegNumberInputItemView vehicleRegNumberInputItemView, @NotNull InputItem inputItem, int i, @NotNull List<? extends Object> list) {
        Boolean enabled;
        Intrinsics.checkNotNullParameter(vehicleRegNumberInputItemView, "view");
        Intrinsics.checkNotNullParameter(inputItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof MultiStateInputChangePayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(vehicleRegNumberInputItemView, inputItem, i);
            return;
        }
        a(vehicleRegNumberInputItemView, t3.getState(), inputItem.getMotivation());
        e eVar = new e(this, inputItem);
        vehicleRegNumberInputItemView.setOnNumberChangedListener(new p4(0, this, eVar));
        boolean z = true;
        vehicleRegNumberInputItemView.setOnRegionChangedListener(new p4(1, this, eVar));
        DisplayingOptions displayingOptions = inputItem.getDisplayingOptions();
        if (!(displayingOptions == null || (enabled = displayingOptions.getEnabled()) == null)) {
            z = enabled.booleanValue();
        }
        vehicleRegNumberInputItemView.setEnabled(z);
    }
}
