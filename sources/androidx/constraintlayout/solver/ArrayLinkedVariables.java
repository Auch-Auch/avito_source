package androidx.constraintlayout.solver;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    public int a = 0;
    public final ArrayRow b;
    public int c = 8;
    public int[] d = new int[8];
    public int[] e = new int[8];
    public float[] f = new float[8];
    public int g = -1;
    public int h = -1;
    public boolean i = false;
    public final Cache mCache;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.b = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 <= -0.001f || f2 >= 0.001f) {
            int i2 = this.g;
            if (i2 == -1) {
                this.g = 0;
                this.f[0] = f2;
                this.d[0] = solverVariable.id;
                this.e[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.b);
                this.a++;
                if (!this.i) {
                    int i3 = this.h + 1;
                    this.h = i3;
                    int[] iArr = this.d;
                    if (i3 >= iArr.length) {
                        this.i = true;
                        this.h = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.a) {
                int[] iArr2 = this.d;
                int i6 = iArr2[i2];
                int i7 = solverVariable.id;
                if (i6 == i7) {
                    float[] fArr = this.f;
                    float f3 = fArr[i2] + f2;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.g) {
                            this.g = this.e[i2];
                        } else {
                            int[] iArr3 = this.e;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.b);
                        }
                        if (this.i) {
                            this.h = i2;
                        }
                        solverVariable.usageInRowCount--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.e[i2];
                i4++;
            }
            int i8 = this.h;
            int i9 = i8 + 1;
            if (this.i) {
                int[] iArr4 = this.d;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.d;
            if (i8 >= iArr5.length && this.a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.d;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.d;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.c * 2;
                this.c = i11;
                this.i = false;
                this.h = i8 - 1;
                this.f = Arrays.copyOf(this.f, i11);
                this.d = Arrays.copyOf(this.d, this.c);
                this.e = Arrays.copyOf(this.e, this.c);
            }
            this.d[i8] = solverVariable.id;
            this.f[i8] = f2;
            if (i5 != -1) {
                int[] iArr8 = this.e;
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                this.e[i8] = this.g;
                this.g = i8;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.b);
            this.a++;
            if (!this.i) {
                this.h++;
            }
            int i12 = this.h;
            int[] iArr9 = this.d;
            if (i12 >= iArr9.length) {
                this.i = true;
                this.h = iArr9.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i2 = this.g;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            SolverVariable solverVariable = this.mCache.d[this.d[i2]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.b);
            }
            i2 = this.e[i2];
            i3++;
        }
        this.g = -1;
        this.h = -1;
        this.i = false;
        this.a = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i2 = this.g;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.d[i2] == solverVariable.id) {
                return true;
            }
            i2 = this.e[i2];
            i3++;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i2 = this.a;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i3) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f2) {
        int i2 = this.g;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.e[i2];
            i3++;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i2 = this.g;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.d[i2] == solverVariable.id) {
                return this.f[i2];
            }
            i2 = this.e[i2];
            i3++;
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.a;
    }

    public int getHead() {
        return this.g;
    }

    public final int getId(int i2) {
        return this.d[i2];
    }

    public final int getNextIndice(int i2) {
        return this.e[i2];
    }

    public final float getValue(int i2) {
        return this.f[i2];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        int i3 = this.g;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.mCache.d[this.d[i3]];
            }
            i3 = this.e[i3];
            i4++;
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        int i3 = this.g;
        int i4 = 0;
        while (i3 != -1 && i4 < this.a) {
            if (i4 == i2) {
                return this.f[i3];
            }
            i3 = this.e[i3];
            i4++;
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i2 = this.g;
        if (i2 == -1) {
            return -1;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            if (this.d[i2] == solverVariable.id) {
                return i2;
            }
            i2 = this.e[i2];
            i3++;
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i2 = this.g;
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            float[] fArr = this.f;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.e[i2];
            i3++;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i2 = this.g;
        if (i2 == -1) {
            this.g = 0;
            this.f[0] = f2;
            this.d[0] = solverVariable.id;
            this.e[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.b);
            this.a++;
            if (!this.i) {
                int i3 = this.h + 1;
                this.h = i3;
                int[] iArr = this.d;
                if (i3 >= iArr.length) {
                    this.i = true;
                    this.h = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.a) {
            int[] iArr2 = this.d;
            int i6 = iArr2[i2];
            int i7 = solverVariable.id;
            if (i6 == i7) {
                this.f[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.e[i2];
            i4++;
        }
        int i8 = this.h;
        int i9 = i8 + 1;
        if (this.i) {
            int[] iArr3 = this.d;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.d;
        if (i8 >= iArr4.length && this.a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.d;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.d;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.c * 2;
            this.c = i11;
            this.i = false;
            this.h = i8 - 1;
            this.f = Arrays.copyOf(this.f, i11);
            this.d = Arrays.copyOf(this.d, this.c);
            this.e = Arrays.copyOf(this.e, this.c);
        }
        this.d[i8] = solverVariable.id;
        this.f[i8] = f2;
        if (i5 != -1) {
            int[] iArr7 = this.e;
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            this.e[i8] = this.g;
            this.g = i8;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.b);
        int i12 = this.a + 1;
        this.a = i12;
        if (!this.i) {
            this.h++;
        }
        int[] iArr8 = this.d;
        if (i12 >= iArr8.length) {
            this.i = true;
        }
        if (this.h >= iArr8.length) {
            this.i = true;
            this.h = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        int i2 = this.g;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.a) {
            if (this.d[i2] == solverVariable.id) {
                if (i2 == this.g) {
                    this.g = this.e[i2];
                } else {
                    int[] iArr = this.e;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.removeFromRow(this.b);
                }
                solverVariable.usageInRowCount--;
                this.a--;
                this.d[i2] = -1;
                if (this.i) {
                    this.h = i2;
                }
                return this.f[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.e[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.d.length * 4 * 3) + 0 + 36;
    }

    public String toString() {
        int i2 = this.g;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.a) {
            StringBuilder L = a.L(a.c3(str, " -> "));
            L.append(this.f[i2]);
            L.append(" : ");
            StringBuilder L2 = a.L(L.toString());
            L2.append(this.mCache.d[this.d[i2]]);
            str = L2.toString();
            i2 = this.e[i2];
            i3++;
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f2 = get(arrayRow.a);
        remove(arrayRow.a, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            add(variable, arrayRowVariables.get(variable) * f2, z);
        }
        return f2;
    }
}
