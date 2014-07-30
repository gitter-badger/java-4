
// This file was auto-generated by the veyron vdl tool.
// Source: base.vdl
package com.veyron2.vdl.test_base;

/**
 * type NamedFloat64 float64 
 **/
public final class NamedFloat64 {
    private double value;

    public NamedFloat64(double value) {
        this.value = value;
    }
    public double getValue() { return this.value; }

    public void setValue(double value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final com.veyron2.vdl.test_base.NamedFloat64 other = (com.veyron2.vdl.test_base.NamedFloat64)obj;
        
        return this.value == other.value;
        
    }
    @Override
    public int hashCode() {
        return java.lang.Double.valueOf(value).hashCode();
    }
}
