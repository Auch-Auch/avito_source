package com.avito.android.authorization.login_protection.adapter.not_found;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.authorization.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/avito/android/authorization/login_protection/adapter/not_found/PhoneNotFoundItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/authorization/login_protection/adapter/not_found/PhoneNotFoundItemView;", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneNotFoundItemViewImpl extends BaseViewHolder implements PhoneNotFoundItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNotFoundItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.s = textView;
        TextViews.bindText$default(textView, view.getContext().getString(R.string.tfa_phone_not_found), false, 2, null);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        textView.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48));
    }
}
