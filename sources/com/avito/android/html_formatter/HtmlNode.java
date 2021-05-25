package com.avito.android.html_formatter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0000H&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH&¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000eH&¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\b\u0016\u0010\u0013J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0019\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/html_formatter/HtmlNode;", "", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "options", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "render", "(Lcom/avito/android/html_formatter/HtmlRenderOptions;)Lcom/avito/android/html_formatter/HtmlCharSequence;", "", "getHtml", "()Ljava/lang/String;", "another", "getCommonParent", "(Lcom/avito/android/html_formatter/HtmlNode;)Lcom/avito/android/html_formatter/HtmlNode;", "anotherNode", "", "isChildOf", "(Lcom/avito/android/html_formatter/HtmlNode;)Z", "isParentOf", "isBlock", "()Z", "isTextNode", "isBlankLine", "isRoot", "getFirstChildTextNode", "()Lcom/avito/android/html_formatter/HtmlNode;", "getFirstBlankRow", "getLeftSiblingBlock", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "asMutable", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface HtmlNode {
    @NotNull
    MutableHtmlNode asMutable();

    @Nullable
    HtmlNode getCommonParent(@Nullable HtmlNode htmlNode);

    @Nullable
    HtmlNode getFirstBlankRow();

    @Nullable
    HtmlNode getFirstChildTextNode();

    @NotNull
    String getHtml();

    @Nullable
    HtmlNode getLeftSiblingBlock();

    boolean isBlankLine();

    boolean isBlock();

    boolean isChildOf(@NotNull HtmlNode htmlNode);

    boolean isParentOf(@NotNull HtmlNode htmlNode);

    boolean isRoot();

    boolean isTextNode();

    @NotNull
    HtmlCharSequence render(@NotNull HtmlRenderOptions htmlRenderOptions);
}
