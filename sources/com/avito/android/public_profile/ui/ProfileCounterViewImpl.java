package com.avito.android.public_profile.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile_stuff.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/public_profile/ui/ProfileCounterViewImpl;", "Lcom/avito/android/public_profile/ui/ProfileCounterView;", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "counter", "", "bindCounter", "(Lcom/avito/android/public_profile/remote/model/ProfileCounter;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "subtitleView", AuthSource.BOOKING_ORDER, "titleView", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileCounterViewImpl implements ProfileCounterView {
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

    public ProfileCounterViewImpl(@NotNull View view) {
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

    @Override // com.avito.android.public_profile.ui.ProfileCounterView
    public void bindCounter(@Nullable ProfileCounter profileCounter) {
        if (profileCounter == null) {
            Views.hide(this.d);
            return;
        }
        TextViews.bindText$default(this.b, profileCounter.getTitle(), false, 2, null);
        TextViews.bindText$default(this.c, profileCounter.getSubtitle(), false, 2, null);
        Views.show(this.d);
    }

    @Override // com.avito.android.public_profile.ui.ProfileCounterView
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.d.setEnabled(function0 != null);
        if (function0 != null) {
            this.c.setTextColor(ContextCompat.getColorStateList(this.d.getContext(), R.color.text_color_blue));
            this.b.setTextColor(ContextCompat.getColorStateList(this.d.getContext(), R.color.text_color_black));
            this.a.setOnClickListener(new a(function0));
            return;
        }
        TextView textView = this.c;
        Context context = this.d.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int i = com.avito.android.lib.design.R.attr.black;
        textView.setTextColor(Contexts.getColorByAttr(context, i));
        TextView textView2 = this.b;
        Context context2 = this.d.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        textView2.setTextColor(Contexts.getColorByAttr(context2, i));
        this.a.setOnClickListener(null);
    }
}
