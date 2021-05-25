package com.avito.android.di.module;

import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverter;
import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverterImpl;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProviderProxy;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProviderImpl;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactoryImpl;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertXlRichJobItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterImpl;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\bH'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0018H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H'¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/avito/android/di/module/RichSnippetsModule;", "", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;", "bindRichXlAdvertItemPresenter", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenterImpl;)Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;", "bindRichAdvertItemPresenter", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenterImpl;)Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemPresenterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemPresenter;", "bindRichJobAdvertItemPresenter", "(Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemPresenterImpl;)Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;", "bindRichJobXlAdvertItemPresenter", "(Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenterImpl;)Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "bindRichAdvertItemStateProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;)Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "bindRichXlAdvertItemStateProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenterImpl;)Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProviderProxy;", "bindRichSnippetStateProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProviderProxy;)Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProviderImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProviderImpl;)Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProvider;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverterImpl;", "advertSellerConverterImpl", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;", "bindSellerConverter", "(Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverterImpl;)Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactoryImpl;", "factory", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "bindSellerInfoParamsFactory", "(Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactoryImpl;)Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DateTimeFormatterModule.class, AsyncPhoneModule.class})
public interface RichSnippetsModule {
    @Reusable
    @Binds
    @NotNull
    RichSnippetsResourceProvider bindResourceProvider(@NotNull RichSnippetsResourceProviderImpl richSnippetsResourceProviderImpl);

    @Reusable
    @Binds
    @NotNull
    AdvertRichItemPresenter bindRichAdvertItemPresenter(@NotNull AdvertRichItemPresenterImpl advertRichItemPresenterImpl);

    @Reusable
    @Binds
    @IntoSet
    @NotNull
    RichSnippetStateProvider bindRichAdvertItemStateProvider(@NotNull AdvertRichItemPresenter advertRichItemPresenter);

    @Reusable
    @Binds
    @NotNull
    AdvertRichJobItemPresenter bindRichJobAdvertItemPresenter(@NotNull AdvertRichJobItemPresenterImpl advertRichJobItemPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    AdvertXlRichJobItemPresenter bindRichJobXlAdvertItemPresenter(@NotNull AdvertXlRichJobItemPresenterImpl advertXlRichJobItemPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    @RichStateProvider
    RichSnippetStateProvider bindRichSnippetStateProvider(@NotNull RichSnippetStateProviderProxy richSnippetStateProviderProxy);

    @Reusable
    @Binds
    @NotNull
    AdvertXlRichItemPresenter bindRichXlAdvertItemPresenter(@NotNull AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl);

    @Reusable
    @Binds
    @IntoSet
    @NotNull
    RichSnippetStateProvider bindRichXlAdvertItemStateProvider(@NotNull AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    AdvertSellerConverter bindSellerConverter(@NotNull AdvertSellerConverterImpl advertSellerConverterImpl);

    @Reusable
    @Binds
    @NotNull
    SellerInfoParamsFactory bindSellerInfoParamsFactory(@NotNull SellerInfoParamsFactoryImpl sellerInfoParamsFactoryImpl);
}
