package a2.a.a.o1.b.b.d;

import com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker;
import com.avito.android.messenger.channels.mvi.sync.ChannelsKey;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.z;
public final class c implements OverlapChecker<ChannelsKey> {
    @NotNull
    public static final c a = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker
    public boolean checkOverlap(ChannelsKey channelsKey, ChannelsKey channelsKey2) {
        ChannelsKey channelsKey3 = channelsKey;
        ChannelsKey channelsKey4 = channelsKey2;
        Intrinsics.checkNotNullParameter(channelsKey3, "key");
        Intrinsics.checkNotNullParameter(channelsKey4, "otherKey");
        ChannelsKey.All all = ChannelsKey.All.INSTANCE;
        if (!Intrinsics.areEqual(channelsKey3, all)) {
            if (channelsKey3 instanceof ChannelsKey.Id) {
                if (!Intrinsics.areEqual(channelsKey4, all)) {
                    if (channelsKey4 instanceof ChannelsKey.Id) {
                        return Intrinsics.areEqual(((ChannelsKey.Id) channelsKey3).getChannelId(), ((ChannelsKey.Id) channelsKey4).getChannelId());
                    }
                    if (!(channelsKey4 instanceof ChannelsKey.Tags)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else if (!(channelsKey3 instanceof ChannelsKey.Tags)) {
                throw new NoWhenBranchMatchedException();
            } else if (!Intrinsics.areEqual(channelsKey4, all) && !(channelsKey4 instanceof ChannelsKey.Id)) {
                if (channelsKey4 instanceof ChannelsKey.Tags) {
                    ChannelsKey.Tags tags = (ChannelsKey.Tags) channelsKey3;
                    if (!tags.getIncludeTags().isEmpty()) {
                        ChannelsKey.Tags tags2 = (ChannelsKey.Tags) channelsKey4;
                        if (!tags2.getIncludeTags().isEmpty()) {
                            if (CollectionsKt___CollectionsKt.intersect(tags.getIncludeTags(), tags2.getIncludeTags()).isEmpty()) {
                                return false;
                            }
                        }
                    }
                    if (!tags.getIncludeTags().isEmpty()) {
                        ChannelsKey.Tags tags3 = (ChannelsKey.Tags) channelsKey4;
                        if (tags3.getIncludeTags().isEmpty()) {
                            if (z.minus((Set) tags.getIncludeTags(), (Iterable) tags3.getExcludeTags()).isEmpty()) {
                                return false;
                            }
                        }
                    }
                    if (tags.getIncludeTags().isEmpty()) {
                        ChannelsKey.Tags tags4 = (ChannelsKey.Tags) channelsKey4;
                        if ((!tags4.getIncludeTags().isEmpty()) && z.minus((Set) tags4.getIncludeTags(), (Iterable) tags.getExcludeTags()).isEmpty()) {
                            return false;
                        }
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return true;
    }
}
