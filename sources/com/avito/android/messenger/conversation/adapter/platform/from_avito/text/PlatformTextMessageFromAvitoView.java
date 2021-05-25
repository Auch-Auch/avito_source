package com.avito.android.messenger.conversation.adapter.platform.from_avito.text;

import android.content.Context;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.MessageViewAvatar;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewDateDelegate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.PlatformMessageViewFromAvitoAvatarDelegate;
import com.avito.android.messenger.conversation.adapter.platform.LinkArrowKeyMovementMethod;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMargins;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMarginsDelegate;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessageView;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "", "charSequence", "Landroid/widget/TextView$BufferType;", "bufferType", "", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "stringResId", "(I)V", "Landroid/view/ActionMode$Callback;", "callback", "setActionModeCallback", "(Landroid/view/ActionMode$Callback;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformTextMessageFromAvitoView extends ItemView, IncomingMessageView, MessageViewMargins {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PlatformTextMessageFromAvitoView platformTextMessageFromAvitoView) {
            ItemView.DefaultImpls.onUnbind(platformTextMessageFromAvitoView);
        }

        public static /* synthetic */ void setText$default(PlatformTextMessageFromAvitoView platformTextMessageFromAvitoView, CharSequence charSequence, TextView.BufferType bufferType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bufferType = TextView.BufferType.SPANNABLE;
                }
                platformTextMessageFromAvitoView.setText(charSequence, bufferType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b;\u0010<J!\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\"\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0 H\u0001¢\u0006\u0004\b\"\u0010#J\u0018\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u001e\u0010(\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0 H\u0001¢\u0006\u0004\b(\u0010#J\u001e\u0010)\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020$0 H\u0001¢\u0006\u0004\b)\u0010#J$\u0010,\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001e\u0010:\u001a\n 7*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/text/PlatformTextMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "charSequence", "Landroid/widget/TextView$BufferType;", "bufferType", "", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", "stringResId", "(I)V", "Landroid/view/ActionMode$Callback;", "callback", "setActionModeCallback", "(Landroid/view/ActionMode$Callback;)V", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "show", "showGroupDivider", "(Z)V", "setClickListener", "setLongClickListener", "overrideTopMarginDp", "overrideBottomMarginDp", "overrideMargins", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "textView", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements PlatformTextMessageFromAvitoView, MessageViewDate, MessageViewAvatar, MessageViewGroupDivider, MessageViewClicks, MessageViewMargins {
        public final TextView s;
        public final View t;
        public final /* synthetic */ MessageViewDateDelegate u;
        public final /* synthetic */ PlatformMessageViewFromAvitoAvatarDelegate v;
        public final /* synthetic */ MessageViewGroupDividerDelegate w;
        public final /* synthetic */ MessageViewClicks.DUMMY x = MessageViewClicks.DUMMY.INSTANCE;
        public final /* synthetic */ MessageViewMarginsDelegate y;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.u = new MessageViewDateDelegate(view);
            int i = R.id.messenger_platform_text_bubble_from_avito;
            this.v = new PlatformMessageViewFromAvitoAvatarDelegate(view, i);
            this.w = new MessageViewGroupDividerDelegate(view);
            int i2 = R.id.message;
            this.y = new MessageViewMarginsDelegate(view, i, i2);
            this.t = view;
            TextView textView = (TextView) view.findViewById(i2);
            this.s = textView;
            textView.setTextIsSelectable(true);
            Intrinsics.checkNotNullExpressionValue(textView, "textView");
            textView.setMovementMethod(LinkArrowKeyMovementMethod.Companion.getInstance());
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoView
        @NotNull
        public Context getContext() {
            Context context = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            return context;
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMargins
        public void overrideMargins(@Nullable Integer num, @Nullable Integer num2) {
            this.y.overrideMargins(num, num2);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoView
        public void setActionModeCallback(@NotNull ActionMode.Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            TextView textView = this.s;
            Intrinsics.checkNotNullExpressionValue(textView, "textView");
            textView.setCustomSelectionActionModeCallback(callback);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatar(@Nullable Picture picture) {
            this.v.setAvatar(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
        public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.v.setAvatarClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.x.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.u.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.x.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoView
        public void setText(@Nullable CharSequence charSequence, @NotNull TextView.BufferType bufferType) {
            Intrinsics.checkNotNullParameter(bufferType, "bufferType");
            this.s.setText(charSequence, bufferType);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.u.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.w.showGroupDivider(z);
        }

        @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoView
        public void setText(int i) {
            this.s.setText(i);
        }
    }

    @NotNull
    Context getContext();

    void setActionModeCallback(@NotNull ActionMode.Callback callback);

    void setText(int i);

    void setText(@Nullable CharSequence charSequence, @NotNull TextView.BufferType bufferType);
}
