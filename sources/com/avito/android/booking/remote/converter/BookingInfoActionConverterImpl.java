package com.avito.android.booking.remote.converter;

import android.content.Context;
import com.avito.android.booking.R;
import com.avito.android.booking.info.ActionButtonState;
import com.avito.android.booking.remote.model.BookingInfoAction;
import com.avito.android.booking.remote.model.BookingInfoActionStyle;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/booking/remote/converter/BookingInfoActionConverterImpl;", "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "Lcom/avito/android/booking/remote/model/BookingInfoAction;", "action", "Lcom/avito/android/booking/info/ActionButtonState;", "convert", "(Lcom/avito/android/booking/remote/model/BookingInfoAction;)Lcom/avito/android/booking/info/ActionButtonState;", "Lkotlin/Lazy;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "fallbackActionButtonState", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoActionConverterImpl implements BookingInfoActionConverter {
    public final Lazy<ActionButtonState> a = c.lazy(new a(this));
    @NotNull
    public final Context b;

    public static final class a extends Lambda implements Function0<ActionButtonState> {
        public final /* synthetic */ BookingInfoActionConverterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BookingInfoActionConverterImpl bookingInfoActionConverterImpl) {
            super(0);
            this.a = bookingInfoActionConverterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ActionButtonState invoke() {
            String string = this.a.getContext().getString(R.string.fallback_action_title);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.fallback_action_title)");
            return new ActionButtonState(string, BookingInfoActionStyle.DEFAULT, null);
        }
    }

    @Inject
    public BookingInfoActionConverterImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
    }

    @Override // com.avito.android.booking.remote.converter.BookingInfoActionConverter
    @NotNull
    public ActionButtonState convert(@Nullable BookingInfoAction bookingInfoAction) {
        BookingInfoActionStyle bookingInfoActionStyle;
        if (bookingInfoAction == null) {
            return this.a.getValue();
        }
        if (bookingInfoAction.getStyle() != null) {
            bookingInfoActionStyle = bookingInfoAction.getStyle();
            Intrinsics.checkNotNull(bookingInfoActionStyle);
        } else if (bookingInfoAction.getDeeplink() != null) {
            bookingInfoActionStyle = BookingInfoActionStyle.PRIMARY;
        } else {
            bookingInfoActionStyle = BookingInfoActionStyle.DEFAULT;
        }
        return new ActionButtonState(bookingInfoAction.getTitle(), bookingInfoActionStyle, bookingInfoAction.getDeeplink());
    }

    @NotNull
    public final Context getContext() {
        return this.b;
    }
}
