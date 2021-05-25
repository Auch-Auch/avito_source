package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;
@KeepForSdk
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {
    private Fragment zza;

    private SupportFragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    @RecentlyNullable
    @KeepForSdk
    public static SupportFragmentWrapper wrap(@Nullable Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final IObjectWrapper zza() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final Bundle zzb() {
        return this.zza.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final int zzc() {
        return this.zza.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNullable
    public final IFragmentWrapper zzd() {
        return wrap(this.zza.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzf() {
        return this.zza.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNullable
    public final String zzg() {
        return this.zza.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNullable
    public final IFragmentWrapper zzh() {
        return wrap(this.zza.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final int zzi() {
        return this.zza.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzj() {
        return this.zza.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final IObjectWrapper zzk() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzl() {
        return this.zza.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzm() {
        return this.zza.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzn() {
        return this.zza.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzo() {
        return this.zza.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzp() {
        return this.zza.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzq() {
        return this.zza.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @RecentlyNonNull
    public final boolean zzr() {
        return this.zza.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzb(@RecentlyNonNull boolean z) {
        this.zza.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzc(@RecentlyNonNull boolean z) {
        this.zza.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzd(@RecentlyNonNull boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@RecentlyNonNull IObjectWrapper iObjectWrapper) {
        this.zza.registerForContextMenu((View) Preconditions.checkNotNull((View) ObjectWrapper.unwrap(iObjectWrapper)));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzb(@RecentlyNonNull IObjectWrapper iObjectWrapper) {
        this.zza.unregisterForContextMenu((View) Preconditions.checkNotNull((View) ObjectWrapper.unwrap(iObjectWrapper)));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@RecentlyNonNull boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@RecentlyNonNull Intent intent) {
        this.zza.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@RecentlyNonNull Intent intent, @RecentlyNonNull int i) {
        this.zza.startActivityForResult(intent, i);
    }
}
