
/**
 * LoginCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package logica;

    /**
     *  LoginCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class LoginCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public LoginCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public LoginCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for validateUser method
            * override this method for handling normal response from validateUser operation
            */
           public void receiveResultvalidateUser(
                    logica.LoginStub.ValidateUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateUser operation
           */
            public void receiveErrorvalidateUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeUser method
            * override this method for handling normal response from removeUser operation
            */
           public void receiveResultremoveUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeUser operation
           */
            public void receiveErrorremoveUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for existsUser method
            * override this method for handling normal response from existsUser operation
            */
           public void receiveResultexistsUser(
                    logica.LoginStub.ExistsUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from existsUser operation
           */
            public void receiveErrorexistsUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listUsers method
            * override this method for handling normal response from listUsers operation
            */
           public void receiveResultlistUsers(
                    logica.LoginStub.ListUsersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listUsers operation
           */
            public void receiveErrorlistUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createUser method
            * override this method for handling normal response from createUser operation
            */
           public void receiveResultcreateUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createUser operation
           */
            public void receiveErrorcreateUser(java.lang.Exception e) {
            }
                


    }
    