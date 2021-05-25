package com.avito.android.messenger.conversation.mvi.send;

import a2.a.a.o1.d.a0.m.e;
import a2.b.a.a.a;
import android.content.res.Resources;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.MessageInput;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.ChatAttachButtonClickedEvent;
import com.avito.android.messenger.analytics.ChatShareLocationButtonClicked;
import com.avito.android.messenger.analytics.MessageType;
import com.avito.android.messenger.analytics.SendMessageEvent;
import com.avito.android.messenger.analytics.StartMessageTypingEvent;
import com.avito.android.messenger.channels.mvi.common.v2.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.channels.mvi.data.DraftRepo;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentException;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractorKt;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileInfo;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Collections;
import com.avito.android.util.Logs;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.Singles;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u001dyz{|}~\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001Bw\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010k\u001a\u00020h\u0012\u0006\u0010o\u001a\u00020l\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010v\u001a\u00020\u0003\u0012\u0006\u0010s\u001a\u00020p\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\bw\u0010xJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0014¢\u0006\u0004\b#\u0010\u0018J\u000f\u0010$\u001a\u00020\bH\u0003¢\u0006\u0004\b$\u0010\u0018R:\u0010)\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010\u00040\u0004 &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010\u00040\u0004\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R(\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004070*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u0010,\u001a\u0004\b9\u0010.R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00120*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010,\u001a\u0004\bP\u0010.R\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR(\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040V0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010,\u001a\u0004\bX\u0010.R\"\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bZ\u0010,\u001a\u0004\b[\u0010.R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u0010,\u001a\u0004\bf\u0010.R\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "", "text", "", "templates", "", "onSendMessageClick", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "onItemSelected", "(Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)V", "operationId", "onPhotosSelected", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "sharedLocation", "onLocationSelected", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)V", "onTextChangedByUser", "onAttachClick", "()V", "onAttachImageClick", "onAttachItemClick", "onAttachFileClick", "onSendLocationClick", "onAttachmentDialogDismissed", "onDraftDeletionFromOutside", "Landroid/net/Uri;", "persistableContentUri", "onFilePicked", "(Landroid/net/Uri;)V", "onCleared", "updateDraftInDb", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", "n", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "typingEventsRelay", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "o", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getAttachImageOperationIdStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "attachImageOperationIdStream", "C", "Ljava/lang/String;", "channelId", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;", "F", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;", "draftRepo", "", "t", "getAttachFileStream", "attachFileStream", "Landroid/content/res/Resources;", "z", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/analytics/Analytics;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "u", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "interactor", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", VKApiConst.VERSION, "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lcom/avito/android/Features;", "B", "Lcom/avito/android/Features;", "features", VKApiConst.Q, "getSendLocationStream", "sendLocationStream", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Larrow/core/Option;", "p", "getAttachItemIdStream", "attachItemIdStream", "r", "getShowToastMessageStream", "showToastMessageStream", "Lcom/avito/android/messenger/conversation/OpenedFrom;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/messenger/conversation/OpenedFrom;", "openedFrom", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "w", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;", "fileAttachmentInteractor", "s", "getClearTextStream", "clearTextStream", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "x", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/util/RandomKeyProvider;", "y", "Lcom/avito/android/util/RandomKeyProvider;", "randomKeyProvider", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;", "D", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;", "onboardingsInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "initialState", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileAttachmentInteractor;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/util/RandomKeyProvider;Landroid/content/res/Resources;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;Lcom/avito/android/messenger/conversation/OpenedFrom;Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;)V", "AttachButtonClickedMutator", "AttachFileClickedMutator", "AttachImageClickedMutator", "AttachItemClickedMutator", "AttachmentDialogDismissedMutator", "ContextInteractorStateChangedMutator", "DraftUpdatedMutator", "DraftWasDeletedFromOutsideMutator", "FilePickedAction", "HasIncomingMessagesChangedMutator", "ItemSelectedMutator", "LocationSelectedMutator", "OnboardingStatesChangedMutator", "PhotosSelectedMutator", "SendLocationClickedMutator", "SendMessageClickMutator", "TextChangedByUserMutator", "UpdateDraftInDbAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SendMessagePresenterImpl extends BaseMviEntityWithMutatorsRelay<SendMessagePresenter.State> implements SendMessagePresenter {
    public final Analytics A;
    public final Features B;
    public final String C;
    public final OnboardingsInteractor D;
    public final OpenedFrom E;
    public final DraftRepo F;
    public final CompositeDisposable m = new CompositeDisposable();
    public final BehaviorRelay<String> n = BehaviorRelay.create();
    @NotNull
    public final SingleLiveEvent<String> o = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Option<String>> p = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<MessageBody.Location> q = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> r = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> s = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String[]> t = new SingleLiveEvent<>();
    public final SendMessageInteractor u;
    public final ChannelContextInteractor v;
    public final FileAttachmentInteractor w;
    public final MessageRepo x;
    public final RandomKeyProvider y;
    public final Resources z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$AttachButtonClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class AttachButtonClickedMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AttachButtonClickedMutator() {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String currentUserId = state.getCurrentUserId();
            if (currentUserId != null) {
                SendMessagePresenterImpl.this.A.track(new ChatAttachButtonClickedEvent(SendMessagePresenterImpl.this.C, currentUserId));
            }
            return state.getAttachButtonState() == MessageInput.AttachButtonState.VISIBLE ? SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, true, null, false, null, false, false, null, 32511, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$AttachFileClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class AttachFileClickedMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AttachFileClickedMutator() {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            SendMessagePresenterImpl.this.D.hide(Onboarding.FileSharing);
            SendMessagePresenterImpl.this.getAttachFileStream().postValue(SendMessagePresenterImpl.this.w.getAllowedMimeTypes());
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$AttachImageClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class AttachImageClickedMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AttachImageClickedMutator() {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state.getPhotoEnabled()) {
                SendMessagePresenterImpl.this.getAttachImageOperationIdStream().postValue(SendMessagePresenterImpl.this.y.generateKey());
            } else {
                SendMessagePresenterImpl.this.getShowToastMessageStream().postValue(SendMessagePresenterImpl.this.z.getString(R.string.messenger_sending_image_is_not_available));
            }
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$AttachItemClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class AttachItemClickedMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AttachItemClickedMutator() {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (state.getAttachButtonState() == MessageInput.AttachButtonState.VISIBLE) {
                SendMessagePresenterImpl.this.getAttachItemIdStream().postValue(OptionKt.toOption(state.getItemId()));
            } else {
                SendMessagePresenterImpl.this.getShowToastMessageStream().postValue(SendMessagePresenterImpl.this.z.getString(R.string.messenger_sending_item_is_not_available));
            }
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$AttachmentDialogDismissedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class AttachmentDialogDismissedMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AttachmentDialogDismissedMutator(SendMessagePresenterImpl sendMessagePresenterImpl) {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$ContextInteractorStateChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "c", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "contextInteractorState", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ContextInteractorStateChangedMutator extends Mutator<SendMessagePresenter.State> {
        public final ChannelContextInteractor.State c;
        public final /* synthetic */ SendMessagePresenterImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContextInteractorStateChangedMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, ChannelContextInteractor.State state) {
            super("ContextInteractorStateChangedMutator(contextInteractorState=" + state + ')');
            Intrinsics.checkNotNullParameter(state, "contextInteractorState");
            this.d = sendMessagePresenterImpl;
            this.c = state;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0153, code lost:
            if ((r14 == null || (r14.getFile() == null && r14.getImage() == null && r14.getItem() == null && r14.getLocation() == null)) == false) goto L_0x0155;
         */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x01b7  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x01b9  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x01be  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x01d4  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0131  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0174  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0179  */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State r24) {
            /*
            // Method dump skipped, instructions count: 501
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl.ContextInteractorStateChangedMutator.invoke(com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State):com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$DraftUpdatedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "", "c", "Ljava/lang/String;", "newDraftText", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DraftUpdatedMutator extends Mutator<SendMessagePresenter.State> {
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DraftUpdatedMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, String str) {
            super("DraftUpdatedMutator(newDraftText=\"" + str + "\")");
            Intrinsics.checkNotNullParameter(str, "newDraftText");
            this.c = str;
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(!Intrinsics.areEqual(this.c, state.getDraftText()))) {
                return state;
            }
            String str = this.c;
            Boolean draftWasEmptyOnScreenOpen = state.getDraftWasEmptyOnScreenOpen();
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, str, false, null, null, false, null, false, null, false, false, Boolean.valueOf(draftWasEmptyOnScreenOpen != null ? draftWasEmptyOnScreenOpen.booleanValue() : this.c.length() == 0), 16367, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$DraftWasDeletedFromOutsideMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class DraftWasDeletedFromOutsideMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DraftWasDeletedFromOutsideMutator(SendMessagePresenterImpl sendMessagePresenterImpl) {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return !state.getDraftWasDeletedFromOutside() ? SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, true, null, 24575, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$FilePickedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lio/reactivex/Single;", "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "persistableContentUri", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Landroid/net/Uri;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class FilePickedAction extends ActionSingle<SendMessagePresenter.State> {
        public final Uri c;
        public final /* synthetic */ SendMessagePresenterImpl d;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ FilePickedAction a;

            public a(FilePickedAction filePickedAction) {
                this.a = filePickedAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                if (th2 instanceof FileAttachmentException.FileMaxSizeExceeded) {
                    String tag = this.a.d.getTAG();
                    StringBuilder L = a2.b.a.a.a.L("File exceeded max allowed size: fileSize = ");
                    FileAttachmentException.FileMaxSizeExceeded fileMaxSizeExceeded = (FileAttachmentException.FileMaxSizeExceeded) th2;
                    L.append(fileMaxSizeExceeded.getFileSizeInBytes());
                    L.append(", maxAllowedSize = ");
                    L.append(fileMaxSizeExceeded.getMaxAllowedSizeInBytes());
                    Logs.debug$default(tag, L.toString(), null, 4, null);
                    this.a.d.getShowToastMessageStream().postValue(this.a.d.z.getString(R.string.messenger_attachment_file_max_size_exceed_error, new DecimalFormat("#.#").format(Float.valueOf(((float) fileMaxSizeExceeded.getMaxAllowedSizeInBytes()) / ((float) 1048576)))));
                    return;
                }
                Logs.error(this.a.d.getTAG(), "File uploading failed", th2);
            }
        }

        public static final class b<T> implements Consumer<FileInfo> {
            public final /* synthetic */ FilePickedAction a;

            public b(FilePickedAction filePickedAction) {
                this.a = filePickedAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(FileInfo fileInfo) {
                String tag = this.a.d.getTAG();
                Logs.debug$default(tag, "File read successfully: " + fileInfo, null, 4, null);
            }
        }

        public static final class c<T, R> implements Function<FileInfo, SingleSource<? extends Unit>> {
            public final /* synthetic */ FilePickedAction a;
            public final /* synthetic */ SendMessagePresenter.State b;

            public c(FilePickedAction filePickedAction, SendMessagePresenter.State state) {
                this.a = filePickedAction;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends Unit> apply(FileInfo fileInfo) {
                FileInfo fileInfo2 = fileInfo;
                Intrinsics.checkNotNullParameter(fileInfo2, "fileInfo");
                String currentUserId = this.b.getCurrentUserId();
                boolean z = false;
                if (currentUserId != null) {
                    if (currentUserId.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    MessageBody.File file = new MessageBody.File("", fileInfo2.getDisplayName(), fileInfo2.getSizeInBytes(), fileInfo2.getMimeType(), null);
                    SendMessageInteractor sendMessageInteractor = this.a.d.u;
                    String currentUserId2 = this.b.getCurrentUserId();
                    Intrinsics.checkNotNull(currentUserId2);
                    return sendMessageInteractor.createMessage(currentUserId2, file, this.a.c).map(a2.a.a.o1.d.a0.m.c.a).doOnSuccess(new a2.a.a.o1.d.a0.m.d(this)).doOnError(new e(this));
                }
                Logs.debug$default(this.a.d.getTAG(), "File upload not started since currentUserId is NULL or EMPTY", null, 4, null);
                return Single.just(Unit.INSTANCE);
            }
        }

        public static final class d<T, R> implements Function<Unit, Unit> {
            public static final d a = new d();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Unit apply(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FilePickedAction(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, Uri uri) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(uri, "persistableContentUri");
            this.d = sendMessagePresenterImpl;
            this.c = uri;
        }

        @NotNull
        public Single<?> invoke(@NotNull SendMessagePresenter.State state) {
            AttachMenuItem.File file;
            Long maxSizeBytes;
            Intrinsics.checkNotNullParameter(state, "curState");
            AttachMenu dynamicAttachMenu = state.getDynamicAttachMenu();
            Single<?> onErrorReturnItem = InteropKt.toV2(this.d.w.uploadFileByUri(this.c, (dynamicAttachMenu == null || (file = dynamicAttachMenu.getFile()) == null || (maxSizeBytes = file.getMaxSizeBytes()) == null) ? FileAttachmentInteractorKt.DEFAULT_ALLOWED_FILE_MAX_SIZE_IN_BYTES : maxSizeBytes.longValue())).doOnError(new a(this)).doOnSuccess(new b(this)).flatMap(new c(this, state)).map(d.a).onErrorReturnItem(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "fileAttachmentInteractor… .onErrorReturnItem(Unit)");
            return onErrorReturnItem;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$HasIncomingMessagesChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "", "c", "Z", "hasIncomingMessages", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class HasIncomingMessagesChangedMutator extends Mutator<SendMessagePresenter.State> {
        public final boolean c;

        public HasIncomingMessagesChangedMutator(boolean z) {
            super("HasIncomingMessagesChangedMutator(hasIncomingMessages=" + z + ')');
            this.c = z;
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            AttachMenu dynamicAttachMenu;
            AttachMenuItem.Image image;
            Intrinsics.checkNotNullParameter(state, "oldState");
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, this.c || (SendMessagePresenterImpl.this.B.getMessengerDynamicAttachMenu().invoke().booleanValue() && (dynamicAttachMenu = state.getDynamicAttachMenu()) != null && (image = dynamicAttachMenu.getImage()) != null && image.getEnableForUnanswered()), null, null, false, null, false, null, false, false, null, 32735, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$ItemSelectedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "c", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ItemSelectedMutator extends MutatorSingle<SendMessagePresenter.State> {
        public final FeedbackAdvertItem c;
        public final /* synthetic */ SendMessagePresenterImpl d;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ ItemSelectedMutator a;

            public a(ItemSelectedMutator itemSelectedMutator) {
                this.a = itemSelectedMutator;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.debug(this.a.d.getTAG(), "Failed to create item message", th);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ItemSelectedMutator(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl r2, com.avito.android.remote.feedback.FeedbackAdvertItem r3) {
            /*
                r1 = this;
                java.lang.String r0 = "item"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.d = r2
                java.lang.String r2 = "ItemSelectedMutator(itemId = "
                java.lang.StringBuilder r2 = a2.b.a.a.a.L(r2)
                java.lang.String r0 = r3.getStringId()
                r2.append(r0)
                r0 = 41
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                r1.c = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl.ItemSelectedMutator.<init>(com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl, com.avito.android.remote.feedback.FeedbackAdvertItem):void");
        }

        @NotNull
        public Single<SendMessagePresenter.State> invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String currentUserId = state.getCurrentUserId();
            if (currentUserId == null) {
                currentUserId = "";
            }
            if (currentUserId.length() > 0) {
                this.d.A.track(new SendMessageEvent.Send(this.d.C, MessageType.ITEM, false));
                Single<SendMessagePresenter.State> andThen = this.d.u.createMessage(currentUserId, this.c).doOnError(new a(this)).ignoreElement().onErrorComplete().andThen(Single.just(SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null)));
                Intrinsics.checkNotNullExpressionValue(andThen, "interactor.createMessage…achMenuIsShown = false)))");
                return andThen;
            }
            Single<SendMessagePresenter.State> just = Single.just(state);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(oldState)");
            return just;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$LocationSelectedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "c", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "sharedLocation", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class LocationSelectedMutator extends MutatorSingle<SendMessagePresenter.State> {
        public final MessageBody.Location c;
        public final /* synthetic */ SendMessagePresenterImpl d;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ LocationSelectedMutator a;

            public a(LocationSelectedMutator locationSelectedMutator) {
                this.a = locationSelectedMutator;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.debug(this.a.d.getTAG(), "Failed to create location message", th);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocationSelectedMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, MessageBody.Location location) {
            super("LocationSelectedMutator(sharedLocation = " + location + ')');
            Intrinsics.checkNotNullParameter(location, "sharedLocation");
            this.d = sendMessagePresenterImpl;
            this.c = location;
        }

        @NotNull
        public Single<SendMessagePresenter.State> invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String currentUserId = state.getCurrentUserId();
            if (currentUserId == null) {
                currentUserId = "";
            }
            if (currentUserId.length() > 0) {
                this.d.A.track(new SendMessageEvent.Send(this.d.C, MessageType.GEO, false));
                Single<SendMessagePresenter.State> andThen = this.d.u.createMessage(currentUserId, this.c).doOnError(new a(this)).ignoreElement().onErrorComplete().andThen(Single.just(SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null)));
                Intrinsics.checkNotNullExpressionValue(andThen, "interactor.createMessage…achMenuIsShown = false)))");
                return andThen;
            }
            Single<SendMessagePresenter.State> just = Single.just(state);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(oldState)");
            return just;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$OnboardingStatesChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingState;", "c", "Ljava/util/Map;", "newOnboardingStates", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class OnboardingStatesChangedMutator extends Mutator<SendMessagePresenter.State> {
        public final Map<Onboarding, OnboardingState> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<com.avito.android.messenger.conversation.mvi.send.Onboarding, ? extends com.avito.android.messenger.conversation.mvi.send.OnboardingState> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnboardingStatesChangedMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, Map<Onboarding, ? extends OnboardingState> map) {
            super("OnboardingStatesChangedMutator(newOnboardingStates=" + map + ')');
            Intrinsics.checkNotNullParameter(map, "newOnboardingStates");
            this.c = map;
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            return Intrinsics.areEqual(state.getOnboardingStates(), this.c) ^ true ? SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, this.c, false, false, null, 30719, null) : state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$PhotosSelectedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", "operationId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class PhotosSelectedMutator extends MutatorSingle<SendMessagePresenter.State> {
        public final String c;
        public final /* synthetic */ SendMessagePresenterImpl d;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ PhotosSelectedMutator a;

            public a(PhotosSelectedMutator photosSelectedMutator) {
                this.a = photosSelectedMutator;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.debug(this.a.d.getTAG(), "Failed to create image message", th);
            }
        }

        public static final class b<T> implements Predicate<List<? extends LocalMessage>> {
            public static final b a = new b();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Predicate
            public boolean test(List<? extends LocalMessage> list) {
                List<? extends LocalMessage> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "it");
                return !list2.isEmpty();
            }
        }

        public static final class c<T> implements Consumer<List<? extends LocalMessage>> {
            public final /* synthetic */ PhotosSelectedMutator a;

            public c(PhotosSelectedMutator photosSelectedMutator) {
                this.a = photosSelectedMutator;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(List<? extends LocalMessage> list) {
                this.a.d.A.track(new SendMessageEvent.Send(this.a.d.C, MessageType.IMAGE, false));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhotosSelectedMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, String str) {
            super(a2.b.a.a.a.d3("PhotosSelectedMutator(operationId = ", str, ')'));
            Intrinsics.checkNotNullParameter(str, "operationId");
            this.d = sendMessagePresenterImpl;
            this.c = str;
        }

        @NotNull
        public Single<SendMessagePresenter.State> invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String currentUserId = state.getCurrentUserId();
            if (currentUserId == null) {
                currentUserId = "";
            }
            if (currentUserId.length() > 0) {
                Single<SendMessagePresenter.State> andThen = this.d.u.createImageMessages(currentUserId, this.c).doOnError(new a(this)).filter(b.a).doAfterSuccess(new c(this)).ignoreElement().onErrorComplete().andThen(Single.just(SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null)));
                Intrinsics.checkNotNullExpressionValue(andThen, "interactor.createImageMe…achMenuIsShown = false)))");
                return andThen;
            }
            Single<SendMessagePresenter.State> just = Single.just(state);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(oldState)");
            return just;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$SendLocationClickedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class SendLocationClickedMutator extends Mutator<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public SendLocationClickedMutator() {
            super(null, 1, null);
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String itemId = state.getItemId();
            if (itemId != null) {
                SendMessagePresenterImpl.this.A.track(new ChatShareLocationButtonClicked(SendMessagePresenterImpl.this.C, itemId));
            }
            SendMessagePresenterImpl.this.getSendLocationStream().postValue(state.getDefaultSharedLocation());
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 32511, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$SendMessageClickMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", "text", "", "d", "Ljava/util/List;", "templates", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Ljava/lang/String;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class SendMessageClickMutator extends MutatorSingle<SendMessagePresenter.State> {
        public final String c;
        public final List<String> d;
        public final /* synthetic */ SendMessagePresenterImpl e;

        public static final class a<T> implements Consumer<Throwable> {
            public final /* synthetic */ SendMessageClickMutator a;

            public a(SendMessageClickMutator sendMessageClickMutator) {
                this.a = sendMessageClickMutator;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.debug(this.a.e.getTAG(), "Failed to create text message", th);
            }
        }

        public static final class b<V> implements Callable<SendMessagePresenter.State> {
            public final /* synthetic */ SendMessageClickMutator a;
            public final /* synthetic */ SendMessagePresenter.State b;

            public b(SendMessageClickMutator sendMessageClickMutator, SendMessagePresenter.State state) {
                this.a = sendMessageClickMutator;
                this.b = state;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public SendMessagePresenter.State call() {
                if (Collections.isNullOrEmpty(this.a.d)) {
                    return SendMessagePresenter.State.copy$default(this.b, null, null, null, null, null, false, null, null, false, null, false, null, false, false, null, 31743, null);
                }
                return this.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendMessageClickMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, @Nullable String str, List<String> list) {
            super("SendMessageClickMutator(text = '" + str + "', templates=" + list + ')');
            Intrinsics.checkNotNullParameter(str, "text");
            this.e = sendMessagePresenterImpl;
            this.c = str;
            this.d = list;
        }

        @NotNull
        public Single<SendMessagePresenter.State> invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            String currentUserId = state.getCurrentUserId();
            if (currentUserId == null) {
                currentUserId = "";
            }
            if (!(currentUserId.length() > 0) || !(!m.isBlank(this.c))) {
                Single<SendMessagePresenter.State> just = Single.just(state);
                Intrinsics.checkNotNullExpressionValue(just, "Single.just(oldState)");
                return just;
            }
            this.e.A.track(new SendMessageEvent.Send(this.e.C, MessageType.TEXT, false));
            SendMessageInteractor sendMessageInteractor = this.e.u;
            String str = this.c;
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            Single<SendMessagePresenter.State> andThen = sendMessageInteractor.createMessages(currentUserId, StringsKt__StringsKt.trim(str).toString(), this.d).doOnError(new a(this)).ignoreElement().onErrorComplete().andThen(Single.fromCallable(new b(this, state)));
            Intrinsics.checkNotNullExpressionValue(andThen, "interactor.createMessage…  }\n                    )");
            return andThen;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$TextChangedByUserMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "", "c", "Ljava/lang/String;", "text", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class TextChangedByUserMutator extends Mutator<SendMessagePresenter.State> {
        public final String c;
        public final /* synthetic */ SendMessagePresenterImpl d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextChangedByUserMutator(@NotNull SendMessagePresenterImpl sendMessagePresenterImpl, String str) {
            super(a.d3("TextChangedByUserMutator(text=", str, ')'));
            Intrinsics.checkNotNullParameter(str, "text");
            this.d = sendMessagePresenterImpl;
            this.c = str;
        }

        @NotNull
        public SendMessagePresenter.State invoke(@NotNull SendMessagePresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(!m.isBlank(this.c)) || state.getStartTypingLogged() || !Intrinsics.areEqual(state.getDraftWasEmptyOnScreenOpen(), Boolean.TRUE)) {
                return !state.getUserChangedText() ? SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, false, null, true, false, null, 28671, null) : state;
            }
            this.d.A.track(new StartMessageTypingEvent(this.d.C));
            return SendMessagePresenter.State.copy$default(state, null, null, null, null, null, false, null, null, false, null, true, null, true, false, null, 27647, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl$UpdateDraftInDbAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;)Lio/reactivex/Single;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenterImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class UpdateDraftInDbAction extends ActionSingle<SendMessagePresenter.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public UpdateDraftInDbAction() {
            super(null, 1, null);
        }

        @NotNull
        public Single<?> invoke(@NotNull SendMessagePresenter.State state) {
            Completable completable;
            Intrinsics.checkNotNullParameter(state, "curState");
            if (!state.getDraftWasDeletedFromOutside() && state.getUserChangedText()) {
                String currentUserId = state.getCurrentUserId();
                if (!(currentUserId == null || m.isBlank(currentUserId)) && (!state.getOtherUserIds().isEmpty())) {
                    BehaviorRelay behaviorRelay = SendMessagePresenterImpl.this.n;
                    Intrinsics.checkNotNullExpressionValue(behaviorRelay, "typingEventsRelay");
                    String str = (String) behaviorRelay.getValue();
                    if (str == null) {
                        str = "";
                    }
                    if (true ^ m.isBlank(str)) {
                        completable = SendMessagePresenterImpl.this.F.putDraft(state.getCurrentUserId(), SendMessagePresenterImpl.this.C, (String) CollectionsKt___CollectionsKt.first((List<? extends Object>) state.getOtherUserIds()), str);
                    } else {
                        completable = SendMessagePresenterImpl.this.F.deleteDraft(state.getCurrentUserId(), SendMessagePresenterImpl.this.C);
                    }
                    Unit unit = Unit.INSTANCE;
                    Single<?> onErrorReturnItem = completable.andThen(Singles.toSingle(unit)).onErrorReturnItem(unit);
                    Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "if (text.isNotBlank()) {… .onErrorReturnItem(Unit)");
                    return onErrorReturnItem;
                }
            }
            return Singles.toSingle(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterKt$sam$i$io_reactivex_functions_Predicate$0] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SendMessagePresenterImpl(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor r21, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor r22, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor r23, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.data.MessageRepo r24, @org.jetbrains.annotations.NotNull com.avito.android.util.RandomKeyProvider r25, @org.jetbrains.annotations.NotNull android.content.res.Resources r26, @org.jetbrains.annotations.NotNull com.avito.android.analytics.Analytics r27, @org.jetbrains.annotations.NotNull com.avito.android.Features r28, @org.jetbrains.annotations.NotNull java.lang.String r29, @org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r30, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State r31, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor r32, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.OpenedFrom r33, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.data.DraftRepo r34) {
        /*
        // Method dump skipped, instructions count: 579
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl.<init>(com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor, com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor, com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor, com.avito.android.messenger.conversation.mvi.data.MessageRepo, com.avito.android.util.RandomKeyProvider, android.content.res.Resources, com.avito.android.analytics.Analytics, com.avito.android.Features, java.lang.String, com.avito.android.util.SchedulersFactory, com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State, com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor, com.avito.android.messenger.conversation.OpenedFrom, com.avito.android.messenger.channels.mvi.data.DraftRepo):void");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void updateDraftInDb() {
        Relay mutatorsRelay = getMutatorsRelay();
        UpdateDraftInDbAction updateDraftInDbAction = new UpdateDraftInDbAction();
        mutatorsRelay.accept(new MutatorSingle(updateDraftInDbAction.getName(), new Function1<SendMessagePresenter.State, Single<SendMessagePresenter.State>>(updateDraftInDbAction) { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$updateDraftInDb$$inlined$plusAssign$1
            public final /* synthetic */ ActionSingle a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Single<SendMessagePresenter.State> invoke(@NotNull final SendMessagePresenter.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Single<SendMessagePresenter.State> onErrorReturn = ((Single) this.a.getBlock().invoke(state)).map(new Function<Object, SendMessagePresenter.State>() { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$updateDraftInDb$$inlined$plusAssign$1.1
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // io.reactivex.functions.Function
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$updateDraftInDb$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                    }
                }).onErrorReturn(new Function<Throwable, SendMessagePresenter.State>() { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$updateDraftInDb$$inlined$plusAssign$1.2
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$updateDraftInDb$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
                return onErrorReturn;
            }
        }));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onAttachClick() {
        Relay mutatorsRelay = getMutatorsRelay();
        AttachButtonClickedMutator attachButtonClickedMutator = new AttachButtonClickedMutator();
        mutatorsRelay.accept(new MutatorSingle(attachButtonClickedMutator.getName(), new SendMessagePresenterImpl$onAttachClick$$inlined$plusAssign$1(attachButtonClickedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onAttachFileClick() {
        Relay mutatorsRelay = getMutatorsRelay();
        AttachFileClickedMutator attachFileClickedMutator = new AttachFileClickedMutator();
        mutatorsRelay.accept(new MutatorSingle(attachFileClickedMutator.getName(), new SendMessagePresenterImpl$onAttachFileClick$$inlined$plusAssign$1(attachFileClickedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onAttachImageClick() {
        Relay mutatorsRelay = getMutatorsRelay();
        AttachImageClickedMutator attachImageClickedMutator = new AttachImageClickedMutator();
        mutatorsRelay.accept(new MutatorSingle(attachImageClickedMutator.getName(), new SendMessagePresenterImpl$onAttachImageClick$$inlined$plusAssign$1(attachImageClickedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onAttachItemClick() {
        Relay mutatorsRelay = getMutatorsRelay();
        AttachItemClickedMutator attachItemClickedMutator = new AttachItemClickedMutator();
        mutatorsRelay.accept(new MutatorSingle(attachItemClickedMutator.getName(), new SendMessagePresenterImpl$onAttachItemClick$$inlined$plusAssign$1(attachItemClickedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onAttachmentDialogDismissed() {
        Relay mutatorsRelay = getMutatorsRelay();
        AttachmentDialogDismissedMutator attachmentDialogDismissedMutator = new AttachmentDialogDismissedMutator(this);
        mutatorsRelay.accept(new MutatorSingle(attachmentDialogDismissedMutator.getName(), new SendMessagePresenterImpl$onAttachmentDialogDismissed$$inlined$plusAssign$1(attachmentDialogDismissedMutator)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.dispose();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onDraftDeletionFromOutside() {
        Relay mutatorsRelay = getMutatorsRelay();
        DraftWasDeletedFromOutsideMutator draftWasDeletedFromOutsideMutator = new DraftWasDeletedFromOutsideMutator(this);
        mutatorsRelay.accept(new MutatorSingle(draftWasDeletedFromOutsideMutator.getName(), new SendMessagePresenterImpl$onDraftDeletionFromOutside$$inlined$plusAssign$1(draftWasDeletedFromOutsideMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onFilePicked(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "persistableContentUri");
        Relay mutatorsRelay = getMutatorsRelay();
        FilePickedAction filePickedAction = new FilePickedAction(this, uri);
        mutatorsRelay.accept(new MutatorSingle(filePickedAction.getName(), new Function1<SendMessagePresenter.State, Single<SendMessagePresenter.State>>(filePickedAction) { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$onFilePicked$$inlined$plusAssign$1
            public final /* synthetic */ ActionSingle a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Single<SendMessagePresenter.State> invoke(@NotNull final SendMessagePresenter.State state) {
                Intrinsics.checkNotNullParameter(state, "oldState");
                Single<SendMessagePresenter.State> onErrorReturn = ((Single) this.a.getBlock().invoke(state)).map(new Function<Object, SendMessagePresenter.State>() { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$onFilePicked$$inlined$plusAssign$1.1
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    @Override // io.reactivex.functions.Function
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$onFilePicked$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                    }
                }).onErrorReturn(new Function<Throwable, SendMessagePresenter.State>() { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$onFilePicked$$inlined$plusAssign$1.2
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter$State, java.lang.Object] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                        /*
                            r1 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            java.lang.Object r2 = r3
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$onFilePicked$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
                return onErrorReturn;
            }
        }));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onItemSelected(@NotNull FeedbackAdvertItem feedbackAdvertItem) {
        Intrinsics.checkNotNullParameter(feedbackAdvertItem, "item");
        getMutatorsRelay().accept(new ItemSelectedMutator(this, feedbackAdvertItem));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onLocationSelected(@NotNull MessageBody.Location location) {
        Intrinsics.checkNotNullParameter(location, "sharedLocation");
        getMutatorsRelay().accept(new LocationSelectedMutator(this, location));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onPhotosSelected(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        getMutatorsRelay().accept(new PhotosSelectedMutator(this, str));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onSendLocationClick() {
        Relay mutatorsRelay = getMutatorsRelay();
        SendLocationClickedMutator sendLocationClickedMutator = new SendLocationClickedMutator();
        mutatorsRelay.accept(new MutatorSingle(sendLocationClickedMutator.getName(), new SendMessagePresenterImpl$onSendLocationClick$$inlined$plusAssign$1(sendLocationClickedMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onSendMessageClick(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "text");
        boolean isNullOrEmpty = Collections.isNullOrEmpty(list);
        getMutatorsRelay().accept(new SendMessageClickMutator(this, str, list));
        if (isNullOrEmpty) {
            getClearTextStream().postValue(Unit.INSTANCE);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    public void onTextChangedByUser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.n.accept(str);
        Relay mutatorsRelay = getMutatorsRelay();
        TextChangedByUserMutator textChangedByUserMutator = new TextChangedByUserMutator(this, str);
        mutatorsRelay.accept(new MutatorSingle(textChangedByUserMutator.getName(), new SendMessagePresenterImpl$onTextChangedByUser$$inlined$plusAssign$1(textChangedByUserMutator)));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    @NotNull
    public SingleLiveEvent<String[]> getAttachFileStream() {
        return this.t;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    @NotNull
    public SingleLiveEvent<String> getAttachImageOperationIdStream() {
        return this.o;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    @NotNull
    public SingleLiveEvent<Option<String>> getAttachItemIdStream() {
        return this.p;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    @NotNull
    public SingleLiveEvent<Unit> getClearTextStream() {
        return this.s;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    @NotNull
    public SingleLiveEvent<MessageBody.Location> getSendLocationStream() {
        return this.q;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter
    @NotNull
    public SingleLiveEvent<String> getShowToastMessageStream() {
        return this.r;
    }
}
