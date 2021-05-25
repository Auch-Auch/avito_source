package com.avito.android.select.new_metro;

import com.avito.android.remote.model.Metro;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroListener;", "", "", "requestId", "", "Lcom/avito/android/remote/model/Metro;", "selected", "", "onMetroSelected", "(Ljava/lang/String;Ljava/util/List;)V", "onSelectMetroCancel", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectMetroListener {
    void onMetroSelected(@NotNull String str, @NotNull List<Metro> list);

    void onSelectMetroCancel();
}
