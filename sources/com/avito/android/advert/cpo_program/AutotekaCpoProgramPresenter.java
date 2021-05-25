package com.avito.android.advert.cpo_program;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter;", "", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;", "view", "", "attachView", "(Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;)V", "detachView", "()V", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;)V", "detachRouter", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaCpoProgramPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;", "", "", "close", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void close();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AutotekaCpoProgramView autotekaCpoProgramView);

    void detachRouter();

    void detachView();
}
