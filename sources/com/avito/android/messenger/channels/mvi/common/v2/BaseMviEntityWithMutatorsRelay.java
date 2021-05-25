package com.avito.android.messenger.channels.mvi.common.v2;

import a2.b.a.a.a;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B5\u0012\u0006\u0010&\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00028\u0000\u0012\u0006\u0010)\u001a\u00020(\u0012\u0014\b\u0002\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050 ¢\u0006\u0004\b*\u0010+J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007JF\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\t\u001a\u00020\b2#\b\b\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u00000\nH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\t\u001a\u00020\b2)\b\b\u0010\r\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\nH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u0016\u001a\u0017\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f0\u00152\u0006\u0010\t\u001a\u00020\b2#\b\b\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00140\nH\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017JY\u0010\u0019\u001a\u0017\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f0\u00182\u0006\u0010\t\u001a\u00020\b2'\b\b\u0010\r\u001a!\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\nH\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ@\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2#\b\b\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u00000\nH\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJF\u0010\u001d\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2)\b\b\u0010\r\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\nH\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ@\u0010\u001e\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2#\b\b\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00140\nH\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJD\u0010\u001f\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2'\b\b\u0010\r\u001a!\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\nH\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001cR(\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntity;", "Lio/reactivex/Observable;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "mutatorsObservable", "()Lio/reactivex/Observable;", "", "name", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "oldState", "block", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "mutator", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lio/reactivex/Single;", "mutatorSingle", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "action", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "actionSingle", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "dispatchMutator", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "dispatchMutatorSingle", "dispatchAction", "dispatchActionSingle", "Lcom/jakewharton/rxrelay2/Relay;", "l", "Lcom/jakewharton/rxrelay2/Relay;", "getMutatorsRelay", "()Lcom/jakewharton/rxrelay2/Relay;", "mutatorsRelay", "TAG", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lcom/avito/android/util/SchedulersFactory;Lcom/jakewharton/rxrelay2/Relay;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseMviEntityWithMutatorsRelay<StateT> extends BaseMviEntity<StateT> {
    @NotNull
    public final Relay<MutatorSingle<StateT>> l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMviEntityWithMutatorsRelay(@NotNull String str, @NotNull StateT statet, @NotNull SchedulersFactory schedulersFactory, @NotNull Relay<MutatorSingle<StateT>> relay) {
        super(str, statet, schedulersFactory);
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(statet, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(relay, "mutatorsRelay");
        this.l = relay;
        initialize().blockingGet();
    }

    @NotNull
    public final Action<StateT> action(@NotNull String str, @NotNull Function1<? super StateT, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new Action<>(str, function1);
    }

    @NotNull
    public final ActionSingle<StateT> actionSingle(@NotNull String str, @NotNull Function1<? super StateT, ? extends Single<?>> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new ActionSingle<>(str, function1);
    }

    public final void dispatchAction(@NotNull String str, @NotNull Function1<? super StateT, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        Relay relay = this.l;
        Action action = new Action(str, function1);
        relay.accept(new MutatorSingle(action.getName(), new BaseMviEntityKt$toMutatorSingle$2(action)));
    }

    public final void dispatchActionSingle(@NotNull String str, @NotNull Function1<? super StateT, ? extends Single<?>> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        Relay relay = this.l;
        ActionSingle actionSingle = new ActionSingle(str, function1);
        relay.accept(new MutatorSingle(actionSingle.getName(), new BaseMviEntityKt$toMutatorSingle$3(actionSingle)));
    }

    public final void dispatchMutator(@NotNull String str, @NotNull Function1<? super StateT, ? extends StateT> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        Relay relay = this.l;
        Mutator mutator = new Mutator(str, function1);
        relay.accept(new MutatorSingle(mutator.getName(), new BaseMviEntityKt$toMutatorSingle$1(mutator)));
    }

    public final void dispatchMutatorSingle(@NotNull String str, @NotNull Function1<? super StateT, ? extends Single<StateT>> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.l.accept(new MutatorSingle(str, function1));
    }

    @NotNull
    public final Relay<MutatorSingle<StateT>> getMutatorsRelay() {
        return this.l;
    }

    @NotNull
    public final Mutator<StateT> mutator(@NotNull String str, @NotNull Function1<? super StateT, ? extends StateT> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new Mutator<>(str, function1);
    }

    @NotNull
    public final MutatorSingle<StateT> mutatorSingle(@NotNull String str, @NotNull Function1<? super StateT, ? extends Single<StateT>> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new MutatorSingle<>(str, function1);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity
    @NotNull
    public Observable<MutatorSingle<StateT>> mutatorsObservable() {
        return this.l;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseMviEntityWithMutatorsRelay(String str, Object obj, SchedulersFactory schedulersFactory, Relay relay, int i, j jVar) {
        this(str, obj, schedulersFactory, (i & 8) != 0 ? a.J1("PublishRelay.create<T>().toSerialized()") : relay);
    }
}
