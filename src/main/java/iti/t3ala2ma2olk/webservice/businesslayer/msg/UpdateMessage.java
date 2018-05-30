/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.t3ala2ma2olk.webservice.businesslayer.msg;

/**
 *
 * @author abdalla
 */
public class UpdateMessage {

    public static String success = "Update Done successfully";
    public static String fail = "Update fail";
    public static String repeatedUsername = "Update fail , repeated Username";
    public static String repeatedEmail = "Update fail , repeated Email";
    public static String idNotFound = "Update fail ,this user does not exist";
    public static String uniqueField = "Update fail ,please chose unique value";
}
