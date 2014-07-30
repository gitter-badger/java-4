// This file was auto-generated by the veyron vdl tool.
// Source: repository.vdl
package com.veyron2.services.mgmt.repository;

/**
 * Binary can be used to store and retrieve veyron application
 * binaries.
 * 
 * To create a binary, clients first invoke the Create() method that
 * specifies the number of parts the binary consists of. Clients then
 * uploads the individual parts through the Upload() method, which
 * identifies the part being uploaded. To resume an upload after a
 * failure, clients invoke the UploadStatus() method, which returns a
 * slice that identifies which parts are missing.
 * 
 * To download a binary, clients first invoke Stat(), which returns
 * information describing the binary, including the number of parts
 * the binary consists of. Clients then download the individual parts
 * through the Download() method, which identifies the part being
 * downloaded. Alternatively, clients can download the binary through
 * HTTP using a transient URL available through the DownloadURL()
 * method.
 * 
 * To delete the binary, clients invoke the Delete() method.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron2.services.mgmt.repository.gen_impl.BinaryServiceWrapper.class)
public interface BinaryService  {

    
    // Create expresses the intent to create a binary identified by the
// object name suffix consisting of the given number of parts. If
// the suffix identifies a binary that has already been created, the
// method returns an error.

    public void create(final com.veyron2.ipc.ServerContext context, final int nparts) throws com.veyron2.ipc.VeyronException;

    
    // Delete deletes the binary identified by the object name
// suffix. If the binary that has not been created, the method
// returns an error.

    public void delete(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // Download opens a stream that can used for downloading the given
// part of the binary identified by the object name suffix. If the
// binary part has not been uploaded, the method returns an
// error. If the Delete() method is invoked when the Download()
// method is in progress, the outcome the Download() method is
// undefined.

    public void download(final com.veyron2.ipc.ServerContext context, final int part, com.veyron2.vdl.Stream<java.lang.Void, java.util.ArrayList<java.lang.Byte>> stream) throws com.veyron2.ipc.VeyronException;

    
    // DownloadURL returns a transient URL from which the binary
// identified by the object name suffix can be downloaded using the
// HTTP protocol. If not all parts of the binary have been uploaded,
// the method returns an error.

    public com.veyron2.services.mgmt.repository.Binary.DownloadURLOut downloadURL(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // Stat returns information describing the parts of the binary
// identified by the object name suffix. If the binary has not been
// created, the method returns an error.

    public java.util.ArrayList<com.veyron2.services.mgmt.binary.PartInfo> stat(final com.veyron2.ipc.ServerContext context) throws com.veyron2.ipc.VeyronException;

    
    // Upload opens a stream that can be used for uploading the given
// part of the binary identified by the object name suffix. If the
// binary has not been created, the method returns an error. If the
// binary part has been uploaded, the method returns an error. If
// the same binary part is being uploaded by another caller, the
// method returns an error.

    public void upload(final com.veyron2.ipc.ServerContext context, final int part, com.veyron2.vdl.Stream<java.util.ArrayList<java.lang.Byte>, java.lang.Void> stream) throws com.veyron2.ipc.VeyronException;

}
