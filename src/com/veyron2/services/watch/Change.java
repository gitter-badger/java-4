// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.watch;

/**
 * type Change struct{Name string;State int32;Value any;ResumeMarker veyron2/services/watch.ResumeMarker []byte;Continued bool} 
 * Change is the new value for a watched entity.
 **/
public final class Change {
    
    
      private java.lang.String name;
    
      private int state;
    
      private java.lang.Object value;
    
      private com.veyron2.services.watch.ResumeMarker resumeMarker;
    
      private boolean continued;
    

    
    public Change(final java.lang.String name, final int state, final java.lang.Object value, final com.veyron2.services.watch.ResumeMarker resumeMarker, final boolean continued) {
        
            this.name = name;
        
            this.state = state;
        
            this.value = value;
        
            this.resumeMarker = resumeMarker;
        
            this.continued = continued;
        
    }

    
    
    public java.lang.String getName() {
        return this.name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public int getState() {
        return this.state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
    public java.lang.Object getValue() {
        return this.value;
    }
    public void setValue(java.lang.Object value) {
        this.value = value;
    }
    
    public com.veyron2.services.watch.ResumeMarker getResumeMarker() {
        return this.resumeMarker;
    }
    public void setResumeMarker(com.veyron2.services.watch.ResumeMarker resumeMarker) {
        this.resumeMarker = resumeMarker;
    }
    
    public boolean getContinued() {
        return this.continued;
    }
    public void setContinued(boolean continued) {
        this.continued = continued;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final Change other = (Change)obj;

        
        
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
         
        
        
        if (this.state != other.state) {
            return false;
        }
         
        
        
        if (this.value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!this.value.equals(other.value)) {
            return false;
        }
         
        
        
        if (this.resumeMarker == null) {
            if (other.resumeMarker != null) {
                return false;
            }
        } else if (!this.resumeMarker.equals(other.resumeMarker)) {
            return false;
        }
         
        
        
        if (this.continued != other.continued) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (name == null ? 0 : name.hashCode());
        
        result = prime * result + state;
        
        result = prime * result + (value == null ? 0 : value.hashCode());
        
        result = prime * result + (resumeMarker == null ? 0 : resumeMarker.hashCode());
        
        result = prime * result + java.lang.Boolean.valueOf(continued).hashCode();
        
        return result;
    }
}