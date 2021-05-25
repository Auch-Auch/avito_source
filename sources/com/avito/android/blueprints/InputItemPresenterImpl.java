package com.avito.android.blueprints;

import a2.g.r.g;
import android.text.TextWatcher;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.common.InputData;
import com.avito.android.common.InputFormatter;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.InputItem;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRj\u0010!\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e \u001e*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\f \u001e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e \u001e*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\f\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R:\u0010&\u001a&\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u000e0\u000e \u001e*\u0012\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/blueprints/InputItemPresenterImpl;", "Lcom/avito/android/blueprints/InputItemPresenter;", "Lcom/avito/android/blueprints/InputItemView;", "view", "Lcom/avito/android/items/InputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/InputItemView;Lcom/avito/android/items/InputItem;I)V", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/avito/android/items/BasicInputItem;", "d", "Lio/reactivex/Observable;", "getFocusChangesObservable", "()Lio/reactivex/Observable;", "focusChangesObservable", "Ldagger/Lazy;", "Lcom/avito/android/blueprints/InputItemPresenter$Listener;", "e", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/provider/InputItemFormatterProvider;", g.a, "Lcom/avito/android/provider/InputItemFormatterProvider;", "formatterProvider", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "focusChangesStream", "c", "getValueChangesObservable", "valueChangesObservable", AuthSource.SEND_ABUSE, "valueChangesStream", "Landroid/text/TextWatcher;", "f", "Landroid/text/TextWatcher;", "phoneNumberTextWatcher", "<init>", "(Ldagger/Lazy;Landroid/text/TextWatcher;Lcom/avito/android/provider/InputItemFormatterProvider;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemPresenterImpl implements InputItemPresenter {
    public final PublishRelay<BasicInputItem> a;
    public final PublishRelay<Pair<Boolean, BasicInputItem>> b;
    @NotNull
    public final Observable<BasicInputItem> c;
    @NotNull
    public final Observable<Pair<Boolean, BasicInputItem>> d;
    public final Lazy<? extends InputItemPresenter.Listener> e;
    public final TextWatcher f;
    public final InputItemFormatterProvider g;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ InputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;
        public final /* synthetic */ InputFormatter c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputItemPresenterImpl inputItemPresenterImpl, InputItem inputItem, InputFormatter inputFormatter) {
            super(1);
            this.a = inputItemPresenterImpl;
            this.b = inputItem;
            this.c = inputFormatter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setValue(str2);
            this.b.clearErrors();
            ((InputItemPresenter.Listener) this.a.e.get()).onElementValueChanged(this.b, str2);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ InputItemPresenterImpl a;
        public final /* synthetic */ InputItem b;
        public final /* synthetic */ InputFormatter c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InputItemPresenterImpl inputItemPresenterImpl, InputItem inputItem, InputFormatter inputFormatter) {
            super(1);
            this.a = inputItemPresenterImpl;
            this.b = inputItem;
            this.c = inputFormatter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            if (booleanValue) {
                ((InputItemPresenter.Listener) this.a.e.get()).onElementErrorDismissed(this.b);
            }
            this.a.b.accept(TuplesKt.to(Boolean.valueOf(booleanValue), this.b));
            return Unit.INSTANCE;
        }
    }

    public InputItemPresenterImpl(@NotNull Lazy<? extends InputItemPresenter.Listener> lazy, @NotNull TextWatcher textWatcher, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(textWatcher, "phoneNumberTextWatcher");
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        this.e = lazy;
        this.f = textWatcher;
        this.g = inputItemFormatterProvider;
        PublishRelay<BasicInputItem> create = PublishRelay.create();
        this.a = create;
        PublishRelay<Pair<Boolean, BasicInputItem>> create2 = PublishRelay.create();
        this.b = create2;
        Intrinsics.checkNotNullExpressionValue(create, "valueChangesStream");
        this.c = create;
        Intrinsics.checkNotNullExpressionValue(create2, "focusChangesStream");
        this.d = create2;
    }

    @Override // com.avito.android.blueprints.InputItemPresenter
    @NotNull
    public Observable<Pair<Boolean, BasicInputItem>> getFocusChangesObservable() {
        return this.d;
    }

    @Override // com.avito.android.blueprints.InputItemPresenter
    @NotNull
    public Observable<BasicInputItem> getValueChangesObservable() {
        return this.c;
    }

    public void bindView(@NotNull InputItemView inputItemView, @NotNull InputItem inputItem, int i) {
        String postfix;
        String prefix;
        Intrinsics.checkNotNullParameter(inputItemView, "view");
        Intrinsics.checkNotNullParameter(inputItem, "item");
        InputFormatter provide = this.g.provide(inputItem.getDisplayingOptions());
        inputItemView.setError(null);
        inputItemView.setFormatter(null);
        inputItemView.setTitle(inputItem.getTitle());
        inputItemView.setInputType(inputItem.getAndroidSdkInputType());
        inputItemView.setMinLines(inputItem.getLines());
        inputItemView.setMaxLines(inputItem.getLines());
        inputItemView.setPrefix(inputItem.getPrefix());
        inputItemView.setPostfix(inputItem.getPostfix());
        inputItemView.setValue(inputItem.getValue());
        String error = inputItem.getError();
        if (error != null) {
            inputItemView.setError(error);
        }
        Integer labelMode = inputItem.getLabelMode();
        if (labelMode != null) {
            inputItemView.setLabelMode(labelMode.intValue());
        }
        inputItemView.setOnValueChangeListener(new a(this, inputItem, provide));
        inputItemView.setFocusChangeListener(new b(this, inputItem, provide));
        if (provide != null) {
            DisplayingOptions displayingOptions = inputItem.getDisplayingOptions();
            if (!(displayingOptions == null || (prefix = displayingOptions.getPrefix()) == null)) {
                inputItemView.setPrefix(prefix);
            }
            DisplayingOptions displayingOptions2 = inputItem.getDisplayingOptions();
            if (!(displayingOptions2 == null || (postfix = displayingOptions2.getPostfix()) == null)) {
                inputItemView.setPostfix(postfix);
            }
            inputItemView.setFormatter(provide);
            inputItemView.setInputType(provide.getInputType());
            String value = inputItem.getValue();
            if (value != null) {
                inputItemView.setValue(provide.format(new InputData(value, 0, 0)).getValue().toString());
            } else {
                inputItemView.setValue(value);
            }
        } else if (Intrinsics.areEqual(inputItem.getStringId(), "phone")) {
            inputItemView.setTextWatcher(this.f);
        }
    }
}
