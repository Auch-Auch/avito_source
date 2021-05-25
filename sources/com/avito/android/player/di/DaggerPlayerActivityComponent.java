package com.avito.android.player.di;

import com.avito.android.player.di.PlayerActivityComponent;
import com.avito.android.player.view.PlayerActivity;
import dagger.internal.Preconditions;
public final class DaggerPlayerActivityComponent implements PlayerActivityComponent {

    public static final class b implements PlayerActivityComponent.Builder {
        public PlayerActivityDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.player.di.PlayerActivityComponent.Builder
        public PlayerActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PlayerActivityDependencies.class);
            return new DaggerPlayerActivityComponent(this.a);
        }

        @Override // com.avito.android.player.di.PlayerActivityComponent.Builder
        public PlayerActivityComponent.Builder dependencies(PlayerActivityDependencies playerActivityDependencies) {
            this.a = (PlayerActivityDependencies) Preconditions.checkNotNull(playerActivityDependencies);
            return this;
        }
    }

    public DaggerPlayerActivityComponent() {
    }

    public static PlayerActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.player.di.PlayerActivityComponent
    public void inject(PlayerActivity playerActivity) {
    }

    public DaggerPlayerActivityComponent(PlayerActivityDependencies playerActivityDependencies) {
    }
}
