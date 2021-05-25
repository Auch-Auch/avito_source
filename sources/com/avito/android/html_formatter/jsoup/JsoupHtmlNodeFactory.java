package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.HtmlNode;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupHtmlNodeFactory;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "", "text", "Lcom/avito/android/html_formatter/HtmlNode;", "createNodeFrom", "(Ljava/lang/String;)Lcom/avito/android/html_formatter/HtmlNode;", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "createMutableNodeFrom", "(Ljava/lang/String;)Lcom/avito/android/html_formatter/MutableHtmlNode;", "Lorg/jsoup/nodes/Element;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lorg/jsoup/nodes/Element;", "<init>", "()V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class JsoupHtmlNodeFactory implements HtmlNodeFactory {
    public final Element a(String str) {
        Document parseBodyFragment = Jsoup.parseBodyFragment(str);
        parseBodyFragment.outputSettings(new Document.OutputSettings().prettyPrint(false));
        Element body = parseBodyFragment.body();
        Intrinsics.checkNotNullExpressionValue(body, "Jsoup.parseBodyFragment(…(false))\n        }.body()");
        return body;
    }

    @Override // com.avito.android.html_formatter.HtmlNodeFactory
    @NotNull
    public MutableHtmlNode createMutableNodeFrom(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new MutableJsoupHtmlNode(a(str));
    }

    @Override // com.avito.android.html_formatter.HtmlNodeFactory
    @NotNull
    public HtmlNode createNodeFrom(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new JsoupHtmlNode(a(str));
    }
}
