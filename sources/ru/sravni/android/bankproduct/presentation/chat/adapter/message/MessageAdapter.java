package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.ChatDocumentItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBinding;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", VKApiConst.POSITION, "getItemViewType", "(I)I", "getItemCount", "()I", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", AuthSource.SEND_ABUSE, "(I)Z", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", "d", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", "chatViewModel", "", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "c", "Ljava/util/List;", "messageList", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<ChatViewCard> c = new ArrayList();
    public final IChatViewModel d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ViewHolderMessageEnum.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            ViewHolderMessageEnum viewHolderMessageEnum = ViewHolderMessageEnum.SRAVNI;
            iArr[0] = 1;
            ViewHolderMessageEnum viewHolderMessageEnum2 = ViewHolderMessageEnum.USER;
            iArr[1] = 2;
            ViewHolderMessageEnum viewHolderMessageEnum3 = ViewHolderMessageEnum.DOCUMENT;
            iArr[2] = 3;
            ViewHolderMessageEnum viewHolderMessageEnum4 = ViewHolderMessageEnum.BOT_FACE;
            iArr[3] = 4;
        }
    }

    public static final class a<T> implements Observer<MessageContainer> {
        public final /* synthetic */ MessageAdapter a;

        public a(MessageAdapter messageAdapter) {
            this.a = messageAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(MessageContainer messageContainer) {
            MessageContainer messageContainer2 = messageContainer;
            if (messageContainer2 != null) {
                boolean isConsistienceCorrect = messageContainer2.isConsistienceCorrect();
                if (!Intrinsics.areEqual(messageContainer2.getSourceMessages(), this.a.c) || !isConsistienceCorrect) {
                    MessageAdapter.access$refillMessages(this.a, messageContainer2);
                    return;
                }
                HashMap hashMap = new HashMap();
                int i = 0;
                for (T t : this.a.c) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    hashMap.put(Integer.valueOf(t.getOrderId()), Integer.valueOf(i));
                    i = i2;
                }
                if (!messageContainer2.getChatDiff().getMutated().isEmpty()) {
                    MessageAdapter.access$mutateMessages(this.a, hashMap, messageContainer2.getChatDiff().getMutated());
                }
                if (!messageContainer2.getChatDiff().getRemoved().isEmpty()) {
                    MessageAdapter.access$removeMessages(this.a, messageContainer2.getChatDiff().getRemoved());
                }
                if (!messageContainer2.getChatDiff().getAddedToEnd().isEmpty()) {
                    MessageAdapter.access$addMessages(this.a, messageContainer2.getChatDiff().getAddedToEnd());
                }
            }
        }
    }

    public MessageAdapter(@NotNull LifecycleOwner lifecycleOwner, @NotNull IChatViewModel iChatViewModel) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkParameterIsNotNull(iChatViewModel, "chatViewModel");
        this.d = iChatViewModel;
        iChatViewModel.getMessagesContainer().observe(lifecycleOwner, new a(this));
    }

    public static final void access$addMessages(MessageAdapter messageAdapter, List list) {
        messageAdapter.c.addAll(list);
        messageAdapter.notifyItemRangeInserted(messageAdapter.c.size() - list.size(), messageAdapter.c.size());
    }

    public static final void access$mutateMessages(MessageAdapter messageAdapter, HashMap hashMap, List list) {
        Objects.requireNonNull(messageAdapter);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChatViewCard chatViewCard = (ChatViewCard) it.next();
            Integer num = (Integer) hashMap.get(Integer.valueOf(chatViewCard.getOrderId()));
            if (num != null) {
                messageAdapter.c.set(num.intValue(), chatViewCard);
                messageAdapter.notifyItemChanged(num.intValue());
            }
        }
    }

    public static final void access$refillMessages(MessageAdapter messageAdapter, MessageContainer messageContainer) {
        Objects.requireNonNull(messageAdapter);
        List<ChatViewCard> resultMessages = messageContainer.getResultMessages();
        messageAdapter.c.clear();
        messageAdapter.c.addAll(resultMessages);
        messageAdapter.notifyDataSetChanged();
    }

    public static final void access$removeMessages(MessageAdapter messageAdapter, List list) {
        Objects.requireNonNull(messageAdapter);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            Iterator<ChatViewCard> it2 = messageAdapter.c.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                if (it2.next().getOrderId() == intValue) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                messageAdapter.c.remove(i);
                messageAdapter.notifyItemRemoved(i);
            }
        }
    }

    public final boolean a(int i) {
        return i == this.c.size() - 1 || this.c.get(i).getType() != this.c.get(i + 1).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int ordinal = this.c.get(i).getType().ordinal();
        if (ordinal == 0) {
            return ViewHolderMessageEnum.SRAVNI.getValue();
        }
        if (ordinal == 1) {
            return ViewHolderMessageEnum.USER.getValue();
        }
        if (ordinal == 2) {
            return ViewHolderMessageEnum.DOCUMENT.getValue();
        }
        if (ordinal == 3) {
            return ViewHolderMessageEnum.BOT_FACE.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        MessageUserViewHolder messageUserViewHolder = (MessageUserViewHolder) (!(viewHolder instanceof MessageUserViewHolder) ? null : viewHolder);
        if (messageUserViewHolder != null) {
            messageUserViewHolder.bind(this.c.get(i), this.d, a(i));
        }
        MessageSravniViewHolder messageSravniViewHolder = (MessageSravniViewHolder) (!(viewHolder instanceof MessageSravniViewHolder) ? null : viewHolder);
        if (messageSravniViewHolder != null) {
            messageSravniViewHolder.bind(this.c.get(i), a(i));
        }
        if (!(viewHolder instanceof MessageDocumentViewHolder)) {
            viewHolder = null;
        }
        MessageDocumentViewHolder messageDocumentViewHolder = (MessageDocumentViewHolder) viewHolder;
        if (messageDocumentViewHolder != null) {
            messageDocumentViewHolder.bindMessageFields(this.c.get(i).getMessageViewCard());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == ViewHolderMessageEnum.SRAVNI.getValue()) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.chat_message_sravni_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…lse\n                    )");
            return new MessageSravniViewHolder((ChatMessageSravniItemSravniBinding) inflate);
        } else if (i == ViewHolderMessageEnum.USER.getValue()) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.chat_message_user_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…lse\n                    )");
            return new MessageUserViewHolder((ChatMessageUserItemSravniBinding) inflate2);
        } else if (i == ViewHolderMessageEnum.DOCUMENT.getValue()) {
            ChatDocumentItemSravniBinding chatDocumentItemSravniBinding = (ChatDocumentItemSravniBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.chat_document_item_sravni, viewGroup, false);
            MessageItemAdapter messageItemAdapter = new MessageItemAdapter();
            RecyclerView recyclerView = chatDocumentItemSravniBinding.rvDocumentItem;
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "viewBinding.rvDocumentItem");
            recyclerView.setAdapter(messageItemAdapter);
            Intrinsics.checkExpressionValueIsNotNull(chatDocumentItemSravniBinding, "viewBinding");
            return new MessageDocumentViewHolder(messageItemAdapter, chatDocumentItemSravniBinding);
        } else if (i != ViewHolderMessageEnum.BOT_FACE.getValue()) {
            return new RecyclerView.ViewHolder(viewGroup, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_stub_item_sravni, viewGroup, false)) { // from class: ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageAdapter$onCreateViewHolder$1
                public final /* synthetic */ ViewGroup s;

                {
                    this.s = r1;
                }
            };
        } else {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_face_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "LayoutInflater\n         …em_sravni, parent, false)");
            return new FaceBotViewHolder(inflate3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        if (!(viewHolder instanceof MessageUserViewHolder)) {
            viewHolder = null;
        }
        MessageUserViewHolder messageUserViewHolder = (MessageUserViewHolder) viewHolder;
        if (messageUserViewHolder != null) {
            messageUserViewHolder.animationWaiting();
        }
    }
}
