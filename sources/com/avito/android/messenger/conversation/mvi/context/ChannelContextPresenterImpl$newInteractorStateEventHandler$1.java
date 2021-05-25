package com.avito.android.messenger.conversation.mvi.context;

import android.net.Uri;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.jsonrpc.client.JsonRpcCallException;
import com.avito.android.messenger.ChannelContextLoadingException;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.util.Formatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.UserLastActivity;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$NewInteractorState;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$NewInteractorState;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextPresenterImpl$newInteractorStateEventHandler$1 extends Lambda implements Function2<ChannelContextPresenterImpl.Event.NewInteractorState, ChannelContextView.State, ChannelContextView.State> {
    public final /* synthetic */ ChannelContextPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelContextPresenterImpl$newInteractorStateEventHandler$1(ChannelContextPresenterImpl channelContextPresenterImpl) {
        super(2);
        this.a = channelContextPresenterImpl;
    }

    @NotNull
    public final ChannelContextView.State invoke(@NotNull ChannelContextPresenterImpl.Event.NewInteractorState newInteractorState, @NotNull ChannelContextView.State state) {
        Object obj;
        ChannelContextView.State state2;
        Triple triple;
        Object obj2;
        Object obj3;
        Uri uri;
        Intrinsics.checkNotNullParameter(newInteractorState, "$this$mutatorHandler");
        Intrinsics.checkNotNullParameter(state, "oldState");
        this.a.B.startContextPreparing();
        boolean z = true;
        Integer num = null;
        UserLastActivity userLastActivity = null;
        UserLastActivity userLastActivity2 = null;
        if ((!m.isBlank(newInteractorState.interactorState.getCurrentUserId())) && (newInteractorState.interactorState.getChannelState() instanceof Loading.Success)) {
            Channel channel = (Channel) ((Loading.Success) newInteractorState.interactorState.getChannelState()).getValue();
            List<User> users = channel.getUsers();
            ArrayList arrayList = new ArrayList();
            for (T t : users) {
                if (!Intrinsics.areEqual(t.getId(), newInteractorState.interactorState.getCurrentUserId())) {
                    arrayList.add(t);
                }
            }
            String name = channel.getDisplayInfo().getName();
            Image avatar = channel.getDisplayInfo().getAvatar();
            Picture pictureOf$default = avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null;
            String status = channel.getDisplayInfo().getStatus();
            ChannelContextPresenterImpl channelContextPresenterImpl = this.a;
            Channel channel2 = (Channel) ((Loading.Success) newInteractorState.interactorState.getChannelState()).getValue();
            ChannelContext context = channel2.getContext();
            if (!(context instanceof ChannelContext.Item)) {
                context = null;
            }
            ChannelContext.Item item = (ChannelContext.Item) context;
            if (item != null) {
                DealAction.Action access$getSupportedDealAction$p = ChannelContextPresenterImpl.access$getSupportedDealAction$p(channelContextPresenterImpl, channel2);
                DeepLink createFromUri = (access$getSupportedDealAction$p == null || (uri = access$getSupportedDealAction$p.getUri()) == null) ? null : channelContextPresenterImpl.z.createFromUri(uri);
                if (createFromUri != null) {
                    z = createFromUri instanceof NoMatchLink;
                }
                String title = (!z && access$getSupportedDealAction$p != null) ? access$getSupportedDealAction$p.getTitle() : null;
                String title2 = item.getTitle();
                Objects.requireNonNull(title2, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj4 = StringsKt__StringsKt.trim(title2).toString();
                String price = item.getPrice();
                Objects.requireNonNull(price, "null cannot be cast to non-null type kotlin.CharSequence");
                obj = new ChannelContextView.ItemBlock.Loaded(obj4, StringsKt__StringsKt.trim(price).toString(), AvitoPictureKt.pictureOf$default(item.getImage(), true, 0.0f, 0.0f, null, 28, null), title, createFromUri);
            } else {
                obj = ChannelContextView.ItemBlock.Hidden.INSTANCE;
            }
            if (obj instanceof ChannelContextView.ItemBlock.Loaded) {
                if (status == null) {
                    ChannelContextPresenterImpl channelContextPresenterImpl2 = this.a;
                    Iterator it = arrayList.iterator();
                    if (!it.hasNext()) {
                        obj3 = null;
                    } else {
                        obj3 = it.next();
                        if (it.hasNext()) {
                            Long lastActionTime = ((User) obj3).getLastActionTime();
                            long longValue = lastActionTime != null ? lastActionTime.longValue() : 0;
                            do {
                                Object next = it.next();
                                Long lastActionTime2 = ((User) next).getLastActionTime();
                                long longValue2 = lastActionTime2 != null ? lastActionTime2.longValue() : 0;
                                if (longValue < longValue2) {
                                    obj3 = next;
                                    longValue = longValue2;
                                }
                            } while (it.hasNext());
                        }
                    }
                    User user = (User) obj3;
                    Formatter formatter = channelContextPresenterImpl2.x;
                    if (user != null) {
                        userLastActivity = new UserLastActivity(user.getId(), user.getLastActionTime(), user.getTimeDiff());
                    }
                    status = formatter.format(userLastActivity);
                }
                state2 = new ChannelContextView.State.Loaded.Item(name, pictureOf$default, status, (ChannelContextView.ItemBlock.Loaded) obj, newInteractorState.interactorState.isConnecting());
            } else if (!Intrinsics.areEqual(obj, ChannelContextView.ItemBlock.Empty.INSTANCE) && !Intrinsics.areEqual(obj, ChannelContextView.ItemBlock.Hidden.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            } else {
                ChannelContext context2 = ((Channel) ((Loading.Success) newInteractorState.interactorState.getChannelState()).getValue()).getContext();
                if (context2 instanceof ChannelContext.System) {
                    if (status == null && (status = ((ChannelContext.System) context2).getStatus()) == null) {
                        status = "";
                    }
                    triple = new Triple(name, status, pictureOf$default);
                } else {
                    if (status == null) {
                        ChannelContextPresenterImpl channelContextPresenterImpl3 = this.a;
                        Iterator it2 = arrayList.iterator();
                        if (!it2.hasNext()) {
                            obj2 = null;
                        } else {
                            obj2 = it2.next();
                            if (it2.hasNext()) {
                                Long lastActionTime3 = ((User) obj2).getLastActionTime();
                                long longValue3 = lastActionTime3 != null ? lastActionTime3.longValue() : 0;
                                do {
                                    Object next2 = it2.next();
                                    Long lastActionTime4 = ((User) next2).getLastActionTime();
                                    long longValue4 = lastActionTime4 != null ? lastActionTime4.longValue() : 0;
                                    if (longValue3 < longValue4) {
                                        obj2 = next2;
                                        longValue3 = longValue4;
                                    }
                                } while (it2.hasNext());
                            }
                        }
                        User user2 = (User) obj2;
                        Formatter formatter2 = channelContextPresenterImpl3.x;
                        if (user2 != null) {
                            userLastActivity2 = new UserLastActivity(user2.getId(), user2.getLastActionTime(), user2.getTimeDiff());
                        }
                        status = formatter2.format(userLastActivity2);
                    }
                    triple = new Triple(name, status, pictureOf$default);
                }
                state2 = new ChannelContextView.State.Loaded.NoItem((String) triple.component1(), (Picture) triple.component3(), (String) triple.component2(), newInteractorState.interactorState.isConnecting());
            }
            this.a.B.trackContextPreparing();
            Unit unit = Unit.INSTANCE;
            return state2;
        } else if (newInteractorState.interactorState.getChannelState() instanceof Loading.InProgress) {
            this.a.B.trackContextPreparing();
            return ChannelContextView.State.Empty.INSTANCE;
        } else {
            ChannelContextView.State.Error error = ChannelContextView.State.Error.INSTANCE;
            if (!Intrinsics.areEqual(state, error)) {
                if (newInteractorState.interactorState.getChannelState() instanceof Loading.Error) {
                    ErrorTracker.DefaultImpls.track$default(this.a.p, new ChannelContextLoadingException("Failed to load channel", ((Loading.Error) newInteractorState.interactorState.getChannelState()).getError()), null, null, 6, null);
                    Throwable error2 = ((Loading.Error) newInteractorState.interactorState.getChannelState()).getError();
                    if (!(error2 instanceof JsonRpcCallException)) {
                        error2 = null;
                    }
                    JsonRpcCallException jsonRpcCallException = (JsonRpcCallException) error2;
                    if (jsonRpcCallException != null) {
                        num = Integer.valueOf(jsonRpcCallException.getCode());
                    }
                    if (num != null && num.intValue() == -32044) {
                        this.a.getCloseScreenStream().postValue(Unit.INSTANCE);
                    }
                } else {
                    ErrorTracker.DefaultImpls.track$default(this.a.p, new ChannelContextLoadingException("Failed to load channel: interactor state is empty", null, 2, null), null, null, 6, null);
                }
            }
            this.a.B.trackContextPreparingError();
            Unit unit2 = Unit.INSTANCE;
            return error;
        }
    }
}
