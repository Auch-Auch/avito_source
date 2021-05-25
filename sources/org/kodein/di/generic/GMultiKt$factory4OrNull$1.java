package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Multi4;
import org.kodein.di.TypesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0018\u00010\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001\"\n\b\u0004\u0010\u0005\u0018\u0001*\u00020\u00042,\u0010\b\u001a(\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0004\u0012\u00028\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"A1", "A2", "A3", "A4", "", "T", "Lkotlin/Function1;", "Lorg/kodein/di/Multi4;", "factory", "Lkotlin/Function4;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function4;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GMultiKt$factory4OrNull$1 extends Lambda implements Function1<Function1<? super Multi4<A1, A2, A3, A4>, ? extends T>, Function4<? super A1, ? super A2, ? super A3, ? super A4, ? extends T>> {
    public static final GMultiKt$factory4OrNull$1 INSTANCE = new GMultiKt$factory4OrNull$1();

    public GMultiKt$factory4OrNull$1() {
        super(1);
    }

    @Nullable
    public final Function4<A1, A2, A3, A4, T> invoke(@Nullable Function1<? super Multi4<A1, A2, A3, A4>, ? extends T> function1) {
        if (function1 != null) {
            return new Function4<A1, A2, A3, A4, T>(function1) { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1
                public final /* synthetic */ Function1 a;

                {
                    this.a = r1;
                }

                @Override // kotlin.jvm.functions.Function4
                @NotNull
                public final T invoke(A1 a1, A2 a22, A3 a3, A4 a4) {
                    return (T) this.a.invoke(new Multi4(a1, a22, a3, a4, TypesKt.TT(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: RETURN  
                          (wrap: T : ?: CHECK_CAST (r9v1 T) = (T) (wrap: java.lang.Object : 0x0015: INVOKE  (r9v2 java.lang.Object) = 
                          (wrap: kotlin.jvm.functions.Function1 : 0x0000: IGET  (r0v0 kotlin.jvm.functions.Function1) = (r8v0 'this' org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1 A[IMMUTABLE_TYPE, THIS]) org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.a kotlin.jvm.functions.Function1)
                          (wrap: org.kodein.di.Multi4 : 0x0012: CONSTRUCTOR  (r1v1 org.kodein.di.Multi4) = 
                          (r9v0 'a1' A1)
                          (r10v0 'a22' A2)
                          (r11v0 'a3' A3)
                          (r12v0 'a4' A4)
                          (wrap: org.kodein.di.TypeToken : 0x0007: INVOKE  (r7v0 org.kodein.di.TypeToken) = 
                          (wrap: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1 : 0x0004: CONSTRUCTOR  (r1v0 org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1) =  call: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1.<init>():void type: CONSTRUCTOR)
                         type: STATIC call: org.kodein.di.TypesKt.TT(org.kodein.di.TypeReference):org.kodein.di.TypeToken)
                         call: org.kodein.di.Multi4.<init>(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, org.kodein.di.TypeToken):void type: CONSTRUCTOR)
                         type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object))
                         in method: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(A1, A2, A3, A4):T, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: CHECK_CAST (r9v1 T) = (T) (wrap: java.lang.Object : 0x0015: INVOKE  (r9v2 java.lang.Object) = 
                          (wrap: kotlin.jvm.functions.Function1 : 0x0000: IGET  (r0v0 kotlin.jvm.functions.Function1) = (r8v0 'this' org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1 A[IMMUTABLE_TYPE, THIS]) org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.a kotlin.jvm.functions.Function1)
                          (wrap: org.kodein.di.Multi4 : 0x0012: CONSTRUCTOR  (r1v1 org.kodein.di.Multi4) = 
                          (r9v0 'a1' A1)
                          (r10v0 'a22' A2)
                          (r11v0 'a3' A3)
                          (r12v0 'a4' A4)
                          (wrap: org.kodein.di.TypeToken : 0x0007: INVOKE  (r7v0 org.kodein.di.TypeToken) = 
                          (wrap: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1 : 0x0004: CONSTRUCTOR  (r1v0 org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1) =  call: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1.<init>():void type: CONSTRUCTOR)
                         type: STATIC call: org.kodein.di.TypesKt.TT(org.kodein.di.TypeReference):org.kodein.di.TypeToken)
                         call: org.kodein.di.Multi4.<init>(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, org.kodein.di.TypeToken):void type: CONSTRUCTOR)
                         type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object) in method: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(A1, A2, A3, A4):T, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 15 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  (r9v2 java.lang.Object) = 
                          (wrap: kotlin.jvm.functions.Function1 : 0x0000: IGET  (r0v0 kotlin.jvm.functions.Function1) = (r8v0 'this' org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1 A[IMMUTABLE_TYPE, THIS]) org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.a kotlin.jvm.functions.Function1)
                          (wrap: org.kodein.di.Multi4 : 0x0012: CONSTRUCTOR  (r1v1 org.kodein.di.Multi4) = 
                          (r9v0 'a1' A1)
                          (r10v0 'a22' A2)
                          (r11v0 'a3' A3)
                          (r12v0 'a4' A4)
                          (wrap: org.kodein.di.TypeToken : 0x0007: INVOKE  (r7v0 org.kodein.di.TypeToken) = 
                          (wrap: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1 : 0x0004: CONSTRUCTOR  (r1v0 org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1) =  call: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1.<init>():void type: CONSTRUCTOR)
                         type: STATIC call: org.kodein.di.TypesKt.TT(org.kodein.di.TypeReference):org.kodein.di.TypeToken)
                         call: org.kodein.di.Multi4.<init>(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, org.kodein.di.TypeToken):void type: CONSTRUCTOR)
                         type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object in method: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(A1, A2, A3, A4):T, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:317)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r1v1 org.kodein.di.Multi4) = 
                          (r9v0 'a1' A1)
                          (r10v0 'a22' A2)
                          (r11v0 'a3' A3)
                          (r12v0 'a4' A4)
                          (wrap: org.kodein.di.TypeToken : 0x0007: INVOKE  (r7v0 org.kodein.di.TypeToken) = 
                          (wrap: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1 : 0x0004: CONSTRUCTOR  (r1v0 org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1) =  call: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1.<init>():void type: CONSTRUCTOR)
                         type: STATIC call: org.kodein.di.TypesKt.TT(org.kodein.di.TypeReference):org.kodein.di.TypeToken)
                         call: org.kodein.di.Multi4.<init>(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, org.kodein.di.TypeToken):void type: CONSTRUCTOR in method: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(A1, A2, A3, A4):T, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 23 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: INVOKE  (r7v0 org.kodein.di.TypeToken) = 
                          (wrap: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1 : 0x0004: CONSTRUCTOR  (r1v0 org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1) =  call: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1.<init>():void type: CONSTRUCTOR)
                         type: STATIC call: org.kodein.di.TypesKt.TT(org.kodein.di.TypeReference):org.kodein.di.TypeToken in method: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(A1, A2, A3, A4):T, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:690)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONSTRUCTOR  (r1v0 org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1) =  call: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1.<init>():void type: CONSTRUCTOR in method: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(A1, A2, A3, A4):T, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 35 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 41 more
                        */
                    /*
                        this = this;
                        kotlin.jvm.functions.Function1 r0 = r8.a
                        org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1 r1 = new org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1$M$$inlined$generic$1
                        r1.<init>()
                        org.kodein.di.TypeToken r7 = org.kodein.di.TypesKt.TT(r1)
                        org.kodein.di.Multi4 r1 = new org.kodein.di.Multi4
                        r2 = r1
                        r3 = r9
                        r4 = r10
                        r5 = r11
                        r6 = r12
                        r2.<init>(r3, r4, r5, r6, r7)
                        java.lang.Object r9 = r0.invoke(r1)
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.kodein.di.generic.GMultiKt$factory4OrNull$1$1$1.invoke(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                }
            };
        }
        return null;
    }
}
