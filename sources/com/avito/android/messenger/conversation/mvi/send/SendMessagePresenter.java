package com.avito.android.messenger.conversation.mvi.send;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import arrow.core.Option;
import com.avito.android.component.MessageInput;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH&¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\bH&¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\bH&¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\bH&¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010%R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010%R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010%R\"\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040.0#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010%R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010%¨\u00064"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "Landroidx/lifecycle/LifecycleObserver;", "", "text", "", "templates", "", "onSendMessageClick", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "onItemSelected", "(Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)V", "operationId", "onPhotosSelected", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "sharedLocation", "onLocationSelected", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)V", "onTextChangedByUser", "onAttachClick", "()V", "onAttachImageClick", "onAttachItemClick", "onAttachFileClick", "onSendLocationClick", "onAttachmentDialogDismissed", "onDraftDeletionFromOutside", "Landroid/net/Uri;", "persistableContentUri", "onFilePicked", "(Landroid/net/Uri;)V", "Landroidx/lifecycle/LiveData;", "getAttachImageOperationIdStream", "()Landroidx/lifecycle/LiveData;", "attachImageOperationIdStream", "", "getAttachFileStream", "attachFileStream", "getSendLocationStream", "sendLocationStream", "getClearTextStream", "clearTextStream", "Larrow/core/Option;", "getAttachItemIdStream", "attachItemIdStream", "getShowToastMessageStream", "showToastMessageStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SendMessagePresenter extends MviEntity<State>, LifecycleObserver {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onSendMessageClick$default(SendMessagePresenter sendMessagePresenter, String str, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    list = null;
                }
                sendMessagePresenter.onSendMessageClick(str, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSendMessageClick");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b-\b\b\u0018\u00002\u00020\u0001B½\u0001\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\u000f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010,\u001a\u00020\t\u0012\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bj\u0010kJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000eJ\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000eJ\u0010\u0010 \u001a\u00020\tHÆ\u0003¢\u0006\u0004\b \u0010\u000eJ\u0012\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b!\u0010\u000bJÆ\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010*\u001a\u00020\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010,\u001a\u00020\t2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b3\u0010\u0004J\u0010\u00105\u001a\u000204HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u000204HÖ\u0001¢\u0006\u0004\b;\u00106J \u0010@\u001a\u00020?2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u000204HÖ\u0001¢\u0006\u0004\b@\u0010AR\u0019\u0010(\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u0011R\u0019\u0010'\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u000eR\u0019\u0010*\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010F\u001a\u0004\bI\u0010\u000eR%\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u001eR\u0019\u0010.\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010F\u001a\u0004\bN\u0010\u000eR\u001b\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u0004R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010\u0018R\u001b\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u000bR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010P\u001a\u0004\b\\\u0010\u0004R\u001b\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010Y\u001a\u0004\b^\u0010\u000bR\u0019\u0010/\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010F\u001a\u0004\b`\u0010\u000eR\u0014\u0010b\u001a\u00020\t8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\ba\u0010\u000eR\u001b\u0010)\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010\u0014R\u0019\u0010,\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010F\u001a\u0004\bg\u0010\u000eR\u001b\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bh\u0010P\u001a\u0004\bi\u0010\u0004¨\u0006l"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "()Z", "Lcom/avito/android/component/MessageInput$AttachButtonState;", "component7", "()Lcom/avito/android/component/MessageInput$AttachButtonState;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "component8", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "component9", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "component10", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "component11", "", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingState;", "component12", "()Ljava/util/Map;", "component13", "component14", "component15", "currentUserId", "otherUserIds", "itemId", "contextIsReady", "draftText", "photoEnabled", "attachButtonState", "dynamicAttachMenu", "attachMenuIsShown", "defaultSharedLocation", "startTypingLogged", "onboardingStates", "userChangedText", "draftWasDeletedFromOutside", "draftWasEmptyOnScreenOpen", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;ZLcom/avito/android/component/MessageInput$AttachButtonState;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;ZLcom/avito/android/remote/model/messenger/message/MessageBody$Location;ZLjava/util/Map;ZZLjava/lang/Boolean;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", g.a, "Lcom/avito/android/component/MessageInput$AttachButtonState;", "getAttachButtonState", "f", "Z", "getPhotoEnabled", "i", "getAttachMenuIsShown", "l", "Ljava/util/Map;", "getOnboardingStates", AuthSource.OPEN_CHANNEL_LIST, "getUserChangedText", "c", "Ljava/lang/String;", "getItemId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getOtherUserIds", "j", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getDefaultSharedLocation", "o", "Ljava/lang/Boolean;", "getDraftWasEmptyOnScreenOpen", AuthSource.SEND_ABUSE, "getCurrentUserId", "d", "getContextIsReady", "n", "getDraftWasDeletedFromOutside", "getEnabled", "enabled", "h", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "getDynamicAttachMenu", "k", "getStartTypingLogged", "e", "getDraftText", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;ZLcom/avito/android/component/MessageInput$AttachButtonState;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;ZLcom/avito/android/remote/model/messenger/message/MessageBody$Location;ZLjava/util/Map;ZZLjava/lang/Boolean;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        @Nullable
        public final String a;
        @NotNull
        public final List<String> b;
        @Nullable
        public final String c;
        @Nullable
        public final Boolean d;
        @Nullable
        public final String e;
        public final boolean f;
        @NotNull
        public final MessageInput.AttachButtonState g;
        @Nullable
        public final AttachMenu h;
        public final boolean i;
        @Nullable
        public final MessageBody.Location j;
        public final boolean k;
        @NotNull
        public final Map<Onboarding, OnboardingState> l;
        public final boolean m;
        public final boolean n;
        @Nullable
        public final Boolean o;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Boolean bool2;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                String readString3 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                MessageInput.AttachButtonState attachButtonState = (MessageInput.AttachButtonState) Enum.valueOf(MessageInput.AttachButtonState.class, parcel.readString());
                AttachMenu attachMenu = (AttachMenu) parcel.readParcelable(State.class.getClassLoader());
                boolean z2 = parcel.readInt() != 0;
                MessageBody.Location location = (MessageBody.Location) parcel.readParcelable(State.class.getClassLoader());
                boolean z3 = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    linkedHashMap.put((Onboarding) Enum.valueOf(Onboarding.class, parcel.readString()), (OnboardingState) Enum.valueOf(OnboardingState.class, parcel.readString()));
                    readInt--;
                }
                boolean z4 = parcel.readInt() != 0;
                boolean z5 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    bool2 = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool2 = null;
                }
                return new State(readString, createStringArrayList, readString2, bool, readString3, z, attachButtonState, attachMenu, z2, location, z3, linkedHashMap, z4, z5, bool2);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State() {
            this(null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32767, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: java.util.Map<com.avito.android.messenger.conversation.mvi.send.Onboarding, ? extends com.avito.android.messenger.conversation.mvi.send.OnboardingState> */
        /* JADX WARN: Multi-variable type inference failed */
        public State(@Nullable String str, @NotNull List<String> list, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, boolean z, @NotNull MessageInput.AttachButtonState attachButtonState, @Nullable AttachMenu attachMenu, boolean z2, @Nullable MessageBody.Location location, boolean z3, @NotNull Map<Onboarding, ? extends OnboardingState> map, boolean z4, boolean z5, @Nullable Boolean bool2) {
            Intrinsics.checkNotNullParameter(list, "otherUserIds");
            Intrinsics.checkNotNullParameter(attachButtonState, "attachButtonState");
            Intrinsics.checkNotNullParameter(map, "onboardingStates");
            this.a = str;
            this.b = list;
            this.c = str2;
            this.d = bool;
            this.e = str3;
            this.f = z;
            this.g = attachButtonState;
            this.h = attachMenu;
            this.i = z2;
            this.j = location;
            this.k = z3;
            this.l = map;
            this.m = z4;
            this.n = z5;
            this.o = bool2;
        }

        public static /* synthetic */ State copy$default(State state, String str, List list, String str2, Boolean bool, String str3, boolean z, MessageInput.AttachButtonState attachButtonState, AttachMenu attachMenu, boolean z2, MessageBody.Location location, boolean z3, Map map, boolean z4, boolean z5, Boolean bool2, int i2, Object obj) {
            return state.copy((i2 & 1) != 0 ? state.a : str, (i2 & 2) != 0 ? state.b : list, (i2 & 4) != 0 ? state.c : str2, (i2 & 8) != 0 ? state.d : bool, (i2 & 16) != 0 ? state.e : str3, (i2 & 32) != 0 ? state.f : z, (i2 & 64) != 0 ? state.g : attachButtonState, (i2 & 128) != 0 ? state.h : attachMenu, (i2 & 256) != 0 ? state.i : z2, (i2 & 512) != 0 ? state.j : location, (i2 & 1024) != 0 ? state.k : z3, (i2 & 2048) != 0 ? state.l : map, (i2 & 4096) != 0 ? state.m : z4, (i2 & 8192) != 0 ? state.n : z5, (i2 & 16384) != 0 ? state.o : bool2);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final MessageBody.Location component10() {
            return this.j;
        }

        public final boolean component11() {
            return this.k;
        }

        @NotNull
        public final Map<Onboarding, OnboardingState> component12() {
            return this.l;
        }

        public final boolean component13() {
            return this.m;
        }

        public final boolean component14() {
            return this.n;
        }

        @Nullable
        public final Boolean component15() {
            return this.o;
        }

        @NotNull
        public final List<String> component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final Boolean component4() {
            return this.d;
        }

        @Nullable
        public final String component5() {
            return this.e;
        }

        public final boolean component6() {
            return this.f;
        }

        @NotNull
        public final MessageInput.AttachButtonState component7() {
            return this.g;
        }

        @Nullable
        public final AttachMenu component8() {
            return this.h;
        }

        public final boolean component9() {
            return this.i;
        }

        @NotNull
        public final State copy(@Nullable String str, @NotNull List<String> list, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, boolean z, @NotNull MessageInput.AttachButtonState attachButtonState, @Nullable AttachMenu attachMenu, boolean z2, @Nullable MessageBody.Location location, boolean z3, @NotNull Map<Onboarding, ? extends OnboardingState> map, boolean z4, boolean z5, @Nullable Boolean bool2) {
            Intrinsics.checkNotNullParameter(list, "otherUserIds");
            Intrinsics.checkNotNullParameter(attachButtonState, "attachButtonState");
            Intrinsics.checkNotNullParameter(map, "onboardingStates");
            return new State(str, list, str2, bool, str3, z, attachButtonState, attachMenu, z2, location, z3, map, z4, z5, bool2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && Intrinsics.areEqual(this.d, state.d) && Intrinsics.areEqual(this.e, state.e) && this.f == state.f && Intrinsics.areEqual(this.g, state.g) && Intrinsics.areEqual(this.h, state.h) && this.i == state.i && Intrinsics.areEqual(this.j, state.j) && this.k == state.k && Intrinsics.areEqual(this.l, state.l) && this.m == state.m && this.n == state.n && Intrinsics.areEqual(this.o, state.o);
        }

        @NotNull
        public final MessageInput.AttachButtonState getAttachButtonState() {
            return this.g;
        }

        public final boolean getAttachMenuIsShown() {
            return this.i;
        }

        @Nullable
        public final Boolean getContextIsReady() {
            return this.d;
        }

        @Nullable
        public final String getCurrentUserId() {
            return this.a;
        }

        @Nullable
        public final MessageBody.Location getDefaultSharedLocation() {
            return this.j;
        }

        @Nullable
        public final String getDraftText() {
            return this.e;
        }

        public final boolean getDraftWasDeletedFromOutside() {
            return this.n;
        }

        @Nullable
        public final Boolean getDraftWasEmptyOnScreenOpen() {
            return this.o;
        }

        @Nullable
        public final AttachMenu getDynamicAttachMenu() {
            return this.h;
        }

        public final boolean getEnabled() {
            return Intrinsics.areEqual(getContextIsReady(), Boolean.TRUE) && getDraftText() != null;
        }

        @Nullable
        public final String getItemId() {
            return this.c;
        }

        @NotNull
        public final Map<Onboarding, OnboardingState> getOnboardingStates() {
            return this.l;
        }

        @NotNull
        public final List<String> getOtherUserIds() {
            return this.b;
        }

        public final boolean getPhotoEnabled() {
            return this.f;
        }

        public final boolean getStartTypingLogged() {
            return this.k;
        }

        public final boolean getUserChangedText() {
            return this.m;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<String> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.d;
            int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
            String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z = this.f;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode5 + i4) * 31;
            MessageInput.AttachButtonState attachButtonState = this.g;
            int hashCode6 = (i7 + (attachButtonState != null ? attachButtonState.hashCode() : 0)) * 31;
            AttachMenu attachMenu = this.h;
            int hashCode7 = (hashCode6 + (attachMenu != null ? attachMenu.hashCode() : 0)) * 31;
            boolean z2 = this.i;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (hashCode7 + i8) * 31;
            MessageBody.Location location = this.j;
            int hashCode8 = (i11 + (location != null ? location.hashCode() : 0)) * 31;
            boolean z3 = this.k;
            if (z3) {
                z3 = true;
            }
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = (hashCode8 + i12) * 31;
            Map<Onboarding, OnboardingState> map = this.l;
            int hashCode9 = (i15 + (map != null ? map.hashCode() : 0)) * 31;
            boolean z4 = this.m;
            if (z4) {
                z4 = true;
            }
            int i16 = z4 ? 1 : 0;
            int i17 = z4 ? 1 : 0;
            int i18 = z4 ? 1 : 0;
            int i19 = (hashCode9 + i16) * 31;
            boolean z5 = this.n;
            if (!z5) {
                i3 = z5 ? 1 : 0;
            }
            int i20 = (i19 + i3) * 31;
            Boolean bool2 = this.o;
            if (bool2 != null) {
                i2 = bool2.hashCode();
            }
            return i20 + i2;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(currentUserId=");
            L.append(this.a);
            L.append(", otherUserIds=");
            L.append(this.b);
            L.append(", itemId=");
            L.append(this.c);
            L.append(", contextIsReady=");
            L.append(this.d);
            L.append(", draftText=");
            L.append(this.e);
            L.append(", photoEnabled=");
            L.append(this.f);
            L.append(", attachButtonState=");
            L.append(this.g);
            L.append(", dynamicAttachMenu=");
            L.append(this.h);
            L.append(", attachMenuIsShown=");
            L.append(this.i);
            L.append(", defaultSharedLocation=");
            L.append(this.j);
            L.append(", startTypingLogged=");
            L.append(this.k);
            L.append(", onboardingStates=");
            L.append(this.l);
            L.append(", userChangedText=");
            L.append(this.m);
            L.append(", draftWasDeletedFromOutside=");
            L.append(this.n);
            L.append(", draftWasEmptyOnScreenOpen=");
            return a.o(L, this.o, ")");
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r5, int r6) {
            /*
                r4 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = r4.a
                r5.writeString(r0)
                java.util.List<java.lang.String> r0 = r4.b
                r5.writeStringList(r0)
                java.lang.String r0 = r4.c
                r5.writeString(r0)
                java.lang.Boolean r0 = r4.d
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x001e
                a2.b.a.a.a.G0(r5, r1, r0)
                goto L_0x0021
            L_0x001e:
                r5.writeInt(r2)
            L_0x0021:
                java.lang.String r0 = r4.e
                r5.writeString(r0)
                boolean r0 = r4.f
                r5.writeInt(r0)
                com.avito.android.component.MessageInput$AttachButtonState r0 = r4.g
                java.lang.String r0 = r0.name()
                r5.writeString(r0)
                com.avito.android.remote.model.messenger.attach_menu.AttachMenu r0 = r4.h
                r5.writeParcelable(r0, r6)
                boolean r0 = r4.i
                r5.writeInt(r0)
                com.avito.android.remote.model.messenger.message.MessageBody$Location r0 = r4.j
                r5.writeParcelable(r0, r6)
                boolean r6 = r4.k
                r5.writeInt(r6)
                java.util.Map<com.avito.android.messenger.conversation.mvi.send.Onboarding, com.avito.android.messenger.conversation.mvi.send.OnboardingState> r6 = r4.l
                java.util.Iterator r6 = a2.b.a.a.a.o0(r6, r5)
            L_0x004e:
                boolean r0 = r6.hasNext()
                if (r0 == 0) goto L_0x0073
                java.lang.Object r0 = r6.next()
                java.lang.Object r3 = r0.getKey()
                com.avito.android.messenger.conversation.mvi.send.Onboarding r3 = (com.avito.android.messenger.conversation.mvi.send.Onboarding) r3
                java.lang.String r3 = r3.name()
                r5.writeString(r3)
                java.lang.Object r0 = r0.getValue()
                com.avito.android.messenger.conversation.mvi.send.OnboardingState r0 = (com.avito.android.messenger.conversation.mvi.send.OnboardingState) r0
                java.lang.String r0 = r0.name()
                r5.writeString(r0)
                goto L_0x004e
            L_0x0073:
                boolean r6 = r4.m
                r5.writeInt(r6)
                boolean r6 = r4.n
                r5.writeInt(r6)
                java.lang.Boolean r6 = r4.o
                if (r6 == 0) goto L_0x0085
                a2.b.a.a.a.G0(r5, r1, r6)
                goto L_0x0088
            L_0x0085:
                r5.writeInt(r2)
            L_0x0088:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State.writeToParcel(android.os.Parcel, int):void");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(String str, List list, String str2, Boolean bool, String str3, boolean z, MessageInput.AttachButtonState attachButtonState, AttachMenu attachMenu, boolean z2, MessageBody.Location location, boolean z3, Map map, boolean z4, boolean z5, Boolean bool2, int i2, j jVar) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? MessageInput.AttachButtonState.DISABLED : attachButtonState, (i2 & 128) != 0 ? null : attachMenu, (i2 & 256) != 0 ? false : z2, (i2 & 512) != 0 ? null : location, (i2 & 1024) != 0 ? false : z3, (i2 & 2048) != 0 ? r.emptyMap() : map, (i2 & 4096) != 0 ? false : z4, (i2 & 8192) == 0 ? z5 : false, (i2 & 16384) != 0 ? null : bool2);
        }
    }

    @NotNull
    LiveData<String[]> getAttachFileStream();

    @NotNull
    LiveData<String> getAttachImageOperationIdStream();

    @NotNull
    LiveData<Option<String>> getAttachItemIdStream();

    @NotNull
    LiveData<Unit> getClearTextStream();

    @NotNull
    LiveData<MessageBody.Location> getSendLocationStream();

    @NotNull
    LiveData<String> getShowToastMessageStream();

    void onAttachClick();

    void onAttachFileClick();

    void onAttachImageClick();

    void onAttachItemClick();

    void onAttachmentDialogDismissed();

    void onDraftDeletionFromOutside();

    void onFilePicked(@NotNull Uri uri);

    void onItemSelected(@NotNull FeedbackAdvertItem feedbackAdvertItem);

    void onLocationSelected(@NotNull MessageBody.Location location);

    void onPhotosSelected(@NotNull String str);

    void onSendLocationClick();

    void onSendMessageClick(@NotNull String str, @Nullable List<String> list);

    void onTextChangedByUser(@NotNull String str);
}
