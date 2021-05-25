package com.avito.android.lib.design.chips;

import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\t¨\u0006!"}, d2 = {"Lcom/avito/android/lib/design/chips/ChipsSelectManager;", "", "", VKApiConst.POSITION, "", "isSelected", "(I)Z", "", "select", "(I)V", "", "positions", "(Ljava/util/Collection;)V", "", "selected", "()Ljava/util/List;", "clearSelected", "isMaxSelected", "()Z", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "getSelectStrategy", "()Lcom/avito/android/lib/design/chips/SelectStrategy;", "setSelectStrategy", "(Lcom/avito/android/lib/design/chips/SelectStrategy;)V", "selectStrategy", "getKeepLastSelected", "setKeepLastSelected", "(Z)V", "keepLastSelected", "getMaxSelected", "()I", "setMaxSelected", "maxSelected", "components_release"}, k = 1, mv = {1, 4, 2})
public interface ChipsSelectManager {
    @NotNull
    List<Integer> clearSelected();

    boolean getKeepLastSelected();

    int getMaxSelected();

    @NotNull
    SelectStrategy getSelectStrategy();

    boolean isMaxSelected();

    boolean isSelected(int i);

    void select(int i);

    void select(@NotNull Collection<Integer> collection);

    @NotNull
    List<Integer> selected();

    void setKeepLastSelected(boolean z);

    void setMaxSelected(int i);

    void setSelectStrategy(@NotNull SelectStrategy selectStrategy);
}
