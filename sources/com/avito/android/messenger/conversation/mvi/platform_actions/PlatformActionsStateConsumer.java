package com.avito.android.messenger.conversation.mvi.platform_actions;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\n\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J+\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0016\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00050\u0018*\u0006\u0012\u0002\b\u00030\u00002\u001a\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u0000H&¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001d8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR.\u0010$\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00050\u00180!*\u0006\u0012\u0002\b\u00030\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\u00060\u0003j\u0002`%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R&\u0010*\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00050\u00180\u001d8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001fR.\u0010,\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u001d8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001fR6\u00102\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010-*\u0006\u0012\u0002\b\u00030\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R6\u00104\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040!*\u0006\u0012\u0002\b\u00030\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010#R$\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010!*\u0006\u0012\u0002\b\u00030\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010#¨\u00067"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", ExifInterface.LATITUDE_SOUTH, "", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateKey;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer;", "producers", "", "bind", "(Ljava/util/Map;)V", "unbind", "()V", "state", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "consume", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "stateConsumed", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;)V", "prevState", "curState", "doConsume", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "", "doBind", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;Ljava/util/Map;)Ljava/util/Set;", "doUnbind", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)V", "Lio/reactivex/Observable;", "getConsumedStream", "()Lio/reactivex/Observable;", "consumedStream", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getUnboundRelay", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Lcom/jakewharton/rxrelay2/PublishRelay;", "unboundRelay", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumerKey;", "getConsumerKey", "()Ljava/lang/Object;", "consumerKey", "getUnboundStream", "unboundStream", "getBoundStream", "boundStream", "", "getLastConsumedStatesByKey", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Ljava/util/Map;", "setLastConsumedStatesByKey", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;Ljava/util/Map;)V", "lastConsumedStatesByKey", "getBoundRelay", "boundRelay", "getConsumedRelay", "consumedRelay", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformActionsStateConsumer<S extends PlatformActionsState> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <S extends PlatformActionsState> void bind(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map) {
            Intrinsics.checkNotNullParameter(map, "producers");
            for (T t : platformActionsStateConsumer.doBind(platformActionsStateConsumer, map)) {
                if (!platformActionsStateConsumer.getLastConsumedStatesByKey(platformActionsStateConsumer).containsKey(t)) {
                    platformActionsStateConsumer.getLastConsumedStatesByKey(platformActionsStateConsumer).put(t, null);
                }
            }
            platformActionsStateConsumer.getBoundRelay(platformActionsStateConsumer).accept(platformActionsStateConsumer.getLastConsumedStatesByKey(platformActionsStateConsumer));
        }

        public static <S extends PlatformActionsState> void consume(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer, @NotNull PlatformActionsState platformActionsState, @Nullable DiffUtil.DiffResult diffResult) {
            Intrinsics.checkNotNullParameter(platformActionsState, "state");
            platformActionsStateConsumer.doConsume(platformActionsStateConsumer, platformActionsStateConsumer.getLastConsumedStatesByKey(platformActionsStateConsumer).get(platformActionsState.getKey()), platformActionsState, diffResult);
        }

        public static /* synthetic */ void consume$default(PlatformActionsStateConsumer platformActionsStateConsumer, PlatformActionsState platformActionsState, DiffUtil.DiffResult diffResult, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    diffResult = null;
                }
                platformActionsStateConsumer.consume(platformActionsState, diffResult);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consume");
        }

        public static /* synthetic */ void doConsume$default(PlatformActionsStateConsumer platformActionsStateConsumer, PlatformActionsStateConsumer platformActionsStateConsumer2, PlatformActionsState platformActionsState, PlatformActionsState platformActionsState2, DiffUtil.DiffResult diffResult, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    diffResult = null;
                }
                platformActionsStateConsumer.doConsume(platformActionsStateConsumer2, platformActionsState, platformActionsState2, diffResult);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doConsume");
        }

        @NotNull
        public static <S extends PlatformActionsState> Observable<Map<Object, PlatformActionsState>> getBoundStream(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer) {
            return platformActionsStateConsumer.getBoundRelay(platformActionsStateConsumer);
        }

        @NotNull
        public static <S extends PlatformActionsState> Observable<PlatformActionsState> getConsumedStream(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer) {
            return platformActionsStateConsumer.getConsumedRelay(platformActionsStateConsumer);
        }

        @NotNull
        public static <S extends PlatformActionsState> Observable<Set<Object>> getUnboundStream(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer) {
            return platformActionsStateConsumer.getUnboundRelay(platformActionsStateConsumer);
        }

        public static <S extends PlatformActionsState> void stateConsumed(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer, @NotNull PlatformActionsState platformActionsState) {
            Intrinsics.checkNotNullParameter(platformActionsState, "state");
            platformActionsStateConsumer.getLastConsumedStatesByKey(platformActionsStateConsumer).put(platformActionsState.getKey(), platformActionsState);
            platformActionsStateConsumer.getConsumedRelay(platformActionsStateConsumer).accept(platformActionsState);
        }

        public static <S extends PlatformActionsState> void unbind(@NotNull PlatformActionsStateConsumer<S> platformActionsStateConsumer) {
            platformActionsStateConsumer.doUnbind(platformActionsStateConsumer);
            platformActionsStateConsumer.getUnboundRelay(platformActionsStateConsumer).accept(platformActionsStateConsumer.getLastConsumedStatesByKey(platformActionsStateConsumer).keySet());
        }
    }

    void bind(@NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map);

    void consume(@NotNull PlatformActionsState platformActionsState, @Nullable DiffUtil.DiffResult diffResult);

    @NotNull
    Set<Object> doBind(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map);

    void doConsume(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer, @Nullable PlatformActionsState platformActionsState, @NotNull PlatformActionsState platformActionsState2, @Nullable DiffUtil.DiffResult diffResult);

    void doUnbind(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer);

    @NotNull
    PublishRelay<Map<Object, PlatformActionsState>> getBoundRelay(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer);

    @NotNull
    Observable<Map<Object, PlatformActionsState>> getBoundStream();

    @NotNull
    PublishRelay<PlatformActionsState> getConsumedRelay(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer);

    @NotNull
    Observable<PlatformActionsState> getConsumedStream();

    @NotNull
    Object getConsumerKey();

    @NotNull
    Map<Object, PlatformActionsState> getLastConsumedStatesByKey(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer);

    @NotNull
    PublishRelay<Set<Object>> getUnboundRelay(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer);

    @NotNull
    Observable<Set<Object>> getUnboundStream();

    void setLastConsumedStatesByKey(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer, @NotNull Map<Object, PlatformActionsState> map);

    void stateConsumed(@NotNull PlatformActionsState platformActionsState);

    void unbind();
}
