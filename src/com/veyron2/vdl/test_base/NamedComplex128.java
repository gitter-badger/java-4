
// This file was auto-generated by the veyron vdl tool.
// Source: base.vdl
package com.veyron2.vdl.test_base;

/**
 * type NamedComplex128 complex128 
 **/
public final class NamedComplex128 {
    private org.apache.commons.math3.complex.Complex value;

    public NamedComplex128(org.apache.commons.math3.complex.Complex value) {
        this.value = value;
    }
    public org.apache.commons.math3.complex.Complex getValue() { return this.value; }

    public void setValue(org.apache.commons.math3.complex.Complex value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final com.veyron2.vdl.test_base.NamedComplex128 other = (com.veyron2.vdl.test_base.NamedComplex128)obj;
        
        if (this.value == null) {
            return other.value == null;
        }
        return this.value.equals(other.value);
        
    }
    @Override
    public int hashCode() {
        return (value == null ? 0 : value.hashCode());
    }
}
