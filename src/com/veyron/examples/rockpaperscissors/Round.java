// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;

/**
 * type Round struct{Moves [2]string;Comment string;Winner veyron/examples/rockpaperscissors.WinnerTag byte;StartTimeNS int64;EndTimeNS int64} 
 * Round represents the state of a round.
 **/
public final class Round {
    
    
      private java.lang.String[] moves;
    
      private java.lang.String comment;
    
      private com.veyron.examples.rockpaperscissors.WinnerTag winner;
    
      private long startTimeNS;
    
      private long endTimeNS;
    

    
    public Round(final java.lang.String[] moves, final java.lang.String comment, final com.veyron.examples.rockpaperscissors.WinnerTag winner, final long startTimeNS, final long endTimeNS) {
        
            this.moves = moves;
        
            this.comment = comment;
        
            this.winner = winner;
        
            this.startTimeNS = startTimeNS;
        
            this.endTimeNS = endTimeNS;
        
    }

    
    
    public java.lang.String[] getMoves() {
        return this.moves;
    }
    public void setMoves(java.lang.String[] moves) {
        this.moves = moves;
    }
    
    public java.lang.String getComment() {
        return this.comment;
    }
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }
    
    public com.veyron.examples.rockpaperscissors.WinnerTag getWinner() {
        return this.winner;
    }
    public void setWinner(com.veyron.examples.rockpaperscissors.WinnerTag winner) {
        this.winner = winner;
    }
    
    public long getStartTimeNS() {
        return this.startTimeNS;
    }
    public void setStartTimeNS(long startTimeNS) {
        this.startTimeNS = startTimeNS;
    }
    
    public long getEndTimeNS() {
        return this.endTimeNS;
    }
    public void setEndTimeNS(long endTimeNS) {
        this.endTimeNS = endTimeNS;
    }
    

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final Round other = (Round)obj;

        
        
        if (this.moves == null) {
            if (other.moves != null) {
                return false;
            }
        } else if (!this.moves.equals(other.moves)) {
            return false;
        }
         
        
        
        if (this.comment == null) {
            if (other.comment != null) {
                return false;
            }
        } else if (!this.comment.equals(other.comment)) {
            return false;
        }
         
        
        
        if (this.winner == null) {
            if (other.winner != null) {
                return false;
            }
        } else if (!this.winner.equals(other.winner)) {
            return false;
        }
         
        
        
        if (this.startTimeNS != other.startTimeNS) {
            return false;
        }
         
        
        
        if (this.endTimeNS != other.endTimeNS) {
            return false;
        }
         
         
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        
        result = prime * result + (moves == null ? 0 : moves.hashCode());
        
        result = prime * result + (comment == null ? 0 : comment.hashCode());
        
        result = prime * result + (winner == null ? 0 : winner.hashCode());
        
        result = prime * result + java.lang.Long.valueOf(startTimeNS).hashCode();
        
        result = prime * result + java.lang.Long.valueOf(endTimeNS).hashCode();
        
        return result;
    }
}