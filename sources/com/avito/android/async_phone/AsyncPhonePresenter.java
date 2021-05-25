package com.avito.android.async_phone;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.remote.error.TypedError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.AsyncPhoneItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JE\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\u000eJI\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhonePresenter;", "", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "Lru/avito/component/serp/AsyncPhoneItemView;", "itemView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "Lkotlin/Function1;", "", "onComplete", "loadPhoneLink", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Lru/avito/component/serp/AsyncPhoneItemView;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "deepLink", "view", "Lcom/avito/android/remote/error/TypedError;", "onError", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lru/avito/component/serp/AsyncPhoneItemView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "bindItem", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Lru/avito/component/serp/AsyncPhoneItemView;)V", "unbindItem", "(Lcom/avito/android/async_phone/AsyncPhoneItem;)V", "Lcom/avito/android/async_phone/AsyncPhoneView;", "attachView", "(Lcom/avito/android/async_phone/AsyncPhoneView;)V", "detachView", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AsyncPhonePresenter {
    void attachView(@NotNull AsyncPhoneView asyncPhoneView);

    void bindItem(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull AsyncPhoneItemView asyncPhoneItemView);

    void detachView();

    void loadPhoneLink(@NotNull AsyncPhoneItem asyncPhoneItem, @Nullable AsyncPhoneItemView asyncPhoneItemView, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource, @NotNull Function1<? super DeepLink, Unit> function1);

    void loadPhoneLink(@NotNull PhoneRequestLink phoneRequestLink, @Nullable AsyncPhoneItemView asyncPhoneItemView, @NotNull Function1<? super DeepLink, Unit> function1, @NotNull Function1<? super TypedError, Unit> function12);

    void unbindItem(@NotNull AsyncPhoneItem asyncPhoneItem);
}
