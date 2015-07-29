package blackboard.webapps.blackboard.spring.rest;

import static com.jayway.restassured.RestAssured.given;

import blackboard.data.user.User;
import blackboard.data.user.UserGenerator;
import blackboard.plugin.rest.api.util.RestConstants;
import blackboard.plugin.rest.api.util.RestUtil;
import blackboard.test.unit.BootstrappedContextTestCase;
import blackboard.test.unit.restassured.LearnRestAssuredTestHelper;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import org.junit.Test;
import org.springframework.http.HttpStatus;
/*
 * 
 * @author Dan Lin
 * @since 1.0
 */
public class HelloRestServiceTest extends BootstrappedContextTestCase
{
  private LearnRestAssuredTestHelper _restAssuredTestHelper;
  private User _user;

  @Override
  public void setUp() throws Exception
  {
    super.setUp();
    _user = UserGenerator.getUserFixture( "test.inst1", true );
    UserGenerator.deleteUserAtTearDown( _user );
    _restAssuredTestHelper = new LearnRestAssuredTestHelper(
                                                             RestUtil
                                                                 .generateLearnRestUrl( RestConstants.REST_VERSION_V1,
                                                                                        "greeting/" ) );

    _restAssuredTestHelper.login( _user.getUserName(), _user.getPassword() );
  }

  @Override
  public void tearDown() throws Exception
  {
    super.tearDown();
  }

  @Test
  public void testGetGeeting() throws Exception
  {
    Response response = given().contentType( ContentType.JSON ).when().get( "" );
    response.then().assertThat().statusCode( HttpStatus.OK.value() );
    JsonPath json = new JsonPath(response.asString());
    assertEquals(json.getString("name"), "World");
    assertEquals(json.getString("greeting"), "Hello World");
  }
  
  @Test
  public void testGetGeetingWithName() throws Exception
  {
//    String urlPath = RestUtil.generateLearnRestUrl( RestConstants.REST_VERSION_V1,
//                           "greeting?name=Dan" );
    String urlPath = "?name=Dan";
    Response response = given().contentType( ContentType.JSON ).when().get(urlPath);
    response.then().assertThat().statusCode( HttpStatus.OK.value() );
    JsonPath json = new JsonPath(response.asString());
    assertEquals(json.getString("name"), "Dan");
    assertEquals(json.getString("greeting"), "Hello Dan");
  }
  
}
