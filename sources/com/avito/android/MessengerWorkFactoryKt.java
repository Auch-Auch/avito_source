package com.avito.android;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a,\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\u0005\u0010\u0006\"(\u0010\u0001\u001a\u00020\u0000*\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00078Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"(\u0010\u0003\u001a\u00020\u0002*\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00078Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*\"\u0010\f\"\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004¨\u0006\r"}, d2 = {"", "tag", "Ljava/util/UUID;", "id", "Lkotlin/Pair;", "workTagAndId", "(Ljava/lang/String;Ljava/util/UUID;)Lkotlin/Pair;", "Lcom/avito/android/WorkTagAndId;", "getTag", "(Lkotlin/Pair;)Ljava/lang/String;", "getId", "(Lkotlin/Pair;)Ljava/util/UUID;", "WorkTagAndId", "core_release"}, k = 2, mv = {1, 4, 2})
public final class MessengerWorkFactoryKt {
    @NotNull
    public static final UUID getId(@NotNull Pair<String, UUID> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$id");
        return pair.getSecond();
    }

    @NotNull
    public static final String getTag(@NotNull Pair<String, UUID> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$tag");
        return pair.getFirst();
    }

    @NotNull
    public static final Pair<String, UUID> workTagAndId(@NotNull String str, @NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(uuid, "id");
        return TuplesKt.to(str, uuid);
    }
}
