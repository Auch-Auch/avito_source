package com.avito.android.user_advert.advert;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_advert/advert/AdvertActionsView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "primaryActionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "secondaryActionClicks", "", "isVisible", "setActionsVisibility", "(Z)V", "", "text", "bindActionsHintText", "(Ljava/lang/String;)V", "bindPrimaryAction", "bindSecondaryAction", "setPrimaryActionVisibility", "setSecondaryActionVisibility", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertActionsView {
    void bindActionsHintText(@Nullable String str);

    void bindPrimaryAction(@Nullable String str);

    void bindSecondaryAction(@Nullable String str);

    @NotNull
    Observable<Unit> primaryActionClicks();

    @NotNull
    Observable<Unit> secondaryActionClicks();

    void setActionsVisibility(boolean z);

    void setPrimaryActionVisibility(boolean z);

    void setSecondaryActionVisibility(boolean z);
}
