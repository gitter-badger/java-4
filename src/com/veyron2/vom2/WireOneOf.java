// This file was auto-generated by the veyron vdl tool.
// Source: wiretype.vdl
package com.veyron2.vom2;

/**
 * type WireOneOf struct{Name string;Types []veyron2/vom2.TypeID uint64} 
 * WireOneOf represents a oneof type definition.
 **/
public final class WireOneOf {
    
    
      private java.lang.String name;
    
      private java.util.ArrayList<com.veyron2.vom2.TypeID> types;
    

    
    public WireOneOf(final java.lang.String name, final java.util.ArrayList<com.veyron2.vom2.TypeID> types) {
        
            this.name = name;
        
            this.types = types;
        
    }

    
    
    public java.lang.String getName() {
        return this.name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.util.ArrayList<com.veyron2.vom2.TypeID> getTypes() {
        return this.types;
    }
    public void setTypes(java.util.ArrayList<com.veyron2.vom2.TypeID> types) {
        this.types = types;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final WireOneOf other = (WireOneOf)obj;

        
        
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
         
        
        
        if (this.types == null) {
            if (other.types != null) {
                return false;
            }
        } else if (!this.types.equals(other.types)) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (name == null ? 0 : name.hashCode());
        
        result = prime * result + (types == null ? 0 : types.hashCode());
        
        return result;
    }
}