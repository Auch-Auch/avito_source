package com.avito.android.messenger.conversation.mvi.messages;

import a2.a.a.o1.d.a0.i.b;
import a2.b.a.a.a;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*&\u0010\u0003\"\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00002\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000¨\u0006\u0004"}, d2 = {"Lkotlin/Pair;", "Landroid/net/Uri;", "", "UriAndMimeType", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessageListPresenterKt {
    public static final int access$correctDividerPosition(int i, List list) {
        if (i < 0 || i >= list.size()) {
            i = 0;
        }
        while (i > 0) {
            int i2 = i - 1;
            LocalMessage localMessage = ((ChannelItem.Message) list.get(i2)).getLocalMessage();
            if (!Intrinsics.areEqual(localMessage.fromId, localMessage.userId)) {
                break;
            }
            i = i2;
        }
        return i;
    }

    public static final String access$getCurrentUserId$p(KProperty0 kProperty0) {
        String currentUserId;
        Object obj = kProperty0.get();
        if (!(obj instanceof b)) {
            obj = null;
        }
        b bVar = (b) obj;
        return (bVar == null || (currentUserId = bVar.getCurrentUserId()) == null) ? "" : currentUserId;
    }

    public static final List access$getRawItems$p(KProperty0 kProperty0) {
        return access$getRawItems$p((MessageListPresenterImpl.PartialState.List.Middle) kProperty0.get());
    }

    public static final String access$getShortStr$p(MessageListPresenterImpl.PartialState partialState) {
        if (partialState instanceof MessageListPresenterImpl.PartialState.Meta) {
            StringBuilder L = a.L("Meta(openTimestamp = ");
            L.append(((MessageListPresenterImpl.PartialState.Meta) partialState).getOpenTimestamp());
            L.append(')');
            return L.toString();
        } else if (partialState instanceof MessageListPresenterImpl.PartialState.Context) {
            if (Intrinsics.areEqual(partialState, MessageListPresenterImpl.PartialState.Context.Empty.INSTANCE)) {
                return "Empty";
            }
            if (partialState instanceof MessageListPresenterImpl.PartialState.Context.LoadingError) {
                StringBuilder L2 = a.L("LoadingError(currentUserId = ");
                L2.append(((MessageListPresenterImpl.PartialState.Context.LoadingError) partialState).getCurrentUserId());
                L2.append(')');
                return L2.toString();
            } else if (partialState instanceof MessageListPresenterImpl.PartialState.Context.LoadedOnlyUserId) {
                StringBuilder L3 = a.L("LoadedOnlyUserId(currentUserId = ");
                L3.append(((MessageListPresenterImpl.PartialState.Context.LoadedOnlyUserId) partialState).getCurrentUserId());
                L3.append(')');
                return L3.toString();
            } else if (partialState instanceof MessageListPresenterImpl.PartialState.Context.Loaded) {
                StringBuilder L4 = a.L("Loaded(\n                        |   userId=");
                MessageListPresenterImpl.PartialState.Context.Loaded loaded = (MessageListPresenterImpl.PartialState.Context.Loaded) partialState;
                L4.append(loaded.getCurrentUserId());
                L4.append(",\n                        |   context=");
                L4.append(loaded.getContext().getClass().getSimpleName());
                L4.append(",\n                        |   users=(");
                L4.append(loaded.getUsers().size());
                L4.append(")[add logging to see contents],\n                        |)");
                return f.trimMargin$default(L4.toString(), null, 1, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (partialState instanceof MessageListPresenterImpl.PartialState.List) {
            return partialState.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final List access$getUsers$p(MessageListPresenterImpl.PartialState.Context context) {
        List<User> users;
        if (!(context instanceof MessageListPresenterImpl.PartialState.Context.Loaded)) {
            context = null;
        }
        MessageListPresenterImpl.PartialState.Context.Loaded loaded = (MessageListPresenterImpl.PartialState.Context.Loaded) context;
        return (loaded == null || (users = loaded.getUsers()) == null) ? CollectionsKt__CollectionsKt.emptyList() : users;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
        if (com.avito.android.remote.model.messenger.MessengerTimestamp.toMillis(r11.created) < r3) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        if (r12.longValue() < r3) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0084, code lost:
        if (r11.isRead != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        r11 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair access$newListTopAndMiddleStates(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.EventDeps r14, java.lang.String r15, java.util.List r16, java.util.List r17, com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.PartialState.List.Top r18, com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.PartialState.List.Middle r19, com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.PartialState.Meta r20) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterKt.access$newListTopAndMiddleStates(com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$EventDeps, java.lang.String, java.util.List, java.util.List, com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$PartialState$List$Top, com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$PartialState$List$Middle, com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$PartialState$Meta):kotlin.Pair");
    }

    public static final long access$toMillis(long j) {
        return MessengerTimestamp.toMillis(j);
    }

    public static final boolean access$wasReadBeforeOpen(LocalMessage localMessage, long j) {
        if (!Intrinsics.areEqual(localMessage.fromId, localMessage.userId)) {
            Long l = localMessage.readLocallyTimestamp;
            if (l != null) {
                Intrinsics.checkNotNull(l);
                if (l.longValue() < j) {
                    return true;
                }
            } else if (localMessage.isRead) {
                return true;
            }
        } else if (MessengerTimestamp.toMillis(localMessage.created) < j) {
            return true;
        }
        return false;
    }

    public static final List access$getRawItems$p(MessageListPresenterImpl.PartialState.List.Middle middle) {
        List<Pair<LocalMessage, MessageMetaInfo>> rawItems;
        if (!(middle instanceof a2.a.a.o1.d.a0.i.a)) {
            middle = null;
        }
        a2.a.a.o1.d.a0.i.a aVar = (a2.a.a.o1.d.a0.i.a) middle;
        return (aVar == null || (rawItems = aVar.getRawItems()) == null) ? CollectionsKt__CollectionsKt.emptyList() : rawItems;
    }

    public static final String access$getCurrentUserId$p(MessageListPresenterImpl.PartialState.Context context) {
        String currentUserId;
        if (!(context instanceof b)) {
            context = null;
        }
        b bVar = (b) context;
        return (bVar == null || (currentUserId = bVar.getCurrentUserId()) == null) ? "" : currentUserId;
    }
}
