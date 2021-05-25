package com.avito.android.html_formatter.di;

import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.html_formatter.HtmlRendererImpl;
import com.avito.android.html_formatter.jsoup.JsoupHtmlCleaner;
import com.avito.android.html_formatter.jsoup.JsoupHtmlNodeFactory;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/html_formatter/di/HtmlRenderingModule;", "", "Lcom/avito/android/html_formatter/HtmlRendererImpl;", "impl", "Lcom/avito/android/html_formatter/HtmlRenderer;", "provideHtmlRenderer", "(Lcom/avito/android/html_formatter/HtmlRendererImpl;)Lcom/avito/android/html_formatter/HtmlRenderer;", "Lcom/avito/android/html_formatter/jsoup/JsoupHtmlNodeFactory;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "provideHtmlNodeFactory", "(Lcom/avito/android/html_formatter/jsoup/JsoupHtmlNodeFactory;)Lcom/avito/android/html_formatter/HtmlNodeFactory;", "Lcom/avito/android/html_formatter/jsoup/JsoupHtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "provideHtmlCleaner", "(Lcom/avito/android/html_formatter/jsoup/JsoupHtmlCleaner;)Lcom/avito/android/html_formatter/HtmlCleaner;", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface HtmlRenderingModule {
    @Singleton
    @Binds
    @NotNull
    HtmlCleaner provideHtmlCleaner(@NotNull JsoupHtmlCleaner jsoupHtmlCleaner);

    @Singleton
    @Binds
    @NotNull
    HtmlNodeFactory provideHtmlNodeFactory(@NotNull JsoupHtmlNodeFactory jsoupHtmlNodeFactory);

    @Singleton
    @Binds
    @NotNull
    HtmlRenderer provideHtmlRenderer(@NotNull HtmlRendererImpl htmlRendererImpl);
}
