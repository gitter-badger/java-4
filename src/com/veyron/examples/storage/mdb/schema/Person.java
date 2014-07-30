// This file was auto-generated by the veyron vdl tool.
// Source: schema.vdl
package com.veyron.examples.storage.mdb.schema;

/**
 * type Person struct{Image string;Name string;BirthDate int64} 
 * Person represents a person, in any role, including producers, director,
 * actor, etc.
 **/
public final class Person {
    
    
      private java.lang.String image;
    
      private java.lang.String name;
    
      private long birthDate;
    

    
    public Person(final java.lang.String image, final java.lang.String name, final long birthDate) {
        
            this.image = image;
        
            this.name = name;
        
            this.birthDate = birthDate;
        
    }

    
    
    public java.lang.String getImage() {
        return this.image;
    }
    public void setImage(java.lang.String image) {
        this.image = image;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public long getBirthDate() {
        return this.birthDate;
    }
    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final Person other = (Person)obj;

        
        
        if (this.image == null) {
            if (other.image != null) {
                return false;
            }
        } else if (!this.image.equals(other.image)) {
            return false;
        }
         
        
        
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
         
        
        
        if (this.birthDate != other.birthDate) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (image == null ? 0 : image.hashCode());
        
        result = prime * result + (name == null ? 0 : name.hashCode());
        
        result = prime * result + java.lang.Long.valueOf(birthDate).hashCode();
        
        return result;
    }
}