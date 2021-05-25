package com.avito.android.messenger.conversation.mvi.platform_actions;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015J;\u0010\f\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u001e\u0010\n\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\u0006H&¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0012\u001a\u00060\bj\u0002`\tH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumerKey;", "consumerKey", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PAState;", "previouslyConsumedStatesByKey", "", "consumerBound", "(Ljava/lang/Object;Ljava/util/Map;)V", "", "consumedStateKeys", "consumerUnbound", "(Ljava/lang/Object;Ljava/util/Set;)V", "state", "stateConsumed", "(Ljava/lang/Object;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;)V", "CoordinatorState", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformActionsCoordinator extends MviEntity<CoordinatorState> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u0000 C2\u00020\u0001:\u0002CDB±\u0001\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00060\u0005\u0012\u0018\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\nj\u0006\u0012\u0002\b\u0003`\u000b0\t\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\"\u0010\u001f\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\u0012j\u0006\u0012\u0002\b\u0003`\u00130\u0011\u0012\u001a\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0011\u0012*\u0010!\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0019\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u00110\u0011¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\nj\u0006\u0012\u0002\b\u0003`\u000b0\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0014\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\u0012j\u0006\u0012\u0002\b\u0003`\u00130\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0011HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J4\u0010\u001a\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0019\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u00110\u0011HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0015JÈ\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00060\u00052\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\nj\u0006\u0012\u0002\b\u0003`\u000b0\t2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2$\b\u0002\u0010\u001f\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\u0012j\u0006\u0012\u0002\b\u0003`\u00130\u00112\u001c\b\u0002\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u00112,\b\u0002\u0010!\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0019\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u00110\u0011HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R-\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0015R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0004R#\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\bR=\u0010!\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0019\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u00110\u00118\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u0010\u0015R\u0019\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0010R+\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\nj\u0006\u0012\u0002\b\u0003`\u000b0\t8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\rR5\u0010\u001f\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\u0012j\u0006\u0012\u0002\b\u0003`\u00130\u00118\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010/\u001a\u0004\b@\u0010\u0015¨\u0006E"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "component2", "()Ljava/util/Set;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer$Factory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASProducerFactory;", "component3", "()Ljava/util/List;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "component4", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASProducer;", "component5", "()Ljava/util/Map;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/CDId;", "component6", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumerKey;", "component7", "channelData", "compatibleStateKeys", "compatibleFactories", "processingStep", "stateProducersByKey", "producedStateIdsByKey", "consumedStateIdsByKey", "copy", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;Ljava/util/Set;Ljava/util/List;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/util/Map;", "getProducedStateIdsByKey", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "getChannelData", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "getCompatibleStateKeys", g.a, "getConsumedStateIdsByKey", "d", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "getProcessingStep", "c", "Ljava/util/List;", "getCompatibleFactories", "e", "getStateProducersByKey", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;Ljava/util/Set;Ljava/util/List;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "Companion", "ProcessingStep", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CoordinatorState {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final CoordinatorState h = new CoordinatorState(null, y.emptySet(), CollectionsKt__CollectionsKt.emptyList(), ProcessingStep.Finished.INSTANCE, r.emptyMap(), r.emptyMap(), r.emptyMap());
        @Nullable
        public final ChannelData a;
        @NotNull
        public final Set<Object> b;
        @NotNull
        public final List<PlatformActionsStateProducer.Factory<?>> c;
        @NotNull
        public final ProcessingStep d;
        @NotNull
        public final Map<Object, PlatformActionsStateProducer<?>> e;
        @NotNull
        public final Map<Object, Long> f;
        @NotNull
        public final Map<Object, Map<Object, Long>> g;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$Companion;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "getDEFAULT", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final CoordinatorState getDEFAULT() {
                return CoordinatorState.h;
            }

            public Companion(j jVar) {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "", "<init>", "()V", "CompatibleProducersAreNotReady", "Finished", "IncompatibleConsumersAreNotReady", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep$IncompatibleConsumersAreNotReady;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep$CompatibleProducersAreNotReady;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep$Finished;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class ProcessingStep {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep$CompatibleProducersAreNotReady;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class CompatibleProducersAreNotReady extends ProcessingStep {
                @NotNull
                public static final CompatibleProducersAreNotReady INSTANCE = new CompatibleProducersAreNotReady();

                public CompatibleProducersAreNotReady() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep$Finished;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Finished extends ProcessingStep {
                @NotNull
                public static final Finished INSTANCE = new Finished();

                public Finished() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep$IncompatibleConsumersAreNotReady;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsCoordinator$CoordinatorState$ProcessingStep;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class IncompatibleConsumersAreNotReady extends ProcessingStep {
                @NotNull
                public static final IncompatibleConsumersAreNotReady INSTANCE = new IncompatibleConsumersAreNotReady();

                public IncompatibleConsumersAreNotReady() {
                    super(null);
                }
            }

            public ProcessingStep() {
            }

            public ProcessingStep(j jVar) {
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer$Factory<?>> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<java.lang.Object, ? extends com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer<?>> */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<java.lang.Object, ? extends java.util.Map<java.lang.Object, java.lang.Long>> */
        /* JADX WARN: Multi-variable type inference failed */
        public CoordinatorState(@Nullable ChannelData channelData, @NotNull Set<? extends Object> set, @NotNull List<? extends PlatformActionsStateProducer.Factory<?>> list, @NotNull ProcessingStep processingStep, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map, @NotNull Map<Object, Long> map2, @NotNull Map<Object, ? extends Map<Object, Long>> map3) {
            Intrinsics.checkNotNullParameter(set, "compatibleStateKeys");
            Intrinsics.checkNotNullParameter(list, "compatibleFactories");
            Intrinsics.checkNotNullParameter(processingStep, "processingStep");
            Intrinsics.checkNotNullParameter(map, "stateProducersByKey");
            Intrinsics.checkNotNullParameter(map2, "producedStateIdsByKey");
            Intrinsics.checkNotNullParameter(map3, "consumedStateIdsByKey");
            this.a = channelData;
            this.b = set;
            this.c = list;
            this.d = processingStep;
            this.e = map;
            this.f = map2;
            this.g = map3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator$CoordinatorState */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CoordinatorState copy$default(CoordinatorState coordinatorState, ChannelData channelData, Set set, List list, ProcessingStep processingStep, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                channelData = coordinatorState.a;
            }
            if ((i & 2) != 0) {
                set = coordinatorState.b;
            }
            if ((i & 4) != 0) {
                list = coordinatorState.c;
            }
            if ((i & 8) != 0) {
                processingStep = coordinatorState.d;
            }
            if ((i & 16) != 0) {
                map = coordinatorState.e;
            }
            if ((i & 32) != 0) {
                map2 = coordinatorState.f;
            }
            if ((i & 64) != 0) {
                map3 = coordinatorState.g;
            }
            return coordinatorState.copy(channelData, set, list, processingStep, map, map2, map3);
        }

        @Nullable
        public final ChannelData component1() {
            return this.a;
        }

        @NotNull
        public final Set<Object> component2() {
            return this.b;
        }

        @NotNull
        public final List<PlatformActionsStateProducer.Factory<?>> component3() {
            return this.c;
        }

        @NotNull
        public final ProcessingStep component4() {
            return this.d;
        }

        @NotNull
        public final Map<Object, PlatformActionsStateProducer<?>> component5() {
            return this.e;
        }

        @NotNull
        public final Map<Object, Long> component6() {
            return this.f;
        }

        @NotNull
        public final Map<Object, Map<Object, Long>> component7() {
            return this.g;
        }

        @NotNull
        public final CoordinatorState copy(@Nullable ChannelData channelData, @NotNull Set<? extends Object> set, @NotNull List<? extends PlatformActionsStateProducer.Factory<?>> list, @NotNull ProcessingStep processingStep, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map, @NotNull Map<Object, Long> map2, @NotNull Map<Object, ? extends Map<Object, Long>> map3) {
            Intrinsics.checkNotNullParameter(set, "compatibleStateKeys");
            Intrinsics.checkNotNullParameter(list, "compatibleFactories");
            Intrinsics.checkNotNullParameter(processingStep, "processingStep");
            Intrinsics.checkNotNullParameter(map, "stateProducersByKey");
            Intrinsics.checkNotNullParameter(map2, "producedStateIdsByKey");
            Intrinsics.checkNotNullParameter(map3, "consumedStateIdsByKey");
            return new CoordinatorState(channelData, set, list, processingStep, map, map2, map3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CoordinatorState)) {
                return false;
            }
            CoordinatorState coordinatorState = (CoordinatorState) obj;
            return Intrinsics.areEqual(this.a, coordinatorState.a) && Intrinsics.areEqual(this.b, coordinatorState.b) && Intrinsics.areEqual(this.c, coordinatorState.c) && Intrinsics.areEqual(this.d, coordinatorState.d) && Intrinsics.areEqual(this.e, coordinatorState.e) && Intrinsics.areEqual(this.f, coordinatorState.f) && Intrinsics.areEqual(this.g, coordinatorState.g);
        }

        @Nullable
        public final ChannelData getChannelData() {
            return this.a;
        }

        @NotNull
        public final List<PlatformActionsStateProducer.Factory<?>> getCompatibleFactories() {
            return this.c;
        }

        @NotNull
        public final Set<Object> getCompatibleStateKeys() {
            return this.b;
        }

        @NotNull
        public final Map<Object, Map<Object, Long>> getConsumedStateIdsByKey() {
            return this.g;
        }

        @NotNull
        public final ProcessingStep getProcessingStep() {
            return this.d;
        }

        @NotNull
        public final Map<Object, Long> getProducedStateIdsByKey() {
            return this.f;
        }

        @NotNull
        public final Map<Object, PlatformActionsStateProducer<?>> getStateProducersByKey() {
            return this.e;
        }

        public int hashCode() {
            ChannelData channelData = this.a;
            int i = 0;
            int hashCode = (channelData != null ? channelData.hashCode() : 0) * 31;
            Set<Object> set = this.b;
            int hashCode2 = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
            List<PlatformActionsStateProducer.Factory<?>> list = this.c;
            int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            ProcessingStep processingStep = this.d;
            int hashCode4 = (hashCode3 + (processingStep != null ? processingStep.hashCode() : 0)) * 31;
            Map<Object, PlatformActionsStateProducer<?>> map = this.e;
            int hashCode5 = (hashCode4 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Object, Long> map2 = this.f;
            int hashCode6 = (hashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Object, Map<Object, Long>> map3 = this.g;
            if (map3 != null) {
                i = map3.hashCode();
            }
            return hashCode6 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("CoordinatorState(channelData=");
            L.append(this.a);
            L.append(", compatibleStateKeys=");
            L.append(this.b);
            L.append(", compatibleFactories=");
            L.append(this.c);
            L.append(", processingStep=");
            L.append(this.d);
            L.append(", stateProducersByKey=");
            L.append(this.e);
            L.append(", producedStateIdsByKey=");
            L.append(this.f);
            L.append(", consumedStateIdsByKey=");
            return a.x(L, this.g, ")");
        }
    }

    void consumerBound(@NotNull Object obj, @NotNull Map<Object, ? extends PlatformActionsState> map);

    void consumerUnbound(@NotNull Object obj, @NotNull Set<? extends Object> set);

    void stateConsumed(@NotNull Object obj, @NotNull PlatformActionsState platformActionsState);
}
