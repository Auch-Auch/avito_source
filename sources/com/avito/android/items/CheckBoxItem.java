package com.avito.android.items;

import a2.g.r.g;
import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BW\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\"\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b-\u0010.R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\"\u0010\"\u001a\u00020\u001b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010%\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\bR\u001b\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\bR\"\u0010*\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/avito/android/items/CheckBoxItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/ItemWithMotivation;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "Lcom/avito/android/remote/model/text/AttributedText;", "f", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "motivation", "", "h", "Z", "getHideTitle", "()Z", "hideTitle", "d", "getSubTitle", "subTitle", "Lcom/avito/android/items/ItemWithState$State;", "e", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", AuthSource.SEND_ABUSE, "getStringId", "stringId", g.a, "getHeader", TariffPackageInfoConverterKt.HEADER_STRING_ID, "c", "isChecked", "setChecked", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class CheckBoxItem implements Item, ItemWithState, ItemWithMotivation {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public boolean c;
    @Nullable
    public final AttributedText d;
    @NotNull
    public ItemWithState.State e;
    @Nullable
    public AttributedText f;
    @Nullable
    public final String g;
    public final boolean h;

    public CheckBoxItem(@NotNull String str, @NotNull String str2, boolean z, @Nullable AttributedText attributedText, @NotNull ItemWithState.State state, @Nullable AttributedText attributedText2, @Nullable String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = attributedText;
        this.e = state;
        this.f = attributedText2;
        this.g = str3;
        this.h = z2;
    }

    @Nullable
    public final String getHeader() {
        return this.g;
    }

    public final boolean getHideTitle() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.items.ItemWithMotivation
    @Nullable
    public AttributedText getMotivation() {
        return this.f;
    }

    @Override // com.avito.android.items.ItemWithState
    @NotNull
    public ItemWithState.State getState() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final AttributedText getSubTitle() {
        return this.d;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    public final boolean isChecked() {
        return this.c;
    }

    public final void setChecked(boolean z) {
        this.c = z;
    }

    public void setMotivation(@Nullable AttributedText attributedText) {
        this.f = attributedText;
    }

    @Override // com.avito.android.items.ItemWithState
    public void setState(@NotNull ItemWithState.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.e = state;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckBoxItem(String str, String str2, boolean z, AttributedText attributedText, ItemWithState.State state, AttributedText attributedText2, String str3, boolean z2, int i, j jVar) {
        this(str, str2, z, (i & 8) != 0 ? null : attributedText, (i & 16) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i & 32) != 0 ? null : attributedText2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? false : z2);
    }
}
