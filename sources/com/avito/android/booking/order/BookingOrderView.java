package com.avito.android.booking.order;

import android.text.TextWatcher;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.text.AttributedText;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0013J5\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH&¢\u0006\u0004\b$\u0010\u000fJ\u000f\u0010%\u001a\u00020\u0003H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H&¢\u0006\u0004\b'\u0010&J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\fH&¢\u0006\u0004\b)\u0010\u000fJ\u0017\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\fH&¢\u0006\u0004\b+\u0010\u000f¨\u0006,"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "actionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "refreshClicks", "", "visible", "setVisible", "(Z)V", "", "title", "setScreenTitle", "(Ljava/lang/String;)V", "Landroid/text/TextWatcher;", "watcher", "setInputTextWatcher", "(Landroid/text/TextWatcher;)V", "removeInputTextWatcher", "text", InternalConstsKt.PLACEHOLDER, "description", "setInputParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "inputState", "descriptionMessage", "", "descriptionTextColor", "setInputState", "([ILjava/lang/String;Ljava/lang/Integer;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "setBookingInfo", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "setButtonText", "showProgress", "()V", "showContent", "errorMessage", "showError", "message", "showMessage", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingOrderView {
    @NotNull
    Observable<Unit> actionClicks();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<Unit> refreshClicks();

    void removeInputTextWatcher(@NotNull TextWatcher textWatcher);

    void setBookingInfo(@NotNull String str, @Nullable AttributedText attributedText);

    void setButtonText(@NotNull String str);

    void setInputParams(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    void setInputState(@NotNull int[] iArr, @Nullable String str, @Nullable Integer num);

    void setInputTextWatcher(@NotNull TextWatcher textWatcher);

    void setScreenTitle(@NotNull String str);

    void setVisible(boolean z);

    void showContent();

    void showError(@NotNull String str);

    void showMessage(@NotNull String str);

    void showProgress();
}
