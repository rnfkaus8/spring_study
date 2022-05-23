package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
//@RestController
public class ResponseBodyController {

    /**
     * HttpServletResponse 객체를 통해서 HTTP 메시지 바디에 직접 응답 메시지 전달
     */
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    /**
     * ResponseEntity 는 HttpEntity 를 상속받음
     * HTTP 응답 코드 지정 가능
     */
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    /**
     * @ResponseBody 를 사용하면 HTTP 메시지 컨버터를 통해 HTTP 메시지 직접 입력 가능
     * 클래스 레벨에 @ResponseBody, @Controller 적용 가능
     * 클래스 레벨에 @ResponseBody, @Controller 를 합친 어노테이션이 @RestController
     */
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3(){
        return "ok";
    }

    /**
     * HTTP 메시지 컨버터를 통해 JSON 형식으로 변경되어 반환
     */
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    /**
     * @ResponseBody 어노테이션 사용 시 HTTP 응답 코드를 설정하기 까다로움
     * @ResponseStatus 어노테이션으로 HTTP 응답 코드 설정 가능
     * 동적으로 HTTP 응답 코드 설정 시 ResponseEntity 객체를 사용
     */
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2(){
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }

}
