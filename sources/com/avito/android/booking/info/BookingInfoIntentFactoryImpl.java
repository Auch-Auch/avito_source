package com.avito.android.booking.info;

import android.content.Context;
import android.content.Intent;
import com.avito.android.BookingInfoIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoIntentFactoryImpl;", "Lcom/avito/android/BookingInfoIntentFactory;", "", "itemId", BookingInfoActivity.EXTRA_FROM_BLOCK, "Landroid/content/Intent;", "bookingInfoIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoIntentFactoryImpl implements BookingInfoIntentFactory {
    @NotNull
    public final Context a;

    @Inject
    public BookingInfoIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.BookingInfoIntentFactory
    @NotNull
    public Intent bookingInfoIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_FROM_BLOCK);
        return BookingInfoActivity.Companion.createBookingInfoIntent(this.a, str, str2);
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }
}
