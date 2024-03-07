import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var height = mutableStateOf("")
    var weight = mutableStateOf("")
    var bmi = mutableStateOf("")

    fun calculateBmi() {
        val heightValue = height.value.toFloatOrNull()
        val weightValue = weight.value.toFloatOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0) {
            val bmiValue = weightValue / (heightValue * heightValue)
            bmi.value = "%.2f".format(bmiValue)
        } else {
            bmi.value = ""
        }
    }
}
