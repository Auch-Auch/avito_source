package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import java.util.Objects;
public final class SavedStateRegistryController {
    public final SavedStateRegistryOwner a;
    public final SavedStateRegistry b = new SavedStateRegistry();

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.a = savedStateRegistryOwner;
    }

    @NonNull
    public static SavedStateRegistryController create(@NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        return new SavedStateRegistryController(savedStateRegistryOwner);
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.b;
    }

    @MainThread
    public void performRestore(@Nullable Bundle bundle) {
        Lifecycle lifecycle = this.a.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.INITIALIZED) {
            lifecycle.addObserver(new Recreator(this.a));
            SavedStateRegistry savedStateRegistry = this.b;
            if (!savedStateRegistry.c) {
                if (bundle != null) {
                    savedStateRegistry.b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.addObserver(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE  
                      (r0v1 'lifecycle' androidx.lifecycle.Lifecycle)
                      (wrap: androidx.savedstate.SavedStateRegistry$1 : 0x002a: CONSTRUCTOR  (r4v3 androidx.savedstate.SavedStateRegistry$1) = (r1v2 'savedStateRegistry' androidx.savedstate.SavedStateRegistry) call: androidx.savedstate.SavedStateRegistry.1.<init>(androidx.savedstate.SavedStateRegistry):void type: CONSTRUCTOR)
                     type: VIRTUAL call: androidx.lifecycle.Lifecycle.addObserver(androidx.lifecycle.LifecycleObserver):void in method: androidx.savedstate.SavedStateRegistryController.performRestore(android.os.Bundle):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: CONSTRUCTOR  (r4v3 androidx.savedstate.SavedStateRegistry$1) = (r1v2 'savedStateRegistry' androidx.savedstate.SavedStateRegistry) call: androidx.savedstate.SavedStateRegistry.1.<init>(androidx.savedstate.SavedStateRegistry):void type: CONSTRUCTOR in method: androidx.savedstate.SavedStateRegistryController.performRestore(android.os.Bundle):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 31 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.savedstate.SavedStateRegistry, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 37 more
                    */
                /*
                    this = this;
                    androidx.savedstate.SavedStateRegistryOwner r0 = r3.a
                    androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
                    androidx.lifecycle.Lifecycle$State r1 = r0.getCurrentState()
                    androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.INITIALIZED
                    if (r1 != r2) goto L_0x003c
                    androidx.savedstate.Recreator r1 = new androidx.savedstate.Recreator
                    androidx.savedstate.SavedStateRegistryOwner r2 = r3.a
                    r1.<init>(r2)
                    r0.addObserver(r1)
                    androidx.savedstate.SavedStateRegistry r1 = r3.b
                    boolean r2 = r1.c
                    if (r2 != 0) goto L_0x0034
                    if (r4 == 0) goto L_0x0028
                    java.lang.String r2 = "androidx.lifecycle.BundlableSavedStateRegistry.key"
                    android.os.Bundle r4 = r4.getBundle(r2)
                    r1.b = r4
                L_0x0028:
                    androidx.savedstate.SavedStateRegistry$1 r4 = new androidx.savedstate.SavedStateRegistry$1
                    r4.<init>()
                    r0.addObserver(r4)
                    r4 = 1
                    r1.c = r4
                    return
                L_0x0034:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "SavedStateRegistry was already restored."
                    r4.<init>(r0)
                    throw r4
                L_0x003c:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "Restarter must be created only during owner's initialization stage"
                    r4.<init>(r0)
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.savedstate.SavedStateRegistryController.performRestore(android.os.Bundle):void");
            }

            @MainThread
            public void performSave(@NonNull Bundle bundle) {
                SavedStateRegistry savedStateRegistry = this.b;
                Objects.requireNonNull(savedStateRegistry);
                Bundle bundle2 = new Bundle();
                Bundle bundle3 = savedStateRegistry.b;
                if (bundle3 != null) {
                    bundle2.putAll(bundle3);
                }
                SafeIterableMap<K, V>.d iteratorWithAdditions = savedStateRegistry.a.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
                    bundle2.putBundle((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
                }
                bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
            }
        }
