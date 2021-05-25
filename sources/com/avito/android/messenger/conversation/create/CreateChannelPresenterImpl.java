package com.avito.android.messenger.conversation.create;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.messenger.conversation.create.CreateChannelInteractor;
import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004#$%&B!\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "", "onCleared", "()V", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "params", "createChannel", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)V", "retry", "", "success", "onAuthResult", "(Z)V", "onPhoneVerificationResult", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "o", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "interactor", "Landroidx/lifecycle/MutableLiveData;", "n", "Landroidx/lifecycle/MutableLiveData;", "getStartPhoneVerificationLiveData", "()Landroidx/lifecycle/MutableLiveData;", "startPhoneVerificationLiveData", AuthSource.OPEN_CHANNEL_LIST, "getStartLoginScreenLiveData", "startLoginScreenLiveData", "savedState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;Lcom/avito/android/util/SchedulersFactory;)V", "AuthResultMutator", "CreateChannelMutator", "PhoneVerificationResultMutator", "RetryMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CreateChannelPresenterImpl extends BaseMviEntityWithMutatorsRelay<CreateChannelPresenter.State> implements CreateChannelPresenter {
    @NotNull
    public final MutableLiveData<Unit> m = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<Unit> n = new SingleLiveEvent();
    public final CreateChannelInteractor o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl$AuthResultMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;)Lio/reactivex/Single;", "Lkotlin/Function1;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "", "d", "Lkotlin/jvm/functions/Function1;", "scheduleCreateChannel", "", "c", "Z", "success", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class AuthResultMutator extends MutatorSingle<CreateChannelPresenter.State> {
        public final boolean c;
        public final Function1<ChannelActivityArguments.Create, Unit> d;

        public static final class a<T> implements Consumer<CreateChannelPresenter.State> {
            public final /* synthetic */ AuthResultMutator a;
            public final /* synthetic */ CreateChannelPresenter.State b;

            public a(AuthResultMutator authResultMutator, CreateChannelPresenter.State state) {
                this.a = authResultMutator;
                this.b = state;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(CreateChannelPresenter.State state) {
                this.a.d.invoke(((CreateChannelPresenter.State.Waiting.Auth) this.b).getCreateParams());
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.messenger.conversation.ChannelActivityArguments$Create, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AuthResultMutator(boolean z, @NotNull Function1<? super ChannelActivityArguments.Create, Unit> function1) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(function1, "scheduleCreateChannel");
            this.c = z;
            this.d = function1;
        }

        @NotNull
        public Single<CreateChannelPresenter.State> invoke(@NotNull CreateChannelPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof CreateChannelPresenter.State.Waiting.Auth)) {
                return Singles.toSingle(state);
            }
            if (!this.c) {
                return Singles.toSingle(CreateChannelPresenter.State.Error.AuthRequired.INSTANCE);
            }
            Single<CreateChannelPresenter.State> doAfterSuccess = Singles.toSingle(new CreateChannelPresenter.State.Waiting.CreateChannel(((CreateChannelPresenter.State.Waiting.Auth) state).getCreateParams())).doAfterSuccess(new a(this, state));
            Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "State.Waiting.CreateChan…(oldState.createParams) }");
            return doAfterSuccess;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl$CreateChannelMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "d", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "c", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "interactor", "Lkotlin/Function0;", "", "f", "Lkotlin/jvm/functions/Function0;", "startPhoneVerification", "e", "startAuth", "<init>", "(Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class CreateChannelMutator extends MutatorSingle<CreateChannelPresenter.State> {
        public final CreateChannelInteractor c;
        public final ChannelActivityArguments.Create d;
        public final Function0<Unit> e;
        public final Function0<Unit> f;

        public static final class a<T, R> implements Function<CreateChannelInteractor.Result, CreateChannelPresenter.State> {
            public final /* synthetic */ CreateChannelMutator a;

            public a(CreateChannelMutator createChannelMutator) {
                this.a = createChannelMutator;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public CreateChannelPresenter.State apply(CreateChannelInteractor.Result result) {
                CreateChannelInteractor.Result result2 = result;
                Intrinsics.checkNotNullParameter(result2, "result");
                if (result2 instanceof CreateChannelInteractor.Result.Success) {
                    return new CreateChannelPresenter.State.Created(this.a.d, ((CreateChannelInteractor.Result.Success) result2).getChannelId());
                }
                if (Intrinsics.areEqual(result2, CreateChannelInteractor.Result.Error.Auth.INSTANCE)) {
                    this.a.e.invoke();
                    return new CreateChannelPresenter.State.Waiting.Auth(this.a.d);
                } else if (Intrinsics.areEqual(result2, CreateChannelInteractor.Result.Error.PhoneVerification.INSTANCE)) {
                    this.a.f.invoke();
                    return new CreateChannelPresenter.State.Waiting.PhoneVerification(this.a.d);
                } else if (Intrinsics.areEqual(result2, CreateChannelInteractor.Result.Error.Forbidden.INSTANCE)) {
                    return CreateChannelPresenter.State.Error.Forbidden.INSTANCE;
                } else {
                    if (result2 instanceof CreateChannelInteractor.Result.Error.Network) {
                        return CreateChannelPresenter.State.Error.Network.INSTANCE;
                    }
                    if (result2 instanceof CreateChannelInteractor.Result.Error.Unknown) {
                        return CreateChannelPresenter.State.Error.Unknown.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateChannelMutator(@NotNull CreateChannelInteractor createChannelInteractor, @NotNull ChannelActivityArguments.Create create, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(createChannelInteractor, "interactor");
            Intrinsics.checkNotNullParameter(create, "createParams");
            Intrinsics.checkNotNullParameter(function0, "startAuth");
            Intrinsics.checkNotNullParameter(function02, "startPhoneVerification");
            this.c = createChannelInteractor;
            this.d = create;
            this.e = function0;
            this.f = function02;
        }

        @NotNull
        public Single<CreateChannelPresenter.State> invoke(@NotNull CreateChannelPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof CreateChannelPresenter.State.Empty) && !(state instanceof CreateChannelPresenter.State.Waiting)) {
                return Singles.toSingle(state);
            }
            if (!(state instanceof CreateChannelPresenter.State.Waiting.CreateChannel) && !(!Intrinsics.areEqual(state.getCreateParams(), this.d))) {
                return Singles.toSingle(state);
            }
            Single<R> map = this.c.getOrCreateChannel(this.d).map(new a(this));
            Intrinsics.checkNotNullExpressionValue(map, "interactor.getOrCreateCh…                        }");
            return map;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl$PhoneVerificationResultMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;)Lio/reactivex/Single;", "", "c", "Z", "success", "Lkotlin/Function1;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "", "d", "Lkotlin/jvm/functions/Function1;", "scheduleCreateChannel", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class PhoneVerificationResultMutator extends MutatorSingle<CreateChannelPresenter.State> {
        public final boolean c;
        public final Function1<ChannelActivityArguments.Create, Unit> d;

        public static final class a<T> implements Consumer<CreateChannelPresenter.State> {
            public final /* synthetic */ PhoneVerificationResultMutator a;
            public final /* synthetic */ CreateChannelPresenter.State b;

            public a(PhoneVerificationResultMutator phoneVerificationResultMutator, CreateChannelPresenter.State state) {
                this.a = phoneVerificationResultMutator;
                this.b = state;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(CreateChannelPresenter.State state) {
                this.a.d.invoke(((CreateChannelPresenter.State.Waiting.PhoneVerification) this.b).getCreateParams());
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.messenger.conversation.ChannelActivityArguments$Create, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhoneVerificationResultMutator(boolean z, @NotNull Function1<? super ChannelActivityArguments.Create, Unit> function1) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(function1, "scheduleCreateChannel");
            this.c = z;
            this.d = function1;
        }

        @NotNull
        public Single<CreateChannelPresenter.State> invoke(@NotNull CreateChannelPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof CreateChannelPresenter.State.Waiting.PhoneVerification)) {
                return Singles.toSingle(state);
            }
            if (!this.c) {
                return Singles.toSingle(CreateChannelPresenter.State.Error.PhoneVerificationRequired.INSTANCE);
            }
            Single<CreateChannelPresenter.State> doAfterSuccess = Singles.toSingle(new CreateChannelPresenter.State.Waiting.CreateChannel(((CreateChannelPresenter.State.Waiting.PhoneVerification) state).getCreateParams())).doAfterSuccess(new a(this, state));
            Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "State.Waiting.CreateChan…(oldState.createParams) }");
            return doAfterSuccess;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl$RetryMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;)Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "Lkotlin/Function1;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "", "d", "Lkotlin/jvm/functions/Function1;", "scheduleCreateChannel", "c", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;Lkotlin/jvm/functions/Function1;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting(otherwise = 3)
    public static final class RetryMutator extends Mutator<CreateChannelPresenter.State> {
        public final ChannelActivityArguments.Create c;
        public final Function1<ChannelActivityArguments.Create, Unit> d;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.messenger.conversation.ChannelActivityArguments$Create, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RetryMutator(@NotNull ChannelActivityArguments.Create create, @NotNull Function1<? super ChannelActivityArguments.Create, Unit> function1) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(create, "createParams");
            Intrinsics.checkNotNullParameter(function1, "scheduleCreateChannel");
            this.c = create;
            this.d = function1;
        }

        @NotNull
        public CreateChannelPresenter.State invoke(@NotNull CreateChannelPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            if (!(state instanceof CreateChannelPresenter.State.Error)) {
                return state;
            }
            this.d.invoke(this.c);
            return new CreateChannelPresenter.State.Waiting.CreateChannel(this.c);
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                MutableLiveData<Unit> startLoginScreenLiveData = ((CreateChannelPresenterImpl) this.b).getStartLoginScreenLiveData();
                Unit unit = Unit.INSTANCE;
                startLoginScreenLiveData.postValue(unit);
                return unit;
            } else if (i == 1) {
                MutableLiveData<Unit> startPhoneVerificationLiveData = ((CreateChannelPresenterImpl) this.b).getStartPhoneVerificationLiveData();
                Unit unit2 = Unit.INSTANCE;
                startPhoneVerificationLiveData.postValue(unit2);
                return unit2;
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CreateChannelPresenterImpl(@NotNull CreateChannelInteractor createChannelInteractor, @NotNull CreateChannelPresenter.State state, @NotNull SchedulersFactory schedulersFactory) {
        super("CreateChannelPresenter", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(createChannelInteractor, "interactor");
        Intrinsics.checkNotNullParameter(state, "savedState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.o = createChannelInteractor;
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter
    public void createChannel(@NotNull ChannelActivityArguments.Create create) {
        Intrinsics.checkNotNullParameter(create, "params");
        getMutatorsRelay().accept(new CreateChannelMutator(this.o, create, new a(0, this), new a(1, this)));
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter
    public void onAuthResult(boolean z) {
        getMutatorsRelay().accept(new AuthResultMutator(z, new Function1<ChannelActivityArguments.Create, Unit>(this) { // from class: com.avito.android.messenger.conversation.create.CreateChannelPresenterImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ChannelActivityArguments.Create create) {
                ChannelActivityArguments.Create create2 = create;
                Intrinsics.checkNotNullParameter(create2, "p1");
                ((CreateChannelPresenterImpl) this.receiver).createChannel(create2);
                return Unit.INSTANCE;
            }
        }));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        Logs.verbose$default(getTAG(), "Cleared", null, 4, null);
        super.onCleared();
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter
    public void onPhoneVerificationResult(boolean z) {
        getMutatorsRelay().accept(new PhoneVerificationResultMutator(z, new Function1<ChannelActivityArguments.Create, Unit>(this) { // from class: com.avito.android.messenger.conversation.create.CreateChannelPresenterImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ChannelActivityArguments.Create create) {
                ChannelActivityArguments.Create create2 = create;
                Intrinsics.checkNotNullParameter(create2, "p1");
                ((CreateChannelPresenterImpl) this.receiver).createChannel(create2);
                return Unit.INSTANCE;
            }
        }));
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter
    public void retry(@NotNull ChannelActivityArguments.Create create) {
        Intrinsics.checkNotNullParameter(create, "params");
        Relay mutatorsRelay = getMutatorsRelay();
        RetryMutator retryMutator = new RetryMutator(create, new Function1<ChannelActivityArguments.Create, Unit>(this) { // from class: com.avito.android.messenger.conversation.create.CreateChannelPresenterImpl.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ChannelActivityArguments.Create create2) {
                ChannelActivityArguments.Create create3 = create2;
                Intrinsics.checkNotNullParameter(create3, "p1");
                ((CreateChannelPresenterImpl) this.receiver).createChannel(create3);
                return Unit.INSTANCE;
            }
        });
        mutatorsRelay.accept(new MutatorSingle(retryMutator.getName(), new CreateChannelPresenterImpl$retry$$inlined$plusAssign$1(retryMutator)));
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter
    @NotNull
    public MutableLiveData<Unit> getStartLoginScreenLiveData() {
        return this.m;
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter
    @NotNull
    public MutableLiveData<Unit> getStartPhoneVerificationLiveData() {
        return this.n;
    }
}
