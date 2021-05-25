package com.avito.android.html_formatter;

import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/html_formatter/HtmlRendererImpl;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "", "html", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "options", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "fromHtml", "(Ljava/lang/String;Lcom/avito/android/html_formatter/HtmlRenderOptions;)Lcom/avito/android/html_formatter/HtmlCharSequence;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "nodeFactory", "<init>", "(Lcom/avito/android/html_formatter/HtmlNodeFactory;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlRendererImpl implements HtmlRenderer {
    public final HtmlNodeFactory a;

    @Inject
    public HtmlRendererImpl(@NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "nodeFactory");
        this.a = htmlNodeFactory;
    }

    @Override // com.avito.android.html_formatter.HtmlRenderer
    @Nullable
    public HtmlCharSequence fromHtml(@NotNull String str, @NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(str, "html");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "options");
        return this.a.createNodeFrom(str).render(htmlRenderOptions);
    }
}
