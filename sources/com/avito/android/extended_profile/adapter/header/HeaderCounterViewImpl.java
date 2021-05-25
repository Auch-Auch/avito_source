package com.avito.android.extended_profile.adapter.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.extended_profile.R;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderCounterViewImpl;", "Lcom/avito/android/extended_profile/adapter/header/HeaderCounterView;", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "counter", "", "bindCounter", "(Lcom/avito/android/public_profile/remote/model/ProfileCounter;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "container", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "subtitleView", AuthSource.BOOKING_ORDER, "titleView", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderCounterViewImpl implements HeaderCounterView {
    public final ViewGroup a;
    public final TextView b;
    public final TextView c;
    public final View d;

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

    public HeaderCounterViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.counter_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.a = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.counter_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.counter_subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderCounterView
    public void bindCounter(@Nullable ProfileCounter profileCounter) {
        if (profileCounter == null) {
            Views.hide(this.d);
            return;
        }
        TextViews.bindText$default(this.b, profileCounter.getTitle(), false, 2, null);
        TextViews.bindText$default(this.c, profileCounter.getSubtitle(), false, 2, null);
        Views.show(this.d);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderCounterView
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.d.setEnabled(function0 != null);
        if (function0 != null) {
            TextView textView = this.c;
            Context context = this.d.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            textView.setTextColor(Contexts.getColorStateListCompat(context, com.avito.android.public_profile_stuff.R.color.text_color_blue));
            TextView textView2 = this.b;
            Context context2 = this.d.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            textView2.setTextColor(Contexts.getColorStateListCompat(context2, com.avito.android.public_profile_stuff.R.color.text_color_black));
            this.a.setOnClickListener(new a(function0));
            return;
        }
        TextView textView3 = this.c;
        Context context3 = this.d.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        int i = com.avito.android.lib.design.R.attr.black;
        textView3.setTextColor(Contexts.getColorByAttr(context3, i));
        TextView textView4 = this.b;
        Context context4 = this.d.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "view.context");
        textView4.setTextColor(Contexts.getColorByAttr(context4, i));
        this.a.setOnClickListener(null);
    }
}
