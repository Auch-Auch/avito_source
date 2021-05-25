package com.avito.android.brandspace.items;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/items/BlockType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MARKETPLACE_CATEGORY", "MARKETPLACE_BANNER", "MARKETPLACE_SNIPPETS_LIST", "MARKETPLACE_SNIPPET", "MARKETPLACE_SNIPPET_LOADER", "MARKETPLACE_TABS", "MARKETPLACE_TAB", "BS_MAIN_BANNER", "BS_CATEGORIES", "BS_GALLERY", "BS_VIDEO_GALLERY", "BS_PRODUCT_DESCRIPTIONS", "BS_TEXT_WITH_IMAGE", "BS_PRODUCT_COMPARISON", "BS_SERP", "BS_TEXT_WITH_VIDEO", "BS_NEWS", "BS_ABOUT", "BS_LEGAL", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public enum BlockType {
    MARKETPLACE_CATEGORY("marketplace_category"),
    MARKETPLACE_BANNER("marketplace_banner"),
    MARKETPLACE_SNIPPETS_LIST("marketplace_snippets_list"),
    MARKETPLACE_SNIPPET("marketplace_snippet"),
    MARKETPLACE_SNIPPET_LOADER("marketplace_snippet_loader"),
    MARKETPLACE_TABS("marketplace_tabs"),
    MARKETPLACE_TAB("marketplace_tab"),
    BS_MAIN_BANNER("bsMainBanner"),
    BS_CATEGORIES("bsCategories"),
    BS_GALLERY("bsGallery"),
    BS_VIDEO_GALLERY("bsVideoGallery"),
    BS_PRODUCT_DESCRIPTIONS("bsProductDescriptions"),
    BS_TEXT_WITH_IMAGE("bsTextWithImage"),
    BS_PRODUCT_COMPARISON("bsProductComparison"),
    BS_SERP("bsSERP"),
    BS_TEXT_WITH_VIDEO("bsTextWithVideo"),
    BS_NEWS("bsNews"),
    BS_ABOUT("bsAbout"),
    BS_LEGAL("bsLegal");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    BlockType(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
