package com.avito.android.items;

import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.items.BasicInputItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/items/ItemWithHtmlSupport;", "Lcom/avito/android/items/BasicInputItem;", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getHtmlRootNode", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "setHtmlRootNode", "(Lcom/avito/android/html_formatter/MutableHtmlNode;)V", "htmlRootNode", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface ItemWithHtmlSupport extends BasicInputItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull ItemWithHtmlSupport itemWithHtmlSupport) {
            return BasicInputItem.DefaultImpls.getId(itemWithHtmlSupport);
        }
    }

    @Nullable
    MutableHtmlNode getHtmlRootNode();

    void setHtmlRootNode(@Nullable MutableHtmlNode mutableHtmlNode);
}
