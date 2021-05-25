package com.avito.android.messenger.conversation.mvi.reply_suggests;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\b¢\u0006\u0004\b\u0005\u0010\u0006\"1\u0010\u0001\u001a\u00020\u0000*\u0018\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00020\u0004j\u0002`\u00078À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"7\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002*\u0018\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00020\u0004j\u0002`\u00078À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*0\b\u0000\u0010\f\"\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00020\u00042\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00020\u0004¨\u0006\r"}, d2 = {"", "message", "", "templates", "Lkotlin/Pair;", "textMessageAndTemplates", "(Ljava/lang/String;Ljava/util/List;)Lkotlin/Pair;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/TextMessageAndTemplates;", "getMessage", "(Lkotlin/Pair;)Ljava/lang/String;", "getTemplates", "(Lkotlin/Pair;)Ljava/util/List;", "TextMessageAndTemplates", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelReplySuggestsPresenterKt {
    @NotNull
    public static final String getMessage(@NotNull Pair<String, ? extends List<String>> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$message");
        return pair.getFirst();
    }

    @NotNull
    public static final List<String> getTemplates(@NotNull Pair<String, ? extends List<String>> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$templates");
        return (List) pair.getSecond();
    }

    @NotNull
    public static final Pair<String, List<String>> textMessageAndTemplates(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(list, "templates");
        return TuplesKt.to(str, list);
    }
}
