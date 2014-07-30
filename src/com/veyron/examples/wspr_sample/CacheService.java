// This file was auto-generated by the veyron vdl tool.
// Source: cache.vdl
package com.veyron.examples.wspr_sample;

/**
 * A Cache service mimics the memcache interface.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron.examples.wspr_sample.gen_impl.CacheServiceWrapper.class)
public interface CacheService  {

    
    // Set sets a value for a key.

    public void set(final com.veyron2.ipc.ServerContext context, final java.lang.String key, final java.lang.Object value) throws com.veyron2.ipc.VeyronException;

    
    // Get returns the value for a key.  If the value is not found, returns
// a not found error.

    public java.lang.Object get(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an byte.

    public byte getAsByte(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an int32.

    public int getAsInt32(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an int64.

    public long getAsInt64(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an uint32.

    public int getAsUint32(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an uint64.

    public long getAsUint64(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an float32.

    public float getAsFloat32(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an float64.

    public double getAsFloat64(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to a string.

    public java.lang.String getAsString(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to a bool.

    public boolean getAsBool(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // Same as Get, but casts the return argument to an error.

    public com.veyron2.ipc.VeyronException getAsError(final com.veyron2.ipc.ServerContext context, final java.lang.String key) throws com.veyron2.ipc.VeyronException;

    
    // AsMap returns the full contents of the cache as a map.

    public java.util.HashMap<java.lang.String, java.lang.Object> asMap(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // KeyValuePairs returns the full contents of the cache as a slice of pairs.

    public java.util.ArrayList<com.veyron.examples.wspr_sample.KeyValuePair> keyValuePairs(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // MostRecentSet returns the key and value and the timestamp for the most
// recent set operation
// TODO(bprosnitz) support type types and change time to native time type

    public com.veyron.examples.wspr_sample.Cache.MostRecentSetOut mostRecentSet(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // KeyPage indexes into the keys (in alphanumerically sorted order) and
// returns the indexth page of 10 keys.

    public java.lang.String[] keyPage(final com.veyron2.ipc.ServerContext context, final long index) throws com.veyron2.ipc.VeyronException;

    
    // Size returns the total number of entries in the cache.

    public long size(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // MultiGet sets up a stream that allows fetching multiple keys.

    public void multiGet(final com.veyron2.ipc.ServerContext context, com.veyron2.vdl.Stream<java.lang.String, java.lang.Object> stream) throws com.veyron2.ipc.VeyronException;

}
