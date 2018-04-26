package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class SomeController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Page not available.";
    }

    @RequestMapping(path = "/hello", produces = "application/json")
    @ResponseBody
    String sayHello(@RequestParam("msg") String param) {
        return param;
    }

    @RequestMapping(path = "/calc", produces = "application/json")
    @ResponseBody
    Integer calculate(@RequestParam("param") List<Integer> params) {

        int result = 0;

        for (int i = 0; i < params.size(); i++) {
            result = result + params.get(i);
        }
        return result;
    }

    @RequestMapping(path = "/splitOdd10", produces = "application/json")
    @ResponseBody
    boolean splitOdd10(@RequestParam int[] array) {
        return checkPossibleGroups(0, array, 0, 0);
    }

    public boolean checkPossibleGroups(int startIndex, int[] nums, int sum1, int sum2) {
        if (startIndex == nums.length) {
            return (sum1 % 10 == 0 && sum2 % 2 == 1) || (sum2 % 10 == 0 && sum1 % 2 == 1);
        }
        return checkPossibleGroups(startIndex + 1, nums, sum1 + nums[startIndex], sum2) ||
                checkPossibleGroups(startIndex + 1, nums, sum1, sum2 + nums[startIndex]);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SomeController.class, args);

    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
