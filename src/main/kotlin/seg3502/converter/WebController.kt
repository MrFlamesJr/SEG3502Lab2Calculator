package seg3502.calculator

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.slf4j.LoggerFactory

@Controller
class WebController {

    private val logger = LoggerFactory.getLogger(WebController::class.java)

    @ModelAttribute
    fun addAttributes(model: Model) {
        //This runs on every request to the controller
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
        var result: Double? = null

        try{
            firstNumberVal = firstNumber.toDouble()
            secondNumberVal = secondNumber.toDouble()
            result = calculate(operation, firstNumberVal, secondNumberVal)
            
        } catch (exp: NumberFormatException) {
            model.addAttribute("error", "NumberFormatException")
            model.addAttribute("result", "")
            model.addAttribute("firstNumber", firstNumber)
            model.addAttribute("secondNumber", secondNumber)
            return "home"
        } catch (exp: IllegalArgumentException) {
            model.addAttribute("error", exp.message)
            model.addAttribute("result", "")
            model.addAttribute("firstNumber", firstNumber)
            model.addAttribute("secondNumber", secondNumber)
            return "home"
        }

        // success: display
        model.addAttribute("error", "") // clear error
        model.addAttribute("result", result) // display result
        model.addAttribute("firstNumber", firstNumber)
        model.addAttribute("secondNumber", secondNumber)
        return "home"
    }

    private fun calculate(operation: String, a: Double, b: Double): Double {

        if (operation == "÷" && b == 0.0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }

        return when (operation) {
            "+" -> a + b
            "-" -> a - b
            "×" -> a * b
            "÷" -> a / b
            else -> throw IllegalArgumentException("Invalid operation: $operation")
        }
    }

}

