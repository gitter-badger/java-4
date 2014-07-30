// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;

/**
 * type PlayerAction struct{Move string;Quit bool} 
 **/
public final class PlayerAction {
    
    
      private java.lang.String move;
    
      private boolean quit;
    

    
    public PlayerAction(final java.lang.String move, final boolean quit) {
        
            this.move = move;
        
            this.quit = quit;
        
    }

    
    
    public java.lang.String getMove() {
        return this.move;
    }
    public void setMove(java.lang.String move) {
        this.move = move;
    }
    
    public boolean getQuit() {
        return this.quit;
    }
    public void setQuit(boolean quit) {
        this.quit = quit;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final PlayerAction other = (PlayerAction)obj;

        
        
        if (this.move == null) {
            if (other.move != null) {
                return false;
            }
        } else if (!this.move.equals(other.move)) {
            return false;
        }
         
        
        
        if (this.quit != other.quit) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (move == null ? 0 : move.hashCode());
        
        result = prime * result + java.lang.Boolean.valueOf(quit).hashCode();
        
        return result;
    }
}