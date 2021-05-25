package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CARD, "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;", "chatMessageClickListener", "", "isNextMessageFromAnotherGroup", "", "bind", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatMessageClickListener;Z)V", "animationWaiting", "()V", "Lru/sravni/android/bankproduct/databinding/ChatMessageUserItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/ChatMessageUserItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/ChatMessageUserItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageUserViewHolder extends RecyclerView.ViewHolder {
    public final ChatMessageUserItemSravniBinding s;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ViewHolderMessageStatusEnum.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            ViewHolderMessageStatusEnum viewHolderMessageStatusEnum = ViewHolderMessageStatusEnum.WAITING;
            iArr[0] = 1;
            ViewHolderMessageStatusEnum viewHolderMessageStatusEnum2 = ViewHolderMessageStatusEnum.ERROR;
            iArr[3] = 2;
            ViewHolderMessageStatusEnum viewHolderMessageStatusEnum3 = ViewHolderMessageStatusEnum.ALLOW_EDIT;
            iArr[2] = 3;
            ViewHolderMessageStatusEnum viewHolderMessageStatusEnum4 = ViewHolderMessageStatusEnum.SUCCESS;
            iArr[1] = 4;
            ViewHolderMessageStatusEnum.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[3] = 1;
            iArr2[0] = 2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageUserViewHolder(@NotNull ChatMessageUserItemSravniBinding chatMessageUserItemSravniBinding) {
        super(chatMessageUserItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(chatMessageUserItemSravniBinding, "itemBinding");
        this.s = chatMessageUserItemSravniBinding;
    }

    public final void animationWaiting() {
        ChatViewCard chatViewCard;
        ImageView imageView = this.s.ivWaitingAnimation;
        Intrinsics.checkExpressionValueIsNotNull(imageView, "itemBinding.ivWaitingAnimation");
        Animation loadAnimation = AnimationUtils.loadAnimation(imageView.getContext(), R.anim.pulsation_sravni);
        UserMessageItemDescription messageDescription = this.s.getMessageDescription();
        if (((messageDescription == null || (chatViewCard = messageDescription.getChatViewCard()) == null) ? null : chatViewCard.getStatus()) == ViewHolderMessageStatusEnum.WAITING) {
            ImageView imageView2 = this.s.ivWaitingAnimation;
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "itemBinding.ivWaitingAnimation");
            imageView2.setVisibility(0);
            this.s.ivWaitingAnimation.startAnimation(loadAnimation);
            return;
        }
        ImageView imageView3 = this.s.ivWaitingAnimation;
        Intrinsics.checkExpressionValueIsNotNull(imageView3, "itemBinding.ivWaitingAnimation");
        imageView3.setVisibility(8);
        this.s.ivWaitingAnimation.clearAnimation();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bind(@org.jetbrains.annotations.NotNull ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatViewCard r10, @org.jetbrains.annotations.NotNull ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatMessageClickListener r11, boolean r12) {
        /*
            r9 = this;
            java.lang.String r0 = "card"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "chatMessageClickListener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum r0 = r10.getStatus()
            int r0 = r0.ordinal()
            r1 = 3
            r2 = 1
            if (r0 == 0) goto L_0x0030
            if (r0 == r2) goto L_0x0029
            r3 = 2
            if (r0 == r3) goto L_0x0026
            if (r0 != r1) goto L_0x0020
            int r0 = ru.sravni.android.bankproduct.R.drawable.ic_message_error_sravni
            goto L_0x0032
        L_0x0020:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x0026:
            int r0 = ru.sravni.android.bankproduct.R.drawable.ic_message_edit_sravni
            goto L_0x0032
        L_0x0029:
            r0 = 17170445(0x106000d, float:2.461195E-38)
            r5 = 17170445(0x106000d, float:2.461195E-38)
            goto L_0x0033
        L_0x0030:
            int r0 = ru.sravni.android.bankproduct.R.drawable.ic_message_sending_sravni
        L_0x0032:
            r5 = r0
        L_0x0033:
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum r0 = r10.getStatus()
            int r0 = r0.ordinal()
            r3 = 0
            if (r0 == 0) goto L_0x0047
            if (r0 == r1) goto L_0x0045
            r0 = 8
            r6 = 8
            goto L_0x0049
        L_0x0045:
            r6 = 0
            goto L_0x0049
        L_0x0047:
            r0 = 4
            r6 = 4
        L_0x0049:
            ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBinding r0 = r9.s
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.UserMessageItemDescription r1 = new ru.sravni.android.bankproduct.presentation.chat.adapter.message.UserMessageItemDescription
            if (r12 == 0) goto L_0x0061
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum r12 = r10.getStatus()
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum r4 = ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum.SUCCESS
            if (r12 == r4) goto L_0x005f
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum r12 = r10.getStatus()
            ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum r4 = ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum.ALLOW_EDIT
            if (r12 != r4) goto L_0x0061
        L_0x005f:
            r8 = 1
            goto L_0x0062
        L_0x0061:
            r8 = 0
        L_0x0062:
            r3 = r1
            r4 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.setMessageDescription(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageUserViewHolder.bind(ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatViewCard, ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatMessageClickListener, boolean):void");
    }
}
