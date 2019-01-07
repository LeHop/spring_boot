/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eureka;

import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author leho
 */
public class TestRandomStringUtils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String token = RandomStringUtils.random(20,true, true);
        System.out.println(token);
    }
    
}
