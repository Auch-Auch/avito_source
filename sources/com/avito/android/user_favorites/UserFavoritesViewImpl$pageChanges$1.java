package com.avito.android.user_favorites;

import com.google.android.material.tabs.TabLayout;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class UserFavoritesViewImpl$pageChanges$1<T> implements ObservableOnSubscribe<Integer> {
    public final /* synthetic */ UserFavoritesViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ UserFavoritesViewImpl$pageChanges$1 a;
        public final /* synthetic */ UserFavoritesViewImpl$pageChanges$1$listener$1 b;

        public a(UserFavoritesViewImpl$pageChanges$1 userFavoritesViewImpl$pageChanges$1, UserFavoritesViewImpl$pageChanges$1$listener$1 userFavoritesViewImpl$pageChanges$1$listener$1) {
            this.a = userFavoritesViewImpl$pageChanges$1;
            this.b = userFavoritesViewImpl$pageChanges$1$listener$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.b.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) this.b);
        }
    }

    public UserFavoritesViewImpl$pageChanges$1(UserFavoritesViewImpl userFavoritesViewImpl) {
        this.a = userFavoritesViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
        UserFavoritesViewImpl$pageChanges$1$listener$1 userFavoritesViewImpl$pageChanges$1$listener$1 = new UserFavoritesViewImpl$pageChanges$1$listener$1(observableEmitter);
        this.a.b.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) userFavoritesViewImpl$pageChanges$1$listener$1);
        observableEmitter.setCancellable(new a(this, userFavoritesViewImpl$pageChanges$1$listener$1));
    }
}
