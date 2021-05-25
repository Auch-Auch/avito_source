package com.avito.android.html_editor;

import android.text.Editable;
import android.text.Spannable;
import com.avito.android.html_formatter.EditorOperation;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/html_editor/InputOperationFactory;", "", "Landroid/text/Spannable;", "text", "", Tracker.Events.CREATIVE_START, "count", "after", "", "beforeTextChanged", "(Landroid/text/Spannable;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "", "Lcom/avito/android/html_formatter/EditorOperation;", "getOperationsList", "(Landroid/text/Editable;)Ljava/util/List;", "clearCachedOperations", "(Landroid/text/Spannable;)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public interface InputOperationFactory {
    void beforeTextChanged(@NotNull Spannable spannable, int i, int i2, int i3);

    void clearCachedOperations(@Nullable Spannable spannable);

    @NotNull
    List<EditorOperation> getOperationsList(@NotNull Editable editable);

    void onTextChanged(@NotNull Spannable spannable, int i, int i2, int i3);
}
