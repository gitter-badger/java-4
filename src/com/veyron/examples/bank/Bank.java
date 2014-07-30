// This file was auto-generated by the veyron vdl tool.
// Source: bank.vdl
package com.veyron.examples.bank;

/**
 * Bank allows clients to store virtual money. Certain implementations can use persistent storage.
 * Uses the client's Veyron Identity to determine account access.
 */

public interface Bank  {

    
    
    public static class ConnectOut {
        
        public java.lang.String newIdentity;
        
        public long accountNumber;
        
    }
    

    
    // Connect causes the bank to bless a new user (string) and return their bank account number (int64). Existing users are not blessed (""), but still receive their account number (int64).

    public com.veyron.examples.bank.Bank.ConnectOut connect(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public com.veyron.examples.bank.Bank.ConnectOut connect(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
