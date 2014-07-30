// This file was auto-generated by the veyron vdl tool.
// Source: wiretype.vdl
package com.veyron2.wiretype;

/**
 * type ArrayType struct{Elem veyron2/wiretype.TypeID uint64;Len uint64;Name string;Tags []string} 
 * ArrayType represents a fixed-length sequence of Elem values.
 **/
public final class ArrayType {
    
    
      private com.veyron2.wiretype.TypeID elem;
    
      private long len;
    
      private java.lang.String name;
    
      private java.util.ArrayList<java.lang.String> tags;
    

    
    public ArrayType(final com.veyron2.wiretype.TypeID elem, final long len, final java.lang.String name, final java.util.ArrayList<java.lang.String> tags) {
        
            this.elem = elem;
        
            this.len = len;
        
            this.name = name;
        
            this.tags = tags;
        
    }

    
    
    public com.veyron2.wiretype.TypeID getElem() {
        return this.elem;
    }
    public void setElem(com.veyron2.wiretype.TypeID elem) {
        this.elem = elem;
    }
    
    public long getLen() {
        return this.len;
    }
    public void setLen(long len) {
        this.len = len;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.util.ArrayList<java.lang.String> getTags() {
        return this.tags;
    }
    public void setTags(java.util.ArrayList<java.lang.String> tags) {
        this.tags = tags;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final ArrayType other = (ArrayType)obj;

        
        
        if (this.elem == null) {
            if (other.elem != null) {
                return false;
            }
        } else if (!this.elem.equals(other.elem)) {
            return false;
        }
         
        
        
        if (this.len != other.len) {
            return false;
        }
         
        
        
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
         
        
        
        if (this.tags == null) {
            if (other.tags != null) {
                return false;
            }
        } else if (!this.tags.equals(other.tags)) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (elem == null ? 0 : elem.hashCode());
        
        result = prime * result + java.lang.Long.valueOf(len).hashCode();
        
        result = prime * result + (name == null ? 0 : name.hashCode());
        
        result = prime * result + (tags == null ? 0 : tags.hashCode());
        
        return result;
    }
}