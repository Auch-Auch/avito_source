package com.avito.android.advert.cpo_program;

import com.avito.android.remote.model.CpoDescription;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;", "", "Lcom/avito/android/remote/model/CpoDescription;", "description", "", "showCpoProgram", "(Lcom/avito/android/remote/model/CpoDescription;)V", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaCpoProgramView {
    void showCpoProgram(@NotNull CpoDescription cpoDescription);

    @NotNull
    Observable<Unit> upButtonClicks();
}
