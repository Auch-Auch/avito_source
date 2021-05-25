package com.avito.android.section.di;

import com.avito.android.di.module.DfpDebugModule;
import com.avito.android.favorite_sellers.SellerCarouselItemConverter;
import com.avito.android.favorite_sellers.SellerCarouselItemConverterImpl;
import com.avito.android.section.SectionInsideItemsConverter;
import com.avito.android.section.SectionInsideItemsConverterImpl;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.section.SectionItemConverterImpl;
import com.avito.android.section.SectionItemPresenter;
import com.avito.android.section.SectionItemPresenterImpl;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.action.SectionActionPresenterImpl;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonPresenter;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonPresenterImpl;
import com.avito.android.section.title.SectionTitleItemPresenter;
import com.avito.android.section.title.SectionTitleItemPresenterImpl;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenter;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/avito/android/section/di/SectionModule;", "", "Lcom/avito/android/section/SectionItemPresenterImpl;", "presenter", "Lcom/avito/android/section/SectionItemPresenter;", "bindSectionItemPresenter", "(Lcom/avito/android/section/SectionItemPresenterImpl;)Lcom/avito/android/section/SectionItemPresenter;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionPresenterImpl;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionPresenter;", "bindSectionTitleWithActionPresenter", "(Lcom/avito/android/section/title_with_action/SectionTitleWithActionPresenterImpl;)Lcom/avito/android/section/title_with_action/SectionTitleWithActionPresenter;", "Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonPresenterImpl;", "Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonPresenter;", "bindExpandSectionsButtonPresenter", "(Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonPresenterImpl;)Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonPresenter;", "Lcom/avito/android/section/title/SectionTitleItemPresenterImpl;", "Lcom/avito/android/section/title/SectionTitleItemPresenter;", "bindSectionTitleItemPresenter", "(Lcom/avito/android/section/title/SectionTitleItemPresenterImpl;)Lcom/avito/android/section/title/SectionTitleItemPresenter;", "Lcom/avito/android/section/action/SectionActionPresenterImpl;", "Lcom/avito/android/section/action/SectionActionPresenter;", "bindSectionActionPresenter", "(Lcom/avito/android/section/action/SectionActionPresenterImpl;)Lcom/avito/android/section/action/SectionActionPresenter;", "Lcom/avito/android/section/SectionItemConverterImpl;", "converter", "Lcom/avito/android/section/SectionItemConverter;", "bindSectionItemConverter", "(Lcom/avito/android/section/SectionItemConverterImpl;)Lcom/avito/android/section/SectionItemConverter;", "Lcom/avito/android/section/SectionInsideItemsConverterImpl;", "Lcom/avito/android/section/SectionInsideItemsConverter;", "bindSectionInsideItemsConverter", "(Lcom/avito/android/section/SectionInsideItemsConverterImpl;)Lcom/avito/android/section/SectionInsideItemsConverter;", "Lcom/avito/android/favorite_sellers/SellerCarouselItemConverterImpl;", "Lcom/avito/android/favorite_sellers/SellerCarouselItemConverter;", "bindSellerCarouselItemConverter", "(Lcom/avito/android/favorite_sellers/SellerCarouselItemConverterImpl;)Lcom/avito/android/favorite_sellers/SellerCarouselItemConverter;", "SavedState", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DfpDebugModule.class})
public interface SectionModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/section/di/SectionModule$SavedState;", "", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SavedState {
    }

    @Reusable
    @Binds
    @NotNull
    ExpandSectionsButtonPresenter bindExpandSectionsButtonPresenter(@NotNull ExpandSectionsButtonPresenterImpl expandSectionsButtonPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    SectionActionPresenter bindSectionActionPresenter(@NotNull SectionActionPresenterImpl sectionActionPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    SectionInsideItemsConverter bindSectionInsideItemsConverter(@NotNull SectionInsideItemsConverterImpl sectionInsideItemsConverterImpl);

    @Reusable
    @Binds
    @NotNull
    SectionItemConverter bindSectionItemConverter(@NotNull SectionItemConverterImpl sectionItemConverterImpl);

    @Reusable
    @Binds
    @NotNull
    SectionItemPresenter bindSectionItemPresenter(@NotNull SectionItemPresenterImpl sectionItemPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    SectionTitleItemPresenter bindSectionTitleItemPresenter(@NotNull SectionTitleItemPresenterImpl sectionTitleItemPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    SectionTitleWithActionPresenter bindSectionTitleWithActionPresenter(@NotNull SectionTitleWithActionPresenterImpl sectionTitleWithActionPresenterImpl);

    @Reusable
    @Binds
    @NotNull
    SellerCarouselItemConverter bindSellerCarouselItemConverter(@NotNull SellerCarouselItemConverterImpl sellerCarouselItemConverterImpl);
}
