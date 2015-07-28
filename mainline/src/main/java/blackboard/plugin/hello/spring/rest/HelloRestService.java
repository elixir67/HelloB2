/*
 * (C) Copyright Blackboard Inc. 1998-2014 - All Rights Reserved
 * 
 * Permission to use, copy, modify, and distribute this software without prior explicit written approval is strictly
 * prohibited. Please refer to the file "copyright.html" for further important copyright and licensing information.
 * 
 * BLACKBOARD MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-
 * INFRINGEMENT. BLACKBOARD SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package blackboard.plugin.hello.spring.rest;

import blackboard.platform.restspring.annotations.RestController;
import blackboard.platform.restspring.annotations.RestSuccessCodes;
import blackboard.platform.spring.beans.annotations.ImplementationStatus;
import blackboard.platform.spring.beans.annotations.ImplementationStatus.Status;
import blackboard.plugin.hello.spring.rest.beans.HelloTORest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController( apiKey = "greeting.*", authPattern = "/v1/greeting/**" )
@RequestMapping( "/v1/greeting" )
@ImplementationStatus( Status.Skeleton )
public class HelloRestService
{
  @RequestMapping( value = "", method = RequestMethod.GET )
  @ResponseBody
  @ResponseStatus( HttpStatus.OK )
  @RestSuccessCodes( status = { HttpStatus.OK } )
  @ImplementationStatus( Status.ReadyForProduction )
//  public String greeting()
//  {
//    String name = "world";
//    return "Hello " + name;
//  }
  public HelloTORest greeting(@RequestParam( value = "name", required = false ) String name)
  {
    //String name = "world";
    HelloTORest r = new HelloTORest();
    r.initName(name);
    return r;
  }

  
}
