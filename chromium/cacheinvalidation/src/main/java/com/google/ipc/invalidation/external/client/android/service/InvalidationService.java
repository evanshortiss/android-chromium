/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: src/java/com/google/ipc/invalidation/external/client/android/service/InvalidationService.aidl
 */
package com.google.ipc.invalidation.external.client.android.service;
/**
 * Defines the bound service interface for the Invalidation service.   The service exposes
 * an intent-like model with a single {@link #handleRrequest} entry point that packages the
 * action and its parameters into a {@link Bundle} but uses a synchronous calling model where
 * a response bundle is also returned to the client containing status and any result or
 * failure information.
 * <p>
 * Having a single entry point (as compared to a interface method per action with explicit
 * parameters) will make it easier to evolve the interface over time.   New action types or
 * additional optional parameters can be added in subsequent versions without changing the
 * service interface in ways that would be incompatible with existing clients.  This is
 * important because the service will be packaged (and updated) independently from clients
 * of the invalidation service.
 * <p>
 * The synchronous nature of the interface (having a response object that can indicate success
 * or failure of an action) is important to support reliable registrations.  If a client
 * sends a registration request, it's important to know that it has been successfully received
 * by the local invalidation service.
 *
 * Before binding, the invalidation service should first ensure that the service is started by
 * calling the {@code Context#startService} with the {@link ServiceParameter#SERVICE_INTENT}.
 * The client can then bind to the service using {@code Context#bindService} with the same
 * intent.   Clients should never explicitly stop the service;  the service itself will decide
 * when it has successfully processed all requests from active clients and will stop itself.
 */
public interface InvalidationService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.google.ipc.invalidation.external.client.android.service.InvalidationService
{
private static final java.lang.String DESCRIPTOR = "com.google.ipc.invalidation.external.client.android.service.InvalidationService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.google.ipc.invalidation.external.client.android.service.InvalidationService interface,
 * generating a proxy if needed.
 */
public static com.google.ipc.invalidation.external.client.android.service.InvalidationService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.google.ipc.invalidation.external.client.android.service.InvalidationService))) {
return ((com.google.ipc.invalidation.external.client.android.service.InvalidationService)iin);
}
return new com.google.ipc.invalidation.external.client.android.service.InvalidationService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_handleRequest:
{
data.enforceInterface(DESCRIPTOR);
android.os.Bundle _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.Bundle _arg1;
_arg1 = new android.os.Bundle();
this.handleRequest(_arg0, _arg1);
reply.writeNoException();
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.google.ipc.invalidation.external.client.android.service.InvalidationService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
   * Sends a request to the invalidation service and retrieves the response containing any
   * return data or status/error information.   The {@code action} parameter in the request
   * bundle will indicate the type of request to be executed and the request parameters will
   * also be stored in the bundle.   The service will acknowledge successful processing of
   * the request by returning a response bundle that contains a {@code status} parameter
   * indicating the success or failure of the request.  If successful, any other output
   * parameters will be included as values in the response bundle.  On failure, additional
   * error or debug information will be included in the response bundle.
   *
   * @see Request
   * @see Response
   */
@Override public void handleRequest(android.os.Bundle request, android.os.Bundle response) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_handleRequest, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
response.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_handleRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
   * Sends a request to the invalidation service and retrieves the response containing any
   * return data or status/error information.   The {@code action} parameter in the request
   * bundle will indicate the type of request to be executed and the request parameters will
   * also be stored in the bundle.   The service will acknowledge successful processing of
   * the request by returning a response bundle that contains a {@code status} parameter
   * indicating the success or failure of the request.  If successful, any other output
   * parameters will be included as values in the response bundle.  On failure, additional
   * error or debug information will be included in the response bundle.
   *
   * @see Request
   * @see Response
   */
public void handleRequest(android.os.Bundle request, android.os.Bundle response) throws android.os.RemoteException;
}
