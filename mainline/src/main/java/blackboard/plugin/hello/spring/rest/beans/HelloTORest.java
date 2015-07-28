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
package blackboard.plugin.hello.spring.rest.beans;

import blackboard.platform.restspring.bean.BaseTORest;
import blackboard.platform.spring.beans.annotations.ImplementationStatus;
import blackboard.platform.spring.beans.annotations.ImplementationStatus.Status;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
@ImplementationStatus( Status.ReadyForProduction )
public class HelloTORest extends BaseTORest
{
  String _name;

  public HelloTORest()
  {
  }

  public String getName()
  {
    return _name;
  }

  public void initName( String name )
  {
    _name = name;
  }
  
  public String getGreeting()
  {
    return "hello " + _name;
  }

  @Override
  public HelloTORest getSampleObject( String sampleType, Integer intention )
  {
    if ( SAMPLE_TYPE_FULL.equals( sampleType ) )
    {
      _name = "Bill Wu";
      return this;
    }

    return null;
  }
}
