// This file was auto-generated by the veyron vdl tool.
// Source: wiretype.vdl
package com.veyron2.wiretype;

/**
 * type StructType struct{Fields []veyron2/wiretype.FieldType struct{Type veyron2/wiretype.TypeID uint64;Name string};Name string;Tags []string} 
 * StructType represents a struct; a sequence of fields.
 **/
public final class StructType {
    
    
      private java.util.ArrayList<com.veyron2.wiretype.FieldType> fields;
    
      private java.lang.String name;
    
      private java.util.ArrayList<java.lang.String> tags;
    

    
    public StructType(final java.util.ArrayList<com.veyron2.wiretype.FieldType> fields, final java.lang.String name, final java.util.ArrayList<java.lang.String> tags) {
        
            this.fields = fields;
        
            this.name = name;
        
            this.tags = tags;
        
    }

    
    
    public java.util.ArrayList<com.veyron2.wiretype.FieldType> getFields() {
        return this.fields;
    }
    public void setFields(java.util.ArrayList<com.veyron2.wiretype.FieldType> fields) {
        this.fields = fields;
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
        final StructType other = (StructType)obj;

        
        
        if (this.fields == null) {
            if (other.fields != null) {
                return false;
            }
        } else if (!this.fields.equals(other.fields)) {
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
        
        result = prime * result + (fields == null ? 0 : fields.hashCode());
        
        result = prime * result + (name == null ? 0 : name.hashCode());
        
        result = prime * result + (tags == null ? 0 : tags.hashCode());
        
        return result;
    }
}