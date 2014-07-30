// This file was auto-generated by the veyron vdl tool.
// Source: wiretype.vdl
package com.veyron2.wiretype;

/**
 * type FieldType struct{Type veyron2/wiretype.TypeID uint64;Name string} 
 * FieldType represents a single possibly-named field in a struct.
 **/
public final class FieldType {
    
    
      private com.veyron2.wiretype.TypeID type;
    
      private java.lang.String name;
    

    
    public FieldType(final com.veyron2.wiretype.TypeID type, final java.lang.String name) {
        
            this.type = type;
        
            this.name = name;
        
    }

    
    
    public com.veyron2.wiretype.TypeID getType() {
        return this.type;
    }
    public void setType(com.veyron2.wiretype.TypeID type) {
        this.type = type;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final FieldType other = (FieldType)obj;

        
        
        if (this.type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!this.type.equals(other.type)) {
            return false;
        }
         
        
        
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (type == null ? 0 : type.hashCode());
        
        result = prime * result + (name == null ? 0 : name.hashCode());
        
        return result;
    }
}