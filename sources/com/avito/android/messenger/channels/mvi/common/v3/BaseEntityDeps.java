package com.avito.android.messenger.channels.mvi.common.v3;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0001\nR\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "", "PartialStateT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;", "Lio/reactivex/disposables/Disposable;", "Lcom/jakewharton/rxrelay2/Relay;", "", "getPartialStatesStream", "()Lcom/jakewharton/rxrelay2/Relay;", "partialStatesStream", "Impl", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface BaseEntityDeps<PartialStateT> extends BaseEventDeps<PartialStateT>, Disposable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR&\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R%\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps$Impl;", "", "PartialStateT", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEntityDeps;", "", "isDisposed", "()Z", "", "dispose", "()V", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "Lkotlin/reflect/KMutableProperty0;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "getStateLock", "()Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "stateLock", "Lcom/jakewharton/rxrelay2/Relay;", "", "c", "Lcom/jakewharton/rxrelay2/Relay;", "getPartialStatesConsumer", "()Lcom/jakewharton/rxrelay2/Relay;", "partialStatesConsumer", "", "d", "Ljava/lang/String;", "getEntityTag", "()Ljava/lang/String;", "entityTag", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.BOOKING_ORDER, "getPartialStatesStream", "partialStatesStream", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static class Impl<PartialStateT> implements BaseEntityDeps<PartialStateT> {
        @NotNull
        public final RxFairCompositeReadWriteLock<KMutableProperty0<?>> a;
        @NotNull
        public final Relay<Set<PartialStateT>> b;
        @NotNull
        public final Relay<Set<PartialStateT>> c;
        @NotNull
        public final String d;
        @NotNull
        public final SchedulersFactory e;

        public static final class a extends Lambda implements Function0<Scheduler> {
            public final /* synthetic */ Impl a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Impl impl) {
                super(0);
                this.a = impl;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Scheduler invoke() {
                return this.a.getSchedulers().io();
            }
        }

        public Impl(@NotNull String str, @NotNull SchedulersFactory schedulersFactory) {
            Intrinsics.checkNotNullParameter(str, "entityTag");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
            this.d = str;
            this.e = schedulersFactory;
            this.a = new RxFairCompositeReadWriteLock<>(a2.b.a.a.a.c3(str, "-stateLock"), new a(this), new EqualsBasedOverlapChecker(), PropertyToStringConverter.INSTANCE, false, null, null, null, 240, null);
            Relay<Set<PartialStateT>> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
            this.b = J1;
            this.c = J1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            getStateLock().dispose();
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEventDeps
        @NotNull
        public final String getEntityTag() {
            return this.d;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEntityDeps
        @NotNull
        public final Relay<Set<PartialStateT>> getPartialStatesStream() {
            return this.b;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEventDeps
        @NotNull
        public final SchedulersFactory getSchedulers() {
            return this.e;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEventDeps
        @NotNull
        public RxFairCompositeReadWriteLock<KMutableProperty0<?>> getStateLock() {
            return this.a;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return getStateLock().isDisposed();
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v3.BaseEventDeps
        @NotNull
        public Relay<Set<PartialStateT>> getPartialStatesConsumer() {
            return this.c;
        }
    }

    @NotNull
    Relay<Set<PartialStateT>> getPartialStatesStream();
}
