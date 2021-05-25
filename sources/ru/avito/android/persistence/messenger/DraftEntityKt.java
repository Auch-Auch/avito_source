package ru.avito.android.persistence.messenger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/avito/android/persistence/messenger/DraftEntity;", "", "getShortStr", "(Lru/avito/android/persistence/messenger/DraftEntity;)Ljava/lang/String;", "shortStr", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class DraftEntityKt {
    @NotNull
    public static final String getShortStr(@NotNull DraftEntity draftEntity) {
        Intrinsics.checkNotNullParameter(draftEntity, "$this$shortStr");
        return "DraftEntity(text='" + draftEntity.getText() + "')";
    }
}
