/*
 AlexanderAndrade.Net CONFIDENTIAL

 <p>Copyright (c) 2018 . All Rights Reserved.

 <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 part of this source code package.
*/
package net.alexanderandrade.api.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${environment}.properties"})
public interface Environment extends Config {

}
