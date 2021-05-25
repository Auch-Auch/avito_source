package com.avito.android.serp.adapter.advert_xl;

import com.avito.android.deep_linking.links.PhoneLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/PhoneCallRouter;", "", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", "Lkotlin/Function0;", "", "successHandler", "failureHandler", "followPhoneLink", "(Lcom/avito/android/deep_linking/links/PhoneLink;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "phoneLink", "", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;)Z", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneCallRouter {
    boolean dialPhone(@NotNull PhoneLink phoneLink);

    void followPhoneLink(@NotNull PhoneLink phoneLink, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
