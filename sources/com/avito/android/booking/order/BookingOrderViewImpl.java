package com.avito.android.booking.order;

import a2.g.r.g;
import android.content.Context;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.booking.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010[\u001a\u00020X¢\u0006\u0004\b^\u0010_J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J+\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u000fJ\u000f\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010\u000fJ\u0017\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010\u000fR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00108\u001a\n 1*\u0004\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010E\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u00103R\u001e\u0010I\u001a\n 1*\u0004\u0018\u00010F0F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010K\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u00103R\u001e\u0010O\u001a\n 1*\u0004\u0018\u00010L0L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001e\u0010Q\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u00103R\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010BR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010BR\u001e\u0010W\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u00103R\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010]\u001a\n 1*\u0004\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u00107¨\u0006`"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderViewImpl;", "Lcom/avito/android/booking/order/BookingOrderView;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "actionClicks", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "navigationClicks", "refreshClicks", "", "visible", "setVisible", "(Z)V", "", "title", "setScreenTitle", "(Ljava/lang/String;)V", "text", InternalConstsKt.PLACEHOLDER, "description", "setInputParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/text/TextWatcher;", "watcher", "setInputTextWatcher", "(Landroid/text/TextWatcher;)V", "removeInputTextWatcher", "", "inputState", "descriptionMessage", "", "descriptionTextColor", "setInputState", "([ILjava/lang/String;Ljava/lang/Integer;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "setBookingInfo", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "setButtonText", "showProgress", "()V", "showContent", "errorMessage", "showError", "message", "showMessage", "Landroid/view/View;", "o", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "i", "Landroid/widget/TextView;", "bookingInfoTitle", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "content", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "k", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/widget/ImageButton;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageButton;", "backButton", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay3/PublishRelay;", "navigationClickRelay", "c", "screenTitle", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "floatingButton", "h", "inputDescription", "Lcom/avito/android/lib/design/input/Input;", g.a, "Lcom/avito/android/lib/design/input/Input;", "input", "j", "bookingInfoDescription", "n", "refreshClickRelay", "l", "actionClickRelay", "f", "inputTitle", "Lcom/avito/android/util/text/AttributedTextFormatter;", "p", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", AuthSource.SEND_ABUSE, "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderViewImpl implements BookingOrderView {
    public final ViewGroup a;
    public final ImageButton b;
    public final TextView c;
    public final ViewGroup d;
    public final Button e;
    public final TextView f;
    public final Input g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public ProgressOverlay k;
    public final PublishRelay<Unit> l;
    public final PublishRelay<Unit> m;
    public final PublishRelay<Unit> n;
    public final View o;
    public final AttributedTextFormatter p;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((BookingOrderViewImpl) this.b).m.accept(Unit.INSTANCE);
            } else if (i == 1) {
                ((BookingOrderViewImpl) this.b).l.accept(Unit.INSTANCE);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BookingOrderViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BookingOrderViewImpl bookingOrderViewImpl) {
            super(0);
            this.a = bookingOrderViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.n;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public BookingOrderViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.o = view;
        this.p = attributedTextFormatter;
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.booking_order_root_view);
        this.a = viewGroup;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "rootView");
        View findViewById = viewGroup.findViewById(R.id.back_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) findViewById;
        this.b = imageButton;
        this.c = (TextView) viewGroup.findViewById(R.id.screen_title);
        int i2 = R.id.content;
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(i2);
        this.d = viewGroup2;
        Button button = (Button) view.findViewById(R.id.floating_button);
        this.e = button;
        this.f = (TextView) viewGroup2.findViewById(R.id.input_title);
        this.g = (Input) viewGroup2.findViewById(R.id.input);
        this.h = (TextView) viewGroup2.findViewById(R.id.input_description);
        this.i = (TextView) viewGroup2.findViewById(R.id.booking_info_title);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.booking_info_description);
        this.j = textView;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "rootView");
        this.k = new ProgressOverlay(viewGroup, i2, null, false, 0, 28, null);
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<Unit>()");
        this.l = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create<Unit>()");
        this.m = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create<Unit>()");
        this.n = create3;
        Intrinsics.checkNotNullExpressionValue(textView, "bookingInfoDescription");
        textView.setMovementMethod(new LinkMovementMethod());
        imageButton.setOnClickListener(new a(0, this));
        button.setOnClickListener(new a(1, this));
        this.k.setOnRefreshListener(new b(this));
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void removeInputTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "watcher");
        this.g.removeTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void setBookingInfo(@NotNull String str, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.i;
        Intrinsics.checkNotNullExpressionValue(textView, "bookingInfoTitle");
        textView.setText(str);
        TextView textView2 = this.j;
        Intrinsics.checkNotNullExpressionValue(textView2, "bookingInfoDescription");
        TextViewsKt.bindAttributedText(textView2, attributedText, this.p);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void setButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.e.setText(str);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void setInputParams(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.f;
        Intrinsics.checkNotNullExpressionValue(textView, "inputTitle");
        textView.setText(str);
        boolean z = false;
        Input.setText$default(this.g, str2, false, 2, null);
        this.g.setHint(str3);
        TextView textView2 = this.h;
        Intrinsics.checkNotNullExpressionValue(textView2, "inputDescription");
        textView2.setText(str4);
        TextView textView3 = this.h;
        if (str4 != null) {
            if (str4.length() > 0) {
                z = true;
            }
        }
        Views.setVisible(textView3, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if ((r4.length() > 0) != false) goto L_0x001b;
     */
    @Override // com.avito.android.booking.order.BookingOrderView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInputState(@org.jetbrains.annotations.NotNull int[] r3, @org.jetbrains.annotations.Nullable java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.Integer r5) {
        /*
            r2 = this;
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.lib.design.input.Input r0 = r2.g
            r0.setState(r3)
            r3 = 1
            r0 = 0
            if (r4 == 0) goto L_0x001a
            int r1 = r4.length()
            if (r1 <= 0) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x0027
            android.widget.TextView r3 = r2.h
            java.lang.String r0 = "inputDescription"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r3.setText(r4)
        L_0x0027:
            if (r5 == 0) goto L_0x0032
            android.widget.TextView r3 = r2.h
            int r4 = r5.intValue()
            r3.setTextColor(r4)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.booking.order.BookingOrderViewImpl.setInputState(int[], java.lang.String, java.lang.Integer):void");
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void setInputTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "watcher");
        this.g.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void setScreenTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.c;
        Intrinsics.checkNotNullExpressionValue(textView, "screenTitle");
        textView.setText(str);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void setVisible(boolean z) {
        Views.setVisible(this.a, z);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void showContent() {
        this.k.showContent();
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.k.showLoadingProblem(str);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.o.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    public void showProgress() {
        this.k.showLoading();
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    @NotNull
    public PublishRelay<Unit> actionClicks() {
        return this.l;
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    @NotNull
    public PublishRelay<Unit> navigationClicks() {
        return this.m;
    }

    @Override // com.avito.android.booking.order.BookingOrderView
    @NotNull
    public PublishRelay<Unit> refreshClicks() {
        return this.n;
    }
}
