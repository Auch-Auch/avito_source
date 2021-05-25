package com.avito.android.user_advert.soa_with_price;

import a2.g.r.g;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.R;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R(\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R.\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$¨\u00060"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/PriceSheetDialogViewImpl;", "Lcom/avito/android/user_advert/soa_with_price/PriceSheetDialogView;", "", "message", "", "setMessage", "(Ljava/lang/CharSequence;)V", "text", "setInputText", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lkotlin/Pair;", "", "", "f", "Lcom/jakewharton/rxrelay2/PublishRelay;", "priceInputFocusChangesRelay", "e", "priceSubmittedRelay", "d", "priceChangingEventsRelay", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "componentContainer", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "closeButton", "Lcom/avito/android/lib/design/input/Input;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/input/Input;", "priceInput", "Lio/reactivex/Observable;", g.a, "Lio/reactivex/Observable;", "getPriceChangingEvents", "()Lio/reactivex/Observable;", "priceChangingEvents", "h", "getPriceSubmittedEvents", "priceSubmittedEvents", "i", "getPriceInputFocusChanges", "priceInputFocusChanges", "Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class PriceSheetDialogViewImpl implements PriceSheetDialogView {
    public final ComponentContainer a;
    public final Input b;
    public final Button c;
    public final PublishRelay<String> d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Pair<Boolean, String>> f;
    @NotNull
    public final Observable<String> g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Pair<Boolean, String>> i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PriceSheetDialogViewImpl a;

        public a(PriceSheetDialogViewImpl priceSheetDialogViewImpl) {
            this.a = priceSheetDialogViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.e.accept(Unit.INSTANCE);
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ PriceSheetDialogViewImpl a;

        public b(PriceSheetDialogViewImpl priceSheetDialogViewImpl) {
            this.a = priceSheetDialogViewImpl;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.f.accept(TuplesKt.to(Boolean.valueOf(z), this.a.b.getDeformattedText()));
        }
    }

    public PriceSheetDialogViewImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        View findViewById = viewGroup.findViewById(R.id.price_input_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.a = (ComponentContainer) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.price_input);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById2;
        this.b = input;
        View findViewById3 = viewGroup.findViewById(R.id.close_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        this.c = button;
        PublishRelay<String> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.d = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.e = create2;
        PublishRelay<Pair<Boolean, String>> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.f = create3;
        Observable<String> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "priceChangingEventsRelay.hide()");
        this.g = hide;
        Observable<Unit> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "priceSubmittedRelay.hide()");
        this.h = hide2;
        Observable<Pair<Boolean, String>> hide3 = create3.hide();
        Intrinsics.checkNotNullExpressionValue(hide3, "priceInputFocusChangesRelay.hide()");
        this.i = hide3;
        button.setOnClickListener(new a(this));
        input.setFocusChangeListener(new b(this));
        input.addTextChangedListener(new TextWatcher(input, this) { // from class: com.avito.android.user_advert.soa_with_price.PriceSheetDialogViewImpl$$special$$inlined$addDeformattedTextChangedListener$1
            public String a;
            public final /* synthetic */ Input b;
            public final /* synthetic */ PriceSheetDialogViewImpl c;

            {
                this.b = r1;
                this.c = r2;
                this.a = r1.getDeformattedText();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                String deformattedText = this.b.getDeformattedText();
                if (!Intrinsics.areEqual(deformattedText, this.a)) {
                    this.c.d.accept(deformattedText);
                    this.a = deformattedText;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        String string = viewGroup.getContext().getString(R.string.price_ruble_postfix);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri…ring.price_ruble_postfix)");
        input.setPostfix(string);
        Input.setFormatterType$default(input, FormatterType.Companion.getDECIMAL(), false, 2, null);
        input.setMaxLength(12);
    }

    @Override // com.avito.android.user_advert.soa_with_price.PriceSheetDialogView
    @NotNull
    public Observable<String> getPriceChangingEvents() {
        return this.g;
    }

    @Override // com.avito.android.user_advert.soa_with_price.PriceSheetDialogView
    @NotNull
    public Observable<Pair<Boolean, String>> getPriceInputFocusChanges() {
        return this.i;
    }

    @Override // com.avito.android.user_advert.soa_with_price.PriceSheetDialogView
    @NotNull
    public Observable<Unit> getPriceSubmittedEvents() {
        return this.h;
    }

    @Override // com.avito.android.user_advert.soa_with_price.PriceSheetDialogView
    public void setInputText(@Nullable CharSequence charSequence) {
        Input.setText$default(this.b, charSequence, false, 2, null);
    }

    @Override // com.avito.android.user_advert.soa_with_price.PriceSheetDialogView
    public void setMessage(@Nullable CharSequence charSequence) {
        this.a.setMessage(charSequence);
    }
}
