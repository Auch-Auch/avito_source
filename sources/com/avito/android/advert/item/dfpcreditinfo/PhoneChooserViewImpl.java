package com.avito.android.advert.item.dfpcreditinfo;

import a2.a.a.f.x.t.h;
import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserItem;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020\u0017¢\u0006\u0004\b-\u0010.J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001e\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0019\u0010!\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR$\u0010)\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0019\u0010,\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001a¨\u0006/"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserViewImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView;", "", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "items", "", "showItems", "(Ljava/util/List;)V", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "()Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getOtherPhone", "setOtherPhone", "(Landroid/widget/TextView;)V", "otherPhone", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "getPhonesContainer", "()Landroid/view/ViewGroup;", "phonesContainer", "Landroid/view/View;", "Landroid/view/View;", "getProgressBar", "()Landroid/view/View;", "progressBar", "c", "getRetryButton", "retryButton", AuthSource.BOOKING_ORDER, "getErrorContainer", "errorContainer", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "f", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "getListener", "()Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, g.a, "getView", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneChooserViewImpl implements PhoneChooserView {
    @NotNull
    public final View a;
    @NotNull
    public final View b;
    @NotNull
    public final View c;
    @NotNull
    public final ViewGroup d;
    @Nullable
    public TextView e;
    @Nullable
    public PhoneChooserView.Listener f;
    @NotNull
    public final View g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PhoneChooserViewImpl a;

        public a(PhoneChooserViewImpl phoneChooserViewImpl) {
            this.a = phoneChooserViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PhoneChooserView.Listener listener = this.a.getListener();
            if (listener != null) {
                listener.onReloadPhonesClicked();
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PhoneChooserViewImpl a;

        public b(PhoneChooserViewImpl phoneChooserViewImpl) {
            this.a = phoneChooserViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PhoneChooserView.Listener listener = this.a.getListener();
            if (listener != null) {
                listener.onOtherPhoneClicked();
            }
        }
    }

    public PhoneChooserViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        View findViewById = view.findViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_bar)");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.error_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.error_container)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.retry_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.retry_button)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.phones_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.phones_container)");
        this.d = (ViewGroup) findViewById4;
        findViewById3.setOnClickListener(new a(this));
    }

    public final TextView a() {
        View inflate = LayoutInflater.from(this.g.getContext()).inflate(R.layout.advert_details_credit_phone, this.d, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        this.d.addView(textView);
        return textView;
    }

    @NotNull
    public final View getErrorContainer() {
        return this.b;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView
    @Nullable
    public PhoneChooserView.Listener getListener() {
        return this.f;
    }

    @Nullable
    public final TextView getOtherPhone() {
        return this.e;
    }

    @NotNull
    public final ViewGroup getPhonesContainer() {
        return this.d;
    }

    @NotNull
    public final View getProgressBar() {
        return this.a;
    }

    @NotNull
    public final View getRetryButton() {
        return this.c;
    }

    @NotNull
    public final View getView() {
        return this.g;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView
    public void setListener(@Nullable PhoneChooserView.Listener listener) {
        this.f = listener;
    }

    public final void setOtherPhone(@Nullable TextView textView) {
        this.e = textView;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView
    public void showItems(@NotNull List<? extends PhoneChooserItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        boolean z = list.isEmpty() || Intrinsics.areEqual((PhoneChooserItem) CollectionsKt___CollectionsKt.firstOrNull(list), PhoneChooserItem.Loading.INSTANCE);
        ArrayList<PhoneChooserItem.Phone> arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof PhoneChooserItem.Phone) {
                arrayList.add(t);
            }
        }
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.d.removeAllViews();
        if (!arrayList.isEmpty()) {
            for (PhoneChooserItem.Phone phone : arrayList) {
                TextView a3 = a();
                a3.setText(phone.getPhone());
                a3.setOnClickListener(new h(phone, this));
            }
        } else if (z) {
            this.a.setVisibility(0);
        } else {
            this.b.setVisibility(0);
        }
        TextView a4 = a();
        a4.setText(this.g.getResources().getString(R.string.advert_details_credit_phone_chooser_other_phone));
        a4.setOnClickListener(new b(this));
        this.e = a4;
    }
}
