package com.avito.android.publish.input_vin.items.divider;

import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextItem;", "Lcom/avito/conveyor_item/Item;", "", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.SEND_ABUSE, "I", "getWordResource", "()I", "wordResource", "<init>", "(I)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DividerWithTextItem implements Item {
    public final int a;

    public DividerWithTextItem(@StringRes int i) {
        this.a = i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return "";
    }

    public final int getWordResource() {
        return this.a;
    }
}
