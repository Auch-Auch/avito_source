package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import io.reactivex.Observable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SamplePlatformActionsView extends PlatformActionsStateConsumer<SamplePlatformActionsState> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void bind(@NotNull SamplePlatformActionsView samplePlatformActionsView, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map) {
            Intrinsics.checkNotNullParameter(map, "producers");
            PlatformActionsStateConsumer.DefaultImpls.bind(samplePlatformActionsView, map);
        }

        public static void consume(@NotNull SamplePlatformActionsView samplePlatformActionsView, @NotNull PlatformActionsState platformActionsState, @Nullable DiffUtil.DiffResult diffResult) {
            Intrinsics.checkNotNullParameter(platformActionsState, "state");
            PlatformActionsStateConsumer.DefaultImpls.consume(samplePlatformActionsView, platformActionsState, diffResult);
        }

        @NotNull
        public static Observable<Map<Object, PlatformActionsState>> getBoundStream(@NotNull SamplePlatformActionsView samplePlatformActionsView) {
            return PlatformActionsStateConsumer.DefaultImpls.getBoundStream(samplePlatformActionsView);
        }

        @NotNull
        public static Observable<PlatformActionsState> getConsumedStream(@NotNull SamplePlatformActionsView samplePlatformActionsView) {
            return PlatformActionsStateConsumer.DefaultImpls.getConsumedStream(samplePlatformActionsView);
        }

        @NotNull
        public static Observable<Set<Object>> getUnboundStream(@NotNull SamplePlatformActionsView samplePlatformActionsView) {
            return PlatformActionsStateConsumer.DefaultImpls.getUnboundStream(samplePlatformActionsView);
        }

        public static void stateConsumed(@NotNull SamplePlatformActionsView samplePlatformActionsView, @NotNull PlatformActionsState platformActionsState) {
            Intrinsics.checkNotNullParameter(platformActionsState, "state");
            PlatformActionsStateConsumer.DefaultImpls.stateConsumed(samplePlatformActionsView, platformActionsState);
        }

        public static void unbind(@NotNull SamplePlatformActionsView samplePlatformActionsView) {
            PlatformActionsStateConsumer.DefaultImpls.unbind(samplePlatformActionsView);
        }
    }
}
