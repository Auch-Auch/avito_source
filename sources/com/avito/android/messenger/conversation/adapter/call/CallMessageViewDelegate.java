package com.avito.android.messenger.conversation.adapter.call;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.call.CallMessageView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/call/CallMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/call/CallMessageView;", "", "textResId", "", "setText", "(I)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CallMessageViewDelegate implements CallMessageView {
    public final TextView a;

    public CallMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextView) view.findViewById(R.id.call_message_text);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CallMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.call.CallMessageView
    public void setText(@StringRes int i) {
        this.a.setText(i);
    }
}
