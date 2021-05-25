package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.conversation.mvi.platform_actions.ChannelData;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetData;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsState;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u00022\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003:\u0002\u0014\u0015B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\b2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePASProducer;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePAState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "channelData", "", "produce", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;)V", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "channelDataId", "reset", "(J)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "ProduceMutator", "ResetMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SamplePlatformActionsStateProducerImpl extends BaseMviEntityWithReducerQueue<SamplePlatformActionsState> implements SamplePlatformActionsStateProducer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl$ProduceMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePAState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "d", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "channelData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl;Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ProduceMutator extends Mutator<SamplePlatformActionsState> {
        public final ChannelData d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProduceMutator(@NotNull SamplePlatformActionsStateProducerImpl samplePlatformActionsStateProducerImpl, ChannelData channelData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(channelData, "channelData");
            this.d = channelData;
        }

        @NotNull
        public SamplePlatformActionsState invoke(@NotNull SamplePlatformActionsState samplePlatformActionsState) {
            Intrinsics.checkNotNullParameter(samplePlatformActionsState, "oldState");
            long j = this.d.id;
            ArrayList arrayList = new ArrayList(30);
            for (int i = 0; i < 30; i++) {
                arrayList.add(new ItemsListSnippetData(String.valueOf(i), a.M2("Item ", i), a.Q2("100", i, " \\u20BD"), null, a.M2("location ", i)));
            }
            return new SamplePlatformActionsState.Visible(j, "Sample Actions", new ListDataSource(arrayList));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl$ResetMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePAState;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "channelDataId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerImpl;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class ResetMutator extends Mutator<SamplePlatformActionsState> {
        public ResetMutator(SamplePlatformActionsStateProducerImpl samplePlatformActionsStateProducerImpl, long j) {
            super(null, null, 3, null);
        }

        @NotNull
        public SamplePlatformActionsState invoke(@NotNull SamplePlatformActionsState samplePlatformActionsState) {
            Intrinsics.checkNotNullParameter(samplePlatformActionsState, "oldState");
            return SamplePlatformActionsState.Empty.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SamplePlatformActionsStateProducerImpl(@NotNull SchedulersFactory schedulersFactory) {
        super("SamplePlatformActionsPresenter", SamplePlatformActionsState.Empty.INSTANCE, schedulersFactory, null, null, null, null, null, 248, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer
    public void produce(@NotNull ChannelData channelData) {
        Intrinsics.checkNotNullParameter(channelData, "channelData");
        getReducerQueue().plusAssign(new ProduceMutator(this, channelData));
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer
    public void reset(long j) {
        getReducerQueue().plusAssign(new ResetMutator(this, j));
    }
}
