package com.avito.android.messenger.conversation.adapter.app_call;

import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u001e\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "actionTitle", "setActionTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", AuthSource.BOOKING_ORDER, "actionTitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class AppCallMessageViewDelegate implements AppCallMessageView {
    public final TextView a;
    public final TextView b;

    public AppCallMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextView) view.findViewById(R.id.app_call_message_text);
        this.b = (TextView) view.findViewById(R.id.app_call_message_action_title);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AppCallMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageView
    public void setActionTitle(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            Views.show(this.b);
            TextView textView = this.b;
            Intrinsics.checkNotNullExpressionValue(textView, "actionTitleView");
            textView.setText(charSequence);
            return;
        }
        Views.hide(this.b);
    }

    @Override // com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        TextView textView = this.a;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setText(charSequence);
    }
}
