import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TestRestAssured {

    @Test
    void TestMethod(){
        given().get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).    //  check the http status code
                body("data.id[1]",equalTo(8)).  // checks the content of the payload
                body("data.first_name",hasItems("Michael","Lindsay")).// checks the content of the payload
                log().all(); //  displays the entire response on the console
    }


}
