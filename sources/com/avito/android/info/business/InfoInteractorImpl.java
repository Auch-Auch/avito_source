package com.avito.android.info.business;

import com.avito.android.info.di.InfoActivityModule;
import com.avito.android.remote.InfoApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Info;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0001\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/info/business/InfoInteractorImpl;", "Lcom/avito/android/info/business/InfoInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/Info;", "load", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/InfoApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/InfoApi;", "api", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "<init>", "(Lcom/avito/android/remote/InfoApi;Ljava/lang/String;)V", "info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoInteractorImpl implements InfoInteractor {
    public final InfoApi a;
    public final String b;

    @Inject
    public InfoInteractorImpl(@NotNull InfoApi infoApi, @InfoActivityModule.InfoPath @NotNull String str) {
        Intrinsics.checkNotNullParameter(infoApi, "api");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        this.a = infoApi;
        this.b = str;
    }

    @Override // com.avito.android.info.business.InfoInteractor
    @NotNull
    public Observable<Info> load() {
        return InteropKt.toV2(this.a.getInfo(this.b));
    }
}
