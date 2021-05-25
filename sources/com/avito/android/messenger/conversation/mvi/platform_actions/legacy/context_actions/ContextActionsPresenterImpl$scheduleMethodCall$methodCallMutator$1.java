package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.util.ThrowablesKt;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.util.Logs;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;)Lio/reactivex/Single;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1 extends Lambda implements Function1<ContextActionsPresenter.State, Single<ContextActionsPresenter.State>> {
    public final /* synthetic */ ContextActionsPresenterImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ RawJson c;
    public final /* synthetic */ ContextActionHandler.MethodCall.Reaction d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1(ContextActionsPresenterImpl contextActionsPresenterImpl, String str, RawJson rawJson, ContextActionHandler.MethodCall.Reaction reaction) {
        super(1);
        this.a = contextActionsPresenterImpl;
        this.b = str;
        this.c = rawJson;
        this.d = reaction;
    }

    @NotNull
    public final Single<ContextActionsPresenter.State> invoke(@NotNull final ContextActionsPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        Single<R> onErrorReturn = this.a.p.callApiMethod(this.b, this.c).subscribeOn(this.a.getSchedulers().io()).observeOn(this.a.getSchedulers().computation()).flatMap(new Function<RawJson, SingleSource<? extends ContextActionsPresenter.State>>(this) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1.1
            public final /* synthetic */ ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1 a;

            {
                this.a = r1;
            }

            public final SingleSource<? extends ContextActionsPresenter.State> apply(@NotNull RawJson rawJson) {
                Intrinsics.checkNotNullParameter(rawJson, "it");
                ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1 contextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1 = this.a;
                if (contextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1.d == null || !(state instanceof ContextActionsPresenter.State.Visible)) {
                    ContextActionsPresenterImpl contextActionsPresenterImpl = contextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1.a;
                    Object obj = state;
                    if (obj instanceof ContextActionsPresenter.State.Visible) {
                        ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) obj;
                        if (visible.isActionInProgress()) {
                            obj = ContextActionsPresenter.State.Visible.copy$default(visible, null, null, null, null, null, false, null, 95, null);
                        }
                    }
                    return Singles.toSingle(obj);
                }
                Single<T> singleDefault = contextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1.a.p.sendReactionAndDeleteContextActions(((ContextActionsPresenter.State.Visible) state).getCurrentUserId(), ((ContextActionsPresenter.State.Visible) state).getChannelId(), this.a.d.getText()).toSingleDefault(ContextActionsPresenter.State.Empty.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(singleDefault, "interactor.sendReactionA…ingleDefault(State.Empty)");
                return singleDefault;
            }
        }).doOnError(new Consumer<Throwable>(this) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1.2
            public final /* synthetic */ ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1 a;

            {
                this.a = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.Formatter */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(Throwable th) {
                ContextActionsPresenterImpl contextActionsPresenterImpl = this.a.a;
                Intrinsics.checkNotNullExpressionValue(th, "error");
                contextActionsPresenterImpl.getErrorMessageStream().postValue(contextActionsPresenterImpl.u.format(ThrowablesKt.toAvitoException(th)));
                Logs.debug(this.a.a.getTAG(), "Method call failed", th);
            }
        }).onErrorReturn(new Function<Throwable, ContextActionsPresenter.State>(this) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1.3
            public final /* synthetic */ ContextActionsPresenterImpl$scheduleMethodCall$methodCallMutator$1 a;

            {
                this.a = r1;
            }

            public final ContextActionsPresenter.State apply(@NotNull Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                ContextActionsPresenterImpl contextActionsPresenterImpl = this.a.a;
                ContextActionsPresenter.State state2 = state;
                if (!(state2 instanceof ContextActionsPresenter.State.Visible)) {
                    return state2;
                }
                ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state2;
                return visible.isActionInProgress() ? ContextActionsPresenter.State.Visible.copy$default(visible, null, null, null, null, null, false, null, 95, null) : state2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "interactor.callApiMethod…ActionInProgress(false) }");
        return onErrorReturn;
    }
}
