package com.avito.android.html_editor;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/html_editor/EditorHistoryProvider;", "", "", "id", "", VKApiConst.POSITION, "Lcom/avito/android/html_editor/HistorySnapshot;", "getHistorySnapshot", "(Ljava/lang/String;I)Lcom/avito/android/html_editor/HistorySnapshot;", "state", "", "saveHistorySnapshot", "(Ljava/lang/String;ILcom/avito/android/html_editor/HistorySnapshot;)V", "fromPosition", "toPosition", "clearSnapshots", "(Ljava/lang/String;II)V", "clearAllHistories", "()V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public interface EditorHistoryProvider {
    void clearAllHistories();

    void clearSnapshots(@NotNull String str, int i, int i2);

    @Nullable
    HistorySnapshot getHistorySnapshot(@NotNull String str, int i);

    void saveHistorySnapshot(@NotNull String str, int i, @NotNull HistorySnapshot historySnapshot);
}
