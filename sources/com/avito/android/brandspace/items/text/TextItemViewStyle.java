package com.avito.android.brandspace.items.text;

import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace/items/text/TextItemViewStyle;", "", "", AuthSource.BOOKING_ORDER, "I", "getTextColorAttr", "()I", "textColorAttr", AuthSource.SEND_ABUSE, "getTextAppearanceAttr", "textAppearanceAttr", "c", "getTopMarginRes", "topMarginRes", "LegalStyle", "TitleStyle", "Lcom/avito/android/brandspace/items/text/TextItemViewStyle$TitleStyle;", "Lcom/avito/android/brandspace/items/text/TextItemViewStyle$LegalStyle;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public abstract class TextItemViewStyle {
    public final int a;
    public final int b;
    public final int c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/brandspace/items/text/TextItemViewStyle$LegalStyle;", "Lcom/avito/android/brandspace/items/text/TextItemViewStyle;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class LegalStyle extends TextItemViewStyle {
        @NotNull
        public static final LegalStyle INSTANCE = new LegalStyle();

        public LegalStyle() {
            super(R.attr.textMicro, R.attr.gray44, com.avito.android.brandspace.R.dimen.brandspace_legal_padding_top, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/brandspace/items/text/TextItemViewStyle$TitleStyle;", "Lcom/avito/android/brandspace/items/text/TextItemViewStyle;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class TitleStyle extends TextItemViewStyle {
        @NotNull
        public static final TitleStyle INSTANCE = new TitleStyle();

        public TitleStyle() {
            super(R.attr.textHeadingLarge, R.attr.black, com.avito.android.brandspace.R.dimen.brandspace_module_padding_top, null);
        }
    }

    public TextItemViewStyle(int i, int i2, int i3, j jVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int getTextAppearanceAttr() {
        return this.a;
    }

    public final int getTextColorAttr() {
        return this.b;
    }

    public final int getTopMarginRes() {
        return this.c;
    }
}
