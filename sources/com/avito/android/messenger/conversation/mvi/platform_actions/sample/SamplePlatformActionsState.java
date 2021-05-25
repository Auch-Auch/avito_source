package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemsListSnippetData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012R \u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\u000f\u001a\u00060\tj\u0002`\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateKey;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "Companion", "Empty", "Visible", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Visible;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class SamplePlatformActionsState implements PlatformActionsState {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY = "SamplePlatformActionsState";
    @NotNull
    public final Object a = KEY;
    public final long b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Companion;", "", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Empty extends SamplePlatformActionsState {
        @NotNull
        public static final Empty INSTANCE = new Empty();

        public Empty() {
            super(-1, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Visible;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemsListSnippetData;", "d", "Lcom/avito/konveyor/data_source/DataSource;", "getItemsDataSource", "()Lcom/avito/konveyor/data_source/DataSource;", "itemsDataSource", "", "c", "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "title", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "id", "<init>", "(JLjava/lang/CharSequence;Lcom/avito/konveyor/data_source/DataSource;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Visible extends SamplePlatformActionsState {
        @NotNull
        public final CharSequence c;
        @NotNull
        public final DataSource<ItemsListSnippetData> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Visible(long j, @NotNull CharSequence charSequence, @NotNull DataSource<ItemsListSnippetData> dataSource) {
            super(j, null);
            Intrinsics.checkNotNullParameter(charSequence, "title");
            Intrinsics.checkNotNullParameter(dataSource, "itemsDataSource");
            this.c = charSequence;
            this.d = dataSource;
        }

        @NotNull
        public final DataSource<ItemsListSnippetData> getItemsDataSource() {
            return this.d;
        }

        @NotNull
        public final CharSequence getTitle() {
            return this.c;
        }
    }

    public SamplePlatformActionsState(long j, j jVar) {
        this.b = j;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState
    public long getId() {
        return this.b;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState
    @NotNull
    public Object getKey() {
        return this.a;
    }
}
