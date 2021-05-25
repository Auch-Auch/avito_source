package com.avito.android.advert.item.icebreakers;

import com.avito.android.remote.model.IceBreaker;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/icebreakers/IcebreakersListener;", "", "Lcom/avito/android/remote/model/IceBreaker;", "iceBreaker", "", VKApiConst.POSITION, "", "onIcebreakerClick", "(Lcom/avito/android/remote/model/IceBreaker;I)V", "onShowIcebreakers", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface IcebreakersListener {
    void onIcebreakerClick(@NotNull IceBreaker iceBreaker, int i);

    void onShowIcebreakers();
}
