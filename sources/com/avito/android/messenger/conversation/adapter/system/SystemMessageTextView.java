package com.avito.android.messenger.conversation.adapter.system;

import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/system/SystemMessageTextView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "", "value", "", "setText", "(Ljava/lang/String;)V", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SystemMessageTextView extends ItemView, MessageViewDate {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SystemMessageTextView systemMessageTextView) {
            ItemView.DefaultImpls.onUnbind(systemMessageTextView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\n\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/system/SystemMessageTextView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/system/SystemMessageTextView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setText", "(Ljava/lang/String;)V", Sort.DATE, "setDate", "setTime", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "text", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements SystemMessageTextView, MessageViewDate {
        public final TextView s;
        public final /* synthetic */ MessageViewDateDelegate t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = new MessageViewDateDelegate(view);
            View findViewById = view.findViewById(R.id.message);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message)");
            this.s = (TextView) findViewById;
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.t.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.system.SystemMessageTextView
        public void setText(@Nullable String str) {
            TextViews.bindText$default(this.s, str, false, 2, null);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.t.setTime(str);
        }
    }

    void setText(@Nullable String str);
}
