package com.avito.android.messenger.conversation.adapter;

import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageViewDateDelegate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "", Sort.DATE, "", "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "timeView", AuthSource.BOOKING_ORDER, "dateView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageViewDateDelegate implements MessageViewDate {
    public final TextView a;
    public final TextView b;

    public MessageViewDateDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextView) view.findViewById(R.id.message_date);
        this.b = (TextView) view.findViewById(R.id.message_date_divider);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
    public void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Sort.DATE);
        TextView textView = this.b;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
    public void setTime(@Nullable String str) {
        TextView textView = this.a;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }
}
