package ru.avito.component.list_dialog;

import androidx.annotation.StringRes;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button_panel.ButtonPanel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\t¨\u0006\u0011"}, d2 = {"Lru/avito/component/list_dialog/ListDialog;", "Lru/avito/component/button_panel/ButtonPanel;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "textId", "(I)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "setDataSource", "(Lcom/avito/konveyor/data_source/DataSource;)V", VKApiConst.POSITION, "notifyItemChanged", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ListDialog extends ButtonPanel {
    void notifyItemChanged(int i);

    void setDataSource(@NotNull DataSource<? extends Item> dataSource);

    void setTitle(@StringRes int i);

    void setTitle(@Nullable String str);
}
