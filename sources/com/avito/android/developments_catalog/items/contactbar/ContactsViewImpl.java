package com.avito.android.developments_catalog.items.contactbar;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b \u0010!J%\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001e\u001a\n \u0012*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/avito/android/developments_catalog/items/contactbar/ContactsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/contactbar/ContactsView;", "", "title", "Lkotlin/Function0;", "", "onClickListener", "bindAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "getButtonsVisibilityPercents", "()Ljava/lang/Integer;", "Landroid/view/View;", "buttonView", "t", "(Landroid/view/View;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "buttonsContainer", VKApiConst.VERSION, "Landroid/view/View;", "Landroid/view/LayoutInflater;", "u", "Landroid/view/LayoutInflater;", "inflater", "view", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ContactsViewImpl extends BaseViewHolder implements ContactsView {
    public final Context s;
    public final LinearLayout t;
    public final LayoutInflater u;
    public View v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContactsViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        this.s = context;
        this.t = (LinearLayout) view.findViewById(R.id.contact_bar_buttons_container);
        this.u = LayoutInflater.from(context);
    }

    @Override // com.avito.android.developments_catalog.items.contactbar.ContactsView
    public void bindAction(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "onClickListener");
        LinearLayout linearLayout = this.t;
        if (linearLayout == null || linearLayout.getChildCount() != 0) {
            View view = this.v;
            if (view != null) {
                t(view, str, function0);
                return;
            }
            return;
        }
        View inflate = this.u.inflate(R.layout.advert_details_contact_bar_button, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "buttonView");
        t(inflate, str, function0);
        this.v = inflate;
        this.t.addView(this.v, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // com.avito.android.developments_catalog.items.contactbar.ContactsView
    @Nullable
    public Integer getButtonsVisibilityPercents() {
        Rect rect = new Rect();
        View view = this.v;
        int i = 0;
        if (view != null && view.getHeight() > 0) {
            view.getGlobalVisibleRect(rect);
            i = (int) ((((rect.top < 0 || rect.bottom < 0) ? 0.0f : (float) rect.height()) / ((float) view.getHeight())) * ((float) 100));
        }
        return Integer.valueOf(i);
    }

    public final void t(View view, String str, Function0<Unit> function0) {
        View findViewById = view.findViewById(R.id.button_container);
        if (findViewById != null) {
            view = findViewById;
        }
        Views.setBackgroundCompat(view, R.drawable.bg_btn_flat_rds_green);
        view.setOnClickListener(new a(function0));
        View findViewById2 = view.findViewById(R.id.button_text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        textView.setText(str);
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorByAttr = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.constantWhite);
        Drawable drawable = this.s.getDrawable(R.drawable.ic_rds_call_20);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable != null ? DrawablesKt.wrapForTinting(drawable, colorByAttr) : null, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
