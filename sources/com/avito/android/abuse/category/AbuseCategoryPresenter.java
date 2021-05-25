package com.avito.android.abuse.category;

import com.avito.android.abuse.category.item.AbuseCategoryItemClickListener;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemClickListener;", "Lcom/avito/android/abuse/category/AbuseCategoryView;", "view", "", "attachView", "(Lcom/avito/android/abuse/category/AbuseCategoryView;)V", "detachView", "()V", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "Router", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseCategoryPresenter extends AbuseCategoryItemClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;", "", "", "categoryId", "", "showAbuseDetailsScreen", "(I)V", "leaveScreen", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen();

        void showAbuseDetailsScreen(int i);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AbuseCategoryView abuseCategoryView);

    void detachRouter();

    void detachView();

    void onBackPressed();

    @NotNull
    Kundle onSaveState();
}
