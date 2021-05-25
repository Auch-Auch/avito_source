package com.avito.android.advert_core.phone_request;

import com.avito.android.async_phone.AsyncPhoneView;
import com.avito.android.deep_linking.links.PhoneLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.AsyncPhoneItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestView;", "Lru/avito/component/serp/AsyncPhoneItemView;", "Lcom/avito/android/async_phone/AsyncPhoneView;", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "link", "", "call", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "", "resourceId", "showToast", "(I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneRequestView extends AsyncPhoneItemView, AsyncPhoneView {
    void call(@NotNull PhoneLink.Call call);

    void showToast(int i);
}
