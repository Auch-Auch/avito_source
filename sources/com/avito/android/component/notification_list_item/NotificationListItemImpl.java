package com.avito.android.component.notification_list_item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.ui_components.R;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001e\u001a\n \u0013*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u001e\u0010 \u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006#"}, d2 = {"Lcom/avito/android/component/notification_list_item/NotificationListItemImpl;", "Lcom/avito/android/component/notification_list_item/NotificationListItem;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", Sort.DATE, "setDate", "showIndicator", "()V", "hideIndicator", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "d", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "e", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "descriptionView", "c", "indicatorView", AuthSource.SEND_ABUSE, "dateView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationListItemImpl implements NotificationListItem {
    public final TextView a;
    public final TextView b;
    public final View c;
    public final TextView d;
    public final View e;

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

    public NotificationListItemImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        this.a = (TextView) view.findViewById(R.id.date);
        this.b = (TextView) view.findViewById(R.id.description);
        this.c = view.findViewById(R.id.indicator);
        this.d = (TextView) view.findViewById(R.id.title);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void hideIndicator() {
        TextView textView = this.b;
        Intrinsics.checkNotNullExpressionValue(textView, "descriptionView");
        TextView textView2 = this.b;
        Intrinsics.checkNotNullExpressionValue(textView2, "descriptionView");
        Context context = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "descriptionView.context");
        textView.setTypeface(Typefaces.getTypeface(context, TypefaceType.Regular));
        Views.conceal(this.c);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.e.setOnClickListener(null);
        } else {
            this.e.setOnClickListener(new a(function0));
        }
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Sort.DATE);
        TextView textView = this.a;
        Intrinsics.checkNotNullExpressionValue(textView, "dateView");
        textView.setText(str);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextView textView = this.b;
        Intrinsics.checkNotNullExpressionValue(textView, "descriptionView");
        textView.setText(str);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.d;
        Intrinsics.checkNotNullExpressionValue(textView, "titleView");
        textView.setText(str);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void showIndicator() {
        TextView textView = this.b;
        Intrinsics.checkNotNullExpressionValue(textView, "descriptionView");
        TextView textView2 = this.b;
        Intrinsics.checkNotNullExpressionValue(textView2, "descriptionView");
        Context context = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "descriptionView.context");
        textView.setTypeface(Typefaces.getTypeface(context, TypefaceType.Bold));
        Views.show(this.c);
    }
}
