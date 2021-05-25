package com.avito.android.advert.item.booking;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b+\u0010,J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010\rR\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u0016R\u001e\u0010&\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010*\u001a\n #*\u0004\u0018\u00010'0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/advert/item/booking/AdvertBookingViewImpl;", "Lcom/avito/android/advert/item/booking/AdvertBookingView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "buttonText", "", "isEnabled", "", "setButtonParams", "(Ljava/lang/String;Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "onUnbind", "()V", "setUnbindListener", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "Lcom/avito/android/util/text/AttributedTextFormatter;", "x", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "u", "onClickListener", "Lcom/avito/android/lib/design/button/Button;", "kotlin.jvm.PlatformType", "t", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "bookingText", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBookingViewImpl extends BaseViewHolder implements AdvertBookingView {
    public final TextView s;
    public final Button t;
    public Function0<Unit> u;
    public Function0<Unit> v;
    public final View w;
    public final AttributedTextFormatter x;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertBookingViewImpl a;

        public a(AdvertBookingViewImpl advertBookingViewImpl) {
            this.a = advertBookingViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.u;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertBookingViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.w = view;
        this.x = attributedTextFormatter;
        TextView textView = (TextView) view.findViewById(R.id.booking_text);
        this.s = textView;
        Button button = (Button) view.findViewById(R.id.button);
        this.t = button;
        Intrinsics.checkNotNullExpressionValue(textView, "bookingText");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        button.setOnClickListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.u = null;
        Function0<Unit> function0 = this.v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.advert.item.booking.AdvertBookingView
    public void setButtonClickListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }

    @Override // com.avito.android.advert.item.booking.AdvertBookingView
    public void setButtonParams(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "buttonText");
        this.t.setText(str);
        Button button = this.t;
        Intrinsics.checkNotNullExpressionValue(button, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        button.setEnabled(z);
    }

    @Override // com.avito.android.advert.item.booking.AdvertBookingView
    public void setText(@Nullable AttributedText attributedText) {
        if (attributedText != null) {
            Views.setVisible(this.s, true);
            TextView textView = this.s;
            Intrinsics.checkNotNullExpressionValue(textView, "bookingText");
            AttributedTextFormatter attributedTextFormatter = this.x;
            Context context = this.w.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            textView.setText(attributedTextFormatter.format(context, attributedText));
            return;
        }
        Views.setVisible(this.s, false);
    }

    @Override // com.avito.android.advert.item.booking.AdvertBookingView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.v = function0;
    }
}
