package com.avito.android.messenger.channels.mvi.view;

import a2.a.a.o1.b.b.e.b;
import a2.a.a.o1.b.b.e.c;
import a2.g.r.g;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.presenter.MessagePreview;
import com.avito.android.messenger.channels.mvi.view.ChannelListItem;
import com.avito.android.messenger.widget.chat_list_element.ChatListElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.vk.sdk.api.VKApiConst;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rambler.libs.swipe_layout.SwipeLayout;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0001\u0001Bq\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\u001a\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020\u001a\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\u00112\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0014\u001a\u00020\u00112\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\u001a2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0016H\b¢\u0006\u0004\b,\u0010-J\u001b\u0010/\u001a\u00020\u001a2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b/\u00100R\u001b\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010@\u001a\u0002098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0019\u0010*\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b*\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030K8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0019\u0010#\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010B\u001a\u0004\b#\u0010CR\u0019\u0010\u001c\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010\u0018R(\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00110Z8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0019\u0010)\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR(\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001b\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bq\u0010X\u001a\u0004\br\u0010\u0018R=\u0010w\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020\u00160s8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u0010\u0001R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\r\n\u0005\b\u0001\u0010B\u001a\u0004\b\u001b\u0010C¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem;", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ViewHolder;", "", "getLayoutRes", "()I", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ViewHolder;ILjava/util/List;)V", "unbindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ViewHolder;I)V", "", "toString", "()Ljava/lang/String;", "id", "", "isActive", "chatTitle", "Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ItemInfo;", "item", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "featureImage", "", Sort.DATE, "isOnline", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "lastMessageType", "Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "lastMessage", "isTyping", "itemDeliveryStatus", "copy", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ItemInfo;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;JZLcom/avito/android/image_loader/Picture;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;ZLjava/lang/String;)Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem;", "other", "contentEquals", "(Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;)Z", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/image_loader/Picture;", "getAvatar", "()Lcom/avito/android/image_loader/Picture;", "j", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "getFeatureImage", "()Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "Landroid/view/View$OnLongClickListener;", "f", "Landroid/view/View$OnLongClickListener;", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "longClickListener", "p", "Z", "()Z", "Landroid/view/View$OnClickListener;", "deleteClickListener", "Landroid/view/View$OnClickListener;", "getDeleteClickListener", "()Landroid/view/View$OnClickListener;", "setDeleteClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroidx/lifecycle/MutableLiveData;", "hideSwipeViewsStream", "Landroidx/lifecycle/MutableLiveData;", "getHideSwipeViewsStream", "()Landroidx/lifecycle/MutableLiveData;", "setHideSwipeViewsStream", "(Landroidx/lifecycle/MutableLiveData;)V", "k", "J", "getDate", "()J", "l", "h", "Ljava/lang/String;", "getChatTitle", "Lkotlin/Function0;", "itemClickListener", "Lkotlin/jvm/functions/Function0;", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "n", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "getLastMessageType", "()Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "o", "Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "getLastMessage", "()Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "getLifecycleOwner", "()Ljava/lang/ref/WeakReference;", "setLifecycleOwner", "(Ljava/lang/ref/WeakReference;)V", VKApiConst.Q, "getItemDeliveryStatus", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateMillis", "dateFormatter", "Lkotlin/jvm/functions/Function1;", "getDateFormatter", "()Lkotlin/jvm/functions/Function1;", "setDateFormatter", "(Lkotlin/jvm/functions/Function1;)V", "i", "Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ItemInfo;", "getItem", "()Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ItemInfo;", g.a, "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ItemInfo;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;JZLcom/avito/android/image_loader/Picture;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;ZLjava/lang/String;)V", "ItemInfo", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelListItem extends AbstractListItem<ViewHolder> {
    public Function1<? super Long, String> dateFormatter;
    public View.OnClickListener deleteClickListener;
    @NotNull
    public View.OnLongClickListener f;
    public final boolean g;
    @NotNull
    public final String h;
    public MutableLiveData<Integer> hideSwipeViewsStream;
    @Nullable
    public final ItemInfo i;
    public Function0<Unit> itemClickListener;
    @NotNull
    public final ChatListElement.FeatureImage j;
    public final long k;
    public final boolean l;
    public WeakReference<LifecycleOwner> lifecycleOwner;
    @Nullable
    public final Picture m;
    @NotNull
    public final ChatListElement.LastMessageType n;
    @NotNull
    public final MessagePreview o;
    public final boolean p;
    @Nullable
    public final String q;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ItemInfo;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "price", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemInfo {
        @NotNull
        public final String a;
        @Nullable
        public final String b;

        public ItemInfo(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = str;
            this.b = str2;
        }

        @Nullable
        public final String getPrice() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010&\u001a\u00020!\u0012\n\u0010(\u001a\u0006\u0012\u0002\b\u00030'¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u00020\u00058F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u00020\u000b8F@\u0006X\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020!8F@\u0006X\u0002¢\u0006\f\n\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "", "animateOpenSwipeView", "()V", "", "y", "Lkotlin/Lazy;", "getHash", "()I", "hash", "Lru/rambler/libs/swipe_layout/SwipeLayout;", "x", "getSwipeLayout", "()Lru/rambler/libs/swipe_layout/SwipeLayout;", "swipeLayout", "Ljava/lang/ref/WeakReference;", "Landroid/animation/ObjectAnimator;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/ref/WeakReference;", "animatorReference", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "w", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "getElement", "()Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "element", "Landroidx/lifecycle/Observer;", "B", "Landroidx/lifecycle/Observer;", "getHideSwipeViewsStreamObserver", "()Landroidx/lifecycle/Observer;", "hideSwipeViewsStreamObserver", "Landroid/view/View;", "z", "getDeleteView", "()Landroid/view/View;", "deleteView", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends FlexibleViewHolder {
        public WeakReference<ObjectAnimator> A;
        @NotNull
        public final Observer<Integer> B;
        @NotNull
        public final ChatListElement w;
        @NotNull
        public final Lazy x;
        @NotNull
        public final Lazy y = t6.c.lazy(new b(this));
        @NotNull
        public final Lazy z;

        public static final class a extends Lambda implements Function0<View> {
            public final /* synthetic */ View a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(View view) {
                super(0);
                this.a = view;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public View invoke() {
                return this.a.findViewById(R.id.chat_list_element_right_view);
            }
        }

        public static final class b extends Lambda implements Function0<Integer> {
            public final /* synthetic */ ViewHolder a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ViewHolder viewHolder) {
                super(0);
                this.a = viewHolder;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Integer invoke() {
                return Integer.valueOf(this.a.getSwipeLayout().hashCode());
            }
        }

        public static final class c<T> implements Observer<Integer> {
            public final /* synthetic */ ViewHolder a;

            public c(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // androidx.lifecycle.Observer
            public void onChanged(Integer num) {
                Integer num2 = num;
                int hash = this.a.getHash();
                if ((num2 == null || hash != num2.intValue()) && this.a.getSwipeLayout().getOffset() != 0) {
                    ViewHolder viewHolder = this.a;
                    ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.A.get();
                    if (objectAnimator != null) {
                        viewHolder.A.clear();
                        if (objectAnimator.isRunning()) {
                            objectAnimator.end();
                        }
                    }
                    ObjectAnimator objectAnimator2 = new ObjectAnimator();
                    objectAnimator2.setTarget(viewHolder.getSwipeLayout());
                    objectAnimator2.setPropertyName("offset");
                    objectAnimator2.setInterpolator(new AccelerateInterpolator());
                    objectAnimator2.setIntValues(viewHolder.getSwipeLayout().getOffset(), 0);
                    objectAnimator2.setDuration(200L);
                    objectAnimator2.start();
                    viewHolder.A = new WeakReference(objectAnimator2);
                }
            }
        }

        public static final class d extends Lambda implements Function0<SwipeLayout> {
            public final /* synthetic */ View a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(View view) {
                super(0);
                this.a = view;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public SwipeLayout invoke() {
                return (SwipeLayout) this.a.findViewById(R.id.swipe_layout);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(view, flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            ChatListElement.Companion companion = ChatListElement.Companion;
            View findViewById = view.findViewById(R.id.chat_list_element);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.chat_list_element)");
            this.w = ChatListElement.Companion.create$default(companion, findViewById, false, 2, null);
            this.x = t6.c.lazy(new d(view));
            this.z = t6.c.lazy(new a(view));
            this.A = new WeakReference<>(null);
            this.B = new c(this);
        }

        public static final void access$animateCloseSwipeView(ViewHolder viewHolder) {
            Objects.requireNonNull(viewHolder);
            ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.A.get();
            if (objectAnimator != null) {
                viewHolder.A.clear();
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                }
            }
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setTarget(viewHolder.getSwipeLayout());
            objectAnimator2.setPropertyName("offset");
            objectAnimator2.setInterpolator(new AccelerateInterpolator());
            objectAnimator2.setIntValues(viewHolder.getSwipeLayout().getOffset(), 0);
            objectAnimator2.setDuration(200L);
            objectAnimator2.start();
            Unit unit = Unit.INSTANCE;
            viewHolder.A = new WeakReference(objectAnimator2);
        }

        public static final void access$animateSwipeViewOffset(ViewHolder viewHolder, int i) {
            Objects.requireNonNull(viewHolder);
            ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.A.get();
            if (objectAnimator != null) {
                viewHolder.A.clear();
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                }
            }
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setTarget(viewHolder.getSwipeLayout());
            objectAnimator2.setPropertyName("offset");
            objectAnimator2.setInterpolator(new AccelerateInterpolator());
            objectAnimator2.setIntValues(viewHolder.getSwipeLayout().getOffset(), i);
            objectAnimator2.setDuration(200L);
            objectAnimator2.start();
            Unit unit = Unit.INSTANCE;
            viewHolder.A = new WeakReference(objectAnimator2);
        }

        public static final void access$finishAnimator(ViewHolder viewHolder) {
            Objects.requireNonNull(viewHolder);
            ObjectAnimator objectAnimator = (ObjectAnimator) viewHolder.A.get();
            if (objectAnimator != null) {
                viewHolder.A.clear();
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                }
            }
        }

        public final void animateOpenSwipeView() {
            int i = -getDeleteView().getWidth();
            ObjectAnimator objectAnimator = (ObjectAnimator) this.A.get();
            if (objectAnimator != null) {
                this.A.clear();
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                }
            }
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setTarget(getSwipeLayout());
            objectAnimator2.setPropertyName("offset");
            objectAnimator2.setInterpolator(new AccelerateInterpolator());
            objectAnimator2.setIntValues(getSwipeLayout().getOffset(), i);
            objectAnimator2.setDuration(200L);
            objectAnimator2.start();
            Unit unit = Unit.INSTANCE;
            this.A = new WeakReference(objectAnimator2);
        }

        @NotNull
        public final View getDeleteView() {
            return (View) this.z.getValue();
        }

        @NotNull
        public final ChatListElement getElement() {
            return this.w;
        }

        public final int getHash() {
            return ((Number) this.y.getValue()).intValue();
        }

        @NotNull
        public final Observer<Integer> getHideSwipeViewsStreamObserver() {
            return this.B;
        }

        @NotNull
        public final SwipeLayout getSwipeLayout() {
            return (SwipeLayout) this.x.getValue();
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelListItem(String str, boolean z, String str2, ItemInfo itemInfo, ChatListElement.FeatureImage featureImage, long j2, boolean z2, Picture picture, ChatListElement.LastMessageType lastMessageType, MessagePreview messagePreview, boolean z3, String str3, int i2, j jVar) {
        this(str, z, str2, itemInfo, featureImage, j2, z2, picture, lastMessageType, messagePreview, z3, (i2 & 2048) != 0 ? null : str3);
    }

    public static /* synthetic */ ChannelListItem copy$default(ChannelListItem channelListItem, String str, boolean z, String str2, ItemInfo itemInfo, ChatListElement.FeatureImage featureImage, long j2, boolean z2, Picture picture, ChatListElement.LastMessageType lastMessageType, MessagePreview messagePreview, boolean z3, String str3, int i2, Object obj) {
        String str4 = (i2 & 1) != 0 ? channelListItem.id : str;
        boolean isActive = (i2 & 2) != 0 ? channelListItem.isActive() : z;
        String chatTitle = (i2 & 4) != 0 ? channelListItem.getChatTitle() : str2;
        ItemInfo item = (i2 & 8) != 0 ? channelListItem.getItem() : itemInfo;
        ChatListElement.FeatureImage featureImage2 = (i2 & 16) != 0 ? channelListItem.getFeatureImage() : featureImage;
        long date = (i2 & 32) != 0 ? channelListItem.getDate() : j2;
        boolean isOnline = (i2 & 64) != 0 ? channelListItem.isOnline() : z2;
        Picture avatar = (i2 & 128) != 0 ? channelListItem.getAvatar() : picture;
        ChatListElement.LastMessageType lastMessageType2 = (i2 & 256) != 0 ? channelListItem.getLastMessageType() : lastMessageType;
        MessagePreview lastMessage = (i2 & 512) != 0 ? channelListItem.getLastMessage() : messagePreview;
        boolean isTyping = (i2 & 1024) != 0 ? channelListItem.isTyping() : z3;
        String itemDeliveryStatus = (i2 & 2048) != 0 ? channelListItem.getItemDeliveryStatus() : str3;
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(chatTitle, "chatTitle");
        Intrinsics.checkNotNullParameter(featureImage2, "featureImage");
        Intrinsics.checkNotNullParameter(lastMessageType2, "lastMessageType");
        Intrinsics.checkNotNullParameter(lastMessage, "lastMessage");
        return new ChannelListItem(str4, isActive, chatTitle, item, featureImage2, date, isOnline, avatar, lastMessageType2, lastMessage, isTyping, itemDeliveryStatus);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i2, List list) {
        bindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i2, (List<? extends Object>) list);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem
    public boolean contentEquals(@NotNull AbstractListItem<?> abstractListItem) {
        Intrinsics.checkNotNullParameter(abstractListItem, "other");
        if (this == abstractListItem) {
            return true;
        }
        if (!(abstractListItem instanceof ChannelListItem) || !super.equals(abstractListItem)) {
            return false;
        }
        ChannelListItem channelListItem = (ChannelListItem) abstractListItem;
        return this.g == channelListItem.g && !(Intrinsics.areEqual(this.h, channelListItem.h) ^ true) && !(Intrinsics.areEqual(this.i, channelListItem.i) ^ true) && !(Intrinsics.areEqual(this.j, channelListItem.j) ^ true) && this.k == channelListItem.k && this.l == channelListItem.l && !(Intrinsics.areEqual(this.m, channelListItem.m) ^ true) && this.n == channelListItem.n && !(Intrinsics.areEqual(this.o, channelListItem.o) ^ true) && this.p == channelListItem.p && !(Intrinsics.areEqual(this.q, channelListItem.q) ^ true);
    }

    @NotNull
    public final ChannelListItem copy(@NotNull String str, boolean z, @NotNull String str2, @Nullable ItemInfo itemInfo, @NotNull ChatListElement.FeatureImage featureImage, long j2, boolean z2, @Nullable Picture picture, @NotNull ChatListElement.LastMessageType lastMessageType, @NotNull MessagePreview messagePreview, boolean z3, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "chatTitle");
        Intrinsics.checkNotNullParameter(featureImage, "featureImage");
        Intrinsics.checkNotNullParameter(lastMessageType, "lastMessageType");
        Intrinsics.checkNotNullParameter(messagePreview, "lastMessage");
        return new ChannelListItem(str, z, str2, itemInfo, featureImage, j2, z2, picture, lastMessageType, messagePreview, z3, str3);
    }

    @Nullable
    public final Picture getAvatar() {
        return this.m;
    }

    @NotNull
    public final String getChatTitle() {
        return this.h;
    }

    public final long getDate() {
        return this.k;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.String>, kotlin.jvm.functions.Function1<java.lang.Long, java.lang.String> */
    @NotNull
    public final Function1<Long, String> getDateFormatter() {
        Function1 function1 = this.dateFormatter;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateFormatter");
        }
        return function1;
    }

    @NotNull
    public final View.OnClickListener getDeleteClickListener() {
        View.OnClickListener onClickListener = this.deleteClickListener;
        if (onClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteClickListener");
        }
        return onClickListener;
    }

    @NotNull
    public final ChatListElement.FeatureImage getFeatureImage() {
        return this.j;
    }

    @NotNull
    public final MutableLiveData<Integer> getHideSwipeViewsStream() {
        MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
        }
        return mutableLiveData;
    }

    @Nullable
    public final ItemInfo getItem() {
        return this.i;
    }

    @NotNull
    public final Function0<Unit> getItemClickListener() {
        Function0<Unit> function0 = this.itemClickListener;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemClickListener");
        }
        return function0;
    }

    @Nullable
    public final String getItemDeliveryStatus() {
        return this.q;
    }

    @NotNull
    public final MessagePreview getLastMessage() {
        return this.o;
    }

    @NotNull
    public final ChatListElement.LastMessageType getLastMessageType() {
        return this.n;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_element_swipable;
    }

    @NotNull
    public final WeakReference<LifecycleOwner> getLifecycleOwner() {
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        return weakReference;
    }

    @NotNull
    public final View.OnLongClickListener getLongClickListener() {
        return this.f;
    }

    public final boolean isActive() {
        return this.g;
    }

    public final boolean isOnline() {
        return this.l;
    }

    public final boolean isTyping() {
        return this.p;
    }

    public final void setDateFormatter(@NotNull Function1<? super Long, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.dateFormatter = function1;
    }

    public final void setDeleteClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
        this.deleteClickListener = onClickListener;
    }

    public final void setHideSwipeViewsStream(@NotNull MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.hideSwipeViewsStream = mutableLiveData;
    }

    public final void setItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.itemClickListener = function0;
    }

    public final void setLifecycleOwner(@NotNull WeakReference<LifecycleOwner> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.lifecycleOwner = weakReference;
    }

    public final void setLongClickListener(@NotNull View.OnLongClickListener onLongClickListener) {
        Intrinsics.checkNotNullParameter(onLongClickListener, "<set-?>");
        this.f = onLongClickListener;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ChannelListItem#");
        String str = this.id;
        int coerceAtMost = e.coerceAtMost(6, str.length());
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L.append(substring);
        L.append(" { chatTitle = ");
        return a2.b.a.a.a.t(L, this.h, " }");
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void unbindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i2) {
        unbindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelListItem(@NotNull String str, boolean z, @NotNull String str2, @Nullable ItemInfo itemInfo, @NotNull ChatListElement.FeatureImage featureImage, long j2, boolean z2, @Nullable Picture picture, @NotNull ChatListElement.LastMessageType lastMessageType, @NotNull MessagePreview messagePreview, boolean z3, @Nullable String str3) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "chatTitle");
        Intrinsics.checkNotNullParameter(featureImage, "featureImage");
        Intrinsics.checkNotNullParameter(lastMessageType, "lastMessageType");
        Intrinsics.checkNotNullParameter(messagePreview, "lastMessage");
        this.g = z;
        this.h = str2;
        this.i = itemInfo;
        this.j = featureImage;
        this.k = j2;
        this.l = z2;
        this.m = picture;
        this.n = lastMessageType;
        this.o = messagePreview;
        this.p = z3;
        this.q = str3;
        this.f = a2.a.a.o1.b.b.e.j.a;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i2, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        ChatListElement element = viewHolder.getElement();
        element.setIsActive(this.g);
        element.setChatTitle(this.h);
        ItemInfo itemInfo = this.i;
        String str = null;
        String title = itemInfo != null ? itemInfo.getTitle() : null;
        ItemInfo itemInfo2 = this.i;
        element.setItemInfo(title, itemInfo2 != null ? itemInfo2.getPrice() : null);
        if (this.n != ChatListElement.LastMessageType.DRAFT) {
            Function1<? super Long, String> function1 = this.dateFormatter;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateFormatter");
            }
            str = function1.invoke(Long.valueOf(MessengerTimestamp.toMillis(this.k)));
        }
        element.setDate(str);
        element.setInterlocutorOnline(this.l);
        element.setAvatarSource(this.m);
        element.setLastMessage(this.n, this.o);
        element.setIsTyping(this.p);
        element.setFeatureImage(this.j);
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        LifecycleOwner lifecycleOwner2 = weakReference.get();
        if (lifecycleOwner2 != null) {
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "it");
            MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
            if (mutableLiveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
            }
            mutableLiveData.removeObserver(viewHolder.getHideSwipeViewsStreamObserver());
            MutableLiveData<Integer> mutableLiveData2 = this.hideSwipeViewsStream;
            if (mutableLiveData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
            }
            mutableLiveData2.observe(lifecycleOwner2, viewHolder.getHideSwipeViewsStreamObserver());
            viewHolder.getSwipeLayout().setOnSwipeListener(new SwipeLayout.OnSwipeListener(this, lifecycleOwner2) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelListItem$bindViewHolder$$inlined$apply$lambda$1
                public final /* synthetic */ ChannelListItem b;
                public final /* synthetic */ LifecycleOwner c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onBeginSwipe(@Nullable SwipeLayout swipeLayout, boolean z) {
                    this.b.getHideSwipeViewsStream().postValue(Integer.valueOf(ChannelListItem.ViewHolder.this.getHash()));
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onLeftStickyEdge(@Nullable SwipeLayout swipeLayout, boolean z) {
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onRightStickyEdge(@Nullable SwipeLayout swipeLayout, boolean z) {
                }

                @Override // ru.rambler.libs.swipe_layout.SwipeLayout.OnSwipeListener
                public void onSwipeClampReached(@Nullable SwipeLayout swipeLayout, boolean z) {
                }
            });
            viewHolder.getElement().setClickListener(new a2.a.a.o1.b.b.e.a(this, lifecycleOwner2));
            viewHolder.getElement().setLongClickListener(new b(viewHolder, this, lifecycleOwner2));
            viewHolder.getDeleteView().setOnClickListener(new c(this, lifecycleOwner2));
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }

    public void unbindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        MutableLiveData<Integer> mutableLiveData = this.hideSwipeViewsStream;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hideSwipeViewsStream");
        }
        mutableLiveData.removeObserver(viewHolder.getHideSwipeViewsStreamObserver());
        viewHolder.getSwipeLayout().reset();
        viewHolder.getSwipeLayout().setOnSwipeListener(null);
        viewHolder.getElement().setClickListener(a.a);
        viewHolder.getElement().setLongClickListener(a2.a.a.o1.b.b.e.j.a);
        viewHolder.getDeleteView().setOnClickListener(null);
        super.unbindViewHolder(flexibleAdapter, (FlexibleAdapter<?>) viewHolder, i2);
    }
}
