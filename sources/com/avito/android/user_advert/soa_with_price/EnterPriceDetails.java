package com.avito.android.user_advert.soa_with_price;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/EnterPriceDetails;", "", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getMessage", "()Lcom/avito/android/remote/model/text/AttributedText;", "message", "", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getPrice", "()Ljava/lang/CharSequence;", "price", "<init>", "(Ljava/lang/CharSequence;Lcom/avito/android/remote/model/text/AttributedText;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class EnterPriceDetails {
    @Nullable
    public final CharSequence a;
    @Nullable
    public final AttributedText b;

    public EnterPriceDetails(@Nullable CharSequence charSequence, @Nullable AttributedText attributedText) {
        this.a = charSequence;
        this.b = attributedText;
    }

    @Nullable
    public final AttributedText getMessage() {
        return this.b;
    }

    @Nullable
    public final CharSequence getPrice() {
        return this.a;
    }
}
