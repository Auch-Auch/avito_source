package com.avito.android.messenger.conversation.adapter;

import android.view.View;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDividerDelegate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "", "show", "", "showGroupDivider", "(Z)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "", AuthSource.SEND_ABUSE, "I", "dividerSize", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageViewGroupDividerDelegate implements MessageViewGroupDivider {
    public final int a;
    public final View b;

    public MessageViewGroupDividerDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        this.a = view.getResources().getDimensionPixelSize(R.dimen.messenger_message_group_divider);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
    public void showGroupDivider(boolean z) {
        if (z) {
            this.b.setPadding(0, this.a, 0, 0);
        } else {
            this.b.setPadding(0, 0, 0, 0);
        }
    }
}
