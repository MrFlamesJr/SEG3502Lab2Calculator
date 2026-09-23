package seg3502.calculator

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class WebController {
    @ModelAttribute
    fun addAttributes(model: Model) {
        model.addAttribute("error", "")
        model.addAttribute("firstNumber", "")
        model.addAttribute("secondNumber", "")
        model.addAttribute("result", "")
    }

    @RequestMapping("/")
    fun home(): String {
        return "home"
    }

    @GetMapping(value = ["/calculate"])
    fun doCalculate(
        @RequestParam(value = "firstNumber", required = false) firstNumber: String,
        @RequestParam(value = "secondNumber", required = false) secondNumber: String,
        @RequestParam(value = "operation", required = false) operation: String,
        model: Model
    ): String {
        var firstNumberVal: Double
        var secondNumberVal: Double

        try{
            
            firstNumberVal = firstNumber.toDouble()
            secondNumberVal = secondNumber.toDouble()
        } catch (exp: NumberFormatException) {
            model.addAttribute("error", "NumberFormatError")
            model.addAttribute("firstNumber", firstNumber)
            model.addAttribute("secondNumber", secondNumber)
            model.addAttribute("result", "")
            return "home"
        }



        when (operation) {
            "+" ->
                System.out.println("Addition operation selected")
                /* 

                calculate and set the result in the model with:
                model.addAttribute("[attribute_name]", [result_value])

                */
                
            "-" ->
                System.out.println("Subtraction operation selected")
                //smt here


                
            else -> { // when operation is not recognized
                model.addAttribute("error", "OperationFormatError")
                model.addAttribute("firstNumber", firstNumberVal)
                model.addAttribute("secondNumber", secondNumberVal)
                model.addAttribute("result", "")
            }
        }
        return "home"
    }
}

