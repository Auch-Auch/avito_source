package com.avito.android.messenger.conversation.adapter.unknown;

import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.unknown.UnknownMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/unknown/UnknownMessageView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "title", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UnknownMessageViewDelegate implements UnknownMessageView {
    public final TextView a;

    public UnknownMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextView) view.findViewById(R.id.unknown_message_title);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        UnknownMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.unknown.UnknownMessageView
    public void setTitle(@Nullable String str) {
        TextView textView = this.a;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        TextViews.bindText$default(textView, str, false, 2, null);
    }
}
